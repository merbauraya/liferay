<%@include file="/html/init.jsp"%>

<%
	AuthorSearch searchContainer = (AuthorSearch)request.getAttribute("liferay-ui:search:searchContainer");

	AuthorDisplayTerms authorDisplayTerms = (AuthorDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>"
	buttonLabel="search"
	displayTerms="<%= authorDisplayTerms %>"
	id="toggle_id_author_search"
	
>
	<aui:fieldset>
		
		
		<aui:field-wrapper>
			<aui:input inlineLabel ="left" inlineField="<%= true %>" name="<%= authorDisplayTerms.FIRSTNAME %>" size="20" value="<%= authorDisplayTerms.getFirstName() %>" />
			
			<aui:input inlineLabel ="left" inlineField="true" name="<%= authorDisplayTerms.LASTNAME %>" size="20" value="<%= authorDisplayTerms.getLastName() %>" />
			
			
		</aui:field-wrapper>
		
		
		
	</aui:fieldset>
</liferay-ui:search-toggle>