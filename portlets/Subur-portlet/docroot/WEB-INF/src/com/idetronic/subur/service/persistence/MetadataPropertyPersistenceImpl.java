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

import com.idetronic.subur.NoSuchMetadataPropertyException;
import com.idetronic.subur.model.MetadataProperty;
import com.idetronic.subur.model.impl.MetadataPropertyImpl;
import com.idetronic.subur.model.impl.MetadataPropertyModelImpl;

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
 * The persistence implementation for the metadata property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataPropertyPersistence
 * @see MetadataPropertyUtil
 * @generated
 */
public class MetadataPropertyPersistenceImpl extends BasePersistenceImpl<MetadataProperty>
	implements MetadataPropertyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MetadataPropertyUtil} to access the metadata property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MetadataPropertyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyModelImpl.FINDER_CACHE_ENABLED,
			MetadataPropertyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyModelImpl.FINDER_CACHE_ENABLED,
			MetadataPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MetadataPropertyPersistenceImpl() {
		setModelClass(MetadataProperty.class);
	}

	/**
	 * Caches the metadata property in the entity cache if it is enabled.
	 *
	 * @param metadataProperty the metadata property
	 */
	@Override
	public void cacheResult(MetadataProperty metadataProperty) {
		EntityCacheUtil.putResult(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyImpl.class, metadataProperty.getPrimaryKey(),
			metadataProperty);

		metadataProperty.resetOriginalValues();
	}

	/**
	 * Caches the metadata properties in the entity cache if it is enabled.
	 *
	 * @param metadataProperties the metadata properties
	 */
	@Override
	public void cacheResult(List<MetadataProperty> metadataProperties) {
		for (MetadataProperty metadataProperty : metadataProperties) {
			if (EntityCacheUtil.getResult(
						MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
						MetadataPropertyImpl.class,
						metadataProperty.getPrimaryKey()) == null) {
				cacheResult(metadataProperty);
			}
			else {
				metadataProperty.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all metadata properties.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MetadataPropertyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MetadataPropertyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the metadata property.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MetadataProperty metadataProperty) {
		EntityCacheUtil.removeResult(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyImpl.class, metadataProperty.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MetadataProperty> metadataProperties) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MetadataProperty metadataProperty : metadataProperties) {
			EntityCacheUtil.removeResult(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
				MetadataPropertyImpl.class, metadataProperty.getPrimaryKey());
		}
	}

	/**
	 * Creates a new metadata property with the primary key. Does not add the metadata property to the database.
	 *
	 * @param metadataPropertyId the primary key for the new metadata property
	 * @return the new metadata property
	 */
	@Override
	public MetadataProperty create(long metadataPropertyId) {
		MetadataProperty metadataProperty = new MetadataPropertyImpl();

		metadataProperty.setNew(true);
		metadataProperty.setPrimaryKey(metadataPropertyId);

		return metadataProperty;
	}

	/**
	 * Removes the metadata property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataPropertyId the primary key of the metadata property
	 * @return the metadata property that was removed
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyException if a metadata property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataProperty remove(long metadataPropertyId)
		throws NoSuchMetadataPropertyException, SystemException {
		return remove((Serializable)metadataPropertyId);
	}

	/**
	 * Removes the metadata property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the metadata property
	 * @return the metadata property that was removed
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyException if a metadata property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataProperty remove(Serializable primaryKey)
		throws NoSuchMetadataPropertyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MetadataProperty metadataProperty = (MetadataProperty)session.get(MetadataPropertyImpl.class,
					primaryKey);

			if (metadataProperty == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetadataPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(metadataProperty);
		}
		catch (NoSuchMetadataPropertyException nsee) {
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
	protected MetadataProperty removeImpl(MetadataProperty metadataProperty)
		throws SystemException {
		metadataProperty = toUnwrappedModel(metadataProperty);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metadataProperty)) {
				metadataProperty = (MetadataProperty)session.get(MetadataPropertyImpl.class,
						metadataProperty.getPrimaryKeyObj());
			}

			if (metadataProperty != null) {
				session.delete(metadataProperty);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (metadataProperty != null) {
			clearCache(metadataProperty);
		}

		return metadataProperty;
	}

	@Override
	public MetadataProperty updateImpl(
		com.idetronic.subur.model.MetadataProperty metadataProperty)
		throws SystemException {
		metadataProperty = toUnwrappedModel(metadataProperty);

		boolean isNew = metadataProperty.isNew();

		Session session = null;

		try {
			session = openSession();

			if (metadataProperty.isNew()) {
				session.save(metadataProperty);

				metadataProperty.setNew(false);
			}
			else {
				session.merge(metadataProperty);
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

		EntityCacheUtil.putResult(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
			MetadataPropertyImpl.class, metadataProperty.getPrimaryKey(),
			metadataProperty);

		return metadataProperty;
	}

	protected MetadataProperty toUnwrappedModel(
		MetadataProperty metadataProperty) {
		if (metadataProperty instanceof MetadataPropertyImpl) {
			return metadataProperty;
		}

		MetadataPropertyImpl metadataPropertyImpl = new MetadataPropertyImpl();

		metadataPropertyImpl.setNew(metadataProperty.isNew());
		metadataPropertyImpl.setPrimaryKey(metadataProperty.getPrimaryKey());

		metadataPropertyImpl.setMetadataPropertyId(metadataProperty.getMetadataPropertyId());
		metadataPropertyImpl.setMetadataSchemaId(metadataProperty.getMetadataSchemaId());
		metadataPropertyImpl.setElement(metadataProperty.getElement());
		metadataPropertyImpl.setScope(metadataProperty.getScope());
		metadataPropertyImpl.setNote(metadataProperty.getNote());

		return metadataPropertyImpl;
	}

	/**
	 * Returns the metadata property with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata property
	 * @return the metadata property
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyException if a metadata property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataProperty findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetadataPropertyException, SystemException {
		MetadataProperty metadataProperty = fetchByPrimaryKey(primaryKey);

		if (metadataProperty == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetadataPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return metadataProperty;
	}

	/**
	 * Returns the metadata property with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataPropertyException} if it could not be found.
	 *
	 * @param metadataPropertyId the primary key of the metadata property
	 * @return the metadata property
	 * @throws com.idetronic.subur.NoSuchMetadataPropertyException if a metadata property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataProperty findByPrimaryKey(long metadataPropertyId)
		throws NoSuchMetadataPropertyException, SystemException {
		return findByPrimaryKey((Serializable)metadataPropertyId);
	}

	/**
	 * Returns the metadata property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata property
	 * @return the metadata property, or <code>null</code> if a metadata property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataProperty fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MetadataProperty metadataProperty = (MetadataProperty)EntityCacheUtil.getResult(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
				MetadataPropertyImpl.class, primaryKey);

		if (metadataProperty == _nullMetadataProperty) {
			return null;
		}

		if (metadataProperty == null) {
			Session session = null;

			try {
				session = openSession();

				metadataProperty = (MetadataProperty)session.get(MetadataPropertyImpl.class,
						primaryKey);

				if (metadataProperty != null) {
					cacheResult(metadataProperty);
				}
				else {
					EntityCacheUtil.putResult(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
						MetadataPropertyImpl.class, primaryKey,
						_nullMetadataProperty);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MetadataPropertyModelImpl.ENTITY_CACHE_ENABLED,
					MetadataPropertyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return metadataProperty;
	}

	/**
	 * Returns the metadata property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataPropertyId the primary key of the metadata property
	 * @return the metadata property, or <code>null</code> if a metadata property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataProperty fetchByPrimaryKey(long metadataPropertyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)metadataPropertyId);
	}

	/**
	 * Returns all the metadata properties.
	 *
	 * @return the metadata properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataProperty> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadata properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadata properties
	 * @param end the upper bound of the range of metadata properties (not inclusive)
	 * @return the range of metadata properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataProperty> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadata properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadata properties
	 * @param end the upper bound of the range of metadata properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadata properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataProperty> findAll(int start, int end,
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

		List<MetadataProperty> list = (List<MetadataProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_METADATAPROPERTY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_METADATAPROPERTY;

				if (pagination) {
					sql = sql.concat(MetadataPropertyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MetadataProperty>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MetadataProperty>(list);
				}
				else {
					list = (List<MetadataProperty>)QueryUtil.list(q,
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
	 * Removes all the metadata properties from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MetadataProperty metadataProperty : findAll()) {
			remove(metadataProperty);
		}
	}

	/**
	 * Returns the number of metadata properties.
	 *
	 * @return the number of metadata properties
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

				Query q = session.createQuery(_SQL_COUNT_METADATAPROPERTY);

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
	 * Initializes the metadata property persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.MetadataProperty")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MetadataProperty>> listenersList = new ArrayList<ModelListener<MetadataProperty>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MetadataProperty>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MetadataPropertyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_METADATAPROPERTY = "SELECT metadataProperty FROM MetadataProperty metadataProperty";
	private static final String _SQL_COUNT_METADATAPROPERTY = "SELECT COUNT(metadataProperty) FROM MetadataProperty metadataProperty";
	private static final String _ORDER_BY_ENTITY_ALIAS = "metadataProperty.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MetadataProperty exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MetadataPropertyPersistenceImpl.class);
	private static MetadataProperty _nullMetadataProperty = new MetadataPropertyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MetadataProperty> toCacheModel() {
				return _nullMetadataPropertyCacheModel;
			}
		};

	private static CacheModel<MetadataProperty> _nullMetadataPropertyCacheModel = new CacheModel<MetadataProperty>() {
			@Override
			public MetadataProperty toEntityModel() {
				return _nullMetadataProperty;
			}
		};
}