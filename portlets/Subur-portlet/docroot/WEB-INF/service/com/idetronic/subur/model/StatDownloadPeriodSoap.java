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
public class StatDownloadPeriodSoap implements Serializable {
	public static StatDownloadPeriodSoap toSoapModel(StatDownloadPeriod model) {
		StatDownloadPeriodSoap soapModel = new StatDownloadPeriodSoap();

		soapModel.setId(model.getId());
		soapModel.setItemId(model.getItemId());
		soapModel.setPerMonth(model.getPerMonth());
		soapModel.setPerYear(model.getPerYear());

		return soapModel;
	}

	public static StatDownloadPeriodSoap[] toSoapModels(
		StatDownloadPeriod[] models) {
		StatDownloadPeriodSoap[] soapModels = new StatDownloadPeriodSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatDownloadPeriodSoap[][] toSoapModels(
		StatDownloadPeriod[][] models) {
		StatDownloadPeriodSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatDownloadPeriodSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatDownloadPeriodSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatDownloadPeriodSoap[] toSoapModels(
		List<StatDownloadPeriod> models) {
		List<StatDownloadPeriodSoap> soapModels = new ArrayList<StatDownloadPeriodSoap>(models.size());

		for (StatDownloadPeriod model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatDownloadPeriodSoap[soapModels.size()]);
	}

	public StatDownloadPeriodSoap() {
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

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
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

	private long _id;
	private long _itemId;
	private int _perMonth;
	private int _perYear;
}