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

import com.idetronic.portlet.model.FAQEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FAQEntry in entity cache.
 *
 * @author Idetronic Sdn Bhd
 * @see FAQEntry
 * @generated
 */
public class FAQEntryCacheModel implements CacheModel<FAQEntry>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{entryId=");
		sb.append(entryId);
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
		sb.append(", question=");
		sb.append(question);
		sb.append(", category=");
		sb.append(category);
		sb.append(", answer=");
		sb.append(answer);
		sb.append(", isactive=");
		sb.append(isactive);
		sb.append(", displayOrder=");
		sb.append(displayOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FAQEntry toEntityModel() {
		FAQEntryImpl faqEntryImpl = new FAQEntryImpl();

		faqEntryImpl.setEntryId(entryId);
		faqEntryImpl.setCompanyId(companyId);
		faqEntryImpl.setGroupId(groupId);
		faqEntryImpl.setUserId(userId);

		if (userName == null) {
			faqEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			faqEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			faqEntryImpl.setCreateDate(null);
		}
		else {
			faqEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			faqEntryImpl.setModifiedDate(null);
		}
		else {
			faqEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (question == null) {
			faqEntryImpl.setQuestion(StringPool.BLANK);
		}
		else {
			faqEntryImpl.setQuestion(question);
		}

		if (category == null) {
			faqEntryImpl.setCategory(StringPool.BLANK);
		}
		else {
			faqEntryImpl.setCategory(category);
		}

		if (answer == null) {
			faqEntryImpl.setAnswer(StringPool.BLANK);
		}
		else {
			faqEntryImpl.setAnswer(answer);
		}

		faqEntryImpl.setIsactive(isactive);
		faqEntryImpl.setDisplayOrder(displayOrder);

		faqEntryImpl.resetOriginalValues();

		return faqEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		entryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		question = objectInput.readUTF();
		category = objectInput.readUTF();
		answer = objectInput.readUTF();
		isactive = objectInput.readBoolean();
		displayOrder = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(entryId);
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

		if (question == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (answer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer);
		}

		objectOutput.writeBoolean(isactive);
		objectOutput.writeLong(displayOrder);
	}

	public long entryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String question;
	public String category;
	public String answer;
	public Boolean isactive;
	public long displayOrder;
}