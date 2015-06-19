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

import com.idetronic.subur.model.Division;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the division service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see DivisionPersistenceImpl
 * @see DivisionUtil
 * @generated
 */
public interface DivisionPersistence extends BasePersistence<Division> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DivisionUtil} to access the division persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the divisions where depositable = &#63;.
	*
	* @param depositable the depositable
	* @return the matching divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.Division> findBydepositable(
		boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the divisions where depositable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param depositable the depositable
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @return the range of matching divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.Division> findBydepositable(
		boolean depositable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the divisions where depositable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param depositable the depositable
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.Division> findBydepositable(
		boolean depositable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first division in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching division
	* @throws com.idetronic.subur.NoSuchDivisionException if a matching division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.Division findBydepositable_First(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first division in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching division, or <code>null</code> if a matching division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.Division fetchBydepositable_First(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last division in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching division
	* @throws com.idetronic.subur.NoSuchDivisionException if a matching division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.Division findBydepositable_Last(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last division in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching division, or <code>null</code> if a matching division could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.Division fetchBydepositable_Last(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the divisions before and after the current division in the ordered set where depositable = &#63;.
	*
	* @param divisionId the primary key of the current division
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next division
	* @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.Division[] findBydepositable_PrevAndNext(
		long divisionId, boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the divisions where depositable = &#63; from the database.
	*
	* @param depositable the depositable
	* @throws SystemException if a system exception occurred
	*/
	public void removeBydepositable(boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of divisions where depositable = &#63;.
	*
	* @param depositable the depositable
	* @return the number of matching divisions
	* @throws SystemException if a system exception occurred
	*/
	public int countBydepositable(boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the division in the entity cache if it is enabled.
	*
	* @param division the division
	*/
	public void cacheResult(com.idetronic.subur.model.Division division);

	/**
	* Caches the divisions in the entity cache if it is enabled.
	*
	* @param divisions the divisions
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.Division> divisions);

	/**
	* Creates a new division with the primary key. Does not add the division to the database.
	*
	* @param divisionId the primary key for the new division
	* @return the new division
	*/
	public com.idetronic.subur.model.Division create(long divisionId);

	/**
	* Removes the division with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param divisionId the primary key of the division
	* @return the division that was removed
	* @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.Division remove(long divisionId)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.Division updateImpl(
		com.idetronic.subur.model.Division division)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the division with the primary key or throws a {@link com.idetronic.subur.NoSuchDivisionException} if it could not be found.
	*
	* @param divisionId the primary key of the division
	* @return the division
	* @throws com.idetronic.subur.NoSuchDivisionException if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.Division findByPrimaryKey(long divisionId)
		throws com.idetronic.subur.NoSuchDivisionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the division with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param divisionId the primary key of the division
	* @return the division, or <code>null</code> if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.Division fetchByPrimaryKey(long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the divisions.
	*
	* @return the divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.Division> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @return the range of divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.Division> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of divisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.Division> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the divisions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of divisions.
	*
	* @return the number of divisions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}