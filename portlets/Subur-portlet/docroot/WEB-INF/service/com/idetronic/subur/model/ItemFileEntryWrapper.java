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
 * This class is a wrapper for {@link ItemFileEntry}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemFileEntry
 * @generated
 */
public class ItemFileEntryWrapper implements ItemFileEntry,
	ModelWrapper<ItemFileEntry> {
	public ItemFileEntryWrapper(ItemFileEntry itemFileEntry) {
		_itemFileEntry = itemFileEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemFileEntry.class;
	}

	@Override
	public String getModelClassName() {
		return ItemFileEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("entryType", getEntryType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long entryType = (Long)attributes.get("entryType");

		if (entryType != null) {
			setEntryType(entryType);
		}
	}

	/**
	* Returns the primary key of this item file entry.
	*
	* @return the primary key of this item file entry
	*/
	@Override
	public com.idetronic.subur.service.persistence.ItemFileEntryPK getPrimaryKey() {
		return _itemFileEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item file entry.
	*
	* @param primaryKey the primary key of this item file entry
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.ItemFileEntryPK primaryKey) {
		_itemFileEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this item file entry.
	*
	* @return the item ID of this item file entry
	*/
	@Override
	public long getItemId() {
		return _itemFileEntry.getItemId();
	}

	/**
	* Sets the item ID of this item file entry.
	*
	* @param itemId the item ID of this item file entry
	*/
	@Override
	public void setItemId(long itemId) {
		_itemFileEntry.setItemId(itemId);
	}

	/**
	* Returns the file entry ID of this item file entry.
	*
	* @return the file entry ID of this item file entry
	*/
	@Override
	public long getFileEntryId() {
		return _itemFileEntry.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this item file entry.
	*
	* @param fileEntryId the file entry ID of this item file entry
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_itemFileEntry.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the entry type of this item file entry.
	*
	* @return the entry type of this item file entry
	*/
	@Override
	public long getEntryType() {
		return _itemFileEntry.getEntryType();
	}

	/**
	* Sets the entry type of this item file entry.
	*
	* @param entryType the entry type of this item file entry
	*/
	@Override
	public void setEntryType(long entryType) {
		_itemFileEntry.setEntryType(entryType);
	}

	@Override
	public boolean isNew() {
		return _itemFileEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemFileEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemFileEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemFileEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemFileEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemFileEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemFileEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemFileEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemFileEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemFileEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemFileEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemFileEntryWrapper((ItemFileEntry)_itemFileEntry.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.ItemFileEntry itemFileEntry) {
		return _itemFileEntry.compareTo(itemFileEntry);
	}

	@Override
	public int hashCode() {
		return _itemFileEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ItemFileEntry> toCacheModel() {
		return _itemFileEntry.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ItemFileEntry toEscapedModel() {
		return new ItemFileEntryWrapper(_itemFileEntry.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ItemFileEntry toUnescapedModel() {
		return new ItemFileEntryWrapper(_itemFileEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemFileEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemFileEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemFileEntry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemFileEntryWrapper)) {
			return false;
		}

		ItemFileEntryWrapper itemFileEntryWrapper = (ItemFileEntryWrapper)obj;

		if (Validator.equals(_itemFileEntry, itemFileEntryWrapper._itemFileEntry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemFileEntry getWrappedItemFileEntry() {
		return _itemFileEntry;
	}

	@Override
	public ItemFileEntry getWrappedModel() {
		return _itemFileEntry;
	}

	@Override
	public void resetOriginalValues() {
		_itemFileEntry.resetOriginalValues();
	}

	private ItemFileEntry _itemFileEntry;
}