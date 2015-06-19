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
 * This class is a wrapper for {@link ItemTypeTemplate}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypeTemplate
 * @generated
 */
public class ItemTypeTemplateWrapper implements ItemTypeTemplate,
	ModelWrapper<ItemTypeTemplate> {
	public ItemTypeTemplateWrapper(ItemTypeTemplate itemTypeTemplate) {
		_itemTypeTemplate = itemTypeTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemTypeTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return ItemTypeTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("metadataPropertyId", getMetadataPropertyId());
		attributes.put("required", getRequired());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		Long metadataPropertyId = (Long)attributes.get("metadataPropertyId");

		if (metadataPropertyId != null) {
			setMetadataPropertyId(metadataPropertyId);
		}

		Boolean required = (Boolean)attributes.get("required");

		if (required != null) {
			setRequired(required);
		}
	}

	/**
	* Returns the primary key of this item type template.
	*
	* @return the primary key of this item type template
	*/
	@Override
	public com.idetronic.subur.service.persistence.ItemTypeTemplatePK getPrimaryKey() {
		return _itemTypeTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item type template.
	*
	* @param primaryKey the primary key of this item type template
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.ItemTypeTemplatePK primaryKey) {
		_itemTypeTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item type ID of this item type template.
	*
	* @return the item type ID of this item type template
	*/
	@Override
	public long getItemTypeId() {
		return _itemTypeTemplate.getItemTypeId();
	}

	/**
	* Sets the item type ID of this item type template.
	*
	* @param itemTypeId the item type ID of this item type template
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeTemplate.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the metadata property ID of this item type template.
	*
	* @return the metadata property ID of this item type template
	*/
	@Override
	public long getMetadataPropertyId() {
		return _itemTypeTemplate.getMetadataPropertyId();
	}

	/**
	* Sets the metadata property ID of this item type template.
	*
	* @param metadataPropertyId the metadata property ID of this item type template
	*/
	@Override
	public void setMetadataPropertyId(long metadataPropertyId) {
		_itemTypeTemplate.setMetadataPropertyId(metadataPropertyId);
	}

	/**
	* Returns the required of this item type template.
	*
	* @return the required of this item type template
	*/
	@Override
	public boolean getRequired() {
		return _itemTypeTemplate.getRequired();
	}

	/**
	* Returns <code>true</code> if this item type template is required.
	*
	* @return <code>true</code> if this item type template is required; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequired() {
		return _itemTypeTemplate.isRequired();
	}

	/**
	* Sets whether this item type template is required.
	*
	* @param required the required of this item type template
	*/
	@Override
	public void setRequired(boolean required) {
		_itemTypeTemplate.setRequired(required);
	}

	@Override
	public boolean isNew() {
		return _itemTypeTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemTypeTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemTypeTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemTypeTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemTypeTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemTypeTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemTypeTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemTypeTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemTypeTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemTypeTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemTypeTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemTypeTemplateWrapper((ItemTypeTemplate)_itemTypeTemplate.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.ItemTypeTemplate itemTypeTemplate) {
		return _itemTypeTemplate.compareTo(itemTypeTemplate);
	}

	@Override
	public int hashCode() {
		return _itemTypeTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ItemTypeTemplate> toCacheModel() {
		return _itemTypeTemplate.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ItemTypeTemplate toEscapedModel() {
		return new ItemTypeTemplateWrapper(_itemTypeTemplate.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ItemTypeTemplate toUnescapedModel() {
		return new ItemTypeTemplateWrapper(_itemTypeTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemTypeTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemTypeTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemTypeTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemTypeTemplateWrapper)) {
			return false;
		}

		ItemTypeTemplateWrapper itemTypeTemplateWrapper = (ItemTypeTemplateWrapper)obj;

		if (Validator.equals(_itemTypeTemplate,
					itemTypeTemplateWrapper._itemTypeTemplate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemTypeTemplate getWrappedItemTypeTemplate() {
		return _itemTypeTemplate;
	}

	@Override
	public ItemTypeTemplate getWrappedModel() {
		return _itemTypeTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_itemTypeTemplate.resetOriginalValues();
	}

	private ItemTypeTemplate _itemTypeTemplate;
}