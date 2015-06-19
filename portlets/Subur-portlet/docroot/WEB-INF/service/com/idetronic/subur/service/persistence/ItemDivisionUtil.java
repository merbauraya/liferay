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

import com.idetronic.subur.model.ItemDivision;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the item division service. This utility wraps {@link ItemDivisionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemDivisionPersistence
 * @see ItemDivisionPersistenceImpl
 * @generated
 */
public class ItemDivisionUtil {
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
	public static void clearCache(ItemDivision itemDivision) {
		getPersistence().clearCache(itemDivision);
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
	public static List<ItemDivision> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ItemDivision> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ItemDivision> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ItemDivision update(ItemDivision itemDivision)
		throws SystemException {
		return getPersistence().update(itemDivision);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ItemDivision update(ItemDivision itemDivision,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(itemDivision, serviceContext);
	}

	/**
	* Returns all the item divisions where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findByitemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByitemId(itemId);
	}

	/**
	* Returns a range of all the item divisions where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item divisions
	* @param end the upper bound of the range of item divisions (not inclusive)
	* @return the range of matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findByitemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByitemId(itemId, start, end);
	}

	/**
	* Returns an ordered range of all the item divisions where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item divisions
	* @param end the upper bound of the range of item divisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findByitemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByitemId(itemId, start, end, orderByComparator);
	}

	/**
	* Returns the first item division in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision findByitemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByitemId_First(itemId, orderByComparator);
	}

	/**
	* Returns the first item division in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item division, or <code>null</code> if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision fetchByitemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByitemId_First(itemId, orderByComparator);
	}

	/**
	* Returns the last item division in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision findByitemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByitemId_Last(itemId, orderByComparator);
	}

	/**
	* Returns the last item division in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item division, or <code>null</code> if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision fetchByitemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByitemId_Last(itemId, orderByComparator);
	}

	/**
	* Returns the item divisions before and after the current item division in the ordered set where itemId = &#63;.
	*
	* @param itemDivisionPK the primary key of the current item division
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a item division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision[] findByitemId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK,
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByitemId_PrevAndNext(itemDivisionPK, itemId,
			orderByComparator);
	}

	/**
	* Removes all the item divisions where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByitemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByitemId(itemId);
	}

	/**
	* Returns the number of item divisions where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByitemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByitemId(itemId);
	}

	/**
	* Returns all the item divisions where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @return the matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findBydivisionId(
		long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydivisionId(divisionId);
	}

	/**
	* Returns a range of all the item divisions where divisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param divisionId the division ID
	* @param start the lower bound of the range of item divisions
	* @param end the upper bound of the range of item divisions (not inclusive)
	* @return the range of matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findBydivisionId(
		long divisionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydivisionId(divisionId, start, end);
	}

	/**
	* Returns an ordered range of all the item divisions where divisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param divisionId the division ID
	* @param start the lower bound of the range of item divisions
	* @param end the upper bound of the range of item divisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findBydivisionId(
		long divisionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydivisionId(divisionId, start, end, orderByComparator);
	}

	/**
	* Returns the first item division in the ordered set where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision findBydivisionId_First(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydivisionId_First(divisionId, orderByComparator);
	}

	/**
	* Returns the first item division in the ordered set where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item division, or <code>null</code> if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision fetchBydivisionId_First(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBydivisionId_First(divisionId, orderByComparator);
	}

	/**
	* Returns the last item division in the ordered set where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision findBydivisionId_Last(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydivisionId_Last(divisionId, orderByComparator);
	}

	/**
	* Returns the last item division in the ordered set where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item division, or <code>null</code> if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision fetchBydivisionId_Last(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBydivisionId_Last(divisionId, orderByComparator);
	}

	/**
	* Returns the item divisions before and after the current item division in the ordered set where divisionId = &#63;.
	*
	* @param itemDivisionPK the primary key of the current item division
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a item division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision[] findBydivisionId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK,
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydivisionId_PrevAndNext(itemDivisionPK, divisionId,
			orderByComparator);
	}

	/**
	* Removes all the item divisions where divisionId = &#63; from the database.
	*
	* @param divisionId the division ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBydivisionId(long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBydivisionId(divisionId);
	}

	/**
	* Returns the number of item divisions where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @return the number of matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static int countBydivisionId(long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBydivisionId(divisionId);
	}

	/**
	* Caches the item division in the entity cache if it is enabled.
	*
	* @param itemDivision the item division
	*/
	public static void cacheResult(
		com.idetronic.subur.model.ItemDivision itemDivision) {
		getPersistence().cacheResult(itemDivision);
	}

	/**
	* Caches the item divisions in the entity cache if it is enabled.
	*
	* @param itemDivisions the item divisions
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.ItemDivision> itemDivisions) {
		getPersistence().cacheResult(itemDivisions);
	}

	/**
	* Creates a new item division with the primary key. Does not add the item division to the database.
	*
	* @param itemDivisionPK the primary key for the new item division
	* @return the new item division
	*/
	public static com.idetronic.subur.model.ItemDivision create(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK) {
		return getPersistence().create(itemDivisionPK);
	}

	/**
	* Removes the item division with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemDivisionPK the primary key of the item division
	* @return the item division that was removed
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a item division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision remove(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemDivisionPK);
	}

	public static com.idetronic.subur.model.ItemDivision updateImpl(
		com.idetronic.subur.model.ItemDivision itemDivision)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(itemDivision);
	}

	/**
	* Returns the item division with the primary key or throws a {@link com.idetronic.subur.NoSuchItemDivisionException} if it could not be found.
	*
	* @param itemDivisionPK the primary key of the item division
	* @return the item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a item division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision findByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemDivisionPK);
	}

	/**
	* Returns the item division with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemDivisionPK the primary key of the item division
	* @return the item division, or <code>null</code> if a item division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemDivision fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemDivisionPK);
	}

	/**
	* Returns all the item divisions.
	*
	* @return the item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the item divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item divisions
	* @param end the upper bound of the range of item divisions (not inclusive)
	* @return the range of item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the item divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item divisions
	* @param end the upper bound of the range of item divisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemDivision> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the item divisions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item divisions.
	*
	* @return the number of item divisions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ItemDivisionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemDivisionPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					ItemDivisionPersistence.class.getName());

			ReferenceRegistry.registerReference(ItemDivisionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ItemDivisionPersistence persistence) {
	}

	private static ItemDivisionPersistence _persistence;
}