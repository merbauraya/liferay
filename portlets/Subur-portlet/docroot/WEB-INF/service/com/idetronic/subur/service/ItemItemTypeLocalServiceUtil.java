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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ItemItemType. This utility wraps
 * {@link com.idetronic.subur.service.impl.ItemItemTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see ItemItemTypeLocalService
 * @see com.idetronic.subur.service.base.ItemItemTypeLocalServiceBaseImpl
 * @see com.idetronic.subur.service.impl.ItemItemTypeLocalServiceImpl
 * @generated
 */
public class ItemItemTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.subur.service.impl.ItemItemTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the item item type to the database. Also notifies the appropriate model listeners.
	*
	* @param itemItemType the item item type
	* @return the item item type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemItemType addItemItemType(
		com.idetronic.subur.model.ItemItemType itemItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addItemItemType(itemItemType);
	}

	/**
	* Creates a new item item type with the primary key. Does not add the item item type to the database.
	*
	* @param itemItemTypePK the primary key for the new item item type
	* @return the new item item type
	*/
	public static com.idetronic.subur.model.ItemItemType createItemItemType(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK) {
		return getService().createItemItemType(itemItemTypePK);
	}

	/**
	* Deletes the item item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemItemTypePK the primary key of the item item type
	* @return the item item type that was removed
	* @throws PortalException if a item item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemItemType deleteItemItemType(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteItemItemType(itemItemTypePK);
	}

	/**
	* Deletes the item item type from the database. Also notifies the appropriate model listeners.
	*
	* @param itemItemType the item item type
	* @return the item item type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemItemType deleteItemItemType(
		com.idetronic.subur.model.ItemItemType itemItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteItemItemType(itemItemType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.subur.model.ItemItemType fetchItemItemType(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchItemItemType(itemItemTypePK);
	}

	/**
	* Returns the item item type with the primary key.
	*
	* @param itemItemTypePK the primary key of the item item type
	* @return the item item type
	* @throws PortalException if a item item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemItemType getItemItemType(
		com.idetronic.subur.service.persistence.ItemItemTypePK itemItemTypePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemItemType(itemItemTypePK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the item item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item item types
	* @param end the upper bound of the range of item item types (not inclusive)
	* @return the range of item item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemItemType> getItemItemTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemItemTypes(start, end);
	}

	/**
	* Returns the number of item item types.
	*
	* @return the number of item item types
	* @throws SystemException if a system exception occurred
	*/
	public static int getItemItemTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemItemTypesCount();
	}

	/**
	* Updates the item item type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemItemType the item item type
	* @return the item item type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemItemType updateItemItemType(
		com.idetronic.subur.model.ItemItemType itemItemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateItemItemType(itemItemType);
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

	public static com.idetronic.subur.model.ItemItemType addItemType(
		long itemId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addItemType(itemId, itemTypeId);
	}

	public static void setItemItemType(long itemId,
		java.lang.String[] itemTypeStrings)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setItemItemType(itemId, itemTypeStrings);
	}

	/**
	* Return item type and item item type by any given item id
	* It return array list of the following
	* Index 0 - Item Type
	* Index 1 - Item Ite Type
	* This is useful when building user interface for list of item type and selected item type
	*/
	public static java.util.List getByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByItemId(itemId);
	}

	/**
	* @param itemId - Subur Item Id
	* @return List of ItemType
	* @throws SystemException
	*/
	public static java.util.List<com.idetronic.subur.model.ItemItemType> itemTypeByItemid(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().itemTypeByItemid(itemId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ItemItemTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ItemItemTypeLocalService.class.getName());

			if (invokableLocalService instanceof ItemItemTypeLocalService) {
				_service = (ItemItemTypeLocalService)invokableLocalService;
			}
			else {
				_service = new ItemItemTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ItemItemTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ItemItemTypeLocalService service) {
	}

	private static ItemItemTypeLocalService _service;
}