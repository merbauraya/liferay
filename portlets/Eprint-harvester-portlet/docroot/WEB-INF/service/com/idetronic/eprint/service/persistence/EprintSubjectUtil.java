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

import com.idetronic.eprint.model.EprintSubject;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the eprint subject service. This utility wraps {@link EprintSubjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintSubjectPersistence
 * @see EprintSubjectPersistenceImpl
 * @generated
 */
public class EprintSubjectUtil {
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
	public static void clearCache(EprintSubject eprintSubject) {
		getPersistence().clearCache(eprintSubject);
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
	public static List<EprintSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EprintSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EprintSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EprintSubject update(EprintSubject eprintSubject,
		boolean merge) throws SystemException {
		return getPersistence().update(eprintSubject, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EprintSubject update(EprintSubject eprintSubject,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eprintSubject, merge, serviceContext);
	}

	/**
	* Caches the eprint subject in the entity cache if it is enabled.
	*
	* @param eprintSubject the eprint subject
	*/
	public static void cacheResult(
		com.idetronic.eprint.model.EprintSubject eprintSubject) {
		getPersistence().cacheResult(eprintSubject);
	}

	/**
	* Caches the eprint subjects in the entity cache if it is enabled.
	*
	* @param eprintSubjects the eprint subjects
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eprint.model.EprintSubject> eprintSubjects) {
		getPersistence().cacheResult(eprintSubjects);
	}

	/**
	* Creates a new eprint subject with the primary key. Does not add the eprint subject to the database.
	*
	* @param eprintId the primary key for the new eprint subject
	* @return the new eprint subject
	*/
	public static com.idetronic.eprint.model.EprintSubject create(long eprintId) {
		return getPersistence().create(eprintId);
	}

	/**
	* Removes the eprint subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eprintId the primary key of the eprint subject
	* @return the eprint subject that was removed
	* @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.EprintSubject remove(long eprintId)
		throws com.idetronic.eprint.NoSuchEprintSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eprintId);
	}

	public static com.idetronic.eprint.model.EprintSubject updateImpl(
		com.idetronic.eprint.model.EprintSubject eprintSubject, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eprintSubject, merge);
	}

	/**
	* Returns the eprint subject with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintSubjectException} if it could not be found.
	*
	* @param eprintId the primary key of the eprint subject
	* @return the eprint subject
	* @throws com.idetronic.eprint.NoSuchEprintSubjectException if a eprint subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.EprintSubject findByPrimaryKey(
		long eprintId)
		throws com.idetronic.eprint.NoSuchEprintSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eprintId);
	}

	/**
	* Returns the eprint subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eprintId the primary key of the eprint subject
	* @return the eprint subject, or <code>null</code> if a eprint subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.EprintSubject fetchByPrimaryKey(
		long eprintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eprintId);
	}

	/**
	* Returns all the eprint subjects.
	*
	* @return the eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eprint.model.EprintSubject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the eprint subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprint subjects
	* @param end the upper bound of the range of eprint subjects (not inclusive)
	* @return the range of eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eprint.model.EprintSubject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the eprint subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprint subjects
	* @param end the upper bound of the range of eprint subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eprint.model.EprintSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the eprint subjects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of eprint subjects.
	*
	* @return the number of eprint subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EprintSubjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EprintSubjectPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eprint.service.ClpSerializer.getServletContextName(),
					EprintSubjectPersistence.class.getName());

			ReferenceRegistry.registerReference(EprintSubjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EprintSubjectPersistence persistence) {
	}

	private static EprintSubjectPersistence _persistence;
}