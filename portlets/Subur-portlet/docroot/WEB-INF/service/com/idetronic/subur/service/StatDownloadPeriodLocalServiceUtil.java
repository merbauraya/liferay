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

package com.idetronic.subur.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for StatDownloadPeriod. This utility wraps
 * {@link com.idetronic.subur.service.impl.StatDownloadPeriodLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see StatDownloadPeriodLocalService
 * @see com.idetronic.subur.service.base.StatDownloadPeriodLocalServiceBaseImpl
 * @see com.idetronic.subur.service.impl.StatDownloadPeriodLocalServiceImpl
 * @generated
 */
public class StatDownloadPeriodLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.subur.service.impl.StatDownloadPeriodLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the stat download period to the database. Also notifies the appropriate model listeners.
	*
	* @param statDownloadPeriod the stat download period
	* @return the stat download period that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod addStatDownloadPeriod(
		com.idetronic.subur.model.StatDownloadPeriod statDownloadPeriod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStatDownloadPeriod(statDownloadPeriod);
	}

	/**
	* Creates a new stat download period with the primary key. Does not add the stat download period to the database.
	*
	* @param id the primary key for the new stat download period
	* @return the new stat download period
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod createStatDownloadPeriod(
		long id) {
		return getService().createStatDownloadPeriod(id);
	}

	/**
	* Deletes the stat download period with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat download period
	* @return the stat download period that was removed
	* @throws PortalException if a stat download period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod deleteStatDownloadPeriod(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStatDownloadPeriod(id);
	}

	/**
	* Deletes the stat download period from the database. Also notifies the appropriate model listeners.
	*
	* @param statDownloadPeriod the stat download period
	* @return the stat download period that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod deleteStatDownloadPeriod(
		com.idetronic.subur.model.StatDownloadPeriod statDownloadPeriod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStatDownloadPeriod(statDownloadPeriod);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.idetronic.subur.model.StatDownloadPeriod fetchStatDownloadPeriod(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStatDownloadPeriod(id);
	}

	/**
	* Returns the stat download period with the primary key.
	*
	* @param id the primary key of the stat download period
	* @return the stat download period
	* @throws PortalException if a stat download period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod getStatDownloadPeriod(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatDownloadPeriod(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the stat download periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download periods
	* @param end the upper bound of the range of stat download periods (not inclusive)
	* @return the range of stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadPeriod> getStatDownloadPeriods(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatDownloadPeriods(start, end);
	}

	/**
	* Returns the number of stat download periods.
	*
	* @return the number of stat download periods
	* @throws SystemException if a system exception occurred
	*/
	public static int getStatDownloadPeriodsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatDownloadPeriodsCount();
	}

	/**
	* Updates the stat download period in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statDownloadPeriod the stat download period
	* @return the stat download period that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadPeriod updateStatDownloadPeriod(
		com.idetronic.subur.model.StatDownloadPeriod statDownloadPeriod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStatDownloadPeriod(statDownloadPeriod);
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

	public static void clearService() {
		_service = null;
	}

	public static StatDownloadPeriodLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StatDownloadPeriodLocalService.class.getName());

			if (invokableLocalService instanceof StatDownloadPeriodLocalService) {
				_service = (StatDownloadPeriodLocalService)invokableLocalService;
			}
			else {
				_service = new StatDownloadPeriodLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StatDownloadPeriodLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StatDownloadPeriodLocalService service) {
	}

	private static StatDownloadPeriodLocalService _service;
}