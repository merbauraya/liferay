package com.idetronic.ruangj;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class TestPortlet extends MVCPortlet {
	long userId,groupId,repositoryId;
	ThemeDisplay themeDisplay;
	private static Log _log = LogFactoryUtil.getLog(TestPortlet.class);
	public void UploadFiles(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 userId = Long.valueOf(actionRequest.getRemoteUser());
		 
		 repositoryId = themeDisplay.getScopeGroupId();
		long folderId;
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		File file = uploadRequest.getFile("coverImage");
		String mimeType = MimeTypesUtil.getContentType(file);
		String title = file.getName();
		String description = "";
		String changeLog = null;
		
		
		if (file.getTotalSpace() > 0) {
			
			try {
				folderId = getFolderId(actionRequest);
				groupId = PortalUtil.getScopeGroupId(actionRequest);
				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(actionRequest);
				 long fileEntryTypeId = ParamUtil.getLong(serviceContext, "fileEntryTypeId", -1L);
			      Map<String, Fields> fieldsMap = new HashMap<String, Fields>();
			      _log.info("adding file");
				DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, repositoryId, folderId, 
						file.getName(), mimeType, title, 
						description, changeLog, fileEntryTypeId, fieldsMap, file, 
						null, file.length(), serviceContext);
				
				
				
				//LMSBookLocalServiceUtil.attachFiles(bookId, serviceContext);
			} catch (PortalException e) {
				_log.error("portalexp");
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		// redirecting to original list page
		actionResponse.sendRedirect(ParamUtil.getString(uploadRequest,
				"redirectURL"));
	}
	private long getFolderId(ActionRequest actionRequest) throws PortalException, SystemException
	{
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(now.get(Calendar.YEAR));
		
		ServiceContext folderServiceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
		long parentFolderId = 0;
		try {
			_log.info("getting folder");
			DLFolder dir = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, year);
			_log.info(dir);
			return dir.getFolderId();
			
		} catch (PortalException e) {
			// 
			return createFolder(year,parentFolderId,actionRequest);
			
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	private long createFolder(String folderName,long parentFolderId,ActionRequest request) throws PortalException, SystemException
	{
		ServiceContext folderServiceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);
		_log.info(folderName);
		_log.info(parentFolderId);
		_log.info(themeDisplay);
		DLFolder folder =  DLFolderLocalServiceUtil.addFolder(
				 themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
				 themeDisplay.getScopeGroupId(), false,
				 parentFolderId,
				 folderName, folderName, false,
				 folderServiceContext);
		return folder.getFolderId();
	}
}
