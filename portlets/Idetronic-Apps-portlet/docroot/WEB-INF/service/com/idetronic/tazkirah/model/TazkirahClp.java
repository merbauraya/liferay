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

package com.idetronic.tazkirah.model;

import com.idetronic.tazkirah.service.ClpSerializer;
import com.idetronic.tazkirah.service.TazkirahLocalServiceUtil;

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
public class TazkirahClp extends BaseModelImpl<Tazkirah> implements Tazkirah {
	public TazkirahClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Tazkirah.class;
	}

	@Override
	public String getModelClassName() {
		return Tazkirah.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tazkirahId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTazkirahId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tazkirahId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tazkirahId", getTazkirahId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("category", getCategory());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tazkirahId = (Long)attributes.get("tazkirahId");

		if (tazkirahId != null) {
			setTazkirahId(tazkirahId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getTazkirahId() {
		return _tazkirahId;
	}

	@Override
	public void setTazkirahId(long tazkirahId) {
		_tazkirahId = tazkirahId;

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setTazkirahId", long.class);

				method.invoke(_tazkirahRemoteModel, tazkirahId);
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

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tazkirahRemoteModel, companyId);
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

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_tazkirahRemoteModel, groupId);
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

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tazkirahRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_tazkirahRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_tazkirahRemoteModel, createDate);
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

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_tazkirahRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_tazkirahRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_tazkirahRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_tazkirahRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_tazkirahRemoteModel != null) {
			try {
				Class<?> clazz = _tazkirahRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_tazkirahRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTazkirahRemoteModel() {
		return _tazkirahRemoteModel;
	}

	public void setTazkirahRemoteModel(BaseModel<?> tazkirahRemoteModel) {
		_tazkirahRemoteModel = tazkirahRemoteModel;
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

		Class<?> remoteModelClass = _tazkirahRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tazkirahRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TazkirahLocalServiceUtil.addTazkirah(this);
		}
		else {
			TazkirahLocalServiceUtil.updateTazkirah(this);
		}
	}

	@Override
	public Tazkirah toEscapedModel() {
		return (Tazkirah)ProxyUtil.newProxyInstance(Tazkirah.class.getClassLoader(),
			new Class[] { Tazkirah.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TazkirahClp clone = new TazkirahClp();

		clone.setTazkirahId(getTazkirahId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setCategory(getCategory());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(Tazkirah tazkirah) {
		long primaryKey = tazkirah.getPrimaryKey();

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

		if (!(obj instanceof TazkirahClp)) {
			return false;
		}

		TazkirahClp tazkirah = (TazkirahClp)obj;

		long primaryKey = tazkirah.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{tazkirahId=");
		sb.append(getTazkirahId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.tazkirah.model.Tazkirah");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tazkirahId</column-name><column-value><![CDATA[");
		sb.append(getTazkirahId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tazkirahId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _content;
	private String _category;
	private int _status;
	private BaseModel<?> _tazkirahRemoteModel;
}