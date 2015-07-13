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
 * This class is a wrapper for {@link StatDownloadPeriod}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadPeriod
 * @generated
 */
public class StatDownloadPeriodWrapper implements StatDownloadPeriod,
	ModelWrapper<StatDownloadPeriod> {
	public StatDownloadPeriodWrapper(StatDownloadPeriod statDownloadPeriod) {
		_statDownloadPeriod = statDownloadPeriod;
	}

	@Override
	public Class<?> getModelClass() {
		return StatDownloadPeriod.class;
	}

	@Override
	public String getModelClassName() {
		return StatDownloadPeriod.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("itemId", getItemId());
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());

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
	}

	/**
	* Returns the primary key of this stat download period.
	*
	* @return the primary key of this stat download period
	*/
	@Override
	public long getPrimaryKey() {
		return _statDownloadPeriod.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat download period.
	*
	* @param primaryKey the primary key of this stat download period
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statDownloadPeriod.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat download period.
	*
	* @return the ID of this stat download period
	*/
	@Override
	public long getId() {
		return _statDownloadPeriod.getId();
	}

	/**
	* Sets the ID of this stat download period.
	*
	* @param id the ID of this stat download period
	*/
	@Override
	public void setId(long id) {
		_statDownloadPeriod.setId(id);
	}

	/**
	* Returns the item ID of this stat download period.
	*
	* @return the item ID of this stat download period
	*/
	@Override
	public long getItemId() {
		return _statDownloadPeriod.getItemId();
	}

	/**
	* Sets the item ID of this stat download period.
	*
	* @param itemId the item ID of this stat download period
	*/
	@Override
	public void setItemId(long itemId) {
		_statDownloadPeriod.setItemId(itemId);
	}

	/**
	* Returns the per month of this stat download period.
	*
	* @return the per month of this stat download period
	*/
	@Override
	public int getPerMonth() {
		return _statDownloadPeriod.getPerMonth();
	}

	/**
	* Sets the per month of this stat download period.
	*
	* @param perMonth the per month of this stat download period
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statDownloadPeriod.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this stat download period.
	*
	* @return the per year of this stat download period
	*/
	@Override
	public int getPerYear() {
		return _statDownloadPeriod.getPerYear();
	}

	/**
	* Sets the per year of this stat download period.
	*
	* @param perYear the per year of this stat download period
	*/
	@Override
	public void setPerYear(int perYear) {
		_statDownloadPeriod.setPerYear(perYear);
	}

	@Override
	public boolean isNew() {
		return _statDownloadPeriod.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statDownloadPeriod.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statDownloadPeriod.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statDownloadPeriod.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statDownloadPeriod.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statDownloadPeriod.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statDownloadPeriod.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statDownloadPeriod.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statDownloadPeriod.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statDownloadPeriod.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statDownloadPeriod.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatDownloadPeriodWrapper((StatDownloadPeriod)_statDownloadPeriod.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.StatDownloadPeriod statDownloadPeriod) {
		return _statDownloadPeriod.compareTo(statDownloadPeriod);
	}

	@Override
	public int hashCode() {
		return _statDownloadPeriod.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatDownloadPeriod> toCacheModel() {
		return _statDownloadPeriod.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatDownloadPeriod toEscapedModel() {
		return new StatDownloadPeriodWrapper(_statDownloadPeriod.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatDownloadPeriod toUnescapedModel() {
		return new StatDownloadPeriodWrapper(_statDownloadPeriod.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statDownloadPeriod.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statDownloadPeriod.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statDownloadPeriod.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatDownloadPeriodWrapper)) {
			return false;
		}

		StatDownloadPeriodWrapper statDownloadPeriodWrapper = (StatDownloadPeriodWrapper)obj;

		if (Validator.equals(_statDownloadPeriod,
					statDownloadPeriodWrapper._statDownloadPeriod)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatDownloadPeriod getWrappedStatDownloadPeriod() {
		return _statDownloadPeriod;
	}

	@Override
	public StatDownloadPeriod getWrappedModel() {
		return _statDownloadPeriod;
	}

	@Override
	public void resetOriginalValues() {
		_statDownloadPeriod.resetOriginalValues();
	}

	private StatDownloadPeriod _statDownloadPeriod;
}