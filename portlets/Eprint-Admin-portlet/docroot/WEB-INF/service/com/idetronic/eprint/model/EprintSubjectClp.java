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
import com.idetronic.eprint.service.EprintSubjectLocalServiceUtil;
import com.idetronic.eprint.service.persistence.EprintSubjectPK;

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
public class EprintSubjectClp extends BaseModelImpl<EprintSubject>
	implements EprintSubject {
	public EprintSubjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EprintSubject.class;
	}

	@Override
	public String getModelClassName() {
		return EprintSubject.class.getName();
	}

	@Override
	public EprintSubjectPK getPrimaryKey() {
		return new EprintSubjectPK(_eprintId, _subjectId);
	}

	@Override
	public void setPrimaryKey(EprintSubjectPK primaryKey) {
		setEprintId(primaryKey.eprintId);
		setSubjectId(primaryKey.subjectId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new EprintSubjectPK(_eprintId, _subjectId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((EprintSubjectPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("subjectId", getSubjectId());
		attributes.put("subjectName", getSubjectName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		String subjectId = (String)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
		}
	}

	@Override
	public long getEprintId() {
		return _eprintId;
	}

	@Override
	public void setEprintId(long eprintId) {
		_eprintId = eprintId;

		if (_eprintSubjectRemoteModel != null) {
			try {
				Class<?> clazz = _eprintSubjectRemoteModel.getClass();

				Method method = clazz.getMethod("setEprintId", long.class);

				method.invoke(_eprintSubjectRemoteModel, eprintId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(String subjectId) {
		_subjectId = subjectId;

		if (_eprintSubjectRemoteModel != null) {
			try {
				Class<?> clazz = _eprintSubjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectId", String.class);

				method.invoke(_eprintSubjectRemoteModel, subjectId);
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

		if (_eprintSubjectRemoteModel != null) {
			try {
				Class<?> clazz = _eprintSubjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectName", String.class);

				method.invoke(_eprintSubjectRemoteModel, subjectName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEprintSubjectRemoteModel() {
		return _eprintSubjectRemoteModel;
	}

	public void setEprintSubjectRemoteModel(
		BaseModel<?> eprintSubjectRemoteModel) {
		_eprintSubjectRemoteModel = eprintSubjectRemoteModel;
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

		Class<?> remoteModelClass = _eprintSubjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eprintSubjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EprintSubjectLocalServiceUtil.addEprintSubject(this);
		}
		else {
			EprintSubjectLocalServiceUtil.updateEprintSubject(this);
		}
	}

	@Override
	public EprintSubject toEscapedModel() {
		return (EprintSubject)ProxyUtil.newProxyInstance(EprintSubject.class.getClassLoader(),
			new Class[] { EprintSubject.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EprintSubjectClp clone = new EprintSubjectClp();

		clone.setEprintId(getEprintId());
		clone.setSubjectId(getSubjectId());
		clone.setSubjectName(getSubjectName());

		return clone;
	}

	@Override
	public int compareTo(EprintSubject eprintSubject) {
		EprintSubjectPK primaryKey = eprintSubject.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprintSubjectClp)) {
			return false;
		}

		EprintSubjectClp eprintSubject = (EprintSubjectClp)obj;

		EprintSubjectPK primaryKey = eprintSubject.getPrimaryKey();

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
		sb.append(", subjectId=");
		sb.append(getSubjectId());
		sb.append(", subjectName=");
		sb.append(getSubjectName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eprint.model.EprintSubject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eprintId</column-name><column-value><![CDATA[");
		sb.append(getEprintId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectId</column-name><column-value><![CDATA[");
		sb.append(getSubjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectName</column-name><column-value><![CDATA[");
		sb.append(getSubjectName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eprintId;
	private String _subjectId;
	private String _subjectName;
	private BaseModel<?> _eprintSubjectRemoteModel;
}