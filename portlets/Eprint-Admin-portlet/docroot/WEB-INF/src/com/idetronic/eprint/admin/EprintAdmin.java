package com.idetronic.eprint.admin;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.idetronic.eprint.admin.EprintHelper;
import com.idetronic.eprint.model.*;
/**
 * Portlet implementation class NewPortlet
 */
public class EprintAdmin extends MVCPortlet {
	static Log log = LogFactoryUtil.getLog(EprintAdmin.class);
	public void importRepository(ActionRequest actionRequest,
		    ActionResponse actionResponse)
		            throws IOException, PortletException { 
		
		String portletPath = getPortletContext().getRealPath("");;
		ServiceContext serviceContext = null;
		try {
            serviceContext = ServiceContextFactory.getInstance(
                            Eprint.class.getName(), actionRequest);
		}catch (Exception e)
		{
			log.error(e);
		}

		EprintHelper.importRepository(serviceContext,portletPath);
		//EprintHelper.generateEprintPage(portletPath);
		
	}
}
