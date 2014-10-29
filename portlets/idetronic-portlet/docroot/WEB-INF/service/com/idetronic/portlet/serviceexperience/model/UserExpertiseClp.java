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

package com.idetronic.portlet.serviceexperience.model;

import com.idetronic.portlet.serviceexperience.service.ClpSerializer;
import com.idetronic.portlet.serviceexperience.service.UserExpertiseLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class UserExpertiseClp extends BaseModelImpl<UserExpertise>
	implements UserExpertise {
	public UserExpertiseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserExpertise.class;
	}

	@Override
	public String getModelClassName() {
		return UserExpertise.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userExpertiseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserExpertiseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userExpertiseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userExpertiseId", getUserExpertiseId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("expertiseData", getExpertiseData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userExpertiseId = (Long)attributes.get("userExpertiseId");

		if (userExpertiseId != null) {
			setUserExpertiseId(userExpertiseId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String expertiseData = (String)attributes.get("expertiseData");

		if (expertiseData != null) {
			setExpertiseData(expertiseData);
		}
	}

	@Override
	public long getUserExpertiseId() {
		return _userExpertiseId;
	}

	@Override
	public void setUserExpertiseId(long userExpertiseId) {
		_userExpertiseId = userExpertiseId;

		if (_userExpertiseRemoteModel != null) {
			try {
				Class<?> clazz = _userExpertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserExpertiseId", long.class);

				method.invoke(_userExpertiseRemoteModel, userExpertiseId);
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

		if (_userExpertiseRemoteModel != null) {
			try {
				Class<?> clazz = _userExpertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_userExpertiseRemoteModel, companyId);
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

		if (_userExpertiseRemoteModel != null) {
			try {
				Class<?> clazz = _userExpertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userExpertiseRemoteModel, userId);
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

		if (_userExpertiseRemoteModel != null) {
			try {
				Class<?> clazz = _userExpertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_userExpertiseRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpertiseData() {
		return _expertiseData;
	}

	@Override
	public void setExpertiseData(String expertiseData) {
		_expertiseData = expertiseData;

		if (_userExpertiseRemoteModel != null) {
			try {
				Class<?> clazz = _userExpertiseRemoteModel.getClass();

				Method method = clazz.getMethod("setExpertiseData", String.class);

				method.invoke(_userExpertiseRemoteModel, expertiseData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserExpertiseRemoteModel() {
		return _userExpertiseRemoteModel;
	}

	public void setUserExpertiseRemoteModel(
		BaseModel<?> userExpertiseRemoteModel) {
		_userExpertiseRemoteModel = userExpertiseRemoteModel;
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

		Class<?> remoteModelClass = _userExpertiseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userExpertiseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserExpertiseLocalServiceUtil.addUserExpertise(this);
		}
		else {
			UserExpertiseLocalServiceUtil.updateUserExpertise(this);
		}
	}

	@Override
	public UserExpertise toEscapedModel() {
		return (UserExpertise)ProxyUtil.newProxyInstance(UserExpertise.class.getClassLoader(),
			new Class[] { UserExpertise.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserExpertiseClp clone = new UserExpertiseClp();

		clone.setUserExpertiseId(getUserExpertiseId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setExpertiseData(getExpertiseData());

		return clone;
	}

	@Override
	public int compareTo(UserExpertise userExpertise) {
		long primaryKey = userExpertise.getPrimaryKey();

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

		if (!(obj instanceof UserExpertiseClp)) {
			return false;
		}

		UserExpertiseClp userExpertise = (UserExpertiseClp)obj;

		long primaryKey = userExpertise.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{userExpertiseId=");
		sb.append(getUserExpertiseId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", expertiseData=");
		sb.append(getExpertiseData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.portlet.serviceexperience.model.UserExpertise");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userExpertiseId</column-name><column-value><![CDATA[");
		sb.append(getUserExpertiseId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expertiseData</column-name><column-value><![CDATA[");
		sb.append(getExpertiseData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userExpertiseId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private String _expertiseData;
	private BaseModel<?> _userExpertiseRemoteModel;
}