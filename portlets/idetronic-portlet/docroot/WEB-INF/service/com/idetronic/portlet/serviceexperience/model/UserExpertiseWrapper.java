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

package com.idetronic.portlet.serviceexperience.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserExpertise}.
 * </p>
 *
 * @author Mazlan Mat
 * @see UserExpertise
 * @generated
 */
public class UserExpertiseWrapper implements UserExpertise,
	ModelWrapper<UserExpertise> {
	public UserExpertiseWrapper(UserExpertise userExpertise) {
		_userExpertise = userExpertise;
	}

	@Override
	public Class<?> getModelClass() {
		return UserExpertise.class;
	}

	@Override
	public String getModelClassName() {
		return UserExpertise.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userExpertiseId", getUserExpertiseId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("expertiseData", getExpertiseData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userExpertiseId = (Long)attributes.get("userExpertiseId");

		if (userExpertiseId != null) {
			setUserExpertiseId(userExpertiseId);
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

		String expertiseData = (String)attributes.get("expertiseData");

		if (expertiseData != null) {
			setExpertiseData(expertiseData);
		}
	}

	/**
	* Returns the primary key of this user expertise.
	*
	* @return the primary key of this user expertise
	*/
	@Override
	public long getPrimaryKey() {
		return _userExpertise.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user expertise.
	*
	* @param primaryKey the primary key of this user expertise
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userExpertise.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user expertise ID of this user expertise.
	*
	* @return the user expertise ID of this user expertise
	*/
	@Override
	public long getUserExpertiseId() {
		return _userExpertise.getUserExpertiseId();
	}

	/**
	* Sets the user expertise ID of this user expertise.
	*
	* @param userExpertiseId the user expertise ID of this user expertise
	*/
	@Override
	public void setUserExpertiseId(long userExpertiseId) {
		_userExpertise.setUserExpertiseId(userExpertiseId);
	}

	/**
	* Returns the company ID of this user expertise.
	*
	* @return the company ID of this user expertise
	*/
	@Override
	public long getCompanyId() {
		return _userExpertise.getCompanyId();
	}

	/**
	* Sets the company ID of this user expertise.
	*
	* @param companyId the company ID of this user expertise
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userExpertise.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this user expertise.
	*
	* @return the user ID of this user expertise
	*/
	@Override
	public long getUserId() {
		return _userExpertise.getUserId();
	}

	/**
	* Sets the user ID of this user expertise.
	*
	* @param userId the user ID of this user expertise
	*/
	@Override
	public void setUserId(long userId) {
		_userExpertise.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user expertise.
	*
	* @return the user uuid of this user expertise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userExpertise.getUserUuid();
	}

	/**
	* Sets the user uuid of this user expertise.
	*
	* @param userUuid the user uuid of this user expertise
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userExpertise.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this user expertise.
	*
	* @return the user name of this user expertise
	*/
	@Override
	public java.lang.String getUserName() {
		return _userExpertise.getUserName();
	}

	/**
	* Sets the user name of this user expertise.
	*
	* @param userName the user name of this user expertise
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_userExpertise.setUserName(userName);
	}

	/**
	* Returns the expertise data of this user expertise.
	*
	* @return the expertise data of this user expertise
	*/
	@Override
	public java.lang.String getExpertiseData() {
		return _userExpertise.getExpertiseData();
	}

	/**
	* Sets the expertise data of this user expertise.
	*
	* @param expertiseData the expertise data of this user expertise
	*/
	@Override
	public void setExpertiseData(java.lang.String expertiseData) {
		_userExpertise.setExpertiseData(expertiseData);
	}

	@Override
	public boolean isNew() {
		return _userExpertise.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userExpertise.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userExpertise.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userExpertise.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userExpertise.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userExpertise.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userExpertise.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userExpertise.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userExpertise.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userExpertise.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userExpertise.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserExpertiseWrapper((UserExpertise)_userExpertise.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.portlet.serviceexperience.model.UserExpertise userExpertise) {
		return _userExpertise.compareTo(userExpertise);
	}

	@Override
	public int hashCode() {
		return _userExpertise.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.portlet.serviceexperience.model.UserExpertise> toCacheModel() {
		return _userExpertise.toCacheModel();
	}

	@Override
	public com.idetronic.portlet.serviceexperience.model.UserExpertise toEscapedModel() {
		return new UserExpertiseWrapper(_userExpertise.toEscapedModel());
	}

	@Override
	public com.idetronic.portlet.serviceexperience.model.UserExpertise toUnescapedModel() {
		return new UserExpertiseWrapper(_userExpertise.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userExpertise.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userExpertise.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userExpertise.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserExpertiseWrapper)) {
			return false;
		}

		UserExpertiseWrapper userExpertiseWrapper = (UserExpertiseWrapper)obj;

		if (Validator.equals(_userExpertise, userExpertiseWrapper._userExpertise)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserExpertise getWrappedUserExpertise() {
		return _userExpertise;
	}

	@Override
	public UserExpertise getWrappedModel() {
		return _userExpertise;
	}

	@Override
	public void resetOriginalValues() {
		_userExpertise.resetOriginalValues();
	}

	private UserExpertise _userExpertise;
}