<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%

PortletURL listURL = renderResponse.createRenderURL();
listURL.setParameter("jspPage", "/jsp/list.jsp");
PortletURL entryURL = renderResponse.createRenderURL();
entryURL.setParameter("jspPage", "/jsp/entry.jsp");

PortletURL viewURL = renderResponse.createRenderURL();
viewURL.setParameter("jspPage", "/jsp/viewfaq.jsp");
%>


<a class="btn btn-primary" href="<%= entryURL %>">New FAQ Entry</a>&nbsp; 
<a class="btn btn-primary" href="<%= listURL %>">List FAQ</a>&nbsp; 
<a class="btn btn-primary" href="<%= viewURL %>">View FAQ</a>&nbsp; 

<%
List<String> catList = FAQEntryLocalServiceUtil.getCategory();
Integer delta = 20;
Integer count = catList.size();
String rowCss="portlet-section-body results-row";
final String altRowCss = "portlet-section-alternate results-row alt";
String css="";

%>
<div class="lfr-search-container" style="margin-top:5px;">
	<div class="yui3-widget aui-component aui-searchcontainer">
	<div class="results-grid aui-searchcontainer-content">
		<table class="taglib-search-iterator">
			<tbody>
				<tr class="portlet-section-header results-header">
					<th>Category</th>
					<th>Action </th>
				</tr>
			
	<%
	
	for (int i=0; i<catList.size();i++)
	{
		if (i%2==0)
			css=rowCss;
		else
			css=altRowCss;
	%>			
	<tr class="<%=css%>"><td>
	<%	
		out.println(catList.get(i));
		out.println("</td><td>");
		entryURL.setParameter("category", catList.get(i));
	%>
	


	<%
		out.println("</td></tr>");
	}
	
	%>
	
	
			</tbody>
		</table>
	</div>
</div>
</div>



 

