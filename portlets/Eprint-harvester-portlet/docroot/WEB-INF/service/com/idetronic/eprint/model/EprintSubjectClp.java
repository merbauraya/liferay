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

	public Class<?> getModelClass() {
		return EprintSubject.class;
	}

	public String getModelClassName() {
		return EprintSubject.class.getName();
	}

	public long getPrimaryKey() {
		return _eprintId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEprintId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_eprintId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("pos", getPos());
		attributes.put("subjects", getSubjects());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		Long pos = (Long)attributes.get("pos");

		if (pos != null) {
			setPos(pos);
		}

		String subjects = (String)attributes.get("subjects");

		if (subjects != null) {
			setSubjects(subjects);
		}
	}

	public long getEprintId() {
		return _eprintId;
	}

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

	public long getPos() {
		return _pos;
	}

	public void setPos(long pos) {
		_pos = pos;

		if (_eprintSubjectRemoteModel != null) {
			try {
				Class<?> clazz = _eprintSubjectRemoteModel.getClass();

				Method method = clazz.getMethod("setPos", long.class);

				method.invoke(_eprintSubjectRemoteModel, pos);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getSubjects() {
		return _subjects;
	}

	public void setSubjects(String subjects) {
		_subjects = subjects;

		if (_eprintSubjectRemoteModel != null) {
			try {
				Class<?> clazz = _eprintSubjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjects", String.class);

				method.invoke(_eprintSubjectRemoteModel, subjects);
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

	public EprintSubject toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		EprintSubjectClp clone = new EprintSubjectClp();

		clone.setEprintId(getEprintId());
		clone.setPos(getPos());
		clone.setSubjects(getSubjects());

		return clone;
	}

	public int compareTo(EprintSubject eprintSubject) {
		long primaryKey = eprintSubject.getPrimaryKey();

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

		if (!(obj instanceof EprintSubjectClp)) {
			return false;
		}

		EprintSubjectClp eprintSubject = (EprintSubjectClp)obj;

		long primaryKey = eprintSubject.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{eprintId=");
		sb.append(getEprintId());
		sb.append(", pos=");
		sb.append(getPos());
		sb.append(", subjects=");
		sb.append(getSubjects());
		sb.append("}");

		return sb.toString();
	}

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
			"<column><column-name>pos</column-name><column-value><![CDATA[");
		sb.append(getPos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjects</column-name><column-value><![CDATA[");
		sb.append(getSubjects());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eprintId;
	private long _pos;
	private String _subjects;
	private BaseModel<?> _eprintSubjectRemoteModel;
}