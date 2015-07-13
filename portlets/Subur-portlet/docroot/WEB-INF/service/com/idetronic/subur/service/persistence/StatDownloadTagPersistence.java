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

import com.idetronic.subur.model.StatDownloadTag;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the stat download tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadTagPersistenceImpl
 * @see StatDownloadTagUtil
 * @generated
 */
public interface StatDownloadTagPersistence extends BasePersistence<StatDownloadTag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatDownloadTagUtil} to access the stat download tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the stat download tags where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @return the matching stat download tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadTag> findByTag(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat download tags where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagId the tag ID
	* @param start the lower bound of the range of stat download tags
	* @param end the upper bound of the range of stat download tags (not inclusive)
	* @return the range of matching stat download tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadTag> findByTag(
		long tagId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat download tags where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagId the tag ID
	* @param start the lower bound of the range of stat download tags
	* @param end the upper bound of the range of stat download tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat download tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadTag> findByTag(
		long tagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat download tag in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download tag
	* @throws com.idetronic.subur.NoSuchStatDownloadTagException if a matching stat download tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadTag findByTag_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat download tag in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download tag, or <code>null</code> if a matching stat download tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadTag fetchByTag_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat download tag in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download tag
	* @throws com.idetronic.subur.NoSuchStatDownloadTagException if a matching stat download tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadTag findByTag_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat download tag in the ordered set where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download tag, or <code>null</code> if a matching stat download tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadTag fetchByTag_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download tags before and after the current stat download tag in the ordered set where tagId = &#63;.
	*
	* @param id the primary key of the current stat download tag
	* @param tagId the tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat download tag
	* @throws com.idetronic.subur.NoSuchStatDownloadTagException if a stat download tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadTag[] findByTag_PrevAndNext(
		long id, long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat download tags where tagId = &#63; from the database.
	*
	* @param tagId the tag ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTag(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat download tags where tagId = &#63;.
	*
	* @param tagId the tag ID
	* @return the number of matching stat download tags
	* @throws SystemException if a system exception occurred
	*/
	public int countByTag(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the stat download tag in the entity cache if it is enabled.
	*
	* @param statDownloadTag the stat download tag
	*/
	public void cacheResult(
		com.idetronic.subur.model.StatDownloadTag statDownloadTag);

	/**
	* Caches the stat download tags in the entity cache if it is enabled.
	*
	* @param statDownloadTags the stat download tags
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.StatDownloadTag> statDownloadTags);

	/**
	* Creates a new stat download tag with the primary key. Does not add the stat download tag to the database.
	*
	* @param id the primary key for the new stat download tag
	* @return the new stat download tag
	*/
	public com.idetronic.subur.model.StatDownloadTag create(long id);

	/**
	* Removes the stat download tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat download tag
	* @return the stat download tag that was removed
	* @throws com.idetronic.subur.NoSuchStatDownloadTagException if a stat download tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadTag remove(long id)
		throws com.idetronic.subur.NoSuchStatDownloadTagException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.StatDownloadTag updateImpl(
		com.idetronic.subur.model.StatDownloadTag statDownloadTag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download tag with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadTagException} if it could not be found.
	*
	* @param id the primary key of the stat download tag
	* @return the stat download tag
	* @throws com.idetronic.subur.NoSuchStatDownloadTagException if a stat download tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadTag findByPrimaryKey(long id)
		throws com.idetronic.subur.NoSuchStatDownloadTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat download tag
	* @return the stat download tag, or <code>null</code> if a stat download tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadTag fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the stat download tags.
	*
	* @return the stat download tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadTag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat download tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download tags
	* @param end the upper bound of the range of stat download tags (not inclusive)
	* @return the range of stat download tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadTag> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat download tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download tags
	* @param end the upper bound of the range of stat download tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat download tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadTag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat download tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat download tags.
	*
	* @return the number of stat download tags
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}