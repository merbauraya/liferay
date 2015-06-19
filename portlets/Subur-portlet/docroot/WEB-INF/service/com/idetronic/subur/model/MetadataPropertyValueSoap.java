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
public class MetadataPropertyValueSoap implements Serializable {
	public static MetadataPropertyValueSoap toSoapModel(
		MetadataPropertyValue model) {
		MetadataPropertyValueSoap soapModel = new MetadataPropertyValueSoap();

		soapModel.setMetadataPropertyValueId(model.getMetadataPropertyValueId());
		soapModel.setItemId(model.getItemId());
		soapModel.setPropertyId(model.getPropertyId());
		soapModel.setTextValue(model.getTextValue());
		soapModel.setItemCount(model.getItemCount());

		return soapModel;
	}

	public static MetadataPropertyValueSoap[] toSoapModels(
		MetadataPropertyValue[] models) {
		MetadataPropertyValueSoap[] soapModels = new MetadataPropertyValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetadataPropertyValueSoap[][] toSoapModels(
		MetadataPropertyValue[][] models) {
		MetadataPropertyValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetadataPropertyValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetadataPropertyValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetadataPropertyValueSoap[] toSoapModels(
		List<MetadataPropertyValue> models) {
		List<MetadataPropertyValueSoap> soapModels = new ArrayList<MetadataPropertyValueSoap>(models.size());

		for (MetadataPropertyValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetadataPropertyValueSoap[soapModels.size()]);
	}

	public MetadataPropertyValueSoap() {
	}

	public long getPrimaryKey() {
		return _metadataPropertyValueId;
	}

	public void setPrimaryKey(long pk) {
		setMetadataPropertyValueId(pk);
	}

	public long getMetadataPropertyValueId() {
		return _metadataPropertyValueId;
	}

	public void setMetadataPropertyValueId(long metadataPropertyValueId) {
		_metadataPropertyValueId = metadataPropertyValueId;
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

	public int getItemCount() {
		return _itemCount;
	}

	public void setItemCount(int itemCount) {
		_itemCount = itemCount;
	}

	private long _metadataPropertyValueId;
	private long _itemId;
	private long _propertyId;
	private String _textValue;
	private int _itemCount;
}