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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the Staff service. This utility wraps {@link StaffPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StaffPersistence
 * @see StaffPersistenceImpl
 * @generated
 */
public class StaffUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Staff staff) {
		getPersistence().clearCache(staff);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Staff> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Staff> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Staff> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Staff update(Staff staff, boolean merge)
		throws SystemException {
		return getPersistence().update(staff, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Staff update(Staff staff, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(staff, merge, serviceContext);
	}

	/**
	* Caches the Staff in the entity cache if it is enabled.
	*
	* @param staff the Staff
	*/
	public static void cacheResult(com.idetronic.model.Staff staff) {
		getPersistence().cacheResult(staff);
	}

	/**
	* Caches the Staffs in the entity cache if it is enabled.
	*
	* @param staffs the Staffs
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.model.Staff> staffs) {
		getPersistence().cacheResult(staffs);
	}

	/**
	* Creates a new Staff with the primary key. Does not add the Staff to the database.
	*
	* @param bp_no_kp the primary key for the new Staff
	* @return the new Staff
	*/
	public static com.idetronic.model.Staff create(java.lang.String bp_no_kp) {
		return getPersistence().create(bp_no_kp);
	}

	/**
	* Removes the Staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff that was removed
	* @throws com.idetronic.NoSuchStaffException if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff remove(java.lang.String bp_no_kp)
		throws com.idetronic.NoSuchStaffException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bp_no_kp);
	}

	public static com.idetronic.model.Staff updateImpl(
		com.idetronic.model.Staff staff, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(staff, merge);
	}

	/**
	* Returns the Staff with the primary key or throws a {@link com.idetronic.NoSuchStaffException} if it could not be found.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff
	* @throws com.idetronic.NoSuchStaffException if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff findByPrimaryKey(
		java.lang.String bp_no_kp)
		throws com.idetronic.NoSuchStaffException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bp_no_kp);
	}

	/**
	* Returns the Staff with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff, or <code>null</code> if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff fetchByPrimaryKey(
		java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bp_no_kp);
	}

	/**
	* Returns all the Staffs.
	*
	* @return the Staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.model.Staff> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.model.Staff> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.model.Staff> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Staffs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Staffs.
	*
	* @return the number of Staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StaffPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StaffPersistence)PortletBeanLocatorUtil.locate(com.idetronic.service.ClpSerializer.getServletContextName(),
					StaffPersistence.class.getName());

			ReferenceRegistry.registerReference(StaffUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(StaffPersistence persistence) {
	}

	private static StaffPersistence _persistence;
}