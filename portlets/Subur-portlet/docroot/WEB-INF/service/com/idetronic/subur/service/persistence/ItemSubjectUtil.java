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

import com.idetronic.subur.model.ItemSubject;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the item subject service. This utility wraps {@link ItemSubjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemSubjectPersistence
 * @see ItemSubjectPersistenceImpl
 * @generated
 */
public class ItemSubjectUtil {
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
	public static void clearCache(ItemSubject itemSubject) {
		getPersistence().clearCache(itemSubject);
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
	public static List<ItemSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ItemSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ItemSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ItemSubject update(ItemSubject itemSubject)
		throws SystemException {
		return getPersistence().update(itemSubject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ItemSubject update(ItemSubject itemSubject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(itemSubject, serviceContext);
	}

	/**
	* Returns all the item subjects where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findByitemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByitemId(itemId);
	}

	/**
	* Returns a range of all the item subjects where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item subjects
	* @param end the upper bound of the range of item subjects (not inclusive)
	* @return the range of matching item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findByitemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByitemId(itemId, start, end);
	}

	/**
	* Returns an ordered range of all the item subjects where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of item subjects
	* @param end the upper bound of the range of item subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findByitemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByitemId(itemId, start, end, orderByComparator);
	}

	/**
	* Returns the first item subject in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item subject
	* @throws com.idetronic.subur.NoSuchItemSubjectException if a matching item subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject findByitemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByitemId_First(itemId, orderByComparator);
	}

	/**
	* Returns the first item subject in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item subject, or <code>null</code> if a matching item subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject fetchByitemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByitemId_First(itemId, orderByComparator);
	}

	/**
	* Returns the last item subject in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item subject
	* @throws com.idetronic.subur.NoSuchItemSubjectException if a matching item subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject findByitemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByitemId_Last(itemId, orderByComparator);
	}

	/**
	* Returns the last item subject in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item subject, or <code>null</code> if a matching item subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject fetchByitemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByitemId_Last(itemId, orderByComparator);
	}

	/**
	* Returns the item subjects before and after the current item subject in the ordered set where itemId = &#63;.
	*
	* @param itemSubjectPK the primary key of the current item subject
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item subject
	* @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject[] findByitemId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK,
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByitemId_PrevAndNext(itemSubjectPK, itemId,
			orderByComparator);
	}

	/**
	* Removes all the item subjects where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByitemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByitemId(itemId);
	}

	/**
	* Returns the number of item subjects where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByitemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByitemId(itemId);
	}

	/**
	* Returns all the item subjects where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @return the matching item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findBysubjectId(
		long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysubjectId(subjectId);
	}

	/**
	* Returns a range of all the item subjects where subjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subjectId the subject ID
	* @param start the lower bound of the range of item subjects
	* @param end the upper bound of the range of item subjects (not inclusive)
	* @return the range of matching item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findBysubjectId(
		long subjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysubjectId(subjectId, start, end);
	}

	/**
	* Returns an ordered range of all the item subjects where subjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subjectId the subject ID
	* @param start the lower bound of the range of item subjects
	* @param end the upper bound of the range of item subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findBysubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysubjectId(subjectId, start, end, orderByComparator);
	}

	/**
	* Returns the first item subject in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item subject
	* @throws com.idetronic.subur.NoSuchItemSubjectException if a matching item subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject findBysubjectId_First(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysubjectId_First(subjectId, orderByComparator);
	}

	/**
	* Returns the first item subject in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item subject, or <code>null</code> if a matching item subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject fetchBysubjectId_First(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysubjectId_First(subjectId, orderByComparator);
	}

	/**
	* Returns the last item subject in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item subject
	* @throws com.idetronic.subur.NoSuchItemSubjectException if a matching item subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject findBysubjectId_Last(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysubjectId_Last(subjectId, orderByComparator);
	}

	/**
	* Returns the last item subject in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item subject, or <code>null</code> if a matching item subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject fetchBysubjectId_Last(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysubjectId_Last(subjectId, orderByComparator);
	}

	/**
	* Returns the item subjects before and after the current item subject in the ordered set where subjectId = &#63;.
	*
	* @param itemSubjectPK the primary key of the current item subject
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item subject
	* @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject[] findBysubjectId_PrevAndNext(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK,
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysubjectId_PrevAndNext(itemSubjectPK, subjectId,
			orderByComparator);
	}

	/**
	* Removes all the item subjects where subjectId = &#63; from the database.
	*
	* @param subjectId the subject ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysubjectId(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBysubjectId(subjectId);
	}

	/**
	* Returns the number of item subjects where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @return the number of matching item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysubjectId(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysubjectId(subjectId);
	}

	/**
	* Caches the item subject in the entity cache if it is enabled.
	*
	* @param itemSubject the item subject
	*/
	public static void cacheResult(
		com.idetronic.subur.model.ItemSubject itemSubject) {
		getPersistence().cacheResult(itemSubject);
	}

	/**
	* Caches the item subjects in the entity cache if it is enabled.
	*
	* @param itemSubjects the item subjects
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.ItemSubject> itemSubjects) {
		getPersistence().cacheResult(itemSubjects);
	}

	/**
	* Creates a new item subject with the primary key. Does not add the item subject to the database.
	*
	* @param itemSubjectPK the primary key for the new item subject
	* @return the new item subject
	*/
	public static com.idetronic.subur.model.ItemSubject create(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK) {
		return getPersistence().create(itemSubjectPK);
	}

	/**
	* Removes the item subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemSubjectPK the primary key of the item subject
	* @return the item subject that was removed
	* @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject remove(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK)
		throws com.idetronic.subur.NoSuchItemSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemSubjectPK);
	}

	public static com.idetronic.subur.model.ItemSubject updateImpl(
		com.idetronic.subur.model.ItemSubject itemSubject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(itemSubject);
	}

	/**
	* Returns the item subject with the primary key or throws a {@link com.idetronic.subur.NoSuchItemSubjectException} if it could not be found.
	*
	* @param itemSubjectPK the primary key of the item subject
	* @return the item subject
	* @throws com.idetronic.subur.NoSuchItemSubjectException if a item subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject findByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK)
		throws com.idetronic.subur.NoSuchItemSubjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemSubjectPK);
	}

	/**
	* Returns the item subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemSubjectPK the primary key of the item subject
	* @return the item subject, or <code>null</code> if a item subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.ItemSubject fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemSubjectPK);
	}

	/**
	* Returns all the item subjects.
	*
	* @return the item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the item subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item subjects
	* @param end the upper bound of the range of item subjects (not inclusive)
	* @return the range of item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the item subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item subjects
	* @param end the upper bound of the range of item subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.ItemSubject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the item subjects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item subjects.
	*
	* @return the number of item subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ItemSubjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemSubjectPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					ItemSubjectPersistence.class.getName());

			ReferenceRegistry.registerReference(ItemSubjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ItemSubjectPersistence persistence) {
	}

	private static ItemSubjectPersistence _persistence;
}