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
 * Provides a wrapper for {@link EprintLocalService}.
 *
 * @author Mazlan Mat
 * @see EprintLocalService
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public com.idetronic.eprint.model.Eprint deleteEprint(
		com.idetronic.eprint.model.Eprint eprint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.deleteEprint(eprint);
	}

	@Override
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
	@Override
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eprintLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eprintLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
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
	@Override
	public com.idetronic.eprint.model.Eprint getEprint(long eprintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.getEprint(eprintId);
	}

	@Override
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprints
	* @param end the upper bound of the range of eprints (not inclusive)
	* @return the range of eprints
	* @throws SystemException if a system exception occurred
	*/
	@Override
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
	@Override
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
	@Override
	public com.idetronic.eprint.model.Eprint updateEprint(
		com.idetronic.eprint.model.Eprint eprint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.updateEprint(eprint);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eprintLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eprintLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eprintLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.idetronic.eprint.model.Eprint insertEprint(long eprintId,
		java.lang.String title, java.lang.String eprintAbstract,
		java.lang.String eprintStatus, java.lang.String eprintType,
		java.lang.String metadataVisibility, java.lang.String eprintKeywords,
		java.lang.String isPublished, java.lang.String dateYear,
		java.lang.String fullTextStatus, java.util.Date createdDate,
		java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eprintLocalService.insertEprint(eprintId, title,
			eprintAbstract, eprintStatus, eprintType, metadataVisibility,
			eprintKeywords, isPublished, dateYear, fullTextStatus, createdDate,
			modifiedDate, serviceContext);
	}

	@Override
	public com.idetronic.eprint.model.Eprint modifyEprint(long eprintId,
		java.lang.String title, java.lang.String eprintAbstract,
		java.lang.String eprintStatus, java.lang.String eprintType,
		java.lang.String metadataVisibility, java.lang.String eprintKeywords,
		java.lang.String isPublished, java.lang.String dateYear,
		java.lang.String fullTextStatus, java.util.Date createdDate,
		java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eprintLocalService.modifyEprint(eprintId, title,
			eprintAbstract, eprintStatus, eprintType, metadataVisibility,
			eprintKeywords, isPublished, dateYear, fullTextStatus, createdDate,
			modifiedDate, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits search(long groupId,
		long userId, long creatorUserId, java.lang.String keyword, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.search(groupId, userId, creatorUserId,
			keyword, start, end);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits getByType(
		java.lang.String type, long companyId, long groupId)
		throws com.liferay.portal.kernel.search.SearchException {
		return _eprintLocalService.getByType(type, companyId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits getHits(
		java.lang.String keyword, long companyId, long groupId) {
		return _eprintLocalService.getHits(keyword, companyId, groupId);
	}

	@Override
	public java.util.List<com.idetronic.eprint.model.Eprint> findBySubjectId(
		java.lang.String subjectId, int begin, int end) {
		return _eprintLocalService.findBySubjectId(subjectId, begin, end);
	}

	@Override
	public java.util.List<com.idetronic.eprint.model.Eprint> findByDivisionId(
		java.lang.String subjectId, int begin, int end) {
		return _eprintLocalService.findByDivisionId(subjectId, begin, end);
	}

	@Override
	public java.util.List<com.idetronic.eprint.model.Eprint> searchIndex(
		java.lang.String keyword, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.searchIndex(keyword, companyId, groupId);
	}

	@Override
	public com.idetronic.eprint.model.Eprint fetchEntry(long groupId,
		java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.fetchEntry(groupId, urlTitle);
	}

	@Override
	public java.util.List<com.idetronic.eprint.model.Eprint> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.findByType(type);
	}

	@Override
	public java.util.List<java.lang.Object> byTypeSummary()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eprintLocalService.byTypeSummary();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EprintLocalService getWrappedEprintLocalService() {
		return _eprintLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEprintLocalService(
		EprintLocalService eprintLocalService) {
		_eprintLocalService = eprintLocalService;
	}

	@Override
	public EprintLocalService getWrappedService() {
		return _eprintLocalService;
	}

	@Override
	public void setWrappedService(EprintLocalService eprintLocalService) {
		_eprintLocalService = eprintLocalService;
	}

	private EprintLocalService _eprintLocalService;
}