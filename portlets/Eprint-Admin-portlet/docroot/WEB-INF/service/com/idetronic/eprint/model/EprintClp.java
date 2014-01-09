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
import com.idetronic.eprint.service.EprintLocalServiceUtil;

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
 * @author matle
 */
public class EprintClp extends BaseModelImpl<Eprint> implements Eprint {
	public EprintClp() {
	}

	public Class<?> getModelClass() {
		return Eprint.class;
	}

	public String getModelClassName() {
		return Eprint.class.getName();
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
		attributes.put("title", getTitle());
		attributes.put("eprintType", getEprintType());
		attributes.put("eprintStatus", getEprintStatus());
		attributes.put("metadataVisibility", getMetadataVisibility());
		attributes.put("eprintAbstract", getEprintAbstract());
		attributes.put("eprintKeywords", getEprintKeywords());
		attributes.put("isPublished", getIsPublished());
		attributes.put("dateYear", getDateYear());
		attributes.put("fullTextStatus", getFullTextStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String eprintType = (String)attributes.get("eprintType");

		if (eprintType != null) {
			setEprintType(eprintType);
		}

		String eprintStatus = (String)attributes.get("eprintStatus");

		if (eprintStatus != null) {
			setEprintStatus(eprintStatus);
		}

		String metadataVisibility = (String)attributes.get("metadataVisibility");

		if (metadataVisibility != null) {
			setMetadataVisibility(metadataVisibility);
		}

		String eprintAbstract = (String)attributes.get("eprintAbstract");

		if (eprintAbstract != null) {
			setEprintAbstract(eprintAbstract);
		}

		String eprintKeywords = (String)attributes.get("eprintKeywords");

		if (eprintKeywords != null) {
			setEprintKeywords(eprintKeywords);
		}

		String isPublished = (String)attributes.get("isPublished");

		if (isPublished != null) {
			setIsPublished(isPublished);
		}

		String dateYear = (String)attributes.get("dateYear");

		if (dateYear != null) {
			setDateYear(dateYear);
		}

		String fullTextStatus = (String)attributes.get("fullTextStatus");

		if (fullTextStatus != null) {
			setFullTextStatus(fullTextStatus);
		}
	}

	public long getEprintId() {
		return _eprintId;
	}

	public void setEprintId(long eprintId) {
		_eprintId = eprintId;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setEprintId", long.class);

				method.invoke(_eprintRemoteModel, eprintId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_eprintRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEprintType() {
		return _eprintType;
	}

	public void setEprintType(String eprintType) {
		_eprintType = eprintType;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setEprintType", String.class);

				method.invoke(_eprintRemoteModel, eprintType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEprintStatus() {
		return _eprintStatus;
	}

	public void setEprintStatus(String eprintStatus) {
		_eprintStatus = eprintStatus;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setEprintStatus", String.class);

				method.invoke(_eprintRemoteModel, eprintStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getMetadataVisibility() {
		return _metadataVisibility;
	}

	public void setMetadataVisibility(String metadataVisibility) {
		_metadataVisibility = metadataVisibility;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataVisibility",
						String.class);

				method.invoke(_eprintRemoteModel, metadataVisibility);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEprintAbstract() {
		return _eprintAbstract;
	}

	public void setEprintAbstract(String eprintAbstract) {
		_eprintAbstract = eprintAbstract;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setEprintAbstract",
						String.class);

				method.invoke(_eprintRemoteModel, eprintAbstract);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEprintKeywords() {
		return _eprintKeywords;
	}

	public void setEprintKeywords(String eprintKeywords) {
		_eprintKeywords = eprintKeywords;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setEprintKeywords",
						String.class);

				method.invoke(_eprintRemoteModel, eprintKeywords);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getIsPublished() {
		return _isPublished;
	}

	public void setIsPublished(String isPublished) {
		_isPublished = isPublished;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPublished", String.class);

				method.invoke(_eprintRemoteModel, isPublished);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getDateYear() {
		return _dateYear;
	}

	public void setDateYear(String dateYear) {
		_dateYear = dateYear;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setDateYear", String.class);

				method.invoke(_eprintRemoteModel, dateYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getFullTextStatus() {
		return _fullTextStatus;
	}

	public void setFullTextStatus(String fullTextStatus) {
		_fullTextStatus = fullTextStatus;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setFullTextStatus",
						String.class);

				method.invoke(_eprintRemoteModel, fullTextStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEprintRemoteModel() {
		return _eprintRemoteModel;
	}

	public void setEprintRemoteModel(BaseModel<?> eprintRemoteModel) {
		_eprintRemoteModel = eprintRemoteModel;
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

		Class<?> remoteModelClass = _eprintRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eprintRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EprintLocalServiceUtil.addEprint(this);
		}
		else {
			EprintLocalServiceUtil.updateEprint(this);
		}
	}

	@Override
	public Eprint toEscapedModel() {
		return (Eprint)ProxyUtil.newProxyInstance(Eprint.class.getClassLoader(),
			new Class[] { Eprint.class }, new AutoEscapeBeanHandler(this));
	}

	public Eprint toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		EprintClp clone = new EprintClp();

		clone.setEprintId(getEprintId());
		clone.setTitle(getTitle());
		clone.setEprintType(getEprintType());
		clone.setEprintStatus(getEprintStatus());
		clone.setMetadataVisibility(getMetadataVisibility());
		clone.setEprintAbstract(getEprintAbstract());
		clone.setEprintKeywords(getEprintKeywords());
		clone.setIsPublished(getIsPublished());
		clone.setDateYear(getDateYear());
		clone.setFullTextStatus(getFullTextStatus());

		return clone;
	}

	public int compareTo(Eprint eprint) {
		long primaryKey = eprint.getPrimaryKey();

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

		if (!(obj instanceof EprintClp)) {
			return false;
		}

		EprintClp eprint = (EprintClp)obj;

		long primaryKey = eprint.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{eprintId=");
		sb.append(getEprintId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", eprintType=");
		sb.append(getEprintType());
		sb.append(", eprintStatus=");
		sb.append(getEprintStatus());
		sb.append(", metadataVisibility=");
		sb.append(getMetadataVisibility());
		sb.append(", eprintAbstract=");
		sb.append(getEprintAbstract());
		sb.append(", eprintKeywords=");
		sb.append(getEprintKeywords());
		sb.append(", isPublished=");
		sb.append(getIsPublished());
		sb.append(", dateYear=");
		sb.append(getDateYear());
		sb.append(", fullTextStatus=");
		sb.append(getFullTextStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eprint.model.Eprint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eprintId</column-name><column-value><![CDATA[");
		sb.append(getEprintId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eprintType</column-name><column-value><![CDATA[");
		sb.append(getEprintType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eprintStatus</column-name><column-value><![CDATA[");
		sb.append(getEprintStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataVisibility</column-name><column-value><![CDATA[");
		sb.append(getMetadataVisibility());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eprintAbstract</column-name><column-value><![CDATA[");
		sb.append(getEprintAbstract());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eprintKeywords</column-name><column-value><![CDATA[");
		sb.append(getEprintKeywords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPublished</column-name><column-value><![CDATA[");
		sb.append(getIsPublished());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateYear</column-name><column-value><![CDATA[");
		sb.append(getDateYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullTextStatus</column-name><column-value><![CDATA[");
		sb.append(getFullTextStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eprintId;
	private String _title;
	private String _eprintType;
	private String _eprintStatus;
	private String _metadataVisibility;
	private String _eprintAbstract;
	private String _eprintKeywords;
	private String _isPublished;
	private String _dateYear;
	private String _fullTextStatus;
	private BaseModel<?> _eprintRemoteModel;
}