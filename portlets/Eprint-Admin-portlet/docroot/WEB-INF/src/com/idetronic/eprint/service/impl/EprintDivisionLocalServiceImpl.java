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

import com.idetronic.eprint.NoSuchEprintDivisionException;
import com.idetronic.eprint.model.EprintDivision;
import com.idetronic.eprint.model.impl.EprintDivisionImpl;
import com.idetronic.eprint.service.base.EprintDivisionLocalServiceBaseImpl;
import com.idetronic.eprint.service.persistence.EprintDivisionPK;
import com.idetronic.eprint.service.persistence.EprintDivisionUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the eprint division local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eprint.service.EprintDivisionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eprint.service.base.EprintDivisionLocalServiceBaseImpl
 * @see com.idetronic.eprint.service.EprintDivisionLocalServiceUtil
 */
public class EprintDivisionLocalServiceImpl
	extends EprintDivisionLocalServiceBaseImpl {
	private static final Log log = LogFactoryUtil.getLog(EprintDivisionLocalServiceImpl.class);
	public EprintDivision validateEprintDivision(long eprintId,String divisionId,String divisionName)
	{
		EprintDivisionPK epDivisionPK = new EprintDivisionPK();
		epDivisionPK.setEprintId(eprintId);
		epDivisionPK.setDivisionId(divisionId);
		
		
		EprintDivision epDivision = null;
		try {
			epDivision =  EprintDivisionUtil.findByPrimaryKey(epDivisionPK);
		} catch (SystemException e) {
			log.error(e);
		}  catch (NoSuchEprintDivisionException e) {
			
			epDivision = insertEprintDivision(eprintId,divisionId,divisionName);
		}
		return epDivision;
		
		
	}
	
	public EprintDivision insertEprintDivision(long eprintId,String divisionId,String divisionName)
	{
		EprintDivision epDivision = new EprintDivisionImpl();
		epDivision.setEprintId(eprintId);
		epDivision.setDivisionId(divisionId);
		epDivision.setDivisionName(divisionName);
		try {
			epDivision = eprintDivisionPersistence.update(epDivision);
		} catch (SystemException e) {
			
			log.error(e);
		}
		
		return epDivision;
		
	}
}