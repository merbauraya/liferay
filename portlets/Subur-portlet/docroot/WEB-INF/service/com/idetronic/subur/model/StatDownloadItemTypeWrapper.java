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
 * This class is a wrapper for {@link StatDownloadItemType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadItemType
 * @generated
 */
public class StatDownloadItemTypeWrapper implements StatDownloadItemType,
	ModelWrapper<StatDownloadItemType> {
	public StatDownloadItemTypeWrapper(
		StatDownloadItemType statDownloadItemType) {
		_statDownloadItemType = statDownloadItemType;
	}

	@Override
	public Class<?> getModelClass() {
		return StatDownloadItemType.class;
	}

	@Override
	public String getModelClassName() {
		return StatDownloadItemType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());
		attributes.put("itemTypeId", getItemTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}
	}

	/**
	* Returns the primary key of this stat download item type.
	*
	* @return the primary key of this stat download item type
	*/
	@Override
	public long getPrimaryKey() {
		return _statDownloadItemType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat download item type.
	*
	* @param primaryKey the primary key of this stat download item type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statDownloadItemType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat download item type.
	*
	* @return the ID of this stat download item type
	*/
	@Override
	public long getId() {
		return _statDownloadItemType.getId();
	}

	/**
	* Sets the ID of this stat download item type.
	*
	* @param id the ID of this stat download item type
	*/
	@Override
	public void setId(long id) {
		_statDownloadItemType.setId(id);
	}

	/**
	* Returns the per month of this stat download item type.
	*
	* @return the per month of this stat download item type
	*/
	@Override
	public int getPerMonth() {
		return _statDownloadItemType.getPerMonth();
	}

	/**
	* Sets the per month of this stat download item type.
	*
	* @param perMonth the per month of this stat download item type
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statDownloadItemType.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this stat download item type.
	*
	* @return the per year of this stat download item type
	*/
	@Override
	public int getPerYear() {
		return _statDownloadItemType.getPerYear();
	}

	/**
	* Sets the per year of this stat download item type.
	*
	* @param perYear the per year of this stat download item type
	*/
	@Override
	public void setPerYear(int perYear) {
		_statDownloadItemType.setPerYear(perYear);
	}

	/**
	* Returns the item type ID of this stat download item type.
	*
	* @return the item type ID of this stat download item type
	*/
	@Override
	public long getItemTypeId() {
		return _statDownloadItemType.getItemTypeId();
	}

	/**
	* Sets the item type ID of this stat download item type.
	*
	* @param itemTypeId the item type ID of this stat download item type
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_statDownloadItemType.setItemTypeId(itemTypeId);
	}

	@Override
	public boolean isNew() {
		return _statDownloadItemType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statDownloadItemType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statDownloadItemType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statDownloadItemType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statDownloadItemType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statDownloadItemType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statDownloadItemType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statDownloadItemType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statDownloadItemType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statDownloadItemType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statDownloadItemType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatDownloadItemTypeWrapper((StatDownloadItemType)_statDownloadItemType.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.StatDownloadItemType statDownloadItemType) {
		return _statDownloadItemType.compareTo(statDownloadItemType);
	}

	@Override
	public int hashCode() {
		return _statDownloadItemType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatDownloadItemType> toCacheModel() {
		return _statDownloadItemType.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatDownloadItemType toEscapedModel() {
		return new StatDownloadItemTypeWrapper(_statDownloadItemType.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatDownloadItemType toUnescapedModel() {
		return new StatDownloadItemTypeWrapper(_statDownloadItemType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statDownloadItemType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statDownloadItemType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statDownloadItemType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatDownloadItemTypeWrapper)) {
			return false;
		}

		StatDownloadItemTypeWrapper statDownloadItemTypeWrapper = (StatDownloadItemTypeWrapper)obj;

		if (Validator.equals(_statDownloadItemType,
					statDownloadItemTypeWrapper._statDownloadItemType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatDownloadItemType getWrappedStatDownloadItemType() {
		return _statDownloadItemType;
	}

	@Override
	public StatDownloadItemType getWrappedModel() {
		return _statDownloadItemType;
	}

	@Override
	public void resetOriginalValues() {
		_statDownloadItemType.resetOriginalValues();
	}

	private StatDownloadItemType _statDownloadItemType;
}