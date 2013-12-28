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

package com.idetronic.service.persistence;

import com.idetronic.model.Staff;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the Staff service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StaffPersistenceImpl
 * @see StaffUtil
 * @generated
 */
public interface StaffPersistence extends BasePersistence<Staff> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StaffUtil} to access the Staff persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Staff in the entity cache if it is enabled.
	*
	* @param staff the Staff
	*/
	public void cacheResult(com.idetronic.model.Staff staff);

	/**
	* Caches the Staffs in the entity cache if it is enabled.
	*
	* @param staffs the Staffs
	*/
	public void cacheResult(java.util.List<com.idetronic.model.Staff> staffs);

	/**
	* Creates a new Staff with the primary key. Does not add the Staff to the database.
	*
	* @param bp_no_kp the primary key for the new Staff
	* @return the new Staff
	*/
	public com.idetronic.model.Staff create(java.lang.String bp_no_kp);

	/**
	* Removes the Staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff that was removed
	* @throws com.idetronic.NoSuchStaffException if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff remove(java.lang.String bp_no_kp)
		throws com.idetronic.NoSuchStaffException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.model.Staff updateImpl(
		com.idetronic.model.Staff staff, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Staff with the primary key or throws a {@link com.idetronic.NoSuchStaffException} if it could not be found.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff
	* @throws com.idetronic.NoSuchStaffException if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff findByPrimaryKey(java.lang.String bp_no_kp)
		throws com.idetronic.NoSuchStaffException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Staff with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff, or <code>null</code> if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff fetchByPrimaryKey(
		java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Staffs.
	*
	* @return the Staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.model.Staff> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Staffs
	* @param end the upper bound of the range of Staffs (not inclusive)
	* @return the range of Staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.model.Staff> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Staffs
	* @param end the upper bound of the range of Staffs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.model.Staff> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Staffs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Staffs.
	*
	* @return the number of Staffs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}