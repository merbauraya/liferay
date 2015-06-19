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
 * This class is a wrapper for {@link MetadataSchema}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataSchema
 * @generated
 */
public class MetadataSchemaWrapper implements MetadataSchema,
	ModelWrapper<MetadataSchema> {
	public MetadataSchemaWrapper(MetadataSchema metadataSchema) {
		_metadataSchema = metadataSchema;
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataSchema.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataSchema.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataSchemaId", getMetadataSchemaId());
		attributes.put("metadataName", getMetadataName());
		attributes.put("nameSpace", getNameSpace());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataSchemaId = (Long)attributes.get("metadataSchemaId");

		if (metadataSchemaId != null) {
			setMetadataSchemaId(metadataSchemaId);
		}

		String metadataName = (String)attributes.get("metadataName");

		if (metadataName != null) {
			setMetadataName(metadataName);
		}

		String nameSpace = (String)attributes.get("nameSpace");

		if (nameSpace != null) {
			setNameSpace(nameSpace);
		}
	}

	/**
	* Returns the primary key of this metadata schema.
	*
	* @return the primary key of this metadata schema
	*/
	@Override
	public long getPrimaryKey() {
		return _metadataSchema.getPrimaryKey();
	}

	/**
	* Sets the primary key of this metadata schema.
	*
	* @param primaryKey the primary key of this metadata schema
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_metadataSchema.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the metadata schema ID of this metadata schema.
	*
	* @return the metadata schema ID of this metadata schema
	*/
	@Override
	public long getMetadataSchemaId() {
		return _metadataSchema.getMetadataSchemaId();
	}

	/**
	* Sets the metadata schema ID of this metadata schema.
	*
	* @param metadataSchemaId the metadata schema ID of this metadata schema
	*/
	@Override
	public void setMetadataSchemaId(long metadataSchemaId) {
		_metadataSchema.setMetadataSchemaId(metadataSchemaId);
	}

	/**
	* Returns the metadata name of this metadata schema.
	*
	* @return the metadata name of this metadata schema
	*/
	@Override
	public java.lang.String getMetadataName() {
		return _metadataSchema.getMetadataName();
	}

	/**
	* Sets the metadata name of this metadata schema.
	*
	* @param metadataName the metadata name of this metadata schema
	*/
	@Override
	public void setMetadataName(java.lang.String metadataName) {
		_metadataSchema.setMetadataName(metadataName);
	}

	/**
	* Returns the name space of this metadata schema.
	*
	* @return the name space of this metadata schema
	*/
	@Override
	public java.lang.String getNameSpace() {
		return _metadataSchema.getNameSpace();
	}

	/**
	* Sets the name space of this metadata schema.
	*
	* @param nameSpace the name space of this metadata schema
	*/
	@Override
	public void setNameSpace(java.lang.String nameSpace) {
		_metadataSchema.setNameSpace(nameSpace);
	}

	@Override
	public boolean isNew() {
		return _metadataSchema.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_metadataSchema.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _metadataSchema.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_metadataSchema.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _metadataSchema.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _metadataSchema.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_metadataSchema.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _metadataSchema.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_metadataSchema.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_metadataSchema.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_metadataSchema.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MetadataSchemaWrapper((MetadataSchema)_metadataSchema.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.MetadataSchema metadataSchema) {
		return _metadataSchema.compareTo(metadataSchema);
	}

	@Override
	public int hashCode() {
		return _metadataSchema.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.MetadataSchema> toCacheModel() {
		return _metadataSchema.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.MetadataSchema toEscapedModel() {
		return new MetadataSchemaWrapper(_metadataSchema.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.MetadataSchema toUnescapedModel() {
		return new MetadataSchemaWrapper(_metadataSchema.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _metadataSchema.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _metadataSchema.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_metadataSchema.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataSchemaWrapper)) {
			return false;
		}

		MetadataSchemaWrapper metadataSchemaWrapper = (MetadataSchemaWrapper)obj;

		if (Validator.equals(_metadataSchema,
					metadataSchemaWrapper._metadataSchema)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MetadataSchema getWrappedMetadataSchema() {
		return _metadataSchema;
	}

	@Override
	public MetadataSchema getWrappedModel() {
		return _metadataSchema;
	}

	@Override
	public void resetOriginalValues() {
		_metadataSchema.resetOriginalValues();
	}

	private MetadataSchema _metadataSchema;
}