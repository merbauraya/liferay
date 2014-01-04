<%@ include file="/html/calendarevent/init.jsp" %>
<aui:script use="aui-base">
	var minusAlt = '<%= UnicodeLanguageUtil.get(pageContext, "collapse") %>';
	var minusImage = '01_minus.png';
	var plusAlt = '<%= UnicodeLanguageUtil.get(pageContext, "expand") %>';
	var plusImage = '01_plus.png';

	A.all('.<portlet:namespace />entry-expander').on(
		'click',
		function(event) {
			var expander = event.currentTarget;
			var clEventDesc = expander.get('parentNode').one('.cl-event-desc');

			if (clEventDesc) {
				var altText = expander.attr('alt');
				var src = expander.attr('src');

				if (src.indexOf('minus.png') > -1) {
					altText = altText.replace(minusAlt, plusAlt);
					src = src.replace(minusImage, plusImage);
				}
				else {
					altText = altText.replace(plusAlt, minusAlt);
					src = src.replace(plusImage, minusImage);
				}

				clEventDesc.toggle();

				expander.attr('alt', altText);
				expander.attr('src', src);
			}
		}
	);
</aui:script>