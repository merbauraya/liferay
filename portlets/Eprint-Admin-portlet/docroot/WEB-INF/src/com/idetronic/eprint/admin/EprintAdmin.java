package com.idetronic.eprint.admin;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceWrapper;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
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
		
		String portletPath = getPortletContext().getRealPath("");
		ServiceContext serviceContext = null;
		try {
            serviceContext = ServiceContextFactory.getInstance(
                            Eprint.class.getName(), actionRequest);
		}catch (Exception e)
		{
			log.error(e);
		}

		//EprintHelper.importRepository(serviceContext,portletPath);
		//EprintHelper.generateEprintPage(portletPath);
		try {
			jobImportRepository();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void jobImportRepository() 
	{
		//String portletPath = getPortletContext().getRealPath("");
		ServiceContext serviceContext = null;
		long companyId;
		try
		{
			Company company = CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil.get("default.web.id"));
			String organisationName = PropsUtil.get("user.default.orgname");
			companyId= company.getCompanyId();//  company.getGroup().getGroupId(); 
		
			long organisationId = OrganizationLocalServiceUtil.getOrganizationId(companyId, organisationName);//
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organisationId);
			long userId =Long.valueOf(PropsUtil.get("scheduled.default.user.id"));
		
			//log.info("orgid="+organisationId +"comp="+companyId);
			Group grp = GroupLocalServiceUtil.getCompanyGroup(companyId);
			//log.info(grp.getGroupId()+grp.getDescriptiveName());
			
			ServiceContext ctx = new ServiceContext();
			ctx.setCompanyId(companyId);
			ctx.setScopeGroupId(grp.getGroupId());
			ctx.setUserId(userId);
		
			EprintHelper.importRepository(ctx);
		}catch (Exception e)
		{
			log.error(e);
		}
	}
}
