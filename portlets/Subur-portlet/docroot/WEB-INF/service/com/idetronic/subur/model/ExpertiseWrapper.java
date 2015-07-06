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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Expertise}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Expertise
 * @generated
 */
public class ExpertiseWrapper implements Expertise, ModelWrapper<Expertise> {
	public ExpertiseWrapper(Expertise expertise) {
		_expertise = expertise;
	}

	@Override
	public Class<?> getModelClass() {
		return Expertise.class;
	}

	@Override
	public String getModelClassName() {
		return Expertise.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expertiseId", getExpertiseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("expertiseName", getExpertiseName());
		attributes.put("indexedName", getIndexedName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("authorCount", getAuthorCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expertiseId = (Long)attributes.get("expertiseId");

		if (expertiseId != null) {
			setExpertiseId(expertiseId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String expertiseName = (String)attributes.get("expertiseName");

		if (expertiseName != null) {
			setExpertiseName(expertiseName);
		}

		String indexedName = (String)attributes.get("indexedName");

		if (indexedName != null) {
			setIndexedName(indexedName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer authorCount = (Integer)attributes.get("authorCount");

		if (authorCount != null) {
			setAuthorCount(authorCount);
		}
	}

	/**
	* Returns the primary key of this expertise.
	*
	* @return the primary key of this expertise
	*/
	@Override
	public long getPrimaryKey() {
		return _expertise.getPrimaryKey();
	}

	/**
	* Sets the primary key of this expertise.
	*
	* @param primaryKey the primary key of this expertise
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expertise.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the expertise ID of this expertise.
	*
	* @return the expertise ID of this expertise
	*/
	@Override
	public long getExpertiseId() {
		return _expertise.getExpertiseId();
	}

	/**
	* Sets the expertise ID of this expertise.
	*
	* @param expertiseId the expertise ID of this expertise
	*/
	@Override
	public void setExpertiseId(long expertiseId) {
		_expertise.setExpertiseId(expertiseId);
	}

	/**
	* Returns the group ID of this expertise.
	*
	* @return the group ID of this expertise
	*/
	@Override
	public long getGroupId() {
		return _expertise.getGroupId();
	}

	/**
	* Sets the group ID of this expertise.
	*
	* @param groupId the group ID of this expertise
	*/
	@Override
	public void setGroupId(long groupId) {
		_expertise.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this expertise.
	*
	* @return the company ID of this expertise
	*/
	@Override
	public long getCompanyId() {
		return _expertise.getCompanyId();
	}

	/**
	* Sets the company ID of this expertise.
	*
	* @param companyId the company ID of this expertise
	*/
	@Override
	public void setCompanyId(long companyId) {
		_expertise.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this expertise.
	*
	* @return the user ID of this expertise
	*/
	@Override
	public long getUserId() {
		return _expertise.getUserId();
	}

	/**
	* Sets the user ID of this expertise.
	*
	* @param userId the user ID of this expertise
	*/
	@Override
	public void setUserId(long userId) {
		_expertise.setUserId(userId);
	}

	/**
	* Returns the user uuid of this expertise.
	*
	* @return the user uuid of this expertise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expertise.getUserUuid();
	}

	/**
	* Sets the user uuid of this expertise.
	*
	* @param userUuid the user uuid of this expertise
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_expertise.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this expertise.
	*
	* @return the create date of this expertise
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _expertise.getCreateDate();
	}

	/**
	* Sets the create date of this expertise.
	*
	* @param createDate the create date of this expertise
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_expertise.setCreateDate(createDate);
	}

	/**
	* Returns the expertise name of this expertise.
	*
	* @return the expertise name of this expertise
	*/
	@Override
	public java.lang.String getExpertiseName() {
		return _expertise.getExpertiseName();
	}

	/**
	* Sets the expertise name of this expertise.
	*
	* @param expertiseName the expertise name of this expertise
	*/
	@Override
	public void setExpertiseName(java.lang.String expertiseName) {
		_expertise.setExpertiseName(expertiseName);
	}

	/**
	* Returns the indexed name of this expertise.
	*
	* @return the indexed name of this expertise
	*/
	@Override
	public java.lang.String getIndexedName() {
		return _expertise.getIndexedName();
	}

	/**
	* Sets the indexed name of this expertise.
	*
	* @param indexedName the indexed name of this expertise
	*/
	@Override
	public void setIndexedName(java.lang.String indexedName) {
		_expertise.setIndexedName(indexedName);
	}

	/**
	* Returns the modified date of this expertise.
	*
	* @return the modified date of this expertise
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _expertise.getModifiedDate();
	}

	/**
	* Sets the modified date of this expertise.
	*
	* @param modifiedDate the modified date of this expertise
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_expertise.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the author count of this expertise.
	*
	* @return the author count of this expertise
	*/
	@Override
	public int getAuthorCount() {
		return _expertise.getAuthorCount();
	}

	/**
	* Sets the author count of this expertise.
	*
	* @param authorCount the author count of this expertise
	*/
	@Override
	public void setAuthorCount(int authorCount) {
		_expertise.setAuthorCount(authorCount);
	}

	@Override
	public boolean isNew() {
		return _expertise.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_expertise.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _expertise.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expertise.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _expertise.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _expertise.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_expertise.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _expertise.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_expertise.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_expertise.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_expertise.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExpertiseWrapper((Expertise)_expertise.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.Expertise expertise) {
		return _expertise.compareTo(expertise);
	}

	@Override
	public int hashCode() {
		return _expertise.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.Expertise> toCacheModel() {
		return _expertise.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.Expertise toEscapedModel() {
		return new ExpertiseWrapper(_expertise.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.Expertise toUnescapedModel() {
		return new ExpertiseWrapper(_expertise.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _expertise.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _expertise.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_expertise.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpertiseWrapper)) {
			return false;
		}

		ExpertiseWrapper expertiseWrapper = (ExpertiseWrapper)obj;

		if (Validator.equals(_expertise, expertiseWrapper._expertise)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Expertise getWrappedExpertise() {
		return _expertise;
	}

	@Override
	public Expertise getWrappedModel() {
		return _expertise;
	}

	@Override
	public void resetOriginalValues() {
		_expertise.resetOriginalValues();
	}

	private Expertise _expertise;
}