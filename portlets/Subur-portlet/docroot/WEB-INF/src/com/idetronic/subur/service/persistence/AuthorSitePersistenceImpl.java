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

import com.idetronic.subur.NoSuchAuthorSiteException;
import com.idetronic.subur.model.AuthorSite;
import com.idetronic.subur.model.impl.AuthorSiteImpl;
import com.idetronic.subur.model.impl.AuthorSiteModelImpl;

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
 * The persistence implementation for the author site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorSitePersistence
 * @see AuthorSiteUtil
 * @generated
 */
public class AuthorSitePersistenceImpl extends BasePersistenceImpl<AuthorSite>
	implements AuthorSitePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AuthorSiteUtil} to access the author site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AuthorSiteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteModelImpl.FINDER_CACHE_ENABLED, AuthorSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteModelImpl.FINDER_CACHE_ENABLED, AuthorSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR = new FinderPath(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteModelImpl.FINDER_CACHE_ENABLED, AuthorSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthor",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR =
		new FinderPath(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteModelImpl.FINDER_CACHE_ENABLED, AuthorSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthor",
			new String[] { Long.class.getName() },
			AuthorSiteModelImpl.AUTHORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHOR = new FinderPath(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthor",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the author sites where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching author sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorSite> findByAuthor(long authorId)
		throws SystemException {
		return findByAuthor(authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the author sites where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of author sites
	 * @param end the upper bound of the range of author sites (not inclusive)
	 * @return the range of matching author sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorSite> findByAuthor(long authorId, int start, int end)
		throws SystemException {
		return findByAuthor(authorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the author sites where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of author sites
	 * @param end the upper bound of the range of author sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching author sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorSite> findByAuthor(long authorId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<AuthorSite> list = (List<AuthorSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AuthorSite authorSite : list) {
				if ((authorId != authorSite.getAuthorId())) {
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

			query.append(_SQL_SELECT_AUTHORSITE_WHERE);

			query.append(_FINDER_COLUMN_AUTHOR_AUTHORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AuthorSiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (!pagination) {
					list = (List<AuthorSite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AuthorSite>(list);
				}
				else {
					list = (List<AuthorSite>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first author site in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author site
	 * @throws com.idetronic.subur.NoSuchAuthorSiteException if a matching author site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite findByAuthor_First(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorSiteException, SystemException {
		AuthorSite authorSite = fetchByAuthor_First(authorId, orderByComparator);

		if (authorSite != null) {
			return authorSite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorSiteException(msg.toString());
	}

	/**
	 * Returns the first author site in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author site, or <code>null</code> if a matching author site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite fetchByAuthor_First(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AuthorSite> list = findByAuthor(authorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author site in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author site
	 * @throws com.idetronic.subur.NoSuchAuthorSiteException if a matching author site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite findByAuthor_Last(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorSiteException, SystemException {
		AuthorSite authorSite = fetchByAuthor_Last(authorId, orderByComparator);

		if (authorSite != null) {
			return authorSite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorSiteException(msg.toString());
	}

	/**
	 * Returns the last author site in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author site, or <code>null</code> if a matching author site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite fetchByAuthor_Last(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAuthor(authorId);

		if (count == 0) {
			return null;
		}

		List<AuthorSite> list = findByAuthor(authorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the author sites before and after the current author site in the ordered set where authorId = &#63;.
	 *
	 * @param authorSiteId the primary key of the current author site
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next author site
	 * @throws com.idetronic.subur.NoSuchAuthorSiteException if a author site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite[] findByAuthor_PrevAndNext(long authorSiteId,
		long authorId, OrderByComparator orderByComparator)
		throws NoSuchAuthorSiteException, SystemException {
		AuthorSite authorSite = findByPrimaryKey(authorSiteId);

		Session session = null;

		try {
			session = openSession();

			AuthorSite[] array = new AuthorSiteImpl[3];

			array[0] = getByAuthor_PrevAndNext(session, authorSite, authorId,
					orderByComparator, true);

			array[1] = authorSite;

			array[2] = getByAuthor_PrevAndNext(session, authorSite, authorId,
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

	protected AuthorSite getByAuthor_PrevAndNext(Session session,
		AuthorSite authorSite, long authorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUTHORSITE_WHERE);

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
			query.append(AuthorSiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(authorSite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AuthorSite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the author sites where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthor(long authorId) throws SystemException {
		for (AuthorSite authorSite : findByAuthor(authorId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(authorSite);
		}
	}

	/**
	 * Returns the number of author sites where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching author sites
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

			query.append(_SQL_COUNT_AUTHORSITE_WHERE);

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

	private static final String _FINDER_COLUMN_AUTHOR_AUTHORID_2 = "authorSite.authorId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_AUTHORSITE = new FinderPath(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteModelImpl.FINDER_CACHE_ENABLED, AuthorSiteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByAuthorSite",
			new String[] { Long.class.getName(), String.class.getName() },
			AuthorSiteModelImpl.AUTHORID_COLUMN_BITMASK |
			AuthorSiteModelImpl.SITENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORSITE = new FinderPath(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthorSite",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the author site where authorId = &#63; and siteName = &#63; or throws a {@link com.idetronic.subur.NoSuchAuthorSiteException} if it could not be found.
	 *
	 * @param authorId the author ID
	 * @param siteName the site name
	 * @return the matching author site
	 * @throws com.idetronic.subur.NoSuchAuthorSiteException if a matching author site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite findByAuthorSite(long authorId, String siteName)
		throws NoSuchAuthorSiteException, SystemException {
		AuthorSite authorSite = fetchByAuthorSite(authorId, siteName);

		if (authorSite == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("authorId=");
			msg.append(authorId);

			msg.append(", siteName=");
			msg.append(siteName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAuthorSiteException(msg.toString());
		}

		return authorSite;
	}

	/**
	 * Returns the author site where authorId = &#63; and siteName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param authorId the author ID
	 * @param siteName the site name
	 * @return the matching author site, or <code>null</code> if a matching author site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite fetchByAuthorSite(long authorId, String siteName)
		throws SystemException {
		return fetchByAuthorSite(authorId, siteName, true);
	}

	/**
	 * Returns the author site where authorId = &#63; and siteName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param authorId the author ID
	 * @param siteName the site name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching author site, or <code>null</code> if a matching author site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite fetchByAuthorSite(long authorId, String siteName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { authorId, siteName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_AUTHORSITE,
					finderArgs, this);
		}

		if (result instanceof AuthorSite) {
			AuthorSite authorSite = (AuthorSite)result;

			if ((authorId != authorSite.getAuthorId()) ||
					!Validator.equals(siteName, authorSite.getSiteName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_AUTHORSITE_WHERE);

			query.append(_FINDER_COLUMN_AUTHORSITE_AUTHORID_2);

			boolean bindSiteName = false;

			if (siteName == null) {
				query.append(_FINDER_COLUMN_AUTHORSITE_SITENAME_1);
			}
			else if (siteName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORSITE_SITENAME_3);
			}
			else {
				bindSiteName = true;

				query.append(_FINDER_COLUMN_AUTHORSITE_SITENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (bindSiteName) {
					qPos.add(siteName);
				}

				List<AuthorSite> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AUTHORSITE,
						finderArgs, list);
				}
				else {
					AuthorSite authorSite = list.get(0);

					result = authorSite;

					cacheResult(authorSite);

					if ((authorSite.getAuthorId() != authorId) ||
							(authorSite.getSiteName() == null) ||
							!authorSite.getSiteName().equals(siteName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AUTHORSITE,
							finderArgs, authorSite);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AUTHORSITE,
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
			return (AuthorSite)result;
		}
	}

	/**
	 * Removes the author site where authorId = &#63; and siteName = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @param siteName the site name
	 * @return the author site that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite removeByAuthorSite(long authorId, String siteName)
		throws NoSuchAuthorSiteException, SystemException {
		AuthorSite authorSite = findByAuthorSite(authorId, siteName);

		return remove(authorSite);
	}

	/**
	 * Returns the number of author sites where authorId = &#63; and siteName = &#63;.
	 *
	 * @param authorId the author ID
	 * @param siteName the site name
	 * @return the number of matching author sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthorSite(long authorId, String siteName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORSITE;

		Object[] finderArgs = new Object[] { authorId, siteName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AUTHORSITE_WHERE);

			query.append(_FINDER_COLUMN_AUTHORSITE_AUTHORID_2);

			boolean bindSiteName = false;

			if (siteName == null) {
				query.append(_FINDER_COLUMN_AUTHORSITE_SITENAME_1);
			}
			else if (siteName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORSITE_SITENAME_3);
			}
			else {
				bindSiteName = true;

				query.append(_FINDER_COLUMN_AUTHORSITE_SITENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (bindSiteName) {
					qPos.add(siteName);
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

	private static final String _FINDER_COLUMN_AUTHORSITE_AUTHORID_2 = "authorSite.authorId = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORSITE_SITENAME_1 = "authorSite.siteName IS NULL";
	private static final String _FINDER_COLUMN_AUTHORSITE_SITENAME_2 = "authorSite.siteName = ?";
	private static final String _FINDER_COLUMN_AUTHORSITE_SITENAME_3 = "(authorSite.siteName IS NULL OR authorSite.siteName = '')";

	public AuthorSitePersistenceImpl() {
		setModelClass(AuthorSite.class);
	}

	/**
	 * Caches the author site in the entity cache if it is enabled.
	 *
	 * @param authorSite the author site
	 */
	@Override
	public void cacheResult(AuthorSite authorSite) {
		EntityCacheUtil.putResult(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteImpl.class, authorSite.getPrimaryKey(), authorSite);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AUTHORSITE,
			new Object[] { authorSite.getAuthorId(), authorSite.getSiteName() },
			authorSite);

		authorSite.resetOriginalValues();
	}

	/**
	 * Caches the author sites in the entity cache if it is enabled.
	 *
	 * @param authorSites the author sites
	 */
	@Override
	public void cacheResult(List<AuthorSite> authorSites) {
		for (AuthorSite authorSite : authorSites) {
			if (EntityCacheUtil.getResult(
						AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
						AuthorSiteImpl.class, authorSite.getPrimaryKey()) == null) {
				cacheResult(authorSite);
			}
			else {
				authorSite.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all author sites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AuthorSiteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AuthorSiteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the author site.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuthorSite authorSite) {
		EntityCacheUtil.removeResult(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteImpl.class, authorSite.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(authorSite);
	}

	@Override
	public void clearCache(List<AuthorSite> authorSites) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AuthorSite authorSite : authorSites) {
			EntityCacheUtil.removeResult(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
				AuthorSiteImpl.class, authorSite.getPrimaryKey());

			clearUniqueFindersCache(authorSite);
		}
	}

	protected void cacheUniqueFindersCache(AuthorSite authorSite) {
		if (authorSite.isNew()) {
			Object[] args = new Object[] {
					authorSite.getAuthorId(), authorSite.getSiteName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AUTHORSITE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AUTHORSITE, args,
				authorSite);
		}
		else {
			AuthorSiteModelImpl authorSiteModelImpl = (AuthorSiteModelImpl)authorSite;

			if ((authorSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_AUTHORSITE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						authorSite.getAuthorId(), authorSite.getSiteName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AUTHORSITE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AUTHORSITE,
					args, authorSite);
			}
		}
	}

	protected void clearUniqueFindersCache(AuthorSite authorSite) {
		AuthorSiteModelImpl authorSiteModelImpl = (AuthorSiteModelImpl)authorSite;

		Object[] args = new Object[] {
				authorSite.getAuthorId(), authorSite.getSiteName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORSITE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AUTHORSITE, args);

		if ((authorSiteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_AUTHORSITE.getColumnBitmask()) != 0) {
			args = new Object[] {
					authorSiteModelImpl.getOriginalAuthorId(),
					authorSiteModelImpl.getOriginalSiteName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORSITE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AUTHORSITE, args);
		}
	}

	/**
	 * Creates a new author site with the primary key. Does not add the author site to the database.
	 *
	 * @param authorSiteId the primary key for the new author site
	 * @return the new author site
	 */
	@Override
	public AuthorSite create(long authorSiteId) {
		AuthorSite authorSite = new AuthorSiteImpl();

		authorSite.setNew(true);
		authorSite.setPrimaryKey(authorSiteId);

		return authorSite;
	}

	/**
	 * Removes the author site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorSiteId the primary key of the author site
	 * @return the author site that was removed
	 * @throws com.idetronic.subur.NoSuchAuthorSiteException if a author site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite remove(long authorSiteId)
		throws NoSuchAuthorSiteException, SystemException {
		return remove((Serializable)authorSiteId);
	}

	/**
	 * Removes the author site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the author site
	 * @return the author site that was removed
	 * @throws com.idetronic.subur.NoSuchAuthorSiteException if a author site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite remove(Serializable primaryKey)
		throws NoSuchAuthorSiteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AuthorSite authorSite = (AuthorSite)session.get(AuthorSiteImpl.class,
					primaryKey);

			if (authorSite == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthorSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(authorSite);
		}
		catch (NoSuchAuthorSiteException nsee) {
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
	protected AuthorSite removeImpl(AuthorSite authorSite)
		throws SystemException {
		authorSite = toUnwrappedModel(authorSite);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(authorSite)) {
				authorSite = (AuthorSite)session.get(AuthorSiteImpl.class,
						authorSite.getPrimaryKeyObj());
			}

			if (authorSite != null) {
				session.delete(authorSite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (authorSite != null) {
			clearCache(authorSite);
		}

		return authorSite;
	}

	@Override
	public AuthorSite updateImpl(
		com.idetronic.subur.model.AuthorSite authorSite)
		throws SystemException {
		authorSite = toUnwrappedModel(authorSite);

		boolean isNew = authorSite.isNew();

		AuthorSiteModelImpl authorSiteModelImpl = (AuthorSiteModelImpl)authorSite;

		Session session = null;

		try {
			session = openSession();

			if (authorSite.isNew()) {
				session.save(authorSite);

				authorSite.setNew(false);
			}
			else {
				session.merge(authorSite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AuthorSiteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((authorSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						authorSiteModelImpl.getOriginalAuthorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);

				args = new Object[] { authorSiteModelImpl.getAuthorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);
			}
		}

		EntityCacheUtil.putResult(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
			AuthorSiteImpl.class, authorSite.getPrimaryKey(), authorSite);

		clearUniqueFindersCache(authorSite);
		cacheUniqueFindersCache(authorSite);

		return authorSite;
	}

	protected AuthorSite toUnwrappedModel(AuthorSite authorSite) {
		if (authorSite instanceof AuthorSiteImpl) {
			return authorSite;
		}

		AuthorSiteImpl authorSiteImpl = new AuthorSiteImpl();

		authorSiteImpl.setNew(authorSite.isNew());
		authorSiteImpl.setPrimaryKey(authorSite.getPrimaryKey());

		authorSiteImpl.setAuthorSiteId(authorSite.getAuthorSiteId());
		authorSiteImpl.setAuthorId(authorSite.getAuthorId());
		authorSiteImpl.setSiteName(authorSite.getSiteName());
		authorSiteImpl.setSiteURL(authorSite.getSiteURL());

		return authorSiteImpl;
	}

	/**
	 * Returns the author site with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the author site
	 * @return the author site
	 * @throws com.idetronic.subur.NoSuchAuthorSiteException if a author site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthorSiteException, SystemException {
		AuthorSite authorSite = fetchByPrimaryKey(primaryKey);

		if (authorSite == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthorSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return authorSite;
	}

	/**
	 * Returns the author site with the primary key or throws a {@link com.idetronic.subur.NoSuchAuthorSiteException} if it could not be found.
	 *
	 * @param authorSiteId the primary key of the author site
	 * @return the author site
	 * @throws com.idetronic.subur.NoSuchAuthorSiteException if a author site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite findByPrimaryKey(long authorSiteId)
		throws NoSuchAuthorSiteException, SystemException {
		return findByPrimaryKey((Serializable)authorSiteId);
	}

	/**
	 * Returns the author site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the author site
	 * @return the author site, or <code>null</code> if a author site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AuthorSite authorSite = (AuthorSite)EntityCacheUtil.getResult(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
				AuthorSiteImpl.class, primaryKey);

		if (authorSite == _nullAuthorSite) {
			return null;
		}

		if (authorSite == null) {
			Session session = null;

			try {
				session = openSession();

				authorSite = (AuthorSite)session.get(AuthorSiteImpl.class,
						primaryKey);

				if (authorSite != null) {
					cacheResult(authorSite);
				}
				else {
					EntityCacheUtil.putResult(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
						AuthorSiteImpl.class, primaryKey, _nullAuthorSite);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AuthorSiteModelImpl.ENTITY_CACHE_ENABLED,
					AuthorSiteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return authorSite;
	}

	/**
	 * Returns the author site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorSiteId the primary key of the author site
	 * @return the author site, or <code>null</code> if a author site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorSite fetchByPrimaryKey(long authorSiteId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)authorSiteId);
	}

	/**
	 * Returns all the author sites.
	 *
	 * @return the author sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorSite> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the author sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of author sites
	 * @param end the upper bound of the range of author sites (not inclusive)
	 * @return the range of author sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorSite> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the author sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of author sites
	 * @param end the upper bound of the range of author sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of author sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorSite> findAll(int start, int end,
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

		List<AuthorSite> list = (List<AuthorSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUTHORSITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUTHORSITE;

				if (pagination) {
					sql = sql.concat(AuthorSiteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AuthorSite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AuthorSite>(list);
				}
				else {
					list = (List<AuthorSite>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the author sites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AuthorSite authorSite : findAll()) {
			remove(authorSite);
		}
	}

	/**
	 * Returns the number of author sites.
	 *
	 * @return the number of author sites
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

				Query q = session.createQuery(_SQL_COUNT_AUTHORSITE);

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
	 * Initializes the author site persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.AuthorSite")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AuthorSite>> listenersList = new ArrayList<ModelListener<AuthorSite>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AuthorSite>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AuthorSiteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_AUTHORSITE = "SELECT authorSite FROM AuthorSite authorSite";
	private static final String _SQL_SELECT_AUTHORSITE_WHERE = "SELECT authorSite FROM AuthorSite authorSite WHERE ";
	private static final String _SQL_COUNT_AUTHORSITE = "SELECT COUNT(authorSite) FROM AuthorSite authorSite";
	private static final String _SQL_COUNT_AUTHORSITE_WHERE = "SELECT COUNT(authorSite) FROM AuthorSite authorSite WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "authorSite.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuthorSite exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AuthorSite exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AuthorSitePersistenceImpl.class);
	private static AuthorSite _nullAuthorSite = new AuthorSiteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AuthorSite> toCacheModel() {
				return _nullAuthorSiteCacheModel;
			}
		};

	private static CacheModel<AuthorSite> _nullAuthorSiteCacheModel = new CacheModel<AuthorSite>() {
			@Override
			public AuthorSite toEntityModel() {
				return _nullAuthorSite;
			}
		};
}