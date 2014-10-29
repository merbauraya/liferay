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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class ServiceExperienceSoap implements Serializable {
	public static ServiceExperienceSoap toSoapModel(ServiceExperience model) {
		ServiceExperienceSoap soapModel = new ServiceExperienceSoap();

		soapModel.setServiceExperienceId(model.getServiceExperienceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setServiceData(model.getServiceData());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ServiceExperienceSoap[] toSoapModels(
		ServiceExperience[] models) {
		ServiceExperienceSoap[] soapModels = new ServiceExperienceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceExperienceSoap[][] toSoapModels(
		ServiceExperience[][] models) {
		ServiceExperienceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceExperienceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceExperienceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceExperienceSoap[] toSoapModels(
		List<ServiceExperience> models) {
		List<ServiceExperienceSoap> soapModels = new ArrayList<ServiceExperienceSoap>(models.size());

		for (ServiceExperience model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceExperienceSoap[soapModels.size()]);
	}

	public ServiceExperienceSoap() {
	}

	public long getPrimaryKey() {
		return _serviceExperienceId;
	}

	public void setPrimaryKey(long pk) {
		setServiceExperienceId(pk);
	}

	public long getServiceExperienceId() {
		return _serviceExperienceId;
	}

	public void setServiceExperienceId(long serviceExperienceId) {
		_serviceExperienceId = serviceExperienceId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getServiceData() {
		return _serviceData;
	}

	public void setServiceData(String serviceData) {
		_serviceData = serviceData;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _serviceExperienceId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _startDate;
	private String _title;
	private Date _endDate;
	private String _serviceData;
	private int _status;
}