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

import com.idetronic.subur.model.DownloadSummary;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the download summary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see DownloadSummaryPersistenceImpl
 * @see DownloadSummaryUtil
 * @generated
 */
public interface DownloadSummaryPersistence extends BasePersistence<DownloadSummary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DownloadSummaryUtil} to access the download summary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the download summaries where status = &#63;.
	*
	* @param status the status
	* @return the matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the download summaries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @return the range of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the download summaries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first download summary in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first download summary in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching download summary, or <code>null</code> if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last download summary in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last download summary in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching download summary, or <code>null</code> if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the download summaries before and after the current download summary in the ordered set where status = &#63;.
	*
	* @param id the primary key of the current download summary
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary[] findByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the download summaries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of download summaries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the download summaries where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the download summaries where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @return the range of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the download summaries where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first download summary in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first download summary in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching download summary, or <code>null</code> if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last download summary in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last download summary in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching download summary, or <code>null</code> if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the download summaries before and after the current download summary in the ordered set where itemId = &#63;.
	*
	* @param id the primary key of the current download summary
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary[] findByItemId_PrevAndNext(
		long id, long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the download summaries where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of download summaries where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the download summaries where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @return the matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByPeriod(
		int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the download summaries where perMonth = &#63; and perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @return the range of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByPeriod(
		int perMonth, int perYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the download summaries where perMonth = &#63; and perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByPeriod(
		int perMonth, int perYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByPeriod_First(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching download summary, or <code>null</code> if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByPeriod_First(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByPeriod_Last(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching download summary, or <code>null</code> if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByPeriod_Last(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the download summaries before and after the current download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param id the primary key of the current download summary
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary[] findByPeriod_PrevAndNext(
		long id, int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the download summaries where perMonth = &#63; and perYear = &#63; from the database.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPeriod(int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of download summaries where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @return the number of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByPeriod(int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the download summaries where perYear = &#63;.
	*
	* @param perYear the per year
	* @return the matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByYear(
		int perYear) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the download summaries where perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perYear the per year
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @return the range of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByYear(
		int perYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the download summaries where perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perYear the per year
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findByYear(
		int perYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first download summary in the ordered set where perYear = &#63;.
	*
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByYear_First(
		int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first download summary in the ordered set where perYear = &#63;.
	*
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching download summary, or <code>null</code> if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByYear_First(
		int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last download summary in the ordered set where perYear = &#63;.
	*
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByYear_Last(
		int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last download summary in the ordered set where perYear = &#63;.
	*
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching download summary, or <code>null</code> if a matching download summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByYear_Last(
		int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the download summaries before and after the current download summary in the ordered set where perYear = &#63;.
	*
	* @param id the primary key of the current download summary
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary[] findByYear_PrevAndNext(
		long id, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the download summaries where perYear = &#63; from the database.
	*
	* @param perYear the per year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByYear(int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of download summaries where perYear = &#63;.
	*
	* @param perYear the per year
	* @return the number of matching download summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByYear(int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the download summary in the entity cache if it is enabled.
	*
	* @param downloadSummary the download summary
	*/
	public void cacheResult(
		com.idetronic.subur.model.DownloadSummary downloadSummary);

	/**
	* Caches the download summaries in the entity cache if it is enabled.
	*
	* @param downloadSummaries the download summaries
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.DownloadSummary> downloadSummaries);

	/**
	* Creates a new download summary with the primary key. Does not add the download summary to the database.
	*
	* @param id the primary key for the new download summary
	* @return the new download summary
	*/
	public com.idetronic.subur.model.DownloadSummary create(long id);

	/**
	* Removes the download summary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the download summary
	* @return the download summary that was removed
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary remove(long id)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.DownloadSummary updateImpl(
		com.idetronic.subur.model.DownloadSummary downloadSummary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the download summary with the primary key or throws a {@link com.idetronic.subur.NoSuchDownloadSummaryException} if it could not be found.
	*
	* @param id the primary key of the download summary
	* @return the download summary
	* @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary findByPrimaryKey(long id)
		throws com.idetronic.subur.NoSuchDownloadSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the download summary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the download summary
	* @return the download summary, or <code>null</code> if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.DownloadSummary fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the download summaries.
	*
	* @return the download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the download summaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @return the range of download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the download summaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of download summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.DownloadSummary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the download summaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of download summaries.
	*
	* @return the number of download summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}