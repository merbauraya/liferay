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

import com.idetronic.subur.NoSuchStatDownloadCategoryException;
import com.idetronic.subur.model.StatDownloadCategory;
import com.idetronic.subur.model.impl.StatDownloadCategoryImpl;
import com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl;

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
 * The persistence implementation for the stat download category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadCategoryPersistence
 * @see StatDownloadCategoryUtil
 * @generated
 */
public class StatDownloadCategoryPersistenceImpl extends BasePersistenceImpl<StatDownloadCategory>
	implements StatDownloadCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatDownloadCategoryUtil} to access the stat download category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatDownloadCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			StatDownloadCategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the stat download categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching stat download categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadCategory> findByCategory(long categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the stat download categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of stat download categories
	 * @param end the upper bound of the range of stat download categories (not inclusive)
	 * @return the range of matching stat download categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadCategory> findByCategory(long categoryId,
		int start, int end) throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat download categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of stat download categories
	 * @param end the upper bound of the range of stat download categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stat download categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadCategory> findByCategory(long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<StatDownloadCategory> list = (List<StatDownloadCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StatDownloadCategory statDownloadCategory : list) {
				if ((categoryId != statDownloadCategory.getCategoryId())) {
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

			query.append(_SQL_SELECT_STATDOWNLOADCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatDownloadCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<StatDownloadCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatDownloadCategory>(list);
				}
				else {
					list = (List<StatDownloadCategory>)QueryUtil.list(q,
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
	 * Returns the first stat download category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat download category
	 * @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a matching stat download category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory findByCategory_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadCategoryException, SystemException {
		StatDownloadCategory statDownloadCategory = fetchByCategory_First(categoryId,
				orderByComparator);

		if (statDownloadCategory != null) {
			return statDownloadCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatDownloadCategoryException(msg.toString());
	}

	/**
	 * Returns the first stat download category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat download category, or <code>null</code> if a matching stat download category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory fetchByCategory_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StatDownloadCategory> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stat download category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat download category
	 * @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a matching stat download category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory findByCategory_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadCategoryException, SystemException {
		StatDownloadCategory statDownloadCategory = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (statDownloadCategory != null) {
			return statDownloadCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatDownloadCategoryException(msg.toString());
	}

	/**
	 * Returns the last stat download category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat download category, or <code>null</code> if a matching stat download category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory fetchByCategory_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<StatDownloadCategory> list = findByCategory(categoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stat download categories before and after the current stat download category in the ordered set where categoryId = &#63;.
	 *
	 * @param id the primary key of the current stat download category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stat download category
	 * @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory[] findByCategory_PrevAndNext(long id,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchStatDownloadCategoryException, SystemException {
		StatDownloadCategory statDownloadCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatDownloadCategory[] array = new StatDownloadCategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(session, statDownloadCategory,
					categoryId, orderByComparator, true);

			array[1] = statDownloadCategory;

			array[2] = getByCategory_PrevAndNext(session, statDownloadCategory,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatDownloadCategory getByCategory_PrevAndNext(Session session,
		StatDownloadCategory statDownloadCategory, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATDOWNLOADCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

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
			query.append(StatDownloadCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statDownloadCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatDownloadCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stat download categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(long categoryId) throws SystemException {
		for (StatDownloadCategory statDownloadCategory : findByCategory(
				categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statDownloadCategory);
		}
	}

	/**
	 * Returns the number of stat download categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching stat download categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategory(long categoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATDOWNLOADCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "statDownloadCategory.categoryId = ?";

	public StatDownloadCategoryPersistenceImpl() {
		setModelClass(StatDownloadCategory.class);
	}

	/**
	 * Caches the stat download category in the entity cache if it is enabled.
	 *
	 * @param statDownloadCategory the stat download category
	 */
	@Override
	public void cacheResult(StatDownloadCategory statDownloadCategory) {
		EntityCacheUtil.putResult(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryImpl.class,
			statDownloadCategory.getPrimaryKey(), statDownloadCategory);

		statDownloadCategory.resetOriginalValues();
	}

	/**
	 * Caches the stat download categories in the entity cache if it is enabled.
	 *
	 * @param statDownloadCategories the stat download categories
	 */
	@Override
	public void cacheResult(List<StatDownloadCategory> statDownloadCategories) {
		for (StatDownloadCategory statDownloadCategory : statDownloadCategories) {
			if (EntityCacheUtil.getResult(
						StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
						StatDownloadCategoryImpl.class,
						statDownloadCategory.getPrimaryKey()) == null) {
				cacheResult(statDownloadCategory);
			}
			else {
				statDownloadCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stat download categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatDownloadCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatDownloadCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stat download category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatDownloadCategory statDownloadCategory) {
		EntityCacheUtil.removeResult(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryImpl.class, statDownloadCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatDownloadCategory> statDownloadCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatDownloadCategory statDownloadCategory : statDownloadCategories) {
			EntityCacheUtil.removeResult(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
				StatDownloadCategoryImpl.class,
				statDownloadCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stat download category with the primary key. Does not add the stat download category to the database.
	 *
	 * @param id the primary key for the new stat download category
	 * @return the new stat download category
	 */
	@Override
	public StatDownloadCategory create(long id) {
		StatDownloadCategory statDownloadCategory = new StatDownloadCategoryImpl();

		statDownloadCategory.setNew(true);
		statDownloadCategory.setPrimaryKey(id);

		return statDownloadCategory;
	}

	/**
	 * Removes the stat download category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stat download category
	 * @return the stat download category that was removed
	 * @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory remove(long id)
		throws NoSuchStatDownloadCategoryException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stat download category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stat download category
	 * @return the stat download category that was removed
	 * @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory remove(Serializable primaryKey)
		throws NoSuchStatDownloadCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatDownloadCategory statDownloadCategory = (StatDownloadCategory)session.get(StatDownloadCategoryImpl.class,
					primaryKey);

			if (statDownloadCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatDownloadCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statDownloadCategory);
		}
		catch (NoSuchStatDownloadCategoryException nsee) {
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
	protected StatDownloadCategory removeImpl(
		StatDownloadCategory statDownloadCategory) throws SystemException {
		statDownloadCategory = toUnwrappedModel(statDownloadCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statDownloadCategory)) {
				statDownloadCategory = (StatDownloadCategory)session.get(StatDownloadCategoryImpl.class,
						statDownloadCategory.getPrimaryKeyObj());
			}

			if (statDownloadCategory != null) {
				session.delete(statDownloadCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statDownloadCategory != null) {
			clearCache(statDownloadCategory);
		}

		return statDownloadCategory;
	}

	@Override
	public StatDownloadCategory updateImpl(
		com.idetronic.subur.model.StatDownloadCategory statDownloadCategory)
		throws SystemException {
		statDownloadCategory = toUnwrappedModel(statDownloadCategory);

		boolean isNew = statDownloadCategory.isNew();

		StatDownloadCategoryModelImpl statDownloadCategoryModelImpl = (StatDownloadCategoryModelImpl)statDownloadCategory;

		Session session = null;

		try {
			session = openSession();

			if (statDownloadCategory.isNew()) {
				session.save(statDownloadCategory);

				statDownloadCategory.setNew(false);
			}
			else {
				session.merge(statDownloadCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatDownloadCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statDownloadCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statDownloadCategoryModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						statDownloadCategoryModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadCategoryImpl.class,
			statDownloadCategory.getPrimaryKey(), statDownloadCategory);

		return statDownloadCategory;
	}

	protected StatDownloadCategory toUnwrappedModel(
		StatDownloadCategory statDownloadCategory) {
		if (statDownloadCategory instanceof StatDownloadCategoryImpl) {
			return statDownloadCategory;
		}

		StatDownloadCategoryImpl statDownloadCategoryImpl = new StatDownloadCategoryImpl();

		statDownloadCategoryImpl.setNew(statDownloadCategory.isNew());
		statDownloadCategoryImpl.setPrimaryKey(statDownloadCategory.getPrimaryKey());

		statDownloadCategoryImpl.setId(statDownloadCategory.getId());
		statDownloadCategoryImpl.setPerMonth(statDownloadCategory.getPerMonth());
		statDownloadCategoryImpl.setPerYear(statDownloadCategory.getPerYear());
		statDownloadCategoryImpl.setCategoryId(statDownloadCategory.getCategoryId());

		return statDownloadCategoryImpl;
	}

	/**
	 * Returns the stat download category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat download category
	 * @return the stat download category
	 * @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatDownloadCategoryException, SystemException {
		StatDownloadCategory statDownloadCategory = fetchByPrimaryKey(primaryKey);

		if (statDownloadCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatDownloadCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statDownloadCategory;
	}

	/**
	 * Returns the stat download category with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadCategoryException} if it could not be found.
	 *
	 * @param id the primary key of the stat download category
	 * @return the stat download category
	 * @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory findByPrimaryKey(long id)
		throws NoSuchStatDownloadCategoryException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stat download category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat download category
	 * @return the stat download category, or <code>null</code> if a stat download category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StatDownloadCategory statDownloadCategory = (StatDownloadCategory)EntityCacheUtil.getResult(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
				StatDownloadCategoryImpl.class, primaryKey);

		if (statDownloadCategory == _nullStatDownloadCategory) {
			return null;
		}

		if (statDownloadCategory == null) {
			Session session = null;

			try {
				session = openSession();

				statDownloadCategory = (StatDownloadCategory)session.get(StatDownloadCategoryImpl.class,
						primaryKey);

				if (statDownloadCategory != null) {
					cacheResult(statDownloadCategory);
				}
				else {
					EntityCacheUtil.putResult(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
						StatDownloadCategoryImpl.class, primaryKey,
						_nullStatDownloadCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatDownloadCategoryModelImpl.ENTITY_CACHE_ENABLED,
					StatDownloadCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statDownloadCategory;
	}

	/**
	 * Returns the stat download category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stat download category
	 * @return the stat download category, or <code>null</code> if a stat download category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadCategory fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the stat download categories.
	 *
	 * @return the stat download categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat download categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat download categories
	 * @param end the upper bound of the range of stat download categories (not inclusive)
	 * @return the range of stat download categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat download categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat download categories
	 * @param end the upper bound of the range of stat download categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stat download categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadCategory> findAll(int start, int end,
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

		List<StatDownloadCategory> list = (List<StatDownloadCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATDOWNLOADCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATDOWNLOADCATEGORY;

				if (pagination) {
					sql = sql.concat(StatDownloadCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatDownloadCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatDownloadCategory>(list);
				}
				else {
					list = (List<StatDownloadCategory>)QueryUtil.list(q,
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
	 * Removes all the stat download categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StatDownloadCategory statDownloadCategory : findAll()) {
			remove(statDownloadCategory);
		}
	}

	/**
	 * Returns the number of stat download categories.
	 *
	 * @return the number of stat download categories
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

				Query q = session.createQuery(_SQL_COUNT_STATDOWNLOADCATEGORY);

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
	 * Initializes the stat download category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.StatDownloadCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatDownloadCategory>> listenersList = new ArrayList<ModelListener<StatDownloadCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatDownloadCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatDownloadCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATDOWNLOADCATEGORY = "SELECT statDownloadCategory FROM StatDownloadCategory statDownloadCategory";
	private static final String _SQL_SELECT_STATDOWNLOADCATEGORY_WHERE = "SELECT statDownloadCategory FROM StatDownloadCategory statDownloadCategory WHERE ";
	private static final String _SQL_COUNT_STATDOWNLOADCATEGORY = "SELECT COUNT(statDownloadCategory) FROM StatDownloadCategory statDownloadCategory";
	private static final String _SQL_COUNT_STATDOWNLOADCATEGORY_WHERE = "SELECT COUNT(statDownloadCategory) FROM StatDownloadCategory statDownloadCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statDownloadCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatDownloadCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatDownloadCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatDownloadCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static StatDownloadCategory _nullStatDownloadCategory = new StatDownloadCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatDownloadCategory> toCacheModel() {
				return _nullStatDownloadCategoryCacheModel;
			}
		};

	private static CacheModel<StatDownloadCategory> _nullStatDownloadCategoryCacheModel =
		new CacheModel<StatDownloadCategory>() {
			@Override
			public StatDownloadCategory toEntityModel() {
				return _nullStatDownloadCategory;
			}
		};
}