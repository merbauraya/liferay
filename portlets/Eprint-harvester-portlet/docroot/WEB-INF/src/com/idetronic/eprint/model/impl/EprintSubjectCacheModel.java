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

import java.io.Serializable;

/**
 * The cache model class for representing EprintSubject in entity cache.
 *
 * @author Mazlan Mat
 * @see EprintSubject
 * @generated
 */
public class EprintSubjectCacheModel implements CacheModel<EprintSubject>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{eprintId=");
		sb.append(eprintId);
		sb.append(", pos=");
		sb.append(pos);
		sb.append(", subjects=");
		sb.append(subjects);
		sb.append("}");

		return sb.toString();
	}

	public EprintSubject toEntityModel() {
		EprintSubjectImpl eprintSubjectImpl = new EprintSubjectImpl();

		eprintSubjectImpl.setEprintId(eprintId);
		eprintSubjectImpl.setPos(pos);

		if (subjects == null) {
			eprintSubjectImpl.setSubjects(StringPool.BLANK);
		}
		else {
			eprintSubjectImpl.setSubjects(subjects);
		}

		eprintSubjectImpl.resetOriginalValues();

		return eprintSubjectImpl;
	}

	public long eprintId;
	public long pos;
	public String subjects;
}