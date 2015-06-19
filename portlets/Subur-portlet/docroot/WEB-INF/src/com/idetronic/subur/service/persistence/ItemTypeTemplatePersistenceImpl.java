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

import com.idetronic.subur.NoSuchItemTypeTemplateException;
import com.idetronic.subur.model.ItemTypeTemplate;
import com.idetronic.subur.model.impl.ItemTypeTemplateImpl;
import com.idetronic.subur.model.impl.ItemTypeTemplateModelImpl;

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
 * The persistence implementation for the item type template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypeTemplatePersistence
 * @see ItemTypeTemplateUtil
 * @generated
 */
public class ItemTypeTemplatePersistenceImpl extends BasePersistenceImpl<ItemTypeTemplate>
	implements ItemTypeTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemTypeTemplateUtil} to access the item type template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemTypeTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeTemplateModelImpl.FINDER_CACHE_ENABLED,
			ItemTypeTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeTemplateModelImpl.FINDER_CACHE_ENABLED,
			ItemTypeTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ItemTypeTemplatePersistenceImpl() {
		setModelClass(ItemTypeTemplate.class);
	}

	/**
	 * Caches the item type template in the entity cache if it is enabled.
	 *
	 * @param itemTypeTemplate the item type template
	 */
	@Override
	public void cacheResult(ItemTypeTemplate itemTypeTemplate) {
		EntityCacheUtil.putResult(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeTemplateImpl.class, itemTypeTemplate.getPrimaryKey(),
			itemTypeTemplate);

		itemTypeTemplate.resetOriginalValues();
	}

	/**
	 * Caches the item type templates in the entity cache if it is enabled.
	 *
	 * @param itemTypeTemplates the item type templates
	 */
	@Override
	public void cacheResult(List<ItemTypeTemplate> itemTypeTemplates) {
		for (ItemTypeTemplate itemTypeTemplate : itemTypeTemplates) {
			if (EntityCacheUtil.getResult(
						ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
						ItemTypeTemplateImpl.class,
						itemTypeTemplate.getPrimaryKey()) == null) {
				cacheResult(itemTypeTemplate);
			}
			else {
				itemTypeTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item type templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemTypeTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemTypeTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item type template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemTypeTemplate itemTypeTemplate) {
		EntityCacheUtil.removeResult(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeTemplateImpl.class, itemTypeTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemTypeTemplate> itemTypeTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemTypeTemplate itemTypeTemplate : itemTypeTemplates) {
			EntityCacheUtil.removeResult(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
				ItemTypeTemplateImpl.class, itemTypeTemplate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item type template with the primary key. Does not add the item type template to the database.
	 *
	 * @param itemTypeTemplatePK the primary key for the new item type template
	 * @return the new item type template
	 */
	@Override
	public ItemTypeTemplate create(ItemTypeTemplatePK itemTypeTemplatePK) {
		ItemTypeTemplate itemTypeTemplate = new ItemTypeTemplateImpl();

		itemTypeTemplate.setNew(true);
		itemTypeTemplate.setPrimaryKey(itemTypeTemplatePK);

		return itemTypeTemplate;
	}

	/**
	 * Removes the item type template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemTypeTemplatePK the primary key of the item type template
	 * @return the item type template that was removed
	 * @throws com.idetronic.subur.NoSuchItemTypeTemplateException if a item type template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemTypeTemplate remove(ItemTypeTemplatePK itemTypeTemplatePK)
		throws NoSuchItemTypeTemplateException, SystemException {
		return remove((Serializable)itemTypeTemplatePK);
	}

	/**
	 * Removes the item type template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item type template
	 * @return the item type template that was removed
	 * @throws com.idetronic.subur.NoSuchItemTypeTemplateException if a item type template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemTypeTemplate remove(Serializable primaryKey)
		throws NoSuchItemTypeTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemTypeTemplate itemTypeTemplate = (ItemTypeTemplate)session.get(ItemTypeTemplateImpl.class,
					primaryKey);

			if (itemTypeTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemTypeTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemTypeTemplate);
		}
		catch (NoSuchItemTypeTemplateException nsee) {
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
	protected ItemTypeTemplate removeImpl(ItemTypeTemplate itemTypeTemplate)
		throws SystemException {
		itemTypeTemplate = toUnwrappedModel(itemTypeTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemTypeTemplate)) {
				itemTypeTemplate = (ItemTypeTemplate)session.get(ItemTypeTemplateImpl.class,
						itemTypeTemplate.getPrimaryKeyObj());
			}

			if (itemTypeTemplate != null) {
				session.delete(itemTypeTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemTypeTemplate != null) {
			clearCache(itemTypeTemplate);
		}

		return itemTypeTemplate;
	}

	@Override
	public ItemTypeTemplate updateImpl(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate)
		throws SystemException {
		itemTypeTemplate = toUnwrappedModel(itemTypeTemplate);

		boolean isNew = itemTypeTemplate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (itemTypeTemplate.isNew()) {
				session.save(itemTypeTemplate);

				itemTypeTemplate.setNew(false);
			}
			else {
				session.merge(itemTypeTemplate);
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

		EntityCacheUtil.putResult(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeTemplateImpl.class, itemTypeTemplate.getPrimaryKey(),
			itemTypeTemplate);

		return itemTypeTemplate;
	}

	protected ItemTypeTemplate toUnwrappedModel(
		ItemTypeTemplate itemTypeTemplate) {
		if (itemTypeTemplate instanceof ItemTypeTemplateImpl) {
			return itemTypeTemplate;
		}

		ItemTypeTemplateImpl itemTypeTemplateImpl = new ItemTypeTemplateImpl();

		itemTypeTemplateImpl.setNew(itemTypeTemplate.isNew());
		itemTypeTemplateImpl.setPrimaryKey(itemTypeTemplate.getPrimaryKey());

		itemTypeTemplateImpl.setItemTypeId(itemTypeTemplate.getItemTypeId());
		itemTypeTemplateImpl.setMetadataPropertyId(itemTypeTemplate.getMetadataPropertyId());
		itemTypeTemplateImpl.setRequired(itemTypeTemplate.isRequired());

		return itemTypeTemplateImpl;
	}

	/**
	 * Returns the item type template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item type template
	 * @return the item type template
	 * @throws com.idetronic.subur.NoSuchItemTypeTemplateException if a item type template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemTypeTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemTypeTemplateException, SystemException {
		ItemTypeTemplate itemTypeTemplate = fetchByPrimaryKey(primaryKey);

		if (itemTypeTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemTypeTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemTypeTemplate;
	}

	/**
	 * Returns the item type template with the primary key or throws a {@link com.idetronic.subur.NoSuchItemTypeTemplateException} if it could not be found.
	 *
	 * @param itemTypeTemplatePK the primary key of the item type template
	 * @return the item type template
	 * @throws com.idetronic.subur.NoSuchItemTypeTemplateException if a item type template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemTypeTemplate findByPrimaryKey(
		ItemTypeTemplatePK itemTypeTemplatePK)
		throws NoSuchItemTypeTemplateException, SystemException {
		return findByPrimaryKey((Serializable)itemTypeTemplatePK);
	}

	/**
	 * Returns the item type template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item type template
	 * @return the item type template, or <code>null</code> if a item type template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemTypeTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemTypeTemplate itemTypeTemplate = (ItemTypeTemplate)EntityCacheUtil.getResult(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
				ItemTypeTemplateImpl.class, primaryKey);

		if (itemTypeTemplate == _nullItemTypeTemplate) {
			return null;
		}

		if (itemTypeTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				itemTypeTemplate = (ItemTypeTemplate)session.get(ItemTypeTemplateImpl.class,
						primaryKey);

				if (itemTypeTemplate != null) {
					cacheResult(itemTypeTemplate);
				}
				else {
					EntityCacheUtil.putResult(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
						ItemTypeTemplateImpl.class, primaryKey,
						_nullItemTypeTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemTypeTemplateModelImpl.ENTITY_CACHE_ENABLED,
					ItemTypeTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemTypeTemplate;
	}

	/**
	 * Returns the item type template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemTypeTemplatePK the primary key of the item type template
	 * @return the item type template, or <code>null</code> if a item type template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemTypeTemplate fetchByPrimaryKey(
		ItemTypeTemplatePK itemTypeTemplatePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)itemTypeTemplatePK);
	}

	/**
	 * Returns all the item type templates.
	 *
	 * @return the item type templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemTypeTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item type templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemTypeTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item type templates
	 * @param end the upper bound of the range of item type templates (not inclusive)
	 * @return the range of item type templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemTypeTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item type templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemTypeTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item type templates
	 * @param end the upper bound of the range of item type templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item type templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemTypeTemplate> findAll(int start, int end,
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

		List<ItemTypeTemplate> list = (List<ItemTypeTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMTYPETEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMTYPETEMPLATE;

				if (pagination) {
					sql = sql.concat(ItemTypeTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemTypeTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemTypeTemplate>(list);
				}
				else {
					list = (List<ItemTypeTemplate>)QueryUtil.list(q,
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
	 * Removes all the item type templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemTypeTemplate itemTypeTemplate : findAll()) {
			remove(itemTypeTemplate);
		}
	}

	/**
	 * Returns the number of item type templates.
	 *
	 * @return the number of item type templates
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

				Query q = session.createQuery(_SQL_COUNT_ITEMTYPETEMPLATE);

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
	 * Initializes the item type template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.ItemTypeTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemTypeTemplate>> listenersList = new ArrayList<ModelListener<ItemTypeTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemTypeTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemTypeTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMTYPETEMPLATE = "SELECT itemTypeTemplate FROM ItemTypeTemplate itemTypeTemplate";
	private static final String _SQL_COUNT_ITEMTYPETEMPLATE = "SELECT COUNT(itemTypeTemplate) FROM ItemTypeTemplate itemTypeTemplate";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemTypeTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemTypeTemplate exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemTypeTemplatePersistenceImpl.class);
	private static ItemTypeTemplate _nullItemTypeTemplate = new ItemTypeTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemTypeTemplate> toCacheModel() {
				return _nullItemTypeTemplateCacheModel;
			}
		};

	private static CacheModel<ItemTypeTemplate> _nullItemTypeTemplateCacheModel = new CacheModel<ItemTypeTemplate>() {
			@Override
			public ItemTypeTemplate toEntityModel() {
				return _nullItemTypeTemplate;
			}
		};
}