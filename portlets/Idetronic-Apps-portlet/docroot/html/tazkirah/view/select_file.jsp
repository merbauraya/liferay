<%@ include file="/html/init-select.jsp" %>

<%
	Folder folder = null;//(Folder)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FOLDER); 

	long folderId = BeanParamUtil.getLong(folder, request, "folderId", DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	String nameSpace = ParamUtil.getString(request, "nameSpace");
	long groupId = BeanParamUtil.getLong(folder, request, "groupId");
	String eventName = ParamUtil.getString(request, "eventName", nameSpace + "selectFile");

	long repositoryId = groupId;
	if (folder != null) {
		DLUtil.addPortletBreadcrumbEntries(folder, request, renderResponse);
	}
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configActionUrl"/>
<aui:form method="post" name="selectFileFm" action="<%=configActionUrl %>">
	<liferay-ui:header
		title="home"
	/>

	<liferay-ui:breadcrumb showGuestGroup="<%= false %>" showLayout="<%= false %>" showParentGroups="<%= false %>" />

	<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("jspPage", "/html/tazkirah/view/select_file.jsp");
	portletURL.setParameter("groupId", String.valueOf(groupId));
	portletURL.setParameter("folderId", String.valueOf(folderId));
	portletURL.setParameter("eventName", eventName);
	List<String> headerNames = new ArrayList<String>();

	headerNames.add("folder");
	headerNames.add("num-of-folders");
	headerNames.add("num-of-documents");

	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);

	int total = DLAppServiceUtil.getFoldersCount(groupId, folderId);

	searchContainer.setTotal(total);

	List results = DLAppServiceUtil.getFolders(groupId, folderId, searchContainer.getStart(), searchContainer.getEnd());

	searchContainer.setResults(results);

	List resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		Folder curFolder = (Folder)results.get(i);

		curFolder = curFolder.toEscapedModel();

		ResultRow row = new ResultRow(curFolder, curFolder.getFolderId(), i);

		PortletURL rowURL = renderResponse.createRenderURL();

		rowURL.setParameter("jspPage", "/html/tazkirah/view/select_file.jsp");
		rowURL.setParameter("groupId", String.valueOf(groupId));
		rowURL.setParameter("folderId", String.valueOf(curFolder.getFolderId()));

		// Name

		StringBundler sb = new StringBundler(4);

		sb.append("<img align=\"left\" border=\"0\" src=\"");
		sb.append(themeDisplay.getPathThemeImages());

		List<Long> subfolderIds = DLAppServiceUtil.getSubfolderIds(groupId, curFolder.getFolderId(), false);

		int foldersCount = subfolderIds.size();

		subfolderIds.clear();
		subfolderIds.add(curFolder.getFolderId());

		int fileEntriesCount = DLAppServiceUtil.getFoldersFileEntriesCount(groupId, subfolderIds, WorkflowConstants.STATUS_APPROVED);

		if ((foldersCount + fileEntriesCount) > 0) {
			sb.append("/common/folder_full_document.png\">");
		}
		else {
			sb.append("/common/folder_empty.png\">");
		}

		sb.append(curFolder.getName());

		row.addText(sb.toString(), rowURL);

		// Statistics

		row.addText(String.valueOf(foldersCount), rowURL);
		row.addText(String.valueOf(fileEntriesCount), rowURL);

		// Add result row

		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

	<c:if test="<%= !results.isEmpty() %>">
		<br />
	</c:if>

	<liferay-ui:header
		title="select image"
	/>

	<%
	headerNames.clear();

	headerNames.add("file");
	headerNames.add("size");

	//if (PropsValues.DL_FILE_ENTRY_READ_COUNT_ENABLED) {
		//headerNames.add("downloads");
	//}

	//headerNames.add("locked");
	
	String[] mediaGalleryMimeTypes= {"image/bmp","image/jpeg","image/png","image/tiff","image/gif"};
	searchContainer = new SearchContainer(renderRequest, null, null, "cur2", SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);
	
	
	int status = WorkflowConstants.STATUS_APPROVED;
	//results = DLAppServiceUtil.getFileEntries(groupId, folderId, searchContainer.getStart(), searchContainer.getEnd());
	//results = DLAppServiceUtil.getFoldersAndFileEntriesAndFileShortcuts(repositoryId, folderId, status, mediaGalleryMimeTypes, true, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());

	results = DLAppServiceUtil.getGroupFileEntries(scopeGroupId, 0, folderId, mediaGalleryMimeTypes, status, 0, SearchContainer.MAX_DELTA, null);
	searchContainer.setTotal(results.size());
	searchContainer.setResults(results);

	
	
	
	resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		FileEntry fileEntry = (FileEntry)results.get(i);
		FileVersion fileVersion = fileEntry.getFileVersion();
		String src = DLUtil.getThumbnailSrc(fileEntry, fileVersion, null, themeDisplay);
		String imageSrc = DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, "&imagePreview=1");
		fileEntry = fileEntry.toEscapedModel();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("fileId", fileEntry.getFileEntryId());
		data.put("fileName", fileEntry.getTitle());
		
		ResultRow row = new ResultRow(fileEntry, fileEntry.getFileEntryId(), i);
		row.setData(data);
		StringBundler sb = new StringBundler(9);
		sb.append("javascript:");
		sb.append("selectImageEntry('");
		sb.append(fileEntry.getFileEntryId());
		sb.append("', '");
		sb.append(UnicodeFormatter.toString(fileEntry.getTitle()));
		sb.append("'); window.close();");

		String rowHREF = sb.toString();

		// Title and description

		sb.setIndex(0);
		sb.append("<img src='"+src+ "' style='width:80px'/>");
		
		
		//sb.append(DLUtil.getFileEntryImage(fileEntry, themeDisplay));
		sb.append(fileEntry.getTitle());

		if (Validator.isNotNull(fileEntry.getDescription())) {
			sb.append("<br />");
			sb.append(fileEntry.getDescription());
		}

		row.addText(sb.toString(), rowHREF);

		// Statistics

		row.addText(TextFormatter.formatKB(fileEntry.getSize(), locale) + "k", rowHREF);

	//	if (PropsValues.DL_FILE_ENTRY_READ_COUNT_ENABLED) {
	//		row.addText(String.valueOf(fileEntry.getReadCount()), rowHREF);
		//}

		// Checked out

		//row.addText(LanguageUtil.get(pageContext, fileEntry.isCheckedOut() ? "yes" : "no"), rowHREF);

		// Add result row

		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</aui:form>

<aui:script use="aui-base">
	var Util = Liferay.Util;

	A.one('#<portlet:namespace />selectFileFm').delegate(
		'click',
		function(event) {
			var result = Util.getAttributes(event.currentTarget, 'data-');

			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);

			Util.getWindow().hide();
		},
		'.selector-button'
	);
</aui:script>
<script type="text/javascript">
	var Util = Liferay.Util;
	function selectImageEntry(imageId,imageName)
	{
		var result = [];
		result.push(imageId);
		result.push(imageName);
		
		Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);
		Util.getWindow().hide();
	}
			
</script>