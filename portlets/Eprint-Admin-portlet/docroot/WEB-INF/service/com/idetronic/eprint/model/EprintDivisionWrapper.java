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
 * This class is a wrapper for {@link EprintDivision}.
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintDivision
 * @generated
 */
public class EprintDivisionWrapper implements EprintDivision,
	ModelWrapper<EprintDivision> {
	public EprintDivisionWrapper(EprintDivision eprintDivision) {
		_eprintDivision = eprintDivision;
	}

	@Override
	public Class<?> getModelClass() {
		return EprintDivision.class;
	}

	@Override
	public String getModelClassName() {
		return EprintDivision.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("divisionId", getDivisionId());
		attributes.put("divisionName", getDivisionName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		String divisionId = (String)attributes.get("divisionId");

		if (divisionId != null) {
			setDivisionId(divisionId);
		}

		String divisionName = (String)attributes.get("divisionName");

		if (divisionName != null) {
			setDivisionName(divisionName);
		}
	}

	/**
	* Returns the primary key of this eprint division.
	*
	* @return the primary key of this eprint division
	*/
	@Override
	public com.idetronic.eprint.service.persistence.EprintDivisionPK getPrimaryKey() {
		return _eprintDivision.getPrimaryKey();
	}

	/**
	* Sets the primary key of this eprint division.
	*
	* @param primaryKey the primary key of this eprint division
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.eprint.service.persistence.EprintDivisionPK primaryKey) {
		_eprintDivision.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eprint ID of this eprint division.
	*
	* @return the eprint ID of this eprint division
	*/
	@Override
	public long getEprintId() {
		return _eprintDivision.getEprintId();
	}

	/**
	* Sets the eprint ID of this eprint division.
	*
	* @param eprintId the eprint ID of this eprint division
	*/
	@Override
	public void setEprintId(long eprintId) {
		_eprintDivision.setEprintId(eprintId);
	}

	/**
	* Returns the division ID of this eprint division.
	*
	* @return the division ID of this eprint division
	*/
	@Override
	public java.lang.String getDivisionId() {
		return _eprintDivision.getDivisionId();
	}

	/**
	* Sets the division ID of this eprint division.
	*
	* @param divisionId the division ID of this eprint division
	*/
	@Override
	public void setDivisionId(java.lang.String divisionId) {
		_eprintDivision.setDivisionId(divisionId);
	}

	/**
	* Returns the division name of this eprint division.
	*
	* @return the division name of this eprint division
	*/
	@Override
	public java.lang.String getDivisionName() {
		return _eprintDivision.getDivisionName();
	}

	/**
	* Sets the division name of this eprint division.
	*
	* @param divisionName the division name of this eprint division
	*/
	@Override
	public void setDivisionName(java.lang.String divisionName) {
		_eprintDivision.setDivisionName(divisionName);
	}

	@Override
	public boolean isNew() {
		return _eprintDivision.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eprintDivision.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eprintDivision.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eprintDivision.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eprintDivision.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eprintDivision.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eprintDivision.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eprintDivision.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eprintDivision.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eprintDivision.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eprintDivision.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EprintDivisionWrapper((EprintDivision)_eprintDivision.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eprint.model.EprintDivision eprintDivision) {
		return _eprintDivision.compareTo(eprintDivision);
	}

	@Override
	public int hashCode() {
		return _eprintDivision.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eprint.model.EprintDivision> toCacheModel() {
		return _eprintDivision.toCacheModel();
	}

	@Override
	public com.idetronic.eprint.model.EprintDivision toEscapedModel() {
		return new EprintDivisionWrapper(_eprintDivision.toEscapedModel());
	}

	@Override
	public com.idetronic.eprint.model.EprintDivision toUnescapedModel() {
		return new EprintDivisionWrapper(_eprintDivision.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eprintDivision.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eprintDivision.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eprintDivision.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprintDivisionWrapper)) {
			return false;
		}

		EprintDivisionWrapper eprintDivisionWrapper = (EprintDivisionWrapper)obj;

		if (Validator.equals(_eprintDivision,
					eprintDivisionWrapper._eprintDivision)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EprintDivision getWrappedEprintDivision() {
		return _eprintDivision;
	}

	@Override
	public EprintDivision getWrappedModel() {
		return _eprintDivision;
	}

	@Override
	public void resetOriginalValues() {
		_eprintDivision.resetOriginalValues();
	}

	private EprintDivision _eprintDivision;
}