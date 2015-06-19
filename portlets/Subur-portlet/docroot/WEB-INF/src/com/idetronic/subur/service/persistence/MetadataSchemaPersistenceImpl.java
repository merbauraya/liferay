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

import com.idetronic.subur.NoSuchMetadataSchemaException;
import com.idetronic.subur.model.MetadataSchema;
import com.idetronic.subur.model.impl.MetadataSchemaImpl;
import com.idetronic.subur.model.impl.MetadataSchemaModelImpl;

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
 * The persistence implementation for the metadata schema service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataSchemaPersistence
 * @see MetadataSchemaUtil
 * @generated
 */
public class MetadataSchemaPersistenceImpl extends BasePersistenceImpl<MetadataSchema>
	implements MetadataSchemaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MetadataSchemaUtil} to access the metadata schema persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MetadataSchemaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
			MetadataSchemaModelImpl.FINDER_CACHE_ENABLED,
			MetadataSchemaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
			MetadataSchemaModelImpl.FINDER_CACHE_ENABLED,
			MetadataSchemaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
			MetadataSchemaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MetadataSchemaPersistenceImpl() {
		setModelClass(MetadataSchema.class);
	}

	/**
	 * Caches the metadata schema in the entity cache if it is enabled.
	 *
	 * @param metadataSchema the metadata schema
	 */
	@Override
	public void cacheResult(MetadataSchema metadataSchema) {
		EntityCacheUtil.putResult(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
			MetadataSchemaImpl.class, metadataSchema.getPrimaryKey(),
			metadataSchema);

		metadataSchema.resetOriginalValues();
	}

	/**
	 * Caches the metadata schemas in the entity cache if it is enabled.
	 *
	 * @param metadataSchemas the metadata schemas
	 */
	@Override
	public void cacheResult(List<MetadataSchema> metadataSchemas) {
		for (MetadataSchema metadataSchema : metadataSchemas) {
			if (EntityCacheUtil.getResult(
						MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
						MetadataSchemaImpl.class, metadataSchema.getPrimaryKey()) == null) {
				cacheResult(metadataSchema);
			}
			else {
				metadataSchema.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all metadata schemas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MetadataSchemaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MetadataSchemaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the metadata schema.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MetadataSchema metadataSchema) {
		EntityCacheUtil.removeResult(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
			MetadataSchemaImpl.class, metadataSchema.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MetadataSchema> metadataSchemas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MetadataSchema metadataSchema : metadataSchemas) {
			EntityCacheUtil.removeResult(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
				MetadataSchemaImpl.class, metadataSchema.getPrimaryKey());
		}
	}

	/**
	 * Creates a new metadata schema with the primary key. Does not add the metadata schema to the database.
	 *
	 * @param metadataSchemaId the primary key for the new metadata schema
	 * @return the new metadata schema
	 */
	@Override
	public MetadataSchema create(long metadataSchemaId) {
		MetadataSchema metadataSchema = new MetadataSchemaImpl();

		metadataSchema.setNew(true);
		metadataSchema.setPrimaryKey(metadataSchemaId);

		return metadataSchema;
	}

	/**
	 * Removes the metadata schema with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataSchemaId the primary key of the metadata schema
	 * @return the metadata schema that was removed
	 * @throws com.idetronic.subur.NoSuchMetadataSchemaException if a metadata schema with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataSchema remove(long metadataSchemaId)
		throws NoSuchMetadataSchemaException, SystemException {
		return remove((Serializable)metadataSchemaId);
	}

	/**
	 * Removes the metadata schema with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the metadata schema
	 * @return the metadata schema that was removed
	 * @throws com.idetronic.subur.NoSuchMetadataSchemaException if a metadata schema with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataSchema remove(Serializable primaryKey)
		throws NoSuchMetadataSchemaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MetadataSchema metadataSchema = (MetadataSchema)session.get(MetadataSchemaImpl.class,
					primaryKey);

			if (metadataSchema == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetadataSchemaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(metadataSchema);
		}
		catch (NoSuchMetadataSchemaException nsee) {
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
	protected MetadataSchema removeImpl(MetadataSchema metadataSchema)
		throws SystemException {
		metadataSchema = toUnwrappedModel(metadataSchema);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metadataSchema)) {
				metadataSchema = (MetadataSchema)session.get(MetadataSchemaImpl.class,
						metadataSchema.getPrimaryKeyObj());
			}

			if (metadataSchema != null) {
				session.delete(metadataSchema);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (metadataSchema != null) {
			clearCache(metadataSchema);
		}

		return metadataSchema;
	}

	@Override
	public MetadataSchema updateImpl(
		com.idetronic.subur.model.MetadataSchema metadataSchema)
		throws SystemException {
		metadataSchema = toUnwrappedModel(metadataSchema);

		boolean isNew = metadataSchema.isNew();

		Session session = null;

		try {
			session = openSession();

			if (metadataSchema.isNew()) {
				session.save(metadataSchema);

				metadataSchema.setNew(false);
			}
			else {
				session.merge(metadataSchema);
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

		EntityCacheUtil.putResult(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
			MetadataSchemaImpl.class, metadataSchema.getPrimaryKey(),
			metadataSchema);

		return metadataSchema;
	}

	protected MetadataSchema toUnwrappedModel(MetadataSchema metadataSchema) {
		if (metadataSchema instanceof MetadataSchemaImpl) {
			return metadataSchema;
		}

		MetadataSchemaImpl metadataSchemaImpl = new MetadataSchemaImpl();

		metadataSchemaImpl.setNew(metadataSchema.isNew());
		metadataSchemaImpl.setPrimaryKey(metadataSchema.getPrimaryKey());

		metadataSchemaImpl.setMetadataSchemaId(metadataSchema.getMetadataSchemaId());
		metadataSchemaImpl.setMetadataName(metadataSchema.getMetadataName());
		metadataSchemaImpl.setNameSpace(metadataSchema.getNameSpace());

		return metadataSchemaImpl;
	}

	/**
	 * Returns the metadata schema with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata schema
	 * @return the metadata schema
	 * @throws com.idetronic.subur.NoSuchMetadataSchemaException if a metadata schema with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataSchema findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetadataSchemaException, SystemException {
		MetadataSchema metadataSchema = fetchByPrimaryKey(primaryKey);

		if (metadataSchema == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetadataSchemaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return metadataSchema;
	}

	/**
	 * Returns the metadata schema with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataSchemaException} if it could not be found.
	 *
	 * @param metadataSchemaId the primary key of the metadata schema
	 * @return the metadata schema
	 * @throws com.idetronic.subur.NoSuchMetadataSchemaException if a metadata schema with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataSchema findByPrimaryKey(long metadataSchemaId)
		throws NoSuchMetadataSchemaException, SystemException {
		return findByPrimaryKey((Serializable)metadataSchemaId);
	}

	/**
	 * Returns the metadata schema with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata schema
	 * @return the metadata schema, or <code>null</code> if a metadata schema with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataSchema fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MetadataSchema metadataSchema = (MetadataSchema)EntityCacheUtil.getResult(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
				MetadataSchemaImpl.class, primaryKey);

		if (metadataSchema == _nullMetadataSchema) {
			return null;
		}

		if (metadataSchema == null) {
			Session session = null;

			try {
				session = openSession();

				metadataSchema = (MetadataSchema)session.get(MetadataSchemaImpl.class,
						primaryKey);

				if (metadataSchema != null) {
					cacheResult(metadataSchema);
				}
				else {
					EntityCacheUtil.putResult(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
						MetadataSchemaImpl.class, primaryKey,
						_nullMetadataSchema);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MetadataSchemaModelImpl.ENTITY_CACHE_ENABLED,
					MetadataSchemaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return metadataSchema;
	}

	/**
	 * Returns the metadata schema with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataSchemaId the primary key of the metadata schema
	 * @return the metadata schema, or <code>null</code> if a metadata schema with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MetadataSchema fetchByPrimaryKey(long metadataSchemaId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)metadataSchemaId);
	}

	/**
	 * Returns all the metadata schemas.
	 *
	 * @return the metadata schemas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataSchema> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadata schemas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadata schemas
	 * @param end the upper bound of the range of metadata schemas (not inclusive)
	 * @return the range of metadata schemas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataSchema> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadata schemas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadata schemas
	 * @param end the upper bound of the range of metadata schemas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadata schemas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MetadataSchema> findAll(int start, int end,
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

		List<MetadataSchema> list = (List<MetadataSchema>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_METADATASCHEMA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_METADATASCHEMA;

				if (pagination) {
					sql = sql.concat(MetadataSchemaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MetadataSchema>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MetadataSchema>(list);
				}
				else {
					list = (List<MetadataSchema>)QueryUtil.list(q,
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
	 * Removes all the metadata schemas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MetadataSchema metadataSchema : findAll()) {
			remove(metadataSchema);
		}
	}

	/**
	 * Returns the number of metadata schemas.
	 *
	 * @return the number of metadata schemas
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

				Query q = session.createQuery(_SQL_COUNT_METADATASCHEMA);

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
	 * Initializes the metadata schema persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.MetadataSchema")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MetadataSchema>> listenersList = new ArrayList<ModelListener<MetadataSchema>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MetadataSchema>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MetadataSchemaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_METADATASCHEMA = "SELECT metadataSchema FROM MetadataSchema metadataSchema";
	private static final String _SQL_COUNT_METADATASCHEMA = "SELECT COUNT(metadataSchema) FROM MetadataSchema metadataSchema";
	private static final String _ORDER_BY_ENTITY_ALIAS = "metadataSchema.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MetadataSchema exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MetadataSchemaPersistenceImpl.class);
	private static MetadataSchema _nullMetadataSchema = new MetadataSchemaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MetadataSchema> toCacheModel() {
				return _nullMetadataSchemaCacheModel;
			}
		};

	private static CacheModel<MetadataSchema> _nullMetadataSchemaCacheModel = new CacheModel<MetadataSchema>() {
			@Override
			public MetadataSchema toEntityModel() {
				return _nullMetadataSchema;
			}
		};
}