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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UserExpertise service. Represents a row in the &quot;ide_UserExpertise&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.portlet.serviceexperience.model.impl.UserExpertiseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.portlet.serviceexperience.model.impl.UserExpertiseImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see UserExpertise
 * @see com.idetronic.portlet.serviceexperience.model.impl.UserExpertiseImpl
 * @see com.idetronic.portlet.serviceexperience.model.impl.UserExpertiseModelImpl
 * @generated
 */
public interface UserExpertiseModel extends BaseModel<UserExpertise> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user expertise model instance should use the {@link UserExpertise} interface instead.
	 */

	/**
	 * Returns the primary key of this user expertise.
	 *
	 * @return the primary key of this user expertise
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user expertise.
	 *
	 * @param primaryKey the primary key of this user expertise
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user expertise ID of this user expertise.
	 *
	 * @return the user expertise ID of this user expertise
	 */
	public long getUserExpertiseId();

	/**
	 * Sets the user expertise ID of this user expertise.
	 *
	 * @param userExpertiseId the user expertise ID of this user expertise
	 */
	public void setUserExpertiseId(long userExpertiseId);

	/**
	 * Returns the company ID of this user expertise.
	 *
	 * @return the company ID of this user expertise
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this user expertise.
	 *
	 * @param companyId the company ID of this user expertise
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this user expertise.
	 *
	 * @return the user ID of this user expertise
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this user expertise.
	 *
	 * @param userId the user ID of this user expertise
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this user expertise.
	 *
	 * @return the user uuid of this user expertise
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this user expertise.
	 *
	 * @param userUuid the user uuid of this user expertise
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this user expertise.
	 *
	 * @return the user name of this user expertise
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this user expertise.
	 *
	 * @param userName the user name of this user expertise
	 */
	public void setUserName(String userName);

	/**
	 * Returns the expertise data of this user expertise.
	 *
	 * @return the expertise data of this user expertise
	 */
	@AutoEscape
	public String getExpertiseData();

	/**
	 * Sets the expertise data of this user expertise.
	 *
	 * @param expertiseData the expertise data of this user expertise
	 */
	public void setExpertiseData(String expertiseData);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(UserExpertise userExpertise);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UserExpertise> toCacheModel();

	@Override
	public UserExpertise toEscapedModel();

	@Override
	public UserExpertise toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}