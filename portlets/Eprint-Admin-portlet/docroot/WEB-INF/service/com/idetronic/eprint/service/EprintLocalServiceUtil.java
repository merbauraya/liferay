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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the eprint local service. This utility wraps {@link com.idetronic.eprint.service.impl.EprintLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matle
 * @see EprintLocalService
 * @see com.idetronic.eprint.service.base.EprintLocalServiceBaseImpl
 * @see com.idetronic.eprint.service.impl.EprintLocalServiceImpl
 * @generated
 */
public class EprintLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eprint.service.impl.EprintLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the eprint to the database. Also notifies the appropriate model listeners.
	*
	* @param eprint the eprint
	* @return the eprint that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint addEprint(
		com.idetronic.eprint.model.Eprint eprint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEprint(eprint);
	}

	/**
	* Creates a new eprint with the primary key. Does not add the eprint to the database.
	*
	* @param eprintId the primary key for the new eprint
	* @return the new eprint
	*/
	public static com.idetronic.eprint.model.Eprint createEprint(long eprintId) {
		return getService().createEprint(eprintId);
	}

	/**
	* Deletes the eprint with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint that was removed
	* @throws PortalException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint deleteEprint(long eprintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEprint(eprintId);
	}

	/**
	* Deletes the eprint from the database. Also notifies the appropriate model listeners.
	*
	* @param eprint the eprint
	* @return the eprint that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint deleteEprint(
		com.idetronic.eprint.model.Eprint eprint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEprint(eprint);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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

	public static com.idetronic.eprint.model.Eprint fetchEprint(long eprintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEprint(eprintId);
	}

	/**
	* Returns the eprint with the primary key.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint
	* @throws PortalException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint getEprint(long eprintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEprint(eprintId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.idetronic.eprint.model.Eprint> getEprints(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEprints(start, end);
	}

	/**
	* Returns the number of eprints.
	*
	* @return the number of eprints
	* @throws SystemException if a system exception occurred
	*/
	public static int getEprintsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEprintsCount();
	}

	/**
	* Updates the eprint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eprint the eprint
	* @return the eprint that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint updateEprint(
		com.idetronic.eprint.model.Eprint eprint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEprint(eprint);
	}

	/**
	* Updates the eprint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eprint the eprint
	* @param merge whether to merge the eprint with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the eprint that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint updateEprint(
		com.idetronic.eprint.model.Eprint eprint, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEprint(eprint, merge);
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

	public static com.idetronic.eprint.model.Eprint insertEprint(
		long eprintId, java.lang.String title, java.lang.String eprintAbstract,
		java.lang.String eprintStatus, java.lang.String eprintType,
		java.lang.String metadataVisibility, java.lang.String eprintKeywords,
		java.lang.String isPublished, java.lang.String dateYear,
		java.lang.String fullTextStatus, java.util.Date createdDate,
		java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .insertEprint(eprintId, title, eprintAbstract, eprintStatus,
			eprintType, metadataVisibility, eprintKeywords, isPublished,
			dateYear, fullTextStatus, createdDate, modifiedDate, serviceContext);
	}

	public static com.idetronic.eprint.model.Eprint modifyEprint(
		long eprintId, java.lang.String title, java.lang.String eprintAbstract,
		java.lang.String eprintStatus, java.lang.String eprintType,
		java.lang.String metadataVisibility, java.lang.String eprintKeywords,
		java.lang.String isPublished, java.lang.String dateYear,
		java.lang.String fullTextStatus, java.util.Date createdDate,
		java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .modifyEprint(eprintId, title, eprintAbstract, eprintStatus,
			eprintType, metadataVisibility, eprintKeywords, isPublished,
			dateYear, fullTextStatus, createdDate, modifiedDate, serviceContext);
	}

	public static com.liferay.portal.kernel.search.Hits getHits(
		java.lang.String keyword, long companyId, long groupId) {
		return getService().getHits(keyword, companyId, groupId);
	}

	public static java.util.List<com.idetronic.eprint.model.Eprint> findBySubjectId(
		java.lang.String subjectId, int begin, int end) {
		return getService().findBySubjectId(subjectId, begin, end);
	}

	public static java.util.List<com.idetronic.eprint.model.Eprint> searchIndex(
		java.lang.String keyword, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchIndex(keyword, companyId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EprintLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EprintLocalService.class.getName());

			if (invokableLocalService instanceof EprintLocalService) {
				_service = (EprintLocalService)invokableLocalService;
			}
			else {
				_service = new EprintLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EprintLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(EprintLocalService service) {
	}

	private static EprintLocalService _service;
}