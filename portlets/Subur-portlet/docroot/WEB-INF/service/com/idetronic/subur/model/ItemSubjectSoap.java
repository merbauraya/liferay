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

import com.idetronic.subur.service.persistence.ItemSubjectPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class ItemSubjectSoap implements Serializable {
	public static ItemSubjectSoap toSoapModel(ItemSubject model) {
		ItemSubjectSoap soapModel = new ItemSubjectSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setSubjectId(model.getSubjectId());

		return soapModel;
	}

	public static ItemSubjectSoap[] toSoapModels(ItemSubject[] models) {
		ItemSubjectSoap[] soapModels = new ItemSubjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemSubjectSoap[][] toSoapModels(ItemSubject[][] models) {
		ItemSubjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemSubjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemSubjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemSubjectSoap[] toSoapModels(List<ItemSubject> models) {
		List<ItemSubjectSoap> soapModels = new ArrayList<ItemSubjectSoap>(models.size());

		for (ItemSubject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemSubjectSoap[soapModels.size()]);
	}

	public ItemSubjectSoap() {
	}

	public ItemSubjectPK getPrimaryKey() {
		return new ItemSubjectPK(_itemId, _subjectId);
	}

	public void setPrimaryKey(ItemSubjectPK pk) {
		setItemId(pk.itemId);
		setSubjectId(pk.subjectId);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getSubjectId() {
		return _subjectId;
	}

	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;
	}

	private long _itemId;
	private long _subjectId;
}