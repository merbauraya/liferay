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

import com.idetronic.subur.model.ItemFileEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ItemFileEntry in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemFileEntry
 * @generated
 */
public class ItemFileEntryCacheModel implements CacheModel<ItemFileEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{itemId=");
		sb.append(itemId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", entryType=");
		sb.append(entryType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemFileEntry toEntityModel() {
		ItemFileEntryImpl itemFileEntryImpl = new ItemFileEntryImpl();

		itemFileEntryImpl.setItemId(itemId);
		itemFileEntryImpl.setFileEntryId(fileEntryId);
		itemFileEntryImpl.setEntryType(entryType);

		itemFileEntryImpl.resetOriginalValues();

		return itemFileEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemId = objectInput.readLong();
		fileEntryId = objectInput.readLong();
		entryType = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemId);
		objectOutput.writeLong(fileEntryId);
		objectOutput.writeLong(entryType);
	}

	public long itemId;
	public long fileEntryId;
	public long entryType;
}