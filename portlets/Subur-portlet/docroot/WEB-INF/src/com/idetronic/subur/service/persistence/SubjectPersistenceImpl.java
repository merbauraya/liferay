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

import com.idetronic.subur.NoSuchSubjectException;
import com.idetronic.subur.model.Subject;
import com.idetronic.subur.model.impl.SubjectImpl;
import com.idetronic.subur.model.impl.SubjectModelImpl;

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
 * The persistence implementation for the subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SubjectPersistence
 * @see SubjectUtil
 * @generated
 */
public class SubjectPersistenceImpl extends BasePersistenceImpl<Subject>
	implements SubjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubjectUtil} to access the subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPOSITABLE =
		new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydepositable",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE =
		new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydepositable",
			new String[] { Boolean.class.getName() },
			SubjectModelImpl.DEPOSITABLE_COLUMN_BITMASK |
			SubjectModelImpl.SUBJECTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPOSITABLE = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydepositable",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the subjects where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @return the matching subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subject> findBydepositable(boolean depositable)
		throws SystemException {
		return findBydepositable(depositable, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subjects where depositable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param depositable the depositable
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of matching subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subject> findBydepositable(boolean depositable, int start,
		int end) throws SystemException {
		return findBydepositable(depositable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subjects where depositable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param depositable the depositable
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subject> findBydepositable(boolean depositable, int start,
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

		List<Subject> list = (List<Subject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Subject subject : list) {
				if ((depositable != subject.getDepositable())) {
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

			query.append(_SQL_SELECT_SUBJECT_WHERE);

			query.append(_FINDER_COLUMN_DEPOSITABLE_DEPOSITABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(depositable);

				if (!pagination) {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Subject>(list);
				}
				else {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first subject in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject
	 * @throws com.idetronic.subur.NoSuchSubjectException if a matching subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject findBydepositable_First(boolean depositable,
		OrderByComparator orderByComparator)
		throws NoSuchSubjectException, SystemException {
		Subject subject = fetchBydepositable_First(depositable,
				orderByComparator);

		if (subject != null) {
			return subject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("depositable=");
		msg.append(depositable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubjectException(msg.toString());
	}

	/**
	 * Returns the first subject in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject, or <code>null</code> if a matching subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject fetchBydepositable_First(boolean depositable,
		OrderByComparator orderByComparator) throws SystemException {
		List<Subject> list = findBydepositable(depositable, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subject in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject
	 * @throws com.idetronic.subur.NoSuchSubjectException if a matching subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject findBydepositable_Last(boolean depositable,
		OrderByComparator orderByComparator)
		throws NoSuchSubjectException, SystemException {
		Subject subject = fetchBydepositable_Last(depositable, orderByComparator);

		if (subject != null) {
			return subject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("depositable=");
		msg.append(depositable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubjectException(msg.toString());
	}

	/**
	 * Returns the last subject in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject, or <code>null</code> if a matching subject could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject fetchBydepositable_Last(boolean depositable,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBydepositable(depositable);

		if (count == 0) {
			return null;
		}

		List<Subject> list = findBydepositable(depositable, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subjects before and after the current subject in the ordered set where depositable = &#63;.
	 *
	 * @param subjectId the primary key of the current subject
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subject
	 * @throws com.idetronic.subur.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject[] findBydepositable_PrevAndNext(long subjectId,
		boolean depositable, OrderByComparator orderByComparator)
		throws NoSuchSubjectException, SystemException {
		Subject subject = findByPrimaryKey(subjectId);

		Session session = null;

		try {
			session = openSession();

			Subject[] array = new SubjectImpl[3];

			array[0] = getBydepositable_PrevAndNext(session, subject,
					depositable, orderByComparator, true);

			array[1] = subject;

			array[2] = getBydepositable_PrevAndNext(session, subject,
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

	protected Subject getBydepositable_PrevAndNext(Session session,
		Subject subject, boolean depositable,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBJECT_WHERE);

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
			query.append(SubjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(depositable);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Subject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subjects where depositable = &#63; from the database.
	 *
	 * @param depositable the depositable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBydepositable(boolean depositable)
		throws SystemException {
		for (Subject subject : findBydepositable(depositable,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subject);
		}
	}

	/**
	 * Returns the number of subjects where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @return the number of matching subjects
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

			query.append(_SQL_COUNT_SUBJECT_WHERE);

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

	private static final String _FINDER_COLUMN_DEPOSITABLE_DEPOSITABLE_2 = "subject.depositable = ?";

	public SubjectPersistenceImpl() {
		setModelClass(Subject.class);
	}

	/**
	 * Caches the subject in the entity cache if it is enabled.
	 *
	 * @param subject the subject
	 */
	@Override
	public void cacheResult(Subject subject) {
		EntityCacheUtil.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey(), subject);

		subject.resetOriginalValues();
	}

	/**
	 * Caches the subjects in the entity cache if it is enabled.
	 *
	 * @param subjects the subjects
	 */
	@Override
	public void cacheResult(List<Subject> subjects) {
		for (Subject subject : subjects) {
			if (EntityCacheUtil.getResult(
						SubjectModelImpl.ENTITY_CACHE_ENABLED,
						SubjectImpl.class, subject.getPrimaryKey()) == null) {
				cacheResult(subject);
			}
			else {
				subject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subjects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subject.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subject subject) {
		EntityCacheUtil.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Subject> subjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Subject subject : subjects) {
			EntityCacheUtil.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
				SubjectImpl.class, subject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new subject with the primary key. Does not add the subject to the database.
	 *
	 * @param subjectId the primary key for the new subject
	 * @return the new subject
	 */
	@Override
	public Subject create(long subjectId) {
		Subject subject = new SubjectImpl();

		subject.setNew(true);
		subject.setPrimaryKey(subjectId);

		return subject;
	}

	/**
	 * Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject that was removed
	 * @throws com.idetronic.subur.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject remove(long subjectId)
		throws NoSuchSubjectException, SystemException {
		return remove((Serializable)subjectId);
	}

	/**
	 * Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject that was removed
	 * @throws com.idetronic.subur.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject remove(Serializable primaryKey)
		throws NoSuchSubjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Subject subject = (Subject)session.get(SubjectImpl.class, primaryKey);

			if (subject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subject);
		}
		catch (NoSuchSubjectException nsee) {
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
	protected Subject removeImpl(Subject subject) throws SystemException {
		subject = toUnwrappedModel(subject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subject)) {
				subject = (Subject)session.get(SubjectImpl.class,
						subject.getPrimaryKeyObj());
			}

			if (subject != null) {
				session.delete(subject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subject != null) {
			clearCache(subject);
		}

		return subject;
	}

	@Override
	public Subject updateImpl(com.idetronic.subur.model.Subject subject)
		throws SystemException {
		subject = toUnwrappedModel(subject);

		boolean isNew = subject.isNew();

		SubjectModelImpl subjectModelImpl = (SubjectModelImpl)subject;

		Session session = null;

		try {
			session = openSession();

			if (subject.isNew()) {
				session.save(subject);

				subject.setNew(false);
			}
			else {
				session.merge(subject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((subjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subjectModelImpl.getOriginalDepositable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPOSITABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE,
					args);

				args = new Object[] { subjectModelImpl.getDepositable() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPOSITABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE,
					args);
			}
		}

		EntityCacheUtil.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey(), subject);

		return subject;
	}

	protected Subject toUnwrappedModel(Subject subject) {
		if (subject instanceof SubjectImpl) {
			return subject;
		}

		SubjectImpl subjectImpl = new SubjectImpl();

		subjectImpl.setNew(subject.isNew());
		subjectImpl.setPrimaryKey(subject.getPrimaryKey());

		subjectImpl.setSubjectId(subject.getSubjectId());
		subjectImpl.setParentId(subject.getParentId());
		subjectImpl.setSubjectName(subject.getSubjectName());
		subjectImpl.setLft(subject.getLft());
		subjectImpl.setRgt(subject.getRgt());
		subjectImpl.setDepositable(subject.isDepositable());
		subjectImpl.setItemCount(subject.getItemCount());

		return subjectImpl;
	}

	/**
	 * Returns the subject with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject
	 * @throws com.idetronic.subur.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubjectException, SystemException {
		Subject subject = fetchByPrimaryKey(primaryKey);

		if (subject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subject;
	}

	/**
	 * Returns the subject with the primary key or throws a {@link com.idetronic.subur.NoSuchSubjectException} if it could not be found.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject
	 * @throws com.idetronic.subur.NoSuchSubjectException if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject findByPrimaryKey(long subjectId)
		throws NoSuchSubjectException, SystemException {
		return findByPrimaryKey((Serializable)subjectId);
	}

	/**
	 * Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject, or <code>null</code> if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Subject subject = (Subject)EntityCacheUtil.getResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
				SubjectImpl.class, primaryKey);

		if (subject == _nullSubject) {
			return null;
		}

		if (subject == null) {
			Session session = null;

			try {
				session = openSession();

				subject = (Subject)session.get(SubjectImpl.class, primaryKey);

				if (subject != null) {
					cacheResult(subject);
				}
				else {
					EntityCacheUtil.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
						SubjectImpl.class, primaryKey, _nullSubject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
					SubjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subject;
	}

	/**
	 * Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject, or <code>null</code> if a subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subject fetchByPrimaryKey(long subjectId) throws SystemException {
		return fetchByPrimaryKey((Serializable)subjectId);
	}

	/**
	 * Returns all the subjects.
	 *
	 * @return the subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subject> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subject> findAll(int start, int end,
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

		List<Subject> list = (List<Subject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBJECT;

				if (pagination) {
					sql = sql.concat(SubjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Subject>(list);
				}
				else {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the subjects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Subject subject : findAll()) {
			remove(subject);
		}
	}

	/**
	 * Returns the number of subjects.
	 *
	 * @return the number of subjects
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

				Query q = session.createQuery(_SQL_COUNT_SUBJECT);

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
	 * Initializes the subject persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.Subject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Subject>> listenersList = new ArrayList<ModelListener<Subject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Subject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBJECT = "SELECT subject FROM Subject subject";
	private static final String _SQL_SELECT_SUBJECT_WHERE = "SELECT subject FROM Subject subject WHERE ";
	private static final String _SQL_COUNT_SUBJECT = "SELECT COUNT(subject) FROM Subject subject";
	private static final String _SQL_COUNT_SUBJECT_WHERE = "SELECT COUNT(subject) FROM Subject subject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubjectPersistenceImpl.class);
	private static Subject _nullSubject = new SubjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Subject> toCacheModel() {
				return _nullSubjectCacheModel;
			}
		};

	private static CacheModel<Subject> _nullSubjectCacheModel = new CacheModel<Subject>() {
			@Override
			public Subject toEntityModel() {
				return _nullSubject;
			}
		};
}