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

package com.idetronic.ruangj.model.impl;

import com.idetronic.ruangj.model.ItemFileEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

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
		StringBundler sb = new StringBundler(17);

		sb.append("{itemEntryId=");
		sb.append(itemEntryId);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", fileType=");
		sb.append(fileType);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemFileEntry toEntityModel() {
		ItemFileEntryImpl itemFileEntryImpl = new ItemFileEntryImpl();

		itemFileEntryImpl.setItemEntryId(itemEntryId);
		itemFileEntryImpl.setItemId(itemId);
		itemFileEntryImpl.setFileEntryId(fileEntryId);

		if (fileType == null) {
			itemFileEntryImpl.setFileType(StringPool.BLANK);
		}
		else {
			itemFileEntryImpl.setFileType(fileType);
		}

		itemFileEntryImpl.setUserId(userId);

		if (userName == null) {
			itemFileEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			itemFileEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			itemFileEntryImpl.setCreateDate(null);
		}
		else {
			itemFileEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			itemFileEntryImpl.setModifiedDate(null);
		}
		else {
			itemFileEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		itemFileEntryImpl.resetOriginalValues();

		return itemFileEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemEntryId = objectInput.readLong();
		itemId = objectInput.readLong();
		fileEntryId = objectInput.readLong();
		fileType = objectInput.readUTF();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemEntryId);
		objectOutput.writeLong(itemId);
		objectOutput.writeLong(fileEntryId);

		if (fileType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileType);
		}

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long itemEntryId;
	public long itemId;
	public long fileEntryId;
	public String fileType;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}