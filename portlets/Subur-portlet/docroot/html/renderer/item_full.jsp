<%@include file="/html/init.jsp"%>

<%
	SuburItem suburItem = (SuburItem)request.getAttribute("suburItem");
	suburItem = suburItem.toEscapedModel();
	List<ItemFileEntry> itemFileEntries = ItemFileEntryLocalServiceUtil.getByItemId(suburItem.getItemId());
	
	List<DLFileEntry> fileEntries = new ArrayList<DLFileEntry>();
	for (ItemFileEntry itemFileEntry: itemFileEntries)
	{
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(itemFileEntry.getFileEntryId());
		fileEntries.add(fileEntry);
	}
	

%>
<dl>
	<dt>Title</dt>
	<dd><%= suburItem.getTitle() %></dd>

</dl>
<div class="asset-categorization-display">
	<label>Tags</label>
	<liferay-ui:asset-tags-summary
	    className="<%= SuburItem.class.getName() %>"
	    classPK="<%= suburItem.getItemId() %>"
	    portletURL="<%= renderResponse.createRenderURL() %>"
	/>
	<label>Categories</label>
	<liferay-ui:asset-categories-summary
	    className="<%= SuburItem.class.getName() %>"
	    classPK="<%= suburItem.getPrimaryKey() %>"
	    portletURL="<%= renderResponse.createRenderURL() %>"
	/>
	<liferay-ui:asset-links
						assetEntryId="<%= suburItem.getPrimaryKey() %>"
						className="<%=SuburItem.class.getName()  %>"
						classPK="<%= suburItem.getPrimaryKey() %>"
							/>
					
	
</div>
<%=itemFileEntries.size() %>
<c:if test="<%=itemFileEntries.size() > 0 %>">
	<h2 class="asset-links-title"><liferay-ui:message key="related-document" /></h2>
		<ul class="asset-link-list">
<%
	for (ItemFileEntry itemFileEntry: itemFileEntries)
	{
		
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(itemFileEntry.getFileEntryId());
		fileEntry = fileEntry.toEscapedModel();
		long folderId = fileEntry.getFolderId();
		String title = fileEntry.getTitle();
		String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "//" + folderId +  "//";// + HttpUtil.encodeURL(HtmlUtil.unescape(title));

%>
	<%=title %>
	<li class="asset-links-list-item">
		<li class="asset-links-list-item">
			<span>
				
			</span>
		</li>
<%		
	}
	
%>
	</ul>
</c:if>