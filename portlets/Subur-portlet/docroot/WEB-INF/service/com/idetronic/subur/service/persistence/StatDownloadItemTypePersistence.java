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

import com.idetronic.subur.model.StatDownloadItemType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the stat download item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadItemTypePersistenceImpl
 * @see StatDownloadItemTypeUtil
 * @generated
 */
public interface StatDownloadItemTypePersistence extends BasePersistence<StatDownloadItemType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatDownloadItemTypeUtil} to access the stat download item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the stat download item types where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the matching stat download item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadItemType> findByItemType(
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat download item types where itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of stat download item types
	* @param end the upper bound of the range of stat download item types (not inclusive)
	* @return the range of matching stat download item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadItemType> findByItemType(
		long itemTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat download item types where itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of stat download item types
	* @param end the upper bound of the range of stat download item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat download item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadItemType> findByItemType(
		long itemTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat download item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download item type
	* @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a matching stat download item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadItemType findByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat download item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download item type, or <code>null</code> if a matching stat download item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadItemType fetchByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat download item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download item type
	* @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a matching stat download item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadItemType findByItemType_Last(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat download item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download item type, or <code>null</code> if a matching stat download item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadItemType fetchByItemType_Last(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download item types before and after the current stat download item type in the ordered set where itemTypeId = &#63;.
	*
	* @param id the primary key of the current stat download item type
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat download item type
	* @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a stat download item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadItemType[] findByItemType_PrevAndNext(
		long id, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat download item types where itemTypeId = &#63; from the database.
	*
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat download item types where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the number of matching stat download item types
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the stat download item type in the entity cache if it is enabled.
	*
	* @param statDownloadItemType the stat download item type
	*/
	public void cacheResult(
		com.idetronic.subur.model.StatDownloadItemType statDownloadItemType);

	/**
	* Caches the stat download item types in the entity cache if it is enabled.
	*
	* @param statDownloadItemTypes the stat download item types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.StatDownloadItemType> statDownloadItemTypes);

	/**
	* Creates a new stat download item type with the primary key. Does not add the stat download item type to the database.
	*
	* @param id the primary key for the new stat download item type
	* @return the new stat download item type
	*/
	public com.idetronic.subur.model.StatDownloadItemType create(long id);

	/**
	* Removes the stat download item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat download item type
	* @return the stat download item type that was removed
	* @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a stat download item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadItemType remove(long id)
		throws com.idetronic.subur.NoSuchStatDownloadItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.StatDownloadItemType updateImpl(
		com.idetronic.subur.model.StatDownloadItemType statDownloadItemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download item type with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadItemTypeException} if it could not be found.
	*
	* @param id the primary key of the stat download item type
	* @return the stat download item type
	* @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a stat download item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadItemType findByPrimaryKey(
		long id)
		throws com.idetronic.subur.NoSuchStatDownloadItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download item type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat download item type
	* @return the stat download item type, or <code>null</code> if a stat download item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadItemType fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the stat download item types.
	*
	* @return the stat download item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadItemType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat download item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download item types
	* @param end the upper bound of the range of stat download item types (not inclusive)
	* @return the range of stat download item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadItemType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat download item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download item types
	* @param end the upper bound of the range of stat download item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat download item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat download item types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat download item types.
	*
	* @return the number of stat download item types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}