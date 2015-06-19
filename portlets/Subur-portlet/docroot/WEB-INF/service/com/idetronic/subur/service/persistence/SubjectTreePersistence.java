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

import com.idetronic.subur.model.SubjectTree;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the subject tree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SubjectTreePersistenceImpl
 * @see SubjectTreeUtil
 * @generated
 */
public interface SubjectTreePersistence extends BasePersistence<SubjectTree> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectTreeUtil} to access the subject tree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the subject trees where depositable = &#63;.
	*
	* @param depositable the depositable
	* @return the matching subject trees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SubjectTree> findBydepositable(
		boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the subject trees where depositable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param depositable the depositable
	* @param start the lower bound of the range of subject trees
	* @param end the upper bound of the range of subject trees (not inclusive)
	* @return the range of matching subject trees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SubjectTree> findBydepositable(
		boolean depositable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the subject trees where depositable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param depositable the depositable
	* @param start the lower bound of the range of subject trees
	* @param end the upper bound of the range of subject trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subject trees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SubjectTree> findBydepositable(
		boolean depositable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subject tree in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject tree
	* @throws com.idetronic.subur.NoSuchSubjectTreeException if a matching subject tree could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SubjectTree findBydepositable_First(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchSubjectTreeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subject tree in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject tree, or <code>null</code> if a matching subject tree could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SubjectTree fetchBydepositable_First(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subject tree in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject tree
	* @throws com.idetronic.subur.NoSuchSubjectTreeException if a matching subject tree could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SubjectTree findBydepositable_Last(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchSubjectTreeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subject tree in the ordered set where depositable = &#63;.
	*
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject tree, or <code>null</code> if a matching subject tree could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SubjectTree fetchBydepositable_Last(
		boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subject trees before and after the current subject tree in the ordered set where depositable = &#63;.
	*
	* @param subjectId the primary key of the current subject tree
	* @param depositable the depositable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subject tree
	* @throws com.idetronic.subur.NoSuchSubjectTreeException if a subject tree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SubjectTree[] findBydepositable_PrevAndNext(
		long subjectId, boolean depositable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchSubjectTreeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subject trees where depositable = &#63; from the database.
	*
	* @param depositable the depositable
	* @throws SystemException if a system exception occurred
	*/
	public void removeBydepositable(boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subject trees where depositable = &#63;.
	*
	* @param depositable the depositable
	* @return the number of matching subject trees
	* @throws SystemException if a system exception occurred
	*/
	public int countBydepositable(boolean depositable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the subject tree in the entity cache if it is enabled.
	*
	* @param subjectTree the subject tree
	*/
	public void cacheResult(com.idetronic.subur.model.SubjectTree subjectTree);

	/**
	* Caches the subject trees in the entity cache if it is enabled.
	*
	* @param subjectTrees the subject trees
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.SubjectTree> subjectTrees);

	/**
	* Creates a new subject tree with the primary key. Does not add the subject tree to the database.
	*
	* @param subjectId the primary key for the new subject tree
	* @return the new subject tree
	*/
	public com.idetronic.subur.model.SubjectTree create(long subjectId);

	/**
	* Removes the subject tree with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectId the primary key of the subject tree
	* @return the subject tree that was removed
	* @throws com.idetronic.subur.NoSuchSubjectTreeException if a subject tree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SubjectTree remove(long subjectId)
		throws com.idetronic.subur.NoSuchSubjectTreeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.SubjectTree updateImpl(
		com.idetronic.subur.model.SubjectTree subjectTree)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subject tree with the primary key or throws a {@link com.idetronic.subur.NoSuchSubjectTreeException} if it could not be found.
	*
	* @param subjectId the primary key of the subject tree
	* @return the subject tree
	* @throws com.idetronic.subur.NoSuchSubjectTreeException if a subject tree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SubjectTree findByPrimaryKey(
		long subjectId)
		throws com.idetronic.subur.NoSuchSubjectTreeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subject tree with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subjectId the primary key of the subject tree
	* @return the subject tree, or <code>null</code> if a subject tree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SubjectTree fetchByPrimaryKey(
		long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subject trees.
	*
	* @return the subject trees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SubjectTree> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the subject trees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subject trees
	* @param end the upper bound of the range of subject trees (not inclusive)
	* @return the range of subject trees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SubjectTree> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the subject trees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SubjectTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subject trees
	* @param end the upper bound of the range of subject trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subject trees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SubjectTree> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subject trees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subject trees.
	*
	* @return the number of subject trees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}