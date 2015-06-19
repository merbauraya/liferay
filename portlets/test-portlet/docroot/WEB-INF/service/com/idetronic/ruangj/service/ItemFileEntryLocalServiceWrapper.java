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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ItemFileEntryLocalService}.
 *
 * @author Mazlan Mat
 * @see ItemFileEntryLocalService
 * @generated
 */
public class ItemFileEntryLocalServiceWrapper
	implements ItemFileEntryLocalService,
		ServiceWrapper<ItemFileEntryLocalService> {
	public ItemFileEntryLocalServiceWrapper(
		ItemFileEntryLocalService itemFileEntryLocalService) {
		_itemFileEntryLocalService = itemFileEntryLocalService;
	}

	/**
	* Adds the item file entry to the database. Also notifies the appropriate model listeners.
	*
	* @param itemFileEntry the item file entry
	* @return the item file entry that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.ruangj.model.ItemFileEntry addItemFileEntry(
		com.idetronic.ruangj.model.ItemFileEntry itemFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.addItemFileEntry(itemFileEntry);
	}

	/**
	* Creates a new item file entry with the primary key. Does not add the item file entry to the database.
	*
	* @param itemEntryId the primary key for the new item file entry
	* @return the new item file entry
	*/
	@Override
	public com.idetronic.ruangj.model.ItemFileEntry createItemFileEntry(
		long itemEntryId) {
		return _itemFileEntryLocalService.createItemFileEntry(itemEntryId);
	}

	/**
	* Deletes the item file entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemEntryId the primary key of the item file entry
	* @return the item file entry that was removed
	* @throws PortalException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.ruangj.model.ItemFileEntry deleteItemFileEntry(
		long itemEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.deleteItemFileEntry(itemEntryId);
	}

	/**
	* Deletes the item file entry from the database. Also notifies the appropriate model listeners.
	*
	* @param itemFileEntry the item file entry
	* @return the item file entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.ruangj.model.ItemFileEntry deleteItemFileEntry(
		com.idetronic.ruangj.model.ItemFileEntry itemFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.deleteItemFileEntry(itemFileEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemFileEntryLocalService.dynamicQuery();
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
		return _itemFileEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _itemFileEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _itemFileEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.ruangj.model.ItemFileEntry fetchItemFileEntry(
		long itemEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.fetchItemFileEntry(itemEntryId);
	}

	/**
	* Returns the item file entry with the primary key.
	*
	* @param itemEntryId the primary key of the item file entry
	* @return the item file entry
	* @throws PortalException if a item file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.ruangj.model.ItemFileEntry getItemFileEntry(
		long itemEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.getItemFileEntry(itemEntryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.idetronic.ruangj.model.ItemFileEntry> getItemFileEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.getItemFileEntries(start, end);
	}

	/**
	* Returns the number of item file entries.
	*
	* @return the number of item file entries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getItemFileEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.getItemFileEntriesCount();
	}

	/**
	* Updates the item file entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemFileEntry the item file entry
	* @return the item file entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.ruangj.model.ItemFileEntry updateItemFileEntry(
		com.idetronic.ruangj.model.ItemFileEntry itemFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntryLocalService.updateItemFileEntry(itemFileEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemFileEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemFileEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemFileEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemFileEntryLocalService getWrappedItemFileEntryLocalService() {
		return _itemFileEntryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemFileEntryLocalService(
		ItemFileEntryLocalService itemFileEntryLocalService) {
		_itemFileEntryLocalService = itemFileEntryLocalService;
	}

	@Override
	public ItemFileEntryLocalService getWrappedService() {
		return _itemFileEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ItemFileEntryLocalService itemFileEntryLocalService) {
		_itemFileEntryLocalService = itemFileEntryLocalService;
	}

	private ItemFileEntryLocalService _itemFileEntryLocalService;
}