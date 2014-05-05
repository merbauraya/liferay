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

package com.idetronic.tazkirah.service.persistence;

import com.idetronic.tazkirah.model.Tazkirah;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the tazkirah service. This utility wraps {@link TazkirahPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see TazkirahPersistence
 * @see TazkirahPersistenceImpl
 * @generated
 */
public class TazkirahUtil {
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
	public static void clearCache(Tazkirah tazkirah) {
		getPersistence().clearCache(tazkirah);
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
	public static List<Tazkirah> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tazkirah> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tazkirah> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Tazkirah update(Tazkirah tazkirah) throws SystemException {
		return getPersistence().update(tazkirah);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Tazkirah update(Tazkirah tazkirah,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tazkirah, serviceContext);
	}

	/**
	* Returns all the tazkirahs where category = &#63;.
	*
	* @param category the category
	* @return the matching tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.tazkirah.model.Tazkirah> findByCategory(
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(category);
	}

	/**
	* Returns a range of all the tazkirahs where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of tazkirahs
	* @param end the upper bound of the range of tazkirahs (not inclusive)
	* @return the range of matching tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.tazkirah.model.Tazkirah> findByCategory(
		java.lang.String category, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(category, start, end);
	}

	/**
	* Returns an ordered range of all the tazkirahs where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of tazkirahs
	* @param end the upper bound of the range of tazkirahs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.tazkirah.model.Tazkirah> findByCategory(
		java.lang.String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(category, start, end, orderByComparator);
	}

	/**
	* Returns the first tazkirah in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tazkirah
	* @throws com.idetronic.tazkirah.NoSuchTazkirahException if a matching tazkirah could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.tazkirah.model.Tazkirah findByCategory_First(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.tazkirah.NoSuchTazkirahException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory_First(category, orderByComparator);
	}

	/**
	* Returns the first tazkirah in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tazkirah, or <code>null</code> if a matching tazkirah could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.tazkirah.model.Tazkirah fetchByCategory_First(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(category, orderByComparator);
	}

	/**
	* Returns the last tazkirah in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tazkirah
	* @throws com.idetronic.tazkirah.NoSuchTazkirahException if a matching tazkirah could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.tazkirah.model.Tazkirah findByCategory_Last(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.tazkirah.NoSuchTazkirahException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory_Last(category, orderByComparator);
	}

	/**
	* Returns the last tazkirah in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tazkirah, or <code>null</code> if a matching tazkirah could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.tazkirah.model.Tazkirah fetchByCategory_Last(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCategory_Last(category, orderByComparator);
	}

	/**
	* Returns the tazkirahs before and after the current tazkirah in the ordered set where category = &#63;.
	*
	* @param tazkirahId the primary key of the current tazkirah
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tazkirah
	* @throws com.idetronic.tazkirah.NoSuchTazkirahException if a tazkirah with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.tazkirah.model.Tazkirah[] findByCategory_PrevAndNext(
		long tazkirahId, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.tazkirah.NoSuchTazkirahException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_PrevAndNext(tazkirahId, category,
			orderByComparator);
	}

	/**
	* Removes all the tazkirahs where category = &#63; from the database.
	*
	* @param category the category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(category);
	}

	/**
	* Returns the number of tazkirahs where category = &#63;.
	*
	* @param category the category
	* @return the number of matching tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(category);
	}

	/**
	* Caches the tazkirah in the entity cache if it is enabled.
	*
	* @param tazkirah the tazkirah
	*/
	public static void cacheResult(
		com.idetronic.tazkirah.model.Tazkirah tazkirah) {
		getPersistence().cacheResult(tazkirah);
	}

	/**
	* Caches the tazkirahs in the entity cache if it is enabled.
	*
	* @param tazkirahs the tazkirahs
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.tazkirah.model.Tazkirah> tazkirahs) {
		getPersistence().cacheResult(tazkirahs);
	}

	/**
	* Creates a new tazkirah with the primary key. Does not add the tazkirah to the database.
	*
	* @param tazkirahId the primary key for the new tazkirah
	* @return the new tazkirah
	*/
	public static com.idetronic.tazkirah.model.Tazkirah create(long tazkirahId) {
		return getPersistence().create(tazkirahId);
	}

	/**
	* Removes the tazkirah with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tazkirahId the primary key of the tazkirah
	* @return the tazkirah that was removed
	* @throws com.idetronic.tazkirah.NoSuchTazkirahException if a tazkirah with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.tazkirah.model.Tazkirah remove(long tazkirahId)
		throws com.idetronic.tazkirah.NoSuchTazkirahException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(tazkirahId);
	}

	public static com.idetronic.tazkirah.model.Tazkirah updateImpl(
		com.idetronic.tazkirah.model.Tazkirah tazkirah)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tazkirah);
	}

	/**
	* Returns the tazkirah with the primary key or throws a {@link com.idetronic.tazkirah.NoSuchTazkirahException} if it could not be found.
	*
	* @param tazkirahId the primary key of the tazkirah
	* @return the tazkirah
	* @throws com.idetronic.tazkirah.NoSuchTazkirahException if a tazkirah with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.tazkirah.model.Tazkirah findByPrimaryKey(
		long tazkirahId)
		throws com.idetronic.tazkirah.NoSuchTazkirahException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(tazkirahId);
	}

	/**
	* Returns the tazkirah with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tazkirahId the primary key of the tazkirah
	* @return the tazkirah, or <code>null</code> if a tazkirah with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.tazkirah.model.Tazkirah fetchByPrimaryKey(
		long tazkirahId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tazkirahId);
	}

	/**
	* Returns all the tazkirahs.
	*
	* @return the tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.tazkirah.model.Tazkirah> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tazkirahs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tazkirahs
	* @param end the upper bound of the range of tazkirahs (not inclusive)
	* @return the range of tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.tazkirah.model.Tazkirah> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tazkirahs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tazkirahs
	* @param end the upper bound of the range of tazkirahs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.tazkirah.model.Tazkirah> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tazkirahs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tazkirahs.
	*
	* @return the number of tazkirahs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TazkirahPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TazkirahPersistence)PortletBeanLocatorUtil.locate(com.idetronic.tazkirah.service.ClpSerializer.getServletContextName(),
					TazkirahPersistence.class.getName());

			ReferenceRegistry.registerReference(TazkirahUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TazkirahPersistence persistence) {
	}

	private static TazkirahPersistence _persistence;
}