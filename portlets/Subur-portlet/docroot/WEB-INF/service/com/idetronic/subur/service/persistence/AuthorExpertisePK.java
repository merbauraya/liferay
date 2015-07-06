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
public class AuthorExpertisePK implements Comparable<AuthorExpertisePK>,
	Serializable {
	public long authorId;
	public long expertiseId;

	public AuthorExpertisePK() {
	}

	public AuthorExpertisePK(long authorId, long expertiseId) {
		this.authorId = authorId;
		this.expertiseId = expertiseId;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public long getExpertiseId() {
		return expertiseId;
	}

	public void setExpertiseId(long expertiseId) {
		this.expertiseId = expertiseId;
	}

	@Override
	public int compareTo(AuthorExpertisePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (authorId < pk.authorId) {
			value = -1;
		}
		else if (authorId > pk.authorId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (expertiseId < pk.expertiseId) {
			value = -1;
		}
		else if (expertiseId > pk.expertiseId) {
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

		if (!(obj instanceof AuthorExpertisePK)) {
			return false;
		}

		AuthorExpertisePK pk = (AuthorExpertisePK)obj;

		if ((authorId == pk.authorId) && (expertiseId == pk.expertiseId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(authorId) + String.valueOf(expertiseId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("authorId");
		sb.append(StringPool.EQUAL);
		sb.append(authorId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("expertiseId");
		sb.append(StringPool.EQUAL);
		sb.append(expertiseId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}