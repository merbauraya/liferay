<%@ include file="/html/subur/init.jsp" %>
<%
	String itemId = renderRequest.getParameter("itemId");
	

	List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

%>
<portlet:actionURL name="newItem" var="depositItemURL"/>
<aui:form method="post" action="<%=depositItemURL%>" name="fm">
	<aui:select size="5" multiple="<%=true %>" label="item-type" name="itemType">

		
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

	<aui:input type="text" cssClass="fullwidth" name="title"></aui:input>
	
	
	<aui:button name="submitBtn" type="submit" value="save" last="true" />
</aui:form>