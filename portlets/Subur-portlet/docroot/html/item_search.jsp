<%@include file="/html/init.jsp"%>

<%
	SuburSearch searchContainer = (SuburSearch)request.getAttribute("liferay-ui:search:searchContainer");

	SuburDisplayTerms suburDisplayTerms = (SuburDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>"
	buttonLabel="search"
	displayTerms="<%= suburDisplayTerms %>"
	id="toggle_id_subur_item_search"
>
	<aui:fieldset>
		
		<aui:input name="<%= suburDisplayTerms.TITLE %>" size="20" value="<%= suburDisplayTerms.getTitle() %>" />

		<aui:input name="<%= suburDisplayTerms.AUTHOR %>" size="20" value="<%= suburDisplayTerms.getAuthor() %>" />
		
		<aui:input name="<%= suburDisplayTerms.YEAR_PUBLISHED %>" size="20" value="<%= suburDisplayTerms.getYear() %>" />
		
		
	</aui:fieldset>
</liferay-ui:search-toggle>