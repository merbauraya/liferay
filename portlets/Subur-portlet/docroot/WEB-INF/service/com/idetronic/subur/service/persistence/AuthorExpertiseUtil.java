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

import com.idetronic.subur.model.AuthorExpertise;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the author expertise service. This utility wraps {@link AuthorExpertisePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorExpertisePersistence
 * @see AuthorExpertisePersistenceImpl
 * @generated
 */
public class AuthorExpertiseUtil {
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
	public static void clearCache(AuthorExpertise authorExpertise) {
		getPersistence().clearCache(authorExpertise);
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
	public static List<AuthorExpertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuthorExpertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuthorExpertise> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AuthorExpertise update(AuthorExpertise authorExpertise)
		throws SystemException {
		return getPersistence().update(authorExpertise);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AuthorExpertise update(AuthorExpertise authorExpertise,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(authorExpertise, serviceContext);
	}

	/**
	* Returns all the author expertises where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findByAuthor(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthor(authorId);
	}

	/**
	* Returns a range of all the author expertises where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @return the range of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findByAuthor(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthor(authorId, start, end);
	}

	/**
	* Returns an ordered range of all the author expertises where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findByAuthor(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthor(authorId, start, end, orderByComparator);
	}

	/**
	* Returns the first author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise findByAuthor_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthor_First(authorId, orderByComparator);
	}

	/**
	* Returns the first author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author expertise, or <code>null</code> if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise fetchByAuthor_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAuthor_First(authorId, orderByComparator);
	}

	/**
	* Returns the last author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise findByAuthor_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthor_Last(authorId, orderByComparator);
	}

	/**
	* Returns the last author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author expertise, or <code>null</code> if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise fetchByAuthor_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAuthor_Last(authorId, orderByComparator);
	}

	/**
	* Returns the author expertises before and after the current author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorExpertisePK the primary key of the current author expertise
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise[] findByAuthor_PrevAndNext(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK,
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthor_PrevAndNext(authorExpertisePK, authorId,
			orderByComparator);
	}

	/**
	* Removes all the author expertises where authorId = &#63; from the database.
	*
	* @param authorId the author ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAuthor(authorId);
	}

	/**
	* Returns the number of author expertises where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the number of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAuthor(authorId);
	}

	/**
	* Returns all the author expertises where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @return the matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findByExpertise(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExpertise(expertiseId);
	}

	/**
	* Returns a range of all the author expertises where expertiseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param expertiseId the expertise ID
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @return the range of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findByExpertise(
		long expertiseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExpertise(expertiseId, start, end);
	}

	/**
	* Returns an ordered range of all the author expertises where expertiseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param expertiseId the expertise ID
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findByExpertise(
		long expertiseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpertise(expertiseId, start, end, orderByComparator);
	}

	/**
	* Returns the first author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise findByExpertise_First(
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpertise_First(expertiseId, orderByComparator);
	}

	/**
	* Returns the first author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author expertise, or <code>null</code> if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise fetchByExpertise_First(
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpertise_First(expertiseId, orderByComparator);
	}

	/**
	* Returns the last author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise findByExpertise_Last(
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpertise_Last(expertiseId, orderByComparator);
	}

	/**
	* Returns the last author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author expertise, or <code>null</code> if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise fetchByExpertise_Last(
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpertise_Last(expertiseId, orderByComparator);
	}

	/**
	* Returns the author expertises before and after the current author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param authorExpertisePK the primary key of the current author expertise
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise[] findByExpertise_PrevAndNext(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK,
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpertise_PrevAndNext(authorExpertisePK, expertiseId,
			orderByComparator);
	}

	/**
	* Removes all the author expertises where expertiseId = &#63; from the database.
	*
	* @param expertiseId the expertise ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByExpertise(long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByExpertise(expertiseId);
	}

	/**
	* Returns the number of author expertises where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @return the number of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static int countByExpertise(long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByExpertise(expertiseId);
	}

	/**
	* Caches the author expertise in the entity cache if it is enabled.
	*
	* @param authorExpertise the author expertise
	*/
	public static void cacheResult(
		com.idetronic.subur.model.AuthorExpertise authorExpertise) {
		getPersistence().cacheResult(authorExpertise);
	}

	/**
	* Caches the author expertises in the entity cache if it is enabled.
	*
	* @param authorExpertises the author expertises
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.AuthorExpertise> authorExpertises) {
		getPersistence().cacheResult(authorExpertises);
	}

	/**
	* Creates a new author expertise with the primary key. Does not add the author expertise to the database.
	*
	* @param authorExpertisePK the primary key for the new author expertise
	* @return the new author expertise
	*/
	public static com.idetronic.subur.model.AuthorExpertise create(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK) {
		return getPersistence().create(authorExpertisePK);
	}

	/**
	* Removes the author expertise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorExpertisePK the primary key of the author expertise
	* @return the author expertise that was removed
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise remove(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(authorExpertisePK);
	}

	public static com.idetronic.subur.model.AuthorExpertise updateImpl(
		com.idetronic.subur.model.AuthorExpertise authorExpertise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(authorExpertise);
	}

	/**
	* Returns the author expertise with the primary key or throws a {@link com.idetronic.subur.NoSuchAuthorExpertiseException} if it could not be found.
	*
	* @param authorExpertisePK the primary key of the author expertise
	* @return the author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise findByPrimaryKey(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(authorExpertisePK);
	}

	/**
	* Returns the author expertise with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorExpertisePK the primary key of the author expertise
	* @return the author expertise, or <code>null</code> if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.AuthorExpertise fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(authorExpertisePK);
	}

	/**
	* Returns all the author expertises.
	*
	* @return the author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the author expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @return the range of author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the author expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.AuthorExpertise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the author expertises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of author expertises.
	*
	* @return the number of author expertises
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AuthorExpertisePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AuthorExpertisePersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					AuthorExpertisePersistence.class.getName());

			ReferenceRegistry.registerReference(AuthorExpertiseUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AuthorExpertisePersistence persistence) {
	}

	private static AuthorExpertisePersistence _persistence;
}