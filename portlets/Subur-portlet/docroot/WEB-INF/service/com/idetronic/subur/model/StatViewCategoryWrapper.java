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
 * This class is a wrapper for {@link StatViewCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewCategory
 * @generated
 */
public class StatViewCategoryWrapper implements StatViewCategory,
	ModelWrapper<StatViewCategory> {
	public StatViewCategoryWrapper(StatViewCategory statViewCategory) {
		_statViewCategory = statViewCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return StatViewCategory.class;
	}

	@Override
	public String getModelClassName() {
		return StatViewCategory.class.getName();
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
	* Returns the primary key of this stat view category.
	*
	* @return the primary key of this stat view category
	*/
	@Override
	public long getPrimaryKey() {
		return _statViewCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat view category.
	*
	* @param primaryKey the primary key of this stat view category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statViewCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat view category.
	*
	* @return the ID of this stat view category
	*/
	@Override
	public long getId() {
		return _statViewCategory.getId();
	}

	/**
	* Sets the ID of this stat view category.
	*
	* @param id the ID of this stat view category
	*/
	@Override
	public void setId(long id) {
		_statViewCategory.setId(id);
	}

	/**
	* Returns the per month of this stat view category.
	*
	* @return the per month of this stat view category
	*/
	@Override
	public int getPerMonth() {
		return _statViewCategory.getPerMonth();
	}

	/**
	* Sets the per month of this stat view category.
	*
	* @param perMonth the per month of this stat view category
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statViewCategory.setPerMonth(perMonth);
	}

	/**
	* Returns the per year of this stat view category.
	*
	* @return the per year of this stat view category
	*/
	@Override
	public int getPerYear() {
		return _statViewCategory.getPerYear();
	}

	/**
	* Sets the per year of this stat view category.
	*
	* @param perYear the per year of this stat view category
	*/
	@Override
	public void setPerYear(int perYear) {
		_statViewCategory.setPerYear(perYear);
	}

	/**
	* Returns the category ID of this stat view category.
	*
	* @return the category ID of this stat view category
	*/
	@Override
	public long getCategoryId() {
		return _statViewCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this stat view category.
	*
	* @param categoryId the category ID of this stat view category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_statViewCategory.setCategoryId(categoryId);
	}

	@Override
	public boolean isNew() {
		return _statViewCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statViewCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statViewCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statViewCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statViewCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statViewCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statViewCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statViewCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statViewCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statViewCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statViewCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatViewCategoryWrapper((StatViewCategory)_statViewCategory.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.StatViewCategory statViewCategory) {
		return _statViewCategory.compareTo(statViewCategory);
	}

	@Override
	public int hashCode() {
		return _statViewCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatViewCategory> toCacheModel() {
		return _statViewCategory.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatViewCategory toEscapedModel() {
		return new StatViewCategoryWrapper(_statViewCategory.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatViewCategory toUnescapedModel() {
		return new StatViewCategoryWrapper(_statViewCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statViewCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statViewCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statViewCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatViewCategoryWrapper)) {
			return false;
		}

		StatViewCategoryWrapper statViewCategoryWrapper = (StatViewCategoryWrapper)obj;

		if (Validator.equals(_statViewCategory,
					statViewCategoryWrapper._statViewCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatViewCategory getWrappedStatViewCategory() {
		return _statViewCategory;
	}

	@Override
	public StatViewCategory getWrappedModel() {
		return _statViewCategory;
	}

	@Override
	public void resetOriginalValues() {
		_statViewCategory.resetOriginalValues();
	}

	private StatViewCategory _statViewCategory;
}