<%@ include file="/html/init.jsp" %>
<%
	//List<Item> suburItems = ItemLocalServiceUtil.getDraftItems();	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/admin/subur/view.jsp");
	portletURL.setWindowState(WindowState.NORMAL);


	PortletURL addItemURL = renderResponse.createRenderURL();
	addItemURL.setParameter("jspPage", "/html/deposit/new.jsp");
	addItemURL.setParameter(Constants.CMD, Constants.ADD);
	String catMsg="";

	

	
	
	PortletURL editEntryURL = renderResponse.createActionURL();
	editEntryURL.setParameter("jspPage", SuburConstant.PAGE_UPDATE_ITEM);
	editEntryURL.setParameter(Constants.CMD, Constants.EDIT);
	editEntryURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	int status = SuburConstant.STATUS_ANY;

%>


<a class="btn btn-primary" href="<%= addItemURL %>">New Entry</a>&nbsp; 
<liferay-ui:search-container
	emptyResultsMessage="no-item-were-found"
	iteratorURL="<%=portletURL %>"
	total="<%= SuburItemLocalServiceUtil.getItemCount(status) %>"
>
	<liferay-ui:search-container-results
		results="<%= SuburItemLocalServiceUtil.getSuburItems(searchContainer.getStart(), searchContainer.getEnd(), status)  %>"
	/>
	<liferay-ui:search-container-row
		className="com.idetronic.subur.model.SuburItem"
		escapedModel="<%= true %>"
		keyProperty="itemId"
		modelVar="item"
	>
	<%
		String statusText="status-"+ item.getStatus();
	%>
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
	<liferay-ui:search-container-column-text
		name="status">
		<liferay-ui:message key="<%=statusText%>" />
		
		
		
		
	</liferay-ui:search-container-column-text>
	
	<liferay-ui:search-container-column-text name="Action">		
		<liferay-ui:icon-menu>
			
			<portlet:renderURL var="editURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
				<portlet:param name="jspPage" value="<%=SuburConstant.PAGE_UPDATE_ITEM %>"/>
				<portlet:param name="itemId" value="<%=String.valueOf(item.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.EDIT %>" />
			</portlet:renderURL>
			
			<portlet:actionURL var="deleteItemURL" name="deleteItem">
				<portlet:param name="itemId" value="<%=String.valueOf(item.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			</portlet:actionURL>
			
			<portlet:actionURL var="publishItemURL" name="publishItem">
				<portlet:param name="itemId" value="<%=String.valueOf(item.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
			</portlet:actionURL>
			
			<portlet:actionURL var="withdrawItemURL" name="withdrawItem">
				<portlet:param name="itemId" value="<%=String.valueOf(item.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
			</portlet:actionURL>
			
			
				<%
				
				
				
				
				
				%>
				<liferay-ui:icon image="edit" url="<%=editURL.toString()  %>" />
				<liferay-ui:icon-delete url="<%=deleteItemURL.toString()  %>" />
				<c:if test="<%= (item.getStatus() == SuburConstant.STATUS_DRAFT_ITEM) %>">
					<liferay-ui:icon image="publish" url="<%=publishItemURL.toString()  %>" />	
				</c:if>
				
				<c:if test="<%= (item.getStatus() == SuburConstant.STATUS_PUBLISHED_ITEM) %>">
					<liferay-ui:icon image="withdraw" url="<%=withdrawItemURL.toString()  %>" />	
				</c:if>
		
		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>