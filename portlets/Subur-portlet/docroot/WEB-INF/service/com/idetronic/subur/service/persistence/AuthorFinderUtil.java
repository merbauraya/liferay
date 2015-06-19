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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Mazlan Mat
 */
public class AuthorFinderUtil {
	public static java.util.List<com.idetronic.subur.model.Author> findByFirstName(
		java.lang.String[] keyword,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByFirstName(keyword, params, start, end, obc);
	}

	public static AuthorFinder getFinder() {
		if (_finder == null) {
			_finder = (AuthorFinder)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					AuthorFinder.class.getName());

			ReferenceRegistry.registerReference(AuthorFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AuthorFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AuthorFinderUtil.class, "_finder");
	}

	private static AuthorFinder _finder;
}