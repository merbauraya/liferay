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

import com.idetronic.subur.NoSuchItemFileEntryException;
import com.idetronic.subur.model.ItemFileEntry;
import com.idetronic.subur.model.impl.ItemFileEntryImpl;
import com.idetronic.subur.model.impl.ItemFileEntryModelImpl;

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
 * The persistence implementation for the item file entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemFileEntryPersistence
 * @see ItemFileEntryUtil
 * @generated
 */
public class ItemFileEntryPersistenceImpl extends BasePersistenceImpl<ItemFileEntry>
	implements ItemFileEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemFileEntryUtil} to access the item file entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemFileEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryModelImpl.FINDER_CACHE_ENABLED,
			ItemFileEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryModelImpl.FINDER_CACHE_ENABLED,
			ItemFileEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYITEMID = new FinderPath(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryModelImpl.FINDER_CACHE_ENABLED,
			ItemFileEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID =
		new FinderPath(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryModelImpl.FINDER_CACHE_ENABLED,
			ItemFileEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybyItemId", new String[] { Long.class.getName() },
			ItemFileEntryModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYITEMID = new FinderPath(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the item file entries where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching item file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemFileEntry> findBybyItemId(long itemId)
		throws SystemException {
		return findBybyItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item file entries where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of item file entries
	 * @param end the upper bound of the range of item file entries (not inclusive)
	 * @return the range of matching item file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemFileEntry> findBybyItemId(long itemId, int start, int end)
		throws SystemException {
		return findBybyItemId(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item file entries where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of item file entries
	 * @param end the upper bound of the range of item file entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemFileEntry> findBybyItemId(long itemId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID;
			finderArgs = new Object[] { itemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYITEMID;
			finderArgs = new Object[] { itemId, start, end, orderByComparator };
		}

		List<ItemFileEntry> list = (List<ItemFileEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemFileEntry itemFileEntry : list) {
				if ((itemId != itemFileEntry.getItemId())) {
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

			query.append(_SQL_SELECT_ITEMFILEENTRY_WHERE);

			query.append(_FINDER_COLUMN_BYITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemFileEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<ItemFileEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemFileEntry>(list);
				}
				else {
					list = (List<ItemFileEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item file entry in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item file entry
	 * @throws com.idetronic.subur.NoSuchItemFileEntryException if a matching item file entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry findBybyItemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemFileEntryException, SystemException {
		ItemFileEntry itemFileEntry = fetchBybyItemId_First(itemId,
				orderByComparator);

		if (itemFileEntry != null) {
			return itemFileEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemFileEntryException(msg.toString());
	}

	/**
	 * Returns the first item file entry in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item file entry, or <code>null</code> if a matching item file entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry fetchBybyItemId_First(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemFileEntry> list = findBybyItemId(itemId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item file entry in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item file entry
	 * @throws com.idetronic.subur.NoSuchItemFileEntryException if a matching item file entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry findBybyItemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemFileEntryException, SystemException {
		ItemFileEntry itemFileEntry = fetchBybyItemId_Last(itemId,
				orderByComparator);

		if (itemFileEntry != null) {
			return itemFileEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemFileEntryException(msg.toString());
	}

	/**
	 * Returns the last item file entry in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item file entry, or <code>null</code> if a matching item file entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry fetchBybyItemId_Last(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyItemId(itemId);

		if (count == 0) {
			return null;
		}

		List<ItemFileEntry> list = findBybyItemId(itemId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item file entries before and after the current item file entry in the ordered set where itemId = &#63;.
	 *
	 * @param itemFileEntryPK the primary key of the current item file entry
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item file entry
	 * @throws com.idetronic.subur.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry[] findBybyItemId_PrevAndNext(
		ItemFileEntryPK itemFileEntryPK, long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchItemFileEntryException, SystemException {
		ItemFileEntry itemFileEntry = findByPrimaryKey(itemFileEntryPK);

		Session session = null;

		try {
			session = openSession();

			ItemFileEntry[] array = new ItemFileEntryImpl[3];

			array[0] = getBybyItemId_PrevAndNext(session, itemFileEntry,
					itemId, orderByComparator, true);

			array[1] = itemFileEntry;

			array[2] = getBybyItemId_PrevAndNext(session, itemFileEntry,
					itemId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ItemFileEntry getBybyItemId_PrevAndNext(Session session,
		ItemFileEntry itemFileEntry, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMFILEENTRY_WHERE);

		query.append(_FINDER_COLUMN_BYITEMID_ITEMID_2);

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
			query.append(ItemFileEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemFileEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemFileEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item file entries where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyItemId(long itemId) throws SystemException {
		for (ItemFileEntry itemFileEntry : findBybyItemId(itemId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemFileEntry);
		}
	}

	/**
	 * Returns the number of item file entries where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching item file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyItemId(long itemId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYITEMID;

		Object[] finderArgs = new Object[] { itemId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEMFILEENTRY_WHERE);

			query.append(_FINDER_COLUMN_BYITEMID_ITEMID_2);

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

	private static final String _FINDER_COLUMN_BYITEMID_ITEMID_2 = "itemFileEntry.id.itemId = ?";

	public ItemFileEntryPersistenceImpl() {
		setModelClass(ItemFileEntry.class);
	}

	/**
	 * Caches the item file entry in the entity cache if it is enabled.
	 *
	 * @param itemFileEntry the item file entry
	 */
	@Override
	public void cacheResult(ItemFileEntry itemFileEntry) {
		EntityCacheUtil.putResult(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryImpl.class, itemFileEntry.getPrimaryKey(),
			itemFileEntry);

		itemFileEntry.resetOriginalValues();
	}

	/**
	 * Caches the item file entries in the entity cache if it is enabled.
	 *
	 * @param itemFileEntries the item file entries
	 */
	@Override
	public void cacheResult(List<ItemFileEntry> itemFileEntries) {
		for (ItemFileEntry itemFileEntry : itemFileEntries) {
			if (EntityCacheUtil.getResult(
						ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
						ItemFileEntryImpl.class, itemFileEntry.getPrimaryKey()) == null) {
				cacheResult(itemFileEntry);
			}
			else {
				itemFileEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item file entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemFileEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemFileEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item file entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemFileEntry itemFileEntry) {
		EntityCacheUtil.removeResult(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryImpl.class, itemFileEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemFileEntry> itemFileEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemFileEntry itemFileEntry : itemFileEntries) {
			EntityCacheUtil.removeResult(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
				ItemFileEntryImpl.class, itemFileEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item file entry with the primary key. Does not add the item file entry to the database.
	 *
	 * @param itemFileEntryPK the primary key for the new item file entry
	 * @return the new item file entry
	 */
	@Override
	public ItemFileEntry create(ItemFileEntryPK itemFileEntryPK) {
		ItemFileEntry itemFileEntry = new ItemFileEntryImpl();

		itemFileEntry.setNew(true);
		itemFileEntry.setPrimaryKey(itemFileEntryPK);

		return itemFileEntry;
	}

	/**
	 * Removes the item file entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemFileEntryPK the primary key of the item file entry
	 * @return the item file entry that was removed
	 * @throws com.idetronic.subur.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry remove(ItemFileEntryPK itemFileEntryPK)
		throws NoSuchItemFileEntryException, SystemException {
		return remove((Serializable)itemFileEntryPK);
	}

	/**
	 * Removes the item file entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item file entry
	 * @return the item file entry that was removed
	 * @throws com.idetronic.subur.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry remove(Serializable primaryKey)
		throws NoSuchItemFileEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemFileEntry itemFileEntry = (ItemFileEntry)session.get(ItemFileEntryImpl.class,
					primaryKey);

			if (itemFileEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemFileEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemFileEntry);
		}
		catch (NoSuchItemFileEntryException nsee) {
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
	protected ItemFileEntry removeImpl(ItemFileEntry itemFileEntry)
		throws SystemException {
		itemFileEntry = toUnwrappedModel(itemFileEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemFileEntry)) {
				itemFileEntry = (ItemFileEntry)session.get(ItemFileEntryImpl.class,
						itemFileEntry.getPrimaryKeyObj());
			}

			if (itemFileEntry != null) {
				session.delete(itemFileEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemFileEntry != null) {
			clearCache(itemFileEntry);
		}

		return itemFileEntry;
	}

	@Override
	public ItemFileEntry updateImpl(
		com.idetronic.subur.model.ItemFileEntry itemFileEntry)
		throws SystemException {
		itemFileEntry = toUnwrappedModel(itemFileEntry);

		boolean isNew = itemFileEntry.isNew();

		ItemFileEntryModelImpl itemFileEntryModelImpl = (ItemFileEntryModelImpl)itemFileEntry;

		Session session = null;

		try {
			session = openSession();

			if (itemFileEntry.isNew()) {
				session.save(itemFileEntry);

				itemFileEntry.setNew(false);
			}
			else {
				session.merge(itemFileEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ItemFileEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((itemFileEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemFileEntryModelImpl.getOriginalItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID,
					args);

				args = new Object[] { itemFileEntryModelImpl.getItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID,
					args);
			}
		}

		EntityCacheUtil.putResult(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			ItemFileEntryImpl.class, itemFileEntry.getPrimaryKey(),
			itemFileEntry);

		return itemFileEntry;
	}

	protected ItemFileEntry toUnwrappedModel(ItemFileEntry itemFileEntry) {
		if (itemFileEntry instanceof ItemFileEntryImpl) {
			return itemFileEntry;
		}

		ItemFileEntryImpl itemFileEntryImpl = new ItemFileEntryImpl();

		itemFileEntryImpl.setNew(itemFileEntry.isNew());
		itemFileEntryImpl.setPrimaryKey(itemFileEntry.getPrimaryKey());

		itemFileEntryImpl.setItemId(itemFileEntry.getItemId());
		itemFileEntryImpl.setFileEntryId(itemFileEntry.getFileEntryId());
		itemFileEntryImpl.setEntryType(itemFileEntry.getEntryType());

		return itemFileEntryImpl;
	}

	/**
	 * Returns the item file entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item file entry
	 * @return the item file entry
	 * @throws com.idetronic.subur.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemFileEntryException, SystemException {
		ItemFileEntry itemFileEntry = fetchByPrimaryKey(primaryKey);

		if (itemFileEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemFileEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemFileEntry;
	}

	/**
	 * Returns the item file entry with the primary key or throws a {@link com.idetronic.subur.NoSuchItemFileEntryException} if it could not be found.
	 *
	 * @param itemFileEntryPK the primary key of the item file entry
	 * @return the item file entry
	 * @throws com.idetronic.subur.NoSuchItemFileEntryException if a item file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry findByPrimaryKey(ItemFileEntryPK itemFileEntryPK)
		throws NoSuchItemFileEntryException, SystemException {
		return findByPrimaryKey((Serializable)itemFileEntryPK);
	}

	/**
	 * Returns the item file entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item file entry
	 * @return the item file entry, or <code>null</code> if a item file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemFileEntry itemFileEntry = (ItemFileEntry)EntityCacheUtil.getResult(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
				ItemFileEntryImpl.class, primaryKey);

		if (itemFileEntry == _nullItemFileEntry) {
			return null;
		}

		if (itemFileEntry == null) {
			Session session = null;

			try {
				session = openSession();

				itemFileEntry = (ItemFileEntry)session.get(ItemFileEntryImpl.class,
						primaryKey);

				if (itemFileEntry != null) {
					cacheResult(itemFileEntry);
				}
				else {
					EntityCacheUtil.putResult(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
						ItemFileEntryImpl.class, primaryKey, _nullItemFileEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemFileEntryModelImpl.ENTITY_CACHE_ENABLED,
					ItemFileEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemFileEntry;
	}

	/**
	 * Returns the item file entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemFileEntryPK the primary key of the item file entry
	 * @return the item file entry, or <code>null</code> if a item file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemFileEntry fetchByPrimaryKey(ItemFileEntryPK itemFileEntryPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemFileEntryPK);
	}

	/**
	 * Returns all the item file entries.
	 *
	 * @return the item file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemFileEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item file entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item file entries
	 * @param end the upper bound of the range of item file entries (not inclusive)
	 * @return the range of item file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemFileEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item file entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item file entries
	 * @param end the upper bound of the range of item file entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemFileEntry> findAll(int start, int end,
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

		List<ItemFileEntry> list = (List<ItemFileEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMFILEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMFILEENTRY;

				if (pagination) {
					sql = sql.concat(ItemFileEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemFileEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemFileEntry>(list);
				}
				else {
					list = (List<ItemFileEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the item file entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemFileEntry itemFileEntry : findAll()) {
			remove(itemFileEntry);
		}
	}

	/**
	 * Returns the number of item file entries.
	 *
	 * @return the number of item file entries
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

				Query q = session.createQuery(_SQL_COUNT_ITEMFILEENTRY);

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
	 * Initializes the item file entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.ItemFileEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemFileEntry>> listenersList = new ArrayList<ModelListener<ItemFileEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemFileEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemFileEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMFILEENTRY = "SELECT itemFileEntry FROM ItemFileEntry itemFileEntry";
	private static final String _SQL_SELECT_ITEMFILEENTRY_WHERE = "SELECT itemFileEntry FROM ItemFileEntry itemFileEntry WHERE ";
	private static final String _SQL_COUNT_ITEMFILEENTRY = "SELECT COUNT(itemFileEntry) FROM ItemFileEntry itemFileEntry";
	private static final String _SQL_COUNT_ITEMFILEENTRY_WHERE = "SELECT COUNT(itemFileEntry) FROM ItemFileEntry itemFileEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemFileEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemFileEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ItemFileEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemFileEntryPersistenceImpl.class);
	private static ItemFileEntry _nullItemFileEntry = new ItemFileEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemFileEntry> toCacheModel() {
				return _nullItemFileEntryCacheModel;
			}
		};

	private static CacheModel<ItemFileEntry> _nullItemFileEntryCacheModel = new CacheModel<ItemFileEntry>() {
			@Override
			public ItemFileEntry toEntityModel() {
				return _nullItemFileEntry;
			}
		};
}