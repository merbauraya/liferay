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
 * This class is a wrapper for {@link ItemType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemType
 * @generated
 */
public class ItemTypeWrapper implements ItemType, ModelWrapper<ItemType> {
	public ItemTypeWrapper(ItemType itemType) {
		_itemType = itemType;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemType.class;
	}

	@Override
	public String getModelClassName() {
		return ItemType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ItemTypeId", getItemTypeId());
		attributes.put("ItemTypeName", getItemTypeName());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ItemTypeId = (Long)attributes.get("ItemTypeId");

		if (ItemTypeId != null) {
			setItemTypeId(ItemTypeId);
		}

		String ItemTypeName = (String)attributes.get("ItemTypeName");

		if (ItemTypeName != null) {
			setItemTypeName(ItemTypeName);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	/**
	* Returns the primary key of this item type.
	*
	* @return the primary key of this item type
	*/
	@Override
	public long getPrimaryKey() {
		return _itemType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item type.
	*
	* @param primaryKey the primary key of this item type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_itemType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item type ID of this item type.
	*
	* @return the item type ID of this item type
	*/
	@Override
	public long getItemTypeId() {
		return _itemType.getItemTypeId();
	}

	/**
	* Sets the item type ID of this item type.
	*
	* @param ItemTypeId the item type ID of this item type
	*/
	@Override
	public void setItemTypeId(long ItemTypeId) {
		_itemType.setItemTypeId(ItemTypeId);
	}

	/**
	* Returns the item type name of this item type.
	*
	* @return the item type name of this item type
	*/
	@Override
	public java.lang.String getItemTypeName() {
		return _itemType.getItemTypeName();
	}

	/**
	* Sets the item type name of this item type.
	*
	* @param ItemTypeName the item type name of this item type
	*/
	@Override
	public void setItemTypeName(java.lang.String ItemTypeName) {
		_itemType.setItemTypeName(ItemTypeName);
	}

	/**
	* Returns the item count of this item type.
	*
	* @return the item count of this item type
	*/
	@Override
	public int getItemCount() {
		return _itemType.getItemCount();
	}

	/**
	* Sets the item count of this item type.
	*
	* @param itemCount the item count of this item type
	*/
	@Override
	public void setItemCount(int itemCount) {
		_itemType.setItemCount(itemCount);
	}

	@Override
	public boolean isNew() {
		return _itemType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemTypeWrapper((ItemType)_itemType.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.ItemType itemType) {
		return _itemType.compareTo(itemType);
	}

	@Override
	public int hashCode() {
		return _itemType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ItemType> toCacheModel() {
		return _itemType.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ItemType toEscapedModel() {
		return new ItemTypeWrapper(_itemType.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ItemType toUnescapedModel() {
		return new ItemTypeWrapper(_itemType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemTypeWrapper)) {
			return false;
		}

		ItemTypeWrapper itemTypeWrapper = (ItemTypeWrapper)obj;

		if (Validator.equals(_itemType, itemTypeWrapper._itemType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemType getWrappedItemType() {
		return _itemType;
	}

	@Override
	public ItemType getWrappedModel() {
		return _itemType;
	}

	@Override
	public void resetOriginalValues() {
		_itemType.resetOriginalValues();
	}

	private ItemType _itemType;
}