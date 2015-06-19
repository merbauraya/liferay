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
public class ItemTypeSoap implements Serializable {
	public static ItemTypeSoap toSoapModel(ItemType model) {
		ItemTypeSoap soapModel = new ItemTypeSoap();

		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setItemTypeName(model.getItemTypeName());
		soapModel.setItemCount(model.getItemCount());

		return soapModel;
	}

	public static ItemTypeSoap[] toSoapModels(ItemType[] models) {
		ItemTypeSoap[] soapModels = new ItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeSoap[][] toSoapModels(ItemType[][] models) {
		ItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeSoap[] toSoapModels(List<ItemType> models) {
		List<ItemTypeSoap> soapModels = new ArrayList<ItemTypeSoap>(models.size());

		for (ItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemTypeSoap[soapModels.size()]);
	}

	public ItemTypeSoap() {
	}

	public long getPrimaryKey() {
		return _ItemTypeId;
	}

	public void setPrimaryKey(long pk) {
		setItemTypeId(pk);
	}

	public long getItemTypeId() {
		return _ItemTypeId;
	}

	public void setItemTypeId(long ItemTypeId) {
		_ItemTypeId = ItemTypeId;
	}

	public String getItemTypeName() {
		return _ItemTypeName;
	}

	public void setItemTypeName(String ItemTypeName) {
		_ItemTypeName = ItemTypeName;
	}

	public int getItemCount() {
		return _itemCount;
	}

	public void setItemCount(int itemCount) {
		_itemCount = itemCount;
	}

	private long _ItemTypeId;
	private String _ItemTypeName;
	private int _itemCount;
}