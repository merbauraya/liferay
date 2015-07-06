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

import com.idetronic.subur.model.AuthorExpertise;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AuthorExpertise in entity cache.
 *
 * @author Mazlan Mat
 * @see AuthorExpertise
 * @generated
 */
public class AuthorExpertiseCacheModel implements CacheModel<AuthorExpertise>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", expertiseId=");
		sb.append(expertiseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AuthorExpertise toEntityModel() {
		AuthorExpertiseImpl authorExpertiseImpl = new AuthorExpertiseImpl();

		authorExpertiseImpl.setAuthorId(authorId);
		authorExpertiseImpl.setExpertiseId(expertiseId);

		authorExpertiseImpl.resetOriginalValues();

		return authorExpertiseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authorId = objectInput.readLong();
		expertiseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(authorId);
		objectOutput.writeLong(expertiseId);
	}

	public long authorId;
	public long expertiseId;
}