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

package com.idetronic.portlet.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Mazlan Mat
 */
public class OrgChartFinderUtil {
	public static java.util.List getUserTree(long userId) {
		return getFinder().getUserTree(userId);
	}

	public static OrgChartFinder getFinder() {
		if (_finder == null) {
			_finder = (OrgChartFinder)PortletBeanLocatorUtil.locate(com.idetronic.portlet.service.ClpSerializer.getServletContextName(),
					OrgChartFinder.class.getName());

			ReferenceRegistry.registerReference(OrgChartFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(OrgChartFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(OrgChartFinderUtil.class, "_finder");
	}

	private static OrgChartFinder _finder;
}