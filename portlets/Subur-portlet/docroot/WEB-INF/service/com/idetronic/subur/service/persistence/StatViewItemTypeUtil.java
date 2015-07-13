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

import com.idetronic.subur.model.StatViewItemType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the stat view item type service. This utility wraps {@link StatViewItemTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewItemTypePersistence
 * @see StatViewItemTypePersistenceImpl
 * @generated
 */
public class StatViewItemTypeUtil {
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
	public static void clearCache(StatViewItemType statViewItemType) {
		getPersistence().clearCache(statViewItemType);
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
	public static List<StatViewItemType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatViewItemType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatViewItemType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StatViewItemType update(StatViewItemType statViewItemType)
		throws SystemException {
		return getPersistence().update(statViewItemType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StatViewItemType update(StatViewItemType statViewItemType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(statViewItemType, serviceContext);
	}

	/**
	* Returns all the stat view item types where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the matching stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewItemType> findByItemType(
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemType(itemTypeId);
	}

	/**
	* Returns a range of all the stat view item types where itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of stat view item types
	* @param end the upper bound of the range of stat view item types (not inclusive)
	* @return the range of matching stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewItemType> findByItemType(
		long itemTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemType(itemTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the stat view item types where itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of stat view item types
	* @param end the upper bound of the range of stat view item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewItemType> findByItemType(
		long itemTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType(itemTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first stat view item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat view item type
	* @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a matching stat view item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewItemType findByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_First(itemTypeId, orderByComparator);
	}

	/**
	* Returns the first stat view item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat view item type, or <code>null</code> if a matching stat view item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewItemType fetchByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByItemType_First(itemTypeId, orderByComparator);
	}

	/**
	* Returns the last stat view item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat view item type
	* @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a matching stat view item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewItemType findByItemType_Last(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_Last(itemTypeId, orderByComparator);
	}

	/**
	* Returns the last stat view item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat view item type, or <code>null</code> if a matching stat view item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewItemType fetchByItemType_Last(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByItemType_Last(itemTypeId, orderByComparator);
	}

	/**
	* Returns the stat view item types before and after the current stat view item type in the ordered set where itemTypeId = &#63;.
	*
	* @param id the primary key of the current stat view item type
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat view item type
	* @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewItemType[] findByItemType_PrevAndNext(
		long id, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_PrevAndNext(id, itemTypeId, orderByComparator);
	}

	/**
	* Removes all the stat view item types where itemTypeId = &#63; from the database.
	*
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByItemType(itemTypeId);
	}

	/**
	* Returns the number of stat view item types where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the number of matching stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByItemType(itemTypeId);
	}

	/**
	* Caches the stat view item type in the entity cache if it is enabled.
	*
	* @param statViewItemType the stat view item type
	*/
	public static void cacheResult(
		com.idetronic.subur.model.StatViewItemType statViewItemType) {
		getPersistence().cacheResult(statViewItemType);
	}

	/**
	* Caches the stat view item types in the entity cache if it is enabled.
	*
	* @param statViewItemTypes the stat view item types
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.StatViewItemType> statViewItemTypes) {
		getPersistence().cacheResult(statViewItemTypes);
	}

	/**
	* Creates a new stat view item type with the primary key. Does not add the stat view item type to the database.
	*
	* @param id the primary key for the new stat view item type
	* @return the new stat view item type
	*/
	public static com.idetronic.subur.model.StatViewItemType create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the stat view item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat view item type
	* @return the stat view item type that was removed
	* @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewItemType remove(long id)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.idetronic.subur.model.StatViewItemType updateImpl(
		com.idetronic.subur.model.StatViewItemType statViewItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(statViewItemType);
	}

	/**
	* Returns the stat view item type with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewItemTypeException} if it could not be found.
	*
	* @param id the primary key of the stat view item type
	* @return the stat view item type
	* @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewItemType findByPrimaryKey(
		long id)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the stat view item type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat view item type
	* @return the stat view item type, or <code>null</code> if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewItemType fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the stat view item types.
	*
	* @return the stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewItemType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stat view item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view item types
	* @param end the upper bound of the range of stat view item types (not inclusive)
	* @return the range of stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewItemType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stat view item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view item types
	* @param end the upper bound of the range of stat view item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the stat view item types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stat view item types.
	*
	* @return the number of stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StatViewItemTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StatViewItemTypePersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					StatViewItemTypePersistence.class.getName());

			ReferenceRegistry.registerReference(StatViewItemTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StatViewItemTypePersistence persistence) {
	}

	private static StatViewItemTypePersistence _persistence;
}