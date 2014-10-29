<%@ include file="/html/init.jsp" %>
<%@ page import="com.idetronic.eventview.util.EventViewUtil" %>
<%@ page import="com.idetronic.eventview.EventViewConfig" %>
<%@ page import="com.liferay.portlet.calendar.model.CalEvent" %>
<%@ page import="com.liferay.calendar.model.CalendarBooking" %>
<%@ page import="com.liferay.calendar.service.CalendarBookingLocalServiceUtil" %>
<%@ page import="com.idetronic.eventview.EventViewConstant" %>
<%@ page import="com.idetronic.eventview.workflow.CalendarBookingWorkflowConstants" %>

<%@ page import="com.idetronic.eventview.util.JCalendarUtil" %>
<%@ page import="com.liferay.portal.kernel.util.TimeZoneUtil" %>
<%@ page import="com.liferay.calendar.model.Calendar" %>
<%@ page import="com.liferay.portal.kernel.util.Time"%>
<%@ page import="com.liferay.calendar.model.CalendarResource" %>
<%@ page import="com.liferay.calendar.service.permission.CalendarPermission" %>

<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="java.util.GregorianCalendar"%>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatConstants" %>

<%
EventViewConfig viewConfig =(EventViewConfig) request.getAttribute("config");
TimeZone utcTimeZone = TimeZone.getTimeZone(StringPool.UTC);

Format dateFormatDate = FastDateFormatFactoryUtil.getTime(locale);
Format dateFormatLongDate = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.LONG, locale, timeZone);

Format dateFormatTime = null;
int viewType = viewConfig.getViewType();

String portletResource = ParamUtil.getString(renderRequest, (String)("portletResource"));
String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
String timeZoneId = user.getTimeZoneId();
TimeZone userTimeZone = TimeZone.getTimeZone(timeZoneId);
dateFormatTime = FastDateFormatFactoryUtil.getSimpleDateFormat("hh:mm a", locale, timeZone);
%>

<liferay-portlet:renderURL 
             portletName="<%=portletResource %>"
             windowState="<%=LiferayWindowState.POP_UP.toString() %>" 
              var="viewDetailURL"> 
               <portlet:param name="jspPage"
                  value="/html/eventview/detail.jsp" />
              <portlet:param name="nameSpace" value="<%=renderResponse.getNamespace() %>"/>
              <portlet:param name="currentURL" value="<%= currentURL%>" />
               <portlet:param name="groupId"
                  value="<%= String.valueOf(themeDisplay.getSiteGroupId()) %>" />
</liferay-portlet:renderURL>