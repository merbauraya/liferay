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
		
		
		<aui:field-wrapper>
			<aui:input inlineLabel ="left" inlineField="<%= true %>" name="<%= suburDisplayTerms.TITLE %>" size="20" value="<%= suburDisplayTerms.getTitle() %>" />
			
			<aui:input inlineLabel ="left" inlineField="true" name="<%= suburDisplayTerms.AUTHOR_FIRST_NAME %>" size="30" value="<%= suburDisplayTerms.getAuthorFirstName() %>" />
			<aui:input last="<%=true %>" inlineLabel ="left" inlineField="<%= true %>" name="<%= suburDisplayTerms.AUTHOR_LAST_NAME %>" size="30" value="<%= suburDisplayTerms.getAuthorLastName() %>" />
			<aui:input label="yearPublished" name="<%= suburDisplayTerms.YEAR_PUBLISHED %>" size="20" value="<%= suburDisplayTerms.getYear() %>" />
			<aui:select size="5" multiple="<%=true %>" name="<%=SuburDisplayTerms.ITEM_TYPE %>">
				<aui:option value="0" selected="<%= suburDisplayTerms.getItemType()==0 %>">Any</aui:option>
			<%
				List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				for (ItemType itemType: itemTypes)
				{
					boolean selected = itemType.getItemTypeId() == suburDisplayTerms.getItemType();
			%>
					<aui:option selected="<%=selected %>" value="<%= itemType.getItemTypeId() %>">
						<%=itemType.getItemTypeName() %>
					</aui:option>
			<%	}
			%>
				
			</aui:select>
			
		</aui:field-wrapper>
		
		
		
	</aui:fieldset>
</liferay-ui:search-toggle>