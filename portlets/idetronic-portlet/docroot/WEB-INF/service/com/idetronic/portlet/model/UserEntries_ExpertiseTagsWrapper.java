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

package com.idetronic.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserEntries_ExpertiseTags}.
 * </p>
 *
 * @author Mazlan Mat
 * @see UserEntries_ExpertiseTags
 * @generated
 */
public class UserEntries_ExpertiseTagsWrapper
	implements UserEntries_ExpertiseTags,
		ModelWrapper<UserEntries_ExpertiseTags> {
	public UserEntries_ExpertiseTagsWrapper(
		UserEntries_ExpertiseTags userEntries_ExpertiseTags) {
		_userEntries_ExpertiseTags = userEntries_ExpertiseTags;
	}

	@Override
	public Class<?> getModelClass() {
		return UserEntries_ExpertiseTags.class;
	}

	@Override
	public String getModelClassName() {
		return UserEntries_ExpertiseTags.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("tagId", getTagId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}
	}

	/**
	* Returns the primary key of this user entries_ expertise tags.
	*
	* @return the primary key of this user entries_ expertise tags
	*/
	@Override
	public com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK getPrimaryKey() {
		return _userEntries_ExpertiseTags.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user entries_ expertise tags.
	*
	* @param primaryKey the primary key of this user entries_ expertise tags
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK primaryKey) {
		_userEntries_ExpertiseTags.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this user entries_ expertise tags.
	*
	* @return the user ID of this user entries_ expertise tags
	*/
	@Override
	public long getUserId() {
		return _userEntries_ExpertiseTags.getUserId();
	}

	/**
	* Sets the user ID of this user entries_ expertise tags.
	*
	* @param userId the user ID of this user entries_ expertise tags
	*/
	@Override
	public void setUserId(long userId) {
		_userEntries_ExpertiseTags.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user entries_ expertise tags.
	*
	* @return the user uuid of this user entries_ expertise tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntries_ExpertiseTags.getUserUuid();
	}

	/**
	* Sets the user uuid of this user entries_ expertise tags.
	*
	* @param userUuid the user uuid of this user entries_ expertise tags
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userEntries_ExpertiseTags.setUserUuid(userUuid);
	}

	/**
	* Returns the tag ID of this user entries_ expertise tags.
	*
	* @return the tag ID of this user entries_ expertise tags
	*/
	@Override
	public long getTagId() {
		return _userEntries_ExpertiseTags.getTagId();
	}

	/**
	* Sets the tag ID of this user entries_ expertise tags.
	*
	* @param tagId the tag ID of this user entries_ expertise tags
	*/
	@Override
	public void setTagId(long tagId) {
		_userEntries_ExpertiseTags.setTagId(tagId);
	}

	@Override
	public boolean isNew() {
		return _userEntries_ExpertiseTags.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userEntries_ExpertiseTags.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userEntries_ExpertiseTags.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userEntries_ExpertiseTags.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userEntries_ExpertiseTags.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userEntries_ExpertiseTags.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userEntries_ExpertiseTags.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userEntries_ExpertiseTags.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userEntries_ExpertiseTags.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userEntries_ExpertiseTags.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userEntries_ExpertiseTags.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserEntries_ExpertiseTagsWrapper((UserEntries_ExpertiseTags)_userEntries_ExpertiseTags.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.portlet.model.UserEntries_ExpertiseTags userEntries_ExpertiseTags) {
		return _userEntries_ExpertiseTags.compareTo(userEntries_ExpertiseTags);
	}

	@Override
	public int hashCode() {
		return _userEntries_ExpertiseTags.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.portlet.model.UserEntries_ExpertiseTags> toCacheModel() {
		return _userEntries_ExpertiseTags.toCacheModel();
	}

	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags toEscapedModel() {
		return new UserEntries_ExpertiseTagsWrapper(_userEntries_ExpertiseTags.toEscapedModel());
	}

	@Override
	public com.idetronic.portlet.model.UserEntries_ExpertiseTags toUnescapedModel() {
		return new UserEntries_ExpertiseTagsWrapper(_userEntries_ExpertiseTags.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userEntries_ExpertiseTags.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userEntries_ExpertiseTags.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userEntries_ExpertiseTags.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserEntries_ExpertiseTagsWrapper)) {
			return false;
		}

		UserEntries_ExpertiseTagsWrapper userEntries_ExpertiseTagsWrapper = (UserEntries_ExpertiseTagsWrapper)obj;

		if (Validator.equals(_userEntries_ExpertiseTags,
					userEntries_ExpertiseTagsWrapper._userEntries_ExpertiseTags)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserEntries_ExpertiseTags getWrappedUserEntries_ExpertiseTags() {
		return _userEntries_ExpertiseTags;
	}

	@Override
	public UserEntries_ExpertiseTags getWrappedModel() {
		return _userEntries_ExpertiseTags;
	}

	@Override
	public void resetOriginalValues() {
		_userEntries_ExpertiseTags.resetOriginalValues();
	}

	private UserEntries_ExpertiseTags _userEntries_ExpertiseTags;
}