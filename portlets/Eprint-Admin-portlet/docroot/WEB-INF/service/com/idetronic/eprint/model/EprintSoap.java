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

package com.idetronic.eprint.model;

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
public class EprintSoap implements Serializable {
	public static EprintSoap toSoapModel(Eprint model) {
		EprintSoap soapModel = new EprintSoap();

		soapModel.setEprintId(model.getEprintId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTitle(model.getTitle());
		soapModel.setUrlTitle(model.getUrlTitle());
		soapModel.setEprintType(model.getEprintType());
		soapModel.setEprintStatus(model.getEprintStatus());
		soapModel.setMetadataVisibility(model.getMetadataVisibility());
		soapModel.setEprintAbstract(model.getEprintAbstract());
		soapModel.setEprintKeywords(model.getEprintKeywords());
		soapModel.setIsPublished(model.getIsPublished());
		soapModel.setDateYear(model.getDateYear());
		soapModel.setFullTextStatus(model.getFullTextStatus());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static EprintSoap[] toSoapModels(Eprint[] models) {
		EprintSoap[] soapModels = new EprintSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EprintSoap[][] toSoapModels(Eprint[][] models) {
		EprintSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EprintSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EprintSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EprintSoap[] toSoapModels(List<Eprint> models) {
		List<EprintSoap> soapModels = new ArrayList<EprintSoap>(models.size());

		for (Eprint model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EprintSoap[soapModels.size()]);
	}

	public EprintSoap() {
	}

	public long getPrimaryKey() {
		return _eprintId;
	}

	public void setPrimaryKey(long pk) {
		setEprintId(pk);
	}

	public long getEprintId() {
		return _eprintId;
	}

	public void setEprintId(long eprintId) {
		_eprintId = eprintId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getUrlTitle() {
		return _urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	public String getEprintType() {
		return _eprintType;
	}

	public void setEprintType(String eprintType) {
		_eprintType = eprintType;
	}

	public String getEprintStatus() {
		return _eprintStatus;
	}

	public void setEprintStatus(String eprintStatus) {
		_eprintStatus = eprintStatus;
	}

	public String getMetadataVisibility() {
		return _metadataVisibility;
	}

	public void setMetadataVisibility(String metadataVisibility) {
		_metadataVisibility = metadataVisibility;
	}

	public String getEprintAbstract() {
		return _eprintAbstract;
	}

	public void setEprintAbstract(String eprintAbstract) {
		_eprintAbstract = eprintAbstract;
	}

	public String getEprintKeywords() {
		return _eprintKeywords;
	}

	public void setEprintKeywords(String eprintKeywords) {
		_eprintKeywords = eprintKeywords;
	}

	public String getIsPublished() {
		return _isPublished;
	}

	public void setIsPublished(String isPublished) {
		_isPublished = isPublished;
	}

	public String getDateYear() {
		return _dateYear;
	}

	public void setDateYear(String dateYear) {
		_dateYear = dateYear;
	}

	public String getFullTextStatus() {
		return _fullTextStatus;
	}

	public void setFullTextStatus(String fullTextStatus) {
		_fullTextStatus = fullTextStatus;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _eprintId;
	private long _groupId;
	private long _userId;
	private String _title;
	private String _urlTitle;
	private String _eprintType;
	private String _eprintStatus;
	private String _metadataVisibility;
	private String _eprintAbstract;
	private String _eprintKeywords;
	private String _isPublished;
	private String _dateYear;
	private String _fullTextStatus;
	private long _companyId;
	private Date _modifiedDate;
	private Date _createdDate;
}