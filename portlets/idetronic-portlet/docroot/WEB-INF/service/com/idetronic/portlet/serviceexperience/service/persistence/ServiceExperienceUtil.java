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

import com.idetronic.portlet.serviceexperience.model.ServiceExperience;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the service experience service. This utility wraps {@link ServiceExperiencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ServiceExperiencePersistence
 * @see ServiceExperiencePersistenceImpl
 * @generated
 */
public class ServiceExperienceUtil {
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
	public static void clearCache(ServiceExperience serviceExperience) {
		getPersistence().clearCache(serviceExperience);
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
	public static List<ServiceExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ServiceExperience update(ServiceExperience serviceExperience)
		throws SystemException {
		return getPersistence().update(serviceExperience);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ServiceExperience update(
		ServiceExperience serviceExperience, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(serviceExperience, serviceContext);
	}

	/**
	* Returns all the service experiences where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> findBybyUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(userId);
	}

	/**
	* Returns a range of all the service experiences where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @return the range of matching service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> findBybyUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the service experiences where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> findBybyUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first service experience in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service experience
	* @throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException if a matching service experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience findBybyUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first service experience in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service experience, or <code>null</code> if a matching service experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience fetchBybyUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last service experience in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service experience
	* @throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException if a matching service experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience findBybyUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last service experience in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service experience, or <code>null</code> if a matching service experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience fetchBybyUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the service experiences before and after the current service experience in the ordered set where userId = &#63;.
	*
	* @param serviceExperienceId the primary key of the current service experience
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service experience
	* @throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience[] findBybyUserId_PrevAndNext(
		long serviceExperienceId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserId_PrevAndNext(serviceExperienceId, userId,
			orderByComparator);
	}

	/**
	* Removes all the service experiences where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyUserId(userId);
	}

	/**
	* Returns the number of service experiences where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyUserId(userId);
	}

	/**
	* Caches the service experience in the entity cache if it is enabled.
	*
	* @param serviceExperience the service experience
	*/
	public static void cacheResult(
		com.idetronic.portlet.serviceexperience.model.ServiceExperience serviceExperience) {
		getPersistence().cacheResult(serviceExperience);
	}

	/**
	* Caches the service experiences in the entity cache if it is enabled.
	*
	* @param serviceExperiences the service experiences
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> serviceExperiences) {
		getPersistence().cacheResult(serviceExperiences);
	}

	/**
	* Creates a new service experience with the primary key. Does not add the service experience to the database.
	*
	* @param serviceExperienceId the primary key for the new service experience
	* @return the new service experience
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience create(
		long serviceExperienceId) {
		return getPersistence().create(serviceExperienceId);
	}

	/**
	* Removes the service experience with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience that was removed
	* @throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience remove(
		long serviceExperienceId)
		throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(serviceExperienceId);
	}

	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience updateImpl(
		com.idetronic.portlet.serviceexperience.model.ServiceExperience serviceExperience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(serviceExperience);
	}

	/**
	* Returns the service experience with the primary key or throws a {@link com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException} if it could not be found.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience
	* @throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience findByPrimaryKey(
		long serviceExperienceId)
		throws com.idetronic.portlet.serviceexperience.NoSuchServiceExperienceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(serviceExperienceId);
	}

	/**
	* Returns the service experience with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceExperienceId the primary key of the service experience
	* @return the service experience, or <code>null</code> if a service experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.ServiceExperience fetchByPrimaryKey(
		long serviceExperienceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(serviceExperienceId);
	}

	/**
	* Returns all the service experiences.
	*
	* @return the service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the service experiences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @return the range of service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the service experiences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.serviceexperience.model.impl.ServiceExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service experiences
	* @param end the upper bound of the range of service experiences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.ServiceExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the service experiences from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of service experiences.
	*
	* @return the number of service experiences
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ServiceExperiencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ServiceExperiencePersistence)PortletBeanLocatorUtil.locate(com.idetronic.portlet.serviceexperience.service.ClpSerializer.getServletContextName(),
					ServiceExperiencePersistence.class.getName());

			ReferenceRegistry.registerReference(ServiceExperienceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ServiceExperiencePersistence persistence) {
	}

	private static ServiceExperiencePersistence _persistence;
}