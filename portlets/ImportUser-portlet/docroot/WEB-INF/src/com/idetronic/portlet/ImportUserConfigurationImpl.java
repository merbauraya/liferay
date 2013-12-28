package com.idetronic.portlet;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ImportUserConfigurationImpl implements ConfigurationAction {
 
    public void processAction(PortletConfig portletConfig,
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
 
        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
 
        if (!cmd.equals(Constants.UPDATE)) {
            return;
        }
 
        String dbUrl = ParamUtil.getString(actionRequest, "dbUrl");
        String dbPassword = ParamUtil.getString(actionRequest, "dbPassword");
        String dbUser = ParamUtil.getString(actionRequest, "dbUser");
        String dbDriver = ParamUtil.getString(actionRequest, "dbDriver");
        String portletResource = ParamUtil.getString(actionRequest,"portletResource");
        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
 
        preferences.setValue("dbUrl", dbUrl);
        preferences.setValue("dbUser", dbUser);
        preferences.setValue("dbPassword", dbPassword);
        preferences.setValue("dbDriver", dbDriver);
 
        preferences.store();
 
        PortletSession portletSession = actionRequest.getPortletSession();
        SessionMessages.add(actionRequest, portletConfig.getPortletName()+ ".doConfigure");
 
    }
 
    public String render(PortletConfig portletConfig,
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws Exception {
    	
        return "/jsp/config.jsp";
    }

}
