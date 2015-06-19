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
 * This class is a wrapper for {@link ItemSubject}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemSubject
 * @generated
 */
public class ItemSubjectWrapper implements ItemSubject,
	ModelWrapper<ItemSubject> {
	public ItemSubjectWrapper(ItemSubject itemSubject) {
		_itemSubject = itemSubject;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemSubject.class;
	}

	@Override
	public String getModelClassName() {
		return ItemSubject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("subjectId", getSubjectId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}
	}

	/**
	* Returns the primary key of this item subject.
	*
	* @return the primary key of this item subject
	*/
	@Override
	public com.idetronic.subur.service.persistence.ItemSubjectPK getPrimaryKey() {
		return _itemSubject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item subject.
	*
	* @param primaryKey the primary key of this item subject
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.ItemSubjectPK primaryKey) {
		_itemSubject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this item subject.
	*
	* @return the item ID of this item subject
	*/
	@Override
	public long getItemId() {
		return _itemSubject.getItemId();
	}

	/**
	* Sets the item ID of this item subject.
	*
	* @param itemId the item ID of this item subject
	*/
	@Override
	public void setItemId(long itemId) {
		_itemSubject.setItemId(itemId);
	}

	/**
	* Returns the subject ID of this item subject.
	*
	* @return the subject ID of this item subject
	*/
	@Override
	public long getSubjectId() {
		return _itemSubject.getSubjectId();
	}

	/**
	* Sets the subject ID of this item subject.
	*
	* @param subjectId the subject ID of this item subject
	*/
	@Override
	public void setSubjectId(long subjectId) {
		_itemSubject.setSubjectId(subjectId);
	}

	@Override
	public boolean isNew() {
		return _itemSubject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemSubject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemSubject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemSubject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemSubject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemSubject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemSubject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemSubject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemSubject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemSubject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemSubject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemSubjectWrapper((ItemSubject)_itemSubject.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.ItemSubject itemSubject) {
		return _itemSubject.compareTo(itemSubject);
	}

	@Override
	public int hashCode() {
		return _itemSubject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ItemSubject> toCacheModel() {
		return _itemSubject.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ItemSubject toEscapedModel() {
		return new ItemSubjectWrapper(_itemSubject.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ItemSubject toUnescapedModel() {
		return new ItemSubjectWrapper(_itemSubject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemSubject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemSubject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemSubject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemSubjectWrapper)) {
			return false;
		}

		ItemSubjectWrapper itemSubjectWrapper = (ItemSubjectWrapper)obj;

		if (Validator.equals(_itemSubject, itemSubjectWrapper._itemSubject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemSubject getWrappedItemSubject() {
		return _itemSubject;
	}

	@Override
	public ItemSubject getWrappedModel() {
		return _itemSubject;
	}

	@Override
	public void resetOriginalValues() {
		_itemSubject.resetOriginalValues();
	}

	private ItemSubject _itemSubject;
}