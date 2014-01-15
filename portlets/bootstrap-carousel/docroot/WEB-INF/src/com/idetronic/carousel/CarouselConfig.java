package com.idetronic.carousel;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.idetronic.carousel.model.Carousel;
import com.idetronic.carousel.model.WebContent;
import com.idetronic.carousel.service.CarouselServiceImpl;
import com.idetronic.carousel.util.CarouselConstants.CarouselType;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class CarouselConfig implements ConfigurationAction {
	 static Log log = LogFactoryUtil.getLog(CarouselConfig.class);//  (LMSBookLocalServiceImpl.class);
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		  
	        String backgroundColor = ParamUtil.getString(actionRequest, "backgroundColor");
	        String height  = ParamUtil.getString(actionRequest, "height");
	        String tags = ParamUtil.getString(actionRequest, "assetTagNames");
	       
	        String portletResource = ParamUtil.getString(actionRequest,"portletResource");
	        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
	        String cssStyle = ParamUtil.getString(actionRequest, "cssStyle");
	        String carouselType = ParamUtil.getString(actionRequest,"carouselType");
	        preferences.setValue("backgroundColor", backgroundColor);
	        preferences.setValue("height", height);
	        preferences.setValue("tagName", tags);
	        preferences.setValue("cssStyle", cssStyle);
	        preferences.setValue("carouselType",carouselType);
	        preferences.store();
	 
	        PortletSession portletSession = actionRequest.getPortletSession();
	        SessionMessages.add(actionRequest, portletConfig.getPortletName()+ ".doConfigure");
		
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		
		CarouselServiceImpl carouselService = new CarouselServiceImpl((PortletRequest)(renderRequest));
        Carousel carousel = carouselService.createCarouselFromPreferences();
        if (carousel != null) {
            
            renderRequest.setAttribute("carousel", (Object)(carousel));
        }
        	
		return "/html/carousel/config.jsp";
	}

}
