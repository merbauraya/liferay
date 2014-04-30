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

import com.idetronic.eprint.model.EprintDivision;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the eprint division service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintDivisionPersistenceImpl
 * @see EprintDivisionUtil
 * @generated
 */
public interface EprintDivisionPersistence extends BasePersistence<EprintDivision> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EprintDivisionUtil} to access the eprint division persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the eprint division in the entity cache if it is enabled.
	*
	* @param eprintDivision the eprint division
	*/
	public void cacheResult(
		com.idetronic.eprint.model.EprintDivision eprintDivision);

	/**
	* Caches the eprint divisions in the entity cache if it is enabled.
	*
	* @param eprintDivisions the eprint divisions
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eprint.model.EprintDivision> eprintDivisions);

	/**
	* Creates a new eprint division with the primary key. Does not add the eprint division to the database.
	*
	* @param eprintDivisionPK the primary key for the new eprint division
	* @return the new eprint division
	*/
	public com.idetronic.eprint.model.EprintDivision create(
		com.idetronic.eprint.service.persistence.EprintDivisionPK eprintDivisionPK);

	/**
	* Removes the eprint division with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintDivisionPK the primary key of the eprint division
	* @return the eprint division that was removed
	* @throws com.idetronic.eprint.NoSuchEprintDivisionException if a eprint division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintDivision remove(
		com.idetronic.eprint.service.persistence.EprintDivisionPK eprintDivisionPK)
		throws com.idetronic.eprint.NoSuchEprintDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eprint.model.EprintDivision updateImpl(
		com.idetronic.eprint.model.EprintDivision eprintDivision)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprint division with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintDivisionException} if it could not be found.
	*
	* @param eprintDivisionPK the primary key of the eprint division
	* @return the eprint division
	* @throws com.idetronic.eprint.NoSuchEprintDivisionException if a eprint division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintDivision findByPrimaryKey(
		com.idetronic.eprint.service.persistence.EprintDivisionPK eprintDivisionPK)
		throws com.idetronic.eprint.NoSuchEprintDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprint division with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eprintDivisionPK the primary key of the eprint division
	* @return the eprint division, or <code>null</code> if a eprint division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintDivision fetchByPrimaryKey(
		com.idetronic.eprint.service.persistence.EprintDivisionPK eprintDivisionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eprint divisions.
	*
	* @return the eprint divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintDivision> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the eprint divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprint divisions
	* @param end the upper bound of the range of eprint divisions (not inclusive)
	* @return the range of eprint divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintDivision> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the eprint divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprint divisions
	* @param end the upper bound of the range of eprint divisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eprint divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintDivision> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eprint divisions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eprint divisions.
	*
	* @return the number of eprint divisions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}