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

import com.idetronic.subur.NoSuchStatDownloadItemTypeException;
import com.idetronic.subur.model.StatDownloadItemType;
import com.idetronic.subur.model.impl.StatDownloadItemTypeImpl;
import com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl;

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
 * The persistence implementation for the stat download item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadItemTypePersistence
 * @see StatDownloadItemTypeUtil
 * @generated
 */
public class StatDownloadItemTypePersistenceImpl extends BasePersistenceImpl<StatDownloadItemType>
	implements StatDownloadItemTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatDownloadItemTypeUtil} to access the stat download item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatDownloadItemTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPE = new FinderPath(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByItemType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE =
		new FinderPath(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemType",
			new String[] { Long.class.getName() },
			StatDownloadItemTypeModelImpl.ITEMTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMTYPE = new FinderPath(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the stat download item types where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @return the matching stat download item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadItemType> findByItemType(long itemTypeId)
		throws SystemException {
		return findByItemType(itemTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the stat download item types where itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of stat download item types
	 * @param end the upper bound of the range of stat download item types (not inclusive)
	 * @return the range of matching stat download item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadItemType> findByItemType(long itemTypeId,
		int start, int end) throws SystemException {
		return findByItemType(itemTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat download item types where itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of stat download item types
	 * @param end the upper bound of the range of stat download item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stat download item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadItemType> findByItemType(long itemTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE;
			finderArgs = new Object[] { itemTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPE;
			finderArgs = new Object[] { itemTypeId, start, end, orderByComparator };
		}

		List<StatDownloadItemType> list = (List<StatDownloadItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StatDownloadItemType statDownloadItemType : list) {
				if ((itemTypeId != statDownloadItemType.getItemTypeId())) {
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

			query.append(_SQL_SELECT_STATDOWNLOADITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatDownloadItemTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemTypeId);

				if (!pagination) {
					list = (List<StatDownloadItemType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatDownloadItemType>(list);
				}
				else {
					list = (List<StatDownloadItemType>)QueryUtil.list(q,
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
	 * Returns the first stat download item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat download item type
	 * @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a matching stat download item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType findByItemType_First(long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadItemTypeException, SystemException {
		StatDownloadItemType statDownloadItemType = fetchByItemType_First(itemTypeId,
				orderByComparator);

		if (statDownloadItemType != null) {
			return statDownloadItemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatDownloadItemTypeException(msg.toString());
	}

	/**
	 * Returns the first stat download item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat download item type, or <code>null</code> if a matching stat download item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType fetchByItemType_First(long itemTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StatDownloadItemType> list = findByItemType(itemTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stat download item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat download item type
	 * @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a matching stat download item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType findByItemType_Last(long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadItemTypeException, SystemException {
		StatDownloadItemType statDownloadItemType = fetchByItemType_Last(itemTypeId,
				orderByComparator);

		if (statDownloadItemType != null) {
			return statDownloadItemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatDownloadItemTypeException(msg.toString());
	}

	/**
	 * Returns the last stat download item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat download item type, or <code>null</code> if a matching stat download item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType fetchByItemType_Last(long itemTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemType(itemTypeId);

		if (count == 0) {
			return null;
		}

		List<StatDownloadItemType> list = findByItemType(itemTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stat download item types before and after the current stat download item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param id the primary key of the current stat download item type
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stat download item type
	 * @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a stat download item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType[] findByItemType_PrevAndNext(long id,
		long itemTypeId, OrderByComparator orderByComparator)
		throws NoSuchStatDownloadItemTypeException, SystemException {
		StatDownloadItemType statDownloadItemType = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatDownloadItemType[] array = new StatDownloadItemTypeImpl[3];

			array[0] = getByItemType_PrevAndNext(session, statDownloadItemType,
					itemTypeId, orderByComparator, true);

			array[1] = statDownloadItemType;

			array[2] = getByItemType_PrevAndNext(session, statDownloadItemType,
					itemTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatDownloadItemType getByItemType_PrevAndNext(Session session,
		StatDownloadItemType statDownloadItemType, long itemTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATDOWNLOADITEMTYPE_WHERE);

		query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

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
			query.append(StatDownloadItemTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statDownloadItemType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatDownloadItemType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stat download item types where itemTypeId = &#63; from the database.
	 *
	 * @param itemTypeId the item type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemType(long itemTypeId) throws SystemException {
		for (StatDownloadItemType statDownloadItemType : findByItemType(
				itemTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statDownloadItemType);
		}
	}

	/**
	 * Returns the number of stat download item types where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @return the number of matching stat download item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemType(long itemTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMTYPE;

		Object[] finderArgs = new Object[] { itemTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATDOWNLOADITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemTypeId);

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

	private static final String _FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2 = "statDownloadItemType.itemTypeId = ?";

	public StatDownloadItemTypePersistenceImpl() {
		setModelClass(StatDownloadItemType.class);
	}

	/**
	 * Caches the stat download item type in the entity cache if it is enabled.
	 *
	 * @param statDownloadItemType the stat download item type
	 */
	@Override
	public void cacheResult(StatDownloadItemType statDownloadItemType) {
		EntityCacheUtil.putResult(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeImpl.class,
			statDownloadItemType.getPrimaryKey(), statDownloadItemType);

		statDownloadItemType.resetOriginalValues();
	}

	/**
	 * Caches the stat download item types in the entity cache if it is enabled.
	 *
	 * @param statDownloadItemTypes the stat download item types
	 */
	@Override
	public void cacheResult(List<StatDownloadItemType> statDownloadItemTypes) {
		for (StatDownloadItemType statDownloadItemType : statDownloadItemTypes) {
			if (EntityCacheUtil.getResult(
						StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						StatDownloadItemTypeImpl.class,
						statDownloadItemType.getPrimaryKey()) == null) {
				cacheResult(statDownloadItemType);
			}
			else {
				statDownloadItemType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stat download item types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatDownloadItemTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatDownloadItemTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stat download item type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatDownloadItemType statDownloadItemType) {
		EntityCacheUtil.removeResult(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeImpl.class, statDownloadItemType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatDownloadItemType> statDownloadItemTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatDownloadItemType statDownloadItemType : statDownloadItemTypes) {
			EntityCacheUtil.removeResult(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				StatDownloadItemTypeImpl.class,
				statDownloadItemType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stat download item type with the primary key. Does not add the stat download item type to the database.
	 *
	 * @param id the primary key for the new stat download item type
	 * @return the new stat download item type
	 */
	@Override
	public StatDownloadItemType create(long id) {
		StatDownloadItemType statDownloadItemType = new StatDownloadItemTypeImpl();

		statDownloadItemType.setNew(true);
		statDownloadItemType.setPrimaryKey(id);

		return statDownloadItemType;
	}

	/**
	 * Removes the stat download item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stat download item type
	 * @return the stat download item type that was removed
	 * @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a stat download item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType remove(long id)
		throws NoSuchStatDownloadItemTypeException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stat download item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stat download item type
	 * @return the stat download item type that was removed
	 * @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a stat download item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType remove(Serializable primaryKey)
		throws NoSuchStatDownloadItemTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatDownloadItemType statDownloadItemType = (StatDownloadItemType)session.get(StatDownloadItemTypeImpl.class,
					primaryKey);

			if (statDownloadItemType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatDownloadItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statDownloadItemType);
		}
		catch (NoSuchStatDownloadItemTypeException nsee) {
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
	protected StatDownloadItemType removeImpl(
		StatDownloadItemType statDownloadItemType) throws SystemException {
		statDownloadItemType = toUnwrappedModel(statDownloadItemType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statDownloadItemType)) {
				statDownloadItemType = (StatDownloadItemType)session.get(StatDownloadItemTypeImpl.class,
						statDownloadItemType.getPrimaryKeyObj());
			}

			if (statDownloadItemType != null) {
				session.delete(statDownloadItemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statDownloadItemType != null) {
			clearCache(statDownloadItemType);
		}

		return statDownloadItemType;
	}

	@Override
	public StatDownloadItemType updateImpl(
		com.idetronic.subur.model.StatDownloadItemType statDownloadItemType)
		throws SystemException {
		statDownloadItemType = toUnwrappedModel(statDownloadItemType);

		boolean isNew = statDownloadItemType.isNew();

		StatDownloadItemTypeModelImpl statDownloadItemTypeModelImpl = (StatDownloadItemTypeModelImpl)statDownloadItemType;

		Session session = null;

		try {
			session = openSession();

			if (statDownloadItemType.isNew()) {
				session.save(statDownloadItemType);

				statDownloadItemType.setNew(false);
			}
			else {
				session.merge(statDownloadItemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatDownloadItemTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statDownloadItemTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statDownloadItemTypeModelImpl.getOriginalItemTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE,
					args);

				args = new Object[] {
						statDownloadItemTypeModelImpl.getItemTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadItemTypeImpl.class,
			statDownloadItemType.getPrimaryKey(), statDownloadItemType);

		return statDownloadItemType;
	}

	protected StatDownloadItemType toUnwrappedModel(
		StatDownloadItemType statDownloadItemType) {
		if (statDownloadItemType instanceof StatDownloadItemTypeImpl) {
			return statDownloadItemType;
		}

		StatDownloadItemTypeImpl statDownloadItemTypeImpl = new StatDownloadItemTypeImpl();

		statDownloadItemTypeImpl.setNew(statDownloadItemType.isNew());
		statDownloadItemTypeImpl.setPrimaryKey(statDownloadItemType.getPrimaryKey());

		statDownloadItemTypeImpl.setId(statDownloadItemType.getId());
		statDownloadItemTypeImpl.setPerMonth(statDownloadItemType.getPerMonth());
		statDownloadItemTypeImpl.setPerYear(statDownloadItemType.getPerYear());
		statDownloadItemTypeImpl.setItemTypeId(statDownloadItemType.getItemTypeId());

		return statDownloadItemTypeImpl;
	}

	/**
	 * Returns the stat download item type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat download item type
	 * @return the stat download item type
	 * @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a stat download item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatDownloadItemTypeException, SystemException {
		StatDownloadItemType statDownloadItemType = fetchByPrimaryKey(primaryKey);

		if (statDownloadItemType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatDownloadItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statDownloadItemType;
	}

	/**
	 * Returns the stat download item type with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadItemTypeException} if it could not be found.
	 *
	 * @param id the primary key of the stat download item type
	 * @return the stat download item type
	 * @throws com.idetronic.subur.NoSuchStatDownloadItemTypeException if a stat download item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType findByPrimaryKey(long id)
		throws NoSuchStatDownloadItemTypeException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stat download item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat download item type
	 * @return the stat download item type, or <code>null</code> if a stat download item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StatDownloadItemType statDownloadItemType = (StatDownloadItemType)EntityCacheUtil.getResult(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				StatDownloadItemTypeImpl.class, primaryKey);

		if (statDownloadItemType == _nullStatDownloadItemType) {
			return null;
		}

		if (statDownloadItemType == null) {
			Session session = null;

			try {
				session = openSession();

				statDownloadItemType = (StatDownloadItemType)session.get(StatDownloadItemTypeImpl.class,
						primaryKey);

				if (statDownloadItemType != null) {
					cacheResult(statDownloadItemType);
				}
				else {
					EntityCacheUtil.putResult(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						StatDownloadItemTypeImpl.class, primaryKey,
						_nullStatDownloadItemType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatDownloadItemTypeModelImpl.ENTITY_CACHE_ENABLED,
					StatDownloadItemTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statDownloadItemType;
	}

	/**
	 * Returns the stat download item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stat download item type
	 * @return the stat download item type, or <code>null</code> if a stat download item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadItemType fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the stat download item types.
	 *
	 * @return the stat download item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadItemType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat download item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat download item types
	 * @param end the upper bound of the range of stat download item types (not inclusive)
	 * @return the range of stat download item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadItemType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat download item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat download item types
	 * @param end the upper bound of the range of stat download item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stat download item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadItemType> findAll(int start, int end,
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

		List<StatDownloadItemType> list = (List<StatDownloadItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATDOWNLOADITEMTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATDOWNLOADITEMTYPE;

				if (pagination) {
					sql = sql.concat(StatDownloadItemTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatDownloadItemType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatDownloadItemType>(list);
				}
				else {
					list = (List<StatDownloadItemType>)QueryUtil.list(q,
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
	 * Removes all the stat download item types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StatDownloadItemType statDownloadItemType : findAll()) {
			remove(statDownloadItemType);
		}
	}

	/**
	 * Returns the number of stat download item types.
	 *
	 * @return the number of stat download item types
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

				Query q = session.createQuery(_SQL_COUNT_STATDOWNLOADITEMTYPE);

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
	 * Initializes the stat download item type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.StatDownloadItemType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatDownloadItemType>> listenersList = new ArrayList<ModelListener<StatDownloadItemType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatDownloadItemType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatDownloadItemTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATDOWNLOADITEMTYPE = "SELECT statDownloadItemType FROM StatDownloadItemType statDownloadItemType";
	private static final String _SQL_SELECT_STATDOWNLOADITEMTYPE_WHERE = "SELECT statDownloadItemType FROM StatDownloadItemType statDownloadItemType WHERE ";
	private static final String _SQL_COUNT_STATDOWNLOADITEMTYPE = "SELECT COUNT(statDownloadItemType) FROM StatDownloadItemType statDownloadItemType";
	private static final String _SQL_COUNT_STATDOWNLOADITEMTYPE_WHERE = "SELECT COUNT(statDownloadItemType) FROM StatDownloadItemType statDownloadItemType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statDownloadItemType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatDownloadItemType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatDownloadItemType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatDownloadItemTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static StatDownloadItemType _nullStatDownloadItemType = new StatDownloadItemTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatDownloadItemType> toCacheModel() {
				return _nullStatDownloadItemTypeCacheModel;
			}
		};

	private static CacheModel<StatDownloadItemType> _nullStatDownloadItemTypeCacheModel =
		new CacheModel<StatDownloadItemType>() {
			@Override
			public StatDownloadItemType toEntityModel() {
				return _nullStatDownloadItemType;
			}
		};
}