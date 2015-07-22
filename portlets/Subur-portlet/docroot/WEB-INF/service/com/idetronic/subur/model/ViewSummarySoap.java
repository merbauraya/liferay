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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.subur.service.http.ViewSummaryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.http.ViewSummaryServiceSoap
 * @generated
 */
public class ViewSummarySoap implements Serializable {
	public static ViewSummarySoap toSoapModel(ViewSummary model) {
		ViewSummarySoap soapModel = new ViewSummarySoap();

		soapModel.setId(model.getId());
		soapModel.setItemId(model.getItemId());
		soapModel.setPerMonth(model.getPerMonth());
		soapModel.setPerYear(model.getPerYear());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ViewSummarySoap[] toSoapModels(ViewSummary[] models) {
		ViewSummarySoap[] soapModels = new ViewSummarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewSummarySoap[][] toSoapModels(ViewSummary[][] models) {
		ViewSummarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewSummarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewSummarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewSummarySoap[] toSoapModels(List<ViewSummary> models) {
		List<ViewSummarySoap> soapModels = new ArrayList<ViewSummarySoap>(models.size());

		for (ViewSummary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewSummarySoap[soapModels.size()]);
	}

	public ViewSummarySoap() {
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _id;
	private long _itemId;
	private int _perMonth;
	private int _perYear;
	private int _status;
}