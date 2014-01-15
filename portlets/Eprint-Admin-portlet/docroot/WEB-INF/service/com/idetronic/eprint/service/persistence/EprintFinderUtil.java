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

package com.idetronic.eprint.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author matle
 */
public class EprintFinderUtil {
	public static java.util.List<com.idetronic.eprint.model.Eprint> findBySubjectId(
		java.lang.String subjectId, int begin, int end) {
		return getFinder().findBySubjectId(subjectId, begin, end);
	}

	public static EprintFinder getFinder() {
		if (_finder == null) {
			_finder = (EprintFinder)PortletBeanLocatorUtil.locate(com.idetronic.eprint.service.ClpSerializer.getServletContextName(),
					EprintFinder.class.getName());

			ReferenceRegistry.registerReference(EprintFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(EprintFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EprintFinderUtil.class, "_finder");
	}

	private static EprintFinder _finder;
}