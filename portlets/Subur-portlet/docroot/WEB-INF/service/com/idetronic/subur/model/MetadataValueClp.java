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
import com.idetronic.subur.service.MetadataValueLocalServiceUtil;

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
public class MetadataValueClp extends BaseModelImpl<MetadataValue>
	implements MetadataValue {
	public MetadataValueClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataValue.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataValue.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _metadataValueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMetadataValueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _metadataValueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataValueId", getMetadataValueId());
		attributes.put("itemId", getItemId());
		attributes.put("propertyId", getPropertyId());
		attributes.put("textValue", getTextValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataValueId = (Long)attributes.get("metadataValueId");

		if (metadataValueId != null) {
			setMetadataValueId(metadataValueId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
		}

		String textValue = (String)attributes.get("textValue");

		if (textValue != null) {
			setTextValue(textValue);
		}
	}

	@Override
	public long getMetadataValueId() {
		return _metadataValueId;
	}

	@Override
	public void setMetadataValueId(long metadataValueId) {
		_metadataValueId = metadataValueId;

		if (_metadataValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataValueId", long.class);

				method.invoke(_metadataValueRemoteModel, metadataValueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_metadataValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_metadataValueRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPropertyId() {
		return _propertyId;
	}

	@Override
	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;

		if (_metadataValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueRemoteModel.getClass();

				Method method = clazz.getMethod("setPropertyId", long.class);

				method.invoke(_metadataValueRemoteModel, propertyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTextValue() {
		return _textValue;
	}

	@Override
	public void setTextValue(String textValue) {
		_textValue = textValue;

		if (_metadataValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueRemoteModel.getClass();

				Method method = clazz.getMethod("setTextValue", String.class);

				method.invoke(_metadataValueRemoteModel, textValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMetadataValueRemoteModel() {
		return _metadataValueRemoteModel;
	}

	public void setMetadataValueRemoteModel(
		BaseModel<?> metadataValueRemoteModel) {
		_metadataValueRemoteModel = metadataValueRemoteModel;
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

		Class<?> remoteModelClass = _metadataValueRemoteModel.getClass();

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

		Object returnValue = method.invoke(_metadataValueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MetadataValueLocalServiceUtil.addMetadataValue(this);
		}
		else {
			MetadataValueLocalServiceUtil.updateMetadataValue(this);
		}
	}

	@Override
	public MetadataValue toEscapedModel() {
		return (MetadataValue)ProxyUtil.newProxyInstance(MetadataValue.class.getClassLoader(),
			new Class[] { MetadataValue.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MetadataValueClp clone = new MetadataValueClp();

		clone.setMetadataValueId(getMetadataValueId());
		clone.setItemId(getItemId());
		clone.setPropertyId(getPropertyId());
		clone.setTextValue(getTextValue());

		return clone;
	}

	@Override
	public int compareTo(MetadataValue metadataValue) {
		long primaryKey = metadataValue.getPrimaryKey();

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

		if (!(obj instanceof MetadataValueClp)) {
			return false;
		}

		MetadataValueClp metadataValue = (MetadataValueClp)obj;

		long primaryKey = metadataValue.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{metadataValueId=");
		sb.append(getMetadataValueId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", propertyId=");
		sb.append(getPropertyId());
		sb.append(", textValue=");
		sb.append(getTextValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.MetadataValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>metadataValueId</column-name><column-value><![CDATA[");
		sb.append(getMetadataValueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propertyId</column-name><column-value><![CDATA[");
		sb.append(getPropertyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>textValue</column-name><column-value><![CDATA[");
		sb.append(getTextValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _metadataValueId;
	private long _itemId;
	private long _propertyId;
	private String _textValue;
	private BaseModel<?> _metadataValueRemoteModel;
}