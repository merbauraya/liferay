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

import com.idetronic.subur.model.MetadataValue;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the metadata value service. This utility wraps {@link MetadataValuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataValuePersistence
 * @see MetadataValuePersistenceImpl
 * @generated
 */
public class MetadataValueUtil {
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
	public static void clearCache(MetadataValue metadataValue) {
		getPersistence().clearCache(metadataValue);
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
	public static List<MetadataValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MetadataValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MetadataValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MetadataValue update(MetadataValue metadataValue)
		throws SystemException {
		return getPersistence().update(metadataValue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MetadataValue update(MetadataValue metadataValue,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(metadataValue, serviceContext);
	}

	/**
	* Caches the metadata value in the entity cache if it is enabled.
	*
	* @param metadataValue the metadata value
	*/
	public static void cacheResult(
		com.idetronic.subur.model.MetadataValue metadataValue) {
		getPersistence().cacheResult(metadataValue);
	}

	/**
	* Caches the metadata values in the entity cache if it is enabled.
	*
	* @param metadataValues the metadata values
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.MetadataValue> metadataValues) {
		getPersistence().cacheResult(metadataValues);
	}

	/**
	* Creates a new metadata value with the primary key. Does not add the metadata value to the database.
	*
	* @param metadataValueId the primary key for the new metadata value
	* @return the new metadata value
	*/
	public static com.idetronic.subur.model.MetadataValue create(
		long metadataValueId) {
		return getPersistence().create(metadataValueId);
	}

	/**
	* Removes the metadata value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataValueId the primary key of the metadata value
	* @return the metadata value that was removed
	* @throws com.idetronic.subur.NoSuchMetadataValueException if a metadata value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataValue remove(
		long metadataValueId)
		throws com.idetronic.subur.NoSuchMetadataValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(metadataValueId);
	}

	public static com.idetronic.subur.model.MetadataValue updateImpl(
		com.idetronic.subur.model.MetadataValue metadataValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(metadataValue);
	}

	/**
	* Returns the metadata value with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataValueException} if it could not be found.
	*
	* @param metadataValueId the primary key of the metadata value
	* @return the metadata value
	* @throws com.idetronic.subur.NoSuchMetadataValueException if a metadata value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataValue findByPrimaryKey(
		long metadataValueId)
		throws com.idetronic.subur.NoSuchMetadataValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(metadataValueId);
	}

	/**
	* Returns the metadata value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metadataValueId the primary key of the metadata value
	* @return the metadata value, or <code>null</code> if a metadata value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataValue fetchByPrimaryKey(
		long metadataValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(metadataValueId);
	}

	/**
	* Returns all the metadata values.
	*
	* @return the metadata values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the metadata values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata values
	* @param end the upper bound of the range of metadata values (not inclusive)
	* @return the range of metadata values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the metadata values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata values
	* @param end the upper bound of the range of metadata values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of metadata values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the metadata values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of metadata values.
	*
	* @return the number of metadata values
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MetadataValuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MetadataValuePersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					MetadataValuePersistence.class.getName());

			ReferenceRegistry.registerReference(MetadataValueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MetadataValuePersistence persistence) {
	}

	private static MetadataValuePersistence _persistence;
}