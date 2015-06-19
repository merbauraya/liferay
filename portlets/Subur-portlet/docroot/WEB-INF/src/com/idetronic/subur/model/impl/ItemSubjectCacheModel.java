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

import com.idetronic.subur.model.ItemSubject;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ItemSubject in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemSubject
 * @generated
 */
public class ItemSubjectCacheModel implements CacheModel<ItemSubject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{itemId=");
		sb.append(itemId);
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemSubject toEntityModel() {
		ItemSubjectImpl itemSubjectImpl = new ItemSubjectImpl();

		itemSubjectImpl.setItemId(itemId);
		itemSubjectImpl.setSubjectId(subjectId);

		itemSubjectImpl.resetOriginalValues();

		return itemSubjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemId = objectInput.readLong();
		subjectId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemId);
		objectOutput.writeLong(subjectId);
	}

	public long itemId;
	public long subjectId;
}