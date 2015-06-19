/*
 * typeahead.js
 * https://github.com/twitter/typeahead.js
 * Copyright 2013-2014 Twitter, Inc. and other contributors; Licensed MIT
 */
var VERSION = '%VERSION%';
var _ = (function() {
    'use strict';
    return {
        isMsie: function() {
            // from https://github.com/ded/bowser/blob/master/bowser.js
            return (/(msie|trident)/i).test(navigator.userAgent) ?
                navigator.userAgent.match(/(msie |rv:)(\d+(.\d+)?)/i)[2] : false;
        },
        isBlankString: function(str) {
            return !str || /^\s*$/.test(str);
        },
        // http://stackoverflow.com/a/6969486
        escapeRegExChars: function(str) {
            return str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, '\\$&');
        },
        isString: function(obj) {
            return typeof obj === 'string';
        },
        isNumber: function(obj) {
            return typeof obj === 'number';
        },
        isArray: $.isArray,
        isFunction: $.isFunction,
        isObject: $.isPlainObject,
        isUndefined: function(obj) {
            return typeof obj === 'undefined';
        },
        toStr: function toStr(s) {
            return (_.isUndefined(s) || s === null) ? '' : s + '';
        },
        bind: $.proxy,
        each: function(collection, cb) {
            // stupid argument order for jQuery.each
            $.each(collection, reverseArgs);

            function reverseArgs(index, value) {
                return cb(value, index);
            }
        },
        map: $.map,
        filter: $.grep,
        every: function(obj, test) {
            var result = true;
            if (!obj) {
                return result;
            }
            $.each(obj, function(key, val) {
                if (!(result = test.call(null, val, key, obj))) {
                    return false;
                }
            });
            return !!result;
        },
        some: function(obj, test) {
            var result = false;
            if (!obj) {
                return result;
            }
            $.each(obj, function(key, val) {
                if (result = test.call(null, val, key, obj)) {
                    return false;
                }
            });
            return !!result;
        },
        mixin: $.extend,
        getUniqueId: (function() {
            var counter = 0;
            return function() {
                return counter++;
            };
        })(),
        templatify: function templatify(obj) {
            return $.isFunction(obj) ? obj : template;

            function template() {
                return String(obj);
            }
        },
        defer: function(fn) {
            setTimeout(fn, 0);
        },
        debounce: function(func, wait, immediate) {
            var timeout, result;
            return function() {
                var context = this,
                    args = arguments,
                    later, callNow;
                later = function() {
                    timeout = null;
                    if (!immediate) {
                        result = func.apply(context, args);
                    }
                };
                callNow = immediate && !timeout;
                clearTimeout(timeout);
                timeout = setTimeout(later, wait);
                if (callNow) {
                    result = func.apply(context, args);
                }
                return result;
            };
        },
        throttle: function(func, wait) {
            var context, args, timeout, result, previous, later;
            previous = 0;
            later = function() {
                previous = new Date();
                timeout = null;
                result = func.apply(context, args);
            };
            return function() {
                var now = new Date(),
                    remaining = wait - (now - previous);
                context = this;
                args = arguments;
                if (remaining <= 0) {
                    clearTimeout(timeout);
                    timeout = null;
                    previous = now;
                    result = func.apply(context, args);
                } else if (!timeout) {
                    timeout = setTimeout(later, remaining);
                }
                return result;
            };
        },
        noop: function() {}
    };
})();
/*
 * typeahead.js
 * https://github.com/twitter/typeahead.js
 * Copyright 2013-2014 Twitter, Inc. and other contributors; Licensed MIT
 */
