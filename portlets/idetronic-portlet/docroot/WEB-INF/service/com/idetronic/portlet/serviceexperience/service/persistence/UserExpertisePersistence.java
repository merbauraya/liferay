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

package com.idetronic.portlet.serviceexperience.service.persistence;

import com.idetronic.portlet.serviceexperience.model.UserExpertise;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user expertise service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserExpertisePersistenceImpl
 * @see UserExpertiseUtil
 * @generated
 */
public interface UserExpertisePersistence extends BasePersistence<UserExpertise> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserExpertiseUtil} to access the user expertise persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user expertise in the entity cache if it is enabled.
	*
	* @param userExpertise the user expertise
	*/
	public void cacheResult(
		com.idetronic.portlet.serviceexperience.model.UserExpertise userExpertise);

	/**
	* Caches the user expertises in the entity cache if it is enabled.
	*
	* @param userExpertises the user expertises
	*/
	public void cacheResult(
		java.util.List<com.idetronic.portlet.serviceexperience.model.UserExpertise> userExpertises);

	/**
	* Creates a new user expertise with the primary key. Does not add the user expertise to the database.
	*
	* @param userExpertiseId the primary key for the new user expertise
	* @return the new user expertise
	*/
	public com.idetronic.portlet.serviceexperience.model.UserExpertise create(
		long userExpertiseId);

	/**
	* Removes the user expertise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userExpertiseId the primary key of the user expertise
	* @return the user expertise that was removed
	* @throws com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException if a user expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.serviceexperience.model.UserExpertise remove(
		long userExpertiseId)
		throws com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.portlet.serviceexperience.model.UserExpertise updateImpl(
		com.idetronic.portlet.serviceexperience.model.UserExpertise userExpertise)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user expertise with the primary key or throws a {@link com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException} if it could not be found.
	*
	* @param userExpertiseId the primary key of the user expertise
	* @return the user expertise
	* @throws com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException if a user expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.serviceexperience.model.UserExpertise findByPrimaryKey(
		long userExpertiseId)
		throws com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user expertise with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userExpertiseId the primary key of the user expertise
	* @return the user expertise, or <code>null</code> if a user expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.serviceexperience.model.UserExpertise fetchByPrimaryKey(
		long userExpertiseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user expertises.
	*
	* @return the user expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.serviceexperience.model.UserExpertise> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.UserExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user expertises
	* @param end the upper bound of the range of user expertises (not inclusive)
	* @return the range of user expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.serviceexperience.model.UserExpertise> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.UserExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user expertises
	* @param end the upper bound of the range of user expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.serviceexperience.model.UserExpertise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user expertises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user expertises.
	*
	* @return the number of user expertises
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}