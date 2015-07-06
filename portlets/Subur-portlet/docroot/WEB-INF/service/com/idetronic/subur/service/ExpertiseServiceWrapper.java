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
 * Provides a wrapper for {@link ExpertiseService}.
 *
 * @author Mazlan Mat
 * @see ExpertiseService
 * @generated
 */
public class ExpertiseServiceWrapper implements ExpertiseService,
	ServiceWrapper<ExpertiseService> {
	public ExpertiseServiceWrapper(ExpertiseService expertiseService) {
		_expertiseService = expertiseService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _expertiseService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_expertiseService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _expertiseService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Expertise> getGroupExpertises(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseService.getGroupExpertises(groupIds);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Expertise> getGroupExpertises(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseService.getGroupExpertises(groupId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray search(long[] groupIds,
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseService.search(groupIds, name, start, end);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray search(long groupId,
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseService.search(groupId, name, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ExpertiseService getWrappedExpertiseService() {
		return _expertiseService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedExpertiseService(ExpertiseService expertiseService) {
		_expertiseService = expertiseService;
	}

	@Override
	public ExpertiseService getWrappedService() {
		return _expertiseService;
	}

	@Override
	public void setWrappedService(ExpertiseService expertiseService) {
		_expertiseService = expertiseService;
	}

	private ExpertiseService _expertiseService;
}