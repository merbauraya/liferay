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
 * This class is a wrapper for {@link MetadataPropertyValue}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataPropertyValue
 * @generated
 */
public class MetadataPropertyValueWrapper implements MetadataPropertyValue,
	ModelWrapper<MetadataPropertyValue> {
	public MetadataPropertyValueWrapper(
		MetadataPropertyValue metadataPropertyValue) {
		_metadataPropertyValue = metadataPropertyValue;
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataPropertyValue.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataPropertyValue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataPropertyValueId", getMetadataPropertyValueId());
		attributes.put("itemId", getItemId());
		attributes.put("propertyId", getPropertyId());
		attributes.put("textValue", getTextValue());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataPropertyValueId = (Long)attributes.get(
				"metadataPropertyValueId");

		if (metadataPropertyValueId != null) {
			setMetadataPropertyValueId(metadataPropertyValueId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
		}

		String textValue = (String)attributes.get("textValue");

		if (textValue != null) {
			setTextValue(textValue);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	/**
	* Returns the primary key of this metadata property value.
	*
	* @return the primary key of this metadata property value
	*/
	@Override
	public long getPrimaryKey() {
		return _metadataPropertyValue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this metadata property value.
	*
	* @param primaryKey the primary key of this metadata property value
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_metadataPropertyValue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the metadata property value ID of this metadata property value.
	*
	* @return the metadata property value ID of this metadata property value
	*/
	@Override
	public long getMetadataPropertyValueId() {
		return _metadataPropertyValue.getMetadataPropertyValueId();
	}

	/**
	* Sets the metadata property value ID of this metadata property value.
	*
	* @param metadataPropertyValueId the metadata property value ID of this metadata property value
	*/
	@Override
	public void setMetadataPropertyValueId(long metadataPropertyValueId) {
		_metadataPropertyValue.setMetadataPropertyValueId(metadataPropertyValueId);
	}

	/**
	* Returns the item ID of this metadata property value.
	*
	* @return the item ID of this metadata property value
	*/
	@Override
	public long getItemId() {
		return _metadataPropertyValue.getItemId();
	}

	/**
	* Sets the item ID of this metadata property value.
	*
	* @param itemId the item ID of this metadata property value
	*/
	@Override
	public void setItemId(long itemId) {
		_metadataPropertyValue.setItemId(itemId);
	}

	/**
	* Returns the property ID of this metadata property value.
	*
	* @return the property ID of this metadata property value
	*/
	@Override
	public long getPropertyId() {
		return _metadataPropertyValue.getPropertyId();
	}

	/**
	* Sets the property ID of this metadata property value.
	*
	* @param propertyId the property ID of this metadata property value
	*/
	@Override
	public void setPropertyId(long propertyId) {
		_metadataPropertyValue.setPropertyId(propertyId);
	}

	/**
	* Returns the text value of this metadata property value.
	*
	* @return the text value of this metadata property value
	*/
	@Override
	public java.lang.String getTextValue() {
		return _metadataPropertyValue.getTextValue();
	}

	/**
	* Sets the text value of this metadata property value.
	*
	* @param textValue the text value of this metadata property value
	*/
	@Override
	public void setTextValue(java.lang.String textValue) {
		_metadataPropertyValue.setTextValue(textValue);
	}

	/**
	* Returns the item count of this metadata property value.
	*
	* @return the item count of this metadata property value
	*/
	@Override
	public int getItemCount() {
		return _metadataPropertyValue.getItemCount();
	}

	/**
	* Sets the item count of this metadata property value.
	*
	* @param itemCount the item count of this metadata property value
	*/
	@Override
	public void setItemCount(int itemCount) {
		_metadataPropertyValue.setItemCount(itemCount);
	}

	@Override
	public boolean isNew() {
		return _metadataPropertyValue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_metadataPropertyValue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _metadataPropertyValue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_metadataPropertyValue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _metadataPropertyValue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _metadataPropertyValue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_metadataPropertyValue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _metadataPropertyValue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_metadataPropertyValue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_metadataPropertyValue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_metadataPropertyValue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MetadataPropertyValueWrapper((MetadataPropertyValue)_metadataPropertyValue.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.MetadataPropertyValue metadataPropertyValue) {
		return _metadataPropertyValue.compareTo(metadataPropertyValue);
	}

	@Override
	public int hashCode() {
		return _metadataPropertyValue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.MetadataPropertyValue> toCacheModel() {
		return _metadataPropertyValue.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.MetadataPropertyValue toEscapedModel() {
		return new MetadataPropertyValueWrapper(_metadataPropertyValue.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.MetadataPropertyValue toUnescapedModel() {
		return new MetadataPropertyValueWrapper(_metadataPropertyValue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _metadataPropertyValue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _metadataPropertyValue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_metadataPropertyValue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataPropertyValueWrapper)) {
			return false;
		}

		MetadataPropertyValueWrapper metadataPropertyValueWrapper = (MetadataPropertyValueWrapper)obj;

		if (Validator.equals(_metadataPropertyValue,
					metadataPropertyValueWrapper._metadataPropertyValue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MetadataPropertyValue getWrappedMetadataPropertyValue() {
		return _metadataPropertyValue;
	}

	@Override
	public MetadataPropertyValue getWrappedModel() {
		return _metadataPropertyValue;
	}

	@Override
	public void resetOriginalValues() {
		_metadataPropertyValue.resetOriginalValues();
	}

	private MetadataPropertyValue _metadataPropertyValue;
}