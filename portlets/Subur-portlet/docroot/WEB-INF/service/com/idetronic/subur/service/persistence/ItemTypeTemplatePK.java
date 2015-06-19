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
public class ItemTypeTemplatePK implements Comparable<ItemTypeTemplatePK>,
	Serializable {
	public long itemTypeId;
	public long metadataPropertyId;

	public ItemTypeTemplatePK() {
	}

	public ItemTypeTemplatePK(long itemTypeId, long metadataPropertyId) {
		this.itemTypeId = itemTypeId;
		this.metadataPropertyId = metadataPropertyId;
	}

	public long getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public long getMetadataPropertyId() {
		return metadataPropertyId;
	}

	public void setMetadataPropertyId(long metadataPropertyId) {
		this.metadataPropertyId = metadataPropertyId;
	}

	@Override
	public int compareTo(ItemTypeTemplatePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (itemTypeId < pk.itemTypeId) {
			value = -1;
		}
		else if (itemTypeId > pk.itemTypeId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (metadataPropertyId < pk.metadataPropertyId) {
			value = -1;
		}
		else if (metadataPropertyId > pk.metadataPropertyId) {
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

		if (!(obj instanceof ItemTypeTemplatePK)) {
			return false;
		}

		ItemTypeTemplatePK pk = (ItemTypeTemplatePK)obj;

		if ((itemTypeId == pk.itemTypeId) &&
				(metadataPropertyId == pk.metadataPropertyId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(itemTypeId) +
		String.valueOf(metadataPropertyId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("itemTypeId");
		sb.append(StringPool.EQUAL);
		sb.append(itemTypeId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("metadataPropertyId");
		sb.append(StringPool.EQUAL);
		sb.append(metadataPropertyId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}