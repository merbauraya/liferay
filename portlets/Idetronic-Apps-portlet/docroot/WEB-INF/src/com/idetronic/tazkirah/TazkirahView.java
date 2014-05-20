package com.idetronic.tazkirah;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.idetronic.tazkirah.model.Tazkirah;
import com.idetronic.tazkirah.TazkirahConfig;
import com.idetronic.tazkirah.service.TazkirahLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Tazkirah
 */
public class TazkirahView extends MVCPortlet {
	
	
	public void render(RenderRequest request, RenderResponse response)
	             throws PortletException, IOException {
	    
		TazkirahConfig tazkirahConfig= ConfigurationActionImpl.readConfig(request);
		request.setAttribute("tazkirahConfig", (Object)(tazkirahConfig));

		super.render(request, response);
	}
 

}
