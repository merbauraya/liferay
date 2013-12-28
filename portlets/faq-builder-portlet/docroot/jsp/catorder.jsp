<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%
	PortletURL orderCatURL = renderResponse.createActionURL();
orderCatURL.setParameter(ActionRequest.ACTION_NAME,FAQConstant.ACTION_ORDER_CATEGORY);
	

	List<Object> catList = FAQEntryLocalServiceUtil.getCategory();
	int catCount = catList.size();
	int i=0;
	String rowCss="portlet-section-body results-row";
	final String altRowCss = "portlet-section-alternate results-row alt";
	String css="";
	String catName="";
	Long catOrder;
%>
<aui:form name="fm" method="POST"
	action="<%= orderCatURL.toString() %>"
	onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "categoryOrder();" %>'>
	
<div class="lfr-search-container" style="margin-top:5px;">
	<div class="yui3-widget aui-component aui-searchcontainer">
	<div class="results-grid aui-searchcontainer-content">
		<table class="taglib-search-iterator">
			<tbody>
				<tr class="portlet-section-header results-header">
					<th>Category</th>
					<th>Total Question</th>
					<th>display Order </th>
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
		catName += (String) row[0] +",";
	/* for (int i=0; i<catList.size();i++)
	{
		if (i%2==0)
			css=rowCss;
		else
			css=altRowCss; */
	%>			
	<tr class="<%=css%>"><td>
	<%	
		
		out.println((String) row[0]);
		out.println("</td><td>");
		out.print((Long) row[2]);
		out.println("</td><td>"); 
		catOrder = (Long) row[2];
	%>
	<select name="<%=(String) row[0]%>">
	<%
		for (int c = 1;c < catList.size() +1 ;c++)
		{
			String v = (catOrder == c) ?  " selected": "";	
		
	%>		
			
			<option value="<%=c %>" <%=v %>><%=c %>
			
				
			
			</option>
	<%
		}
	%>
	
	
	</select>


		
	<%
		out.println("</td></tr>");
	}
	
	%>
	
	
			</tbody>
		</table>
	</div>
</div>
</div>
	
	<input type="hidden" name="catList" value="<%= catName%>">
	<aui:button type="submit" value="Save" />
	
	
</aui:form>


<aui:script>


	function <portlet:namespace />categoryOrder() {
		
		
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>