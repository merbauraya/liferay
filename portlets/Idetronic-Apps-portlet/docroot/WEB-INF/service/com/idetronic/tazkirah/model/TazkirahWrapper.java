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

package com.idetronic.tazkirah.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tazkirah}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Tazkirah
 * @generated
 */
public class TazkirahWrapper implements Tazkirah, ModelWrapper<Tazkirah> {
	public TazkirahWrapper(Tazkirah tazkirah) {
		_tazkirah = tazkirah;
	}

	@Override
	public Class<?> getModelClass() {
		return Tazkirah.class;
	}

	@Override
	public String getModelClassName() {
		return Tazkirah.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tazkirahId", getTazkirahId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("category", getCategory());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tazkirahId = (Long)attributes.get("tazkirahId");

		if (tazkirahId != null) {
			setTazkirahId(tazkirahId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this tazkirah.
	*
	* @return the primary key of this tazkirah
	*/
	@Override
	public long getPrimaryKey() {
		return _tazkirah.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tazkirah.
	*
	* @param primaryKey the primary key of this tazkirah
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tazkirah.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tazkirah ID of this tazkirah.
	*
	* @return the tazkirah ID of this tazkirah
	*/
	@Override
	public long getTazkirahId() {
		return _tazkirah.getTazkirahId();
	}

	/**
	* Sets the tazkirah ID of this tazkirah.
	*
	* @param tazkirahId the tazkirah ID of this tazkirah
	*/
	@Override
	public void setTazkirahId(long tazkirahId) {
		_tazkirah.setTazkirahId(tazkirahId);
	}

	/**
	* Returns the company ID of this tazkirah.
	*
	* @return the company ID of this tazkirah
	*/
	@Override
	public long getCompanyId() {
		return _tazkirah.getCompanyId();
	}

	/**
	* Sets the company ID of this tazkirah.
	*
	* @param companyId the company ID of this tazkirah
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tazkirah.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this tazkirah.
	*
	* @return the group ID of this tazkirah
	*/
	@Override
	public long getGroupId() {
		return _tazkirah.getGroupId();
	}

	/**
	* Sets the group ID of this tazkirah.
	*
	* @param groupId the group ID of this tazkirah
	*/
	@Override
	public void setGroupId(long groupId) {
		_tazkirah.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this tazkirah.
	*
	* @return the user ID of this tazkirah
	*/
	@Override
	public long getUserId() {
		return _tazkirah.getUserId();
	}

	/**
	* Sets the user ID of this tazkirah.
	*
	* @param userId the user ID of this tazkirah
	*/
	@Override
	public void setUserId(long userId) {
		_tazkirah.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tazkirah.
	*
	* @return the user uuid of this tazkirah
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tazkirah.getUserUuid();
	}

	/**
	* Sets the user uuid of this tazkirah.
	*
	* @param userUuid the user uuid of this tazkirah
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tazkirah.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tazkirah.
	*
	* @return the user name of this tazkirah
	*/
	@Override
	public java.lang.String getUserName() {
		return _tazkirah.getUserName();
	}

	/**
	* Sets the user name of this tazkirah.
	*
	* @param userName the user name of this tazkirah
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tazkirah.setUserName(userName);
	}

	/**
	* Returns the create date of this tazkirah.
	*
	* @return the create date of this tazkirah
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tazkirah.getCreateDate();
	}

	/**
	* Sets the create date of this tazkirah.
	*
	* @param createDate the create date of this tazkirah
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tazkirah.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this tazkirah.
	*
	* @return the modified date of this tazkirah
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tazkirah.getModifiedDate();
	}

	/**
	* Sets the modified date of this tazkirah.
	*
	* @param modifiedDate the modified date of this tazkirah
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tazkirah.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this tazkirah.
	*
	* @return the title of this tazkirah
	*/
	@Override
	public java.lang.String getTitle() {
		return _tazkirah.getTitle();
	}

	/**
	* Sets the title of this tazkirah.
	*
	* @param title the title of this tazkirah
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_tazkirah.setTitle(title);
	}

	/**
	* Returns the content of this tazkirah.
	*
	* @return the content of this tazkirah
	*/
	@Override
	public java.lang.String getContent() {
		return _tazkirah.getContent();
	}

	/**
	* Sets the content of this tazkirah.
	*
	* @param content the content of this tazkirah
	*/
	@Override
	public void setContent(java.lang.String content) {
		_tazkirah.setContent(content);
	}

	/**
	* Returns the category of this tazkirah.
	*
	* @return the category of this tazkirah
	*/
	@Override
	public java.lang.String getCategory() {
		return _tazkirah.getCategory();
	}

	/**
	* Sets the category of this tazkirah.
	*
	* @param category the category of this tazkirah
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_tazkirah.setCategory(category);
	}

	/**
	* Returns the status of this tazkirah.
	*
	* @return the status of this tazkirah
	*/
	@Override
	public int getStatus() {
		return _tazkirah.getStatus();
	}

	/**
	* Sets the status of this tazkirah.
	*
	* @param status the status of this tazkirah
	*/
	@Override
	public void setStatus(int status) {
		_tazkirah.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _tazkirah.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tazkirah.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tazkirah.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tazkirah.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tazkirah.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tazkirah.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tazkirah.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tazkirah.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tazkirah.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tazkirah.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tazkirah.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TazkirahWrapper((Tazkirah)_tazkirah.clone());
	}

	@Override
	public int compareTo(com.idetronic.tazkirah.model.Tazkirah tazkirah) {
		return _tazkirah.compareTo(tazkirah);
	}

	@Override
	public int hashCode() {
		return _tazkirah.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.tazkirah.model.Tazkirah> toCacheModel() {
		return _tazkirah.toCacheModel();
	}

	@Override
	public com.idetronic.tazkirah.model.Tazkirah toEscapedModel() {
		return new TazkirahWrapper(_tazkirah.toEscapedModel());
	}

	@Override
	public com.idetronic.tazkirah.model.Tazkirah toUnescapedModel() {
		return new TazkirahWrapper(_tazkirah.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tazkirah.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tazkirah.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tazkirah.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TazkirahWrapper)) {
			return false;
		}

		TazkirahWrapper tazkirahWrapper = (TazkirahWrapper)obj;

		if (Validator.equals(_tazkirah, tazkirahWrapper._tazkirah)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Tazkirah getWrappedTazkirah() {
		return _tazkirah;
	}

	@Override
	public Tazkirah getWrappedModel() {
		return _tazkirah;
	}

	@Override
	public void resetOriginalValues() {
		_tazkirah.resetOriginalValues();
	}

	private Tazkirah _tazkirah;
}