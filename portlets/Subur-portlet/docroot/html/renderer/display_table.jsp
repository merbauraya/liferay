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
        <portlet:param name="mvcPath" value="/html/renderer/item_full.jsp" />
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
			<liferay-ui:message key="author" />
		</th>
		<th class="table-header">
			<liferay-ui:message key="published-date" />
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

	<td class="table-cell">
		List of author (taglib?)
	</td>

		
	<td class="table-cell">
		<%=dateFormatDate.format(assetEntry.getPublishDate()) %>
	</td>

		

	
	
</tr>

<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
	</tbody>
	</table>
</c:if>