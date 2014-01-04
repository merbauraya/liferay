package com.idetronic.calendarevent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

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
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.calendar.service.*;
import com.liferay.portlet.calendar.model.*;

public class CalendarHelper {
	private static Log _log = LogFactoryUtil.getLog(CalendarHelper.class);
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
			// TODO Auto-generated catch block
			_log.error(e);
			return -1;
		}
	}
	public static List<CalEvent> getEvents(TimeZone timeZone, Locale locale,long groupId,String type)
	{
		Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
		
		try {
			return CalEventLocalServiceUtil.getEvents(groupId, curCal,type);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error(e);
			return null;
		}
	}
	public static List<CalEvent> getMonthEvent(ThemeDisplay themeDisplay)
	{
		List<CalEvent> lstEvents = new ArrayList<CalEvent>();
		TimeZone timeZone = themeDisplay.getTimeZone();
		Locale locale = themeDisplay.getLocale();
		java.util.Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);

		int curDay = curCal.get(Calendar.DAY_OF_MONTH);
		int curMonth = curCal.get(Calendar.MONTH);
		int curYear = curCal.get(Calendar.YEAR);
		int maxDayOfMonth = curCal.getActualMaximum(Calendar.DATE);
		
		
		GregorianCalendar gregCal = new GregorianCalendar();
		gregCal.set(Calendar.MONTH, curMonth);
		gregCal.set(Calendar.YEAR, curYear);
		
		try {
			for (int i=1;i < maxDayOfMonth; i++)
			{
				List<CalEvent> tempEvents = new ArrayList<CalEvent>();
				gregCal.set(Calendar.DATE, i);
				tempEvents.addAll(CalEventServiceUtil.getEvents(themeDisplay.getScopeGroupId(), gregCal, new String()));
				lstEvents.addAll(tempEvents);
			}
			return lstEvents;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			_log.error(e);
			return null;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error(e);
			return null;
		}
	}
	public static List<CalEvent> getEventFromDateRange(ThemeDisplay themeDisplay,Date startDate,Date endDate)
	{
		List<CalEvent> lstEvents = null;
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CalEvent.class);
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		
		
		Criterion criterion = null;
		
		criterion = RestrictionsFactoryUtil.between("startDate",startDate,endDate);
		Order defaultOrder = OrderFactoryUtil.desc("startDate");

		dynamicQuery.add(criterion);
		dynamicQuery.addOrder(defaultOrder);
		try {
			lstEvents = CalEventLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			
			_log.error(e);
		}
		
		

		
		return lstEvents;
	}


}
