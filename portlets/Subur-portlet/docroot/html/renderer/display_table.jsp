<%@ include file="/html/init.jsp" %>

<%
	List results = (List)request.getAttribute("view.jsp-results");
	String title = (String)request.getAttribute("view.jsp-title");
	AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
	AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
	int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();
	String itemId = (String)request.getAttribute("view.jsp-itemId");
%>
<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="jspPage" value="/html/renderer/item_full.jsp" />
        <portlet:param name="itemId" value="<%=itemId %>"/>
</liferay-portlet:renderURL>

<c:if test="<%= assetEntryIndex == 0 %>">
	<table class="table table-bordered table-hover table-striped">
	<thead class="table-columns">
	<tr>
		<th class="table-header table-sortable-column">
			<liferay-ui:message key="title" />
		</th>
		<th class="table-header">
			<liferay-ui:message key="item-type" />
		</th>
		<th class="table-header">
			<liferay-ui:message key="author" />
		</th>
		<th class="table-header">
			<liferay-ui:message key="published-date" />
		</th>
		<th class="table-header">
			<liferay-ui:message key="views" />
		</th>
		
	</tr>
	</thead>

	<tbody class="table-data">
</c:if>

<tr>
	<td class="table-cell">
		<c:choose>
			<c:when test="<%= Validator.isNotNull(viewURL) %>">
				<a href="<%= viewURL %>"><%= HtmlUtil.escape(title) %></a>
			</c:when>
			<c:otherwise>
				<%= HtmlUtil.escape(title) %>
			</c:otherwise>
		</c:choose>
	</td>
	<td>
	
		<%
			PortletURL viewItemTypeURL = renderResponse.createRenderURL();
		%>
		<subur:item-itemtype-display 
			itemId="<%= Long.valueOf(itemId) %>" 
			viewItemTypeURL ="<%=viewItemTypeURL %>"	
		/>
	</td>
	<td class="table-cell">
		<%
			PortletURL viewAuthorURL = renderResponse.createRenderURL();
			viewAuthorURL.setParameter("jspPage", "/html/authornavigator/view_author.jsp");
		%>	
	
		<subur:item-author-display 
			itemId="<%= Long.valueOf(itemId) %>" 
			viewAuthorURL ="<%=viewAuthorURL %>"	
		/>
	</td>

		
	<td class="table-cell">
		<%=dateFormatDate.format(assetEntry.getPublishDate()) %>
	</td>
	<td>
	<%= assetEntry.getViewCount() %>
	
	</td>	

	
	
</tr>

<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
	</tbody>
	</table>
</c:if>