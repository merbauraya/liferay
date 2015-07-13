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

import com.idetronic.subur.NoSuchStatViewPeriodException;
import com.idetronic.subur.model.StatViewPeriod;
import com.idetronic.subur.model.impl.StatViewPeriodImpl;
import com.idetronic.subur.model.impl.StatViewPeriodModelImpl;

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
 * The persistence implementation for the stat view period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewPeriodPersistence
 * @see StatViewPeriodUtil
 * @generated
 */
public class StatViewPeriodPersistenceImpl extends BasePersistenceImpl<StatViewPeriod>
	implements StatViewPeriodPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatViewPeriodUtil} to access the stat view period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatViewPeriodImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodModelImpl.FINDER_CACHE_ENABLED,
			StatViewPeriodImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodModelImpl.FINDER_CACHE_ENABLED,
			StatViewPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID = new FinderPath(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodModelImpl.FINDER_CACHE_ENABLED,
			StatViewPeriodImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID =
		new FinderPath(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodModelImpl.FINDER_CACHE_ENABLED,
			StatViewPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemId",
			new String[] { Long.class.getName() },
			StatViewPeriodModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the stat view periods where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching stat view periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewPeriod> findByItemId(long itemId)
		throws SystemException {
		return findByItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StatViewPeriod> findByItemId(long itemId, int start, int end)
		throws SystemException {
		return findByItemId(itemId, start, end, null);
	}

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
	@Override
	public List<StatViewPeriod> findByItemId(long itemId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID;
			finderArgs = new Object[] { itemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID;
			finderArgs = new Object[] { itemId, start, end, orderByComparator };
		}

		List<StatViewPeriod> list = (List<StatViewPeriod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StatViewPeriod statViewPeriod : list) {
				if ((itemId != statViewPeriod.getItemId())) {
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

			query.append(_SQL_SELECT_STATVIEWPERIOD_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatViewPeriodModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<StatViewPeriod>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatViewPeriod>(list);
				}
				else {
					list = (List<StatViewPeriod>)QueryUtil.list(q,
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
	 * Returns the first stat view period in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat view period
	 * @throws com.idetronic.subur.NoSuchStatViewPeriodException if a matching stat view period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod findByItemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchStatViewPeriodException, SystemException {
		StatViewPeriod statViewPeriod = fetchByItemId_First(itemId,
				orderByComparator);

		if (statViewPeriod != null) {
			return statViewPeriod;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatViewPeriodException(msg.toString());
	}

	/**
	 * Returns the first stat view period in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat view period, or <code>null</code> if a matching stat view period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod fetchByItemId_First(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StatViewPeriod> list = findByItemId(itemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stat view period in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat view period
	 * @throws com.idetronic.subur.NoSuchStatViewPeriodException if a matching stat view period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod findByItemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchStatViewPeriodException, SystemException {
		StatViewPeriod statViewPeriod = fetchByItemId_Last(itemId,
				orderByComparator);

		if (statViewPeriod != null) {
			return statViewPeriod;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatViewPeriodException(msg.toString());
	}

	/**
	 * Returns the last stat view period in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat view period, or <code>null</code> if a matching stat view period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod fetchByItemId_Last(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemId(itemId);

		if (count == 0) {
			return null;
		}

		List<StatViewPeriod> list = findByItemId(itemId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public StatViewPeriod[] findByItemId_PrevAndNext(long id, long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchStatViewPeriodException, SystemException {
		StatViewPeriod statViewPeriod = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatViewPeriod[] array = new StatViewPeriodImpl[3];

			array[0] = getByItemId_PrevAndNext(session, statViewPeriod, itemId,
					orderByComparator, true);

			array[1] = statViewPeriod;

			array[2] = getByItemId_PrevAndNext(session, statViewPeriod, itemId,
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

	protected StatViewPeriod getByItemId_PrevAndNext(Session session,
		StatViewPeriod statViewPeriod, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATVIEWPERIOD_WHERE);

		query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

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
			query.append(StatViewPeriodModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statViewPeriod);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatViewPeriod> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stat view periods where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemId(long itemId) throws SystemException {
		for (StatViewPeriod statViewPeriod : findByItemId(itemId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statViewPeriod);
		}
	}

	/**
	 * Returns the number of stat view periods where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching stat view periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemId(long itemId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMID;

		Object[] finderArgs = new Object[] { itemId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATVIEWPERIOD_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

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

	private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "statViewPeriod.itemId = ?";

	public StatViewPeriodPersistenceImpl() {
		setModelClass(StatViewPeriod.class);
	}

	/**
	 * Caches the stat view period in the entity cache if it is enabled.
	 *
	 * @param statViewPeriod the stat view period
	 */
	@Override
	public void cacheResult(StatViewPeriod statViewPeriod) {
		EntityCacheUtil.putResult(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodImpl.class, statViewPeriod.getPrimaryKey(),
			statViewPeriod);

		statViewPeriod.resetOriginalValues();
	}

	/**
	 * Caches the stat view periods in the entity cache if it is enabled.
	 *
	 * @param statViewPeriods the stat view periods
	 */
	@Override
	public void cacheResult(List<StatViewPeriod> statViewPeriods) {
		for (StatViewPeriod statViewPeriod : statViewPeriods) {
			if (EntityCacheUtil.getResult(
						StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
						StatViewPeriodImpl.class, statViewPeriod.getPrimaryKey()) == null) {
				cacheResult(statViewPeriod);
			}
			else {
				statViewPeriod.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stat view periods.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatViewPeriodImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatViewPeriodImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stat view period.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatViewPeriod statViewPeriod) {
		EntityCacheUtil.removeResult(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodImpl.class, statViewPeriod.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatViewPeriod> statViewPeriods) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatViewPeriod statViewPeriod : statViewPeriods) {
			EntityCacheUtil.removeResult(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
				StatViewPeriodImpl.class, statViewPeriod.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stat view period with the primary key. Does not add the stat view period to the database.
	 *
	 * @param id the primary key for the new stat view period
	 * @return the new stat view period
	 */
	@Override
	public StatViewPeriod create(long id) {
		StatViewPeriod statViewPeriod = new StatViewPeriodImpl();

		statViewPeriod.setNew(true);
		statViewPeriod.setPrimaryKey(id);

		return statViewPeriod;
	}

	/**
	 * Removes the stat view period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stat view period
	 * @return the stat view period that was removed
	 * @throws com.idetronic.subur.NoSuchStatViewPeriodException if a stat view period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod remove(long id)
		throws NoSuchStatViewPeriodException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stat view period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stat view period
	 * @return the stat view period that was removed
	 * @throws com.idetronic.subur.NoSuchStatViewPeriodException if a stat view period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod remove(Serializable primaryKey)
		throws NoSuchStatViewPeriodException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatViewPeriod statViewPeriod = (StatViewPeriod)session.get(StatViewPeriodImpl.class,
					primaryKey);

			if (statViewPeriod == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatViewPeriodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statViewPeriod);
		}
		catch (NoSuchStatViewPeriodException nsee) {
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
	protected StatViewPeriod removeImpl(StatViewPeriod statViewPeriod)
		throws SystemException {
		statViewPeriod = toUnwrappedModel(statViewPeriod);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statViewPeriod)) {
				statViewPeriod = (StatViewPeriod)session.get(StatViewPeriodImpl.class,
						statViewPeriod.getPrimaryKeyObj());
			}

			if (statViewPeriod != null) {
				session.delete(statViewPeriod);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statViewPeriod != null) {
			clearCache(statViewPeriod);
		}

		return statViewPeriod;
	}

	@Override
	public StatViewPeriod updateImpl(
		com.idetronic.subur.model.StatViewPeriod statViewPeriod)
		throws SystemException {
		statViewPeriod = toUnwrappedModel(statViewPeriod);

		boolean isNew = statViewPeriod.isNew();

		StatViewPeriodModelImpl statViewPeriodModelImpl = (StatViewPeriodModelImpl)statViewPeriod;

		Session session = null;

		try {
			session = openSession();

			if (statViewPeriod.isNew()) {
				session.save(statViewPeriod);

				statViewPeriod.setNew(false);
			}
			else {
				session.merge(statViewPeriod);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatViewPeriodModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statViewPeriodModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statViewPeriodModelImpl.getOriginalItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);

				args = new Object[] { statViewPeriodModelImpl.getItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);
			}
		}

		EntityCacheUtil.putResult(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
			StatViewPeriodImpl.class, statViewPeriod.getPrimaryKey(),
			statViewPeriod);

		return statViewPeriod;
	}

	protected StatViewPeriod toUnwrappedModel(StatViewPeriod statViewPeriod) {
		if (statViewPeriod instanceof StatViewPeriodImpl) {
			return statViewPeriod;
		}

		StatViewPeriodImpl statViewPeriodImpl = new StatViewPeriodImpl();

		statViewPeriodImpl.setNew(statViewPeriod.isNew());
		statViewPeriodImpl.setPrimaryKey(statViewPeriod.getPrimaryKey());

		statViewPeriodImpl.setId(statViewPeriod.getId());
		statViewPeriodImpl.setItemId(statViewPeriod.getItemId());
		statViewPeriodImpl.setPerMonth(statViewPeriod.getPerMonth());
		statViewPeriodImpl.setPerYear(statViewPeriod.getPerYear());

		return statViewPeriodImpl;
	}

	/**
	 * Returns the stat view period with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat view period
	 * @return the stat view period
	 * @throws com.idetronic.subur.NoSuchStatViewPeriodException if a stat view period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatViewPeriodException, SystemException {
		StatViewPeriod statViewPeriod = fetchByPrimaryKey(primaryKey);

		if (statViewPeriod == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatViewPeriodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statViewPeriod;
	}

	/**
	 * Returns the stat view period with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewPeriodException} if it could not be found.
	 *
	 * @param id the primary key of the stat view period
	 * @return the stat view period
	 * @throws com.idetronic.subur.NoSuchStatViewPeriodException if a stat view period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod findByPrimaryKey(long id)
		throws NoSuchStatViewPeriodException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stat view period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat view period
	 * @return the stat view period, or <code>null</code> if a stat view period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StatViewPeriod statViewPeriod = (StatViewPeriod)EntityCacheUtil.getResult(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
				StatViewPeriodImpl.class, primaryKey);

		if (statViewPeriod == _nullStatViewPeriod) {
			return null;
		}

		if (statViewPeriod == null) {
			Session session = null;

			try {
				session = openSession();

				statViewPeriod = (StatViewPeriod)session.get(StatViewPeriodImpl.class,
						primaryKey);

				if (statViewPeriod != null) {
					cacheResult(statViewPeriod);
				}
				else {
					EntityCacheUtil.putResult(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
						StatViewPeriodImpl.class, primaryKey,
						_nullStatViewPeriod);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatViewPeriodModelImpl.ENTITY_CACHE_ENABLED,
					StatViewPeriodImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statViewPeriod;
	}

	/**
	 * Returns the stat view period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stat view period
	 * @return the stat view period, or <code>null</code> if a stat view period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewPeriod fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the stat view periods.
	 *
	 * @return the stat view periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewPeriod> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StatViewPeriod> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<StatViewPeriod> findAll(int start, int end,
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

		List<StatViewPeriod> list = (List<StatViewPeriod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATVIEWPERIOD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATVIEWPERIOD;

				if (pagination) {
					sql = sql.concat(StatViewPeriodModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatViewPeriod>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatViewPeriod>(list);
				}
				else {
					list = (List<StatViewPeriod>)QueryUtil.list(q,
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
	 * Removes all the stat view periods from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StatViewPeriod statViewPeriod : findAll()) {
			remove(statViewPeriod);
		}
	}

	/**
	 * Returns the number of stat view periods.
	 *
	 * @return the number of stat view periods
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

				Query q = session.createQuery(_SQL_COUNT_STATVIEWPERIOD);

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
	 * Initializes the stat view period persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.StatViewPeriod")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatViewPeriod>> listenersList = new ArrayList<ModelListener<StatViewPeriod>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatViewPeriod>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatViewPeriodImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATVIEWPERIOD = "SELECT statViewPeriod FROM StatViewPeriod statViewPeriod";
	private static final String _SQL_SELECT_STATVIEWPERIOD_WHERE = "SELECT statViewPeriod FROM StatViewPeriod statViewPeriod WHERE ";
	private static final String _SQL_COUNT_STATVIEWPERIOD = "SELECT COUNT(statViewPeriod) FROM StatViewPeriod statViewPeriod";
	private static final String _SQL_COUNT_STATVIEWPERIOD_WHERE = "SELECT COUNT(statViewPeriod) FROM StatViewPeriod statViewPeriod WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statViewPeriod.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatViewPeriod exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatViewPeriod exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatViewPeriodPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static StatViewPeriod _nullStatViewPeriod = new StatViewPeriodImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatViewPeriod> toCacheModel() {
				return _nullStatViewPeriodCacheModel;
			}
		};

	private static CacheModel<StatViewPeriod> _nullStatViewPeriodCacheModel = new CacheModel<StatViewPeriod>() {
			@Override
			public StatViewPeriod toEntityModel() {
				return _nullStatViewPeriod;
			}
		};
}