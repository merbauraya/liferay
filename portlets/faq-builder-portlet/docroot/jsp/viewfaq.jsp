<%@include file="/jsp/init.jsp" %>

<%
List<FAQEntry> faqs = FAQEntryLocalServiceUtil.getAll();

%>
<div class="faq-portlet-outer">
	<div class="faq-portlet-inner">
		
		<%
		String category ="";
		int i=0;
		
		for (FAQEntry faq :faqs)
			{
				i++;
				if (!category.equals(faq.getCategory()))
				{
					if (category !="")
						out.println("</div>"); //close previous faq-category
					category = faq.getCategory();
					out.println("<div class='faq-category'>");
					out.println("<h3>"+ category+"</h3>");
					
					
				}	
				out.println("<div class='faq-entry'>");
		%>
		<img alt="<%= (windowState.equals(WindowState.MAXIMIZED)) ? LanguageUtil.get(pageContext, "collapse") : LanguageUtil.get(pageContext, "expande") %>" class="<portlet:namespace />entry-expander faq-entry-expander" src='<%= themeDisplay.getPathThemeImage() %>/arrows/01_<%= (windowState.equals(WindowState.MAXIMIZED)) ? "minus" : "plus" %>.png' />
		
		<%
				out.println("<span class='faq-question'>");
				out.println(faq.getQuestion());
				out.println("</span>");
		%>
		<div class="faq-answer <%= (windowState.equals(WindowState.MAXIMIZED)) ? "" : "aui-helper-hidden" %>">
							
		<%
			
				out.println(faq.getAnswer());
				out.println("</div></div>");
			}
			if (faqs.size()>0)
				out.println("</div>");
		%>

		
	</div>

</div>
<aui:script use="aui-base">
	var minusAlt = '<%= UnicodeLanguageUtil.get(pageContext, "collapse") %>';
	var minusImage = '01_minus.png';
	var plusAlt = '<%= UnicodeLanguageUtil.get(pageContext, "expand") %>';
	var plusImage = '01_plus.png';

	A.all('.<portlet:namespace />entry-expander').on(
		'click',
		function(event) {
			var expander = event.currentTarget;
			var faqContent = expander.get('parentNode').one('.faq-answer');

			if (faqContent) {
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

				faqContent.toggle();

				expander.attr('alt', altText);
				expander.attr('src', src);
			}
		}
	);
</aui:script>


