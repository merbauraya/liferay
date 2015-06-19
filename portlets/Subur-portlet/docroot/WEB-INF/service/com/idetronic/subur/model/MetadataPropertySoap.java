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
public class MetadataPropertySoap implements Serializable {
	public static MetadataPropertySoap toSoapModel(MetadataProperty model) {
		MetadataPropertySoap soapModel = new MetadataPropertySoap();

		soapModel.setMetadataPropertyId(model.getMetadataPropertyId());
		soapModel.setMetadataSchemaId(model.getMetadataSchemaId());
		soapModel.setElement(model.getElement());
		soapModel.setScope(model.getScope());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static MetadataPropertySoap[] toSoapModels(MetadataProperty[] models) {
		MetadataPropertySoap[] soapModels = new MetadataPropertySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetadataPropertySoap[][] toSoapModels(
		MetadataProperty[][] models) {
		MetadataPropertySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetadataPropertySoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetadataPropertySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetadataPropertySoap[] toSoapModels(
		List<MetadataProperty> models) {
		List<MetadataPropertySoap> soapModels = new ArrayList<MetadataPropertySoap>(models.size());

		for (MetadataProperty model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetadataPropertySoap[soapModels.size()]);
	}

	public MetadataPropertySoap() {
	}

	public long getPrimaryKey() {
		return _metadataPropertyId;
	}

	public void setPrimaryKey(long pk) {
		setMetadataPropertyId(pk);
	}

	public long getMetadataPropertyId() {
		return _metadataPropertyId;
	}

	public void setMetadataPropertyId(long metadataPropertyId) {
		_metadataPropertyId = metadataPropertyId;
	}

	public long getMetadataSchemaId() {
		return _metadataSchemaId;
	}

	public void setMetadataSchemaId(long metadataSchemaId) {
		_metadataSchemaId = metadataSchemaId;
	}

	public String getElement() {
		return _element;
	}

	public void setElement(String element) {
		_element = element;
	}

	public String getScope() {
		return _scope;
	}

	public void setScope(String scope) {
		_scope = scope;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _metadataPropertyId;
	private long _metadataSchemaId;
	private String _element;
	private String _scope;
	private String _note;
}