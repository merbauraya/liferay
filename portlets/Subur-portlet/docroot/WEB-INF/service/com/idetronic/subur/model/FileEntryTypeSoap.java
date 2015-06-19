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
public class FileEntryTypeSoap implements Serializable {
	public static FileEntryTypeSoap toSoapModel(FileEntryType model) {
		FileEntryTypeSoap soapModel = new FileEntryTypeSoap();

		soapModel.setTypeId(model.getTypeId());
		soapModel.setTypeName(model.getTypeName());

		return soapModel;
	}

	public static FileEntryTypeSoap[] toSoapModels(FileEntryType[] models) {
		FileEntryTypeSoap[] soapModels = new FileEntryTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FileEntryTypeSoap[][] toSoapModels(FileEntryType[][] models) {
		FileEntryTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FileEntryTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FileEntryTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FileEntryTypeSoap[] toSoapModels(List<FileEntryType> models) {
		List<FileEntryTypeSoap> soapModels = new ArrayList<FileEntryTypeSoap>(models.size());

		for (FileEntryType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FileEntryTypeSoap[soapModels.size()]);
	}

	public FileEntryTypeSoap() {
	}

	public long getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(long pk) {
		setTypeId(pk);
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public String getTypeName() {
		return _typeName;
	}

	public void setTypeName(String typeName) {
		_typeName = typeName;
	}

	private long _typeId;
	private String _typeName;
}