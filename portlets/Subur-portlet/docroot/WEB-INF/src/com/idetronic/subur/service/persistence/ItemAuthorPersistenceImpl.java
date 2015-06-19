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

import com.idetronic.subur.NoSuchItemAuthorException;
import com.idetronic.subur.model.ItemAuthor;
import com.idetronic.subur.model.impl.ItemAuthorImpl;
import com.idetronic.subur.model.impl.ItemAuthorModelImpl;

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
 * The persistence implementation for the item author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemAuthorPersistence
 * @see ItemAuthorUtil
 * @generated
 */
public class ItemAuthorPersistenceImpl extends BasePersistenceImpl<ItemAuthor>
	implements ItemAuthorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemAuthorUtil} to access the item author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemAuthorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, ItemAuthorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, ItemAuthorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID = new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, ItemAuthorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByitemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID =
		new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, ItemAuthorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByitemId",
			new String[] { Long.class.getName() },
			ItemAuthorModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByitemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the item authors where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findByitemId(long itemId) throws SystemException {
		return findByitemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item authors where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of item authors
	 * @param end the upper bound of the range of item authors (not inclusive)
	 * @return the range of matching item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findByitemId(long itemId, int start, int end)
		throws SystemException {
		return findByitemId(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item authors where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of item authors
	 * @param end the upper bound of the range of item authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findByitemId(long itemId, int start, int end,
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

		List<ItemAuthor> list = (List<ItemAuthor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemAuthor itemAuthor : list) {
				if ((itemId != itemAuthor.getItemId())) {
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

			query.append(_SQL_SELECT_ITEMAUTHOR_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemAuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<ItemAuthor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemAuthor>(list);
				}
				else {
					list = (List<ItemAuthor>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item author in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item author
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a matching item author could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor findByitemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemAuthorException, SystemException {
		ItemAuthor itemAuthor = fetchByitemId_First(itemId, orderByComparator);

		if (itemAuthor != null) {
			return itemAuthor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemAuthorException(msg.toString());
	}

	/**
	 * Returns the first item author in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item author, or <code>null</code> if a matching item author could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor fetchByitemId_First(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemAuthor> list = findByitemId(itemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item author in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item author
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a matching item author could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor findByitemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemAuthorException, SystemException {
		ItemAuthor itemAuthor = fetchByitemId_Last(itemId, orderByComparator);

		if (itemAuthor != null) {
			return itemAuthor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemAuthorException(msg.toString());
	}

	/**
	 * Returns the last item author in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item author, or <code>null</code> if a matching item author could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor fetchByitemId_Last(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByitemId(itemId);

		if (count == 0) {
			return null;
		}

		List<ItemAuthor> list = findByitemId(itemId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item authors before and after the current item author in the ordered set where itemId = &#63;.
	 *
	 * @param itemAuthorPK the primary key of the current item author
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item author
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor[] findByitemId_PrevAndNext(ItemAuthorPK itemAuthorPK,
		long itemId, OrderByComparator orderByComparator)
		throws NoSuchItemAuthorException, SystemException {
		ItemAuthor itemAuthor = findByPrimaryKey(itemAuthorPK);

		Session session = null;

		try {
			session = openSession();

			ItemAuthor[] array = new ItemAuthorImpl[3];

			array[0] = getByitemId_PrevAndNext(session, itemAuthor, itemId,
					orderByComparator, true);

			array[1] = itemAuthor;

			array[2] = getByitemId_PrevAndNext(session, itemAuthor, itemId,
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

	protected ItemAuthor getByitemId_PrevAndNext(Session session,
		ItemAuthor itemAuthor, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMAUTHOR_WHERE);

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
			query.append(ItemAuthorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemAuthor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemAuthor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item authors where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByitemId(long itemId) throws SystemException {
		for (ItemAuthor itemAuthor : findByitemId(itemId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(itemAuthor);
		}
	}

	/**
	 * Returns the number of item authors where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByitemId(long itemId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMID;

		Object[] finderArgs = new Object[] { itemId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEMAUTHOR_WHERE);

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

	private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "itemAuthor.id.itemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORID = new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, ItemAuthorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByauthorId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID =
		new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, ItemAuthorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByauthorId",
			new String[] { Long.class.getName() },
			ItemAuthorModelImpl.AUTHORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORID = new FinderPath(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByauthorId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the item authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findByauthorId(long authorId)
		throws SystemException {
		return findByauthorId(authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the item authors where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of item authors
	 * @param end the upper bound of the range of item authors (not inclusive)
	 * @return the range of matching item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findByauthorId(long authorId, int start, int end)
		throws SystemException {
		return findByauthorId(authorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item authors where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of item authors
	 * @param end the upper bound of the range of item authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findByauthorId(long authorId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID;
			finderArgs = new Object[] { authorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORID;
			finderArgs = new Object[] { authorId, start, end, orderByComparator };
		}

		List<ItemAuthor> list = (List<ItemAuthor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemAuthor itemAuthor : list) {
				if ((authorId != itemAuthor.getAuthorId())) {
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

			query.append(_SQL_SELECT_ITEMAUTHOR_WHERE);

			query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemAuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (!pagination) {
					list = (List<ItemAuthor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemAuthor>(list);
				}
				else {
					list = (List<ItemAuthor>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item author
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a matching item author could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor findByauthorId_First(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchItemAuthorException, SystemException {
		ItemAuthor itemAuthor = fetchByauthorId_First(authorId,
				orderByComparator);

		if (itemAuthor != null) {
			return itemAuthor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemAuthorException(msg.toString());
	}

	/**
	 * Returns the first item author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item author, or <code>null</code> if a matching item author could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor fetchByauthorId_First(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemAuthor> list = findByauthorId(authorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item author
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a matching item author could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor findByauthorId_Last(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchItemAuthorException, SystemException {
		ItemAuthor itemAuthor = fetchByauthorId_Last(authorId, orderByComparator);

		if (itemAuthor != null) {
			return itemAuthor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemAuthorException(msg.toString());
	}

	/**
	 * Returns the last item author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item author, or <code>null</code> if a matching item author could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor fetchByauthorId_Last(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByauthorId(authorId);

		if (count == 0) {
			return null;
		}

		List<ItemAuthor> list = findByauthorId(authorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item authors before and after the current item author in the ordered set where authorId = &#63;.
	 *
	 * @param itemAuthorPK the primary key of the current item author
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item author
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor[] findByauthorId_PrevAndNext(ItemAuthorPK itemAuthorPK,
		long authorId, OrderByComparator orderByComparator)
		throws NoSuchItemAuthorException, SystemException {
		ItemAuthor itemAuthor = findByPrimaryKey(itemAuthorPK);

		Session session = null;

		try {
			session = openSession();

			ItemAuthor[] array = new ItemAuthorImpl[3];

			array[0] = getByauthorId_PrevAndNext(session, itemAuthor, authorId,
					orderByComparator, true);

			array[1] = itemAuthor;

			array[2] = getByauthorId_PrevAndNext(session, itemAuthor, authorId,
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

	protected ItemAuthor getByauthorId_PrevAndNext(Session session,
		ItemAuthor itemAuthor, long authorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMAUTHOR_WHERE);

		query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);

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
			query.append(ItemAuthorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemAuthor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemAuthor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item authors where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByauthorId(long authorId) throws SystemException {
		for (ItemAuthor itemAuthor : findByauthorId(authorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemAuthor);
		}
	}

	/**
	 * Returns the number of item authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByauthorId(long authorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORID;

		Object[] finderArgs = new Object[] { authorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEMAUTHOR_WHERE);

			query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

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

	private static final String _FINDER_COLUMN_AUTHORID_AUTHORID_2 = "itemAuthor.id.authorId = ?";

	public ItemAuthorPersistenceImpl() {
		setModelClass(ItemAuthor.class);
	}

	/**
	 * Caches the item author in the entity cache if it is enabled.
	 *
	 * @param itemAuthor the item author
	 */
	@Override
	public void cacheResult(ItemAuthor itemAuthor) {
		EntityCacheUtil.putResult(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorImpl.class, itemAuthor.getPrimaryKey(), itemAuthor);

		itemAuthor.resetOriginalValues();
	}

	/**
	 * Caches the item authors in the entity cache if it is enabled.
	 *
	 * @param itemAuthors the item authors
	 */
	@Override
	public void cacheResult(List<ItemAuthor> itemAuthors) {
		for (ItemAuthor itemAuthor : itemAuthors) {
			if (EntityCacheUtil.getResult(
						ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
						ItemAuthorImpl.class, itemAuthor.getPrimaryKey()) == null) {
				cacheResult(itemAuthor);
			}
			else {
				itemAuthor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item authors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemAuthorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemAuthorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item author.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemAuthor itemAuthor) {
		EntityCacheUtil.removeResult(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorImpl.class, itemAuthor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemAuthor> itemAuthors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemAuthor itemAuthor : itemAuthors) {
			EntityCacheUtil.removeResult(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
				ItemAuthorImpl.class, itemAuthor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item author with the primary key. Does not add the item author to the database.
	 *
	 * @param itemAuthorPK the primary key for the new item author
	 * @return the new item author
	 */
	@Override
	public ItemAuthor create(ItemAuthorPK itemAuthorPK) {
		ItemAuthor itemAuthor = new ItemAuthorImpl();

		itemAuthor.setNew(true);
		itemAuthor.setPrimaryKey(itemAuthorPK);

		return itemAuthor;
	}

	/**
	 * Removes the item author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemAuthorPK the primary key of the item author
	 * @return the item author that was removed
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor remove(ItemAuthorPK itemAuthorPK)
		throws NoSuchItemAuthorException, SystemException {
		return remove((Serializable)itemAuthorPK);
	}

	/**
	 * Removes the item author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item author
	 * @return the item author that was removed
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor remove(Serializable primaryKey)
		throws NoSuchItemAuthorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemAuthor itemAuthor = (ItemAuthor)session.get(ItemAuthorImpl.class,
					primaryKey);

			if (itemAuthor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemAuthorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemAuthor);
		}
		catch (NoSuchItemAuthorException nsee) {
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
	protected ItemAuthor removeImpl(ItemAuthor itemAuthor)
		throws SystemException {
		itemAuthor = toUnwrappedModel(itemAuthor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemAuthor)) {
				itemAuthor = (ItemAuthor)session.get(ItemAuthorImpl.class,
						itemAuthor.getPrimaryKeyObj());
			}

			if (itemAuthor != null) {
				session.delete(itemAuthor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemAuthor != null) {
			clearCache(itemAuthor);
		}

		return itemAuthor;
	}

	@Override
	public ItemAuthor updateImpl(
		com.idetronic.subur.model.ItemAuthor itemAuthor)
		throws SystemException {
		itemAuthor = toUnwrappedModel(itemAuthor);

		boolean isNew = itemAuthor.isNew();

		ItemAuthorModelImpl itemAuthorModelImpl = (ItemAuthorModelImpl)itemAuthor;

		Session session = null;

		try {
			session = openSession();

			if (itemAuthor.isNew()) {
				session.save(itemAuthor);

				itemAuthor.setNew(false);
			}
			else {
				session.merge(itemAuthor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ItemAuthorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((itemAuthorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemAuthorModelImpl.getOriginalItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);

				args = new Object[] { itemAuthorModelImpl.getItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);
			}

			if ((itemAuthorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemAuthorModelImpl.getOriginalAuthorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID,
					args);

				args = new Object[] { itemAuthorModelImpl.getAuthorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID,
					args);
			}
		}

		EntityCacheUtil.putResult(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ItemAuthorImpl.class, itemAuthor.getPrimaryKey(), itemAuthor);

		return itemAuthor;
	}

	protected ItemAuthor toUnwrappedModel(ItemAuthor itemAuthor) {
		if (itemAuthor instanceof ItemAuthorImpl) {
			return itemAuthor;
		}

		ItemAuthorImpl itemAuthorImpl = new ItemAuthorImpl();

		itemAuthorImpl.setNew(itemAuthor.isNew());
		itemAuthorImpl.setPrimaryKey(itemAuthor.getPrimaryKey());

		itemAuthorImpl.setItemId(itemAuthor.getItemId());
		itemAuthorImpl.setAuthorId(itemAuthor.getAuthorId());

		return itemAuthorImpl;
	}

	/**
	 * Returns the item author with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item author
	 * @return the item author
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemAuthorException, SystemException {
		ItemAuthor itemAuthor = fetchByPrimaryKey(primaryKey);

		if (itemAuthor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemAuthorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemAuthor;
	}

	/**
	 * Returns the item author with the primary key or throws a {@link com.idetronic.subur.NoSuchItemAuthorException} if it could not be found.
	 *
	 * @param itemAuthorPK the primary key of the item author
	 * @return the item author
	 * @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor findByPrimaryKey(ItemAuthorPK itemAuthorPK)
		throws NoSuchItemAuthorException, SystemException {
		return findByPrimaryKey((Serializable)itemAuthorPK);
	}

	/**
	 * Returns the item author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item author
	 * @return the item author, or <code>null</code> if a item author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemAuthor itemAuthor = (ItemAuthor)EntityCacheUtil.getResult(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
				ItemAuthorImpl.class, primaryKey);

		if (itemAuthor == _nullItemAuthor) {
			return null;
		}

		if (itemAuthor == null) {
			Session session = null;

			try {
				session = openSession();

				itemAuthor = (ItemAuthor)session.get(ItemAuthorImpl.class,
						primaryKey);

				if (itemAuthor != null) {
					cacheResult(itemAuthor);
				}
				else {
					EntityCacheUtil.putResult(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
						ItemAuthorImpl.class, primaryKey, _nullItemAuthor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemAuthorModelImpl.ENTITY_CACHE_ENABLED,
					ItemAuthorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemAuthor;
	}

	/**
	 * Returns the item author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemAuthorPK the primary key of the item author
	 * @return the item author, or <code>null</code> if a item author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemAuthor fetchByPrimaryKey(ItemAuthorPK itemAuthorPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemAuthorPK);
	}

	/**
	 * Returns all the item authors.
	 *
	 * @return the item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item authors
	 * @param end the upper bound of the range of item authors (not inclusive)
	 * @return the range of item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item authors
	 * @param end the upper bound of the range of item authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item authors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemAuthor> findAll(int start, int end,
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

		List<ItemAuthor> list = (List<ItemAuthor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMAUTHOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMAUTHOR;

				if (pagination) {
					sql = sql.concat(ItemAuthorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemAuthor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemAuthor>(list);
				}
				else {
					list = (List<ItemAuthor>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the item authors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemAuthor itemAuthor : findAll()) {
			remove(itemAuthor);
		}
	}

	/**
	 * Returns the number of item authors.
	 *
	 * @return the number of item authors
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

				Query q = session.createQuery(_SQL_COUNT_ITEMAUTHOR);

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
	 * Initializes the item author persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.ItemAuthor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemAuthor>> listenersList = new ArrayList<ModelListener<ItemAuthor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemAuthor>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemAuthorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMAUTHOR = "SELECT itemAuthor FROM ItemAuthor itemAuthor";
	private static final String _SQL_SELECT_ITEMAUTHOR_WHERE = "SELECT itemAuthor FROM ItemAuthor itemAuthor WHERE ";
	private static final String _SQL_COUNT_ITEMAUTHOR = "SELECT COUNT(itemAuthor) FROM ItemAuthor itemAuthor";
	private static final String _SQL_COUNT_ITEMAUTHOR_WHERE = "SELECT COUNT(itemAuthor) FROM ItemAuthor itemAuthor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemAuthor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemAuthor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ItemAuthor exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemAuthorPersistenceImpl.class);
	private static ItemAuthor _nullItemAuthor = new ItemAuthorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemAuthor> toCacheModel() {
				return _nullItemAuthorCacheModel;
			}
		};

	private static CacheModel<ItemAuthor> _nullItemAuthorCacheModel = new CacheModel<ItemAuthor>() {
			@Override
			public ItemAuthor toEntityModel() {
				return _nullItemAuthor;
			}
		};
}