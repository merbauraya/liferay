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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the file entry type service. This utility wraps {@link FileEntryTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FileEntryTypePersistence
 * @see FileEntryTypePersistenceImpl
 * @generated
 */
public class FileEntryTypeUtil {
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
	public static void clearCache(FileEntryType fileEntryType) {
		getPersistence().clearCache(fileEntryType);
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
	public static List<FileEntryType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FileEntryType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FileEntryType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FileEntryType update(FileEntryType fileEntryType)
		throws SystemException {
		return getPersistence().update(fileEntryType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FileEntryType update(FileEntryType fileEntryType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(fileEntryType, serviceContext);
	}

	/**
	* Caches the file entry type in the entity cache if it is enabled.
	*
	* @param fileEntryType the file entry type
	*/
	public static void cacheResult(
		com.idetronic.subur.model.FileEntryType fileEntryType) {
		getPersistence().cacheResult(fileEntryType);
	}

	/**
	* Caches the file entry types in the entity cache if it is enabled.
	*
	* @param fileEntryTypes the file entry types
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.FileEntryType> fileEntryTypes) {
		getPersistence().cacheResult(fileEntryTypes);
	}

	/**
	* Creates a new file entry type with the primary key. Does not add the file entry type to the database.
	*
	* @param typeId the primary key for the new file entry type
	* @return the new file entry type
	*/
	public static com.idetronic.subur.model.FileEntryType create(long typeId) {
		return getPersistence().create(typeId);
	}

	/**
	* Removes the file entry type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the file entry type
	* @return the file entry type that was removed
	* @throws com.idetronic.subur.NoSuchFileEntryTypeException if a file entry type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.FileEntryType remove(long typeId)
		throws com.idetronic.subur.NoSuchFileEntryTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(typeId);
	}

	public static com.idetronic.subur.model.FileEntryType updateImpl(
		com.idetronic.subur.model.FileEntryType fileEntryType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(fileEntryType);
	}

	/**
	* Returns the file entry type with the primary key or throws a {@link com.idetronic.subur.NoSuchFileEntryTypeException} if it could not be found.
	*
	* @param typeId the primary key of the file entry type
	* @return the file entry type
	* @throws com.idetronic.subur.NoSuchFileEntryTypeException if a file entry type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.FileEntryType findByPrimaryKey(
		long typeId)
		throws com.idetronic.subur.NoSuchFileEntryTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(typeId);
	}

	/**
	* Returns the file entry type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeId the primary key of the file entry type
	* @return the file entry type, or <code>null</code> if a file entry type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.FileEntryType fetchByPrimaryKey(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(typeId);
	}

	/**
	* Returns all the file entry types.
	*
	* @return the file entry types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.FileEntryType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.subur.model.FileEntryType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.subur.model.FileEntryType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the file entry types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of file entry types.
	*
	* @return the number of file entry types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FileEntryTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FileEntryTypePersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					FileEntryTypePersistence.class.getName());

			ReferenceRegistry.registerReference(FileEntryTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FileEntryTypePersistence persistence) {
	}

	private static FileEntryTypePersistence _persistence;
}