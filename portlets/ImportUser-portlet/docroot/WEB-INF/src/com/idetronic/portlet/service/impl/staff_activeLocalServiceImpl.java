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

package com.idetronic.portlet.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.idetronic.portlet.model.staff_active;
import com.idetronic.portlet.service.base.staff_activeLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the staff_active local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.portlet.service.staff_activeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.portlet.service.base.staff_activeLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.staff_activeLocalServiceUtil
 */
public class staff_activeLocalServiceImpl
	extends staff_activeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.portlet.service.staff_activeLocalServiceUtil} to access the staff_active local service.
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getDepartment() {
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(staff_active.class);
		query.setProjection(ProjectionFactoryUtil.projectionList()
				.add(ProjectionFactoryUtil.groupProperty("bk_jab_sekarang_desc"))
				.add(ProjectionFactoryUtil.count("bk_jab_sekarang_desc")));


		try {
			// catList = dynamicQuery(query);
			List<Object> result = dynamicQuery(query);
			return result;

		} catch (SystemException ex) {
			ex.printStackTrace();
			return null;
		}

		// return catList;
	}
}