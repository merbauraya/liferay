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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the Staff local service. This utility wraps {@link com.idetronic.service.impl.StaffLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see StaffLocalService
 * @see com.idetronic.service.base.StaffLocalServiceBaseImpl
 * @see com.idetronic.service.impl.StaffLocalServiceImpl
 * @generated
 */
public class StaffLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.service.impl.StaffLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the Staff to the database. Also notifies the appropriate model listeners.
	*
	* @param staff the Staff
	* @return the Staff that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff addStaff(
		com.idetronic.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStaff(staff);
	}

	/**
	* Creates a new Staff with the primary key. Does not add the Staff to the database.
	*
	* @param bp_no_kp the primary key for the new Staff
	* @return the new Staff
	*/
	public static com.idetronic.model.Staff createStaff(
		java.lang.String bp_no_kp) {
		return getService().createStaff(bp_no_kp);
	}

	/**
	* Deletes the Staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff that was removed
	* @throws PortalException if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff deleteStaff(
		java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStaff(bp_no_kp);
	}

	/**
	* Deletes the Staff from the database. Also notifies the appropriate model listeners.
	*
	* @param staff the Staff
	* @return the Staff that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff deleteStaff(
		com.idetronic.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStaff(staff);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.idetronic.model.Staff fetchStaff(
		java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStaff(bp_no_kp);
	}

	/**
	* Returns the Staff with the primary key.
	*
	* @param bp_no_kp the primary key of the Staff
	* @return the Staff
	* @throws PortalException if a Staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff getStaff(java.lang.String bp_no_kp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaff(bp_no_kp);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.idetronic.model.Staff> getStaffs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaffs(start, end);
	}

	/**
	* Returns the number of Staffs.
	*
	* @return the number of Staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int getStaffsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaffsCount();
	}

	/**
	* Updates the Staff in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param staff the Staff
	* @return the Staff that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff updateStaff(
		com.idetronic.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStaff(staff);
	}

	/**
	* Updates the Staff in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param staff the Staff
	* @param merge whether to merge the Staff with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Staff that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.model.Staff updateStaff(
		com.idetronic.model.Staff staff, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStaff(staff, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<java.lang.Object> getDepartment() {
		return getService().getDepartment();
	}

	public static void clearService() {
		_service = null;
	}

	public static StaffLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StaffLocalService.class.getName());

			if (invokableLocalService instanceof StaffLocalService) {
				_service = (StaffLocalService)invokableLocalService;
			}
			else {
				_service = new StaffLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StaffLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(StaffLocalService service) {
	}

	private static StaffLocalService _service;
}