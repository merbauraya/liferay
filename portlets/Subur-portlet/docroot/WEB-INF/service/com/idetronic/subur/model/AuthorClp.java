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

import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class AuthorClp extends BaseModelImpl<Author> implements Author {
	public AuthorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Author.class;
	}

	@Override
	public String getModelClassName() {
		return Author.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _authorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAuthorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _authorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("title", getTitle());
		attributes.put("idType", getIdType());
		attributes.put("remoteId", getRemoteId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("userId", getUserId());
		attributes.put("metadata", getMetadata());
		attributes.put("lastPublishedDate", getLastPublishedDate());
		attributes.put("itemCount", getItemCount());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("Uuid", getUuid());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer idType = (Integer)attributes.get("idType");

		if (idType != null) {
			setIdType(idType);
		}

		String remoteId = (String)attributes.get("remoteId");

		if (remoteId != null) {
			setRemoteId(remoteId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		Integer userId = (Integer)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String metadata = (String)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
		}

		Date lastPublishedDate = (Date)attributes.get("lastPublishedDate");

		if (lastPublishedDate != null) {
			setLastPublishedDate(lastPublishedDate);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String Uuid = (String)attributes.get("Uuid");

		if (Uuid != null) {
			setUuid(Uuid);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_authorId = authorId;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorId", long.class);

				method.invoke(_authorRemoteModel, authorId);
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

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_authorRemoteModel, groupId);
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

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_authorRemoteModel, companyId);
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

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_authorRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIdType() {
		return _idType;
	}

	@Override
	public void setIdType(int idType) {
		_idType = idType;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setIdType", int.class);

				method.invoke(_authorRemoteModel, idType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemoteId() {
		return _remoteId;
	}

	@Override
	public void setRemoteId(String remoteId) {
		_remoteId = remoteId;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setRemoteId", String.class);

				method.invoke(_authorRemoteModel, remoteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_authorRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_authorRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMiddleName() {
		return _middleName;
	}

	@Override
	public void setMiddleName(String middleName) {
		_middleName = middleName;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setMiddleName", String.class);

				method.invoke(_authorRemoteModel, middleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(int userId) {
		_userId = userId;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", int.class);

				method.invoke(_authorRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMetadata() {
		return _metadata;
	}

	@Override
	public void setMetadata(String metadata) {
		_metadata = metadata;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadata", String.class);

				method.invoke(_authorRemoteModel, metadata);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastPublishedDate() {
		return _lastPublishedDate;
	}

	@Override
	public void setLastPublishedDate(Date lastPublishedDate) {
		_lastPublishedDate = lastPublishedDate;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setLastPublishedDate",
						Date.class);

				method.invoke(_authorRemoteModel, lastPublishedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getItemCount() {
		return _itemCount;
	}

	@Override
	public void setItemCount(int itemCount) {
		_itemCount = itemCount;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCount", int.class);

				method.invoke(_authorRemoteModel, itemCount);
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

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_authorRemoteModel, createDate);
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

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_authorRemoteModel, modifiedDate);
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

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_authorRemoteModel, Uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_authorRemoteModel != null) {
			try {
				Class<?> clazz = _authorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_authorRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getDisplayName() {
		try {
			String methodName = "getDisplayName";

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

	public BaseModel<?> getAuthorRemoteModel() {
		return _authorRemoteModel;
	}

	public void setAuthorRemoteModel(BaseModel<?> authorRemoteModel) {
		_authorRemoteModel = authorRemoteModel;
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

		Class<?> remoteModelClass = _authorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_authorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AuthorLocalServiceUtil.addAuthor(this);
		}
		else {
			AuthorLocalServiceUtil.updateAuthor(this);
		}
	}

	@Override
	public Author toEscapedModel() {
		return (Author)ProxyUtil.newProxyInstance(Author.class.getClassLoader(),
			new Class[] { Author.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuthorClp clone = new AuthorClp();

		clone.setAuthorId(getAuthorId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setTitle(getTitle());
		clone.setIdType(getIdType());
		clone.setRemoteId(getRemoteId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setMiddleName(getMiddleName());
		clone.setUserId(getUserId());
		clone.setMetadata(getMetadata());
		clone.setLastPublishedDate(getLastPublishedDate());
		clone.setItemCount(getItemCount());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUuid(getUuid());
		clone.setCreatedBy(getCreatedBy());

		return clone;
	}

	@Override
	public int compareTo(Author author) {
		long primaryKey = author.getPrimaryKey();

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

		if (!(obj instanceof AuthorClp)) {
			return false;
		}

		AuthorClp author = (AuthorClp)obj;

		long primaryKey = author.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{authorId=");
		sb.append(getAuthorId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", idType=");
		sb.append(getIdType());
		sb.append(", remoteId=");
		sb.append(getRemoteId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", metadata=");
		sb.append(getMetadata());
		sb.append(", lastPublishedDate=");
		sb.append(getLastPublishedDate());
		sb.append(", itemCount=");
		sb.append(getItemCount());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", Uuid=");
		sb.append(getUuid());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.Author");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idType</column-name><column-value><![CDATA[");
		sb.append(getIdType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteId</column-name><column-value><![CDATA[");
		sb.append(getRemoteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadata</column-name><column-value><![CDATA[");
		sb.append(getMetadata());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishedDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCount</column-name><column-value><![CDATA[");
		sb.append(getItemCount());
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
			"<column><column-name>Uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _authorId;
	private long _groupId;
	private long _companyId;
	private String _title;
	private int _idType;
	private String _remoteId;
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private int _userId;
	private String _metadata;
	private Date _lastPublishedDate;
	private int _itemCount;
	private Date _createDate;
	private Date _modifiedDate;
	private String _Uuid;
	private long _createdBy;
	private BaseModel<?> _authorRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}