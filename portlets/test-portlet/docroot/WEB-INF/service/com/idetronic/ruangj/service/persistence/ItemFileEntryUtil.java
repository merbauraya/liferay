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

package com.idetronic.ruangj.service.persistence;

import com.idetronic.ruangj.model.ItemFileEntry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the item file entry service. This utility wraps {@link ItemFileEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemFileEntryPersistence
 * @see ItemFileEntryPersistenceImpl
 * @generated
 */
public class ItemFileEntryUtil {
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
	public static void clearCache(ItemFileEntry itemFileEntry) {
		getPersistence().clearCache(itemFileEntry);
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
	public static List<ItemFileEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ItemFileEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ItemFileEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ItemFileEntry update(ItemFileEntry itemFileEntry)
		throws SystemException {
		return getPersistence().update(itemFileEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ItemFileEntry update(ItemFileEntry itemFileEntry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(itemFileEntry, serviceContext);
	}

	/**
	* Returns all the item file entries where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.ruangj.model.ItemFileEntry> findByItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemId(itemId);
	}

	/**
	* Returns a range of all the item file entries where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @return the range of matching item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.ruangj.model.ItemFileEntry> findByItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemId(itemId, start, end);
	}

	/**
	* Returns an ordered range of all the item file entries where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.ruangj.model.ItemFileEntry> findByItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemId(itemId, start, end, orderByComparator);
	}

	/**
	* Returns the first item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item file entry
	* @throws com.idetronic.ruangj.NoSuchItemFileEntryException if a matching item file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry findByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemId_First(itemId, orderByComparator);
	}

	/**
	* Returns the first item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item file entry, or <code>null</code> if a matching item file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry fetchByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByItemId_First(itemId, orderByComparator);
	}

	/**
	* Returns the last item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item file entry
	* @throws com.idetronic.ruangj.NoSuchItemFileEntryException if a matching item file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry findByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemId_Last(itemId, orderByComparator);
	}

	/**
	* Returns the last item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item file entry, or <code>null</code> if a matching item file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry fetchByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByItemId_Last(itemId, orderByComparator);
	}

	/**
	* Returns the item file entries before and after the current item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemEntryId the primary key of the current item file entry
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item file entry
	* @throws com.idetronic.ruangj.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry[] findByItemId_PrevAndNext(
		long itemEntryId, long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemId_PrevAndNext(itemEntryId, itemId,
			orderByComparator);
	}

	/**
	* Removes all the item file entries where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByItemId(itemId);
	}

	/**
	* Returns the number of item file entries where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByItemId(itemId);
	}

	/**
	* Caches the item file entry in the entity cache if it is enabled.
	*
	* @param itemFileEntry the item file entry
	*/
	public static void cacheResult(
		com.idetronic.ruangj.model.ItemFileEntry itemFileEntry) {
		getPersistence().cacheResult(itemFileEntry);
	}

	/**
	* Caches the item file entries in the entity cache if it is enabled.
	*
	* @param itemFileEntries the item file entries
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.ruangj.model.ItemFileEntry> itemFileEntries) {
		getPersistence().cacheResult(itemFileEntries);
	}

	/**
	* Creates a new item file entry with the primary key. Does not add the item file entry to the database.
	*
	* @param itemEntryId the primary key for the new item file entry
	* @return the new item file entry
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry create(
		long itemEntryId) {
		return getPersistence().create(itemEntryId);
	}

	/**
	* Removes the item file entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemEntryId the primary key of the item file entry
	* @return the item file entry that was removed
	* @throws com.idetronic.ruangj.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry remove(
		long itemEntryId)
		throws com.idetronic.ruangj.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemEntryId);
	}

	public static com.idetronic.ruangj.model.ItemFileEntry updateImpl(
		com.idetronic.ruangj.model.ItemFileEntry itemFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(itemFileEntry);
	}

	/**
	* Returns the item file entry with the primary key or throws a {@link com.idetronic.ruangj.NoSuchItemFileEntryException} if it could not be found.
	*
	* @param itemEntryId the primary key of the item file entry
	* @return the item file entry
	* @throws com.idetronic.ruangj.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry findByPrimaryKey(
		long itemEntryId)
		throws com.idetronic.ruangj.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemEntryId);
	}

	/**
	* Returns the item file entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemEntryId the primary key of the item file entry
	* @return the item file entry, or <code>null</code> if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry fetchByPrimaryKey(
		long itemEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemEntryId);
	}

	/**
	* Returns all the item file entries.
	*
	* @return the item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.ruangj.model.ItemFileEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the item file entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @return the range of item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.ruangj.model.ItemFileEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the item file entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.ruangj.model.ItemFileEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the item file entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item file entries.
	*
	* @return the number of item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ItemFileEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemFileEntryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.ruangj.service.ClpSerializer.getServletContextName(),
					ItemFileEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ItemFileEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ItemFileEntryPersistence persistence) {
	}

	private static ItemFileEntryPersistence _persistence;
}