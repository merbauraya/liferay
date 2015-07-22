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

package com.idetronic.subur.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ViewSummaryService}.
 *
 * @author Mazlan Mat
 * @see ViewSummaryService
 * @generated
 */
public class ViewSummaryServiceWrapper implements ViewSummaryService,
	ServiceWrapper<ViewSummaryService> {
	public ViewSummaryServiceWrapper(ViewSummaryService viewSummaryService) {
		_viewSummaryService = viewSummaryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _viewSummaryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_viewSummaryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _viewSummaryService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getMonthlyCategory(
		int year, long vocabularyId) throws java.lang.Exception {
		return _viewSummaryService.getMonthlyCategory(year, vocabularyId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getMonthlyItemType(int year)
		throws java.lang.Exception {
		return _viewSummaryService.getMonthlyItemType(year);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getMonthlySummary(int year)
		throws java.lang.Exception {
		return _viewSummaryService.getMonthlySummary(year);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getMonthlyTagSummary(
		int year) throws java.lang.Exception {
		return _viewSummaryService.getMonthlyTagSummary(year);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ViewSummaryService getWrappedViewSummaryService() {
		return _viewSummaryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedViewSummaryService(
		ViewSummaryService viewSummaryService) {
		_viewSummaryService = viewSummaryService;
	}

	@Override
	public ViewSummaryService getWrappedService() {
		return _viewSummaryService;
	}

	@Override
	public void setWrappedService(ViewSummaryService viewSummaryService) {
		_viewSummaryService = viewSummaryService;
	}

	private ViewSummaryService _viewSummaryService;
}