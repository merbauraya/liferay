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

import com.idetronic.subur.NoSuchItemItemTypeException;
import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.impl.ItemItemTypeImpl;
import com.idetronic.subur.model.impl.ItemItemTypeModelImpl;

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
 * The persistence implementation for the item item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemItemTypePersistence
 * @see ItemItemTypeUtil
 * @generated
 */
public class ItemItemTypePersistenceImpl extends BasePersistenceImpl<ItemItemType>
	implements ItemItemTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemItemTypeUtil} to access the item item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemItemTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID = new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID =
		new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemId",
			new String[] { Long.class.getName() },
			ItemItemTypeModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the item item types where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findByItemId(long itemId)
		throws SystemException {
		return findByItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item item types where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of item item types
	 * @param end the upper bound of the range of item item types (not inclusive)
	 * @return the range of matching item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findByItemId(long itemId, int start, int end)
		throws SystemException {
		return findByItemId(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item item types where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of item item types
	 * @param end the upper bound of the range of item item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findByItemId(long itemId, int start, int end,
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

		List<ItemItemType> list = (List<ItemItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemItemType itemItemType : list) {
				if ((itemId != itemItemType.getItemId())) {
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

			query.append(_SQL_SELECT_ITEMITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemItemTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<ItemItemType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemItemType>(list);
				}
				else {
					list = (List<ItemItemType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item item type in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item item type
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a matching item item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType findByItemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemItemTypeException, SystemException {
		ItemItemType itemItemType = fetchByItemId_First(itemId,
				orderByComparator);

		if (itemItemType != null) {
			return itemItemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemItemTypeException(msg.toString());
	}

	/**
	 * Returns the first item item type in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item item type, or <code>null</code> if a matching item item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType fetchByItemId_First(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemItemType> list = findByItemId(itemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item item type in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item item type
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a matching item item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType findByItemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemItemTypeException, SystemException {
		ItemItemType itemItemType = fetchByItemId_Last(itemId, orderByComparator);

		if (itemItemType != null) {
			return itemItemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemItemTypeException(msg.toString());
	}

	/**
	 * Returns the last item item type in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item item type, or <code>null</code> if a matching item item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType fetchByItemId_Last(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemId(itemId);

		if (count == 0) {
			return null;
		}

		List<ItemItemType> list = findByItemId(itemId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item item types before and after the current item item type in the ordered set where itemId = &#63;.
	 *
	 * @param itemItemTypePK the primary key of the current item item type
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item item type
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType[] findByItemId_PrevAndNext(
		ItemItemTypePK itemItemTypePK, long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemItemTypeException, SystemException {
		ItemItemType itemItemType = findByPrimaryKey(itemItemTypePK);

		Session session = null;

		try {
			session = openSession();

			ItemItemType[] array = new ItemItemTypeImpl[3];

			array[0] = getByItemId_PrevAndNext(session, itemItemType, itemId,
					orderByComparator, true);

			array[1] = itemItemType;

			array[2] = getByItemId_PrevAndNext(session, itemItemType, itemId,
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

	protected ItemItemType getByItemId_PrevAndNext(Session session,
		ItemItemType itemItemType, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMITEMTYPE_WHERE);

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
			query.append(ItemItemTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemItemType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemItemType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item item types where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemId(long itemId) throws SystemException {
		for (ItemItemType itemItemType : findByItemId(itemId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemItemType);
		}
	}

	/**
	 * Returns the number of item item types where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching item item types
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

			query.append(_SQL_COUNT_ITEMITEMTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "itemItemType.id.itemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPE = new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByItemType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE =
		new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemType",
			new String[] { Long.class.getName() },
			ItemItemTypeModelImpl.ITEMTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMTYPE = new FinderPath(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the item item types where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @return the matching item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findByItemType(long itemTypeId)
		throws SystemException {
		return findByItemType(itemTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the item item types where itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of item item types
	 * @param end the upper bound of the range of item item types (not inclusive)
	 * @return the range of matching item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findByItemType(long itemTypeId, int start, int end)
		throws SystemException {
		return findByItemType(itemTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item item types where itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of item item types
	 * @param end the upper bound of the range of item item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findByItemType(long itemTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ItemItemType> list = (List<ItemItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemItemType itemItemType : list) {
				if ((itemTypeId != itemItemType.getItemTypeId())) {
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

			query.append(_SQL_SELECT_ITEMITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemItemTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemTypeId);

				if (!pagination) {
					list = (List<ItemItemType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemItemType>(list);
				}
				else {
					list = (List<ItemItemType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item item type
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a matching item item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType findByItemType_First(long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchItemItemTypeException, SystemException {
		ItemItemType itemItemType = fetchByItemType_First(itemTypeId,
				orderByComparator);

		if (itemItemType != null) {
			return itemItemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemItemTypeException(msg.toString());
	}

	/**
	 * Returns the first item item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item item type, or <code>null</code> if a matching item item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType fetchByItemType_First(long itemTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemItemType> list = findByItemType(itemTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item item type
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a matching item item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType findByItemType_Last(long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchItemItemTypeException, SystemException {
		ItemItemType itemItemType = fetchByItemType_Last(itemTypeId,
				orderByComparator);

		if (itemItemType != null) {
			return itemItemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemItemTypeException(msg.toString());
	}

	/**
	 * Returns the last item item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item item type, or <code>null</code> if a matching item item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType fetchByItemType_Last(long itemTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemType(itemTypeId);

		if (count == 0) {
			return null;
		}

		List<ItemItemType> list = findByItemType(itemTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item item types before and after the current item item type in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemItemTypePK the primary key of the current item item type
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item item type
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType[] findByItemType_PrevAndNext(
		ItemItemTypePK itemItemTypePK, long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchItemItemTypeException, SystemException {
		ItemItemType itemItemType = findByPrimaryKey(itemItemTypePK);

		Session session = null;

		try {
			session = openSession();

			ItemItemType[] array = new ItemItemTypeImpl[3];

			array[0] = getByItemType_PrevAndNext(session, itemItemType,
					itemTypeId, orderByComparator, true);

			array[1] = itemItemType;

			array[2] = getByItemType_PrevAndNext(session, itemItemType,
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

	protected ItemItemType getByItemType_PrevAndNext(Session session,
		ItemItemType itemItemType, long itemTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMITEMTYPE_WHERE);

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
			query.append(ItemItemTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemItemType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemItemType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item item types where itemTypeId = &#63; from the database.
	 *
	 * @param itemTypeId the item type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemType(long itemTypeId) throws SystemException {
		for (ItemItemType itemItemType : findByItemType(itemTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemItemType);
		}
	}

	/**
	 * Returns the number of item item types where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @return the number of matching item item types
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

			query.append(_SQL_COUNT_ITEMITEMTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2 = "itemItemType.id.itemTypeId = ?";

	public ItemItemTypePersistenceImpl() {
		setModelClass(ItemItemType.class);
	}

	/**
	 * Caches the item item type in the entity cache if it is enabled.
	 *
	 * @param itemItemType the item item type
	 */
	@Override
	public void cacheResult(ItemItemType itemItemType) {
		EntityCacheUtil.putResult(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeImpl.class, itemItemType.getPrimaryKey(), itemItemType);

		itemItemType.resetOriginalValues();
	}

	/**
	 * Caches the item item types in the entity cache if it is enabled.
	 *
	 * @param itemItemTypes the item item types
	 */
	@Override
	public void cacheResult(List<ItemItemType> itemItemTypes) {
		for (ItemItemType itemItemType : itemItemTypes) {
			if (EntityCacheUtil.getResult(
						ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						ItemItemTypeImpl.class, itemItemType.getPrimaryKey()) == null) {
				cacheResult(itemItemType);
			}
			else {
				itemItemType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item item types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemItemTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemItemTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item item type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemItemType itemItemType) {
		EntityCacheUtil.removeResult(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeImpl.class, itemItemType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemItemType> itemItemTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemItemType itemItemType : itemItemTypes) {
			EntityCacheUtil.removeResult(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				ItemItemTypeImpl.class, itemItemType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item item type with the primary key. Does not add the item item type to the database.
	 *
	 * @param itemItemTypePK the primary key for the new item item type
	 * @return the new item item type
	 */
	@Override
	public ItemItemType create(ItemItemTypePK itemItemTypePK) {
		ItemItemType itemItemType = new ItemItemTypeImpl();

		itemItemType.setNew(true);
		itemItemType.setPrimaryKey(itemItemTypePK);

		return itemItemType;
	}

	/**
	 * Removes the item item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemItemTypePK the primary key of the item item type
	 * @return the item item type that was removed
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType remove(ItemItemTypePK itemItemTypePK)
		throws NoSuchItemItemTypeException, SystemException {
		return remove((Serializable)itemItemTypePK);
	}

	/**
	 * Removes the item item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item item type
	 * @return the item item type that was removed
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType remove(Serializable primaryKey)
		throws NoSuchItemItemTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemItemType itemItemType = (ItemItemType)session.get(ItemItemTypeImpl.class,
					primaryKey);

			if (itemItemType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemItemType);
		}
		catch (NoSuchItemItemTypeException nsee) {
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
	protected ItemItemType removeImpl(ItemItemType itemItemType)
		throws SystemException {
		itemItemType = toUnwrappedModel(itemItemType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemItemType)) {
				itemItemType = (ItemItemType)session.get(ItemItemTypeImpl.class,
						itemItemType.getPrimaryKeyObj());
			}

			if (itemItemType != null) {
				session.delete(itemItemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemItemType != null) {
			clearCache(itemItemType);
		}

		return itemItemType;
	}

	@Override
	public ItemItemType updateImpl(
		com.idetronic.subur.model.ItemItemType itemItemType)
		throws SystemException {
		itemItemType = toUnwrappedModel(itemItemType);

		boolean isNew = itemItemType.isNew();

		ItemItemTypeModelImpl itemItemTypeModelImpl = (ItemItemTypeModelImpl)itemItemType;

		Session session = null;

		try {
			session = openSession();

			if (itemItemType.isNew()) {
				session.save(itemItemType);

				itemItemType.setNew(false);
			}
			else {
				session.merge(itemItemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ItemItemTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((itemItemTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemItemTypeModelImpl.getOriginalItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);

				args = new Object[] { itemItemTypeModelImpl.getItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);
			}

			if ((itemItemTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemItemTypeModelImpl.getOriginalItemTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE,
					args);

				args = new Object[] { itemItemTypeModelImpl.getItemTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemItemTypeImpl.class, itemItemType.getPrimaryKey(), itemItemType);

		return itemItemType;
	}

	protected ItemItemType toUnwrappedModel(ItemItemType itemItemType) {
		if (itemItemType instanceof ItemItemTypeImpl) {
			return itemItemType;
		}

		ItemItemTypeImpl itemItemTypeImpl = new ItemItemTypeImpl();

		itemItemTypeImpl.setNew(itemItemType.isNew());
		itemItemTypeImpl.setPrimaryKey(itemItemType.getPrimaryKey());

		itemItemTypeImpl.setItemId(itemItemType.getItemId());
		itemItemTypeImpl.setItemTypeId(itemItemType.getItemTypeId());

		return itemItemTypeImpl;
	}

	/**
	 * Returns the item item type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item item type
	 * @return the item item type
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemItemTypeException, SystemException {
		ItemItemType itemItemType = fetchByPrimaryKey(primaryKey);

		if (itemItemType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemItemType;
	}

	/**
	 * Returns the item item type with the primary key or throws a {@link com.idetronic.subur.NoSuchItemItemTypeException} if it could not be found.
	 *
	 * @param itemItemTypePK the primary key of the item item type
	 * @return the item item type
	 * @throws com.idetronic.subur.NoSuchItemItemTypeException if a item item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType findByPrimaryKey(ItemItemTypePK itemItemTypePK)
		throws NoSuchItemItemTypeException, SystemException {
		return findByPrimaryKey((Serializable)itemItemTypePK);
	}

	/**
	 * Returns the item item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item item type
	 * @return the item item type, or <code>null</code> if a item item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemItemType itemItemType = (ItemItemType)EntityCacheUtil.getResult(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				ItemItemTypeImpl.class, primaryKey);

		if (itemItemType == _nullItemItemType) {
			return null;
		}

		if (itemItemType == null) {
			Session session = null;

			try {
				session = openSession();

				itemItemType = (ItemItemType)session.get(ItemItemTypeImpl.class,
						primaryKey);

				if (itemItemType != null) {
					cacheResult(itemItemType);
				}
				else {
					EntityCacheUtil.putResult(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						ItemItemTypeImpl.class, primaryKey, _nullItemItemType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemItemTypeModelImpl.ENTITY_CACHE_ENABLED,
					ItemItemTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemItemType;
	}

	/**
	 * Returns the item item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemItemTypePK the primary key of the item item type
	 * @return the item item type, or <code>null</code> if a item item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemItemType fetchByPrimaryKey(ItemItemTypePK itemItemTypePK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemItemTypePK);
	}

	/**
	 * Returns all the item item types.
	 *
	 * @return the item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item item types
	 * @param end the upper bound of the range of item item types (not inclusive)
	 * @return the range of item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item item types
	 * @param end the upper bound of the range of item item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemItemType> findAll(int start, int end,
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

		List<ItemItemType> list = (List<ItemItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMITEMTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMITEMTYPE;

				if (pagination) {
					sql = sql.concat(ItemItemTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemItemType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemItemType>(list);
				}
				else {
					list = (List<ItemItemType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the item item types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemItemType itemItemType : findAll()) {
			remove(itemItemType);
		}
	}

	/**
	 * Returns the number of item item types.
	 *
	 * @return the number of item item types
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

				Query q = session.createQuery(_SQL_COUNT_ITEMITEMTYPE);

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
	 * Initializes the item item type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.ItemItemType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemItemType>> listenersList = new ArrayList<ModelListener<ItemItemType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemItemType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemItemTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMITEMTYPE = "SELECT itemItemType FROM ItemItemType itemItemType";
	private static final String _SQL_SELECT_ITEMITEMTYPE_WHERE = "SELECT itemItemType FROM ItemItemType itemItemType WHERE ";
	private static final String _SQL_COUNT_ITEMITEMTYPE = "SELECT COUNT(itemItemType) FROM ItemItemType itemItemType";
	private static final String _SQL_COUNT_ITEMITEMTYPE_WHERE = "SELECT COUNT(itemItemType) FROM ItemItemType itemItemType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemItemType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemItemType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ItemItemType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemItemTypePersistenceImpl.class);
	private static ItemItemType _nullItemItemType = new ItemItemTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemItemType> toCacheModel() {
				return _nullItemItemTypeCacheModel;
			}
		};

	private static CacheModel<ItemItemType> _nullItemItemTypeCacheModel = new CacheModel<ItemItemType>() {
			@Override
			public ItemItemType toEntityModel() {
				return _nullItemItemType;
			}
		};
}