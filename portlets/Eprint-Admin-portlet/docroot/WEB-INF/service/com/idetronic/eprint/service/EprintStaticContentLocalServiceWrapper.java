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

package com.idetronic.eprint.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EprintStaticContentLocalService}.
 *
 * @author Mazlan Mat
 * @see EprintStaticContentLocalService
 * @generated
 */
public class EprintStaticContentLocalServiceWrapper
	implements EprintStaticContentLocalService,
		ServiceWrapper<EprintStaticContentLocalService> {
	public EprintStaticContentLocalServiceWrapper(
		EprintStaticContentLocalService eprintStaticContentLocalService) {
		_eprintStaticContentLocalService = eprintStaticContentLocalService;
	}

	/**
	* Adds the eprint static content to the database. Also notifies the appropriate model listeners.
	*
	* @param eprintStaticContent the eprint static content
	* @return the eprint static content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintStaticContent addEprintStaticContent(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.addEprintStaticContent(eprintStaticContent);
	}

	/**
	* Creates a new eprint static content with the primary key. Does not add the eprint static content to the database.
	*
	* @param contentId the primary key for the new eprint static content
	* @return the new eprint static content
	*/
	@Override
	public com.idetronic.eprint.model.EprintStaticContent createEprintStaticContent(
		long contentId) {
		return _eprintStaticContentLocalService.createEprintStaticContent(contentId);
	}

	/**
	* Deletes the eprint static content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the eprint static content
	* @return the eprint static content that was removed
	* @throws PortalException if a eprint static content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintStaticContent deleteEprintStaticContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.deleteEprintStaticContent(contentId);
	}

	/**
	* Deletes the eprint static content from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintStaticContent the eprint static content
	* @return the eprint static content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintStaticContent deleteEprintStaticContent(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.deleteEprintStaticContent(eprintStaticContent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eprintStaticContentLocalService.dynamicQuery();
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
		return _eprintStaticContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintStaticContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eprintStaticContentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintStaticContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eprintStaticContentLocalService.dynamicQuery(dynamicQuery,
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
		return _eprintStaticContentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eprintStaticContentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eprint.model.EprintStaticContent fetchEprintStaticContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.fetchEprintStaticContent(contentId);
	}

	/**
	* Returns the eprint static content with the primary key.
	*
	* @param contentId the primary key of the eprint static content
	* @return the eprint static content
	* @throws PortalException if a eprint static content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintStaticContent getEprintStaticContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.getEprintStaticContent(contentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the eprint static contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintStaticContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprint static contents
	* @param end the upper bound of the range of eprint static contents (not inclusive)
	* @return the range of eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eprint.model.EprintStaticContent> getEprintStaticContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.getEprintStaticContents(start,
			end);
	}

	/**
	* Returns the number of eprint static contents.
	*
	* @return the number of eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEprintStaticContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.getEprintStaticContentsCount();
	}

	/**
	* Updates the eprint static content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eprintStaticContent the eprint static content
	* @return the eprint static content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintStaticContent updateEprintStaticContent(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintStaticContentLocalService.updateEprintStaticContent(eprintStaticContent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eprintStaticContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eprintStaticContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eprintStaticContentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.idetronic.eprint.model.EprintStaticContent addContent(long key,
		java.lang.String content) {
		return _eprintStaticContentLocalService.addContent(key, content);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EprintStaticContentLocalService getWrappedEprintStaticContentLocalService() {
		return _eprintStaticContentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEprintStaticContentLocalService(
		EprintStaticContentLocalService eprintStaticContentLocalService) {
		_eprintStaticContentLocalService = eprintStaticContentLocalService;
	}

	@Override
	public EprintStaticContentLocalService getWrappedService() {
		return _eprintStaticContentLocalService;
	}

	@Override
	public void setWrappedService(
		EprintStaticContentLocalService eprintStaticContentLocalService) {
		_eprintStaticContentLocalService = eprintStaticContentLocalService;
	}

	private EprintStaticContentLocalService _eprintStaticContentLocalService;
}