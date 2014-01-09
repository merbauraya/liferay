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

package com.idetronic.eprint.service.base;

import com.idetronic.eprint.model.EprintSubject;
import com.idetronic.eprint.service.EprintSubjectLocalService;
import com.idetronic.eprint.service.EprintSubjectService;
import com.idetronic.eprint.service.persistence.EprintSubjectPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the eprint subject local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.idetronic.eprint.service.impl.EprintSubjectLocalServiceImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eprint.service.impl.EprintSubjectLocalServiceImpl
 * @see com.idetronic.eprint.service.EprintSubjectLocalServiceUtil
 * @generated
 */
public abstract class EprintSubjectLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements EprintSubjectLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.idetronic.eprint.service.EprintSubjectLocalServiceUtil} to access the eprint subject local service.
	 */

	/**
	 * Adds the eprint subject to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eprintSubject the eprint subject
	 * @return the eprint subject that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EprintSubject addEprintSubject(EprintSubject eprintSubject)
		throws SystemException {
		eprintSubject.setNew(true);

		return eprintSubjectPersistence.update(eprintSubject, false);
	}

	/**
	 * Creates a new eprint subject with the primary key. Does not add the eprint subject to the database.
	 *
	 * @param eprintId the primary key for the new eprint subject
	 * @return the new eprint subject
	 */
	public EprintSubject createEprintSubject(long eprintId) {
		return eprintSubjectPersistence.create(eprintId);
	}

	/**
	 * Deletes the eprint subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eprintId the primary key of the eprint subject
	 * @return the eprint subject that was removed
	 * @throws PortalException if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public EprintSubject deleteEprintSubject(long eprintId)
		throws PortalException, SystemException {
		return eprintSubjectPersistence.remove(eprintId);
	}

	/**
	 * Deletes the eprint subject from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eprintSubject the eprint subject
	 * @return the eprint subject that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public EprintSubject deleteEprintSubject(EprintSubject eprintSubject)
		throws SystemException {
		return eprintSubjectPersistence.remove(eprintSubject);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(EprintSubject.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return eprintSubjectPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return eprintSubjectPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return eprintSubjectPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return eprintSubjectPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public EprintSubject fetchEprintSubject(long eprintId)
		throws SystemException {
		return eprintSubjectPersistence.fetchByPrimaryKey(eprintId);
	}

	/**
	 * Returns the eprint subject with the primary key.
	 *
	 * @param eprintId the primary key of the eprint subject
	 * @return the eprint subject
	 * @throws PortalException if a eprint subject with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EprintSubject getEprintSubject(long eprintId)
		throws PortalException, SystemException {
		return eprintSubjectPersistence.findByPrimaryKey(eprintId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return eprintSubjectPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the eprint subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprint subjects
	 * @param end the upper bound of the range of eprint subjects (not inclusive)
	 * @return the range of eprint subjects
	 * @throws SystemException if a system exception occurred
	 */
	public List<EprintSubject> getEprintSubjects(int start, int end)
		throws SystemException {
		return eprintSubjectPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of eprint subjects.
	 *
	 * @return the number of eprint subjects
	 * @throws SystemException if a system exception occurred
	 */
	public int getEprintSubjectsCount() throws SystemException {
		return eprintSubjectPersistence.countAll();
	}

	/**
	 * Updates the eprint subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eprintSubject the eprint subject
	 * @return the eprint subject that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EprintSubject updateEprintSubject(EprintSubject eprintSubject)
		throws SystemException {
		return updateEprintSubject(eprintSubject, true);
	}

	/**
	 * Updates the eprint subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eprintSubject the eprint subject
	 * @param merge whether to merge the eprint subject with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the eprint subject that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EprintSubject updateEprintSubject(EprintSubject eprintSubject,
		boolean merge) throws SystemException {
		eprintSubject.setNew(false);

		return eprintSubjectPersistence.update(eprintSubject, merge);
	}

	/**
	 * Returns the eprint subject local service.
	 *
	 * @return the eprint subject local service
	 */
	public EprintSubjectLocalService getEprintSubjectLocalService() {
		return eprintSubjectLocalService;
	}

	/**
	 * Sets the eprint subject local service.
	 *
	 * @param eprintSubjectLocalService the eprint subject local service
	 */
	public void setEprintSubjectLocalService(
		EprintSubjectLocalService eprintSubjectLocalService) {
		this.eprintSubjectLocalService = eprintSubjectLocalService;
	}

	/**
	 * Returns the eprint subject remote service.
	 *
	 * @return the eprint subject remote service
	 */
	public EprintSubjectService getEprintSubjectService() {
		return eprintSubjectService;
	}

	/**
	 * Sets the eprint subject remote service.
	 *
	 * @param eprintSubjectService the eprint subject remote service
	 */
	public void setEprintSubjectService(
		EprintSubjectService eprintSubjectService) {
		this.eprintSubjectService = eprintSubjectService;
	}

	/**
	 * Returns the eprint subject persistence.
	 *
	 * @return the eprint subject persistence
	 */
	public EprintSubjectPersistence getEprintSubjectPersistence() {
		return eprintSubjectPersistence;
	}

	/**
	 * Sets the eprint subject persistence.
	 *
	 * @param eprintSubjectPersistence the eprint subject persistence
	 */
	public void setEprintSubjectPersistence(
		EprintSubjectPersistence eprintSubjectPersistence) {
		this.eprintSubjectPersistence = eprintSubjectPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.idetronic.eprint.model.EprintSubject",
			eprintSubjectLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.idetronic.eprint.model.EprintSubject");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return EprintSubject.class;
	}

	protected String getModelClassName() {
		return EprintSubject.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = eprintSubjectPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = EprintSubjectLocalService.class)
	protected EprintSubjectLocalService eprintSubjectLocalService;
	@BeanReference(type = EprintSubjectService.class)
	protected EprintSubjectService eprintSubjectService;
	@BeanReference(type = EprintSubjectPersistence.class)
	protected EprintSubjectPersistence eprintSubjectPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private EprintSubjectLocalServiceClpInvoker _clpInvoker = new EprintSubjectLocalServiceClpInvoker();
}