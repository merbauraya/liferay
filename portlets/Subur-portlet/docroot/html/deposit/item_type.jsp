<%@ include file="/html/subur/init.jsp" %>
<%
	List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

%>
<aui:select label="item-type" name="itemType" onchange='<%= renderResponse.getNamespace() + "itemType();" %>'>
	
	<%for (ItemType itemType: itemTypes) 
	{
	%>
		<aui:option value="<%= itemType.getItemTypeId() %>">
			<%=itemType.getItemTypeName() %>
		</aui:option>
	<%
	}
	%>
</aui:select>
