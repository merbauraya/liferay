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

package com.idetronic.eprint.service.persistence;

import com.idetronic.eprint.NoSuchEprintException;
import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.model.impl.EprintImpl;
import com.idetronic.eprint.model.impl.EprintModelImpl;

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
 * The persistence implementation for the eprint service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintPersistence
 * @see EprintUtil
 * @generated
 */
public class EprintPersistenceImpl extends BasePersistenceImpl<Eprint>
	implements EprintPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EprintUtil} to access the eprint persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EprintImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintModelImpl.FINDER_CACHE_ENABLED, EprintImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintModelImpl.FINDER_CACHE_ENABLED, EprintImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EPRINTTYPE =
		new FinderPath(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintModelImpl.FINDER_CACHE_ENABLED, EprintImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByeprintType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPRINTTYPE =
		new FinderPath(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintModelImpl.FINDER_CACHE_ENABLED, EprintImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByeprintType",
			new String[] { String.class.getName() },
			EprintModelImpl.EPRINTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EPRINTTYPE = new FinderPath(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeprintType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the eprints where eprintType = &#63;.
	 *
	 * @param eprintType the eprint type
	 * @return the matching eprints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Eprint> findByeprintType(String eprintType)
		throws SystemException {
		return findByeprintType(eprintType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprints where eprintType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eprintType the eprint type
	 * @param start the lower bound of the range of eprints
	 * @param end the upper bound of the range of eprints (not inclusive)
	 * @return the range of matching eprints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Eprint> findByeprintType(String eprintType, int start, int end)
		throws SystemException {
		return findByeprintType(eprintType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprints where eprintType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eprintType the eprint type
	 * @param start the lower bound of the range of eprints
	 * @param end the upper bound of the range of eprints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eprints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Eprint> findByeprintType(String eprintType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPRINTTYPE;
			finderArgs = new Object[] { eprintType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EPRINTTYPE;
			finderArgs = new Object[] { eprintType, start, end, orderByComparator };
		}

		List<Eprint> list = (List<Eprint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Eprint eprint : list) {
				if (!Validator.equals(eprintType, eprint.getEprintType())) {
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

			query.append(_SQL_SELECT_EPRINT_WHERE);

			boolean bindEprintType = false;

			if (eprintType == null) {
				query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_1);
			}
			else if (eprintType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_3);
			}
			else {
				bindEprintType = true;

				query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EprintModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEprintType) {
					qPos.add(eprintType);
				}

				if (!pagination) {
					list = (List<Eprint>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Eprint>(list);
				}
				else {
					list = (List<Eprint>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first eprint in the ordered set where eprintType = &#63;.
	 *
	 * @param eprintType the eprint type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprint
	 * @throws com.idetronic.eprint.NoSuchEprintException if a matching eprint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint findByeprintType_First(String eprintType,
		OrderByComparator orderByComparator)
		throws NoSuchEprintException, SystemException {
		Eprint eprint = fetchByeprintType_First(eprintType, orderByComparator);

		if (eprint != null) {
			return eprint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eprintType=");
		msg.append(eprintType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEprintException(msg.toString());
	}

	/**
	 * Returns the first eprint in the ordered set where eprintType = &#63;.
	 *
	 * @param eprintType the eprint type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprint, or <code>null</code> if a matching eprint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint fetchByeprintType_First(String eprintType,
		OrderByComparator orderByComparator) throws SystemException {
		List<Eprint> list = findByeprintType(eprintType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last eprint in the ordered set where eprintType = &#63;.
	 *
	 * @param eprintType the eprint type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprint
	 * @throws com.idetronic.eprint.NoSuchEprintException if a matching eprint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint findByeprintType_Last(String eprintType,
		OrderByComparator orderByComparator)
		throws NoSuchEprintException, SystemException {
		Eprint eprint = fetchByeprintType_Last(eprintType, orderByComparator);

		if (eprint != null) {
			return eprint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eprintType=");
		msg.append(eprintType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEprintException(msg.toString());
	}

	/**
	 * Returns the last eprint in the ordered set where eprintType = &#63;.
	 *
	 * @param eprintType the eprint type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprint, or <code>null</code> if a matching eprint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint fetchByeprintType_Last(String eprintType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByeprintType(eprintType);

		if (count == 0) {
			return null;
		}

		List<Eprint> list = findByeprintType(eprintType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eprints before and after the current eprint in the ordered set where eprintType = &#63;.
	 *
	 * @param eprintId the primary key of the current eprint
	 * @param eprintType the eprint type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eprint
	 * @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint[] findByeprintType_PrevAndNext(long eprintId,
		String eprintType, OrderByComparator orderByComparator)
		throws NoSuchEprintException, SystemException {
		Eprint eprint = findByPrimaryKey(eprintId);

		Session session = null;

		try {
			session = openSession();

			Eprint[] array = new EprintImpl[3];

			array[0] = getByeprintType_PrevAndNext(session, eprint, eprintType,
					orderByComparator, true);

			array[1] = eprint;

			array[2] = getByeprintType_PrevAndNext(session, eprint, eprintType,
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

	protected Eprint getByeprintType_PrevAndNext(Session session,
		Eprint eprint, String eprintType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EPRINT_WHERE);

		boolean bindEprintType = false;

		if (eprintType == null) {
			query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_1);
		}
		else if (eprintType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_3);
		}
		else {
			bindEprintType = true;

			query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_2);
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
			query.append(EprintModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEprintType) {
			qPos.add(eprintType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eprint);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Eprint> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eprints where eprintType = &#63; from the database.
	 *
	 * @param eprintType the eprint type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByeprintType(String eprintType) throws SystemException {
		for (Eprint eprint : findByeprintType(eprintType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eprint);
		}
	}

	/**
	 * Returns the number of eprints where eprintType = &#63;.
	 *
	 * @param eprintType the eprint type
	 * @return the number of matching eprints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByeprintType(String eprintType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EPRINTTYPE;

		Object[] finderArgs = new Object[] { eprintType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EPRINT_WHERE);

			boolean bindEprintType = false;

			if (eprintType == null) {
				query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_1);
			}
			else if (eprintType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_3);
			}
			else {
				bindEprintType = true;

				query.append(_FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEprintType) {
					qPos.add(eprintType);
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

	private static final String _FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_1 = "eprint.eprintType IS NULL";
	private static final String _FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_2 = "eprint.eprintType = ?";
	private static final String _FINDER_COLUMN_EPRINTTYPE_EPRINTTYPE_3 = "(eprint.eprintType IS NULL OR eprint.eprintType = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_UT = new FinderPath(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintModelImpl.FINDER_CACHE_ENABLED, EprintImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_UT",
			new String[] { Long.class.getName(), String.class.getName() },
			EprintModelImpl.GROUPID_COLUMN_BITMASK |
			EprintModelImpl.URLTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_UT = new FinderPath(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UT",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the eprint where groupId = &#63; and urlTitle = &#63; or throws a {@link com.idetronic.eprint.NoSuchEprintException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching eprint
	 * @throws com.idetronic.eprint.NoSuchEprintException if a matching eprint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint findByG_UT(long groupId, String urlTitle)
		throws NoSuchEprintException, SystemException {
		Eprint eprint = fetchByG_UT(groupId, urlTitle);

		if (eprint == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", urlTitle=");
			msg.append(urlTitle);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEprintException(msg.toString());
		}

		return eprint;
	}

	/**
	 * Returns the eprint where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching eprint, or <code>null</code> if a matching eprint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint fetchByG_UT(long groupId, String urlTitle)
		throws SystemException {
		return fetchByG_UT(groupId, urlTitle, true);
	}

	/**
	 * Returns the eprint where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching eprint, or <code>null</code> if a matching eprint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint fetchByG_UT(long groupId, String urlTitle,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, urlTitle };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_UT,
					finderArgs, this);
		}

		if (result instanceof Eprint) {
			Eprint eprint = (Eprint)result;

			if ((groupId != eprint.getGroupId()) ||
					!Validator.equals(urlTitle, eprint.getUrlTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EPRINT_WHERE);

			query.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				List<Eprint> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT,
						finderArgs, list);
				}
				else {
					Eprint eprint = list.get(0);

					result = eprint;

					cacheResult(eprint);

					if ((eprint.getGroupId() != groupId) ||
							(eprint.getUrlTitle() == null) ||
							!eprint.getUrlTitle().equals(urlTitle)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT,
							finderArgs, eprint);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_UT,
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
			return (Eprint)result;
		}
	}

	/**
	 * Removes the eprint where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the eprint that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint removeByG_UT(long groupId, String urlTitle)
		throws NoSuchEprintException, SystemException {
		Eprint eprint = findByG_UT(groupId, urlTitle);

		return remove(eprint);
	}

	/**
	 * Returns the number of eprints where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching eprints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_UT(long groupId, String urlTitle)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_UT;

		Object[] finderArgs = new Object[] { groupId, urlTitle };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EPRINT_WHERE);

			query.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
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

	private static final String _FINDER_COLUMN_G_UT_GROUPID_2 = "eprint.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_UT_URLTITLE_1 = "eprint.urlTitle IS NULL";
	private static final String _FINDER_COLUMN_G_UT_URLTITLE_2 = "eprint.urlTitle = ?";
	private static final String _FINDER_COLUMN_G_UT_URLTITLE_3 = "(eprint.urlTitle IS NULL OR eprint.urlTitle = '')";

	public EprintPersistenceImpl() {
		setModelClass(Eprint.class);
	}

	/**
	 * Caches the eprint in the entity cache if it is enabled.
	 *
	 * @param eprint the eprint
	 */
	@Override
	public void cacheResult(Eprint eprint) {
		EntityCacheUtil.putResult(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintImpl.class, eprint.getPrimaryKey(), eprint);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT,
			new Object[] { eprint.getGroupId(), eprint.getUrlTitle() }, eprint);

		eprint.resetOriginalValues();
	}

	/**
	 * Caches the eprints in the entity cache if it is enabled.
	 *
	 * @param eprints the eprints
	 */
	@Override
	public void cacheResult(List<Eprint> eprints) {
		for (Eprint eprint : eprints) {
			if (EntityCacheUtil.getResult(
						EprintModelImpl.ENTITY_CACHE_ENABLED, EprintImpl.class,
						eprint.getPrimaryKey()) == null) {
				cacheResult(eprint);
			}
			else {
				eprint.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all eprints.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EprintImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EprintImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the eprint.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Eprint eprint) {
		EntityCacheUtil.removeResult(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintImpl.class, eprint.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(eprint);
	}

	@Override
	public void clearCache(List<Eprint> eprints) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Eprint eprint : eprints) {
			EntityCacheUtil.removeResult(EprintModelImpl.ENTITY_CACHE_ENABLED,
				EprintImpl.class, eprint.getPrimaryKey());

			clearUniqueFindersCache(eprint);
		}
	}

	protected void cacheUniqueFindersCache(Eprint eprint) {
		if (eprint.isNew()) {
			Object[] args = new Object[] {
					eprint.getGroupId(), eprint.getUrlTitle()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_UT, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT, args, eprint);
		}
		else {
			EprintModelImpl eprintModelImpl = (EprintModelImpl)eprint;

			if ((eprintModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_UT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eprint.getGroupId(), eprint.getUrlTitle()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_UT, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_UT, args,
					eprint);
			}
		}
	}

	protected void clearUniqueFindersCache(Eprint eprint) {
		EprintModelImpl eprintModelImpl = (EprintModelImpl)eprint;

		Object[] args = new Object[] { eprint.getGroupId(), eprint.getUrlTitle() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_UT, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_UT, args);

		if ((eprintModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_UT.getColumnBitmask()) != 0) {
			args = new Object[] {
					eprintModelImpl.getOriginalGroupId(),
					eprintModelImpl.getOriginalUrlTitle()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_UT, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_UT, args);
		}
	}

	/**
	 * Creates a new eprint with the primary key. Does not add the eprint to the database.
	 *
	 * @param eprintId the primary key for the new eprint
	 * @return the new eprint
	 */
	@Override
	public Eprint create(long eprintId) {
		Eprint eprint = new EprintImpl();

		eprint.setNew(true);
		eprint.setPrimaryKey(eprintId);

		return eprint;
	}

	/**
	 * Removes the eprint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eprintId the primary key of the eprint
	 * @return the eprint that was removed
	 * @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint remove(long eprintId)
		throws NoSuchEprintException, SystemException {
		return remove((Serializable)eprintId);
	}

	/**
	 * Removes the eprint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the eprint
	 * @return the eprint that was removed
	 * @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint remove(Serializable primaryKey)
		throws NoSuchEprintException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Eprint eprint = (Eprint)session.get(EprintImpl.class, primaryKey);

			if (eprint == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEprintException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eprint);
		}
		catch (NoSuchEprintException nsee) {
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
	protected Eprint removeImpl(Eprint eprint) throws SystemException {
		eprint = toUnwrappedModel(eprint);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eprint)) {
				eprint = (Eprint)session.get(EprintImpl.class,
						eprint.getPrimaryKeyObj());
			}

			if (eprint != null) {
				session.delete(eprint);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eprint != null) {
			clearCache(eprint);
		}

		return eprint;
	}

	@Override
	public Eprint updateImpl(com.idetronic.eprint.model.Eprint eprint)
		throws SystemException {
		eprint = toUnwrappedModel(eprint);

		boolean isNew = eprint.isNew();

		EprintModelImpl eprintModelImpl = (EprintModelImpl)eprint;

		Session session = null;

		try {
			session = openSession();

			if (eprint.isNew()) {
				session.save(eprint);

				eprint.setNew(false);
			}
			else {
				session.merge(eprint);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EprintModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eprintModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPRINTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eprintModelImpl.getOriginalEprintType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EPRINTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPRINTTYPE,
					args);

				args = new Object[] { eprintModelImpl.getEprintType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EPRINTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPRINTTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(EprintModelImpl.ENTITY_CACHE_ENABLED,
			EprintImpl.class, eprint.getPrimaryKey(), eprint);

		clearUniqueFindersCache(eprint);
		cacheUniqueFindersCache(eprint);

		return eprint;
	}

	protected Eprint toUnwrappedModel(Eprint eprint) {
		if (eprint instanceof EprintImpl) {
			return eprint;
		}

		EprintImpl eprintImpl = new EprintImpl();

		eprintImpl.setNew(eprint.isNew());
		eprintImpl.setPrimaryKey(eprint.getPrimaryKey());

		eprintImpl.setEprintId(eprint.getEprintId());
		eprintImpl.setGroupId(eprint.getGroupId());
		eprintImpl.setTitle(eprint.getTitle());
		eprintImpl.setUrlTitle(eprint.getUrlTitle());
		eprintImpl.setEprintType(eprint.getEprintType());
		eprintImpl.setEprintStatus(eprint.getEprintStatus());
		eprintImpl.setMetadataVisibility(eprint.getMetadataVisibility());
		eprintImpl.setEprintAbstract(eprint.getEprintAbstract());
		eprintImpl.setEprintKeywords(eprint.getEprintKeywords());
		eprintImpl.setIsPublished(eprint.getIsPublished());
		eprintImpl.setDateYear(eprint.getDateYear());
		eprintImpl.setFullTextStatus(eprint.getFullTextStatus());
		eprintImpl.setCompanyId(eprint.getCompanyId());
		eprintImpl.setModifiedDate(eprint.getModifiedDate());
		eprintImpl.setCreatedDate(eprint.getCreatedDate());
		eprintImpl.setUserId(eprint.getUserId());
		eprintImpl.setUserName(eprint.getUserName());

		return eprintImpl;
	}

	/**
	 * Returns the eprint with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprint
	 * @return the eprint
	 * @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEprintException, SystemException {
		Eprint eprint = fetchByPrimaryKey(primaryKey);

		if (eprint == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEprintException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eprint;
	}

	/**
	 * Returns the eprint with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintException} if it could not be found.
	 *
	 * @param eprintId the primary key of the eprint
	 * @return the eprint
	 * @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint findByPrimaryKey(long eprintId)
		throws NoSuchEprintException, SystemException {
		return findByPrimaryKey((Serializable)eprintId);
	}

	/**
	 * Returns the eprint with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprint
	 * @return the eprint, or <code>null</code> if a eprint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Eprint eprint = (Eprint)EntityCacheUtil.getResult(EprintModelImpl.ENTITY_CACHE_ENABLED,
				EprintImpl.class, primaryKey);

		if (eprint == _nullEprint) {
			return null;
		}

		if (eprint == null) {
			Session session = null;

			try {
				session = openSession();

				eprint = (Eprint)session.get(EprintImpl.class, primaryKey);

				if (eprint != null) {
					cacheResult(eprint);
				}
				else {
					EntityCacheUtil.putResult(EprintModelImpl.ENTITY_CACHE_ENABLED,
						EprintImpl.class, primaryKey, _nullEprint);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EprintModelImpl.ENTITY_CACHE_ENABLED,
					EprintImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eprint;
	}

	/**
	 * Returns the eprint with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eprintId the primary key of the eprint
	 * @return the eprint, or <code>null</code> if a eprint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Eprint fetchByPrimaryKey(long eprintId) throws SystemException {
		return fetchByPrimaryKey((Serializable)eprintId);
	}

	/**
	 * Returns all the eprints.
	 *
	 * @return the eprints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Eprint> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprints
	 * @param end the upper bound of the range of eprints (not inclusive)
	 * @return the range of eprints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Eprint> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprints
	 * @param end the upper bound of the range of eprints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eprints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Eprint> findAll(int start, int end,
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

		List<Eprint> list = (List<Eprint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EPRINT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EPRINT;

				if (pagination) {
					sql = sql.concat(EprintModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Eprint>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Eprint>(list);
				}
				else {
					list = (List<Eprint>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the eprints from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Eprint eprint : findAll()) {
			remove(eprint);
		}
	}

	/**
	 * Returns the number of eprints.
	 *
	 * @return the number of eprints
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

				Query q = session.createQuery(_SQL_COUNT_EPRINT);

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
	 * Initializes the eprint persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eprint.model.Eprint")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Eprint>> listenersList = new ArrayList<ModelListener<Eprint>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Eprint>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EprintImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EPRINT = "SELECT eprint FROM Eprint eprint";
	private static final String _SQL_SELECT_EPRINT_WHERE = "SELECT eprint FROM Eprint eprint WHERE ";
	private static final String _SQL_COUNT_EPRINT = "SELECT COUNT(eprint) FROM Eprint eprint";
	private static final String _SQL_COUNT_EPRINT_WHERE = "SELECT COUNT(eprint) FROM Eprint eprint WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eprint.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Eprint exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Eprint exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EprintPersistenceImpl.class);
	private static Eprint _nullEprint = new EprintImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Eprint> toCacheModel() {
				return _nullEprintCacheModel;
			}
		};

	private static CacheModel<Eprint> _nullEprintCacheModel = new CacheModel<Eprint>() {
			@Override
			public Eprint toEntityModel() {
				return _nullEprint;
			}
		};
}