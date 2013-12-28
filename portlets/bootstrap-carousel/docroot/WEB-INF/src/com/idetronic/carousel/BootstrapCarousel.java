package com.idetronic.carousel;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.idetronic.carousel.model.Carousel;
import com.idetronic.carousel.model.WebContent;
import com.idetronic.carousel.service.CarouselServiceImpl;
import com.idetronic.carousel.util.CarouselConstants.CarouselType;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BootstrapCarousel extends MVCPortlet{
	 static Log log = LogFactoryUtil.getLog(BootstrapCarousel.class);//  (LMSBookLocalServiceImpl.class);

	 public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
	     
		 CarouselServiceImpl carouselService = new CarouselServiceImpl((PortletRequest)(renderRequest));
	        Carousel carousel = carouselService.createCarouselFromPreferences();
	        if (carousel != null) {
	            if (carousel.getCarouselType() == CarouselType.WEBCONTENT) {
	                List<WebContent> webContentList = carouselService.getWebContentList(carousel);
	                carouselService.sortWebContent(webContentList);
	                carousel.setWebContentList(webContentList);
	                renderRequest.setAttribute("itemSize", webContentList.size());
	            }
	            renderRequest.setAttribute("carousel", (Object)(carousel));
	            
	        }
	        super.doView(renderRequest, renderResponse);
	        
	        	
	    }

}
