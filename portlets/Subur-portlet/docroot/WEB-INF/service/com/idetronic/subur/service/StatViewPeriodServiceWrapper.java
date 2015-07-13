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

package com.idetronic.subur.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatViewPeriodService}.
 *
 * @author Mazlan Mat
 * @see StatViewPeriodService
 * @generated
 */
public class StatViewPeriodServiceWrapper implements StatViewPeriodService,
	ServiceWrapper<StatViewPeriodService> {
	public StatViewPeriodServiceWrapper(
		StatViewPeriodService statViewPeriodService) {
		_statViewPeriodService = statViewPeriodService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _statViewPeriodService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_statViewPeriodService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _statViewPeriodService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StatViewPeriodService getWrappedStatViewPeriodService() {
		return _statViewPeriodService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStatViewPeriodService(
		StatViewPeriodService statViewPeriodService) {
		_statViewPeriodService = statViewPeriodService;
	}

	@Override
	public StatViewPeriodService getWrappedService() {
		return _statViewPeriodService;
	}

	@Override
	public void setWrappedService(StatViewPeriodService statViewPeriodService) {
		_statViewPeriodService = statViewPeriodService;
	}

	private StatViewPeriodService _statViewPeriodService;
}