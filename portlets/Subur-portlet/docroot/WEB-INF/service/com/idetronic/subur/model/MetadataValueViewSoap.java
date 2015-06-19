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

import com.idetronic.subur.service.persistence.MetadataValueViewPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class MetadataValueViewSoap implements Serializable {
	public static MetadataValueViewSoap toSoapModel(MetadataValueView model) {
		MetadataValueViewSoap soapModel = new MetadataValueViewSoap();

		soapModel.setPropertyId(model.getPropertyId());
		soapModel.setSubjectId(model.getSubjectId());
		soapModel.setSubjectName(model.getSubjectName());
		soapModel.setTextValue(model.getTextValue());
		soapModel.setItemCount(model.getItemCount());

		return soapModel;
	}

	public static MetadataValueViewSoap[] toSoapModels(
		MetadataValueView[] models) {
		MetadataValueViewSoap[] soapModels = new MetadataValueViewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetadataValueViewSoap[][] toSoapModels(
		MetadataValueView[][] models) {
		MetadataValueViewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetadataValueViewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetadataValueViewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetadataValueViewSoap[] toSoapModels(
		List<MetadataValueView> models) {
		List<MetadataValueViewSoap> soapModels = new ArrayList<MetadataValueViewSoap>(models.size());

		for (MetadataValueView model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetadataValueViewSoap[soapModels.size()]);
	}

	public MetadataValueViewSoap() {
	}

	public MetadataValueViewPK getPrimaryKey() {
		return new MetadataValueViewPK(_propertyId, _subjectId);
	}

	public void setPrimaryKey(MetadataValueViewPK pk) {
		setPropertyId(pk.propertyId);
		setSubjectId(pk.subjectId);
	}

	public long getPropertyId() {
		return _propertyId;
	}

	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;
	}

	public long getSubjectId() {
		return _subjectId;
	}

	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;
	}

	public String getSubjectName() {
		return _subjectName;
	}

	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;
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

	private long _propertyId;
	private long _subjectId;
	private String _subjectName;
	private String _textValue;
	private int _itemCount;
}