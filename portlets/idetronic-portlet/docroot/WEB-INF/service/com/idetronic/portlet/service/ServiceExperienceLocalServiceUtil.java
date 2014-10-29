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

package com.idetronic.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ServiceExperience. This utility wraps
 * {@link com.idetronic.portlet.service.impl.ServiceExperienceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see ServiceExperienceLocalService
 * @see com.idetronic.portlet.service.base.ServiceExperienceLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.impl.ServiceExperienceLocalServiceImpl
 * @generated
 */
public class ServiceExperienceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.portlet.service.impl.ServiceExperienceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the service experience to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceExperience the service experience
	* @return the service experience that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ServiceExperience addServiceExperience(
		com.idetronic.portlet.model.ServiceExperience serviceExperience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addServiceExperience(serviceExperience);
	}

	/**
	* Creates a new service experience with the primary key. Does not add the service experience to the database.
	*
	* @param serviceExperienceId the primary key for the new service experience
	* @return the new service experience
	*/
	public static com.idetronic.portlet.model.ServiceExperience createServiceExperience(
		long serviceExperienceId) {
		return getService().createServiceExperience(serviceExperienceId);
	}

	/**
	* Deletes the service experience with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience that was removed
	* @throws PortalException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ServiceExperience deleteServiceExperience(
		long serviceExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteServiceExperience(serviceExperienceId);
	}

	/**
	* Deletes the service experience from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceExperience the service experience
	* @return the service experience that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ServiceExperience deleteServiceExperience(
		com.idetronic.portlet.model.ServiceExperience serviceExperience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteServiceExperience(serviceExperience);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.idetronic.portlet.model.ServiceExperience fetchServiceExperience(
		long serviceExperienceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchServiceExperience(serviceExperienceId);
	}

	/**
	* Returns the service experience with the primary key.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience
	* @throws PortalException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ServiceExperience getServiceExperience(
		long serviceExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceExperience(serviceExperienceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service experiences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @return the range of service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ServiceExperience> getServiceExperiences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceExperiences(start, end);
	}

	/**
	* Returns the number of service experiences.
	*
	* @return the number of service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static int getServiceExperiencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceExperiencesCount();
	}

	/**
	* Updates the service experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceExperience the service experience
	* @return the service experience that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ServiceExperience updateServiceExperience(
		com.idetronic.portlet.model.ServiceExperience serviceExperience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateServiceExperience(serviceExperience);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.idetronic.portlet.model.ServiceExperience> getUserServiceExperience(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserServiceExperience(userId);
	}

	public static int getUserServiceExperienceCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserServiceExperienceCount(userId);
	}

	public static com.idetronic.portlet.model.ServiceExperience addServiceExperience(
		long userId, java.lang.String title, int startDateMonth,
		int startDateDay, int startDateYear, int endDateMonth, int endDateDay,
		int endDateYear, boolean current, java.lang.String data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addServiceExperience(userId, title, startDateMonth,
			startDateDay, startDateYear, endDateMonth, endDateDay, endDateYear,
			current, data);
	}

	public static com.idetronic.portlet.model.ServiceExperience updateServiceExperience(
		long serviceExperienceId, java.lang.String title, int startDateMonth,
		int startDateDay, int startDateYear, int endDateMonth, int endDateDay,
		int endDateYear, boolean current, java.lang.String data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateServiceExperience(serviceExperienceId, title,
			startDateMonth, startDateDay, startDateYear, endDateMonth,
			endDateDay, endDateYear, current, data);
	}

	public static void clearService() {
		_service = null;
	}

	public static ServiceExperienceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ServiceExperienceLocalService.class.getName());

			if (invokableLocalService instanceof ServiceExperienceLocalService) {
				_service = (ServiceExperienceLocalService)invokableLocalService;
			}
			else {
				_service = new ServiceExperienceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ServiceExperienceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ServiceExperienceLocalService service) {
	}

	private static ServiceExperienceLocalService _service;
}