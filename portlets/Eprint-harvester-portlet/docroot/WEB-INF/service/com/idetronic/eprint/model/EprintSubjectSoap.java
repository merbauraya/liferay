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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eprint.service.http.EprintSubjectServiceSoap}.
 *
 * @author    Mazlan Mat
 * @see       com.idetronic.eprint.service.http.EprintSubjectServiceSoap
 * @generated
 */
public class EprintSubjectSoap implements Serializable {
	public static EprintSubjectSoap toSoapModel(EprintSubject model) {
		EprintSubjectSoap soapModel = new EprintSubjectSoap();

		soapModel.setEprintId(model.getEprintId());
		soapModel.setPos(model.getPos());
		soapModel.setSubjects(model.getSubjects());

		return soapModel;
	}

	public static EprintSubjectSoap[] toSoapModels(EprintSubject[] models) {
		EprintSubjectSoap[] soapModels = new EprintSubjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EprintSubjectSoap[][] toSoapModels(EprintSubject[][] models) {
		EprintSubjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EprintSubjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EprintSubjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EprintSubjectSoap[] toSoapModels(List<EprintSubject> models) {
		List<EprintSubjectSoap> soapModels = new ArrayList<EprintSubjectSoap>(models.size());

		for (EprintSubject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EprintSubjectSoap[soapModels.size()]);
	}

	public EprintSubjectSoap() {
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

	public long getPos() {
		return _pos;
	}

	public void setPos(long pos) {
		_pos = pos;
	}

	public String getSubjects() {
		return _subjects;
	}

	public void setSubjects(String subjects) {
		_subjects = subjects;
	}

	private long _eprintId;
	private long _pos;
	private String _subjects;
}