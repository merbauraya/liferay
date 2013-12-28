package com.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.omg.CORBA.Request;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class JasperAction
 */
public class JasperAction extends MVCPortlet {
	public void createUserReports(ActionRequest actionRequest, ActionResponse response)
	throws IOException, PortletException, PortalException, SystemException, JRException, SQLException {
		
		/*//PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest)).getS;
		UploadPortletRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
		File file=uploadRequest.getFile("file");
		JasperDesign jasperDesign = JRXmlLoader.load(file);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		
		Connection con=DataAccess.getConnection();
		JasperPrint print = JasperFillManager.fillReport(jasperReport, null, con);
		JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		StringBuffer stringBuffer=new StringBuffer();
		exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, stringBuffer);
		exporter.exportReport();
		String pdfApplicationFormName = "Test";
		response.setContentType("application/pdf");
		response.setProperty(HttpHeaders.CONTENT_DISPOSITION,"attachement;filename="+pdfApplicationFormName.replaceAll(" ", ""));
		OutputStream os = response.getPortletOutputStream();*/
		
		//System.out.println("user reportss;;==================="+uploadRequest.getFile("file"));
	}
	public void serveResource(ResourceRequest request, ResourceResponse response)
	throws PortletException, IOException {
		UploadPortletRequest uploadRequest=PortalUtil.getUploadPortletRequest(request);
		File file=uploadRequest.getFile("file");
		JasperDesign jasperDesign;
		Map parameters = new HashMap();
		parameters.put("ReportTitle", "Address Report");
		try {
			jasperDesign = JRXmlLoader.load(file);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			Connection con=DataAccess.getConnection();
			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, con);
			JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			//StringBuffer stringBuffer=new StringBuffer();
			OutputStream os = response.getPortletOutputStream();
			String pdfApplicationFormName = "Test";
			response.setContentType("application/pdf");
			response.setProperty(HttpHeaders.CONTENT_DISPOSITION,"attachement;filename="+pdfApplicationFormName.replaceAll(" ", ""));
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
			exporter.exportReport();
			os.flush();
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.serveResource(request, response);
	}
}
