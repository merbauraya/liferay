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

import com.idetronic.subur.model.Division;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Division in entity cache.
 *
 * @author Mazlan Mat
 * @see Division
 * @generated
 */
public class DivisionCacheModel implements CacheModel<Division>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{divisionId=");
		sb.append(divisionId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", divisionName=");
		sb.append(divisionName);
		sb.append(", depositable=");
		sb.append(depositable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Division toEntityModel() {
		DivisionImpl divisionImpl = new DivisionImpl();

		divisionImpl.setDivisionId(divisionId);
		divisionImpl.setParentId(parentId);

		if (divisionName == null) {
			divisionImpl.setDivisionName(StringPool.BLANK);
		}
		else {
			divisionImpl.setDivisionName(divisionName);
		}

		divisionImpl.setDepositable(depositable);

		divisionImpl.resetOriginalValues();

		return divisionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		divisionId = objectInput.readLong();
		parentId = objectInput.readLong();
		divisionName = objectInput.readUTF();
		depositable = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(divisionId);
		objectOutput.writeLong(parentId);

		if (divisionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(divisionName);
		}

		objectOutput.writeBoolean(depositable);
	}

	public long divisionId;
	public long parentId;
	public String divisionName;
	public boolean depositable;
}