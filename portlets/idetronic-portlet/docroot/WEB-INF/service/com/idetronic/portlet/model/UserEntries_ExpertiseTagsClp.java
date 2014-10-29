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

package com.idetronic.portlet.model;

import com.idetronic.portlet.service.ClpSerializer;
import com.idetronic.portlet.service.UserEntries_ExpertiseTagsLocalServiceUtil;
import com.idetronic.portlet.service.persistence.UserEntries_ExpertiseTagsPK;

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
public class UserEntries_ExpertiseTagsClp extends BaseModelImpl<UserEntries_ExpertiseTags>
	implements UserEntries_ExpertiseTags {
	public UserEntries_ExpertiseTagsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserEntries_ExpertiseTags.class;
	}

	@Override
	public String getModelClassName() {
		return UserEntries_ExpertiseTags.class.getName();
	}

	@Override
	public UserEntries_ExpertiseTagsPK getPrimaryKey() {
		return new UserEntries_ExpertiseTagsPK(_userId, _tagId);
	}

	@Override
	public void setPrimaryKey(UserEntries_ExpertiseTagsPK primaryKey) {
		setUserId(primaryKey.userId);
		setTagId(primaryKey.tagId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserEntries_ExpertiseTagsPK(_userId, _tagId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserEntries_ExpertiseTagsPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("tagId", getTagId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_userEntries_ExpertiseTagsRemoteModel != null) {
			try {
				Class<?> clazz = _userEntries_ExpertiseTagsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userEntries_ExpertiseTagsRemoteModel, userId);
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
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_tagId = tagId;

		if (_userEntries_ExpertiseTagsRemoteModel != null) {
			try {
				Class<?> clazz = _userEntries_ExpertiseTagsRemoteModel.getClass();

				Method method = clazz.getMethod("setTagId", long.class);

				method.invoke(_userEntries_ExpertiseTagsRemoteModel, tagId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserEntries_ExpertiseTagsRemoteModel() {
		return _userEntries_ExpertiseTagsRemoteModel;
	}

	public void setUserEntries_ExpertiseTagsRemoteModel(
		BaseModel<?> userEntries_ExpertiseTagsRemoteModel) {
		_userEntries_ExpertiseTagsRemoteModel = userEntries_ExpertiseTagsRemoteModel;
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

		Class<?> remoteModelClass = _userEntries_ExpertiseTagsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userEntries_ExpertiseTagsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserEntries_ExpertiseTagsLocalServiceUtil.addUserEntries_ExpertiseTags(this);
		}
		else {
			UserEntries_ExpertiseTagsLocalServiceUtil.updateUserEntries_ExpertiseTags(this);
		}
	}

	@Override
	public UserEntries_ExpertiseTags toEscapedModel() {
		return (UserEntries_ExpertiseTags)ProxyUtil.newProxyInstance(UserEntries_ExpertiseTags.class.getClassLoader(),
			new Class[] { UserEntries_ExpertiseTags.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserEntries_ExpertiseTagsClp clone = new UserEntries_ExpertiseTagsClp();

		clone.setUserId(getUserId());
		clone.setTagId(getTagId());

		return clone;
	}

	@Override
	public int compareTo(UserEntries_ExpertiseTags userEntries_ExpertiseTags) {
		UserEntries_ExpertiseTagsPK primaryKey = userEntries_ExpertiseTags.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserEntries_ExpertiseTagsClp)) {
			return false;
		}

		UserEntries_ExpertiseTagsClp userEntries_ExpertiseTags = (UserEntries_ExpertiseTagsClp)obj;

		UserEntries_ExpertiseTagsPK primaryKey = userEntries_ExpertiseTags.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", tagId=");
		sb.append(getTagId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.portlet.model.UserEntries_ExpertiseTags");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tagId</column-name><column-value><![CDATA[");
		sb.append(getTagId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private long _tagId;
	private BaseModel<?> _userEntries_ExpertiseTagsRemoteModel;
}