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

import com.idetronic.subur.model.MetadataSchema;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MetadataSchema in entity cache.
 *
 * @author Mazlan Mat
 * @see MetadataSchema
 * @generated
 */
public class MetadataSchemaCacheModel implements CacheModel<MetadataSchema>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{metadataSchemaId=");
		sb.append(metadataSchemaId);
		sb.append(", metadataName=");
		sb.append(metadataName);
		sb.append(", nameSpace=");
		sb.append(nameSpace);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MetadataSchema toEntityModel() {
		MetadataSchemaImpl metadataSchemaImpl = new MetadataSchemaImpl();

		metadataSchemaImpl.setMetadataSchemaId(metadataSchemaId);

		if (metadataName == null) {
			metadataSchemaImpl.setMetadataName(StringPool.BLANK);
		}
		else {
			metadataSchemaImpl.setMetadataName(metadataName);
		}

		if (nameSpace == null) {
			metadataSchemaImpl.setNameSpace(StringPool.BLANK);
		}
		else {
			metadataSchemaImpl.setNameSpace(nameSpace);
		}

		metadataSchemaImpl.resetOriginalValues();

		return metadataSchemaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		metadataSchemaId = objectInput.readLong();
		metadataName = objectInput.readUTF();
		nameSpace = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(metadataSchemaId);

		if (metadataName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metadataName);
		}

		if (nameSpace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameSpace);
		}
	}

	public long metadataSchemaId;
	public String metadataName;
	public String nameSpace;
}