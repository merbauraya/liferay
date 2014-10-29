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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserEntries_ExpertiseTagsLocalService}.
 *
 * @author Mazlan Mat
 * @see UserEntries_ExpertiseTagsLocalService
 * @generated
 */
public class UserEntries_ExpertiseTagsLocalServiceWrapper
	implements UserEntries_ExpertiseTagsLocalService,
		ServiceWrapper<UserEntries_ExpertiseTagsLocalService> {
	public UserEntries_ExpertiseTagsLocalServiceWrapper(
		UserEntries_ExpertiseTagsLocalService userEntries_ExpertiseTagsLocalService) {
		_userEntries_ExpertiseTagsLocalService = userEntries_ExpertiseTagsLocalService;
	}

	/**
	* Adds the user entries_ expertise tags to the database. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTags the user entries_ expertise tags
	* @return the user entries_ expertise tags that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags addUserEntries_ExpertiseTags(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.addUserEntries_ExpertiseTags(userEntries_ExpertiseTags);
	}

	/**
	* Creates a new user entries_ expertise tags with the primary key. Does not add the user entries_ expertise tags to the database.
	*
	* @param userEntries_ExpertiseTagsPK the primary key for the new user entries_ expertise tags
	* @return the new user entries_ expertise tags
	*/
	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags createUserEntries_ExpertiseTags(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK) {
		return _userEntries_ExpertiseTagsLocalService.createUserEntries_ExpertiseTags(userEntries_ExpertiseTagsPK);
	}

	/**
	* Deletes the user entries_ expertise tags with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	* @return the user entries_ expertise tags that was removed
	* @throws PortalException if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags deleteUserEntries_ExpertiseTags(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.deleteUserEntries_ExpertiseTags(userEntries_ExpertiseTagsPK);
	}

	/**
	* Deletes the user entries_ expertise tags from the database. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTags the user entries_ expertise tags
	* @return the user entries_ expertise tags that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags deleteUserEntries_ExpertiseTags(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.deleteUserEntries_ExpertiseTags(userEntries_ExpertiseTags);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userEntries_ExpertiseTagsLocalService.dynamicQuery();
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
		return _userEntries_ExpertiseTagsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.dynamicQuery(dynamicQuery,
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
		return _userEntries_ExpertiseTagsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userEntries_ExpertiseTagsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags fetchUserEntries_ExpertiseTags(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.fetchUserEntries_ExpertiseTags(userEntries_ExpertiseTagsPK);
	}

	/**
	* Returns the user entries_ expertise tags with the primary key.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	* @return the user entries_ expertise tags
	* @throws PortalException if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags getUserEntries_ExpertiseTags(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.getUserEntries_ExpertiseTags(userEntries_ExpertiseTagsPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> getUserEntries_ExpertiseTagses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.getUserEntries_ExpertiseTagses(start,
			end);
	}

	/**
	* Returns the number of user entries_ expertise tagses.
	*
	* @return the number of user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserEntries_ExpertiseTagsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.getUserEntries_ExpertiseTagsesCount();
	}

	/**
	* Updates the user entries_ expertise tags in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTags the user entries_ expertise tags
	* @return the user entries_ expertise tags that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags updateUserEntries_ExpertiseTags(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTagsLocalService.updateUserEntries_ExpertiseTags(userEntries_ExpertiseTags);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userEntries_ExpertiseTagsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userEntries_ExpertiseTagsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userEntries_ExpertiseTagsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void addEntry(long userId, java.lang.String[] tags)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userEntries_ExpertiseTagsLocalService.addEntry(userId, tags);
	}

	@Override
	public void addEntry(long userId, java.lang.String tags,
		java.lang.String delimeter)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userEntries_ExpertiseTagsLocalService.addEntry(userId, tags, delimeter);
	}

	@Override
	public java.util.List getUserEntry(long userId) {
		return _userEntries_ExpertiseTagsLocalService.getUserEntry(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserEntries_ExpertiseTagsLocalService getWrappedUserEntries_ExpertiseTagsLocalService() {
		return _userEntries_ExpertiseTagsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserEntries_ExpertiseTagsLocalService(
		UserEntries_ExpertiseTagsLocalService userEntries_ExpertiseTagsLocalService) {
		_userEntries_ExpertiseTagsLocalService = userEntries_ExpertiseTagsLocalService;
	}

	@Override
	public UserEntries_ExpertiseTagsLocalService getWrappedService() {
		return _userEntries_ExpertiseTagsLocalService;
	}

	@Override
	public void setWrappedService(
		UserEntries_ExpertiseTagsLocalService userEntries_ExpertiseTagsLocalService) {
		_userEntries_ExpertiseTagsLocalService = userEntries_ExpertiseTagsLocalService;
	}

	private UserEntries_ExpertiseTagsLocalService _userEntries_ExpertiseTagsLocalService;
}