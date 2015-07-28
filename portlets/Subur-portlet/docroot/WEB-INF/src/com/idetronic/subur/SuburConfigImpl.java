package com.idetronic.subur;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class SuburConfigImpl extends DefaultConfigurationAction  {
	static Log log = LogFactoryUtil.getLog(SuburConfigImpl.class);
	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");
		
		//PortletPreferences preferences = actionRequest.getPreferences();
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		
		
		
		String itemToShow = getParameter(actionRequest,"itemToShow");
		String displayStyle = getParameter(actionRequest,"displayStyle");
		String delta = getParameter(actionRequest,"delta");
		String paginationType = getParameter(actionRequest,"paginationType");
		String orderByColumn1 = getParameter(actionRequest,"orderByColumn1");
		String orderByType1 = getParameter(actionRequest,"orderByType1");
		String orderByColumn2 = getParameter(actionRequest,"orderByColumn2");
		String orderByType2 = getParameter(actionRequest,"orderByType2");
		String useOrOperatorCategorySearch = getParameter(actionRequest,"useOrOperatorCategorySearch");
		String useOrOperatorTagSearch = getParameter(actionRequest,"useOrOperatorTagSearch");
		String authorTitle = getParameter(actionRequest,"authorTitle");
		String authorSiteName = getParameter(actionRequest,"authorSiteName");
		String itemIdentifier = getParameter(actionRequest,"itemIdentifier");
		
		//rss related
		String enableRss = getParameter(actionRequest,"enableRss");
		String rssName = getParameter(actionRequest,"rssName");
		String rssDelta = getParameter(actionRequest,"rssDelta");
		String rssDisplayStyle = getParameter(actionRequest,"rssDisplayStyle");
		String rssFeedType = getParameter(actionRequest,"rssFeedType");
		
		preferences.setValue("itemToShow", itemToShow);
		preferences.setValue("displayStyle", displayStyle);
		preferences.setValue("delta", delta);
		preferences.setValue("paginationType", paginationType);
		preferences.setValue("orderByColumn1", orderByColumn1);
		preferences.setValue("orderByType1", orderByType1);
		preferences.setValue("orderByColumn2", orderByColumn2);
		preferences.setValue("orderByType2", orderByType2);
		preferences.setValue("useOrOperatorCategorySearch", useOrOperatorCategorySearch);
		preferences.setValue("useOrOperatorTagSearch", useOrOperatorTagSearch);
		preferences.setValue("authorTitle", authorTitle);
		preferences.setValue("authorSiteName", authorSiteName);
		preferences.setValue("itemIdentifier", itemIdentifier);
		
		preferences.setValue("enableRss", enableRss);
		preferences.setValue("rssName", rssName);
		preferences.setValue("rssDelta", rssDelta);
		preferences.setValue("rssDisplayStyle", rssDisplayStyle);
		preferences.setValue("rssFeedType", rssFeedType);
		
		preferences.store();
		super.processAction(
				portletConfig, actionRequest, actionResponse);
		
		
		
	}
	
	

}
