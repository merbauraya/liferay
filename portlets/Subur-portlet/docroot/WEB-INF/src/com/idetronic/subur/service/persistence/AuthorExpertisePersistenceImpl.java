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

import com.idetronic.subur.NoSuchAuthorExpertiseException;
import com.idetronic.subur.model.AuthorExpertise;
import com.idetronic.subur.model.impl.AuthorExpertiseImpl;
import com.idetronic.subur.model.impl.AuthorExpertiseModelImpl;

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
 * The persistence implementation for the author expertise service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorExpertisePersistence
 * @see AuthorExpertiseUtil
 * @generated
 */
public class AuthorExpertisePersistenceImpl extends BasePersistenceImpl<AuthorExpertise>
	implements AuthorExpertisePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AuthorExpertiseUtil} to access the author expertise persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AuthorExpertiseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED,
			AuthorExpertiseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED,
			AuthorExpertiseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR = new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED,
			AuthorExpertiseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAuthor",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR =
		new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED,
			AuthorExpertiseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthor",
			new String[] { Long.class.getName() },
			AuthorExpertiseModelImpl.AUTHORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHOR = new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthor",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the author expertises where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findByAuthor(long authorId)
		throws SystemException {
		return findByAuthor(authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the author expertises where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of author expertises
	 * @param end the upper bound of the range of author expertises (not inclusive)
	 * @return the range of matching author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findByAuthor(long authorId, int start, int end)
		throws SystemException {
		return findByAuthor(authorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the author expertises where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of author expertises
	 * @param end the upper bound of the range of author expertises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findByAuthor(long authorId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR;
			finderArgs = new Object[] { authorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR;
			finderArgs = new Object[] { authorId, start, end, orderByComparator };
		}

		List<AuthorExpertise> list = (List<AuthorExpertise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AuthorExpertise authorExpertise : list) {
				if ((authorId != authorExpertise.getAuthorId())) {
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

			query.append(_SQL_SELECT_AUTHOREXPERTISE_WHERE);

			query.append(_FINDER_COLUMN_AUTHOR_AUTHORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AuthorExpertiseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (!pagination) {
					list = (List<AuthorExpertise>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AuthorExpertise>(list);
				}
				else {
					list = (List<AuthorExpertise>)QueryUtil.list(q,
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
	 * Returns the first author expertise in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author expertise
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise findByAuthor_First(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorExpertiseException, SystemException {
		AuthorExpertise authorExpertise = fetchByAuthor_First(authorId,
				orderByComparator);

		if (authorExpertise != null) {
			return authorExpertise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorExpertiseException(msg.toString());
	}

	/**
	 * Returns the first author expertise in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author expertise, or <code>null</code> if a matching author expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise fetchByAuthor_First(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AuthorExpertise> list = findByAuthor(authorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author expertise in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author expertise
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise findByAuthor_Last(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorExpertiseException, SystemException {
		AuthorExpertise authorExpertise = fetchByAuthor_Last(authorId,
				orderByComparator);

		if (authorExpertise != null) {
			return authorExpertise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorExpertiseException(msg.toString());
	}

	/**
	 * Returns the last author expertise in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author expertise, or <code>null</code> if a matching author expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise fetchByAuthor_Last(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAuthor(authorId);

		if (count == 0) {
			return null;
		}

		List<AuthorExpertise> list = findByAuthor(authorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the author expertises before and after the current author expertise in the ordered set where authorId = &#63;.
	 *
	 * @param authorExpertisePK the primary key of the current author expertise
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next author expertise
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise[] findByAuthor_PrevAndNext(
		AuthorExpertisePK authorExpertisePK, long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorExpertiseException, SystemException {
		AuthorExpertise authorExpertise = findByPrimaryKey(authorExpertisePK);

		Session session = null;

		try {
			session = openSession();

			AuthorExpertise[] array = new AuthorExpertiseImpl[3];

			array[0] = getByAuthor_PrevAndNext(session, authorExpertise,
					authorId, orderByComparator, true);

			array[1] = authorExpertise;

			array[2] = getByAuthor_PrevAndNext(session, authorExpertise,
					authorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuthorExpertise getByAuthor_PrevAndNext(Session session,
		AuthorExpertise authorExpertise, long authorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUTHOREXPERTISE_WHERE);

		query.append(_FINDER_COLUMN_AUTHOR_AUTHORID_2);

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
			query.append(AuthorExpertiseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(authorExpertise);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AuthorExpertise> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the author expertises where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthor(long authorId) throws SystemException {
		for (AuthorExpertise authorExpertise : findByAuthor(authorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(authorExpertise);
		}
	}

	/**
	 * Returns the number of author expertises where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthor(long authorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHOR;

		Object[] finderArgs = new Object[] { authorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUTHOREXPERTISE_WHERE);

			query.append(_FINDER_COLUMN_AUTHOR_AUTHORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

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

	private static final String _FINDER_COLUMN_AUTHOR_AUTHORID_2 = "authorExpertise.id.authorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPERTISE =
		new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED,
			AuthorExpertiseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByExpertise",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPERTISE =
		new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED,
			AuthorExpertiseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExpertise",
			new String[] { Long.class.getName() },
			AuthorExpertiseModelImpl.EXPERTISEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXPERTISE = new FinderPath(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExpertise",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the author expertises where expertiseId = &#63;.
	 *
	 * @param expertiseId the expertise ID
	 * @return the matching author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findByExpertise(long expertiseId)
		throws SystemException {
		return findByExpertise(expertiseId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the author expertises where expertiseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param expertiseId the expertise ID
	 * @param start the lower bound of the range of author expertises
	 * @param end the upper bound of the range of author expertises (not inclusive)
	 * @return the range of matching author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findByExpertise(long expertiseId, int start,
		int end) throws SystemException {
		return findByExpertise(expertiseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the author expertises where expertiseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param expertiseId the expertise ID
	 * @param start the lower bound of the range of author expertises
	 * @param end the upper bound of the range of author expertises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findByExpertise(long expertiseId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPERTISE;
			finderArgs = new Object[] { expertiseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPERTISE;
			finderArgs = new Object[] { expertiseId, start, end, orderByComparator };
		}

		List<AuthorExpertise> list = (List<AuthorExpertise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AuthorExpertise authorExpertise : list) {
				if ((expertiseId != authorExpertise.getExpertiseId())) {
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

			query.append(_SQL_SELECT_AUTHOREXPERTISE_WHERE);

			query.append(_FINDER_COLUMN_EXPERTISE_EXPERTISEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AuthorExpertiseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(expertiseId);

				if (!pagination) {
					list = (List<AuthorExpertise>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AuthorExpertise>(list);
				}
				else {
					list = (List<AuthorExpertise>)QueryUtil.list(q,
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
	 * Returns the first author expertise in the ordered set where expertiseId = &#63;.
	 *
	 * @param expertiseId the expertise ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author expertise
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise findByExpertise_First(long expertiseId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorExpertiseException, SystemException {
		AuthorExpertise authorExpertise = fetchByExpertise_First(expertiseId,
				orderByComparator);

		if (authorExpertise != null) {
			return authorExpertise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("expertiseId=");
		msg.append(expertiseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorExpertiseException(msg.toString());
	}

	/**
	 * Returns the first author expertise in the ordered set where expertiseId = &#63;.
	 *
	 * @param expertiseId the expertise ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author expertise, or <code>null</code> if a matching author expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise fetchByExpertise_First(long expertiseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AuthorExpertise> list = findByExpertise(expertiseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author expertise in the ordered set where expertiseId = &#63;.
	 *
	 * @param expertiseId the expertise ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author expertise
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise findByExpertise_Last(long expertiseId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorExpertiseException, SystemException {
		AuthorExpertise authorExpertise = fetchByExpertise_Last(expertiseId,
				orderByComparator);

		if (authorExpertise != null) {
			return authorExpertise;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("expertiseId=");
		msg.append(expertiseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorExpertiseException(msg.toString());
	}

	/**
	 * Returns the last author expertise in the ordered set where expertiseId = &#63;.
	 *
	 * @param expertiseId the expertise ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author expertise, or <code>null</code> if a matching author expertise could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise fetchByExpertise_Last(long expertiseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByExpertise(expertiseId);

		if (count == 0) {
			return null;
		}

		List<AuthorExpertise> list = findByExpertise(expertiseId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the author expertises before and after the current author expertise in the ordered set where expertiseId = &#63;.
	 *
	 * @param authorExpertisePK the primary key of the current author expertise
	 * @param expertiseId the expertise ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next author expertise
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise[] findByExpertise_PrevAndNext(
		AuthorExpertisePK authorExpertisePK, long expertiseId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorExpertiseException, SystemException {
		AuthorExpertise authorExpertise = findByPrimaryKey(authorExpertisePK);

		Session session = null;

		try {
			session = openSession();

			AuthorExpertise[] array = new AuthorExpertiseImpl[3];

			array[0] = getByExpertise_PrevAndNext(session, authorExpertise,
					expertiseId, orderByComparator, true);

			array[1] = authorExpertise;

			array[2] = getByExpertise_PrevAndNext(session, authorExpertise,
					expertiseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuthorExpertise getByExpertise_PrevAndNext(Session session,
		AuthorExpertise authorExpertise, long expertiseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUTHOREXPERTISE_WHERE);

		query.append(_FINDER_COLUMN_EXPERTISE_EXPERTISEID_2);

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
			query.append(AuthorExpertiseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(expertiseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(authorExpertise);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AuthorExpertise> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the author expertises where expertiseId = &#63; from the database.
	 *
	 * @param expertiseId the expertise ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByExpertise(long expertiseId) throws SystemException {
		for (AuthorExpertise authorExpertise : findByExpertise(expertiseId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(authorExpertise);
		}
	}

	/**
	 * Returns the number of author expertises where expertiseId = &#63;.
	 *
	 * @param expertiseId the expertise ID
	 * @return the number of matching author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByExpertise(long expertiseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXPERTISE;

		Object[] finderArgs = new Object[] { expertiseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUTHOREXPERTISE_WHERE);

			query.append(_FINDER_COLUMN_EXPERTISE_EXPERTISEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(expertiseId);

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

	private static final String _FINDER_COLUMN_EXPERTISE_EXPERTISEID_2 = "authorExpertise.id.expertiseId = ?";

	public AuthorExpertisePersistenceImpl() {
		setModelClass(AuthorExpertise.class);
	}

	/**
	 * Caches the author expertise in the entity cache if it is enabled.
	 *
	 * @param authorExpertise the author expertise
	 */
	@Override
	public void cacheResult(AuthorExpertise authorExpertise) {
		EntityCacheUtil.putResult(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseImpl.class, authorExpertise.getPrimaryKey(),
			authorExpertise);

		authorExpertise.resetOriginalValues();
	}

	/**
	 * Caches the author expertises in the entity cache if it is enabled.
	 *
	 * @param authorExpertises the author expertises
	 */
	@Override
	public void cacheResult(List<AuthorExpertise> authorExpertises) {
		for (AuthorExpertise authorExpertise : authorExpertises) {
			if (EntityCacheUtil.getResult(
						AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
						AuthorExpertiseImpl.class,
						authorExpertise.getPrimaryKey()) == null) {
				cacheResult(authorExpertise);
			}
			else {
				authorExpertise.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all author expertises.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AuthorExpertiseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AuthorExpertiseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the author expertise.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuthorExpertise authorExpertise) {
		EntityCacheUtil.removeResult(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseImpl.class, authorExpertise.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AuthorExpertise> authorExpertises) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AuthorExpertise authorExpertise : authorExpertises) {
			EntityCacheUtil.removeResult(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
				AuthorExpertiseImpl.class, authorExpertise.getPrimaryKey());
		}
	}

	/**
	 * Creates a new author expertise with the primary key. Does not add the author expertise to the database.
	 *
	 * @param authorExpertisePK the primary key for the new author expertise
	 * @return the new author expertise
	 */
	@Override
	public AuthorExpertise create(AuthorExpertisePK authorExpertisePK) {
		AuthorExpertise authorExpertise = new AuthorExpertiseImpl();

		authorExpertise.setNew(true);
		authorExpertise.setPrimaryKey(authorExpertisePK);

		return authorExpertise;
	}

	/**
	 * Removes the author expertise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorExpertisePK the primary key of the author expertise
	 * @return the author expertise that was removed
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise remove(AuthorExpertisePK authorExpertisePK)
		throws NoSuchAuthorExpertiseException, SystemException {
		return remove((Serializable)authorExpertisePK);
	}

	/**
	 * Removes the author expertise with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the author expertise
	 * @return the author expertise that was removed
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise remove(Serializable primaryKey)
		throws NoSuchAuthorExpertiseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AuthorExpertise authorExpertise = (AuthorExpertise)session.get(AuthorExpertiseImpl.class,
					primaryKey);

			if (authorExpertise == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthorExpertiseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(authorExpertise);
		}
		catch (NoSuchAuthorExpertiseException nsee) {
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
	protected AuthorExpertise removeImpl(AuthorExpertise authorExpertise)
		throws SystemException {
		authorExpertise = toUnwrappedModel(authorExpertise);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(authorExpertise)) {
				authorExpertise = (AuthorExpertise)session.get(AuthorExpertiseImpl.class,
						authorExpertise.getPrimaryKeyObj());
			}

			if (authorExpertise != null) {
				session.delete(authorExpertise);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (authorExpertise != null) {
			clearCache(authorExpertise);
		}

		return authorExpertise;
	}

	@Override
	public AuthorExpertise updateImpl(
		com.idetronic.subur.model.AuthorExpertise authorExpertise)
		throws SystemException {
		authorExpertise = toUnwrappedModel(authorExpertise);

		boolean isNew = authorExpertise.isNew();

		AuthorExpertiseModelImpl authorExpertiseModelImpl = (AuthorExpertiseModelImpl)authorExpertise;

		Session session = null;

		try {
			session = openSession();

			if (authorExpertise.isNew()) {
				session.save(authorExpertise);

				authorExpertise.setNew(false);
			}
			else {
				session.merge(authorExpertise);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AuthorExpertiseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((authorExpertiseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						authorExpertiseModelImpl.getOriginalAuthorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);

				args = new Object[] { authorExpertiseModelImpl.getAuthorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);
			}

			if ((authorExpertiseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPERTISE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						authorExpertiseModelImpl.getOriginalExpertiseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXPERTISE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPERTISE,
					args);

				args = new Object[] { authorExpertiseModelImpl.getExpertiseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXPERTISE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPERTISE,
					args);
			}
		}

		EntityCacheUtil.putResult(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
			AuthorExpertiseImpl.class, authorExpertise.getPrimaryKey(),
			authorExpertise);

		return authorExpertise;
	}

	protected AuthorExpertise toUnwrappedModel(AuthorExpertise authorExpertise) {
		if (authorExpertise instanceof AuthorExpertiseImpl) {
			return authorExpertise;
		}

		AuthorExpertiseImpl authorExpertiseImpl = new AuthorExpertiseImpl();

		authorExpertiseImpl.setNew(authorExpertise.isNew());
		authorExpertiseImpl.setPrimaryKey(authorExpertise.getPrimaryKey());

		authorExpertiseImpl.setAuthorId(authorExpertise.getAuthorId());
		authorExpertiseImpl.setExpertiseId(authorExpertise.getExpertiseId());

		return authorExpertiseImpl;
	}

	/**
	 * Returns the author expertise with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the author expertise
	 * @return the author expertise
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthorExpertiseException, SystemException {
		AuthorExpertise authorExpertise = fetchByPrimaryKey(primaryKey);

		if (authorExpertise == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthorExpertiseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return authorExpertise;
	}

	/**
	 * Returns the author expertise with the primary key or throws a {@link com.idetronic.subur.NoSuchAuthorExpertiseException} if it could not be found.
	 *
	 * @param authorExpertisePK the primary key of the author expertise
	 * @return the author expertise
	 * @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise findByPrimaryKey(AuthorExpertisePK authorExpertisePK)
		throws NoSuchAuthorExpertiseException, SystemException {
		return findByPrimaryKey((Serializable)authorExpertisePK);
	}

	/**
	 * Returns the author expertise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the author expertise
	 * @return the author expertise, or <code>null</code> if a author expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AuthorExpertise authorExpertise = (AuthorExpertise)EntityCacheUtil.getResult(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
				AuthorExpertiseImpl.class, primaryKey);

		if (authorExpertise == _nullAuthorExpertise) {
			return null;
		}

		if (authorExpertise == null) {
			Session session = null;

			try {
				session = openSession();

				authorExpertise = (AuthorExpertise)session.get(AuthorExpertiseImpl.class,
						primaryKey);

				if (authorExpertise != null) {
					cacheResult(authorExpertise);
				}
				else {
					EntityCacheUtil.putResult(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
						AuthorExpertiseImpl.class, primaryKey,
						_nullAuthorExpertise);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AuthorExpertiseModelImpl.ENTITY_CACHE_ENABLED,
					AuthorExpertiseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return authorExpertise;
	}

	/**
	 * Returns the author expertise with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorExpertisePK the primary key of the author expertise
	 * @return the author expertise, or <code>null</code> if a author expertise with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorExpertise fetchByPrimaryKey(
		AuthorExpertisePK authorExpertisePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)authorExpertisePK);
	}

	/**
	 * Returns all the author expertises.
	 *
	 * @return the author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the author expertises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of author expertises
	 * @param end the upper bound of the range of author expertises (not inclusive)
	 * @return the range of author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the author expertises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of author expertises
	 * @param end the upper bound of the range of author expertises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of author expertises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorExpertise> findAll(int start, int end,
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

		List<AuthorExpertise> list = (List<AuthorExpertise>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUTHOREXPERTISE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUTHOREXPERTISE;

				if (pagination) {
					sql = sql.concat(AuthorExpertiseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AuthorExpertise>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AuthorExpertise>(list);
				}
				else {
					list = (List<AuthorExpertise>)QueryUtil.list(q,
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
	 * Removes all the author expertises from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AuthorExpertise authorExpertise : findAll()) {
			remove(authorExpertise);
		}
	}

	/**
	 * Returns the number of author expertises.
	 *
	 * @return the number of author expertises
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

				Query q = session.createQuery(_SQL_COUNT_AUTHOREXPERTISE);

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
	 * Initializes the author expertise persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.AuthorExpertise")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AuthorExpertise>> listenersList = new ArrayList<ModelListener<AuthorExpertise>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AuthorExpertise>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AuthorExpertiseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_AUTHOREXPERTISE = "SELECT authorExpertise FROM AuthorExpertise authorExpertise";
	private static final String _SQL_SELECT_AUTHOREXPERTISE_WHERE = "SELECT authorExpertise FROM AuthorExpertise authorExpertise WHERE ";
	private static final String _SQL_COUNT_AUTHOREXPERTISE = "SELECT COUNT(authorExpertise) FROM AuthorExpertise authorExpertise";
	private static final String _SQL_COUNT_AUTHOREXPERTISE_WHERE = "SELECT COUNT(authorExpertise) FROM AuthorExpertise authorExpertise WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "authorExpertise.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuthorExpertise exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AuthorExpertise exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AuthorExpertisePersistenceImpl.class);
	private static AuthorExpertise _nullAuthorExpertise = new AuthorExpertiseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AuthorExpertise> toCacheModel() {
				return _nullAuthorExpertiseCacheModel;
			}
		};

	private static CacheModel<AuthorExpertise> _nullAuthorExpertiseCacheModel = new CacheModel<AuthorExpertise>() {
			@Override
			public AuthorExpertise toEntityModel() {
				return _nullAuthorExpertise;
			}
		};
}