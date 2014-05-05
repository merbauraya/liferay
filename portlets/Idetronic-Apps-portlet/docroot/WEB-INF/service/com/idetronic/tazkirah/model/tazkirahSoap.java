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

package com.idetronic.tazkirah.model;

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
public class tazkirahSoap implements Serializable {
	public static tazkirahSoap toSoapModel(tazkirah model) {
		tazkirahSoap soapModel = new tazkirahSoap();

		soapModel.setTazkirahId(model.getTazkirahId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setContext(model.getContext());
		soapModel.setCategory(model.getCategory());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static tazkirahSoap[] toSoapModels(tazkirah[] models) {
		tazkirahSoap[] soapModels = new tazkirahSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static tazkirahSoap[][] toSoapModels(tazkirah[][] models) {
		tazkirahSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new tazkirahSoap[models.length][models[0].length];
		}
		else {
			soapModels = new tazkirahSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static tazkirahSoap[] toSoapModels(List<tazkirah> models) {
		List<tazkirahSoap> soapModels = new ArrayList<tazkirahSoap>(models.size());

		for (tazkirah model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new tazkirahSoap[soapModels.size()]);
	}

	public tazkirahSoap() {
	}

	public long getPrimaryKey() {
		return _tazkirahId;
	}

	public void setPrimaryKey(long pk) {
		setTazkirahId(pk);
	}

	public long getTazkirahId() {
		return _tazkirahId;
	}

	public void setTazkirahId(long tazkirahId) {
		_tazkirahId = tazkirahId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContext() {
		return _context;
	}

	public void setContext(String context) {
		_context = context;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _tazkirahId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _context;
	private String _category;
	private int _status;
}