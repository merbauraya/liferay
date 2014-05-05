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

package com.idetronic.tazkirah.service.persistence;

import com.idetronic.tazkirah.NoSuchTazkirahException;
import com.idetronic.tazkirah.model.Tazkirah;
import com.idetronic.tazkirah.model.impl.TazkirahImpl;
import com.idetronic.tazkirah.model.impl.TazkirahModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tazkirah service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see TazkirahPersistence
 * @see TazkirahUtil
 * @generated
 */
public class TazkirahPersistenceImpl extends BasePersistenceImpl<Tazkirah>
	implements TazkirahPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TazkirahUtil} to access the tazkirah persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TazkirahImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahModelImpl.FINDER_CACHE_ENABLED, TazkirahImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahModelImpl.FINDER_CACHE_ENABLED, TazkirahImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahModelImpl.FINDER_CACHE_ENABLED, TazkirahImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahModelImpl.FINDER_CACHE_ENABLED, TazkirahImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { String.class.getName() },
			TazkirahModelImpl.CATEGORY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tazkirahs where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching tazkirahs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tazkirah> findByCategory(String category)
		throws SystemException {
		return findByCategory(category, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tazkirahs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of tazkirahs
	 * @param end the upper bound of the range of tazkirahs (not inclusive)
	 * @return the range of matching tazkirahs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tazkirah> findByCategory(String category, int start, int end)
		throws SystemException {
		return findByCategory(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tazkirahs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of tazkirahs
	 * @param end the upper bound of the range of tazkirahs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tazkirahs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tazkirah> findByCategory(String category, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { category, start, end, orderByComparator };
		}

		List<Tazkirah> list = (List<Tazkirah>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tazkirah tazkirah : list) {
				if (!Validator.equals(category, tazkirah.getCategory())) {
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

			query.append(_SQL_SELECT_TAZKIRAH_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TazkirahModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

				if (!pagination) {
					list = (List<Tazkirah>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tazkirah>(list);
				}
				else {
					list = (List<Tazkirah>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tazkirah in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tazkirah
	 * @throws com.idetronic.tazkirah.NoSuchTazkirahException if a matching tazkirah could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah findByCategory_First(String category,
		OrderByComparator orderByComparator)
		throws NoSuchTazkirahException, SystemException {
		Tazkirah tazkirah = fetchByCategory_First(category, orderByComparator);

		if (tazkirah != null) {
			return tazkirah;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTazkirahException(msg.toString());
	}

	/**
	 * Returns the first tazkirah in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tazkirah, or <code>null</code> if a matching tazkirah could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah fetchByCategory_First(String category,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tazkirah> list = findByCategory(category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tazkirah in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tazkirah
	 * @throws com.idetronic.tazkirah.NoSuchTazkirahException if a matching tazkirah could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah findByCategory_Last(String category,
		OrderByComparator orderByComparator)
		throws NoSuchTazkirahException, SystemException {
		Tazkirah tazkirah = fetchByCategory_Last(category, orderByComparator);

		if (tazkirah != null) {
			return tazkirah;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTazkirahException(msg.toString());
	}

	/**
	 * Returns the last tazkirah in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tazkirah, or <code>null</code> if a matching tazkirah could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah fetchByCategory_Last(String category,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(category);

		if (count == 0) {
			return null;
		}

		List<Tazkirah> list = findByCategory(category, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tazkirahs before and after the current tazkirah in the ordered set where category = &#63;.
	 *
	 * @param tazkirahId the primary key of the current tazkirah
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tazkirah
	 * @throws com.idetronic.tazkirah.NoSuchTazkirahException if a tazkirah with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah[] findByCategory_PrevAndNext(long tazkirahId,
		String category, OrderByComparator orderByComparator)
		throws NoSuchTazkirahException, SystemException {
		Tazkirah tazkirah = findByPrimaryKey(tazkirahId);

		Session session = null;

		try {
			session = openSession();

			Tazkirah[] array = new TazkirahImpl[3];

			array[0] = getByCategory_PrevAndNext(session, tazkirah, category,
					orderByComparator, true);

			array[1] = tazkirah;

			array[2] = getByCategory_PrevAndNext(session, tazkirah, category,
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

	protected Tazkirah getByCategory_PrevAndNext(Session session,
		Tazkirah tazkirah, String category,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAZKIRAH_WHERE);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
		}

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
			query.append(TazkirahModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategory) {
			qPos.add(category);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tazkirah);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tazkirah> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tazkirahs where category = &#63; from the database.
	 *
	 * @param category the category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(String category) throws SystemException {
		for (Tazkirah tazkirah : findByCategory(category, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tazkirah);
		}
	}

	/**
	 * Returns the number of tazkirahs where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching tazkirahs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategory(String category) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { category };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAZKIRAH_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_1 = "tazkirah.category IS NULL";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 = "tazkirah.category = ?";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 = "(tazkirah.category IS NULL OR tazkirah.category = '')";

	public TazkirahPersistenceImpl() {
		setModelClass(Tazkirah.class);
	}

	/**
	 * Caches the tazkirah in the entity cache if it is enabled.
	 *
	 * @param tazkirah the tazkirah
	 */
	@Override
	public void cacheResult(Tazkirah tazkirah) {
		EntityCacheUtil.putResult(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahImpl.class, tazkirah.getPrimaryKey(), tazkirah);

		tazkirah.resetOriginalValues();
	}

	/**
	 * Caches the tazkirahs in the entity cache if it is enabled.
	 *
	 * @param tazkirahs the tazkirahs
	 */
	@Override
	public void cacheResult(List<Tazkirah> tazkirahs) {
		for (Tazkirah tazkirah : tazkirahs) {
			if (EntityCacheUtil.getResult(
						TazkirahModelImpl.ENTITY_CACHE_ENABLED,
						TazkirahImpl.class, tazkirah.getPrimaryKey()) == null) {
				cacheResult(tazkirah);
			}
			else {
				tazkirah.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tazkirahs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TazkirahImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TazkirahImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tazkirah.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tazkirah tazkirah) {
		EntityCacheUtil.removeResult(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahImpl.class, tazkirah.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Tazkirah> tazkirahs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tazkirah tazkirah : tazkirahs) {
			EntityCacheUtil.removeResult(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
				TazkirahImpl.class, tazkirah.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tazkirah with the primary key. Does not add the tazkirah to the database.
	 *
	 * @param tazkirahId the primary key for the new tazkirah
	 * @return the new tazkirah
	 */
	@Override
	public Tazkirah create(long tazkirahId) {
		Tazkirah tazkirah = new TazkirahImpl();

		tazkirah.setNew(true);
		tazkirah.setPrimaryKey(tazkirahId);

		return tazkirah;
	}

	/**
	 * Removes the tazkirah with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tazkirahId the primary key of the tazkirah
	 * @return the tazkirah that was removed
	 * @throws com.idetronic.tazkirah.NoSuchTazkirahException if a tazkirah with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah remove(long tazkirahId)
		throws NoSuchTazkirahException, SystemException {
		return remove((Serializable)tazkirahId);
	}

	/**
	 * Removes the tazkirah with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tazkirah
	 * @return the tazkirah that was removed
	 * @throws com.idetronic.tazkirah.NoSuchTazkirahException if a tazkirah with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah remove(Serializable primaryKey)
		throws NoSuchTazkirahException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Tazkirah tazkirah = (Tazkirah)session.get(TazkirahImpl.class,
					primaryKey);

			if (tazkirah == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTazkirahException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tazkirah);
		}
		catch (NoSuchTazkirahException nsee) {
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
	protected Tazkirah removeImpl(Tazkirah tazkirah) throws SystemException {
		tazkirah = toUnwrappedModel(tazkirah);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tazkirah)) {
				tazkirah = (Tazkirah)session.get(TazkirahImpl.class,
						tazkirah.getPrimaryKeyObj());
			}

			if (tazkirah != null) {
				session.delete(tazkirah);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tazkirah != null) {
			clearCache(tazkirah);
		}

		return tazkirah;
	}

	@Override
	public Tazkirah updateImpl(com.idetronic.tazkirah.model.Tazkirah tazkirah)
		throws SystemException {
		tazkirah = toUnwrappedModel(tazkirah);

		boolean isNew = tazkirah.isNew();

		TazkirahModelImpl tazkirahModelImpl = (TazkirahModelImpl)tazkirah;

		Session session = null;

		try {
			session = openSession();

			if (tazkirah.isNew()) {
				session.save(tazkirah);

				tazkirah.setNew(false);
			}
			else {
				session.merge(tazkirah);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TazkirahModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tazkirahModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tazkirahModelImpl.getOriginalCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { tazkirahModelImpl.getCategory() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
			TazkirahImpl.class, tazkirah.getPrimaryKey(), tazkirah);

		return tazkirah;
	}

	protected Tazkirah toUnwrappedModel(Tazkirah tazkirah) {
		if (tazkirah instanceof TazkirahImpl) {
			return tazkirah;
		}

		TazkirahImpl tazkirahImpl = new TazkirahImpl();

		tazkirahImpl.setNew(tazkirah.isNew());
		tazkirahImpl.setPrimaryKey(tazkirah.getPrimaryKey());

		tazkirahImpl.setTazkirahId(tazkirah.getTazkirahId());
		tazkirahImpl.setCompanyId(tazkirah.getCompanyId());
		tazkirahImpl.setGroupId(tazkirah.getGroupId());
		tazkirahImpl.setUserId(tazkirah.getUserId());
		tazkirahImpl.setUserName(tazkirah.getUserName());
		tazkirahImpl.setCreateDate(tazkirah.getCreateDate());
		tazkirahImpl.setModifiedDate(tazkirah.getModifiedDate());
		tazkirahImpl.setTitle(tazkirah.getTitle());
		tazkirahImpl.setContent(tazkirah.getContent());
		tazkirahImpl.setCategory(tazkirah.getCategory());
		tazkirahImpl.setStatus(tazkirah.getStatus());

		return tazkirahImpl;
	}

	/**
	 * Returns the tazkirah with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tazkirah
	 * @return the tazkirah
	 * @throws com.idetronic.tazkirah.NoSuchTazkirahException if a tazkirah with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTazkirahException, SystemException {
		Tazkirah tazkirah = fetchByPrimaryKey(primaryKey);

		if (tazkirah == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTazkirahException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tazkirah;
	}

	/**
	 * Returns the tazkirah with the primary key or throws a {@link com.idetronic.tazkirah.NoSuchTazkirahException} if it could not be found.
	 *
	 * @param tazkirahId the primary key of the tazkirah
	 * @return the tazkirah
	 * @throws com.idetronic.tazkirah.NoSuchTazkirahException if a tazkirah with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah findByPrimaryKey(long tazkirahId)
		throws NoSuchTazkirahException, SystemException {
		return findByPrimaryKey((Serializable)tazkirahId);
	}

	/**
	 * Returns the tazkirah with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tazkirah
	 * @return the tazkirah, or <code>null</code> if a tazkirah with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Tazkirah tazkirah = (Tazkirah)EntityCacheUtil.getResult(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
				TazkirahImpl.class, primaryKey);

		if (tazkirah == _nullTazkirah) {
			return null;
		}

		if (tazkirah == null) {
			Session session = null;

			try {
				session = openSession();

				tazkirah = (Tazkirah)session.get(TazkirahImpl.class, primaryKey);

				if (tazkirah != null) {
					cacheResult(tazkirah);
				}
				else {
					EntityCacheUtil.putResult(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
						TazkirahImpl.class, primaryKey, _nullTazkirah);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TazkirahModelImpl.ENTITY_CACHE_ENABLED,
					TazkirahImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tazkirah;
	}

	/**
	 * Returns the tazkirah with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tazkirahId the primary key of the tazkirah
	 * @return the tazkirah, or <code>null</code> if a tazkirah with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tazkirah fetchByPrimaryKey(long tazkirahId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tazkirahId);
	}

	/**
	 * Returns all the tazkirahs.
	 *
	 * @return the tazkirahs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tazkirah> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tazkirahs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tazkirahs
	 * @param end the upper bound of the range of tazkirahs (not inclusive)
	 * @return the range of tazkirahs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tazkirah> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tazkirahs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.tazkirah.model.impl.TazkirahModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tazkirahs
	 * @param end the upper bound of the range of tazkirahs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tazkirahs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tazkirah> findAll(int start, int end,
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

		List<Tazkirah> list = (List<Tazkirah>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAZKIRAH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAZKIRAH;

				if (pagination) {
					sql = sql.concat(TazkirahModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Tazkirah>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tazkirah>(list);
				}
				else {
					list = (List<Tazkirah>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tazkirahs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Tazkirah tazkirah : findAll()) {
			remove(tazkirah);
		}
	}

	/**
	 * Returns the number of tazkirahs.
	 *
	 * @return the number of tazkirahs
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

				Query q = session.createQuery(_SQL_COUNT_TAZKIRAH);

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
	 * Initializes the tazkirah persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.tazkirah.model.Tazkirah")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Tazkirah>> listenersList = new ArrayList<ModelListener<Tazkirah>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Tazkirah>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TazkirahImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAZKIRAH = "SELECT tazkirah FROM Tazkirah tazkirah";
	private static final String _SQL_SELECT_TAZKIRAH_WHERE = "SELECT tazkirah FROM Tazkirah tazkirah WHERE ";
	private static final String _SQL_COUNT_TAZKIRAH = "SELECT COUNT(tazkirah) FROM Tazkirah tazkirah";
	private static final String _SQL_COUNT_TAZKIRAH_WHERE = "SELECT COUNT(tazkirah) FROM Tazkirah tazkirah WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tazkirah.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tazkirah exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tazkirah exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TazkirahPersistenceImpl.class);
	private static Tazkirah _nullTazkirah = new TazkirahImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Tazkirah> toCacheModel() {
				return _nullTazkirahCacheModel;
			}
		};

	private static CacheModel<Tazkirah> _nullTazkirahCacheModel = new CacheModel<Tazkirah>() {
			@Override
			public Tazkirah toEntityModel() {
				return _nullTazkirah;
			}
		};
}