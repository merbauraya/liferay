<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%

	PortletURL listURL = renderResponse.createRenderURL();
	listURL.setParameter("jspPage", "/jsp/list.jsp");
	PortletURL entryURL = renderResponse.createRenderURL();
	entryURL.setParameter("jspPage", "/jsp/entry.jsp");
	
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", "/jsp/viewfaq.jsp");
	
	
	PortletURL orderCatURL = renderResponse.createRenderURL();
	orderCatURL.setParameter("jspPage", "/jsp/catorder.jsp");
	
	PortletURL orderQuestionURL = renderResponse.createRenderURL();
	orderQuestionURL.setParameter("jspPage", "/jsp/questionorder.jsp");
	
	PortletURL addURL = renderResponse.createRenderURL();
	addURL.setParameter("jspPage",FAQConstant.EDIT_FAQ);
	addURL.setParameter("backURL", themeDisplay.getURLCurrent());
	
	PortletURL deleteCatURL = renderResponse.createActionURL();
	deleteCatURL.setParameter(ActionRequest.ACTION_NAME,FAQConstant.DELETE_BY_CATEGORY);
	//deleteFaqURL.setParameter("redirectURL", iteratorURL.toString());


%>


<a class="btn btn-primary" href="<%= entryURL %>">New FAQ Entry</a>&nbsp; 
<a class="btn btn-primary" href="<%= listURL %>">List FAQ</a>&nbsp; 
<a class="btn btn-primary" href="<%= viewURL %>">View FAQ</a>&nbsp; 
<a class="btn btn-primary" href="<%= orderCatURL %>">Category Display Order</a>&nbsp; 
<a class="btn btn-primary" href="<%= orderQuestionURL %>">Question Display Order</a>&nbsp; 
<%
	List<Object> catList = FAQEntryLocalServiceUtil.getCategory();
	Integer delta = 20;
	Integer count = catList.size();
	String rowCss="portlet-section-body results-row";
	final String altRowCss = "portlet-section-alternate results-row alt";
	String css="";
	Integer i=0;
	String catMsg="",delMsg="";
%>
<div class="lfr-search-container" style="margin-top:5px;">
	<div class="yui3-widget aui-component aui-searchcontainer">
	<div class="results-grid aui-searchcontainer-content">
		<table class="taglib-search-iterator">
			<tbody>
				<tr class="portlet-section-header results-header">
					<th>Category</th>
					<th>Total Question</th>
					<th>Action </th>
				</tr>
			
	<%
	for (Object faq : catList)
	{
		Object row[] = (Object[]) faq;
		if (i%2==0)
			css=rowCss;
		else
			css=altRowCss;
		i++;
	
	/* for (int i=0; i<catList.size();i++)
	{
		if (i%2==0)
			css=rowCss;
		else
			css=altRowCss; */
	%>			
	<tr class="<%=css%>"><td>
	<%	
		deleteCatURL.setParameter("category", (String) row[0]);
		out.println((String) row[0]);
		out.println("</td><td>");
		out.print((Long) row[2]);
		out.println("</td><td>"); 
		
	%>
	<liferay-ui:icon-menu>
			<%
			
			//deleteFaqURL.setParameter("faqId", Long.toString(faq.getEntryId()));
			addURL.setParameter("category", (String) row[0]);
			catMsg = "Add in '"+(String) row[0]+ "'";
			delMsg = "Delete all in '"+(String) row[0]+ "'";
			%>
			
			<liferay-ui:icon image="page" url="<%= addURL.toString() %>" label="true" message="<%= catMsg %>"/>
			<liferay-ui:icon-delete url="<%= deleteCatURL.toString()  %>" message ="<%= delMsg %>" />
	
		</liferay-ui:icon-menu>

		
	<%
		out.println("</td></tr>");
	}
	
	%>
	
	
			</tbody>
		</table>
	</div>
</div>
</div>



 

