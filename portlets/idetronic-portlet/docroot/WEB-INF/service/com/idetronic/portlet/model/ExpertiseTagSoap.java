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
public class ExpertiseTagSoap implements Serializable {
	public static ExpertiseTagSoap toSoapModel(ExpertiseTag model) {
		ExpertiseTagSoap soapModel = new ExpertiseTagSoap();

		soapModel.setTagId(model.getTagId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTagName(model.getTagName());
		soapModel.setUserCount(model.getUserCount());

		return soapModel;
	}

	public static ExpertiseTagSoap[] toSoapModels(ExpertiseTag[] models) {
		ExpertiseTagSoap[] soapModels = new ExpertiseTagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpertiseTagSoap[][] toSoapModels(ExpertiseTag[][] models) {
		ExpertiseTagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpertiseTagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpertiseTagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpertiseTagSoap[] toSoapModels(List<ExpertiseTag> models) {
		List<ExpertiseTagSoap> soapModels = new ArrayList<ExpertiseTagSoap>(models.size());

		for (ExpertiseTag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpertiseTagSoap[soapModels.size()]);
	}

	public ExpertiseTagSoap() {
	}

	public long getPrimaryKey() {
		return _tagId;
	}

	public void setPrimaryKey(long pk) {
		setTagId(pk);
	}

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getTagName() {
		return _tagName;
	}

	public void setTagName(String tagName) {
		_tagName = tagName;
	}

	public int getUserCount() {
		return _userCount;
	}

	public void setUserCount(int userCount) {
		_userCount = userCount;
	}

	private long _tagId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tagName;
	private int _userCount;
}