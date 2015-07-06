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

import java.util.Date;

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
		StringBundler sb = new StringBundler(27);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", title=");
		sb.append(title);
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
		sb.append(", lastPublishedDate=");
		sb.append(lastPublishedDate);
		sb.append(", itemCount=");
		sb.append(itemCount);
		sb.append(", personalSite=");
		sb.append(personalSite);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Author toEntityModel() {
		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setAuthorId(authorId);
		authorImpl.setGroupId(groupId);
		authorImpl.setCompanyId(companyId);

		if (title == null) {
			authorImpl.setTitle(StringPool.BLANK);
		}
		else {
			authorImpl.setTitle(title);
		}

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

		if (lastPublishedDate == Long.MIN_VALUE) {
			authorImpl.setLastPublishedDate(null);
		}
		else {
			authorImpl.setLastPublishedDate(new Date(lastPublishedDate));
		}

		authorImpl.setItemCount(itemCount);

		if (personalSite == null) {
			authorImpl.setPersonalSite(StringPool.BLANK);
		}
		else {
			authorImpl.setPersonalSite(personalSite);
		}

		authorImpl.resetOriginalValues();

		return authorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authorId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		title = objectInput.readUTF();
		idType = objectInput.readInt();
		remoteId = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		userId = objectInput.readInt();
		metadata = objectInput.readUTF();
		lastPublishedDate = objectInput.readLong();
		itemCount = objectInput.readInt();
		personalSite = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(authorId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

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

		objectOutput.writeLong(lastPublishedDate);
		objectOutput.writeInt(itemCount);

		if (personalSite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personalSite);
		}
	}

	public long authorId;
	public long groupId;
	public long companyId;
	public String title;
	public int idType;
	public String remoteId;
	public String firstName;
	public String lastName;
	public int userId;
	public String metadata;
	public long lastPublishedDate;
	public int itemCount;
	public String personalSite;
}