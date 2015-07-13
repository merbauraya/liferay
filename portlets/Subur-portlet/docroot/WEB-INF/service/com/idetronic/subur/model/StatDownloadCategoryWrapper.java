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
 * This class is a wrapper for {@link StatDownloadCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadCategory
 * @generated
 */
public class StatDownloadCategoryWrapper implements StatDownloadCategory,
	ModelWrapper<StatDownloadCategory> {
	public StatDownloadCategoryWrapper(
		StatDownloadCategory statDownloadCategory) {
		_statDownloadCategory = statDownloadCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return StatDownloadCategory.class;
	}

	@Override
	public String getModelClassName() {
		return StatDownloadCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());
		attributes.put("categoryId", getCategoryId());

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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	* Returns the primary key of this stat download category.
	*
	* @return the primary key of this stat download category
	*/
	@Override
	public long getPrimaryKey() {
		return _statDownloadCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat download category.
	*
	* @param primaryKey the primary key of this stat download category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statDownloadCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat download category.
	*
	* @return the ID of this stat download category
	*/
	@Override
	public long getId() {
		return _statDownloadCategory.getId();
	}

	/**
	* Sets the ID of this stat download category.
	*
	* @param id the ID of this stat download category
	*/
	@Override
	public void setId(long id) {
		_statDownloadCategory.setId(id);
	}

	/**
	* Returns the per month of this stat download category.
	*
	* @return the per month of this stat download category
	*/
	@Override
	public int getPerMonth() {
		return _statDownloadCategory.getPerMonth();
	}

	/**
	* Sets the per month of this stat download category.
	*
	* @param perMonth the per month of this stat download category
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statDownloadCategory.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this stat download category.
	*
	* @return the per year of this stat download category
	*/
	@Override
	public int getPerYear() {
		return _statDownloadCategory.getPerYear();
	}

	/**
	* Sets the per year of this stat download category.
	*
	* @param perYear the per year of this stat download category
	*/
	@Override
	public void setPerYear(int perYear) {
		_statDownloadCategory.setPerYear(perYear);
	}

	/**
	* Returns the category ID of this stat download category.
	*
	* @return the category ID of this stat download category
	*/
	@Override
	public long getCategoryId() {
		return _statDownloadCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this stat download category.
	*
	* @param categoryId the category ID of this stat download category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_statDownloadCategory.setCategoryId(categoryId);
	}

	@Override
	public boolean isNew() {
		return _statDownloadCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statDownloadCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statDownloadCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statDownloadCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statDownloadCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statDownloadCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statDownloadCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statDownloadCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statDownloadCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statDownloadCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statDownloadCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatDownloadCategoryWrapper((StatDownloadCategory)_statDownloadCategory.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.StatDownloadCategory statDownloadCategory) {
		return _statDownloadCategory.compareTo(statDownloadCategory);
	}

	@Override
	public int hashCode() {
		return _statDownloadCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatDownloadCategory> toCacheModel() {
		return _statDownloadCategory.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatDownloadCategory toEscapedModel() {
		return new StatDownloadCategoryWrapper(_statDownloadCategory.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatDownloadCategory toUnescapedModel() {
		return new StatDownloadCategoryWrapper(_statDownloadCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statDownloadCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statDownloadCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statDownloadCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatDownloadCategoryWrapper)) {
			return false;
		}

		StatDownloadCategoryWrapper statDownloadCategoryWrapper = (StatDownloadCategoryWrapper)obj;

		if (Validator.equals(_statDownloadCategory,
					statDownloadCategoryWrapper._statDownloadCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatDownloadCategory getWrappedStatDownloadCategory() {
		return _statDownloadCategory;
	}

	@Override
	public StatDownloadCategory getWrappedModel() {
		return _statDownloadCategory;
	}

	@Override
	public void resetOriginalValues() {
		_statDownloadCategory.resetOriginalValues();
	}

	private StatDownloadCategory _statDownloadCategory;
}