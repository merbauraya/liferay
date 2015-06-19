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

import com.idetronic.subur.NoSuchMetadataValueViewException;
import com.idetronic.subur.model.MetadataValueView;
import com.idetronic.subur.model.impl.MetadataValueViewImpl;
import com.idetronic.subur.model.impl.MetadataValueViewModelImpl;

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
 * The persistence implementation for the metadata value view service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataValueViewPersistence
 * @see MetadataValueViewUtil
 * @generated
 */
public class MetadataValueViewPersistenceImpl extends BasePersistenceImpl<MetadataValueView>
	implements MetadataValueViewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MetadataValueViewUtil} to access the metadata value view persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MetadataValueViewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
			MetadataValueViewModelImpl.FINDER_CACHE_ENABLED,
			MetadataValueViewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
			MetadataValueViewModelImpl.FINDER_CACHE_ENABLED,
			MetadataValueViewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
			MetadataValueViewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MetadataValueViewPersistenceImpl() {
		setModelClass(MetadataValueView.class);
	}

	/**
	 * Caches the metadata value view in the entity cache if it is enabled.
	 *
	 * @param metadataValueView the metadata value view
	 */
	@Override
	public void cacheResult(MetadataValueView metadataValueView) {
		EntityCacheUtil.putResult(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
			MetadataValueViewImpl.class, metadataValueView.getPrimaryKey(),
			metadataValueView);

		metadataValueView.resetOriginalValues();
	}

	/**
	 * Caches the metadata value views in the entity cache if it is enabled.
	 *
	 * @param metadataValueViews the metadata value views
	 */
	@Override
	public void cacheResult(List<MetadataValueView> metadataValueViews) {
		for (MetadataValueView metadataValueView : metadataValueViews) {
			if (EntityCacheUtil.getResult(
						MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
						MetadataValueViewImpl.class,
						metadataValueView.getPrimaryKey()) == null) {
				cacheResult(metadataValueView);
			}
			else {
				metadataValueView.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all metadata value views.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MetadataValueViewImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MetadataValueViewImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the metadata value view.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MetadataValueView metadataValueView) {
		EntityCacheUtil.removeResult(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
			MetadataValueViewImpl.class, metadataValueView.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MetadataValueView> metadataValueViews) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MetadataValueView metadataValueView : metadataValueViews) {
			EntityCacheUtil.removeResult(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
				MetadataValueViewImpl.class, metadataValueView.getPrimaryKey());
		}
	}

	/**
	 * Creates a new metadata value view with the primary key. Does not add the metadata value view to the database.
	 *
	 * @param metadataValueViewPK the primary key for the new metadata value view
	 * @return the new metadata value view
	 */
	@Override
	public MetadataValueView create(MetadataValueViewPK metadataValueViewPK) {
		MetadataValueView metadataValueView = new MetadataValueViewImpl();

		metadataValueView.setNew(true);
		metadataValueView.setPrimaryKey(metadataValueViewPK);

		return metadataValueView;
	}

	/**
	 * Removes the metadata value view with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataValueViewPK the primary key of the metadata value view
	 * @return the metadata value view that was removed
	 * @throws com.idetronic.subur.NoSuchMetadataValueViewException if a metadata value view with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataValueView remove(MetadataValueViewPK metadataValueViewPK)
		throws NoSuchMetadataValueViewException, SystemException {
		return remove((Serializable)metadataValueViewPK);
	}

	/**
	 * Removes the metadata value view with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the metadata value view
	 * @return the metadata value view that was removed
	 * @throws com.idetronic.subur.NoSuchMetadataValueViewException if a metadata value view with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataValueView remove(Serializable primaryKey)
		throws NoSuchMetadataValueViewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MetadataValueView metadataValueView = (MetadataValueView)session.get(MetadataValueViewImpl.class,
					primaryKey);

			if (metadataValueView == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetadataValueViewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(metadataValueView);
		}
		catch (NoSuchMetadataValueViewException nsee) {
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
	protected MetadataValueView removeImpl(MetadataValueView metadataValueView)
		throws SystemException {
		metadataValueView = toUnwrappedModel(metadataValueView);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metadataValueView)) {
				metadataValueView = (MetadataValueView)session.get(MetadataValueViewImpl.class,
						metadataValueView.getPrimaryKeyObj());
			}

			if (metadataValueView != null) {
				session.delete(metadataValueView);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (metadataValueView != null) {
			clearCache(metadataValueView);
		}

		return metadataValueView;
	}

	@Override
	public MetadataValueView updateImpl(
		com.idetronic.subur.model.MetadataValueView metadataValueView)
		throws SystemException {
		metadataValueView = toUnwrappedModel(metadataValueView);

		boolean isNew = metadataValueView.isNew();

		Session session = null;

		try {
			session = openSession();

			if (metadataValueView.isNew()) {
				session.save(metadataValueView);

				metadataValueView.setNew(false);
			}
			else {
				session.merge(metadataValueView);
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

		EntityCacheUtil.putResult(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
			MetadataValueViewImpl.class, metadataValueView.getPrimaryKey(),
			metadataValueView);

		return metadataValueView;
	}

	protected MetadataValueView toUnwrappedModel(
		MetadataValueView metadataValueView) {
		if (metadataValueView instanceof MetadataValueViewImpl) {
			return metadataValueView;
		}

		MetadataValueViewImpl metadataValueViewImpl = new MetadataValueViewImpl();

		metadataValueViewImpl.setNew(metadataValueView.isNew());
		metadataValueViewImpl.setPrimaryKey(metadataValueView.getPrimaryKey());

		metadataValueViewImpl.setPropertyId(metadataValueView.getPropertyId());
		metadataValueViewImpl.setSubjectId(metadataValueView.getSubjectId());
		metadataValueViewImpl.setSubjectName(metadataValueView.getSubjectName());
		metadataValueViewImpl.setTextValue(metadataValueView.getTextValue());
		metadataValueViewImpl.setItemCount(metadataValueView.getItemCount());

		return metadataValueViewImpl;
	}

	/**
	 * Returns the metadata value view with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata value view
	 * @return the metadata value view
	 * @throws com.idetronic.subur.NoSuchMetadataValueViewException if a metadata value view with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataValueView findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetadataValueViewException, SystemException {
		MetadataValueView metadataValueView = fetchByPrimaryKey(primaryKey);

		if (metadataValueView == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetadataValueViewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return metadataValueView;
	}

	/**
	 * Returns the metadata value view with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataValueViewException} if it could not be found.
	 *
	 * @param metadataValueViewPK the primary key of the metadata value view
	 * @return the metadata value view
	 * @throws com.idetronic.subur.NoSuchMetadataValueViewException if a metadata value view with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataValueView findByPrimaryKey(
		MetadataValueViewPK metadataValueViewPK)
		throws NoSuchMetadataValueViewException, SystemException {
		return findByPrimaryKey((Serializable)metadataValueViewPK);
	}

	/**
	 * Returns the metadata value view with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata value view
	 * @return the metadata value view, or <code>null</code> if a metadata value view with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataValueView fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MetadataValueView metadataValueView = (MetadataValueView)EntityCacheUtil.getResult(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
				MetadataValueViewImpl.class, primaryKey);

		if (metadataValueView == _nullMetadataValueView) {
			return null;
		}

		if (metadataValueView == null) {
			Session session = null;

			try {
				session = openSession();

				metadataValueView = (MetadataValueView)session.get(MetadataValueViewImpl.class,
						primaryKey);

				if (metadataValueView != null) {
					cacheResult(metadataValueView);
				}
				else {
					EntityCacheUtil.putResult(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
						MetadataValueViewImpl.class, primaryKey,
						_nullMetadataValueView);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MetadataValueViewModelImpl.ENTITY_CACHE_ENABLED,
					MetadataValueViewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return metadataValueView;
	}

	/**
	 * Returns the metadata value view with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataValueViewPK the primary key of the metadata value view
	 * @return the metadata value view, or <code>null</code> if a metadata value view with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataValueView fetchByPrimaryKey(
		MetadataValueViewPK metadataValueViewPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)metadataValueViewPK);
	}

	/**
	 * Returns all the metadata value views.
	 *
	 * @return the metadata value views
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataValueView> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadata value views.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadata value views
	 * @param end the upper bound of the range of metadata value views (not inclusive)
	 * @return the range of metadata value views
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataValueView> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadata value views.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadata value views
	 * @param end the upper bound of the range of metadata value views (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadata value views
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataValueView> findAll(int start, int end,
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

		List<MetadataValueView> list = (List<MetadataValueView>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_METADATAVALUEVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_METADATAVALUEVIEW;

				if (pagination) {
					sql = sql.concat(MetadataValueViewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MetadataValueView>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MetadataValueView>(list);
				}
				else {
					list = (List<MetadataValueView>)QueryUtil.list(q,
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
	 * Removes all the metadata value views from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MetadataValueView metadataValueView : findAll()) {
			remove(metadataValueView);
		}
	}

	/**
	 * Returns the number of metadata value views.
	 *
	 * @return the number of metadata value views
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

				Query q = session.createQuery(_SQL_COUNT_METADATAVALUEVIEW);

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
	 * Initializes the metadata value view persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.MetadataValueView")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MetadataValueView>> listenersList = new ArrayList<ModelListener<MetadataValueView>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MetadataValueView>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MetadataValueViewImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_METADATAVALUEVIEW = "SELECT metadataValueView FROM MetadataValueView metadataValueView";
	private static final String _SQL_COUNT_METADATAVALUEVIEW = "SELECT COUNT(metadataValueView) FROM MetadataValueView metadataValueView";
	private static final String _ORDER_BY_ENTITY_ALIAS = "metadataValueView.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MetadataValueView exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MetadataValueViewPersistenceImpl.class);
	private static MetadataValueView _nullMetadataValueView = new MetadataValueViewImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MetadataValueView> toCacheModel() {
				return _nullMetadataValueViewCacheModel;
			}
		};

	private static CacheModel<MetadataValueView> _nullMetadataValueViewCacheModel =
		new CacheModel<MetadataValueView>() {
			@Override
			public MetadataValueView toEntityModel() {
				return _nullMetadataValueView;
			}
		};
}