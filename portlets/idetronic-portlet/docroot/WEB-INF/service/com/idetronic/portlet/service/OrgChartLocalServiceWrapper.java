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

package com.idetronic.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrgChartLocalService}.
 *
 * @author Mazlan Mat
 * @see OrgChartLocalService
 * @generated
 */
public class OrgChartLocalServiceWrapper implements OrgChartLocalService,
	ServiceWrapper<OrgChartLocalService> {
	public OrgChartLocalServiceWrapper(
		OrgChartLocalService orgChartLocalService) {
		_orgChartLocalService = orgChartLocalService;
	}

	/**
	* Adds the org chart to the database. Also notifies the appropriate model listeners.
	*
	* @param orgChart the org chart
	* @return the org chart that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.OrgChart addOrgChart(
		com.idetronic.portlet.model.OrgChart orgChart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.addOrgChart(orgChart);
	}

	/**
	* Creates a new org chart with the primary key. Does not add the org chart to the database.
	*
	* @param orgChartPK the primary key for the new org chart
	* @return the new org chart
	*/
	@Override
	public com.idetronic.portlet.model.OrgChart createOrgChart(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK) {
		return _orgChartLocalService.createOrgChart(orgChartPK);
	}

	/**
	* Deletes the org chart with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgChartPK the primary key of the org chart
	* @return the org chart that was removed
	* @throws PortalException if a org chart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.OrgChart deleteOrgChart(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.deleteOrgChart(orgChartPK);
	}

	/**
	* Deletes the org chart from the database. Also notifies the appropriate model listeners.
	*
	* @param orgChart the org chart
	* @return the org chart that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.OrgChart deleteOrgChart(
		com.idetronic.portlet.model.OrgChart orgChart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.deleteOrgChart(orgChart);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orgChartLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.OrgChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.OrgChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.portlet.model.OrgChart fetchOrgChart(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.fetchOrgChart(orgChartPK);
	}

	/**
	* Returns the org chart with the primary key.
	*
	* @param orgChartPK the primary key of the org chart
	* @return the org chart
	* @throws PortalException if a org chart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.OrgChart getOrgChart(
		com.idetronic.portlet.service.persistence.OrgChartPK orgChartPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.getOrgChart(orgChartPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the org charts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.OrgChartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of org charts
	* @param end the upper bound of the range of org charts (not inclusive)
	* @return the range of org charts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.portlet.model.OrgChart> getOrgCharts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.getOrgCharts(start, end);
	}

	/**
	* Returns the number of org charts.
	*
	* @return the number of org charts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrgChartsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.getOrgChartsCount();
	}

	/**
	* Updates the org chart in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orgChart the org chart
	* @return the org chart that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.portlet.model.OrgChart updateOrgChart(
		com.idetronic.portlet.model.OrgChart orgChart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.updateOrgChart(orgChart);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _orgChartLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_orgChartLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _orgChartLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.portlet.model.OrgChart addEntry(long userId,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChartLocalService.addEntry(userId, parentId);
	}

	@Override
	public void deleteByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_orgChartLocalService.deleteByParentId(parentId);
	}

	@Override
	public java.util.List getUserTree(long userId) {
		return _orgChartLocalService.getUserTree(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrgChartLocalService getWrappedOrgChartLocalService() {
		return _orgChartLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrgChartLocalService(
		OrgChartLocalService orgChartLocalService) {
		_orgChartLocalService = orgChartLocalService;
	}

	@Override
	public OrgChartLocalService getWrappedService() {
		return _orgChartLocalService;
	}

	@Override
	public void setWrappedService(OrgChartLocalService orgChartLocalService) {
		_orgChartLocalService = orgChartLocalService;
	}

	private OrgChartLocalService _orgChartLocalService;
}