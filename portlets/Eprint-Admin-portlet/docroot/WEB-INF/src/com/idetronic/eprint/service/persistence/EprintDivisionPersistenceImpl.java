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

import com.idetronic.eprint.NoSuchEprintDivisionException;
import com.idetronic.eprint.model.EprintDivision;
import com.idetronic.eprint.model.impl.EprintDivisionImpl;
import com.idetronic.eprint.model.impl.EprintDivisionModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the eprint division service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintDivisionPersistence
 * @see EprintDivisionUtil
 * @generated
 */
public class EprintDivisionPersistenceImpl extends BasePersistenceImpl<EprintDivision>
	implements EprintDivisionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EprintDivisionUtil} to access the eprint division persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EprintDivisionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EprintDivisionModelImpl.FINDER_CACHE_ENABLED,
			EprintDivisionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EprintDivisionModelImpl.FINDER_CACHE_ENABLED,
			EprintDivisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EprintDivisionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EprintDivisionPersistenceImpl() {
		setModelClass(EprintDivision.class);
	}

	/**
	 * Caches the eprint division in the entity cache if it is enabled.
	 *
	 * @param eprintDivision the eprint division
	 */
	@Override
	public void cacheResult(EprintDivision eprintDivision) {
		EntityCacheUtil.putResult(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EprintDivisionImpl.class, eprintDivision.getPrimaryKey(),
			eprintDivision);

		eprintDivision.resetOriginalValues();
	}

	/**
	 * Caches the eprint divisions in the entity cache if it is enabled.
	 *
	 * @param eprintDivisions the eprint divisions
	 */
	@Override
	public void cacheResult(List<EprintDivision> eprintDivisions) {
		for (EprintDivision eprintDivision : eprintDivisions) {
			if (EntityCacheUtil.getResult(
						EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
						EprintDivisionImpl.class, eprintDivision.getPrimaryKey()) == null) {
				cacheResult(eprintDivision);
			}
			else {
				eprintDivision.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all eprint divisions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EprintDivisionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EprintDivisionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the eprint division.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EprintDivision eprintDivision) {
		EntityCacheUtil.removeResult(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EprintDivisionImpl.class, eprintDivision.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EprintDivision> eprintDivisions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EprintDivision eprintDivision : eprintDivisions) {
			EntityCacheUtil.removeResult(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
				EprintDivisionImpl.class, eprintDivision.getPrimaryKey());
		}
	}

	/**
	 * Creates a new eprint division with the primary key. Does not add the eprint division to the database.
	 *
	 * @param eprintDivisionPK the primary key for the new eprint division
	 * @return the new eprint division
	 */
	@Override
	public EprintDivision create(EprintDivisionPK eprintDivisionPK) {
		EprintDivision eprintDivision = new EprintDivisionImpl();

		eprintDivision.setNew(true);
		eprintDivision.setPrimaryKey(eprintDivisionPK);

		return eprintDivision;
	}

	/**
	 * Removes the eprint division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eprintDivisionPK the primary key of the eprint division
	 * @return the eprint division that was removed
	 * @throws com.idetronic.eprint.NoSuchEprintDivisionException if a eprint division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintDivision remove(EprintDivisionPK eprintDivisionPK)
		throws NoSuchEprintDivisionException, SystemException {
		return remove((Serializable)eprintDivisionPK);
	}

	/**
	 * Removes the eprint division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the eprint division
	 * @return the eprint division that was removed
	 * @throws com.idetronic.eprint.NoSuchEprintDivisionException if a eprint division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintDivision remove(Serializable primaryKey)
		throws NoSuchEprintDivisionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EprintDivision eprintDivision = (EprintDivision)session.get(EprintDivisionImpl.class,
					primaryKey);

			if (eprintDivision == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEprintDivisionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eprintDivision);
		}
		catch (NoSuchEprintDivisionException nsee) {
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
	protected EprintDivision removeImpl(EprintDivision eprintDivision)
		throws SystemException {
		eprintDivision = toUnwrappedModel(eprintDivision);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eprintDivision)) {
				eprintDivision = (EprintDivision)session.get(EprintDivisionImpl.class,
						eprintDivision.getPrimaryKeyObj());
			}

			if (eprintDivision != null) {
				session.delete(eprintDivision);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eprintDivision != null) {
			clearCache(eprintDivision);
		}

		return eprintDivision;
	}

	@Override
	public EprintDivision updateImpl(
		com.idetronic.eprint.model.EprintDivision eprintDivision)
		throws SystemException {
		eprintDivision = toUnwrappedModel(eprintDivision);

		boolean isNew = eprintDivision.isNew();

		Session session = null;

		try {
			session = openSession();

			if (eprintDivision.isNew()) {
				session.save(eprintDivision);

				eprintDivision.setNew(false);
			}
			else {
				session.merge(eprintDivision);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
			EprintDivisionImpl.class, eprintDivision.getPrimaryKey(),
			eprintDivision);

		return eprintDivision;
	}

	protected EprintDivision toUnwrappedModel(EprintDivision eprintDivision) {
		if (eprintDivision instanceof EprintDivisionImpl) {
			return eprintDivision;
		}

		EprintDivisionImpl eprintDivisionImpl = new EprintDivisionImpl();

		eprintDivisionImpl.setNew(eprintDivision.isNew());
		eprintDivisionImpl.setPrimaryKey(eprintDivision.getPrimaryKey());

		eprintDivisionImpl.setEprintId(eprintDivision.getEprintId());
		eprintDivisionImpl.setDivisionId(eprintDivision.getDivisionId());
		eprintDivisionImpl.setDivisionName(eprintDivision.getDivisionName());

		return eprintDivisionImpl;
	}

	/**
	 * Returns the eprint division with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprint division
	 * @return the eprint division
	 * @throws com.idetronic.eprint.NoSuchEprintDivisionException if a eprint division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintDivision findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEprintDivisionException, SystemException {
		EprintDivision eprintDivision = fetchByPrimaryKey(primaryKey);

		if (eprintDivision == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEprintDivisionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eprintDivision;
	}

	/**
	 * Returns the eprint division with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintDivisionException} if it could not be found.
	 *
	 * @param eprintDivisionPK the primary key of the eprint division
	 * @return the eprint division
	 * @throws com.idetronic.eprint.NoSuchEprintDivisionException if a eprint division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintDivision findByPrimaryKey(EprintDivisionPK eprintDivisionPK)
		throws NoSuchEprintDivisionException, SystemException {
		return findByPrimaryKey((Serializable)eprintDivisionPK);
	}

	/**
	 * Returns the eprint division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprint division
	 * @return the eprint division, or <code>null</code> if a eprint division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintDivision fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EprintDivision eprintDivision = (EprintDivision)EntityCacheUtil.getResult(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
				EprintDivisionImpl.class, primaryKey);

		if (eprintDivision == _nullEprintDivision) {
			return null;
		}

		if (eprintDivision == null) {
			Session session = null;

			try {
				session = openSession();

				eprintDivision = (EprintDivision)session.get(EprintDivisionImpl.class,
						primaryKey);

				if (eprintDivision != null) {
					cacheResult(eprintDivision);
				}
				else {
					EntityCacheUtil.putResult(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
						EprintDivisionImpl.class, primaryKey,
						_nullEprintDivision);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EprintDivisionModelImpl.ENTITY_CACHE_ENABLED,
					EprintDivisionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eprintDivision;
	}

	/**
	 * Returns the eprint division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eprintDivisionPK the primary key of the eprint division
	 * @return the eprint division, or <code>null</code> if a eprint division with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintDivision fetchByPrimaryKey(EprintDivisionPK eprintDivisionPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eprintDivisionPK);
	}

	/**
	 * Returns all the eprint divisions.
	 *
	 * @return the eprint divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EprintDivision> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprint divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint divisions
	 * @param end the upper bound of the range of eprint divisions (not inclusive)
	 * @return the range of eprint divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EprintDivision> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprint divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintDivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint divisions
	 * @param end the upper bound of the range of eprint divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eprint divisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EprintDivision> findAll(int start, int end,
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

		List<EprintDivision> list = (List<EprintDivision>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EPRINTDIVISION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EPRINTDIVISION;

				if (pagination) {
					sql = sql.concat(EprintDivisionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EprintDivision>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EprintDivision>(list);
				}
				else {
					list = (List<EprintDivision>)QueryUtil.list(q,
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
	 * Removes all the eprint divisions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EprintDivision eprintDivision : findAll()) {
			remove(eprintDivision);
		}
	}

	/**
	 * Returns the number of eprint divisions.
	 *
	 * @return the number of eprint divisions
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

				Query q = session.createQuery(_SQL_COUNT_EPRINTDIVISION);

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
	 * Initializes the eprint division persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eprint.model.EprintDivision")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EprintDivision>> listenersList = new ArrayList<ModelListener<EprintDivision>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EprintDivision>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EprintDivisionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EPRINTDIVISION = "SELECT eprintDivision FROM EprintDivision eprintDivision";
	private static final String _SQL_COUNT_EPRINTDIVISION = "SELECT COUNT(eprintDivision) FROM EprintDivision eprintDivision";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eprintDivision.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EprintDivision exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EprintDivisionPersistenceImpl.class);
	private static EprintDivision _nullEprintDivision = new EprintDivisionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EprintDivision> toCacheModel() {
				return _nullEprintDivisionCacheModel;
			}
		};

	private static CacheModel<EprintDivision> _nullEprintDivisionCacheModel = new CacheModel<EprintDivision>() {
			@Override
			public EprintDivision toEntityModel() {
				return _nullEprintDivision;
			}
		};
}