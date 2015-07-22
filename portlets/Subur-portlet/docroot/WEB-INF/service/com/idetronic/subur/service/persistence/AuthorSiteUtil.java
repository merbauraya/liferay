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

import com.idetronic.subur.model.AuthorSite;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the author site service. This utility wraps {@link AuthorSitePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorSitePersistence
 * @see AuthorSitePersistenceImpl
 * @generated
 */
public class AuthorSiteUtil {
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
	public static void clearCache(AuthorSite authorSite) {
		getPersistence().clearCache(authorSite);
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
	public static List<AuthorSite> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuthorSite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuthorSite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AuthorSite update(AuthorSite authorSite)
		throws SystemException {
		return getPersistence().update(authorSite);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AuthorSite update(AuthorSite authorSite,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(authorSite, serviceContext);
	}

	/**
	* Returns all the author sites where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the matching author sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorSite> findByAuthor(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthor(authorId);
	}

	/**
	* Returns a range of all the author sites where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of author sites
	* @param end the upper bound of the range of author sites (not inclusive)
	* @return the range of matching author sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorSite> findByAuthor(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthor(authorId, start, end);
	}

	/**
	* Returns an ordered range of all the author sites where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of author sites
	* @param end the upper bound of the range of author sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching author sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorSite> findByAuthor(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthor(authorId, start, end, orderByComparator);
	}

	/**
	* Returns the first author site in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author site
	* @throws com.idetronic.subur.NoSuchAuthorSiteException if a matching author site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite findByAuthor_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthor_First(authorId, orderByComparator);
	}

	/**
	* Returns the first author site in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author site, or <code>null</code> if a matching author site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite fetchByAuthor_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAuthor_First(authorId, orderByComparator);
	}

	/**
	* Returns the last author site in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author site
	* @throws com.idetronic.subur.NoSuchAuthorSiteException if a matching author site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite findByAuthor_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthor_Last(authorId, orderByComparator);
	}

	/**
	* Returns the last author site in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author site, or <code>null</code> if a matching author site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite fetchByAuthor_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAuthor_Last(authorId, orderByComparator);
	}

	/**
	* Returns the author sites before and after the current author site in the ordered set where authorId = &#63;.
	*
	* @param authorSiteId the primary key of the current author site
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author site
	* @throws com.idetronic.subur.NoSuchAuthorSiteException if a author site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite[] findByAuthor_PrevAndNext(
		long authorSiteId, long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthor_PrevAndNext(authorSiteId, authorId,
			orderByComparator);
	}

	/**
	* Removes all the author sites where authorId = &#63; from the database.
	*
	* @param authorId the author ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAuthor(authorId);
	}

	/**
	* Returns the number of author sites where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the number of matching author sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAuthor(authorId);
	}

	/**
	* Returns the author site where authorId = &#63; and siteName = &#63; or throws a {@link com.idetronic.subur.NoSuchAuthorSiteException} if it could not be found.
	*
	* @param authorId the author ID
	* @param siteName the site name
	* @return the matching author site
	* @throws com.idetronic.subur.NoSuchAuthorSiteException if a matching author site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite findByAuthorSite(
		long authorId, java.lang.String siteName)
		throws com.idetronic.subur.NoSuchAuthorSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthorSite(authorId, siteName);
	}

	/**
	* Returns the author site where authorId = &#63; and siteName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param authorId the author ID
	* @param siteName the site name
	* @return the matching author site, or <code>null</code> if a matching author site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite fetchByAuthorSite(
		long authorId, java.lang.String siteName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAuthorSite(authorId, siteName);
	}

	/**
	* Returns the author site where authorId = &#63; and siteName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param authorId the author ID
	* @param siteName the site name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching author site, or <code>null</code> if a matching author site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite fetchByAuthorSite(
		long authorId, java.lang.String siteName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorSite(authorId, siteName, retrieveFromCache);
	}

	/**
	* Removes the author site where authorId = &#63; and siteName = &#63; from the database.
	*
	* @param authorId the author ID
	* @param siteName the site name
	* @return the author site that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite removeByAuthorSite(
		long authorId, java.lang.String siteName)
		throws com.idetronic.subur.NoSuchAuthorSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByAuthorSite(authorId, siteName);
	}

	/**
	* Returns the number of author sites where authorId = &#63; and siteName = &#63;.
	*
	* @param authorId the author ID
	* @param siteName the site name
	* @return the number of matching author sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthorSite(long authorId, java.lang.String siteName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAuthorSite(authorId, siteName);
	}

	/**
	* Caches the author site in the entity cache if it is enabled.
	*
	* @param authorSite the author site
	*/
	public static void cacheResult(
		com.idetronic.subur.model.AuthorSite authorSite) {
		getPersistence().cacheResult(authorSite);
	}

	/**
	* Caches the author sites in the entity cache if it is enabled.
	*
	* @param authorSites the author sites
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.AuthorSite> authorSites) {
		getPersistence().cacheResult(authorSites);
	}

	/**
	* Creates a new author site with the primary key. Does not add the author site to the database.
	*
	* @param authorSiteId the primary key for the new author site
	* @return the new author site
	*/
	public static com.idetronic.subur.model.AuthorSite create(long authorSiteId) {
		return getPersistence().create(authorSiteId);
	}

	/**
	* Removes the author site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorSiteId the primary key of the author site
	* @return the author site that was removed
	* @throws com.idetronic.subur.NoSuchAuthorSiteException if a author site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite remove(long authorSiteId)
		throws com.idetronic.subur.NoSuchAuthorSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(authorSiteId);
	}

	public static com.idetronic.subur.model.AuthorSite updateImpl(
		com.idetronic.subur.model.AuthorSite authorSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(authorSite);
	}

	/**
	* Returns the author site with the primary key or throws a {@link com.idetronic.subur.NoSuchAuthorSiteException} if it could not be found.
	*
	* @param authorSiteId the primary key of the author site
	* @return the author site
	* @throws com.idetronic.subur.NoSuchAuthorSiteException if a author site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite findByPrimaryKey(
		long authorSiteId)
		throws com.idetronic.subur.NoSuchAuthorSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(authorSiteId);
	}

	/**
	* Returns the author site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorSiteId the primary key of the author site
	* @return the author site, or <code>null</code> if a author site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorSite fetchByPrimaryKey(
		long authorSiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(authorSiteId);
	}

	/**
	* Returns all the author sites.
	*
	* @return the author sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorSite> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the author sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author sites
	* @param end the upper bound of the range of author sites (not inclusive)
	* @return the range of author sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorSite> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the author sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author sites
	* @param end the upper bound of the range of author sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of author sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorSite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the author sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of author sites.
	*
	* @return the number of author sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AuthorSitePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AuthorSitePersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					AuthorSitePersistence.class.getName());

			ReferenceRegistry.registerReference(AuthorSiteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AuthorSitePersistence persistence) {
	}

	private static AuthorSitePersistence _persistence;
}