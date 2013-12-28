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

package com.slayer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LMSBookService}.
 * </p>
 *
 * @author    matle
 * @see       LMSBookService
 * @generated
 */
public class LMSBookServiceWrapper implements LMSBookService,
	ServiceWrapper<LMSBookService> {
	public LMSBookServiceWrapper(LMSBookService lmsBookService) {
		_lmsBookService = lmsBookService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lmsBookService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsBookService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lmsBookService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LMSBookService getWrappedLMSBookService() {
		return _lmsBookService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLMSBookService(LMSBookService lmsBookService) {
		_lmsBookService = lmsBookService;
	}

	public LMSBookService getWrappedService() {
		return _lmsBookService;
	}

	public void setWrappedService(LMSBookService lmsBookService) {
		_lmsBookService = lmsBookService;
	}

	private LMSBookService _lmsBookService;
}