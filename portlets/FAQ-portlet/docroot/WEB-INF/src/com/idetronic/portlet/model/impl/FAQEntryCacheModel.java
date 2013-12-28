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

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing FAQEntry in entity cache.
 *
 * @author Mazlan Mat
 * @see FAQEntry
 * @generated
 */
public class FAQEntryCacheModel implements CacheModel<FAQEntry>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{entryId=");
		sb.append(entryId);
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

	public FAQEntry toEntityModel() {
		FAQEntryImpl faqEntryImpl = new FAQEntryImpl();

		faqEntryImpl.setEntryId(entryId);
		faqEntryImpl.setCompanyId(companyId);
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

	public long entryId;
	public long companyId;
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