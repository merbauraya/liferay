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
 * This class is a wrapper for {@link ItemAuthor}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemAuthor
 * @generated
 */
public class ItemAuthorWrapper implements ItemAuthor, ModelWrapper<ItemAuthor> {
	public ItemAuthorWrapper(ItemAuthor itemAuthor) {
		_itemAuthor = itemAuthor;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemAuthor.class;
	}

	@Override
	public String getModelClassName() {
		return ItemAuthor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("authorId", getAuthorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}
	}

	/**
	* Returns the primary key of this item author.
	*
	* @return the primary key of this item author
	*/
	@Override
	public com.idetronic.subur.service.persistence.ItemAuthorPK getPrimaryKey() {
		return _itemAuthor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item author.
	*
	* @param primaryKey the primary key of this item author
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.ItemAuthorPK primaryKey) {
		_itemAuthor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this item author.
	*
	* @return the item ID of this item author
	*/
	@Override
	public long getItemId() {
		return _itemAuthor.getItemId();
	}

	/**
	* Sets the item ID of this item author.
	*
	* @param itemId the item ID of this item author
	*/
	@Override
	public void setItemId(long itemId) {
		_itemAuthor.setItemId(itemId);
	}

	/**
	* Returns the author ID of this item author.
	*
	* @return the author ID of this item author
	*/
	@Override
	public long getAuthorId() {
		return _itemAuthor.getAuthorId();
	}

	/**
	* Sets the author ID of this item author.
	*
	* @param authorId the author ID of this item author
	*/
	@Override
	public void setAuthorId(long authorId) {
		_itemAuthor.setAuthorId(authorId);
	}

	@Override
	public boolean isNew() {
		return _itemAuthor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemAuthor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemAuthor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemAuthor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemAuthor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemAuthor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemAuthor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemAuthor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemAuthor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemAuthor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemAuthor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemAuthorWrapper((ItemAuthor)_itemAuthor.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.ItemAuthor itemAuthor) {
		return _itemAuthor.compareTo(itemAuthor);
	}

	@Override
	public int hashCode() {
		return _itemAuthor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ItemAuthor> toCacheModel() {
		return _itemAuthor.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ItemAuthor toEscapedModel() {
		return new ItemAuthorWrapper(_itemAuthor.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ItemAuthor toUnescapedModel() {
		return new ItemAuthorWrapper(_itemAuthor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemAuthor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemAuthor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemAuthor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemAuthorWrapper)) {
			return false;
		}

		ItemAuthorWrapper itemAuthorWrapper = (ItemAuthorWrapper)obj;

		if (Validator.equals(_itemAuthor, itemAuthorWrapper._itemAuthor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemAuthor getWrappedItemAuthor() {
		return _itemAuthor;
	}

	@Override
	public ItemAuthor getWrappedModel() {
		return _itemAuthor;
	}

	@Override
	public void resetOriginalValues() {
		_itemAuthor.resetOriginalValues();
	}

	private ItemAuthor _itemAuthor;
}