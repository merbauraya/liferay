package com.idetronic.eprint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.idetronic.eprint.admin.EprintHelper;
import com.idetronic.eprint.model.Eprint;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EprintView
 */
public class EprintView extends MVCPortlet {
static Log log = LogFactoryUtil.getLog(EprintView.class);
	

    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException 
    {
    	List<Eprint> eprints = null;
    	PortletRequestDispatcher dispatcher = null;
    	String resourceType = request.getParameter("resType");
    	String subjectId = request.getParameter("subjectId");
    	request.setAttribute("subjectId", subjectId);
    	String reqFormat = request.getParameter("reqFormat");
    	String dataFormat = request.getParameter("dataFormat");
    	String subjectName = request.getParameter("subjectName");
    	request.setAttribute("subjectName", subjectName);
    	
    	JSONArray jsonResponse;
    
    	if (Validator.equals(resourceType, "bySubjectId"))
    	{
    		if (Validator.equals(reqFormat, "json")){
    			
    			if (Validator.equals(dataFormat, "json")){
    				jsonResponse = EprintHelper.browseBySubjectIdJSON(subjectId, -1, -1);
    				request.setAttribute("jsonResponse", jsonResponse);
    				dispatcher = getPortletContext().getRequestDispatcher(EprintConstant.PAGE_ENTRY_SUBJECT_ID_DATATABLE_JSON);
        			
    			}
    			else
    			{	
    				dispatcher = getPortletContext().getRequestDispatcher(EprintConstant.PAGE_ENTRY_SUBJECT_ID_DATATABLE);
    			}
        	}
        	else{
        		eprints= EprintHelper.browseBySubjectId(subjectId, -1, -1);
        		request.setAttribute("eprints", eprints);
        		dispatcher = getPortletContext().getRequestDispatcher(EprintConstant.PAGE_ENTRY_SUBJECT_ID);
            	
        	}
    		
    	}
    		
    		
    	
    	
    	
    	dispatcher.include(request, response);
    }
	
	public void bySubject(ResourceRequest request, ResourceResponse response) throws PortletException, IOException 
	    {
		PortletRequestDispatcher dispatcher = null;
	    // ...
		
		dispatcher = getPortletContext().getRequestDispatcher("/html/eprintview/bysubject.jsp");
	
	    }
	public void browseBySubject(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException 
	{
		
	
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,
		//                        themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		
	
		log.info("browsebysubject");
		
		actionResponse.setRenderParameter("jspPage", EprintConstant.PAGE_BY_SUBJECT);
	
		
	}
	 public void render(RenderRequest request, RenderResponse response)
             throws PortletException, IOException {
    
		 EprintConfig config = EprintConfigAction.readConfig(request);
		 request.setAttribute("eprintConfig", (Object)(config));  
		 
		 super.render(request, response);
}


}
