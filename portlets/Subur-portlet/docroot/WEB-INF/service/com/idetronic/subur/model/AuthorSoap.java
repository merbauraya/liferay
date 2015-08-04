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
public class AuthorSoap implements Serializable {
	public static AuthorSoap toSoapModel(Author model) {
		AuthorSoap soapModel = new AuthorSoap();

		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTitle(model.getTitle());
		soapModel.setIdType(model.getIdType());
		soapModel.setRemoteId(model.getRemoteId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setUserId(model.getUserId());
		soapModel.setMetadata(model.getMetadata());
		soapModel.setLastPublishedDate(model.getLastPublishedDate());
		soapModel.setItemCount(model.getItemCount());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUuid(model.getUuid());
		soapModel.setCreatedBy(model.getCreatedBy());

		return soapModel;
	}

	public static AuthorSoap[] toSoapModels(Author[] models) {
		AuthorSoap[] soapModels = new AuthorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthorSoap[][] toSoapModels(Author[][] models) {
		AuthorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthorSoap[] toSoapModels(List<Author> models) {
		List<AuthorSoap> soapModels = new ArrayList<AuthorSoap>(models.size());

		for (Author model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthorSoap[soapModels.size()]);
	}

	public AuthorSoap() {
	}

	public long getPrimaryKey() {
		return _authorId;
	}

	public void setPrimaryKey(long pk) {
		setAuthorId(pk);
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public int getIdType() {
		return _idType;
	}

	public void setIdType(int idType) {
		_idType = idType;
	}

	public String getRemoteId() {
		return _remoteId;
	}

	public void setRemoteId(String remoteId) {
		_remoteId = remoteId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public String getMetadata() {
		return _metadata;
	}

	public void setMetadata(String metadata) {
		_metadata = metadata;
	}

	public Date getLastPublishedDate() {
		return _lastPublishedDate;
	}

	public void setLastPublishedDate(Date lastPublishedDate) {
		_lastPublishedDate = lastPublishedDate;
	}

	public int getItemCount() {
		return _itemCount;
	}

	public void setItemCount(int itemCount) {
		_itemCount = itemCount;
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

	public String getUuid() {
		return _Uuid;
	}

	public void setUuid(String Uuid) {
		_Uuid = Uuid;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	private long _authorId;
	private long _groupId;
	private long _companyId;
	private String _title;
	private int _idType;
	private String _remoteId;
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private int _userId;
	private String _metadata;
	private Date _lastPublishedDate;
	private int _itemCount;
	private Date _createDate;
	private Date _modifiedDate;
	private String _Uuid;
	private long _createdBy;
}