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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ExpertiseTag}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ExpertiseTag
 * @generated
 */
public class ExpertiseTagWrapper implements ExpertiseTag,
	ModelWrapper<ExpertiseTag> {
	public ExpertiseTagWrapper(ExpertiseTag expertiseTag) {
		_expertiseTag = expertiseTag;
	}

	@Override
	public Class<?> getModelClass() {
		return ExpertiseTag.class;
	}

	@Override
	public String getModelClassName() {
		return ExpertiseTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tagName", getTagName());
		attributes.put("userCount", getUserCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String tagName = (String)attributes.get("tagName");

		if (tagName != null) {
			setTagName(tagName);
		}

		Integer userCount = (Integer)attributes.get("userCount");

		if (userCount != null) {
			setUserCount(userCount);
		}
	}

	/**
	* Returns the primary key of this expertise tag.
	*
	* @return the primary key of this expertise tag
	*/
	@Override
	public long getPrimaryKey() {
		return _expertiseTag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this expertise tag.
	*
	* @param primaryKey the primary key of this expertise tag
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expertiseTag.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tag ID of this expertise tag.
	*
	* @return the tag ID of this expertise tag
	*/
	@Override
	public long getTagId() {
		return _expertiseTag.getTagId();
	}

	/**
	* Sets the tag ID of this expertise tag.
	*
	* @param tagId the tag ID of this expertise tag
	*/
	@Override
	public void setTagId(long tagId) {
		_expertiseTag.setTagId(tagId);
	}

	/**
	* Returns the group ID of this expertise tag.
	*
	* @return the group ID of this expertise tag
	*/
	@Override
	public long getGroupId() {
		return _expertiseTag.getGroupId();
	}

	/**
	* Sets the group ID of this expertise tag.
	*
	* @param groupId the group ID of this expertise tag
	*/
	@Override
	public void setGroupId(long groupId) {
		_expertiseTag.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this expertise tag.
	*
	* @return the company ID of this expertise tag
	*/
	@Override
	public long getCompanyId() {
		return _expertiseTag.getCompanyId();
	}

	/**
	* Sets the company ID of this expertise tag.
	*
	* @param companyId the company ID of this expertise tag
	*/
	@Override
	public void setCompanyId(long companyId) {
		_expertiseTag.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this expertise tag.
	*
	* @return the user ID of this expertise tag
	*/
	@Override
	public long getUserId() {
		return _expertiseTag.getUserId();
	}

	/**
	* Sets the user ID of this expertise tag.
	*
	* @param userId the user ID of this expertise tag
	*/
	@Override
	public void setUserId(long userId) {
		_expertiseTag.setUserId(userId);
	}

	/**
	* Returns the user uuid of this expertise tag.
	*
	* @return the user uuid of this expertise tag
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertiseTag.getUserUuid();
	}

	/**
	* Sets the user uuid of this expertise tag.
	*
	* @param userUuid the user uuid of this expertise tag
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_expertiseTag.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this expertise tag.
	*
	* @return the user name of this expertise tag
	*/
	@Override
	public java.lang.String getUserName() {
		return _expertiseTag.getUserName();
	}

	/**
	* Sets the user name of this expertise tag.
	*
	* @param userName the user name of this expertise tag
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_expertiseTag.setUserName(userName);
	}

	/**
	* Returns the create date of this expertise tag.
	*
	* @return the create date of this expertise tag
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _expertiseTag.getCreateDate();
	}

	/**
	* Sets the create date of this expertise tag.
	*
	* @param createDate the create date of this expertise tag
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_expertiseTag.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this expertise tag.
	*
	* @return the modified date of this expertise tag
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _expertiseTag.getModifiedDate();
	}

	/**
	* Sets the modified date of this expertise tag.
	*
	* @param modifiedDate the modified date of this expertise tag
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_expertiseTag.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the tag name of this expertise tag.
	*
	* @return the tag name of this expertise tag
	*/
	@Override
	public java.lang.String getTagName() {
		return _expertiseTag.getTagName();
	}

	/**
	* Sets the tag name of this expertise tag.
	*
	* @param tagName the tag name of this expertise tag
	*/
	@Override
	public void setTagName(java.lang.String tagName) {
		_expertiseTag.setTagName(tagName);
	}

	/**
	* Returns the user count of this expertise tag.
	*
	* @return the user count of this expertise tag
	*/
	@Override
	public int getUserCount() {
		return _expertiseTag.getUserCount();
	}

	/**
	* Sets the user count of this expertise tag.
	*
	* @param userCount the user count of this expertise tag
	*/
	@Override
	public void setUserCount(int userCount) {
		_expertiseTag.setUserCount(userCount);
	}

	@Override
	public boolean isNew() {
		return _expertiseTag.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_expertiseTag.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _expertiseTag.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expertiseTag.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _expertiseTag.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _expertiseTag.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_expertiseTag.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _expertiseTag.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_expertiseTag.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_expertiseTag.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_expertiseTag.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExpertiseTagWrapper((ExpertiseTag)_expertiseTag.clone());
	}

	@Override
	public int compareTo(com.idetronic.portlet.model.ExpertiseTag expertiseTag) {
		return _expertiseTag.compareTo(expertiseTag);
	}

	@Override
	public int hashCode() {
		return _expertiseTag.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.portlet.model.ExpertiseTag> toCacheModel() {
		return _expertiseTag.toCacheModel();
	}

	@Override
	public com.idetronic.portlet.model.ExpertiseTag toEscapedModel() {
		return new ExpertiseTagWrapper(_expertiseTag.toEscapedModel());
	}

	@Override
	public com.idetronic.portlet.model.ExpertiseTag toUnescapedModel() {
		return new ExpertiseTagWrapper(_expertiseTag.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _expertiseTag.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _expertiseTag.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_expertiseTag.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpertiseTagWrapper)) {
			return false;
		}

		ExpertiseTagWrapper expertiseTagWrapper = (ExpertiseTagWrapper)obj;

		if (Validator.equals(_expertiseTag, expertiseTagWrapper._expertiseTag)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ExpertiseTag getWrappedExpertiseTag() {
		return _expertiseTag;
	}

	@Override
	public ExpertiseTag getWrappedModel() {
		return _expertiseTag;
	}

	@Override
	public void resetOriginalValues() {
		_expertiseTag.resetOriginalValues();
	}

	private ExpertiseTag _expertiseTag;
}