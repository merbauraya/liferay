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

import com.idetronic.subur.model.MetadataPropertyValue;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the metadata property value service. This utility wraps {@link MetadataPropertyValuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataPropertyValuePersistence
 * @see MetadataPropertyValuePersistenceImpl
 * @generated
 */
public class MetadataPropertyValueUtil {
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
	public static void clearCache(MetadataPropertyValue metadataPropertyValue) {
		getPersistence().clearCache(metadataPropertyValue);
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
	public static List<MetadataPropertyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MetadataPropertyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MetadataPropertyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MetadataPropertyValue update(
		MetadataPropertyValue metadataPropertyValue) throws SystemException {
		return getPersistence().update(metadataPropertyValue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MetadataPropertyValue update(
		MetadataPropertyValue metadataPropertyValue,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(metadataPropertyValue, serviceContext);
	}

	/**
	* Returns all the metadata property values where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching metadata property values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataPropertyValue> findBybyItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyItemId(itemId);
	}

	/**
	* Returns a range of all the metadata property values where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of metadata property values
	* @param end the upper bound of the range of metadata property values (not inclusive)
	* @return the range of matching metadata property values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataPropertyValue> findBybyItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyItemId(itemId, start, end);
	}

	/**
	* Returns an ordered range of all the metadata property values where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of metadata property values
	* @param end the upper bound of the range of metadata property values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching metadata property values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataPropertyValue> findBybyItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyItemId(itemId, start, end, orderByComparator);
	}

	/**
	* Returns the first metadata property value in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching metadata property value
	* @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a matching metadata property value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue findBybyItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchMetadataPropertyValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyItemId_First(itemId, orderByComparator);
	}

	/**
	* Returns the first metadata property value in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching metadata property value, or <code>null</code> if a matching metadata property value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue fetchBybyItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyItemId_First(itemId, orderByComparator);
	}

	/**
	* Returns the last metadata property value in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching metadata property value
	* @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a matching metadata property value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue findBybyItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchMetadataPropertyValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyItemId_Last(itemId, orderByComparator);
	}

	/**
	* Returns the last metadata property value in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching metadata property value, or <code>null</code> if a matching metadata property value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue fetchBybyItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyItemId_Last(itemId, orderByComparator);
	}

	/**
	* Returns the metadata property values before and after the current metadata property value in the ordered set where itemId = &#63;.
	*
	* @param metadataPropertyValueId the primary key of the current metadata property value
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next metadata property value
	* @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a metadata property value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue[] findBybyItemId_PrevAndNext(
		long metadataPropertyValueId, long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchMetadataPropertyValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyItemId_PrevAndNext(metadataPropertyValueId, itemId,
			orderByComparator);
	}

	/**
	* Removes all the metadata property values where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyItemId(itemId);
	}

	/**
	* Returns the number of metadata property values where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching metadata property values
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyItemId(itemId);
	}

	/**
	* Caches the metadata property value in the entity cache if it is enabled.
	*
	* @param metadataPropertyValue the metadata property value
	*/
	public static void cacheResult(
		com.idetronic.subur.model.MetadataPropertyValue metadataPropertyValue) {
		getPersistence().cacheResult(metadataPropertyValue);
	}

	/**
	* Caches the metadata property values in the entity cache if it is enabled.
	*
	* @param metadataPropertyValues the metadata property values
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.MetadataPropertyValue> metadataPropertyValues) {
		getPersistence().cacheResult(metadataPropertyValues);
	}

	/**
	* Creates a new metadata property value with the primary key. Does not add the metadata property value to the database.
	*
	* @param metadataPropertyValueId the primary key for the new metadata property value
	* @return the new metadata property value
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue create(
		long metadataPropertyValueId) {
		return getPersistence().create(metadataPropertyValueId);
	}

	/**
	* Removes the metadata property value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataPropertyValueId the primary key of the metadata property value
	* @return the metadata property value that was removed
	* @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a metadata property value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue remove(
		long metadataPropertyValueId)
		throws com.idetronic.subur.NoSuchMetadataPropertyValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(metadataPropertyValueId);
	}

	public static com.idetronic.subur.model.MetadataPropertyValue updateImpl(
		com.idetronic.subur.model.MetadataPropertyValue metadataPropertyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(metadataPropertyValue);
	}

	/**
	* Returns the metadata property value with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataPropertyValueException} if it could not be found.
	*
	* @param metadataPropertyValueId the primary key of the metadata property value
	* @return the metadata property value
	* @throws com.idetronic.subur.NoSuchMetadataPropertyValueException if a metadata property value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue findByPrimaryKey(
		long metadataPropertyValueId)
		throws com.idetronic.subur.NoSuchMetadataPropertyValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(metadataPropertyValueId);
	}

	/**
	* Returns the metadata property value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metadataPropertyValueId the primary key of the metadata property value
	* @return the metadata property value, or <code>null</code> if a metadata property value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataPropertyValue fetchByPrimaryKey(
		long metadataPropertyValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(metadataPropertyValueId);
	}

	/**
	* Returns all the metadata property values.
	*
	* @return the metadata property values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataPropertyValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the metadata property values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata property values
	* @param end the upper bound of the range of metadata property values (not inclusive)
	* @return the range of metadata property values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataPropertyValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the metadata property values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata property values
	* @param end the upper bound of the range of metadata property values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of metadata property values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataPropertyValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the metadata property values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of metadata property values.
	*
	* @return the number of metadata property values
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MetadataPropertyValuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MetadataPropertyValuePersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					MetadataPropertyValuePersistence.class.getName());

			ReferenceRegistry.registerReference(MetadataPropertyValueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MetadataPropertyValuePersistence persistence) {
	}

	private static MetadataPropertyValuePersistence _persistence;
}