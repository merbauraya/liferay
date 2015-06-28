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
		
		<aui:input inlineLabel ="left" inlineField="<%= true %>" name="<%= suburDisplayTerms.TITLE %>" size="20" value="<%= suburDisplayTerms.getTitle() %>" />
		
		<aui:field-wrapper>
			
			<aui:input inlineLabel ="left" inlineField="true" name="<%= suburDisplayTerms.AUTHOR_FIRST_NAME %>" size="30" value="<%= suburDisplayTerms.getAuthorFirstName() %>" />
			<aui:input last="<%=true %>" inlineLabel ="left" inlineField="<%= true %>" name="<%= suburDisplayTerms.AUTHOR_LAST_NAME %>" size="30" value="<%= suburDisplayTerms.getAuthorLastName() %>" />
		</aui:field-wrapper>
		<aui:input name="<%= suburDisplayTerms.AUTHOR %>" size="20" value="<%= suburDisplayTerms.getAuthor() %>" />
		
		<aui:input label="yearPublished" name="<%= suburDisplayTerms.YEAR_PUBLISHED %>" size="20" value="<%= suburDisplayTerms.getYear() %>" />
		
		
	</aui:fieldset>
</liferay-ui:search-toggle>