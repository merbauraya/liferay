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
 * Provides a wrapper for {@link MetadataPropertyValueLocalService}.
 *
 * @author Mazlan Mat
 * @see MetadataPropertyValueLocalService
 * @generated
 */
public class MetadataPropertyValueLocalServiceWrapper
	implements MetadataPropertyValueLocalService,
		ServiceWrapper<MetadataPropertyValueLocalService> {
	public MetadataPropertyValueLocalServiceWrapper(
		MetadataPropertyValueLocalService metadataPropertyValueLocalService) {
		_metadataPropertyValueLocalService = metadataPropertyValueLocalService;
	}

	/**
	* Adds the metadata property value to the database. Also notifies the appropriate model listeners.
	*
	* @param metadataPropertyValue the metadata property value
	* @return the metadata property value that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataPropertyValue addMetadataPropertyValue(
		com.idetronic.subur.model.MetadataPropertyValue metadataPropertyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.addMetadataPropertyValue(metadataPropertyValue);
	}

	/**
	* Creates a new metadata property value with the primary key. Does not add the metadata property value to the database.
	*
	* @param metadataPropertyValueId the primary key for the new metadata property value
	* @return the new metadata property value
	*/
	@Override
	public com.idetronic.subur.model.MetadataPropertyValue createMetadataPropertyValue(
		long metadataPropertyValueId) {
		return _metadataPropertyValueLocalService.createMetadataPropertyValue(metadataPropertyValueId);
	}

	/**
	* Deletes the metadata property value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataPropertyValueId the primary key of the metadata property value
	* @return the metadata property value that was removed
	* @throws PortalException if a metadata property value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataPropertyValue deleteMetadataPropertyValue(
		long metadataPropertyValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.deleteMetadataPropertyValue(metadataPropertyValueId);
	}

	/**
	* Deletes the metadata property value from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataPropertyValue the metadata property value
	* @return the metadata property value that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataPropertyValue deleteMetadataPropertyValue(
		com.idetronic.subur.model.MetadataPropertyValue metadataPropertyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.deleteMetadataPropertyValue(metadataPropertyValue);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _metadataPropertyValueLocalService.dynamicQuery();
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
		return _metadataPropertyValueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _metadataPropertyValueLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _metadataPropertyValueLocalService.dynamicQuery(dynamicQuery,
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
		return _metadataPropertyValueLocalService.dynamicQueryCount(dynamicQuery);
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
		return _metadataPropertyValueLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.MetadataPropertyValue fetchMetadataPropertyValue(
		long metadataPropertyValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.fetchMetadataPropertyValue(metadataPropertyValueId);
	}

	/**
	* Returns the metadata property value with the primary key.
	*
	* @param metadataPropertyValueId the primary key of the metadata property value
	* @return the metadata property value
	* @throws PortalException if a metadata property value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataPropertyValue getMetadataPropertyValue(
		long metadataPropertyValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.getMetadataPropertyValue(metadataPropertyValueId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the metadata property values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata property values
	* @param end the upper bound of the range of metadata property values (not inclusive)
	* @return the range of metadata property values
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.MetadataPropertyValue> getMetadataPropertyValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.getMetadataPropertyValues(start,
			end);
	}

	/**
	* Returns the number of metadata property values.
	*
	* @return the number of metadata property values
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMetadataPropertyValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.getMetadataPropertyValuesCount();
	}

	/**
	* Updates the metadata property value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param metadataPropertyValue the metadata property value
	* @return the metadata property value that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.MetadataPropertyValue updateMetadataPropertyValue(
		com.idetronic.subur.model.MetadataPropertyValue metadataPropertyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.updateMetadataPropertyValue(metadataPropertyValue);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _metadataPropertyValueLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_metadataPropertyValueLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _metadataPropertyValueLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.idetronic.subur.model.MetadataPropertyValue addMetadataPropertyValue(
		long itemId, long metadataId, java.lang.String textValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.addMetadataPropertyValue(itemId,
			metadataId, textValue);
	}

	@Override
	public com.idetronic.subur.model.MetadataPropertyValue updateMetadataPropertyValue(
		long metadataPropertyValueId, long itemId, long metadataId,
		java.lang.String textValue)
		throws com.idetronic.subur.NoSuchMetadataPropertyValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return _metadataPropertyValueLocalService.updateMetadataPropertyValue(metadataPropertyValueId,
			itemId, metadataId, textValue);
	}

	@Override
	public java.util.List getAdditionalMetadata(long itemId) {
		return _metadataPropertyValueLocalService.getAdditionalMetadata(itemId);
	}

	@Override
	public java.util.List getAuthor(long itemId) {
		return _metadataPropertyValueLocalService.getAuthor(itemId);
	}

	@Override
	public java.util.List getByItemId(long itemId) {
		return _metadataPropertyValueLocalService.getByItemId(itemId);
	}

	@Override
	public java.util.List getItemCountAuthorBySubject(long subjectId) {
		return _metadataPropertyValueLocalService.getItemCountAuthorBySubject(subjectId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MetadataPropertyValueLocalService getWrappedMetadataPropertyValueLocalService() {
		return _metadataPropertyValueLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMetadataPropertyValueLocalService(
		MetadataPropertyValueLocalService metadataPropertyValueLocalService) {
		_metadataPropertyValueLocalService = metadataPropertyValueLocalService;
	}

	@Override
	public MetadataPropertyValueLocalService getWrappedService() {
		return _metadataPropertyValueLocalService;
	}

	@Override
	public void setWrappedService(
		MetadataPropertyValueLocalService metadataPropertyValueLocalService) {
		_metadataPropertyValueLocalService = metadataPropertyValueLocalService;
	}

	private MetadataPropertyValueLocalService _metadataPropertyValueLocalService;
}