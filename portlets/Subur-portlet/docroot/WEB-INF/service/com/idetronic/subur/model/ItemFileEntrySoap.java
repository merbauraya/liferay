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

import com.idetronic.subur.service.persistence.ItemFileEntryPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.subur.service.http.ItemFileEntryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.http.ItemFileEntryServiceSoap
 * @generated
 */
public class ItemFileEntrySoap implements Serializable {
	public static ItemFileEntrySoap toSoapModel(ItemFileEntry model) {
		ItemFileEntrySoap soapModel = new ItemFileEntrySoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setEntryType(model.getEntryType());

		return soapModel;
	}

	public static ItemFileEntrySoap[] toSoapModels(ItemFileEntry[] models) {
		ItemFileEntrySoap[] soapModels = new ItemFileEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemFileEntrySoap[][] toSoapModels(ItemFileEntry[][] models) {
		ItemFileEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemFileEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemFileEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemFileEntrySoap[] toSoapModels(List<ItemFileEntry> models) {
		List<ItemFileEntrySoap> soapModels = new ArrayList<ItemFileEntrySoap>(models.size());

		for (ItemFileEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemFileEntrySoap[soapModels.size()]);
	}

	public ItemFileEntrySoap() {
	}

	public ItemFileEntryPK getPrimaryKey() {
		return new ItemFileEntryPK(_itemId, _fileEntryId);
	}

	public void setPrimaryKey(ItemFileEntryPK pk) {
		setItemId(pk.itemId);
		setFileEntryId(pk.fileEntryId);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getEntryType() {
		return _entryType;
	}

	public void setEntryType(long entryType) {
		_entryType = entryType;
	}

	private long _itemId;
	private long _fileEntryId;
	private long _entryType;
}