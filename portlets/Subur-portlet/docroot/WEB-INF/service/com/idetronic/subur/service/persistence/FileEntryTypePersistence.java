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

import com.idetronic.subur.model.FileEntryType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the file entry type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FileEntryTypePersistenceImpl
 * @see FileEntryTypeUtil
 * @generated
 */
public interface FileEntryTypePersistence extends BasePersistence<FileEntryType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileEntryTypeUtil} to access the file entry type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the file entry type in the entity cache if it is enabled.
	*
	* @param fileEntryType the file entry type
	*/
	public void cacheResult(
		com.idetronic.subur.model.FileEntryType fileEntryType);

	/**
	* Caches the file entry types in the entity cache if it is enabled.
	*
	* @param fileEntryTypes the file entry types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.FileEntryType> fileEntryTypes);

	/**
	* Creates a new file entry type with the primary key. Does not add the file entry type to the database.
	*
	* @param typeId the primary key for the new file entry type
	* @return the new file entry type
	*/
	public com.idetronic.subur.model.FileEntryType create(long typeId);

	/**
	* Removes the file entry type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the file entry type
	* @return the file entry type that was removed
	* @throws com.idetronic.subur.NoSuchFileEntryTypeException if a file entry type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.FileEntryType remove(long typeId)
		throws com.idetronic.subur.NoSuchFileEntryTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.FileEntryType updateImpl(
		com.idetronic.subur.model.FileEntryType fileEntryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the file entry type with the primary key or throws a {@link com.idetronic.subur.NoSuchFileEntryTypeException} if it could not be found.
	*
	* @param typeId the primary key of the file entry type
	* @return the file entry type
	* @throws com.idetronic.subur.NoSuchFileEntryTypeException if a file entry type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.FileEntryType findByPrimaryKey(long typeId)
		throws com.idetronic.subur.NoSuchFileEntryTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the file entry type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeId the primary key of the file entry type
	* @return the file entry type, or <code>null</code> if a file entry type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.FileEntryType fetchByPrimaryKey(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the file entry types.
	*
	* @return the file entry types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.FileEntryType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the file entry types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.FileEntryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file entry types
	* @param end the upper bound of the range of file entry types (not inclusive)
	* @return the range of file entry types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.FileEntryType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the file entry types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.FileEntryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file entry types
	* @param end the upper bound of the range of file entry types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of file entry types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.FileEntryType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the file entry types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of file entry types.
	*
	* @return the number of file entry types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}