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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.idetronic.subur.Subur;
import com.idetronic.subur.model.Division;
import com.idetronic.subur.service.base.DivisionLocalServiceBaseImpl;


import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * The implementation of the division local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.DivisionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.DivisionLocalServiceBaseImpl
 * @see com.idetronic.subur.service.DivisionLocalServiceUtil
 */
public class DivisionLocalServiceImpl extends DivisionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.DivisionLocalServiceUtil} to access the division local service.
	 */
	private static Log logger = LogFactoryUtil.getLog(DivisionLocalServiceImpl.class);
	
	public List<Division> findAll() throws SystemException
	{
		return divisionPersistence.findAll();
	}
	public List<Division> getDepositable() throws SystemException
	{
		return divisionPersistence.findBydepositable(true);
	}
}