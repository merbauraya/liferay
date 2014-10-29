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

package com.idetronic.portlet.service.persistence;

import com.idetronic.portlet.model.OrgChart;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the org chart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see OrgChartPersistenceImpl
 * @see OrgChartUtil
 * @generated
 */
public interface OrgChartPersistence extends BasePersistence<OrgChart> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrgChartUtil} to access the org chart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the org charts where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching org charts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.OrgChart> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the org charts where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.OrgChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of org charts
	* @param end the upper bound of the range of org charts (not inclusive)
	* @return the range of matching org charts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.OrgChart> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the org charts where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.OrgChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of org charts
	* @param end the upper bound of the range of org charts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching org charts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.OrgChart> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first org chart in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching org chart
	* @throws com.idetronic.portlet.NoSuchOrgChartException if a matching org chart could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.OrgChart findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchOrgChartException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first org chart in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching org chart, or <code>null</code> if a matching org chart could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.OrgChart fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last org chart in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching org chart
	* @throws com.idetronic.portlet.NoSuchOrgChartException if a matching org chart could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.OrgChart findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchOrgChartException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last org chart in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching org chart, or <code>null</code> if a matching org chart could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.OrgChart fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the org charts before and after the current org chart in the ordered set where userId = &#63;.
	*
	* @param orgChartPK the primary key of the current org chart
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next org chart
	* @throws com.idetronic.portlet.NoSuchOrgChartException if a org chart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.OrgChart[] findByuserId_PrevAndNext(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchOrgChartException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the org charts where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of org charts where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching org charts
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the org chart in the entity cache if it is enabled.
	*
	* @param orgChart the org chart
	*/
	public void cacheResult(com.idetronic.portlet.model.OrgChart orgChart);

	/**
	* Caches the org charts in the entity cache if it is enabled.
	*
	* @param orgCharts the org charts
	*/
	public void cacheResult(
		java.util.List<com.idetronic.portlet.model.OrgChart> orgCharts);

	/**
	* Creates a new org chart with the primary key. Does not add the org chart to the database.
	*
	* @param orgChartPK the primary key for the new org chart
	* @return the new org chart
	*/
	public com.idetronic.portlet.model.OrgChart create(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK);

	/**
	* Removes the org chart with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgChartPK the primary key of the org chart
	* @return the org chart that was removed
	* @throws com.idetronic.portlet.NoSuchOrgChartException if a org chart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.OrgChart remove(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK)
		throws com.idetronic.portlet.NoSuchOrgChartException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.portlet.model.OrgChart updateImpl(
		com.idetronic.portlet.model.OrgChart orgChart)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the org chart with the primary key or throws a {@link com.idetronic.portlet.NoSuchOrgChartException} if it could not be found.
	*
	* @param orgChartPK the primary key of the org chart
	* @return the org chart
	* @throws com.idetronic.portlet.NoSuchOrgChartException if a org chart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.OrgChart findByPrimaryKey(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK)
		throws com.idetronic.portlet.NoSuchOrgChartException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the org chart with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orgChartPK the primary key of the org chart
	* @return the org chart, or <code>null</code> if a org chart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.OrgChart fetchByPrimaryKey(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the org charts.
	*
	* @return the org charts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.OrgChart> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the org charts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.OrgChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of org charts
	* @param end the upper bound of the range of org charts (not inclusive)
	* @return the range of org charts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.OrgChart> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the org charts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.OrgChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of org charts
	* @param end the upper bound of the range of org charts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of org charts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.OrgChart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the org charts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of org charts.
	*
	* @return the number of org charts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}