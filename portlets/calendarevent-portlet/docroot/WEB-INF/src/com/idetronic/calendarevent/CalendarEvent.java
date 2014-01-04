package com.idetronic.calendarevent;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
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
	static Log log = LogFactoryUtil.getLog(com.idetronic.calendarevent.CalendarEvent.class);//  (LMSBookLocalServiceImpl.class);

	
	/*
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
    	isAjax = false;
    	log.info("in processAction ");
    }*/
    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException 
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
    	PortletRequestDispatcher dispatcher = null;
    	List<CalEvent> lstEvents = null;
    	
    	startDate = request.getParameter("startDate");
		endDate = request.getParameter("endDate");
		log.info("st="+ startDate + " end="+ endDate);
		isAjax = true;
		SimpleDateFormat df = new  SimpleDateFormat("yyyy-mm-dd");
		try {
			Date dStartDate = df.parse(startDate);
			Date dEndDate   = df.parse(endDate);
			lstEvents = CalendarHelper.getEventFromDateRange(themeDisplay,dStartDate,dEndDate);
			
		} catch (ParseException e) {
			log.error(e);
		}
		
		request.setAttribute("lstEvents", lstEvents);
		
		
		
		
		 log.info("in refreshEvent ");
		 dispatcher = getPortletContext().getRequestDispatcher("/html/calendarevent/refreshEvent.jsp");
		 dispatcher.include(request, response);
		 isAjax = false;
	 }

    
/*	 public void refreshEvent(ActionRequest request, ActionResponse response) throws PortletException, IOException 
	 {

		 startDate = request.getParameter("startDate");
		 endDate = request.getParameter("endDate");
		 isAjax = true;
		 log.info("in refreshEvent ");
	 }*/
	 public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException 
	 {
		 response.setContentType("text/html");
		 log.info("in diview ");
		 PortletRequestDispatcher dispatcher = null;
		 //if (isAjax){
			// dispatcher = getPortletContext().getRequestDispatcher("/html/calendarevent/refreshEvent.jsp");
		 //}
		 	// else
		 //{
			 dispatcher = getPortletContext().getRequestDispatcher("/html/calendarevent/view.jsp");
			 
		 //}
		 dispatcher.include(request, response);
		 
	 }
	
}
