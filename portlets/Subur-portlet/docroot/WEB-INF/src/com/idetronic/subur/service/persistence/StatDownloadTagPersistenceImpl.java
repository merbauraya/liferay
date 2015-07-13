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

import com.idetronic.subur.NoSuchStatDownloadTagException;
import com.idetronic.subur.model.StatDownloadTag;
import com.idetronic.subur.model.impl.StatDownloadTagImpl;
import com.idetronic.subur.model.impl.StatDownloadTagModelImpl;

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
 * The persistence implementation for the stat download tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadTagPersistence
 * @see StatDownloadTagUtil
 * @generated
 */
public class StatDownloadTagPersistenceImpl extends BasePersistenceImpl<StatDownloadTag>
	implements StatDownloadTagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatDownloadTagUtil} to access the stat download tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatDownloadTagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadTagImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAG = new FinderPath(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadTagImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTag",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG = new FinderPath(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagModelImpl.FINDER_CACHE_ENABLED,
			StatDownloadTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTag",
			new String[] { Long.class.getName() },
			StatDownloadTagModelImpl.TAGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAG = new FinderPath(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTag",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the stat download tags where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the matching stat download tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadTag> findByTag(long tagId)
		throws SystemException {
		return findByTag(tagId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat download tags where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of stat download tags
	 * @param end the upper bound of the range of stat download tags (not inclusive)
	 * @return the range of matching stat download tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadTag> findByTag(long tagId, int start, int end)
		throws SystemException {
		return findByTag(tagId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat download tags where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of stat download tags
	 * @param end the upper bound of the range of stat download tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stat download tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadTag> findByTag(long tagId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG;
			finderArgs = new Object[] { tagId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAG;
			finderArgs = new Object[] { tagId, start, end, orderByComparator };
		}

		List<StatDownloadTag> list = (List<StatDownloadTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StatDownloadTag statDownloadTag : list) {
				if ((tagId != statDownloadTag.getTagId())) {
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

			query.append(_SQL_SELECT_STATDOWNLOADTAG_WHERE);

			query.append(_FINDER_COLUMN_TAG_TAGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatDownloadTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tagId);

				if (!pagination) {
					list = (List<StatDownloadTag>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatDownloadTag>(list);
				}
				else {
					list = (List<StatDownloadTag>)QueryUtil.list(q,
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
	 * Returns the first stat download tag in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat download tag
	 * @throws com.idetronic.subur.NoSuchStatDownloadTagException if a matching stat download tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag findByTag_First(long tagId,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadTagException, SystemException {
		StatDownloadTag statDownloadTag = fetchByTag_First(tagId,
				orderByComparator);

		if (statDownloadTag != null) {
			return statDownloadTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagId=");
		msg.append(tagId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatDownloadTagException(msg.toString());
	}

	/**
	 * Returns the first stat download tag in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stat download tag, or <code>null</code> if a matching stat download tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag fetchByTag_First(long tagId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StatDownloadTag> list = findByTag(tagId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stat download tag in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat download tag
	 * @throws com.idetronic.subur.NoSuchStatDownloadTagException if a matching stat download tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag findByTag_Last(long tagId,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadTagException, SystemException {
		StatDownloadTag statDownloadTag = fetchByTag_Last(tagId,
				orderByComparator);

		if (statDownloadTag != null) {
			return statDownloadTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagId=");
		msg.append(tagId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatDownloadTagException(msg.toString());
	}

	/**
	 * Returns the last stat download tag in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stat download tag, or <code>null</code> if a matching stat download tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag fetchByTag_Last(long tagId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTag(tagId);

		if (count == 0) {
			return null;
		}

		List<StatDownloadTag> list = findByTag(tagId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stat download tags before and after the current stat download tag in the ordered set where tagId = &#63;.
	 *
	 * @param id the primary key of the current stat download tag
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stat download tag
	 * @throws com.idetronic.subur.NoSuchStatDownloadTagException if a stat download tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag[] findByTag_PrevAndNext(long id, long tagId,
		OrderByComparator orderByComparator)
		throws NoSuchStatDownloadTagException, SystemException {
		StatDownloadTag statDownloadTag = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatDownloadTag[] array = new StatDownloadTagImpl[3];

			array[0] = getByTag_PrevAndNext(session, statDownloadTag, tagId,
					orderByComparator, true);

			array[1] = statDownloadTag;

			array[2] = getByTag_PrevAndNext(session, statDownloadTag, tagId,
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

	protected StatDownloadTag getByTag_PrevAndNext(Session session,
		StatDownloadTag statDownloadTag, long tagId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATDOWNLOADTAG_WHERE);

		query.append(_FINDER_COLUMN_TAG_TAGID_2);

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
			query.append(StatDownloadTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tagId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statDownloadTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatDownloadTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stat download tags where tagId = &#63; from the database.
	 *
	 * @param tagId the tag ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTag(long tagId) throws SystemException {
		for (StatDownloadTag statDownloadTag : findByTag(tagId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statDownloadTag);
		}
	}

	/**
	 * Returns the number of stat download tags where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the number of matching stat download tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTag(long tagId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAG;

		Object[] finderArgs = new Object[] { tagId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATDOWNLOADTAG_WHERE);

			query.append(_FINDER_COLUMN_TAG_TAGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tagId);

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

	private static final String _FINDER_COLUMN_TAG_TAGID_2 = "statDownloadTag.tagId = ?";

	public StatDownloadTagPersistenceImpl() {
		setModelClass(StatDownloadTag.class);
	}

	/**
	 * Caches the stat download tag in the entity cache if it is enabled.
	 *
	 * @param statDownloadTag the stat download tag
	 */
	@Override
	public void cacheResult(StatDownloadTag statDownloadTag) {
		EntityCacheUtil.putResult(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagImpl.class, statDownloadTag.getPrimaryKey(),
			statDownloadTag);

		statDownloadTag.resetOriginalValues();
	}

	/**
	 * Caches the stat download tags in the entity cache if it is enabled.
	 *
	 * @param statDownloadTags the stat download tags
	 */
	@Override
	public void cacheResult(List<StatDownloadTag> statDownloadTags) {
		for (StatDownloadTag statDownloadTag : statDownloadTags) {
			if (EntityCacheUtil.getResult(
						StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
						StatDownloadTagImpl.class,
						statDownloadTag.getPrimaryKey()) == null) {
				cacheResult(statDownloadTag);
			}
			else {
				statDownloadTag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stat download tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatDownloadTagImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatDownloadTagImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stat download tag.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatDownloadTag statDownloadTag) {
		EntityCacheUtil.removeResult(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagImpl.class, statDownloadTag.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatDownloadTag> statDownloadTags) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatDownloadTag statDownloadTag : statDownloadTags) {
			EntityCacheUtil.removeResult(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
				StatDownloadTagImpl.class, statDownloadTag.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stat download tag with the primary key. Does not add the stat download tag to the database.
	 *
	 * @param id the primary key for the new stat download tag
	 * @return the new stat download tag
	 */
	@Override
	public StatDownloadTag create(long id) {
		StatDownloadTag statDownloadTag = new StatDownloadTagImpl();

		statDownloadTag.setNew(true);
		statDownloadTag.setPrimaryKey(id);

		return statDownloadTag;
	}

	/**
	 * Removes the stat download tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stat download tag
	 * @return the stat download tag that was removed
	 * @throws com.idetronic.subur.NoSuchStatDownloadTagException if a stat download tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag remove(long id)
		throws NoSuchStatDownloadTagException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stat download tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stat download tag
	 * @return the stat download tag that was removed
	 * @throws com.idetronic.subur.NoSuchStatDownloadTagException if a stat download tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag remove(Serializable primaryKey)
		throws NoSuchStatDownloadTagException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatDownloadTag statDownloadTag = (StatDownloadTag)session.get(StatDownloadTagImpl.class,
					primaryKey);

			if (statDownloadTag == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatDownloadTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statDownloadTag);
		}
		catch (NoSuchStatDownloadTagException nsee) {
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
	protected StatDownloadTag removeImpl(StatDownloadTag statDownloadTag)
		throws SystemException {
		statDownloadTag = toUnwrappedModel(statDownloadTag);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statDownloadTag)) {
				statDownloadTag = (StatDownloadTag)session.get(StatDownloadTagImpl.class,
						statDownloadTag.getPrimaryKeyObj());
			}

			if (statDownloadTag != null) {
				session.delete(statDownloadTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statDownloadTag != null) {
			clearCache(statDownloadTag);
		}

		return statDownloadTag;
	}

	@Override
	public StatDownloadTag updateImpl(
		com.idetronic.subur.model.StatDownloadTag statDownloadTag)
		throws SystemException {
		statDownloadTag = toUnwrappedModel(statDownloadTag);

		boolean isNew = statDownloadTag.isNew();

		StatDownloadTagModelImpl statDownloadTagModelImpl = (StatDownloadTagModelImpl)statDownloadTag;

		Session session = null;

		try {
			session = openSession();

			if (statDownloadTag.isNew()) {
				session.save(statDownloadTag);

				statDownloadTag.setNew(false);
			}
			else {
				session.merge(statDownloadTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatDownloadTagModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statDownloadTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statDownloadTagModelImpl.getOriginalTagId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG,
					args);

				args = new Object[] { statDownloadTagModelImpl.getTagId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG,
					args);
			}
		}

		EntityCacheUtil.putResult(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
			StatDownloadTagImpl.class, statDownloadTag.getPrimaryKey(),
			statDownloadTag);

		return statDownloadTag;
	}

	protected StatDownloadTag toUnwrappedModel(StatDownloadTag statDownloadTag) {
		if (statDownloadTag instanceof StatDownloadTagImpl) {
			return statDownloadTag;
		}

		StatDownloadTagImpl statDownloadTagImpl = new StatDownloadTagImpl();

		statDownloadTagImpl.setNew(statDownloadTag.isNew());
		statDownloadTagImpl.setPrimaryKey(statDownloadTag.getPrimaryKey());

		statDownloadTagImpl.setId(statDownloadTag.getId());
		statDownloadTagImpl.setPerMonth(statDownloadTag.getPerMonth());
		statDownloadTagImpl.setPerYear(statDownloadTag.getPerYear());
		statDownloadTagImpl.setTagId(statDownloadTag.getTagId());

		return statDownloadTagImpl;
	}

	/**
	 * Returns the stat download tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat download tag
	 * @return the stat download tag
	 * @throws com.idetronic.subur.NoSuchStatDownloadTagException if a stat download tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatDownloadTagException, SystemException {
		StatDownloadTag statDownloadTag = fetchByPrimaryKey(primaryKey);

		if (statDownloadTag == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatDownloadTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statDownloadTag;
	}

	/**
	 * Returns the stat download tag with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadTagException} if it could not be found.
	 *
	 * @param id the primary key of the stat download tag
	 * @return the stat download tag
	 * @throws com.idetronic.subur.NoSuchStatDownloadTagException if a stat download tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag findByPrimaryKey(long id)
		throws NoSuchStatDownloadTagException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stat download tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat download tag
	 * @return the stat download tag, or <code>null</code> if a stat download tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StatDownloadTag statDownloadTag = (StatDownloadTag)EntityCacheUtil.getResult(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
				StatDownloadTagImpl.class, primaryKey);

		if (statDownloadTag == _nullStatDownloadTag) {
			return null;
		}

		if (statDownloadTag == null) {
			Session session = null;

			try {
				session = openSession();

				statDownloadTag = (StatDownloadTag)session.get(StatDownloadTagImpl.class,
						primaryKey);

				if (statDownloadTag != null) {
					cacheResult(statDownloadTag);
				}
				else {
					EntityCacheUtil.putResult(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
						StatDownloadTagImpl.class, primaryKey,
						_nullStatDownloadTag);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatDownloadTagModelImpl.ENTITY_CACHE_ENABLED,
					StatDownloadTagImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statDownloadTag;
	}

	/**
	 * Returns the stat download tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stat download tag
	 * @return the stat download tag, or <code>null</code> if a stat download tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatDownloadTag fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the stat download tags.
	 *
	 * @return the stat download tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadTag> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat download tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat download tags
	 * @param end the upper bound of the range of stat download tags (not inclusive)
	 * @return the range of stat download tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadTag> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat download tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat download tags
	 * @param end the upper bound of the range of stat download tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stat download tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatDownloadTag> findAll(int start, int end,
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

		List<StatDownloadTag> list = (List<StatDownloadTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATDOWNLOADTAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATDOWNLOADTAG;

				if (pagination) {
					sql = sql.concat(StatDownloadTagModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatDownloadTag>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatDownloadTag>(list);
				}
				else {
					list = (List<StatDownloadTag>)QueryUtil.list(q,
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
	 * Removes all the stat download tags from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StatDownloadTag statDownloadTag : findAll()) {
			remove(statDownloadTag);
		}
	}

	/**
	 * Returns the number of stat download tags.
	 *
	 * @return the number of stat download tags
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

				Query q = session.createQuery(_SQL_COUNT_STATDOWNLOADTAG);

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
	 * Initializes the stat download tag persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.StatDownloadTag")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatDownloadTag>> listenersList = new ArrayList<ModelListener<StatDownloadTag>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatDownloadTag>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatDownloadTagImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATDOWNLOADTAG = "SELECT statDownloadTag FROM StatDownloadTag statDownloadTag";
	private static final String _SQL_SELECT_STATDOWNLOADTAG_WHERE = "SELECT statDownloadTag FROM StatDownloadTag statDownloadTag WHERE ";
	private static final String _SQL_COUNT_STATDOWNLOADTAG = "SELECT COUNT(statDownloadTag) FROM StatDownloadTag statDownloadTag";
	private static final String _SQL_COUNT_STATDOWNLOADTAG_WHERE = "SELECT COUNT(statDownloadTag) FROM StatDownloadTag statDownloadTag WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statDownloadTag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatDownloadTag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatDownloadTag exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatDownloadTagPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static StatDownloadTag _nullStatDownloadTag = new StatDownloadTagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatDownloadTag> toCacheModel() {
				return _nullStatDownloadTagCacheModel;
			}
		};

	private static CacheModel<StatDownloadTag> _nullStatDownloadTagCacheModel = new CacheModel<StatDownloadTag>() {
			@Override
			public StatDownloadTag toEntityModel() {
				return _nullStatDownloadTag;
			}
		};
}