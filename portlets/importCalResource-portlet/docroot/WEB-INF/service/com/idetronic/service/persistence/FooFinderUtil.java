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

package com.idetronic.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author matle
 */
public class FooFinderUtil {
	public static java.util.List<com.liferay.calendar.model.CalendarResource> doFindByC_G_C_C_N_D_A(
		long companyId, long[] groupIds, long[] classNameIds,
		java.lang.String[] codes, java.lang.String[] names,
		java.lang.String[] descriptions, boolean active, boolean andOperator,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator,
		boolean inlineSQLHelper)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .doFindByC_G_C_C_N_D_A(companyId, groupIds, classNameIds,
			codes, names, descriptions, active, andOperator, start, end,
			orderByComparator, inlineSQLHelper);
	}

	public static FooFinder getFinder() {
		if (_finder == null) {
			_finder = (FooFinder)PortletBeanLocatorUtil.locate(com.idetronic.service.ClpSerializer.getServletContextName(),
					FooFinder.class.getName());

			ReferenceRegistry.registerReference(FooFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(FooFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FooFinderUtil.class, "_finder");
	}

	private static FooFinder _finder;
}