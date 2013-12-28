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

package com.slayer.service.persistence;

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

import com.slayer.NoSuchBookException;

import com.slayer.model.LMSBook;
import com.slayer.model.impl.LMSBookImpl;
import com.slayer.model.impl.LMSBookModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l m s book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matle
 * @see LMSBookPersistence
 * @see LMSBookUtil
 * @generated
 */
public class LMSBookPersistenceImpl extends BasePersistenceImpl<LMSBook>
	implements LMSBookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LMSBookUtil} to access the l m s book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LMSBookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, LMSBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the l m s book in the entity cache if it is enabled.
	 *
	 * @param lmsBook the l m s book
	 */
	public void cacheResult(LMSBook lmsBook) {
		EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey(), lmsBook);

		lmsBook.resetOriginalValues();
	}

	/**
	 * Caches the l m s books in the entity cache if it is enabled.
	 *
	 * @param lmsBooks the l m s books
	 */
	public void cacheResult(List<LMSBook> lmsBooks) {
		for (LMSBook lmsBook : lmsBooks) {
			if (EntityCacheUtil.getResult(
						LMSBookModelImpl.ENTITY_CACHE_ENABLED,
						LMSBookImpl.class, lmsBook.getPrimaryKey()) == null) {
				cacheResult(lmsBook);
			}
			else {
				lmsBook.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l m s books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LMSBookImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LMSBookImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l m s book.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LMSBook lmsBook) {
		EntityCacheUtil.removeResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LMSBook> lmsBooks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LMSBook lmsBook : lmsBooks) {
			EntityCacheUtil.removeResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
				LMSBookImpl.class, lmsBook.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l m s book with the primary key. Does not add the l m s book to the database.
	 *
	 * @param bookId the primary key for the new l m s book
	 * @return the new l m s book
	 */
	public LMSBook create(long bookId) {
		LMSBook lmsBook = new LMSBookImpl();

		lmsBook.setNew(true);
		lmsBook.setPrimaryKey(bookId);

		return lmsBook;
	}

	/**
	 * Removes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book that was removed
	 * @throws com.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook remove(long bookId)
		throws NoSuchBookException, SystemException {
		return remove(Long.valueOf(bookId));
	}

	/**
	 * Removes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book that was removed
	 * @throws com.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook remove(Serializable primaryKey)
		throws NoSuchBookException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LMSBook lmsBook = (LMSBook)session.get(LMSBookImpl.class, primaryKey);

			if (lmsBook == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lmsBook);
		}
		catch (NoSuchBookException nsee) {
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
	protected LMSBook removeImpl(LMSBook lmsBook) throws SystemException {
		lmsBook = toUnwrappedModel(lmsBook);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lmsBook);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lmsBook);

		return lmsBook;
	}

	@Override
	public LMSBook updateImpl(com.slayer.model.LMSBook lmsBook, boolean merge)
		throws SystemException {
		lmsBook = toUnwrappedModel(lmsBook);

		boolean isNew = lmsBook.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmsBook, merge);

			lmsBook.setNew(false);
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

		EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
			LMSBookImpl.class, lmsBook.getPrimaryKey(), lmsBook);

		return lmsBook;
	}

	protected LMSBook toUnwrappedModel(LMSBook lmsBook) {
		if (lmsBook instanceof LMSBookImpl) {
			return lmsBook;
		}

		LMSBookImpl lmsBookImpl = new LMSBookImpl();

		lmsBookImpl.setNew(lmsBook.isNew());
		lmsBookImpl.setPrimaryKey(lmsBook.getPrimaryKey());

		lmsBookImpl.setBookId(lmsBook.getBookId());
		lmsBookImpl.setBookTitle(lmsBook.getBookTitle());
		lmsBookImpl.setAuthor(lmsBook.getAuthor());
		lmsBookImpl.setCreateDate(lmsBook.getCreateDate());

		return lmsBookImpl;
	}

	/**
	 * Returns the l m s book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book
	 * @throws com.liferay.portal.NoSuchModelException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l m s book with the primary key or throws a {@link com.slayer.NoSuchBookException} if it could not be found.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book
	 * @throws com.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook findByPrimaryKey(long bookId)
		throws NoSuchBookException, SystemException {
		LMSBook lmsBook = fetchByPrimaryKey(bookId);

		if (lmsBook == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookId);
			}

			throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookId);
		}

		return lmsBook;
	}

	/**
	 * Returns the l m s book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l m s book
	 * @return the l m s book, or <code>null</code> if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LMSBook fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l m s book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the l m s book
	 * @return the l m s book, or <code>null</code> if a l m s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LMSBook fetchByPrimaryKey(long bookId) throws SystemException {
		LMSBook lmsBook = (LMSBook)EntityCacheUtil.getResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
				LMSBookImpl.class, bookId);

		if (lmsBook == _nullLMSBook) {
			return null;
		}

		if (lmsBook == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lmsBook = (LMSBook)session.get(LMSBookImpl.class,
						Long.valueOf(bookId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lmsBook != null) {
					cacheResult(lmsBook);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LMSBookModelImpl.ENTITY_CACHE_ENABLED,
						LMSBookImpl.class, bookId, _nullLMSBook);
				}

				closeSession(session);
			}
		}

		return lmsBook;
	}

	/**
	 * Returns all the l m s books.
	 *
	 * @return the l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l m s books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @return the range of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l m s books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l m s books
	 * @param end the upper bound of the range of l m s books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<LMSBook> findAll(int start, int end,
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

		List<LMSBook> list = (List<LMSBook>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LMSBOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LMSBOOK;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LMSBook>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the l m s books from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LMSBook lmsBook : findAll()) {
			remove(lmsBook);
		}
	}

	/**
	 * Returns the number of l m s books.
	 *
	 * @return the number of l m s books
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LMSBOOK);

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
	 * Initializes the l m s book persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.slayer.model.LMSBook")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LMSBook>> listenersList = new ArrayList<ModelListener<LMSBook>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<LMSBook>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LMSBookImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LMSBookPersistence.class)
	protected LMSBookPersistence lmsBookPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LMSBOOK = "SELECT lmsBook FROM LMSBook lmsBook";
	private static final String _SQL_COUNT_LMSBOOK = "SELECT COUNT(lmsBook) FROM LMSBook lmsBook";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lmsBook.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LMSBook exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LMSBookPersistenceImpl.class);
	private static LMSBook _nullLMSBook = new LMSBookImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LMSBook> toCacheModel() {
				return _nullLMSBookCacheModel;
			}
		};

	private static CacheModel<LMSBook> _nullLMSBookCacheModel = new CacheModel<LMSBook>() {
			public LMSBook toEntityModel() {
				return _nullLMSBook;
			}
		};
}