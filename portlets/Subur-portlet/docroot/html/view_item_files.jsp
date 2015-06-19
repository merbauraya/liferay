<%
		List fileResults = new ArrayList(fileEntries.size());	
		
		for (ItemFileEntry itemFileEntry : fileEntries  ) 
		{
			FileEntry fileEntry = null;
			try {
				fileEntry = DLAppLocalServiceUtil.getFileEntry(itemFileEntry.getFileEntryId());
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn("Documents and Media search index is stale and contains file entry {" + itemFileEntry.getFileEntryId() + "}");
				}

				continue;
			}

			fileResults.add(fileEntry);
			
		}
		
		for (int i = 0;i < fileResults.size(); i++)
		{
			FileEntry fileResult = (FileEntry)fileResults.get(i);	
			FileVersion latestFileVersion = fileResult.getFileVersion();
			String thumbNail = DLUtil.getThumbnailSrc(fileResult, null,themeDisplay);
		}
	
	%>
	<c:if test='<%=fileResults.size() > 0 %>'>
		<liferay-ui:search-container delta="10" 
			emptyResultsMessage="no-entries-were-found"
			headerNames="title,size,download">
			
	        <liferay-ui:search-container-results
	                results="<%= fileResults %>"
	                total="<%= fileResults.size() %>"
	        />
		<liferay-ui:search-container-row
                className="com.liferay.portal.kernel.repository.model.FileEntry"
                keyProperty="itemId" modelVar="fileItem" escapedModel="<%=true%>">
                <%
                	FileVersion latestFileVersion = fileItem.getFileVersion();
                	String thumb = DLUtil.getThumbnailSrc(fileItem, latestFileVersion, null, themeDisplay);
                	String size = TextFormatter.formatStorageSize(latestFileVersion.getSize(), locale);
                %>
                <liferay-util:buffer var="fileEntryTitle">

						<%
						String rowURL = DLUtil.getPreviewURL(fileItem,latestFileVersion,themeDisplay,StringPool.BLANK,false);//liferayPortletResponse.createRenderURL();

						//rowURL.setParameter("struts_action", "/document_library/view_file_entry");
						//rowURL.setParameter("redirect", HttpUtil.removeParameter(currentURL, liferayPortletResponse.getNamespace() + "ajax"));
						//rowURL.setParameter("fileEntryId", String.valueOf(fileItem.getFileEntryId()));
						%>

						<liferay-ui:app-view-entry
							displayStyle="list"
							locked="<%= fileItem.isCheckedOut() %>"
							showCheckbox="<%= false %>"
							thumbnailSrc='<%= themeDisplay.getPathThemeImages() + "/file_system/small/" + DLUtil.getFileIcon(fileItem.getExtension()) + ".png" %>'
							title="<%= latestFileVersion.getTitle() %>"
							url="<%= rowURL %>"
						/>
					</liferay-util:buffer>
                
                
                
                
                <liferay-ui:search-container-column-text name="Title" value="<%=fileEntryTitle %>" />

                <liferay-ui:search-container-column-text name="Size" value="<%=size %>" />
				<liferay-ui:search-container-column-text name="Downloads" value="<%=String.valueOf(fileItem.getReadCount()) %>" />
                

                
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator />
		</liferay-ui:search-container>
	
	</c:if>
	
	