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

import com.idetronic.subur.NoSuchStatDownloadPeriodException;
import com.idetronic.subur.model.StatDownloadPeriod;
import com.idetronic.subur.model.impl.StatDownloadPeriodImpl;
import com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the stat download period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadPeriodPersistence
 * @see StatDownloadPeriodUtil
 * @generated
 */
public class StatDownloadPeriodPersistenceImpl extends BasePersistenceImpl<StatDownloadPeriod>
	implements StatDownloadPeriodPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatDownloadPeriodUtil} to access the stat download period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatDownloadPeriodImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERIOD = new FinderPath(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPeriod",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD =
		new FinderPath(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPeriod",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			StatDownloadPeriodModelImpl.PERMONTH_COLUMN_BITMASK |
			StatDownloadPeriodModelImpl.PERYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERIOD = new FinderPath(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPeriod",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the stat download periods where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @return the matching stat download periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadPeriod> findByPeriod(int perMonth, int perYear)
		throws SystemException {
		return findByPeriod(perMonth, perYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat download periods where perMonth = &#63; and perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param start the lower bound of the range of stat download periods
	 * @param end the upper bound of the range of stat download periods (not inclusive)
	 * @return the range of matching stat download periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadPeriod> findByPeriod(int perMonth, int perYear,
		int start, int end) throws SystemException {
		return findByPeriod(perMonth, perYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat download periods where perMonth = &#63; and perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param start the lower bound of the range of stat download periods
	 * @param end the upper bound of the range of stat download periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stat download periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadPeriod> findByPeriod(int perMonth, int perYear,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD;
			finderArgs = new Object[] { perMonth, perYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERIOD;
			finderArgs = new Object[] {
					perMonth, perYear,
					
					start, end, orderByComparator
				};
		}

		List<StatDownloadPeriod> list = (List<StatDownloadPeriod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StatDownloadPeriod statDownloadPeriod : list) {
				if ((perMonth != statDownloadPeriod.getPerMonth()) ||
						(perYear != statDownloadPeriod.getPerYear())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STATDOWNLOADPERIOD_WHERE);

			query.append(_FINDER_COLUMN_PERIOD_PERMONTH_2);

			query.append(_FINDER_COLUMN_PERIOD_PERYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatDownloadPeriodModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perMonth);

				qPos.add(perYear);

				if (!pagination) {
					list = (List<StatDownloadPeriod>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatDownloadPeriod>(list);
				}
				else {
					list = (List<StatDownloadPeriod>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat download period
	 * @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a matching stat download period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod findByPeriod_First(int perMonth, int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadPeriodException, SystemException {
		StatDownloadPeriod statDownloadPeriod = fetchByPeriod_First(perMonth,
				perYear, orderByComparator);

		if (statDownloadPeriod != null) {
			return statDownloadPeriod;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perMonth=");
		msg.append(perMonth);

		msg.append(", perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatDownloadPeriodException(msg.toString());
	}

	/**
	 * Returns the first stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat download period, or <code>null</code> if a matching stat download period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod fetchByPeriod_First(int perMonth, int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<StatDownloadPeriod> list = findByPeriod(perMonth, perYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat download period
	 * @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a matching stat download period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod findByPeriod_Last(int perMonth, int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadPeriodException, SystemException {
		StatDownloadPeriod statDownloadPeriod = fetchByPeriod_Last(perMonth,
				perYear, orderByComparator);

		if (statDownloadPeriod != null) {
			return statDownloadPeriod;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perMonth=");
		msg.append(perMonth);

		msg.append(", perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatDownloadPeriodException(msg.toString());
	}

	/**
	 * Returns the last stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat download period, or <code>null</code> if a matching stat download period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod fetchByPeriod_Last(int perMonth, int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPeriod(perMonth, perYear);

		if (count == 0) {
			return null;
		}

		List<StatDownloadPeriod> list = findByPeriod(perMonth, perYear,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stat download periods before and after the current stat download period in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param id the primary key of the current stat download period
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stat download period
	 * @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a stat download period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod[] findByPeriod_PrevAndNext(long id, int perMonth,
		int perYear, OrderByComparator orderByComparator)
		throws NoSuchStatDownloadPeriodException, SystemException {
		StatDownloadPeriod statDownloadPeriod = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatDownloadPeriod[] array = new StatDownloadPeriodImpl[3];

			array[0] = getByPeriod_PrevAndNext(session, statDownloadPeriod,
					perMonth, perYear, orderByComparator, true);

			array[1] = statDownloadPeriod;

			array[2] = getByPeriod_PrevAndNext(session, statDownloadPeriod,
					perMonth, perYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatDownloadPeriod getByPeriod_PrevAndNext(Session session,
		StatDownloadPeriod statDownloadPeriod, int perMonth, int perYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATDOWNLOADPERIOD_WHERE);

		query.append(_FINDER_COLUMN_PERIOD_PERMONTH_2);

		query.append(_FINDER_COLUMN_PERIOD_PERYEAR_2);

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
			query.append(StatDownloadPeriodModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(perMonth);

		qPos.add(perYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statDownloadPeriod);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatDownloadPeriod> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stat download periods where perMonth = &#63; and perYear = &#63; from the database.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPeriod(int perMonth, int perYear)
		throws SystemException {
		for (StatDownloadPeriod statDownloadPeriod : findByPeriod(perMonth,
				perYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statDownloadPeriod);
		}
	}

	/**
	 * Returns the number of stat download periods where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @return the number of matching stat download periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPeriod(int perMonth, int perYear)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERIOD;

		Object[] finderArgs = new Object[] { perMonth, perYear };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STATDOWNLOADPERIOD_WHERE);

			query.append(_FINDER_COLUMN_PERIOD_PERMONTH_2);

			query.append(_FINDER_COLUMN_PERIOD_PERYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perMonth);

				qPos.add(perYear);

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

	private static final String _FINDER_COLUMN_PERIOD_PERMONTH_2 = "statDownloadPeriod.perMonth = ? AND ";
	private static final String _FINDER_COLUMN_PERIOD_PERYEAR_2 = "statDownloadPeriod.perYear = ?";

	public StatDownloadPeriodPersistenceImpl() {
		setModelClass(StatDownloadPeriod.class);
	}

	/**
	 * Caches the stat download period in the entity cache if it is enabled.
	 *
	 * @param statDownloadPeriod the stat download period
	 */
	@Override
	public void cacheResult(StatDownloadPeriod statDownloadPeriod) {
		EntityCacheUtil.putResult(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodImpl.class, statDownloadPeriod.getPrimaryKey(),
			statDownloadPeriod);

		statDownloadPeriod.resetOriginalValues();
	}

	/**
	 * Caches the stat download periods in the entity cache if it is enabled.
	 *
	 * @param statDownloadPeriods the stat download periods
	 */
	@Override
	public void cacheResult(List<StatDownloadPeriod> statDownloadPeriods) {
		for (StatDownloadPeriod statDownloadPeriod : statDownloadPeriods) {
			if (EntityCacheUtil.getResult(
						StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
						StatDownloadPeriodImpl.class,
						statDownloadPeriod.getPrimaryKey()) == null) {
				cacheResult(statDownloadPeriod);
			}
			else {
				statDownloadPeriod.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stat download periods.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatDownloadPeriodImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatDownloadPeriodImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stat download period.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatDownloadPeriod statDownloadPeriod) {
		EntityCacheUtil.removeResult(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodImpl.class, statDownloadPeriod.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatDownloadPeriod> statDownloadPeriods) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatDownloadPeriod statDownloadPeriod : statDownloadPeriods) {
			EntityCacheUtil.removeResult(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
				StatDownloadPeriodImpl.class, statDownloadPeriod.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stat download period with the primary key. Does not add the stat download period to the database.
	 *
	 * @param id the primary key for the new stat download period
	 * @return the new stat download period
	 */
	@Override
	public StatDownloadPeriod create(long id) {
		StatDownloadPeriod statDownloadPeriod = new StatDownloadPeriodImpl();

		statDownloadPeriod.setNew(true);
		statDownloadPeriod.setPrimaryKey(id);

		return statDownloadPeriod;
	}

	/**
	 * Removes the stat download period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stat download period
	 * @return the stat download period that was removed
	 * @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a stat download period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod remove(long id)
		throws NoSuchStatDownloadPeriodException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stat download period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stat download period
	 * @return the stat download period that was removed
	 * @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a stat download period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod remove(Serializable primaryKey)
		throws NoSuchStatDownloadPeriodException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatDownloadPeriod statDownloadPeriod = (StatDownloadPeriod)session.get(StatDownloadPeriodImpl.class,
					primaryKey);

			if (statDownloadPeriod == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatDownloadPeriodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statDownloadPeriod);
		}
		catch (NoSuchStatDownloadPeriodException nsee) {
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
	protected StatDownloadPeriod removeImpl(
		StatDownloadPeriod statDownloadPeriod) throws SystemException {
		statDownloadPeriod = toUnwrappedModel(statDownloadPeriod);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statDownloadPeriod)) {
				statDownloadPeriod = (StatDownloadPeriod)session.get(StatDownloadPeriodImpl.class,
						statDownloadPeriod.getPrimaryKeyObj());
			}

			if (statDownloadPeriod != null) {
				session.delete(statDownloadPeriod);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statDownloadPeriod != null) {
			clearCache(statDownloadPeriod);
		}

		return statDownloadPeriod;
	}

	@Override
	public StatDownloadPeriod updateImpl(
		com.idetronic.subur.model.StatDownloadPeriod statDownloadPeriod)
		throws SystemException {
		statDownloadPeriod = toUnwrappedModel(statDownloadPeriod);

		boolean isNew = statDownloadPeriod.isNew();

		StatDownloadPeriodModelImpl statDownloadPeriodModelImpl = (StatDownloadPeriodModelImpl)statDownloadPeriod;

		Session session = null;

		try {
			session = openSession();

			if (statDownloadPeriod.isNew()) {
				session.save(statDownloadPeriod);

				statDownloadPeriod.setNew(false);
			}
			else {
				session.merge(statDownloadPeriod);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatDownloadPeriodModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statDownloadPeriodModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statDownloadPeriodModelImpl.getOriginalPerMonth(),
						statDownloadPeriodModelImpl.getOriginalPerYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERIOD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD,
					args);

				args = new Object[] {
						statDownloadPeriodModelImpl.getPerMonth(),
						statDownloadPeriodModelImpl.getPerYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERIOD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD,
					args);
			}
		}

		EntityCacheUtil.putResult(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadPeriodImpl.class, statDownloadPeriod.getPrimaryKey(),
			statDownloadPeriod);

		return statDownloadPeriod;
	}

	protected StatDownloadPeriod toUnwrappedModel(
		StatDownloadPeriod statDownloadPeriod) {
		if (statDownloadPeriod instanceof StatDownloadPeriodImpl) {
			return statDownloadPeriod;
		}

		StatDownloadPeriodImpl statDownloadPeriodImpl = new StatDownloadPeriodImpl();

		statDownloadPeriodImpl.setNew(statDownloadPeriod.isNew());
		statDownloadPeriodImpl.setPrimaryKey(statDownloadPeriod.getPrimaryKey());

		statDownloadPeriodImpl.setId(statDownloadPeriod.getId());
		statDownloadPeriodImpl.setItemId(statDownloadPeriod.getItemId());
		statDownloadPeriodImpl.setPerMonth(statDownloadPeriod.getPerMonth());
		statDownloadPeriodImpl.setPerYear(statDownloadPeriod.getPerYear());

		return statDownloadPeriodImpl;
	}

	/**
	 * Returns the stat download period with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat download period
	 * @return the stat download period
	 * @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a stat download period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatDownloadPeriodException, SystemException {
		StatDownloadPeriod statDownloadPeriod = fetchByPrimaryKey(primaryKey);

		if (statDownloadPeriod == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatDownloadPeriodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statDownloadPeriod;
	}

	/**
	 * Returns the stat download period with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadPeriodException} if it could not be found.
	 *
	 * @param id the primary key of the stat download period
	 * @return the stat download period
	 * @throws com.idetronic.subur.NoSuchStatDownloadPeriodException if a stat download period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod findByPrimaryKey(long id)
		throws NoSuchStatDownloadPeriodException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stat download period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat download period
	 * @return the stat download period, or <code>null</code> if a stat download period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StatDownloadPeriod statDownloadPeriod = (StatDownloadPeriod)EntityCacheUtil.getResult(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
				StatDownloadPeriodImpl.class, primaryKey);

		if (statDownloadPeriod == _nullStatDownloadPeriod) {
			return null;
		}

		if (statDownloadPeriod == null) {
			Session session = null;

			try {
				session = openSession();

				statDownloadPeriod = (StatDownloadPeriod)session.get(StatDownloadPeriodImpl.class,
						primaryKey);

				if (statDownloadPeriod != null) {
					cacheResult(statDownloadPeriod);
				}
				else {
					EntityCacheUtil.putResult(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
						StatDownloadPeriodImpl.class, primaryKey,
						_nullStatDownloadPeriod);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatDownloadPeriodModelImpl.ENTITY_CACHE_ENABLED,
					StatDownloadPeriodImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statDownloadPeriod;
	}

	/**
	 * Returns the stat download period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stat download period
	 * @return the stat download period, or <code>null</code> if a stat download period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadPeriod fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the stat download periods.
	 *
	 * @return the stat download periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadPeriod> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat download periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat download periods
	 * @param end the upper bound of the range of stat download periods (not inclusive)
	 * @return the range of stat download periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadPeriod> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat download periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat download periods
	 * @param end the upper bound of the range of stat download periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stat download periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadPeriod> findAll(int start, int end,
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

		List<StatDownloadPeriod> list = (List<StatDownloadPeriod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATDOWNLOADPERIOD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATDOWNLOADPERIOD;

				if (pagination) {
					sql = sql.concat(StatDownloadPeriodModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatDownloadPeriod>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatDownloadPeriod>(list);
				}
				else {
					list = (List<StatDownloadPeriod>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the stat download periods from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StatDownloadPeriod statDownloadPeriod : findAll()) {
			remove(statDownloadPeriod);
		}
	}

	/**
	 * Returns the number of stat download periods.
	 *
	 * @return the number of stat download periods
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

				Query q = session.createQuery(_SQL_COUNT_STATDOWNLOADPERIOD);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the stat download period persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.StatDownloadPeriod")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatDownloadPeriod>> listenersList = new ArrayList<ModelListener<StatDownloadPeriod>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatDownloadPeriod>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatDownloadPeriodImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATDOWNLOADPERIOD = "SELECT statDownloadPeriod FROM StatDownloadPeriod statDownloadPeriod";
	private static final String _SQL_SELECT_STATDOWNLOADPERIOD_WHERE = "SELECT statDownloadPeriod FROM StatDownloadPeriod statDownloadPeriod WHERE ";
	private static final String _SQL_COUNT_STATDOWNLOADPERIOD = "SELECT COUNT(statDownloadPeriod) FROM StatDownloadPeriod statDownloadPeriod";
	private static final String _SQL_COUNT_STATDOWNLOADPERIOD_WHERE = "SELECT COUNT(statDownloadPeriod) FROM StatDownloadPeriod statDownloadPeriod WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statDownloadPeriod.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatDownloadPeriod exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatDownloadPeriod exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatDownloadPeriodPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static StatDownloadPeriod _nullStatDownloadPeriod = new StatDownloadPeriodImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatDownloadPeriod> toCacheModel() {
				return _nullStatDownloadPeriodCacheModel;
			}
		};

	private static CacheModel<StatDownloadPeriod> _nullStatDownloadPeriodCacheModel =
		new CacheModel<StatDownloadPeriod>() {
			@Override
			public StatDownloadPeriod toEntityModel() {
				return _nullStatDownloadPeriod;
			}
		};
}