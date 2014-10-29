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

import com.idetronic.portlet.NoSuchExpertiseTagException;
import com.idetronic.portlet.model.ExpertiseTag;
import com.idetronic.portlet.model.impl.ExpertiseTagImpl;
import com.idetronic.portlet.model.impl.ExpertiseTagModelImpl;

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
import com.liferay.portal.kernel.util.ArrayUtil;
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
 * The persistence implementation for the expertise tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ExpertiseTagPersistence
 * @see ExpertiseTagUtil
 * @generated
 */
public class ExpertiseTagPersistenceImpl extends BasePersistenceImpl<ExpertiseTag>
	implements ExpertiseTagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpertiseTagUtil} to access the expertise tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpertiseTagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagModelImpl.FINDER_CACHE_ENABLED, ExpertiseTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagModelImpl.FINDER_CACHE_ENABLED, ExpertiseTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGNAME = new FinderPath(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagModelImpl.FINDER_CACHE_ENABLED, ExpertiseTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTagName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGNAME =
		new FinderPath(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagModelImpl.FINDER_CACHE_ENABLED, ExpertiseTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTagName",
			new String[] { String.class.getName() },
			ExpertiseTagModelImpl.TAGNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAGNAME = new FinderPath(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTagName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TAGNAME = new FinderPath(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTagName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the expertise tags where tagName = &#63;.
	 *
	 * @param tagName the tag name
	 * @return the matching expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findByTagName(String tagName)
		throws SystemException {
		return findByTagName(tagName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expertise tags where tagName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagName the tag name
	 * @param start the lower bound of the range of expertise tags
	 * @param end the upper bound of the range of expertise tags (not inclusive)
	 * @return the range of matching expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findByTagName(String tagName, int start, int end)
		throws SystemException {
		return findByTagName(tagName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expertise tags where tagName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagName the tag name
	 * @param start the lower bound of the range of expertise tags
	 * @param end the upper bound of the range of expertise tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findByTagName(String tagName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGNAME;
			finderArgs = new Object[] { tagName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGNAME;
			finderArgs = new Object[] { tagName, start, end, orderByComparator };
		}

		List<ExpertiseTag> list = (List<ExpertiseTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExpertiseTag expertiseTag : list) {
				if (!Validator.equals(tagName, expertiseTag.getTagName())) {
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

			query.append(_SQL_SELECT_EXPERTISETAG_WHERE);

			boolean bindTagName = false;

			if (tagName == null) {
				query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_1);
			}
			else if (tagName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_3);
			}
			else {
				bindTagName = true;

				query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExpertiseTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTagName) {
					qPos.add(tagName);
				}

				if (!pagination) {
					list = (List<ExpertiseTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExpertiseTag>(list);
				}
				else {
					list = (List<ExpertiseTag>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first expertise tag in the ordered set where tagName = &#63;.
	 *
	 * @param tagName the tag name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expertise tag
	 * @throws com.idetronic.portlet.NoSuchExpertiseTagException if a matching expertise tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag findByTagName_First(String tagName,
		OrderByComparator orderByComparator)
		throws NoSuchExpertiseTagException, SystemException {
		ExpertiseTag expertiseTag = fetchByTagName_First(tagName,
				orderByComparator);

		if (expertiseTag != null) {
			return expertiseTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagName=");
		msg.append(tagName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExpertiseTagException(msg.toString());
	}

	/**
	 * Returns the first expertise tag in the ordered set where tagName = &#63;.
	 *
	 * @param tagName the tag name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expertise tag, or <code>null</code> if a matching expertise tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag fetchByTagName_First(String tagName,
		OrderByComparator orderByComparator) throws SystemException {
		List<ExpertiseTag> list = findByTagName(tagName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expertise tag in the ordered set where tagName = &#63;.
	 *
	 * @param tagName the tag name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expertise tag
	 * @throws com.idetronic.portlet.NoSuchExpertiseTagException if a matching expertise tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag findByTagName_Last(String tagName,
		OrderByComparator orderByComparator)
		throws NoSuchExpertiseTagException, SystemException {
		ExpertiseTag expertiseTag = fetchByTagName_Last(tagName,
				orderByComparator);

		if (expertiseTag != null) {
			return expertiseTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagName=");
		msg.append(tagName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExpertiseTagException(msg.toString());
	}

	/**
	 * Returns the last expertise tag in the ordered set where tagName = &#63;.
	 *
	 * @param tagName the tag name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expertise tag, or <code>null</code> if a matching expertise tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag fetchByTagName_Last(String tagName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTagName(tagName);

		if (count == 0) {
			return null;
		}

		List<ExpertiseTag> list = findByTagName(tagName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expertise tags before and after the current expertise tag in the ordered set where tagName = &#63;.
	 *
	 * @param tagId the primary key of the current expertise tag
	 * @param tagName the tag name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expertise tag
	 * @throws com.idetronic.portlet.NoSuchExpertiseTagException if a expertise tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag[] findByTagName_PrevAndNext(long tagId, String tagName,
		OrderByComparator orderByComparator)
		throws NoSuchExpertiseTagException, SystemException {
		ExpertiseTag expertiseTag = findByPrimaryKey(tagId);

		Session session = null;

		try {
			session = openSession();

			ExpertiseTag[] array = new ExpertiseTagImpl[3];

			array[0] = getByTagName_PrevAndNext(session, expertiseTag, tagName,
					orderByComparator, true);

			array[1] = expertiseTag;

			array[2] = getByTagName_PrevAndNext(session, expertiseTag, tagName,
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

	protected ExpertiseTag getByTagName_PrevAndNext(Session session,
		ExpertiseTag expertiseTag, String tagName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPERTISETAG_WHERE);

		boolean bindTagName = false;

		if (tagName == null) {
			query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_1);
		}
		else if (tagName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_3);
		}
		else {
			bindTagName = true;

			query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_2);
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
			query.append(ExpertiseTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTagName) {
			qPos.add(tagName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(expertiseTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpertiseTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the expertise tags where tagName = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagNames the tag names
	 * @return the matching expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findByTagName(String[] tagNames)
		throws SystemException {
		return findByTagName(tagNames, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the expertise tags where tagName = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagNames the tag names
	 * @param start the lower bound of the range of expertise tags
	 * @param end the upper bound of the range of expertise tags (not inclusive)
	 * @return the range of matching expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findByTagName(String[] tagNames, int start,
		int end) throws SystemException {
		return findByTagName(tagNames, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expertise tags where tagName = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagNames the tag names
	 * @param start the lower bound of the range of expertise tags
	 * @param end the upper bound of the range of expertise tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findByTagName(String[] tagNames, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((tagNames != null) && (tagNames.length == 1)) {
			return findByTagName(tagNames[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(tagNames) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(tagNames),
					
					start, end, orderByComparator
				};
		}

		List<ExpertiseTag> list = (List<ExpertiseTag>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGNAME,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExpertiseTag expertiseTag : list) {
				if (!ArrayUtil.contains(tagNames, expertiseTag.getTagName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EXPERTISETAG_WHERE);

			boolean conjunctionable = false;

			if ((tagNames == null) || (tagNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < tagNames.length; i++) {
					String tagName = tagNames[i];

					if (tagName == null) {
						query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_4);
					}
					else if (tagName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_5);
					}

					if ((i + 1) < tagNames.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExpertiseTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tagNames != null) {
					qPos.add(tagNames);
				}

				if (!pagination) {
					list = (List<ExpertiseTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExpertiseTag>(list);
				}
				else {
					list = (List<ExpertiseTag>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGNAME,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the expertise tags where tagName = &#63; from the database.
	 *
	 * @param tagName the tag name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTagName(String tagName) throws SystemException {
		for (ExpertiseTag expertiseTag : findByTagName(tagName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(expertiseTag);
		}
	}

	/**
	 * Returns the number of expertise tags where tagName = &#63;.
	 *
	 * @param tagName the tag name
	 * @return the number of matching expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTagName(String tagName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAGNAME;

		Object[] finderArgs = new Object[] { tagName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXPERTISETAG_WHERE);

			boolean bindTagName = false;

			if (tagName == null) {
				query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_1);
			}
			else if (tagName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_3);
			}
			else {
				bindTagName = true;

				query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTagName) {
					qPos.add(tagName);
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

	/**
	 * Returns the number of expertise tags where tagName = any &#63;.
	 *
	 * @param tagNames the tag names
	 * @return the number of matching expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTagName(String[] tagNames) throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(tagNames) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TAGNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EXPERTISETAG_WHERE);

			boolean conjunctionable = false;

			if ((tagNames == null) || (tagNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < tagNames.length; i++) {
					String tagName = tagNames[i];

					if (tagName == null) {
						query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_4);
					}
					else if (tagName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_TAGNAME_TAGNAME_5);
					}

					if ((i + 1) < tagNames.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (tagNames != null) {
					qPos.add(tagNames);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TAGNAME,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TAGNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TAGNAME_TAGNAME_1 = "expertiseTag.tagName IS NULL";
	private static final String _FINDER_COLUMN_TAGNAME_TAGNAME_2 = "expertiseTag.tagName = ?";
	private static final String _FINDER_COLUMN_TAGNAME_TAGNAME_3 = "(expertiseTag.tagName IS NULL OR expertiseTag.tagName = '')";
	private static final String _FINDER_COLUMN_TAGNAME_TAGNAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_TAGNAME_TAGNAME_1) + ")";
	private static final String _FINDER_COLUMN_TAGNAME_TAGNAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_TAGNAME_TAGNAME_2) + ")";
	private static final String _FINDER_COLUMN_TAGNAME_TAGNAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_TAGNAME_TAGNAME_3) + ")";

	public ExpertiseTagPersistenceImpl() {
		setModelClass(ExpertiseTag.class);
	}

	/**
	 * Caches the expertise tag in the entity cache if it is enabled.
	 *
	 * @param expertiseTag the expertise tag
	 */
	@Override
	public void cacheResult(ExpertiseTag expertiseTag) {
		EntityCacheUtil.putResult(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagImpl.class, expertiseTag.getPrimaryKey(), expertiseTag);

		expertiseTag.resetOriginalValues();
	}

	/**
	 * Caches the expertise tags in the entity cache if it is enabled.
	 *
	 * @param expertiseTags the expertise tags
	 */
	@Override
	public void cacheResult(List<ExpertiseTag> expertiseTags) {
		for (ExpertiseTag expertiseTag : expertiseTags) {
			if (EntityCacheUtil.getResult(
						ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
						ExpertiseTagImpl.class, expertiseTag.getPrimaryKey()) == null) {
				cacheResult(expertiseTag);
			}
			else {
				expertiseTag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all expertise tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExpertiseTagImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExpertiseTagImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expertise tag.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExpertiseTag expertiseTag) {
		EntityCacheUtil.removeResult(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagImpl.class, expertiseTag.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExpertiseTag> expertiseTags) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExpertiseTag expertiseTag : expertiseTags) {
			EntityCacheUtil.removeResult(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
				ExpertiseTagImpl.class, expertiseTag.getPrimaryKey());
		}
	}

	/**
	 * Creates a new expertise tag with the primary key. Does not add the expertise tag to the database.
	 *
	 * @param tagId the primary key for the new expertise tag
	 * @return the new expertise tag
	 */
	@Override
	public ExpertiseTag create(long tagId) {
		ExpertiseTag expertiseTag = new ExpertiseTagImpl();

		expertiseTag.setNew(true);
		expertiseTag.setPrimaryKey(tagId);

		return expertiseTag;
	}

	/**
	 * Removes the expertise tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the expertise tag
	 * @return the expertise tag that was removed
	 * @throws com.idetronic.portlet.NoSuchExpertiseTagException if a expertise tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag remove(long tagId)
		throws NoSuchExpertiseTagException, SystemException {
		return remove((Serializable)tagId);
	}

	/**
	 * Removes the expertise tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expertise tag
	 * @return the expertise tag that was removed
	 * @throws com.idetronic.portlet.NoSuchExpertiseTagException if a expertise tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag remove(Serializable primaryKey)
		throws NoSuchExpertiseTagException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ExpertiseTag expertiseTag = (ExpertiseTag)session.get(ExpertiseTagImpl.class,
					primaryKey);

			if (expertiseTag == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpertiseTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expertiseTag);
		}
		catch (NoSuchExpertiseTagException nsee) {
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
	protected ExpertiseTag removeImpl(ExpertiseTag expertiseTag)
		throws SystemException {
		expertiseTag = toUnwrappedModel(expertiseTag);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expertiseTag)) {
				expertiseTag = (ExpertiseTag)session.get(ExpertiseTagImpl.class,
						expertiseTag.getPrimaryKeyObj());
			}

			if (expertiseTag != null) {
				session.delete(expertiseTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expertiseTag != null) {
			clearCache(expertiseTag);
		}

		return expertiseTag;
	}

	@Override
	public ExpertiseTag updateImpl(
		com.idetronic.portlet.model.ExpertiseTag expertiseTag)
		throws SystemException {
		expertiseTag = toUnwrappedModel(expertiseTag);

		boolean isNew = expertiseTag.isNew();

		ExpertiseTagModelImpl expertiseTagModelImpl = (ExpertiseTagModelImpl)expertiseTag;

		Session session = null;

		try {
			session = openSession();

			if (expertiseTag.isNew()) {
				session.save(expertiseTag);

				expertiseTag.setNew(false);
			}
			else {
				session.merge(expertiseTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExpertiseTagModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((expertiseTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						expertiseTagModelImpl.getOriginalTagName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGNAME,
					args);

				args = new Object[] { expertiseTagModelImpl.getTagName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
			ExpertiseTagImpl.class, expertiseTag.getPrimaryKey(), expertiseTag);

		return expertiseTag;
	}

	protected ExpertiseTag toUnwrappedModel(ExpertiseTag expertiseTag) {
		if (expertiseTag instanceof ExpertiseTagImpl) {
			return expertiseTag;
		}

		ExpertiseTagImpl expertiseTagImpl = new ExpertiseTagImpl();

		expertiseTagImpl.setNew(expertiseTag.isNew());
		expertiseTagImpl.setPrimaryKey(expertiseTag.getPrimaryKey());

		expertiseTagImpl.setTagId(expertiseTag.getTagId());
		expertiseTagImpl.setGroupId(expertiseTag.getGroupId());
		expertiseTagImpl.setCompanyId(expertiseTag.getCompanyId());
		expertiseTagImpl.setUserId(expertiseTag.getUserId());
		expertiseTagImpl.setUserName(expertiseTag.getUserName());
		expertiseTagImpl.setCreateDate(expertiseTag.getCreateDate());
		expertiseTagImpl.setModifiedDate(expertiseTag.getModifiedDate());
		expertiseTagImpl.setTagName(expertiseTag.getTagName());
		expertiseTagImpl.setUserCount(expertiseTag.getUserCount());

		return expertiseTagImpl;
	}

	/**
	 * Returns the expertise tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the expertise tag
	 * @return the expertise tag
	 * @throws com.idetronic.portlet.NoSuchExpertiseTagException if a expertise tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpertiseTagException, SystemException {
		ExpertiseTag expertiseTag = fetchByPrimaryKey(primaryKey);

		if (expertiseTag == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpertiseTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expertiseTag;
	}

	/**
	 * Returns the expertise tag with the primary key or throws a {@link com.idetronic.portlet.NoSuchExpertiseTagException} if it could not be found.
	 *
	 * @param tagId the primary key of the expertise tag
	 * @return the expertise tag
	 * @throws com.idetronic.portlet.NoSuchExpertiseTagException if a expertise tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag findByPrimaryKey(long tagId)
		throws NoSuchExpertiseTagException, SystemException {
		return findByPrimaryKey((Serializable)tagId);
	}

	/**
	 * Returns the expertise tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expertise tag
	 * @return the expertise tag, or <code>null</code> if a expertise tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ExpertiseTag expertiseTag = (ExpertiseTag)EntityCacheUtil.getResult(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
				ExpertiseTagImpl.class, primaryKey);

		if (expertiseTag == _nullExpertiseTag) {
			return null;
		}

		if (expertiseTag == null) {
			Session session = null;

			try {
				session = openSession();

				expertiseTag = (ExpertiseTag)session.get(ExpertiseTagImpl.class,
						primaryKey);

				if (expertiseTag != null) {
					cacheResult(expertiseTag);
				}
				else {
					EntityCacheUtil.putResult(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
						ExpertiseTagImpl.class, primaryKey, _nullExpertiseTag);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ExpertiseTagModelImpl.ENTITY_CACHE_ENABLED,
					ExpertiseTagImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expertiseTag;
	}

	/**
	 * Returns the expertise tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagId the primary key of the expertise tag
	 * @return the expertise tag, or <code>null</code> if a expertise tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExpertiseTag fetchByPrimaryKey(long tagId) throws SystemException {
		return fetchByPrimaryKey((Serializable)tagId);
	}

	/**
	 * Returns all the expertise tags.
	 *
	 * @return the expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expertise tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expertise tags
	 * @param end the upper bound of the range of expertise tags (not inclusive)
	 * @return the range of expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the expertise tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expertise tags
	 * @param end the upper bound of the range of expertise tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expertise tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExpertiseTag> findAll(int start, int end,
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

		List<ExpertiseTag> list = (List<ExpertiseTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXPERTISETAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPERTISETAG;

				if (pagination) {
					sql = sql.concat(ExpertiseTagModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExpertiseTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExpertiseTag>(list);
				}
				else {
					list = (List<ExpertiseTag>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the expertise tags from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ExpertiseTag expertiseTag : findAll()) {
			remove(expertiseTag);
		}
	}

	/**
	 * Returns the number of expertise tags.
	 *
	 * @return the number of expertise tags
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

				Query q = session.createQuery(_SQL_COUNT_EXPERTISETAG);

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
	 * Initializes the expertise tag persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.portlet.model.ExpertiseTag")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ExpertiseTag>> listenersList = new ArrayList<ModelListener<ExpertiseTag>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ExpertiseTag>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExpertiseTagImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EXPERTISETAG = "SELECT expertiseTag FROM ExpertiseTag expertiseTag";
	private static final String _SQL_SELECT_EXPERTISETAG_WHERE = "SELECT expertiseTag FROM ExpertiseTag expertiseTag WHERE ";
	private static final String _SQL_COUNT_EXPERTISETAG = "SELECT COUNT(expertiseTag) FROM ExpertiseTag expertiseTag";
	private static final String _SQL_COUNT_EXPERTISETAG_WHERE = "SELECT COUNT(expertiseTag) FROM ExpertiseTag expertiseTag WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expertiseTag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExpertiseTag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExpertiseTag exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExpertiseTagPersistenceImpl.class);
	private static ExpertiseTag _nullExpertiseTag = new ExpertiseTagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ExpertiseTag> toCacheModel() {
				return _nullExpertiseTagCacheModel;
			}
		};

	private static CacheModel<ExpertiseTag> _nullExpertiseTagCacheModel = new CacheModel<ExpertiseTag>() {
			@Override
			public ExpertiseTag toEntityModel() {
				return _nullExpertiseTag;
			}
		};
}