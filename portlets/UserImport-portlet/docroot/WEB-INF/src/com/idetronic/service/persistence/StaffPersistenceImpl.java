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

package com.idetronic.service.persistence;

import com.idetronic.NoSuchStaffException;

import com.idetronic.model.Staff;
import com.idetronic.model.impl.StaffImpl;
import com.idetronic.model.impl.StaffModelImpl;

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
 * The persistence implementation for the Staff service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StaffPersistence
 * @see StaffUtil
 * @generated
 */
public class StaffPersistenceImpl extends BasePersistenceImpl<Staff>
	implements StaffPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StaffUtil} to access the Staff persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StaffImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffModelImpl.FINDER_CACHE_ENABLED, StaffImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffModelImpl.FINDER_CACHE_ENABLED, StaffImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Staff in the entity cache if it is enabled.
	 *
	 * @param staff the Staff
	 */
	public void cacheResult(Staff staff) {
		EntityCacheUtil.putResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffImpl.class, staff.getPrimaryKey(), staff);

		staff.resetOriginalValues();
	}

	/**
	 * Caches the Staffs in the entity cache if it is enabled.
	 *
	 * @param staffs the Staffs
	 */
	public void cacheResult(List<Staff> staffs) {
		for (Staff staff : staffs) {
			if (EntityCacheUtil.getResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
						StaffImpl.class, staff.getPrimaryKey()) == null) {
				cacheResult(staff);
			}
			else {
				staff.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Staffs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StaffImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StaffImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Staff.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Staff staff) {
		EntityCacheUtil.removeResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffImpl.class, staff.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Staff> staffs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Staff staff : staffs) {
			EntityCacheUtil.removeResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
				StaffImpl.class, staff.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Staff with the primary key. Does not add the Staff to the database.
	 *
	 * @param bp_no_kp the primary key for the new Staff
	 * @return the new Staff
	 */
	public Staff create(String bp_no_kp) {
		Staff staff = new StaffImpl();

		staff.setNew(true);
		staff.setPrimaryKey(bp_no_kp);

		return staff;
	}

	/**
	 * Removes the Staff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bp_no_kp the primary key of the Staff
	 * @return the Staff that was removed
	 * @throws com.idetronic.NoSuchStaffException if a Staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Staff remove(String bp_no_kp)
		throws NoSuchStaffException, SystemException {
		return remove((Serializable)bp_no_kp);
	}

	/**
	 * Removes the Staff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Staff
	 * @return the Staff that was removed
	 * @throws com.idetronic.NoSuchStaffException if a Staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff remove(Serializable primaryKey)
		throws NoSuchStaffException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Staff staff = (Staff)session.get(StaffImpl.class, primaryKey);

			if (staff == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStaffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(staff);
		}
		catch (NoSuchStaffException nsee) {
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
	protected Staff removeImpl(Staff staff) throws SystemException {
		staff = toUnwrappedModel(staff);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, staff);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(staff);

		return staff;
	}

	@Override
	public Staff updateImpl(com.idetronic.model.Staff staff, boolean merge)
		throws SystemException {
		staff = toUnwrappedModel(staff);

		boolean isNew = staff.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, staff, merge);

			staff.setNew(false);
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

		EntityCacheUtil.putResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffImpl.class, staff.getPrimaryKey(), staff);

		return staff;
	}

	protected Staff toUnwrappedModel(Staff staff) {
		if (staff instanceof StaffImpl) {
			return staff;
		}

		StaffImpl staffImpl = new StaffImpl();

		staffImpl.setNew(staff.isNew());
		staffImpl.setPrimaryKey(staff.getPrimaryKey());

		staffImpl.setBp_name(staff.getBp_name());
		staffImpl.setBp_no_pekerja(staff.getBp_no_pekerja());
		staffImpl.setBp_no_kp(staff.getBp_no_kp());
		staffImpl.setBk_jab_hakiki(staff.getBk_jab_hakiki());
		staffImpl.setBk_jab_hakiki_desc(staff.getBk_jab_hakiki_desc());
		staffImpl.setBk_jab_sekarang(staff.getBk_jab_sekarang());
		staffImpl.setBk_jab_sekarang_desc(staff.getBk_jab_sekarang_desc());
		staffImpl.setBk_jaw_jenis(staff.getBk_jaw_jenis());
		staffImpl.setAl_alamat1(staff.getAl_alamat1());
		staffImpl.setAl_alamat2(staff.getAl_alamat2());
		staffImpl.setAl_alamat3(staff.getAl_alamat3());
		staffImpl.setAl_poskod(staff.getAl_poskod());
		staffImpl.setAl_bandar(staff.getAl_bandar());
		staffImpl.setAl_negeri(staff.getAl_negeri());
		staffImpl.setAl_negara(staff.getAl_negara());
		staffImpl.setBp_telefon(staff.getBp_telefon());
		staffImpl.setBp_email(staff.getBp_email());
		staffImpl.setBp_tjangka_bsara(staff.getBp_tjangka_bsara());
		staffImpl.setBp_rekod_status(staff.getBp_rekod_status());
		staffImpl.setBk_jaw_hakiki(staff.getBk_jaw_hakiki());
		staffImpl.setBk_jaw_hakiki_desc(staff.getBk_jaw_hakiki_desc());
		staffImpl.setBk_jaw_sekarang(staff.getBk_jaw_sekarang());
		staffImpl.setBk_jaw_sekarang_desc(staff.getBk_jaw_sekarang_desc());
		staffImpl.setBk_tarikh_lahir(staff.getBk_tarikh_lahir());
		staffImpl.setBk_tarikh_masuk(staff.getBk_tarikh_masuk());
		staffImpl.setBk_rekod_status(staff.getBk_rekod_status());

		return staffImpl;
	}

	/**
	 * Returns the Staff with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Staff
	 * @return the Staff
	 * @throws com.liferay.portal.NoSuchModelException if a Staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the Staff with the primary key or throws a {@link com.idetronic.NoSuchStaffException} if it could not be found.
	 *
	 * @param bp_no_kp the primary key of the Staff
	 * @return the Staff
	 * @throws com.idetronic.NoSuchStaffException if a Staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Staff findByPrimaryKey(String bp_no_kp)
		throws NoSuchStaffException, SystemException {
		Staff staff = fetchByPrimaryKey(bp_no_kp);

		if (staff == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bp_no_kp);
			}

			throw new NoSuchStaffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bp_no_kp);
		}

		return staff;
	}

	/**
	 * Returns the Staff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Staff
	 * @return the Staff, or <code>null</code> if a Staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the Staff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bp_no_kp the primary key of the Staff
	 * @return the Staff, or <code>null</code> if a Staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Staff fetchByPrimaryKey(String bp_no_kp) throws SystemException {
		Staff staff = (Staff)EntityCacheUtil.getResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
				StaffImpl.class, bp_no_kp);

		if (staff == _nullStaff) {
			return null;
		}

		if (staff == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				staff = (Staff)session.get(StaffImpl.class, bp_no_kp);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (staff != null) {
					cacheResult(staff);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
						StaffImpl.class, bp_no_kp, _nullStaff);
				}

				closeSession(session);
			}
		}

		return staff;
	}

	/**
	 * Returns all the Staffs.
	 *
	 * @return the Staffs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Staff> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Staffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Staffs
	 * @param end the upper bound of the range of Staffs (not inclusive)
	 * @return the range of Staffs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Staff> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Staffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Staffs
	 * @param end the upper bound of the range of Staffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Staffs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Staff> findAll(int start, int end,
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

		List<Staff> list = (List<Staff>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STAFF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STAFF;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Staff>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Staff>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the Staffs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Staff staff : findAll()) {
			remove(staff);
		}
	}

	/**
	 * Returns the number of Staffs.
	 *
	 * @return the number of Staffs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STAFF);

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
	 * Initializes the Staff persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.model.Staff")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Staff>> listenersList = new ArrayList<ModelListener<Staff>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<Staff>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StaffImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = StaffPersistence.class)
	protected StaffPersistence staffPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_STAFF = "SELECT staff FROM Staff staff";
	private static final String _SQL_COUNT_STAFF = "SELECT COUNT(staff) FROM Staff staff";
	private static final String _ORDER_BY_ENTITY_ALIAS = "staff.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Staff exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StaffPersistenceImpl.class);
	private static Staff _nullStaff = new StaffImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Staff> toCacheModel() {
				return _nullStaffCacheModel;
			}
		};

	private static CacheModel<Staff> _nullStaffCacheModel = new CacheModel<Staff>() {
			public Staff toEntityModel() {
				return _nullStaff;
			}
		};
}