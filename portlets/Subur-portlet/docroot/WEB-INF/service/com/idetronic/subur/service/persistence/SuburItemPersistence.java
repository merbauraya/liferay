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

import com.idetronic.subur.model.SuburItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the subur item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburItemPersistenceImpl
 * @see SuburItemUtil
 * @generated
 */
public interface SuburItemPersistence extends BasePersistence<SuburItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SuburItemUtil} to access the subur item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the subur items where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the subur items where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the subur items where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subur item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subur item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subur item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subur item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur items before and after the current subur item in the ordered set where groupId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem[] findByGroupId_PrevAndNext(
		long itemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subur items that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the subur items that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the subur items that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur items before and after the current subur item in the ordered set of subur items that the user has permission to view where groupId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem[] filterFindByGroupId_PrevAndNext(
		long itemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subur items where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subur items where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subur items that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subur items where status = &#63;.
	*
	* @param status the status
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the subur items where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the subur items where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subur item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem findByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subur item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem fetchByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subur item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem findByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subur item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem fetchByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur items before and after the current subur item in the ordered set where status = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem[] findByStatus_PrevAndNext(
		long itemId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subur items where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subur items where status = &#63;.
	*
	* @param status the status
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the subur item in the entity cache if it is enabled.
	*
	* @param suburItem the subur item
	*/
	public void cacheResult(com.idetronic.subur.model.SuburItem suburItem);

	/**
	* Caches the subur items in the entity cache if it is enabled.
	*
	* @param suburItems the subur items
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.SuburItem> suburItems);

	/**
	* Creates a new subur item with the primary key. Does not add the subur item to the database.
	*
	* @param itemId the primary key for the new subur item
	* @return the new subur item
	*/
	public com.idetronic.subur.model.SuburItem create(long itemId);

	/**
	* Removes the subur item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item that was removed
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem remove(long itemId)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.SuburItem updateImpl(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur item with the primary key or throws a {@link com.idetronic.subur.NoSuchItemException} if it could not be found.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem findByPrimaryKey(long itemId)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item, or <code>null</code> if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburItem fetchByPrimaryKey(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subur items.
	*
	* @return the subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the subur items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the subur items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subur items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subur items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subur items.
	*
	* @return the number of subur items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}