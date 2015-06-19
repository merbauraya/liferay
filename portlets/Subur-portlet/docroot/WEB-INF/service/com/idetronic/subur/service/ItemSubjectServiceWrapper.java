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
 * Provides a wrapper for {@link ItemSubjectService}.
 *
 * @author Mazlan Mat
 * @see ItemSubjectService
 * @generated
 */
public class ItemSubjectServiceWrapper implements ItemSubjectService,
	ServiceWrapper<ItemSubjectService> {
	public ItemSubjectServiceWrapper(ItemSubjectService itemSubjectService) {
		_itemSubjectService = itemSubjectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemSubjectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemSubjectService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemSubjectService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemSubjectService getWrappedItemSubjectService() {
		return _itemSubjectService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemSubjectService(
		ItemSubjectService itemSubjectService) {
		_itemSubjectService = itemSubjectService;
	}

	@Override
	public ItemSubjectService getWrappedService() {
		return _itemSubjectService;
	}

	@Override
	public void setWrappedService(ItemSubjectService itemSubjectService) {
		_itemSubjectService = itemSubjectService;
	}

	private ItemSubjectService _itemSubjectService;
}