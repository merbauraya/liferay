<%@include file="/html/init.jsp"%>
<%
	long itemId = ParamUtil.getLong(request, "itemId");
	//SuburItem item = SuburItemLocalServiceUtil.getSuburItem(itemId);
	List authors = SuburItemLocalServiceUtil.getAuthor(itemId);
	List auth = new ArrayList();
	List lstDetails  = SuburItemLocalServiceUtil.getDetails(itemId);
	
	List<ItemType> itemItemTypes = SuburItemLocalServiceUtil.getItemTypes(itemId);
	
	List fileEntriesList = SuburItemLocalServiceUtil.getFileEntry(itemId);
	
	
	List<FileEntryType> fileTypes = (List)fileEntriesList.get(0);
	List<ItemFileEntry> fileEntries = (List)fileEntriesList.get(1);
	
	List<SuburItem> items = (List)lstDetails.get(0);
	List<MetadataPropertyValue> propValues = (List)lstDetails.get(1);
	SuburItem item = items.get(0);
	
	for (MetadataPropertyValue propVal : propValues)
	{
		if (propVal.getPropertyId() == SuburConstant.METADATA_CONTRIBUTOR_AUTHOR)
			auth.add(propVal);
	}
	
	
%>
<div class="itemDetail">
	<h3><%=item.getTitle() %></h3>
	<table class="itemView" border-spacing="5">
		<tbody>
			<tr valign="top">
				
				<th>Item Type</th>
				<td>
				<%
					for (ItemType iType : itemItemTypes)
					{
				%>
					<div class="item-item-type">
						<%=iType.getItemTypeName() %>
					</div>
				<%		
					}
				%>
				</td>
			</tr>
			<tr valign="top">
				<th>Authors</th>
				<td>
				<%
					for (int i = 0; i < auth.size(); i++)
					{
						MetadataPropertyValue author = (MetadataPropertyValue)auth.get(i);
				%>
					<div class="authorList">
						<%=author.getTextValue() %>
					</div>
				<%
					}
				%>
				</td>
			</tr>
			<tr>
				<th>Deposit date</th>
				<td><%=item.getCreateDate() %></td>
			</tr>
			<tr>
				<th>Last Modified</th>
				<td><%=item.getModifiedDate() %></td>
			</tr>
			<c:if test="<%=Validator.isNotNull(item.getItemAbstract())%>">
				<th>Abstract</th>
				<td><%= item.getItemAbstract() %></td>
			</c:if>
		
		</tbody>
	
	</table>
	
	<%@ include file="/html/view_item_files.jsp" %>
	
	
	
	
	
	
	
</div>
<div class="span4">
xxxx
</div>

<%!
private static Log _log = LogFactoryUtil.getLog("subur.docroot.html.view_item.jsp");
%>