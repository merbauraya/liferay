package com.idetronic.tazkirah;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.idetronic.tazkirah.model.Tazkirah;
import com.idetronic.tazkirah.service.TazkirahLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Tazkirah
 */
public class TazkirahView extends MVCPortlet {
	
	
	 public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		 //read params
	 
		 super.doView(renderRequest, renderResponse);
	 }
	 
 

}
