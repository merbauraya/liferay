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

package com.idetronic.eprint.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EprintSubject}.
 * </p>
 *
 * @author    Mazlan Mat
 * @see       EprintSubject
 * @generated
 */
public class EprintSubjectWrapper implements EprintSubject,
	ModelWrapper<EprintSubject> {
	public EprintSubjectWrapper(EprintSubject eprintSubject) {
		_eprintSubject = eprintSubject;
	}

	public Class<?> getModelClass() {
		return EprintSubject.class;
	}

	public String getModelClassName() {
		return EprintSubject.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("pos", getPos());
		attributes.put("subjects", getSubjects());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		Long pos = (Long)attributes.get("pos");

		if (pos != null) {
			setPos(pos);
		}

		String subjects = (String)attributes.get("subjects");

		if (subjects != null) {
			setSubjects(subjects);
		}
	}

	/**
	* Returns the primary key of this eprint subject.
	*
	* @return the primary key of this eprint subject
	*/
	public long getPrimaryKey() {
		return _eprintSubject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this eprint subject.
	*
	* @param primaryKey the primary key of this eprint subject
	*/
	public void setPrimaryKey(long primaryKey) {
		_eprintSubject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eprint ID of this eprint subject.
	*
	* @return the eprint ID of this eprint subject
	*/
	public long getEprintId() {
		return _eprintSubject.getEprintId();
	}

	/**
	* Sets the eprint ID of this eprint subject.
	*
	* @param eprintId the eprint ID of this eprint subject
	*/
	public void setEprintId(long eprintId) {
		_eprintSubject.setEprintId(eprintId);
	}

	/**
	* Returns the pos of this eprint subject.
	*
	* @return the pos of this eprint subject
	*/
	public long getPos() {
		return _eprintSubject.getPos();
	}

	/**
	* Sets the pos of this eprint subject.
	*
	* @param pos the pos of this eprint subject
	*/
	public void setPos(long pos) {
		_eprintSubject.setPos(pos);
	}

	/**
	* Returns the subjects of this eprint subject.
	*
	* @return the subjects of this eprint subject
	*/
	public java.lang.String getSubjects() {
		return _eprintSubject.getSubjects();
	}

	/**
	* Sets the subjects of this eprint subject.
	*
	* @param subjects the subjects of this eprint subject
	*/
	public void setSubjects(java.lang.String subjects) {
		_eprintSubject.setSubjects(subjects);
	}

	public boolean isNew() {
		return _eprintSubject.isNew();
	}

	public void setNew(boolean n) {
		_eprintSubject.setNew(n);
	}

	public boolean isCachedModel() {
		return _eprintSubject.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_eprintSubject.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _eprintSubject.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _eprintSubject.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eprintSubject.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eprintSubject.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eprintSubject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EprintSubjectWrapper((EprintSubject)_eprintSubject.clone());
	}

	public int compareTo(com.idetronic.eprint.model.EprintSubject eprintSubject) {
		return _eprintSubject.compareTo(eprintSubject);
	}

	@Override
	public int hashCode() {
		return _eprintSubject.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.idetronic.eprint.model.EprintSubject> toCacheModel() {
		return _eprintSubject.toCacheModel();
	}

	public com.idetronic.eprint.model.EprintSubject toEscapedModel() {
		return new EprintSubjectWrapper(_eprintSubject.toEscapedModel());
	}

	public com.idetronic.eprint.model.EprintSubject toUnescapedModel() {
		return new EprintSubjectWrapper(_eprintSubject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eprintSubject.toString();
	}

	public java.lang.String toXmlString() {
		return _eprintSubject.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eprintSubject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprintSubjectWrapper)) {
			return false;
		}

		EprintSubjectWrapper eprintSubjectWrapper = (EprintSubjectWrapper)obj;

		if (Validator.equals(_eprintSubject, eprintSubjectWrapper._eprintSubject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EprintSubject getWrappedEprintSubject() {
		return _eprintSubject;
	}

	public EprintSubject getWrappedModel() {
		return _eprintSubject;
	}

	public void resetOriginalValues() {
		_eprintSubject.resetOriginalValues();
	}

	private EprintSubject _eprintSubject;
}