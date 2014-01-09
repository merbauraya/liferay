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
 * <p>
 * This class is a wrapper for {@link EprintLocalService}.
 * </p>
 *
 * @author    matle
 * @see       EprintLocalService
 * @generated
 */
public class EprintLocalServiceWrapper implements EprintLocalService,
	ServiceWrapper<EprintLocalService> {
	public EprintLocalServiceWrapper(EprintLocalService eprintLocalService) {
		_eprintLocalService = eprintLocalService;
	}

	/**
	* Adds the eprint to the database. Also notifies the appropriate model listeners.
	*
	* @param eprint the eprint
	* @return the eprint that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint addEprint(
		com.idetronic.eprint.model.Eprint eprint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.addEprint(eprint);
	}

	/**
	* Creates a new eprint with the primary key. Does not add the eprint to the database.
	*
	* @param eprintId the primary key for the new eprint
	* @return the new eprint
	*/
	public com.idetronic.eprint.model.Eprint createEprint(long eprintId) {
		return _eprintLocalService.createEprint(eprintId);
	}

	/**
	* Deletes the eprint with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint that was removed
	* @throws PortalException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint deleteEprint(long eprintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.deleteEprint(eprintId);
	}

	/**
	* Deletes the eprint from the database. Also notifies the appropriate model listeners.
	*
	* @param eprint the eprint
	* @return the eprint that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint deleteEprint(
		com.idetronic.eprint.model.Eprint eprint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.deleteEprint(eprint);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eprintLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.idetronic.eprint.model.Eprint fetchEprint(long eprintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.fetchEprint(eprintId);
	}

	/**
	* Returns the eprint with the primary key.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint
	* @throws PortalException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint getEprint(long eprintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.getEprint(eprintId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the eprints.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprints
	* @param end the upper bound of the range of eprints (not inclusive)
	* @return the range of eprints
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.Eprint> getEprints(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.getEprints(start, end);
	}

	/**
	* Returns the number of eprints.
	*
	* @return the number of eprints
	* @throws SystemException if a system exception occurred
	*/
	public int getEprintsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.getEprintsCount();
	}

	/**
	* Updates the eprint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eprint the eprint
	* @return the eprint that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint updateEprint(
		com.idetronic.eprint.model.Eprint eprint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.updateEprint(eprint);
	}

	/**
	* Updates the eprint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eprint the eprint
	* @param merge whether to merge the eprint with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the eprint that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint updateEprint(
		com.idetronic.eprint.model.Eprint eprint, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.updateEprint(eprint, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _eprintLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eprintLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eprintLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.idetronic.eprint.model.Eprint insertEprint(long eprintId,
		java.lang.String title, java.lang.String eprintAbstract,
		java.lang.String eprintStatus, java.lang.String eprintType,
		java.lang.String metadataVisibility, java.lang.String eprintKeywords,
		java.lang.String isPublished, java.lang.String dateYear,
		java.lang.String fullTextStatus) {
		return _eprintLocalService.insertEprint(eprintId, title,
			eprintAbstract, eprintStatus, eprintType, metadataVisibility,
			eprintKeywords, isPublished, dateYear, fullTextStatus);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EprintLocalService getWrappedEprintLocalService() {
		return _eprintLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEprintLocalService(
		EprintLocalService eprintLocalService) {
		_eprintLocalService = eprintLocalService;
	}

	public EprintLocalService getWrappedService() {
		return _eprintLocalService;
	}

	public void setWrappedService(EprintLocalService eprintLocalService) {
		_eprintLocalService = eprintLocalService;
	}

	private EprintLocalService _eprintLocalService;
}