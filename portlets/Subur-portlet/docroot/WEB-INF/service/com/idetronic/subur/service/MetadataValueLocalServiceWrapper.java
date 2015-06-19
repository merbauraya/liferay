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
 * Provides a wrapper for {@link MetadataValueLocalService}.
 *
 * @author Mazlan Mat
 * @see MetadataValueLocalService
 * @generated
 */
public class MetadataValueLocalServiceWrapper
	implements MetadataValueLocalService,
		ServiceWrapper<MetadataValueLocalService> {
	public MetadataValueLocalServiceWrapper(
		MetadataValueLocalService metadataValueLocalService) {
		_metadataValueLocalService = metadataValueLocalService;
	}

	/**
	* Adds the metadata value to the database. Also notifies the appropriate model listeners.
	*
	* @param metadataValue the metadata value
	* @return the metadata value that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataValue addMetadataValue(
		com.idetronic.subur.model.MetadataValue metadataValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.addMetadataValue(metadataValue);
	}

	/**
	* Creates a new metadata value with the primary key. Does not add the metadata value to the database.
	*
	* @param metadataValueId the primary key for the new metadata value
	* @return the new metadata value
	*/
	@Override
	public com.idetronic.subur.model.MetadataValue createMetadataValue(
		long metadataValueId) {
		return _metadataValueLocalService.createMetadataValue(metadataValueId);
	}

	/**
	* Deletes the metadata value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataValueId the primary key of the metadata value
	* @return the metadata value that was removed
	* @throws PortalException if a metadata value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataValue deleteMetadataValue(
		long metadataValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.deleteMetadataValue(metadataValueId);
	}

	/**
	* Deletes the metadata value from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataValue the metadata value
	* @return the metadata value that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataValue deleteMetadataValue(
		com.idetronic.subur.model.MetadataValue metadataValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.deleteMetadataValue(metadataValue);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _metadataValueLocalService.dynamicQuery();
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
		return _metadataValueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _metadataValueLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _metadataValueLocalService.dynamicQuery(dynamicQuery, start,
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
		return _metadataValueLocalService.dynamicQueryCount(dynamicQuery);
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
		return _metadataValueLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.MetadataValue fetchMetadataValue(
		long metadataValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.fetchMetadataValue(metadataValueId);
	}

	/**
	* Returns the metadata value with the primary key.
	*
	* @param metadataValueId the primary key of the metadata value
	* @return the metadata value
	* @throws PortalException if a metadata value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataValue getMetadataValue(
		long metadataValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.getMetadataValue(metadataValueId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the metadata values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata values
	* @param end the upper bound of the range of metadata values (not inclusive)
	* @return the range of metadata values
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.MetadataValue> getMetadataValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.getMetadataValues(start, end);
	}

	/**
	* Returns the number of metadata values.
	*
	* @return the number of metadata values
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMetadataValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.getMetadataValuesCount();
	}

	/**
	* Updates the metadata value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param metadataValue the metadata value
	* @return the metadata value that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataValue updateMetadataValue(
		com.idetronic.subur.model.MetadataValue metadataValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataValueLocalService.updateMetadataValue(metadataValue);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _metadataValueLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_metadataValueLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _metadataValueLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MetadataValueLocalService getWrappedMetadataValueLocalService() {
		return _metadataValueLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMetadataValueLocalService(
		MetadataValueLocalService metadataValueLocalService) {
		_metadataValueLocalService = metadataValueLocalService;
	}

	@Override
	public MetadataValueLocalService getWrappedService() {
		return _metadataValueLocalService;
	}

	@Override
	public void setWrappedService(
		MetadataValueLocalService metadataValueLocalService) {
		_metadataValueLocalService = metadataValueLocalService;
	}

	private MetadataValueLocalService _metadataValueLocalService;
}