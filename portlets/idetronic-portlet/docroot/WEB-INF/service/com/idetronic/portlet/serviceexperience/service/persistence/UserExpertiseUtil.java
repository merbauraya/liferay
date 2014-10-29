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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user expertise service. This utility wraps {@link UserExpertisePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserExpertisePersistence
 * @see UserExpertisePersistenceImpl
 * @generated
 */
public class UserExpertiseUtil {
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
	public static void clearCache(UserExpertise userExpertise) {
		getPersistence().clearCache(userExpertise);
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
	public static List<UserExpertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserExpertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserExpertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserExpertise update(UserExpertise userExpertise)
		throws SystemException {
		return getPersistence().update(userExpertise);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserExpertise update(UserExpertise userExpertise,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userExpertise, serviceContext);
	}

	/**
	* Caches the user expertise in the entity cache if it is enabled.
	*
	* @param userExpertise the user expertise
	*/
	public static void cacheResult(
		com.idetronic.portlet.serviceexperience.model.UserExpertise userExpertise) {
		getPersistence().cacheResult(userExpertise);
	}

	/**
	* Caches the user expertises in the entity cache if it is enabled.
	*
	* @param userExpertises the user expertises
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.portlet.serviceexperience.model.UserExpertise> userExpertises) {
		getPersistence().cacheResult(userExpertises);
	}

	/**
	* Creates a new user expertise with the primary key. Does not add the user expertise to the database.
	*
	* @param userExpertiseId the primary key for the new user expertise
	* @return the new user expertise
	*/
	public static com.idetronic.portlet.serviceexperience.model.UserExpertise create(
		long userExpertiseId) {
		return getPersistence().create(userExpertiseId);
	}

	/**
	* Removes the user expertise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userExpertiseId the primary key of the user expertise
	* @return the user expertise that was removed
	* @throws com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException if a user expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.UserExpertise remove(
		long userExpertiseId)
		throws com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userExpertiseId);
	}

	public static com.idetronic.portlet.serviceexperience.model.UserExpertise updateImpl(
		com.idetronic.portlet.serviceexperience.model.UserExpertise userExpertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userExpertise);
	}

	/**
	* Returns the user expertise with the primary key or throws a {@link com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException} if it could not be found.
	*
	* @param userExpertiseId the primary key of the user expertise
	* @return the user expertise
	* @throws com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException if a user expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.UserExpertise findByPrimaryKey(
		long userExpertiseId)
		throws com.idetronic.portlet.serviceexperience.NoSuchUserExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userExpertiseId);
	}

	/**
	* Returns the user expertise with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userExpertiseId the primary key of the user expertise
	* @return the user expertise, or <code>null</code> if a user expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.serviceexperience.model.UserExpertise fetchByPrimaryKey(
		long userExpertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userExpertiseId);
	}

	/**
	* Returns all the user expertises.
	*
	* @return the user expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.UserExpertise> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.UserExpertise> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.portlet.serviceexperience.model.UserExpertise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user expertises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user expertises.
	*
	* @return the number of user expertises
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserExpertisePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserExpertisePersistence)PortletBeanLocatorUtil.locate(com.idetronic.portlet.serviceexperience.service.ClpSerializer.getServletContextName(),
					UserExpertisePersistence.class.getName());

			ReferenceRegistry.registerReference(UserExpertiseUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserExpertisePersistence persistence) {
	}

	private static UserExpertisePersistence _persistence;
}