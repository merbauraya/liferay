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

import com.idetronic.subur.NoSuchExpertiseException;
import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.model.impl.ExpertiseImpl;
import com.idetronic.subur.model.impl.ExpertiseModelImpl;

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
 * The persistence implementation for the expertise service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ExpertisePersistence
 * @see ExpertiseUtil
 * @generated
 */
public class ExpertisePersistenceImpl extends BasePersistenceImpl<Expertise>
	implements ExpertisePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpertiseUtil} to access the expertise persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpertiseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseModelImpl.FINDER_CACHE_ENABLED, ExpertiseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseModelImpl.FINDER_CACHE_ENABLED, ExpertiseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseModelImpl.FINDER_CACHE_ENABLED, ExpertiseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseModelImpl.FINDER_CACHE_ENABLED, ExpertiseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ExpertiseModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the expertises where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expertise> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expertises where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expertises
	 * @param end the upper bound of the range of expertises (not inclusive)
	 * @return the range of matching expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expertise> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expertises where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expertises
	 * @param end the upper bound of the range of expertises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expertise> findByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Expertise> list = (List<Expertise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Expertise expertise : list) {
				if ((groupId != expertise.getGroupId())) {
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

			query.append(_SQL_SELECT_EXPERTISE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExpertiseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Expertise>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Expertise>(list);
				}
				else {
					list = (List<Expertise>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first expertise in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expertise
	 * @throws com.idetronic.subur.NoSuchExpertiseException if a matching expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchExpertiseException, SystemException {
		Expertise expertise = fetchByGroup_First(groupId, orderByComparator);

		if (expertise != null) {
			return expertise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExpertiseException(msg.toString());
	}

	/**
	 * Returns the first expertise in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expertise, or <code>null</code> if a matching expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Expertise> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expertise in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expertise
	 * @throws com.idetronic.subur.NoSuchExpertiseException if a matching expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchExpertiseException, SystemException {
		Expertise expertise = fetchByGroup_Last(groupId, orderByComparator);

		if (expertise != null) {
			return expertise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExpertiseException(msg.toString());
	}

	/**
	 * Returns the last expertise in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expertise, or <code>null</code> if a matching expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Expertise> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expertises before and after the current expertise in the ordered set where groupId = &#63;.
	 *
	 * @param expertiseId the primary key of the current expertise
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expertise
	 * @throws com.idetronic.subur.NoSuchExpertiseException if a expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise[] findByGroup_PrevAndNext(long expertiseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchExpertiseException, SystemException {
		Expertise expertise = findByPrimaryKey(expertiseId);

		Session session = null;

		try {
			session = openSession();

			Expertise[] array = new ExpertiseImpl[3];

			array[0] = getByGroup_PrevAndNext(session, expertise, groupId,
					orderByComparator, true);

			array[1] = expertise;

			array[2] = getByGroup_PrevAndNext(session, expertise, groupId,
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

	protected Expertise getByGroup_PrevAndNext(Session session,
		Expertise expertise, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPERTISE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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
			query.append(ExpertiseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(expertise);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Expertise> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expertises where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (Expertise expertise : findByGroup(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(expertise);
		}
	}

	/**
	 * Returns the number of expertises where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroup(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXPERTISE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "expertise.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPNAME = new FinderPath(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseModelImpl.FINDER_CACHE_ENABLED, ExpertiseImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupName",
			new String[] { Long.class.getName(), String.class.getName() },
			ExpertiseModelImpl.GROUPID_COLUMN_BITMASK |
			ExpertiseModelImpl.INDEXEDNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPNAME = new FinderPath(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the expertise where groupId = &#63; and indexedName = &#63; or throws a {@link com.idetronic.subur.NoSuchExpertiseException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @return the matching expertise
	 * @throws com.idetronic.subur.NoSuchExpertiseException if a matching expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise findByGroupName(long groupId, String indexedName)
		throws NoSuchExpertiseException, SystemException {
		Expertise expertise = fetchByGroupName(groupId, indexedName);

		if (expertise == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", indexedName=");
			msg.append(indexedName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchExpertiseException(msg.toString());
		}

		return expertise;
	}

	/**
	 * Returns the expertise where groupId = &#63; and indexedName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @return the matching expertise, or <code>null</code> if a matching expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise fetchByGroupName(long groupId, String indexedName)
		throws SystemException {
		return fetchByGroupName(groupId, indexedName, true);
	}

	/**
	 * Returns the expertise where groupId = &#63; and indexedName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching expertise, or <code>null</code> if a matching expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise fetchByGroupName(long groupId, String indexedName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, indexedName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPNAME,
					finderArgs, this);
		}

		if (result instanceof Expertise) {
			Expertise expertise = (Expertise)result;

			if ((groupId != expertise.getGroupId()) ||
					!Validator.equals(indexedName, expertise.getIndexedName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EXPERTISE_WHERE);

			query.append(_FINDER_COLUMN_GROUPNAME_GROUPID_2);

			boolean bindIndexedName = false;

			if (indexedName == null) {
				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_1);
			}
			else if (indexedName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_3);
			}
			else {
				bindIndexedName = true;

				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindIndexedName) {
					qPos.add(indexedName);
				}

				List<Expertise> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME,
						finderArgs, list);
				}
				else {
					Expertise expertise = list.get(0);

					result = expertise;

					cacheResult(expertise);

					if ((expertise.getGroupId() != groupId) ||
							(expertise.getIndexedName() == null) ||
							!expertise.getIndexedName().equals(indexedName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME,
							finderArgs, expertise);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Expertise)result;
		}
	}

	/**
	 * Removes the expertise where groupId = &#63; and indexedName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @return the expertise that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise removeByGroupName(long groupId, String indexedName)
		throws NoSuchExpertiseException, SystemException {
		Expertise expertise = findByGroupName(groupId, indexedName);

		return remove(expertise);
	}

	/**
	 * Returns the number of expertises where groupId = &#63; and indexedName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @return the number of matching expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupName(long groupId, String indexedName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPNAME;

		Object[] finderArgs = new Object[] { groupId, indexedName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXPERTISE_WHERE);

			query.append(_FINDER_COLUMN_GROUPNAME_GROUPID_2);

			boolean bindIndexedName = false;

			if (indexedName == null) {
				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_1);
			}
			else if (indexedName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_3);
			}
			else {
				bindIndexedName = true;

				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindIndexedName) {
					qPos.add(indexedName);
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

	private static final String _FINDER_COLUMN_GROUPNAME_GROUPID_2 = "expertise.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPNAME_INDEXEDNAME_1 = "expertise.indexedName IS NULL";
	private static final String _FINDER_COLUMN_GROUPNAME_INDEXEDNAME_2 = "expertise.indexedName = ?";
	private static final String _FINDER_COLUMN_GROUPNAME_INDEXEDNAME_3 = "(expertise.indexedName IS NULL OR expertise.indexedName = '')";

	public ExpertisePersistenceImpl() {
		setModelClass(Expertise.class);
	}

	/**
	 * Caches the expertise in the entity cache if it is enabled.
	 *
	 * @param expertise the expertise
	 */
	@Override
	public void cacheResult(Expertise expertise) {
		EntityCacheUtil.putResult(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseImpl.class, expertise.getPrimaryKey(), expertise);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME,
			new Object[] { expertise.getGroupId(), expertise.getIndexedName() },
			expertise);

		expertise.resetOriginalValues();
	}

	/**
	 * Caches the expertises in the entity cache if it is enabled.
	 *
	 * @param expertises the expertises
	 */
	@Override
	public void cacheResult(List<Expertise> expertises) {
		for (Expertise expertise : expertises) {
			if (EntityCacheUtil.getResult(
						ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
						ExpertiseImpl.class, expertise.getPrimaryKey()) == null) {
				cacheResult(expertise);
			}
			else {
				expertise.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all expertises.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExpertiseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExpertiseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expertise.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Expertise expertise) {
		EntityCacheUtil.removeResult(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseImpl.class, expertise.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(expertise);
	}

	@Override
	public void clearCache(List<Expertise> expertises) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Expertise expertise : expertises) {
			EntityCacheUtil.removeResult(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
				ExpertiseImpl.class, expertise.getPrimaryKey());

			clearUniqueFindersCache(expertise);
		}
	}

	protected void cacheUniqueFindersCache(Expertise expertise) {
		if (expertise.isNew()) {
			Object[] args = new Object[] {
					expertise.getGroupId(), expertise.getIndexedName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME, args,
				expertise);
		}
		else {
			ExpertiseModelImpl expertiseModelImpl = (ExpertiseModelImpl)expertise;

			if ((expertiseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						expertise.getGroupId(), expertise.getIndexedName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPNAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME, args,
					expertise);
			}
		}
	}

	protected void clearUniqueFindersCache(Expertise expertise) {
		ExpertiseModelImpl expertiseModelImpl = (ExpertiseModelImpl)expertise;

		Object[] args = new Object[] {
				expertise.getGroupId(), expertise.getIndexedName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPNAME, args);

		if ((expertiseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					expertiseModelImpl.getOriginalGroupId(),
					expertiseModelImpl.getOriginalIndexedName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPNAME, args);
		}
	}

	/**
	 * Creates a new expertise with the primary key. Does not add the expertise to the database.
	 *
	 * @param expertiseId the primary key for the new expertise
	 * @return the new expertise
	 */
	@Override
	public Expertise create(long expertiseId) {
		Expertise expertise = new ExpertiseImpl();

		expertise.setNew(true);
		expertise.setPrimaryKey(expertiseId);

		return expertise;
	}

	/**
	 * Removes the expertise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expertiseId the primary key of the expertise
	 * @return the expertise that was removed
	 * @throws com.idetronic.subur.NoSuchExpertiseException if a expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise remove(long expertiseId)
		throws NoSuchExpertiseException, SystemException {
		return remove((Serializable)expertiseId);
	}

	/**
	 * Removes the expertise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expertise
	 * @return the expertise that was removed
	 * @throws com.idetronic.subur.NoSuchExpertiseException if a expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise remove(Serializable primaryKey)
		throws NoSuchExpertiseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Expertise expertise = (Expertise)session.get(ExpertiseImpl.class,
					primaryKey);

			if (expertise == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpertiseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expertise);
		}
		catch (NoSuchExpertiseException nsee) {
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
	protected Expertise removeImpl(Expertise expertise)
		throws SystemException {
		expertise = toUnwrappedModel(expertise);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expertise)) {
				expertise = (Expertise)session.get(ExpertiseImpl.class,
						expertise.getPrimaryKeyObj());
			}

			if (expertise != null) {
				session.delete(expertise);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expertise != null) {
			clearCache(expertise);
		}

		return expertise;
	}

	@Override
	public Expertise updateImpl(com.idetronic.subur.model.Expertise expertise)
		throws SystemException {
		expertise = toUnwrappedModel(expertise);

		boolean isNew = expertise.isNew();

		ExpertiseModelImpl expertiseModelImpl = (ExpertiseModelImpl)expertise;

		Session session = null;

		try {
			session = openSession();

			if (expertise.isNew()) {
				session.save(expertise);

				expertise.setNew(false);
			}
			else {
				session.merge(expertise);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExpertiseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((expertiseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						expertiseModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { expertiseModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseImpl.class, expertise.getPrimaryKey(), expertise);

		clearUniqueFindersCache(expertise);
		cacheUniqueFindersCache(expertise);

		return expertise;
	}

	protected Expertise toUnwrappedModel(Expertise expertise) {
		if (expertise instanceof ExpertiseImpl) {
			return expertise;
		}

		ExpertiseImpl expertiseImpl = new ExpertiseImpl();

		expertiseImpl.setNew(expertise.isNew());
		expertiseImpl.setPrimaryKey(expertise.getPrimaryKey());

		expertiseImpl.setExpertiseId(expertise.getExpertiseId());
		expertiseImpl.setGroupId(expertise.getGroupId());
		expertiseImpl.setCompanyId(expertise.getCompanyId());
		expertiseImpl.setUserId(expertise.getUserId());
		expertiseImpl.setCreateDate(expertise.getCreateDate());
		expertiseImpl.setExpertiseName(expertise.getExpertiseName());
		expertiseImpl.setIndexedName(expertise.getIndexedName());
		expertiseImpl.setModifiedDate(expertise.getModifiedDate());
		expertiseImpl.setAuthorCount(expertise.getAuthorCount());

		return expertiseImpl;
	}

	/**
	 * Returns the expertise with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the expertise
	 * @return the expertise
	 * @throws com.idetronic.subur.NoSuchExpertiseException if a expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpertiseException, SystemException {
		Expertise expertise = fetchByPrimaryKey(primaryKey);

		if (expertise == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpertiseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expertise;
	}

	/**
	 * Returns the expertise with the primary key or throws a {@link com.idetronic.subur.NoSuchExpertiseException} if it could not be found.
	 *
	 * @param expertiseId the primary key of the expertise
	 * @return the expertise
	 * @throws com.idetronic.subur.NoSuchExpertiseException if a expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise findByPrimaryKey(long expertiseId)
		throws NoSuchExpertiseException, SystemException {
		return findByPrimaryKey((Serializable)expertiseId);
	}

	/**
	 * Returns the expertise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expertise
	 * @return the expertise, or <code>null</code> if a expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Expertise expertise = (Expertise)EntityCacheUtil.getResult(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
				ExpertiseImpl.class, primaryKey);

		if (expertise == _nullExpertise) {
			return null;
		}

		if (expertise == null) {
			Session session = null;

			try {
				session = openSession();

				expertise = (Expertise)session.get(ExpertiseImpl.class,
						primaryKey);

				if (expertise != null) {
					cacheResult(expertise);
				}
				else {
					EntityCacheUtil.putResult(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
						ExpertiseImpl.class, primaryKey, _nullExpertise);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ExpertiseModelImpl.ENTITY_CACHE_ENABLED,
					ExpertiseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expertise;
	}

	/**
	 * Returns the expertise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expertiseId the primary key of the expertise
	 * @return the expertise, or <code>null</code> if a expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expertise fetchByPrimaryKey(long expertiseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)expertiseId);
	}

	/**
	 * Returns all the expertises.
	 *
	 * @return the expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expertise> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expertises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expertises
	 * @param end the upper bound of the range of expertises (not inclusive)
	 * @return the range of expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expertise> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the expertises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expertises
	 * @param end the upper bound of the range of expertises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expertise> findAll(int start, int end,
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

		List<Expertise> list = (List<Expertise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXPERTISE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPERTISE;

				if (pagination) {
					sql = sql.concat(ExpertiseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Expertise>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Expertise>(list);
				}
				else {
					list = (List<Expertise>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the expertises from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Expertise expertise : findAll()) {
			remove(expertise);
		}
	}

	/**
	 * Returns the number of expertises.
	 *
	 * @return the number of expertises
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

				Query q = session.createQuery(_SQL_COUNT_EXPERTISE);

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
	 * Initializes the expertise persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.Expertise")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Expertise>> listenersList = new ArrayList<ModelListener<Expertise>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Expertise>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExpertiseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EXPERTISE = "SELECT expertise FROM Expertise expertise";
	private static final String _SQL_SELECT_EXPERTISE_WHERE = "SELECT expertise FROM Expertise expertise WHERE ";
	private static final String _SQL_COUNT_EXPERTISE = "SELECT COUNT(expertise) FROM Expertise expertise";
	private static final String _SQL_COUNT_EXPERTISE_WHERE = "SELECT COUNT(expertise) FROM Expertise expertise WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expertise.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Expertise exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Expertise exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExpertisePersistenceImpl.class);
	private static Expertise _nullExpertise = new ExpertiseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Expertise> toCacheModel() {
				return _nullExpertiseCacheModel;
			}
		};

	private static CacheModel<Expertise> _nullExpertiseCacheModel = new CacheModel<Expertise>() {
			@Override
			public Expertise toEntityModel() {
				return _nullExpertise;
			}
		};
}