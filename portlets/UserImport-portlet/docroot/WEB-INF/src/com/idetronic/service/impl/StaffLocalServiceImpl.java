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

import java.util.ArrayList;
import java.util.List;

import com.idetronic.model.Staff;

import com.idetronic.service.base.StaffLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the Staff local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.service.StaffLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.service.base.StaffLocalServiceBaseImpl
 * @see com.idetronic.service.StaffLocalServiceUtil
 */
public class StaffLocalServiceImpl extends StaffLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.service.StaffLocalServiceUtil} to access the Staff local service.
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getDepartment() {
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Staff.class);
		query.setProjection(ProjectionFactoryUtil.projectionList()
				.add(ProjectionFactoryUtil.groupProperty("bk_jab_sekarang_desc"))
				.add(ProjectionFactoryUtil.count("bk_jab_sekarang_desc")));

		// DynamicQuery query =
		// DynamicQueryFactoryUtil.forClass(FAQEntry.class);

		// query.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("category")));
		// query.setProjection(ProjectionFactoryUtil.count("category"));
		// query.addOrder(OrderFactoryUtil.asc("displayOrder"));

		try {
			// catList = dynamicQuery(query);
			List<Object> result = dynamicQuery(query);
			return result;

		} catch (SystemException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}