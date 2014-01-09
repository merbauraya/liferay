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

package com.idetronic.eprint.service.persistence;

import com.idetronic.eprint.model.EprintSubject;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the eprint subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintSubjectPersistenceImpl
 * @see EprintSubjectUtil
 * @generated
 */
public interface EprintSubjectPersistence extends BasePersistence<EprintSubject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EprintSubjectUtil} to access the eprint subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the eprint subject in the entity cache if it is enabled.
	*
	* @param eprintSubject the eprint subject
	*/
	public void cacheResult(
		com.idetronic.eprint.model.EprintSubject eprintSubject);

	/**
	* Caches the eprint subjects in the entity cache if it is enabled.
	*
	* @param eprintSubjects the eprint subjects
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eprint.model.EprintSubject> eprintSubjects);

	/**
	* Creates a new eprint subject with the primary key. Does not add the eprint subject to the database.
	*
	* @param eprintId the primary key for the new eprint subject
	* @return the new eprint subject
	*/
	public com.idetronic.eprint.model.EprintSubject create(long eprintId);

	/**
	* Removes the eprint subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintId the primary key of the eprint subject
	* @return the eprint subject that was removed
	* @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintSubject remove(long eprintId)
		throws com.idetronic.eprint.NoSuchEprintSubjectException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eprint.model.EprintSubject updateImpl(
		com.idetronic.eprint.model.EprintSubject eprintSubject, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprint subject with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintSubjectException} if it could not be found.
	*
	* @param eprintId the primary key of the eprint subject
	* @return the eprint subject
	* @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintSubject findByPrimaryKey(
		long eprintId)
		throws com.idetronic.eprint.NoSuchEprintSubjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprint subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eprintId the primary key of the eprint subject
	* @return the eprint subject, or <code>null</code> if a eprint subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintSubject fetchByPrimaryKey(
		long eprintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eprint subjects.
	*
	* @return the eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintSubject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the eprint subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprint subjects
	* @param end the upper bound of the range of eprint subjects (not inclusive)
	* @return the range of eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintSubject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the eprint subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprint subjects
	* @param end the upper bound of the range of eprint subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eprint subjects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eprint subjects.
	*
	* @return the number of eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}