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
 * This class is a wrapper for {@link StatViewItemType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewItemType
 * @generated
 */
public class StatViewItemTypeWrapper implements StatViewItemType,
	ModelWrapper<StatViewItemType> {
	public StatViewItemTypeWrapper(StatViewItemType statViewItemType) {
		_statViewItemType = statViewItemType;
	}

	@Override
	public Class<?> getModelClass() {
		return StatViewItemType.class;
	}

	@Override
	public String getModelClassName() {
		return StatViewItemType.class.getName();
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
	* Returns the primary key of this stat view item type.
	*
	* @return the primary key of this stat view item type
	*/
	@Override
	public long getPrimaryKey() {
		return _statViewItemType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat view item type.
	*
	* @param primaryKey the primary key of this stat view item type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statViewItemType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat view item type.
	*
	* @return the ID of this stat view item type
	*/
	@Override
	public long getId() {
		return _statViewItemType.getId();
	}

	/**
	* Sets the ID of this stat view item type.
	*
	* @param id the ID of this stat view item type
	*/
	@Override
	public void setId(long id) {
		_statViewItemType.setId(id);
	}

	/**
	* Returns the per month of this stat view item type.
	*
	* @return the per month of this stat view item type
	*/
	@Override
	public int getPerMonth() {
		return _statViewItemType.getPerMonth();
	}

	/**
	* Sets the per month of this stat view item type.
	*
	* @param perMonth the per month of this stat view item type
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statViewItemType.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this stat view item type.
	*
	* @return the per year of this stat view item type
	*/
	@Override
	public int getPerYear() {
		return _statViewItemType.getPerYear();
	}

	/**
	* Sets the per year of this stat view item type.
	*
	* @param perYear the per year of this stat view item type
	*/
	@Override
	public void setPerYear(int perYear) {
		_statViewItemType.setPerYear(perYear);
	}

	/**
	* Returns the item type ID of this stat view item type.
	*
	* @return the item type ID of this stat view item type
	*/
	@Override
	public long getItemTypeId() {
		return _statViewItemType.getItemTypeId();
	}

	/**
	* Sets the item type ID of this stat view item type.
	*
	* @param itemTypeId the item type ID of this stat view item type
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_statViewItemType.setItemTypeId(itemTypeId);
	}

	@Override
	public boolean isNew() {
		return _statViewItemType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statViewItemType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statViewItemType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statViewItemType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statViewItemType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statViewItemType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statViewItemType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statViewItemType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statViewItemType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statViewItemType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statViewItemType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatViewItemTypeWrapper((StatViewItemType)_statViewItemType.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.StatViewItemType statViewItemType) {
		return _statViewItemType.compareTo(statViewItemType);
	}

	@Override
	public int hashCode() {
		return _statViewItemType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatViewItemType> toCacheModel() {
		return _statViewItemType.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatViewItemType toEscapedModel() {
		return new StatViewItemTypeWrapper(_statViewItemType.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatViewItemType toUnescapedModel() {
		return new StatViewItemTypeWrapper(_statViewItemType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statViewItemType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statViewItemType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statViewItemType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatViewItemTypeWrapper)) {
			return false;
		}

		StatViewItemTypeWrapper statViewItemTypeWrapper = (StatViewItemTypeWrapper)obj;

		if (Validator.equals(_statViewItemType,
					statViewItemTypeWrapper._statViewItemType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatViewItemType getWrappedStatViewItemType() {
		return _statViewItemType;
	}

	@Override
	public StatViewItemType getWrappedModel() {
		return _statViewItemType;
	}

	@Override
	public void resetOriginalValues() {
		_statViewItemType.resetOriginalValues();
	}

	private StatViewItemType _statViewItemType;
}