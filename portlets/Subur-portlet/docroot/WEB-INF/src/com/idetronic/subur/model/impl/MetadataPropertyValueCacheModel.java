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

import com.idetronic.subur.model.MetadataPropertyValue;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MetadataPropertyValue in entity cache.
 *
 * @author Mazlan Mat
 * @see MetadataPropertyValue
 * @generated
 */
public class MetadataPropertyValueCacheModel implements CacheModel<MetadataPropertyValue>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{metadataPropertyValueId=");
		sb.append(metadataPropertyValueId);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", propertyId=");
		sb.append(propertyId);
		sb.append(", textValue=");
		sb.append(textValue);
		sb.append(", itemCount=");
		sb.append(itemCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MetadataPropertyValue toEntityModel() {
		MetadataPropertyValueImpl metadataPropertyValueImpl = new MetadataPropertyValueImpl();

		metadataPropertyValueImpl.setMetadataPropertyValueId(metadataPropertyValueId);
		metadataPropertyValueImpl.setItemId(itemId);
		metadataPropertyValueImpl.setPropertyId(propertyId);

		if (textValue == null) {
			metadataPropertyValueImpl.setTextValue(StringPool.BLANK);
		}
		else {
			metadataPropertyValueImpl.setTextValue(textValue);
		}

		metadataPropertyValueImpl.setItemCount(itemCount);

		metadataPropertyValueImpl.resetOriginalValues();

		return metadataPropertyValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		metadataPropertyValueId = objectInput.readLong();
		itemId = objectInput.readLong();
		propertyId = objectInput.readLong();
		textValue = objectInput.readUTF();
		itemCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(metadataPropertyValueId);
		objectOutput.writeLong(itemId);
		objectOutput.writeLong(propertyId);

		if (textValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(textValue);
		}

		objectOutput.writeInt(itemCount);
	}

	public long metadataPropertyValueId;
	public long itemId;
	public long propertyId;
	public String textValue;
	public int itemCount;
}