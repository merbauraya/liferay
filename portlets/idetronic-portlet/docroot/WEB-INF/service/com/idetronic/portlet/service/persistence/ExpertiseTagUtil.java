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

import com.idetronic.portlet.model.ExpertiseTag;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the expertise tag service. This utility wraps {@link ExpertiseTagPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ExpertiseTagPersistence
 * @see ExpertiseTagPersistenceImpl
 * @generated
 */
public class ExpertiseTagUtil {
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
	public static void clearCache(ExpertiseTag expertiseTag) {
		getPersistence().clearCache(expertiseTag);
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
	public static List<ExpertiseTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExpertiseTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExpertiseTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ExpertiseTag update(ExpertiseTag expertiseTag)
		throws SystemException {
		return getPersistence().update(expertiseTag);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ExpertiseTag update(ExpertiseTag expertiseTag,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(expertiseTag, serviceContext);
	}

	/**
	* Returns all the expertise tags where tagName = &#63;.
	*
	* @param tagName the tag name
	* @return the matching expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findByTagName(
		java.lang.String tagName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagName(tagName);
	}

	/**
	* Returns a range of all the expertise tags where tagName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagName the tag name
	* @param start the lower bound of the range of expertise tags
	* @param end the upper bound of the range of expertise tags (not inclusive)
	* @return the range of matching expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findByTagName(
		java.lang.String tagName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagName(tagName, start, end);
	}

	/**
	* Returns an ordered range of all the expertise tags where tagName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagName the tag name
	* @param start the lower bound of the range of expertise tags
	* @param end the upper bound of the range of expertise tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findByTagName(
		java.lang.String tagName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTagName(tagName, start, end, orderByComparator);
	}

	/**
	* Returns the first expertise tag in the ordered set where tagName = &#63;.
	*
	* @param tagName the tag name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expertise tag
	* @throws com.idetronic.portlet.NoSuchExpertiseTagException if a matching expertise tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ExpertiseTag findByTagName_First(
		java.lang.String tagName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchExpertiseTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagName_First(tagName, orderByComparator);
	}

	/**
	* Returns the first expertise tag in the ordered set where tagName = &#63;.
	*
	* @param tagName the tag name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching expertise tag, or <code>null</code> if a matching expertise tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ExpertiseTag fetchByTagName_First(
		java.lang.String tagName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTagName_First(tagName, orderByComparator);
	}

	/**
	* Returns the last expertise tag in the ordered set where tagName = &#63;.
	*
	* @param tagName the tag name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expertise tag
	* @throws com.idetronic.portlet.NoSuchExpertiseTagException if a matching expertise tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ExpertiseTag findByTagName_Last(
		java.lang.String tagName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchExpertiseTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagName_Last(tagName, orderByComparator);
	}

	/**
	* Returns the last expertise tag in the ordered set where tagName = &#63;.
	*
	* @param tagName the tag name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching expertise tag, or <code>null</code> if a matching expertise tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ExpertiseTag fetchByTagName_Last(
		java.lang.String tagName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTagName_Last(tagName, orderByComparator);
	}

	/**
	* Returns the expertise tags before and after the current expertise tag in the ordered set where tagName = &#63;.
	*
	* @param tagId the primary key of the current expertise tag
	* @param tagName the tag name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next expertise tag
	* @throws com.idetronic.portlet.NoSuchExpertiseTagException if a expertise tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ExpertiseTag[] findByTagName_PrevAndNext(
		long tagId, java.lang.String tagName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchExpertiseTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTagName_PrevAndNext(tagId, tagName, orderByComparator);
	}

	/**
	* Returns all the expertise tags where tagName = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagNames the tag names
	* @return the matching expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findByTagName(
		java.lang.String[] tagNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagName(tagNames);
	}

	/**
	* Returns a range of all the expertise tags where tagName = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagNames the tag names
	* @param start the lower bound of the range of expertise tags
	* @param end the upper bound of the range of expertise tags (not inclusive)
	* @return the range of matching expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findByTagName(
		java.lang.String[] tagNames, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagName(tagNames, start, end);
	}

	/**
	* Returns an ordered range of all the expertise tags where tagName = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagNames the tag names
	* @param start the lower bound of the range of expertise tags
	* @param end the upper bound of the range of expertise tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findByTagName(
		java.lang.String[] tagNames, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTagName(tagNames, start, end, orderByComparator);
	}

	/**
	* Removes all the expertise tags where tagName = &#63; from the database.
	*
	* @param tagName the tag name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTagName(java.lang.String tagName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTagName(tagName);
	}

	/**
	* Returns the number of expertise tags where tagName = &#63;.
	*
	* @param tagName the tag name
	* @return the number of matching expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTagName(java.lang.String tagName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTagName(tagName);
	}

	/**
	* Returns the number of expertise tags where tagName = any &#63;.
	*
	* @param tagNames the tag names
	* @return the number of matching expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTagName(java.lang.String[] tagNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTagName(tagNames);
	}

	/**
	* Caches the expertise tag in the entity cache if it is enabled.
	*
	* @param expertiseTag the expertise tag
	*/
	public static void cacheResult(
		com.idetronic.portlet.model.ExpertiseTag expertiseTag) {
		getPersistence().cacheResult(expertiseTag);
	}

	/**
	* Caches the expertise tags in the entity cache if it is enabled.
	*
	* @param expertiseTags the expertise tags
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.portlet.model.ExpertiseTag> expertiseTags) {
		getPersistence().cacheResult(expertiseTags);
	}

	/**
	* Creates a new expertise tag with the primary key. Does not add the expertise tag to the database.
	*
	* @param tagId the primary key for the new expertise tag
	* @return the new expertise tag
	*/
	public static com.idetronic.portlet.model.ExpertiseTag create(long tagId) {
		return getPersistence().create(tagId);
	}

	/**
	* Removes the expertise tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagId the primary key of the expertise tag
	* @return the expertise tag that was removed
	* @throws com.idetronic.portlet.NoSuchExpertiseTagException if a expertise tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ExpertiseTag remove(long tagId)
		throws com.idetronic.portlet.NoSuchExpertiseTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(tagId);
	}

	public static com.idetronic.portlet.model.ExpertiseTag updateImpl(
		com.idetronic.portlet.model.ExpertiseTag expertiseTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(expertiseTag);
	}

	/**
	* Returns the expertise tag with the primary key or throws a {@link com.idetronic.portlet.NoSuchExpertiseTagException} if it could not be found.
	*
	* @param tagId the primary key of the expertise tag
	* @return the expertise tag
	* @throws com.idetronic.portlet.NoSuchExpertiseTagException if a expertise tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ExpertiseTag findByPrimaryKey(
		long tagId)
		throws com.idetronic.portlet.NoSuchExpertiseTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(tagId);
	}

	/**
	* Returns the expertise tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagId the primary key of the expertise tag
	* @return the expertise tag, or <code>null</code> if a expertise tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.ExpertiseTag fetchByPrimaryKey(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tagId);
	}

	/**
	* Returns all the expertise tags.
	*
	* @return the expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the expertise tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expertise tags
	* @param end the upper bound of the range of expertise tags (not inclusive)
	* @return the range of expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the expertise tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.ExpertiseTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expertise tags
	* @param end the upper bound of the range of expertise tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.ExpertiseTag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the expertise tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of expertise tags.
	*
	* @return the number of expertise tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExpertiseTagPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExpertiseTagPersistence)PortletBeanLocatorUtil.locate(com.idetronic.portlet.service.ClpSerializer.getServletContextName(),
					ExpertiseTagPersistence.class.getName());

			ReferenceRegistry.registerReference(ExpertiseTagUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ExpertiseTagPersistence persistence) {
	}

	private static ExpertiseTagPersistence _persistence;
}