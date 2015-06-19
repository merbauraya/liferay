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
 * This class is a wrapper for {@link ItemItemType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemItemType
 * @generated
 */
public class ItemItemTypeWrapper implements ItemItemType,
	ModelWrapper<ItemItemType> {
	public ItemItemTypeWrapper(ItemItemType itemItemType) {
		_itemItemType = itemItemType;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemItemType.class;
	}

	@Override
	public String getModelClassName() {
		return ItemItemType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("itemTypeId", getItemTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}
	}

	/**
	* Returns the primary key of this item item type.
	*
	* @return the primary key of this item item type
	*/
	@Override
	public com.idetronic.subur.service.persistence.ItemItemTypePK getPrimaryKey() {
		return _itemItemType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item item type.
	*
	* @param primaryKey the primary key of this item item type
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.ItemItemTypePK primaryKey) {
		_itemItemType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this item item type.
	*
	* @return the item ID of this item item type
	*/
	@Override
	public long getItemId() {
		return _itemItemType.getItemId();
	}

	/**
	* Sets the item ID of this item item type.
	*
	* @param itemId the item ID of this item item type
	*/
	@Override
	public void setItemId(long itemId) {
		_itemItemType.setItemId(itemId);
	}

	/**
	* Returns the item type ID of this item item type.
	*
	* @return the item type ID of this item item type
	*/
	@Override
	public long getItemTypeId() {
		return _itemItemType.getItemTypeId();
	}

	/**
	* Sets the item type ID of this item item type.
	*
	* @param itemTypeId the item type ID of this item item type
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemItemType.setItemTypeId(itemTypeId);
	}

	@Override
	public boolean isNew() {
		return _itemItemType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemItemType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemItemType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemItemType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemItemType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemItemType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemItemType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemItemType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemItemType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemItemType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemItemType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemItemTypeWrapper((ItemItemType)_itemItemType.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.ItemItemType itemItemType) {
		return _itemItemType.compareTo(itemItemType);
	}

	@Override
	public int hashCode() {
		return _itemItemType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ItemItemType> toCacheModel() {
		return _itemItemType.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ItemItemType toEscapedModel() {
		return new ItemItemTypeWrapper(_itemItemType.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ItemItemType toUnescapedModel() {
		return new ItemItemTypeWrapper(_itemItemType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemItemType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemItemType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemItemType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemItemTypeWrapper)) {
			return false;
		}

		ItemItemTypeWrapper itemItemTypeWrapper = (ItemItemTypeWrapper)obj;

		if (Validator.equals(_itemItemType, itemItemTypeWrapper._itemItemType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemItemType getWrappedItemItemType() {
		return _itemItemType;
	}

	@Override
	public ItemItemType getWrappedModel() {
		return _itemItemType;
	}

	@Override
	public void resetOriginalValues() {
		_itemItemType.resetOriginalValues();
	}

	private ItemItemType _itemItemType;
}