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

import com.idetronic.portlet.model.UserEntries_ExpertiseTags;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserEntries_ExpertiseTags in entity cache.
 *
 * @author Mazlan Mat
 * @see UserEntries_ExpertiseTags
 * @generated
 */
public class UserEntries_ExpertiseTagsCacheModel implements CacheModel<UserEntries_ExpertiseTags>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", tagId=");
		sb.append(tagId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserEntries_ExpertiseTags toEntityModel() {
		UserEntries_ExpertiseTagsImpl userEntries_ExpertiseTagsImpl = new UserEntries_ExpertiseTagsImpl();

		userEntries_ExpertiseTagsImpl.setUserId(userId);
		userEntries_ExpertiseTagsImpl.setTagId(tagId);

		userEntries_ExpertiseTagsImpl.resetOriginalValues();

		return userEntries_ExpertiseTagsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		tagId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(tagId);
	}

	public long userId;
	public long tagId;
}