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

import com.idetronic.subur.NoSuchDivisionException;
import com.idetronic.subur.model.Division;
import com.idetronic.subur.model.impl.DivisionImpl;
import com.idetronic.subur.model.impl.DivisionModelImpl;

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
 * The persistence implementation for the division service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see DivisionPersistence
 * @see DivisionUtil
 * @generated
 */
public class DivisionPersistenceImpl extends BasePersistenceImpl<Division>
	implements DivisionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DivisionUtil} to access the division persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DivisionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionModelImpl.FINDER_CACHE_ENABLED, DivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionModelImpl.FINDER_CACHE_ENABLED, DivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPOSITABLE =
		new FinderPath(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionModelImpl.FINDER_CACHE_ENABLED, DivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydepositable",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE =
		new FinderPath(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionModelImpl.FINDER_CACHE_ENABLED, DivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydepositable",
			new String[] { Boolean.class.getName() },
			DivisionModelImpl.DEPOSITABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPOSITABLE = new FinderPath(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydepositable",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the divisions where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @return the matching divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Division> findBydepositable(boolean depositable)
		throws SystemException {
		return findBydepositable(depositable, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the divisions where depositable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param depositable the depositable
	 * @param start the lower bound of the range of divisions
	 * @param end the upper bound of the range of divisions (not inclusive)
	 * @return the range of matching divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Division> findBydepositable(boolean depositable, int start,
		int end) throws SystemException {
		return findBydepositable(depositable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the divisions where depositable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param depositable the depositable
	 * @param start the lower bound of the range of divisions
	 * @param end the upper bound of the range of divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Division> findBydepositable(boolean depositable, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE;
			finderArgs = new Object[] { depositable };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPOSITABLE;
			finderArgs = new Object[] { depositable, start, end, orderByComparator };
		}

		List<Division> list = (List<Division>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Division division : list) {
				if ((depositable != division.getDepositable())) {
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

			query.append(_SQL_SELECT_DIVISION_WHERE);

			query.append(_FINDER_COLUMN_DEPOSITABLE_DEPOSITABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DivisionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(depositable);

				if (!pagination) {
					list = (List<Division>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Division>(list);
				}
				else {
					list = (List<Division>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first division in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching division
	 * @throws com.idetronic.subur.NoSuchDivisionException if a matching division could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division findBydepositable_First(boolean depositable,
		OrderByComparator orderByComparator)
		throws NoSuchDivisionException, SystemException {
		Division division = fetchBydepositable_First(depositable,
				orderByComparator);

		if (division != null) {
			return division;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("depositable=");
		msg.append(depositable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDivisionException(msg.toString());
	}

	/**
	 * Returns the first division in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching division, or <code>null</code> if a matching division could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division fetchBydepositable_First(boolean depositable,
		OrderByComparator orderByComparator) throws SystemException {
		List<Division> list = findBydepositable(depositable, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last division in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching division
	 * @throws com.idetronic.subur.NoSuchDivisionException if a matching division could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division findBydepositable_Last(boolean depositable,
		OrderByComparator orderByComparator)
		throws NoSuchDivisionException, SystemException {
		Division division = fetchBydepositable_Last(depositable,
				orderByComparator);

		if (division != null) {
			return division;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("depositable=");
		msg.append(depositable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDivisionException(msg.toString());
	}

	/**
	 * Returns the last division in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching division, or <code>null</code> if a matching division could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division fetchBydepositable_Last(boolean depositable,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBydepositable(depositable);

		if (count == 0) {
			return null;
		}

		List<Division> list = findBydepositable(depositable, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the divisions before and after the current division in the ordered set where depositable = &#63;.
	 *
	 * @param divisionId the primary key of the current division
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next division
	 * @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division[] findBydepositable_PrevAndNext(long divisionId,
		boolean depositable, OrderByComparator orderByComparator)
		throws NoSuchDivisionException, SystemException {
		Division division = findByPrimaryKey(divisionId);

		Session session = null;

		try {
			session = openSession();

			Division[] array = new DivisionImpl[3];

			array[0] = getBydepositable_PrevAndNext(session, division,
					depositable, orderByComparator, true);

			array[1] = division;

			array[2] = getBydepositable_PrevAndNext(session, division,
					depositable, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Division getBydepositable_PrevAndNext(Session session,
		Division division, boolean depositable,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DIVISION_WHERE);

		query.append(_FINDER_COLUMN_DEPOSITABLE_DEPOSITABLE_2);

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
			query.append(DivisionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(depositable);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(division);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Division> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the divisions where depositable = &#63; from the database.
	 *
	 * @param depositable the depositable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBydepositable(boolean depositable)
		throws SystemException {
		for (Division division : findBydepositable(depositable,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(division);
		}
	}

	/**
	 * Returns the number of divisions where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @return the number of matching divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBydepositable(boolean depositable)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPOSITABLE;

		Object[] finderArgs = new Object[] { depositable };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DIVISION_WHERE);

			query.append(_FINDER_COLUMN_DEPOSITABLE_DEPOSITABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(depositable);

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

	private static final String _FINDER_COLUMN_DEPOSITABLE_DEPOSITABLE_2 = "division.depositable = ?";

	public DivisionPersistenceImpl() {
		setModelClass(Division.class);
	}

	/**
	 * Caches the division in the entity cache if it is enabled.
	 *
	 * @param division the division
	 */
	@Override
	public void cacheResult(Division division) {
		EntityCacheUtil.putResult(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionImpl.class, division.getPrimaryKey(), division);

		division.resetOriginalValues();
	}

	/**
	 * Caches the divisions in the entity cache if it is enabled.
	 *
	 * @param divisions the divisions
	 */
	@Override
	public void cacheResult(List<Division> divisions) {
		for (Division division : divisions) {
			if (EntityCacheUtil.getResult(
						DivisionModelImpl.ENTITY_CACHE_ENABLED,
						DivisionImpl.class, division.getPrimaryKey()) == null) {
				cacheResult(division);
			}
			else {
				division.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all divisions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DivisionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DivisionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the division.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Division division) {
		EntityCacheUtil.removeResult(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionImpl.class, division.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Division> divisions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Division division : divisions) {
			EntityCacheUtil.removeResult(DivisionModelImpl.ENTITY_CACHE_ENABLED,
				DivisionImpl.class, division.getPrimaryKey());
		}
	}

	/**
	 * Creates a new division with the primary key. Does not add the division to the database.
	 *
	 * @param divisionId the primary key for the new division
	 * @return the new division
	 */
	@Override
	public Division create(long divisionId) {
		Division division = new DivisionImpl();

		division.setNew(true);
		division.setPrimaryKey(divisionId);

		return division;
	}

	/**
	 * Removes the division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param divisionId the primary key of the division
	 * @return the division that was removed
	 * @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division remove(long divisionId)
		throws NoSuchDivisionException, SystemException {
		return remove((Serializable)divisionId);
	}

	/**
	 * Removes the division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the division
	 * @return the division that was removed
	 * @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division remove(Serializable primaryKey)
		throws NoSuchDivisionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Division division = (Division)session.get(DivisionImpl.class,
					primaryKey);

			if (division == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDivisionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(division);
		}
		catch (NoSuchDivisionException nsee) {
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
	protected Division removeImpl(Division division) throws SystemException {
		division = toUnwrappedModel(division);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(division)) {
				division = (Division)session.get(DivisionImpl.class,
						division.getPrimaryKeyObj());
			}

			if (division != null) {
				session.delete(division);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (division != null) {
			clearCache(division);
		}

		return division;
	}

	@Override
	public Division updateImpl(com.idetronic.subur.model.Division division)
		throws SystemException {
		division = toUnwrappedModel(division);

		boolean isNew = division.isNew();

		DivisionModelImpl divisionModelImpl = (DivisionModelImpl)division;

		Session session = null;

		try {
			session = openSession();

			if (division.isNew()) {
				session.save(division);

				division.setNew(false);
			}
			else {
				session.merge(division);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DivisionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((divisionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						divisionModelImpl.getOriginalDepositable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPOSITABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE,
					args);

				args = new Object[] { divisionModelImpl.getDepositable() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPOSITABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE,
					args);
			}
		}

		EntityCacheUtil.putResult(DivisionModelImpl.ENTITY_CACHE_ENABLED,
			DivisionImpl.class, division.getPrimaryKey(), division);

		return division;
	}

	protected Division toUnwrappedModel(Division division) {
		if (division instanceof DivisionImpl) {
			return division;
		}

		DivisionImpl divisionImpl = new DivisionImpl();

		divisionImpl.setNew(division.isNew());
		divisionImpl.setPrimaryKey(division.getPrimaryKey());

		divisionImpl.setDivisionId(division.getDivisionId());
		divisionImpl.setParentId(division.getParentId());
		divisionImpl.setDivisionName(division.getDivisionName());
		divisionImpl.setDepositable(division.isDepositable());

		return divisionImpl;
	}

	/**
	 * Returns the division with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the division
	 * @return the division
	 * @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDivisionException, SystemException {
		Division division = fetchByPrimaryKey(primaryKey);

		if (division == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDivisionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return division;
	}

	/**
	 * Returns the division with the primary key or throws a {@link com.idetronic.subur.NoSuchDivisionException} if it could not be found.
	 *
	 * @param divisionId the primary key of the division
	 * @return the division
	 * @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division findByPrimaryKey(long divisionId)
		throws NoSuchDivisionException, SystemException {
		return findByPrimaryKey((Serializable)divisionId);
	}

	/**
	 * Returns the division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the division
	 * @return the division, or <code>null</code> if a division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Division division = (Division)EntityCacheUtil.getResult(DivisionModelImpl.ENTITY_CACHE_ENABLED,
				DivisionImpl.class, primaryKey);

		if (division == _nullDivision) {
			return null;
		}

		if (division == null) {
			Session session = null;

			try {
				session = openSession();

				division = (Division)session.get(DivisionImpl.class, primaryKey);

				if (division != null) {
					cacheResult(division);
				}
				else {
					EntityCacheUtil.putResult(DivisionModelImpl.ENTITY_CACHE_ENABLED,
						DivisionImpl.class, primaryKey, _nullDivision);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DivisionModelImpl.ENTITY_CACHE_ENABLED,
					DivisionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return division;
	}

	/**
	 * Returns the division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param divisionId the primary key of the division
	 * @return the division, or <code>null</code> if a division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Division fetchByPrimaryKey(long divisionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)divisionId);
	}

	/**
	 * Returns all the divisions.
	 *
	 * @return the divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Division> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of divisions
	 * @param end the upper bound of the range of divisions (not inclusive)
	 * @return the range of divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Division> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of divisions
	 * @param end the upper bound of the range of divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Division> findAll(int start, int end,
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

		List<Division> list = (List<Division>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DIVISION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DIVISION;

				if (pagination) {
					sql = sql.concat(DivisionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Division>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Division>(list);
				}
				else {
					list = (List<Division>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the divisions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Division division : findAll()) {
			remove(division);
		}
	}

	/**
	 * Returns the number of divisions.
	 *
	 * @return the number of divisions
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

				Query q = session.createQuery(_SQL_COUNT_DIVISION);

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
	 * Initializes the division persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.Division")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Division>> listenersList = new ArrayList<ModelListener<Division>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Division>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DivisionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DIVISION = "SELECT division FROM Division division";
	private static final String _SQL_SELECT_DIVISION_WHERE = "SELECT division FROM Division division WHERE ";
	private static final String _SQL_COUNT_DIVISION = "SELECT COUNT(division) FROM Division division";
	private static final String _SQL_COUNT_DIVISION_WHERE = "SELECT COUNT(division) FROM Division division WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "division.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Division exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Division exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DivisionPersistenceImpl.class);
	private static Division _nullDivision = new DivisionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Division> toCacheModel() {
				return _nullDivisionCacheModel;
			}
		};

	private static CacheModel<Division> _nullDivisionCacheModel = new CacheModel<Division>() {
			@Override
			public Division toEntityModel() {
				return _nullDivision;
			}
		};
}