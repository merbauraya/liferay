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
public class SuburItemFinderUtil {
	public static java.util.List getItemTypes(long itemId) {
		return getFinder().getItemTypes(itemId);
	}

	public static java.util.List getItemDetails(long itemId) {
		return getFinder().getItemDetails(itemId);
	}

	public static java.util.List<com.idetronic.subur.model.SuburItem> findByAuthorGroup(
		long groupId, long authorId, int start, int end, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByAuthorGroup(groupId, authorId, start, end, status, obc);
	}

	public static java.util.List getItemAuthors(long itemId) {
		return getFinder().getItemAuthors(itemId);
	}

	public static SuburItemFinder getFinder() {
		if (_finder == null) {
			_finder = (SuburItemFinder)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					SuburItemFinder.class.getName());

			ReferenceRegistry.registerReference(SuburItemFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SuburItemFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SuburItemFinderUtil.class, "_finder");
	}

	private static SuburItemFinder _finder;
}