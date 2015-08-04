<%@ include file="/html/subur/init.jsp" %>
<%
	
	//List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	SuburItem item = (SuburItem)request.getAttribute("suburItem");
	
%>
<liferay-security:permissionsURL
    modelResource="<%= SuburItem.class.getName() %>"
    modelResourceDescription="<%= item.getTitle() %>"
    resourcePrimKey="<%= String.valueOf(item.getPrimaryKey()) %>"
    var="entryURL"
    windowState="<%= LiferayWindowState.POP_UP.toString() %>"
/>

<liferay-ui:icon 
	image="permissions" 
	url="<%= entryURL %>" 
	useDialog="<%= true %>"
	method="get"
	message="set-permission"	
	label="<%=true %>"	
/>
<aui:fieldset>
	<aui:select size="1" multiple="<%=false %>" label="item-status" name="itemStatus">

		<%
			int itemStatus = item.getStatus();
		%>
		
		<aui:option selected="<%=(itemStatus ==SuburConstant.STATUS_DRAFT_ITEM)  %>" value="<%= SuburConstant.STATUS_DRAFT_ITEM %>">
			<liferay-ui:message key="status-draft" />
		</aui:option>
		<aui:option selected="<%=(itemStatus ==SuburConstant.STATUS_PUBLISHED_ITEM)  %>" value="<%= SuburConstant.STATUS_PUBLISHED_ITEM%>">
			<liferay-ui:message key="status-published" />
		</aui:option>
		<aui:option selected="<%=(itemStatus ==SuburConstant.STATUS_WITHDRAWN_ITEM)  %>" value="<%= SuburConstant.STATUS_WITHDRAWN_ITEM%>">
			<liferay-ui:message key="status-withdrawn" />
		</aui:option>
		
</aui:select>
	
</aui:fieldset>
