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
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class EprintConfigAction extends DefaultConfigurationAction{
	static Log log = LogFactoryUtil.getLog(EprintConfigAction.class);
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		//super.processAction(portletConfig, actionRequest, actionResponse);
		PortletPreferences prefs = actionRequest.getPreferences();
		validateEprintURL(actionRequest);
		super.processAction(portletConfig, actionRequest, actionResponse);
		
		
	}
	protected void validateEprintURL(ActionRequest actionRequest)
	{
		String eprintURL  = getParameter(actionRequest,"eprintURL");
		
		if (Validator.isNull(eprintURL)){
			SessionErrors.add(actionRequest, "eprintURL");
			
		}else if (!Validator.isUrl(eprintURL))
		{
			SessionErrors.add(actionRequest, "eprintURL");
		}
	}
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		log.info("render");
		EprintConfig config = readConfig((PortletRequest)renderRequest);
		renderRequest.setAttribute("eprintConfig", (Object)(config));   
		return "/html/eprintview/config.jsp";
	}
	//obsolete
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
        String socialBookmarksDisplayStyle = prefs.getValue("socialBookmarksDisplayStyle", "simple");
        String socialBookmarksDisplayPosition = prefs.getValue("socialBookmarksDisplayPosition", "bottom");
        log.info("style="+socialBookmarksDisplayStyle);
        config.setEprintURL(prefs.getValue("eprintURL", ""));
        String enableBookmarks = prefs.getValue("enableSocialBookmarks", "false");
        
        config.setEnableSocialBookmarks(enableBookmarks == "true"?true:false);//
        config.setSocialBookmarksDisplayPosition(socialBookmarksDisplayPosition);
        config.setSocialBookmarksDisplayStyle(socialBookmarksDisplayStyle);
        return config;
	}
}
