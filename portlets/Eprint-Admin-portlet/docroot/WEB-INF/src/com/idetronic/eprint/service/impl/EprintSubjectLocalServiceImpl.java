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

import com.idetronic.eprint.NoSuchEprintSubjectException;
import com.idetronic.eprint.service.EprintSubjectLocalServiceUtil;
import com.idetronic.eprint.service.base.EprintSubjectLocalServiceBaseImpl;
import com.idetronic.eprint.service.persistence.EprintSubjectPK;
import com.idetronic.eprint.service.persistence.EprintSubjectPersistenceImpl;
import com.idetronic.eprint.service.persistence.EprintSubjectUtil;
import com.idetronic.eprint.model.EprintSubject;
import com.idetronic.eprint.model.impl.EprintSubjectImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

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
	private static final Log log = LogFactoryUtil.getLog(EprintSubjectLocalServiceImpl.class);
	public EprintSubject validateEprintSubject(long eprintId,String subjectId,String subjectName)
	{
		EprintSubjectPK epSubjectPK = new EprintSubjectPK();
		epSubjectPK.setEprintId(eprintId);
		epSubjectPK.setSubjectId(subjectId);
		
		EprintSubject epSubject = null;
		try {
			epSubject =  EprintSubjectUtil.findByPrimaryKey(epSubjectPK);
		} catch (NoSuchEprintSubjectException e) {
			epSubject = insertEprintSubject(eprintId,subjectId,subjectName);
		} catch (SystemException e) {
			log.error(e);
		}
		return epSubject;
		
		
	}
	
	public EprintSubject insertEprintSubject(long eprintId,String subjectId,String subjectName)
	{
		EprintSubject epSubject = new EprintSubjectImpl();
		epSubject.setEprintId(eprintId);
		epSubject.setSubjectId(subjectId);
		epSubject.setSubjectName(subjectName);
		try {
			epSubject = eprintSubjectPersistence.update(epSubject, false);
		} catch (SystemException e) {
			
			log.error(e);
		}
		
		return epSubject;
		
	}
}