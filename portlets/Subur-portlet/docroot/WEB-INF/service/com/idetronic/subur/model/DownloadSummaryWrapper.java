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
 * This class is a wrapper for {@link DownloadSummary}.
 * </p>
 *
 * @author Mazlan Mat
 * @see DownloadSummary
 * @generated
 */
public class DownloadSummaryWrapper implements DownloadSummary,
	ModelWrapper<DownloadSummary> {
	public DownloadSummaryWrapper(DownloadSummary downloadSummary) {
		_downloadSummary = downloadSummary;
	}

	@Override
	public Class<?> getModelClass() {
		return DownloadSummary.class;
	}

	@Override
	public String getModelClassName() {
		return DownloadSummary.class.getName();
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
	* Returns the primary key of this download summary.
	*
	* @return the primary key of this download summary
	*/
	@Override
	public long getPrimaryKey() {
		return _downloadSummary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this download summary.
	*
	* @param primaryKey the primary key of this download summary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_downloadSummary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this download summary.
	*
	* @return the ID of this download summary
	*/
	@Override
	public long getId() {
		return _downloadSummary.getId();
	}

	/**
	* Sets the ID of this download summary.
	*
	* @param id the ID of this download summary
	*/
	@Override
	public void setId(long id) {
		_downloadSummary.setId(id);
	}

	/**
	* Returns the item ID of this download summary.
	*
	* @return the item ID of this download summary
	*/
	@Override
	public long getItemId() {
		return _downloadSummary.getItemId();
	}

	/**
	* Sets the item ID of this download summary.
	*
	* @param itemId the item ID of this download summary
	*/
	@Override
	public void setItemId(long itemId) {
		_downloadSummary.setItemId(itemId);
	}

	/**
	* Returns the per month of this download summary.
	*
	* @return the per month of this download summary
	*/
	@Override
	public int getPerMonth() {
		return _downloadSummary.getPerMonth();
	}

	/**
	* Sets the per month of this download summary.
	*
	* @param perMonth the per month of this download summary
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_downloadSummary.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this download summary.
	*
	* @return the per year of this download summary
	*/
	@Override
	public int getPerYear() {
		return _downloadSummary.getPerYear();
	}

	/**
	* Sets the per year of this download summary.
	*
	* @param perYear the per year of this download summary
	*/
	@Override
	public void setPerYear(int perYear) {
		_downloadSummary.setPerYear(perYear);
	}

	/**
	* Returns the status of this download summary.
	*
	* @return the status of this download summary
	*/
	@Override
	public int getStatus() {
		return _downloadSummary.getStatus();
	}

	/**
	* Sets the status of this download summary.
	*
	* @param status the status of this download summary
	*/
	@Override
	public void setStatus(int status) {
		_downloadSummary.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _downloadSummary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_downloadSummary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _downloadSummary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_downloadSummary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _downloadSummary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _downloadSummary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_downloadSummary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _downloadSummary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_downloadSummary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_downloadSummary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_downloadSummary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DownloadSummaryWrapper((DownloadSummary)_downloadSummary.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.DownloadSummary downloadSummary) {
		return _downloadSummary.compareTo(downloadSummary);
	}

	@Override
	public int hashCode() {
		return _downloadSummary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.DownloadSummary> toCacheModel() {
		return _downloadSummary.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.DownloadSummary toEscapedModel() {
		return new DownloadSummaryWrapper(_downloadSummary.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.DownloadSummary toUnescapedModel() {
		return new DownloadSummaryWrapper(_downloadSummary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _downloadSummary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _downloadSummary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_downloadSummary.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DownloadSummaryWrapper)) {
			return false;
		}

		DownloadSummaryWrapper downloadSummaryWrapper = (DownloadSummaryWrapper)obj;

		if (Validator.equals(_downloadSummary,
					downloadSummaryWrapper._downloadSummary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DownloadSummary getWrappedDownloadSummary() {
		return _downloadSummary;
	}

	@Override
	public DownloadSummary getWrappedModel() {
		return _downloadSummary;
	}

	@Override
	public void resetOriginalValues() {
		_downloadSummary.resetOriginalValues();
	}

	private DownloadSummary _downloadSummary;
}