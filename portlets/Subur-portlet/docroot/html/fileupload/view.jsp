<%@ include file="/html/init.jsp" %>

<portlet:actionURL  var="NAMEUrl" name="METHODJAVANAMEManageForm">
</portlet:actionURL>
 <%
	Ticket ticket = TicketLocalServiceUtil.addTicket(user.getCompanyId(), User.class.getName(), user.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, null, new ServiceContext());
	HttpServletRequest req = (HttpServletRequest)request;
 	long folderId = SuburFolderUtil.getFolderId(req, themeDisplay);
 	
%>
<%=folderId %>
<aui:row>
<aui:form name="fm1" action="<%=NAMEUrl %>" method="POST" enctype="multipart/form-data">
	<aui:col width="<%=50 %>">
	
    
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
</aui:col>
<aui:col width="<%=50 %>">
		<div class="common-file-metadata-container hide selected" id="<portlet:namespace />commonFileMetadataContainer">
	
		<liferay-util:include page="/html/multiple_upload_resources.jsp" 
		useCustomPage="<%=true %>" 
		servletContext="<%=application %>"/>
	</div>
</aui:col>

<aui:script use="liferay-upload,aui-base">
    var liferayUpload = new Liferay.Upload(
        {
            boundingBox: '#<portlet:namespace />fileUpload',
            deleteFile: '<liferay-portlet:actionURL name="deleteTempFile" doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
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
                    tempFolderName: 'com.idetronic.subur.Subur._TEMP_FOLDER_NAME_ATTACHMENT'
                }
            },
            uploadFile: '<liferay-portlet:actionURL name="manageFileUpload" doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
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
</aui:form>
</aui:row>

<aui:script >

    $('#<portlet:namespace />continueButton').on(
        'click',
        function(event) {
            event.preventDefault();
            var fm = $('#<portlet:namespace />fm1');
            console.log(fm);
            /*
            //fm.ajaxSubmit(
            $('#<portlet:namespace />fm1').ajaxSubmit(
           
            
            
                {
                    success: function(responseData) {
                    	console.log(responseData);
                        <%-- $('#<portlet:namespace />exportImportOptions').html(responseData); --%>
                    }
                }
            );*/
        }
    );
</aui:script>
