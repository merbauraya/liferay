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
public class StatViewTagSoap implements Serializable {
	public static StatViewTagSoap toSoapModel(StatViewTag model) {
		StatViewTagSoap soapModel = new StatViewTagSoap();

		soapModel.setId(model.getId());
		soapModel.setPerMonth(model.getPerMonth());
		soapModel.setPerYear(model.getPerYear());
		soapModel.setTagId(model.getTagId());

		return soapModel;
	}

	public static StatViewTagSoap[] toSoapModels(StatViewTag[] models) {
		StatViewTagSoap[] soapModels = new StatViewTagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatViewTagSoap[][] toSoapModels(StatViewTag[][] models) {
		StatViewTagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatViewTagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatViewTagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatViewTagSoap[] toSoapModels(List<StatViewTag> models) {
		List<StatViewTagSoap> soapModels = new ArrayList<StatViewTagSoap>(models.size());

		for (StatViewTag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatViewTagSoap[soapModels.size()]);
	}

	public StatViewTagSoap() {
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

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	private long _id;
	private int _perMonth;
	private int _perYear;
	private long _tagId;
}