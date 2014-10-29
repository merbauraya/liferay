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
 * Provides a wrapper for {@link ExpertiseTagLocalService}.
 *
 * @author Mazlan Mat
 * @see ExpertiseTagLocalService
 * @generated
 */
public class ExpertiseTagLocalServiceWrapper implements ExpertiseTagLocalService,
	ServiceWrapper<ExpertiseTagLocalService> {
	public ExpertiseTagLocalServiceWrapper(
		ExpertiseTagLocalService expertiseTagLocalService) {
		_expertiseTagLocalService = expertiseTagLocalService;
	}

	/**
	* Adds the expertise tag to the database. Also notifies the appropriate model listeners.
	*
	* @param expertiseTag the expertise tag
	* @return the expertise tag that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.ExpertiseTag addExpertiseTag(
		com.idetronic.portlet.model.ExpertiseTag expertiseTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.addExpertiseTag(expertiseTag);
	}

	/**
	* Creates a new expertise tag with the primary key. Does not add the expertise tag to the database.
	*
	* @param tagId the primary key for the new expertise tag
	* @return the new expertise tag
	*/
	@Override
	public com.idetronic.portlet.model.ExpertiseTag createExpertiseTag(
		long tagId) {
		return _expertiseTagLocalService.createExpertiseTag(tagId);
	}

	/**
	* Deletes the expertise tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagId the primary key of the expertise tag
	* @return the expertise tag that was removed
	* @throws PortalException if a expertise tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.ExpertiseTag deleteExpertiseTag(
		long tagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.deleteExpertiseTag(tagId);
	}

	/**
	* Deletes the expertise tag from the database. Also notifies the appropriate model listeners.
	*
	* @param expertiseTag the expertise tag
	* @return the expertise tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.ExpertiseTag deleteExpertiseTag(
		com.idetronic.portlet.model.ExpertiseTag expertiseTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.deleteExpertiseTag(expertiseTag);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expertiseTagLocalService.dynamicQuery();
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
		return _expertiseTagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _expertiseTagLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _expertiseTagLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _expertiseTagLocalService.dynamicQueryCount(dynamicQuery);
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
		return _expertiseTagLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.portlet.model.ExpertiseTag fetchExpertiseTag(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.fetchExpertiseTag(tagId);
	}

	/**
	* Returns the expertise tag with the primary key.
	*
	* @param tagId the primary key of the expertise tag
	* @return the expertise tag
	* @throws PortalException if a expertise tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.ExpertiseTag getExpertiseTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.getExpertiseTag(tagId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the expertise tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expertise tags
	* @param end the upper bound of the range of expertise tags (not inclusive)
	* @return the range of expertise tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.portlet.model.ExpertiseTag> getExpertiseTags(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.getExpertiseTags(start, end);
	}

	/**
	* Returns the number of expertise tags.
	*
	* @return the number of expertise tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getExpertiseTagsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.getExpertiseTagsCount();
	}

	/**
	* Updates the expertise tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expertiseTag the expertise tag
	* @return the expertise tag that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.ExpertiseTag updateExpertiseTag(
		com.idetronic.portlet.model.ExpertiseTag expertiseTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.updateExpertiseTag(expertiseTag);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _expertiseTagLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_expertiseTagLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _expertiseTagLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addExpertiseTag(java.lang.String[] tags, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_expertiseTagLocalService.addExpertiseTag(tags, userId);
	}

	@Override
	public void addExpertiseTag(java.lang.String tags,
		java.lang.String delimeter, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_expertiseTagLocalService.addExpertiseTag(tags, delimeter, userId);
	}

	@Override
	public java.util.List<com.idetronic.portlet.model.ExpertiseTag> findByTagName(
		java.lang.String[] tagNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTagLocalService.findByTagName(tagNames);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ExpertiseTagLocalService getWrappedExpertiseTagLocalService() {
		return _expertiseTagLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedExpertiseTagLocalService(
		ExpertiseTagLocalService expertiseTagLocalService) {
		_expertiseTagLocalService = expertiseTagLocalService;
	}

	@Override
	public ExpertiseTagLocalService getWrappedService() {
		return _expertiseTagLocalService;
	}

	@Override
	public void setWrappedService(
		ExpertiseTagLocalService expertiseTagLocalService) {
		_expertiseTagLocalService = expertiseTagLocalService;
	}

	private ExpertiseTagLocalService _expertiseTagLocalService;
}