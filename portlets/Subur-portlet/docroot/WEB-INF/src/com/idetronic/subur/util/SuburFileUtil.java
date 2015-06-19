package com.idetronic.subur.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

public class SuburFileUtil {
	public static long addFile(PortletRequest request,long folderId,File file,String fileName)
	{
		try {
			long groupId = PortalUtil.getScopeGroupId(request);
			long userId = PortalUtil.getUserId(request);
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(request);
			long fileEntryTypeId = ParamUtil.getLong(serviceContext, "fileEntryTypeId", -1L);
			String mimeType = MimeTypesUtil.getContentType(file);
			
			Map<String, Fields> fieldsMap = new HashMap<String, Fields>();
			//DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, repositoryId, folderId, sourceFileName, mimeType, title, description, changeLog, fileEntryTypeId, fieldsMap, file, is, size, serviceContext)
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, groupId, folderId, 
					file.getName(), mimeType, fileName, 
					file.getName(), StringPool.BLANK, fileEntryTypeId, fieldsMap, file, 
					null, file.length(), serviceContext);
			return fileEntry.getFileEntryId();
		} catch (PortalException e) {
			
			e.printStackTrace();
		} catch (SystemException e) {
			
			e.printStackTrace();
		}
		return 0;
		
	}

}
