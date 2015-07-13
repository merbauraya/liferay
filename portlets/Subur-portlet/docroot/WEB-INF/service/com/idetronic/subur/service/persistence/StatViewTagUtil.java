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

import com.idetronic.subur.model.StatViewTag;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the stat view tag service. This utility wraps {@link StatViewTagPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewTagPersistence
 * @see StatViewTagPersistenceImpl
 * @generated
 */
public class StatViewTagUtil {
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
	public static void clearCache(StatViewTag statViewTag) {
		getPersistence().clearCache(statViewTag);
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
	public static List<StatViewTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatViewTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatViewTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StatViewTag update(StatViewTag statViewTag)
		throws SystemException {
		return getPersistence().update(statViewTag);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StatViewTag update(StatViewTag statViewTag,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(statViewTag, serviceContext);
	}

	/**
	* Returns all the stat view tags where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @return the matching stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewTag> findByTag(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTag(tagId);
	}

	/**
	* Returns a range of all the stat view tags where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagId the tag ID
	* @param start the lower bound of the range of stat view tags
	* @param end the upper bound of the range of stat view tags (not inclusive)
	* @return the range of matching stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewTag> findByTag(
		long tagId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTag(tagId, start, end);
	}

	/**
	* Returns an ordered range of all the stat view tags where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagId the tag ID
	* @param start the lower bound of the range of stat view tags
	* @param end the upper bound of the range of stat view tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewTag> findByTag(
		long tagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTag(tagId, start, end, orderByComparator);
	}

	/**
	* Returns the first stat view tag in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat view tag
	* @throws com.idetronic.subur.NoSuchStatViewTagException if a matching stat view tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewTag findByTag_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTag_First(tagId, orderByComparator);
	}

	/**
	* Returns the first stat view tag in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat view tag, or <code>null</code> if a matching stat view tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewTag fetchByTag_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTag_First(tagId, orderByComparator);
	}

	/**
	* Returns the last stat view tag in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat view tag
	* @throws com.idetronic.subur.NoSuchStatViewTagException if a matching stat view tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewTag findByTag_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTag_Last(tagId, orderByComparator);
	}

	/**
	* Returns the last stat view tag in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat view tag, or <code>null</code> if a matching stat view tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewTag fetchByTag_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTag_Last(tagId, orderByComparator);
	}

	/**
	* Returns the stat view tags before and after the current stat view tag in the ordered set where tagId = &#63;.
	*
	* @param id the primary key of the current stat view tag
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat view tag
	* @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewTag[] findByTag_PrevAndNext(
		long id, long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTag_PrevAndNext(id, tagId, orderByComparator);
	}

	/**
	* Removes all the stat view tags where tagId = &#63; from the database.
	*
	* @param tagId the tag ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTag(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTag(tagId);
	}

	/**
	* Returns the number of stat view tags where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @return the number of matching stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTag(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTag(tagId);
	}

	/**
	* Caches the stat view tag in the entity cache if it is enabled.
	*
	* @param statViewTag the stat view tag
	*/
	public static void cacheResult(
		com.idetronic.subur.model.StatViewTag statViewTag) {
		getPersistence().cacheResult(statViewTag);
	}

	/**
	* Caches the stat view tags in the entity cache if it is enabled.
	*
	* @param statViewTags the stat view tags
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.StatViewTag> statViewTags) {
		getPersistence().cacheResult(statViewTags);
	}

	/**
	* Creates a new stat view tag with the primary key. Does not add the stat view tag to the database.
	*
	* @param id the primary key for the new stat view tag
	* @return the new stat view tag
	*/
	public static com.idetronic.subur.model.StatViewTag create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the stat view tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat view tag
	* @return the stat view tag that was removed
	* @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewTag remove(long id)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.idetronic.subur.model.StatViewTag updateImpl(
		com.idetronic.subur.model.StatViewTag statViewTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(statViewTag);
	}

	/**
	* Returns the stat view tag with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewTagException} if it could not be found.
	*
	* @param id the primary key of the stat view tag
	* @return the stat view tag
	* @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewTag findByPrimaryKey(
		long id)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the stat view tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat view tag
	* @return the stat view tag, or <code>null</code> if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatViewTag fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the stat view tags.
	*
	* @return the stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewTag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stat view tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view tags
	* @param end the upper bound of the range of stat view tags (not inclusive)
	* @return the range of stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewTag> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stat view tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view tags
	* @param end the upper bound of the range of stat view tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatViewTag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the stat view tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stat view tags.
	*
	* @return the number of stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StatViewTagPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StatViewTagPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					StatViewTagPersistence.class.getName());

			ReferenceRegistry.registerReference(StatViewTagUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StatViewTagPersistence persistence) {
	}

	private static StatViewTagPersistence _persistence;
}