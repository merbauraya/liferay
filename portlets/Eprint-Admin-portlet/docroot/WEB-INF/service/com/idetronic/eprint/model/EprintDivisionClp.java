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
import com.idetronic.eprint.service.EprintDivisionLocalServiceUtil;
import com.idetronic.eprint.service.persistence.EprintDivisionPK;

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
public class EprintDivisionClp extends BaseModelImpl<EprintDivision>
	implements EprintDivision {
	public EprintDivisionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EprintDivision.class;
	}

	@Override
	public String getModelClassName() {
		return EprintDivision.class.getName();
	}

	@Override
	public EprintDivisionPK getPrimaryKey() {
		return new EprintDivisionPK(_eprintId, _divisionId);
	}

	@Override
	public void setPrimaryKey(EprintDivisionPK primaryKey) {
		setEprintId(primaryKey.eprintId);
		setDivisionId(primaryKey.divisionId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new EprintDivisionPK(_eprintId, _divisionId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((EprintDivisionPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("divisionId", getDivisionId());
		attributes.put("divisionName", getDivisionName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		String divisionId = (String)attributes.get("divisionId");

		if (divisionId != null) {
			setDivisionId(divisionId);
		}

		String divisionName = (String)attributes.get("divisionName");

		if (divisionName != null) {
			setDivisionName(divisionName);
		}
	}

	@Override
	public long getEprintId() {
		return _eprintId;
	}

	@Override
	public void setEprintId(long eprintId) {
		_eprintId = eprintId;

		if (_eprintDivisionRemoteModel != null) {
			try {
				Class<?> clazz = _eprintDivisionRemoteModel.getClass();

				Method method = clazz.getMethod("setEprintId", long.class);

				method.invoke(_eprintDivisionRemoteModel, eprintId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDivisionId() {
		return _divisionId;
	}

	@Override
	public void setDivisionId(String divisionId) {
		_divisionId = divisionId;

		if (_eprintDivisionRemoteModel != null) {
			try {
				Class<?> clazz = _eprintDivisionRemoteModel.getClass();

				Method method = clazz.getMethod("setDivisionId", String.class);

				method.invoke(_eprintDivisionRemoteModel, divisionId);
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

		if (_eprintDivisionRemoteModel != null) {
			try {
				Class<?> clazz = _eprintDivisionRemoteModel.getClass();

				Method method = clazz.getMethod("setDivisionName", String.class);

				method.invoke(_eprintDivisionRemoteModel, divisionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEprintDivisionRemoteModel() {
		return _eprintDivisionRemoteModel;
	}

	public void setEprintDivisionRemoteModel(
		BaseModel<?> eprintDivisionRemoteModel) {
		_eprintDivisionRemoteModel = eprintDivisionRemoteModel;
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

		Class<?> remoteModelClass = _eprintDivisionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eprintDivisionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EprintDivisionLocalServiceUtil.addEprintDivision(this);
		}
		else {
			EprintDivisionLocalServiceUtil.updateEprintDivision(this);
		}
	}

	@Override
	public EprintDivision toEscapedModel() {
		return (EprintDivision)ProxyUtil.newProxyInstance(EprintDivision.class.getClassLoader(),
			new Class[] { EprintDivision.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EprintDivisionClp clone = new EprintDivisionClp();

		clone.setEprintId(getEprintId());
		clone.setDivisionId(getDivisionId());
		clone.setDivisionName(getDivisionName());

		return clone;
	}

	@Override
	public int compareTo(EprintDivision eprintDivision) {
		EprintDivisionPK primaryKey = eprintDivision.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprintDivisionClp)) {
			return false;
		}

		EprintDivisionClp eprintDivision = (EprintDivisionClp)obj;

		EprintDivisionPK primaryKey = eprintDivision.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{eprintId=");
		sb.append(getEprintId());
		sb.append(", divisionId=");
		sb.append(getDivisionId());
		sb.append(", divisionName=");
		sb.append(getDivisionName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eprint.model.EprintDivision");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eprintId</column-name><column-value><![CDATA[");
		sb.append(getEprintId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>divisionId</column-name><column-value><![CDATA[");
		sb.append(getDivisionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>divisionName</column-name><column-value><![CDATA[");
		sb.append(getDivisionName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eprintId;
	private String _divisionId;
	private String _divisionName;
	private BaseModel<?> _eprintDivisionRemoteModel;
}