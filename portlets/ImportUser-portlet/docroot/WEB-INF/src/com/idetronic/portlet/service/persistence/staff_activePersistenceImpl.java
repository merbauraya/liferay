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

import com.idetronic.portlet.NoSuchstaff_activeException;
import com.idetronic.portlet.model.impl.staff_activeImpl;
import com.idetronic.portlet.model.impl.staff_activeModelImpl;
import com.idetronic.portlet.model.staff_active;

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
 * The persistence implementation for the staff_active service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see staff_activePersistence
 * @see staff_activeUtil
 * @generated
 */
public class staff_activePersistenceImpl extends BasePersistenceImpl<staff_active>
	implements staff_activePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link staff_activeUtil} to access the staff_active persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = staff_activeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
			staff_activeModelImpl.FINDER_CACHE_ENABLED, staff_activeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
			staff_activeModelImpl.FINDER_CACHE_ENABLED, staff_activeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
			staff_activeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the staff_active in the entity cache if it is enabled.
	 *
	 * @param staff_active the staff_active
	 */
	public void cacheResult(staff_active staff_active) {
		EntityCacheUtil.putResult(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
			staff_activeImpl.class, staff_active.getPrimaryKey(), staff_active);

		staff_active.resetOriginalValues();
	}

	/**
	 * Caches the staff_actives in the entity cache if it is enabled.
	 *
	 * @param staff_actives the staff_actives
	 */
	public void cacheResult(List<staff_active> staff_actives) {
		for (staff_active staff_active : staff_actives) {
			if (EntityCacheUtil.getResult(
						staff_activeModelImpl.ENTITY_CACHE_ENABLED,
						staff_activeImpl.class, staff_active.getPrimaryKey()) == null) {
				cacheResult(staff_active);
			}
			else {
				staff_active.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staff_actives.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(staff_activeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(staff_activeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staff_active.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(staff_active staff_active) {
		EntityCacheUtil.removeResult(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
			staff_activeImpl.class, staff_active.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<staff_active> staff_actives) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (staff_active staff_active : staff_actives) {
			EntityCacheUtil.removeResult(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
				staff_activeImpl.class, staff_active.getPrimaryKey());
		}
	}

	/**
	 * Creates a new staff_active with the primary key. Does not add the staff_active to the database.
	 *
	 * @param bp_no_kp the primary key for the new staff_active
	 * @return the new staff_active
	 */
	public staff_active create(String bp_no_kp) {
		staff_active staff_active = new staff_activeImpl();

		staff_active.setNew(true);
		staff_active.setPrimaryKey(bp_no_kp);

		return staff_active;
	}

	/**
	 * Removes the staff_active with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bp_no_kp the primary key of the staff_active
	 * @return the staff_active that was removed
	 * @throws com.idetronic.portlet.NoSuchstaff_activeException if a staff_active with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public staff_active remove(String bp_no_kp)
		throws NoSuchstaff_activeException, SystemException {
		return remove((Serializable)bp_no_kp);
	}

	/**
	 * Removes the staff_active with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staff_active
	 * @return the staff_active that was removed
	 * @throws com.idetronic.portlet.NoSuchstaff_activeException if a staff_active with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public staff_active remove(Serializable primaryKey)
		throws NoSuchstaff_activeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			staff_active staff_active = (staff_active)session.get(staff_activeImpl.class,
					primaryKey);

			if (staff_active == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchstaff_activeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(staff_active);
		}
		catch (NoSuchstaff_activeException nsee) {
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
	protected staff_active removeImpl(staff_active staff_active)
		throws SystemException {
		staff_active = toUnwrappedModel(staff_active);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, staff_active);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(staff_active);

		return staff_active;
	}

	@Override
	public staff_active updateImpl(
		com.idetronic.portlet.model.staff_active staff_active, boolean merge)
		throws SystemException {
		staff_active = toUnwrappedModel(staff_active);

		boolean isNew = staff_active.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, staff_active, merge);

			staff_active.setNew(false);
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

		EntityCacheUtil.putResult(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
			staff_activeImpl.class, staff_active.getPrimaryKey(), staff_active);

		return staff_active;
	}

	protected staff_active toUnwrappedModel(staff_active staff_active) {
		if (staff_active instanceof staff_activeImpl) {
			return staff_active;
		}

		staff_activeImpl staff_activeImpl = new staff_activeImpl();

		staff_activeImpl.setNew(staff_active.isNew());
		staff_activeImpl.setPrimaryKey(staff_active.getPrimaryKey());

		staff_activeImpl.setBp_name(staff_active.getBp_name());
		staff_activeImpl.setBp_no_pekerja(staff_active.getBp_no_pekerja());
		staff_activeImpl.setBp_no_kp(staff_active.getBp_no_kp());
		staff_activeImpl.setBk_jab_hakiki(staff_active.getBk_jab_hakiki());
		staff_activeImpl.setBk_jab_hakiki_desc(staff_active.getBk_jab_hakiki_desc());
		staff_activeImpl.setBk_jab_sekarang(staff_active.getBk_jab_sekarang());
		staff_activeImpl.setBk_jab_sekarang_desc(staff_active.getBk_jab_sekarang_desc());
		staff_activeImpl.setBk_jaw_jenis(staff_active.getBk_jaw_jenis());
		staff_activeImpl.setAl_alamat1(staff_active.getAl_alamat1());
		staff_activeImpl.setAl_alamat2(staff_active.getAl_alamat2());
		staff_activeImpl.setAl_alamat3(staff_active.getAl_alamat3());
		staff_activeImpl.setAl_poskod(staff_active.getAl_poskod());
		staff_activeImpl.setAl_bandar(staff_active.getAl_bandar());
		staff_activeImpl.setAl_negeri(staff_active.getAl_negeri());
		staff_activeImpl.setAl_negara(staff_active.getAl_negara());
		staff_activeImpl.setBp_telefon(staff_active.getBp_telefon());
		staff_activeImpl.setBp_email(staff_active.getBp_email());
		staff_activeImpl.setBp_tjangka_bsara(staff_active.getBp_tjangka_bsara());
		staff_activeImpl.setBp_rekod_status(staff_active.getBp_rekod_status());
		staff_activeImpl.setBk_jaw_hakiki(staff_active.getBk_jaw_hakiki());
		staff_activeImpl.setBk_jaw_hakiki_desc(staff_active.getBk_jaw_hakiki_desc());
		staff_activeImpl.setBk_jaw_sekarang(staff_active.getBk_jaw_sekarang());
		staff_activeImpl.setBk_jaw_sekarang_desc(staff_active.getBk_jaw_sekarang_desc());
		staff_activeImpl.setBk_tarikh_lahir(staff_active.getBk_tarikh_lahir());
		staff_activeImpl.setBk_tarikh_masuk(staff_active.getBk_tarikh_masuk());
		staff_activeImpl.setBk_rekod_status(staff_active.getBk_rekod_status());

		return staff_activeImpl;
	}

	/**
	 * Returns the staff_active with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the staff_active
	 * @return the staff_active
	 * @throws com.liferay.portal.NoSuchModelException if a staff_active with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public staff_active findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the staff_active with the primary key or throws a {@link com.idetronic.portlet.NoSuchstaff_activeException} if it could not be found.
	 *
	 * @param bp_no_kp the primary key of the staff_active
	 * @return the staff_active
	 * @throws com.idetronic.portlet.NoSuchstaff_activeException if a staff_active with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public staff_active findByPrimaryKey(String bp_no_kp)
		throws NoSuchstaff_activeException, SystemException {
		staff_active staff_active = fetchByPrimaryKey(bp_no_kp);

		if (staff_active == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bp_no_kp);
			}

			throw new NoSuchstaff_activeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bp_no_kp);
		}

		return staff_active;
	}

	/**
	 * Returns the staff_active with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staff_active
	 * @return the staff_active, or <code>null</code> if a staff_active with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public staff_active fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the staff_active with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bp_no_kp the primary key of the staff_active
	 * @return the staff_active, or <code>null</code> if a staff_active with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public staff_active fetchByPrimaryKey(String bp_no_kp)
		throws SystemException {
		staff_active staff_active = (staff_active)EntityCacheUtil.getResult(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
				staff_activeImpl.class, bp_no_kp);

		if (staff_active == _nullstaff_active) {
			return null;
		}

		if (staff_active == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				staff_active = (staff_active)session.get(staff_activeImpl.class,
						bp_no_kp);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (staff_active != null) {
					cacheResult(staff_active);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(staff_activeModelImpl.ENTITY_CACHE_ENABLED,
						staff_activeImpl.class, bp_no_kp, _nullstaff_active);
				}

				closeSession(session);
			}
		}

		return staff_active;
	}

	/**
	 * Returns all the staff_actives.
	 *
	 * @return the staff_actives
	 * @throws SystemException if a system exception occurred
	 */
	public List<staff_active> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staff_actives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of staff_actives
	 * @param end the upper bound of the range of staff_actives (not inclusive)
	 * @return the range of staff_actives
	 * @throws SystemException if a system exception occurred
	 */
	public List<staff_active> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staff_actives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of staff_actives
	 * @param end the upper bound of the range of staff_actives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staff_actives
	 * @throws SystemException if a system exception occurred
	 */
	public List<staff_active> findAll(int start, int end,
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

		List<staff_active> list = (List<staff_active>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STAFF_ACTIVE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STAFF_ACTIVE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<staff_active>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<staff_active>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the staff_actives from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (staff_active staff_active : findAll()) {
			remove(staff_active);
		}
	}

	/**
	 * Returns the number of staff_actives.
	 *
	 * @return the number of staff_actives
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STAFF_ACTIVE);

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
	 * Initializes the staff_active persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.portlet.model.staff_active")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<staff_active>> listenersList = new ArrayList<ModelListener<staff_active>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<staff_active>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(staff_activeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = staff_activePersistence.class)
	protected staff_activePersistence staff_activePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_STAFF_ACTIVE = "SELECT staff_active FROM staff_active staff_active";
	private static final String _SQL_COUNT_STAFF_ACTIVE = "SELECT COUNT(staff_active) FROM staff_active staff_active";
	private static final String _ORDER_BY_ENTITY_ALIAS = "staff_active.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No staff_active exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(staff_activePersistenceImpl.class);
	private static staff_active _nullstaff_active = new staff_activeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<staff_active> toCacheModel() {
				return _nullstaff_activeCacheModel;
			}
		};

	private static CacheModel<staff_active> _nullstaff_activeCacheModel = new CacheModel<staff_active>() {
			public staff_active toEntityModel() {
				return _nullstaff_active;
			}
		};
}