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

package com.idetronic.subur.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ViewSummary}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ViewSummary
 * @generated
 */
public class ViewSummaryWrapper implements ViewSummary,
	ModelWrapper<ViewSummary> {
	public ViewSummaryWrapper(ViewSummary viewSummary) {
		_viewSummary = viewSummary;
	}

	@Override
	public Class<?> getModelClass() {
		return ViewSummary.class;
	}

	@Override
	public String getModelClassName() {
		return ViewSummary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("itemId", getItemId());
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this view summary.
	*
	* @return the primary key of this view summary
	*/
	@Override
	public long getPrimaryKey() {
		return _viewSummary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this view summary.
	*
	* @param primaryKey the primary key of this view summary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_viewSummary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this view summary.
	*
	* @return the ID of this view summary
	*/
	@Override
	public long getId() {
		return _viewSummary.getId();
	}

	/**
	* Sets the ID of this view summary.
	*
	* @param id the ID of this view summary
	*/
	@Override
	public void setId(long id) {
		_viewSummary.setId(id);
	}

	/**
	* Returns the item ID of this view summary.
	*
	* @return the item ID of this view summary
	*/
	@Override
	public long getItemId() {
		return _viewSummary.getItemId();
	}

	/**
	* Sets the item ID of this view summary.
	*
	* @param itemId the item ID of this view summary
	*/
	@Override
	public void setItemId(long itemId) {
		_viewSummary.setItemId(itemId);
	}

	/**
	* Returns the per month of this view summary.
	*
	* @return the per month of this view summary
	*/
	@Override
	public int getPerMonth() {
		return _viewSummary.getPerMonth();
	}

	/**
	* Sets the per month of this view summary.
	*
	* @param perMonth the per month of this view summary
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_viewSummary.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this view summary.
	*
	* @return the per year of this view summary
	*/
	@Override
	public int getPerYear() {
		return _viewSummary.getPerYear();
	}

	/**
	* Sets the per year of this view summary.
	*
	* @param perYear the per year of this view summary
	*/
	@Override
	public void setPerYear(int perYear) {
		_viewSummary.setPerYear(perYear);
	}

	/**
	* Returns the status of this view summary.
	*
	* @return the status of this view summary
	*/
	@Override
	public int getStatus() {
		return _viewSummary.getStatus();
	}

	/**
	* Sets the status of this view summary.
	*
	* @param status the status of this view summary
	*/
	@Override
	public void setStatus(int status) {
		_viewSummary.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _viewSummary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_viewSummary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _viewSummary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_viewSummary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _viewSummary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _viewSummary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_viewSummary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _viewSummary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_viewSummary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_viewSummary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_viewSummary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ViewSummaryWrapper((ViewSummary)_viewSummary.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.ViewSummary viewSummary) {
		return _viewSummary.compareTo(viewSummary);
	}

	@Override
	public int hashCode() {
		return _viewSummary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ViewSummary> toCacheModel() {
		return _viewSummary.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ViewSummary toEscapedModel() {
		return new ViewSummaryWrapper(_viewSummary.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ViewSummary toUnescapedModel() {
		return new ViewSummaryWrapper(_viewSummary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _viewSummary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _viewSummary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_viewSummary.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ViewSummaryWrapper)) {
			return false;
		}

		ViewSummaryWrapper viewSummaryWrapper = (ViewSummaryWrapper)obj;

		if (Validator.equals(_viewSummary, viewSummaryWrapper._viewSummary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ViewSummary getWrappedViewSummary() {
		return _viewSummary;
	}

	@Override
	public ViewSummary getWrappedModel() {
		return _viewSummary;
	}

	@Override
	public void resetOriginalValues() {
		_viewSummary.resetOriginalValues();
	}

	private ViewSummary _viewSummary;
}