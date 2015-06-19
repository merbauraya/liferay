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
 * This class is a wrapper for {@link MetadataProperty}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataProperty
 * @generated
 */
public class MetadataPropertyWrapper implements MetadataProperty,
	ModelWrapper<MetadataProperty> {
	public MetadataPropertyWrapper(MetadataProperty metadataProperty) {
		_metadataProperty = metadataProperty;
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataProperty.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataProperty.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataPropertyId", getMetadataPropertyId());
		attributes.put("metadataSchemaId", getMetadataSchemaId());
		attributes.put("element", getElement());
		attributes.put("scope", getScope());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataPropertyId = (Long)attributes.get("metadataPropertyId");

		if (metadataPropertyId != null) {
			setMetadataPropertyId(metadataPropertyId);
		}

		Long metadataSchemaId = (Long)attributes.get("metadataSchemaId");

		if (metadataSchemaId != null) {
			setMetadataSchemaId(metadataSchemaId);
		}

		String element = (String)attributes.get("element");

		if (element != null) {
			setElement(element);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	/**
	* Returns the primary key of this metadata property.
	*
	* @return the primary key of this metadata property
	*/
	@Override
	public long getPrimaryKey() {
		return _metadataProperty.getPrimaryKey();
	}

	/**
	* Sets the primary key of this metadata property.
	*
	* @param primaryKey the primary key of this metadata property
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_metadataProperty.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the metadata property ID of this metadata property.
	*
	* @return the metadata property ID of this metadata property
	*/
	@Override
	public long getMetadataPropertyId() {
		return _metadataProperty.getMetadataPropertyId();
	}

	/**
	* Sets the metadata property ID of this metadata property.
	*
	* @param metadataPropertyId the metadata property ID of this metadata property
	*/
	@Override
	public void setMetadataPropertyId(long metadataPropertyId) {
		_metadataProperty.setMetadataPropertyId(metadataPropertyId);
	}

	/**
	* Returns the metadata schema ID of this metadata property.
	*
	* @return the metadata schema ID of this metadata property
	*/
	@Override
	public long getMetadataSchemaId() {
		return _metadataProperty.getMetadataSchemaId();
	}

	/**
	* Sets the metadata schema ID of this metadata property.
	*
	* @param metadataSchemaId the metadata schema ID of this metadata property
	*/
	@Override
	public void setMetadataSchemaId(long metadataSchemaId) {
		_metadataProperty.setMetadataSchemaId(metadataSchemaId);
	}

	/**
	* Returns the element of this metadata property.
	*
	* @return the element of this metadata property
	*/
	@Override
	public java.lang.String getElement() {
		return _metadataProperty.getElement();
	}

	/**
	* Sets the element of this metadata property.
	*
	* @param element the element of this metadata property
	*/
	@Override
	public void setElement(java.lang.String element) {
		_metadataProperty.setElement(element);
	}

	/**
	* Returns the scope of this metadata property.
	*
	* @return the scope of this metadata property
	*/
	@Override
	public java.lang.String getScope() {
		return _metadataProperty.getScope();
	}

	/**
	* Sets the scope of this metadata property.
	*
	* @param scope the scope of this metadata property
	*/
	@Override
	public void setScope(java.lang.String scope) {
		_metadataProperty.setScope(scope);
	}

	/**
	* Returns the note of this metadata property.
	*
	* @return the note of this metadata property
	*/
	@Override
	public java.lang.String getNote() {
		return _metadataProperty.getNote();
	}

	/**
	* Sets the note of this metadata property.
	*
	* @param note the note of this metadata property
	*/
	@Override
	public void setNote(java.lang.String note) {
		_metadataProperty.setNote(note);
	}

	@Override
	public boolean isNew() {
		return _metadataProperty.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_metadataProperty.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _metadataProperty.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_metadataProperty.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _metadataProperty.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _metadataProperty.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_metadataProperty.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _metadataProperty.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_metadataProperty.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_metadataProperty.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_metadataProperty.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MetadataPropertyWrapper((MetadataProperty)_metadataProperty.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.MetadataProperty metadataProperty) {
		return _metadataProperty.compareTo(metadataProperty);
	}

	@Override
	public int hashCode() {
		return _metadataProperty.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.MetadataProperty> toCacheModel() {
		return _metadataProperty.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.MetadataProperty toEscapedModel() {
		return new MetadataPropertyWrapper(_metadataProperty.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.MetadataProperty toUnescapedModel() {
		return new MetadataPropertyWrapper(_metadataProperty.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _metadataProperty.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _metadataProperty.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_metadataProperty.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataPropertyWrapper)) {
			return false;
		}

		MetadataPropertyWrapper metadataPropertyWrapper = (MetadataPropertyWrapper)obj;

		if (Validator.equals(_metadataProperty,
					metadataPropertyWrapper._metadataProperty)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MetadataProperty getWrappedMetadataProperty() {
		return _metadataProperty;
	}

	@Override
	public MetadataProperty getWrappedModel() {
		return _metadataProperty;
	}

	@Override
	public void resetOriginalValues() {
		_metadataProperty.resetOriginalValues();
	}

	private MetadataProperty _metadataProperty;
}