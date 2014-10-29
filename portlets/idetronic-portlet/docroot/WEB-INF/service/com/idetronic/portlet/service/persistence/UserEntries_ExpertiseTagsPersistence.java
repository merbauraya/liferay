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

import com.idetronic.portlet.model.UserEntries_ExpertiseTags;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user entries_ expertise tags service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserEntries_ExpertiseTagsPersistenceImpl
 * @see UserEntries_ExpertiseTagsUtil
 * @generated
 */
public interface UserEntries_ExpertiseTagsPersistence extends BasePersistence<UserEntries_ExpertiseTags> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserEntries_ExpertiseTagsUtil} to access the user entries_ expertise tags persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user entries_ expertise tagses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user entries_ expertise tagses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user entries_ expertise tagses
	* @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	* @return the range of matching user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user entries_ expertise tagses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user entries_ expertise tagses
	* @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user entries_ expertise tags in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user entries_ expertise tags
	* @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a matching user entries_ expertise tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user entries_ expertise tags in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user entries_ expertise tags, or <code>null</code> if a matching user entries_ expertise tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user entries_ expertise tags in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user entries_ expertise tags
	* @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a matching user entries_ expertise tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user entries_ expertise tags in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user entries_ expertise tags, or <code>null</code> if a matching user entries_ expertise tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entries_ expertise tagses before and after the current user entries_ expertise tags in the ordered set where userId = &#63;.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the current user entries_ expertise tags
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user entries_ expertise tags
	* @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags[] findByuserId_PrevAndNext(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user entries_ expertise tagses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user entries_ expertise tagses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user entries_ expertise tagses where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @return the matching user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findBytagId(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user entries_ expertise tagses where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagId the tag ID
	* @param start the lower bound of the range of user entries_ expertise tagses
	* @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	* @return the range of matching user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findBytagId(
		long tagId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user entries_ expertise tagses where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagId the tag ID
	* @param start the lower bound of the range of user entries_ expertise tagses
	* @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findBytagId(
		long tagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user entries_ expertise tags in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user entries_ expertise tags
	* @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a matching user entries_ expertise tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags findBytagId_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user entries_ expertise tags in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user entries_ expertise tags, or <code>null</code> if a matching user entries_ expertise tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags fetchBytagId_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user entries_ expertise tags in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user entries_ expertise tags
	* @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a matching user entries_ expertise tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags findBytagId_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user entries_ expertise tags in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user entries_ expertise tags, or <code>null</code> if a matching user entries_ expertise tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags fetchBytagId_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entries_ expertise tagses before and after the current user entries_ expertise tags in the ordered set where tagId = &#63;.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the current user entries_ expertise tags
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user entries_ expertise tags
	* @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags[] findBytagId_PrevAndNext(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK,
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user entries_ expertise tagses where tagId = &#63; from the database.
	*
	* @param tagId the tag ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytagId(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user entries_ expertise tagses where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @return the number of matching user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public int countBytagId(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user entries_ expertise tags in the entity cache if it is enabled.
	*
	* @param userEntries_ExpertiseTags the user entries_ expertise tags
	*/
	public void cacheResult(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags);

	/**
	* Caches the user entries_ expertise tagses in the entity cache if it is enabled.
	*
	* @param userEntries_ExpertiseTagses the user entries_ expertise tagses
	*/
	public void cacheResult(
		java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> userEntries_ExpertiseTagses);

	/**
	* Creates a new user entries_ expertise tags with the primary key. Does not add the user entries_ expertise tags to the database.
	*
	* @param userEntries_ExpertiseTagsPK the primary key for the new user entries_ expertise tags
	* @return the new user entries_ expertise tags
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags create(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK);

	/**
	* Removes the user entries_ expertise tags with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	* @return the user entries_ expertise tags that was removed
	* @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags remove(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.portlet.model.UserEntries_ExpertiseTags updateImpl(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entries_ expertise tags with the primary key or throws a {@link com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException} if it could not be found.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	* @return the user entries_ expertise tags
	* @throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags findByPrimaryKey(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.idetronic.portlet.NoSuchUserEntries_ExpertiseTagsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entries_ expertise tags with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userEntries_ExpertiseTagsPK the primary key of the user entries_ expertise tags
	* @return the user entries_ expertise tags, or <code>null</code> if a user entries_ expertise tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags fetchByPrimaryKey(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK userEntries_ExpertiseTagsPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user entries_ expertise tagses.
	*
	* @return the user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user entries_ expertise tagses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user entries_ expertise tagses
	* @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	* @return the range of user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user entries_ expertise tagses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserEntries_ExpertiseTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user entries_ expertise tagses
	* @param end the upper bound of the range of user entries_ expertise tagses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserEntries_ExpertiseTags> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user entries_ expertise tagses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user entries_ expertise tagses.
	*
	* @return the number of user entries_ expertise tagses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}