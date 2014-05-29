<%@ include file="/html/tabview/init.jsp" %>
<%@ page import="com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.blogs.model.BlogsEntry" %>

<% 
	int maxItemToDisplay = 10;
	List<BlogsEntry> results = new ArrayList<BlogsEntry>();
	int status = WorkflowConstants.STATUS_APPROVED;
	results = BlogsEntryServiceUtil.getOrganizationEntries(viewConfig.getOrganizationId(), new Date(), WorkflowConstants.STATUS_APPROVED, viewConfig.getMaxItem());

	
	
	
%>
<c:choose>
	<c:when test="<%= results.isEmpty() %>">
		<liferay-ui:message key="there-are-no-blogs" />

		<br /><br />
	</c:when>
	<c:otherwise>
		<div class="tbview-ol">
			<ol>

		<%
		for (int i = 0; i < results.size(); i++) {
			BlogsEntry entry = (BlogsEntry)results.get(i);
			PortletURL showBlogEntryURL = renderResponse.createRenderURL();
			showBlogEntryURL.setParameter("jspPage", "/html/tabview/view_blog.jsp");
			showBlogEntryURL.setParameter("entryId", String.valueOf(entry.getEntryId()));
			
			StringBundler sb = new StringBundler(8);

			sb.append(themeDisplay.getPathMain());
			sb.append("/blogs/find_entry?noSuchEntryRedirect=");
			sb.append(HttpUtil.encodeURL(showBlogEntryURL.toString()));
			sb.append("&entryId=");
			sb.append(entry.getEntryId());

			String viewEntryURL = sb.toString();
			
		%>
		<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.VIEW) %>">
			<li>
				<a href="<%=viewEntryURL %>">
					<%=entry.getTitle() %>
				</a>
			</li>	
				
			
			
		</c:if>

		<%
		}
		%>
			</ol>
		</div>
	</c:otherwise>
</c:choose>

