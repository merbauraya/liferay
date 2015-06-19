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

import com.idetronic.subur.NoSuchMetadataPropertyValueException;
import com.idetronic.subur.model.MetadataPropertyValue;
import com.idetronic.subur.model.impl.MetadataPropertyValueImpl;
import com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl;

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
 * The persistence implementation for the metadata property value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataPropertyValuePersistence
 * @see MetadataPropertyValueUtil
 * @generated
 */
public class MetadataPropertyValuePersistenceImpl extends BasePersistenceImpl<MetadataPropertyValue>
	implements MetadataPropertyValuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MetadataPropertyValueUtil} to access the metadata property value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MetadataPropertyValueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueModelImpl.FINDER_CACHE_ENABLED,
			MetadataPropertyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueModelImpl.FINDER_CACHE_ENABLED,
			MetadataPropertyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYITEMID = new FinderPath(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueModelImpl.FINDER_CACHE_ENABLED,
			MetadataPropertyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID =
		new FinderPath(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueModelImpl.FINDER_CACHE_ENABLED,
			MetadataPropertyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyItemId",
			new String[] { Long.class.getName() },
			MetadataPropertyValueModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYITEMID = new FinderPath(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the metadata property values where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching metadata property values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataPropertyValue> findBybyItemId(long itemId)
		throws SystemException {
		return findBybyItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadata property values where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of metadata property values
	 * @param end the upper bound of the range of metadata property values (not inclusive)
	 * @return the range of matching metadata property values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataPropertyValue> findBybyItemId(long itemId, int start,
		int end) throws SystemException {
		return findBybyItemId(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadata property values where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of metadata property values
	 * @param end the upper bound of the range of metadata property values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadata property values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataPropertyValue> findBybyItemId(long itemId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<MetadataPropertyValue> list = (List<MetadataPropertyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MetadataPropertyValue metadataPropertyValue : list) {
				if ((itemId != metadataPropertyValue.getItemId())) {
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

			query.append(_SQL_SELECT_METADATAPROPERTYVALUE_WHERE);

			query.append(_FINDER_COLUMN_BYITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MetadataPropertyValueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<MetadataPropertyValue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MetadataPropertyValue>(list);
				}
				else {
					list = (List<MetadataPropertyValue>)QueryUtil.list(q,
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
	 * Returns the first metadata property value in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata property value
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a matching metadata property value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue findBybyItemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchMetadataPropertyValueException, SystemException {
		MetadataPropertyValue metadataPropertyValue = fetchBybyItemId_First(itemId,
				orderByComparator);

		if (metadataPropertyValue != null) {
			return metadataPropertyValue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMetadataPropertyValueException(msg.toString());
	}

	/**
	 * Returns the first metadata property value in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata property value, or <code>null</code> if a matching metadata property value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue fetchBybyItemId_First(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MetadataPropertyValue> list = findBybyItemId(itemId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last metadata property value in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata property value
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a matching metadata property value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue findBybyItemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchMetadataPropertyValueException, SystemException {
		MetadataPropertyValue metadataPropertyValue = fetchBybyItemId_Last(itemId,
				orderByComparator);

		if (metadataPropertyValue != null) {
			return metadataPropertyValue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMetadataPropertyValueException(msg.toString());
	}

	/**
	 * Returns the last metadata property value in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata property value, or <code>null</code> if a matching metadata property value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue fetchBybyItemId_Last(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyItemId(itemId);

		if (count == 0) {
			return null;
		}

		List<MetadataPropertyValue> list = findBybyItemId(itemId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the metadata property values before and after the current metadata property value in the ordered set where itemId = &#63;.
	 *
	 * @param metadataPropertyValueId the primary key of the current metadata property value
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata property value
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a metadata property value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue[] findBybyItemId_PrevAndNext(
		long metadataPropertyValueId, long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchMetadataPropertyValueException, SystemException {
		MetadataPropertyValue metadataPropertyValue = findByPrimaryKey(metadataPropertyValueId);

		Session session = null;

		try {
			session = openSession();

			MetadataPropertyValue[] array = new MetadataPropertyValueImpl[3];

			array[0] = getBybyItemId_PrevAndNext(session,
					metadataPropertyValue, itemId, orderByComparator, true);

			array[1] = metadataPropertyValue;

			array[2] = getBybyItemId_PrevAndNext(session,
					metadataPropertyValue, itemId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MetadataPropertyValue getBybyItemId_PrevAndNext(Session session,
		MetadataPropertyValue metadataPropertyValue, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_METADATAPROPERTYVALUE_WHERE);

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
			query.append(MetadataPropertyValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(metadataPropertyValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MetadataPropertyValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the metadata property values where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyItemId(long itemId) throws SystemException {
		for (MetadataPropertyValue metadataPropertyValue : findBybyItemId(
				itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(metadataPropertyValue);
		}
	}

	/**
	 * Returns the number of metadata property values where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching metadata property values
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

			query.append(_SQL_COUNT_METADATAPROPERTYVALUE_WHERE);

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

	private static final String _FINDER_COLUMN_BYITEMID_ITEMID_2 = "metadataPropertyValue.itemId = ?";

	public MetadataPropertyValuePersistenceImpl() {
		setModelClass(MetadataPropertyValue.class);
	}

	/**
	 * Caches the metadata property value in the entity cache if it is enabled.
	 *
	 * @param metadataPropertyValue the metadata property value
	 */
	@Override
	public void cacheResult(MetadataPropertyValue metadataPropertyValue) {
		EntityCacheUtil.putResult(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueImpl.class,
			metadataPropertyValue.getPrimaryKey(), metadataPropertyValue);

		metadataPropertyValue.resetOriginalValues();
	}

	/**
	 * Caches the metadata property values in the entity cache if it is enabled.
	 *
	 * @param metadataPropertyValues the metadata property values
	 */
	@Override
	public void cacheResult(List<MetadataPropertyValue> metadataPropertyValues) {
		for (MetadataPropertyValue metadataPropertyValue : metadataPropertyValues) {
			if (EntityCacheUtil.getResult(
						MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
						MetadataPropertyValueImpl.class,
						metadataPropertyValue.getPrimaryKey()) == null) {
				cacheResult(metadataPropertyValue);
			}
			else {
				metadataPropertyValue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all metadata property values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MetadataPropertyValueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MetadataPropertyValueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the metadata property value.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MetadataPropertyValue metadataPropertyValue) {
		EntityCacheUtil.removeResult(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueImpl.class,
			metadataPropertyValue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MetadataPropertyValue> metadataPropertyValues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MetadataPropertyValue metadataPropertyValue : metadataPropertyValues) {
			EntityCacheUtil.removeResult(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
				MetadataPropertyValueImpl.class,
				metadataPropertyValue.getPrimaryKey());
		}
	}

	/**
	 * Creates a new metadata property value with the primary key. Does not add the metadata property value to the database.
	 *
	 * @param metadataPropertyValueId the primary key for the new metadata property value
	 * @return the new metadata property value
	 */
	@Override
	public MetadataPropertyValue create(long metadataPropertyValueId) {
		MetadataPropertyValue metadataPropertyValue = new MetadataPropertyValueImpl();

		metadataPropertyValue.setNew(true);
		metadataPropertyValue.setPrimaryKey(metadataPropertyValueId);

		return metadataPropertyValue;
	}

	/**
	 * Removes the metadata property value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataPropertyValueId the primary key of the metadata property value
	 * @return the metadata property value that was removed
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a metadata property value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue remove(long metadataPropertyValueId)
		throws NoSuchMetadataPropertyValueException, SystemException {
		return remove((Serializable)metadataPropertyValueId);
	}

	/**
	 * Removes the metadata property value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the metadata property value
	 * @return the metadata property value that was removed
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a metadata property value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue remove(Serializable primaryKey)
		throws NoSuchMetadataPropertyValueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MetadataPropertyValue metadataPropertyValue = (MetadataPropertyValue)session.get(MetadataPropertyValueImpl.class,
					primaryKey);

			if (metadataPropertyValue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetadataPropertyValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(metadataPropertyValue);
		}
		catch (NoSuchMetadataPropertyValueException nsee) {
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
	protected MetadataPropertyValue removeImpl(
		MetadataPropertyValue metadataPropertyValue) throws SystemException {
		metadataPropertyValue = toUnwrappedModel(metadataPropertyValue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metadataPropertyValue)) {
				metadataPropertyValue = (MetadataPropertyValue)session.get(MetadataPropertyValueImpl.class,
						metadataPropertyValue.getPrimaryKeyObj());
			}

			if (metadataPropertyValue != null) {
				session.delete(metadataPropertyValue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (metadataPropertyValue != null) {
			clearCache(metadataPropertyValue);
		}

		return metadataPropertyValue;
	}

	@Override
	public MetadataPropertyValue updateImpl(
		com.idetronic.subur.model.MetadataPropertyValue metadataPropertyValue)
		throws SystemException {
		metadataPropertyValue = toUnwrappedModel(metadataPropertyValue);

		boolean isNew = metadataPropertyValue.isNew();

		MetadataPropertyValueModelImpl metadataPropertyValueModelImpl = (MetadataPropertyValueModelImpl)metadataPropertyValue;

		Session session = null;

		try {
			session = openSession();

			if (metadataPropertyValue.isNew()) {
				session.save(metadataPropertyValue);

				metadataPropertyValue.setNew(false);
			}
			else {
				session.merge(metadataPropertyValue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MetadataPropertyValueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((metadataPropertyValueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						metadataPropertyValueModelImpl.getOriginalItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID,
					args);

				args = new Object[] { metadataPropertyValueModelImpl.getItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYITEMID,
					args);
			}
		}

		EntityCacheUtil.putResult(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyValueImpl.class,
			metadataPropertyValue.getPrimaryKey(), metadataPropertyValue);

		return metadataPropertyValue;
	}

	protected MetadataPropertyValue toUnwrappedModel(
		MetadataPropertyValue metadataPropertyValue) {
		if (metadataPropertyValue instanceof MetadataPropertyValueImpl) {
			return metadataPropertyValue;
		}

		MetadataPropertyValueImpl metadataPropertyValueImpl = new MetadataPropertyValueImpl();

		metadataPropertyValueImpl.setNew(metadataPropertyValue.isNew());
		metadataPropertyValueImpl.setPrimaryKey(metadataPropertyValue.getPrimaryKey());

		metadataPropertyValueImpl.setMetadataPropertyValueId(metadataPropertyValue.getMetadataPropertyValueId());
		metadataPropertyValueImpl.setItemId(metadataPropertyValue.getItemId());
		metadataPropertyValueImpl.setPropertyId(metadataPropertyValue.getPropertyId());
		metadataPropertyValueImpl.setTextValue(metadataPropertyValue.getTextValue());
		metadataPropertyValueImpl.setItemCount(metadataPropertyValue.getItemCount());

		return metadataPropertyValueImpl;
	}

	/**
	 * Returns the metadata property value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata property value
	 * @return the metadata property value
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a metadata property value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetadataPropertyValueException, SystemException {
		MetadataPropertyValue metadataPropertyValue = fetchByPrimaryKey(primaryKey);

		if (metadataPropertyValue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetadataPropertyValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return metadataPropertyValue;
	}

	/**
	 * Returns the metadata property value with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataPropertyValueException} if it could not be found.
	 *
	 * @param metadataPropertyValueId the primary key of the metadata property value
	 * @return the metadata property value
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a metadata property value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue findByPrimaryKey(long metadataPropertyValueId)
		throws NoSuchMetadataPropertyValueException, SystemException {
		return findByPrimaryKey((Serializable)metadataPropertyValueId);
	}

	/**
	 * Returns the metadata property value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata property value
	 * @return the metadata property value, or <code>null</code> if a metadata property value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MetadataPropertyValue metadataPropertyValue = (MetadataPropertyValue)EntityCacheUtil.getResult(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
				MetadataPropertyValueImpl.class, primaryKey);

		if (metadataPropertyValue == _nullMetadataPropertyValue) {
			return null;
		}

		if (metadataPropertyValue == null) {
			Session session = null;

			try {
				session = openSession();

				metadataPropertyValue = (MetadataPropertyValue)session.get(MetadataPropertyValueImpl.class,
						primaryKey);

				if (metadataPropertyValue != null) {
					cacheResult(metadataPropertyValue);
				}
				else {
					EntityCacheUtil.putResult(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
						MetadataPropertyValueImpl.class, primaryKey,
						_nullMetadataPropertyValue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MetadataPropertyValueModelImpl.ENTITY_CACHE_ENABLED,
					MetadataPropertyValueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return metadataPropertyValue;
	}

	/**
	 * Returns the metadata property value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataPropertyValueId the primary key of the metadata property value
	 * @return the metadata property value, or <code>null</code> if a metadata property value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataPropertyValue fetchByPrimaryKey(long metadataPropertyValueId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)metadataPropertyValueId);
	}

	/**
	 * Returns all the metadata property values.
	 *
	 * @return the metadata property values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataPropertyValue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadata property values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadata property values
	 * @param end the upper bound of the range of metadata property values (not inclusive)
	 * @return the range of metadata property values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataPropertyValue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadata property values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadata property values
	 * @param end the upper bound of the range of metadata property values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadata property values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataPropertyValue> findAll(int start, int end,
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

		List<MetadataPropertyValue> list = (List<MetadataPropertyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_METADATAPROPERTYVALUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_METADATAPROPERTYVALUE;

				if (pagination) {
					sql = sql.concat(MetadataPropertyValueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MetadataPropertyValue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MetadataPropertyValue>(list);
				}
				else {
					list = (List<MetadataPropertyValue>)QueryUtil.list(q,
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
	 * Removes all the metadata property values from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MetadataPropertyValue metadataPropertyValue : findAll()) {
			remove(metadataPropertyValue);
		}
	}

	/**
	 * Returns the number of metadata property values.
	 *
	 * @return the number of metadata property values
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

				Query q = session.createQuery(_SQL_COUNT_METADATAPROPERTYVALUE);

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
	 * Initializes the metadata property value persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.MetadataPropertyValue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MetadataPropertyValue>> listenersList = new ArrayList<ModelListener<MetadataPropertyValue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MetadataPropertyValue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MetadataPropertyValueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_METADATAPROPERTYVALUE = "SELECT metadataPropertyValue FROM MetadataPropertyValue metadataPropertyValue";
	private static final String _SQL_SELECT_METADATAPROPERTYVALUE_WHERE = "SELECT metadataPropertyValue FROM MetadataPropertyValue metadataPropertyValue WHERE ";
	private static final String _SQL_COUNT_METADATAPROPERTYVALUE = "SELECT COUNT(metadataPropertyValue) FROM MetadataPropertyValue metadataPropertyValue";
	private static final String _SQL_COUNT_METADATAPROPERTYVALUE_WHERE = "SELECT COUNT(metadataPropertyValue) FROM MetadataPropertyValue metadataPropertyValue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "metadataPropertyValue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MetadataPropertyValue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MetadataPropertyValue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MetadataPropertyValuePersistenceImpl.class);
	private static MetadataPropertyValue _nullMetadataPropertyValue = new MetadataPropertyValueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MetadataPropertyValue> toCacheModel() {
				return _nullMetadataPropertyValueCacheModel;
			}
		};

	private static CacheModel<MetadataPropertyValue> _nullMetadataPropertyValueCacheModel =
		new CacheModel<MetadataPropertyValue>() {
			@Override
			public MetadataPropertyValue toEntityModel() {
				return _nullMetadataPropertyValue;
			}
		};
}