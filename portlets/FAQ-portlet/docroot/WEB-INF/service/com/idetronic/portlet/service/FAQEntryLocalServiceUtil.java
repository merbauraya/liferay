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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FAQEntry. This utility wraps
 * {@link com.idetronic.portlet.service.impl.FAQEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Idetronic Sdn Bhd
 * @see FAQEntryLocalService
 * @see com.idetronic.portlet.service.base.FAQEntryLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.impl.FAQEntryLocalServiceImpl
 * @generated
 */
public class FAQEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.portlet.service.impl.FAQEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the f a q entry to the database. Also notifies the appropriate model listeners.
	*
	* @param faqEntry the f a q entry
	* @return the f a q entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.FAQEntry addFAQEntry(
		com.idetronic.portlet.model.FAQEntry faqEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFAQEntry(faqEntry);
	}

	/**
	* Creates a new f a q entry with the primary key. Does not add the f a q entry to the database.
	*
	* @param entryId the primary key for the new f a q entry
	* @return the new f a q entry
	*/
	public static com.idetronic.portlet.model.FAQEntry createFAQEntry(
		long entryId) {
		return getService().createFAQEntry(entryId);
	}

	/**
	* Deletes the f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the f a q entry
	* @return the f a q entry that was removed
	* @throws PortalException if a f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.FAQEntry deleteFAQEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFAQEntry(entryId);
	}

	/**
	* Deletes the f a q entry from the database. Also notifies the appropriate model listeners.
	*
	* @param faqEntry the f a q entry
	* @return the f a q entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.FAQEntry deleteFAQEntry(
		com.idetronic.portlet.model.FAQEntry faqEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFAQEntry(faqEntry);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.FAQEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.FAQEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.idetronic.portlet.model.FAQEntry fetchFAQEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFAQEntry(entryId);
	}

	/**
	* Returns the f a q entry with the primary key.
	*
	* @param entryId the primary key of the f a q entry
	* @return the f a q entry
	* @throws PortalException if a f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.FAQEntry getFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQEntry(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the f a q entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.FAQEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of f a q entries
	* @param end the upper bound of the range of f a q entries (not inclusive)
	* @return the range of f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.FAQEntry> getFAQEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQEntries(start, end);
	}

	/**
	* Returns the number of f a q entries.
	*
	* @return the number of f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getFAQEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQEntriesCount();
	}

	/**
	* Updates the f a q entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqEntry the f a q entry
	* @return the f a q entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.FAQEntry updateFAQEntry(
		com.idetronic.portlet.model.FAQEntry faqEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFAQEntry(faqEntry);
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

	public static com.idetronic.portlet.model.FAQEntry addEntry(
		java.lang.String category, java.lang.String question,
		java.lang.String answer, long userId, long companyId, long groupId,
		java.lang.String userName) {
		return getService()
				   .addEntry(category, question, answer, userId, companyId,
			groupId, userName);
	}

	public static com.idetronic.portlet.model.FAQEntry updateEntry(long faqId,
		java.lang.String category, java.lang.String question,
		java.lang.String answer) {
		return getService().updateEntry(faqId, category, question, answer);
	}

	public static java.util.List<java.lang.String> getCategory() {
		return getService().getCategory();
	}

	public static java.util.List<com.idetronic.portlet.model.FAQEntry> getAll() {
		return getService().getAll();
	}

	public static java.util.List<com.idetronic.portlet.model.FAQEntry> getByCategory(
		java.lang.String category) {
		return getService().getByCategory(category);
	}

	public static void clearService() {
		_service = null;
	}

	public static FAQEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FAQEntryLocalService.class.getName());

			if (invokableLocalService instanceof FAQEntryLocalService) {
				_service = (FAQEntryLocalService)invokableLocalService;
			}
			else {
				_service = new FAQEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FAQEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FAQEntryLocalService service) {
	}

	private static FAQEntryLocalService _service;
}