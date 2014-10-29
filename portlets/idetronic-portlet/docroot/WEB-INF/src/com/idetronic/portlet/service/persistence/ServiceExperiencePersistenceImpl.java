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

import com.idetronic.portlet.NoSuchServiceExperienceException;
import com.idetronic.portlet.model.ServiceExperience;
import com.idetronic.portlet.model.impl.ServiceExperienceImpl;
import com.idetronic.portlet.model.impl.ServiceExperienceModelImpl;

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
 * The persistence implementation for the service experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ServiceExperiencePersistence
 * @see ServiceExperienceUtil
 * @generated
 */
public class ServiceExperiencePersistenceImpl extends BasePersistenceImpl<ServiceExperience>
	implements ServiceExperiencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceExperienceUtil} to access the service experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceExperienceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceModelImpl.FINDER_CACHE_ENABLED,
			ServiceExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceModelImpl.FINDER_CACHE_ENABLED,
			ServiceExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID = new FinderPath(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceModelImpl.FINDER_CACHE_ENABLED,
			ServiceExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID =
		new FinderPath(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceModelImpl.FINDER_CACHE_ENABLED,
			ServiceExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyUserId",
			new String[] { Long.class.getName() },
			ServiceExperienceModelImpl.USERID_COLUMN_BITMASK |
			ServiceExperienceModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYUSERID = new FinderPath(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the service experiences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching service experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceExperience> findBybyUserId(long userId)
		throws SystemException {
		return findBybyUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service experiences where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of service experiences
	 * @param end the upper bound of the range of service experiences (not inclusive)
	 * @return the range of matching service experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceExperience> findBybyUserId(long userId, int start,
		int end) throws SystemException {
		return findBybyUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service experiences where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of service experiences
	 * @param end the upper bound of the range of service experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceExperience> findBybyUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYUSERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<ServiceExperience> list = (List<ServiceExperience>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceExperience serviceExperience : list) {
				if ((userId != serviceExperience.getUserId())) {
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

			query.append(_SQL_SELECT_SERVICEEXPERIENCE_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<ServiceExperience>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceExperience>(list);
				}
				else {
					list = (List<ServiceExperience>)QueryUtil.list(q,
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
	 * Returns the first service experience in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service experience
	 * @throws com.idetronic.portlet.NoSuchServiceExperienceException if a matching service experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience findBybyUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceExperienceException, SystemException {
		ServiceExperience serviceExperience = fetchBybyUserId_First(userId,
				orderByComparator);

		if (serviceExperience != null) {
			return serviceExperience;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceExperienceException(msg.toString());
	}

	/**
	 * Returns the first service experience in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service experience, or <code>null</code> if a matching service experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience fetchBybyUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceExperience> list = findBybyUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service experience in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service experience
	 * @throws com.idetronic.portlet.NoSuchServiceExperienceException if a matching service experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience findBybyUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceExperienceException, SystemException {
		ServiceExperience serviceExperience = fetchBybyUserId_Last(userId,
				orderByComparator);

		if (serviceExperience != null) {
			return serviceExperience;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceExperienceException(msg.toString());
	}

	/**
	 * Returns the last service experience in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service experience, or <code>null</code> if a matching service experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience fetchBybyUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyUserId(userId);

		if (count == 0) {
			return null;
		}

		List<ServiceExperience> list = findBybyUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service experiences before and after the current service experience in the ordered set where userId = &#63;.
	 *
	 * @param serviceExperienceId the primary key of the current service experience
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service experience
	 * @throws com.idetronic.portlet.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience[] findBybyUserId_PrevAndNext(
		long serviceExperienceId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceExperienceException, SystemException {
		ServiceExperience serviceExperience = findByPrimaryKey(serviceExperienceId);

		Session session = null;

		try {
			session = openSession();

			ServiceExperience[] array = new ServiceExperienceImpl[3];

			array[0] = getBybyUserId_PrevAndNext(session, serviceExperience,
					userId, orderByComparator, true);

			array[1] = serviceExperience;

			array[2] = getBybyUserId_PrevAndNext(session, serviceExperience,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceExperience getBybyUserId_PrevAndNext(Session session,
		ServiceExperience serviceExperience, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEEXPERIENCE_WHERE);

		query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

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
			query.append(ServiceExperienceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceExperience);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceExperience> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service experiences where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyUserId(long userId) throws SystemException {
		for (ServiceExperience serviceExperience : findBybyUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceExperience);
		}
	}

	/**
	 * Returns the number of service experiences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching service experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYUSERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEEXPERIENCE_WHERE);

			query.append(_FINDER_COLUMN_BYUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_BYUSERID_USERID_2 = "serviceExperience.userId = ?";

	public ServiceExperiencePersistenceImpl() {
		setModelClass(ServiceExperience.class);
	}

	/**
	 * Caches the service experience in the entity cache if it is enabled.
	 *
	 * @param serviceExperience the service experience
	 */
	@Override
	public void cacheResult(ServiceExperience serviceExperience) {
		EntityCacheUtil.putResult(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceImpl.class, serviceExperience.getPrimaryKey(),
			serviceExperience);

		serviceExperience.resetOriginalValues();
	}

	/**
	 * Caches the service experiences in the entity cache if it is enabled.
	 *
	 * @param serviceExperiences the service experiences
	 */
	@Override
	public void cacheResult(List<ServiceExperience> serviceExperiences) {
		for (ServiceExperience serviceExperience : serviceExperiences) {
			if (EntityCacheUtil.getResult(
						ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
						ServiceExperienceImpl.class,
						serviceExperience.getPrimaryKey()) == null) {
				cacheResult(serviceExperience);
			}
			else {
				serviceExperience.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service experiences.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceExperienceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceExperienceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service experience.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceExperience serviceExperience) {
		EntityCacheUtil.removeResult(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceImpl.class, serviceExperience.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServiceExperience> serviceExperiences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceExperience serviceExperience : serviceExperiences) {
			EntityCacheUtil.removeResult(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
				ServiceExperienceImpl.class, serviceExperience.getPrimaryKey());
		}
	}

	/**
	 * Creates a new service experience with the primary key. Does not add the service experience to the database.
	 *
	 * @param serviceExperienceId the primary key for the new service experience
	 * @return the new service experience
	 */
	@Override
	public ServiceExperience create(long serviceExperienceId) {
		ServiceExperience serviceExperience = new ServiceExperienceImpl();

		serviceExperience.setNew(true);
		serviceExperience.setPrimaryKey(serviceExperienceId);

		return serviceExperience;
	}

	/**
	 * Removes the service experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceExperienceId the primary key of the service experience
	 * @return the service experience that was removed
	 * @throws com.idetronic.portlet.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience remove(long serviceExperienceId)
		throws NoSuchServiceExperienceException, SystemException {
		return remove((Serializable)serviceExperienceId);
	}

	/**
	 * Removes the service experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service experience
	 * @return the service experience that was removed
	 * @throws com.idetronic.portlet.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience remove(Serializable primaryKey)
		throws NoSuchServiceExperienceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceExperience serviceExperience = (ServiceExperience)session.get(ServiceExperienceImpl.class,
					primaryKey);

			if (serviceExperience == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceExperienceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceExperience);
		}
		catch (NoSuchServiceExperienceException nsee) {
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
	protected ServiceExperience removeImpl(ServiceExperience serviceExperience)
		throws SystemException {
		serviceExperience = toUnwrappedModel(serviceExperience);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceExperience)) {
				serviceExperience = (ServiceExperience)session.get(ServiceExperienceImpl.class,
						serviceExperience.getPrimaryKeyObj());
			}

			if (serviceExperience != null) {
				session.delete(serviceExperience);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serviceExperience != null) {
			clearCache(serviceExperience);
		}

		return serviceExperience;
	}

	@Override
	public ServiceExperience updateImpl(
		com.idetronic.portlet.model.ServiceExperience serviceExperience)
		throws SystemException {
		serviceExperience = toUnwrappedModel(serviceExperience);

		boolean isNew = serviceExperience.isNew();

		ServiceExperienceModelImpl serviceExperienceModelImpl = (ServiceExperienceModelImpl)serviceExperience;

		Session session = null;

		try {
			session = openSession();

			if (serviceExperience.isNew()) {
				session.save(serviceExperience);

				serviceExperience.setNew(false);
			}
			else {
				session.merge(serviceExperience);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceExperienceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceExperienceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceExperienceModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);

				args = new Object[] { serviceExperienceModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ServiceExperienceImpl.class, serviceExperience.getPrimaryKey(),
			serviceExperience);

		return serviceExperience;
	}

	protected ServiceExperience toUnwrappedModel(
		ServiceExperience serviceExperience) {
		if (serviceExperience instanceof ServiceExperienceImpl) {
			return serviceExperience;
		}

		ServiceExperienceImpl serviceExperienceImpl = new ServiceExperienceImpl();

		serviceExperienceImpl.setNew(serviceExperience.isNew());
		serviceExperienceImpl.setPrimaryKey(serviceExperience.getPrimaryKey());

		serviceExperienceImpl.setServiceExperienceId(serviceExperience.getServiceExperienceId());
		serviceExperienceImpl.setCompanyId(serviceExperience.getCompanyId());
		serviceExperienceImpl.setUserId(serviceExperience.getUserId());
		serviceExperienceImpl.setUserName(serviceExperience.getUserName());
		serviceExperienceImpl.setCreateDate(serviceExperience.getCreateDate());
		serviceExperienceImpl.setModifiedDate(serviceExperience.getModifiedDate());
		serviceExperienceImpl.setStartDate(serviceExperience.getStartDate());
		serviceExperienceImpl.setTitle(serviceExperience.getTitle());
		serviceExperienceImpl.setEndDate(serviceExperience.getEndDate());
		serviceExperienceImpl.setServiceData(serviceExperience.getServiceData());
		serviceExperienceImpl.setStatus(serviceExperience.getStatus());

		return serviceExperienceImpl;
	}

	/**
	 * Returns the service experience with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service experience
	 * @return the service experience
	 * @throws com.idetronic.portlet.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceExperienceException, SystemException {
		ServiceExperience serviceExperience = fetchByPrimaryKey(primaryKey);

		if (serviceExperience == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceExperienceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return serviceExperience;
	}

	/**
	 * Returns the service experience with the primary key or throws a {@link com.idetronic.portlet.NoSuchServiceExperienceException} if it could not be found.
	 *
	 * @param serviceExperienceId the primary key of the service experience
	 * @return the service experience
	 * @throws com.idetronic.portlet.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience findByPrimaryKey(long serviceExperienceId)
		throws NoSuchServiceExperienceException, SystemException {
		return findByPrimaryKey((Serializable)serviceExperienceId);
	}

	/**
	 * Returns the service experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service experience
	 * @return the service experience, or <code>null</code> if a service experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ServiceExperience serviceExperience = (ServiceExperience)EntityCacheUtil.getResult(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
				ServiceExperienceImpl.class, primaryKey);

		if (serviceExperience == _nullServiceExperience) {
			return null;
		}

		if (serviceExperience == null) {
			Session session = null;

			try {
				session = openSession();

				serviceExperience = (ServiceExperience)session.get(ServiceExperienceImpl.class,
						primaryKey);

				if (serviceExperience != null) {
					cacheResult(serviceExperience);
				}
				else {
					EntityCacheUtil.putResult(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
						ServiceExperienceImpl.class, primaryKey,
						_nullServiceExperience);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ServiceExperienceModelImpl.ENTITY_CACHE_ENABLED,
					ServiceExperienceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serviceExperience;
	}

	/**
	 * Returns the service experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceExperienceId the primary key of the service experience
	 * @return the service experience, or <code>null</code> if a service experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceExperience fetchByPrimaryKey(long serviceExperienceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)serviceExperienceId);
	}

	/**
	 * Returns all the service experiences.
	 *
	 * @return the service experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceExperience> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service experiences
	 * @param end the upper bound of the range of service experiences (not inclusive)
	 * @return the range of service experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceExperience> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service experiences
	 * @param end the upper bound of the range of service experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceExperience> findAll(int start, int end,
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

		List<ServiceExperience> list = (List<ServiceExperience>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICEEXPERIENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEEXPERIENCE;

				if (pagination) {
					sql = sql.concat(ServiceExperienceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceExperience>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceExperience>(list);
				}
				else {
					list = (List<ServiceExperience>)QueryUtil.list(q,
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
	 * Removes all the service experiences from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ServiceExperience serviceExperience : findAll()) {
			remove(serviceExperience);
		}
	}

	/**
	 * Returns the number of service experiences.
	 *
	 * @return the number of service experiences
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

				Query q = session.createQuery(_SQL_COUNT_SERVICEEXPERIENCE);

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
	 * Initializes the service experience persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.portlet.model.ServiceExperience")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceExperience>> listenersList = new ArrayList<ModelListener<ServiceExperience>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceExperience>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceExperienceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SERVICEEXPERIENCE = "SELECT serviceExperience FROM ServiceExperience serviceExperience";
	private static final String _SQL_SELECT_SERVICEEXPERIENCE_WHERE = "SELECT serviceExperience FROM ServiceExperience serviceExperience WHERE ";
	private static final String _SQL_COUNT_SERVICEEXPERIENCE = "SELECT COUNT(serviceExperience) FROM ServiceExperience serviceExperience";
	private static final String _SQL_COUNT_SERVICEEXPERIENCE_WHERE = "SELECT COUNT(serviceExperience) FROM ServiceExperience serviceExperience WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceExperience.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceExperience exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceExperience exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceExperiencePersistenceImpl.class);
	private static ServiceExperience _nullServiceExperience = new ServiceExperienceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceExperience> toCacheModel() {
				return _nullServiceExperienceCacheModel;
			}
		};

	private static CacheModel<ServiceExperience> _nullServiceExperienceCacheModel =
		new CacheModel<ServiceExperience>() {
			@Override
			public ServiceExperience toEntityModel() {
				return _nullServiceExperience;
			}
		};
}