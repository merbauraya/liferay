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

package com.idetronic.portlet.serviceexperience.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServiceExperienceLocalService}.
 *
 * @author Mazlan Mat
 * @see ServiceExperienceLocalService
 * @generated
 */
public class ServiceExperienceLocalServiceWrapper
	implements ServiceExperienceLocalService,
		ServiceWrapper<ServiceExperienceLocalService> {
	public ServiceExperienceLocalServiceWrapper(
		ServiceExperienceLocalService serviceExperienceLocalService) {
		_serviceExperienceLocalService = serviceExperienceLocalService;
	}

	/**
	* Adds the service experience to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceExperience the service experience
	* @return the service experience that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience addServiceExperience(
		com.idetronic.portlet.serviceexperience.model.ServiceExperience serviceExperience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.addServiceExperience(serviceExperience);
	}

	/**
	* Creates a new service experience with the primary key. Does not add the service experience to the database.
	*
	* @param serviceExperienceId the primary key for the new service experience
	* @return the new service experience
	*/
	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience createServiceExperience(
		long serviceExperienceId) {
		return _serviceExperienceLocalService.createServiceExperience(serviceExperienceId);
	}

	/**
	* Deletes the service experience with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience that was removed
	* @throws PortalException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience deleteServiceExperience(
		long serviceExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.deleteServiceExperience(serviceExperienceId);
	}

	/**
	* Deletes the service experience from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceExperience the service experience
	* @return the service experience that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience deleteServiceExperience(
		com.idetronic.portlet.serviceexperience.model.ServiceExperience serviceExperience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.deleteServiceExperience(serviceExperience);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceExperienceLocalService.dynamicQuery();
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
		return _serviceExperienceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceExperienceLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceExperienceLocalService.dynamicQuery(dynamicQuery, start,
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
		return _serviceExperienceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _serviceExperienceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience fetchServiceExperience(
		long serviceExperienceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.fetchServiceExperience(serviceExperienceId);
	}

	/**
	* Returns the service experience with the primary key.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience
	* @throws PortalException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience getServiceExperience(
		long serviceExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.getServiceExperience(serviceExperienceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service experiences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @return the range of service experiences
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> getServiceExperiences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.getServiceExperiences(start, end);
	}

	/**
	* Returns the number of service experiences.
	*
	* @return the number of service experiences
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getServiceExperiencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.getServiceExperiencesCount();
	}

	/**
	* Updates the service experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceExperience the service experience
	* @return the service experience that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience updateServiceExperience(
		com.idetronic.portlet.serviceexperience.model.ServiceExperience serviceExperience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.updateServiceExperience(serviceExperience);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _serviceExperienceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_serviceExperienceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _serviceExperienceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> getUserServiceExperience(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.getUserServiceExperience(userId);
	}

	@Override
	public int getUserServiceExperienceCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.getUserServiceExperienceCount(userId);
	}

	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience addServiceExperience(
		long userId, java.lang.String title, int startDateMonth,
		int startDateDay, int startDateYear, int endDateMonth, int endDateDay,
		int endDateYear, boolean current, java.lang.String data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.addServiceExperience(userId,
			title, startDateMonth, startDateDay, startDateYear, endDateMonth,
			endDateDay, endDateYear, current, data);
	}

	@Override
	public com.idetronic.portlet.serviceexperience.model.ServiceExperience updateServiceExperience(
		long serviceExperienceId, java.lang.String title, int startDateMonth,
		int startDateDay, int startDateYear, int endDateMonth, int endDateDay,
		int endDateYear, boolean current, java.lang.String data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperienceLocalService.updateServiceExperience(serviceExperienceId,
			title, startDateMonth, startDateDay, startDateYear, endDateMonth,
			endDateDay, endDateYear, current, data);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ServiceExperienceLocalService getWrappedServiceExperienceLocalService() {
		return _serviceExperienceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedServiceExperienceLocalService(
		ServiceExperienceLocalService serviceExperienceLocalService) {
		_serviceExperienceLocalService = serviceExperienceLocalService;
	}

	@Override
	public ServiceExperienceLocalService getWrappedService() {
		return _serviceExperienceLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceExperienceLocalService serviceExperienceLocalService) {
		_serviceExperienceLocalService = serviceExperienceLocalService;
	}

	private ServiceExperienceLocalService _serviceExperienceLocalService;
}