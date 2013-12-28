/**
 * 
 *
 * @author Mazlan Mat
 *
 */

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
 

public class ConfigurationActionImpl implements ConfigurationAction {
 
    public void processAction(PortletConfig portletConfig,
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
 
        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
 
        if (!cmd.equals(Constants.UPDATE)) {
            return;
        }
 
        String listRecordUrl = ParamUtil.getString(actionRequest, "listrecord");
        String listSet = ParamUtil.getString(actionRequest, "listset");
        String xslUrl = ParamUtil.getString(actionRequest, "xsl");
        String eprintURL = ParamUtil.getString(actionRequest, "eprintURL");
        String portletResource = ParamUtil.getString(actionRequest,"portletResource");
        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
 
        preferences.setValue("eprintURL", eprintURL);
        preferences.setValue("listrecord", listRecordUrl);
        preferences.setValue("listset", listSet);
        preferences.setValue("xsl", xslUrl);
 
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
