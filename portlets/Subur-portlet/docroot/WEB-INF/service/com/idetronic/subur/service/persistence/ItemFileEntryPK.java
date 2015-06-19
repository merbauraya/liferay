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
public class ItemFileEntryPK implements Comparable<ItemFileEntryPK>,
	Serializable {
	public long itemId;
	public long fileEntryId;

	public ItemFileEntryPK() {
	}

	public ItemFileEntryPK(long itemId, long fileEntryId) {
		this.itemId = itemId;
		this.fileEntryId = fileEntryId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	@Override
	public int compareTo(ItemFileEntryPK pk) {
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

		if (fileEntryId < pk.fileEntryId) {
			value = -1;
		}
		else if (fileEntryId > pk.fileEntryId) {
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

		if (!(obj instanceof ItemFileEntryPK)) {
			return false;
		}

		ItemFileEntryPK pk = (ItemFileEntryPK)obj;

		if ((itemId == pk.itemId) && (fileEntryId == pk.fileEntryId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(itemId) + String.valueOf(fileEntryId)).hashCode();
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
		sb.append("fileEntryId");
		sb.append(StringPool.EQUAL);
		sb.append(fileEntryId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}