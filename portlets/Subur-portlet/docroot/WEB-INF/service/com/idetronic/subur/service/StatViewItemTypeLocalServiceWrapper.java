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
 * Provides a wrapper for {@link StatViewItemTypeLocalService}.
 *
 * @author Mazlan Mat
 * @see StatViewItemTypeLocalService
 * @generated
 */
public class StatViewItemTypeLocalServiceWrapper
	implements StatViewItemTypeLocalService,
		ServiceWrapper<StatViewItemTypeLocalService> {
	public StatViewItemTypeLocalServiceWrapper(
		StatViewItemTypeLocalService statViewItemTypeLocalService) {
		_statViewItemTypeLocalService = statViewItemTypeLocalService;
	}

	/**
	* Adds the stat view item type to the database. Also notifies the appropriate model listeners.
	*
	* @param statViewItemType the stat view item type
	* @return the stat view item type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewItemType addStatViewItemType(
		com.idetronic.subur.model.StatViewItemType statViewItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.addStatViewItemType(statViewItemType);
	}

	/**
	* Creates a new stat view item type with the primary key. Does not add the stat view item type to the database.
	*
	* @param id the primary key for the new stat view item type
	* @return the new stat view item type
	*/
	@Override
	public com.idetronic.subur.model.StatViewItemType createStatViewItemType(
		long id) {
		return _statViewItemTypeLocalService.createStatViewItemType(id);
	}

	/**
	* Deletes the stat view item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat view item type
	* @return the stat view item type that was removed
	* @throws PortalException if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewItemType deleteStatViewItemType(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.deleteStatViewItemType(id);
	}

	/**
	* Deletes the stat view item type from the database. Also notifies the appropriate model listeners.
	*
	* @param statViewItemType the stat view item type
	* @return the stat view item type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewItemType deleteStatViewItemType(
		com.idetronic.subur.model.StatViewItemType statViewItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.deleteStatViewItemType(statViewItemType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statViewItemTypeLocalService.dynamicQuery();
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
		return _statViewItemTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statViewItemTypeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statViewItemTypeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _statViewItemTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _statViewItemTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.StatViewItemType fetchStatViewItemType(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.fetchStatViewItemType(id);
	}

	/**
	* Returns the stat view item type with the primary key.
	*
	* @param id the primary key of the stat view item type
	* @return the stat view item type
	* @throws PortalException if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewItemType getStatViewItemType(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.getStatViewItemType(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the stat view item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view item types
	* @param end the upper bound of the range of stat view item types (not inclusive)
	* @return the range of stat view item types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.StatViewItemType> getStatViewItemTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.getStatViewItemTypes(start, end);
	}

	/**
	* Returns the number of stat view item types.
	*
	* @return the number of stat view item types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStatViewItemTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.getStatViewItemTypesCount();
	}

	/**
	* Updates the stat view item type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statViewItemType the stat view item type
	* @return the stat view item type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatViewItemType updateStatViewItemType(
		com.idetronic.subur.model.StatViewItemType statViewItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statViewItemTypeLocalService.updateStatViewItemType(statViewItemType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _statViewItemTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_statViewItemTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _statViewItemTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StatViewItemTypeLocalService getWrappedStatViewItemTypeLocalService() {
		return _statViewItemTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStatViewItemTypeLocalService(
		StatViewItemTypeLocalService statViewItemTypeLocalService) {
		_statViewItemTypeLocalService = statViewItemTypeLocalService;
	}

	@Override
	public StatViewItemTypeLocalService getWrappedService() {
		return _statViewItemTypeLocalService;
	}

	@Override
	public void setWrappedService(
		StatViewItemTypeLocalService statViewItemTypeLocalService) {
		_statViewItemTypeLocalService = statViewItemTypeLocalService;
	}

	private StatViewItemTypeLocalService _statViewItemTypeLocalService;
}