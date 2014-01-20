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

import com.idetronic.eprint.model.EprintStaticContent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing EprintStaticContent in entity cache.
 *
 * @author matle
 * @see EprintStaticContent
 * @generated
 */
public class EprintStaticContentCacheModel implements CacheModel<EprintStaticContent>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{contentId=");
		sb.append(contentId);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	public EprintStaticContent toEntityModel() {
		EprintStaticContentImpl eprintStaticContentImpl = new EprintStaticContentImpl();

		eprintStaticContentImpl.setContentId(contentId);

		if (content == null) {
			eprintStaticContentImpl.setContent(StringPool.BLANK);
		}
		else {
			eprintStaticContentImpl.setContent(content);
		}

		eprintStaticContentImpl.resetOriginalValues();

		return eprintStaticContentImpl;
	}

	public long contentId;
	public String content;
}