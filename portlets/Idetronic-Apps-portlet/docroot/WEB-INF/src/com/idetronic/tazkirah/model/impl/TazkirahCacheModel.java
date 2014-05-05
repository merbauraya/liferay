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

package com.idetronic.tazkirah.model.impl;

import com.idetronic.tazkirah.model.Tazkirah;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Tazkirah in entity cache.
 *
 * @author Mazlan Mat
 * @see Tazkirah
 * @generated
 */
public class TazkirahCacheModel implements CacheModel<Tazkirah>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{tazkirahId=");
		sb.append(tazkirahId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", category=");
		sb.append(category);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tazkirah toEntityModel() {
		TazkirahImpl tazkirahImpl = new TazkirahImpl();

		tazkirahImpl.setTazkirahId(tazkirahId);
		tazkirahImpl.setCompanyId(companyId);
		tazkirahImpl.setGroupId(groupId);
		tazkirahImpl.setUserId(userId);

		if (userName == null) {
			tazkirahImpl.setUserName(StringPool.BLANK);
		}
		else {
			tazkirahImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tazkirahImpl.setCreateDate(null);
		}
		else {
			tazkirahImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tazkirahImpl.setModifiedDate(null);
		}
		else {
			tazkirahImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			tazkirahImpl.setTitle(StringPool.BLANK);
		}
		else {
			tazkirahImpl.setTitle(title);
		}

		if (content == null) {
			tazkirahImpl.setContent(StringPool.BLANK);
		}
		else {
			tazkirahImpl.setContent(content);
		}

		if (category == null) {
			tazkirahImpl.setCategory(StringPool.BLANK);
		}
		else {
			tazkirahImpl.setCategory(category);
		}

		tazkirahImpl.setStatus(status);

		tazkirahImpl.resetOriginalValues();

		return tazkirahImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tazkirahId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		category = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tazkirahId);
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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeInt(status);
	}

	public long tazkirahId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String content;
	public String category;
	public int status;
}