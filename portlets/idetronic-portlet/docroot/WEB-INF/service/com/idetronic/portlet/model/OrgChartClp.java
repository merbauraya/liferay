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
import com.idetronic.portlet.service.OrgChartLocalServiceUtil;
import com.idetronic.portlet.service.persistence.OrgChartPK;

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
public class OrgChartClp extends BaseModelImpl<OrgChart> implements OrgChart {
	public OrgChartClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OrgChart.class;
	}

	@Override
	public String getModelClassName() {
		return OrgChart.class.getName();
	}

	@Override
	public OrgChartPK getPrimaryKey() {
		return new OrgChartPK(_userId, _parentId);
	}

	@Override
	public void setPrimaryKey(OrgChartPK primaryKey) {
		setUserId(primaryKey.userId);
		setParentId(primaryKey.parentId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new OrgChartPK(_userId, _parentId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((OrgChartPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_orgChartRemoteModel != null) {
			try {
				Class<?> clazz = _orgChartRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_orgChartRemoteModel, userId);
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
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_orgChartRemoteModel != null) {
			try {
				Class<?> clazz = _orgChartRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_orgChartRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrgChartRemoteModel() {
		return _orgChartRemoteModel;
	}

	public void setOrgChartRemoteModel(BaseModel<?> orgChartRemoteModel) {
		_orgChartRemoteModel = orgChartRemoteModel;
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

		Class<?> remoteModelClass = _orgChartRemoteModel.getClass();

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

		Object returnValue = method.invoke(_orgChartRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrgChartLocalServiceUtil.addOrgChart(this);
		}
		else {
			OrgChartLocalServiceUtil.updateOrgChart(this);
		}
	}

	@Override
	public OrgChart toEscapedModel() {
		return (OrgChart)ProxyUtil.newProxyInstance(OrgChart.class.getClassLoader(),
			new Class[] { OrgChart.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrgChartClp clone = new OrgChartClp();

		clone.setUserId(getUserId());
		clone.setParentId(getParentId());

		return clone;
	}

	@Override
	public int compareTo(OrgChart orgChart) {
		OrgChartPK primaryKey = orgChart.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrgChartClp)) {
			return false;
		}

		OrgChartClp orgChart = (OrgChartClp)obj;

		OrgChartPK primaryKey = orgChart.getPrimaryKey();

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
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.portlet.model.OrgChart");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private long _parentId;
	private BaseModel<?> _orgChartRemoteModel;
}