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
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;

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
public class MetadataPropertyValueClp extends BaseModelImpl<MetadataPropertyValue>
	implements MetadataPropertyValue {
	public MetadataPropertyValueClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataPropertyValue.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataPropertyValue.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _metadataPropertyValueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMetadataPropertyValueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _metadataPropertyValueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataPropertyValueId", getMetadataPropertyValueId());
		attributes.put("itemId", getItemId());
		attributes.put("propertyId", getPropertyId());
		attributes.put("textValue", getTextValue());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataPropertyValueId = (Long)attributes.get(
				"metadataPropertyValueId");

		if (metadataPropertyValueId != null) {
			setMetadataPropertyValueId(metadataPropertyValueId);
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

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	@Override
	public long getMetadataPropertyValueId() {
		return _metadataPropertyValueId;
	}

	@Override
	public void setMetadataPropertyValueId(long metadataPropertyValueId) {
		_metadataPropertyValueId = metadataPropertyValueId;

		if (_metadataPropertyValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyValueRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataPropertyValueId",
						long.class);

				method.invoke(_metadataPropertyValueRemoteModel,
					metadataPropertyValueId);
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

		if (_metadataPropertyValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyValueRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_metadataPropertyValueRemoteModel, itemId);
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

		if (_metadataPropertyValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyValueRemoteModel.getClass();

				Method method = clazz.getMethod("setPropertyId", long.class);

				method.invoke(_metadataPropertyValueRemoteModel, propertyId);
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

		if (_metadataPropertyValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyValueRemoteModel.getClass();

				Method method = clazz.getMethod("setTextValue", String.class);

				method.invoke(_metadataPropertyValueRemoteModel, textValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getItemCount() {
		return _itemCount;
	}

	@Override
	public void setItemCount(int itemCount) {
		_itemCount = itemCount;

		if (_metadataPropertyValueRemoteModel != null) {
			try {
				Class<?> clazz = _metadataPropertyValueRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCount", int.class);

				method.invoke(_metadataPropertyValueRemoteModel, itemCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMetadataPropertyValueRemoteModel() {
		return _metadataPropertyValueRemoteModel;
	}

	public void setMetadataPropertyValueRemoteModel(
		BaseModel<?> metadataPropertyValueRemoteModel) {
		_metadataPropertyValueRemoteModel = metadataPropertyValueRemoteModel;
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

		Class<?> remoteModelClass = _metadataPropertyValueRemoteModel.getClass();

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

		Object returnValue = method.invoke(_metadataPropertyValueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MetadataPropertyValueLocalServiceUtil.addMetadataPropertyValue(this);
		}
		else {
			MetadataPropertyValueLocalServiceUtil.updateMetadataPropertyValue(this);
		}
	}

	@Override
	public MetadataPropertyValue toEscapedModel() {
		return (MetadataPropertyValue)ProxyUtil.newProxyInstance(MetadataPropertyValue.class.getClassLoader(),
			new Class[] { MetadataPropertyValue.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MetadataPropertyValueClp clone = new MetadataPropertyValueClp();

		clone.setMetadataPropertyValueId(getMetadataPropertyValueId());
		clone.setItemId(getItemId());
		clone.setPropertyId(getPropertyId());
		clone.setTextValue(getTextValue());
		clone.setItemCount(getItemCount());

		return clone;
	}

	@Override
	public int compareTo(MetadataPropertyValue metadataPropertyValue) {
		long primaryKey = metadataPropertyValue.getPrimaryKey();

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

		if (!(obj instanceof MetadataPropertyValueClp)) {
			return false;
		}

		MetadataPropertyValueClp metadataPropertyValue = (MetadataPropertyValueClp)obj;

		long primaryKey = metadataPropertyValue.getPrimaryKey();

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

		sb.append("{metadataPropertyValueId=");
		sb.append(getMetadataPropertyValueId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", propertyId=");
		sb.append(getPropertyId());
		sb.append(", textValue=");
		sb.append(getTextValue());
		sb.append(", itemCount=");
		sb.append(getItemCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.MetadataPropertyValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>metadataPropertyValueId</column-name><column-value><![CDATA[");
		sb.append(getMetadataPropertyValueId());
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
		sb.append(
			"<column><column-name>itemCount</column-name><column-value><![CDATA[");
		sb.append(getItemCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _metadataPropertyValueId;
	private long _itemId;
	private long _propertyId;
	private String _textValue;
	private int _itemCount;
	private BaseModel<?> _metadataPropertyValueRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}