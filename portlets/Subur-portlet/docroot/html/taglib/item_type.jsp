<div class="item-item-type">
	<label><liferay-ui:message key="item-type" /></label>
		<span class="item-type-summary">
<%
	PortletURL itemTypeURL = renderResponse.createRenderURL();
	Object[] itemTypes = ItemItemTypeLocalServiceUtil.getByItemIdArray(itemId);

	for (int i = 0; i < itemTypes.length; i ++)
	{
		ItemType itemType = (ItemType)itemTypes[i];
		itemTypeURL.setParameter("itemTypeId",String.valueOf(itemType.getItemTypeId()));
%>
		
			<a href="<%= itemTypeURL.toString() %>"><%= itemType.getItemTypeName() %></a>	
		
		
<%	}
%>
	</span>
</div>