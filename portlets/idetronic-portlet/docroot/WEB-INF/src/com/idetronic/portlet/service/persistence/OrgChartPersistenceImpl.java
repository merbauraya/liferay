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

import com.idetronic.portlet.NoSuchOrgChartException;
import com.idetronic.portlet.model.OrgChart;
import com.idetronic.portlet.model.impl.OrgChartImpl;
import com.idetronic.portlet.model.impl.OrgChartModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the org chart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see OrgChartPersistence
 * @see OrgChartUtil
 * @generated
 */
public class OrgChartPersistenceImpl extends BasePersistenceImpl<OrgChart>
	implements OrgChartPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrgChartUtil} to access the org chart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrgChartImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartModelImpl.FINDER_CACHE_ENABLED, OrgChartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartModelImpl.FINDER_CACHE_ENABLED, OrgChartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartModelImpl.FINDER_CACHE_ENABLED, OrgChartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartModelImpl.FINDER_CACHE_ENABLED, OrgChartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			OrgChartModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the org charts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching org charts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrgChart> findByuserId(long userId) throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OrgChart> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

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
	@Override
	public List<OrgChart> findByuserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<OrgChart> list = (List<OrgChart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrgChart orgChart : list) {
				if ((userId != orgChart.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ORGCHART_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrgChartModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<OrgChart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrgChart>(list);
				}
				else {
					list = (List<OrgChart>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first org chart in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching org chart
	 * @throws com.idetronic.portlet.NoSuchOrgChartException if a matching org chart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgChartException, SystemException {
		OrgChart orgChart = fetchByuserId_First(userId, orderByComparator);

		if (orgChart != null) {
			return orgChart;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrgChartException(msg.toString());
	}

	/**
	 * Returns the first org chart in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching org chart, or <code>null</code> if a matching org chart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OrgChart> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last org chart in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching org chart
	 * @throws com.idetronic.portlet.NoSuchOrgChartException if a matching org chart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgChartException, SystemException {
		OrgChart orgChart = fetchByuserId_Last(userId, orderByComparator);

		if (orgChart != null) {
			return orgChart;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrgChartException(msg.toString());
	}

	/**
	 * Returns the last org chart in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching org chart, or <code>null</code> if a matching org chart could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<OrgChart> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public OrgChart[] findByuserId_PrevAndNext(OrgChartPK orgChartPK,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchOrgChartException, SystemException {
		OrgChart orgChart = findByPrimaryKey(orgChartPK);

		Session session = null;

		try {
			session = openSession();

			OrgChart[] array = new OrgChartImpl[3];

			array[0] = getByuserId_PrevAndNext(session, orgChart, userId,
					orderByComparator, true);

			array[1] = orgChart;

			array[2] = getByuserId_PrevAndNext(session, orgChart, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrgChart getByuserId_PrevAndNext(Session session,
		OrgChart orgChart, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGCHART_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(OrgChartModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(orgChart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrgChart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the org charts where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (OrgChart orgChart : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(orgChart);
		}
	}

	/**
	 * Returns the number of org charts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching org charts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGCHART_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "orgChart.id.userId = ?";

	public OrgChartPersistenceImpl() {
		setModelClass(OrgChart.class);
	}

	/**
	 * Caches the org chart in the entity cache if it is enabled.
	 *
	 * @param orgChart the org chart
	 */
	@Override
	public void cacheResult(OrgChart orgChart) {
		EntityCacheUtil.putResult(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartImpl.class, orgChart.getPrimaryKey(), orgChart);

		orgChart.resetOriginalValues();
	}

	/**
	 * Caches the org charts in the entity cache if it is enabled.
	 *
	 * @param orgCharts the org charts
	 */
	@Override
	public void cacheResult(List<OrgChart> orgCharts) {
		for (OrgChart orgChart : orgCharts) {
			if (EntityCacheUtil.getResult(
						OrgChartModelImpl.ENTITY_CACHE_ENABLED,
						OrgChartImpl.class, orgChart.getPrimaryKey()) == null) {
				cacheResult(orgChart);
			}
			else {
				orgChart.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all org charts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrgChartImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrgChartImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the org chart.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrgChart orgChart) {
		EntityCacheUtil.removeResult(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartImpl.class, orgChart.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrgChart> orgCharts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrgChart orgChart : orgCharts) {
			EntityCacheUtil.removeResult(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
				OrgChartImpl.class, orgChart.getPrimaryKey());
		}
	}

	/**
	 * Creates a new org chart with the primary key. Does not add the org chart to the database.
	 *
	 * @param orgChartPK the primary key for the new org chart
	 * @return the new org chart
	 */
	@Override
	public OrgChart create(OrgChartPK orgChartPK) {
		OrgChart orgChart = new OrgChartImpl();

		orgChart.setNew(true);
		orgChart.setPrimaryKey(orgChartPK);

		return orgChart;
	}

	/**
	 * Removes the org chart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgChartPK the primary key of the org chart
	 * @return the org chart that was removed
	 * @throws com.idetronic.portlet.NoSuchOrgChartException if a org chart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart remove(OrgChartPK orgChartPK)
		throws NoSuchOrgChartException, SystemException {
		return remove((Serializable)orgChartPK);
	}

	/**
	 * Removes the org chart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the org chart
	 * @return the org chart that was removed
	 * @throws com.idetronic.portlet.NoSuchOrgChartException if a org chart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart remove(Serializable primaryKey)
		throws NoSuchOrgChartException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgChart orgChart = (OrgChart)session.get(OrgChartImpl.class,
					primaryKey);

			if (orgChart == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrgChartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orgChart);
		}
		catch (NoSuchOrgChartException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected OrgChart removeImpl(OrgChart orgChart) throws SystemException {
		orgChart = toUnwrappedModel(orgChart);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orgChart)) {
				orgChart = (OrgChart)session.get(OrgChartImpl.class,
						orgChart.getPrimaryKeyObj());
			}

			if (orgChart != null) {
				session.delete(orgChart);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (orgChart != null) {
			clearCache(orgChart);
		}

		return orgChart;
	}

	@Override
	public OrgChart updateImpl(com.idetronic.portlet.model.OrgChart orgChart)
		throws SystemException {
		orgChart = toUnwrappedModel(orgChart);

		boolean isNew = orgChart.isNew();

		OrgChartModelImpl orgChartModelImpl = (OrgChartModelImpl)orgChart;

		Session session = null;

		try {
			session = openSession();

			if (orgChart.isNew()) {
				session.save(orgChart);

				orgChart.setNew(false);
			}
			else {
				session.merge(orgChart);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrgChartModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((orgChartModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						orgChartModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { orgChartModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
			OrgChartImpl.class, orgChart.getPrimaryKey(), orgChart);

		return orgChart;
	}

	protected OrgChart toUnwrappedModel(OrgChart orgChart) {
		if (orgChart instanceof OrgChartImpl) {
			return orgChart;
		}

		OrgChartImpl orgChartImpl = new OrgChartImpl();

		orgChartImpl.setNew(orgChart.isNew());
		orgChartImpl.setPrimaryKey(orgChart.getPrimaryKey());

		orgChartImpl.setUserId(orgChart.getUserId());
		orgChartImpl.setParentId(orgChart.getParentId());

		return orgChartImpl;
	}

	/**
	 * Returns the org chart with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the org chart
	 * @return the org chart
	 * @throws com.idetronic.portlet.NoSuchOrgChartException if a org chart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrgChartException, SystemException {
		OrgChart orgChart = fetchByPrimaryKey(primaryKey);

		if (orgChart == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrgChartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return orgChart;
	}

	/**
	 * Returns the org chart with the primary key or throws a {@link com.idetronic.portlet.NoSuchOrgChartException} if it could not be found.
	 *
	 * @param orgChartPK the primary key of the org chart
	 * @return the org chart
	 * @throws com.idetronic.portlet.NoSuchOrgChartException if a org chart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart findByPrimaryKey(OrgChartPK orgChartPK)
		throws NoSuchOrgChartException, SystemException {
		return findByPrimaryKey((Serializable)orgChartPK);
	}

	/**
	 * Returns the org chart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the org chart
	 * @return the org chart, or <code>null</code> if a org chart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrgChart orgChart = (OrgChart)EntityCacheUtil.getResult(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
				OrgChartImpl.class, primaryKey);

		if (orgChart == _nullOrgChart) {
			return null;
		}

		if (orgChart == null) {
			Session session = null;

			try {
				session = openSession();

				orgChart = (OrgChart)session.get(OrgChartImpl.class, primaryKey);

				if (orgChart != null) {
					cacheResult(orgChart);
				}
				else {
					EntityCacheUtil.putResult(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
						OrgChartImpl.class, primaryKey, _nullOrgChart);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrgChartModelImpl.ENTITY_CACHE_ENABLED,
					OrgChartImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return orgChart;
	}

	/**
	 * Returns the org chart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orgChartPK the primary key of the org chart
	 * @return the org chart, or <code>null</code> if a org chart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgChart fetchByPrimaryKey(OrgChartPK orgChartPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)orgChartPK);
	}

	/**
	 * Returns all the org charts.
	 *
	 * @return the org charts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrgChart> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OrgChart> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<OrgChart> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<OrgChart> list = (List<OrgChart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGCHART);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGCHART;

				if (pagination) {
					sql = sql.concat(OrgChartModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrgChart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrgChart>(list);
				}
				else {
					list = (List<OrgChart>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the org charts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrgChart orgChart : findAll()) {
			remove(orgChart);
		}
	}

	/**
	 * Returns the number of org charts.
	 *
	 * @return the number of org charts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORGCHART);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the org chart persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.portlet.model.OrgChart")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgChart>> listenersList = new ArrayList<ModelListener<OrgChart>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgChart>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(OrgChartImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGCHART = "SELECT orgChart FROM OrgChart orgChart";
	private static final String _SQL_SELECT_ORGCHART_WHERE = "SELECT orgChart FROM OrgChart orgChart WHERE ";
	private static final String _SQL_COUNT_ORGCHART = "SELECT COUNT(orgChart) FROM OrgChart orgChart";
	private static final String _SQL_COUNT_ORGCHART_WHERE = "SELECT COUNT(orgChart) FROM OrgChart orgChart WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orgChart.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrgChart exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrgChart exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrgChartPersistenceImpl.class);
	private static OrgChart _nullOrgChart = new OrgChartImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrgChart> toCacheModel() {
				return _nullOrgChartCacheModel;
			}
		};

	private static CacheModel<OrgChart> _nullOrgChartCacheModel = new CacheModel<OrgChart>() {
			@Override
			public OrgChart toEntityModel() {
				return _nullOrgChart;
			}
		};
}