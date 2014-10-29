<%@ include file="/html/tabview/init.jsp" %>
<%@ page import="com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.wiki.model.WikiPage" %>
<%@ page import="com.liferay.portlet.wiki.model.WikiNode" %>

<%
	List<WikiPage> results = new ArrayList<WikiPage>();
	results = WikiPageLocalServiceUtil.getWikiPages(0, viewConfig.getMaxItem());
%>
<c:choose>
	<c:when test="<%= results.isEmpty() %>">
		<liferay-ui:message key="there-are-no-pages" />

		<br /><br />
	</c:when>
	<c:otherwise>
		<div class="tbview-ol">
			<ol>

		<%
		for (int i = 0; i < results.size(); i++) {
			WikiPage entry = (WikiPage)results.get(i);
			PortletURL showBlogEntryURL = renderResponse.createRenderURL();
			showBlogEntryURL.setParameter("jspPage", "/html/tabview/view_blog.jsp");
			showBlogEntryURL.setParameter("entryId", String.valueOf(entry.getPageId()));
			
			StringBundler sb = new StringBundler(10);

			sb.append(themeDisplay.getPathMain());
			//sb.append("/wiki/find_page?noSuchEntryRedirect=");
			//sb.append(HttpUtil.encodeURL(showBlogEntryURL.toString()));
			sb.append("/wiki/find_page?p_l_id=");
			sb.append(themeDisplay.getPlid());
			sb.append("&pageResourcePrimKey=");
			sb.append(entry.getResourcePrimKey());
			
			

			String viewEntryURL = sb.toString();
			WikiNode curNode = entry.getNode();
			
		%>
		<liferay-portlet:renderURL var="rowURL" portletName="36" plid="<%=themeDisplay.getPlid()%>">
				<portlet:param name="struts_action" value="/wiki/view" />
				<portlet:param name="nodeName" value="<%= curNode.getName() %>" />
				<portlet:param name="title" value="<%= entry.getTitle() %>" />
			
			</liferay-portlet:renderURL>
	
		
		
			<li>
				<a href="<%=viewEntryURL %>">
					<%=entry.getTitle() %>
				</a>
			</li>	
				
			
			
		

		<%
		}
		%>
			</ol>
		</div>
	</c:otherwise>
</c:choose>