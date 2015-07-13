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
 * This class is a wrapper for {@link StatDownloadTag}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadTag
 * @generated
 */
public class StatDownloadTagWrapper implements StatDownloadTag,
	ModelWrapper<StatDownloadTag> {
	public StatDownloadTagWrapper(StatDownloadTag statDownloadTag) {
		_statDownloadTag = statDownloadTag;
	}

	@Override
	public Class<?> getModelClass() {
		return StatDownloadTag.class;
	}

	@Override
	public String getModelClassName() {
		return StatDownloadTag.class.getName();
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
	* Returns the primary key of this stat download tag.
	*
	* @return the primary key of this stat download tag
	*/
	@Override
	public long getPrimaryKey() {
		return _statDownloadTag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat download tag.
	*
	* @param primaryKey the primary key of this stat download tag
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statDownloadTag.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat download tag.
	*
	* @return the ID of this stat download tag
	*/
	@Override
	public long getId() {
		return _statDownloadTag.getId();
	}

	/**
	* Sets the ID of this stat download tag.
	*
	* @param id the ID of this stat download tag
	*/
	@Override
	public void setId(long id) {
		_statDownloadTag.setId(id);
	}

	/**
	* Returns the per month of this stat download tag.
	*
	* @return the per month of this stat download tag
	*/
	@Override
	public int getPerMonth() {
		return _statDownloadTag.getPerMonth();
	}

	/**
	* Sets the per month of this stat download tag.
	*
	* @param perMonth the per month of this stat download tag
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statDownloadTag.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this stat download tag.
	*
	* @return the per year of this stat download tag
	*/
	@Override
	public int getPerYear() {
		return _statDownloadTag.getPerYear();
	}

	/**
	* Sets the per year of this stat download tag.
	*
	* @param perYear the per year of this stat download tag
	*/
	@Override
	public void setPerYear(int perYear) {
		_statDownloadTag.setPerYear(perYear);
	}

	/**
	* Returns the tag ID of this stat download tag.
	*
	* @return the tag ID of this stat download tag
	*/
	@Override
	public long getTagId() {
		return _statDownloadTag.getTagId();
	}

	/**
	* Sets the tag ID of this stat download tag.
	*
	* @param tagId the tag ID of this stat download tag
	*/
	@Override
	public void setTagId(long tagId) {
		_statDownloadTag.setTagId(tagId);
	}

	@Override
	public boolean isNew() {
		return _statDownloadTag.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statDownloadTag.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statDownloadTag.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statDownloadTag.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statDownloadTag.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statDownloadTag.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statDownloadTag.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statDownloadTag.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statDownloadTag.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statDownloadTag.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statDownloadTag.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatDownloadTagWrapper((StatDownloadTag)_statDownloadTag.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.StatDownloadTag statDownloadTag) {
		return _statDownloadTag.compareTo(statDownloadTag);
	}

	@Override
	public int hashCode() {
		return _statDownloadTag.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatDownloadTag> toCacheModel() {
		return _statDownloadTag.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatDownloadTag toEscapedModel() {
		return new StatDownloadTagWrapper(_statDownloadTag.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatDownloadTag toUnescapedModel() {
		return new StatDownloadTagWrapper(_statDownloadTag.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statDownloadTag.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statDownloadTag.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statDownloadTag.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatDownloadTagWrapper)) {
			return false;
		}

		StatDownloadTagWrapper statDownloadTagWrapper = (StatDownloadTagWrapper)obj;

		if (Validator.equals(_statDownloadTag,
					statDownloadTagWrapper._statDownloadTag)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatDownloadTag getWrappedStatDownloadTag() {
		return _statDownloadTag;
	}

	@Override
	public StatDownloadTag getWrappedModel() {
		return _statDownloadTag;
	}

	@Override
	public void resetOriginalValues() {
		_statDownloadTag.resetOriginalValues();
	}

	private StatDownloadTag _statDownloadTag;
}