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

import com.idetronic.subur.model.ItemType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ItemType in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemType
 * @generated
 */
public class ItemTypeCacheModel implements CacheModel<ItemType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ItemTypeId=");
		sb.append(ItemTypeId);
		sb.append(", ItemTypeName=");
		sb.append(ItemTypeName);
		sb.append(", itemCount=");
		sb.append(itemCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemType toEntityModel() {
		ItemTypeImpl itemTypeImpl = new ItemTypeImpl();

		itemTypeImpl.setItemTypeId(ItemTypeId);

		if (ItemTypeName == null) {
			itemTypeImpl.setItemTypeName(StringPool.BLANK);
		}
		else {
			itemTypeImpl.setItemTypeName(ItemTypeName);
		}

		itemTypeImpl.setItemCount(itemCount);

		itemTypeImpl.resetOriginalValues();

		return itemTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ItemTypeId = objectInput.readLong();
		ItemTypeName = objectInput.readUTF();
		itemCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ItemTypeId);

		if (ItemTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ItemTypeName);
		}

		objectOutput.writeInt(itemCount);
	}

	public long ItemTypeId;
	public String ItemTypeName;
	public int itemCount;
}