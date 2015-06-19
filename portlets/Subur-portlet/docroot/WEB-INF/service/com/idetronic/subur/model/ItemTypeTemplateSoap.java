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

import com.idetronic.subur.service.persistence.ItemTypeTemplatePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class ItemTypeTemplateSoap implements Serializable {
	public static ItemTypeTemplateSoap toSoapModel(ItemTypeTemplate model) {
		ItemTypeTemplateSoap soapModel = new ItemTypeTemplateSoap();

		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setMetadataPropertyId(model.getMetadataPropertyId());
		soapModel.setRequired(model.getRequired());

		return soapModel;
	}

	public static ItemTypeTemplateSoap[] toSoapModels(ItemTypeTemplate[] models) {
		ItemTypeTemplateSoap[] soapModels = new ItemTypeTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeTemplateSoap[][] toSoapModels(
		ItemTypeTemplate[][] models) {
		ItemTypeTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemTypeTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemTypeTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeTemplateSoap[] toSoapModels(
		List<ItemTypeTemplate> models) {
		List<ItemTypeTemplateSoap> soapModels = new ArrayList<ItemTypeTemplateSoap>(models.size());

		for (ItemTypeTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemTypeTemplateSoap[soapModels.size()]);
	}

	public ItemTypeTemplateSoap() {
	}

	public ItemTypeTemplatePK getPrimaryKey() {
		return new ItemTypeTemplatePK(_itemTypeId, _metadataPropertyId);
	}

	public void setPrimaryKey(ItemTypeTemplatePK pk) {
		setItemTypeId(pk.itemTypeId);
		setMetadataPropertyId(pk.metadataPropertyId);
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	public long getMetadataPropertyId() {
		return _metadataPropertyId;
	}

	public void setMetadataPropertyId(long metadataPropertyId) {
		_metadataPropertyId = metadataPropertyId;
	}

	public boolean getRequired() {
		return _required;
	}

	public boolean isRequired() {
		return _required;
	}

	public void setRequired(boolean required) {
		_required = required;
	}

	private long _itemTypeId;
	private long _metadataPropertyId;
	private boolean _required;
}