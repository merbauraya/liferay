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
public class StatViewItemTypeSoap implements Serializable {
	public static StatViewItemTypeSoap toSoapModel(StatViewItemType model) {
		StatViewItemTypeSoap soapModel = new StatViewItemTypeSoap();

		soapModel.setId(model.getId());
		soapModel.setPerMonth(model.getPerMonth());
		soapModel.setPerYear(model.getPerYear());
		soapModel.setItemTypeId(model.getItemTypeId());

		return soapModel;
	}

	public static StatViewItemTypeSoap[] toSoapModels(StatViewItemType[] models) {
		StatViewItemTypeSoap[] soapModels = new StatViewItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatViewItemTypeSoap[][] toSoapModels(
		StatViewItemType[][] models) {
		StatViewItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatViewItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatViewItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatViewItemTypeSoap[] toSoapModels(
		List<StatViewItemType> models) {
		List<StatViewItemTypeSoap> soapModels = new ArrayList<StatViewItemTypeSoap>(models.size());

		for (StatViewItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatViewItemTypeSoap[soapModels.size()]);
	}

	public StatViewItemTypeSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public int getPerMonth() {
		return _perMonth;
	}

	public void setPerMonth(int perMonth) {
		_perMonth = perMonth;
	}

	public int getPerYear() {
		return _perYear;
	}

	public void setPerYear(int perYear) {
		_perYear = perYear;
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	private long _id;
	private int _perMonth;
	private int _perYear;
	private long _itemTypeId;
}