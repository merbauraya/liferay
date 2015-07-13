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

import com.idetronic.subur.model.StatDownloadCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the stat download category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadCategoryPersistenceImpl
 * @see StatDownloadCategoryUtil
 * @generated
 */
public interface StatDownloadCategoryPersistence extends BasePersistence<StatDownloadCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatDownloadCategoryUtil} to access the stat download category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the stat download categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadCategory> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat download categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of stat download categories
	* @param end the upper bound of the range of stat download categories (not inclusive)
	* @return the range of matching stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadCategory> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat download categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of stat download categories
	* @param end the upper bound of the range of stat download categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadCategory> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat download category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download category
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a matching stat download category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadCategory findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat download category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download category, or <code>null</code> if a matching stat download category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadCategory fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat download category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download category
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a matching stat download category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadCategory findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat download category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download category, or <code>null</code> if a matching stat download category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadCategory fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download categories before and after the current stat download category in the ordered set where categoryId = &#63;.
	*
	* @param id the primary key of the current stat download category
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat download category
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadCategory[] findByCategory_PrevAndNext(
		long id, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat download categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat download categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the stat download category in the entity cache if it is enabled.
	*
	* @param statDownloadCategory the stat download category
	*/
	public void cacheResult(
		com.idetronic.subur.model.StatDownloadCategory statDownloadCategory);

	/**
	* Caches the stat download categories in the entity cache if it is enabled.
	*
	* @param statDownloadCategories the stat download categories
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.StatDownloadCategory> statDownloadCategories);

	/**
	* Creates a new stat download category with the primary key. Does not add the stat download category to the database.
	*
	* @param id the primary key for the new stat download category
	* @return the new stat download category
	*/
	public com.idetronic.subur.model.StatDownloadCategory create(long id);

	/**
	* Removes the stat download category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat download category
	* @return the stat download category that was removed
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadCategory remove(long id)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.StatDownloadCategory updateImpl(
		com.idetronic.subur.model.StatDownloadCategory statDownloadCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download category with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadCategoryException} if it could not be found.
	*
	* @param id the primary key of the stat download category
	* @return the stat download category
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadCategory findByPrimaryKey(
		long id)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat download category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat download category
	* @return the stat download category, or <code>null</code> if a stat download category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatDownloadCategory fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the stat download categories.
	*
	* @return the stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat download categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download categories
	* @param end the upper bound of the range of stat download categories (not inclusive)
	* @return the range of stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat download categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download categories
	* @param end the upper bound of the range of stat download categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatDownloadCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat download categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat download categories.
	*
	* @return the number of stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}