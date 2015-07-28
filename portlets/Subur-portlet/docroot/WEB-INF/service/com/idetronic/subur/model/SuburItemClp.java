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
import com.idetronic.subur.service.SuburItemLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class SuburItemClp extends BaseModelImpl<SuburItem> implements SuburItem {
	public SuburItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SuburItem.class;
	}

	@Override
	public String getModelClassName() {
		return SuburItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _itemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishedDate", getPublishedDate());
		attributes.put("title", getTitle());
		attributes.put("itemAbstract", getItemAbstract());
		attributes.put("language", getLanguage());
		attributes.put("status", getStatus());
		attributes.put("Uuid", getUuid());
		attributes.put("metadataValue", getMetadataValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
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

		Date publishedDate = (Date)attributes.get("publishedDate");

		if (publishedDate != null) {
			setPublishedDate(publishedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String itemAbstract = (String)attributes.get("itemAbstract");

		if (itemAbstract != null) {
			setItemAbstract(itemAbstract);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String Uuid = (String)attributes.get("Uuid");

		if (Uuid != null) {
			setUuid(Uuid);
		}

		String metadataValue = (String)attributes.get("metadataValue");

		if (metadataValue != null) {
			setMetadataValue(metadataValue);
		}
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_suburItemRemoteModel, itemId);
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

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_suburItemRemoteModel, companyId);
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

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_suburItemRemoteModel, groupId);
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

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_suburItemRemoteModel, userId);
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

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_suburItemRemoteModel, userName);
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

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_suburItemRemoteModel, createDate);
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

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_suburItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPublishedDate() {
		return _publishedDate;
	}

	@Override
	public void setPublishedDate(Date publishedDate) {
		_publishedDate = publishedDate;

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishedDate", Date.class);

				method.invoke(_suburItemRemoteModel, publishedDate);
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

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_suburItemRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemAbstract() {
		return _itemAbstract;
	}

	@Override
	public void setItemAbstract(String itemAbstract) {
		_itemAbstract = itemAbstract;

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemAbstract", String.class);

				method.invoke(_suburItemRemoteModel, itemAbstract);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguage() {
		return _language;
	}

	@Override
	public void setLanguage(String language) {
		_language = language;

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguage", String.class);

				method.invoke(_suburItemRemoteModel, language);
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

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_suburItemRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUuid() {
		return _Uuid;
	}

	@Override
	public void setUuid(String Uuid) {
		_Uuid = Uuid;

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_suburItemRemoteModel, Uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMetadataValue() {
		return _metadataValue;
	}

	@Override
	public void setMetadataValue(String metadataValue) {
		_metadataValue = metadataValue;

		if (_suburItemRemoteModel != null) {
			try {
				Class<?> clazz = _suburItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataValue", String.class);

				method.invoke(_suburItemRemoteModel, metadataValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getIdentifiers() {
		try {
			String methodName = "getIdentifiers";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Map<java.lang.String, java.lang.String> returnObj = (java.util.Map<java.lang.String, java.lang.String>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSearchDescription() {
		try {
			String methodName = "getSearchDescription";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setIdentifier(
		java.util.Map<java.lang.String, java.lang.String> identifierMap) {
		try {
			String methodName = "setIdentifier";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Map.class };

			Object[] parameterValues = new Object[] { identifierMap };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setOtherTitle(java.lang.String[] otherTitle) {
		try {
			String methodName = "setOtherTitle";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { otherTitle };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.idetronic.subur.model.ItemType> getItemTypes() {
		try {
			String methodName = "getItemTypes";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.idetronic.subur.model.ItemType> returnObj = (java.util.List<com.idetronic.subur.model.ItemType>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String[] getOtherTitles() {
		try {
			String methodName = "getOtherTitles";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String[] returnObj = (java.lang.String[])invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.Map getSeriesReportNo() {
		try {
			String methodName = "getSeriesReportNo";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Map returnObj = (java.util.Map)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSeriesReportNo(
		java.util.Map<java.lang.String, java.lang.String> entryMap) {
		try {
			String methodName = "setSeriesReportNo";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Map.class };

			Object[] parameterValues = new Object[] { entryMap };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSuburItemRemoteModel() {
		return _suburItemRemoteModel;
	}

	public void setSuburItemRemoteModel(BaseModel<?> suburItemRemoteModel) {
		_suburItemRemoteModel = suburItemRemoteModel;
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

		Class<?> remoteModelClass = _suburItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_suburItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SuburItemLocalServiceUtil.addSuburItem(this);
		}
		else {
			SuburItemLocalServiceUtil.updateSuburItem(this);
		}
	}

	@Override
	public SuburItem toEscapedModel() {
		return (SuburItem)ProxyUtil.newProxyInstance(SuburItem.class.getClassLoader(),
			new Class[] { SuburItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SuburItemClp clone = new SuburItemClp();

		clone.setItemId(getItemId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPublishedDate(getPublishedDate());
		clone.setTitle(getTitle());
		clone.setItemAbstract(getItemAbstract());
		clone.setLanguage(getLanguage());
		clone.setStatus(getStatus());
		clone.setUuid(getUuid());
		clone.setMetadataValue(getMetadataValue());

		return clone;
	}

	@Override
	public int compareTo(SuburItem suburItem) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), suburItem.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SuburItemClp)) {
			return false;
		}

		SuburItemClp suburItem = (SuburItemClp)obj;

		long primaryKey = suburItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{itemId=");
		sb.append(getItemId());
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
		sb.append(", publishedDate=");
		sb.append(getPublishedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", itemAbstract=");
		sb.append(getItemAbstract());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", Uuid=");
		sb.append(getUuid());
		sb.append(", metadataValue=");
		sb.append(getMetadataValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.SuburItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
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
			"<column><column-name>publishedDate</column-name><column-value><![CDATA[");
		sb.append(getPublishedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemAbstract</column-name><column-value><![CDATA[");
		sb.append(getItemAbstract());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataValue</column-name><column-value><![CDATA[");
		sb.append(getMetadataValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishedDate;
	private String _title;
	private String _itemAbstract;
	private String _language;
	private int _status;
	private String _Uuid;
	private String _metadataValue;
	private BaseModel<?> _suburItemRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}