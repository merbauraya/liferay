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
public class UserEntries_ExpertiseTagsFinderUtil {
	public static java.util.List getUserTags(long userId) {
		return getFinder().getUserTags(userId);
	}

	public static UserEntries_ExpertiseTagsFinder getFinder() {
		if (_finder == null) {
			_finder = (UserEntries_ExpertiseTagsFinder)PortletBeanLocatorUtil.locate(com.idetronic.portlet.service.ClpSerializer.getServletContextName(),
					UserEntries_ExpertiseTagsFinder.class.getName());

			ReferenceRegistry.registerReference(UserEntries_ExpertiseTagsFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(UserEntries_ExpertiseTagsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(UserEntries_ExpertiseTagsFinderUtil.class,
			"_finder");
	}

	private static UserEntries_ExpertiseTagsFinder _finder;
}