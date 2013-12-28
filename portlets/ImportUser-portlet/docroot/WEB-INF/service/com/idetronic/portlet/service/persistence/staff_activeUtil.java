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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the staff_active service. This utility wraps {@link staff_activePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see staff_activePersistence
 * @see staff_activePersistenceImpl
 * @generated
 */
public class staff_activeUtil {
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
	public static void clearCache(staff_active staff_active) {
		getPersistence().clearCache(staff_active);
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
	public static List<staff_active> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<staff_active> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<staff_active> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static staff_active update(staff_active staff_active, boolean merge)
		throws SystemException {
		return getPersistence().update(staff_active, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static staff_active update(staff_active staff_active, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(staff_active, merge, serviceContext);
	}

	/**
	* Caches the staff_active in the entity cache if it is enabled.
	*
	* @param staff_active the staff_active
	*/
	public static void cacheResult(
		com.idetronic.portlet.model.staff_active staff_active) {
		getPersistence().cacheResult(staff_active);
	}

	/**
	* Caches the staff_actives in the entity cache if it is enabled.
	*
	* @param staff_actives the staff_actives
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.portlet.model.staff_active> staff_actives) {
		getPersistence().cacheResult(staff_actives);
	}

	/**
	* Creates a new staff_active with the primary key. Does not add the staff_active to the database.
	*
	* @param bp_no_kp the primary key for the new staff_active
	* @return the new staff_active
	*/
	public static com.idetronic.portlet.model.staff_active create(
		java.lang.String bp_no_kp) {
		return getPersistence().create(bp_no_kp);
	}

	/**
	* Removes the staff_active with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bp_no_kp the primary key of the staff_active
	* @return the staff_active that was removed
	* @throws com.idetronic.portlet.NoSuchstaff_activeException if a staff_active with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.staff_active remove(
		java.lang.String bp_no_kp)
		throws com.idetronic.portlet.NoSuchstaff_activeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bp_no_kp);
	}

	public static com.idetronic.portlet.model.staff_active updateImpl(
		com.idetronic.portlet.model.staff_active staff_active, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(staff_active, merge);
	}

	/**
	* Returns the staff_active with the primary key or throws a {@link com.idetronic.portlet.NoSuchstaff_activeException} if it could not be found.
	*
	* @param bp_no_kp the primary key of the staff_active
	* @return the staff_active
	* @throws com.idetronic.portlet.NoSuchstaff_activeException if a staff_active with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.staff_active findByPrimaryKey(
		java.lang.String bp_no_kp)
		throws com.idetronic.portlet.NoSuchstaff_activeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bp_no_kp);
	}

	/**
	* Returns the staff_active with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bp_no_kp the primary key of the staff_active
	* @return the staff_active, or <code>null</code> if a staff_active with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.staff_active fetchByPrimaryKey(
		java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bp_no_kp);
	}

	/**
	* Returns all the staff_actives.
	*
	* @return the staff_actives
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.staff_active> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.portlet.model.staff_active> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.portlet.model.staff_active> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the staff_actives from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of staff_actives.
	*
	* @return the number of staff_actives
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static staff_activePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (staff_activePersistence)PortletBeanLocatorUtil.locate(com.idetronic.portlet.service.ClpSerializer.getServletContextName(),
					staff_activePersistence.class.getName());

			ReferenceRegistry.registerReference(staff_activeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(staff_activePersistence persistence) {
	}

	private static staff_activePersistence _persistence;
}