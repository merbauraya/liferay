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
 * Provides a wrapper for {@link ExpertiseLocalService}.
 *
 * @author Mazlan Mat
 * @see ExpertiseLocalService
 * @generated
 */
public class ExpertiseLocalServiceWrapper implements ExpertiseLocalService,
	ServiceWrapper<ExpertiseLocalService> {
	public ExpertiseLocalServiceWrapper(
		ExpertiseLocalService expertiseLocalService) {
		_expertiseLocalService = expertiseLocalService;
	}

	/**
	* Adds the expertise to the database. Also notifies the appropriate model listeners.
	*
	* @param expertise the expertise
	* @return the expertise that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Expertise addExpertise(
		com.idetronic.subur.model.Expertise expertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.addExpertise(expertise);
	}

	/**
	* Creates a new expertise with the primary key. Does not add the expertise to the database.
	*
	* @param expertiseId the primary key for the new expertise
	* @return the new expertise
	*/
	@Override
	public com.idetronic.subur.model.Expertise createExpertise(long expertiseId) {
		return _expertiseLocalService.createExpertise(expertiseId);
	}

	/**
	* Deletes the expertise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expertiseId the primary key of the expertise
	* @return the expertise that was removed
	* @throws PortalException if a expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Expertise deleteExpertise(long expertiseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.deleteExpertise(expertiseId);
	}

	/**
	* Deletes the expertise from the database. Also notifies the appropriate model listeners.
	*
	* @param expertise the expertise
	* @return the expertise that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Expertise deleteExpertise(
		com.idetronic.subur.model.Expertise expertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.deleteExpertise(expertise);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expertiseLocalService.dynamicQuery();
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
		return _expertiseLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _expertiseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _expertiseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.subur.model.Expertise fetchExpertise(long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.fetchExpertise(expertiseId);
	}

	/**
	* Returns the expertise with the primary key.
	*
	* @param expertiseId the primary key of the expertise
	* @return the expertise
	* @throws PortalException if a expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Expertise getExpertise(long expertiseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.getExpertise(expertiseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.idetronic.subur.model.Expertise> getExpertises(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.getExpertises(start, end);
	}

	/**
	* Returns the number of expertises.
	*
	* @return the number of expertises
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getExpertisesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.getExpertisesCount();
	}

	/**
	* Updates the expertise in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expertise the expertise
	* @return the expertise that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Expertise updateExpertise(
		com.idetronic.subur.model.Expertise expertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.updateExpertise(expertise);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _expertiseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_expertiseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _expertiseLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Expertise> checkExpertises(
		long userId, com.liferay.portal.model.Group group,
		java.lang.String[] names)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.checkExpertises(userId, group, names);
	}

	@Override
	public com.idetronic.subur.model.Expertise addExpertise(long userId,
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.addExpertise(userId, name, serviceContext);
	}

	@Override
	public com.idetronic.subur.model.Expertise getExpertise(long groupId,
		java.lang.String name)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.getExpertise(groupId, name);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Expertise> findByGroupsName(
		long[] groupIds, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.findByGroupsName(groupIds, name, start,
			end, obc);
	}

	@Override
	public com.idetronic.subur.model.Expertise incrementAuthorCount(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.incrementAuthorCount(expertiseId);
	}

	@Override
	public com.idetronic.subur.model.Expertise decrementAuthorCount(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseLocalService.decrementAuthorCount(expertiseId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ExpertiseLocalService getWrappedExpertiseLocalService() {
		return _expertiseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedExpertiseLocalService(
		ExpertiseLocalService expertiseLocalService) {
		_expertiseLocalService = expertiseLocalService;
	}

	@Override
	public ExpertiseLocalService getWrappedService() {
		return _expertiseLocalService;
	}

	@Override
	public void setWrappedService(ExpertiseLocalService expertiseLocalService) {
		_expertiseLocalService = expertiseLocalService;
	}

	private ExpertiseLocalService _expertiseLocalService;
}