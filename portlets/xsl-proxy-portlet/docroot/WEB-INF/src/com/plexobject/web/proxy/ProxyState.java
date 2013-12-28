package com.plexobject.web.proxy;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Cookie;

/**
 * Class: ProxyState
 * 
 * Description: This class stores state needed to make a proxy request including
 * method type and cookies.
 * 
 */
public class ProxyState implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATA_DELIMITER = "\n";
    private static final String COOKIE_DELIMITER = ";";
    private static final String NULL = "null";

    private String uri;
    private MethodType method;
    private Map<String, Cookie> cookies;

    /**
     * Constructors for ProxyState
     */
    public ProxyState(String uri, String method) {
        this(uri, MethodType.valueOf(method));
    }

    public ProxyState(String uri, MethodType method) {
        this.uri = uri;
        this.method = method;
        this.cookies = new HashMap<String, Cookie>();
    }
    public void setUri(String uri,String method)
    {
    	this.uri = uri;
    	this.method =MethodType.valueOf(method);
    }
    public void setUri(String uri,MethodType method)
    {
    	this.uri = uri;
    	this.method =method;
    }
    /**
     * @return uri
     */
    public String getUri() {
        return this.uri;
    }

    /**
     * @return method
     */
    public MethodType getMethod() {
        return this.method;
    }

    /**
     * @return cookies
     */
    public Collection<Cookie> getCookies() {
        return this.cookies.values();
    }


    /**
     * @param cookies
     */
    public void addCookies(Collection<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            addCookie(cookie);
        }
    }

    /**
     * @param cookie
     *            - to add
     */
    public void addCookie(Cookie cookie) {
        this.cookies.put(cookie.getName(), cookie);
    }

    public String getCookieString() {
        StringBuilder sb = new StringBuilder(512);
        for (Cookie cookie : cookies.values()) {
            if (cookie.getDomain() != null) {
                sb.append(cookie.getDomain()).append(COOKIE_DELIMITER);
            } else {
                sb.append(NULL).append(COOKIE_DELIMITER);
            }
            sb.append(cookie.getName()).append(COOKIE_DELIMITER).append(
                    cookie.getValue()).append(COOKIE_DELIMITER);

            if (cookie.getPath() != null) {
                sb.append(cookie.getPath()).append(COOKIE_DELIMITER);
            } else {
                sb.append(NULL).append(COOKIE_DELIMITER);
            }
            if (cookie.getExpiryDate() != null) {
                sb.append(String.valueOf(cookie.getExpiryDate().getTime()))
                        .append(COOKIE_DELIMITER);
            } else {
                sb.append(NULL).append(COOKIE_DELIMITER);
            }
            sb.append(String.valueOf(cookie.getSecure()))
                    .append(DATA_DELIMITER);
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(512);
        sb.append(uri.toString()).append(DATA_DELIMITER);
        sb.append(method.toString()).append(DATA_DELIMITER);
        sb.append(getCookieString());
        return sb.toString();
    }

    /**
     * This method converts proxy state into string based serialized state
     * 
     * @return string based serialized state
     */
    public String toExternalFormat() {
        try {
            return URLEncoder.encode(toString(), "UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("failed to encode", e);
        }
    }

    /**
     * This method converts a string based serialized state into the proxy state
     * 
     * @param ser
     *            - string based serialized state
     * @return ProxyState
     * @throws IllegalArgumentException
     *             - if serialized state is null or corrupted.
     */
    public static ProxyState valueOf(String ser) {
        if (ser == null)
            throw new IllegalArgumentException("Null serialized object");
        String decoded;
        try {
            decoded = URLDecoder.decode(ser, "UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported encoding " + ser, e);
        }
        String[] lines = decoded.split(DATA_DELIMITER);
        if (lines.length < 2)
            throw new IllegalArgumentException(
                    "Insufficient number of tokens in serialized object ["
                            + decoded + "]");
        ProxyState state = new ProxyState(lines[0], lines[1]);
        for (int i = 2; i < lines.length; i++) {
            String[] cookieFields = lines[i].split(COOKIE_DELIMITER);
            if (cookieFields.length < 6)
                throw new IllegalArgumentException(
                        "Insufficient number of tokens 6 in serialized cookies ["
                                + lines[i] + "]/[" + decoded + "]");
            String domain = cookieFields[0];
            if (NULL.equals(domain)) {
                domain = null;
            }
            String name = cookieFields[1];
            String value = cookieFields[2];
            String path = cookieFields[3];
            if (NULL.equals(path)) {
                path = null;
            }
            Date expires = null;
            if (!NULL.equals(cookieFields[4])) {
                expires = new Date(Long.parseLong(cookieFields[4]));
            }
            boolean secure = new Boolean(cookieFields[5]).booleanValue();
            Cookie cookie = new Cookie(domain, name, value, path, expires,
                    secure);
            state.addCookie(cookie);
        }
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProxyState))
            return false;
        final ProxyState other = (ProxyState) o;
        if (uri != null ? !uri.equals(other.uri) : other.uri != null)
            return false;
        if (method != null ? !method.equals(other.method)
                : other.method != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (uri != null ? uri.hashCode() : 0);
        result = 29 * result + (method != null ? method.hashCode() : 0);
        return result;
    }
}
