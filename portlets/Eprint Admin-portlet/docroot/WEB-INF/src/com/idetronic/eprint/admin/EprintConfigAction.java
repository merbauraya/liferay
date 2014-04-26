package com.idetronic.eprint.admin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.idetronic.eprint.EprintConfig;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
public class EprintConfigAction implements ConfigurationAction{
	static Log log = LogFactoryUtil.getLog(EprintConfigAction.class);
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		long userId,companyId;  
		
		userId = 0;
		companyId = PortalUtil.getCompanyId(actionRequest);
        String useDefaultUser = ParamUtil.getString(actionRequest, "useDefaultUser");
        if (Validator.isNull(useDefaultUser))
        	log.info("useDefaultUser=null");
        else
        {
        	userId=UserLocalServiceUtil.getDefaultUserId(companyId);
        }
        log.info("usedefaultuser="+useDefaultUser+ userId);
        String eprintNewWindow = ParamUtil.getString(actionRequest, "eprintNewWindow");
        String showDepositDate  = ParamUtil.getString(actionRequest, "showDepositDate");
        String tags = ParamUtil.getString(actionRequest, "assetTagNames");
       
        String portletResource = ParamUtil.getString(actionRequest,"portletResource");
        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
     
        preferences.setValue("useDefaultUser", useDefaultUser);
        preferences.setValue("userId", String.valueOf(userId));
       
        preferences.store();
        
        PortletSession portletSession = actionRequest.getPortletSession();
        SessionMessages.add(actionRequest, portletConfig.getPortletName()+ ".doConfigure");
		
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		EprintAdminConfig config = readConfig((PortletRequest)renderRequest);
		renderRequest.setAttribute("eprintConfig", (Object)(config));   
		return "/html/eprint/config.jsp";
	}
	public static EprintAdminConfig readConfig(PortletRequest portletRequest)
	{
		EprintAdminConfig config = new EprintAdminConfig();
		
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
        String userId = prefs.getValue("userId", null);
        String useDefaultUser = prefs.getValue("useDefaultUser", null);
        boolean bUseDefaulteUser = Validator.isNull(useDefaultUser)? false:true;
        config.setUseDefaultUser(bUseDefaulteUser);
        if (Validator.isNotNull(userId))
        	config.setUserId(Long.valueOf(userId));
        //config.setUserId(Long.valueOf(prefs.getValue("userId", "")));
        return config;
	}

}
