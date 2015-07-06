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

import com.idetronic.subur.service.AuthorExpertiseLocalServiceUtil;
import com.idetronic.subur.service.ClpSerializer;
import com.idetronic.subur.service.persistence.AuthorExpertisePK;

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
public class AuthorExpertiseClp extends BaseModelImpl<AuthorExpertise>
	implements AuthorExpertise {
	public AuthorExpertiseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AuthorExpertise.class;
	}

	@Override
	public String getModelClassName() {
		return AuthorExpertise.class.getName();
	}

	@Override
	public AuthorExpertisePK getPrimaryKey() {
		return new AuthorExpertisePK(_authorId, _expertiseId);
	}

	@Override
	public void setPrimaryKey(AuthorExpertisePK primaryKey) {
		setAuthorId(primaryKey.authorId);
		setExpertiseId(primaryKey.expertiseId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AuthorExpertisePK(_authorId, _expertiseId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AuthorExpertisePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("expertiseId", getExpertiseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long expertiseId = (Long)attributes.get("expertiseId");

		if (expertiseId != null) {
			setExpertiseId(expertiseId);
		}
	}

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_authorId = authorId;

		if (_authorExpertiseRemoteModel != null) {
			try {
				Class<?> clazz = _authorExpertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorId", long.class);

				method.invoke(_authorExpertiseRemoteModel, authorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getExpertiseId() {
		return _expertiseId;
	}

	@Override
	public void setExpertiseId(long expertiseId) {
		_expertiseId = expertiseId;

		if (_authorExpertiseRemoteModel != null) {
			try {
				Class<?> clazz = _authorExpertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setExpertiseId", long.class);

				method.invoke(_authorExpertiseRemoteModel, expertiseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAuthorExpertiseRemoteModel() {
		return _authorExpertiseRemoteModel;
	}

	public void setAuthorExpertiseRemoteModel(
		BaseModel<?> authorExpertiseRemoteModel) {
		_authorExpertiseRemoteModel = authorExpertiseRemoteModel;
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

		Class<?> remoteModelClass = _authorExpertiseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_authorExpertiseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AuthorExpertiseLocalServiceUtil.addAuthorExpertise(this);
		}
		else {
			AuthorExpertiseLocalServiceUtil.updateAuthorExpertise(this);
		}
	}

	@Override
	public AuthorExpertise toEscapedModel() {
		return (AuthorExpertise)ProxyUtil.newProxyInstance(AuthorExpertise.class.getClassLoader(),
			new Class[] { AuthorExpertise.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuthorExpertiseClp clone = new AuthorExpertiseClp();

		clone.setAuthorId(getAuthorId());
		clone.setExpertiseId(getExpertiseId());

		return clone;
	}

	@Override
	public int compareTo(AuthorExpertise authorExpertise) {
		AuthorExpertisePK primaryKey = authorExpertise.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorExpertiseClp)) {
			return false;
		}

		AuthorExpertiseClp authorExpertise = (AuthorExpertiseClp)obj;

		AuthorExpertisePK primaryKey = authorExpertise.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{authorId=");
		sb.append(getAuthorId());
		sb.append(", expertiseId=");
		sb.append(getExpertiseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.AuthorExpertise");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expertiseId</column-name><column-value><![CDATA[");
		sb.append(getExpertiseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _authorId;
	private long _expertiseId;
	private BaseModel<?> _authorExpertiseRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}