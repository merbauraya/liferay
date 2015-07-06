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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Expertise. This utility wraps
 * {@link com.idetronic.subur.service.impl.ExpertiseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see ExpertiseLocalService
 * @see com.idetronic.subur.service.base.ExpertiseLocalServiceBaseImpl
 * @see com.idetronic.subur.service.impl.ExpertiseLocalServiceImpl
 * @generated
 */
public class ExpertiseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.subur.service.impl.ExpertiseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the expertise to the database. Also notifies the appropriate model listeners.
	*
	* @param expertise the expertise
	* @return the expertise that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise addExpertise(
		com.idetronic.subur.model.Expertise expertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addExpertise(expertise);
	}

	/**
	* Creates a new expertise with the primary key. Does not add the expertise to the database.
	*
	* @param expertiseId the primary key for the new expertise
	* @return the new expertise
	*/
	public static com.idetronic.subur.model.Expertise createExpertise(
		long expertiseId) {
		return getService().createExpertise(expertiseId);
	}

	/**
	* Deletes the expertise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expertiseId the primary key of the expertise
	* @return the expertise that was removed
	* @throws PortalException if a expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise deleteExpertise(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteExpertise(expertiseId);
	}

	/**
	* Deletes the expertise from the database. Also notifies the appropriate model listeners.
	*
	* @param expertise the expertise
	* @return the expertise that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise deleteExpertise(
		com.idetronic.subur.model.Expertise expertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteExpertise(expertise);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.subur.model.Expertise fetchExpertise(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchExpertise(expertiseId);
	}

	/**
	* Returns the expertise with the primary key.
	*
	* @param expertiseId the primary key of the expertise
	* @return the expertise
	* @throws PortalException if a expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise getExpertise(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getExpertise(expertiseId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expertises
	* @param end the upper bound of the range of expertises (not inclusive)
	* @return the range of expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Expertise> getExpertises(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getExpertises(start, end);
	}

	/**
	* Returns the number of expertises.
	*
	* @return the number of expertises
	* @throws SystemException if a system exception occurred
	*/
	public static int getExpertisesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getExpertisesCount();
	}

	/**
	* Updates the expertise in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expertise the expertise
	* @return the expertise that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise updateExpertise(
		com.idetronic.subur.model.Expertise expertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateExpertise(expertise);
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

	public static java.util.List<com.idetronic.subur.model.Expertise> checkExpertises(
		long userId, com.liferay.portal.model.Group group,
		java.lang.String[] names)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().checkExpertises(userId, group, names);
	}

	public static com.idetronic.subur.model.Expertise addExpertise(
		long userId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addExpertise(userId, name, serviceContext);
	}

	public static com.idetronic.subur.model.Expertise getExpertise(
		long groupId, java.lang.String name)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getExpertise(groupId, name);
	}

	public static java.util.List<com.idetronic.subur.model.Expertise> findByGroupsName(
		long[] groupIds, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupsName(groupIds, name, start, end, obc);
	}

	public static com.idetronic.subur.model.Expertise incrementAuthorCount(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().incrementAuthorCount(expertiseId);
	}

	public static com.idetronic.subur.model.Expertise decrementAuthorCount(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().decrementAuthorCount(expertiseId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ExpertiseLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ExpertiseLocalService.class.getName());

			if (invokableLocalService instanceof ExpertiseLocalService) {
				_service = (ExpertiseLocalService)invokableLocalService;
			}
			else {
				_service = new ExpertiseLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ExpertiseLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ExpertiseLocalService service) {
	}

	private static ExpertiseLocalService _service;
}