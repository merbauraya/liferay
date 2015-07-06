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

import com.idetronic.subur.model.Expertise;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the expertise service. This utility wraps {@link ExpertisePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ExpertisePersistence
 * @see ExpertisePersistenceImpl
 * @generated
 */
public class ExpertiseUtil {
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
	public static void clearCache(Expertise expertise) {
		getPersistence().clearCache(expertise);
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
	public static List<Expertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Expertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Expertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Expertise update(Expertise expertise)
		throws SystemException {
		return getPersistence().update(expertise);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Expertise update(Expertise expertise,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(expertise, serviceContext);
	}

	/**
	* Returns all the expertises where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Expertise> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the expertises where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of expertises
	* @param end the upper bound of the range of expertises (not inclusive)
	* @return the range of matching expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Expertise> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the expertises where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of expertises
	* @param end the upper bound of the range of expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Expertise> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first expertise in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expertise
	* @throws com.idetronic.subur.NoSuchExpertiseException if a matching expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first expertise in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expertise, or <code>null</code> if a matching expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last expertise in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expertise
	* @throws com.idetronic.subur.NoSuchExpertiseException if a matching expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last expertise in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expertise, or <code>null</code> if a matching expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the expertises before and after the current expertise in the ordered set where groupId = &#63;.
	*
	* @param expertiseId the primary key of the current expertise
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next expertise
	* @throws com.idetronic.subur.NoSuchExpertiseException if a expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise[] findByGroup_PrevAndNext(
		long expertiseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(expertiseId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the expertises where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of expertises where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching expertises
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the expertise where groupId = &#63; and indexedName = &#63; or throws a {@link com.idetronic.subur.NoSuchExpertiseException} if it could not be found.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @return the matching expertise
	* @throws com.idetronic.subur.NoSuchExpertiseException if a matching expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise findByGroupName(
		long groupId, java.lang.String indexedName)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupName(groupId, indexedName);
	}

	/**
	* Returns the expertise where groupId = &#63; and indexedName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @return the matching expertise, or <code>null</code> if a matching expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise fetchByGroupName(
		long groupId, java.lang.String indexedName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupName(groupId, indexedName);
	}

	/**
	* Returns the expertise where groupId = &#63; and indexedName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching expertise, or <code>null</code> if a matching expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise fetchByGroupName(
		long groupId, java.lang.String indexedName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupName(groupId, indexedName, retrieveFromCache);
	}

	/**
	* Removes the expertise where groupId = &#63; and indexedName = &#63; from the database.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @return the expertise that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise removeByGroupName(
		long groupId, java.lang.String indexedName)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByGroupName(groupId, indexedName);
	}

	/**
	* Returns the number of expertises where groupId = &#63; and indexedName = &#63;.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @return the number of matching expertises
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupName(long groupId,
		java.lang.String indexedName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupName(groupId, indexedName);
	}

	/**
	* Caches the expertise in the entity cache if it is enabled.
	*
	* @param expertise the expertise
	*/
	public static void cacheResult(
		com.idetronic.subur.model.Expertise expertise) {
		getPersistence().cacheResult(expertise);
	}

	/**
	* Caches the expertises in the entity cache if it is enabled.
	*
	* @param expertises the expertises
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.Expertise> expertises) {
		getPersistence().cacheResult(expertises);
	}

	/**
	* Creates a new expertise with the primary key. Does not add the expertise to the database.
	*
	* @param expertiseId the primary key for the new expertise
	* @return the new expertise
	*/
	public static com.idetronic.subur.model.Expertise create(long expertiseId) {
		return getPersistence().create(expertiseId);
	}

	/**
	* Removes the expertise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expertiseId the primary key of the expertise
	* @return the expertise that was removed
	* @throws com.idetronic.subur.NoSuchExpertiseException if a expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise remove(long expertiseId)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(expertiseId);
	}

	public static com.idetronic.subur.model.Expertise updateImpl(
		com.idetronic.subur.model.Expertise expertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(expertise);
	}

	/**
	* Returns the expertise with the primary key or throws a {@link com.idetronic.subur.NoSuchExpertiseException} if it could not be found.
	*
	* @param expertiseId the primary key of the expertise
	* @return the expertise
	* @throws com.idetronic.subur.NoSuchExpertiseException if a expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise findByPrimaryKey(
		long expertiseId)
		throws com.idetronic.subur.NoSuchExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(expertiseId);
	}

	/**
	* Returns the expertise with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param expertiseId the primary key of the expertise
	* @return the expertise, or <code>null</code> if a expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Expertise fetchByPrimaryKey(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(expertiseId);
	}

	/**
	* Returns all the expertises.
	*
	* @return the expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Expertise> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expertises
	* @param end the upper bound of the range of expertises (not inclusive)
	* @return the range of expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Expertise> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expertises
	* @param end the upper bound of the range of expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Expertise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the expertises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of expertises.
	*
	* @return the number of expertises
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExpertisePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExpertisePersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					ExpertisePersistence.class.getName());

			ReferenceRegistry.registerReference(ExpertiseUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ExpertisePersistence persistence) {
	}

	private static ExpertisePersistence _persistence;
}