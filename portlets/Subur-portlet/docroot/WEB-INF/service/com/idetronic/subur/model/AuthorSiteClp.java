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

package com.idetronic.subur.model;

import com.idetronic.subur.service.AuthorSiteLocalServiceUtil;
import com.idetronic.subur.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class AuthorSiteClp extends BaseModelImpl<AuthorSite>
	implements AuthorSite {
	public AuthorSiteClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AuthorSite.class;
	}

	@Override
	public String getModelClassName() {
		return AuthorSite.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _authorSiteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAuthorSiteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _authorSiteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorSiteId", getAuthorSiteId());
		attributes.put("authorId", getAuthorId());
		attributes.put("siteName", getSiteName());
		attributes.put("siteURL", getSiteURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorSiteId = (Long)attributes.get("authorSiteId");

		if (authorSiteId != null) {
			setAuthorSiteId(authorSiteId);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String siteName = (String)attributes.get("siteName");

		if (siteName != null) {
			setSiteName(siteName);
		}

		String siteURL = (String)attributes.get("siteURL");

		if (siteURL != null) {
			setSiteURL(siteURL);
		}
	}

	@Override
	public long getAuthorSiteId() {
		return _authorSiteId;
	}

	@Override
	public void setAuthorSiteId(long authorSiteId) {
		_authorSiteId = authorSiteId;

		if (_authorSiteRemoteModel != null) {
			try {
				Class<?> clazz = _authorSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorSiteId", long.class);

				method.invoke(_authorSiteRemoteModel, authorSiteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_authorId = authorId;

		if (_authorSiteRemoteModel != null) {
			try {
				Class<?> clazz = _authorSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorId", long.class);

				method.invoke(_authorSiteRemoteModel, authorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSiteName() {
		return _siteName;
	}

	@Override
	public void setSiteName(String siteName) {
		_siteName = siteName;

		if (_authorSiteRemoteModel != null) {
			try {
				Class<?> clazz = _authorSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setSiteName", String.class);

				method.invoke(_authorSiteRemoteModel, siteName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSiteURL() {
		return _siteURL;
	}

	@Override
	public void setSiteURL(String siteURL) {
		_siteURL = siteURL;

		if (_authorSiteRemoteModel != null) {
			try {
				Class<?> clazz = _authorSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setSiteURL", String.class);

				method.invoke(_authorSiteRemoteModel, siteURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAuthorSiteRemoteModel() {
		return _authorSiteRemoteModel;
	}

	public void setAuthorSiteRemoteModel(BaseModel<?> authorSiteRemoteModel) {
		_authorSiteRemoteModel = authorSiteRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _authorSiteRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_authorSiteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AuthorSiteLocalServiceUtil.addAuthorSite(this);
		}
		else {
			AuthorSiteLocalServiceUtil.updateAuthorSite(this);
		}
	}

	@Override
	public AuthorSite toEscapedModel() {
		return (AuthorSite)ProxyUtil.newProxyInstance(AuthorSite.class.getClassLoader(),
			new Class[] { AuthorSite.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuthorSiteClp clone = new AuthorSiteClp();

		clone.setAuthorSiteId(getAuthorSiteId());
		clone.setAuthorId(getAuthorId());
		clone.setSiteName(getSiteName());
		clone.setSiteURL(getSiteURL());

		return clone;
	}

	@Override
	public int compareTo(AuthorSite authorSite) {
		long primaryKey = authorSite.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorSiteClp)) {
			return false;
		}

		AuthorSiteClp authorSite = (AuthorSiteClp)obj;

		long primaryKey = authorSite.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{authorSiteId=");
		sb.append(getAuthorSiteId());
		sb.append(", authorId=");
		sb.append(getAuthorId());
		sb.append(", siteName=");
		sb.append(getSiteName());
		sb.append(", siteURL=");
		sb.append(getSiteURL());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.AuthorSite");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>authorSiteId</column-name><column-value><![CDATA[");
		sb.append(getAuthorSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteName</column-name><column-value><![CDATA[");
		sb.append(getSiteName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteURL</column-name><column-value><![CDATA[");
		sb.append(getSiteURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _authorSiteId;
	private long _authorId;
	private String _siteName;
	private String _siteURL;
	private BaseModel<?> _authorSiteRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}