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

import com.idetronic.subur.service.persistence.ItemAuthorPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class ItemAuthorSoap implements Serializable {
	public static ItemAuthorSoap toSoapModel(ItemAuthor model) {
		ItemAuthorSoap soapModel = new ItemAuthorSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setAuthorId(model.getAuthorId());

		return soapModel;
	}

	public static ItemAuthorSoap[] toSoapModels(ItemAuthor[] models) {
		ItemAuthorSoap[] soapModels = new ItemAuthorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemAuthorSoap[][] toSoapModels(ItemAuthor[][] models) {
		ItemAuthorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemAuthorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemAuthorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemAuthorSoap[] toSoapModels(List<ItemAuthor> models) {
		List<ItemAuthorSoap> soapModels = new ArrayList<ItemAuthorSoap>(models.size());

		for (ItemAuthor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemAuthorSoap[soapModels.size()]);
	}

	public ItemAuthorSoap() {
	}

	public ItemAuthorPK getPrimaryKey() {
		return new ItemAuthorPK(_itemId, _authorId);
	}

	public void setPrimaryKey(ItemAuthorPK pk) {
		setItemId(pk.itemId);
		setAuthorId(pk.authorId);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	private long _itemId;
	private long _authorId;
}