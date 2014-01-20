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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the eprint static content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author matle
 * @see EprintStaticContentPersistenceImpl
 * @see EprintStaticContentUtil
 * @generated
 */
public interface EprintStaticContentPersistence extends BasePersistence<EprintStaticContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EprintStaticContentUtil} to access the eprint static content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the eprint static content in the entity cache if it is enabled.
	*
	* @param eprintStaticContent the eprint static content
	*/
	public void cacheResult(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent);

	/**
	* Caches the eprint static contents in the entity cache if it is enabled.
	*
	* @param eprintStaticContents the eprint static contents
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eprint.model.EprintStaticContent> eprintStaticContents);

	/**
	* Creates a new eprint static content with the primary key. Does not add the eprint static content to the database.
	*
	* @param contentId the primary key for the new eprint static content
	* @return the new eprint static content
	*/
	public com.idetronic.eprint.model.EprintStaticContent create(long contentId);

	/**
	* Removes the eprint static content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the eprint static content
	* @return the eprint static content that was removed
	* @throws com.idetronic.eprint.NoSuchEprintStaticContentException if a eprint static content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintStaticContent remove(long contentId)
		throws com.idetronic.eprint.NoSuchEprintStaticContentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eprint.model.EprintStaticContent updateImpl(
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprint static content with the primary key or throws a {@link com.idetronic.eprint.NoSuchEprintStaticContentException} if it could not be found.
	*
	* @param contentId the primary key of the eprint static content
	* @return the eprint static content
	* @throws com.idetronic.eprint.NoSuchEprintStaticContentException if a eprint static content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintStaticContent findByPrimaryKey(
		long contentId)
		throws com.idetronic.eprint.NoSuchEprintStaticContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eprint static content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contentId the primary key of the eprint static content
	* @return the eprint static content, or <code>null</code> if a eprint static content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eprint.model.EprintStaticContent fetchByPrimaryKey(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eprint static contents.
	*
	* @return the eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintStaticContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the eprint static contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprint static contents
	* @param end the upper bound of the range of eprint static contents (not inclusive)
	* @return the range of eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintStaticContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the eprint static contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of eprint static contents
	* @param end the upper bound of the range of eprint static contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eprint.model.EprintStaticContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eprint static contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eprint static contents.
	*
	* @return the number of eprint static contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}