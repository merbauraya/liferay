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

import com.idetronic.ruangj.model.Item;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemPersistenceImpl
 * @see ItemUtil
 * @generated
 */
public interface ItemPersistence extends BasePersistence<Item> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemUtil} to access the item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the items where itemType = &#63;.
	*
	* @param itemType the item type
	* @return the matching items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findByItemType(
		int itemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the items where itemType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemType the item type
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @return the range of matching items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findByItemType(
		int itemType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the items where itemType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemType the item type
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findByItemType(
		int itemType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item in the ordered set where itemType = &#63;.
	*
	* @param itemType the item type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item
	* @throws com.idetronic.ruangj.NoSuchItemException if a matching item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item findByItemType_First(int itemType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item in the ordered set where itemType = &#63;.
	*
	* @param itemType the item type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item, or <code>null</code> if a matching item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item fetchByItemType_First(int itemType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item in the ordered set where itemType = &#63;.
	*
	* @param itemType the item type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item
	* @throws com.idetronic.ruangj.NoSuchItemException if a matching item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item findByItemType_Last(int itemType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item in the ordered set where itemType = &#63;.
	*
	* @param itemType the item type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item, or <code>null</code> if a matching item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item fetchByItemType_Last(int itemType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the items before and after the current item in the ordered set where itemType = &#63;.
	*
	* @param itemId the primary key of the current item
	* @param itemType the item type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item
	* @throws com.idetronic.ruangj.NoSuchItemException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item[] findByItemType_PrevAndNext(
		long itemId, int itemType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the items where itemType = &#63; from the database.
	*
	* @param itemType the item type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemType(int itemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of items where itemType = &#63;.
	*
	* @param itemType the item type
	* @return the number of matching items
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemType(int itemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the items where status = &#63;.
	*
	* @param status the status
	* @return the matching items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the items where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @return the range of matching items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the items where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item
	* @throws com.idetronic.ruangj.NoSuchItemException if a matching item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item findByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item, or <code>null</code> if a matching item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item fetchByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item
	* @throws com.idetronic.ruangj.NoSuchItemException if a matching item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item findByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item, or <code>null</code> if a matching item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item fetchByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the items before and after the current item in the ordered set where status = &#63;.
	*
	* @param itemId the primary key of the current item
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item
	* @throws com.idetronic.ruangj.NoSuchItemException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item[] findByStatus_PrevAndNext(
		long itemId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.ruangj.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the items where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of items where status = &#63;.
	*
	* @param status the status
	* @return the number of matching items
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the item in the entity cache if it is enabled.
	*
	* @param item the item
	*/
	public void cacheResult(com.idetronic.ruangj.model.Item item);

	/**
	* Caches the items in the entity cache if it is enabled.
	*
	* @param items the items
	*/
	public void cacheResult(
		java.util.List<com.idetronic.ruangj.model.Item> items);

	/**
	* Creates a new item with the primary key. Does not add the item to the database.
	*
	* @param itemId the primary key for the new item
	* @return the new item
	*/
	public com.idetronic.ruangj.model.Item create(long itemId);

	/**
	* Removes the item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the item
	* @return the item that was removed
	* @throws com.idetronic.ruangj.NoSuchItemException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item remove(long itemId)
		throws com.idetronic.ruangj.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.ruangj.model.Item updateImpl(
		com.idetronic.ruangj.model.Item item)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item with the primary key or throws a {@link com.idetronic.ruangj.NoSuchItemException} if it could not be found.
	*
	* @param itemId the primary key of the item
	* @return the item
	* @throws com.idetronic.ruangj.NoSuchItemException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item findByPrimaryKey(long itemId)
		throws com.idetronic.ruangj.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the item
	* @return the item, or <code>null</code> if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.ruangj.model.Item fetchByPrimaryKey(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the items.
	*
	* @return the items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @return the range of items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.ruangj.model.Item> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of items.
	*
	* @return the number of items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}