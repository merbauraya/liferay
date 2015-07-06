<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Author author = (Author)row.getObject();

	long authorId = author.getAuthorId();

%>



<liferay-ui:icon-menu>
	<portlet:renderURL var="editAuthorURL">
		<portlet:param name="authorId" value="<%=String.valueOf(authorId) %>" />
		<portlet:param name="jspPage" value="/html/admin/author/edit_author.jsp" />
	
	</portlet:renderURL>
	
	<liferay-ui:icon
			image="edit"
			url="<%= editAuthorURL %>"
		/>

</liferay-ui:icon-menu>