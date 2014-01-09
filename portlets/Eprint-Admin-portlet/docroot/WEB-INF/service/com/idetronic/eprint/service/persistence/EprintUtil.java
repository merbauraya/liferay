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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the eprint service. This utility wraps {@link EprintPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matle
 * @see EprintPersistence
 * @see EprintPersistenceImpl
 * @generated
 */
public class EprintUtil {
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
	public static void clearCache(Eprint eprint) {
		getPersistence().clearCache(eprint);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Eprint> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Eprint> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Eprint> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Eprint update(Eprint eprint, boolean merge)
		throws SystemException {
		return getPersistence().update(eprint, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Eprint update(Eprint eprint, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eprint, merge, serviceContext);
	}

	/**
	* Caches the eprint in the entity cache if it is enabled.
	*
	* @param eprint the eprint
	*/
	public static void cacheResult(com.idetronic.eprint.model.Eprint eprint) {
		getPersistence().cacheResult(eprint);
	}

	/**
	* Caches the eprints in the entity cache if it is enabled.
	*
	* @param eprints the eprints
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eprint.model.Eprint> eprints) {
		getPersistence().cacheResult(eprints);
	}

	/**
	* Creates a new eprint with the primary key. Does not add the eprint to the database.
	*
	* @param eprintId the primary key for the new eprint
	* @return the new eprint
	*/
	public static com.idetronic.eprint.model.Eprint create(long eprintId) {
		return getPersistence().create(eprintId);
	}

	/**
	* Removes the eprint with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint that was removed
	* @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint remove(long eprintId)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eprintId);
	}

	public static com.idetronic.eprint.model.Eprint updateImpl(
		com.idetronic.eprint.model.Eprint eprint, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eprint, merge);
	}

	/**
	* Returns the eprint with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintException} if it could not be found.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint
	* @throws com.idetronic.eprint.NoSuchEprintException if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint findByPrimaryKey(
		long eprintId)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eprintId);
	}

	/**
	* Returns the eprint with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eprintId the primary key of the eprint
	* @return the eprint, or <code>null</code> if a eprint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint fetchByPrimaryKey(
		long eprintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eprintId);
	}

	/**
	* Returns all the eprints where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @return the matching eprints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eprint.model.Eprint> findByeprintType(
		java.lang.String eprintType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByeprintType(eprintType);
	}

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
	public static java.util.List<com.idetronic.eprint.model.Eprint> findByeprintType(
		java.lang.String eprintType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByeprintType(eprintType, start, end);
	}

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
	public static java.util.List<com.idetronic.eprint.model.Eprint> findByeprintType(
		java.lang.String eprintType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByeprintType(eprintType, start, end, orderByComparator);
	}

	/**
	* Returns the first eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprint
	* @throws com.idetronic.eprint.NoSuchEprintException if a matching eprint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint findByeprintType_First(
		java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByeprintType_First(eprintType, orderByComparator);
	}

	/**
	* Returns the first eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprint, or <code>null</code> if a matching eprint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint fetchByeprintType_First(
		java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByeprintType_First(eprintType, orderByComparator);
	}

	/**
	* Returns the last eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprint
	* @throws com.idetronic.eprint.NoSuchEprintException if a matching eprint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint findByeprintType_Last(
		java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByeprintType_Last(eprintType, orderByComparator);
	}

	/**
	* Returns the last eprint in the ordered set where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprint, or <code>null</code> if a matching eprint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.Eprint fetchByeprintType_Last(
		java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByeprintType_Last(eprintType, orderByComparator);
	}

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
	public static com.idetronic.eprint.model.Eprint[] findByeprintType_PrevAndNext(
		long eprintId, java.lang.String eprintType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eprint.NoSuchEprintException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByeprintType_PrevAndNext(eprintId, eprintType,
			orderByComparator);
	}

	/**
	* Returns all the eprints.
	*
	* @return the eprints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eprint.model.Eprint> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.eprint.model.Eprint> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.eprint.model.Eprint> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the eprints where eprintType = &#63; from the database.
	*
	* @param eprintType the eprint type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByeprintType(java.lang.String eprintType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByeprintType(eprintType);
	}

	/**
	* Removes all the eprints from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of eprints where eprintType = &#63;.
	*
	* @param eprintType the eprint type
	* @return the number of matching eprints
	* @throws SystemException if a system exception occurred
	*/
	public static int countByeprintType(java.lang.String eprintType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByeprintType(eprintType);
	}

	/**
	* Returns the number of eprints.
	*
	* @return the number of eprints
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EprintPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EprintPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eprint.service.ClpSerializer.getServletContextName(),
					EprintPersistence.class.getName());

			ReferenceRegistry.registerReference(EprintUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EprintPersistence persistence) {
	}

	private static EprintPersistence _persistence;
}