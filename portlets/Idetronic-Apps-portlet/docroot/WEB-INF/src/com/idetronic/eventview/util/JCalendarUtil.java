package com.idetronic.eventview.util;

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class JCalendarUtil
{
  public static final long DAY = 86400000L;
  public static final long HOUR = 3600000L;
  public static final long MINUTE = 60000L;
  public static final long MONTH = 2592000000L;
  public static final long SECOND = 1000L;
  private static TimeZone _utcTimeZone = TimeZone.getTimeZone("UTC");

  public static long getDaysBetween(Calendar startTimeJCalendar, Calendar endTimeJCalendar)
  {
    startTimeJCalendar = toMidnightJCalendar(startTimeJCalendar);
    endTimeJCalendar = toMidnightJCalendar(endTimeJCalendar);

    long startTime = startTimeJCalendar.getTimeInMillis();
    long endTime = endTimeJCalendar.getTimeInMillis();

    return (endTime - startTime) / 86400000L;
  }

  public static Calendar getJCalendar(int year, int month, int day, int hour, int minutes, int seconds, int milliseconds, TimeZone timeZone)
  {
    Calendar jCalendar = CalendarFactoryUtil.getCalendar(timeZone);

    jCalendar.set(1, year);
    jCalendar.set(2, month);
    jCalendar.set(5, day);
    jCalendar.set(11, hour);
    jCalendar.set(12, minutes);
    jCalendar.set(13, seconds);
    jCalendar.set(14, milliseconds);

    return jCalendar;
  }

  public static Calendar getJCalendar(long time) {
    return getJCalendar(time, _utcTimeZone);
  }

  public static Calendar getJCalendar(long time, TimeZone timeZone) {
    Calendar jCalendar = CalendarFactoryUtil.getCalendar(timeZone);

    jCalendar.setTimeInMillis(time);

    return jCalendar;
  }

  public static int getTimeZoneOffset(TimeZone timeZone) {
    int offset = timeZone.getRawOffset();

    boolean inDaylightTime = timeZone.inDaylightTime(new Date());

    if (inDaylightTime) {
      offset += timeZone.getDSTSavings();
    }

    return offset;
  }

  public static Calendar toLastHourJCalendar(Calendar jCalendar) {
    Calendar lastHourJCalendar = (Calendar)jCalendar.clone();

    lastHourJCalendar.set(11, 23);
    lastHourJCalendar.set(12, 59);
    lastHourJCalendar.set(13, 59);
    lastHourJCalendar.set(14, 999);

    return lastHourJCalendar;
  }

  public static Calendar toMidnightJCalendar(Calendar jCalendar) {
    Calendar midnightJCalendar = (Calendar)jCalendar.clone();

    midnightJCalendar.set(11, 0);
    midnightJCalendar.set(12, 0);
    midnightJCalendar.set(13, 0);
    midnightJCalendar.set(14, 0);

    return midnightJCalendar;
  }
}