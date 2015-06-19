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

import com.idetronic.subur.service.ClpSerializer;
import com.idetronic.subur.service.MetadataPropertyLocalServiceUtil;

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
public class MetadataPropertyClp extends BaseModelImpl<MetadataProperty>
	implements MetadataProperty {
	public MetadataPropertyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataProperty.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataProperty.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _metadataPropertyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMetadataPropertyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _metadataPropertyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataPropertyId", getMetadataPropertyId());
		attributes.put("metadataSchemaId", getMetadataSchemaId());
		attributes.put("element", getElement());
		attributes.put("scope", getScope());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataPropertyId = (Long)attributes.get("metadataPropertyId");

		if (metadataPropertyId != null) {
			setMetadataPropertyId(metadataPropertyId);
		}

		Long metadataSchemaId = (Long)attributes.get("metadataSchemaId");

		if (metadataSchemaId != null) {
			setMetadataSchemaId(metadataSchemaId);
		}

		String element = (String)attributes.get("element");

		if (element != null) {
			setElement(element);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public long getMetadataPropertyId() {
		return _metadataPropertyId;
	}

	@Override
	public void setMetadataPropertyId(long metadataPropertyId) {
		_metadataPropertyId = metadataPropertyId;

		if (_metadataPropertyRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataPropertyId",
						long.class);

				method.invoke(_metadataPropertyRemoteModel, metadataPropertyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMetadataSchemaId() {
		return _metadataSchemaId;
	}

	@Override
	public void setMetadataSchemaId(long metadataSchemaId) {
		_metadataSchemaId = metadataSchemaId;

		if (_metadataPropertyRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataSchemaId",
						long.class);

				method.invoke(_metadataPropertyRemoteModel, metadataSchemaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getElement() {
		return _element;
	}

	@Override
	public void setElement(String element) {
		_element = element;

		if (_metadataPropertyRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyRemoteModel.getClass();

				Method method = clazz.getMethod("setElement", String.class);

				method.invoke(_metadataPropertyRemoteModel, element);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScope() {
		return _scope;
	}

	@Override
	public void setScope(String scope) {
		_scope = scope;

		if (_metadataPropertyRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyRemoteModel.getClass();

				Method method = clazz.getMethod("setScope", String.class);

				method.invoke(_metadataPropertyRemoteModel, scope);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_metadataPropertyRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_metadataPropertyRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMetadataPropertyRemoteModel() {
		return _metadataPropertyRemoteModel;
	}

	public void setMetadataPropertyRemoteModel(
		BaseModel<?> metadataPropertyRemoteModel) {
		_metadataPropertyRemoteModel = metadataPropertyRemoteModel;
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

		Class<?> remoteModelClass = _metadataPropertyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_metadataPropertyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MetadataPropertyLocalServiceUtil.addMetadataProperty(this);
		}
		else {
			MetadataPropertyLocalServiceUtil.updateMetadataProperty(this);
		}
	}

	@Override
	public MetadataProperty toEscapedModel() {
		return (MetadataProperty)ProxyUtil.newProxyInstance(MetadataProperty.class.getClassLoader(),
			new Class[] { MetadataProperty.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MetadataPropertyClp clone = new MetadataPropertyClp();

		clone.setMetadataPropertyId(getMetadataPropertyId());
		clone.setMetadataSchemaId(getMetadataSchemaId());
		clone.setElement(getElement());
		clone.setScope(getScope());
		clone.setNote(getNote());

		return clone;
	}

	@Override
	public int compareTo(MetadataProperty metadataProperty) {
		long primaryKey = metadataProperty.getPrimaryKey();

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

		if (!(obj instanceof MetadataPropertyClp)) {
			return false;
		}

		MetadataPropertyClp metadataProperty = (MetadataPropertyClp)obj;

		long primaryKey = metadataProperty.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{metadataPropertyId=");
		sb.append(getMetadataPropertyId());
		sb.append(", metadataSchemaId=");
		sb.append(getMetadataSchemaId());
		sb.append(", element=");
		sb.append(getElement());
		sb.append(", scope=");
		sb.append(getScope());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.MetadataProperty");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>metadataPropertyId</column-name><column-value><![CDATA[");
		sb.append(getMetadataPropertyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataSchemaId</column-name><column-value><![CDATA[");
		sb.append(getMetadataSchemaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>element</column-name><column-value><![CDATA[");
		sb.append(getElement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scope</column-name><column-value><![CDATA[");
		sb.append(getScope());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _metadataPropertyId;
	private long _metadataSchemaId;
	private String _element;
	private String _scope;
	private String _note;
	private BaseModel<?> _metadataPropertyRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}