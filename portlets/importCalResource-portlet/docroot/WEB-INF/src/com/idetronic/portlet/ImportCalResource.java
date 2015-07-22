package com.idetronic.portlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.idetronic.service.FooLocalServiceUtil;
import com.idetronic.service.persistence.FooFinderUtil;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarResourceLocalServiceUtil;
import com.liferay.calendar.util.comparator.CalendarResourceNameComparator;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.comparator.UserFirstNameComparator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.User;

public class ImportCalResource extends MVCPortlet{
	private static Log logger = LogFactoryUtil.getLog(ImportCalResource.class);

	
	public void importCalResource(ActionRequest request,ActionResponse response) throws PortalException, SystemException, IOException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		logger.info("coid="+themeDisplay.getCompanyId());
		logger.info("cogroup="+themeDisplay.getCompanyGroupId());
		logger.info("scopegr="+themeDisplay.getScopeGroupId());
		long classNameId = PortalUtil.getClassNameId(CalendarResource.class);
		logger.info("clname="+classNameId);
		logger.info("def_del="+SearchContainer.DEFAULT_DELTA);
		CalendarResourceNameComparator xx = new CalendarResourceNameComparator();
		logger.info( xx.toString());
		int userCount = UserLocalServiceUtil.getCompanyUsersCount(themeDisplay.getCompanyId());
		logger.info("user count="+userCount);
		
		List<User> users = UserLocalServiceUtil.getGroupUsers(themeDisplay.getScopeGroupId());
		logger.info(users.size() + ":"+ themeDisplay.getScopeGroupId());
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				CalendarResource.class.getName(), request);
		
		String keywords = "izwa";
		
		String[] codes = CustomSQLUtil.keywords("");
		String[] names = CustomSQLUtil.keywords(keywords);
		String[] descriptions = CustomSQLUtil.keywords("", false);
		
		long[] groupIds = new long[]{themeDisplay.getCompanyGroupId(),
				themeDisplay.getScopeGroupId()
			};
		
		List<CalendarResource> calendarResources =
				FooLocalServiceUtil.doFindByC_G_C_C_N_D_A(
					themeDisplay.getCompanyId(),
					groupIds,
					new long[] {classNameId}, codes,names,descriptions, true, true, 0,
					SearchContainer.DEFAULT_DELTA,
					new CalendarResourceNameComparator(),false);
		
		logger.info(calendarResources.size());
		for (CalendarResource cr : calendarResources)
		{
			logger.info(cr.getName());
		}
		List<CalendarResource> cocalendarResources =
				FooLocalServiceUtil.doFindByC_G_C_C_N_D_A(
					themeDisplay.getCompanyId(),
					new long[] {themeDisplay.getCompanyGroupId()},
					new long[] {classNameId}, codes,names,descriptions, true, true, 0,
					SearchContainer.DEFAULT_DELTA,
					new CalendarResourceNameComparator(),false);
		for (CalendarResource cr : cocalendarResources)
		{
			logger.info(cr.getName());
		}
		
		String name = StringUtil.merge(
				CustomSQLUtil.keywords(keywords), StringPool.BLANK);

		LinkedHashMap<String, Object> params =
				new LinkedHashMap<String, Object>();

			params.put("usersGroups", themeDisplay.getUserId());
			long userClassNameId = PortalUtil.getClassNameId(User.class);

			List<User> xusers = UserLocalServiceUtil.search(
				themeDisplay.getCompanyId(), keywords, 0, null, 0,
				SearchContainer.DEFAULT_DELTA, new UserFirstNameComparator());
		
		
		for (User user : users)
		{
			logger.info(user.getFirstName());
		//	CalendarResource calResource = getUserCalendarResource(user.getUserId(),serviceContext);
		}
		
		
	}
	
	
	
	private CalendarResource getUserCalendarResource(
			long userId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long classNameId = PortalUtil.getClassNameId(User.class);

		CalendarResource calendarResource =
			CalendarResourceLocalServiceUtil.fetchCalendarResource(
				classNameId, userId);

		if (calendarResource != null) {
			return calendarResource;
		}

		User user = UserLocalServiceUtil.getUser(userId);

		Group userGroup = null;

		String userName = user.getFullName();

		if (user.isDefaultUser()) {
			userGroup = GroupLocalServiceUtil.getGroup(
				serviceContext.getCompanyId(), GroupConstants.GUEST);

			userName = GroupConstants.GUEST;
		}
		else {
			userGroup = GroupLocalServiceUtil.getUserGroup(
				serviceContext.getCompanyId(), userId);
		}

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), userName);

		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

		return CalendarResourceLocalServiceUtil.addCalendarResource(
			userId, userGroup.getGroupId(),
			PortalUtil.getClassNameId(User.class), userId, null, null, nameMap,
			descriptionMap, true, serviceContext);
	}
}
