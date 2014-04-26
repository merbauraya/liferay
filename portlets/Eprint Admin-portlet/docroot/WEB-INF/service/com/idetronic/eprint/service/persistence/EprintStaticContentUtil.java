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

import com.idetronic.eprint.model.EprintStaticContent;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the eprint static content service. This utility wraps {@link EprintStaticContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintStaticContentPersistence
 * @see EprintStaticContentPersistenceImpl
 * @generated
 */
public class EprintStaticContentUtil {
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
	public static void clearCache(EprintStaticContent eprintStaticContent) {
		getPersistence().clearCache(eprintStaticContent);
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
	public static List<EprintStaticContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EprintStaticContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EprintStaticContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EprintStaticContent update(
		EprintStaticContent eprintStaticContent) throws SystemException {
		return getPersistence().update(eprintStaticContent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EprintStaticContent update(
		EprintStaticContent eprintStaticContent, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(eprintStaticContent, serviceContext);
	}

	/**
	* Caches the eprint static content in the entity cache if it is enabled.
	*
	* @param eprintStaticContent the eprint static content
	*/
	public static void cacheResult(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent) {
		getPersistence().cacheResult(eprintStaticContent);
	}

	/**
	* Caches the eprint static contents in the entity cache if it is enabled.
	*
	* @param eprintStaticContents the eprint static contents
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eprint.model.EprintStaticContent> eprintStaticContents) {
		getPersistence().cacheResult(eprintStaticContents);
	}

	/**
	* Creates a new eprint static content with the primary key. Does not add the eprint static content to the database.
	*
	* @param contentId the primary key for the new eprint static content
	* @return the new eprint static content
	*/
	public static com.idetronic.eprint.model.EprintStaticContent create(
		long contentId) {
		return getPersistence().create(contentId);
	}

	/**
	* Removes the eprint static content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the eprint static content
	* @return the eprint static content that was removed
	* @throws com.idetronic.eprint.NoSuchEprintStaticContentException if a eprint static content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.EprintStaticContent remove(
		long contentId)
		throws com.idetronic.eprint.NoSuchEprintStaticContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(contentId);
	}

	public static com.idetronic.eprint.model.EprintStaticContent updateImpl(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eprintStaticContent);
	}

	/**
	* Returns the eprint static content with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintStaticContentException} if it could not be found.
	*
	* @param contentId the primary key of the eprint static content
	* @return the eprint static content
	* @throws com.idetronic.eprint.NoSuchEprintStaticContentException if a eprint static content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.EprintStaticContent findByPrimaryKey(
		long contentId)
		throws com.idetronic.eprint.NoSuchEprintStaticContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(contentId);
	}

	/**
	* Returns the eprint static content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contentId the primary key of the eprint static content
	* @return the eprint static content, or <code>null</code> if a eprint static content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eprint.model.EprintStaticContent fetchByPrimaryKey(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contentId);
	}

	/**
	* Returns all the eprint static contents.
	*
	* @return the eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eprint.model.EprintStaticContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the eprint static contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintStaticContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprint static contents
	* @param end the upper bound of the range of eprint static contents (not inclusive)
	* @return the range of eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eprint.model.EprintStaticContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the eprint static contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eprint.model.impl.EprintStaticContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprint static contents
	* @param end the upper bound of the range of eprint static contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eprint.model.EprintStaticContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the eprint static contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of eprint static contents.
	*
	* @return the number of eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EprintStaticContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EprintStaticContentPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eprint.service.ClpSerializer.getServletContextName(),
					EprintStaticContentPersistence.class.getName());

			ReferenceRegistry.registerReference(EprintStaticContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EprintStaticContentPersistence persistence) {
	}

	private static EprintStaticContentPersistence _persistence;
}