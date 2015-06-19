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
 * Provides a wrapper for {@link ItemTypeTemplateLocalService}.
 *
 * @author Mazlan Mat
 * @see ItemTypeTemplateLocalService
 * @generated
 */
public class ItemTypeTemplateLocalServiceWrapper
	implements ItemTypeTemplateLocalService,
		ServiceWrapper<ItemTypeTemplateLocalService> {
	public ItemTypeTemplateLocalServiceWrapper(
		ItemTypeTemplateLocalService itemTypeTemplateLocalService) {
		_itemTypeTemplateLocalService = itemTypeTemplateLocalService;
	}

	/**
	* Adds the item type template to the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeTemplate the item type template
	* @return the item type template that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemTypeTemplate addItemTypeTemplate(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.addItemTypeTemplate(itemTypeTemplate);
	}

	/**
	* Creates a new item type template with the primary key. Does not add the item type template to the database.
	*
	* @param itemTypeTemplatePK the primary key for the new item type template
	* @return the new item type template
	*/
	@Override
	public com.idetronic.subur.model.ItemTypeTemplate createItemTypeTemplate(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK) {
		return _itemTypeTemplateLocalService.createItemTypeTemplate(itemTypeTemplatePK);
	}

	/**
	* Deletes the item type template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeTemplatePK the primary key of the item type template
	* @return the item type template that was removed
	* @throws PortalException if a item type template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemTypeTemplate deleteItemTypeTemplate(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.deleteItemTypeTemplate(itemTypeTemplatePK);
	}

	/**
	* Deletes the item type template from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeTemplate the item type template
	* @return the item type template that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemTypeTemplate deleteItemTypeTemplate(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.deleteItemTypeTemplate(itemTypeTemplate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemTypeTemplateLocalService.dynamicQuery();
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
		return _itemTypeTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemTypeTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemTypeTemplateLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemTypeTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemTypeTemplateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _itemTypeTemplateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _itemTypeTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.ItemTypeTemplate fetchItemTypeTemplate(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.fetchItemTypeTemplate(itemTypeTemplatePK);
	}

	/**
	* Returns the item type template with the primary key.
	*
	* @param itemTypeTemplatePK the primary key of the item type template
	* @return the item type template
	* @throws PortalException if a item type template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemTypeTemplate getItemTypeTemplate(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.getItemTypeTemplate(itemTypeTemplatePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the item type templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemTypeTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item type templates
	* @param end the upper bound of the range of item type templates (not inclusive)
	* @return the range of item type templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.ItemTypeTemplate> getItemTypeTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.getItemTypeTemplates(start, end);
	}

	/**
	* Returns the number of item type templates.
	*
	* @return the number of item type templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getItemTypeTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.getItemTypeTemplatesCount();
	}

	/**
	* Updates the item type template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemTypeTemplate the item type template
	* @return the item type template that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemTypeTemplate updateItemTypeTemplate(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeTemplateLocalService.updateItemTypeTemplate(itemTypeTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemTypeTemplateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemTypeTemplateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemTypeTemplateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemTypeTemplateLocalService getWrappedItemTypeTemplateLocalService() {
		return _itemTypeTemplateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemTypeTemplateLocalService(
		ItemTypeTemplateLocalService itemTypeTemplateLocalService) {
		_itemTypeTemplateLocalService = itemTypeTemplateLocalService;
	}

	@Override
	public ItemTypeTemplateLocalService getWrappedService() {
		return _itemTypeTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		ItemTypeTemplateLocalService itemTypeTemplateLocalService) {
		_itemTypeTemplateLocalService = itemTypeTemplateLocalService;
	}

	private ItemTypeTemplateLocalService _itemTypeTemplateLocalService;
}