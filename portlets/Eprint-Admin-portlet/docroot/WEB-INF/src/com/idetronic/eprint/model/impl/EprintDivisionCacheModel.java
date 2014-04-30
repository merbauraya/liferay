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

import com.idetronic.eprint.model.EprintDivision;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EprintDivision in entity cache.
 *
 * @author Mazlan Mat
 * @see EprintDivision
 * @generated
 */
public class EprintDivisionCacheModel implements CacheModel<EprintDivision>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{eprintId=");
		sb.append(eprintId);
		sb.append(", divisionId=");
		sb.append(divisionId);
		sb.append(", divisionName=");
		sb.append(divisionName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EprintDivision toEntityModel() {
		EprintDivisionImpl eprintDivisionImpl = new EprintDivisionImpl();

		eprintDivisionImpl.setEprintId(eprintId);

		if (divisionId == null) {
			eprintDivisionImpl.setDivisionId(StringPool.BLANK);
		}
		else {
			eprintDivisionImpl.setDivisionId(divisionId);
		}

		if (divisionName == null) {
			eprintDivisionImpl.setDivisionName(StringPool.BLANK);
		}
		else {
			eprintDivisionImpl.setDivisionName(divisionName);
		}

		eprintDivisionImpl.resetOriginalValues();

		return eprintDivisionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eprintId = objectInput.readLong();
		divisionId = objectInput.readUTF();
		divisionName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eprintId);

		if (divisionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(divisionId);
		}

		if (divisionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(divisionName);
		}
	}

	public long eprintId;
	public String divisionId;
	public String divisionName;
}