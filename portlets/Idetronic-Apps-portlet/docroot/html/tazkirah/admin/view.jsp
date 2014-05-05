<%@ include file="/html/init.jsp" %>
<%
	List<Tazkirah> tazkirahs = TazkirahLocalServiceUtil.listOrderByCategory(themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId());
	
	String organisationName = PropsUtil.get("tazkirah.category");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/tazkirah/admin/view.jsp");
	
	PortletURL deleteEntryURL = renderResponse.createActionURL();
	deleteEntryURL.setParameter(ActionRequest.ACTION_NAME,"deleteEntry");
	deleteEntryURL.setParameter("redirectURL", portletURL.toString());
	
	PortletURL editEntryURL = renderResponse.createRenderURL();
	editEntryURL.setParameter("jspPage", "/html/tazkirah/admin/entry.jsp");
	editEntryURL.setParameter(Constants.CMD, Constants.EDIT);
	editEntryURL.setParameter("redirectURL", portletURL.toString());
	
	
	PortletURL addEntryURL = renderResponse.createRenderURL();
	addEntryURL.setParameter("jspPage", "/html/tazkirah/admin/entry.jsp");
	addEntryURL.setParameter(Constants.CMD, Constants.ADD);
	String catMsg="";
	
	
%>
<a class="btn btn-primary" href="<%= addEntryURL %>">New Entry</a>&nbsp; 

<liferay-ui:search-container
		emptyResultsMessage='No results to display'
		iteratorURL="<%= portletURL %>"
	>
	<liferay-ui:search-container-results
			total="<%=tazkirahs.size() %>"
			results="<%= ListUtil.subList(tazkirahs,searchContainer.getStart(),searchContainer.getEnd()) %>"
		/>
	<liferay-ui:search-container-row
			className="Tazkirah"
			modelVar="entry">
		
			<liferay-ui:search-container-column-text
				name="category"
				title="<%= entry.getCategory() %>"
			/>
			<liferay-ui:search-container-column-text
				name="title"
				title="<%= entry.getTitle() %>"
			/>
			
			<liferay-ui:search-container-column-text
				name="content"
				title="<%= entry.getContent() %>"
			/>
			<liferay-ui:search-container-column-text name="Action">
		<liferay-ui:icon-menu>
			<%
			editEntryURL.setParameter("tazkirahId", Long.toString(entry.getTazkirahId()  ));
			deleteEntryURL.setParameter("tazkirahId", Long.toString(entry.getTazkirahId()));
			addEntryURL.setParameter("category", entry.getCategory());
			catMsg = "Add in '"+entry.getCategory()+ "'";
			%>
			<liferay-ui:icon image="edit" url="<%=editEntryURL.toString()  %>" />
			<liferay-ui:icon image="page" url="<%= addEntryURL.toString() %>" label="true" message="<%= catMsg %>"/>
			<liferay-ui:icon-delete url="<%=deleteEntryURL.toString()  %>" />
	
		</liferay-ui:icon-menu>
	
	</liferay-ui:search-container-column-text>
			
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>



