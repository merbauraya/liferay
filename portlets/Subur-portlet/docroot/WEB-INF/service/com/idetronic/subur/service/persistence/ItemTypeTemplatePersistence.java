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

package com.idetronic.subur.service.persistence;

import com.idetronic.subur.model.ItemTypeTemplate;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item type template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypeTemplatePersistenceImpl
 * @see ItemTypeTemplateUtil
 * @generated
 */
public interface ItemTypeTemplatePersistence extends BasePersistence<ItemTypeTemplate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemTypeTemplateUtil} to access the item type template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the item type template in the entity cache if it is enabled.
	*
	* @param itemTypeTemplate the item type template
	*/
	public void cacheResult(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate);

	/**
	* Caches the item type templates in the entity cache if it is enabled.
	*
	* @param itemTypeTemplates the item type templates
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.ItemTypeTemplate> itemTypeTemplates);

	/**
	* Creates a new item type template with the primary key. Does not add the item type template to the database.
	*
	* @param itemTypeTemplatePK the primary key for the new item type template
	* @return the new item type template
	*/
	public com.idetronic.subur.model.ItemTypeTemplate create(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK);

	/**
	* Removes the item type template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeTemplatePK the primary key of the item type template
	* @return the item type template that was removed
	* @throws com.idetronic.subur.NoSuchItemTypeTemplateException if a item type template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemTypeTemplate remove(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.idetronic.subur.NoSuchItemTypeTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.ItemTypeTemplate updateImpl(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item type template with the primary key or throws a {@link com.idetronic.subur.NoSuchItemTypeTemplateException} if it could not be found.
	*
	* @param itemTypeTemplatePK the primary key of the item type template
	* @return the item type template
	* @throws com.idetronic.subur.NoSuchItemTypeTemplateException if a item type template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemTypeTemplate findByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.idetronic.subur.NoSuchItemTypeTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item type template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemTypeTemplatePK the primary key of the item type template
	* @return the item type template, or <code>null</code> if a item type template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemTypeTemplate fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item type templates.
	*
	* @return the item type templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemTypeTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.ItemTypeTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item type templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemTypeTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item type templates
	* @param end the upper bound of the range of item type templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item type templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemTypeTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item type templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item type templates.
	*
	* @return the number of item type templates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}