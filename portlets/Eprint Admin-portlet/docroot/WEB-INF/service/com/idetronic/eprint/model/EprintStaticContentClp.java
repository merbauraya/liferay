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

package com.idetronic.eprint.model;

import com.idetronic.eprint.service.ClpSerializer;
import com.idetronic.eprint.service.EprintStaticContentLocalServiceUtil;

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
public class EprintStaticContentClp extends BaseModelImpl<EprintStaticContent>
	implements EprintStaticContent {
	public EprintStaticContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EprintStaticContent.class;
	}

	@Override
	public String getModelClassName() {
		return EprintStaticContent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentId", getContentId());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public long getContentId() {
		return _contentId;
	}

	@Override
	public void setContentId(long contentId) {
		_contentId = contentId;

		if (_eprintStaticContentRemoteModel != null) {
			try {
				Class<?> clazz = _eprintStaticContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentId", long.class);

				method.invoke(_eprintStaticContentRemoteModel, contentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_eprintStaticContentRemoteModel != null) {
			try {
				Class<?> clazz = _eprintStaticContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_eprintStaticContentRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEprintStaticContentRemoteModel() {
		return _eprintStaticContentRemoteModel;
	}

	public void setEprintStaticContentRemoteModel(
		BaseModel<?> eprintStaticContentRemoteModel) {
		_eprintStaticContentRemoteModel = eprintStaticContentRemoteModel;
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

		Class<?> remoteModelClass = _eprintStaticContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eprintStaticContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EprintStaticContentLocalServiceUtil.addEprintStaticContent(this);
		}
		else {
			EprintStaticContentLocalServiceUtil.updateEprintStaticContent(this);
		}
	}

	@Override
	public EprintStaticContent toEscapedModel() {
		return (EprintStaticContent)ProxyUtil.newProxyInstance(EprintStaticContent.class.getClassLoader(),
			new Class[] { EprintStaticContent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EprintStaticContentClp clone = new EprintStaticContentClp();

		clone.setContentId(getContentId());
		clone.setContent(getContent());

		return clone;
	}

	@Override
	public int compareTo(EprintStaticContent eprintStaticContent) {
		long primaryKey = eprintStaticContent.getPrimaryKey();

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

		if (!(obj instanceof EprintStaticContentClp)) {
			return false;
		}

		EprintStaticContentClp eprintStaticContent = (EprintStaticContentClp)obj;

		long primaryKey = eprintStaticContent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{contentId=");
		sb.append(getContentId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eprint.model.EprintStaticContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contentId</column-name><column-value><![CDATA[");
		sb.append(getContentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contentId;
	private String _content;
	private BaseModel<?> _eprintStaticContentRemoteModel;
}