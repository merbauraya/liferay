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
 * Provides a wrapper for {@link AuthorExpertiseLocalService}.
 *
 * @author Mazlan Mat
 * @see AuthorExpertiseLocalService
 * @generated
 */
public class AuthorExpertiseLocalServiceWrapper
	implements AuthorExpertiseLocalService,
		ServiceWrapper<AuthorExpertiseLocalService> {
	public AuthorExpertiseLocalServiceWrapper(
		AuthorExpertiseLocalService authorExpertiseLocalService) {
		_authorExpertiseLocalService = authorExpertiseLocalService;
	}

	/**
	* Adds the author expertise to the database. Also notifies the appropriate model listeners.
	*
	* @param authorExpertise the author expertise
	* @return the author expertise that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorExpertise addAuthorExpertise(
		com.idetronic.subur.model.AuthorExpertise authorExpertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.addAuthorExpertise(authorExpertise);
	}

	/**
	* Creates a new author expertise with the primary key. Does not add the author expertise to the database.
	*
	* @param authorExpertisePK the primary key for the new author expertise
	* @return the new author expertise
	*/
	@Override
	public com.idetronic.subur.model.AuthorExpertise createAuthorExpertise(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK) {
		return _authorExpertiseLocalService.createAuthorExpertise(authorExpertisePK);
	}

	/**
	* Deletes the author expertise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorExpertisePK the primary key of the author expertise
	* @return the author expertise that was removed
	* @throws PortalException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorExpertise deleteAuthorExpertise(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.deleteAuthorExpertise(authorExpertisePK);
	}

	/**
	* Deletes the author expertise from the database. Also notifies the appropriate model listeners.
	*
	* @param authorExpertise the author expertise
	* @return the author expertise that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorExpertise deleteAuthorExpertise(
		com.idetronic.subur.model.AuthorExpertise authorExpertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.deleteAuthorExpertise(authorExpertise);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _authorExpertiseLocalService.dynamicQuery();
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
		return _authorExpertiseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _authorExpertiseLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _authorExpertiseLocalService.dynamicQuery(dynamicQuery, start,
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
		return _authorExpertiseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _authorExpertiseLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.AuthorExpertise fetchAuthorExpertise(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.fetchAuthorExpertise(authorExpertisePK);
	}

	/**
	* Returns the author expertise with the primary key.
	*
	* @param authorExpertisePK the primary key of the author expertise
	* @return the author expertise
	* @throws PortalException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorExpertise getAuthorExpertise(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.getAuthorExpertise(authorExpertisePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the author expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @return the range of author expertises
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> getAuthorExpertises(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.getAuthorExpertises(start, end);
	}

	/**
	* Returns the number of author expertises.
	*
	* @return the number of author expertises
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAuthorExpertisesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.getAuthorExpertisesCount();
	}

	/**
	* Updates the author expertise in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param authorExpertise the author expertise
	* @return the author expertise that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorExpertise updateAuthorExpertise(
		com.idetronic.subur.model.AuthorExpertise authorExpertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorExpertiseLocalService.updateAuthorExpertise(authorExpertise);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _authorExpertiseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_authorExpertiseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _authorExpertiseLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AuthorExpertiseLocalService getWrappedAuthorExpertiseLocalService() {
		return _authorExpertiseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAuthorExpertiseLocalService(
		AuthorExpertiseLocalService authorExpertiseLocalService) {
		_authorExpertiseLocalService = authorExpertiseLocalService;
	}

	@Override
	public AuthorExpertiseLocalService getWrappedService() {
		return _authorExpertiseLocalService;
	}

	@Override
	public void setWrappedService(
		AuthorExpertiseLocalService authorExpertiseLocalService) {
		_authorExpertiseLocalService = authorExpertiseLocalService;
	}

	private AuthorExpertiseLocalService _authorExpertiseLocalService;
}