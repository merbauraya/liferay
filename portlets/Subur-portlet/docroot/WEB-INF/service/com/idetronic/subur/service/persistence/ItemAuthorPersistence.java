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

import com.idetronic.subur.model.ItemAuthor;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemAuthorPersistenceImpl
 * @see ItemAuthorUtil
 * @generated
 */
public interface ItemAuthorPersistence extends BasePersistence<ItemAuthor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemAuthorUtil} to access the item author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the item authors where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findByitemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item authors where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item authors
	* @param end the upper bound of the range of item authors (not inclusive)
	* @return the range of matching item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findByitemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item authors where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item authors
	* @param end the upper bound of the range of item authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findByitemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item author in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item author
	* @throws com.idetronic.subur.NoSuchItemAuthorException if a matching item author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor findByitemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item author in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item author, or <code>null</code> if a matching item author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor fetchByitemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item author in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item author
	* @throws com.idetronic.subur.NoSuchItemAuthorException if a matching item author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor findByitemId_Last(long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item author in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item author, or <code>null</code> if a matching item author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor fetchByitemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item authors before and after the current item author in the ordered set where itemId = &#63;.
	*
	* @param itemAuthorPK the primary key of the current item author
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item author
	* @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor[] findByitemId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK,
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item authors where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByitemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item authors where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching item authors
	* @throws SystemException if a system exception occurred
	*/
	public int countByitemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item authors where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the matching item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findByauthorId(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item authors where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of item authors
	* @param end the upper bound of the range of item authors (not inclusive)
	* @return the range of matching item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findByauthorId(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item authors where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of item authors
	* @param end the upper bound of the range of item authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findByauthorId(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item author in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item author
	* @throws com.idetronic.subur.NoSuchItemAuthorException if a matching item author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor findByauthorId_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item author in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item author, or <code>null</code> if a matching item author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor fetchByauthorId_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item author in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item author
	* @throws com.idetronic.subur.NoSuchItemAuthorException if a matching item author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor findByauthorId_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item author in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item author, or <code>null</code> if a matching item author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor fetchByauthorId_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item authors before and after the current item author in the ordered set where authorId = &#63;.
	*
	* @param itemAuthorPK the primary key of the current item author
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item author
	* @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor[] findByauthorId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK,
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item authors where authorId = &#63; from the database.
	*
	* @param authorId the author ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByauthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item authors where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the number of matching item authors
	* @throws SystemException if a system exception occurred
	*/
	public int countByauthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the item author in the entity cache if it is enabled.
	*
	* @param itemAuthor the item author
	*/
	public void cacheResult(com.idetronic.subur.model.ItemAuthor itemAuthor);

	/**
	* Caches the item authors in the entity cache if it is enabled.
	*
	* @param itemAuthors the item authors
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.ItemAuthor> itemAuthors);

	/**
	* Creates a new item author with the primary key. Does not add the item author to the database.
	*
	* @param itemAuthorPK the primary key for the new item author
	* @return the new item author
	*/
	public com.idetronic.subur.model.ItemAuthor create(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK);

	/**
	* Removes the item author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemAuthorPK the primary key of the item author
	* @return the item author that was removed
	* @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor remove(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK)
		throws com.idetronic.subur.NoSuchItemAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.ItemAuthor updateImpl(
		com.idetronic.subur.model.ItemAuthor itemAuthor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item author with the primary key or throws a {@link com.idetronic.subur.NoSuchItemAuthorException} if it could not be found.
	*
	* @param itemAuthorPK the primary key of the item author
	* @return the item author
	* @throws com.idetronic.subur.NoSuchItemAuthorException if a item author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor findByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK)
		throws com.idetronic.subur.NoSuchItemAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemAuthorPK the primary key of the item author
	* @return the item author, or <code>null</code> if a item author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ItemAuthor fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item authors.
	*
	* @return the item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item authors
	* @param end the upper bound of the range of item authors (not inclusive)
	* @return the range of item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item authors
	* @param end the upper bound of the range of item authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ItemAuthor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item authors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item authors.
	*
	* @return the number of item authors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}