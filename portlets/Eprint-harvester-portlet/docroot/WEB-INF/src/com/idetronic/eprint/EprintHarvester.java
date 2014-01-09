package com.idetronic.eprint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Collection;
import java.util.Map;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.sql.DataSource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.util.portlet.PortletProps;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EprintHarvester
 */
public class EprintHarvester extends MVCPortlet {
	static Log log = LogFactoryUtil.getLog(EprintHarvester.class);
	

    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException 
    {
    	log.info("serveResource");
    	PortletRequestDispatcher dispatcher = null;
    	dispatcher = getPortletContext().getRequestDispatcher(EprintConstant.PAGE_ENTRY_SUBJECT_ID);
    	dispatcher.include(request, response);
    }
	
	public void bySubject(ResourceRequest request, ResourceResponse response) throws PortletException, IOException 
	    {
		PortletRequestDispatcher dispatcher = null;
	    // ...
		 dispatcher = getPortletContext().getRequestDispatcher("/html/eprintharvester/bysubject.jsp");
	
	    }
	public void browseBySubject(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException 
	{
		
		Connection conn;
		long _companyId;
		long _organisationId;
		Organization organization = null;
		ResultSet rs = null;
		String realPath = getPortletContext().getRealPath("/");
		//_locale = LocaleUtil.getDefault();
		//Log log = LogFactoryUtil.getLog(SimsUser.class);//  (LMSBookLocalServiceImpl.class);
		String DATASOURCE_CONTEXT = "java:comp/env/jdbc/eprints";
		
		
			try {
				conn = DataAccess.getConnection("jdbc/eprints");
							
				buildSubjectPage(conn,realPath);
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				log.error(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
				
			}
		
		
		
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,
		                        themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		
		log.info("path"+realPath);
		actionRequest.setAttribute("rs", (Object)rs);
		actionResponse.setRenderParameter("jspPage", EprintConstant.PAGE_BY_SUBJECT);
	
		
	}

	private static void buildSubjectPage(Connection conn,String portletPath)
	{
		
		
		ResultSet rs = null;
		//ArrayList<String> data = new ArrayList<String>();
		HashMap data = new HashMap();
		Multimap<String, String> dataIndex = ArrayListMultimap.create();
		//String query = PortletProps.get(EprintConstant.KEY_BROWSE_BY_SUBJECT_SQL);
		String query = "( "+
				"select subjects as subjectid,parents as parentid,name_name as subjectname "+
				"from eprint_subjects eps,subject_parents a,subject_name_name b, eprint ep "+
				"where a.subjectid=b.subjectid "+
				"and ep.eprintid = eps.eprintid "+
				"and eps.subjects=a.subjectid "+
				"and ep.eprint_status='archive'  "+
				"and ep.metadata_visibility = 'show') "+
				"union "+
				"( "+
				"select c.subjectid as subjectid, c.parents as parentid, d.name_name as subjectname "+
				"from "+
				"eprint_subjects a ,subject_parents b,subject_parents c,subject_name_name d,eprint ep "+
				"where a.subjects = b.subjectid "+
				"and ep.eprintid = a.eprintid "+
				"and c.subjectid = b.parents "+
				"and d.subjectid = c.subjectid "+
				"and ep.eprint_status='archive' "+
				"and ep.metadata_visibility = 'show') "+
				"union "+
				"( "+
				"select d.subjectid as subjectid, d.parents as parentid, e.name_name as subjectname "+
				"from "+
				"subject_parents b,eprint_subjects a, "+
				"subject_parents c,subject_parents d, "+
				"subject_name_name e,eprint ep "+
				"where a.subjects = b.subjectid "+
				"and ep.eprintid = a.eprintid "+
				"and c.subjectid = b.parents "+
				"and d.subjectid = c.parents "+
				"and e.subjectid = d.subjectid "+
				"and ep.eprint_status='archive' "+
				"and ep.metadata_visibility = 'show' ) "+
				"union "+
				"( "+
				"select f.subjectid as subjectid, f.parents as parentid, e.name_name as subjectname "+
				"from "+
				"subject_parents b,eprint_subjects a, "+
				"subject_parents c,subject_parents d, "+
				"subject_name_name e,eprint ep, subject_parents f "+
				"where a.subjects = b.subjectid "+
				"and ep.eprintid = a.eprintid "+
				"and c.subjectid = b.parents "+
				"and d.subjectid = c.parents "+
				"and e.subjectid = f.subjectid "+
				"and ep.eprint_status='archive' "+
				"and ep.metadata_visibility = 'show' "+
				"and f.subjectid = d.parents) "+
				"order by subjectid ";

		Statement stmt = null;
		String dept;
		//Map<String, Collection<String>> dataIndex = new HashMap<String, Collection<String>>();	
	    try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(query);
	        
	        while (rs.next())
	        {
	        	
	        	
	        	ArrayList<String> record = new ArrayList<String>();
	        	String subjectId = rs.getString("subjectid");
	        	
	        	String parentId = rs.getString("parentid");
	        	
	        	record.add(subjectId);
	        	record.add(parentId);
	        	record.add(rs.getString("subjectname"));
	        	data.put(subjectId, record);
	        	dataIndex.put(parentId, subjectId);
	        	
	        	//data.addAll(record);
	        }
	      
	    } catch (java.sql.SQLException e ) {
	        log.error(e);
	        
	        
	    
	    } finally {
	    	DataAccess.cleanUp(rs);
	    	DataAccess.cleanUp(conn);
	    }
	    log.info("size="+dataIndex.size());
        EprintHelper.buildBrowseBySubject(data, dataIndex,portletPath);
        
	}

}
