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
import com.idetronic.subur.service.MetadataValueViewLocalServiceUtil;
import com.idetronic.subur.service.persistence.MetadataValueViewPK;

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
public class MetadataValueViewClp extends BaseModelImpl<MetadataValueView>
	implements MetadataValueView {
	public MetadataValueViewClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataValueView.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataValueView.class.getName();
	}

	@Override
	public MetadataValueViewPK getPrimaryKey() {
		return new MetadataValueViewPK(_propertyId, _subjectId);
	}

	@Override
	public void setPrimaryKey(MetadataValueViewPK primaryKey) {
		setPropertyId(primaryKey.propertyId);
		setSubjectId(primaryKey.subjectId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new MetadataValueViewPK(_propertyId, _subjectId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((MetadataValueViewPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertyId", getPropertyId());
		attributes.put("subjectId", getSubjectId());
		attributes.put("subjectName", getSubjectName());
		attributes.put("textValue", getTextValue());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
		}

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
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
	public long getPropertyId() {
		return _propertyId;
	}

	@Override
	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;

		if (_metadataValueViewRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueViewRemoteModel.getClass();

				Method method = clazz.getMethod("setPropertyId", long.class);

				method.invoke(_metadataValueViewRemoteModel, propertyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;

		if (_metadataValueViewRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueViewRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectId", long.class);

				method.invoke(_metadataValueViewRemoteModel, subjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectName() {
		return _subjectName;
	}

	@Override
	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;

		if (_metadataValueViewRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueViewRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectName", String.class);

				method.invoke(_metadataValueViewRemoteModel, subjectName);
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

		if (_metadataValueViewRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueViewRemoteModel.getClass();

				Method method = clazz.getMethod("setTextValue", String.class);

				method.invoke(_metadataValueViewRemoteModel, textValue);
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

		if (_metadataValueViewRemoteModel != null) {
			try {
				Class<?> clazz = _metadataValueViewRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCount", int.class);

				method.invoke(_metadataValueViewRemoteModel, itemCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMetadataValueViewRemoteModel() {
		return _metadataValueViewRemoteModel;
	}

	public void setMetadataValueViewRemoteModel(
		BaseModel<?> metadataValueViewRemoteModel) {
		_metadataValueViewRemoteModel = metadataValueViewRemoteModel;
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

		Class<?> remoteModelClass = _metadataValueViewRemoteModel.getClass();

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

		Object returnValue = method.invoke(_metadataValueViewRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MetadataValueViewLocalServiceUtil.addMetadataValueView(this);
		}
		else {
			MetadataValueViewLocalServiceUtil.updateMetadataValueView(this);
		}
	}

	@Override
	public MetadataValueView toEscapedModel() {
		return (MetadataValueView)ProxyUtil.newProxyInstance(MetadataValueView.class.getClassLoader(),
			new Class[] { MetadataValueView.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MetadataValueViewClp clone = new MetadataValueViewClp();

		clone.setPropertyId(getPropertyId());
		clone.setSubjectId(getSubjectId());
		clone.setSubjectName(getSubjectName());
		clone.setTextValue(getTextValue());
		clone.setItemCount(getItemCount());

		return clone;
	}

	@Override
	public int compareTo(MetadataValueView metadataValueView) {
		MetadataValueViewPK primaryKey = metadataValueView.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataValueViewClp)) {
			return false;
		}

		MetadataValueViewClp metadataValueView = (MetadataValueViewClp)obj;

		MetadataValueViewPK primaryKey = metadataValueView.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{propertyId=");
		sb.append(getPropertyId());
		sb.append(", subjectId=");
		sb.append(getSubjectId());
		sb.append(", subjectName=");
		sb.append(getSubjectName());
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
		sb.append("com.idetronic.subur.model.MetadataValueView");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>propertyId</column-name><column-value><![CDATA[");
		sb.append(getPropertyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectId</column-name><column-value><![CDATA[");
		sb.append(getSubjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectName</column-name><column-value><![CDATA[");
		sb.append(getSubjectName());
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

	private long _propertyId;
	private long _subjectId;
	private String _subjectName;
	private String _textValue;
	private int _itemCount;
	private BaseModel<?> _metadataValueViewRemoteModel;
}