package com.idetronic.subur;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class AuthorConfigImpl extends DefaultConfigurationAction{
	
	static Log log = LogFactoryUtil.getLog(AuthorConfigImpl.class);

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");
		
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		
		String authorSalutation = getParameter(actionRequest,"authorSalutation");
		String authorSiteName = getParameter(actionRequest,"authorSiteName");
		
		
		//author categorization
		
		String categorizationString = actionRequest.getParameter("authorCategoryIndexes");
		log.info("xx="+categorizationString );
		
		int[] categorizationIndexes = StringUtil.split(categorizationString, 0);

		
		
		Map<String,Long> categoryMap = new HashMap<String,Long>();
		for (int categoryIndex : categorizationIndexes)
		{
			String categoryName = ParamUtil.getString(actionRequest, "categoryName"+categoryIndex);
			long vocabularyId = ParamUtil.getLong(actionRequest, "vocabulary"+categoryIndex);
			log.info(categoryName + ":"+ vocabularyId);
			categoryMap.put(categoryName, vocabularyId);
			
			
		}
		String categoryXML = com.idetronic.subur.util.AuthorUtil.getAuthorCategoryString(categoryMap);
		preferences.setValue("authorCategory", categoryXML);
		preferences.setValue("authorSalutation", authorSalutation);
		preferences.setValue("authorSiteName", authorSiteName);
		
		preferences.store();
		super.processAction(
				portletConfig, actionRequest, actionResponse);
		
	}

}
