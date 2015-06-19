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

import com.idetronic.subur.model.MetadataProperty;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MetadataProperty in entity cache.
 *
 * @author Mazlan Mat
 * @see MetadataProperty
 * @generated
 */
public class MetadataPropertyCacheModel implements CacheModel<MetadataProperty>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{metadataPropertyId=");
		sb.append(metadataPropertyId);
		sb.append(", metadataSchemaId=");
		sb.append(metadataSchemaId);
		sb.append(", element=");
		sb.append(element);
		sb.append(", scope=");
		sb.append(scope);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MetadataProperty toEntityModel() {
		MetadataPropertyImpl metadataPropertyImpl = new MetadataPropertyImpl();

		metadataPropertyImpl.setMetadataPropertyId(metadataPropertyId);
		metadataPropertyImpl.setMetadataSchemaId(metadataSchemaId);

		if (element == null) {
			metadataPropertyImpl.setElement(StringPool.BLANK);
		}
		else {
			metadataPropertyImpl.setElement(element);
		}

		if (scope == null) {
			metadataPropertyImpl.setScope(StringPool.BLANK);
		}
		else {
			metadataPropertyImpl.setScope(scope);
		}

		if (note == null) {
			metadataPropertyImpl.setNote(StringPool.BLANK);
		}
		else {
			metadataPropertyImpl.setNote(note);
		}

		metadataPropertyImpl.resetOriginalValues();

		return metadataPropertyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		metadataPropertyId = objectInput.readLong();
		metadataSchemaId = objectInput.readLong();
		element = objectInput.readUTF();
		scope = objectInput.readUTF();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(metadataPropertyId);
		objectOutput.writeLong(metadataSchemaId);

		if (element == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(element);
		}

		if (scope == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scope);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long metadataPropertyId;
	public long metadataSchemaId;
	public String element;
	public String scope;
	public String note;
}