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
 * This class is a wrapper for {@link ServiceExperience}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ServiceExperience
 * @generated
 */
public class ServiceExperienceWrapper implements ServiceExperience,
	ModelWrapper<ServiceExperience> {
	public ServiceExperienceWrapper(ServiceExperience serviceExperience) {
		_serviceExperience = serviceExperience;
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceExperience.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceExperience.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceExperienceId", getServiceExperienceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startDate", getStartDate());
		attributes.put("title", getTitle());
		attributes.put("endDate", getEndDate());
		attributes.put("serviceData", getServiceData());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceExperienceId = (Long)attributes.get("serviceExperienceId");

		if (serviceExperienceId != null) {
			setServiceExperienceId(serviceExperienceId);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String serviceData = (String)attributes.get("serviceData");

		if (serviceData != null) {
			setServiceData(serviceData);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this service experience.
	*
	* @return the primary key of this service experience
	*/
	@Override
	public long getPrimaryKey() {
		return _serviceExperience.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service experience.
	*
	* @param primaryKey the primary key of this service experience
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_serviceExperience.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the service experience ID of this service experience.
	*
	* @return the service experience ID of this service experience
	*/
	@Override
	public long getServiceExperienceId() {
		return _serviceExperience.getServiceExperienceId();
	}

	/**
	* Sets the service experience ID of this service experience.
	*
	* @param serviceExperienceId the service experience ID of this service experience
	*/
	@Override
	public void setServiceExperienceId(long serviceExperienceId) {
		_serviceExperience.setServiceExperienceId(serviceExperienceId);
	}

	/**
	* Returns the company ID of this service experience.
	*
	* @return the company ID of this service experience
	*/
	@Override
	public long getCompanyId() {
		return _serviceExperience.getCompanyId();
	}

	/**
	* Sets the company ID of this service experience.
	*
	* @param companyId the company ID of this service experience
	*/
	@Override
	public void setCompanyId(long companyId) {
		_serviceExperience.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this service experience.
	*
	* @return the user ID of this service experience
	*/
	@Override
	public long getUserId() {
		return _serviceExperience.getUserId();
	}

	/**
	* Sets the user ID of this service experience.
	*
	* @param userId the user ID of this service experience
	*/
	@Override
	public void setUserId(long userId) {
		_serviceExperience.setUserId(userId);
	}

	/**
	* Returns the user uuid of this service experience.
	*
	* @return the user uuid of this service experience
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceExperience.getUserUuid();
	}

	/**
	* Sets the user uuid of this service experience.
	*
	* @param userUuid the user uuid of this service experience
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_serviceExperience.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this service experience.
	*
	* @return the user name of this service experience
	*/
	@Override
	public java.lang.String getUserName() {
		return _serviceExperience.getUserName();
	}

	/**
	* Sets the user name of this service experience.
	*
	* @param userName the user name of this service experience
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_serviceExperience.setUserName(userName);
	}

	/**
	* Returns the create date of this service experience.
	*
	* @return the create date of this service experience
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _serviceExperience.getCreateDate();
	}

	/**
	* Sets the create date of this service experience.
	*
	* @param createDate the create date of this service experience
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_serviceExperience.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this service experience.
	*
	* @return the modified date of this service experience
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _serviceExperience.getModifiedDate();
	}

	/**
	* Sets the modified date of this service experience.
	*
	* @param modifiedDate the modified date of this service experience
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_serviceExperience.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the start date of this service experience.
	*
	* @return the start date of this service experience
	*/
	@Override
	public java.util.Date getStartDate() {
		return _serviceExperience.getStartDate();
	}

	/**
	* Sets the start date of this service experience.
	*
	* @param startDate the start date of this service experience
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_serviceExperience.setStartDate(startDate);
	}

	/**
	* Returns the title of this service experience.
	*
	* @return the title of this service experience
	*/
	@Override
	public java.lang.String getTitle() {
		return _serviceExperience.getTitle();
	}

	/**
	* Sets the title of this service experience.
	*
	* @param title the title of this service experience
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_serviceExperience.setTitle(title);
	}

	/**
	* Returns the end date of this service experience.
	*
	* @return the end date of this service experience
	*/
	@Override
	public java.util.Date getEndDate() {
		return _serviceExperience.getEndDate();
	}

	/**
	* Sets the end date of this service experience.
	*
	* @param endDate the end date of this service experience
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_serviceExperience.setEndDate(endDate);
	}

	/**
	* Returns the service data of this service experience.
	*
	* @return the service data of this service experience
	*/
	@Override
	public java.lang.String getServiceData() {
		return _serviceExperience.getServiceData();
	}

	/**
	* Sets the service data of this service experience.
	*
	* @param serviceData the service data of this service experience
	*/
	@Override
	public void setServiceData(java.lang.String serviceData) {
		_serviceExperience.setServiceData(serviceData);
	}

	/**
	* Returns the status of this service experience.
	*
	* @return the status of this service experience
	*/
	@Override
	public int getStatus() {
		return _serviceExperience.getStatus();
	}

	/**
	* Sets the status of this service experience.
	*
	* @param status the status of this service experience
	*/
	@Override
	public void setStatus(int status) {
		_serviceExperience.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _serviceExperience.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_serviceExperience.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _serviceExperience.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_serviceExperience.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _serviceExperience.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceExperience.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceExperience.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceExperience.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_serviceExperience.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_serviceExperience.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceExperience.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceExperienceWrapper((ServiceExperience)_serviceExperience.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.portlet.model.ServiceExperience serviceExperience) {
		return _serviceExperience.compareTo(serviceExperience);
	}

	@Override
	public int hashCode() {
		return _serviceExperience.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.portlet.model.ServiceExperience> toCacheModel() {
		return _serviceExperience.toCacheModel();
	}

	@Override
	public com.idetronic.portlet.model.ServiceExperience toEscapedModel() {
		return new ServiceExperienceWrapper(_serviceExperience.toEscapedModel());
	}

	@Override
	public com.idetronic.portlet.model.ServiceExperience toUnescapedModel() {
		return new ServiceExperienceWrapper(_serviceExperience.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceExperience.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _serviceExperience.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceExperience.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceExperienceWrapper)) {
			return false;
		}

		ServiceExperienceWrapper serviceExperienceWrapper = (ServiceExperienceWrapper)obj;

		if (Validator.equals(_serviceExperience,
					serviceExperienceWrapper._serviceExperience)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ServiceExperience getWrappedServiceExperience() {
		return _serviceExperience;
	}

	@Override
	public ServiceExperience getWrappedModel() {
		return _serviceExperience;
	}

	@Override
	public void resetOriginalValues() {
		_serviceExperience.resetOriginalValues();
	}

	private ServiceExperience _serviceExperience;
}