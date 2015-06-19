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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Item}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Item
 * @generated
 */
public class ItemWrapper implements Item, ModelWrapper<Item> {
	public ItemWrapper(Item item) {
		_item = item;
	}

	@Override
	public Class<?> getModelClass() {
		return Item.class;
	}

	@Override
	public String getModelClassName() {
		return Item.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("itemAbstract", getItemAbstract());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String itemAbstract = (String)attributes.get("itemAbstract");

		if (itemAbstract != null) {
			setItemAbstract(itemAbstract);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this item.
	*
	* @return the primary key of this item
	*/
	@Override
	public long getPrimaryKey() {
		return _item.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item.
	*
	* @param primaryKey the primary key of this item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_item.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this item.
	*
	* @return the item ID of this item
	*/
	@Override
	public long getItemId() {
		return _item.getItemId();
	}

	/**
	* Sets the item ID of this item.
	*
	* @param itemId the item ID of this item
	*/
	@Override
	public void setItemId(long itemId) {
		_item.setItemId(itemId);
	}

	/**
	* Returns the company ID of this item.
	*
	* @return the company ID of this item
	*/
	@Override
	public long getCompanyId() {
		return _item.getCompanyId();
	}

	/**
	* Sets the company ID of this item.
	*
	* @param companyId the company ID of this item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_item.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this item.
	*
	* @return the group ID of this item
	*/
	@Override
	public long getGroupId() {
		return _item.getGroupId();
	}

	/**
	* Sets the group ID of this item.
	*
	* @param groupId the group ID of this item
	*/
	@Override
	public void setGroupId(long groupId) {
		_item.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this item.
	*
	* @return the user ID of this item
	*/
	@Override
	public long getUserId() {
		return _item.getUserId();
	}

	/**
	* Sets the user ID of this item.
	*
	* @param userId the user ID of this item
	*/
	@Override
	public void setUserId(long userId) {
		_item.setUserId(userId);
	}

	/**
	* Returns the user uuid of this item.
	*
	* @return the user uuid of this item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _item.getUserUuid();
	}

	/**
	* Sets the user uuid of this item.
	*
	* @param userUuid the user uuid of this item
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_item.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this item.
	*
	* @return the user name of this item
	*/
	@Override
	public java.lang.String getUserName() {
		return _item.getUserName();
	}

	/**
	* Sets the user name of this item.
	*
	* @param userName the user name of this item
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_item.setUserName(userName);
	}

	/**
	* Returns the create date of this item.
	*
	* @return the create date of this item
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _item.getCreateDate();
	}

	/**
	* Sets the create date of this item.
	*
	* @param createDate the create date of this item
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_item.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this item.
	*
	* @return the modified date of this item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _item.getModifiedDate();
	}

	/**
	* Sets the modified date of this item.
	*
	* @param modifiedDate the modified date of this item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_item.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this item.
	*
	* @return the title of this item
	*/
	@Override
	public java.lang.String getTitle() {
		return _item.getTitle();
	}

	/**
	* Sets the title of this item.
	*
	* @param title the title of this item
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_item.setTitle(title);
	}

	/**
	* Returns the item abstract of this item.
	*
	* @return the item abstract of this item
	*/
	@Override
	public java.lang.String getItemAbstract() {
		return _item.getItemAbstract();
	}

	/**
	* Sets the item abstract of this item.
	*
	* @param itemAbstract the item abstract of this item
	*/
	@Override
	public void setItemAbstract(java.lang.String itemAbstract) {
		_item.setItemAbstract(itemAbstract);
	}

	/**
	* Returns the status of this item.
	*
	* @return the status of this item
	*/
	@Override
	public int getStatus() {
		return _item.getStatus();
	}

	/**
	* Sets the status of this item.
	*
	* @param status the status of this item
	*/
	@Override
	public void setStatus(int status) {
		_item.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _item.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_item.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _item.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_item.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _item.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _item.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_item.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _item.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_item.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_item.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_item.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemWrapper((Item)_item.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.Item item) {
		return _item.compareTo(item);
	}

	@Override
	public int hashCode() {
		return _item.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.Item> toCacheModel() {
		return _item.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.Item toEscapedModel() {
		return new ItemWrapper(_item.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.Item toUnescapedModel() {
		return new ItemWrapper(_item.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _item.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _item.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_item.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemWrapper)) {
			return false;
		}

		ItemWrapper itemWrapper = (ItemWrapper)obj;

		if (Validator.equals(_item, itemWrapper._item)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Item getWrappedItem() {
		return _item;
	}

	@Override
	public Item getWrappedModel() {
		return _item;
	}

	@Override
	public void resetOriginalValues() {
		_item.resetOriginalValues();
	}

	private Item _item;
}