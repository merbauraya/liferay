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

import com.idetronic.subur.model.MetadataValueView;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MetadataValueView in entity cache.
 *
 * @author Mazlan Mat
 * @see MetadataValueView
 * @generated
 */
public class MetadataValueViewCacheModel implements CacheModel<MetadataValueView>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{propertyId=");
		sb.append(propertyId);
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", subjectName=");
		sb.append(subjectName);
		sb.append(", textValue=");
		sb.append(textValue);
		sb.append(", itemCount=");
		sb.append(itemCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MetadataValueView toEntityModel() {
		MetadataValueViewImpl metadataValueViewImpl = new MetadataValueViewImpl();

		metadataValueViewImpl.setPropertyId(propertyId);
		metadataValueViewImpl.setSubjectId(subjectId);

		if (subjectName == null) {
			metadataValueViewImpl.setSubjectName(StringPool.BLANK);
		}
		else {
			metadataValueViewImpl.setSubjectName(subjectName);
		}

		if (textValue == null) {
			metadataValueViewImpl.setTextValue(StringPool.BLANK);
		}
		else {
			metadataValueViewImpl.setTextValue(textValue);
		}

		metadataValueViewImpl.setItemCount(itemCount);

		metadataValueViewImpl.resetOriginalValues();

		return metadataValueViewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		propertyId = objectInput.readLong();
		subjectId = objectInput.readLong();
		subjectName = objectInput.readUTF();
		textValue = objectInput.readUTF();
		itemCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(propertyId);
		objectOutput.writeLong(subjectId);

		if (subjectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectName);
		}

		if (textValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(textValue);
		}

		objectOutput.writeInt(itemCount);
	}

	public long propertyId;
	public long subjectId;
	public String subjectName;
	public String textValue;
	public int itemCount;
}