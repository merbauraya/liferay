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
public class ViewSummaryFinderUtil {
	public static com.liferay.portal.kernel.json.JSONArray getMonthlyCategorySummary(
		int year, long vocabularyId) throws java.sql.SQLException {
		return getFinder().getMonthlyCategorySummary(year, vocabularyId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getMothlyItemTypeSummary(
		int year) throws java.sql.SQLException {
		return getFinder().getMothlyItemTypeSummary(year);
	}

	public static com.liferay.portal.kernel.json.JSONArray getMothlyTagSummary(
		int year) throws java.sql.SQLException {
		return getFinder().getMothlyTagSummary(year);
	}

	public static com.liferay.portal.kernel.json.JSONArray getMonthlySummary(
		int year) throws java.sql.SQLException {
		return getFinder().getMonthlySummary(year);
	}

	public static ViewSummaryFinder getFinder() {
		if (_finder == null) {
			_finder = (ViewSummaryFinder)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					ViewSummaryFinder.class.getName());

			ReferenceRegistry.registerReference(ViewSummaryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ViewSummaryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ViewSummaryFinderUtil.class,
			"_finder");
	}

	private static ViewSummaryFinder _finder;
}