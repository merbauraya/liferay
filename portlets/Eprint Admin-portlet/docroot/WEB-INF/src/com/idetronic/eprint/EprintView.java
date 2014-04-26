package com.idetronic.eprint;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.idetronic.eprint.admin.EprintHelper;
import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.service.EprintLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
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
    				
    				if (Validator.isNotNull(subjectId))
    				{
    					jsonResponse = EprintHelper.browseBySubjectIdJSON(subjectId, -1, -1);
    					
    				}
    				else
    				{
    					
    					jsonResponse = EprintHelper.getLatestEntry();
    				}
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
    	else
    	{
    		//not by subjectid
    		
    	}
    		
    		
    	
    	
    	
    	dispatcher.include(request, response);
    }
	public void updateEntry(ActionRequest request, ActionResponse response) throws Exception
	{
		String eprintId = request.getParameter("eprintId");
		String title = request.getParameter("title");
		String eprintAbstract = request.getParameter("abstract");
		String keywords = request.getParameter("keywords");
		Eprint eprint = EprintLocalServiceUtil.fetchEprint(Long.parseLong(eprintId));
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Eprint.class.getName(), request);
		
		String[] assetTagNames = StringUtil.split(request.getParameter("assetTagNames") , ",");	
		String assetLinkEntryIdsString = request.getParameter(
				"assetLinksSearchContainerPrimaryKeys");
		if (assetLinkEntryIdsString != null) {
			long[] assetLinkEntryIds = StringUtil.split(
				assetLinkEntryIdsString, 0L);

			serviceContext.setAssetLinkEntryIds(assetLinkEntryIds);
		}

		
		String[] relatedAssets = StringUtil.split(request.getParameter("assetLinksSearchContainerPrimaryKeys"),",")	;		
		long[] tid = new long[relatedAssets.length];
		for (int i=0;i < relatedAssets.length;i++)
			tid[i] = Long.parseLong(relatedAssets[i]);
		
		ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
			
		try {
			//AssetEntryLocalServiceUtil.updateEntry(td.getUserId(), td.getScopeGroupId(), 
				//									Eprint.class.getName(), 
					//								Long.valueOf(eprintId),null,assetTagNames);
			EprintLocalServiceUtil.modifyEprint(Long.valueOf(eprintId), title, eprintAbstract, 
					eprint.getEprintStatus(),eprint.getEprintType(),
					eprint.getMetadataVisibility(),keywords,
					eprint.getIsPublished(),
					eprint.getDateYear(),eprint.getFullTextStatus(),
					eprint.getCreatedDate(),eprint.getModifiedDate(),serviceContext);
					//fullTextStatus, createdDate, modifiedDate, serviceContext);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
											   
		
		
		
				
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
	private void browseByType(String Type)
	{
		
	}
	 public void render(RenderRequest request, RenderResponse response)
             throws PortletException, IOException {
    
		 EprintConfig config = EprintConfigAction.readConfig(request);
		 request.setAttribute("eprintConfig", (Object)(config));  
		 
		 super.render(request, response);
}


}
