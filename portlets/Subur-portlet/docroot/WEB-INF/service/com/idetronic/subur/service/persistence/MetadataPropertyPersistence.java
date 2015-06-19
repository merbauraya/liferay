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

import com.idetronic.subur.model.MetadataProperty;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the metadata property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataPropertyPersistenceImpl
 * @see MetadataPropertyUtil
 * @generated
 */
public interface MetadataPropertyPersistence extends BasePersistence<MetadataProperty> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MetadataPropertyUtil} to access the metadata property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the metadata property in the entity cache if it is enabled.
	*
	* @param metadataProperty the metadata property
	*/
	public void cacheResult(
		com.idetronic.subur.model.MetadataProperty metadataProperty);

	/**
	* Caches the metadata properties in the entity cache if it is enabled.
	*
	* @param metadataProperties the metadata properties
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.MetadataProperty> metadataProperties);

	/**
	* Creates a new metadata property with the primary key. Does not add the metadata property to the database.
	*
	* @param metadataPropertyId the primary key for the new metadata property
	* @return the new metadata property
	*/
	public com.idetronic.subur.model.MetadataProperty create(
		long metadataPropertyId);

	/**
	* Removes the metadata property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataPropertyId the primary key of the metadata property
	* @return the metadata property that was removed
	* @throws com.idetronic.subur.NoSuchMetadataPropertyException if a metadata property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.MetadataProperty remove(
		long metadataPropertyId)
		throws com.idetronic.subur.NoSuchMetadataPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.MetadataProperty updateImpl(
		com.idetronic.subur.model.MetadataProperty metadataProperty)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the metadata property with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataPropertyException} if it could not be found.
	*
	* @param metadataPropertyId the primary key of the metadata property
	* @return the metadata property
	* @throws com.idetronic.subur.NoSuchMetadataPropertyException if a metadata property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.MetadataProperty findByPrimaryKey(
		long metadataPropertyId)
		throws com.idetronic.subur.NoSuchMetadataPropertyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the metadata property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metadataPropertyId the primary key of the metadata property
	* @return the metadata property, or <code>null</code> if a metadata property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.MetadataProperty fetchByPrimaryKey(
		long metadataPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the metadata properties.
	*
	* @return the metadata properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.MetadataProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the metadata properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata properties
	* @param end the upper bound of the range of metadata properties (not inclusive)
	* @return the range of metadata properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.MetadataProperty> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the metadata properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata properties
	* @param end the upper bound of the range of metadata properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of metadata properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.MetadataProperty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the metadata properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of metadata properties.
	*
	* @return the number of metadata properties
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}