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
 * Provides a wrapper for {@link EprintSubjectLocalService}.
 *
 * @author Mazlan Mat
 * @see EprintSubjectLocalService
 * @generated
 */
public class EprintSubjectLocalServiceWrapper
	implements EprintSubjectLocalService,
		ServiceWrapper<EprintSubjectLocalService> {
	public EprintSubjectLocalServiceWrapper(
		EprintSubjectLocalService eprintSubjectLocalService) {
		_eprintSubjectLocalService = eprintSubjectLocalService;
	}

	/**
	* Adds the eprint subject to the database. Also notifies the appropriate model listeners.
	*
	* @param eprintSubject the eprint subject
	* @return the eprint subject that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintSubject addEprintSubject(
		com.idetronic.eprint.model.EprintSubject eprintSubject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.addEprintSubject(eprintSubject);
	}

	/**
	* Creates a new eprint subject with the primary key. Does not add the eprint subject to the database.
	*
	* @param eprintSubjectPK the primary key for the new eprint subject
	* @return the new eprint subject
	*/
	@Override
	public com.idetronic.eprint.model.EprintSubject createEprintSubject(
		com.idetronic.eprint.service.persistence.EprintSubjectPK eprintSubjectPK) {
		return _eprintSubjectLocalService.createEprintSubject(eprintSubjectPK);
	}

	/**
	* Deletes the eprint subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintSubjectPK the primary key of the eprint subject
	* @return the eprint subject that was removed
	* @throws PortalException if a eprint subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintSubject deleteEprintSubject(
		com.idetronic.eprint.service.persistence.EprintSubjectPK eprintSubjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.deleteEprintSubject(eprintSubjectPK);
	}

	/**
	* Deletes the eprint subject from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintSubject the eprint subject
	* @return the eprint subject that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintSubject deleteEprintSubject(
		com.idetronic.eprint.model.EprintSubject eprintSubject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.deleteEprintSubject(eprintSubject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eprintSubjectLocalService.dynamicQuery();
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
		return _eprintSubjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eprintSubjectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eprintSubjectLocalService.dynamicQuery(dynamicQuery, start,
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
		return _eprintSubjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eprintSubjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eprint.model.EprintSubject fetchEprintSubject(
		com.idetronic.eprint.service.persistence.EprintSubjectPK eprintSubjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.fetchEprintSubject(eprintSubjectPK);
	}

	/**
	* Returns the eprint subject with the primary key.
	*
	* @param eprintSubjectPK the primary key of the eprint subject
	* @return the eprint subject
	* @throws PortalException if a eprint subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintSubject getEprintSubject(
		com.idetronic.eprint.service.persistence.EprintSubjectPK eprintSubjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.getEprintSubject(eprintSubjectPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the eprint subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprint subjects
	* @param end the upper bound of the range of eprint subjects (not inclusive)
	* @return the range of eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eprint.model.EprintSubject> getEprintSubjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.getEprintSubjects(start, end);
	}

	/**
	* Returns the number of eprint subjects.
	*
	* @return the number of eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEprintSubjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.getEprintSubjectsCount();
	}

	/**
	* Updates the eprint subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eprintSubject the eprint subject
	* @return the eprint subject that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eprint.model.EprintSubject updateEprintSubject(
		com.idetronic.eprint.model.EprintSubject eprintSubject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintSubjectLocalService.updateEprintSubject(eprintSubject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eprintSubjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eprintSubjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eprintSubjectLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eprint.model.EprintSubject validateEprintSubject(
		long eprintId, java.lang.String subjectId, java.lang.String subjectName) {
		return _eprintSubjectLocalService.validateEprintSubject(eprintId,
			subjectId, subjectName);
	}

	@Override
	public com.idetronic.eprint.model.EprintSubject insertEprintSubject(
		long eprintId, java.lang.String subjectId, java.lang.String subjectName) {
		return _eprintSubjectLocalService.insertEprintSubject(eprintId,
			subjectId, subjectName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EprintSubjectLocalService getWrappedEprintSubjectLocalService() {
		return _eprintSubjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEprintSubjectLocalService(
		EprintSubjectLocalService eprintSubjectLocalService) {
		_eprintSubjectLocalService = eprintSubjectLocalService;
	}

	@Override
	public EprintSubjectLocalService getWrappedService() {
		return _eprintSubjectLocalService;
	}

	@Override
	public void setWrappedService(
		EprintSubjectLocalService eprintSubjectLocalService) {
		_eprintSubjectLocalService = eprintSubjectLocalService;
	}

	private EprintSubjectLocalService _eprintSubjectLocalService;
}