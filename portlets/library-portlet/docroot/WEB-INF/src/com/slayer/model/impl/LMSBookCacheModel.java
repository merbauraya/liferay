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

package com.slayer.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.slayer.model.LMSBook;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LMSBook in entity cache.
 *
 * @author matle
 * @see LMSBook
 * @generated
 */
public class LMSBookCacheModel implements CacheModel<LMSBook>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", bookTitle=");
		sb.append(bookTitle);
		sb.append(", author=");
		sb.append(author);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	public LMSBook toEntityModel() {
		LMSBookImpl lmsBookImpl = new LMSBookImpl();

		lmsBookImpl.setBookId(bookId);

		if (bookTitle == null) {
			lmsBookImpl.setBookTitle(StringPool.BLANK);
		}
		else {
			lmsBookImpl.setBookTitle(bookTitle);
		}

		if (author == null) {
			lmsBookImpl.setAuthor(StringPool.BLANK);
		}
		else {
			lmsBookImpl.setAuthor(author);
		}

		if (createDate == Long.MIN_VALUE) {
			lmsBookImpl.setCreateDate(null);
		}
		else {
			lmsBookImpl.setCreateDate(new Date(createDate));
		}

		lmsBookImpl.resetOriginalValues();

		return lmsBookImpl;
	}

	public long bookId;
	public String bookTitle;
	public String author;
	public long createDate;
}