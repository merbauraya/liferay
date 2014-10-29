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

package com.idetronic.portlet.service.persistence;

import com.idetronic.portlet.model.ServiceExperience;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the service experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ServiceExperiencePersistenceImpl
 * @see ServiceExperienceUtil
 * @generated
 */
public interface ServiceExperiencePersistence extends BasePersistence<ServiceExperience> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceExperienceUtil} to access the service experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the service experiences where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching service experiences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.ServiceExperience> findBybyUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service experiences where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @return the range of matching service experiences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.ServiceExperience> findBybyUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service experiences where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service experiences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.ServiceExperience> findBybyUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service experience in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service experience
	* @throws com.idetronic.portlet.NoSuchServiceExperienceException if a matching service experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.ServiceExperience findBybyUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service experience in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service experience, or <code>null</code> if a matching service experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.ServiceExperience fetchBybyUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service experience in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service experience
	* @throws com.idetronic.portlet.NoSuchServiceExperienceException if a matching service experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.ServiceExperience findBybyUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service experience in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service experience, or <code>null</code> if a matching service experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.ServiceExperience fetchBybyUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service experiences before and after the current service experience in the ordered set where userId = &#63;.
	*
	* @param serviceExperienceId the primary key of the current service experience
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service experience
	* @throws com.idetronic.portlet.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.ServiceExperience[] findBybyUserId_PrevAndNext(
		long serviceExperienceId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service experiences where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service experiences where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching service experiences
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the service experience in the entity cache if it is enabled.
	*
	* @param serviceExperience the service experience
	*/
	public void cacheResult(
		com.idetronic.portlet.model.ServiceExperience serviceExperience);

	/**
	* Caches the service experiences in the entity cache if it is enabled.
	*
	* @param serviceExperiences the service experiences
	*/
	public void cacheResult(
		java.util.List<com.idetronic.portlet.model.ServiceExperience> serviceExperiences);

	/**
	* Creates a new service experience with the primary key. Does not add the service experience to the database.
	*
	* @param serviceExperienceId the primary key for the new service experience
	* @return the new service experience
	*/
	public com.idetronic.portlet.model.ServiceExperience create(
		long serviceExperienceId);

	/**
	* Removes the service experience with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience that was removed
	* @throws com.idetronic.portlet.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.ServiceExperience remove(
		long serviceExperienceId)
		throws com.idetronic.portlet.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.portlet.model.ServiceExperience updateImpl(
		com.idetronic.portlet.model.ServiceExperience serviceExperience)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service experience with the primary key or throws a {@link com.idetronic.portlet.NoSuchServiceExperienceException} if it could not be found.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience
	* @throws com.idetronic.portlet.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.ServiceExperience findByPrimaryKey(
		long serviceExperienceId)
		throws com.idetronic.portlet.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service experience with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience, or <code>null</code> if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.ServiceExperience fetchByPrimaryKey(
		long serviceExperienceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service experiences.
	*
	* @return the service experiences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.ServiceExperience> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service experiences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @return the range of service experiences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.ServiceExperience> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service experiences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service experiences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.ServiceExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service experiences from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service experiences.
	*
	* @return the number of service experiences
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}