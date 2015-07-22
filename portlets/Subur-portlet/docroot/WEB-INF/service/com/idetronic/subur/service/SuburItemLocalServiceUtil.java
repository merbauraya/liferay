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
 * Provides the local service utility for SuburItem. This utility wraps
 * {@link com.idetronic.subur.service.impl.SuburItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see SuburItemLocalService
 * @see com.idetronic.subur.service.base.SuburItemLocalServiceBaseImpl
 * @see com.idetronic.subur.service.impl.SuburItemLocalServiceImpl
 * @generated
 */
public class SuburItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.subur.service.impl.SuburItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the subur item to the database. Also notifies the appropriate model listeners.
	*
	* @param suburItem the subur item
	* @return the subur item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem addSuburItem(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSuburItem(suburItem);
	}

	/**
	* Creates a new subur item with the primary key. Does not add the subur item to the database.
	*
	* @param itemId the primary key for the new subur item
	* @return the new subur item
	*/
	public static com.idetronic.subur.model.SuburItem createSuburItem(
		long itemId) {
		return getService().createSuburItem(itemId);
	}

	/**
	* Deletes the subur item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item that was removed
	* @throws PortalException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem deleteSuburItem(
		long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSuburItem(itemId);
	}

	/**
	* Deletes the subur item from the database. Also notifies the appropriate model listeners.
	*
	* @param suburItem the subur item
	* @return the subur item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem deleteSuburItem(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSuburItem(suburItem);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.subur.model.SuburItem fetchSuburItem(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSuburItem(itemId);
	}

	/**
	* Returns the subur item with the primary key.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item
	* @throws PortalException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem getSuburItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSuburItem(itemId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the subur items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> getSuburItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSuburItems(start, end);
	}

	/**
	* Returns the number of subur items.
	*
	* @return the number of subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int getSuburItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSuburItemsCount();
	}

	/**
	* Updates the subur item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param suburItem the subur item
	* @return the subur item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem updateSuburItem(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSuburItem(suburItem);
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

	public static com.idetronic.subur.model.SuburItem addItem(long userId,
		long groupId, java.lang.String title, java.lang.String itemAbstract,
		long[] itemTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addItem(userId, groupId, title, itemAbstract, itemTypeId,
			serviceContext);
	}

	public static com.idetronic.subur.model.SuburItem updateSuburItem(
		com.idetronic.subur.model.SuburItem suburItem, long userId,
		long[] itemTypeIds, long[] authorIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSuburItem(suburItem, userId, itemTypeIds, authorIds,
			serviceContext);
	}

	public static void deleteItem(com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteItem(suburItem);
	}

	public static java.util.List getItemTypes(long itemId) {
		return getService().getItemTypes(itemId);
	}

	public static java.util.List<com.idetronic.subur.model.SuburItem> getSuburItems(
		int start, int end, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSuburItems(start, end, status);
	}

	/**
	* Publish a subur item
	*
	* @param itemId subur Item Id
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	public static com.idetronic.subur.model.SuburItem publishItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().publishItem(itemId);
	}

	/**
	* Withdraw item from public viewing
	*
	* @param itemId
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	public static com.idetronic.subur.model.SuburItem withDrawItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().withDrawItem(itemId);
	}

	public static int getItemCount(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemCount(status);
	}

	public static java.util.List<com.idetronic.subur.model.SuburItem> getByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroup(groupId);
	}

	public static int countAssetVocabularyById(long vocabularyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAssetVocabularyById(vocabularyId);
	}

	public static int getEntriesCount(
		com.liferay.portlet.asset.service.persistence.AssetEntryQuery entryQuery,
		long[] anyItemTypeIds, long[] allItemTypeIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEntriesCount(entryQuery, anyItemTypeIds, allItemTypeIds);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetEntry> getAssetEntries(
		com.liferay.portlet.asset.service.persistence.AssetEntryQuery entryQuery,
		long[] anyItemTypeIds, long[] allItemTypeIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAssetEntries(entryQuery, anyItemTypeIds, allItemTypeIds);
	}

	/**
	* Add download info for the Item
	*/
	public static void addDownloadStats(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addDownloadStats(itemId);
	}

	/**
	* Add view stats info the Item and increment Asset Entry view counter
	*
	* @param itemId
	* @throws PortalException
	* @throws SystemException
	*/
	public static void addViewStat(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addViewStat(itemId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SuburItemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SuburItemLocalService.class.getName());

			if (invokableLocalService instanceof SuburItemLocalService) {
				_service = (SuburItemLocalService)invokableLocalService;
			}
			else {
				_service = new SuburItemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SuburItemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SuburItemLocalService service) {
	}

	private static SuburItemLocalService _service;
}