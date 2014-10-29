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

package com.idetronic.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OrgChart}.
 * </p>
 *
 * @author Mazlan Mat
 * @see OrgChart
 * @generated
 */
public class OrgChartWrapper implements OrgChart, ModelWrapper<OrgChart> {
	public OrgChartWrapper(OrgChart orgChart) {
		_orgChart = orgChart;
	}

	@Override
	public Class<?> getModelClass() {
		return OrgChart.class;
	}

	@Override
	public String getModelClassName() {
		return OrgChart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	/**
	* Returns the primary key of this org chart.
	*
	* @return the primary key of this org chart
	*/
	@Override
	public com.idetronic.portlet.service.persistence.OrgChartPK getPrimaryKey() {
		return _orgChart.getPrimaryKey();
	}

	/**
	* Sets the primary key of this org chart.
	*
	* @param primaryKey the primary key of this org chart
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.portlet.service.persistence.OrgChartPK primaryKey) {
		_orgChart.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this org chart.
	*
	* @return the user ID of this org chart
	*/
	@Override
	public long getUserId() {
		return _orgChart.getUserId();
	}

	/**
	* Sets the user ID of this org chart.
	*
	* @param userId the user ID of this org chart
	*/
	@Override
	public void setUserId(long userId) {
		_orgChart.setUserId(userId);
	}

	/**
	* Returns the user uuid of this org chart.
	*
	* @return the user uuid of this org chart
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgChart.getUserUuid();
	}

	/**
	* Sets the user uuid of this org chart.
	*
	* @param userUuid the user uuid of this org chart
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_orgChart.setUserUuid(userUuid);
	}

	/**
	* Returns the parent ID of this org chart.
	*
	* @return the parent ID of this org chart
	*/
	@Override
	public long getParentId() {
		return _orgChart.getParentId();
	}

	/**
	* Sets the parent ID of this org chart.
	*
	* @param parentId the parent ID of this org chart
	*/
	@Override
	public void setParentId(long parentId) {
		_orgChart.setParentId(parentId);
	}

	@Override
	public boolean isNew() {
		return _orgChart.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_orgChart.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _orgChart.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_orgChart.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _orgChart.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _orgChart.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_orgChart.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orgChart.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_orgChart.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_orgChart.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orgChart.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrgChartWrapper((OrgChart)_orgChart.clone());
	}

	@Override
	public int compareTo(com.idetronic.portlet.model.OrgChart orgChart) {
		return _orgChart.compareTo(orgChart);
	}

	@Override
	public int hashCode() {
		return _orgChart.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.portlet.model.OrgChart> toCacheModel() {
		return _orgChart.toCacheModel();
	}

	@Override
	public com.idetronic.portlet.model.OrgChart toEscapedModel() {
		return new OrgChartWrapper(_orgChart.toEscapedModel());
	}

	@Override
	public com.idetronic.portlet.model.OrgChart toUnescapedModel() {
		return new OrgChartWrapper(_orgChart.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _orgChart.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _orgChart.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_orgChart.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrgChartWrapper)) {
			return false;
		}

		OrgChartWrapper orgChartWrapper = (OrgChartWrapper)obj;

		if (Validator.equals(_orgChart, orgChartWrapper._orgChart)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrgChart getWrappedOrgChart() {
		return _orgChart;
	}

	@Override
	public OrgChart getWrappedModel() {
		return _orgChart;
	}

	@Override
	public void resetOriginalValues() {
		_orgChart.resetOriginalValues();
	}

	private OrgChart _orgChart;
}