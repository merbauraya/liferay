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
 * @author matle
 */
public class EprintSubjectPK implements Comparable<EprintSubjectPK>,
	Serializable {
	public long eprintId;
	public String subjectId;

	public EprintSubjectPK() {
	}

	public EprintSubjectPK(long eprintId, String subjectId) {
		this.eprintId = eprintId;
		this.subjectId = subjectId;
	}

	public long getEprintId() {
		return eprintId;
	}

	public void setEprintId(long eprintId) {
		this.eprintId = eprintId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public int compareTo(EprintSubjectPK pk) {
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

		value = subjectId.compareTo(pk.subjectId);

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

		if (!(obj instanceof EprintSubjectPK)) {
			return false;
		}

		EprintSubjectPK pk = (EprintSubjectPK)obj;

		if ((eprintId == pk.eprintId) && (subjectId.equals(pk.subjectId))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(eprintId) + String.valueOf(subjectId)).hashCode();
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
		sb.append("subjectId");
		sb.append(StringPool.EQUAL);
		sb.append(subjectId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}