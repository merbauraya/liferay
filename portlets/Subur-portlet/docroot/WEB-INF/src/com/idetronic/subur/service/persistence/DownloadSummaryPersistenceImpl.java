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

import com.idetronic.subur.NoSuchDownloadSummaryException;
import com.idetronic.subur.model.DownloadSummary;
import com.idetronic.subur.model.impl.DownloadSummaryImpl;
import com.idetronic.subur.model.impl.DownloadSummaryModelImpl;

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
 * The persistence implementation for the download summary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see DownloadSummaryPersistence
 * @see DownloadSummaryUtil
 * @generated
 */
public class DownloadSummaryPersistenceImpl extends BasePersistenceImpl<DownloadSummary>
	implements DownloadSummaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DownloadSummaryUtil} to access the download summary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DownloadSummaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			DownloadSummaryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the download summaries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByStatus(int status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the download summaries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @return the range of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the download summaries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<DownloadSummary> list = (List<DownloadSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DownloadSummary downloadSummary : list) {
				if ((status != downloadSummary.getStatus())) {
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

			query.append(_SQL_SELECT_DOWNLOADSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DownloadSummaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<DownloadSummary>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DownloadSummary>(list);
				}
				else {
					list = (List<DownloadSummary>)QueryUtil.list(q,
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
	 * Returns the first download summary in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByStatus_First(status,
				orderByComparator);

		if (downloadSummary != null) {
			return downloadSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDownloadSummaryException(msg.toString());
	}

	/**
	 * Returns the first download summary in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching download summary, or <code>null</code> if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<DownloadSummary> list = findByStatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last download summary in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByStatus_Last(status,
				orderByComparator);

		if (downloadSummary != null) {
			return downloadSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDownloadSummaryException(msg.toString());
	}

	/**
	 * Returns the last download summary in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching download summary, or <code>null</code> if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<DownloadSummary> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the download summaries before and after the current download summary in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current download summary
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary[] findByStatus_PrevAndNext(long id, int status,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DownloadSummary[] array = new DownloadSummaryImpl[3];

			array[0] = getByStatus_PrevAndNext(session, downloadSummary,
					status, orderByComparator, true);

			array[1] = downloadSummary;

			array[2] = getByStatus_PrevAndNext(session, downloadSummary,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DownloadSummary getByStatus_PrevAndNext(Session session,
		DownloadSummary downloadSummary, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOWNLOADSUMMARY_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(DownloadSummaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(downloadSummary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DownloadSummary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the download summaries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (DownloadSummary downloadSummary : findByStatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(downloadSummary);
		}
	}

	/**
	 * Returns the number of download summaries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOWNLOADSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "downloadSummary.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID =
		new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemId",
			new String[] { Long.class.getName() },
			DownloadSummaryModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the download summaries where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByItemId(long itemId)
		throws SystemException {
		return findByItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the download summaries where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @return the range of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByItemId(long itemId, int start, int end)
		throws SystemException {
		return findByItemId(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the download summaries where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByItemId(long itemId, int start, int end,
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

		List<DownloadSummary> list = (List<DownloadSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DownloadSummary downloadSummary : list) {
				if ((itemId != downloadSummary.getItemId())) {
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

			query.append(_SQL_SELECT_DOWNLOADSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DownloadSummaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<DownloadSummary>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DownloadSummary>(list);
				}
				else {
					list = (List<DownloadSummary>)QueryUtil.list(q,
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
	 * Returns the first download summary in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByItemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByItemId_First(itemId,
				orderByComparator);

		if (downloadSummary != null) {
			return downloadSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDownloadSummaryException(msg.toString());
	}

	/**
	 * Returns the first download summary in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching download summary, or <code>null</code> if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByItemId_First(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DownloadSummary> list = findByItemId(itemId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last download summary in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByItemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByItemId_Last(itemId,
				orderByComparator);

		if (downloadSummary != null) {
			return downloadSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDownloadSummaryException(msg.toString());
	}

	/**
	 * Returns the last download summary in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching download summary, or <code>null</code> if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByItemId_Last(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemId(itemId);

		if (count == 0) {
			return null;
		}

		List<DownloadSummary> list = findByItemId(itemId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the download summaries before and after the current download summary in the ordered set where itemId = &#63;.
	 *
	 * @param id the primary key of the current download summary
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary[] findByItemId_PrevAndNext(long id, long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DownloadSummary[] array = new DownloadSummaryImpl[3];

			array[0] = getByItemId_PrevAndNext(session, downloadSummary,
					itemId, orderByComparator, true);

			array[1] = downloadSummary;

			array[2] = getByItemId_PrevAndNext(session, downloadSummary,
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

	protected DownloadSummary getByItemId_PrevAndNext(Session session,
		DownloadSummary downloadSummary, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOWNLOADSUMMARY_WHERE);

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
			query.append(DownloadSummaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(downloadSummary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DownloadSummary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the download summaries where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemId(long itemId) throws SystemException {
		for (DownloadSummary downloadSummary : findByItemId(itemId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(downloadSummary);
		}
	}

	/**
	 * Returns the number of download summaries where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching download summaries
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

			query.append(_SQL_COUNT_DOWNLOADSUMMARY_WHERE);

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

	private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "downloadSummary.itemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERIOD = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPeriod",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD =
		new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPeriod",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			DownloadSummaryModelImpl.PERMONTH_COLUMN_BITMASK |
			DownloadSummaryModelImpl.PERYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERIOD = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPeriod",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the download summaries where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @return the matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByPeriod(int perMonth, int perYear)
		throws SystemException {
		return findByPeriod(perMonth, perYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the download summaries where perMonth = &#63; and perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @return the range of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByPeriod(int perMonth, int perYear,
		int start, int end) throws SystemException {
		return findByPeriod(perMonth, perYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the download summaries where perMonth = &#63; and perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByPeriod(int perMonth, int perYear,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD;
			finderArgs = new Object[] { perMonth, perYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERIOD;
			finderArgs = new Object[] {
					perMonth, perYear,
					
					start, end, orderByComparator
				};
		}

		List<DownloadSummary> list = (List<DownloadSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DownloadSummary downloadSummary : list) {
				if ((perMonth != downloadSummary.getPerMonth()) ||
						(perYear != downloadSummary.getPerYear())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DOWNLOADSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_PERIOD_PERMONTH_2);

			query.append(_FINDER_COLUMN_PERIOD_PERYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DownloadSummaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perMonth);

				qPos.add(perYear);

				if (!pagination) {
					list = (List<DownloadSummary>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DownloadSummary>(list);
				}
				else {
					list = (List<DownloadSummary>)QueryUtil.list(q,
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
	 * Returns the first download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByPeriod_First(int perMonth, int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByPeriod_First(perMonth,
				perYear, orderByComparator);

		if (downloadSummary != null) {
			return downloadSummary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perMonth=");
		msg.append(perMonth);

		msg.append(", perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDownloadSummaryException(msg.toString());
	}

	/**
	 * Returns the first download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching download summary, or <code>null</code> if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByPeriod_First(int perMonth, int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<DownloadSummary> list = findByPeriod(perMonth, perYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByPeriod_Last(int perMonth, int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByPeriod_Last(perMonth, perYear,
				orderByComparator);

		if (downloadSummary != null) {
			return downloadSummary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perMonth=");
		msg.append(perMonth);

		msg.append(", perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDownloadSummaryException(msg.toString());
	}

	/**
	 * Returns the last download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching download summary, or <code>null</code> if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByPeriod_Last(int perMonth, int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPeriod(perMonth, perYear);

		if (count == 0) {
			return null;
		}

		List<DownloadSummary> list = findByPeriod(perMonth, perYear, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the download summaries before and after the current download summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param id the primary key of the current download summary
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary[] findByPeriod_PrevAndNext(long id, int perMonth,
		int perYear, OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DownloadSummary[] array = new DownloadSummaryImpl[3];

			array[0] = getByPeriod_PrevAndNext(session, downloadSummary,
					perMonth, perYear, orderByComparator, true);

			array[1] = downloadSummary;

			array[2] = getByPeriod_PrevAndNext(session, downloadSummary,
					perMonth, perYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DownloadSummary getByPeriod_PrevAndNext(Session session,
		DownloadSummary downloadSummary, int perMonth, int perYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOWNLOADSUMMARY_WHERE);

		query.append(_FINDER_COLUMN_PERIOD_PERMONTH_2);

		query.append(_FINDER_COLUMN_PERIOD_PERYEAR_2);

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
			query.append(DownloadSummaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(perMonth);

		qPos.add(perYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(downloadSummary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DownloadSummary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the download summaries where perMonth = &#63; and perYear = &#63; from the database.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPeriod(int perMonth, int perYear)
		throws SystemException {
		for (DownloadSummary downloadSummary : findByPeriod(perMonth, perYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(downloadSummary);
		}
	}

	/**
	 * Returns the number of download summaries where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @return the number of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPeriod(int perMonth, int perYear)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERIOD;

		Object[] finderArgs = new Object[] { perMonth, perYear };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOWNLOADSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_PERIOD_PERMONTH_2);

			query.append(_FINDER_COLUMN_PERIOD_PERYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perMonth);

				qPos.add(perYear);

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

	private static final String _FINDER_COLUMN_PERIOD_PERMONTH_2 = "downloadSummary.perMonth = ? AND ";
	private static final String _FINDER_COLUMN_PERIOD_PERYEAR_2 = "downloadSummary.perYear = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByYear",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED,
			DownloadSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] { Integer.class.getName() },
			DownloadSummaryModelImpl.PERYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the download summaries where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @return the matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByYear(int perYear)
		throws SystemException {
		return findByYear(perYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the download summaries where perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perYear the per year
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @return the range of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByYear(int perYear, int start, int end)
		throws SystemException {
		return findByYear(perYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the download summaries where perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perYear the per year
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findByYear(int perYear, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { perYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { perYear, start, end, orderByComparator };
		}

		List<DownloadSummary> list = (List<DownloadSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DownloadSummary downloadSummary : list) {
				if ((perYear != downloadSummary.getPerYear())) {
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

			query.append(_SQL_SELECT_DOWNLOADSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_YEAR_PERYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DownloadSummaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perYear);

				if (!pagination) {
					list = (List<DownloadSummary>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DownloadSummary>(list);
				}
				else {
					list = (List<DownloadSummary>)QueryUtil.list(q,
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
	 * Returns the first download summary in the ordered set where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByYear_First(int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByYear_First(perYear,
				orderByComparator);

		if (downloadSummary != null) {
			return downloadSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDownloadSummaryException(msg.toString());
	}

	/**
	 * Returns the first download summary in the ordered set where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching download summary, or <code>null</code> if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByYear_First(int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<DownloadSummary> list = findByYear(perYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last download summary in the ordered set where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByYear_Last(int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByYear_Last(perYear,
				orderByComparator);

		if (downloadSummary != null) {
			return downloadSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDownloadSummaryException(msg.toString());
	}

	/**
	 * Returns the last download summary in the ordered set where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching download summary, or <code>null</code> if a matching download summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByYear_Last(int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYear(perYear);

		if (count == 0) {
			return null;
		}

		List<DownloadSummary> list = findByYear(perYear, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the download summaries before and after the current download summary in the ordered set where perYear = &#63;.
	 *
	 * @param id the primary key of the current download summary
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary[] findByYear_PrevAndNext(long id, int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DownloadSummary[] array = new DownloadSummaryImpl[3];

			array[0] = getByYear_PrevAndNext(session, downloadSummary, perYear,
					orderByComparator, true);

			array[1] = downloadSummary;

			array[2] = getByYear_PrevAndNext(session, downloadSummary, perYear,
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

	protected DownloadSummary getByYear_PrevAndNext(Session session,
		DownloadSummary downloadSummary, int perYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOWNLOADSUMMARY_WHERE);

		query.append(_FINDER_COLUMN_YEAR_PERYEAR_2);

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
			query.append(DownloadSummaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(perYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(downloadSummary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DownloadSummary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the download summaries where perYear = &#63; from the database.
	 *
	 * @param perYear the per year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByYear(int perYear) throws SystemException {
		for (DownloadSummary downloadSummary : findByYear(perYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(downloadSummary);
		}
	}

	/**
	 * Returns the number of download summaries where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @return the number of matching download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByYear(int perYear) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YEAR;

		Object[] finderArgs = new Object[] { perYear };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOWNLOADSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_YEAR_PERYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perYear);

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

	private static final String _FINDER_COLUMN_YEAR_PERYEAR_2 = "downloadSummary.perYear = ?";

	public DownloadSummaryPersistenceImpl() {
		setModelClass(DownloadSummary.class);
	}

	/**
	 * Caches the download summary in the entity cache if it is enabled.
	 *
	 * @param downloadSummary the download summary
	 */
	@Override
	public void cacheResult(DownloadSummary downloadSummary) {
		EntityCacheUtil.putResult(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryImpl.class, downloadSummary.getPrimaryKey(),
			downloadSummary);

		downloadSummary.resetOriginalValues();
	}

	/**
	 * Caches the download summaries in the entity cache if it is enabled.
	 *
	 * @param downloadSummaries the download summaries
	 */
	@Override
	public void cacheResult(List<DownloadSummary> downloadSummaries) {
		for (DownloadSummary downloadSummary : downloadSummaries) {
			if (EntityCacheUtil.getResult(
						DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
						DownloadSummaryImpl.class,
						downloadSummary.getPrimaryKey()) == null) {
				cacheResult(downloadSummary);
			}
			else {
				downloadSummary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all download summaries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DownloadSummaryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DownloadSummaryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the download summary.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DownloadSummary downloadSummary) {
		EntityCacheUtil.removeResult(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryImpl.class, downloadSummary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DownloadSummary> downloadSummaries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DownloadSummary downloadSummary : downloadSummaries) {
			EntityCacheUtil.removeResult(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
				DownloadSummaryImpl.class, downloadSummary.getPrimaryKey());
		}
	}

	/**
	 * Creates a new download summary with the primary key. Does not add the download summary to the database.
	 *
	 * @param id the primary key for the new download summary
	 * @return the new download summary
	 */
	@Override
	public DownloadSummary create(long id) {
		DownloadSummary downloadSummary = new DownloadSummaryImpl();

		downloadSummary.setNew(true);
		downloadSummary.setPrimaryKey(id);

		return downloadSummary;
	}

	/**
	 * Removes the download summary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the download summary
	 * @return the download summary that was removed
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary remove(long id)
		throws NoSuchDownloadSummaryException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the download summary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the download summary
	 * @return the download summary that was removed
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary remove(Serializable primaryKey)
		throws NoSuchDownloadSummaryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DownloadSummary downloadSummary = (DownloadSummary)session.get(DownloadSummaryImpl.class,
					primaryKey);

			if (downloadSummary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDownloadSummaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(downloadSummary);
		}
		catch (NoSuchDownloadSummaryException nsee) {
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
	protected DownloadSummary removeImpl(DownloadSummary downloadSummary)
		throws SystemException {
		downloadSummary = toUnwrappedModel(downloadSummary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(downloadSummary)) {
				downloadSummary = (DownloadSummary)session.get(DownloadSummaryImpl.class,
						downloadSummary.getPrimaryKeyObj());
			}

			if (downloadSummary != null) {
				session.delete(downloadSummary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (downloadSummary != null) {
			clearCache(downloadSummary);
		}

		return downloadSummary;
	}

	@Override
	public DownloadSummary updateImpl(
		com.idetronic.subur.model.DownloadSummary downloadSummary)
		throws SystemException {
		downloadSummary = toUnwrappedModel(downloadSummary);

		boolean isNew = downloadSummary.isNew();

		DownloadSummaryModelImpl downloadSummaryModelImpl = (DownloadSummaryModelImpl)downloadSummary;

		Session session = null;

		try {
			session = openSession();

			if (downloadSummary.isNew()) {
				session.save(downloadSummary);

				downloadSummary.setNew(false);
			}
			else {
				session.merge(downloadSummary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DownloadSummaryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((downloadSummaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						downloadSummaryModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { downloadSummaryModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((downloadSummaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						downloadSummaryModelImpl.getOriginalItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);

				args = new Object[] { downloadSummaryModelImpl.getItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);
			}

			if ((downloadSummaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						downloadSummaryModelImpl.getOriginalPerMonth(),
						downloadSummaryModelImpl.getOriginalPerYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERIOD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD,
					args);

				args = new Object[] {
						downloadSummaryModelImpl.getPerMonth(),
						downloadSummaryModelImpl.getPerYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERIOD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD,
					args);
			}

			if ((downloadSummaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						downloadSummaryModelImpl.getOriginalPerYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);

				args = new Object[] { downloadSummaryModelImpl.getPerYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);
			}
		}

		EntityCacheUtil.putResult(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
			DownloadSummaryImpl.class, downloadSummary.getPrimaryKey(),
			downloadSummary);

		return downloadSummary;
	}

	protected DownloadSummary toUnwrappedModel(DownloadSummary downloadSummary) {
		if (downloadSummary instanceof DownloadSummaryImpl) {
			return downloadSummary;
		}

		DownloadSummaryImpl downloadSummaryImpl = new DownloadSummaryImpl();

		downloadSummaryImpl.setNew(downloadSummary.isNew());
		downloadSummaryImpl.setPrimaryKey(downloadSummary.getPrimaryKey());

		downloadSummaryImpl.setId(downloadSummary.getId());
		downloadSummaryImpl.setItemId(downloadSummary.getItemId());
		downloadSummaryImpl.setPerMonth(downloadSummary.getPerMonth());
		downloadSummaryImpl.setPerYear(downloadSummary.getPerYear());
		downloadSummaryImpl.setStatus(downloadSummary.getStatus());

		return downloadSummaryImpl;
	}

	/**
	 * Returns the download summary with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the download summary
	 * @return the download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDownloadSummaryException, SystemException {
		DownloadSummary downloadSummary = fetchByPrimaryKey(primaryKey);

		if (downloadSummary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDownloadSummaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return downloadSummary;
	}

	/**
	 * Returns the download summary with the primary key or throws a {@link com.idetronic.subur.NoSuchDownloadSummaryException} if it could not be found.
	 *
	 * @param id the primary key of the download summary
	 * @return the download summary
	 * @throws com.idetronic.subur.NoSuchDownloadSummaryException if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary findByPrimaryKey(long id)
		throws NoSuchDownloadSummaryException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the download summary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the download summary
	 * @return the download summary, or <code>null</code> if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DownloadSummary downloadSummary = (DownloadSummary)EntityCacheUtil.getResult(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
				DownloadSummaryImpl.class, primaryKey);

		if (downloadSummary == _nullDownloadSummary) {
			return null;
		}

		if (downloadSummary == null) {
			Session session = null;

			try {
				session = openSession();

				downloadSummary = (DownloadSummary)session.get(DownloadSummaryImpl.class,
						primaryKey);

				if (downloadSummary != null) {
					cacheResult(downloadSummary);
				}
				else {
					EntityCacheUtil.putResult(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
						DownloadSummaryImpl.class, primaryKey,
						_nullDownloadSummary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DownloadSummaryModelImpl.ENTITY_CACHE_ENABLED,
					DownloadSummaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return downloadSummary;
	}

	/**
	 * Returns the download summary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the download summary
	 * @return the download summary, or <code>null</code> if a download summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DownloadSummary fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the download summaries.
	 *
	 * @return the download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the download summaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @return the range of download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the download summaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of download summaries
	 * @param end the upper bound of the range of download summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of download summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DownloadSummary> findAll(int start, int end,
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

		List<DownloadSummary> list = (List<DownloadSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOWNLOADSUMMARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOWNLOADSUMMARY;

				if (pagination) {
					sql = sql.concat(DownloadSummaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DownloadSummary>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DownloadSummary>(list);
				}
				else {
					list = (List<DownloadSummary>)QueryUtil.list(q,
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
	 * Removes all the download summaries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DownloadSummary downloadSummary : findAll()) {
			remove(downloadSummary);
		}
	}

	/**
	 * Returns the number of download summaries.
	 *
	 * @return the number of download summaries
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

				Query q = session.createQuery(_SQL_COUNT_DOWNLOADSUMMARY);

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
	 * Initializes the download summary persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.DownloadSummary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DownloadSummary>> listenersList = new ArrayList<ModelListener<DownloadSummary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DownloadSummary>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DownloadSummaryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOWNLOADSUMMARY = "SELECT downloadSummary FROM DownloadSummary downloadSummary";
	private static final String _SQL_SELECT_DOWNLOADSUMMARY_WHERE = "SELECT downloadSummary FROM DownloadSummary downloadSummary WHERE ";
	private static final String _SQL_COUNT_DOWNLOADSUMMARY = "SELECT COUNT(downloadSummary) FROM DownloadSummary downloadSummary";
	private static final String _SQL_COUNT_DOWNLOADSUMMARY_WHERE = "SELECT COUNT(downloadSummary) FROM DownloadSummary downloadSummary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "downloadSummary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DownloadSummary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DownloadSummary exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DownloadSummaryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static DownloadSummary _nullDownloadSummary = new DownloadSummaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DownloadSummary> toCacheModel() {
				return _nullDownloadSummaryCacheModel;
			}
		};

	private static CacheModel<DownloadSummary> _nullDownloadSummaryCacheModel = new CacheModel<DownloadSummary>() {
			@Override
			public DownloadSummary toEntityModel() {
				return _nullDownloadSummary;
			}
		};
}