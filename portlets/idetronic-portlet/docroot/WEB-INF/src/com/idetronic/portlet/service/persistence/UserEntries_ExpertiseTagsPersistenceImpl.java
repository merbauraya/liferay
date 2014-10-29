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

package com.idetronic.portlet.service.persistence;

import com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException;
import com.idetronic.portlet.model.UserEntries_ExpertiseTags;
import com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsImpl;
import com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl;

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
 * The persistence implementation for the user entries_ expertise tags service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserEntries_ExpertiseTagsPersistence
 * @see UserEntries_ExpertiseTagsUtil
 * @generated
 */
public class UserEntries_ExpertiseTagsPersistenceImpl
	extends BasePersistenceImpl<UserEntries_ExpertiseTags>
	implements UserEntries_ExpertiseTagsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserEntries_ExpertiseTagsUtil} to access the user entries_ expertise tags persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserEntries_ExpertiseTagsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			UserEntries_ExpertiseTagsModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserId", new String[] { Long.class.getName() });

	/**
	 * Returns all the user entries_ expertise tagses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findByuserId(long userId)
		throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user entries_ expertise tagses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user entries_ expertise tagses
	 * @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	 * @return the range of matching user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findByuserId(long userId, int start,
		int end) throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user entries_ expertise tagses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user entries_ expertise tagses
	 * @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findByuserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<UserEntries_ExpertiseTags> list = (List<UserEntries_ExpertiseTags>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserEntries_ExpertiseTags userEntries_ExpertiseTags : list) {
				if ((userId != userEntries_ExpertiseTags.getUserId())) {
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

			query.append(_SQL_SELECT_USERENTRIES_EXPERTISETAGS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserEntries_ExpertiseTagsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserEntries_ExpertiseTags>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserEntries_ExpertiseTags>(list);
				}
				else {
					list = (List<UserEntries_ExpertiseTags>)QueryUtil.list(q,
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
	 * Returns the first user entries_ expertise tags in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entries_ expertise tags
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a matching user entries_ expertise tags could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = fetchByuserId_First(userId,
				orderByComparator);

		if (userEntries_ExpertiseTags != null) {
			return userEntries_ExpertiseTags;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserEntries_ExpertiseTagsException(msg.toString());
	}

	/**
	 * Returns the first user entries_ expertise tags in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entries_ expertise tags, or <code>null</code> if a matching user entries_ expertise tags could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserEntries_ExpertiseTags> list = findByuserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user entries_ expertise tags in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entries_ expertise tags
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a matching user entries_ expertise tags could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = fetchByuserId_Last(userId,
				orderByComparator);

		if (userEntries_ExpertiseTags != null) {
			return userEntries_ExpertiseTags;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserEntries_ExpertiseTagsException(msg.toString());
	}

	/**
	 * Returns the last user entries_ expertise tags in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entries_ expertise tags, or <code>null</code> if a matching user entries_ expertise tags could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserEntries_ExpertiseTags> list = findByuserId(userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user entries_ expertise tagses before and after the current user entries_ expertise tags in the ordered set where userId = &#63;.
	 *
	 * @param userEntries_ExpertiseTagsPK the primary key of the current user entries_ expertise tags
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user entries_ expertise tags
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags[] findByuserId_PrevAndNext(
		UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = findByPrimaryKey(userEntries_ExpertiseTagsPK);

		Session session = null;

		try {
			session = openSession();

			UserEntries_ExpertiseTags[] array = new UserEntries_ExpertiseTagsImpl[3];

			array[0] = getByuserId_PrevAndNext(session,
					userEntries_ExpertiseTags, userId, orderByComparator, true);

			array[1] = userEntries_ExpertiseTags;

			array[2] = getByuserId_PrevAndNext(session,
					userEntries_ExpertiseTags, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEntries_ExpertiseTags getByuserId_PrevAndNext(
		Session session, UserEntries_ExpertiseTags userEntries_ExpertiseTags,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERENTRIES_EXPERTISETAGS_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(UserEntries_ExpertiseTagsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userEntries_ExpertiseTags);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserEntries_ExpertiseTags> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user entries_ expertise tagses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (UserEntries_ExpertiseTags userEntries_ExpertiseTags : findByuserId(
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userEntries_ExpertiseTags);
		}
	}

	/**
	 * Returns the number of user entries_ expertise tagses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENTRIES_EXPERTISETAGS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userEntries_ExpertiseTags.id.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGID = new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytagId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID = new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytagId",
			new String[] { Long.class.getName() },
			UserEntries_ExpertiseTagsModelImpl.TAGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAGID = new FinderPath(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBytagId", new String[] { Long.class.getName() });

	/**
	 * Returns all the user entries_ expertise tagses where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the matching user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findBytagId(long tagId)
		throws SystemException {
		return findBytagId(tagId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user entries_ expertise tagses where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of user entries_ expertise tagses
	 * @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	 * @return the range of matching user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findBytagId(long tagId, int start,
		int end) throws SystemException {
		return findBytagId(tagId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user entries_ expertise tagses where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of user entries_ expertise tagses
	 * @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findBytagId(long tagId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID;
			finderArgs = new Object[] { tagId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGID;
			finderArgs = new Object[] { tagId, start, end, orderByComparator };
		}

		List<UserEntries_ExpertiseTags> list = (List<UserEntries_ExpertiseTags>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserEntries_ExpertiseTags userEntries_ExpertiseTags : list) {
				if ((tagId != userEntries_ExpertiseTags.getTagId())) {
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

			query.append(_SQL_SELECT_USERENTRIES_EXPERTISETAGS_WHERE);

			query.append(_FINDER_COLUMN_TAGID_TAGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserEntries_ExpertiseTagsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tagId);

				if (!pagination) {
					list = (List<UserEntries_ExpertiseTags>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserEntries_ExpertiseTags>(list);
				}
				else {
					list = (List<UserEntries_ExpertiseTags>)QueryUtil.list(q,
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
	 * Returns the first user entries_ expertise tags in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entries_ expertise tags
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a matching user entries_ expertise tags could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags findBytagId_First(long tagId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = fetchBytagId_First(tagId,
				orderByComparator);

		if (userEntries_ExpertiseTags != null) {
			return userEntries_ExpertiseTags;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagId=");
		msg.append(tagId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserEntries_ExpertiseTagsException(msg.toString());
	}

	/**
	 * Returns the first user entries_ expertise tags in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entries_ expertise tags, or <code>null</code> if a matching user entries_ expertise tags could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags fetchBytagId_First(long tagId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserEntries_ExpertiseTags> list = findBytagId(tagId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user entries_ expertise tags in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entries_ expertise tags
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a matching user entries_ expertise tags could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags findBytagId_Last(long tagId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = fetchBytagId_Last(tagId,
				orderByComparator);

		if (userEntries_ExpertiseTags != null) {
			return userEntries_ExpertiseTags;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagId=");
		msg.append(tagId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserEntries_ExpertiseTagsException(msg.toString());
	}

	/**
	 * Returns the last user entries_ expertise tags in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entries_ expertise tags, or <code>null</code> if a matching user entries_ expertise tags could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags fetchBytagId_Last(long tagId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytagId(tagId);

		if (count == 0) {
			return null;
		}

		List<UserEntries_ExpertiseTags> list = findBytagId(tagId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user entries_ expertise tagses before and after the current user entries_ expertise tags in the ordered set where tagId = &#63;.
	 *
	 * @param userEntries_ExpertiseTagsPK the primary key of the current user entries_ expertise tags
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user entries_ expertise tags
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags[] findBytagId_PrevAndNext(
		UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK, long tagId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = findByPrimaryKey(userEntries_ExpertiseTagsPK);

		Session session = null;

		try {
			session = openSession();

			UserEntries_ExpertiseTags[] array = new UserEntries_ExpertiseTagsImpl[3];

			array[0] = getBytagId_PrevAndNext(session,
					userEntries_ExpertiseTags, tagId, orderByComparator, true);

			array[1] = userEntries_ExpertiseTags;

			array[2] = getBytagId_PrevAndNext(session,
					userEntries_ExpertiseTags, tagId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEntries_ExpertiseTags getBytagId_PrevAndNext(
		Session session, UserEntries_ExpertiseTags userEntries_ExpertiseTags,
		long tagId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERENTRIES_EXPERTISETAGS_WHERE);

		query.append(_FINDER_COLUMN_TAGID_TAGID_2);

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
			query.append(UserEntries_ExpertiseTagsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tagId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userEntries_ExpertiseTags);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserEntries_ExpertiseTags> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user entries_ expertise tagses where tagId = &#63; from the database.
	 *
	 * @param tagId the tag ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytagId(long tagId) throws SystemException {
		for (UserEntries_ExpertiseTags userEntries_ExpertiseTags : findBytagId(
				tagId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userEntries_ExpertiseTags);
		}
	}

	/**
	 * Returns the number of user entries_ expertise tagses where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the number of matching user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBytagId(long tagId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAGID;

		Object[] finderArgs = new Object[] { tagId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENTRIES_EXPERTISETAGS_WHERE);

			query.append(_FINDER_COLUMN_TAGID_TAGID_2);

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

	private static final String _FINDER_COLUMN_TAGID_TAGID_2 = "userEntries_ExpertiseTags.id.tagId = ?";

	public UserEntries_ExpertiseTagsPersistenceImpl() {
		setModelClass(UserEntries_ExpertiseTags.class);
	}

	/**
	 * Caches the user entries_ expertise tags in the entity cache if it is enabled.
	 *
	 * @param userEntries_ExpertiseTags the user entries_ expertise tags
	 */
	@Override
	public void cacheResult(UserEntries_ExpertiseTags userEntries_ExpertiseTags) {
		EntityCacheUtil.putResult(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			userEntries_ExpertiseTags.getPrimaryKey(), userEntries_ExpertiseTags);

		userEntries_ExpertiseTags.resetOriginalValues();
	}

	/**
	 * Caches the user entries_ expertise tagses in the entity cache if it is enabled.
	 *
	 * @param userEntries_ExpertiseTagses the user entries_ expertise tagses
	 */
	@Override
	public void cacheResult(
		List<UserEntries_ExpertiseTags> userEntries_ExpertiseTagses) {
		for (UserEntries_ExpertiseTags userEntries_ExpertiseTags : userEntries_ExpertiseTagses) {
			if (EntityCacheUtil.getResult(
						UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
						UserEntries_ExpertiseTagsImpl.class,
						userEntries_ExpertiseTags.getPrimaryKey()) == null) {
				cacheResult(userEntries_ExpertiseTags);
			}
			else {
				userEntries_ExpertiseTags.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user entries_ expertise tagses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserEntries_ExpertiseTagsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserEntries_ExpertiseTagsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user entries_ expertise tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserEntries_ExpertiseTags userEntries_ExpertiseTags) {
		EntityCacheUtil.removeResult(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			userEntries_ExpertiseTags.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<UserEntries_ExpertiseTags> userEntries_ExpertiseTagses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserEntries_ExpertiseTags userEntries_ExpertiseTags : userEntries_ExpertiseTagses) {
			EntityCacheUtil.removeResult(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
				UserEntries_ExpertiseTagsImpl.class,
				userEntries_ExpertiseTags.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user entries_ expertise tags with the primary key. Does not add the user entries_ expertise tags to the database.
	 *
	 * @param userEntries_ExpertiseTagsPK the primary key for the new user entries_ expertise tags
	 * @return the new user entries_ expertise tags
	 */
	@Override
	public UserEntries_ExpertiseTags create(
		UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK) {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = new UserEntries_ExpertiseTagsImpl();

		userEntries_ExpertiseTags.setNew(true);
		userEntries_ExpertiseTags.setPrimaryKey(userEntries_ExpertiseTagsPK);

		return userEntries_ExpertiseTags;
	}

	/**
	 * Removes the user entries_ expertise tags with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	 * @return the user entries_ expertise tags that was removed
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags remove(
		UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		return remove((Serializable)userEntries_ExpertiseTagsPK);
	}

	/**
	 * Removes the user entries_ expertise tags with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user entries_ expertise tags
	 * @return the user entries_ expertise tags that was removed
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags remove(Serializable primaryKey)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserEntries_ExpertiseTags userEntries_ExpertiseTags = (UserEntries_ExpertiseTags)session.get(UserEntries_ExpertiseTagsImpl.class,
					primaryKey);

			if (userEntries_ExpertiseTags == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserEntries_ExpertiseTagsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userEntries_ExpertiseTags);
		}
		catch (NoSuchUserEntries_ExpertiseTagsException nsee) {
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
	protected UserEntries_ExpertiseTags removeImpl(
		UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws SystemException {
		userEntries_ExpertiseTags = toUnwrappedModel(userEntries_ExpertiseTags);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userEntries_ExpertiseTags)) {
				userEntries_ExpertiseTags = (UserEntries_ExpertiseTags)session.get(UserEntries_ExpertiseTagsImpl.class,
						userEntries_ExpertiseTags.getPrimaryKeyObj());
			}

			if (userEntries_ExpertiseTags != null) {
				session.delete(userEntries_ExpertiseTags);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userEntries_ExpertiseTags != null) {
			clearCache(userEntries_ExpertiseTags);
		}

		return userEntries_ExpertiseTags;
	}

	@Override
	public UserEntries_ExpertiseTags updateImpl(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws SystemException {
		userEntries_ExpertiseTags = toUnwrappedModel(userEntries_ExpertiseTags);

		boolean isNew = userEntries_ExpertiseTags.isNew();

		UserEntries_ExpertiseTagsModelImpl userEntries_ExpertiseTagsModelImpl = (UserEntries_ExpertiseTagsModelImpl)userEntries_ExpertiseTags;

		Session session = null;

		try {
			session = openSession();

			if (userEntries_ExpertiseTags.isNew()) {
				session.save(userEntries_ExpertiseTags);

				userEntries_ExpertiseTags.setNew(false);
			}
			else {
				session.merge(userEntries_ExpertiseTags);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!UserEntries_ExpertiseTagsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userEntries_ExpertiseTagsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userEntries_ExpertiseTagsModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						userEntries_ExpertiseTagsModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((userEntries_ExpertiseTagsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userEntries_ExpertiseTagsModelImpl.getOriginalTagId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID,
					args);

				args = new Object[] {
						userEntries_ExpertiseTagsModelImpl.getTagId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID,
					args);
			}
		}

		EntityCacheUtil.putResult(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
			UserEntries_ExpertiseTagsImpl.class,
			userEntries_ExpertiseTags.getPrimaryKey(), userEntries_ExpertiseTags);

		return userEntries_ExpertiseTags;
	}

	protected UserEntries_ExpertiseTags toUnwrappedModel(
		UserEntries_ExpertiseTags userEntries_ExpertiseTags) {
		if (userEntries_ExpertiseTags instanceof UserEntries_ExpertiseTagsImpl) {
			return userEntries_ExpertiseTags;
		}

		UserEntries_ExpertiseTagsImpl userEntries_ExpertiseTagsImpl = new UserEntries_ExpertiseTagsImpl();

		userEntries_ExpertiseTagsImpl.setNew(userEntries_ExpertiseTags.isNew());
		userEntries_ExpertiseTagsImpl.setPrimaryKey(userEntries_ExpertiseTags.getPrimaryKey());

		userEntries_ExpertiseTagsImpl.setUserId(userEntries_ExpertiseTags.getUserId());
		userEntries_ExpertiseTagsImpl.setTagId(userEntries_ExpertiseTags.getTagId());

		return userEntries_ExpertiseTagsImpl;
	}

	/**
	 * Returns the user entries_ expertise tags with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user entries_ expertise tags
	 * @return the user entries_ expertise tags
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = fetchByPrimaryKey(primaryKey);

		if (userEntries_ExpertiseTags == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserEntries_ExpertiseTagsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userEntries_ExpertiseTags;
	}

	/**
	 * Returns the user entries_ expertise tags with the primary key or throws a {@link com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException} if it could not be found.
	 *
	 * @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	 * @return the user entries_ expertise tags
	 * @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags findByPrimaryKey(
		UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws NoSuchUserEntries_ExpertiseTagsException, SystemException {
		return findByPrimaryKey((Serializable)userEntries_ExpertiseTagsPK);
	}

	/**
	 * Returns the user entries_ expertise tags with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user entries_ expertise tags
	 * @return the user entries_ expertise tags, or <code>null</code> if a user entries_ expertise tags with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserEntries_ExpertiseTags userEntries_ExpertiseTags = (UserEntries_ExpertiseTags)EntityCacheUtil.getResult(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
				UserEntries_ExpertiseTagsImpl.class, primaryKey);

		if (userEntries_ExpertiseTags == _nullUserEntries_ExpertiseTags) {
			return null;
		}

		if (userEntries_ExpertiseTags == null) {
			Session session = null;

			try {
				session = openSession();

				userEntries_ExpertiseTags = (UserEntries_ExpertiseTags)session.get(UserEntries_ExpertiseTagsImpl.class,
						primaryKey);

				if (userEntries_ExpertiseTags != null) {
					cacheResult(userEntries_ExpertiseTags);
				}
				else {
					EntityCacheUtil.putResult(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
						UserEntries_ExpertiseTagsImpl.class, primaryKey,
						_nullUserEntries_ExpertiseTags);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserEntries_ExpertiseTagsModelImpl.ENTITY_CACHE_ENABLED,
					UserEntries_ExpertiseTagsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userEntries_ExpertiseTags;
	}

	/**
	 * Returns the user entries_ expertise tags with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	 * @return the user entries_ expertise tags, or <code>null</code> if a user entries_ expertise tags with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntries_ExpertiseTags fetchByPrimaryKey(
		UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userEntries_ExpertiseTagsPK);
	}

	/**
	 * Returns all the user entries_ expertise tagses.
	 *
	 * @return the user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user entries_ expertise tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user entries_ expertise tagses
	 * @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	 * @return the range of user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user entries_ expertise tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user entries_ expertise tagses
	 * @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user entries_ expertise tagses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEntries_ExpertiseTags> findAll(int start, int end,
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

		List<UserEntries_ExpertiseTags> list = (List<UserEntries_ExpertiseTags>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERENTRIES_EXPERTISETAGS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERENTRIES_EXPERTISETAGS;

				if (pagination) {
					sql = sql.concat(UserEntries_ExpertiseTagsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserEntries_ExpertiseTags>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserEntries_ExpertiseTags>(list);
				}
				else {
					list = (List<UserEntries_ExpertiseTags>)QueryUtil.list(q,
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
	 * Removes all the user entries_ expertise tagses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserEntries_ExpertiseTags userEntries_ExpertiseTags : findAll()) {
			remove(userEntries_ExpertiseTags);
		}
	}

	/**
	 * Returns the number of user entries_ expertise tagses.
	 *
	 * @return the number of user entries_ expertise tagses
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

				Query q = session.createQuery(_SQL_COUNT_USERENTRIES_EXPERTISETAGS);

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
	 * Initializes the user entries_ expertise tags persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.portlet.model.UserEntries_ExpertiseTags")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserEntries_ExpertiseTags>> listenersList = new ArrayList<ModelListener<UserEntries_ExpertiseTags>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserEntries_ExpertiseTags>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserEntries_ExpertiseTagsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERENTRIES_EXPERTISETAGS = "SELECT userEntries_ExpertiseTags FROM UserEntries_ExpertiseTags userEntries_ExpertiseTags";
	private static final String _SQL_SELECT_USERENTRIES_EXPERTISETAGS_WHERE = "SELECT userEntries_ExpertiseTags FROM UserEntries_ExpertiseTags userEntries_ExpertiseTags WHERE ";
	private static final String _SQL_COUNT_USERENTRIES_EXPERTISETAGS = "SELECT COUNT(userEntries_ExpertiseTags) FROM UserEntries_ExpertiseTags userEntries_ExpertiseTags";
	private static final String _SQL_COUNT_USERENTRIES_EXPERTISETAGS_WHERE = "SELECT COUNT(userEntries_ExpertiseTags) FROM UserEntries_ExpertiseTags userEntries_ExpertiseTags WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userEntries_ExpertiseTags.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserEntries_ExpertiseTags exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserEntries_ExpertiseTags exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserEntries_ExpertiseTagsPersistenceImpl.class);
	private static UserEntries_ExpertiseTags _nullUserEntries_ExpertiseTags = new UserEntries_ExpertiseTagsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserEntries_ExpertiseTags> toCacheModel() {
				return _nullUserEntries_ExpertiseTagsCacheModel;
			}
		};

	private static CacheModel<UserEntries_ExpertiseTags> _nullUserEntries_ExpertiseTagsCacheModel =
		new CacheModel<UserEntries_ExpertiseTags>() {
			@Override
			public UserEntries_ExpertiseTags toEntityModel() {
				return _nullUserEntries_ExpertiseTags;
			}
		};
}