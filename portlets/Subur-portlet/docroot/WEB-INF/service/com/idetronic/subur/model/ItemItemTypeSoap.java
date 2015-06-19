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

import com.idetronic.subur.service.persistence.ItemItemTypePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class ItemItemTypeSoap implements Serializable {
	public static ItemItemTypeSoap toSoapModel(ItemItemType model) {
		ItemItemTypeSoap soapModel = new ItemItemTypeSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setItemTypeId(model.getItemTypeId());

		return soapModel;
	}

	public static ItemItemTypeSoap[] toSoapModels(ItemItemType[] models) {
		ItemItemTypeSoap[] soapModels = new ItemItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemItemTypeSoap[][] toSoapModels(ItemItemType[][] models) {
		ItemItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemItemTypeSoap[] toSoapModels(List<ItemItemType> models) {
		List<ItemItemTypeSoap> soapModels = new ArrayList<ItemItemTypeSoap>(models.size());

		for (ItemItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemItemTypeSoap[soapModels.size()]);
	}

	public ItemItemTypeSoap() {
	}

	public ItemItemTypePK getPrimaryKey() {
		return new ItemItemTypePK(_itemId, _itemTypeId);
	}

	public void setPrimaryKey(ItemItemTypePK pk) {
		setItemId(pk.itemId);
		setItemTypeId(pk.itemTypeId);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	private long _itemId;
	private long _itemTypeId;
}