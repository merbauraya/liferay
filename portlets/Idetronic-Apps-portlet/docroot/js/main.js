AUI().use(
	'aui-base',
	'aui-io-plugin-deprecated',
	'liferay-util-window',
	function(A) {
		Liferay.namespace('Tazkirah');

		Liferay.Tazkirah = {
			init: function(param) {
				var instance = this;

				instance._popupURL = param.popupURL;
			},

			closePopup: function() {
				var instance = this;

				var popup = instance.getPopup()

				if (popup) {
					popup.hide();
				}
			},

			displayPopup: function(url, title) {
				var instance = this;

				var popup = instance.getPopup();

				popup.show();

				popup.titleNode.html(title);

				popup.io.set('uri', url);

				popup.io.start();
			},

			getPopup: function() {
				var instance = this;

				if (!instance._popup) {
					instance._popup = Liferay.Util.Window.getWindow(
						{
							dialog: {
								centered: true,
								constrain2view: true,
								cssClass: 'microblogs-portlet',
								modal: true,
								resizable: false,
								width: 475
							}
						}
					).plug(
						A.Plugin.IO,
						{
							autoLoad: false
						}
					).render();
				}

				return instance._popup;
			},

			

	
		};


	}
);