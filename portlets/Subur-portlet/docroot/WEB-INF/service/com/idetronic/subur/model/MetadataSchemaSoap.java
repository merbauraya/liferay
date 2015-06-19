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
public class MetadataSchemaSoap implements Serializable {
	public static MetadataSchemaSoap toSoapModel(MetadataSchema model) {
		MetadataSchemaSoap soapModel = new MetadataSchemaSoap();

		soapModel.setMetadataSchemaId(model.getMetadataSchemaId());
		soapModel.setMetadataName(model.getMetadataName());
		soapModel.setNameSpace(model.getNameSpace());

		return soapModel;
	}

	public static MetadataSchemaSoap[] toSoapModels(MetadataSchema[] models) {
		MetadataSchemaSoap[] soapModels = new MetadataSchemaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetadataSchemaSoap[][] toSoapModels(MetadataSchema[][] models) {
		MetadataSchemaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetadataSchemaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetadataSchemaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetadataSchemaSoap[] toSoapModels(List<MetadataSchema> models) {
		List<MetadataSchemaSoap> soapModels = new ArrayList<MetadataSchemaSoap>(models.size());

		for (MetadataSchema model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetadataSchemaSoap[soapModels.size()]);
	}

	public MetadataSchemaSoap() {
	}

	public long getPrimaryKey() {
		return _metadataSchemaId;
	}

	public void setPrimaryKey(long pk) {
		setMetadataSchemaId(pk);
	}

	public long getMetadataSchemaId() {
		return _metadataSchemaId;
	}

	public void setMetadataSchemaId(long metadataSchemaId) {
		_metadataSchemaId = metadataSchemaId;
	}

	public String getMetadataName() {
		return _metadataName;
	}

	public void setMetadataName(String metadataName) {
		_metadataName = metadataName;
	}

	public String getNameSpace() {
		return _nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		_nameSpace = nameSpace;
	}

	private long _metadataSchemaId;
	private String _metadataName;
	private String _nameSpace;
}