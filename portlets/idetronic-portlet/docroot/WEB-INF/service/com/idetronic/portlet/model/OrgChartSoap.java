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

import com.idetronic.portlet.service.persistence.OrgChartPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class OrgChartSoap implements Serializable {
	public static OrgChartSoap toSoapModel(OrgChart model) {
		OrgChartSoap soapModel = new OrgChartSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setParentId(model.getParentId());

		return soapModel;
	}

	public static OrgChartSoap[] toSoapModels(OrgChart[] models) {
		OrgChartSoap[] soapModels = new OrgChartSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgChartSoap[][] toSoapModels(OrgChart[][] models) {
		OrgChartSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgChartSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgChartSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgChartSoap[] toSoapModels(List<OrgChart> models) {
		List<OrgChartSoap> soapModels = new ArrayList<OrgChartSoap>(models.size());

		for (OrgChart model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgChartSoap[soapModels.size()]);
	}

	public OrgChartSoap() {
	}

	public OrgChartPK getPrimaryKey() {
		return new OrgChartPK(_userId, _parentId);
	}

	public void setPrimaryKey(OrgChartPK pk) {
		setUserId(pk.userId);
		setParentId(pk.parentId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	private long _userId;
	private long _parentId;
}