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

import com.idetronic.subur.model.MetadataSchema;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the metadata schema service. This utility wraps {@link MetadataSchemaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataSchemaPersistence
 * @see MetadataSchemaPersistenceImpl
 * @generated
 */
public class MetadataSchemaUtil {
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
	public static void clearCache(MetadataSchema metadataSchema) {
		getPersistence().clearCache(metadataSchema);
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
	public static List<MetadataSchema> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MetadataSchema> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MetadataSchema> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MetadataSchema update(MetadataSchema metadataSchema)
		throws SystemException {
		return getPersistence().update(metadataSchema);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MetadataSchema update(MetadataSchema metadataSchema,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(metadataSchema, serviceContext);
	}

	/**
	* Caches the metadata schema in the entity cache if it is enabled.
	*
	* @param metadataSchema the metadata schema
	*/
	public static void cacheResult(
		com.idetronic.subur.model.MetadataSchema metadataSchema) {
		getPersistence().cacheResult(metadataSchema);
	}

	/**
	* Caches the metadata schemas in the entity cache if it is enabled.
	*
	* @param metadataSchemas the metadata schemas
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.MetadataSchema> metadataSchemas) {
		getPersistence().cacheResult(metadataSchemas);
	}

	/**
	* Creates a new metadata schema with the primary key. Does not add the metadata schema to the database.
	*
	* @param metadataSchemaId the primary key for the new metadata schema
	* @return the new metadata schema
	*/
	public static com.idetronic.subur.model.MetadataSchema create(
		long metadataSchemaId) {
		return getPersistence().create(metadataSchemaId);
	}

	/**
	* Removes the metadata schema with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataSchemaId the primary key of the metadata schema
	* @return the metadata schema that was removed
	* @throws com.idetronic.subur.NoSuchMetadataSchemaException if a metadata schema with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataSchema remove(
		long metadataSchemaId)
		throws com.idetronic.subur.NoSuchMetadataSchemaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(metadataSchemaId);
	}

	public static com.idetronic.subur.model.MetadataSchema updateImpl(
		com.idetronic.subur.model.MetadataSchema metadataSchema)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(metadataSchema);
	}

	/**
	* Returns the metadata schema with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataSchemaException} if it could not be found.
	*
	* @param metadataSchemaId the primary key of the metadata schema
	* @return the metadata schema
	* @throws com.idetronic.subur.NoSuchMetadataSchemaException if a metadata schema with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataSchema findByPrimaryKey(
		long metadataSchemaId)
		throws com.idetronic.subur.NoSuchMetadataSchemaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(metadataSchemaId);
	}

	/**
	* Returns the metadata schema with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metadataSchemaId the primary key of the metadata schema
	* @return the metadata schema, or <code>null</code> if a metadata schema with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataSchema fetchByPrimaryKey(
		long metadataSchemaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(metadataSchemaId);
	}

	/**
	* Returns all the metadata schemas.
	*
	* @return the metadata schemas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataSchema> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the metadata schemas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata schemas
	* @param end the upper bound of the range of metadata schemas (not inclusive)
	* @return the range of metadata schemas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataSchema> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the metadata schemas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata schemas
	* @param end the upper bound of the range of metadata schemas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of metadata schemas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataSchema> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the metadata schemas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of metadata schemas.
	*
	* @return the number of metadata schemas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MetadataSchemaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MetadataSchemaPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					MetadataSchemaPersistence.class.getName());

			ReferenceRegistry.registerReference(MetadataSchemaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MetadataSchemaPersistence persistence) {
	}

	private static MetadataSchemaPersistence _persistence;
}