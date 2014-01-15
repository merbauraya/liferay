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

package com.idetronic.eprint.model.impl;

import com.idetronic.eprint.model.Eprint;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Eprint in entity cache.
 *
 * @author matle
 * @see Eprint
 * @generated
 */
public class EprintCacheModel implements CacheModel<Eprint>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{eprintId=");
		sb.append(eprintId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", eprintType=");
		sb.append(eprintType);
		sb.append(", eprintStatus=");
		sb.append(eprintStatus);
		sb.append(", metadataVisibility=");
		sb.append(metadataVisibility);
		sb.append(", eprintAbstract=");
		sb.append(eprintAbstract);
		sb.append(", eprintKeywords=");
		sb.append(eprintKeywords);
		sb.append(", isPublished=");
		sb.append(isPublished);
		sb.append(", dateYear=");
		sb.append(dateYear);
		sb.append(", fullTextStatus=");
		sb.append(fullTextStatus);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	public Eprint toEntityModel() {
		EprintImpl eprintImpl = new EprintImpl();

		eprintImpl.setEprintId(eprintId);

		if (title == null) {
			eprintImpl.setTitle(StringPool.BLANK);
		}
		else {
			eprintImpl.setTitle(title);
		}

		if (eprintType == null) {
			eprintImpl.setEprintType(StringPool.BLANK);
		}
		else {
			eprintImpl.setEprintType(eprintType);
		}

		if (eprintStatus == null) {
			eprintImpl.setEprintStatus(StringPool.BLANK);
		}
		else {
			eprintImpl.setEprintStatus(eprintStatus);
		}

		if (metadataVisibility == null) {
			eprintImpl.setMetadataVisibility(StringPool.BLANK);
		}
		else {
			eprintImpl.setMetadataVisibility(metadataVisibility);
		}

		if (eprintAbstract == null) {
			eprintImpl.setEprintAbstract(StringPool.BLANK);
		}
		else {
			eprintImpl.setEprintAbstract(eprintAbstract);
		}

		if (eprintKeywords == null) {
			eprintImpl.setEprintKeywords(StringPool.BLANK);
		}
		else {
			eprintImpl.setEprintKeywords(eprintKeywords);
		}

		if (isPublished == null) {
			eprintImpl.setIsPublished(StringPool.BLANK);
		}
		else {
			eprintImpl.setIsPublished(isPublished);
		}

		if (dateYear == null) {
			eprintImpl.setDateYear(StringPool.BLANK);
		}
		else {
			eprintImpl.setDateYear(dateYear);
		}

		if (fullTextStatus == null) {
			eprintImpl.setFullTextStatus(StringPool.BLANK);
		}
		else {
			eprintImpl.setFullTextStatus(fullTextStatus);
		}

		eprintImpl.setCompanyId(companyId);

		if (modifiedDate == Long.MIN_VALUE) {
			eprintImpl.setModifiedDate(null);
		}
		else {
			eprintImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (createdDate == Long.MIN_VALUE) {
			eprintImpl.setCreatedDate(null);
		}
		else {
			eprintImpl.setCreatedDate(new Date(createdDate));
		}

		eprintImpl.setGroupId(groupId);

		eprintImpl.resetOriginalValues();

		return eprintImpl;
	}

	public long eprintId;
	public String title;
	public String eprintType;
	public String eprintStatus;
	public String metadataVisibility;
	public String eprintAbstract;
	public String eprintKeywords;
	public String isPublished;
	public String dateYear;
	public String fullTextStatus;
	public long companyId;
	public long modifiedDate;
	public long createdDate;
	public long groupId;
}