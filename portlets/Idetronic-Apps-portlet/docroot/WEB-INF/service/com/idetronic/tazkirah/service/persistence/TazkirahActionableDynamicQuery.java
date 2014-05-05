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

package com.idetronic.tazkirah.service.persistence;

import com.idetronic.tazkirah.model.Tazkirah;
import com.idetronic.tazkirah.service.TazkirahLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Mazlan Mat
 * @generated
 */
public abstract class TazkirahActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public TazkirahActionableDynamicQuery() throws SystemException {
		setBaseLocalService(TazkirahLocalServiceUtil.getService());
		setClass(Tazkirah.class);

		setClassLoader(com.idetronic.tazkirah.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("tazkirahId");
	}
}