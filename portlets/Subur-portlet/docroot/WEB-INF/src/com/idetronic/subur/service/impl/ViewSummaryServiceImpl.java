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

package com.idetronic.subur.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.Locale;

import com.idetronic.subur.service.ViewSummaryLocalServiceUtil;
import com.idetronic.subur.service.base.ViewSummaryServiceBaseImpl;
import com.idetronic.subur.service.persistence.ViewSummaryFinderUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

/**
 * The implementation of the view summary remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ViewSummaryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ViewSummaryServiceBaseImpl
 * @see com.idetronic.subur.service.ViewSummaryServiceUtil
 */
public class ViewSummaryServiceImpl extends ViewSummaryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ViewSummaryServiceUtil} to access the view summary remote service.
	 */
	
	private static Log logger = LogFactoryUtil.getLog(ViewSummaryServiceImpl.class);
	
	public JSONArray getMonthlyCategory(int year,long vocabularyId) throws Exception
	{
		return ViewSummaryFinderUtil.getMonthlyCategorySummary(year,vocabularyId);
	}
	
	public JSONArray getMonthlyItemType(int year) throws Exception
	{
		return ViewSummaryFinderUtil.getMothlyItemTypeSummary(year);
	}
	public JSONArray getMonthlySummary(int year) throws Exception
	{
		
		
		return ViewSummaryLocalServiceUtil.getMonthlyStatRs(year);
		
				
	}
	
	public JSONArray getMonthlyTagSummary(int year) throws Exception
	{
		return ViewSummaryFinderUtil.getMothlyTagSummary(year);
	}
}