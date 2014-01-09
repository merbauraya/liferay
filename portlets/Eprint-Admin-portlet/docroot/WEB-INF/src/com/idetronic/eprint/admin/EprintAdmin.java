package com.idetronic.eprint.admin;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.idetronic.eprint.admin.EprintHelper;
/**
 * Portlet implementation class NewPortlet
 */
public class EprintAdmin extends MVCPortlet {
	
	public void importRepository(ActionRequest actionRequest,
		    ActionResponse actionResponse)
		            throws IOException, PortletException { 
		
		EprintHelper.importRepository();
		
	}
}
