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

import com.idetronic.subur.model.AuthorSite;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AuthorSite in entity cache.
 *
 * @author Mazlan Mat
 * @see AuthorSite
 * @generated
 */
public class AuthorSiteCacheModel implements CacheModel<AuthorSite>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{authorSiteId=");
		sb.append(authorSiteId);
		sb.append(", authorId=");
		sb.append(authorId);
		sb.append(", siteName=");
		sb.append(siteName);
		sb.append(", siteURL=");
		sb.append(siteURL);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AuthorSite toEntityModel() {
		AuthorSiteImpl authorSiteImpl = new AuthorSiteImpl();

		authorSiteImpl.setAuthorSiteId(authorSiteId);
		authorSiteImpl.setAuthorId(authorId);

		if (siteName == null) {
			authorSiteImpl.setSiteName(StringPool.BLANK);
		}
		else {
			authorSiteImpl.setSiteName(siteName);
		}

		if (siteURL == null) {
			authorSiteImpl.setSiteURL(StringPool.BLANK);
		}
		else {
			authorSiteImpl.setSiteURL(siteURL);
		}

		authorSiteImpl.resetOriginalValues();

		return authorSiteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authorSiteId = objectInput.readLong();
		authorId = objectInput.readLong();
		siteName = objectInput.readUTF();
		siteURL = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(authorSiteId);
		objectOutput.writeLong(authorId);

		if (siteName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(siteName);
		}

		if (siteURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(siteURL);
		}
	}

	public long authorSiteId;
	public long authorId;
	public String siteName;
	public String siteURL;
}