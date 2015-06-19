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

package com.idetronic.subur.service.persistence;

import com.idetronic.subur.model.Division;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the division service. This utility wraps {@link DivisionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see DivisionPersistence
 * @see DivisionPersistenceImpl
 * @generated
 */
public class DivisionUtil {
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
	public static void clearCache(Division division) {
		getPersistence().clearCache(division);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Division> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Division> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Division> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Division update(Division division) throws SystemException {
		return getPersistence().update(division);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Division update(Division division,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(division, serviceContext);
	}

	/**
	* Returns all the divisions where depositable = &#63;.
	*
	* @param depositable the depositable
	* @return the matching divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Division> findBydepositable(
		boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydepositable(depositable);
	}

	/**
	* Returns a range of all the divisions where depositable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param depositable the depositable
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @return the range of matching divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Division> findBydepositable(
		boolean depositable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydepositable(depositable, start, end);
	}

	/**
	* Returns an ordered range of all the divisions where depositable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param depositable the depositable
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Division> findBydepositable(
		boolean depositable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydepositable(depositable, start, end, orderByComparator);
	}

	/**
	* Returns the first division in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching division
	* @throws com.idetronic.subur.NoSuchDivisionException if a matching division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Division findBydepositable_First(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydepositable_First(depositable, orderByComparator);
	}

	/**
	* Returns the first division in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching division, or <code>null</code> if a matching division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Division fetchBydepositable_First(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBydepositable_First(depositable, orderByComparator);
	}

	/**
	* Returns the last division in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching division
	* @throws com.idetronic.subur.NoSuchDivisionException if a matching division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Division findBydepositable_Last(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydepositable_Last(depositable, orderByComparator);
	}

	/**
	* Returns the last division in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching division, or <code>null</code> if a matching division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Division fetchBydepositable_Last(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBydepositable_Last(depositable, orderByComparator);
	}

	/**
	* Returns the divisions before and after the current division in the ordered set where depositable = &#63;.
	*
	* @param divisionId the primary key of the current division
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next division
	* @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Division[] findBydepositable_PrevAndNext(
		long divisionId, boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydepositable_PrevAndNext(divisionId, depositable,
			orderByComparator);
	}

	/**
	* Removes all the divisions where depositable = &#63; from the database.
	*
	* @param depositable the depositable
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBydepositable(boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBydepositable(depositable);
	}

	/**
	* Returns the number of divisions where depositable = &#63;.
	*
	* @param depositable the depositable
	* @return the number of matching divisions
	* @throws SystemException if a system exception occurred
	*/
	public static int countBydepositable(boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBydepositable(depositable);
	}

	/**
	* Caches the division in the entity cache if it is enabled.
	*
	* @param division the division
	*/
	public static void cacheResult(com.idetronic.subur.model.Division division) {
		getPersistence().cacheResult(division);
	}

	/**
	* Caches the divisions in the entity cache if it is enabled.
	*
	* @param divisions the divisions
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.Division> divisions) {
		getPersistence().cacheResult(divisions);
	}

	/**
	* Creates a new division with the primary key. Does not add the division to the database.
	*
	* @param divisionId the primary key for the new division
	* @return the new division
	*/
	public static com.idetronic.subur.model.Division create(long divisionId) {
		return getPersistence().create(divisionId);
	}

	/**
	* Removes the division with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param divisionId the primary key of the division
	* @return the division that was removed
	* @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Division remove(long divisionId)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(divisionId);
	}

	public static com.idetronic.subur.model.Division updateImpl(
		com.idetronic.subur.model.Division division)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(division);
	}

	/**
	* Returns the division with the primary key or throws a {@link com.idetronic.subur.NoSuchDivisionException} if it could not be found.
	*
	* @param divisionId the primary key of the division
	* @return the division
	* @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Division findByPrimaryKey(
		long divisionId)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(divisionId);
	}

	/**
	* Returns the division with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param divisionId the primary key of the division
	* @return the division, or <code>null</code> if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Division fetchByPrimaryKey(
		long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(divisionId);
	}

	/**
	* Returns all the divisions.
	*
	* @return the divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Division> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @return the range of divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Division> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Division> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the divisions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of divisions.
	*
	* @return the number of divisions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DivisionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DivisionPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					DivisionPersistence.class.getName());

			ReferenceRegistry.registerReference(DivisionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DivisionPersistence persistence) {
	}

	private static DivisionPersistence _persistence;
}