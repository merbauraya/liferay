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

import com.idetronic.subur.model.Author;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Author in entity cache.
 *
 * @author Mazlan Mat
 * @see Author
 * @generated
 */
public class AuthorCacheModel implements CacheModel<Author>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", idType=");
		sb.append(idType);
		sb.append(", remoteId=");
		sb.append(remoteId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", metadata=");
		sb.append(metadata);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Author toEntityModel() {
		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setAuthorId(authorId);
		authorImpl.setGroupId(groupId);
		authorImpl.setIdType(idType);

		if (remoteId == null) {
			authorImpl.setRemoteId(StringPool.BLANK);
		}
		else {
			authorImpl.setRemoteId(remoteId);
		}

		if (firstName == null) {
			authorImpl.setFirstName(StringPool.BLANK);
		}
		else {
			authorImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			authorImpl.setLastName(StringPool.BLANK);
		}
		else {
			authorImpl.setLastName(lastName);
		}

		authorImpl.setUserId(userId);

		if (metadata == null) {
			authorImpl.setMetadata(StringPool.BLANK);
		}
		else {
			authorImpl.setMetadata(metadata);
		}

		authorImpl.resetOriginalValues();

		return authorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authorId = objectInput.readLong();
		groupId = objectInput.readLong();
		idType = objectInput.readInt();
		remoteId = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		userId = objectInput.readInt();
		metadata = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(authorId);
		objectOutput.writeLong(groupId);
		objectOutput.writeInt(idType);

		if (remoteId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remoteId);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeInt(userId);

		if (metadata == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metadata);
		}
	}

	public long authorId;
	public long groupId;
	public int idType;
	public String remoteId;
	public String firstName;
	public String lastName;
	public int userId;
	public String metadata;
}