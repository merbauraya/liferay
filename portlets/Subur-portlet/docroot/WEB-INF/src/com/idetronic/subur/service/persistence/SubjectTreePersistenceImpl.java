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

import com.idetronic.subur.NoSuchSubjectTreeException;
import com.idetronic.subur.model.SubjectTree;
import com.idetronic.subur.model.impl.SubjectTreeImpl;
import com.idetronic.subur.model.impl.SubjectTreeModelImpl;

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
 * The persistence implementation for the subject tree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SubjectTreePersistence
 * @see SubjectTreeUtil
 * @generated
 */
public class SubjectTreePersistenceImpl extends BasePersistenceImpl<SubjectTree>
	implements SubjectTreePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubjectTreeUtil} to access the subject tree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubjectTreeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeModelImpl.FINDER_CACHE_ENABLED, SubjectTreeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeModelImpl.FINDER_CACHE_ENABLED, SubjectTreeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPOSITABLE =
		new FinderPath(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeModelImpl.FINDER_CACHE_ENABLED, SubjectTreeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydepositable",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE =
		new FinderPath(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeModelImpl.FINDER_CACHE_ENABLED, SubjectTreeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydepositable",
			new String[] { Boolean.class.getName() },
			SubjectTreeModelImpl.DEPOSITABLE_COLUMN_BITMASK |
			SubjectTreeModelImpl.SUBJECTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPOSITABLE = new FinderPath(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydepositable",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the subject trees where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @return the matching subject trees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubjectTree> findBydepositable(boolean depositable)
		throws SystemException {
		return findBydepositable(depositable, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subject trees where depositable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param depositable the depositable
	 * @param start the lower bound of the range of subject trees
	 * @param end the upper bound of the range of subject trees (not inclusive)
	 * @return the range of matching subject trees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubjectTree> findBydepositable(boolean depositable, int start,
		int end) throws SystemException {
		return findBydepositable(depositable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subject trees where depositable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param depositable the depositable
	 * @param start the lower bound of the range of subject trees
	 * @param end the upper bound of the range of subject trees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subject trees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubjectTree> findBydepositable(boolean depositable, int start,
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

		List<SubjectTree> list = (List<SubjectTree>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubjectTree subjectTree : list) {
				if ((depositable != subjectTree.getDepositable())) {
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

			query.append(_SQL_SELECT_SUBJECTTREE_WHERE);

			query.append(_FINDER_COLUMN_DEPOSITABLE_DEPOSITABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubjectTreeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(depositable);

				if (!pagination) {
					list = (List<SubjectTree>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubjectTree>(list);
				}
				else {
					list = (List<SubjectTree>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first subject tree in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject tree
	 * @throws com.idetronic.subur.NoSuchSubjectTreeException if a matching subject tree could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree findBydepositable_First(boolean depositable,
		OrderByComparator orderByComparator)
		throws NoSuchSubjectTreeException, SystemException {
		SubjectTree subjectTree = fetchBydepositable_First(depositable,
				orderByComparator);

		if (subjectTree != null) {
			return subjectTree;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("depositable=");
		msg.append(depositable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubjectTreeException(msg.toString());
	}

	/**
	 * Returns the first subject tree in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject tree, or <code>null</code> if a matching subject tree could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree fetchBydepositable_First(boolean depositable,
		OrderByComparator orderByComparator) throws SystemException {
		List<SubjectTree> list = findBydepositable(depositable, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subject tree in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject tree
	 * @throws com.idetronic.subur.NoSuchSubjectTreeException if a matching subject tree could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree findBydepositable_Last(boolean depositable,
		OrderByComparator orderByComparator)
		throws NoSuchSubjectTreeException, SystemException {
		SubjectTree subjectTree = fetchBydepositable_Last(depositable,
				orderByComparator);

		if (subjectTree != null) {
			return subjectTree;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("depositable=");
		msg.append(depositable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubjectTreeException(msg.toString());
	}

	/**
	 * Returns the last subject tree in the ordered set where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject tree, or <code>null</code> if a matching subject tree could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree fetchBydepositable_Last(boolean depositable,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBydepositable(depositable);

		if (count == 0) {
			return null;
		}

		List<SubjectTree> list = findBydepositable(depositable, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subject trees before and after the current subject tree in the ordered set where depositable = &#63;.
	 *
	 * @param subjectId the primary key of the current subject tree
	 * @param depositable the depositable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subject tree
	 * @throws com.idetronic.subur.NoSuchSubjectTreeException if a subject tree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree[] findBydepositable_PrevAndNext(long subjectId,
		boolean depositable, OrderByComparator orderByComparator)
		throws NoSuchSubjectTreeException, SystemException {
		SubjectTree subjectTree = findByPrimaryKey(subjectId);

		Session session = null;

		try {
			session = openSession();

			SubjectTree[] array = new SubjectTreeImpl[3];

			array[0] = getBydepositable_PrevAndNext(session, subjectTree,
					depositable, orderByComparator, true);

			array[1] = subjectTree;

			array[2] = getBydepositable_PrevAndNext(session, subjectTree,
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

	protected SubjectTree getBydepositable_PrevAndNext(Session session,
		SubjectTree subjectTree, boolean depositable,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBJECTTREE_WHERE);

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
			query.append(SubjectTreeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(depositable);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subjectTree);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubjectTree> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subject trees where depositable = &#63; from the database.
	 *
	 * @param depositable the depositable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBydepositable(boolean depositable)
		throws SystemException {
		for (SubjectTree subjectTree : findBydepositable(depositable,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subjectTree);
		}
	}

	/**
	 * Returns the number of subject trees where depositable = &#63;.
	 *
	 * @param depositable the depositable
	 * @return the number of matching subject trees
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

			query.append(_SQL_COUNT_SUBJECTTREE_WHERE);

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

	private static final String _FINDER_COLUMN_DEPOSITABLE_DEPOSITABLE_2 = "subjectTree.depositable = ?";

	public SubjectTreePersistenceImpl() {
		setModelClass(SubjectTree.class);
	}

	/**
	 * Caches the subject tree in the entity cache if it is enabled.
	 *
	 * @param subjectTree the subject tree
	 */
	@Override
	public void cacheResult(SubjectTree subjectTree) {
		EntityCacheUtil.putResult(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeImpl.class, subjectTree.getPrimaryKey(), subjectTree);

		subjectTree.resetOriginalValues();
	}

	/**
	 * Caches the subject trees in the entity cache if it is enabled.
	 *
	 * @param subjectTrees the subject trees
	 */
	@Override
	public void cacheResult(List<SubjectTree> subjectTrees) {
		for (SubjectTree subjectTree : subjectTrees) {
			if (EntityCacheUtil.getResult(
						SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
						SubjectTreeImpl.class, subjectTree.getPrimaryKey()) == null) {
				cacheResult(subjectTree);
			}
			else {
				subjectTree.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subject trees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubjectTreeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubjectTreeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subject tree.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubjectTree subjectTree) {
		EntityCacheUtil.removeResult(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeImpl.class, subjectTree.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SubjectTree> subjectTrees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SubjectTree subjectTree : subjectTrees) {
			EntityCacheUtil.removeResult(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
				SubjectTreeImpl.class, subjectTree.getPrimaryKey());
		}
	}

	/**
	 * Creates a new subject tree with the primary key. Does not add the subject tree to the database.
	 *
	 * @param subjectId the primary key for the new subject tree
	 * @return the new subject tree
	 */
	@Override
	public SubjectTree create(long subjectId) {
		SubjectTree subjectTree = new SubjectTreeImpl();

		subjectTree.setNew(true);
		subjectTree.setPrimaryKey(subjectId);

		return subjectTree;
	}

	/**
	 * Removes the subject tree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectId the primary key of the subject tree
	 * @return the subject tree that was removed
	 * @throws com.idetronic.subur.NoSuchSubjectTreeException if a subject tree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree remove(long subjectId)
		throws NoSuchSubjectTreeException, SystemException {
		return remove((Serializable)subjectId);
	}

	/**
	 * Removes the subject tree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subject tree
	 * @return the subject tree that was removed
	 * @throws com.idetronic.subur.NoSuchSubjectTreeException if a subject tree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree remove(Serializable primaryKey)
		throws NoSuchSubjectTreeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SubjectTree subjectTree = (SubjectTree)session.get(SubjectTreeImpl.class,
					primaryKey);

			if (subjectTree == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubjectTreeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subjectTree);
		}
		catch (NoSuchSubjectTreeException nsee) {
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
	protected SubjectTree removeImpl(SubjectTree subjectTree)
		throws SystemException {
		subjectTree = toUnwrappedModel(subjectTree);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subjectTree)) {
				subjectTree = (SubjectTree)session.get(SubjectTreeImpl.class,
						subjectTree.getPrimaryKeyObj());
			}

			if (subjectTree != null) {
				session.delete(subjectTree);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subjectTree != null) {
			clearCache(subjectTree);
		}

		return subjectTree;
	}

	@Override
	public SubjectTree updateImpl(
		com.idetronic.subur.model.SubjectTree subjectTree)
		throws SystemException {
		subjectTree = toUnwrappedModel(subjectTree);

		boolean isNew = subjectTree.isNew();

		SubjectTreeModelImpl subjectTreeModelImpl = (SubjectTreeModelImpl)subjectTree;

		Session session = null;

		try {
			session = openSession();

			if (subjectTree.isNew()) {
				session.save(subjectTree);

				subjectTree.setNew(false);
			}
			else {
				session.merge(subjectTree);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubjectTreeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((subjectTreeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subjectTreeModelImpl.getOriginalDepositable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPOSITABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE,
					args);

				args = new Object[] { subjectTreeModelImpl.getDepositable() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPOSITABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPOSITABLE,
					args);
			}
		}

		EntityCacheUtil.putResult(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
			SubjectTreeImpl.class, subjectTree.getPrimaryKey(), subjectTree);

		return subjectTree;
	}

	protected SubjectTree toUnwrappedModel(SubjectTree subjectTree) {
		if (subjectTree instanceof SubjectTreeImpl) {
			return subjectTree;
		}

		SubjectTreeImpl subjectTreeImpl = new SubjectTreeImpl();

		subjectTreeImpl.setNew(subjectTree.isNew());
		subjectTreeImpl.setPrimaryKey(subjectTree.getPrimaryKey());

		subjectTreeImpl.setSubjectId(subjectTree.getSubjectId());
		subjectTreeImpl.setParentId(subjectTree.getParentId());
		subjectTreeImpl.setSubjectName(subjectTree.getSubjectName());
		subjectTreeImpl.setLft(subjectTree.getLft());
		subjectTreeImpl.setRgt(subjectTree.getRgt());
		subjectTreeImpl.setDepositable(subjectTree.isDepositable());
		subjectTreeImpl.setItemCount(subjectTree.getItemCount());

		return subjectTreeImpl;
	}

	/**
	 * Returns the subject tree with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject tree
	 * @return the subject tree
	 * @throws com.idetronic.subur.NoSuchSubjectTreeException if a subject tree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubjectTreeException, SystemException {
		SubjectTree subjectTree = fetchByPrimaryKey(primaryKey);

		if (subjectTree == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubjectTreeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subjectTree;
	}

	/**
	 * Returns the subject tree with the primary key or throws a {@link com.idetronic.subur.NoSuchSubjectTreeException} if it could not be found.
	 *
	 * @param subjectId the primary key of the subject tree
	 * @return the subject tree
	 * @throws com.idetronic.subur.NoSuchSubjectTreeException if a subject tree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree findByPrimaryKey(long subjectId)
		throws NoSuchSubjectTreeException, SystemException {
		return findByPrimaryKey((Serializable)subjectId);
	}

	/**
	 * Returns the subject tree with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject tree
	 * @return the subject tree, or <code>null</code> if a subject tree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SubjectTree subjectTree = (SubjectTree)EntityCacheUtil.getResult(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
				SubjectTreeImpl.class, primaryKey);

		if (subjectTree == _nullSubjectTree) {
			return null;
		}

		if (subjectTree == null) {
			Session session = null;

			try {
				session = openSession();

				subjectTree = (SubjectTree)session.get(SubjectTreeImpl.class,
						primaryKey);

				if (subjectTree != null) {
					cacheResult(subjectTree);
				}
				else {
					EntityCacheUtil.putResult(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
						SubjectTreeImpl.class, primaryKey, _nullSubjectTree);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubjectTreeModelImpl.ENTITY_CACHE_ENABLED,
					SubjectTreeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subjectTree;
	}

	/**
	 * Returns the subject tree with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectId the primary key of the subject tree
	 * @return the subject tree, or <code>null</code> if a subject tree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubjectTree fetchByPrimaryKey(long subjectId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)subjectId);
	}

	/**
	 * Returns all the subject trees.
	 *
	 * @return the subject trees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubjectTree> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subject trees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject trees
	 * @param end the upper bound of the range of subject trees (not inclusive)
	 * @return the range of subject trees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubjectTree> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subject trees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject trees
	 * @param end the upper bound of the range of subject trees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subject trees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubjectTree> findAll(int start, int end,
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

		List<SubjectTree> list = (List<SubjectTree>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBJECTTREE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBJECTTREE;

				if (pagination) {
					sql = sql.concat(SubjectTreeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SubjectTree>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubjectTree>(list);
				}
				else {
					list = (List<SubjectTree>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the subject trees from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SubjectTree subjectTree : findAll()) {
			remove(subjectTree);
		}
	}

	/**
	 * Returns the number of subject trees.
	 *
	 * @return the number of subject trees
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

				Query q = session.createQuery(_SQL_COUNT_SUBJECTTREE);

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
	 * Initializes the subject tree persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.SubjectTree")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SubjectTree>> listenersList = new ArrayList<ModelListener<SubjectTree>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SubjectTree>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubjectTreeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBJECTTREE = "SELECT subjectTree FROM SubjectTree subjectTree";
	private static final String _SQL_SELECT_SUBJECTTREE_WHERE = "SELECT subjectTree FROM SubjectTree subjectTree WHERE ";
	private static final String _SQL_COUNT_SUBJECTTREE = "SELECT COUNT(subjectTree) FROM SubjectTree subjectTree";
	private static final String _SQL_COUNT_SUBJECTTREE_WHERE = "SELECT COUNT(subjectTree) FROM SubjectTree subjectTree WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subjectTree.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubjectTree exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubjectTree exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubjectTreePersistenceImpl.class);
	private static SubjectTree _nullSubjectTree = new SubjectTreeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SubjectTree> toCacheModel() {
				return _nullSubjectTreeCacheModel;
			}
		};

	private static CacheModel<SubjectTree> _nullSubjectTreeCacheModel = new CacheModel<SubjectTree>() {
			@Override
			public SubjectTree toEntityModel() {
				return _nullSubjectTree;
			}
		};
}