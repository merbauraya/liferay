<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.model.TicketConstants"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Ticket"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.sun.mail.imap.DefaultFolder"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<portlet:defineObjects />
<liferay-theme:defineObjects/>

 <%
Ticket ticket = TicketLocalServiceUtil.addTicket(user.getCompanyId(), User.class.getName(), user.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, null, new ServiceContext());
%>

<!--REEDME instead of<form> of view.jsp you can also use <aui:form action="<c:out value="${NAMEUrl}"/>" cssClass="lfr-export-dialog" method="post" name="fm1">-->

<div class="lfr-dynamic-uploader">
    <div class="lfr-upload-container" id="<portlet:namespace />fileUpload">
    &nbsp;
    </div>
</div>
<div id="<portlet:namespace/>fallback"></div>

<aui:script use="liferay-upload,aui-base">
    var liferayUpload = new Liferay.Upload(
        {
            boundingBox: '#<portlet:namespace />fileUpload',
            deleteFile: '<liferay-portlet:actionURL name="METHODJAVANAMEFordeleteFile" doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
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
                    tempFolderName: 'com.example.portlet.ClientPortlet' <!-- this is equals of _TEMP_FOLDER_NAME_ATTACHMENT of ClientPortlet.java -->
                }
            },
            uploadFile: '<liferay-portlet:actionURL name="METHODJAVANAMEForuploadFile" doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
        }
    );
</aui:script>