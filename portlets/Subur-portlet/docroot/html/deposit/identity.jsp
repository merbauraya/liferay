<%@ include file="/html/init.jsp" %>
<%@page import="java.util.Arrays" %>
<%
	
	//List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	SuburItem item = (SuburItem)request.getAttribute("suburItem");
	
	//List itemItemTypes =  ItemItemTypeLocalServiceUtil.getByItemId(item.getItemId());  //ItemItemTypeLocalServiceUtil.getByItemId(item.getItemId());
	
	
	List<ItemType> itemTypes2 = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<ItemItemType> itemItemType2 = ItemItemTypeLocalServiceUtil.itemTypeByItemid(item.getItemId());
	
	Long[] selectedItemType = new Long[itemItemType2.size()];
	for (int i = 0; i < itemItemType2.size() ; i++)
	{
		selectedItemType[i] = itemItemType2.get(i).getItemTypeId();
		
	}
	
	
	
	
	
	//List<ItemType> itemTypes = (List)itemItemTypes.get(0);
	//List<ItemItemType> selectedItemTypes = (List)itemItemTypes.get(1);
	
	
%>
<aui:model-context bean="<%= item %>" model="<%= SuburItem.class %>" />

<aui:select size="5" multiple="<%=true %>" label="item-type" name="itemType">

	
	<%for (ItemType itemType: itemTypes2) 
	{
		boolean selected = Arrays.asList(selectedItemType).contains(new Long(itemType.getItemTypeId()));
		
		
		
	%>
		<aui:option selected="<%=selected %>" value="<%= itemType.getItemTypeId() %>">
			<%=itemType.getItemTypeName() %>
		</aui:option>
	<%
	}
	%>
</aui:select>

<aui:input type="text" name="title" cssClass="field subur-title">

</aui:input>
<aui:input type="textarea" name="itemAbstract" autoSize="<%= true %>"></aui:input>

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