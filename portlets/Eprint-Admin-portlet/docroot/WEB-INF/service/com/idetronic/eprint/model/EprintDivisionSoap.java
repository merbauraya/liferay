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

import com.idetronic.eprint.service.persistence.EprintDivisionPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class EprintDivisionSoap implements Serializable {
	public static EprintDivisionSoap toSoapModel(EprintDivision model) {
		EprintDivisionSoap soapModel = new EprintDivisionSoap();

		soapModel.setEprintId(model.getEprintId());
		soapModel.setDivisionId(model.getDivisionId());
		soapModel.setDivisionName(model.getDivisionName());

		return soapModel;
	}

	public static EprintDivisionSoap[] toSoapModels(EprintDivision[] models) {
		EprintDivisionSoap[] soapModels = new EprintDivisionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EprintDivisionSoap[][] toSoapModels(EprintDivision[][] models) {
		EprintDivisionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EprintDivisionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EprintDivisionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EprintDivisionSoap[] toSoapModels(List<EprintDivision> models) {
		List<EprintDivisionSoap> soapModels = new ArrayList<EprintDivisionSoap>(models.size());

		for (EprintDivision model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EprintDivisionSoap[soapModels.size()]);
	}

	public EprintDivisionSoap() {
	}

	public EprintDivisionPK getPrimaryKey() {
		return new EprintDivisionPK(_eprintId, _divisionId);
	}

	public void setPrimaryKey(EprintDivisionPK pk) {
		setEprintId(pk.eprintId);
		setDivisionId(pk.divisionId);
	}

	public long getEprintId() {
		return _eprintId;
	}

	public void setEprintId(long eprintId) {
		_eprintId = eprintId;
	}

	public String getDivisionId() {
		return _divisionId;
	}

	public void setDivisionId(String divisionId) {
		_divisionId = divisionId;
	}

	public String getDivisionName() {
		return _divisionName;
	}

	public void setDivisionName(String divisionName) {
		_divisionName = divisionName;
	}

	private long _eprintId;
	private String _divisionId;
	private String _divisionName;
}