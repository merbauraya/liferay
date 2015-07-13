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
 * This class is a wrapper for {@link StatViewTag}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewTag
 * @generated
 */
public class StatViewTagWrapper implements StatViewTag,
	ModelWrapper<StatViewTag> {
	public StatViewTagWrapper(StatViewTag statViewTag) {
		_statViewTag = statViewTag;
	}

	@Override
	public Class<?> getModelClass() {
		return StatViewTag.class;
	}

	@Override
	public String getModelClassName() {
		return StatViewTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());
		attributes.put("tagId", getTagId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}
	}

	/**
	* Returns the primary key of this stat view tag.
	*
	* @return the primary key of this stat view tag
	*/
	@Override
	public long getPrimaryKey() {
		return _statViewTag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat view tag.
	*
	* @param primaryKey the primary key of this stat view tag
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statViewTag.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat view tag.
	*
	* @return the ID of this stat view tag
	*/
	@Override
	public long getId() {
		return _statViewTag.getId();
	}

	/**
	* Sets the ID of this stat view tag.
	*
	* @param id the ID of this stat view tag
	*/
	@Override
	public void setId(long id) {
		_statViewTag.setId(id);
	}

	/**
	* Returns the per month of this stat view tag.
	*
	* @return the per month of this stat view tag
	*/
	@Override
	public int getPerMonth() {
		return _statViewTag.getPerMonth();
	}

	/**
	* Sets the per month of this stat view tag.
	*
	* @param perMonth the per month of this stat view tag
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statViewTag.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this stat view tag.
	*
	* @return the per year of this stat view tag
	*/
	@Override
	public int getPerYear() {
		return _statViewTag.getPerYear();
	}

	/**
	* Sets the per year of this stat view tag.
	*
	* @param perYear the per year of this stat view tag
	*/
	@Override
	public void setPerYear(int perYear) {
		_statViewTag.setPerYear(perYear);
	}

	/**
	* Returns the tag ID of this stat view tag.
	*
	* @return the tag ID of this stat view tag
	*/
	@Override
	public long getTagId() {
		return _statViewTag.getTagId();
	}

	/**
	* Sets the tag ID of this stat view tag.
	*
	* @param tagId the tag ID of this stat view tag
	*/
	@Override
	public void setTagId(long tagId) {
		_statViewTag.setTagId(tagId);
	}

	@Override
	public boolean isNew() {
		return _statViewTag.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statViewTag.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statViewTag.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statViewTag.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statViewTag.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statViewTag.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statViewTag.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statViewTag.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statViewTag.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statViewTag.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statViewTag.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatViewTagWrapper((StatViewTag)_statViewTag.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.StatViewTag statViewTag) {
		return _statViewTag.compareTo(statViewTag);
	}

	@Override
	public int hashCode() {
		return _statViewTag.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatViewTag> toCacheModel() {
		return _statViewTag.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatViewTag toEscapedModel() {
		return new StatViewTagWrapper(_statViewTag.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatViewTag toUnescapedModel() {
		return new StatViewTagWrapper(_statViewTag.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statViewTag.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statViewTag.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statViewTag.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatViewTagWrapper)) {
			return false;
		}

		StatViewTagWrapper statViewTagWrapper = (StatViewTagWrapper)obj;

		if (Validator.equals(_statViewTag, statViewTagWrapper._statViewTag)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatViewTag getWrappedStatViewTag() {
		return _statViewTag;
	}

	@Override
	public StatViewTag getWrappedModel() {
		return _statViewTag;
	}

	@Override
	public void resetOriginalValues() {
		_statViewTag.resetOriginalValues();
	}

	private StatViewTag _statViewTag;
}