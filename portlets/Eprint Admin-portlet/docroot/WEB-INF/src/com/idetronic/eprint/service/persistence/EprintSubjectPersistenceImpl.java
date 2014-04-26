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

import com.idetronic.eprint.NoSuchEprintSubjectException;
import com.idetronic.eprint.model.EprintSubject;
import com.idetronic.eprint.model.impl.EprintSubjectImpl;
import com.idetronic.eprint.model.impl.EprintSubjectModelImpl;

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
 * The persistence implementation for the eprint subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintSubjectPersistence
 * @see EprintSubjectUtil
 * @generated
 */
public class EprintSubjectPersistenceImpl extends BasePersistenceImpl<EprintSubject>
	implements EprintSubjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EprintSubjectUtil} to access the eprint subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EprintSubjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
			EprintSubjectModelImpl.FINDER_CACHE_ENABLED,
			EprintSubjectImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
			EprintSubjectModelImpl.FINDER_CACHE_ENABLED,
			EprintSubjectImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
			EprintSubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EprintSubjectPersistenceImpl() {
		setModelClass(EprintSubject.class);
	}

	/**
	 * Caches the eprint subject in the entity cache if it is enabled.
	 *
	 * @param eprintSubject the eprint subject
	 */
	@Override
	public void cacheResult(EprintSubject eprintSubject) {
		EntityCacheUtil.putResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
			EprintSubjectImpl.class, eprintSubject.getPrimaryKey(),
			eprintSubject);

		eprintSubject.resetOriginalValues();
	}

	/**
	 * Caches the eprint subjects in the entity cache if it is enabled.
	 *
	 * @param eprintSubjects the eprint subjects
	 */
	@Override
	public void cacheResult(List<EprintSubject> eprintSubjects) {
		for (EprintSubject eprintSubject : eprintSubjects) {
			if (EntityCacheUtil.getResult(
						EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
						EprintSubjectImpl.class, eprintSubject.getPrimaryKey()) == null) {
				cacheResult(eprintSubject);
			}
			else {
				eprintSubject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all eprint subjects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EprintSubjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EprintSubjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the eprint subject.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EprintSubject eprintSubject) {
		EntityCacheUtil.removeResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
			EprintSubjectImpl.class, eprintSubject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EprintSubject> eprintSubjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EprintSubject eprintSubject : eprintSubjects) {
			EntityCacheUtil.removeResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
				EprintSubjectImpl.class, eprintSubject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new eprint subject with the primary key. Does not add the eprint subject to the database.
	 *
	 * @param eprintSubjectPK the primary key for the new eprint subject
	 * @return the new eprint subject
	 */
	@Override
	public EprintSubject create(EprintSubjectPK eprintSubjectPK) {
		EprintSubject eprintSubject = new EprintSubjectImpl();

		eprintSubject.setNew(true);
		eprintSubject.setPrimaryKey(eprintSubjectPK);

		return eprintSubject;
	}

	/**
	 * Removes the eprint subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eprintSubjectPK the primary key of the eprint subject
	 * @return the eprint subject that was removed
	 * @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintSubject remove(EprintSubjectPK eprintSubjectPK)
		throws NoSuchEprintSubjectException, SystemException {
		return remove((Serializable)eprintSubjectPK);
	}

	/**
	 * Removes the eprint subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the eprint subject
	 * @return the eprint subject that was removed
	 * @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintSubject remove(Serializable primaryKey)
		throws NoSuchEprintSubjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EprintSubject eprintSubject = (EprintSubject)session.get(EprintSubjectImpl.class,
					primaryKey);

			if (eprintSubject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEprintSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eprintSubject);
		}
		catch (NoSuchEprintSubjectException nsee) {
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
	protected EprintSubject removeImpl(EprintSubject eprintSubject)
		throws SystemException {
		eprintSubject = toUnwrappedModel(eprintSubject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eprintSubject)) {
				eprintSubject = (EprintSubject)session.get(EprintSubjectImpl.class,
						eprintSubject.getPrimaryKeyObj());
			}

			if (eprintSubject != null) {
				session.delete(eprintSubject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eprintSubject != null) {
			clearCache(eprintSubject);
		}

		return eprintSubject;
	}

	@Override
	public EprintSubject updateImpl(
		com.idetronic.eprint.model.EprintSubject eprintSubject)
		throws SystemException {
		eprintSubject = toUnwrappedModel(eprintSubject);

		boolean isNew = eprintSubject.isNew();

		Session session = null;

		try {
			session = openSession();

			if (eprintSubject.isNew()) {
				session.save(eprintSubject);

				eprintSubject.setNew(false);
			}
			else {
				session.merge(eprintSubject);
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

		EntityCacheUtil.putResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
			EprintSubjectImpl.class, eprintSubject.getPrimaryKey(),
			eprintSubject);

		return eprintSubject;
	}

	protected EprintSubject toUnwrappedModel(EprintSubject eprintSubject) {
		if (eprintSubject instanceof EprintSubjectImpl) {
			return eprintSubject;
		}

		EprintSubjectImpl eprintSubjectImpl = new EprintSubjectImpl();

		eprintSubjectImpl.setNew(eprintSubject.isNew());
		eprintSubjectImpl.setPrimaryKey(eprintSubject.getPrimaryKey());

		eprintSubjectImpl.setEprintId(eprintSubject.getEprintId());
		eprintSubjectImpl.setSubjectId(eprintSubject.getSubjectId());
		eprintSubjectImpl.setSubjectName(eprintSubject.getSubjectName());

		return eprintSubjectImpl;
	}

	/**
	 * Returns the eprint subject with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprint subject
	 * @return the eprint subject
	 * @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintSubject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEprintSubjectException, SystemException {
		EprintSubject eprintSubject = fetchByPrimaryKey(primaryKey);

		if (eprintSubject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEprintSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eprintSubject;
	}

	/**
	 * Returns the eprint subject with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintSubjectException} if it could not be found.
	 *
	 * @param eprintSubjectPK the primary key of the eprint subject
	 * @return the eprint subject
	 * @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintSubject findByPrimaryKey(EprintSubjectPK eprintSubjectPK)
		throws NoSuchEprintSubjectException, SystemException {
		return findByPrimaryKey((Serializable)eprintSubjectPK);
	}

	/**
	 * Returns the eprint subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprint subject
	 * @return the eprint subject, or <code>null</code> if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintSubject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EprintSubject eprintSubject = (EprintSubject)EntityCacheUtil.getResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
				EprintSubjectImpl.class, primaryKey);

		if (eprintSubject == _nullEprintSubject) {
			return null;
		}

		if (eprintSubject == null) {
			Session session = null;

			try {
				session = openSession();

				eprintSubject = (EprintSubject)session.get(EprintSubjectImpl.class,
						primaryKey);

				if (eprintSubject != null) {
					cacheResult(eprintSubject);
				}
				else {
					EntityCacheUtil.putResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
						EprintSubjectImpl.class, primaryKey, _nullEprintSubject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
					EprintSubjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eprintSubject;
	}

	/**
	 * Returns the eprint subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eprintSubjectPK the primary key of the eprint subject
	 * @return the eprint subject, or <code>null</code> if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintSubject fetchByPrimaryKey(EprintSubjectPK eprintSubjectPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eprintSubjectPK);
	}

	/**
	 * Returns all the eprint subjects.
	 *
	 * @return the eprint subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EprintSubject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprint subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint subjects
	 * @param end the upper bound of the range of eprint subjects (not inclusive)
	 * @return the range of eprint subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EprintSubject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprint subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint subjects
	 * @param end the upper bound of the range of eprint subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eprint subjects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EprintSubject> findAll(int start, int end,
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

		List<EprintSubject> list = (List<EprintSubject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EPRINTSUBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EPRINTSUBJECT;

				if (pagination) {
					sql = sql.concat(EprintSubjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EprintSubject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EprintSubject>(list);
				}
				else {
					list = (List<EprintSubject>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the eprint subjects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EprintSubject eprintSubject : findAll()) {
			remove(eprintSubject);
		}
	}

	/**
	 * Returns the number of eprint subjects.
	 *
	 * @return the number of eprint subjects
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

				Query q = session.createQuery(_SQL_COUNT_EPRINTSUBJECT);

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
	 * Initializes the eprint subject persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eprint.model.EprintSubject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EprintSubject>> listenersList = new ArrayList<ModelListener<EprintSubject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EprintSubject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EprintSubjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EPRINTSUBJECT = "SELECT eprintSubject FROM EprintSubject eprintSubject";
	private static final String _SQL_COUNT_EPRINTSUBJECT = "SELECT COUNT(eprintSubject) FROM EprintSubject eprintSubject";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eprintSubject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EprintSubject exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EprintSubjectPersistenceImpl.class);
	private static EprintSubject _nullEprintSubject = new EprintSubjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EprintSubject> toCacheModel() {
				return _nullEprintSubjectCacheModel;
			}
		};

	private static CacheModel<EprintSubject> _nullEprintSubjectCacheModel = new CacheModel<EprintSubject>() {
			@Override
			public EprintSubject toEntityModel() {
				return _nullEprintSubject;
			}
		};
}