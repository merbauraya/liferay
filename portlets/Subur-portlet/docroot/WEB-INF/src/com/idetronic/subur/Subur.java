package com.idetronic.subur;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemDivisionLocalServiceUtil;
import com.idetronic.subur.service.ItemFileEntryLocalServiceUtil;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.ItemSubjectLocalServiceUtil;
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;
import com.idetronic.subur.service.SubjectLocalServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.util.SuburConstant;
import com.idetronic.subur.util.SuburFileUtil;
import com.idetronic.subur.util.SuburFolderUtil;
import com.idetronic.subur.util.SuburUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.sanitizer.Sanitizer;
import com.liferay.portal.kernel.sanitizer.SanitizerUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.StringUtil;

public class Subur extends MVCPortlet {
	private static Log logger = LogFactoryUtil.getLog(Subur.class);
	private static final String _TEMP_FOLDER_NAME_ATTACHMENT = Subur.class.getName();

	PortletRequest _request = null;
	ThemeDisplay themeDisplay;
	
	public void newItem(ActionRequest request,ActionResponse response) throws PortalException, SystemException
	{
		themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         SuburItem.class.getName(), request);
		String title = ParamUtil.getString(request, "title");
		String[] itemType = ParamUtil.getParameterValues(request, "itemType");
		String itemAbstract = ParamUtil.getString(request, "itemAbstract");
		String otherTitle = ParamUtil.getString(request, "otherTitle");
		logger.info("aaa");
		SuburItem item  = SuburItemLocalServiceUtil.addItem(themeDisplay.getUserId(), 
				themeDisplay.getScopeGroupId(), title, itemAbstract,serviceContext);
		logger.info("added");
		ItemItemTypeLocalServiceUtil.setItemItemType(item.getItemId(), itemType);
		logger.info("setitemtype");
		setOtherTitle(item.getItemId(),otherTitle);
		//response.setRenderParameter("itemId", String.valueOf(item.getItemId()));
		request.setAttribute("itemId", String.valueOf(item.getItemId()));
		
