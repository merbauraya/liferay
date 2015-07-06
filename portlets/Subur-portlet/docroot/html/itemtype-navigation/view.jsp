<%@ include file="/html/init.jsp" %>

<div class="item-type-nav">
	<ul>
	
<%
	
	String itemTypeIdSelected = ParamUtil.getString(request, "itemTypeId");


	String[] selectedItemTypesIds = StringUtil.split(itemTypeIdSelected);
	boolean showCount = true;
	List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(-1, -1);
	
	for (ItemType itemType: itemTypes)
	{
		PortletURL itemTypeURL = renderResponse.createActionURL();
		long itemTypeId = itemType.getItemTypeId();
		
		
		
		String itemName = itemType.getItemTypeName();
		if (showCount)
			itemName = itemType.getItemTypeName() + " (" + itemType.getItemCount() + ")";
		
		String itemTypeParam = null;
		
		String selectedStyle = StringPool.BLANK;
		if (ArrayUtil.contains(selectedItemTypesIds, String.valueOf(itemTypeId)))
		{
			selectedStyle = "item-type-selected";
			itemTypeParam = StringUtil.merge(ArrayUtil.remove(selectedItemTypesIds, String.valueOf(itemTypeId)));
		}else
		{
			itemTypeParam = StringUtil.merge(ArrayUtil.append(selectedItemTypesIds, String.valueOf(itemTypeId)));
		}
		itemTypeURL.setParameter("itemTypeIds", itemTypeParam);
	
%>
		<li class="item-type-popular">
			 <span>
			 	<a class="<%= selectedStyle %>"  href="<%= itemTypeURL.toString()%>">
			 		<%= itemName %>
			 	</a>
			 
			 </span>
		</li>

<%	} %>

	</ul>
</div>