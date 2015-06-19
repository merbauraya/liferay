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
public class MetadataValueSoap implements Serializable {
	public static MetadataValueSoap toSoapModel(MetadataValue model) {
		MetadataValueSoap soapModel = new MetadataValueSoap();

		soapModel.setMetadataValueId(model.getMetadataValueId());
		soapModel.setItemId(model.getItemId());
		soapModel.setPropertyId(model.getPropertyId());
		soapModel.setTextValue(model.getTextValue());

		return soapModel;
	}

	public static MetadataValueSoap[] toSoapModels(MetadataValue[] models) {
		MetadataValueSoap[] soapModels = new MetadataValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetadataValueSoap[][] toSoapModels(MetadataValue[][] models) {
		MetadataValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetadataValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetadataValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetadataValueSoap[] toSoapModels(List<MetadataValue> models) {
		List<MetadataValueSoap> soapModels = new ArrayList<MetadataValueSoap>(models.size());

		for (MetadataValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetadataValueSoap[soapModels.size()]);
	}

	public MetadataValueSoap() {
	}

	public long getPrimaryKey() {
		return _metadataValueId;
	}

	public void setPrimaryKey(long pk) {
		setMetadataValueId(pk);
	}

	public long getMetadataValueId() {
		return _metadataValueId;
	}

	public void setMetadataValueId(long metadataValueId) {
		_metadataValueId = metadataValueId;
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getPropertyId() {
		return _propertyId;
	}

	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;
	}

	public String getTextValue() {
		return _textValue;
	}

	public void setTextValue(String textValue) {
		_textValue = textValue;
	}

	private long _metadataValueId;
	private long _itemId;
	private long _propertyId;
	private String _textValue;
}