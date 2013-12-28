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

package com.idetronic.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link StaffLocalService}.
 * </p>
 *
 * @author    Mazlan Mat
 * @see       StaffLocalService
 * @generated
 */
public class StaffLocalServiceWrapper implements StaffLocalService,
	ServiceWrapper<StaffLocalService> {
	public StaffLocalServiceWrapper(StaffLocalService staffLocalService) {
		_staffLocalService = staffLocalService;
	}

	/**
	* Adds the Staff to the database. Also notifies the appropriate model listeners.
	*
	* @param staff the Staff
	* @return the Staff that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff addStaff(com.idetronic.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.addStaff(staff);
	}

	/**
	* Creates a new Staff with the primary key. Does not add the Staff to the database.
	*
	* @param bp_no_kp the primary key for the new Staff
	* @return the new Staff
	*/
	public com.idetronic.model.Staff createStaff(java.lang.String bp_no_kp) {
		return _staffLocalService.createStaff(bp_no_kp);
	}

	/**
	* Deletes the Staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff that was removed
	* @throws PortalException if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff deleteStaff(java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.deleteStaff(bp_no_kp);
	}

	/**
	* Deletes the Staff from the database. Also notifies the appropriate model listeners.
	*
	* @param staff the Staff
	* @return the Staff that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff deleteStaff(
		com.idetronic.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.deleteStaff(staff);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _staffLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.idetronic.model.Staff fetchStaff(java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.fetchStaff(bp_no_kp);
	}

	/**
	* Returns the Staff with the primary key.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff
	* @throws PortalException if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff getStaff(java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.getStaff(bp_no_kp);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Staffs
	* @param end the upper bound of the range of Staffs (not inclusive)
	* @return the range of Staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.model.Staff> getStaffs(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.getStaffs(start, end);
	}

	/**
	* Returns the number of Staffs.
	*
	* @return the number of Staffs
	* @throws SystemException if a system exception occurred
	*/
	public int getStaffsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.getStaffsCount();
	}

	/**
	* Updates the Staff in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param staff the Staff
	* @return the Staff that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff updateStaff(
		com.idetronic.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.updateStaff(staff);
	}

	/**
	* Updates the Staff in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param staff the Staff
	* @param merge whether to merge the Staff with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Staff that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.model.Staff updateStaff(
		com.idetronic.model.Staff staff, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.updateStaff(staff, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _staffLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_staffLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _staffLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<java.lang.Object> getDepartment() {
		return _staffLocalService.getDepartment();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public StaffLocalService getWrappedStaffLocalService() {
		return _staffLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedStaffLocalService(StaffLocalService staffLocalService) {
		_staffLocalService = staffLocalService;
	}

	public StaffLocalService getWrappedService() {
		return _staffLocalService;
	}

	public void setWrappedService(StaffLocalService staffLocalService) {
		_staffLocalService = staffLocalService;
	}

	private StaffLocalService _staffLocalService;
}