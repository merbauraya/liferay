<%@ include file="/html/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

Group group = themeDisplay.getScopeGroup();

long microblogsEntryUserId = themeDisplay.getUserId();

if (group.isUser()) {
	microblogsEntryUserId = group.getClassPK();
}

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("mvcPath", "/status_update/view.jsp");
%>

<c:if test="<%= MicroblogsPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ENTRY) && (group.isUser() ) %>">
	<liferay-util:include page="/html/statusupdate/entry.jsp" servletContext="<%= application %>" />
</c:if>
