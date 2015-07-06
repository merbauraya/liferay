<%@ include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "jspPage");
	ResultRow row = (ResultRow) request
	.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SuburItem item = (SuburItem) row.getObject();
%>
<liferay-ui:icon-menu>
	<c:if
		test="<%=SuburItemPermission.contains(permissionChecker,
							item.getItemId(), ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="itemId"
				value="<%=String.valueOf(item.getItemId())%>" />
			<portlet:param name="jspPage"
				value="/html/edit.jsp" />
		</portlet:renderURL>
		
		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString()%>" />
	</c:if>
	<c:if
		test="<%=SuburItemPermission.contains(permissionChecker,
							item.getItemId(), ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL
			modelResource="<%=SuburItem.class.getName()%>"
			modelResourceDescription="<%=item.getTitle()%>"
			resourcePrimKey="<%=String.valueOf(item.getItemId())%>"
			var="permissionsURL" />
		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>
	<c:if
		test="<%=SuburItemPermission.contains(permissionChecker,
							item.getItemId(), ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteItem" var="deleteURL">
			<portlet:param name="itemId"
				value="<%=String.valueOf(item.getItemId())%>" />
		</portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
	<c:if
		test="<%=SuburItemPermission.contains(permissionChecker,
							item.getItemId(), ActionKeys.VIEW)%>">
		<portlet:renderURL var="viewURL">
			<portlet:param name="itemId"
				value="<%=String.valueOf(item.getItemId())%>" />
			<portlet:param name="mvcPath"
				value="/html/view_item.jsp" />	
		</portlet:renderURL>
		<liferay-ui:icon image="view" url="<%=viewURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>