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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the item type template service. This utility wraps {@link ItemTypeTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypeTemplatePersistence
 * @see ItemTypeTemplatePersistenceImpl
 * @generated
 */
public class ItemTypeTemplateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ItemTypeTemplate itemTypeTemplate) {
		getPersistence().clearCache(itemTypeTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ItemTypeTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ItemTypeTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ItemTypeTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ItemTypeTemplate update(ItemTypeTemplate itemTypeTemplate)
		throws SystemException {
		return getPersistence().update(itemTypeTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ItemTypeTemplate update(ItemTypeTemplate itemTypeTemplate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(itemTypeTemplate, serviceContext);
	}

	/**
	* Caches the item type template in the entity cache if it is enabled.
	*
	* @param itemTypeTemplate the item type template
	*/
	public static void cacheResult(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate) {
		getPersistence().cacheResult(itemTypeTemplate);
	}

	/**
	* Caches the item type templates in the entity cache if it is enabled.
	*
	* @param itemTypeTemplates the item type templates
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.ItemTypeTemplate> itemTypeTemplates) {
		getPersistence().cacheResult(itemTypeTemplates);
	}

	/**
	* Creates a new item type template with the primary key. Does not add the item type template to the database.
	*
	* @param itemTypeTemplatePK the primary key for the new item type template
	* @return the new item type template
	*/
	public static com.idetronic.subur.model.ItemTypeTemplate create(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK) {
		return getPersistence().create(itemTypeTemplatePK);
	}

	/**
	* Removes the item type template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeTemplatePK the primary key of the item type template
	* @return the item type template that was removed
	* @throws com.idetronic.subur.NoSuchItemTypeTemplateException if a item type template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemTypeTemplate remove(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.idetronic.subur.NoSuchItemTypeTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemTypeTemplatePK);
	}

	public static com.idetronic.subur.model.ItemTypeTemplate updateImpl(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(itemTypeTemplate);
	}

	/**
	* Returns the item type template with the primary key or throws a {@link com.idetronic.subur.NoSuchItemTypeTemplateException} if it could not be found.
	*
	* @param itemTypeTemplatePK the primary key of the item type template
	* @return the item type template
	* @throws com.idetronic.subur.NoSuchItemTypeTemplateException if a item type template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemTypeTemplate findByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.idetronic.subur.NoSuchItemTypeTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemTypeTemplatePK);
	}

	/**
	* Returns the item type template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemTypeTemplatePK the primary key of the item type template
	* @return the item type template, or <code>null</code> if a item type template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemTypeTemplate fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK itemTypeTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemTypeTemplatePK);
	}

	/**
	* Returns all the item type templates.
	*
	* @return the item type templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemTypeTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.idetronic.subur.model.ItemTypeTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.subur.model.ItemTypeTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the item type templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item type templates.
	*
	* @return the number of item type templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ItemTypeTemplatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemTypeTemplatePersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					ItemTypeTemplatePersistence.class.getName());

			ReferenceRegistry.registerReference(ItemTypeTemplateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ItemTypeTemplatePersistence persistence) {
	}

	private static ItemTypeTemplatePersistence _persistence;
}