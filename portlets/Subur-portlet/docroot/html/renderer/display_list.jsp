<%@ include file="/html/init.jsp" %>

<%
	List results = (List)request.getAttribute("view.jsp-results");
	String title = (String)request.getAttribute("view.jsp-title");
	AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
	int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();
	String itemId = (String)request.getAttribute("view.jsp-itemId");
%>
<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="jspPage" value="/html/renderer/item_full.jsp" />
        <portlet:param name="itemId" value="<%=itemId %>"/>
</liferay-portlet:renderURL>

<c:if test="<%= assetEntryIndex == 0 %>">
	<ul class="title-list">
</c:if>

		<li class="title-list">
				<liferay-ui:icon
					label="<%= true %>"
					message="<%= HtmlUtil.escape(title) %>"
					src="<%= assetRenderer.getIconPath(renderRequest) %>"
					url="<%= viewURL.toString() %>"
				/>
		</li>
<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
	</ul>
</c:if>