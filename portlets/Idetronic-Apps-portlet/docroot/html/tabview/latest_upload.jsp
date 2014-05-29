<%@ include file="/html/tabview/init.jsp" %>

<%
	List<DLFileEntry> results = new ArrayList<DLFileEntry>();
	List<String> headerNames = new ArrayList<String>();	
	headerNames.add("name");
	headerNames.add("size");
	PortletURL portletURL = renderResponse.createRenderURL();

	
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, portletURL, headerNames, "no-requests-were-found");
	searchContainer.setEmptyResultsMessage("no-documents-were-found");
	 
	results = DLFileEntryLocalServiceUtil.getGroupFileEntries(themeDisplay.getScopeGroupId(), 0, viewConfig.getMaxItem());
	searchContainer.setResults(results);
	List<ResultRow> resultRows = searchContainer.getResultRows();
%>
<c:choose>
	<c:when test="<%= results.isEmpty() %>">
		<liferay-ui:message key="there-are-no-new-uploads" />

		<br /><br />
	</c:when>
	<c:otherwise>
		<div class="tbview-ol">
			<ol>
<%
		for (int i = 0; i < results.size(); i++) {
			DLFileEntry fileEntry = results.get(i);
			ResultRow row = new ResultRow(fileEntry, fileEntry.getFileEntryId(), i);
			DLFileVersion fileVersion = fileEntry.getLatestFileVersion(false);
			String docURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle())) + "?version=" + fileVersion.getVersion();

			
			
		%>
		<c:if test="<%= DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.VIEW) %>">
			<li>
					<liferay-ui:icon
						image='<%= "../file_system/small/" + fileEntry.getIcon() %>'
						label="<%= true %>"
						message="<%= fileEntry.getTitle() %>"
						url="<%= docURL %>"
					/>
			</li>	
				
			
			
		</c:if>

		<%
		}
		%>
			</ol>
		</div>
	</c:otherwise>
</c:choose>



	
<%	/*
	
	for (int i=0; i<results.size();i++)
	{
		DLFileEntry fileEntry = results.get(i);
		ResultRow row = new ResultRow(fileEntry, fileEntry.getFileEntryId(), i);
		DLFileVersion fileVersion = fileEntry.getLatestFileVersion(false);
		String docURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle())) + "?version=" + fileVersion.getVersion();

	*/	
%>

<%	/*

long size = fileEntry.getSize();
row.addText(TextFormatter.formatKB(size, locale) + "Kb");
resultRows.add(row);

	}*/
%>