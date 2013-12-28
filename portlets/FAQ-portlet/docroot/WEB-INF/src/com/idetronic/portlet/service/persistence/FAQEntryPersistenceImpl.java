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

import com.idetronic.portlet.NoSuchEntryException;
import com.idetronic.portlet.model.FAQEntry;
import com.idetronic.portlet.model.impl.FAQEntryImpl;
import com.idetronic.portlet.model.impl.FAQEntryModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.Validator;
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
 * The persistence implementation for the f a q entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FAQEntryPersistence
 * @see FAQEntryUtil
 * @generated
 */
public class FAQEntryPersistenceImpl extends BasePersistenceImpl<FAQEntry>
	implements FAQEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FAQEntryUtil} to access the f a q entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FAQEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DISTINCTCATALOGERY =
		new FinderPath(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryModelImpl.FINDER_CACHE_ENABLED, FAQEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDistinctCatalogery",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTINCTCATALOGERY =
		new FinderPath(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryModelImpl.FINDER_CACHE_ENABLED, FAQEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDistinctCatalogery",
			new String[] { String.class.getName() },
			FAQEntryModelImpl.CATEGORY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DISTINCTCATALOGERY = new FinderPath(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDistinctCatalogery", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryModelImpl.FINDER_CACHE_ENABLED, FAQEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryModelImpl.FINDER_CACHE_ENABLED, FAQEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the f a q entry in the entity cache if it is enabled.
	 *
	 * @param faqEntry the f a q entry
	 */
	public void cacheResult(FAQEntry faqEntry) {
		EntityCacheUtil.putResult(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryImpl.class, faqEntry.getPrimaryKey(), faqEntry);

		faqEntry.resetOriginalValues();
	}

	/**
	 * Caches the f a q entries in the entity cache if it is enabled.
	 *
	 * @param faqEntries the f a q entries
	 */
	public void cacheResult(List<FAQEntry> faqEntries) {
		for (FAQEntry faqEntry : faqEntries) {
			if (EntityCacheUtil.getResult(
						FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
						FAQEntryImpl.class, faqEntry.getPrimaryKey()) == null) {
				cacheResult(faqEntry);
			}
			else {
				faqEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all f a q entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FAQEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FAQEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the f a q entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FAQEntry faqEntry) {
		EntityCacheUtil.removeResult(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryImpl.class, faqEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FAQEntry> faqEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FAQEntry faqEntry : faqEntries) {
			EntityCacheUtil.removeResult(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
				FAQEntryImpl.class, faqEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new f a q entry with the primary key. Does not add the f a q entry to the database.
	 *
	 * @param entryId the primary key for the new f a q entry
	 * @return the new f a q entry
	 */
	public FAQEntry create(long entryId) {
		FAQEntry faqEntry = new FAQEntryImpl();

		faqEntry.setNew(true);
		faqEntry.setPrimaryKey(entryId);

		return faqEntry;
	}

	/**
	 * Removes the f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the f a q entry
	 * @return the f a q entry that was removed
	 * @throws com.idetronic.portlet.NoSuchEntryException if a f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQEntry remove(long entryId)
		throws NoSuchEntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the f a q entry
	 * @return the f a q entry that was removed
	 * @throws com.idetronic.portlet.NoSuchEntryException if a f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQEntry remove(Serializable primaryKey)
		throws NoSuchEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FAQEntry faqEntry = (FAQEntry)session.get(FAQEntryImpl.class,
					primaryKey);

			if (faqEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(faqEntry);
		}
		catch (NoSuchEntryException nsee) {
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
	protected FAQEntry removeImpl(FAQEntry faqEntry) throws SystemException {
		faqEntry = toUnwrappedModel(faqEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, faqEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(faqEntry);

		return faqEntry;
	}

	@Override
	public FAQEntry updateImpl(com.idetronic.portlet.model.FAQEntry faqEntry,
		boolean merge) throws SystemException {
		faqEntry = toUnwrappedModel(faqEntry);

		boolean isNew = faqEntry.isNew();

		FAQEntryModelImpl faqEntryModelImpl = (FAQEntryModelImpl)faqEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, faqEntry, merge);

			faqEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FAQEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((faqEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTINCTCATALOGERY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						faqEntryModelImpl.getOriginalCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISTINCTCATALOGERY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTINCTCATALOGERY,
					args);

				args = new Object[] { faqEntryModelImpl.getCategory() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISTINCTCATALOGERY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTINCTCATALOGERY,
					args);
			}
		}

		EntityCacheUtil.putResult(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			FAQEntryImpl.class, faqEntry.getPrimaryKey(), faqEntry);

		return faqEntry;
	}

	protected FAQEntry toUnwrappedModel(FAQEntry faqEntry) {
		if (faqEntry instanceof FAQEntryImpl) {
			return faqEntry;
		}

		FAQEntryImpl faqEntryImpl = new FAQEntryImpl();

		faqEntryImpl.setNew(faqEntry.isNew());
		faqEntryImpl.setPrimaryKey(faqEntry.getPrimaryKey());

		faqEntryImpl.setEntryId(faqEntry.getEntryId());
		faqEntryImpl.setCompanyId(faqEntry.getCompanyId());
		faqEntryImpl.setUserId(faqEntry.getUserId());
		faqEntryImpl.setUserName(faqEntry.getUserName());
		faqEntryImpl.setCreateDate(faqEntry.getCreateDate());
		faqEntryImpl.setModifiedDate(faqEntry.getModifiedDate());
		faqEntryImpl.setQuestion(faqEntry.getQuestion());
		faqEntryImpl.setCategory(faqEntry.getCategory());
		faqEntryImpl.setAnswer(faqEntry.getAnswer());
		faqEntryImpl.setIsactive(faqEntry.getIsactive());
		faqEntryImpl.setDisplayOrder(faqEntry.getDisplayOrder());

		return faqEntryImpl;
	}

	/**
	 * Returns the f a q entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q entry
	 * @return the f a q entry
	 * @throws com.liferay.portal.NoSuchModelException if a f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q entry with the primary key or throws a {@link com.idetronic.portlet.NoSuchEntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the f a q entry
	 * @return the f a q entry
	 * @throws com.idetronic.portlet.NoSuchEntryException if a f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQEntry findByPrimaryKey(long entryId)
		throws NoSuchEntryException, SystemException {
		FAQEntry faqEntry = fetchByPrimaryKey(entryId);

		if (faqEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return faqEntry;
	}

	/**
	 * Returns the f a q entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q entry
	 * @return the f a q entry, or <code>null</code> if a f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the f a q entry
	 * @return the f a q entry, or <code>null</code> if a f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQEntry fetchByPrimaryKey(long entryId) throws SystemException {
		FAQEntry faqEntry = (FAQEntry)EntityCacheUtil.getResult(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
				FAQEntryImpl.class, entryId);

		if (faqEntry == _nullFAQEntry) {
			return null;
		}

		if (faqEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				faqEntry = (FAQEntry)session.get(FAQEntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (faqEntry != null) {
					cacheResult(faqEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FAQEntryModelImpl.ENTITY_CACHE_ENABLED,
						FAQEntryImpl.class, entryId, _nullFAQEntry);
				}

				closeSession(session);
			}
		}

		return faqEntry;
	}

	/**
	 * Returns all the f a q entries where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQEntry> findByDistinctCatalogery(String category)
		throws SystemException {
		return findByDistinctCatalogery(category, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q entries where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of f a q entries
	 * @param end the upper bound of the range of f a q entries (not inclusive)
	 * @return the range of matching f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQEntry> findByDistinctCatalogery(String category, int start,
		int end) throws SystemException {
		return findByDistinctCatalogery(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q entries where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of f a q entries
	 * @param end the upper bound of the range of f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQEntry> findByDistinctCatalogery(String category, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTINCTCATALOGERY;
			finderArgs = new Object[] { category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DISTINCTCATALOGERY;
			finderArgs = new Object[] { category, start, end, orderByComparator };
		}

		List<FAQEntry> list = (List<FAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FAQEntry faqEntry : list) {
				if (!Validator.equals(category, faqEntry.getCategory())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_FAQENTRY_WHERE);

			if (category == null) {
				query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_1);
			}
			else {
				if (category.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_3);
				}
				else {
					query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (category != null) {
					qPos.add(category);
				}

				list = (List<FAQEntry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first f a q entry in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q entry
	 * @throws com.idetronic.portlet.NoSuchEntryException if a matching f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQEntry findByDistinctCatalogery_First(String category,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		FAQEntry faqEntry = fetchByDistinctCatalogery_First(category,
				orderByComparator);

		if (faqEntry != null) {
			return faqEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first f a q entry in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q entry, or <code>null</code> if a matching f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQEntry fetchByDistinctCatalogery_First(String category,
		OrderByComparator orderByComparator) throws SystemException {
		List<FAQEntry> list = findByDistinctCatalogery(category, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last f a q entry in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q entry
	 * @throws com.idetronic.portlet.NoSuchEntryException if a matching f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQEntry findByDistinctCatalogery_Last(String category,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		FAQEntry faqEntry = fetchByDistinctCatalogery_Last(category,
				orderByComparator);

		if (faqEntry != null) {
			return faqEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last f a q entry in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q entry, or <code>null</code> if a matching f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQEntry fetchByDistinctCatalogery_Last(String category,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDistinctCatalogery(category);

		List<FAQEntry> list = findByDistinctCatalogery(category, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the f a q entries before and after the current f a q entry in the ordered set where category = &#63;.
	 *
	 * @param entryId the primary key of the current f a q entry
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q entry
	 * @throws com.idetronic.portlet.NoSuchEntryException if a f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQEntry[] findByDistinctCatalogery_PrevAndNext(long entryId,
		String category, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		FAQEntry faqEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			FAQEntry[] array = new FAQEntryImpl[3];

			array[0] = getByDistinctCatalogery_PrevAndNext(session, faqEntry,
					category, orderByComparator, true);

			array[1] = faqEntry;

			array[2] = getByDistinctCatalogery_PrevAndNext(session, faqEntry,
					category, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQEntry getByDistinctCatalogery_PrevAndNext(Session session,
		FAQEntry faqEntry, String category,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQENTRY_WHERE);

		if (category == null) {
			query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_1);
		}
		else {
			if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_3);
			}
			else {
				query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_2);
			}
		}

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (category != null) {
			qPos.add(category);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q entries.
	 *
	 * @return the f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q entries
	 * @param end the upper bound of the range of f a q entries (not inclusive)
	 * @return the range of f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQEntry> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q entries
	 * @param end the upper bound of the range of f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQEntry> findAll(int start, int end,
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

		List<FAQEntry> list = (List<FAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FAQENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAQENTRY;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FAQEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the f a q entries where category = &#63; from the database.
	 *
	 * @param category the category
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDistinctCatalogery(String category)
		throws SystemException {
		for (FAQEntry faqEntry : findByDistinctCatalogery(category)) {
			remove(faqEntry);
		}
	}

	/**
	 * Removes all the f a q entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FAQEntry faqEntry : findAll()) {
			remove(faqEntry);
		}
	}

	/**
	 * Returns the number of f a q entries where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDistinctCatalogery(String category)
		throws SystemException {
		Object[] finderArgs = new Object[] { category };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DISTINCTCATALOGERY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQENTRY_WHERE);

			if (category == null) {
				query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_1);
			}
			else {
				if (category.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_3);
				}
				else {
					query.append(_FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (category != null) {
					qPos.add(category);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISTINCTCATALOGERY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q entries.
	 *
	 * @return the number of f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAQENTRY);

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
	 * Initializes the f a q entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.portlet.model.FAQEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FAQEntry>> listenersList = new ArrayList<ModelListener<FAQEntry>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<FAQEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FAQEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = FAQEntryPersistence.class)
	protected FAQEntryPersistence faqEntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_FAQENTRY = "SELECT faqEntry FROM FAQEntry faqEntry";
	private static final String _SQL_SELECT_FAQENTRY_WHERE = "SELECT faqEntry FROM FAQEntry faqEntry WHERE ";
	private static final String _SQL_COUNT_FAQENTRY = "SELECT COUNT(faqEntry) FROM FAQEntry faqEntry";
	private static final String _SQL_COUNT_FAQENTRY_WHERE = "SELECT COUNT(faqEntry) FROM FAQEntry faqEntry WHERE ";
	private static final String _FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_1 = "faqEntry.category IS NULL";
	private static final String _FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_2 = "faqEntry.category = ?";
	private static final String _FINDER_COLUMN_DISTINCTCATALOGERY_CATEGORY_3 = "(faqEntry.category IS NULL OR faqEntry.category = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "faqEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FAQEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FAQEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FAQEntryPersistenceImpl.class);
	private static FAQEntry _nullFAQEntry = new FAQEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FAQEntry> toCacheModel() {
				return _nullFAQEntryCacheModel;
			}
		};

	private static CacheModel<FAQEntry> _nullFAQEntryCacheModel = new CacheModel<FAQEntry>() {
			public FAQEntry toEntityModel() {
				return _nullFAQEntry;
			}
		};
}