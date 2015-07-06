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

import com.idetronic.subur.service.persistence.AuthorExpertisePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class AuthorExpertiseSoap implements Serializable {
	public static AuthorExpertiseSoap toSoapModel(AuthorExpertise model) {
		AuthorExpertiseSoap soapModel = new AuthorExpertiseSoap();

		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setExpertiseId(model.getExpertiseId());

		return soapModel;
	}

	public static AuthorExpertiseSoap[] toSoapModels(AuthorExpertise[] models) {
		AuthorExpertiseSoap[] soapModels = new AuthorExpertiseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthorExpertiseSoap[][] toSoapModels(
		AuthorExpertise[][] models) {
		AuthorExpertiseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthorExpertiseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthorExpertiseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthorExpertiseSoap[] toSoapModels(
		List<AuthorExpertise> models) {
		List<AuthorExpertiseSoap> soapModels = new ArrayList<AuthorExpertiseSoap>(models.size());

		for (AuthorExpertise model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthorExpertiseSoap[soapModels.size()]);
	}

	public AuthorExpertiseSoap() {
	}

	public AuthorExpertisePK getPrimaryKey() {
		return new AuthorExpertisePK(_authorId, _expertiseId);
	}

	public void setPrimaryKey(AuthorExpertisePK pk) {
		setAuthorId(pk.authorId);
		setExpertiseId(pk.expertiseId);
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	public long getExpertiseId() {
		return _expertiseId;
	}

	public void setExpertiseId(long expertiseId) {
		_expertiseId = expertiseId;
	}

	private long _authorId;
	private long _expertiseId;
}