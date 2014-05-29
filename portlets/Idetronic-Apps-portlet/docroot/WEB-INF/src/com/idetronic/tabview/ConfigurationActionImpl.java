package com.idetronic.tabview;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.blogs.service.permission.BlogsEntryPermission;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl implements ConfigurationAction {
	static Log log = LogFactoryUtil.getLog(ConfigurationActionImpl.class);
	
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
		
		String maxItem = ParamUtil.getString(actionRequest, "max");
		String organizationId = ParamUtil.getString(actionRequest, "organizationId");
		log.info(maxItem + "::"+ organizationId);
		/*String maxDaysToQuery = ParamUtil.getString(actionRequest, "maxDaysToQuery");
		String maxItemToDisplay = ParamUtil.getString(actionRequest, "maxItemToDisplay");
		String viewType = ParamUtil.getString(actionRequest, "viewType");
		String upcomingViewType = ParamUtil.getString(actionRequest, "upcomingViewType");
		*/
		/*
		config.setInternalTitle(prefs.getValue("internalTitle", StringPool.BLANK));
        config.setMaxDaysToQuery(prefs.getValue("maxDaysToQuery", "100"));
        config.setShowInternalTitle(prefs.getValue("showInternalTitle", "false"));
        config.setMaxItemToDisplay(prefs.getValue("maxItemToDisplay", "10"));
        config.setViewType(prefs.getValue("viewType", "1"));
		*/
		
		prefs.setValue("maxItem",maxItem);
		prefs.setValue("organizationId", organizationId);
		/*prefs.setValue("maxDaysToQuery", maxDaysToQuery);
		prefs.setValue("maxItemToDisplay", maxItemToDisplay);
		prefs.setValue("viewType", viewType);
		prefs.setValue("upcomingViewType", upcomingViewType); */
		
		prefs.store();
		PortletSession portletSession = actionRequest.getPortletSession();
	    SessionMessages.add(actionRequest, portletConfig.getPortletName()+ ".doConfigure");
	     
	}
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		TabViewConfig config = readConfig((PortletRequest)renderRequest);
		renderRequest.setAttribute("config", (Object)(config));   
		return "/html/tabview/config.jsp";
	}
	public static TabViewConfig readConfig(PortletRequest portletRequest)
	{
		TabViewConfig config = new TabViewConfig();
		
		PortletPreferences prefs = portletRequest.getPreferences();
        String portletResource = ParamUtil.getString((PortletRequest)(portletRequest), (String)("portletResource"));
        if (Validator.isNotNull((String)(portletResource))) {
            try {
                prefs = PortletPreferencesFactoryUtil.getPortletSetup((PortletRequest)(portletRequest), (String)(portletResource));
            }
            catch (Exception e) {
                log.error((Object)("Error getting portlet preferences"), (Throwable)(e));
            }
        }
        if (prefs == null) {
            log.error((Object)("Portlet preferences is null"));
            
            return config;
        }
        
        
        config.setMaxItem(Integer.valueOf(prefs.getValue("maxItem", "10")));
        config.setOrganizationId(Long.valueOf(prefs.getValue("organizationId", "0")));
       

        return config;
	}

}
