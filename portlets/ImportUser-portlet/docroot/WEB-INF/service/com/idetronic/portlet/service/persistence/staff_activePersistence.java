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

package com.idetronic.portlet.service.persistence;

import com.idetronic.portlet.model.staff_active;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the staff_active service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see staff_activePersistenceImpl
 * @see staff_activeUtil
 * @generated
 */
public interface staff_activePersistence extends BasePersistence<staff_active> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link staff_activeUtil} to access the staff_active persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the staff_active in the entity cache if it is enabled.
	*
	* @param staff_active the staff_active
	*/
	public void cacheResult(
		com.idetronic.portlet.model.staff_active staff_active);

	/**
	* Caches the staff_actives in the entity cache if it is enabled.
	*
	* @param staff_actives the staff_actives
	*/
	public void cacheResult(
		java.util.List<com.idetronic.portlet.model.staff_active> staff_actives);

	/**
	* Creates a new staff_active with the primary key. Does not add the staff_active to the database.
	*
	* @param bp_no_kp the primary key for the new staff_active
	* @return the new staff_active
	*/
	public com.idetronic.portlet.model.staff_active create(
		java.lang.String bp_no_kp);

	/**
	* Removes the staff_active with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bp_no_kp the primary key of the staff_active
	* @return the staff_active that was removed
	* @throws com.idetronic.portlet.NoSuchstaff_activeException if a staff_active with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.staff_active remove(
		java.lang.String bp_no_kp)
		throws com.idetronic.portlet.NoSuchstaff_activeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.portlet.model.staff_active updateImpl(
		com.idetronic.portlet.model.staff_active staff_active, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff_active with the primary key or throws a {@link com.idetronic.portlet.NoSuchstaff_activeException} if it could not be found.
	*
	* @param bp_no_kp the primary key of the staff_active
	* @return the staff_active
	* @throws com.idetronic.portlet.NoSuchstaff_activeException if a staff_active with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.staff_active findByPrimaryKey(
		java.lang.String bp_no_kp)
		throws com.idetronic.portlet.NoSuchstaff_activeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff_active with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bp_no_kp the primary key of the staff_active
	* @return the staff_active, or <code>null</code> if a staff_active with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.staff_active fetchByPrimaryKey(
		java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the staff_actives.
	*
	* @return the staff_actives
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.staff_active> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the staff_actives.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of staff_actives
	* @param end the upper bound of the range of staff_actives (not inclusive)
	* @return the range of staff_actives
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.staff_active> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the staff_actives.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of staff_actives
	* @param end the upper bound of the range of staff_actives (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of staff_actives
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.staff_active> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the staff_actives from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of staff_actives.
	*
	* @return the number of staff_actives
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}