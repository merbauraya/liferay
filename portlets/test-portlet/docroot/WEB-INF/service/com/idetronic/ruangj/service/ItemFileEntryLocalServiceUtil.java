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

package com.idetronic.ruangj.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ItemFileEntry. This utility wraps
 * {@link com.idetronic.ruangj.service.impl.ItemFileEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see ItemFileEntryLocalService
 * @see com.idetronic.ruangj.service.base.ItemFileEntryLocalServiceBaseImpl
 * @see com.idetronic.ruangj.service.impl.ItemFileEntryLocalServiceImpl
 * @generated
 */
public class ItemFileEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.ruangj.service.impl.ItemFileEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the item file entry to the database. Also notifies the appropriate model listeners.
	*
	* @param itemFileEntry the item file entry
	* @return the item file entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry addItemFileEntry(
		com.idetronic.ruangj.model.ItemFileEntry itemFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addItemFileEntry(itemFileEntry);
	}

	/**
	* Creates a new item file entry with the primary key. Does not add the item file entry to the database.
	*
	* @param itemEntryId the primary key for the new item file entry
	* @return the new item file entry
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry createItemFileEntry(
		long itemEntryId) {
		return getService().createItemFileEntry(itemEntryId);
	}

	/**
	* Deletes the item file entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemEntryId the primary key of the item file entry
	* @return the item file entry that was removed
	* @throws PortalException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry deleteItemFileEntry(
		long itemEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteItemFileEntry(itemEntryId);
	}

	/**
	* Deletes the item file entry from the database. Also notifies the appropriate model listeners.
	*
	* @param itemFileEntry the item file entry
	* @return the item file entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry deleteItemFileEntry(
		com.idetronic.ruangj.model.ItemFileEntry itemFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteItemFileEntry(itemFileEntry);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.ruangj.model.ItemFileEntry fetchItemFileEntry(
		long itemEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchItemFileEntry(itemEntryId);
	}

	/**
	* Returns the item file entry with the primary key.
	*
	* @param itemEntryId the primary key of the item file entry
	* @return the item file entry
	* @throws PortalException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry getItemFileEntry(
		long itemEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemFileEntry(itemEntryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the item file entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.ruangj.model.impl.ItemFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item file entries
	* @param end the upper bound of the range of item file entries (not inclusive)
	* @return the range of item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.ruangj.model.ItemFileEntry> getItemFileEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemFileEntries(start, end);
	}

	/**
	* Returns the number of item file entries.
	*
	* @return the number of item file entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getItemFileEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemFileEntriesCount();
	}

	/**
	* Updates the item file entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemFileEntry the item file entry
	* @return the item file entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.ruangj.model.ItemFileEntry updateItemFileEntry(
		com.idetronic.ruangj.model.ItemFileEntry itemFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateItemFileEntry(itemFileEntry);
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

	public static void clearService() {
		_service = null;
	}

	public static ItemFileEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ItemFileEntryLocalService.class.getName());

			if (invokableLocalService instanceof ItemFileEntryLocalService) {
				_service = (ItemFileEntryLocalService)invokableLocalService;
			}
			else {
				_service = new ItemFileEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ItemFileEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ItemFileEntryLocalService service) {
	}

	private static ItemFileEntryLocalService _service;
}