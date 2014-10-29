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

package com.idetronic.portlet.model.impl;

import com.idetronic.portlet.model.ExpertiseTag;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExpertiseTag in entity cache.
 *
 * @author Mazlan Mat
 * @see ExpertiseTag
 * @generated
 */
public class ExpertiseTagCacheModel implements CacheModel<ExpertiseTag>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{tagId=");
		sb.append(tagId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", tagName=");
		sb.append(tagName);
		sb.append(", userCount=");
		sb.append(userCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExpertiseTag toEntityModel() {
		ExpertiseTagImpl expertiseTagImpl = new ExpertiseTagImpl();

		expertiseTagImpl.setTagId(tagId);
		expertiseTagImpl.setGroupId(groupId);
		expertiseTagImpl.setCompanyId(companyId);
		expertiseTagImpl.setUserId(userId);

		if (userName == null) {
			expertiseTagImpl.setUserName(StringPool.BLANK);
		}
		else {
			expertiseTagImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			expertiseTagImpl.setCreateDate(null);
		}
		else {
			expertiseTagImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			expertiseTagImpl.setModifiedDate(null);
		}
		else {
			expertiseTagImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (tagName == null) {
			expertiseTagImpl.setTagName(StringPool.BLANK);
		}
		else {
			expertiseTagImpl.setTagName(tagName);
		}

		expertiseTagImpl.setUserCount(userCount);

		expertiseTagImpl.resetOriginalValues();

		return expertiseTagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tagId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		tagName = objectInput.readUTF();
		userCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tagId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (tagName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tagName);
		}

		objectOutput.writeInt(userCount);
	}

	public long tagId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String tagName;
	public int userCount;
}