<%@ include file="/html/directory/init.jsp" %>

<%
String q = ParamUtil.getString(request,"q");
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/html/directory/view.jsp");
LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();

SearchContainer searchContainer = new UserSearch((PortletRequest)renderRequest, "cur2", currentURLObj);
//searchContainer.setRowChecker(new RowChecker(renderResponse));
userParams.put("expandoAttributes", q);

//List hits = UserLocalServiceUtil.search(themeDisplay.getCompanyId(), q, 
//		WorkflowConstants.STATUS_ANY, null, searchContainer.getStart(), searchContainer.getEnd(), null);

%>
<liferay-ui:search-container
	searchContainer="<%= searchContainer %>"
	var="userSearchContainer"

>
	<liferay-ui:search-container-results>
	
		<%@ include file="/html/directory/user_search_results.jsp" %>
	</liferay-ui:search-container-results>
	
<liferay-ui:search-container-row
		className="com.liferay.portal.model.User"
		escapedModel="<%= true %>"
		keyProperty="userId"
		modelVar="user2"
		rowIdProperty="screenName">
		<liferay-portlet:renderURL varImpl="rowURL">
			<portlet:param name="jspPage" value="/html/directory/user_detail.jsp" />
			<portlet:param name="redirect" value="<%= userSearchContainer.getIteratorURL().toString() %>" />
			<portlet:param name="p_u_i_d" value="<%= String.valueOf(user2.getUserId()) %>" />
		</liferay-portlet:renderURL>
		<%@ include file="/html/directory/user_column.jsp" %>
		
		
		
		
		
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/directory/user_action.jsp"
		/>
		
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


