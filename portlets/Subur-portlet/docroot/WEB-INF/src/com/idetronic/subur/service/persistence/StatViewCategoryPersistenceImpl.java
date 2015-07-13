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

import com.idetronic.subur.NoSuchStatViewCategoryException;
import com.idetronic.subur.model.StatViewCategory;
import com.idetronic.subur.model.impl.StatViewCategoryImpl;
import com.idetronic.subur.model.impl.StatViewCategoryModelImpl;

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
 * The persistence implementation for the stat view category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewCategoryPersistence
 * @see StatViewCategoryUtil
 * @generated
 */
public class StatViewCategoryPersistenceImpl extends BasePersistenceImpl<StatViewCategory>
	implements StatViewCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatViewCategoryUtil} to access the stat view category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatViewCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryModelImpl.FINDER_CACHE_ENABLED,
			StatViewCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryModelImpl.FINDER_CACHE_ENABLED,
			StatViewCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryModelImpl.FINDER_CACHE_ENABLED,
			StatViewCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryModelImpl.FINDER_CACHE_ENABLED,
			StatViewCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			StatViewCategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the stat view categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching stat view categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewCategory> findByCategory(long categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the stat view categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of stat view categories
	 * @param end the upper bound of the range of stat view categories (not inclusive)
	 * @return the range of matching stat view categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewCategory> findByCategory(long categoryId, int start,
		int end) throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat view categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of stat view categories
	 * @param end the upper bound of the range of stat view categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stat view categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewCategory> findByCategory(long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<StatViewCategory> list = (List<StatViewCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StatViewCategory statViewCategory : list) {
				if ((categoryId != statViewCategory.getCategoryId())) {
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

			query.append(_SQL_SELECT_STATVIEWCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatViewCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<StatViewCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatViewCategory>(list);
				}
				else {
					list = (List<StatViewCategory>)QueryUtil.list(q,
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
	 * Returns the first stat view category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat view category
	 * @throws com.idetronic.subur.NoSuchStatViewCategoryException if a matching stat view category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory findByCategory_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchStatViewCategoryException, SystemException {
		StatViewCategory statViewCategory = fetchByCategory_First(categoryId,
				orderByComparator);

		if (statViewCategory != null) {
			return statViewCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatViewCategoryException(msg.toString());
	}

	/**
	 * Returns the first stat view category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat view category, or <code>null</code> if a matching stat view category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory fetchByCategory_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StatViewCategory> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stat view category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat view category
	 * @throws com.idetronic.subur.NoSuchStatViewCategoryException if a matching stat view category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory findByCategory_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchStatViewCategoryException, SystemException {
		StatViewCategory statViewCategory = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (statViewCategory != null) {
			return statViewCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatViewCategoryException(msg.toString());
	}

	/**
	 * Returns the last stat view category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat view category, or <code>null</code> if a matching stat view category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory fetchByCategory_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<StatViewCategory> list = findByCategory(categoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stat view categories before and after the current stat view category in the ordered set where categoryId = &#63;.
	 *
	 * @param id the primary key of the current stat view category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stat view category
	 * @throws com.idetronic.subur.NoSuchStatViewCategoryException if a stat view category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory[] findByCategory_PrevAndNext(long id,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchStatViewCategoryException, SystemException {
		StatViewCategory statViewCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatViewCategory[] array = new StatViewCategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(session, statViewCategory,
					categoryId, orderByComparator, true);

			array[1] = statViewCategory;

			array[2] = getByCategory_PrevAndNext(session, statViewCategory,
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

	protected StatViewCategory getByCategory_PrevAndNext(Session session,
		StatViewCategory statViewCategory, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATVIEWCATEGORY_WHERE);

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
			query.append(StatViewCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statViewCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatViewCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stat view categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(long categoryId) throws SystemException {
		for (StatViewCategory statViewCategory : findByCategory(categoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statViewCategory);
		}
	}

	/**
	 * Returns the number of stat view categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching stat view categories
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

			query.append(_SQL_COUNT_STATVIEWCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "statViewCategory.categoryId = ?";

	public StatViewCategoryPersistenceImpl() {
		setModelClass(StatViewCategory.class);
	}

	/**
	 * Caches the stat view category in the entity cache if it is enabled.
	 *
	 * @param statViewCategory the stat view category
	 */
	@Override
	public void cacheResult(StatViewCategory statViewCategory) {
		EntityCacheUtil.putResult(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryImpl.class, statViewCategory.getPrimaryKey(),
			statViewCategory);

		statViewCategory.resetOriginalValues();
	}

	/**
	 * Caches the stat view categories in the entity cache if it is enabled.
	 *
	 * @param statViewCategories the stat view categories
	 */
	@Override
	public void cacheResult(List<StatViewCategory> statViewCategories) {
		for (StatViewCategory statViewCategory : statViewCategories) {
			if (EntityCacheUtil.getResult(
						StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
						StatViewCategoryImpl.class,
						statViewCategory.getPrimaryKey()) == null) {
				cacheResult(statViewCategory);
			}
			else {
				statViewCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stat view categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatViewCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatViewCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stat view category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatViewCategory statViewCategory) {
		EntityCacheUtil.removeResult(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryImpl.class, statViewCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatViewCategory> statViewCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatViewCategory statViewCategory : statViewCategories) {
			EntityCacheUtil.removeResult(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
				StatViewCategoryImpl.class, statViewCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stat view category with the primary key. Does not add the stat view category to the database.
	 *
	 * @param id the primary key for the new stat view category
	 * @return the new stat view category
	 */
	@Override
	public StatViewCategory create(long id) {
		StatViewCategory statViewCategory = new StatViewCategoryImpl();

		statViewCategory.setNew(true);
		statViewCategory.setPrimaryKey(id);

		return statViewCategory;
	}

	/**
	 * Removes the stat view category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stat view category
	 * @return the stat view category that was removed
	 * @throws com.idetronic.subur.NoSuchStatViewCategoryException if a stat view category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory remove(long id)
		throws NoSuchStatViewCategoryException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stat view category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stat view category
	 * @return the stat view category that was removed
	 * @throws com.idetronic.subur.NoSuchStatViewCategoryException if a stat view category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory remove(Serializable primaryKey)
		throws NoSuchStatViewCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatViewCategory statViewCategory = (StatViewCategory)session.get(StatViewCategoryImpl.class,
					primaryKey);

			if (statViewCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatViewCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statViewCategory);
		}
		catch (NoSuchStatViewCategoryException nsee) {
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
	protected StatViewCategory removeImpl(StatViewCategory statViewCategory)
		throws SystemException {
		statViewCategory = toUnwrappedModel(statViewCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statViewCategory)) {
				statViewCategory = (StatViewCategory)session.get(StatViewCategoryImpl.class,
						statViewCategory.getPrimaryKeyObj());
			}

			if (statViewCategory != null) {
				session.delete(statViewCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statViewCategory != null) {
			clearCache(statViewCategory);
		}

		return statViewCategory;
	}

	@Override
	public StatViewCategory updateImpl(
		com.idetronic.subur.model.StatViewCategory statViewCategory)
		throws SystemException {
		statViewCategory = toUnwrappedModel(statViewCategory);

		boolean isNew = statViewCategory.isNew();

		StatViewCategoryModelImpl statViewCategoryModelImpl = (StatViewCategoryModelImpl)statViewCategory;

		Session session = null;

		try {
			session = openSession();

			if (statViewCategory.isNew()) {
				session.save(statViewCategory);

				statViewCategory.setNew(false);
			}
			else {
				session.merge(statViewCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatViewCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statViewCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statViewCategoryModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { statViewCategoryModelImpl.getCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
			StatViewCategoryImpl.class, statViewCategory.getPrimaryKey(),
			statViewCategory);

		return statViewCategory;
	}

	protected StatViewCategory toUnwrappedModel(
		StatViewCategory statViewCategory) {
		if (statViewCategory instanceof StatViewCategoryImpl) {
			return statViewCategory;
		}

		StatViewCategoryImpl statViewCategoryImpl = new StatViewCategoryImpl();

		statViewCategoryImpl.setNew(statViewCategory.isNew());
		statViewCategoryImpl.setPrimaryKey(statViewCategory.getPrimaryKey());

		statViewCategoryImpl.setId(statViewCategory.getId());
		statViewCategoryImpl.setPerMonth(statViewCategory.getPerMonth());
		statViewCategoryImpl.setPerYear(statViewCategory.getPerYear());
		statViewCategoryImpl.setCategoryId(statViewCategory.getCategoryId());

		return statViewCategoryImpl;
	}

	/**
	 * Returns the stat view category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat view category
	 * @return the stat view category
	 * @throws com.idetronic.subur.NoSuchStatViewCategoryException if a stat view category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatViewCategoryException, SystemException {
		StatViewCategory statViewCategory = fetchByPrimaryKey(primaryKey);

		if (statViewCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatViewCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statViewCategory;
	}

	/**
	 * Returns the stat view category with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewCategoryException} if it could not be found.
	 *
	 * @param id the primary key of the stat view category
	 * @return the stat view category
	 * @throws com.idetronic.subur.NoSuchStatViewCategoryException if a stat view category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory findByPrimaryKey(long id)
		throws NoSuchStatViewCategoryException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stat view category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat view category
	 * @return the stat view category, or <code>null</code> if a stat view category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StatViewCategory statViewCategory = (StatViewCategory)EntityCacheUtil.getResult(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
				StatViewCategoryImpl.class, primaryKey);

		if (statViewCategory == _nullStatViewCategory) {
			return null;
		}

		if (statViewCategory == null) {
			Session session = null;

			try {
				session = openSession();

				statViewCategory = (StatViewCategory)session.get(StatViewCategoryImpl.class,
						primaryKey);

				if (statViewCategory != null) {
					cacheResult(statViewCategory);
				}
				else {
					EntityCacheUtil.putResult(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
						StatViewCategoryImpl.class, primaryKey,
						_nullStatViewCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatViewCategoryModelImpl.ENTITY_CACHE_ENABLED,
					StatViewCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statViewCategory;
	}

	/**
	 * Returns the stat view category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stat view category
	 * @return the stat view category, or <code>null</code> if a stat view category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewCategory fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the stat view categories.
	 *
	 * @return the stat view categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat view categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat view categories
	 * @param end the upper bound of the range of stat view categories (not inclusive)
	 * @return the range of stat view categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat view categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat view categories
	 * @param end the upper bound of the range of stat view categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stat view categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewCategory> findAll(int start, int end,
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

		List<StatViewCategory> list = (List<StatViewCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATVIEWCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATVIEWCATEGORY;

				if (pagination) {
					sql = sql.concat(StatViewCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatViewCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatViewCategory>(list);
				}
				else {
					list = (List<StatViewCategory>)QueryUtil.list(q,
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
	 * Removes all the stat view categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StatViewCategory statViewCategory : findAll()) {
			remove(statViewCategory);
		}
	}

	/**
	 * Returns the number of stat view categories.
	 *
	 * @return the number of stat view categories
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

				Query q = session.createQuery(_SQL_COUNT_STATVIEWCATEGORY);

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
	 * Initializes the stat view category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.StatViewCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatViewCategory>> listenersList = new ArrayList<ModelListener<StatViewCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatViewCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatViewCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATVIEWCATEGORY = "SELECT statViewCategory FROM StatViewCategory statViewCategory";
	private static final String _SQL_SELECT_STATVIEWCATEGORY_WHERE = "SELECT statViewCategory FROM StatViewCategory statViewCategory WHERE ";
	private static final String _SQL_COUNT_STATVIEWCATEGORY = "SELECT COUNT(statViewCategory) FROM StatViewCategory statViewCategory";
	private static final String _SQL_COUNT_STATVIEWCATEGORY_WHERE = "SELECT COUNT(statViewCategory) FROM StatViewCategory statViewCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statViewCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatViewCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatViewCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatViewCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static StatViewCategory _nullStatViewCategory = new StatViewCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatViewCategory> toCacheModel() {
				return _nullStatViewCategoryCacheModel;
			}
		};

	private static CacheModel<StatViewCategory> _nullStatViewCategoryCacheModel = new CacheModel<StatViewCategory>() {
			@Override
			public StatViewCategory toEntityModel() {
				return _nullStatViewCategory;
			}
		};
}