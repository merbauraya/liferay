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
 * Provides a wrapper for {@link MetadataPropertyLocalService}.
 *
 * @author Mazlan Mat
 * @see MetadataPropertyLocalService
 * @generated
 */
public class MetadataPropertyLocalServiceWrapper
	implements MetadataPropertyLocalService,
		ServiceWrapper<MetadataPropertyLocalService> {
	public MetadataPropertyLocalServiceWrapper(
		MetadataPropertyLocalService metadataPropertyLocalService) {
		_metadataPropertyLocalService = metadataPropertyLocalService;
	}

	/**
	* Adds the metadata property to the database. Also notifies the appropriate model listeners.
	*
	* @param metadataProperty the metadata property
	* @return the metadata property that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataProperty addMetadataProperty(
		com.idetronic.subur.model.MetadataProperty metadataProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.addMetadataProperty(metadataProperty);
	}

	/**
	* Creates a new metadata property with the primary key. Does not add the metadata property to the database.
	*
	* @param metadataPropertyId the primary key for the new metadata property
	* @return the new metadata property
	*/
	@Override
	public com.idetronic.subur.model.MetadataProperty createMetadataProperty(
		long metadataPropertyId) {
		return _metadataPropertyLocalService.createMetadataProperty(metadataPropertyId);
	}

	/**
	* Deletes the metadata property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataPropertyId the primary key of the metadata property
	* @return the metadata property that was removed
	* @throws PortalException if a metadata property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataProperty deleteMetadataProperty(
		long metadataPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.deleteMetadataProperty(metadataPropertyId);
	}

	/**
	* Deletes the metadata property from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataProperty the metadata property
	* @return the metadata property that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataProperty deleteMetadataProperty(
		com.idetronic.subur.model.MetadataProperty metadataProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.deleteMetadataProperty(metadataProperty);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _metadataPropertyLocalService.dynamicQuery();
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
		return _metadataPropertyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _metadataPropertyLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _metadataPropertyLocalService.dynamicQuery(dynamicQuery, start,
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
		return _metadataPropertyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _metadataPropertyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.MetadataProperty fetchMetadataProperty(
		long metadataPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.fetchMetadataProperty(metadataPropertyId);
	}

	/**
	* Returns the metadata property with the primary key.
	*
	* @param metadataPropertyId the primary key of the metadata property
	* @return the metadata property
	* @throws PortalException if a metadata property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataProperty getMetadataProperty(
		long metadataPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.getMetadataProperty(metadataPropertyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the metadata properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata properties
	* @param end the upper bound of the range of metadata properties (not inclusive)
	* @return the range of metadata properties
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.MetadataProperty> getMetadataProperties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.getMetadataProperties(start, end);
	}

	/**
	* Returns the number of metadata properties.
	*
	* @return the number of metadata properties
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMetadataPropertiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.getMetadataPropertiesCount();
	}

	/**
	* Updates the metadata property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param metadataProperty the metadata property
	* @return the metadata property that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataProperty updateMetadataProperty(
		com.idetronic.subur.model.MetadataProperty metadataProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyLocalService.updateMetadataProperty(metadataProperty);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _metadataPropertyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_metadataPropertyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _metadataPropertyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MetadataPropertyLocalService getWrappedMetadataPropertyLocalService() {
		return _metadataPropertyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMetadataPropertyLocalService(
		MetadataPropertyLocalService metadataPropertyLocalService) {
		_metadataPropertyLocalService = metadataPropertyLocalService;
	}

	@Override
	public MetadataPropertyLocalService getWrappedService() {
		return _metadataPropertyLocalService;
	}

	@Override
	public void setWrappedService(
		MetadataPropertyLocalService metadataPropertyLocalService) {
		_metadataPropertyLocalService = metadataPropertyLocalService;
	}

	private MetadataPropertyLocalService _metadataPropertyLocalService;
}