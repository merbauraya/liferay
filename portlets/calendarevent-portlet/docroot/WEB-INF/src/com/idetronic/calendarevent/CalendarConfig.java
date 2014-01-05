package com.idetronic.calendarevent;

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

public class CalendarConfig implements ConfigurationAction {
	 static Log log = LogFactoryUtil.getLog(CalendarConfig.class);//  (LMSBookLocalServiceImpl.class);
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		   
	 
	  
		   
		   	String portletResource = ParamUtil.getString(actionRequest,"portletResource");
	        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
	        
			
	        String maxAllEventDisplay = ParamUtil.getString(actionRequest, "maxAllEventDisplay");
	        String maxEventDisplay  = ParamUtil.getString(actionRequest, "maxEventDisplay");
	        String showEmptyEventType = ParamUtil.getString(actionRequest, "showEmptyEventType");
	        
	        preferences.setValue("maxAllEventDisplay", maxAllEventDisplay);
	        preferences.setValue("maxEventDisplay", maxEventDisplay);
	        preferences.setValue("showEmptyEventType", showEmptyEventType);
	      
	        preferences.store();
	 
	        PortletSession portletSession = actionRequest.getPortletSession();
	        SessionMessages.add(actionRequest, portletConfig.getPortletName()+ ".doConfigure");
		
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		PortletPreferences pref = renderRequest.getPreferences();
		EventDisplayModel evModel = CalendarHelper.createEventModel(pref);
	
       	renderRequest.setAttribute("evModel", (Object) (evModel));
		return "/html/calendarevent/config.jsp";
	}
	

}