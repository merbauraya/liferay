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

package com.idetronic.subur.service.persistence;

import com.idetronic.subur.model.ItemTypeTemplate;
import com.idetronic.subur.service.ItemTypeTemplateLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Mazlan Mat
 * @generated
 */
public abstract class ItemTypeTemplateActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ItemTypeTemplateActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ItemTypeTemplateLocalServiceUtil.getService());
		setClass(ItemTypeTemplate.class);

		setClassLoader(com.idetronic.subur.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.itemTypeId");
	}
}