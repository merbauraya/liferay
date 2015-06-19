<%@ include file="/html/item.jsp" %>
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