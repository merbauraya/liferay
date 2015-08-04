package com.idetronic.subur;

import java.util.HashMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AuthorPortlet
 */
public class AuthorPortlet extends MVCPortlet {
	
	/**
	 * editAuthor - Add/Edit author action request during item author 	
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void editAuthor(ActionRequest request,ActionResponse response)throws PortalException, SystemException
	{
		
		logger.info("editauth");
		
		String cmd = ParamUtil.getString(request, "cmd");
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long authorId = ParamUtil.getLong(request, "authorId");
		Author author = null;
		if (cmd.equalsIgnoreCase(Constants.UPDATE))
			author = AuthorLocalServiceUtil.getAuthor(authorId);
		
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String middleName = ParamUtil.getString(request, "middleName");
		String remoteId = ParamUtil.getString(request, "remoteId");
		String title = ParamUtil.getString(request, "title");
		String categoryIds = ParamUtil.getString(request, "categoryIds");

		logger.info(categoryIds);
		String expertises = ParamUtil.getString(request, "expertiseNames");
		
		String[] expertiseNamesArr = null;
		if (!expertises.isEmpty())
		{
			expertiseNamesArr = expertises.split(",");
		}
		
		
		int idType = ParamUtil.getInteger(request, "idType");
		
		//handle Author Site
		String authorSiteIndexesString = request.getParameter(
				"authorSiteIndexes");
		
		
		HashMap<String, String> authorSite = new HashMap<>();
		int[] authorSiteIndexes = StringUtil.split(authorSiteIndexesString, 0);
		for (int authorSiteIndex : authorSiteIndexes) {
			
			long authorSiteId = ParamUtil.getLong(
					request, "authorSiteId" + authorSiteIndex);
			
			String authorSiteName = ParamUtil.getString(
					request, "siteName" + authorSiteIndex);
			
			String authorSiteURL = ParamUtil.getString(
					request, "siteURL" + authorSiteIndex);
			
			if (Validator.isNull(authorSiteURL))  {
				continue;
			}		
			logger.info(authorSiteName+"="+authorSiteURL);
			
			authorSite.put(authorSiteName, authorSiteURL);
			
			
			
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Author.class.getName(), request);
		
		
		long[] catIds = null;
		logger.info(categoryIds);
		if (!categoryIds.isEmpty())
		{
			String[] catIdsArr = categoryIds.split(",");
			catIds= new long[catIdsArr.length];
			for (int i = 0;i < catIdsArr.length; i++)
			{
				if (!catIdsArr[i].isEmpty())
					catIds[i] = Long.parseLong(catIdsArr[i]);
				
			}
		}
		
		serviceContext.setAssetCategoryIds(catIds);
		
		if (cmd.equalsIgnoreCase(Constants.ADD))
		{
			
			authorId = AuthorLocalServiceUtil.addAuthor(firstName, lastName,title, authorSite,
					remoteId, 
					idType, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), 
					themeDisplay.getUserId(),expertiseNamesArr,serviceContext);
			
			
		}else
		{
			 AuthorLocalServiceUtil.updateAuthor(authorId, title, 
					firstName, lastName, authorSite,
					remoteId, idType, 
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), 
					expertiseNamesArr,serviceContext);
			
			
		}
		
		long itemId = ParamUtil.getLong(request, "itemId");
		
		
		
		
	}
 
		private static Log logger = LogFactoryUtil.getLog(Subur.class);

}
