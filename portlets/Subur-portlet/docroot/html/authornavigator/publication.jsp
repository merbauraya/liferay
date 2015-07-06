<%
	//PortletURL portletURL = renderResponse.createRenderURL();

//	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);


	

	

%>
<liferay-ui:search-container emptyResultsMessage="no-publication-were-found"
	
>
	<liferay-ui:search-container-results
		results = "<%=AuthorLocalServiceUtil.getItemByAuthorGroup(themeDisplay.getScopeGroupId(),
			authorId,searchContainer.getStart() ,
			searchContainer.getEnd(),SuburConstant.STATUS_PUBLISHED_ITEM,searchContainer.getOrderByComparator())
			%>"
	
	/>

		<liferay-ui:search-container-row
				className="com.idetronic.subur.model.SuburItem"
				keyProperty="itemId"
				modelVar="item"
		>
			<%
			PortletURL viewItemURL = renderResponse.createRenderURL();
			viewItemURL.setParameter("jspPage","/html/renderer/item_full.jsp");
			viewItemURL.setParameter("itemId",String.valueOf(item.getItemId()));
			
			%>
			<liferay-ui:search-container-column-text name="title">
				<a href="<%=viewItemURL.toString() %>">
					<%= item.getTitle() %>"
				</a>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text
					name="item-type">
					<subur:item-itemtype-display 
						itemId="<%= Long.valueOf(item.getItemId()) %>"
					/>
						
			</liferay-ui:search-container-column-text>
			<%
					PortletURL viewAuthorURL = renderResponse.createRenderURL();
					viewAuthorURL.setParameter("jspPage", "/html/authornavigator/view_author.jsp");
				%>	
			<liferay-ui:search-container-column-text
				name="author">
				<subur:item-author-display
					itemId="<%= Long.valueOf(item.getItemId()) %>" 
					viewAuthorURL ="<%=viewAuthorURL %>"	
				/>
				
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text
					name="published"
					value="<%= yearFormatDate.format(item.getPublishedDate()) %>"	
			/>
			<%
				AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(SuburItem.class.getName(), item.getItemId());
			%>
			<liferay-ui:search-container-column-text
					name="views"
					value="<%= String.valueOf(entry.getViewCount()) %>"	
			/>
					
			
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	