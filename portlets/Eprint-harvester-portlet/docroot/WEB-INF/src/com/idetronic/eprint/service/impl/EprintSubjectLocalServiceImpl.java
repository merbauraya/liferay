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

package com.idetronic.eprint.service.impl;

import java.util.List;

import com.idetronic.eprint.model.*;
import com.idetronic.eprint.service.base.EprintSubjectLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;

/**
 * The implementation of the eprint subject local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eprint.service.EprintSubjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eprint.service.base.EprintSubjectLocalServiceBaseImpl
 * @see com.idetronic.eprint.service.EprintSubjectLocalServiceUtil
 */
public class EprintSubjectLocalServiceImpl
	extends EprintSubjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eprint.service.EprintSubjectLocalServiceUtil} to access the eprint subject local service.
	 */
	public List<EprintSubject> getAll()
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(EprintSubject.class);
		return null;
	}
}