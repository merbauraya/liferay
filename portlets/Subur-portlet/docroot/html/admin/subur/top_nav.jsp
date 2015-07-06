<%
	boolean showAddEntry = SuburPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ENTRY);
	boolean showAdminItem = SuburPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE);
	boolean showPermission = SuburPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
	boolean showSubscribe = SuburPermission.contains(permissionChecker, scopeGroupId, ActionKeys.SUBSCRIBE);// && (BlogsUtil.getEmailEntryAddedEnabled(portletPreferences) || BlogsUtil.getEmailEntryUpdatedEnabled(portletPreferences));
	boolean showManageAuthor = SuburPermission.contains(permissionChecker, scopeGroupId, SuburConstant.PERMISSION_MANAGE_AUTHOR);// && (BlogsUtil.getEmailEntryAddedEnabled(portletPreferences) || BlogsUtil.getEmailEntryUpdatedEnabled(portletPreferences));
	
	SearchContainer suburSearchContainer = new SuburSearch(renderRequest, currentURLObj);
	SuburDisplayTerms suburDisplayTerms = (SuburDisplayTerms)suburSearchContainer.getDisplayTerms();
%>

<c:if test="<%= showAddEntry || showAdminItem || showPermission ||  showSubscribe || showSearch || showManageAuthor%>">
	<aui:nav-bar>
		<c:if test="<%= showAddEntry || showAdminItem || showPermission %>">
			<aui:nav>
				<c:if test="<%= showAddEntry %>">
					<portlet:renderURL var="addItemURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
						<portlet:param name="jspPage" value="<%= SuburConstant.PAGE_NEW_ITEM %>" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						 
					</portlet:renderURL>
					<aui:nav-item href="<%= addItemURL %>" label="add-subur-item" name="addItemButton" />
				</c:if>
				<c:if test="<%= showAdminItem %>">
					<portlet:renderURL var="adminItemURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
						<portlet:param name="jspPage" value="<%= SuburConstant.PAGE_ADMIN_ITEM %>" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						
					</portlet:renderURL>
					<aui:nav-item href="<%= adminItemURL %>" label="manage-item" name="manageItemButton" />
					
				</c:if>
				<c:if test="<%= showManageAuthor %>">
					<portlet:renderURL var="manageAuthorURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
						<portlet:param name="jspPage" value="<%= SuburConstant.PAGE_ADMIN_AUTHOR %>" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						
					</portlet:renderURL>
					<aui:nav-item href="<%= manageAuthorURL %>" label="manage-author" name="manageAuthorButton" />
					
				</c:if>
				<c:if test="<%= showPermission %>">
					<liferay-security:permissionsURL
						modelResource="com.idetronic.subur"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
						var="permissionsURL"
						windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					/>
					<aui:nav-item href="<%= permissionsURL %>" label="permissions" title="edit-permissions" useDialog="<%= true %>" />
					
				</c:if>
			</aui:nav>
		</c:if>
		
			
		
		<c:if test="<%= showSearch %>">
	        <aui:nav-bar-search cssClass="pull-right">
				<liferay-ui:search-form
					page="/html/search/item_form.jsp"
					 searchContainer="<%= suburSearchContainer %>"
					 servletContext="<%= this.getServletConfig().getServletContext() %>"
						/>
			</aui:nav-bar-search>
		</c:if>
    </div>
		
	</aui:nav-bar>

</c:if>