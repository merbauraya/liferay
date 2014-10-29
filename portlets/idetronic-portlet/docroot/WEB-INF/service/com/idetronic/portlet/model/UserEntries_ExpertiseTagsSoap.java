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

import com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class UserEntries_ExpertiseTagsSoap implements Serializable {
	public static UserEntries_ExpertiseTagsSoap toSoapModel(
		UserEntries_ExpertiseTags model) {
		UserEntries_ExpertiseTagsSoap soapModel = new UserEntries_ExpertiseTagsSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setTagId(model.getTagId());

		return soapModel;
	}

	public static UserEntries_ExpertiseTagsSoap[] toSoapModels(
		UserEntries_ExpertiseTags[] models) {
		UserEntries_ExpertiseTagsSoap[] soapModels = new UserEntries_ExpertiseTagsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserEntries_ExpertiseTagsSoap[][] toSoapModels(
		UserEntries_ExpertiseTags[][] models) {
		UserEntries_ExpertiseTagsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserEntries_ExpertiseTagsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserEntries_ExpertiseTagsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserEntries_ExpertiseTagsSoap[] toSoapModels(
		List<UserEntries_ExpertiseTags> models) {
		List<UserEntries_ExpertiseTagsSoap> soapModels = new ArrayList<UserEntries_ExpertiseTagsSoap>(models.size());

		for (UserEntries_ExpertiseTags model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserEntries_ExpertiseTagsSoap[soapModels.size()]);
	}

	public UserEntries_ExpertiseTagsSoap() {
	}

	public UserEntries_ExpertiseTagsPK getPrimaryKey() {
		return new UserEntries_ExpertiseTagsPK(_userId, _tagId);
	}

	public void setPrimaryKey(UserEntries_ExpertiseTagsPK pk) {
		setUserId(pk.userId);
		setTagId(pk.tagId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	private long _userId;
	private long _tagId;
}