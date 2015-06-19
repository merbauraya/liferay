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
 * Provides a wrapper for {@link ItemFileEntryService}.
 *
 * @author Mazlan Mat
 * @see ItemFileEntryService
 * @generated
 */
public class ItemFileEntryServiceWrapper implements ItemFileEntryService,
	ServiceWrapper<ItemFileEntryService> {
	public ItemFileEntryServiceWrapper(
		ItemFileEntryService itemFileEntryService) {
		_itemFileEntryService = itemFileEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemFileEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemFileEntryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemFileEntryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemFileEntryService getWrappedItemFileEntryService() {
		return _itemFileEntryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemFileEntryService(
		ItemFileEntryService itemFileEntryService) {
		_itemFileEntryService = itemFileEntryService;
	}

	@Override
	public ItemFileEntryService getWrappedService() {
		return _itemFileEntryService;
	}

	@Override
	public void setWrappedService(ItemFileEntryService itemFileEntryService) {
		_itemFileEntryService = itemFileEntryService;
	}

	private ItemFileEntryService _itemFileEntryService;
}