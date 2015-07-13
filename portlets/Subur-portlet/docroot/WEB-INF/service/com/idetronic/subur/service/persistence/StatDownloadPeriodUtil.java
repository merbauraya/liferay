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

import com.idetronic.subur.model.StatDownloadPeriod;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the stat download period service. This utility wraps {@link StatDownloadPeriodPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadPeriodPersistence
 * @see StatDownloadPeriodPersistenceImpl
 * @generated
 */
public class StatDownloadPeriodUtil {
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
	public static void clearCache(StatDownloadPeriod statDownloadPeriod) {
		getPersistence().clearCache(statDownloadPeriod);
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
	public static List<StatDownloadPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatDownloadPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatDownloadPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StatDownloadPeriod update(
		StatDownloadPeriod statDownloadPeriod) throws SystemException {
		return getPersistence().update(statDownloadPeriod);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StatDownloadPeriod update(
		StatDownloadPeriod statDownloadPeriod, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(statDownloadPeriod, serviceContext);
	}

	/**
	* Returns all the stat download periods where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @return the matching stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadPeriod> findByPeriod(
		int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPeriod(perMonth, perYear);
	}

	/**
	* Returns a range of all the stat download periods where perMonth = &#63; and perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param start the lower bound of the range of stat download periods
	* @param end the upper bound of the range of stat download periods (not inclusive)
	* @return the range of matching stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadPeriod> findByPeriod(
		int perMonth, int perYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPeriod(perMonth, perYear, start, end);
	}

	/**
	* Returns an ordered range of all the stat download periods where perMonth = &#63; and perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param start the lower bound of the range of stat download periods
	* @param end the upper bound of the range of stat download periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadPeriod> findByPeriod(
		int perMonth, int perYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPeriod(perMonth, perYear, start, end,
			orderByComparator);
	}

	/**
	* Returns the first stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download period
	* @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a matching stat download period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod findByPeriod_First(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadPeriodException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPeriod_First(perMonth, perYear, orderByComparator);
	}

	/**
	* Returns the first stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download period, or <code>null</code> if a matching stat download period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod fetchByPeriod_First(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPeriod_First(perMonth, perYear, orderByComparator);
	}

	/**
	* Returns the last stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download period
	* @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a matching stat download period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod findByPeriod_Last(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadPeriodException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPeriod_Last(perMonth, perYear, orderByComparator);
	}

	/**
	* Returns the last stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download period, or <code>null</code> if a matching stat download period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod fetchByPeriod_Last(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPeriod_Last(perMonth, perYear, orderByComparator);
	}

	/**
	* Returns the stat download periods before and after the current stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param id the primary key of the current stat download period
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat download period
	* @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a stat download period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod[] findByPeriod_PrevAndNext(
		long id, int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadPeriodException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPeriod_PrevAndNext(id, perMonth, perYear,
			orderByComparator);
	}

	/**
	* Removes all the stat download periods where perMonth = &#63; and perYear = &#63; from the database.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPeriod(int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPeriod(perMonth, perYear);
	}

	/**
	* Returns the number of stat download periods where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @return the number of matching stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPeriod(int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPeriod(perMonth, perYear);
	}

	/**
	* Caches the stat download period in the entity cache if it is enabled.
	*
	* @param statDownloadPeriod the stat download period
	*/
	public static void cacheResult(
		com.idetronic.subur.model.StatDownloadPeriod statDownloadPeriod) {
		getPersistence().cacheResult(statDownloadPeriod);
	}

	/**
	* Caches the stat download periods in the entity cache if it is enabled.
	*
	* @param statDownloadPeriods the stat download periods
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.StatDownloadPeriod> statDownloadPeriods) {
		getPersistence().cacheResult(statDownloadPeriods);
	}

	/**
	* Creates a new stat download period with the primary key. Does not add the stat download period to the database.
	*
	* @param id the primary key for the new stat download period
	* @return the new stat download period
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the stat download period with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat download period
	* @return the stat download period that was removed
	* @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a stat download period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod remove(long id)
		throws com.idetronic.subur.NoSuchStatDownloadPeriodException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.idetronic.subur.model.StatDownloadPeriod updateImpl(
		com.idetronic.subur.model.StatDownloadPeriod statDownloadPeriod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(statDownloadPeriod);
	}

	/**
	* Returns the stat download period with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadPeriodException} if it could not be found.
	*
	* @param id the primary key of the stat download period
	* @return the stat download period
	* @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a stat download period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod findByPrimaryKey(
		long id)
		throws com.idetronic.subur.NoSuchStatDownloadPeriodException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the stat download period with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat download period
	* @return the stat download period, or <code>null</code> if a stat download period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the stat download periods.
	*
	* @return the stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadPeriod> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stat download periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download periods
	* @param end the upper bound of the range of stat download periods (not inclusive)
	* @return the range of stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadPeriod> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stat download periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download periods
	* @param end the upper bound of the range of stat download periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadPeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the stat download periods from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stat download periods.
	*
	* @return the number of stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StatDownloadPeriodPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StatDownloadPeriodPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					StatDownloadPeriodPersistence.class.getName());

			ReferenceRegistry.registerReference(StatDownloadPeriodUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StatDownloadPeriodPersistence persistence) {
	}

	private static StatDownloadPeriodPersistence _persistence;
}