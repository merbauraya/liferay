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
 * Provides the local service utility for UserEntries_ExpertiseTags. This utility wraps
 * {@link com.idetronic.portlet.service.impl.UserEntries_ExpertiseTagsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see UserEntries_ExpertiseTagsLocalService
 * @see com.idetronic.portlet.service.base.UserEntries_ExpertiseTagsLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.impl.UserEntries_ExpertiseTagsLocalServiceImpl
 * @generated
 */
public class UserEntries_ExpertiseTagsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.portlet.service.impl.UserEntries_ExpertiseTagsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user entries_ expertise tags to the database. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTags the user entries_ expertise tags
	* @return the user entries_ expertise tags that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserEntries_ExpertiseTags addUserEntries_ExpertiseTags(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addUserEntries_ExpertiseTags(userEntries_ExpertiseTags);
	}

	/**
	* Creates a new user entries_ expertise tags with the primary key. Does not add the user entries_ expertise tags to the database.
	*
	* @param userEntries_ExpertiseTagsPK the primary key for the new user entries_ expertise tags
	* @return the new user entries_ expertise tags
	*/
	public static com.idetronic.portlet.model.UserEntries_ExpertiseTags createUserEntries_ExpertiseTags(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK) {
		return getService()
				   .createUserEntries_ExpertiseTags(userEntries_ExpertiseTagsPK);
	}

	/**
	* Deletes the user entries_ expertise tags with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	* @return the user entries_ expertise tags that was removed
	* @throws PortalException if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserEntries_ExpertiseTags deleteUserEntries_ExpertiseTags(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteUserEntries_ExpertiseTags(userEntries_ExpertiseTagsPK);
	}

	/**
	* Deletes the user entries_ expertise tags from the database. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTags the user entries_ expertise tags
	* @return the user entries_ expertise tags that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserEntries_ExpertiseTags deleteUserEntries_ExpertiseTags(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteUserEntries_ExpertiseTags(userEntries_ExpertiseTags);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.portlet.model.UserEntries_ExpertiseTags fetchUserEntries_ExpertiseTags(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchUserEntries_ExpertiseTags(userEntries_ExpertiseTagsPK);
	}

	/**
	* Returns the user entries_ expertise tags with the primary key.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	* @return the user entries_ expertise tags
	* @throws PortalException if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserEntries_ExpertiseTags getUserEntries_ExpertiseTags(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUserEntries_ExpertiseTags(userEntries_ExpertiseTagsPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user entries_ expertise tagses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user entries_ expertise tagses
	* @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	* @return the range of user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> getUserEntries_ExpertiseTagses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEntries_ExpertiseTagses(start, end);
	}

	/**
	* Returns the number of user entries_ expertise tagses.
	*
	* @return the number of user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserEntries_ExpertiseTagsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEntries_ExpertiseTagsesCount();
	}

	/**
	* Updates the user entries_ expertise tags in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTags the user entries_ expertise tags
	* @return the user entries_ expertise tags that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserEntries_ExpertiseTags updateUserEntries_ExpertiseTags(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateUserEntries_ExpertiseTags(userEntries_ExpertiseTags);
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

	public static void addEntry(long userId, java.lang.String[] tags)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addEntry(userId, tags);
	}

	public static void addEntry(long userId, java.lang.String tags,
		java.lang.String delimeter)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addEntry(userId, tags, delimeter);
	}

	public static java.util.List getUserEntry(long userId) {
		return getService().getUserEntry(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserEntries_ExpertiseTagsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserEntries_ExpertiseTagsLocalService.class.getName());

			if (invokableLocalService instanceof UserEntries_ExpertiseTagsLocalService) {
				_service = (UserEntries_ExpertiseTagsLocalService)invokableLocalService;
			}
			else {
				_service = new UserEntries_ExpertiseTagsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserEntries_ExpertiseTagsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserEntries_ExpertiseTagsLocalService service) {
	}

	private static UserEntries_ExpertiseTagsLocalService _service;
}