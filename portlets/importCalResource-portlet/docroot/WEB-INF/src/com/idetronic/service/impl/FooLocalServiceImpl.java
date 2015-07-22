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

package com.idetronic.service.impl;

import java.util.List;

import com.idetronic.service.base.FooLocalServiceBaseImpl;
import com.idetronic.service.persistence.FooFinderUtil;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.util.comparator.CalendarResourceNameComparator;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the foo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.service.FooLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matle
 * @see com.idetronic.service.base.FooLocalServiceBaseImpl
 * @see com.idetronic.service.FooLocalServiceUtil
 */
public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.service.FooLocalServiceUtil} to access the foo local service.
	 */
	public List<CalendarResource> doFindByC_G_C_C_N_D_A(
			long companyId, long[] groupIds, long[] classNameIds,
			String[] codes, String[] names, String[] descriptions,
			boolean active, boolean andOperator, int start, int end,
			OrderByComparator orderByComparator, boolean inlineSQLHelper)
		throws SystemException
		{
return FooFinderUtil.doFindByC_G_C_C_N_D_A(
		companyId,
		groupIds,
		classNameIds, codes,names,descriptions, true, true, 0,
		SearchContainer.DEFAULT_DELTA,
		new CalendarResourceNameComparator(),false)	;	
		}
		
}