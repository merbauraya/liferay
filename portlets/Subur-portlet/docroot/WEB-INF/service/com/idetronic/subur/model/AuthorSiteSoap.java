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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class AuthorSiteSoap implements Serializable {
	public static AuthorSiteSoap toSoapModel(AuthorSite model) {
		AuthorSiteSoap soapModel = new AuthorSiteSoap();

		soapModel.setAuthorSiteId(model.getAuthorSiteId());
		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setSiteName(model.getSiteName());
		soapModel.setSiteURL(model.getSiteURL());

		return soapModel;
	}

	public static AuthorSiteSoap[] toSoapModels(AuthorSite[] models) {
		AuthorSiteSoap[] soapModels = new AuthorSiteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthorSiteSoap[][] toSoapModels(AuthorSite[][] models) {
		AuthorSiteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthorSiteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthorSiteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthorSiteSoap[] toSoapModels(List<AuthorSite> models) {
		List<AuthorSiteSoap> soapModels = new ArrayList<AuthorSiteSoap>(models.size());

		for (AuthorSite model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthorSiteSoap[soapModels.size()]);
	}

	public AuthorSiteSoap() {
	}

	public long getPrimaryKey() {
		return _authorSiteId;
	}

	public void setPrimaryKey(long pk) {
		setAuthorSiteId(pk);
	}

	public long getAuthorSiteId() {
		return _authorSiteId;
	}

	public void setAuthorSiteId(long authorSiteId) {
		_authorSiteId = authorSiteId;
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	public String getSiteName() {
		return _siteName;
	}

	public void setSiteName(String siteName) {
		_siteName = siteName;
	}

	public String getSiteURL() {
		return _siteURL;
	}

	public void setSiteURL(String siteURL) {
		_siteURL = siteURL;
	}

	private long _authorSiteId;
	private long _authorId;
	private String _siteName;
	private String _siteURL;
}