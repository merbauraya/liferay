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

import com.idetronic.subur.model.ViewSummary;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the view summary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ViewSummaryPersistenceImpl
 * @see ViewSummaryUtil
 * @generated
 */
public interface ViewSummaryPersistence extends BasePersistence<ViewSummary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ViewSummaryUtil} to access the view summary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the view summaries where status = &#63;.
	*
	* @param status the status
	* @return the matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the view summaries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @return the range of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the view summaries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first view summary in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first view summary in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching view summary, or <code>null</code> if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last view summary in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary findByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last view summary in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching view summary, or <code>null</code> if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the view summaries before and after the current view summary in the ordered set where status = &#63;.
	*
	* @param id the primary key of the current view summary
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary[] findByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the view summaries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of view summaries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the view summaries where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @return the matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByPeriod(
		int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the view summaries where perMonth = &#63; and perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @return the range of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByPeriod(
		int perMonth, int perYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the view summaries where perMonth = &#63; and perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByPeriod(
		int perMonth, int perYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary findByPeriod_First(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching view summary, or <code>null</code> if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary fetchByPeriod_First(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary findByPeriod_Last(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching view summary, or <code>null</code> if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary fetchByPeriod_Last(
		int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the view summaries before and after the current view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	*
	* @param id the primary key of the current view summary
	* @param perMonth the per month
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary[] findByPeriod_PrevAndNext(
		long id, int perMonth, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the view summaries where perMonth = &#63; and perYear = &#63; from the database.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPeriod(int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of view summaries where perMonth = &#63; and perYear = &#63;.
	*
	* @param perMonth the per month
	* @param perYear the per year
	* @return the number of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByPeriod(int perMonth, int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the view summaries where perYear = &#63;.
	*
	* @param perYear the per year
	* @return the matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByYear(
		int perYear) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the view summaries where perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perYear the per year
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @return the range of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByYear(
		int perYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the view summaries where perYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param perYear the per year
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findByYear(
		int perYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first view summary in the ordered set where perYear = &#63;.
	*
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary findByYear_First(int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first view summary in the ordered set where perYear = &#63;.
	*
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching view summary, or <code>null</code> if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary fetchByYear_First(
		int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last view summary in the ordered set where perYear = &#63;.
	*
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary findByYear_Last(int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last view summary in the ordered set where perYear = &#63;.
	*
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching view summary, or <code>null</code> if a matching view summary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary fetchByYear_Last(int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the view summaries before and after the current view summary in the ordered set where perYear = &#63;.
	*
	* @param id the primary key of the current view summary
	* @param perYear the per year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary[] findByYear_PrevAndNext(
		long id, int perYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the view summaries where perYear = &#63; from the database.
	*
	* @param perYear the per year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByYear(int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of view summaries where perYear = &#63;.
	*
	* @param perYear the per year
	* @return the number of matching view summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByYear(int perYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the view summary in the entity cache if it is enabled.
	*
	* @param viewSummary the view summary
	*/
	public void cacheResult(com.idetronic.subur.model.ViewSummary viewSummary);

	/**
	* Caches the view summaries in the entity cache if it is enabled.
	*
	* @param viewSummaries the view summaries
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.ViewSummary> viewSummaries);

	/**
	* Creates a new view summary with the primary key. Does not add the view summary to the database.
	*
	* @param id the primary key for the new view summary
	* @return the new view summary
	*/
	public com.idetronic.subur.model.ViewSummary create(long id);

	/**
	* Removes the view summary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the view summary
	* @return the view summary that was removed
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary remove(long id)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.ViewSummary updateImpl(
		com.idetronic.subur.model.ViewSummary viewSummary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the view summary with the primary key or throws a {@link com.idetronic.subur.NoSuchViewSummaryException} if it could not be found.
	*
	* @param id the primary key of the view summary
	* @return the view summary
	* @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary findByPrimaryKey(long id)
		throws com.idetronic.subur.NoSuchViewSummaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the view summary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the view summary
	* @return the view summary, or <code>null</code> if a view summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ViewSummary fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the view summaries.
	*
	* @return the view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the view summaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @return the range of view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the view summaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of view summaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ViewSummary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the view summaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of view summaries.
	*
	* @return the number of view summaries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}