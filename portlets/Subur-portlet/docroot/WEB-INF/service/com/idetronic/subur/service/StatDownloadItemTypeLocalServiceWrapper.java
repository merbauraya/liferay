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

package com.idetronic.subur.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatDownloadItemTypeLocalService}.
 *
 * @author Mazlan Mat
 * @see StatDownloadItemTypeLocalService
 * @generated
 */
public class StatDownloadItemTypeLocalServiceWrapper
	implements StatDownloadItemTypeLocalService,
		ServiceWrapper<StatDownloadItemTypeLocalService> {
	public StatDownloadItemTypeLocalServiceWrapper(
		StatDownloadItemTypeLocalService statDownloadItemTypeLocalService) {
		_statDownloadItemTypeLocalService = statDownloadItemTypeLocalService;
	}

	/**
	* Adds the stat download item type to the database. Also notifies the appropriate model listeners.
	*
	* @param statDownloadItemType the stat download item type
	* @return the stat download item type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadItemType addStatDownloadItemType(
		com.idetronic.subur.model.StatDownloadItemType statDownloadItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.addStatDownloadItemType(statDownloadItemType);
	}

	/**
	* Creates a new stat download item type with the primary key. Does not add the stat download item type to the database.
	*
	* @param id the primary key for the new stat download item type
	* @return the new stat download item type
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadItemType createStatDownloadItemType(
		long id) {
		return _statDownloadItemTypeLocalService.createStatDownloadItemType(id);
	}

	/**
	* Deletes the stat download item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat download item type
	* @return the stat download item type that was removed
	* @throws PortalException if a stat download item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadItemType deleteStatDownloadItemType(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.deleteStatDownloadItemType(id);
	}

	/**
	* Deletes the stat download item type from the database. Also notifies the appropriate model listeners.
	*
	* @param statDownloadItemType the stat download item type
	* @return the stat download item type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadItemType deleteStatDownloadItemType(
		com.idetronic.subur.model.StatDownloadItemType statDownloadItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.deleteStatDownloadItemType(statDownloadItemType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statDownloadItemTypeLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.StatDownloadItemType fetchStatDownloadItemType(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.fetchStatDownloadItemType(id);
	}

	/**
	* Returns the stat download item type with the primary key.
	*
	* @param id the primary key of the stat download item type
	* @return the stat download item type
	* @throws PortalException if a stat download item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadItemType getStatDownloadItemType(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.getStatDownloadItemType(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the stat download item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download item types
	* @param end the upper bound of the range of stat download item types (not inclusive)
	* @return the range of stat download item types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.StatDownloadItemType> getStatDownloadItemTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.getStatDownloadItemTypes(start,
			end);
	}

	/**
	* Returns the number of stat download item types.
	*
	* @return the number of stat download item types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStatDownloadItemTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.getStatDownloadItemTypesCount();
	}

	/**
	* Updates the stat download item type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statDownloadItemType the stat download item type
	* @return the stat download item type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadItemType updateStatDownloadItemType(
		com.idetronic.subur.model.StatDownloadItemType statDownloadItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadItemTypeLocalService.updateStatDownloadItemType(statDownloadItemType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _statDownloadItemTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_statDownloadItemTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _statDownloadItemTypeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StatDownloadItemTypeLocalService getWrappedStatDownloadItemTypeLocalService() {
		return _statDownloadItemTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStatDownloadItemTypeLocalService(
		StatDownloadItemTypeLocalService statDownloadItemTypeLocalService) {
		_statDownloadItemTypeLocalService = statDownloadItemTypeLocalService;
	}

	@Override
	public StatDownloadItemTypeLocalService getWrappedService() {
		return _statDownloadItemTypeLocalService;
	}

	@Override
	public void setWrappedService(
		StatDownloadItemTypeLocalService statDownloadItemTypeLocalService) {
		_statDownloadItemTypeLocalService = statDownloadItemTypeLocalService;
	}

	private StatDownloadItemTypeLocalService _statDownloadItemTypeLocalService;
}