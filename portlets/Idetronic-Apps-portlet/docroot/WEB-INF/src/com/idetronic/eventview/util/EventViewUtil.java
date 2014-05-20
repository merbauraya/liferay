package com.idetronic.eventview.util;

import java.text.Format;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;


import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.ClpSerializer;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.calendar.service.*;
import com.liferay.portlet.calendar.model.*;

public class EventViewUtil {
	private static Log log = LogFactoryUtil.getLog(EventViewUtil.class);
	public static String[] getEventType()
	{
		String eventTypes = PropsUtil.get("calendar.event.types");
		return eventTypes.split(",");
	
	}
	public static int getEventsCount(long groupId, String type)
	{
		try {
			return CalEventLocalServiceUtil.getEventsCount(groupId, type);
		} catch (SystemException e) {

			log.error(e);
			return -1;
		}
	}
	public static List<CalEvent> getEvents(TimeZone timeZone, Locale locale,long groupId,String type)
	{
		Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
		
		try {
			return CalEventLocalServiceUtil.getEvents(groupId, curCal,type);
		} catch (SystemException e) {

			log.error(e);
			return null;
		}
	}
	public static List<CalendarBooking> getCurrentMonthEvent(ThemeDisplay themeDisplay,boolean showPast)
	{
		//Format dateFormatDate = FastDateFormatConstants.LONG;
		List<CalEvent> lstEvents = new ArrayList<CalEvent>();
		TimeZone timeZone = themeDisplay.getTimeZone();
		Locale locale = themeDisplay.getLocale();
		java.util.Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
		
		int curDay = curCal.get(Calendar.DAY_OF_MONTH);
		int curMonth = curCal.get(Calendar.MONTH);
		int curYear = curCal.get(Calendar.YEAR);
		int maxDayOfMonth = curCal.getActualMaximum(Calendar.DATE);
		
		curCal.set(curYear, curMonth, 1);
		Date startDate = curCal.getTime();
		
		curCal.set(curYear, curMonth,maxDayOfMonth);
		Date endDate = curCal.getTime();

		return getEventFromDateRange(themeDisplay,startDate,endDate);
		
	}
	
	public static List<CalendarBooking> getUpComingEvent(ThemeDisplay themeDisplay, int maxItem,int maxDayToQuery)
	{
		java.util.Calendar curCal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
		Date startDate = new Date();
		curCal.setTime(startDate);
		curCal.add(Calendar.DATE, maxDayToQuery);
		
		
		//let's put approximate end date to satisfy maxItem
		
		Date endDate = curCal.getTime();
		
		List<CalendarBooking> bookings = getEventFromDateRange(themeDisplay,startDate,endDate);
		if (bookings.size() <= maxItem )
			return bookings;
		if (bookings.size() > maxItem)
		{
			for (int i = bookings.size();i > 0; i--)
			{
				if (i > maxItem)
					bookings.remove(i);
				else
					break;
			}
			
		}
		
		
		return bookings;
	}
	/*
	public static List<CalEvent> getUpComingEvent(ThemeDisplay themeDisplay,int rangeFromToday)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, rangeFromToday);
		
		Date endDate = cal.getTime();
		return getEventFromDateRange(themeDisplay,new Date(),endDate);
		
	}*/
	public static List<CalendarBooking> getEventFromDateRange(ThemeDisplay themeDisplay,Date startDate,Date endDate)
	{
		List<CalendarBooking> lstEvents = null;
		ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CalendarBooking.class,classLoader);//, portalClassLoader)
			//	                    .add(PropertyFactoryUtil.forName("startTime").le(endDate.getTime()))            
				//                    .addOrder(OrderFactoryUtil.desc("startTime"));
		
		
		
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		
		
		Criterion criterion = null;
		
		criterion = RestrictionsFactoryUtil.between("startTime",startDate.getTime(),endDate.getTime());
		Order defaultOrder = OrderFactoryUtil.asc("startTime");
		
		dynamicQuery.add(criterion);
		dynamicQuery.addOrder(defaultOrder);
		try {
			lstEvents = CalendarBookingLocalServiceUtil.dynamicQuery(dynamicQuery);
			
		} catch (SystemException e) {
		
			log.error(e);
		}
		
		return lstEvents;
	}

}
