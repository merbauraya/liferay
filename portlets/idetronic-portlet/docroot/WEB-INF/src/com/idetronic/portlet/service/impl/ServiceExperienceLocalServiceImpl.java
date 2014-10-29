/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.portlet.service.impl;

import java.util.Date;
import java.util.List;

import com.idetronic.portlet.service.base.ServiceExperienceLocalServiceBaseImpl;
import com.idetronic.portlet.model.ServiceExperience;
import com.idetronic.portlet.service.impl.ServiceExperienceLocalServiceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the service experience local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.portlet.service.ServiceExperienceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.portlet.service.base.ServiceExperienceLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.ServiceExperienceLocalServiceUtil
 */
public class ServiceExperienceLocalServiceImpl
	extends ServiceExperienceLocalServiceBaseImpl {
	private static Log _log = LogFactoryUtil.getLog(ServiceExperienceLocalServiceImpl.class);
	public List<ServiceExperience> getUserServiceExperience(long userId) throws SystemException
	{
		return serviceExperiencePersistence.findBybyUserId(userId);
	}
	public int getUserServiceExperienceCount(long userId) throws SystemException
	{
		return serviceExperiencePersistence.countBybyUserId(userId);
	}
	public ServiceExperience addServiceExperience(
			long userId,String title,int startDateMonth,
			int startDateDay,int startDateYear,int endDateMonth,
			int endDateDay,int endDateYear, boolean current,String data)
		throws PortalException, SystemException {
		
		User user = userLocalService.getUserById(userId);
		Date startDate = PortalUtil.getDate(startDateMonth, startDateDay, startDateYear);//, user.getTimeZone(),
				//UserServiceStartDateException.class);
		Date endDate = null;
		
		
		if (!current) {
			endDate = PortalUtil.getDate(
				endDateMonth, endDateDay, endDateYear);//, user.getTimeZone(),
				//UserServiceEndDateException.class);
		}
		Date now = new Date();

		long serviceExperienceId = counterLocalService.increment();
		
		ServiceExperience serviceExperience = serviceExperiencePersistence.create(serviceExperienceId);
		serviceExperience.setCompanyId(user.getCompanyId());
		serviceExperience.setUserId(user.getUserId());
		serviceExperience.setUserName(user.getFullName());
		serviceExperience.setCreateDate(now);
		serviceExperience.setStartDate(startDate);
		serviceExperience.setEndDate(endDate);
		serviceExperience.setModifiedDate(now);
		serviceExperience.setTitle(title);
		serviceExperience.setServiceData(data);
		
		serviceExperiencePersistence.update(serviceExperience);
		
		return serviceExperience;
	}
	
	public ServiceExperience updateServiceExperience(long serviceExperienceId,
			String title,int startDateMonth,
			int startDateDay,int startDateYear,int endDateMonth,
			int endDateDay,int endDateYear,boolean current,
			String data) throws SystemException, PortalException
	{
		ServiceExperience serviceExperience = serviceExperiencePersistence.findByPrimaryKey(serviceExperienceId);
		
		User user = userLocalService.getUserById(serviceExperience.getUserId());
		
		Date startDate = PortalUtil.getDate(
				startDateMonth, startDateDay, startDateYear);//, user.getTimeZone(),
				//UserServiceStartDateException.class);
		
		
		Date endDate = null;

		if (!current) {
			endDate = PortalUtil.getDate(
				endDateMonth, endDateDay, endDateYear);//, user.getTimeZone(),
				//UserServiceEndDateException.class);
		}
		Date now = new Date();
		serviceExperience.setServiceData(data);
		serviceExperience.setModifiedDate(now);
		serviceExperience.setTitle(title);
		serviceExperience.setEndDate(endDate);
		serviceExperience.setStartDate(startDate);
		
		serviceExperiencePersistence.update(serviceExperience);
		return serviceExperience;
		
	}
}