var oParser = (function() {
    'use strict';
    return {
        local: getLocal,
        prefetch: getPrefetch,
        remote: getRemote
    };

    function getLocal(o) {
        return o.local || null;
    }

    function getPrefetch(o) {
        var prefetch, defaults;
        defaults = {
            url: null,
            thumbprint: '',
            ttl: 24 * 60 * 60 * 1000, // 1 day
            filter: null,
            ajax: {}
        };
        if (prefetch = o.prefetch || null) {
            // support basic (url) and advanced configuration
            prefetch = _.isString(prefetch) ? {
                url: prefetch
            } : prefetch;
            prefetch = _.mixin(defaults, prefetch);
            prefetch.thumbprint = VERSION + prefetch.thumbprint;
            prefetch.ajax.type = prefetch.ajax.type || 'GET';
            prefetch.ajax.dataType = prefetch.ajax.dataType || 'json';
            !prefetch.url && $.error('prefetch requires url to be set');
        }
        return prefetch;
    }

    function getRemote(o) {
        var remote, defaults;
        defaults = {
            url: null,
            cache: true,
            wildcard: '%QUERY',
            replace: null,
            rateLimitBy: 'debounce',
            rateLimitWait: 300,
            send: null,
            filter: null,
            ajax: {}
        };
        if (remote = o.remote || null) {
            // support basic (url) and advanced configuration
            remote = _.isString(remote) ? {
                url: remote
            } : remote;
            remote = _.mixin(defaults, remote);
            remote.rateLimiter = /^throttle$/i.test(remote.rateLimitBy) ?
                byThrottle(remote.rateLimitWait) : byDebounce(remote.rateLimitWait);
            remote.ajax.type = remote.ajax.type || 'GET';
            remote.ajax.dataType = remote.ajax.dataType || 'json';
            delete remote.rateLimitBy;
            delete remote.rateLimitWait;
            !remote.url && $.error('remote requires url to be set');
        }
        return remote;

        function byDebounce(wait) {
            return function(fn) {
                return _.debounce(fn, wait);
            };
        }

        function byThrottle(wait) {
            return function(fn) {
                return _.throttle(fn, wait);
            };
        }
    }
})();
/*
 * typeahead.js
 * https://github.com/twitter/typeahead.js
 * Copyright 2013-2014 Twitter, Inc. and other contributors; Licensed MIT
 */
var SearchIndex = (function() {
    'use strict';
    // constructor
    // -----------
    function SearchIndex(o) {
            o = o || {};
            if (!o.datumTokenizer || !o.queryTokenizer) {
                $.error('datumTokenizer and queryTokenizer are both required');
            }
            this.datumTokenizer = o.datumTokenizer;
            this.queryTokenizer = o.queryTokenizer;
            this.reset();
        }
        // instance methods
        // ----------------
    _.mixin(SearchIndex.prototype, {
        // ### public
        bootstrap: function bootstrap(o) {
            this.datums = o.datums;
            this.trie = o.trie;
        },
        add: function(data) {
            var that = this;
            data = _.isArray(data) ? data : [data];
            _.each(data, function(datum) {
                var id, tokens;
                id = that.datums.push(datum) - 1;
                tokens = normalizeTokens(that.datumTokenizer(datum));
                _.each(tokens, function(token) {
                    var node, chars, ch;
                    node = that.trie;
                    chars = token.split('');
                    while (ch = chars.shift()) {
                        node = node.children[ch] || (node.children[ch] = newNode());
                        node.ids.push(id);
                    }
                });
            });
        },
        get: function get(query) {
            var that = this,
                tokens, matches;
            tokens = normalizeTokens(this.queryTokenizer(query));
            _.each(tokens, function(token) {
                var node, chars, ch, ids;
                // previous tokens didn't share any matches
                if (matches && matches.length === 0) {
                    return false;
                }
                node = that.trie;
                chars = token.split('');
                while (node && (ch = chars.shift())) {
                    node = node.children[ch];
                }
                if (node && chars.length === 0) {
                    ids = node.ids.slice(0);
                    matches = matches ? getIntersection(matches, ids) : ids;
                }
                // break early if we find out there are no possible matches
                else {
                    matches = [];
                    return false;
                }
            });
            return matches ?
                _.map(unique(matches), function(id) {
                    return that.datums[id];
                }) : [];
        },
        reset: function reset() {
            this.datums = [];
            this.trie = newNode();
        },
        serialize: function serialize() {
            return {
                datums: this.datums,
                trie: this.trie
            };
        }
    });
    return SearchIndex;
    // helper functions
    // ----------------
    function normalizeTokens(tokens) {
        // filter out falsy tokens
        tokens = _.filter(tokens, function(token) {
            return !!token;
        });
        // normalize tokens
        tokens = _.map(tokens, function(token) {
            return token.toLowerCase();
        });
        return tokens;
    }

    function newNode() {
        return {
            ids: [],
            children: {}
        };
    }

    function unique(array) {
        var seen = {},
            uniques = [];
        for (var i = 0, len = array.length; i < len; i++) {
            if (!seen[array[i]]) {
                seen[array[i]] = true;
                uniques.push(array[i]);
            }
        }
        return uniques;
    }

    function getIntersection(arrayA, arrayB) {
        var ai = 0,
            bi = 0,
            intersection = [];
        arrayA = arrayA.sort(compare);
        arrayB = arrayB.sort(compare);
        var lenArrayA = arrayA.length,
            lenArrayB = arrayB.length;
        while (ai < lenArrayA && bi < lenArrayB) {
            if (arrayA[ai] < arrayB[bi]) {
                ai++;
            } else if (arrayA[ai] > arrayB[bi]) {
                bi++;
            } else {
                intersection.push(arrayA[ai]);
                ai++;
                bi++;
            }
        }
        return intersection;

        function compare(a, b) {
            return a - b;
        }
    }
})();
/*
 * typeahead.js
 * https://github.com/twitter/typeahead.js
 * Copyright 2013-2014 Twitter, Inc. and other contributors; Licensed MIT
 */
