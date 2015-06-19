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

import com.idetronic.subur.NoSuchItemTypeException;
import com.idetronic.subur.model.ItemType;
import com.idetronic.subur.model.impl.ItemTypeImpl;
import com.idetronic.subur.model.impl.ItemTypeModelImpl;

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
 * The persistence implementation for the item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypePersistence
 * @see ItemTypeUtil
 * @generated
 */
public class ItemTypePersistenceImpl extends BasePersistenceImpl<ItemType>
	implements ItemTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemTypeUtil} to access the item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ItemTypePersistenceImpl() {
		setModelClass(ItemType.class);
	}

	/**
	 * Caches the item type in the entity cache if it is enabled.
	 *
	 * @param itemType the item type
	 */
	@Override
	public void cacheResult(ItemType itemType) {
		EntityCacheUtil.putResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeImpl.class, itemType.getPrimaryKey(), itemType);

		itemType.resetOriginalValues();
	}

	/**
	 * Caches the item types in the entity cache if it is enabled.
	 *
	 * @param itemTypes the item types
	 */
	@Override
	public void cacheResult(List<ItemType> itemTypes) {
		for (ItemType itemType : itemTypes) {
			if (EntityCacheUtil.getResult(
						ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						ItemTypeImpl.class, itemType.getPrimaryKey()) == null) {
				cacheResult(itemType);
			}
			else {
				itemType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemType itemType) {
		EntityCacheUtil.removeResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeImpl.class, itemType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemType> itemTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemType itemType : itemTypes) {
			EntityCacheUtil.removeResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				ItemTypeImpl.class, itemType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item type with the primary key. Does not add the item type to the database.
	 *
	 * @param ItemTypeId the primary key for the new item type
	 * @return the new item type
	 */
	@Override
	public ItemType create(long ItemTypeId) {
		ItemType itemType = new ItemTypeImpl();

		itemType.setNew(true);
		itemType.setPrimaryKey(ItemTypeId);

		return itemType;
	}

	/**
	 * Removes the item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ItemTypeId the primary key of the item type
	 * @return the item type that was removed
	 * @throws com.idetronic.subur.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType remove(long ItemTypeId)
		throws NoSuchItemTypeException, SystemException {
		return remove((Serializable)ItemTypeId);
	}

	/**
	 * Removes the item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item type
	 * @return the item type that was removed
	 * @throws com.idetronic.subur.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType remove(Serializable primaryKey)
		throws NoSuchItemTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemType itemType = (ItemType)session.get(ItemTypeImpl.class,
					primaryKey);

			if (itemType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemType);
		}
		catch (NoSuchItemTypeException nsee) {
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
	protected ItemType removeImpl(ItemType itemType) throws SystemException {
		itemType = toUnwrappedModel(itemType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemType)) {
				itemType = (ItemType)session.get(ItemTypeImpl.class,
						itemType.getPrimaryKeyObj());
			}

			if (itemType != null) {
				session.delete(itemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemType != null) {
			clearCache(itemType);
		}

		return itemType;
	}

	@Override
	public ItemType updateImpl(com.idetronic.subur.model.ItemType itemType)
		throws SystemException {
		itemType = toUnwrappedModel(itemType);

		boolean isNew = itemType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (itemType.isNew()) {
				session.save(itemType);

				itemType.setNew(false);
			}
			else {
				session.merge(itemType);
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

		EntityCacheUtil.putResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeImpl.class, itemType.getPrimaryKey(), itemType);

		return itemType;
	}

	protected ItemType toUnwrappedModel(ItemType itemType) {
		if (itemType instanceof ItemTypeImpl) {
			return itemType;
		}

		ItemTypeImpl itemTypeImpl = new ItemTypeImpl();

		itemTypeImpl.setNew(itemType.isNew());
		itemTypeImpl.setPrimaryKey(itemType.getPrimaryKey());

		itemTypeImpl.setItemTypeId(itemType.getItemTypeId());
		itemTypeImpl.setItemTypeName(itemType.getItemTypeName());
		itemTypeImpl.setItemCount(itemType.getItemCount());

		return itemTypeImpl;
	}

	/**
	 * Returns the item type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item type
	 * @return the item type
	 * @throws com.idetronic.subur.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemTypeException, SystemException {
		ItemType itemType = fetchByPrimaryKey(primaryKey);

		if (itemType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemType;
	}

	/**
	 * Returns the item type with the primary key or throws a {@link com.idetronic.subur.NoSuchItemTypeException} if it could not be found.
	 *
	 * @param ItemTypeId the primary key of the item type
	 * @return the item type
	 * @throws com.idetronic.subur.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType findByPrimaryKey(long ItemTypeId)
		throws NoSuchItemTypeException, SystemException {
		return findByPrimaryKey((Serializable)ItemTypeId);
	}

	/**
	 * Returns the item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item type
	 * @return the item type, or <code>null</code> if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemType itemType = (ItemType)EntityCacheUtil.getResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				ItemTypeImpl.class, primaryKey);

		if (itemType == _nullItemType) {
			return null;
		}

		if (itemType == null) {
			Session session = null;

			try {
				session = openSession();

				itemType = (ItemType)session.get(ItemTypeImpl.class, primaryKey);

				if (itemType != null) {
					cacheResult(itemType);
				}
				else {
					EntityCacheUtil.putResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						ItemTypeImpl.class, primaryKey, _nullItemType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
					ItemTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemType;
	}

	/**
	 * Returns the item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ItemTypeId the primary key of the item type
	 * @return the item type, or <code>null</code> if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType fetchByPrimaryKey(long ItemTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ItemTypeId);
	}

	/**
	 * Returns all the item types.
	 *
	 * @return the item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item types
	 * @param end the upper bound of the range of item types (not inclusive)
	 * @return the range of item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item types
	 * @param end the upper bound of the range of item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findAll(int start, int end,
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

		List<ItemType> list = (List<ItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMTYPE;

				if (pagination) {
					sql = sql.concat(ItemTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemType>(list);
				}
				else {
					list = (List<ItemType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the item types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemType itemType : findAll()) {
			remove(itemType);
		}
	}

	/**
	 * Returns the number of item types.
	 *
	 * @return the number of item types
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

				Query q = session.createQuery(_SQL_COUNT_ITEMTYPE);

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
	 * Initializes the item type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.ItemType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemType>> listenersList = new ArrayList<ModelListener<ItemType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMTYPE = "SELECT itemType FROM ItemType itemType";
	private static final String _SQL_COUNT_ITEMTYPE = "SELECT COUNT(itemType) FROM ItemType itemType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemTypePersistenceImpl.class);
	private static ItemType _nullItemType = new ItemTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemType> toCacheModel() {
				return _nullItemTypeCacheModel;
			}
		};

	private static CacheModel<ItemType> _nullItemTypeCacheModel = new CacheModel<ItemType>() {
			@Override
			public ItemType toEntityModel() {
				return _nullItemType;
			}
		};
}