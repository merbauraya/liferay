package com.idetronic.eprint;
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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class EprintConfigAction implements ConfigurationAction{
	static Log log = LogFactoryUtil.getLog(EprintConfigAction.class);
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		  
        String eprintURL = ParamUtil.getString(actionRequest, "eprintURL");
        String eprintNewWindow = ParamUtil.getString(actionRequest, "eprintNewWindow");
        String showDepositDate  = ParamUtil.getString(actionRequest, "showDepositDate");
        String tags = ParamUtil.getString(actionRequest, "assetTagNames");
       
        String portletResource = ParamUtil.getString(actionRequest,"portletResource");
        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
        String cssStyle = ParamUtil.getString(actionRequest, "cssStyle");
        String carouselType = ParamUtil.getString(actionRequest,"carouselType");
        preferences.setValue("eprintURL", eprintURL);
        preferences.setValue("eprintNewWindow", eprintNewWindow);
        preferences.setValue("showDepositDate", showDepositDate);
        preferences.setValue("cssStyle", cssStyle);
        preferences.setValue("carouselType",carouselType);
        preferences.store();
        log.info(eprintURL);
        PortletSession portletSession = actionRequest.getPortletSession();
        SessionMessages.add(actionRequest, portletConfig.getPortletName()+ ".doConfigure");
		
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		EprintConfig config = readConfig((PortletRequest)renderRequest);
		renderRequest.setAttribute("eprintConfig", (Object)(config));   
		return "/html/eprintview/config.jsp";
	}
	public static EprintConfig readConfig(PortletRequest portletRequest)
	{
		EprintConfig config = new EprintConfig();
		
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
        config.setEprintURL(prefs.getValue("eprintURL", ""));
        return config;
	}
}
