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

import com.idetronic.subur.model.Expertise;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Expertise in entity cache.
 *
 * @author Mazlan Mat
 * @see Expertise
 * @generated
 */
public class ExpertiseCacheModel implements CacheModel<Expertise>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{expertiseId=");
		sb.append(expertiseId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", expertiseName=");
		sb.append(expertiseName);
		sb.append(", indexedName=");
		sb.append(indexedName);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", authorCount=");
		sb.append(authorCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Expertise toEntityModel() {
		ExpertiseImpl expertiseImpl = new ExpertiseImpl();

		expertiseImpl.setExpertiseId(expertiseId);
		expertiseImpl.setGroupId(groupId);
		expertiseImpl.setCompanyId(companyId);
		expertiseImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			expertiseImpl.setCreateDate(null);
		}
		else {
			expertiseImpl.setCreateDate(new Date(createDate));
		}

		if (expertiseName == null) {
			expertiseImpl.setExpertiseName(StringPool.BLANK);
		}
		else {
			expertiseImpl.setExpertiseName(expertiseName);
		}

		if (indexedName == null) {
			expertiseImpl.setIndexedName(StringPool.BLANK);
		}
		else {
			expertiseImpl.setIndexedName(indexedName);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			expertiseImpl.setModifiedDate(null);
		}
		else {
			expertiseImpl.setModifiedDate(new Date(modifiedDate));
		}

		expertiseImpl.setAuthorCount(authorCount);

		expertiseImpl.resetOriginalValues();

		return expertiseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expertiseId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		expertiseName = objectInput.readUTF();
		indexedName = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		authorCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(expertiseId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		if (expertiseName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expertiseName);
		}

		if (indexedName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indexedName);
		}

		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(authorCount);
	}

	public long expertiseId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public String expertiseName;
	public String indexedName;
	public long modifiedDate;
	public int authorCount;
}