var PersistentStorage = (function() {
    'use strict';
    var ls, methods;
    try {
        ls = window.localStorage;
        // while in private browsing mode, some browsers make
        // localStorage available, but throw an error when used
        ls.setItem('~~~', '!');
        ls.removeItem('~~~');
    } catch (err) {
        ls = null;
    }
    // constructor
    // -----------
    function PersistentStorage(namespace) {
            this.prefix = ['__', namespace, '__'].join('');
            this.ttlKey = '__ttl__';
            this.keyMatcher = new RegExp('^' + _.escapeRegExChars(this.prefix));
        }
        // instance methods
        // ----------------
    if (ls && window.JSON) {
        methods = {
            // ### private
            _prefix: function(key) {
                return this.prefix + key;
            },
            _ttlKey: function(key) {
                return this._prefix(key) + this.ttlKey;
            },
            // ### public
            get: function(key) {
                if (this.isExpired(key)) {
                    this.remove(key);
                }
                return decode(ls.getItem(this._prefix(key)));
            },
            set: function(key, val, ttl) {
                if (_.isNumber(ttl)) {
                    ls.setItem(this._ttlKey(key), encode(now() + ttl));
                } else {
                    ls.removeItem(this._ttlKey(key));
                }
                return ls.setItem(this._prefix(key), encode(val));
            },
            remove: function(key) {
                ls.removeItem(this._ttlKey(key));
                ls.removeItem(this._prefix(key));
                return this;
            },
            clear: function() {
                var i, key, keys = [],
                    len = ls.length;
                for (i = 0; i < len; i++) {
                    if ((key = ls.key(i)).match(this.keyMatcher)) {
                        // gather keys to remove after loop exits
                        keys.push(key.replace(this.keyMatcher, ''));
                    }
                }
                for (i = keys.length; i--;) {
                    this.remove(keys[i]);
                }
                return this;
            },
            isExpired: function(key) {
                var ttl = decode(ls.getItem(this._ttlKey(key)));
                return _.isNumber(ttl) && now() > ttl ? true : false;
            }
        };
    } else {
        methods = {
            get: _.noop,
            set: _.noop,
            remove: _.noop,
            clear: _.noop,
            isExpired: _.noop
        };
    }
    _.mixin(PersistentStorage.prototype, methods);
    return PersistentStorage;
    // helper functions
    // ----------------
    function now() {
        return new Date().getTime();
    }

    function encode(val) {
        // convert undefined to null to avoid issues with JSON.parse
        return JSON.stringify(_.isUndefined(val) ? null : val);
    }

    function decode(val) {
        return JSON.parse(val);
    }
})();