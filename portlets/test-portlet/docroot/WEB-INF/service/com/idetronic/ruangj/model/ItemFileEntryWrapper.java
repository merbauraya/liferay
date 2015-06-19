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

package com.idetronic.ruangj.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
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

		attributes.put("itemEntryId", getItemEntryId());
		attributes.put("itemId", getItemId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("fileType", getFileType());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemEntryId = (Long)attributes.get("itemEntryId");

		if (itemEntryId != null) {
			setItemEntryId(itemEntryId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String fileType = (String)attributes.get("fileType");

		if (fileType != null) {
			setFileType(fileType);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this item file entry.
	*
	* @return the primary key of this item file entry
	*/
	@Override
	public long getPrimaryKey() {
		return _itemFileEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item file entry.
	*
	* @param primaryKey the primary key of this item file entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_itemFileEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item entry ID of this item file entry.
	*
	* @return the item entry ID of this item file entry
	*/
	@Override
	public long getItemEntryId() {
		return _itemFileEntry.getItemEntryId();
	}

	/**
	* Sets the item entry ID of this item file entry.
	*
	* @param itemEntryId the item entry ID of this item file entry
	*/
	@Override
	public void setItemEntryId(long itemEntryId) {
		_itemFileEntry.setItemEntryId(itemEntryId);
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
	* Returns the file type of this item file entry.
	*
	* @return the file type of this item file entry
	*/
	@Override
	public java.lang.String getFileType() {
		return _itemFileEntry.getFileType();
	}

	/**
	* Sets the file type of this item file entry.
	*
	* @param fileType the file type of this item file entry
	*/
	@Override
	public void setFileType(java.lang.String fileType) {
		_itemFileEntry.setFileType(fileType);
	}

	/**
	* Returns the user ID of this item file entry.
	*
	* @return the user ID of this item file entry
	*/
	@Override
	public long getUserId() {
		return _itemFileEntry.getUserId();
	}

	/**
	* Sets the user ID of this item file entry.
	*
	* @param userId the user ID of this item file entry
	*/
	@Override
	public void setUserId(long userId) {
		_itemFileEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this item file entry.
	*
	* @return the user uuid of this item file entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemFileEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this item file entry.
	*
	* @param userUuid the user uuid of this item file entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_itemFileEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this item file entry.
	*
	* @return the user name of this item file entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _itemFileEntry.getUserName();
	}

	/**
	* Sets the user name of this item file entry.
	*
	* @param userName the user name of this item file entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_itemFileEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this item file entry.
	*
	* @return the create date of this item file entry
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _itemFileEntry.getCreateDate();
	}

	/**
	* Sets the create date of this item file entry.
	*
	* @param createDate the create date of this item file entry
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_itemFileEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this item file entry.
	*
	* @return the modified date of this item file entry
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _itemFileEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this item file entry.
	*
	* @param modifiedDate the modified date of this item file entry
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_itemFileEntry.setModifiedDate(modifiedDate);
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
	public int compareTo(ItemFileEntry itemFileEntry) {
		return _itemFileEntry.compareTo(itemFileEntry);
	}

	@Override
	public int hashCode() {
		return _itemFileEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ItemFileEntry> toCacheModel() {
		return _itemFileEntry.toCacheModel();
	}

	@Override
	public ItemFileEntry toEscapedModel() {
		return new ItemFileEntryWrapper(_itemFileEntry.toEscapedModel());
	}

	@Override
	public ItemFileEntry toUnescapedModel() {
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