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
import com.idetronic.subur.service.DivisionLocalServiceUtil;

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
public class DivisionClp extends BaseModelImpl<Division> implements Division {
	public DivisionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Division.class;
	}

	@Override
	public String getModelClassName() {
		return Division.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _divisionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDivisionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _divisionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("divisionId", getDivisionId());
		attributes.put("parentId", getParentId());
		attributes.put("divisionName", getDivisionName());
		attributes.put("depositable", getDepositable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long divisionId = (Long)attributes.get("divisionId");

		if (divisionId != null) {
			setDivisionId(divisionId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String divisionName = (String)attributes.get("divisionName");

		if (divisionName != null) {
			setDivisionName(divisionName);
		}

		Boolean depositable = (Boolean)attributes.get("depositable");

		if (depositable != null) {
			setDepositable(depositable);
		}
	}

	@Override
	public long getDivisionId() {
		return _divisionId;
	}

	@Override
	public void setDivisionId(long divisionId) {
		_divisionId = divisionId;

		if (_divisionRemoteModel != null) {
			try {
				Class<?> clazz = _divisionRemoteModel.getClass();

				Method method = clazz.getMethod("setDivisionId", long.class);

				method.invoke(_divisionRemoteModel, divisionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_divisionRemoteModel != null) {
			try {
				Class<?> clazz = _divisionRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_divisionRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDivisionName() {
		return _divisionName;
	}

	@Override
	public void setDivisionName(String divisionName) {
		_divisionName = divisionName;

		if (_divisionRemoteModel != null) {
			try {
				Class<?> clazz = _divisionRemoteModel.getClass();

				Method method = clazz.getMethod("setDivisionName", String.class);

				method.invoke(_divisionRemoteModel, divisionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDepositable() {
		return _depositable;
	}

	@Override
	public boolean isDepositable() {
		return _depositable;
	}

	@Override
	public void setDepositable(boolean depositable) {
		_depositable = depositable;

		if (_divisionRemoteModel != null) {
			try {
				Class<?> clazz = _divisionRemoteModel.getClass();

				Method method = clazz.getMethod("setDepositable", boolean.class);

				method.invoke(_divisionRemoteModel, depositable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDivisionRemoteModel() {
		return _divisionRemoteModel;
	}

	public void setDivisionRemoteModel(BaseModel<?> divisionRemoteModel) {
		_divisionRemoteModel = divisionRemoteModel;
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

		Class<?> remoteModelClass = _divisionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_divisionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DivisionLocalServiceUtil.addDivision(this);
		}
		else {
			DivisionLocalServiceUtil.updateDivision(this);
		}
	}

	@Override
	public Division toEscapedModel() {
		return (Division)ProxyUtil.newProxyInstance(Division.class.getClassLoader(),
			new Class[] { Division.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DivisionClp clone = new DivisionClp();

		clone.setDivisionId(getDivisionId());
		clone.setParentId(getParentId());
		clone.setDivisionName(getDivisionName());
		clone.setDepositable(getDepositable());

		return clone;
	}

	@Override
	public int compareTo(Division division) {
		long primaryKey = division.getPrimaryKey();

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

		if (!(obj instanceof DivisionClp)) {
			return false;
		}

		DivisionClp division = (DivisionClp)obj;

		long primaryKey = division.getPrimaryKey();

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

		sb.append("{divisionId=");
		sb.append(getDivisionId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", divisionName=");
		sb.append(getDivisionName());
		sb.append(", depositable=");
		sb.append(getDepositable());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.Division");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>divisionId</column-name><column-value><![CDATA[");
		sb.append(getDivisionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>divisionName</column-name><column-value><![CDATA[");
		sb.append(getDivisionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depositable</column-name><column-value><![CDATA[");
		sb.append(getDepositable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _divisionId;
	private long _parentId;
	private String _divisionName;
	private boolean _depositable;
	private BaseModel<?> _divisionRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}