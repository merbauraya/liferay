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

import com.idetronic.subur.model.FileEntryType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FileEntryType in entity cache.
 *
 * @author Mazlan Mat
 * @see FileEntryType
 * @generated
 */
public class FileEntryTypeCacheModel implements CacheModel<FileEntryType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{typeId=");
		sb.append(typeId);
		sb.append(", typeName=");
		sb.append(typeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileEntryType toEntityModel() {
		FileEntryTypeImpl fileEntryTypeImpl = new FileEntryTypeImpl();

		fileEntryTypeImpl.setTypeId(typeId);

		if (typeName == null) {
			fileEntryTypeImpl.setTypeName(StringPool.BLANK);
		}
		else {
			fileEntryTypeImpl.setTypeName(typeName);
		}

		fileEntryTypeImpl.resetOriginalValues();

		return fileEntryTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeId = objectInput.readLong();
		typeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(typeId);

		if (typeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeName);
		}
	}

	public long typeId;
	public String typeName;
}