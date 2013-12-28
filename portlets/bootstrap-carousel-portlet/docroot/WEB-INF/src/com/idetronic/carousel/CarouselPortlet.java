package com.idetronic.carousel;

import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.idetronic.carousel.model.*;
import com.idetronic.carousel.service.CarouselServiceImpl;
import com.idetronic.carousel.util.*;
import com.idetronic.carousel.util.CarouselConstants.CarouselType;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class Carousel
 */
public class CarouselPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog((Class)(CarouselPortlet.class));
	
	 public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
	        CarouselServiceImpl carouselService = new CarouselServiceImpl((PortletRequest)(renderRequest));
	        Carousel carousel = carouselService.createCarouselFromPreferences();
	        if (carousel != null) {
	            if (carousel.getCarouselType() == CarouselType.WEBCONTENT) {
	                List<WebContent> webContentList = carouselService.getWebContentList(carousel);
	                carouselService.sortWebContent(webContentList);
	                carousel.setWebContentList(webContentList);
	            }
	            renderRequest.setAttribute("carousel", (Object)(carousel));
	        }
	        super.doView(renderRequest, renderResponse);
	    }
/*
	    public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
	        Carousel carousel;
	        CarouselServiceImpl carouselService;
	        if ((SessionErrors.isEmpty((PortletRequest)(renderRequest))) && ((carousel = (carouselService = new CarouselServiceImpl((PortletRequest)(renderRequest))).createCarouselFromPreferences()) != null)) {
	            renderRequest.setAttribute("carousel", (Object)(carousel));
	        }
	        super.doEdit(renderRequest, renderResponse);
	    }
*/
	    @SuppressWarnings("unchecked")
		public void saveConfiguration(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	        CarouselServiceImpl carouselService = new CarouselServiceImpl((PortletRequest)(actionRequest));
	        Carousel carousel = carouselService.createCarouselFromRequest();
	        ArrayList errors = new ArrayList();
	        CarouselValidator validator = new CarouselValidator();
	        if (validator.validate(carousel, errors)) {
	            carouselService.saveCarouselPreferences(carousel);
	            actionRequest.setAttribute("SUCCESS_SAVED_PREFERENCES", (Object)(true));
	            SessionMessages.add((PortletRequest)(actionRequest), (String)((String.valueOf(actionResponse.getNamespace()) + ".doConfigure")));
	        } else {
	            for (Object error : errors) {
	                SessionErrors.add((PortletRequest)(actionRequest), (String)(error));
	            }
	            actionRequest.setAttribute("carousel", (Object)(carousel));
	            PortalUtil.copyRequestParameters((ActionRequest)(actionRequest), (ActionResponse)(actionResponse));
	            actionResponse.setRenderParameter("jspPage", "/html/carousel/config.jsp");
	        }
	    }



}
