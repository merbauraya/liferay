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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the metadata value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataValuePersistenceImpl
 * @see MetadataValueUtil
 * @generated
 */
public interface MetadataValuePersistence extends BasePersistence<MetadataValue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MetadataValueUtil} to access the metadata value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the metadata value in the entity cache if it is enabled.
	*
	* @param metadataValue the metadata value
	*/
	public void cacheResult(
		com.idetronic.subur.model.MetadataValue metadataValue);

	/**
	* Caches the metadata values in the entity cache if it is enabled.
	*
	* @param metadataValues the metadata values
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.MetadataValue> metadataValues);

	/**
	* Creates a new metadata value with the primary key. Does not add the metadata value to the database.
	*
	* @param metadataValueId the primary key for the new metadata value
	* @return the new metadata value
	*/
	public com.idetronic.subur.model.MetadataValue create(long metadataValueId);

	/**
	* Removes the metadata value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataValueId the primary key of the metadata value
	* @return the metadata value that was removed
	* @throws com.idetronic.subur.NoSuchMetadataValueException if a metadata value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.MetadataValue remove(long metadataValueId)
		throws com.idetronic.subur.NoSuchMetadataValueException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.MetadataValue updateImpl(
		com.idetronic.subur.model.MetadataValue metadataValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the metadata value with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataValueException} if it could not be found.
	*
	* @param metadataValueId the primary key of the metadata value
	* @return the metadata value
	* @throws com.idetronic.subur.NoSuchMetadataValueException if a metadata value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.MetadataValue findByPrimaryKey(
		long metadataValueId)
		throws com.idetronic.subur.NoSuchMetadataValueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the metadata value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metadataValueId the primary key of the metadata value
	* @return the metadata value, or <code>null</code> if a metadata value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.MetadataValue fetchByPrimaryKey(
		long metadataValueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the metadata values.
	*
	* @return the metadata values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.MetadataValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.MetadataValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.MetadataValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the metadata values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of metadata values.
	*
	* @return the number of metadata values
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}