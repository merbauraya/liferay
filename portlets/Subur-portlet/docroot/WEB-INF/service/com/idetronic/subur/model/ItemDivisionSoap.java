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

import com.idetronic.subur.service.persistence.ItemDivisionPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class ItemDivisionSoap implements Serializable {
	public static ItemDivisionSoap toSoapModel(ItemDivision model) {
		ItemDivisionSoap soapModel = new ItemDivisionSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setDivisionId(model.getDivisionId());

		return soapModel;
	}

	public static ItemDivisionSoap[] toSoapModels(ItemDivision[] models) {
		ItemDivisionSoap[] soapModels = new ItemDivisionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemDivisionSoap[][] toSoapModels(ItemDivision[][] models) {
		ItemDivisionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemDivisionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemDivisionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemDivisionSoap[] toSoapModels(List<ItemDivision> models) {
		List<ItemDivisionSoap> soapModels = new ArrayList<ItemDivisionSoap>(models.size());

		for (ItemDivision model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemDivisionSoap[soapModels.size()]);
	}

	public ItemDivisionSoap() {
	}

	public ItemDivisionPK getPrimaryKey() {
		return new ItemDivisionPK(_itemId, _divisionId);
	}

	public void setPrimaryKey(ItemDivisionPK pk) {
		setItemId(pk.itemId);
		setDivisionId(pk.divisionId);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getDivisionId() {
		return _divisionId;
	}

	public void setDivisionId(long divisionId) {
		_divisionId = divisionId;
	}

	private long _itemId;
	private long _divisionId;
}