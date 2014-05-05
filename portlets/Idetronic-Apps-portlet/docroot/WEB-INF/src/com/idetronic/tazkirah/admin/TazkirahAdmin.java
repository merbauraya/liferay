package com.idetronic.tazkirah.admin;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.idetronic.tazkirah.service.TazkirahLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Admin
 */
public class TazkirahAdmin extends MVCPortlet {
	public void addEntry(ActionRequest request,ActionResponse response)  throws IOException, PortletException 
	{
		String category = ParamUtil.getString(request, "category");
		String content = ParamUtil.getString(request, "content");
		String title = ParamUtil.getString(request, "title");
		ThemeDisplay themeDisplay = 
			     (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
				
		TazkirahLocalServiceUtil.addEntry(title, content, category, themeDisplay.getUserId(), 
					themeDisplay.getUser().getFullName(), themeDisplay.getCompanyId(), 
					themeDisplay.getScopeGroupId() );
	}
	public void editEntry(ActionRequest request,ActionResponse response)  throws IOException, PortletException 
	{
		String category = ParamUtil.getString(request, "category");
		String content = ParamUtil.getString(request, "content");
		String title = ParamUtil.getString(request, "title");
		long tazkirahId = ParamUtil.getLong(request, "tazkirahId");
		ThemeDisplay themeDisplay = 
			     (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
				
		TazkirahLocalServiceUtil.updateEntry(tazkirahId, title, content, category, themeDisplay.getUserId(), 
				themeDisplay.getUser().getFullName(), themeDisplay.getCompanyId(), 
				themeDisplay.getScopeGroupId() );
				
	}
	
	public void deleteEntry(ActionRequest request,ActionResponse response)  throws IOException, PortletException 
	{
		long tazkirahId = ParamUtil.getLong(request, "tazkirahId");
		TazkirahLocalServiceUtil.deleteEntry(tazkirahId);
	}
 

}
