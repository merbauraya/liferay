package com.idetronic.tazkirah;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl implements ConfigurationAction {
	static Log log = LogFactoryUtil.getLog(ConfigurationActionImpl.class);
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
		
		String showTitle = ParamUtil.getString(actionRequest, "showTitle");
		String selectedCategory = ParamUtil.getString(actionRequest, "toList");
		String imageBackground = ParamUtil.getString(actionRequest, "bgImageId");
		
		prefs.setValue("showTitle",showTitle);
		prefs.setValue("selectedCategory", selectedCategory);
		prefs.setValue("imageBackgroundId", imageBackground);
		
		prefs.store();
		PortletSession portletSession = actionRequest.getPortletSession();
	    SessionMessages.add(actionRequest, portletConfig.getPortletName()+ ".doConfigure");
	     
	}
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		TazkirahConfig config = readConfig((PortletRequest)renderRequest);
		renderRequest.setAttribute("config", (Object)(config));   
		return "/html/tazkirah/view/config.jsp";
	}
	public static TazkirahConfig readConfig(PortletRequest portletRequest)
	{
		TazkirahConfig config = new TazkirahConfig();
		
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
        config.setShowTitle(prefs.getValue("showTitle", "false"));
        config.setSelectedCategory(prefs.getValue("selectedCategory", ""));
        String imageBg = prefs.getValue("imageBackgroundId", null);
        if (Validator.isNotNull(imageBg))
        	config.setBackgroundImageId(Long.valueOf(imageBg));
        return config;
	}

}
