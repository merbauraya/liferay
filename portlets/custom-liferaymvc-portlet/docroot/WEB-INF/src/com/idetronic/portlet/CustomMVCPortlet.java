package com.idetronic.portlet;

import java.io.IOException;
import java.net.URL;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CustomMVCPortlet extends MVCPortlet {

	//Default Render Method.
	private String ePrintURL;
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		this.readConfig();
	/*	String renderAction = renderRequest.getParameter("action");
		String verb = renderRequest.getParameter("verb");
		String metadataPrefix = renderRequest.getParameter("metadataPrefix");
		String set = renderRequest.getParameter("set");
		
		String content = "";
		if (renderAction == null)
			content = "Please select";
		
		if (renderAction != null && renderAction.equalsIgnoreCase("listrecord"))
		{
			eprintURL += "&verb=ListRecords&metadataPrefix=oai_dc";
		}
		
		renderRequest.setAttribute("content", content);*/
		//renderRequest.setAttribute("action", "view");
		super.doView(renderRequest, renderResponse);
	}
	private void readConfig()
	{
		
	}
	@ProcessAction(name="addName")
	public void addName(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException{
		String userName = ParamUtil.get(actionRequest, "userName", StringPool.BLANK);
		actionRequest.setAttribute("userName", userName);
	}
	@ProcessAction(name="listSet")
	public void listSet(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException{
		String userName = ParamUtil.get(actionRequest, "userName", StringPool.BLANK);
		actionRequest.setAttribute("userName", userName);
		
			
	}
	@ProcessAction(name="listRecord")
	public void listRecord(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException{
		
		String portletInstanceId = (String) renderRequest.getAttribute(WebKeys.PORTLET_ID);

		//javax.portlet.PortletPreferences config = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletInstanceId);

	
		//String userName = ParamUtil.get(actionRequest, "userName", StringPool.BLANK);
		
		//URL url = new URL("http://www.google.com");
		//renderRequest.setAttribute("action", "listRecord");
		//nderRequest.setAttribute("content", url.getContent());
		
		
	}
	
}
