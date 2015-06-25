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

import com.idetronic.subur.model.SuburItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SuburItem in entity cache.
 *
 * @author Mazlan Mat
 * @see SuburItem
 * @generated
 */
public class SuburItemCacheModel implements CacheModel<SuburItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{itemId=");
		sb.append(itemId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", publishedDate=");
		sb.append(publishedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", itemAbstract=");
		sb.append(itemAbstract);
		sb.append(", status=");
		sb.append(status);
		sb.append(", Uuid=");
		sb.append(Uuid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SuburItem toEntityModel() {
		SuburItemImpl suburItemImpl = new SuburItemImpl();

		suburItemImpl.setItemId(itemId);
		suburItemImpl.setCompanyId(companyId);
		suburItemImpl.setGroupId(groupId);
		suburItemImpl.setUserId(userId);

		if (userName == null) {
			suburItemImpl.setUserName(StringPool.BLANK);
		}
		else {
			suburItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			suburItemImpl.setCreateDate(null);
		}
		else {
			suburItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			suburItemImpl.setModifiedDate(null);
		}
		else {
			suburItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (publishedDate == Long.MIN_VALUE) {
			suburItemImpl.setPublishedDate(null);
		}
		else {
			suburItemImpl.setPublishedDate(new Date(publishedDate));
		}

		if (title == null) {
			suburItemImpl.setTitle(StringPool.BLANK);
		}
		else {
			suburItemImpl.setTitle(title);
		}

		if (itemAbstract == null) {
			suburItemImpl.setItemAbstract(StringPool.BLANK);
		}
		else {
			suburItemImpl.setItemAbstract(itemAbstract);
		}

		suburItemImpl.setStatus(status);

		if (Uuid == null) {
			suburItemImpl.setUuid(StringPool.BLANK);
		}
		else {
			suburItemImpl.setUuid(Uuid);
		}

		suburItemImpl.resetOriginalValues();

		return suburItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		publishedDate = objectInput.readLong();
		title = objectInput.readUTF();
		itemAbstract = objectInput.readUTF();
		status = objectInput.readInt();
		Uuid = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(publishedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (itemAbstract == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemAbstract);
		}

		objectOutput.writeInt(status);

		if (Uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Uuid);
		}
	}

	public long itemId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long publishedDate;
	public String title;
	public String itemAbstract;
	public int status;
	public String Uuid;
}