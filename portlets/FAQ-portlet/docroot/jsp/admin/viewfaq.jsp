<%@include file="/jsp/init.jsp" %>

<%
List<FAQEntry> faqs = FAQEntryLocalServiceUtil.getAll();

%>
<div class="faq-portlet-outer">
	<div class="faq-portlet-inner">
		
		<%
		String category ="";	
		for (FAQEntry faq :faqs)
			{
				if (!category.equals(faq.getCategory()))
				{
					category = faq.getCategory();
					out.println("<div class='faq-portlet-cat-header'>");
					out.println("<h1>"+ category+"</h1></div>");
					
				}
				out.println("<div class='faq-portlet-content'>");
				out.println("<h3>"+faq.getQuestion()+ "</h3>");
				out.println("<p>"+ faq.getAnswer()+ "</p></div>");
			}
		
		%>
			
		
		
		
	</div>

</div>



