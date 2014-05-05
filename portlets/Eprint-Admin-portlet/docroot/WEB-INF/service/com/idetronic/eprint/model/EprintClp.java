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
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class EprintClp extends BaseModelImpl<Eprint> implements Eprint {
	public EprintClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Eprint.class;
	}

	@Override
	public String getModelClassName() {
		return Eprint.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eprintId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEprintId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eprintId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("title", getTitle());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("eprintType", getEprintType());
		attributes.put("eprintStatus", getEprintStatus());
		attributes.put("metadataVisibility", getMetadataVisibility());
		attributes.put("eprintAbstract", getEprintAbstract());
		attributes.put("eprintKeywords", getEprintKeywords());
		attributes.put("isPublished", getIsPublished());
		attributes.put("dateYear", getDateYear());
		attributes.put("fullTextStatus", getFullTextStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getEprintId() {
		return _eprintId;
	}

	@Override
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

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eprintRemoteModel, groupId);
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

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eprintRemoteModel, userId);
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
	public String getTitle() {
		return _title;
	}

	@Override
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

	@Override
	public String getUrlTitle() {
		return _urlTitle;
	}

	@Override
	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setUrlTitle", String.class);

				method.invoke(_eprintRemoteModel, urlTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEprintType() {
		return _eprintType;
	}

	@Override
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

	@Override
	public String getEprintStatus() {
		return _eprintStatus;
	}

	@Override
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

	@Override
	public String getMetadataVisibility() {
		return _metadataVisibility;
	}

	@Override
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

	@Override
	public String getEprintAbstract() {
		return _eprintAbstract;
	}

	@Override
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

	@Override
	public String getEprintKeywords() {
		return _eprintKeywords;
	}

	@Override
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

	@Override
	public String getIsPublished() {
		return _isPublished;
	}

	@Override
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

	@Override
	public String getDateYear() {
		return _dateYear;
	}

	@Override
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

	@Override
	public String getFullTextStatus() {
		return _fullTextStatus;
	}

	@Override
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

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eprintRemoteModel, companyId);
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

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eprintRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_eprintRemoteModel != null) {
			try {
				Class<?> clazz = _eprintRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_eprintRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getSummary() {
		try {
			String methodName = "getSummary";

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

	@Override
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

	@Override
	public Object clone() {
		EprintClp clone = new EprintClp();

		clone.setEprintId(getEprintId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setTitle(getTitle());
		clone.setUrlTitle(getUrlTitle());
		clone.setEprintType(getEprintType());
		clone.setEprintStatus(getEprintStatus());
		clone.setMetadataVisibility(getMetadataVisibility());
		clone.setEprintAbstract(getEprintAbstract());
		clone.setEprintKeywords(getEprintKeywords());
		clone.setIsPublished(getIsPublished());
		clone.setDateYear(getDateYear());
		clone.setFullTextStatus(getFullTextStatus());
		clone.setCompanyId(getCompanyId());
		clone.setModifiedDate(getModifiedDate());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
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
		StringBundler sb = new StringBundler(33);

		sb.append("{eprintId=");
		sb.append(getEprintId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", urlTitle=");
		sb.append(getUrlTitle());
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
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eprint.model.Eprint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eprintId</column-name><column-value><![CDATA[");
		sb.append(getEprintId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlTitle</column-name><column-value><![CDATA[");
		sb.append(getUrlTitle());
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
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eprintId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _title;
	private String _urlTitle;
	private String _eprintType;
	private String _eprintStatus;
	private String _metadataVisibility;
	private String _eprintAbstract;
	private String _eprintKeywords;
	private String _isPublished;
	private String _dateYear;
	private String _fullTextStatus;
	private long _companyId;
	private Date _modifiedDate;
	private Date _createdDate;
	private BaseModel<?> _eprintRemoteModel;
}