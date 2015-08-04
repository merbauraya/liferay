<%@ include file="/html/subur/init.jsp" %>

<portlet:actionURL  var="NAMEUrl" name="METHODJAVANAMEManageForm">
</portlet:actionURL>
 <%
	
 	SuburItem item = (SuburItem)request.getAttribute("suburItem");
 	long itemId = item.getItemId();
 	Ticket ticket = TicketLocalServiceUtil.addTicket(user.getCompanyId(), User.class.getName(), user.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, null, new ServiceContext());
	HttpServletRequest req = (HttpServletRequest)request;
 	long folderId = SuburFolderUtil.getFolderId(req, themeDisplay);
 	
%>
<liferay-ui:panel defaultState="open" extended="<%= false %>" id="suburAssetLinksPanel" persistState="<%= true %>" title="select-related-assets">
    <aui:fieldset>
       <liferay-ui:input-asset-links
            className="<%= SuburItem.class.getName() %>"
            classPK="<%= itemId %>"
        />
    </aui:fieldset>
</liferay-ui:panel>

<aui:row>

	

<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="suburFileUploadPanel" persistState="<%= true %>" title="or-upload-document">

    
<div class="lfr-dynamic-uploader">
    <div class="lfr-upload-container" id="<portlet:namespace />fileUpload">
    &nbsp;
    </div>
</div>
<div id="<portlet:namespace/>fallback">
 <aui:button-row>
            <aui:button cssClass='hide' name="continueButton" type="submit" value="Continue" />
        </aui:button-row>
</div>
</liferay-ui:panel>


<aui:script use="liferay-upload,aui-base">
    var liferayUpload = new Liferay.Upload(
        {
            boundingBox: '#<portlet:namespace />fileUpload',
            deleteFile: '<liferay-portlet:actionURL name="deleteTempFile" doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="suburItemId" value="<%=String.valueOf(itemId) %>" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
            fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
            maxFileSize: '<%= PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE) %>',
            metadataContainer: '#<portlet:namespace />commonFileMetadataContainer',
            metadataExplanationContainer: '#<portlet:namespace />metadataExplanationContainer',
            namespace: '<portlet:namespace />',
            tempFileURL: {
                method: Liferay.Service.bind('/dlapp/get-temp-file-entry-names'),
                params: {
                    groupId: <%= scopeGroupId %>,
                    folderId: <%= DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>,
                    tempFolderName: '<%=SuburConstant.TEMP_UPLOAD_FOLDER%>'
                }
            },
            uploadFile: '<liferay-portlet:actionURL name="manageTempFileUpload" doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="suburItemId" value="<%=String.valueOf(itemId) %>" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
        }
    );
    
    var continueButton = A.one('#<portlet:namespace />continueButton');

    function toggleContinueButton() {
        var uploadedFiles = liferayUpload._fileListContent.all('.upload-file.upload-complete');
        continueButton.show();
        /*
        if (uploadedFiles.size() == 1) {
            console.log('One file Upload');
            console.log(uploadedFiles);
            continueButton.show();
        }
        else {
            console.log(uploadedFiles);
            continueButton.hide();
        }*/
    }
    liferayUpload._uploader.on(
            'fileuploadstart',
            function(event) {
                console.log('File Upload Start');               
            }
        );  
    
    Liferay.on(
            'uploadcomplete',
            function(event) {
                console.log('File Upload Complete');
            }
        );
    
    liferayUpload._uploader.on(
            'alluploadscomplete',
            function(event) {
                console.log('All Uploads Complete');
                toggleContinueButton();
            }
        );      
    
    Liferay.on(
            'tempFileRemoved',
            function(event) {
                console.log('Temp File Removed');
                toggleContinueButton();
            }
        );      
    
</aui:script>

</aui:row>


