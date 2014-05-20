package com.idetronic.eventview;

import java.io.IOException;

import com.idetronic.eventview.ConfigurationActionImpl;
import com.idetronic.eventview.EventViewConfig;
import com.liferay.calendar.CalendarBookingDurationException;
import com.liferay.calendar.CalendarNameException;
import com.liferay.calendar.CalendarResourceCodeException;
import com.liferay.calendar.CalendarResourceNameException;
import com.liferay.calendar.DuplicateCalendarResourceException;
import com.liferay.calendar.NoSuchResourceException;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarBookingServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.service.CalendarNotificationTemplateServiceUtil;
import com.liferay.calendar.service.CalendarResourceServiceUtil;
import com.liferay.calendar.service.CalendarServiceUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


/**
 * Portlet implementation class EventView
 */
public class EventView extends MVCPortlet {
 
	public void invokeTransition(ActionRequest actionRequest, ActionResponse actionResponse)
		    throws Exception
		  {
		    long calendarBookingId = ParamUtil.getLong(
		      actionRequest, "calendarBookingId");

		    int status = ParamUtil.getInteger(actionRequest, "status");

		    ServiceContext serviceContext = ServiceContextFactory.getInstance(
		      CalendarBooking.class.getName(), actionRequest);

		    CalendarBookingServiceUtil.invokeTransition(
		      calendarBookingId, status, serviceContext);
		  }
	public void render(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
   
		EventViewConfig viewConfig = ConfigurationActionImpl.readConfig(request);
		request.setAttribute("config", (Object)(viewConfig));

		super.render(request, response);
	}
}
