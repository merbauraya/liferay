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
 * This class is a wrapper for {@link MetadataValueView}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataValueView
 * @generated
 */
public class MetadataValueViewWrapper implements MetadataValueView,
	ModelWrapper<MetadataValueView> {
	public MetadataValueViewWrapper(MetadataValueView metadataValueView) {
		_metadataValueView = metadataValueView;
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataValueView.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataValueView.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertyId", getPropertyId());
		attributes.put("subjectId", getSubjectId());
		attributes.put("subjectName", getSubjectName());
		attributes.put("textValue", getTextValue());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
		}

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
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
	* Returns the primary key of this metadata value view.
	*
	* @return the primary key of this metadata value view
	*/
	@Override
	public com.idetronic.subur.service.persistence.MetadataValueViewPK getPrimaryKey() {
		return _metadataValueView.getPrimaryKey();
	}

	/**
	* Sets the primary key of this metadata value view.
	*
	* @param primaryKey the primary key of this metadata value view
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.MetadataValueViewPK primaryKey) {
		_metadataValueView.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the property ID of this metadata value view.
	*
	* @return the property ID of this metadata value view
	*/
	@Override
	public long getPropertyId() {
		return _metadataValueView.getPropertyId();
	}

	/**
	* Sets the property ID of this metadata value view.
	*
	* @param propertyId the property ID of this metadata value view
	*/
	@Override
	public void setPropertyId(long propertyId) {
		_metadataValueView.setPropertyId(propertyId);
	}

	/**
	* Returns the subject ID of this metadata value view.
	*
	* @return the subject ID of this metadata value view
	*/
	@Override
	public long getSubjectId() {
		return _metadataValueView.getSubjectId();
	}

	/**
	* Sets the subject ID of this metadata value view.
	*
	* @param subjectId the subject ID of this metadata value view
	*/
	@Override
	public void setSubjectId(long subjectId) {
		_metadataValueView.setSubjectId(subjectId);
	}

	/**
	* Returns the subject name of this metadata value view.
	*
	* @return the subject name of this metadata value view
	*/
	@Override
	public java.lang.String getSubjectName() {
		return _metadataValueView.getSubjectName();
	}

	/**
	* Sets the subject name of this metadata value view.
	*
	* @param subjectName the subject name of this metadata value view
	*/
	@Override
	public void setSubjectName(java.lang.String subjectName) {
		_metadataValueView.setSubjectName(subjectName);
	}

	/**
	* Returns the text value of this metadata value view.
	*
	* @return the text value of this metadata value view
	*/
	@Override
	public java.lang.String getTextValue() {
		return _metadataValueView.getTextValue();
	}

	/**
	* Sets the text value of this metadata value view.
	*
	* @param textValue the text value of this metadata value view
	*/
	@Override
	public void setTextValue(java.lang.String textValue) {
		_metadataValueView.setTextValue(textValue);
	}

	/**
	* Returns the item count of this metadata value view.
	*
	* @return the item count of this metadata value view
	*/
	@Override
	public int getItemCount() {
		return _metadataValueView.getItemCount();
	}

	/**
	* Sets the item count of this metadata value view.
	*
	* @param itemCount the item count of this metadata value view
	*/
	@Override
	public void setItemCount(int itemCount) {
		_metadataValueView.setItemCount(itemCount);
	}

	@Override
	public boolean isNew() {
		return _metadataValueView.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_metadataValueView.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _metadataValueView.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_metadataValueView.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _metadataValueView.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _metadataValueView.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_metadataValueView.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _metadataValueView.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_metadataValueView.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_metadataValueView.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_metadataValueView.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MetadataValueViewWrapper((MetadataValueView)_metadataValueView.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.MetadataValueView metadataValueView) {
		return _metadataValueView.compareTo(metadataValueView);
	}

	@Override
	public int hashCode() {
		return _metadataValueView.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.MetadataValueView> toCacheModel() {
		return _metadataValueView.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.MetadataValueView toEscapedModel() {
		return new MetadataValueViewWrapper(_metadataValueView.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.MetadataValueView toUnescapedModel() {
		return new MetadataValueViewWrapper(_metadataValueView.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _metadataValueView.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _metadataValueView.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_metadataValueView.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataValueViewWrapper)) {
			return false;
		}

		MetadataValueViewWrapper metadataValueViewWrapper = (MetadataValueViewWrapper)obj;

		if (Validator.equals(_metadataValueView,
					metadataValueViewWrapper._metadataValueView)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MetadataValueView getWrappedMetadataValueView() {
		return _metadataValueView;
	}

	@Override
	public MetadataValueView getWrappedModel() {
		return _metadataValueView;
	}

	@Override
	public void resetOriginalValues() {
		_metadataValueView.resetOriginalValues();
	}

	private MetadataValueView _metadataValueView;
}