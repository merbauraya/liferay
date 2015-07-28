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
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class SuburItemSoap implements Serializable {
	public static SuburItemSoap toSoapModel(SuburItem model) {
		SuburItemSoap soapModel = new SuburItemSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPublishedDate(model.getPublishedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setItemAbstract(model.getItemAbstract());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setStatus(model.getStatus());
		soapModel.setUuid(model.getUuid());
		soapModel.setMetadataValue(model.getMetadataValue());

		return soapModel;
	}

	public static SuburItemSoap[] toSoapModels(SuburItem[] models) {
		SuburItemSoap[] soapModels = new SuburItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SuburItemSoap[][] toSoapModels(SuburItem[][] models) {
		SuburItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SuburItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SuburItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SuburItemSoap[] toSoapModels(List<SuburItem> models) {
		List<SuburItemSoap> soapModels = new ArrayList<SuburItemSoap>(models.size());

		for (SuburItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SuburItemSoap[soapModels.size()]);
	}

	public SuburItemSoap() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long pk) {
		setItemId(pk);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public Date getPublishedDate() {
		return _publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		_publishedDate = publishedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getItemAbstract() {
		return _itemAbstract;
	}

	public void setItemAbstract(String itemAbstract) {
		_itemAbstract = itemAbstract;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getUuid() {
		return _Uuid;
	}

	public void setUuid(String Uuid) {
		_Uuid = Uuid;
	}

	public String getMetadataValue() {
		return _metadataValue;
	}

	public void setMetadataValue(String metadataValue) {
		_metadataValue = metadataValue;
	}

	private long _itemId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishedDate;
	private String _title;
	private String _itemAbstract;
	private String _language;
	private int _status;
	private String _Uuid;
	private String _metadataValue;
}