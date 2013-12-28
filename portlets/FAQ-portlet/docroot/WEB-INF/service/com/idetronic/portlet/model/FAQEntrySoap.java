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
 * @author    Mazlan Mat
 * @generated
 */
public class FAQEntrySoap implements Serializable {
	public static FAQEntrySoap toSoapModel(FAQEntry model) {
		FAQEntrySoap soapModel = new FAQEntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setQuestion(model.getQuestion());
		soapModel.setCategory(model.getCategory());
		soapModel.setAnswer(model.getAnswer());
		soapModel.setIsactive(model.getIsactive());
		soapModel.setDisplayOrder(model.getDisplayOrder());

		return soapModel;
	}

	public static FAQEntrySoap[] toSoapModels(FAQEntry[] models) {
		FAQEntrySoap[] soapModels = new FAQEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FAQEntrySoap[][] toSoapModels(FAQEntry[][] models) {
		FAQEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FAQEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FAQEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FAQEntrySoap[] toSoapModels(List<FAQEntry> models) {
		List<FAQEntrySoap> soapModels = new ArrayList<FAQEntrySoap>(models.size());

		for (FAQEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FAQEntrySoap[soapModels.size()]);
	}

	public FAQEntrySoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
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

	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		_question = question;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getAnswer() {
		return _answer;
	}

	public void setAnswer(String answer) {
		_answer = answer;
	}

	public Boolean getIsactive() {
		return _isactive;
	}

	public void setIsactive(Boolean isactive) {
		_isactive = isactive;
	}

	public long getDisplayOrder() {
		return _displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;
	}

	private long _entryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _question;
	private String _category;
	private String _answer;
	private Boolean _isactive;
	private long _displayOrder;
}