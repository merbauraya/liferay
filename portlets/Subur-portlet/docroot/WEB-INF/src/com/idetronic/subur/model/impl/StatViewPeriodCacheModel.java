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

import com.idetronic.subur.model.StatViewPeriod;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatViewPeriod in entity cache.
 *
 * @author Mazlan Mat
 * @see StatViewPeriod
 * @generated
 */
public class StatViewPeriodCacheModel implements CacheModel<StatViewPeriod>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", perMonth=");
		sb.append(perMonth);
		sb.append(", perYear=");
		sb.append(perYear);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatViewPeriod toEntityModel() {
		StatViewPeriodImpl statViewPeriodImpl = new StatViewPeriodImpl();

		statViewPeriodImpl.setId(id);
		statViewPeriodImpl.setItemId(itemId);
		statViewPeriodImpl.setPerMonth(perMonth);
		statViewPeriodImpl.setPerYear(perYear);

		statViewPeriodImpl.resetOriginalValues();

		return statViewPeriodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		itemId = objectInput.readLong();
		perMonth = objectInput.readInt();
		perYear = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(itemId);
		objectOutput.writeInt(perMonth);
		objectOutput.writeInt(perYear);
	}

	public long id;
	public long itemId;
	public int perMonth;
	public int perYear;
}