		//request.setAttribute("suburItem",item);
		response.setRenderParameter("jspPage","/html/deposit.jsp");
		
		
	}
	
	public void depositItem(ActionRequest request,ActionResponse response) throws PortalException, SystemException
	{
		_request = request;
		long userId = PortalUtil.getUser(request).getUserId();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         SuburItem.class.getName(), request);
		
		
		themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		
		long itemId = ParamUtil.getLong(uploadRequest, "itemId");
		File file = uploadRequest.getFile("itemFile");
		String sourceFile = uploadRequest.getFileName("itemFile");
		//logger.info("sourceFile="+sourceFile);
		//logger.info("file="+file);
		String title = ParamUtil.getString(uploadRequest, "title");
		String subjects = ParamUtil.getString(uploadRequest, "subject");
		
		String itemAbstract = ParamUtil.getString(uploadRequest, "itemAbstract");
		long divisionId = ParamUtil.getLong(uploadRequest, "division");
		String otherTitle = ParamUtil.getString(uploadRequest, "otherTitle");
		String categoryIds = ParamUtil.getString(uploadRequest, "categoryIds");
		String authorIdsString = ParamUtil.getString(uploadRequest, "authorsSearchContainerPrimaryKeys");
		String assetLinkEntryIdsString = ParamUtil.getString(uploadRequest,
				"assetLinksSearchContainerPrimaryKeys");
		if (assetLinkEntryIdsString != null) {
			long[] assetLinkEntryIds = StringUtil.split(
				assetLinkEntryIdsString, 0L);

			serviceContext.setAssetLinkEntryIds(assetLinkEntryIds);
		}

		logger.info(assetLinkEntryIdsString);
		
		
		long[] authorIds = StringUtil.split(GetterUtil.getString(authorIdsString), 0L);
		
		
		//handler categories
		long[] catIds = null;
		if (!categoryIds.isEmpty())
		{
			String[] catIdsArr = categoryIds.split(",");
			catIds= new long[catIdsArr.length];
			for (int i = 0;i < catIdsArr.length; i++)
			{
				
				catIds[i] = Long.parseLong(catIdsArr[i]);
				
			}
		}
		
		String tags = ParamUtil.getString(uploadRequest, "assetTagNames");
		logger.info(tags);
		String[] tagNamesArr = null;
		if (!tags.isEmpty())
		{
			tagNamesArr = tags.split(",");
		}
		
		
		try {
			SuburItem suburItem = SuburItemLocalServiceUtil.getSuburItem(itemId);
			//SuburItem item =SuburItemLocalServiceUtil.addItem(themeDisplay.getUserId(),
			//		themeDisplay.getScopeGroupId(), title, itemAbstract,serviceContext);
			suburItem.setTitle(title);
			suburItem.setItemAbstract(itemAbstract);
			//SuburItemLocalServiceUtil.updateSuburItem(suburItem);
			serviceContext.setAssetTagNames(tagNamesArr);
			serviceContext.setAssetCategoryIds(catIds);
			SuburItemLocalServiceUtil.updateSuburItem(suburItem, userId, serviceContext);
			ItemAuthorLocalServiceUtil.setItemAuthor(itemId, authorIds);
			
			if (Validator.isNotNull(sourceFile))
				attachItemFile(suburItem,file);
			setItemType(suburItem.getItemId(),uploadRequest);
			//addSubject(item.getItemId(), subjects);
			
		} catch (PortalException e) {
			//SessionErrors.add(request, e.getClass().getName());
			e.printStackTrace();
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
/**
 * editAuthor - Add/Edit author action request during item author 	
 * @param request
 * @param response
 * @throws PortalException
 * @throws SystemException
 */
	public void editAuthor(ActionRequest request,ActionResponse response)throws PortalException, SystemException
	{
		
		String cmd = ParamUtil.getString(request, "cmd");
		long authorId = ParamUtil.getLong(request, "authorId");
		Author author = null;
		if (cmd.equalsIgnoreCase(Constants.UPDATE))
			author = AuthorLocalServiceUtil.getAuthor(authorId);
		
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String remoteId = ParamUtil.getString(request, "remoteId");
		int idType = ParamUtil.getInteger(request, "idType");
		if (author == null)
		{
			authorId = AuthorLocalServiceUtil.addAuthor(firstName, lastName, remoteId, idType);
		}else
		{
			author.setFirstName(firstName);
			author.setLastName(lastName);
			AuthorLocalServiceUtil.updateAuthor(author);
		}
		
		long itemId = ParamUtil.getLong(request, "itemId");
		
		
		
		
	}
	public String fileUpload (RenderRequest request, RenderResponse response, PortletRequest portletRequest) {
			PortletSession portletSession = request.getPortletSession(false);
			long uploadFolderId = 0;
			long uploadedAttachmentId = 0;

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(portletRequest);

			String uploadFileName = uploadRequest.getFileName("fileUpload");
			File uploadFile = uploadRequest.getFile("fileUpload");

			ServiceContext serviceContext = null;
			try {
			serviceContext = ServiceContextFactory.getInstance(request);
			} catch (Exception e) {
			logger.error("Exception in fileUpload method");
			} 

	

			return "success";
			}
	
	
	private void addDivision(long itemId,long divisionId) throws SystemException
	{
		ItemDivisionLocalServiceUtil.addItemDivision(itemId, divisionId);
	}
	
	
	/* Add subject to the item
	 * subjects - comma separated subject id
	 * 
	 * 
	 */
	private void addSubject(long itemId,String subjects) throws SystemException, NumberFormatException, PortalException
	{
		ArrayList itemSubject = new ArrayList(Arrays.asList(subjects.split(","))); 
		ItemSubjectLocalServiceUtil.addItemSubject(itemId,itemSubject);
		
		
		
	}
	private void addAuthor(long itemId,UploadPortletRequest request,PortletResponse response) throws SystemException, NoSuchMetadataPropertyValueException
	{
		/* handle author */
		
		
		String authorIndexesString = ParamUtil.getString(request, "authorsIndexes");
		logger.info("author="+authorIndexesString);
		if (Validator.isNull(authorIndexesString)) {
			
			return;
		}
		Set<Long> authorEntryIds = new HashSet<Long>();
		int[] authorEntriesIndexes = StringUtil.split(
				authorIndexesString, 0);
		
		
		for (int authorEntriesIndex : authorEntriesIndexes)
		{
			long authorEntryId = ParamUtil.getLong(
					request, "authorEntryId" + authorEntriesIndex);
			String firstName = ParamUtil.getString(request, "firstName" + authorEntriesIndex);
			logger.info(firstName);
			
			String lastName = ParamUtil.getString(request, "lastName" + authorEntriesIndex);
			logger.info(lastName);
			
			if (authorEntryId <= 0)
			{
				MetadataPropertyValueLocalServiceUtil.addMetadataPropertyValue(itemId, 
						SuburConstant.METADATA_CONTRIBUTOR_AUTHOR, 
						SuburUtil.getName(firstName, lastName));
			}else
			{
				MetadataPropertyValueLocalServiceUtil.updateMetadataPropertyValue(authorEntryId, 
						itemId,SuburConstant.METADATA_CONTRIBUTOR_AUTHOR, 
						SuburUtil.getName(firstName, lastName));
			}
		}
		
		
		
	}
	private void setOtherTitle(long itemId,String otherTitle) throws SystemException
	{
		MetadataPropertyValueLocalServiceUtil.addMetadataPropertyValue(itemId, 
				SuburConstant.METADATA_OTHER_TITLE, 
				otherTitle);
	}
	private void setItemType(long itemId,UploadPortletRequest request) throws SystemException
	{
		
		String[] itemTypeStrings = ParamUtil.getParameterValues(request, "itemType");
		ItemItemTypeLocalServiceUtil.setItemItemType(itemId, itemTypeStrings);
		
	}
	private void attachItemFile(SuburItem item,File file) throws SystemException
	{
		long folderId = SuburFolderUtil.getFolderId(_request, themeDisplay);
		long fileEntryId = SuburFileUtil.addFile(_request, folderId, file,file.getName());
		long entryType = 0;
		ItemFileEntryLocalServiceUtil.add(item.getItemId(), fileEntryId, entryType);
		
		
	}
	
	private void depositItem(PortletRequest request)
	{
		//QueryParser queryParser = new QueryParser(FIELD_CONTENTS, new StandardAnalyzer());
	}
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException 
	{
		themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String resource = ParamUtil.getString(resourceRequest, "resource");
		
		PrintWriter out=resourceResponse.getWriter();
		//logger.info(resource);
		String resourceId = resourceRequest.getResourceID();
		logger.info(resourceId);
		if (Validator.equals(resourceId, SuburConstant.RESOURCE_AUTHOR_LOOKUP))
		{
			out.print(authorLookup(resourceRequest,resourceResponse));
		}
		/*
		if (Validator.equals(resourceId, SuburConstant.RESOURCE_ITEM_AUTHOR_LIST))
		{
			out.print(itemAuthorList(resourceRequest,resourceResponse));
		}
		*/
		
		if (Validator.equals(resourceId,SuburConstant.RESOURCE_UPLOAD_FILE))
		{
			JSONObject jSubject = JSONFactoryUtil.createJSONObject();
			try {
				long fileEntryId = uploadFile(resourceRequest,resourceResponse);
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId) ;
				
				jSubject.put("fileName", fileEntry.getTitle());// .getName());
				jSubject.put("fileSize", fileEntry.getSize());
				jSubject.put("fileId", fileEntry.getFileEntryId());
				jSubject.put("status","success");
			
			}catch (Exception e)
			{
				jSubject.put("status","failed");
			}
			out.print(jSubject.toString());
		}
		if (Validator.equals(resource,"depositableSubject"))
		{
			try {
				String jSubjects = SubjectLocalServiceUtil.getDepositableJson();
				out.print(jSubjects);
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if (Validator.equals(resource, "subject"))
		{
			long selectedSubject = ParamUtil.getLong(resourceRequest, "subjectId");
		}else if (Validator.equals(resource,"author"))
		{
			
		}
	
		
	}
	
	private String authorLookup(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
		//String<> x = resourceRequest.
		String keyword = ParamUtil.getString(resourceRequest, "keyword");
		
		
		
		
		long itemId = ParamUtil.getLong(resourceRequest, "itemId");
		logger.info("keywrd="+ keyword);
		JSONObject jsonCells = JSONFactoryUtil.createJSONObject();
		  jsonCells.put("key", "1");
          jsonCells.put("name", "New York, USA");
          jsonResults.put(jsonCells);
          jsonCells = JSONFactoryUtil.createJSONObject();
          jsonCells.put("key", "2");
          jsonCells.put("name", "Delhi, India");
          jsonResults.put(jsonCells);
          jsonCells = JSONFactoryUtil.createJSONObject();
          jsonCells.put("key", "3");
          jsonCells.put("name", "Hyderabad, India");
          jsonResults.put(jsonCells);
          
          return jsonResults.toString();
		
	}
	
	private long uploadFile(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException {
        UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
        File file = uploadRequest.getFile("myFile");
        String fileName = uploadRequest.getFileName("myFile");
        logger.info("filename="+file.getName()+ ":"+fileName);
        themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long folderId = SuburFolderUtil.getFolderId(resourceRequest, themeDisplay);
		long fileEntryId = SuburFileUtil.addFile(resourceRequest, folderId, file,fileName);
		long entryType = 0;
		
		return fileEntryId;
		
		//ItemFileEntryLocalServiceUtil.add(item.getItemId(), fileEntryId, entryType);
        
		/*
        
        String objFileName = uploadRequest.getFileName("myFile");
        _log.info("objFile: [" + objFile + "], objFileName: [" + objFileName + "]");        
        String uploadDirectory = "L:/myfiles/";

        File currentFile = new File(uploadDirectory);
        if (currentFile.exists()) {
            _log.info("Going to write the file contents");
            File newFile = new File(uploadDirectory + "/" + objFileName);
            OutputStream os = new FileOutputStream(newFile);
            InputStream is = new FileInputStream(objFile);
            
            byte[] buff = new byte[is.available()];
            is.read(buff);
            os.write(buff);
            is.close();
            os.close();
            
        }*/
    }
	public void METHODJAVANAMEManageForm(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException 
	{
	    List<FileEntry> tempFileEntrys = new ArrayList<FileEntry>();
	    try
	    {
	        ThemeDisplay themeDisplay  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	        //get selected checkbox of file to upload
	        String [] selectedFile = uploadRequest.getParameterValues("selectUploadedFileCheckbox");
	        if(selectedFile != null)
	        {
	            for(int i = 0; i < selectedFile.length; ++i)
	            {
	                FileEntry tmpfile = TempFileUtil.getTempFile(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), selectedFile[i], _TEMP_FOLDER_NAME_ATTACHMENT);
	                if(tmpfile!=null && tmpfile.getTitle()!=null && (!tmpfile.getTitle().equals("")))
	                {
	                    tempFileEntrys.add(tmpfile);
	                    System.out.println("file: " + tmpfile.getTitle());
	                }
	            }
	        }

	        /////upload tempFileEntrys where you needed
	        
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        //delete all tmp files uploaded in liferay tmp folder
	        for (FileEntry tmp : tempFileEntrys) 
	        {
	            try 
	            {
	                TempFileUtil.deleteTempFile(tmp.getFileEntryId());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    actionResponse.setRenderParameter("mvcPath","/jsp/viewList.jsp");
	}
	public void manageFileUpload(ActionRequest request,ActionResponse response) throws Exception
	{
		
		logger.info("manage file upload");
		
		//upload file in liferay tmp folder
	    UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	    long folderId = SuburFolderUtil.getFolderId(request, themeDisplay);// .xxx();  ParamUtil.getLong(uploadPortletRequest, "folderId");
	    String sourceFileName = uploadPortletRequest.getFileName("file");
	    long itemId=ParamUtil.getLong(request, "suburItemId");
	    logger.info("itemid="+itemId);
	    File file;
	    String title = sourceFileName;
	    String description = null;
	    String changeLog = StringPool.BLANK;
	    
	    InputStream inputStream = null;
	    
	    try 
	    {
	        inputStream = uploadPortletRequest.getFileAsStream("file");
	        file = uploadPortletRequest.getFile("file");
	        String mimeType = MimeTypesUtil.getContentType(file);
	        String contentType = uploadPortletRequest.getContentType("file");
	        FileEntry fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName, mimeType, title, description, changeLog, file,  new ServiceContext());
	        
	        long fileEntryId = fileEntry.getFileEntryId();
	        //attach uploaded file to item
	        ItemFileEntryLocalServiceUtil.add(itemId, fileEntryId, 0);
	        
	        
	        //DLAppServiceUtil.addTempFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName,_TEMP_FOLDER_NAME_ATTACHMENT, inputStream, contentType);
	        
	        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
	        jsonObject.put("name", sourceFileName);
	        jsonObject.put("title", sourceFileName);
	        writeJSON(request, response, jsonObject);
	    }
	    catch (Exception e)
	    {
	    	logger.error(e);
	    	UploadException uploadException =(UploadException)request.getAttribute(WebKeys.UPLOAD_EXCEPTION);
	        if ((uploadException != null) &&uploadException.isExceededSizeLimit()) 
	        {
	            throw new FileSizeException(uploadException.getCause());
	        }
	        else 
	        {
	            logger.error(e);
	        	throw e;
	        }
	    }
	    finally 
	    {
	        StreamUtil.cleanUp(inputStream);
	    }
	}
	public void deleteTempFile(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException 
	{
	    //delete file from liferay tmp folder, before uploaded
	    ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    long folderId = SuburFolderUtil.getFolderId(actionRequest, themeDisplay);
	    String fileName = ParamUtil.getString(actionRequest, "fileName");
	    long itemId = ParamUtil.getLong(actionRequest, "suburItemId");
	    
	    JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
	    try 
	    {
	    	FileEntry fileEntry = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName) ;
	    	
	    	ItemFileEntryLocalServiceUtil.delete(itemId,fileEntry.getFileEntryId());
	    	DLAppServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
	    	
	    	//DLAppServiceUtil.deleteFileEntryByTitle(themeDisplay.getScopeGroupId(), folderId, fileName);
	    	//DLAppServiceUtil.deleteTempFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName,_TEMP_FOLDER_NAME_ATTACHMENT);
	        jsonObject.put("deleted", Boolean.TRUE);
	    }
	    catch (Exception e) 
	    {
	        String errorMessage = themeDisplay.translate("an-unexpected-error-occurred-while-deleting-the-file");
	        jsonObject.put("deleted", Boolean.FALSE);
	        jsonObject.put("errorMessage", errorMessage);
	    }
	    writeJSON(actionRequest, actionResponse, jsonObject);
	}
	protected long[] getLongArray(PortletRequest portletRequest, String name) {
		String value = portletRequest.getParameter(name);

		if (value == null) {
			return null;
		}

		return StringUtil.split(GetterUtil.getString(value), 0L);
	}
	
}
