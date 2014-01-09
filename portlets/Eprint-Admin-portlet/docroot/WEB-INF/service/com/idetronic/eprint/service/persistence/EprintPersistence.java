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

package com.idetronic.eprint.service.persistence;

import com.idetronic.eprint.model.Eprint;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the eprint service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matle
 * @see EprintPersistenceImpl
 * @see EprintUtil
 * @generated
 */
public interface EprintPersistence extends BasePersistence<Eprint> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EprintUtil} to access the eprint persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the eprint in the entity cache if it is enabled.
	*
	* @param eprint the eprint
	*/
	public void cacheResult(com.idetronic.eprint.model.Eprint eprint);

	/**
	* Caches the eprints in the entity cache if it is enabled.
	*
	* @param eprints the eprints
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eprint.model.Eprint> eprints);

	/**
	* Creates a new eprint with the primary key. Does not add the eprint to the database.
	*
	* @param eprintId the primary key for the new eprint
	* @return the new eprint
	*/
	public com.idetronic.eprint.model.Eprint create(long eprintId);

	/**
	* Removes the eprint with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint that was removed
	* @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint remove(long eprintId)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eprint.model.Eprint updateImpl(
		com.idetronic.eprint.model.Eprint eprint, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprint with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintException} if it could not be found.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint
	* @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint findByPrimaryKey(long eprintId)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprint with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint, or <code>null</code> if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint fetchByPrimaryKey(long eprintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eprints where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @return the matching eprints
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.Eprint> findByeprintType(
		java.lang.String eprintType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the eprints where eprintType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eprintType the eprint type
	* @param start the lower bound of the range of eprints
	* @param end the upper bound of the range of eprints (not inclusive)
	* @return the range of matching eprints
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.Eprint> findByeprintType(
		java.lang.String eprintType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the eprints where eprintType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eprintType the eprint type
	* @param start the lower bound of the range of eprints
	* @param end the upper bound of the range of eprints (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eprints
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.Eprint> findByeprintType(
		java.lang.String eprintType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprint
	* @throws com.idetronic.eprint.NoSuchEprintException if a matching eprint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint findByeprintType_First(
		java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprint, or <code>null</code> if a matching eprint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint fetchByeprintType_First(
		java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprint
	* @throws com.idetronic.eprint.NoSuchEprintException if a matching eprint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint findByeprintType_Last(
		java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprint, or <code>null</code> if a matching eprint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint fetchByeprintType_Last(
		java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprints before and after the current eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintId the primary key of the current eprint
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next eprint
	* @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.Eprint[] findByeprintType_PrevAndNext(
		long eprintId, java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eprints.
	*
	* @return the eprints
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.Eprint> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the eprints.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprints
	* @param end the upper bound of the range of eprints (not inclusive)
	* @return the range of eprints
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.Eprint> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the eprints.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprints
	* @param end the upper bound of the range of eprints (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eprints
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.Eprint> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eprints where eprintType = &#63; from the database.
	*
	* @param eprintType the eprint type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByeprintType(java.lang.String eprintType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eprints from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eprints where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @return the number of matching eprints
	* @throws SystemException if a system exception occurred
	*/
	public int countByeprintType(java.lang.String eprintType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eprints.
	*
	* @return the number of eprints
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}