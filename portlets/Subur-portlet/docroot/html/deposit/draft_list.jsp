<%@ include file="/html/init.jsp" %>
<%
	//List<Item> suburItems = ItemLocalServiceUtil.getDraftItems();	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/deposit/draft_list.jsp");
	portletURL.setWindowState(WindowState.NORMAL);


	PortletURL addItemURL = renderResponse.createRenderURL();
	addItemURL.setParameter("jspPage", "/html/deposit/new.jsp");
	addItemURL.setParameter(Constants.CMD, Constants.ADD);
	String catMsg="";

	PortletURL deleteEntryURL = renderResponse.createActionURL();
	deleteEntryURL.setParameter(ActionRequest.ACTION_NAME,"deleteEntry");
	deleteEntryURL.setParameter("redirectURL", portletURL.toString());
	
	PortletURL editEntryURL = renderResponse.createRenderURL();
	editEntryURL.setParameter("jspPage", "/html/deposit.jsp");
	editEntryURL.setParameter(Constants.CMD, Constants.EDIT);
	

%>
<a class="btn btn-primary" href="<%= addItemURL %>">New Entry</a>&nbsp; 
<liferay-ui:search-container
	emptyResultsMessage="no-item-were-found"
	iteratorURL="<%=portletURL %>"
	total = "<%= SuburItemLocalServiceUtil.getDraftItemCount() %>"
>
	<liferay-ui:search-container-results
		results="<%= SuburItemLocalServiceUtil.getDraftItems(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>
	<liferay-ui:search-container-row
		className="com.idetronic.subur.model.SuburItem"
		escapedModel="<%= true %>"
		keyProperty="itemId"
		modelVar="item"
	>
	<liferay-ui:search-container-column-text
				name="title"
				title="<%= item.getTitle() %>"
			/>
	
	<liferay-ui:search-container-column-text
				name="createDate"
				buffer="buffer"
	>
		<%
			buffer.append(dateFormatDate.format(item.getCreateDate()));
		%>
	</liferay-ui:search-container-column-text>	
	<liferay-ui:search-container-column-text
		name="Last Modified"
		buffer="buffer"
	>
		<%
			buffer.append(timeFormatDate.format(item.getModifiedDate()));
		%>
	</liferay-ui:search-container-column-text>
	
	<liferay-ui:search-container-column-text name="Action">		
		<liferay-ui:icon-menu>
				<%
				editEntryURL.setParameter("itemId", Long.toString(item.getItemId()  ));
				deleteEntryURL.setParameter("itemId", Long.toString(item.getItemId() ));
				
				
				%>
				<liferay-ui:icon image="edit" url="<%=editEntryURL.toString()  %>" />
				<liferay-ui:icon-delete url="<%=deleteEntryURL.toString()  %>" />
		
		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>