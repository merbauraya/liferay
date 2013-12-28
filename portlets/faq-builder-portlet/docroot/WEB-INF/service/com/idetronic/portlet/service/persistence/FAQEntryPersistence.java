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

import com.idetronic.portlet.model.FAQEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the f a q entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FAQEntryPersistenceImpl
 * @see FAQEntryUtil
 * @generated
 */
public interface FAQEntryPersistence extends BasePersistence<FAQEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FAQEntryUtil} to access the f a q entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the f a q entry in the entity cache if it is enabled.
	*
	* @param faqEntry the f a q entry
	*/
	public void cacheResult(com.idetronic.portlet.model.FAQEntry faqEntry);

	/**
	* Caches the f a q entries in the entity cache if it is enabled.
	*
	* @param faqEntries the f a q entries
	*/
	public void cacheResult(
		java.util.List<com.idetronic.portlet.model.FAQEntry> faqEntries);

	/**
	* Creates a new f a q entry with the primary key. Does not add the f a q entry to the database.
	*
	* @param entryId the primary key for the new f a q entry
	* @return the new f a q entry
	*/
	public com.idetronic.portlet.model.FAQEntry create(long entryId);

	/**
	* Removes the f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the f a q entry
	* @return the f a q entry that was removed
	* @throws com.idetronic.portlet.NoSuchEntryException if a f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry remove(long entryId)
		throws com.idetronic.portlet.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.portlet.model.FAQEntry updateImpl(
		com.idetronic.portlet.model.FAQEntry faqEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the f a q entry with the primary key or throws a {@link com.idetronic.portlet.NoSuchEntryException} if it could not be found.
	*
	* @param entryId the primary key of the f a q entry
	* @return the f a q entry
	* @throws com.idetronic.portlet.NoSuchEntryException if a f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry findByPrimaryKey(long entryId)
		throws com.idetronic.portlet.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the f a q entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the f a q entry
	* @return the f a q entry, or <code>null</code> if a f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.FAQEntry fetchByPrimaryKey(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the f a q entries.
	*
	* @return the f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.FAQEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the f a q entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q entries
	* @param end the upper bound of the range of f a q entries (not inclusive)
	* @return the range of f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.FAQEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the f a q entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q entries
	* @param end the upper bound of the range of f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.FAQEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the f a q entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of f a q entries.
	*
	* @return the number of f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}