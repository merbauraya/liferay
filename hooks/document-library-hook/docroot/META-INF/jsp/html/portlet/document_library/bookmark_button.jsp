<%@ include file="/html/portlet/document_library/init.jsp" %>
<%
long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));
long repositoryId = GetterUtil.getLong((String)request.getAttribute("view.jsp-repositoryId"));

%>

<liferay-ui:icon-menu align="left" direction="down" icon="" message="bookmark" showExpanded="<%= false %>" showWhenSingleIcon="<%= true %>">



	<portlet:renderURL var="editBookMarkURL">
			<portlet:param name="struts_action" value="/document_library/edit_bookmark" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
	</portlet:renderURL>

	<liferay-ui:icon image="add_instance" message="add" url="<%= editBookMarkURL %>" />
</liferay-ui:icon-menu>