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

import com.idetronic.subur.NoSuchViewSummaryException;
import com.idetronic.subur.model.ViewSummary;
import com.idetronic.subur.model.impl.ViewSummaryImpl;
import com.idetronic.subur.model.impl.ViewSummaryModelImpl;

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
 * The persistence implementation for the view summary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ViewSummaryPersistence
 * @see ViewSummaryUtil
 * @generated
 */
public class ViewSummaryPersistenceImpl extends BasePersistenceImpl<ViewSummary>
	implements ViewSummaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ViewSummaryUtil} to access the view summary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ViewSummaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, ViewSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, ViewSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, ViewSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, ViewSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ViewSummaryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the view summaries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByStatus(int status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the view summaries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of view summaries
	 * @param end the upper bound of the range of view summaries (not inclusive)
	 * @return the range of matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the view summaries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of view summaries
	 * @param end the upper bound of the range of view summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByStatus(int status, int start, int end,
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

		List<ViewSummary> list = (List<ViewSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ViewSummary viewSummary : list) {
				if ((status != viewSummary.getStatus())) {
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

			query.append(_SQL_SELECT_VIEWSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ViewSummaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<ViewSummary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ViewSummary>(list);
				}
				else {
					list = (List<ViewSummary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first view summary in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = fetchByStatus_First(status, orderByComparator);

		if (viewSummary != null) {
			return viewSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchViewSummaryException(msg.toString());
	}

	/**
	 * Returns the first view summary in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching view summary, or <code>null</code> if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ViewSummary> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last view summary in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = fetchByStatus_Last(status, orderByComparator);

		if (viewSummary != null) {
			return viewSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchViewSummaryException(msg.toString());
	}

	/**
	 * Returns the last view summary in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching view summary, or <code>null</code> if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ViewSummary> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the view summaries before and after the current view summary in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current view summary
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary[] findByStatus_PrevAndNext(long id, int status,
		OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ViewSummary[] array = new ViewSummaryImpl[3];

			array[0] = getByStatus_PrevAndNext(session, viewSummary, status,
					orderByComparator, true);

			array[1] = viewSummary;

			array[2] = getByStatus_PrevAndNext(session, viewSummary, status,
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

	protected ViewSummary getByStatus_PrevAndNext(Session session,
		ViewSummary viewSummary, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIEWSUMMARY_WHERE);

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
			query.append(ViewSummaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(viewSummary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ViewSummary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the view summaries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (ViewSummary viewSummary : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(viewSummary);
		}
	}

	/**
	 * Returns the number of view summaries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching view summaries
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

			query.append(_SQL_COUNT_VIEWSUMMARY_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "viewSummary.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERIOD = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, ViewSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPeriod",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD =
		new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, ViewSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPeriod",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			ViewSummaryModelImpl.PERMONTH_COLUMN_BITMASK |
			ViewSummaryModelImpl.PERYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERIOD = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPeriod",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the view summaries where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @return the matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByPeriod(int perMonth, int perYear)
		throws SystemException {
		return findByPeriod(perMonth, perYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the view summaries where perMonth = &#63; and perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param start the lower bound of the range of view summaries
	 * @param end the upper bound of the range of view summaries (not inclusive)
	 * @return the range of matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByPeriod(int perMonth, int perYear, int start,
		int end) throws SystemException {
		return findByPeriod(perMonth, perYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the view summaries where perMonth = &#63; and perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param start the lower bound of the range of view summaries
	 * @param end the upper bound of the range of view summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByPeriod(int perMonth, int perYear, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ViewSummary> list = (List<ViewSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ViewSummary viewSummary : list) {
				if ((perMonth != viewSummary.getPerMonth()) ||
						(perYear != viewSummary.getPerYear())) {
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

			query.append(_SQL_SELECT_VIEWSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_PERIOD_PERMONTH_2);

			query.append(_FINDER_COLUMN_PERIOD_PERYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ViewSummaryModelImpl.ORDER_BY_JPQL);
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
					list = (List<ViewSummary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ViewSummary>(list);
				}
				else {
					list = (List<ViewSummary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary findByPeriod_First(int perMonth, int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = fetchByPeriod_First(perMonth, perYear,
				orderByComparator);

		if (viewSummary != null) {
			return viewSummary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perMonth=");
		msg.append(perMonth);

		msg.append(", perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchViewSummaryException(msg.toString());
	}

	/**
	 * Returns the first view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching view summary, or <code>null</code> if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary fetchByPeriod_First(int perMonth, int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<ViewSummary> list = findByPeriod(perMonth, perYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary findByPeriod_Last(int perMonth, int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = fetchByPeriod_Last(perMonth, perYear,
				orderByComparator);

		if (viewSummary != null) {
			return viewSummary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perMonth=");
		msg.append(perMonth);

		msg.append(", perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchViewSummaryException(msg.toString());
	}

	/**
	 * Returns the last view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching view summary, or <code>null</code> if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary fetchByPeriod_Last(int perMonth, int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPeriod(perMonth, perYear);

		if (count == 0) {
			return null;
		}

		List<ViewSummary> list = findByPeriod(perMonth, perYear, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the view summaries before and after the current view summary in the ordered set where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param id the primary key of the current view summary
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary[] findByPeriod_PrevAndNext(long id, int perMonth,
		int perYear, OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ViewSummary[] array = new ViewSummaryImpl[3];

			array[0] = getByPeriod_PrevAndNext(session, viewSummary, perMonth,
					perYear, orderByComparator, true);

			array[1] = viewSummary;

			array[2] = getByPeriod_PrevAndNext(session, viewSummary, perMonth,
					perYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ViewSummary getByPeriod_PrevAndNext(Session session,
		ViewSummary viewSummary, int perMonth, int perYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIEWSUMMARY_WHERE);

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
			query.append(ViewSummaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(perMonth);

		qPos.add(perYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(viewSummary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ViewSummary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the view summaries where perMonth = &#63; and perYear = &#63; from the database.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPeriod(int perMonth, int perYear)
		throws SystemException {
		for (ViewSummary viewSummary : findByPeriod(perMonth, perYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(viewSummary);
		}
	}

	/**
	 * Returns the number of view summaries where perMonth = &#63; and perYear = &#63;.
	 *
	 * @param perMonth the per month
	 * @param perYear the per year
	 * @return the number of matching view summaries
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

			query.append(_SQL_COUNT_VIEWSUMMARY_WHERE);

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

	private static final String _FINDER_COLUMN_PERIOD_PERMONTH_2 = "viewSummary.perMonth = ? AND ";
	private static final String _FINDER_COLUMN_PERIOD_PERYEAR_2 = "viewSummary.perYear = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, ViewSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYear",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, ViewSummaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] { Integer.class.getName() },
			ViewSummaryModelImpl.PERYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the view summaries where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @return the matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByYear(int perYear) throws SystemException {
		return findByYear(perYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the view summaries where perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perYear the per year
	 * @param start the lower bound of the range of view summaries
	 * @param end the upper bound of the range of view summaries (not inclusive)
	 * @return the range of matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByYear(int perYear, int start, int end)
		throws SystemException {
		return findByYear(perYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the view summaries where perYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param perYear the per year
	 * @param start the lower bound of the range of view summaries
	 * @param end the upper bound of the range of view summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findByYear(int perYear, int start, int end,
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

		List<ViewSummary> list = (List<ViewSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ViewSummary viewSummary : list) {
				if ((perYear != viewSummary.getPerYear())) {
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

			query.append(_SQL_SELECT_VIEWSUMMARY_WHERE);

			query.append(_FINDER_COLUMN_YEAR_PERYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ViewSummaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(perYear);

				if (!pagination) {
					list = (List<ViewSummary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ViewSummary>(list);
				}
				else {
					list = (List<ViewSummary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first view summary in the ordered set where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary findByYear_First(int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = fetchByYear_First(perYear, orderByComparator);

		if (viewSummary != null) {
			return viewSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchViewSummaryException(msg.toString());
	}

	/**
	 * Returns the first view summary in the ordered set where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching view summary, or <code>null</code> if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary fetchByYear_First(int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<ViewSummary> list = findByYear(perYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last view summary in the ordered set where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary findByYear_Last(int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = fetchByYear_Last(perYear, orderByComparator);

		if (viewSummary != null) {
			return viewSummary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("perYear=");
		msg.append(perYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchViewSummaryException(msg.toString());
	}

	/**
	 * Returns the last view summary in the ordered set where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching view summary, or <code>null</code> if a matching view summary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary fetchByYear_Last(int perYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYear(perYear);

		if (count == 0) {
			return null;
		}

		List<ViewSummary> list = findByYear(perYear, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the view summaries before and after the current view summary in the ordered set where perYear = &#63;.
	 *
	 * @param id the primary key of the current view summary
	 * @param perYear the per year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary[] findByYear_PrevAndNext(long id, int perYear,
		OrderByComparator orderByComparator)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ViewSummary[] array = new ViewSummaryImpl[3];

			array[0] = getByYear_PrevAndNext(session, viewSummary, perYear,
					orderByComparator, true);

			array[1] = viewSummary;

			array[2] = getByYear_PrevAndNext(session, viewSummary, perYear,
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

	protected ViewSummary getByYear_PrevAndNext(Session session,
		ViewSummary viewSummary, int perYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIEWSUMMARY_WHERE);

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
			query.append(ViewSummaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(perYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(viewSummary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ViewSummary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the view summaries where perYear = &#63; from the database.
	 *
	 * @param perYear the per year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByYear(int perYear) throws SystemException {
		for (ViewSummary viewSummary : findByYear(perYear, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(viewSummary);
		}
	}

	/**
	 * Returns the number of view summaries where perYear = &#63;.
	 *
	 * @param perYear the per year
	 * @return the number of matching view summaries
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

			query.append(_SQL_COUNT_VIEWSUMMARY_WHERE);

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

	private static final String _FINDER_COLUMN_YEAR_PERYEAR_2 = "viewSummary.perYear = ?";

	public ViewSummaryPersistenceImpl() {
		setModelClass(ViewSummary.class);
	}

	/**
	 * Caches the view summary in the entity cache if it is enabled.
	 *
	 * @param viewSummary the view summary
	 */
	@Override
	public void cacheResult(ViewSummary viewSummary) {
		EntityCacheUtil.putResult(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryImpl.class, viewSummary.getPrimaryKey(), viewSummary);

		viewSummary.resetOriginalValues();
	}

	/**
	 * Caches the view summaries in the entity cache if it is enabled.
	 *
	 * @param viewSummaries the view summaries
	 */
	@Override
	public void cacheResult(List<ViewSummary> viewSummaries) {
		for (ViewSummary viewSummary : viewSummaries) {
			if (EntityCacheUtil.getResult(
						ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
						ViewSummaryImpl.class, viewSummary.getPrimaryKey()) == null) {
				cacheResult(viewSummary);
			}
			else {
				viewSummary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all view summaries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ViewSummaryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ViewSummaryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the view summary.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ViewSummary viewSummary) {
		EntityCacheUtil.removeResult(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryImpl.class, viewSummary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ViewSummary> viewSummaries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ViewSummary viewSummary : viewSummaries) {
			EntityCacheUtil.removeResult(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
				ViewSummaryImpl.class, viewSummary.getPrimaryKey());
		}
	}

	/**
	 * Creates a new view summary with the primary key. Does not add the view summary to the database.
	 *
	 * @param id the primary key for the new view summary
	 * @return the new view summary
	 */
	@Override
	public ViewSummary create(long id) {
		ViewSummary viewSummary = new ViewSummaryImpl();

		viewSummary.setNew(true);
		viewSummary.setPrimaryKey(id);

		return viewSummary;
	}

	/**
	 * Removes the view summary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the view summary
	 * @return the view summary that was removed
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary remove(long id)
		throws NoSuchViewSummaryException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the view summary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the view summary
	 * @return the view summary that was removed
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary remove(Serializable primaryKey)
		throws NoSuchViewSummaryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewSummary viewSummary = (ViewSummary)session.get(ViewSummaryImpl.class,
					primaryKey);

			if (viewSummary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchViewSummaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(viewSummary);
		}
		catch (NoSuchViewSummaryException nsee) {
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
	protected ViewSummary removeImpl(ViewSummary viewSummary)
		throws SystemException {
		viewSummary = toUnwrappedModel(viewSummary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(viewSummary)) {
				viewSummary = (ViewSummary)session.get(ViewSummaryImpl.class,
						viewSummary.getPrimaryKeyObj());
			}

			if (viewSummary != null) {
				session.delete(viewSummary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (viewSummary != null) {
			clearCache(viewSummary);
		}

		return viewSummary;
	}

	@Override
	public ViewSummary updateImpl(
		com.idetronic.subur.model.ViewSummary viewSummary)
		throws SystemException {
		viewSummary = toUnwrappedModel(viewSummary);

		boolean isNew = viewSummary.isNew();

		ViewSummaryModelImpl viewSummaryModelImpl = (ViewSummaryModelImpl)viewSummary;

		Session session = null;

		try {
			session = openSession();

			if (viewSummary.isNew()) {
				session.save(viewSummary);

				viewSummary.setNew(false);
			}
			else {
				session.merge(viewSummary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ViewSummaryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((viewSummaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						viewSummaryModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { viewSummaryModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((viewSummaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						viewSummaryModelImpl.getOriginalPerMonth(),
						viewSummaryModelImpl.getOriginalPerYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERIOD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD,
					args);

				args = new Object[] {
						viewSummaryModelImpl.getPerMonth(),
						viewSummaryModelImpl.getPerYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERIOD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIOD,
					args);
			}

			if ((viewSummaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						viewSummaryModelImpl.getOriginalPerYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);

				args = new Object[] { viewSummaryModelImpl.getPerYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);
			}
		}

		EntityCacheUtil.putResult(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
			ViewSummaryImpl.class, viewSummary.getPrimaryKey(), viewSummary);

		return viewSummary;
	}

	protected ViewSummary toUnwrappedModel(ViewSummary viewSummary) {
		if (viewSummary instanceof ViewSummaryImpl) {
			return viewSummary;
		}

		ViewSummaryImpl viewSummaryImpl = new ViewSummaryImpl();

		viewSummaryImpl.setNew(viewSummary.isNew());
		viewSummaryImpl.setPrimaryKey(viewSummary.getPrimaryKey());

		viewSummaryImpl.setId(viewSummary.getId());
		viewSummaryImpl.setItemId(viewSummary.getItemId());
		viewSummaryImpl.setPerMonth(viewSummary.getPerMonth());
		viewSummaryImpl.setPerYear(viewSummary.getPerYear());
		viewSummaryImpl.setStatus(viewSummary.getStatus());

		return viewSummaryImpl;
	}

	/**
	 * Returns the view summary with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the view summary
	 * @return the view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchViewSummaryException, SystemException {
		ViewSummary viewSummary = fetchByPrimaryKey(primaryKey);

		if (viewSummary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchViewSummaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return viewSummary;
	}

	/**
	 * Returns the view summary with the primary key or throws a {@link com.idetronic.subur.NoSuchViewSummaryException} if it could not be found.
	 *
	 * @param id the primary key of the view summary
	 * @return the view summary
	 * @throws com.idetronic.subur.NoSuchViewSummaryException if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary findByPrimaryKey(long id)
		throws NoSuchViewSummaryException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the view summary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the view summary
	 * @return the view summary, or <code>null</code> if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ViewSummary viewSummary = (ViewSummary)EntityCacheUtil.getResult(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
				ViewSummaryImpl.class, primaryKey);

		if (viewSummary == _nullViewSummary) {
			return null;
		}

		if (viewSummary == null) {
			Session session = null;

			try {
				session = openSession();

				viewSummary = (ViewSummary)session.get(ViewSummaryImpl.class,
						primaryKey);

				if (viewSummary != null) {
					cacheResult(viewSummary);
				}
				else {
					EntityCacheUtil.putResult(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
						ViewSummaryImpl.class, primaryKey, _nullViewSummary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ViewSummaryModelImpl.ENTITY_CACHE_ENABLED,
					ViewSummaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return viewSummary;
	}

	/**
	 * Returns the view summary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the view summary
	 * @return the view summary, or <code>null</code> if a view summary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViewSummary fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the view summaries.
	 *
	 * @return the view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the view summaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of view summaries
	 * @param end the upper bound of the range of view summaries (not inclusive)
	 * @return the range of view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the view summaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of view summaries
	 * @param end the upper bound of the range of view summaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of view summaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ViewSummary> findAll(int start, int end,
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

		List<ViewSummary> list = (List<ViewSummary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIEWSUMMARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIEWSUMMARY;

				if (pagination) {
					sql = sql.concat(ViewSummaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ViewSummary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ViewSummary>(list);
				}
				else {
					list = (List<ViewSummary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the view summaries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ViewSummary viewSummary : findAll()) {
			remove(viewSummary);
		}
	}

	/**
	 * Returns the number of view summaries.
	 *
	 * @return the number of view summaries
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

				Query q = session.createQuery(_SQL_COUNT_VIEWSUMMARY);

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
	 * Initializes the view summary persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.ViewSummary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewSummary>> listenersList = new ArrayList<ModelListener<ViewSummary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewSummary>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ViewSummaryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIEWSUMMARY = "SELECT viewSummary FROM ViewSummary viewSummary";
	private static final String _SQL_SELECT_VIEWSUMMARY_WHERE = "SELECT viewSummary FROM ViewSummary viewSummary WHERE ";
	private static final String _SQL_COUNT_VIEWSUMMARY = "SELECT COUNT(viewSummary) FROM ViewSummary viewSummary";
	private static final String _SQL_COUNT_VIEWSUMMARY_WHERE = "SELECT COUNT(viewSummary) FROM ViewSummary viewSummary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "viewSummary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ViewSummary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ViewSummary exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ViewSummaryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static ViewSummary _nullViewSummary = new ViewSummaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ViewSummary> toCacheModel() {
				return _nullViewSummaryCacheModel;
			}
		};

	private static CacheModel<ViewSummary> _nullViewSummaryCacheModel = new CacheModel<ViewSummary>() {
			@Override
			public ViewSummary toEntityModel() {
				return _nullViewSummary;
			}
		};
}