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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class UserExpertiseSoap implements Serializable {
	public static UserExpertiseSoap toSoapModel(UserExpertise model) {
		UserExpertiseSoap soapModel = new UserExpertiseSoap();

		soapModel.setUserExpertiseId(model.getUserExpertiseId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setExpertiseData(model.getExpertiseData());

		return soapModel;
	}

	public static UserExpertiseSoap[] toSoapModels(UserExpertise[] models) {
		UserExpertiseSoap[] soapModels = new UserExpertiseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserExpertiseSoap[][] toSoapModels(UserExpertise[][] models) {
		UserExpertiseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserExpertiseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserExpertiseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserExpertiseSoap[] toSoapModels(List<UserExpertise> models) {
		List<UserExpertiseSoap> soapModels = new ArrayList<UserExpertiseSoap>(models.size());

		for (UserExpertise model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserExpertiseSoap[soapModels.size()]);
	}

	public UserExpertiseSoap() {
	}

	public long getPrimaryKey() {
		return _userExpertiseId;
	}

	public void setPrimaryKey(long pk) {
		setUserExpertiseId(pk);
	}

	public long getUserExpertiseId() {
		return _userExpertiseId;
	}

	public void setUserExpertiseId(long userExpertiseId) {
		_userExpertiseId = userExpertiseId;
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

	public String getExpertiseData() {
		return _expertiseData;
	}

	public void setExpertiseData(String expertiseData) {
		_expertiseData = expertiseData;
	}

	private long _userExpertiseId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private String _expertiseData;
}