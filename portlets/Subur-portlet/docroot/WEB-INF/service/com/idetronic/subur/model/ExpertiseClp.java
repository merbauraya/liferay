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
import com.idetronic.subur.service.ExpertiseLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class ExpertiseClp extends BaseModelImpl<Expertise> implements Expertise {
	public ExpertiseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Expertise.class;
	}

	@Override
	public String getModelClassName() {
		return Expertise.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _expertiseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExpertiseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expertiseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expertiseId", getExpertiseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("expertiseName", getExpertiseName());
		attributes.put("indexedName", getIndexedName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("authorCount", getAuthorCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expertiseId = (Long)attributes.get("expertiseId");

		if (expertiseId != null) {
			setExpertiseId(expertiseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String expertiseName = (String)attributes.get("expertiseName");

		if (expertiseName != null) {
			setExpertiseName(expertiseName);
		}

		String indexedName = (String)attributes.get("indexedName");

		if (indexedName != null) {
			setIndexedName(indexedName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer authorCount = (Integer)attributes.get("authorCount");

		if (authorCount != null) {
			setAuthorCount(authorCount);
		}
	}

	@Override
	public long getExpertiseId() {
		return _expertiseId;
	}

	@Override
	public void setExpertiseId(long expertiseId) {
		_expertiseId = expertiseId;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setExpertiseId", long.class);

				method.invoke(_expertiseRemoteModel, expertiseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_expertiseRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_expertiseRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_expertiseRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_expertiseRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpertiseName() {
		return _expertiseName;
	}

	@Override
	public void setExpertiseName(String expertiseName) {
		_expertiseName = expertiseName;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setExpertiseName", String.class);

				method.invoke(_expertiseRemoteModel, expertiseName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndexedName() {
		return _indexedName;
	}

	@Override
	public void setIndexedName(String indexedName) {
		_indexedName = indexedName;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexedName", String.class);

				method.invoke(_expertiseRemoteModel, indexedName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_expertiseRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAuthorCount() {
		return _authorCount;
	}

	@Override
	public void setAuthorCount(int authorCount) {
		_authorCount = authorCount;

		if (_expertiseRemoteModel != null) {
			try {
				Class<?> clazz = _expertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorCount", int.class);

				method.invoke(_expertiseRemoteModel, authorCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getExpertiseRemoteModel() {
		return _expertiseRemoteModel;
	}

	public void setExpertiseRemoteModel(BaseModel<?> expertiseRemoteModel) {
		_expertiseRemoteModel = expertiseRemoteModel;
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

		Class<?> remoteModelClass = _expertiseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_expertiseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ExpertiseLocalServiceUtil.addExpertise(this);
		}
		else {
			ExpertiseLocalServiceUtil.updateExpertise(this);
		}
	}

	@Override
	public Expertise toEscapedModel() {
		return (Expertise)ProxyUtil.newProxyInstance(Expertise.class.getClassLoader(),
			new Class[] { Expertise.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExpertiseClp clone = new ExpertiseClp();

		clone.setExpertiseId(getExpertiseId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setExpertiseName(getExpertiseName());
		clone.setIndexedName(getIndexedName());
		clone.setModifiedDate(getModifiedDate());
		clone.setAuthorCount(getAuthorCount());

		return clone;
	}

	@Override
	public int compareTo(Expertise expertise) {
		long primaryKey = expertise.getPrimaryKey();

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

		if (!(obj instanceof ExpertiseClp)) {
			return false;
		}

		ExpertiseClp expertise = (ExpertiseClp)obj;

		long primaryKey = expertise.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{expertiseId=");
		sb.append(getExpertiseId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", expertiseName=");
		sb.append(getExpertiseName());
		sb.append(", indexedName=");
		sb.append(getIndexedName());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", authorCount=");
		sb.append(getAuthorCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.Expertise");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>expertiseId</column-name><column-value><![CDATA[");
		sb.append(getExpertiseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expertiseName</column-name><column-value><![CDATA[");
		sb.append(getExpertiseName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexedName</column-name><column-value><![CDATA[");
		sb.append(getIndexedName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorCount</column-name><column-value><![CDATA[");
		sb.append(getAuthorCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _expertiseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private String _expertiseName;
	private String _indexedName;
	private Date _modifiedDate;
	private int _authorCount;
	private BaseModel<?> _expertiseRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}