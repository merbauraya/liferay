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
import com.idetronic.subur.service.MetadataSchemaLocalServiceUtil;

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
public class MetadataSchemaClp extends BaseModelImpl<MetadataSchema>
	implements MetadataSchema {
	public MetadataSchemaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataSchema.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataSchema.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _metadataSchemaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMetadataSchemaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _metadataSchemaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataSchemaId", getMetadataSchemaId());
		attributes.put("metadataName", getMetadataName());
		attributes.put("nameSpace", getNameSpace());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataSchemaId = (Long)attributes.get("metadataSchemaId");

		if (metadataSchemaId != null) {
			setMetadataSchemaId(metadataSchemaId);
		}

		String metadataName = (String)attributes.get("metadataName");

		if (metadataName != null) {
			setMetadataName(metadataName);
		}

		String nameSpace = (String)attributes.get("nameSpace");

		if (nameSpace != null) {
			setNameSpace(nameSpace);
		}
	}

	@Override
	public long getMetadataSchemaId() {
		return _metadataSchemaId;
	}

	@Override
	public void setMetadataSchemaId(long metadataSchemaId) {
		_metadataSchemaId = metadataSchemaId;

		if (_metadataSchemaRemoteModel != null) {
			try {
				Class<?> clazz = _metadataSchemaRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataSchemaId",
						long.class);

				method.invoke(_metadataSchemaRemoteModel, metadataSchemaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMetadataName() {
		return _metadataName;
	}

	@Override
	public void setMetadataName(String metadataName) {
		_metadataName = metadataName;

		if (_metadataSchemaRemoteModel != null) {
			try {
				Class<?> clazz = _metadataSchemaRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataName", String.class);

				method.invoke(_metadataSchemaRemoteModel, metadataName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNameSpace() {
		return _nameSpace;
	}

	@Override
	public void setNameSpace(String nameSpace) {
		_nameSpace = nameSpace;

		if (_metadataSchemaRemoteModel != null) {
			try {
				Class<?> clazz = _metadataSchemaRemoteModel.getClass();

				Method method = clazz.getMethod("setNameSpace", String.class);

				method.invoke(_metadataSchemaRemoteModel, nameSpace);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMetadataSchemaRemoteModel() {
		return _metadataSchemaRemoteModel;
	}

	public void setMetadataSchemaRemoteModel(
		BaseModel<?> metadataSchemaRemoteModel) {
		_metadataSchemaRemoteModel = metadataSchemaRemoteModel;
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

		Class<?> remoteModelClass = _metadataSchemaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_metadataSchemaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MetadataSchemaLocalServiceUtil.addMetadataSchema(this);
		}
		else {
			MetadataSchemaLocalServiceUtil.updateMetadataSchema(this);
		}
	}

	@Override
	public MetadataSchema toEscapedModel() {
		return (MetadataSchema)ProxyUtil.newProxyInstance(MetadataSchema.class.getClassLoader(),
			new Class[] { MetadataSchema.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MetadataSchemaClp clone = new MetadataSchemaClp();

		clone.setMetadataSchemaId(getMetadataSchemaId());
		clone.setMetadataName(getMetadataName());
		clone.setNameSpace(getNameSpace());

		return clone;
	}

	@Override
	public int compareTo(MetadataSchema metadataSchema) {
		long primaryKey = metadataSchema.getPrimaryKey();

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

		if (!(obj instanceof MetadataSchemaClp)) {
			return false;
		}

		MetadataSchemaClp metadataSchema = (MetadataSchemaClp)obj;

		long primaryKey = metadataSchema.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{metadataSchemaId=");
		sb.append(getMetadataSchemaId());
		sb.append(", metadataName=");
		sb.append(getMetadataName());
		sb.append(", nameSpace=");
		sb.append(getNameSpace());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.MetadataSchema");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>metadataSchemaId</column-name><column-value><![CDATA[");
		sb.append(getMetadataSchemaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataName</column-name><column-value><![CDATA[");
		sb.append(getMetadataName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameSpace</column-name><column-value><![CDATA[");
		sb.append(getNameSpace());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _metadataSchemaId;
	private String _metadataName;
	private String _nameSpace;
	private BaseModel<?> _metadataSchemaRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}