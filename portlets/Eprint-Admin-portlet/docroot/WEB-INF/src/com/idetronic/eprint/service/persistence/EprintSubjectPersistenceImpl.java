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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
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
 * @author matle
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

	/**
	 * Caches the eprint subject in the entity cache if it is enabled.
	 *
	 * @param eprintSubject the eprint subject
	 */
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

			BatchSessionUtil.delete(session, eprintSubject);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(eprintSubject);

		return eprintSubject;
	}

	@Override
	public EprintSubject updateImpl(
		com.idetronic.eprint.model.EprintSubject eprintSubject, boolean merge)
		throws SystemException {
		eprintSubject = toUnwrappedModel(eprintSubject);

		boolean isNew = eprintSubject.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, eprintSubject, merge);

			eprintSubject.setNew(false);
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
	 * @throws com.liferay.portal.NoSuchModelException if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintSubject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((EprintSubjectPK)primaryKey);
	}

	/**
	 * Returns the eprint subject with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintSubjectException} if it could not be found.
	 *
	 * @param eprintSubjectPK the primary key of the eprint subject
	 * @return the eprint subject
	 * @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EprintSubject findByPrimaryKey(EprintSubjectPK eprintSubjectPK)
		throws NoSuchEprintSubjectException, SystemException {
		EprintSubject eprintSubject = fetchByPrimaryKey(eprintSubjectPK);

		if (eprintSubject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + eprintSubjectPK);
			}

			throw new NoSuchEprintSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				eprintSubjectPK);
		}

		return eprintSubject;
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
		return fetchByPrimaryKey((EprintSubjectPK)primaryKey);
	}

	/**
	 * Returns the eprint subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eprintSubjectPK the primary key of the eprint subject
	 * @return the eprint subject, or <code>null</code> if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EprintSubject fetchByPrimaryKey(EprintSubjectPK eprintSubjectPK)
		throws SystemException {
		EprintSubject eprintSubject = (EprintSubject)EntityCacheUtil.getResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
				EprintSubjectImpl.class, eprintSubjectPK);

		if (eprintSubject == _nullEprintSubject) {
			return null;
		}

		if (eprintSubject == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				eprintSubject = (EprintSubject)session.get(EprintSubjectImpl.class,
						eprintSubjectPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (eprintSubject != null) {
					cacheResult(eprintSubject);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EprintSubjectModelImpl.ENTITY_CACHE_ENABLED,
						EprintSubjectImpl.class, eprintSubjectPK,
						_nullEprintSubject);
				}

				closeSession(session);
			}
		}

		return eprintSubject;
	}

	/**
	 * Returns all the eprint subjects.
	 *
	 * @return the eprint subjects
	 * @throws SystemException if a system exception occurred
	 */
	public List<EprintSubject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprint subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint subjects
	 * @param end the upper bound of the range of eprint subjects (not inclusive)
	 * @return the range of eprint subjects
	 * @throws SystemException if a system exception occurred
	 */
	public List<EprintSubject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprint subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint subjects
	 * @param end the upper bound of the range of eprint subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eprint subjects
	 * @throws SystemException if a system exception occurred
	 */
	public List<EprintSubject> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
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
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EprintSubject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EprintSubject>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

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
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EPRINTSUBJECT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

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
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<EprintSubject>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
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
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = EprintPersistence.class)
	protected EprintPersistence eprintPersistence;
	@BeanReference(type = EprintStaticContentPersistence.class)
	protected EprintStaticContentPersistence eprintStaticContentPersistence;
	@BeanReference(type = EprintSubjectPersistence.class)
	protected EprintSubjectPersistence eprintSubjectPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
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
			public EprintSubject toEntityModel() {
				return _nullEprintSubject;
			}
		};
}