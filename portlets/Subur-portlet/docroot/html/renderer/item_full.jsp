<%@include file="/html/init.jsp"%>

<%
	long itemId = ParamUtil.getLong(request,"itemId");
	//SuburItem suburItem = (SuburItem)request.getAttribute("suburItem");
	SuburItem suburItem = SuburItemLocalServiceUtil.fetchSuburItem(itemId);
	suburItem = suburItem.toEscapedModel();
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(SuburItem.class.getName(), itemId);
	suburItem = suburItem.toEscapedModel();
	List<ItemFileEntry> itemFileEntries = ItemFileEntryLocalServiceUtil.getByItemId(suburItem.getItemId());
	
	List<DLFileEntry> fileEntries = new ArrayList<DLFileEntry>();
	for (ItemFileEntry itemFileEntry: itemFileEntries)
	{
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(itemFileEntry.getFileEntryId());
		fileEntries.add(fileEntry);
	}
	
	
	//view counter
	AssetEntry incrementAssetEntry = null;
	incrementAssetEntry = AssetEntryServiceUtil.incrementViewCounter(assetEntry.getClassName(), assetEntry.getClassPK());
	
	
%>
<div>
	<div class="item-title">
		<h3><%= suburItem.getTitle() %></h3>
	</div>
	<div class="item-date">
		<%
			
			//if (suburItem.getStatus() == SuburConstant.STATUS_DRAFT_ITEM)
		%>
		<span class="hide-accessible">Published Date</span>
			<c:if test="<%=Validator.isNotNull(suburItem.getPublishedDate()) %>">
				<%=dateFormatDate.format(suburItem.getPublishedDate()) %>
			</c:if>
	</div>
	<c:if test="<%= SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.DELETE) || SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.PERMISSIONS) || SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.UPDATE) %>">
		<ul class="edit-actions entry icons-container lfr-meta-actions">
			<c:if test="<%= SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.UPDATE) %>">
				<li class="edit-entry">
					<portlet:renderURL var="editEntryURL">
						<portlet:param name="jspPage" value="<%= SuburConstant.PAGE_UPDATE_ITEM %>" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						<portlet:param name="itemId" value="<%= String.valueOf(suburItem.getItemId()) %>" />
					</portlet:renderURL>

					<liferay-ui:icon
						image="edit"
						label="<%= true %>"
						url="<%= editEntryURL %>"
					/>
				</li>
			</c:if>

			<c:if test="<%= showEditEntryPermissions && SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.PERMISSIONS) %>">
				<li class="edit-entry-permissions">
					<liferay-security:permissionsURL
						modelResource="<%= SuburItem.class.getName() %>"
						modelResourceDescription="<%= suburItem.getTitle() %>"
						resourceGroupId="<%= String.valueOf(suburItem.getGroupId()) %>"
						resourcePrimKey="<%= String.valueOf(suburItem.getItemId()) %>"
						var="permissionsEntryURL"
						windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					/>

					<liferay-ui:icon
						image="permissions"
						label="<%= true %>"
						method="get"
						url="<%= permissionsEntryURL %>"
						useDialog="<%= true %>"
					/>
				</li>
			</c:if>

			<c:if test="<%= SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.DELETE) %>">
				<li class="delete-entry">
					<portlet:renderURL var="viewURL">
						<portlet:param name="struts_action" value="/blogs/view" />
					</portlet:renderURL>

					<portlet:actionURL var="deleteEntryURL" name="deleteItem">
						<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
						<portlet:param name="redirect" value="<%= viewURL %>" />
						<portlet:param name="itemId" value="<%= String.valueOf(suburItem.getItemId()) %>" />
					</portlet:actionURL>

					<liferay-ui:icon-delete
						label="<%= true %>"
						trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>"
						url="<%= deleteEntryURL %>"
					/>
				</li>
			</c:if>
			<c:if test="<%= SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.UPDATE) %>">
				<li class="withdraw-item">
					<portlet:renderURL var="viewURL">
						<portlet:param name="struts_action" value="/blogs/view" />
					</portlet:renderURL>

					<portlet:actionURL var="withdrawItemURL" name="withdrawItem">
						<portlet:param name="redirect" value="<%= viewURL %>" />
						<portlet:param name="itemId" value="<%= String.valueOf(suburItem.getItemId()) %>" />
					</portlet:actionURL>

					<liferay-ui:icon
						label="<%= true %>"
						image="withdraw"
						url="<%= withdrawItemURL %>"
					/>
				</li>
			</c:if>
		</ul>
	</c:if>
	<div class="item-author">
		<span class="hide-accessible">Author</span>
		<%
			long[] authorIds = ItemAuthorLocalServiceUtil.getAuthorId(itemId);
			List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
			for (Author author: authors)
			{
		%>
				<%=SuburUtil.getName(author.getFirstName(),author.getLastName()) %>
		
		<%	} %>
	
	</div>
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
	</div>
	<div class="item-abstract">
		<%=suburItem.getItemAbstract() %>
	</div>
	<div>
		
		<liferay-ui:asset-links
			assetEntryId="<%= assetEntry.getEntryId() %>"
			className="<%= SuburItem.class.getName() %>"
			classPK="<%= suburItem.getPrimaryKey() %>"
							
		/>
						
		
	</div>
	
</div>
