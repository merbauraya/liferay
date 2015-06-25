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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SuburItemLocalService}.
 *
 * @author Mazlan Mat
 * @see SuburItemLocalService
 * @generated
 */
public class SuburItemLocalServiceWrapper implements SuburItemLocalService,
	ServiceWrapper<SuburItemLocalService> {
	public SuburItemLocalServiceWrapper(
		SuburItemLocalService suburItemLocalService) {
		_suburItemLocalService = suburItemLocalService;
	}

	/**
	* Adds the subur item to the database. Also notifies the appropriate model listeners.
	*
	* @param suburItem the subur item
	* @return the subur item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburItem addSuburItem(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.addSuburItem(suburItem);
	}

	/**
	* Creates a new subur item with the primary key. Does not add the subur item to the database.
	*
	* @param itemId the primary key for the new subur item
	* @return the new subur item
	*/
	@Override
	public com.idetronic.subur.model.SuburItem createSuburItem(long itemId) {
		return _suburItemLocalService.createSuburItem(itemId);
	}

	/**
	* Deletes the subur item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item that was removed
	* @throws PortalException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburItem deleteSuburItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.deleteSuburItem(itemId);
	}

	/**
	* Deletes the subur item from the database. Also notifies the appropriate model listeners.
	*
	* @param suburItem the subur item
	* @return the subur item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburItem deleteSuburItem(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.deleteSuburItem(suburItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _suburItemLocalService.dynamicQuery();
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
		return _suburItemLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _suburItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _suburItemLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.subur.model.SuburItem fetchSuburItem(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.fetchSuburItem(itemId);
	}

	/**
	* Returns the subur item with the primary key.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item
	* @throws PortalException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburItem getSuburItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.getSuburItem(itemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.idetronic.subur.model.SuburItem> getSuburItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.getSuburItems(start, end);
	}

	/**
	* Returns the number of subur items.
	*
	* @return the number of subur items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSuburItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.getSuburItemsCount();
	}

	/**
	* Updates the subur item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param suburItem the subur item
	* @return the subur item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburItem updateSuburItem(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.updateSuburItem(suburItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _suburItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_suburItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _suburItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.subur.model.SuburItem addItem(long userId,
		long groupId, java.lang.String title, java.lang.String itemAbstract,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.addItem(userId, groupId, title,
			itemAbstract, serviceContext);
	}

	@Override
	public com.idetronic.subur.model.SuburItem updateSuburItem(
		com.idetronic.subur.model.SuburItem suburItem, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.updateSuburItem(suburItem, userId,
			serviceContext);
	}

	@Override
	public java.util.List getItemTypes(long itemId) {
		return _suburItemLocalService.getItemTypes(itemId);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.SuburItem> getSuburItems(
		int start, int end, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.getSuburItems(start, end, status);
	}

	/**
	* Publish a subur item
	*
	* @param itemId subur Item Id
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	@Override
	public com.idetronic.subur.model.SuburItem publishItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.publishItem(itemId);
	}

	/**
	* Withdraw item from public viewing
	*
	* @param itemId
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	@Override
	public com.idetronic.subur.model.SuburItem withDrawItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.withDrawItem(itemId);
	}

	@Override
	public int getItemCount(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.getItemCount(status);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.SuburItem> getByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.getByGroup(groupId);
	}

	@Override
	public java.util.List getDetails(long itemId) {
		return _suburItemLocalService.getDetails(itemId);
	}

	@Override
	public java.util.List getFileEntry(long itemId) {
		return _suburItemLocalService.getFileEntry(itemId);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.SuburItem> getBySubjectId(
		long subjectId, int start, int end) {
		return _suburItemLocalService.getBySubjectId(subjectId, start, end);
	}

	@Override
	public int countAssetVocabularyById(long vocabularyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItemLocalService.countAssetVocabularyById(vocabularyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SuburItemLocalService getWrappedSuburItemLocalService() {
		return _suburItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSuburItemLocalService(
		SuburItemLocalService suburItemLocalService) {
		_suburItemLocalService = suburItemLocalService;
	}

	@Override
	public SuburItemLocalService getWrappedService() {
		return _suburItemLocalService;
	}

	@Override
	public void setWrappedService(SuburItemLocalService suburItemLocalService) {
		_suburItemLocalService = suburItemLocalService;
	}

	private SuburItemLocalService _suburItemLocalService;
}