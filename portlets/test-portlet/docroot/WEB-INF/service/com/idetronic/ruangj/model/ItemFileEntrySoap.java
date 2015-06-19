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

package com.idetronic.ruangj.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.ruangj.service.http.ItemFileEntryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.ruangj.service.http.ItemFileEntryServiceSoap
 * @generated
 */
public class ItemFileEntrySoap implements Serializable {
	public static ItemFileEntrySoap toSoapModel(ItemFileEntry model) {
		ItemFileEntrySoap soapModel = new ItemFileEntrySoap();

		soapModel.setItemEntryId(model.getItemEntryId());
		soapModel.setItemId(model.getItemId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setFileType(model.getFileType());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ItemFileEntrySoap[] toSoapModels(ItemFileEntry[] models) {
		ItemFileEntrySoap[] soapModels = new ItemFileEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemFileEntrySoap[][] toSoapModels(ItemFileEntry[][] models) {
		ItemFileEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemFileEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemFileEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemFileEntrySoap[] toSoapModels(List<ItemFileEntry> models) {
		List<ItemFileEntrySoap> soapModels = new ArrayList<ItemFileEntrySoap>(models.size());

		for (ItemFileEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemFileEntrySoap[soapModels.size()]);
	}

	public ItemFileEntrySoap() {
	}

	public long getPrimaryKey() {
		return _itemEntryId;
	}

	public void setPrimaryKey(long pk) {
		setItemEntryId(pk);
	}

	public long getItemEntryId() {
		return _itemEntryId;
	}

	public void setItemEntryId(long itemEntryId) {
		_itemEntryId = itemEntryId;
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getFileType() {
		return _fileType;
	}

	public void setFileType(String fileType) {
		_fileType = fileType;
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

	private long _itemEntryId;
	private long _itemId;
	private long _fileEntryId;
	private String _fileType;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}