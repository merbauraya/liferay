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

import com.idetronic.subur.model.StatViewPeriod;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the stat view period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewPeriodPersistenceImpl
 * @see StatViewPeriodUtil
 * @generated
 */
public interface StatViewPeriodPersistence extends BasePersistence<StatViewPeriod> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatViewPeriodUtil} to access the stat view period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the stat view periods where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching stat view periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewPeriod> findByItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat view periods where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of stat view periods
	* @param end the upper bound of the range of stat view periods (not inclusive)
	* @return the range of matching stat view periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewPeriod> findByItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat view periods where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of stat view periods
	* @param end the upper bound of the range of stat view periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat view periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewPeriod> findByItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat view period in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat view period
	* @throws com.idetronic.subur.NoSuchStatViewPeriodException if a matching stat view period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewPeriod findByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat view period in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat view period, or <code>null</code> if a matching stat view period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewPeriod fetchByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat view period in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat view period
	* @throws com.idetronic.subur.NoSuchStatViewPeriodException if a matching stat view period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewPeriod findByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat view period in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat view period, or <code>null</code> if a matching stat view period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewPeriod fetchByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view periods before and after the current stat view period in the ordered set where itemId = &#63;.
	*
	* @param id the primary key of the current stat view period
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat view period
	* @throws com.idetronic.subur.NoSuchStatViewPeriodException if a stat view period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewPeriod[] findByItemId_PrevAndNext(
		long id, long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat view periods where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view periods where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching stat view periods
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the stat view period in the entity cache if it is enabled.
	*
	* @param statViewPeriod the stat view period
	*/
	public void cacheResult(
		com.idetronic.subur.model.StatViewPeriod statViewPeriod);

	/**
	* Caches the stat view periods in the entity cache if it is enabled.
	*
	* @param statViewPeriods the stat view periods
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.StatViewPeriod> statViewPeriods);

	/**
	* Creates a new stat view period with the primary key. Does not add the stat view period to the database.
	*
	* @param id the primary key for the new stat view period
	* @return the new stat view period
	*/
	public com.idetronic.subur.model.StatViewPeriod create(long id);

	/**
	* Removes the stat view period with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat view period
	* @return the stat view period that was removed
	* @throws com.idetronic.subur.NoSuchStatViewPeriodException if a stat view period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewPeriod remove(long id)
		throws com.idetronic.subur.NoSuchStatViewPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.StatViewPeriod updateImpl(
		com.idetronic.subur.model.StatViewPeriod statViewPeriod)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view period with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewPeriodException} if it could not be found.
	*
	* @param id the primary key of the stat view period
	* @return the stat view period
	* @throws com.idetronic.subur.NoSuchStatViewPeriodException if a stat view period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewPeriod findByPrimaryKey(long id)
		throws com.idetronic.subur.NoSuchStatViewPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view period with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat view period
	* @return the stat view period, or <code>null</code> if a stat view period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewPeriod fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the stat view periods.
	*
	* @return the stat view periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewPeriod> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat view periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view periods
	* @param end the upper bound of the range of stat view periods (not inclusive)
	* @return the range of stat view periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewPeriod> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat view periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view periods
	* @param end the upper bound of the range of stat view periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat view periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewPeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat view periods from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view periods.
	*
	* @return the number of stat view periods
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}