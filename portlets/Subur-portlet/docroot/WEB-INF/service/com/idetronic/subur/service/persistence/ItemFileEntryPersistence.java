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

import com.idetronic.subur.model.ItemFileEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item file entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemFileEntryPersistenceImpl
 * @see ItemFileEntryUtil
 * @generated
 */
public interface ItemFileEntryPersistence extends BasePersistence<ItemFileEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemFileEntryUtil} to access the item file entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the item file entries where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching item file entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemFileEntry> findBybyItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item file entries where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @return the range of matching item file entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemFileEntry> findBybyItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item file entries where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item file entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemFileEntry> findBybyItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item file entry
	* @throws com.idetronic.subur.NoSuchItemFileEntryException if a matching item file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemFileEntry findBybyItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item file entry, or <code>null</code> if a matching item file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemFileEntry fetchBybyItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item file entry
	* @throws com.idetronic.subur.NoSuchItemFileEntryException if a matching item file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemFileEntry findBybyItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item file entry, or <code>null</code> if a matching item file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemFileEntry fetchBybyItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item file entries before and after the current item file entry in the ordered set where itemId = &#63;.
	*
	* @param itemFileEntryPK the primary key of the current item file entry
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item file entry
	* @throws com.idetronic.subur.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemFileEntry[] findBybyItemId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemFileEntryPK itemFileEntryPK,
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item file entries where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item file entries where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching item file entries
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the item file entry in the entity cache if it is enabled.
	*
	* @param itemFileEntry the item file entry
	*/
	public void cacheResult(
		com.idetronic.subur.model.ItemFileEntry itemFileEntry);

	/**
	* Caches the item file entries in the entity cache if it is enabled.
	*
	* @param itemFileEntries the item file entries
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.ItemFileEntry> itemFileEntries);

	/**
	* Creates a new item file entry with the primary key. Does not add the item file entry to the database.
	*
	* @param itemFileEntryPK the primary key for the new item file entry
	* @return the new item file entry
	*/
	public com.idetronic.subur.model.ItemFileEntry create(
		com.idetronic.subur.service.persistence.ItemFileEntryPK itemFileEntryPK);

	/**
	* Removes the item file entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemFileEntryPK the primary key of the item file entry
	* @return the item file entry that was removed
	* @throws com.idetronic.subur.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemFileEntry remove(
		com.idetronic.subur.service.persistence.ItemFileEntryPK itemFileEntryPK)
		throws com.idetronic.subur.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.ItemFileEntry updateImpl(
		com.idetronic.subur.model.ItemFileEntry itemFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item file entry with the primary key or throws a {@link com.idetronic.subur.NoSuchItemFileEntryException} if it could not be found.
	*
	* @param itemFileEntryPK the primary key of the item file entry
	* @return the item file entry
	* @throws com.idetronic.subur.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemFileEntry findByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemFileEntryPK itemFileEntryPK)
		throws com.idetronic.subur.NoSuchItemFileEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item file entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemFileEntryPK the primary key of the item file entry
	* @return the item file entry, or <code>null</code> if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemFileEntry fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemFileEntryPK itemFileEntryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item file entries.
	*
	* @return the item file entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemFileEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item file entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @return the range of item file entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemFileEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item file entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item file entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemFileEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item file entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item file entries.
	*
	* @return the number of item file entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}