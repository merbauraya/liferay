package com.idetronic.tabview;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


import com.idetronic.eventview.EventViewConfig;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
/**
 * Portlet implementation class TabView
 */
public class TabView extends MVCPortlet {
 
	public void render(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
   
		TabViewConfig viewConfig = ConfigurationActionImpl.readConfig(request);
		request.setAttribute("config", (Object)(viewConfig));

		super.render(request, response);
	}
}
