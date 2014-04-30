package com.idetronic.eprint.admin;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.idetronic.eprint.EprintConstant;
import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.service.EprintLocalServiceUtil;
import com.idetronic.eprint.service.EprintStaticContentLocalServiceUtil;
import com.idetronic.eprint.transform.XslContentTransformer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
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
			
			String defaultScopeId = PropsUtil.get("default.scope.group.id");
			
			long organisationId = OrganizationLocalServiceUtil.getOrganizationId(companyId, organisationName);//
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organisationId);
			long userId =Long.valueOf(PropsUtil.get("scheduled.default.user.id"));
		
			//log.info("orgid="+organisationId +"comp="+companyId);
			Group grp = GroupLocalServiceUtil.getCompanyGroup(companyId);
			//log.info(grp.getGroupId()+grp.getDescriptiveName());
			
			ServiceContext ctx = new ServiceContext();
			ctx.setCompanyId(companyId);
			ctx.setScopeGroupId(Long.valueOf(defaultScopeId));
			ctx.setUserId(userId);
		
			EprintHelper.importRepository(ctx);
		}catch (Exception e)
		{
			log.error(e);
		}
	}
	public void generateByTypeSummary() throws SystemException, ParserConfigurationException
	{
		List<Object> results = EprintLocalServiceUtil.byTypeSummary();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		Element root = doc.createElement("summary");
		
		
		
		long totalRow=0;
		for (Object obj: results) {
			 Element item = doc.createElement("item");
			 
			 Object row[] = (Object[]) obj;
			 String eType = (String)row[0];
			 long rowCount = Long.parseLong(row[1].toString());
			 totalRow += rowCount;
			 item.setAttribute("name", eType);
			 item.setAttribute("total", String.valueOf(rowCount));
			 root.appendChild(item);
		}
		
		XslContentTransformer transform = new XslContentTransformer(
				EprintConstant.XSL_BY_SUBJECT);
		
	
		
		
		
		String result="";
		EprintStaticContentLocalServiceUtil.addContent(EprintConstant.KEY_BY_EPRINT_TYPE, doc.toString());
		
	}
}
