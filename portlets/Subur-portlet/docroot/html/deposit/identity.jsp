<%@ include file="/html/item.jsp" %>
<%
	
	//List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	SuburItem item = (SuburItem)request.getAttribute("suburItem");
	
	List itemItemTypes =  ItemItemTypeLocalServiceUtil.getByItemId(item.getItemId());  //ItemItemTypeLocalServiceUtil.getByItemId(item.getItemId());

	
	List vType = new ArrayList();
	
	
	List<ItemType> itemTypes = (List)itemItemTypes.get(0);
	List<ItemItemType> selectedItemTypes = (List)itemItemTypes.get(1);
	for (ItemItemType k : selectedItemTypes)
		out.print("id="+ k.getItemId() + "::"+ k.getItemTypeId());
	
%>
<aui:model-context bean="<%= item %>" model="<%= SuburItem.class %>" />

<aui:select size="5" multiple="<%=true %>" label="item-type" name="itemType" onchange='<%= renderResponse.getNamespace() + "itemType();" %>'>

	
	<%for (ItemType itemType: itemTypes) 
	{
		boolean selected=false;
		for (ItemItemType iType: selectedItemTypes)
		{
			if (iType.getItemTypeId() == itemType.getItemTypeId())
			{
				if (Validator.isNotNull(iType.getItemId()) || iType.getItemId()!= 0)
					selected = true;
				break;
			}
		}
		
	%>
		<aui:option selected="<%=selected %>" value="<%= itemType.getItemTypeId() %>">
			<%=itemType.getItemTypeName() %>
		</aui:option>
	<%
	}
	%>
</aui:select>

<aui:input type="text" name="title">

</aui:input>
<aui:input type="textarea" name="itemAbstract"></aui:input>

<div class="control-group">
	<aui:input type="text" name="otherTitle" label="Other Title"></aui:input>
</div>
<div class="control-group">
	<aui:input type="text" name="publisher"></aui:input>
</div>
<div class="control-group">
	<aui:input type="text" name="series-report-no"></aui:input>
</div>
<div class="control-group">
	
	<aui:select label="language" name="language" >
		<option value="">N/A</option>
	</aui:select>

</div>