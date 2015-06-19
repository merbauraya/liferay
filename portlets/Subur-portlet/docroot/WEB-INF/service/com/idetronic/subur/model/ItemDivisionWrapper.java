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
 * This class is a wrapper for {@link ItemDivision}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemDivision
 * @generated
 */
public class ItemDivisionWrapper implements ItemDivision,
	ModelWrapper<ItemDivision> {
	public ItemDivisionWrapper(ItemDivision itemDivision) {
		_itemDivision = itemDivision;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemDivision.class;
	}

	@Override
	public String getModelClassName() {
		return ItemDivision.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("divisionId", getDivisionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long divisionId = (Long)attributes.get("divisionId");

		if (divisionId != null) {
			setDivisionId(divisionId);
		}
	}

	/**
	* Returns the primary key of this item division.
	*
	* @return the primary key of this item division
	*/
	@Override
	public com.idetronic.subur.service.persistence.ItemDivisionPK getPrimaryKey() {
		return _itemDivision.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item division.
	*
	* @param primaryKey the primary key of this item division
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.ItemDivisionPK primaryKey) {
		_itemDivision.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this item division.
	*
	* @return the item ID of this item division
	*/
	@Override
	public long getItemId() {
		return _itemDivision.getItemId();
	}

	/**
	* Sets the item ID of this item division.
	*
	* @param itemId the item ID of this item division
	*/
	@Override
	public void setItemId(long itemId) {
		_itemDivision.setItemId(itemId);
	}

	/**
	* Returns the division ID of this item division.
	*
	* @return the division ID of this item division
	*/
	@Override
	public long getDivisionId() {
		return _itemDivision.getDivisionId();
	}

	/**
	* Sets the division ID of this item division.
	*
	* @param divisionId the division ID of this item division
	*/
	@Override
	public void setDivisionId(long divisionId) {
		_itemDivision.setDivisionId(divisionId);
	}

	@Override
	public boolean isNew() {
		return _itemDivision.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemDivision.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemDivision.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemDivision.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemDivision.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemDivision.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemDivision.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemDivision.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemDivision.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemDivision.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemDivision.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemDivisionWrapper((ItemDivision)_itemDivision.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.ItemDivision itemDivision) {
		return _itemDivision.compareTo(itemDivision);
	}

	@Override
	public int hashCode() {
		return _itemDivision.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ItemDivision> toCacheModel() {
		return _itemDivision.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ItemDivision toEscapedModel() {
		return new ItemDivisionWrapper(_itemDivision.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ItemDivision toUnescapedModel() {
		return new ItemDivisionWrapper(_itemDivision.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemDivision.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemDivision.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemDivision.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemDivisionWrapper)) {
			return false;
		}

		ItemDivisionWrapper itemDivisionWrapper = (ItemDivisionWrapper)obj;

		if (Validator.equals(_itemDivision, itemDivisionWrapper._itemDivision)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemDivision getWrappedItemDivision() {
		return _itemDivision;
	}

	@Override
	public ItemDivision getWrappedModel() {
		return _itemDivision;
	}

	@Override
	public void resetOriginalValues() {
		_itemDivision.resetOriginalValues();
	}

	private ItemDivision _itemDivision;
}