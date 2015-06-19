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
public class DivisionSoap implements Serializable {
	public static DivisionSoap toSoapModel(Division model) {
		DivisionSoap soapModel = new DivisionSoap();

		soapModel.setDivisionId(model.getDivisionId());
		soapModel.setParentId(model.getParentId());
		soapModel.setDivisionName(model.getDivisionName());
		soapModel.setDepositable(model.getDepositable());

		return soapModel;
	}

	public static DivisionSoap[] toSoapModels(Division[] models) {
		DivisionSoap[] soapModels = new DivisionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DivisionSoap[][] toSoapModels(Division[][] models) {
		DivisionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DivisionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DivisionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DivisionSoap[] toSoapModels(List<Division> models) {
		List<DivisionSoap> soapModels = new ArrayList<DivisionSoap>(models.size());

		for (Division model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DivisionSoap[soapModels.size()]);
	}

	public DivisionSoap() {
	}

	public long getPrimaryKey() {
		return _divisionId;
	}

	public void setPrimaryKey(long pk) {
		setDivisionId(pk);
	}

	public long getDivisionId() {
		return _divisionId;
	}

	public void setDivisionId(long divisionId) {
		_divisionId = divisionId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getDivisionName() {
		return _divisionName;
	}

	public void setDivisionName(String divisionName) {
		_divisionName = divisionName;
	}

	public boolean getDepositable() {
		return _depositable;
	}

	public boolean isDepositable() {
		return _depositable;
	}

	public void setDepositable(boolean depositable) {
		_depositable = depositable;
	}

	private long _divisionId;
	private long _parentId;
	private String _divisionName;
	private boolean _depositable;
}