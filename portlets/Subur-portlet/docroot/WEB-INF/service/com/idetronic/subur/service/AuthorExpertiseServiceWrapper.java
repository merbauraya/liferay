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
 * Provides a wrapper for {@link AuthorExpertiseService}.
 *
 * @author Mazlan Mat
 * @see AuthorExpertiseService
 * @generated
 */
public class AuthorExpertiseServiceWrapper implements AuthorExpertiseService,
	ServiceWrapper<AuthorExpertiseService> {
	public AuthorExpertiseServiceWrapper(
		AuthorExpertiseService authorExpertiseService) {
		_authorExpertiseService = authorExpertiseService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _authorExpertiseService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_authorExpertiseService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _authorExpertiseService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> getGroupExpertise(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseService.getGroupExpertise(groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AuthorExpertiseService getWrappedAuthorExpertiseService() {
		return _authorExpertiseService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAuthorExpertiseService(
		AuthorExpertiseService authorExpertiseService) {
		_authorExpertiseService = authorExpertiseService;
	}

	@Override
	public AuthorExpertiseService getWrappedService() {
		return _authorExpertiseService;
	}

	@Override
	public void setWrappedService(AuthorExpertiseService authorExpertiseService) {
		_authorExpertiseService = authorExpertiseService;
	}

	private AuthorExpertiseService _authorExpertiseService;
}