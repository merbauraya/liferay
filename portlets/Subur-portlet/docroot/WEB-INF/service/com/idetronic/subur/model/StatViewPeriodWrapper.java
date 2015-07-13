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
 * This class is a wrapper for {@link StatViewPeriod}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewPeriod
 * @generated
 */
public class StatViewPeriodWrapper implements StatViewPeriod,
	ModelWrapper<StatViewPeriod> {
	public StatViewPeriodWrapper(StatViewPeriod statViewPeriod) {
		_statViewPeriod = statViewPeriod;
	}

	@Override
	public Class<?> getModelClass() {
		return StatViewPeriod.class;
	}

	@Override
	public String getModelClassName() {
		return StatViewPeriod.class.getName();
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
	* Returns the primary key of this stat view period.
	*
	* @return the primary key of this stat view period
	*/
	@Override
	public long getPrimaryKey() {
		return _statViewPeriod.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat view period.
	*
	* @param primaryKey the primary key of this stat view period
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statViewPeriod.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat view period.
	*
	* @return the ID of this stat view period
	*/
	@Override
	public long getId() {
		return _statViewPeriod.getId();
	}

	/**
	* Sets the ID of this stat view period.
	*
	* @param id the ID of this stat view period
	*/
	@Override
	public void setId(long id) {
		_statViewPeriod.setId(id);
	}

	/**
	* Returns the item ID of this stat view period.
	*
	* @return the item ID of this stat view period
	*/
	@Override
	public long getItemId() {
		return _statViewPeriod.getItemId();
	}

	/**
	* Sets the item ID of this stat view period.
	*
	* @param itemId the item ID of this stat view period
	*/
	@Override
	public void setItemId(long itemId) {
		_statViewPeriod.setItemId(itemId);
	}

	/**
	* Returns the per month of this stat view period.
	*
	* @return the per month of this stat view period
	*/
	@Override
	public int getPerMonth() {
		return _statViewPeriod.getPerMonth();
	}

	/**
	* Sets the per month of this stat view period.
	*
	* @param perMonth the per month of this stat view period
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statViewPeriod.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this stat view period.
	*
	* @return the per year of this stat view period
	*/
	@Override
	public int getPerYear() {
		return _statViewPeriod.getPerYear();
	}

	/**
	* Sets the per year of this stat view period.
	*
	* @param perYear the per year of this stat view period
	*/
	@Override
	public void setPerYear(int perYear) {
		_statViewPeriod.setPerYear(perYear);
	}

	@Override
	public boolean isNew() {
		return _statViewPeriod.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statViewPeriod.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statViewPeriod.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statViewPeriod.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statViewPeriod.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statViewPeriod.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statViewPeriod.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statViewPeriod.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statViewPeriod.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statViewPeriod.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statViewPeriod.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatViewPeriodWrapper((StatViewPeriod)_statViewPeriod.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.StatViewPeriod statViewPeriod) {
		return _statViewPeriod.compareTo(statViewPeriod);
	}

	@Override
	public int hashCode() {
		return _statViewPeriod.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatViewPeriod> toCacheModel() {
		return _statViewPeriod.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatViewPeriod toEscapedModel() {
		return new StatViewPeriodWrapper(_statViewPeriod.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatViewPeriod toUnescapedModel() {
		return new StatViewPeriodWrapper(_statViewPeriod.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statViewPeriod.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statViewPeriod.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statViewPeriod.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatViewPeriodWrapper)) {
			return false;
		}

		StatViewPeriodWrapper statViewPeriodWrapper = (StatViewPeriodWrapper)obj;

		if (Validator.equals(_statViewPeriod,
					statViewPeriodWrapper._statViewPeriod)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatViewPeriod getWrappedStatViewPeriod() {
		return _statViewPeriod;
	}

	@Override
	public StatViewPeriod getWrappedModel() {
		return _statViewPeriod;
	}

	@Override
	public void resetOriginalValues() {
		_statViewPeriod.resetOriginalValues();
	}

	private StatViewPeriod _statViewPeriod;
}