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
public class ExpertiseFinderUtil {
	public static java.util.List<com.idetronic.subur.model.Expertise> filterFindByG_N(
		long[] groupIds, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().filterFindByG_N(groupIds, name, start, end, obc);
	}

	public static ExpertiseFinder getFinder() {
		if (_finder == null) {
			_finder = (ExpertiseFinder)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					ExpertiseFinder.class.getName());

			ReferenceRegistry.registerReference(ExpertiseFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ExpertiseFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ExpertiseFinderUtil.class, "_finder");
	}

	private static ExpertiseFinder _finder;
}