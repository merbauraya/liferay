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
public class StatDownloadItemTypeSoap implements Serializable {
	public static StatDownloadItemTypeSoap toSoapModel(
		StatDownloadItemType model) {
		StatDownloadItemTypeSoap soapModel = new StatDownloadItemTypeSoap();

		soapModel.setId(model.getId());
		soapModel.setPerMonth(model.getPerMonth());
		soapModel.setPerYear(model.getPerYear());
		soapModel.setItemTypeId(model.getItemTypeId());

		return soapModel;
	}

	public static StatDownloadItemTypeSoap[] toSoapModels(
		StatDownloadItemType[] models) {
		StatDownloadItemTypeSoap[] soapModels = new StatDownloadItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatDownloadItemTypeSoap[][] toSoapModels(
		StatDownloadItemType[][] models) {
		StatDownloadItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatDownloadItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatDownloadItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatDownloadItemTypeSoap[] toSoapModels(
		List<StatDownloadItemType> models) {
		List<StatDownloadItemTypeSoap> soapModels = new ArrayList<StatDownloadItemTypeSoap>(models.size());

		for (StatDownloadItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatDownloadItemTypeSoap[soapModels.size()]);
	}

	public StatDownloadItemTypeSoap() {
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