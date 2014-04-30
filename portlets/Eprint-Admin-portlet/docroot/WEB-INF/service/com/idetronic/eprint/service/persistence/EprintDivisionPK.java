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

package com.idetronic.eprint.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Mazlan Mat
 */
public class EprintDivisionPK implements Comparable<EprintDivisionPK>,
	Serializable {
	public long eprintId;
	public String divisionId;

	public EprintDivisionPK() {
	}

	public EprintDivisionPK(long eprintId, String divisionId) {
		this.eprintId = eprintId;
		this.divisionId = divisionId;
	}

	public long getEprintId() {
		return eprintId;
	}

	public void setEprintId(long eprintId) {
		this.eprintId = eprintId;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	@Override
	public int compareTo(EprintDivisionPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (eprintId < pk.eprintId) {
			value = -1;
		}
		else if (eprintId > pk.eprintId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = divisionId.compareTo(pk.divisionId);

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

		if (!(obj instanceof EprintDivisionPK)) {
			return false;
		}

		EprintDivisionPK pk = (EprintDivisionPK)obj;

		if ((eprintId == pk.eprintId) && (divisionId.equals(pk.divisionId))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(eprintId) + String.valueOf(divisionId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("eprintId");
		sb.append(StringPool.EQUAL);
		sb.append(eprintId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("divisionId");
		sb.append(StringPool.EQUAL);
		sb.append(divisionId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}