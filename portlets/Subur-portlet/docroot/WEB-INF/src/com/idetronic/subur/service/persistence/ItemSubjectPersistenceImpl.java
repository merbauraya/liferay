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

import com.idetronic.subur.NoSuchItemSubjectException;
import com.idetronic.subur.model.ItemSubject;
import com.idetronic.subur.model.impl.ItemSubjectImpl;
import com.idetronic.subur.model.impl.ItemSubjectModelImpl;

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
 * The persistence implementation for the item subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemSubjectPersistence
 * @see ItemSubjectUtil
 * @generated
 */
public class ItemSubjectPersistenceImpl extends BasePersistenceImpl<ItemSubject>
	implements ItemSubjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemSubjectUtil} to access the item subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemSubjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, ItemSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, ItemSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID = new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, ItemSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByitemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID =
		new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, ItemSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByitemId",
			new String[] { Long.class.getName() },
			ItemSubjectModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByitemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the item subjects where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findByitemId(long itemId)
		throws SystemException {
		return findByitemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item subjects where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of item subjects
	 * @param end the upper bound of the range of item subjects (not inclusive)
	 * @return the range of matching item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findByitemId(long itemId, int start, int end)
		throws SystemException {
		return findByitemId(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item subjects where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of item subjects
	 * @param end the upper bound of the range of item subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findByitemId(long itemId, int start, int end,
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

		List<ItemSubject> list = (List<ItemSubject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemSubject itemSubject : list) {
				if ((itemId != itemSubject.getItemId())) {
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

			query.append(_SQL_SELECT_ITEMSUBJECT_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemSubjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<ItemSubject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemSubject>(list);
				}
				else {
					list = (List<ItemSubject>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item subject in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item subject
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a matching item subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject findByitemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemSubjectException, SystemException {
		ItemSubject itemSubject = fetchByitemId_First(itemId, orderByComparator);

		if (itemSubject != null) {
			return itemSubject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemSubjectException(msg.toString());
	}

	/**
	 * Returns the first item subject in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item subject, or <code>null</code> if a matching item subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject fetchByitemId_First(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemSubject> list = findByitemId(itemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item subject in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item subject
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a matching item subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject findByitemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemSubjectException, SystemException {
		ItemSubject itemSubject = fetchByitemId_Last(itemId, orderByComparator);

		if (itemSubject != null) {
			return itemSubject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemSubjectException(msg.toString());
	}

	/**
	 * Returns the last item subject in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item subject, or <code>null</code> if a matching item subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject fetchByitemId_Last(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByitemId(itemId);

		if (count == 0) {
			return null;
		}

		List<ItemSubject> list = findByitemId(itemId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item subjects before and after the current item subject in the ordered set where itemId = &#63;.
	 *
	 * @param itemSubjectPK the primary key of the current item subject
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item subject
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject[] findByitemId_PrevAndNext(ItemSubjectPK itemSubjectPK,
		long itemId, OrderByComparator orderByComparator)
		throws NoSuchItemSubjectException, SystemException {
		ItemSubject itemSubject = findByPrimaryKey(itemSubjectPK);

		Session session = null;

		try {
			session = openSession();

			ItemSubject[] array = new ItemSubjectImpl[3];

			array[0] = getByitemId_PrevAndNext(session, itemSubject, itemId,
					orderByComparator, true);

			array[1] = itemSubject;

			array[2] = getByitemId_PrevAndNext(session, itemSubject, itemId,
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

	protected ItemSubject getByitemId_PrevAndNext(Session session,
		ItemSubject itemSubject, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMSUBJECT_WHERE);

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
			query.append(ItemSubjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemSubject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemSubject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item subjects where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByitemId(long itemId) throws SystemException {
		for (ItemSubject itemSubject : findByitemId(itemId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(itemSubject);
		}
	}

	/**
	 * Returns the number of item subjects where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching item subjects
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

			query.append(_SQL_COUNT_ITEMSUBJECT_WHERE);

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

	private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "itemSubject.id.itemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBJECTID =
		new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, ItemSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysubjectId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECTID =
		new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, ItemSubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysubjectId",
			new String[] { Long.class.getName() },
			ItemSubjectModelImpl.SUBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUBJECTID = new FinderPath(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysubjectId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the item subjects where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findBysubjectId(long subjectId)
		throws SystemException {
		return findBysubjectId(subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the item subjects where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of item subjects
	 * @param end the upper bound of the range of item subjects (not inclusive)
	 * @return the range of matching item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findBysubjectId(long subjectId, int start, int end)
		throws SystemException {
		return findBysubjectId(subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item subjects where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of item subjects
	 * @param end the upper bound of the range of item subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findBysubjectId(long subjectId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECTID;
			finderArgs = new Object[] { subjectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBJECTID;
			finderArgs = new Object[] { subjectId, start, end, orderByComparator };
		}

		List<ItemSubject> list = (List<ItemSubject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemSubject itemSubject : list) {
				if ((subjectId != itemSubject.getSubjectId())) {
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

			query.append(_SQL_SELECT_ITEMSUBJECT_WHERE);

			query.append(_FINDER_COLUMN_SUBJECTID_SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemSubjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(subjectId);

				if (!pagination) {
					list = (List<ItemSubject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemSubject>(list);
				}
				else {
					list = (List<ItemSubject>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item subject in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item subject
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a matching item subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject findBysubjectId_First(long subjectId,
		OrderByComparator orderByComparator)
		throws NoSuchItemSubjectException, SystemException {
		ItemSubject itemSubject = fetchBysubjectId_First(subjectId,
				orderByComparator);

		if (itemSubject != null) {
			return itemSubject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subjectId=");
		msg.append(subjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemSubjectException(msg.toString());
	}

	/**
	 * Returns the first item subject in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item subject, or <code>null</code> if a matching item subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject fetchBysubjectId_First(long subjectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemSubject> list = findBysubjectId(subjectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item subject in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item subject
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a matching item subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject findBysubjectId_Last(long subjectId,
		OrderByComparator orderByComparator)
		throws NoSuchItemSubjectException, SystemException {
		ItemSubject itemSubject = fetchBysubjectId_Last(subjectId,
				orderByComparator);

		if (itemSubject != null) {
			return itemSubject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subjectId=");
		msg.append(subjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemSubjectException(msg.toString());
	}

	/**
	 * Returns the last item subject in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item subject, or <code>null</code> if a matching item subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject fetchBysubjectId_Last(long subjectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBysubjectId(subjectId);

		if (count == 0) {
			return null;
		}

		List<ItemSubject> list = findBysubjectId(subjectId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item subjects before and after the current item subject in the ordered set where subjectId = &#63;.
	 *
	 * @param itemSubjectPK the primary key of the current item subject
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item subject
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject[] findBysubjectId_PrevAndNext(
		ItemSubjectPK itemSubjectPK, long subjectId,
		OrderByComparator orderByComparator)
		throws NoSuchItemSubjectException, SystemException {
		ItemSubject itemSubject = findByPrimaryKey(itemSubjectPK);

		Session session = null;

		try {
			session = openSession();

			ItemSubject[] array = new ItemSubjectImpl[3];

			array[0] = getBysubjectId_PrevAndNext(session, itemSubject,
					subjectId, orderByComparator, true);

			array[1] = itemSubject;

			array[2] = getBysubjectId_PrevAndNext(session, itemSubject,
					subjectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ItemSubject getBysubjectId_PrevAndNext(Session session,
		ItemSubject itemSubject, long subjectId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMSUBJECT_WHERE);

		query.append(_FINDER_COLUMN_SUBJECTID_SUBJECTID_2);

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
			query.append(ItemSubjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(subjectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemSubject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemSubject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item subjects where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysubjectId(long subjectId) throws SystemException {
		for (ItemSubject itemSubject : findBysubjectId(subjectId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemSubject);
		}
	}

	/**
	 * Returns the number of item subjects where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysubjectId(long subjectId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBJECTID;

		Object[] finderArgs = new Object[] { subjectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEMSUBJECT_WHERE);

			query.append(_FINDER_COLUMN_SUBJECTID_SUBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(subjectId);

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

	private static final String _FINDER_COLUMN_SUBJECTID_SUBJECTID_2 = "itemSubject.id.subjectId = ?";

	public ItemSubjectPersistenceImpl() {
		setModelClass(ItemSubject.class);
	}

	/**
	 * Caches the item subject in the entity cache if it is enabled.
	 *
	 * @param itemSubject the item subject
	 */
	@Override
	public void cacheResult(ItemSubject itemSubject) {
		EntityCacheUtil.putResult(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectImpl.class, itemSubject.getPrimaryKey(), itemSubject);

		itemSubject.resetOriginalValues();
	}

	/**
	 * Caches the item subjects in the entity cache if it is enabled.
	 *
	 * @param itemSubjects the item subjects
	 */
	@Override
	public void cacheResult(List<ItemSubject> itemSubjects) {
		for (ItemSubject itemSubject : itemSubjects) {
			if (EntityCacheUtil.getResult(
						ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
						ItemSubjectImpl.class, itemSubject.getPrimaryKey()) == null) {
				cacheResult(itemSubject);
			}
			else {
				itemSubject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item subjects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemSubjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemSubjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item subject.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemSubject itemSubject) {
		EntityCacheUtil.removeResult(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectImpl.class, itemSubject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemSubject> itemSubjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemSubject itemSubject : itemSubjects) {
			EntityCacheUtil.removeResult(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
				ItemSubjectImpl.class, itemSubject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item subject with the primary key. Does not add the item subject to the database.
	 *
	 * @param itemSubjectPK the primary key for the new item subject
	 * @return the new item subject
	 */
	@Override
	public ItemSubject create(ItemSubjectPK itemSubjectPK) {
		ItemSubject itemSubject = new ItemSubjectImpl();

		itemSubject.setNew(true);
		itemSubject.setPrimaryKey(itemSubjectPK);

		return itemSubject;
	}

	/**
	 * Removes the item subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemSubjectPK the primary key of the item subject
	 * @return the item subject that was removed
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject remove(ItemSubjectPK itemSubjectPK)
		throws NoSuchItemSubjectException, SystemException {
		return remove((Serializable)itemSubjectPK);
	}

	/**
	 * Removes the item subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item subject
	 * @return the item subject that was removed
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject remove(Serializable primaryKey)
		throws NoSuchItemSubjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemSubject itemSubject = (ItemSubject)session.get(ItemSubjectImpl.class,
					primaryKey);

			if (itemSubject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemSubject);
		}
		catch (NoSuchItemSubjectException nsee) {
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
	protected ItemSubject removeImpl(ItemSubject itemSubject)
		throws SystemException {
		itemSubject = toUnwrappedModel(itemSubject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemSubject)) {
				itemSubject = (ItemSubject)session.get(ItemSubjectImpl.class,
						itemSubject.getPrimaryKeyObj());
			}

			if (itemSubject != null) {
				session.delete(itemSubject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemSubject != null) {
			clearCache(itemSubject);
		}

		return itemSubject;
	}

	@Override
	public ItemSubject updateImpl(
		com.idetronic.subur.model.ItemSubject itemSubject)
		throws SystemException {
		itemSubject = toUnwrappedModel(itemSubject);

		boolean isNew = itemSubject.isNew();

		ItemSubjectModelImpl itemSubjectModelImpl = (ItemSubjectModelImpl)itemSubject;

		Session session = null;

		try {
			session = openSession();

			if (itemSubject.isNew()) {
				session.save(itemSubject);

				itemSubject.setNew(false);
			}
			else {
				session.merge(itemSubject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ItemSubjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((itemSubjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemSubjectModelImpl.getOriginalItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);

				args = new Object[] { itemSubjectModelImpl.getItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);
			}

			if ((itemSubjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemSubjectModelImpl.getOriginalSubjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECTID,
					args);

				args = new Object[] { itemSubjectModelImpl.getSubjectId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECTID,
					args);
			}
		}

		EntityCacheUtil.putResult(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
			ItemSubjectImpl.class, itemSubject.getPrimaryKey(), itemSubject);

		return itemSubject;
	}

	protected ItemSubject toUnwrappedModel(ItemSubject itemSubject) {
		if (itemSubject instanceof ItemSubjectImpl) {
			return itemSubject;
		}

		ItemSubjectImpl itemSubjectImpl = new ItemSubjectImpl();

		itemSubjectImpl.setNew(itemSubject.isNew());
		itemSubjectImpl.setPrimaryKey(itemSubject.getPrimaryKey());

		itemSubjectImpl.setItemId(itemSubject.getItemId());
		itemSubjectImpl.setSubjectId(itemSubject.getSubjectId());

		return itemSubjectImpl;
	}

	/**
	 * Returns the item subject with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item subject
	 * @return the item subject
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemSubjectException, SystemException {
		ItemSubject itemSubject = fetchByPrimaryKey(primaryKey);

		if (itemSubject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemSubject;
	}

	/**
	 * Returns the item subject with the primary key or throws a {@link com.idetronic.subur.NoSuchItemSubjectException} if it could not be found.
	 *
	 * @param itemSubjectPK the primary key of the item subject
	 * @return the item subject
	 * @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject findByPrimaryKey(ItemSubjectPK itemSubjectPK)
		throws NoSuchItemSubjectException, SystemException {
		return findByPrimaryKey((Serializable)itemSubjectPK);
	}

	/**
	 * Returns the item subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item subject
	 * @return the item subject, or <code>null</code> if a item subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemSubject itemSubject = (ItemSubject)EntityCacheUtil.getResult(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
				ItemSubjectImpl.class, primaryKey);

		if (itemSubject == _nullItemSubject) {
			return null;
		}

		if (itemSubject == null) {
			Session session = null;

			try {
				session = openSession();

				itemSubject = (ItemSubject)session.get(ItemSubjectImpl.class,
						primaryKey);

				if (itemSubject != null) {
					cacheResult(itemSubject);
				}
				else {
					EntityCacheUtil.putResult(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
						ItemSubjectImpl.class, primaryKey, _nullItemSubject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemSubjectModelImpl.ENTITY_CACHE_ENABLED,
					ItemSubjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemSubject;
	}

	/**
	 * Returns the item subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemSubjectPK the primary key of the item subject
	 * @return the item subject, or <code>null</code> if a item subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemSubject fetchByPrimaryKey(ItemSubjectPK itemSubjectPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemSubjectPK);
	}

	/**
	 * Returns all the item subjects.
	 *
	 * @return the item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item subjects
	 * @param end the upper bound of the range of item subjects (not inclusive)
	 * @return the range of item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item subjects
	 * @param end the upper bound of the range of item subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemSubject> findAll(int start, int end,
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

		List<ItemSubject> list = (List<ItemSubject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMSUBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMSUBJECT;

				if (pagination) {
					sql = sql.concat(ItemSubjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemSubject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemSubject>(list);
				}
				else {
					list = (List<ItemSubject>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the item subjects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemSubject itemSubject : findAll()) {
			remove(itemSubject);
		}
	}

	/**
	 * Returns the number of item subjects.
	 *
	 * @return the number of item subjects
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

				Query q = session.createQuery(_SQL_COUNT_ITEMSUBJECT);

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
	 * Initializes the item subject persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.ItemSubject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemSubject>> listenersList = new ArrayList<ModelListener<ItemSubject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemSubject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemSubjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMSUBJECT = "SELECT itemSubject FROM ItemSubject itemSubject";
	private static final String _SQL_SELECT_ITEMSUBJECT_WHERE = "SELECT itemSubject FROM ItemSubject itemSubject WHERE ";
	private static final String _SQL_COUNT_ITEMSUBJECT = "SELECT COUNT(itemSubject) FROM ItemSubject itemSubject";
	private static final String _SQL_COUNT_ITEMSUBJECT_WHERE = "SELECT COUNT(itemSubject) FROM ItemSubject itemSubject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemSubject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemSubject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ItemSubject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemSubjectPersistenceImpl.class);
	private static ItemSubject _nullItemSubject = new ItemSubjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemSubject> toCacheModel() {
				return _nullItemSubjectCacheModel;
			}
		};

	private static CacheModel<ItemSubject> _nullItemSubjectCacheModel = new CacheModel<ItemSubject>() {
			@Override
			public ItemSubject toEntityModel() {
				return _nullItemSubject;
			}
		};
}