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

import com.idetronic.subur.model.ItemItemType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemItemTypePersistenceImpl
 * @see ItemItemTypeUtil
 * @generated
 */
public interface ItemItemTypePersistence extends BasePersistence<ItemItemType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemItemTypeUtil} to access the item item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the item item types where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findByItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item item types where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item item types
	* @param end the upper bound of the range of item item types (not inclusive)
	* @return the range of matching item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findByItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item item types where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item item types
	* @param end the upper bound of the range of item item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findByItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item item type in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item item type
	* @throws com.idetronic.subur.NoSuchItemItemTypeException if a matching item item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType findByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item item type in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item item type, or <code>null</code> if a matching item item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType fetchByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item item type in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item item type
	* @throws com.idetronic.subur.NoSuchItemItemTypeException if a matching item item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType findByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item item type in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item item type, or <code>null</code> if a matching item item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType fetchByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item item types before and after the current item item type in the ordered set where itemId = &#63;.
	*
	* @param itemItemTypePK the primary key of the current item item type
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item item type
	* @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType[] findByItemId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK,
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item item types where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item item types where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching item item types
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item item types where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the matching item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findByItemType(
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item item types where itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of item item types
	* @param end the upper bound of the range of item item types (not inclusive)
	* @return the range of matching item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findByItemType(
		long itemTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item item types where itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of item item types
	* @param end the upper bound of the range of item item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findByItemType(
		long itemTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item item type
	* @throws com.idetronic.subur.NoSuchItemItemTypeException if a matching item item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType findByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item item type, or <code>null</code> if a matching item item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType fetchByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item item type
	* @throws com.idetronic.subur.NoSuchItemItemTypeException if a matching item item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType findByItemType_Last(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item item type, or <code>null</code> if a matching item item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType fetchByItemType_Last(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item item types before and after the current item item type in the ordered set where itemTypeId = &#63;.
	*
	* @param itemItemTypePK the primary key of the current item item type
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item item type
	* @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType[] findByItemType_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK,
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item item types where itemTypeId = &#63; from the database.
	*
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item item types where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the number of matching item item types
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the item item type in the entity cache if it is enabled.
	*
	* @param itemItemType the item item type
	*/
	public void cacheResult(com.idetronic.subur.model.ItemItemType itemItemType);

	/**
	* Caches the item item types in the entity cache if it is enabled.
	*
	* @param itemItemTypes the item item types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.ItemItemType> itemItemTypes);

	/**
	* Creates a new item item type with the primary key. Does not add the item item type to the database.
	*
	* @param itemItemTypePK the primary key for the new item item type
	* @return the new item item type
	*/
	public com.idetronic.subur.model.ItemItemType create(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK);

	/**
	* Removes the item item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemItemTypePK the primary key of the item item type
	* @return the item item type that was removed
	* @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType remove(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK)
		throws com.idetronic.subur.NoSuchItemItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.ItemItemType updateImpl(
		com.idetronic.subur.model.ItemItemType itemItemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item item type with the primary key or throws a {@link com.idetronic.subur.NoSuchItemItemTypeException} if it could not be found.
	*
	* @param itemItemTypePK the primary key of the item item type
	* @return the item item type
	* @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType findByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK)
		throws com.idetronic.subur.NoSuchItemItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item item type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemItemTypePK the primary key of the item item type
	* @return the item item type, or <code>null</code> if a item item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemItemType fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item item types.
	*
	* @return the item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item item types
	* @param end the upper bound of the range of item item types (not inclusive)
	* @return the range of item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item item types
	* @param end the upper bound of the range of item item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item item types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item item types.
	*
	* @return the number of item item types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}