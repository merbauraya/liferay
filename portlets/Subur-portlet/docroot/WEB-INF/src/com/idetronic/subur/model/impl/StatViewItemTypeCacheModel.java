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

package com.idetronic.subur.model.impl;

import com.idetronic.subur.model.StatViewItemType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatViewItemType in entity cache.
 *
 * @author Mazlan Mat
 * @see StatViewItemType
 * @generated
 */
public class StatViewItemTypeCacheModel implements CacheModel<StatViewItemType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", perMonth=");
		sb.append(perMonth);
		sb.append(", perYear=");
		sb.append(perYear);
		sb.append(", itemTypeId=");
		sb.append(itemTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatViewItemType toEntityModel() {
		StatViewItemTypeImpl statViewItemTypeImpl = new StatViewItemTypeImpl();

		statViewItemTypeImpl.setId(id);
		statViewItemTypeImpl.setPerMonth(perMonth);
		statViewItemTypeImpl.setPerYear(perYear);
		statViewItemTypeImpl.setItemTypeId(itemTypeId);

		statViewItemTypeImpl.resetOriginalValues();

		return statViewItemTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		perMonth = objectInput.readInt();
		perYear = objectInput.readInt();
		itemTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeInt(perMonth);
		objectOutput.writeInt(perYear);
		objectOutput.writeLong(itemTypeId);
	}

	public long id;
	public int perMonth;
	public int perYear;
	public long itemTypeId;
}