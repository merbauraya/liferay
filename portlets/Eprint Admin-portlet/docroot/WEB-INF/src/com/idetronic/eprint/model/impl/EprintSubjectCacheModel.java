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

import com.idetronic.eprint.model.EprintSubject;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EprintSubject in entity cache.
 *
 * @author Mazlan Mat
 * @see EprintSubject
 * @generated
 */
public class EprintSubjectCacheModel implements CacheModel<EprintSubject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{eprintId=");
		sb.append(eprintId);
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", subjectName=");
		sb.append(subjectName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EprintSubject toEntityModel() {
		EprintSubjectImpl eprintSubjectImpl = new EprintSubjectImpl();

		eprintSubjectImpl.setEprintId(eprintId);

		if (subjectId == null) {
			eprintSubjectImpl.setSubjectId(StringPool.BLANK);
		}
		else {
			eprintSubjectImpl.setSubjectId(subjectId);
		}

		if (subjectName == null) {
			eprintSubjectImpl.setSubjectName(StringPool.BLANK);
		}
		else {
			eprintSubjectImpl.setSubjectName(subjectName);
		}

		eprintSubjectImpl.resetOriginalValues();

		return eprintSubjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eprintId = objectInput.readLong();
		subjectId = objectInput.readUTF();
		subjectName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eprintId);

		if (subjectId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectId);
		}

		if (subjectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectName);
		}
	}

	public long eprintId;
	public String subjectId;
	public String subjectName;
}