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
 * This class is a wrapper for {@link Division}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Division
 * @generated
 */
public class DivisionWrapper implements Division, ModelWrapper<Division> {
	public DivisionWrapper(Division division) {
		_division = division;
	}

	@Override
	public Class<?> getModelClass() {
		return Division.class;
	}

	@Override
	public String getModelClassName() {
		return Division.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("divisionId", getDivisionId());
		attributes.put("parentId", getParentId());
		attributes.put("divisionName", getDivisionName());
		attributes.put("depositable", getDepositable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long divisionId = (Long)attributes.get("divisionId");

		if (divisionId != null) {
			setDivisionId(divisionId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String divisionName = (String)attributes.get("divisionName");

		if (divisionName != null) {
			setDivisionName(divisionName);
		}

		Boolean depositable = (Boolean)attributes.get("depositable");

		if (depositable != null) {
			setDepositable(depositable);
		}
	}

	/**
	* Returns the primary key of this division.
	*
	* @return the primary key of this division
	*/
	@Override
	public long getPrimaryKey() {
		return _division.getPrimaryKey();
	}

	/**
	* Sets the primary key of this division.
	*
	* @param primaryKey the primary key of this division
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_division.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the division ID of this division.
	*
	* @return the division ID of this division
	*/
	@Override
	public long getDivisionId() {
		return _division.getDivisionId();
	}

	/**
	* Sets the division ID of this division.
	*
	* @param divisionId the division ID of this division
	*/
	@Override
	public void setDivisionId(long divisionId) {
		_division.setDivisionId(divisionId);
	}

	/**
	* Returns the parent ID of this division.
	*
	* @return the parent ID of this division
	*/
	@Override
	public long getParentId() {
		return _division.getParentId();
	}

	/**
	* Sets the parent ID of this division.
	*
	* @param parentId the parent ID of this division
	*/
	@Override
	public void setParentId(long parentId) {
		_division.setParentId(parentId);
	}

	/**
	* Returns the division name of this division.
	*
	* @return the division name of this division
	*/
	@Override
	public java.lang.String getDivisionName() {
		return _division.getDivisionName();
	}

	/**
	* Sets the division name of this division.
	*
	* @param divisionName the division name of this division
	*/
	@Override
	public void setDivisionName(java.lang.String divisionName) {
		_division.setDivisionName(divisionName);
	}

	/**
	* Returns the depositable of this division.
	*
	* @return the depositable of this division
	*/
	@Override
	public boolean getDepositable() {
		return _division.getDepositable();
	}

	/**
	* Returns <code>true</code> if this division is depositable.
	*
	* @return <code>true</code> if this division is depositable; <code>false</code> otherwise
	*/
	@Override
	public boolean isDepositable() {
		return _division.isDepositable();
	}

	/**
	* Sets whether this division is depositable.
	*
	* @param depositable the depositable of this division
	*/
	@Override
	public void setDepositable(boolean depositable) {
		_division.setDepositable(depositable);
	}

	@Override
	public boolean isNew() {
		return _division.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_division.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _division.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_division.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _division.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _division.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_division.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _division.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_division.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_division.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_division.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DivisionWrapper((Division)_division.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.Division division) {
		return _division.compareTo(division);
	}

	@Override
	public int hashCode() {
		return _division.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.Division> toCacheModel() {
		return _division.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.Division toEscapedModel() {
		return new DivisionWrapper(_division.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.Division toUnescapedModel() {
		return new DivisionWrapper(_division.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _division.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _division.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_division.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DivisionWrapper)) {
			return false;
		}

		DivisionWrapper divisionWrapper = (DivisionWrapper)obj;

		if (Validator.equals(_division, divisionWrapper._division)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Division getWrappedDivision() {
		return _division;
	}

	@Override
	public Division getWrappedModel() {
		return _division;
	}

	@Override
	public void resetOriginalValues() {
		_division.resetOriginalValues();
	}

	private Division _division;
}