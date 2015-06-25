<%@ include file="/html/init.jsp" %>
display_title_list
xxx
<%
	List results = (List)request.getAttribute("view.jsp-results");
	String title = (String)request.getAttribute("view.jsp-title");
	AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
%>
<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/display/item_full.jsp" />
        
</liferay-portlet:renderURL>

<ul class="title-list">

<li class="title-list subur">
		<liferay-ui:icon
			label="<%= true %>"
			message="<%= HtmlUtil.escape(title) %>"
			src="<%= assetRenderer.getIconPath(renderRequest) %>"
			url="<%= viewURL %>"
		/>

</ul>