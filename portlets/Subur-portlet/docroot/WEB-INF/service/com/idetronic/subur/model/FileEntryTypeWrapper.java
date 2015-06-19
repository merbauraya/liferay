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
 * This class is a wrapper for {@link FileEntryType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FileEntryType
 * @generated
 */
public class FileEntryTypeWrapper implements FileEntryType,
	ModelWrapper<FileEntryType> {
	public FileEntryTypeWrapper(FileEntryType fileEntryType) {
		_fileEntryType = fileEntryType;
	}

	@Override
	public Class<?> getModelClass() {
		return FileEntryType.class;
	}

	@Override
	public String getModelClassName() {
		return FileEntryType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeId", getTypeId());
		attributes.put("typeName", getTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}
	}

	/**
	* Returns the primary key of this file entry type.
	*
	* @return the primary key of this file entry type
	*/
	@Override
	public long getPrimaryKey() {
		return _fileEntryType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this file entry type.
	*
	* @param primaryKey the primary key of this file entry type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fileEntryType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the type ID of this file entry type.
	*
	* @return the type ID of this file entry type
	*/
	@Override
	public long getTypeId() {
		return _fileEntryType.getTypeId();
	}

	/**
	* Sets the type ID of this file entry type.
	*
	* @param typeId the type ID of this file entry type
	*/
	@Override
	public void setTypeId(long typeId) {
		_fileEntryType.setTypeId(typeId);
	}

	/**
	* Returns the type name of this file entry type.
	*
	* @return the type name of this file entry type
	*/
	@Override
	public java.lang.String getTypeName() {
		return _fileEntryType.getTypeName();
	}

	/**
	* Sets the type name of this file entry type.
	*
	* @param typeName the type name of this file entry type
	*/
	@Override
	public void setTypeName(java.lang.String typeName) {
		_fileEntryType.setTypeName(typeName);
	}

	@Override
	public boolean isNew() {
		return _fileEntryType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_fileEntryType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _fileEntryType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fileEntryType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _fileEntryType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _fileEntryType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fileEntryType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fileEntryType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_fileEntryType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_fileEntryType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fileEntryType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FileEntryTypeWrapper((FileEntryType)_fileEntryType.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.FileEntryType fileEntryType) {
		return _fileEntryType.compareTo(fileEntryType);
	}

	@Override
	public int hashCode() {
		return _fileEntryType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.FileEntryType> toCacheModel() {
		return _fileEntryType.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.FileEntryType toEscapedModel() {
		return new FileEntryTypeWrapper(_fileEntryType.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.FileEntryType toUnescapedModel() {
		return new FileEntryTypeWrapper(_fileEntryType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fileEntryType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _fileEntryType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fileEntryType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FileEntryTypeWrapper)) {
			return false;
		}

		FileEntryTypeWrapper fileEntryTypeWrapper = (FileEntryTypeWrapper)obj;

		if (Validator.equals(_fileEntryType, fileEntryTypeWrapper._fileEntryType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FileEntryType getWrappedFileEntryType() {
		return _fileEntryType;
	}

	@Override
	public FileEntryType getWrappedModel() {
		return _fileEntryType;
	}

	@Override
	public void resetOriginalValues() {
		_fileEntryType.resetOriginalValues();
	}

	private FileEntryType _fileEntryType;
}