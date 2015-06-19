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
 * This class is a wrapper for {@link MetadataValue}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataValue
 * @generated
 */
public class MetadataValueWrapper implements MetadataValue,
	ModelWrapper<MetadataValue> {
	public MetadataValueWrapper(MetadataValue metadataValue) {
		_metadataValue = metadataValue;
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataValue.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataValue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataValueId", getMetadataValueId());
		attributes.put("itemId", getItemId());
		attributes.put("propertyId", getPropertyId());
		attributes.put("textValue", getTextValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataValueId = (Long)attributes.get("metadataValueId");

		if (metadataValueId != null) {
			setMetadataValueId(metadataValueId);
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
	}

	/**
	* Returns the primary key of this metadata value.
	*
	* @return the primary key of this metadata value
	*/
	@Override
	public long getPrimaryKey() {
		return _metadataValue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this metadata value.
	*
	* @param primaryKey the primary key of this metadata value
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_metadataValue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the metadata value ID of this metadata value.
	*
	* @return the metadata value ID of this metadata value
	*/
	@Override
	public long getMetadataValueId() {
		return _metadataValue.getMetadataValueId();
	}

	/**
	* Sets the metadata value ID of this metadata value.
	*
	* @param metadataValueId the metadata value ID of this metadata value
	*/
	@Override
	public void setMetadataValueId(long metadataValueId) {
		_metadataValue.setMetadataValueId(metadataValueId);
	}

	/**
	* Returns the item ID of this metadata value.
	*
	* @return the item ID of this metadata value
	*/
	@Override
	public long getItemId() {
		return _metadataValue.getItemId();
	}

	/**
	* Sets the item ID of this metadata value.
	*
	* @param itemId the item ID of this metadata value
	*/
	@Override
	public void setItemId(long itemId) {
		_metadataValue.setItemId(itemId);
	}

	/**
	* Returns the property ID of this metadata value.
	*
	* @return the property ID of this metadata value
	*/
	@Override
	public long getPropertyId() {
		return _metadataValue.getPropertyId();
	}

	/**
	* Sets the property ID of this metadata value.
	*
	* @param propertyId the property ID of this metadata value
	*/
	@Override
	public void setPropertyId(long propertyId) {
		_metadataValue.setPropertyId(propertyId);
	}

	/**
	* Returns the text value of this metadata value.
	*
	* @return the text value of this metadata value
	*/
	@Override
	public java.lang.String getTextValue() {
		return _metadataValue.getTextValue();
	}

	/**
	* Sets the text value of this metadata value.
	*
	* @param textValue the text value of this metadata value
	*/
	@Override
	public void setTextValue(java.lang.String textValue) {
		_metadataValue.setTextValue(textValue);
	}

	@Override
	public boolean isNew() {
		return _metadataValue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_metadataValue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _metadataValue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_metadataValue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _metadataValue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _metadataValue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_metadataValue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _metadataValue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_metadataValue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_metadataValue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_metadataValue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MetadataValueWrapper((MetadataValue)_metadataValue.clone());
	}

	@Override
	public int compareTo(MetadataValue metadataValue) {
		return _metadataValue.compareTo(metadataValue);
	}

	@Override
	public int hashCode() {
		return _metadataValue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<MetadataValue> toCacheModel() {
		return _metadataValue.toCacheModel();
	}

	@Override
	public MetadataValue toEscapedModel() {
		return new MetadataValueWrapper(_metadataValue.toEscapedModel());
	}

	@Override
	public MetadataValue toUnescapedModel() {
		return new MetadataValueWrapper(_metadataValue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _metadataValue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _metadataValue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_metadataValue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataValueWrapper)) {
			return false;
		}

		MetadataValueWrapper metadataValueWrapper = (MetadataValueWrapper)obj;

		if (Validator.equals(_metadataValue, metadataValueWrapper._metadataValue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MetadataValue getWrappedMetadataValue() {
		return _metadataValue;
	}

	@Override
	public MetadataValue getWrappedModel() {
		return _metadataValue;
	}

	@Override
	public void resetOriginalValues() {
		_metadataValue.resetOriginalValues();
	}

	private MetadataValue _metadataValue;
}