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
 * <p>
 * This class is a wrapper for {@link FAQEntryLocalService}.
 * </p>
 *
 * @author    Mazlan Mat
 * @see       FAQEntryLocalService
 * @generated
 */
public class FAQEntryLocalServiceWrapper implements FAQEntryLocalService,
	ServiceWrapper<FAQEntryLocalService> {
	public FAQEntryLocalServiceWrapper(
		FAQEntryLocalService faqEntryLocalService) {
		_faqEntryLocalService = faqEntryLocalService;
	}

	/**
	* Adds the f a q entry to the database. Also notifies the appropriate model listeners.
	*
	* @param faqEntry the f a q entry
	* @return the f a q entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry addFAQEntry(
		com.idetronic.portlet.model.FAQEntry faqEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.addFAQEntry(faqEntry);
	}

	/**
	* Creates a new f a q entry with the primary key. Does not add the f a q entry to the database.
	*
	* @param entryId the primary key for the new f a q entry
	* @return the new f a q entry
	*/
	public com.idetronic.portlet.model.FAQEntry createFAQEntry(long entryId) {
		return _faqEntryLocalService.createFAQEntry(entryId);
	}

	/**
	* Deletes the f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the f a q entry
	* @return the f a q entry that was removed
	* @throws PortalException if a f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry deleteFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.deleteFAQEntry(entryId);
	}

	/**
	* Deletes the f a q entry from the database. Also notifies the appropriate model listeners.
	*
	* @param faqEntry the f a q entry
	* @return the f a q entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry deleteFAQEntry(
		com.idetronic.portlet.model.FAQEntry faqEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.deleteFAQEntry(faqEntry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _faqEntryLocalService.dynamicQuery();
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
		return _faqEntryLocalService.dynamicQuery(dynamicQuery);
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
		return _faqEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _faqEntryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _faqEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.idetronic.portlet.model.FAQEntry fetchFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.fetchFAQEntry(entryId);
	}

	/**
	* Returns the f a q entry with the primary key.
	*
	* @param entryId the primary key of the f a q entry
	* @return the f a q entry
	* @throws PortalException if a f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry getFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.getFAQEntry(entryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the f a q entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q entries
	* @param end the upper bound of the range of f a q entries (not inclusive)
	* @return the range of f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.FAQEntry> getFAQEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.getFAQEntries(start, end);
	}

	/**
	* Returns the number of f a q entries.
	*
	* @return the number of f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int getFAQEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.getFAQEntriesCount();
	}

	/**
	* Updates the f a q entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqEntry the f a q entry
	* @return the f a q entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry updateFAQEntry(
		com.idetronic.portlet.model.FAQEntry faqEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.updateFAQEntry(faqEntry);
	}

	/**
	* Updates the f a q entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqEntry the f a q entry
	* @param merge whether to merge the f a q entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the f a q entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry updateFAQEntry(
		com.idetronic.portlet.model.FAQEntry faqEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqEntryLocalService.updateFAQEntry(faqEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _faqEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_faqEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _faqEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.idetronic.portlet.model.FAQEntry addEntry(
		java.lang.String category, java.lang.String question,
		java.lang.String answer) {
		return _faqEntryLocalService.addEntry(category, question, answer);
	}

	public com.idetronic.portlet.model.FAQEntry updateEntry(long faqId,
		java.lang.String category, java.lang.String question,
		java.lang.String answer) {
		return _faqEntryLocalService.updateEntry(faqId, category, question,
			answer);
	}

	public java.util.List<java.lang.String> getCategory() {
		return _faqEntryLocalService.getCategory();
	}

	public java.util.List<com.idetronic.portlet.model.FAQEntry> getAll() {
		return _faqEntryLocalService.getAll();
	}

	public java.util.List<com.idetronic.portlet.model.FAQEntry> getByCategory(
		java.lang.String category) {
		return _faqEntryLocalService.getByCategory(category);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public FAQEntryLocalService getWrappedFAQEntryLocalService() {
		return _faqEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedFAQEntryLocalService(
		FAQEntryLocalService faqEntryLocalService) {
		_faqEntryLocalService = faqEntryLocalService;
	}

	public FAQEntryLocalService getWrappedService() {
		return _faqEntryLocalService;
	}

	public void setWrappedService(FAQEntryLocalService faqEntryLocalService) {
		_faqEntryLocalService = faqEntryLocalService;
	}

	private FAQEntryLocalService _faqEntryLocalService;
}