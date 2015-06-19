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

package com.idetronic.subur.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Mazlan Mat
 * @generated
 */
public class ItemDivisionPK implements Comparable<ItemDivisionPK>, Serializable {
	public long itemId;
	public long divisionId;

	public ItemDivisionPK() {
	}

	public ItemDivisionPK(long itemId, long divisionId) {
		this.itemId = itemId;
		this.divisionId = divisionId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(long divisionId) {
		this.divisionId = divisionId;
	}

	@Override
	public int compareTo(ItemDivisionPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (itemId < pk.itemId) {
			value = -1;
		}
		else if (itemId > pk.itemId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (divisionId < pk.divisionId) {
			value = -1;
		}
		else if (divisionId > pk.divisionId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemDivisionPK)) {
			return false;
		}

		ItemDivisionPK pk = (ItemDivisionPK)obj;

		if ((itemId == pk.itemId) && (divisionId == pk.divisionId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(itemId) + String.valueOf(divisionId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("itemId");
		sb.append(StringPool.EQUAL);
		sb.append(itemId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("divisionId");
		sb.append(StringPool.EQUAL);
		sb.append(divisionId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}