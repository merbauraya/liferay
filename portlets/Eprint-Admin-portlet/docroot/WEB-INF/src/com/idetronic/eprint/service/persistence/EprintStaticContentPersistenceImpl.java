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

import com.idetronic.eprint.NoSuchEprintStaticContentException;
import com.idetronic.eprint.model.EprintStaticContent;
import com.idetronic.eprint.model.impl.EprintStaticContentImpl;
import com.idetronic.eprint.model.impl.EprintStaticContentModelImpl;

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
 * The persistence implementation for the eprint static content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matle
 * @see EprintStaticContentPersistence
 * @see EprintStaticContentUtil
 * @generated
 */
public class EprintStaticContentPersistenceImpl extends BasePersistenceImpl<EprintStaticContent>
	implements EprintStaticContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EprintStaticContentUtil} to access the eprint static content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EprintStaticContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
			EprintStaticContentModelImpl.FINDER_CACHE_ENABLED,
			EprintStaticContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
			EprintStaticContentModelImpl.FINDER_CACHE_ENABLED,
			EprintStaticContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
			EprintStaticContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the eprint static content in the entity cache if it is enabled.
	 *
	 * @param eprintStaticContent the eprint static content
	 */
	public void cacheResult(EprintStaticContent eprintStaticContent) {
		EntityCacheUtil.putResult(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
			EprintStaticContentImpl.class, eprintStaticContent.getPrimaryKey(),
			eprintStaticContent);

		eprintStaticContent.resetOriginalValues();
	}

	/**
	 * Caches the eprint static contents in the entity cache if it is enabled.
	 *
	 * @param eprintStaticContents the eprint static contents
	 */
	public void cacheResult(List<EprintStaticContent> eprintStaticContents) {
		for (EprintStaticContent eprintStaticContent : eprintStaticContents) {
			if (EntityCacheUtil.getResult(
						EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
						EprintStaticContentImpl.class,
						eprintStaticContent.getPrimaryKey()) == null) {
				cacheResult(eprintStaticContent);
			}
			else {
				eprintStaticContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all eprint static contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EprintStaticContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EprintStaticContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the eprint static content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EprintStaticContent eprintStaticContent) {
		EntityCacheUtil.removeResult(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
			EprintStaticContentImpl.class, eprintStaticContent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EprintStaticContent> eprintStaticContents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EprintStaticContent eprintStaticContent : eprintStaticContents) {
			EntityCacheUtil.removeResult(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
				EprintStaticContentImpl.class,
				eprintStaticContent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new eprint static content with the primary key. Does not add the eprint static content to the database.
	 *
	 * @param contentId the primary key for the new eprint static content
	 * @return the new eprint static content
	 */
	public EprintStaticContent create(long contentId) {
		EprintStaticContent eprintStaticContent = new EprintStaticContentImpl();

		eprintStaticContent.setNew(true);
		eprintStaticContent.setPrimaryKey(contentId);

		return eprintStaticContent;
	}

	/**
	 * Removes the eprint static content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentId the primary key of the eprint static content
	 * @return the eprint static content that was removed
	 * @throws com.idetronic.eprint.NoSuchEprintStaticContentException if a eprint static content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EprintStaticContent remove(long contentId)
		throws NoSuchEprintStaticContentException, SystemException {
		return remove(Long.valueOf(contentId));
	}

	/**
	 * Removes the eprint static content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the eprint static content
	 * @return the eprint static content that was removed
	 * @throws com.idetronic.eprint.NoSuchEprintStaticContentException if a eprint static content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintStaticContent remove(Serializable primaryKey)
		throws NoSuchEprintStaticContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EprintStaticContent eprintStaticContent = (EprintStaticContent)session.get(EprintStaticContentImpl.class,
					primaryKey);

			if (eprintStaticContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEprintStaticContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eprintStaticContent);
		}
		catch (NoSuchEprintStaticContentException nsee) {
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
	protected EprintStaticContent removeImpl(
		EprintStaticContent eprintStaticContent) throws SystemException {
		eprintStaticContent = toUnwrappedModel(eprintStaticContent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, eprintStaticContent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(eprintStaticContent);

		return eprintStaticContent;
	}

	@Override
	public EprintStaticContent updateImpl(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent,
		boolean merge) throws SystemException {
		eprintStaticContent = toUnwrappedModel(eprintStaticContent);

		boolean isNew = eprintStaticContent.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, eprintStaticContent, merge);

			eprintStaticContent.setNew(false);
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

		EntityCacheUtil.putResult(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
			EprintStaticContentImpl.class, eprintStaticContent.getPrimaryKey(),
			eprintStaticContent);

		return eprintStaticContent;
	}

	protected EprintStaticContent toUnwrappedModel(
		EprintStaticContent eprintStaticContent) {
		if (eprintStaticContent instanceof EprintStaticContentImpl) {
			return eprintStaticContent;
		}

		EprintStaticContentImpl eprintStaticContentImpl = new EprintStaticContentImpl();

		eprintStaticContentImpl.setNew(eprintStaticContent.isNew());
		eprintStaticContentImpl.setPrimaryKey(eprintStaticContent.getPrimaryKey());

		eprintStaticContentImpl.setContentId(eprintStaticContent.getContentId());
		eprintStaticContentImpl.setContent(eprintStaticContent.getContent());

		return eprintStaticContentImpl;
	}

	/**
	 * Returns the eprint static content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprint static content
	 * @return the eprint static content
	 * @throws com.liferay.portal.NoSuchModelException if a eprint static content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintStaticContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the eprint static content with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintStaticContentException} if it could not be found.
	 *
	 * @param contentId the primary key of the eprint static content
	 * @return the eprint static content
	 * @throws com.idetronic.eprint.NoSuchEprintStaticContentException if a eprint static content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EprintStaticContent findByPrimaryKey(long contentId)
		throws NoSuchEprintStaticContentException, SystemException {
		EprintStaticContent eprintStaticContent = fetchByPrimaryKey(contentId);

		if (eprintStaticContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contentId);
			}

			throw new NoSuchEprintStaticContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contentId);
		}

		return eprintStaticContent;
	}

	/**
	 * Returns the eprint static content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprint static content
	 * @return the eprint static content, or <code>null</code> if a eprint static content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EprintStaticContent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the eprint static content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contentId the primary key of the eprint static content
	 * @return the eprint static content, or <code>null</code> if a eprint static content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EprintStaticContent fetchByPrimaryKey(long contentId)
		throws SystemException {
		EprintStaticContent eprintStaticContent = (EprintStaticContent)EntityCacheUtil.getResult(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
				EprintStaticContentImpl.class, contentId);

		if (eprintStaticContent == _nullEprintStaticContent) {
			return null;
		}

		if (eprintStaticContent == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				eprintStaticContent = (EprintStaticContent)session.get(EprintStaticContentImpl.class,
						Long.valueOf(contentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (eprintStaticContent != null) {
					cacheResult(eprintStaticContent);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EprintStaticContentModelImpl.ENTITY_CACHE_ENABLED,
						EprintStaticContentImpl.class, contentId,
						_nullEprintStaticContent);
				}

				closeSession(session);
			}
		}

		return eprintStaticContent;
	}

	/**
	 * Returns all the eprint static contents.
	 *
	 * @return the eprint static contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<EprintStaticContent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprint static contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint static contents
	 * @param end the upper bound of the range of eprint static contents (not inclusive)
	 * @return the range of eprint static contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<EprintStaticContent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprint static contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint static contents
	 * @param end the upper bound of the range of eprint static contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eprint static contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<EprintStaticContent> findAll(int start, int end,
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

		List<EprintStaticContent> list = (List<EprintStaticContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EPRINTSTATICCONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EPRINTSTATICCONTENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EprintStaticContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EprintStaticContent>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the eprint static contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EprintStaticContent eprintStaticContent : findAll()) {
			remove(eprintStaticContent);
		}
	}

	/**
	 * Returns the number of eprint static contents.
	 *
	 * @return the number of eprint static contents
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EPRINTSTATICCONTENT);

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
	 * Initializes the eprint static content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eprint.model.EprintStaticContent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EprintStaticContent>> listenersList = new ArrayList<ModelListener<EprintStaticContent>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<EprintStaticContent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EprintStaticContentImpl.class.getName());
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
	private static final String _SQL_SELECT_EPRINTSTATICCONTENT = "SELECT eprintStaticContent FROM EprintStaticContent eprintStaticContent";
	private static final String _SQL_COUNT_EPRINTSTATICCONTENT = "SELECT COUNT(eprintStaticContent) FROM EprintStaticContent eprintStaticContent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eprintStaticContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EprintStaticContent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EprintStaticContentPersistenceImpl.class);
	private static EprintStaticContent _nullEprintStaticContent = new EprintStaticContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EprintStaticContent> toCacheModel() {
				return _nullEprintStaticContentCacheModel;
			}
		};

	private static CacheModel<EprintStaticContent> _nullEprintStaticContentCacheModel =
		new CacheModel<EprintStaticContent>() {
			public EprintStaticContent toEntityModel() {
				return _nullEprintStaticContent;
			}
		};
}