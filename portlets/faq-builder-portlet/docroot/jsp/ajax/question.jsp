<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%
	String category =request.getParameter("qCategory");
	List <FAQEntry> faqs = FAQEntryLocalServiceUtil.getByCategory(category);
	String rowCss="portlet-section-body results-row";
	final String altRowCss = "portlet-section-alternate results-row alt";
	String css="";
	
	
%>


<div class="results-grid aui-searchcontainer-content" style="margin-top:10px;margin-bottom:10px">
	<table id="questionList" class="taglib-search-iterator">
		<thead>
			<tr class="portlet-section-header results-header">
				
				
				<th>Question</th>
				<th>Order</th>
				
			</tr>
		</thead>
		
		<tbody class="ui-sortable">
<%
	int i=1;
for (FAQEntry faq: faqs)
{
	//Object row[] = (Object[]) faq;
	if (i%2!=0)
		css=rowCss;
	else
		css=altRowCss;
	
	%>
			
			<tr class="<%=css %>" id="<%=faq.getPrimaryKey()%>" data-id="<%=faq.getPrimaryKey()%>" data-rank="<%=i %>">
			
			<td><%=faq.getQuestion() %></td>
			<td>
				<button class="change-rank" data-direction="up">&#9650;</button>
	            <button class="change-rank" data-direction="down">&#9660;</button>
			</td>
			</tr>

	<%
	i++;
} %>
			</tbody>
	
	</table>
	
	</div>
	
	




