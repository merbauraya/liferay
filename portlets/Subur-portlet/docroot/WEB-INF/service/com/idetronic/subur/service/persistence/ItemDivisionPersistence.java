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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item division service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemDivisionPersistenceImpl
 * @see ItemDivisionUtil
 * @generated
 */
public interface ItemDivisionPersistence extends BasePersistence<ItemDivision> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemDivisionUtil} to access the item division persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the item divisions where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemDivision> findByitemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.ItemDivision> findByitemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.ItemDivision> findByitemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item division in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision findByitemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item division in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item division, or <code>null</code> if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision fetchByitemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item division in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision findByitemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item division in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item division, or <code>null</code> if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision fetchByitemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.ItemDivision[] findByitemId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK,
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item divisions where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByitemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item divisions where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public int countByitemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item divisions where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @return the matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemDivision> findBydivisionId(
		long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.ItemDivision> findBydivisionId(
		long divisionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.ItemDivision> findBydivisionId(
		long divisionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item division in the ordered set where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision findBydivisionId_First(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item division in the ordered set where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item division, or <code>null</code> if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision fetchBydivisionId_First(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item division in the ordered set where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision findBydivisionId_Last(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item division in the ordered set where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item division, or <code>null</code> if a matching item division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision fetchBydivisionId_Last(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.ItemDivision[] findBydivisionId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK,
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item divisions where divisionId = &#63; from the database.
	*
	* @param divisionId the division ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBydivisionId(long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item divisions where divisionId = &#63;.
	*
	* @param divisionId the division ID
	* @return the number of matching item divisions
	* @throws SystemException if a system exception occurred
	*/
	public int countBydivisionId(long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the item division in the entity cache if it is enabled.
	*
	* @param itemDivision the item division
	*/
	public void cacheResult(com.idetronic.subur.model.ItemDivision itemDivision);

	/**
	* Caches the item divisions in the entity cache if it is enabled.
	*
	* @param itemDivisions the item divisions
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.ItemDivision> itemDivisions);

	/**
	* Creates a new item division with the primary key. Does not add the item division to the database.
	*
	* @param itemDivisionPK the primary key for the new item division
	* @return the new item division
	*/
	public com.idetronic.subur.model.ItemDivision create(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK);

	/**
	* Removes the item division with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemDivisionPK the primary key of the item division
	* @return the item division that was removed
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a item division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision remove(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.ItemDivision updateImpl(
		com.idetronic.subur.model.ItemDivision itemDivision)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item division with the primary key or throws a {@link com.idetronic.subur.NoSuchItemDivisionException} if it could not be found.
	*
	* @param itemDivisionPK the primary key of the item division
	* @return the item division
	* @throws com.idetronic.subur.NoSuchItemDivisionException if a item division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision findByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK)
		throws com.idetronic.subur.NoSuchItemDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item division with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemDivisionPK the primary key of the item division
	* @return the item division, or <code>null</code> if a item division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemDivision fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemDivisionPK itemDivisionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item divisions.
	*
	* @return the item divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemDivision> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.ItemDivision> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.ItemDivision> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item divisions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item divisions.
	*
	* @return the number of item divisions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}