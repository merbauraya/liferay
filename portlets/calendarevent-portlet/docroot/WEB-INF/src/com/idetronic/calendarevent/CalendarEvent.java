package com.idetronic.calendarevent;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequestDispatcher;

/**
 * Portlet implementation class CalendarEvent
 */
public class CalendarEvent extends MVCPortlet {
	String startDate;
	String endDate;
	boolean isAjax;
	protected String viewJSP;
	static Log log = LogFactoryUtil.getLog(com.idetronic.calendarevent.CalendarEvent.class);
	
	
	          
	
    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException 
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
    	PortletRequestDispatcher dispatcher = null;
    	List<CalEvent> lstEvents = null;
    	PortletPreferences pref = request.getPreferences();
    	EventDisplayModel evModel = CalendarHelper.createEventModel(pref);
    	startDate = request.getParameter("startDate");
		endDate = request.getParameter("endDate");
	
		isAjax = true;
		SimpleDateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dStartDate = df.parse(startDate);
			Date dEndDate   = df.parse(endDate);
		
			lstEvents = CalendarHelper.getEventFromDateRange(themeDisplay,dStartDate,dEndDate);
			
		} catch (ParseException e) {
			log.error(e);
		}
		
		request.setAttribute("lstEvents", lstEvents);
		request.setAttribute("evModel", evModel);
		 dispatcher = getPortletContext().getRequestDispatcher("/html/calendarevent/refreshEvent.jsp");
		 dispatcher.include(request, response);
		 isAjax = false;
	 }


	 public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException 
	 {
		 PortletPreferences pref = request.getPreferences();
		 EventDisplayModel evModel = CalendarHelper.createEventModel(pref);
		 
		 PortletRequestDispatcher dispatcher = null;
	
		dispatcher = getPortletContext().getRequestDispatcher("/html/calendarevent/view.jsp");
		request.setAttribute("evModel", evModel);
		
		 dispatcher.include(request, response);
		 
	 }
	
}
