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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.subur.service.http.ExpertiseServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.http.ExpertiseServiceSoap
 * @generated
 */
public class ExpertiseSoap implements Serializable {
	public static ExpertiseSoap toSoapModel(Expertise model) {
		ExpertiseSoap soapModel = new ExpertiseSoap();

		soapModel.setExpertiseId(model.getExpertiseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setExpertiseName(model.getExpertiseName());
		soapModel.setIndexedName(model.getIndexedName());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAuthorCount(model.getAuthorCount());

		return soapModel;
	}

	public static ExpertiseSoap[] toSoapModels(Expertise[] models) {
		ExpertiseSoap[] soapModels = new ExpertiseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpertiseSoap[][] toSoapModels(Expertise[][] models) {
		ExpertiseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpertiseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpertiseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpertiseSoap[] toSoapModels(List<Expertise> models) {
		List<ExpertiseSoap> soapModels = new ArrayList<ExpertiseSoap>(models.size());

		for (Expertise model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpertiseSoap[soapModels.size()]);
	}

	public ExpertiseSoap() {
	}

	public long getPrimaryKey() {
		return _expertiseId;
	}

	public void setPrimaryKey(long pk) {
		setExpertiseId(pk);
	}

	public long getExpertiseId() {
		return _expertiseId;
	}

	public void setExpertiseId(long expertiseId) {
		_expertiseId = expertiseId;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getExpertiseName() {
		return _expertiseName;
	}

	public void setExpertiseName(String expertiseName) {
		_expertiseName = expertiseName;
	}

	public String getIndexedName() {
		return _indexedName;
	}

	public void setIndexedName(String indexedName) {
		_indexedName = indexedName;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getAuthorCount() {
		return _authorCount;
	}

	public void setAuthorCount(int authorCount) {
		_authorCount = authorCount;
	}

	private long _expertiseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private String _expertiseName;
	private String _indexedName;
	private Date _modifiedDate;
	private int _authorCount;
}