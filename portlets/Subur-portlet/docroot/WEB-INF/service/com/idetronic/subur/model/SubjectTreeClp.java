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
import com.idetronic.subur.service.SubjectTreeLocalServiceUtil;

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
public class SubjectTreeClp extends BaseModelImpl<SubjectTree>
	implements SubjectTree {
	public SubjectTreeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SubjectTree.class;
	}

	@Override
	public String getModelClassName() {
		return SubjectTree.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _subjectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subjectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subjectId", getSubjectId());
		attributes.put("parentId", getParentId());
		attributes.put("subjectName", getSubjectName());
		attributes.put("lft", getLft());
		attributes.put("rgt", getRgt());
		attributes.put("depositable", getDepositable());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
		}

		Integer lft = (Integer)attributes.get("lft");

		if (lft != null) {
			setLft(lft);
		}

		Integer rgt = (Integer)attributes.get("rgt");

		if (rgt != null) {
			setRgt(rgt);
		}

		Boolean depositable = (Boolean)attributes.get("depositable");

		if (depositable != null) {
			setDepositable(depositable);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	@Override
	public long getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;

		if (_subjectTreeRemoteModel != null) {
			try {
				Class<?> clazz = _subjectTreeRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectId", long.class);

				method.invoke(_subjectTreeRemoteModel, subjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_subjectTreeRemoteModel != null) {
			try {
				Class<?> clazz = _subjectTreeRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_subjectTreeRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectName() {
		return _subjectName;
	}

	@Override
	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;

		if (_subjectTreeRemoteModel != null) {
			try {
				Class<?> clazz = _subjectTreeRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectName", String.class);

				method.invoke(_subjectTreeRemoteModel, subjectName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLft() {
		return _lft;
	}

	@Override
	public void setLft(int lft) {
		_lft = lft;

		if (_subjectTreeRemoteModel != null) {
			try {
				Class<?> clazz = _subjectTreeRemoteModel.getClass();

				Method method = clazz.getMethod("setLft", int.class);

				method.invoke(_subjectTreeRemoteModel, lft);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRgt() {
		return _rgt;
	}

	@Override
	public void setRgt(int rgt) {
		_rgt = rgt;

		if (_subjectTreeRemoteModel != null) {
			try {
				Class<?> clazz = _subjectTreeRemoteModel.getClass();

				Method method = clazz.getMethod("setRgt", int.class);

				method.invoke(_subjectTreeRemoteModel, rgt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDepositable() {
		return _depositable;
	}

	@Override
	public boolean isDepositable() {
		return _depositable;
	}

	@Override
	public void setDepositable(boolean depositable) {
		_depositable = depositable;

		if (_subjectTreeRemoteModel != null) {
			try {
				Class<?> clazz = _subjectTreeRemoteModel.getClass();

				Method method = clazz.getMethod("setDepositable", boolean.class);

				method.invoke(_subjectTreeRemoteModel, depositable);
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

		if (_subjectTreeRemoteModel != null) {
			try {
				Class<?> clazz = _subjectTreeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCount", int.class);

				method.invoke(_subjectTreeRemoteModel, itemCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubjectTreeRemoteModel() {
		return _subjectTreeRemoteModel;
	}

	public void setSubjectTreeRemoteModel(BaseModel<?> subjectTreeRemoteModel) {
		_subjectTreeRemoteModel = subjectTreeRemoteModel;
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

		Class<?> remoteModelClass = _subjectTreeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_subjectTreeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubjectTreeLocalServiceUtil.addSubjectTree(this);
		}
		else {
			SubjectTreeLocalServiceUtil.updateSubjectTree(this);
		}
	}

	@Override
	public SubjectTree toEscapedModel() {
		return (SubjectTree)ProxyUtil.newProxyInstance(SubjectTree.class.getClassLoader(),
			new Class[] { SubjectTree.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubjectTreeClp clone = new SubjectTreeClp();

		clone.setSubjectId(getSubjectId());
		clone.setParentId(getParentId());
		clone.setSubjectName(getSubjectName());
		clone.setLft(getLft());
		clone.setRgt(getRgt());
		clone.setDepositable(getDepositable());
		clone.setItemCount(getItemCount());

		return clone;
	}

	@Override
	public int compareTo(SubjectTree subjectTree) {
		int value = 0;

		value = getSubjectName().compareTo(subjectTree.getSubjectName());

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

		if (!(obj instanceof SubjectTreeClp)) {
			return false;
		}

		SubjectTreeClp subjectTree = (SubjectTreeClp)obj;

		long primaryKey = subjectTree.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{subjectId=");
		sb.append(getSubjectId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", subjectName=");
		sb.append(getSubjectName());
		sb.append(", lft=");
		sb.append(getLft());
		sb.append(", rgt=");
		sb.append(getRgt());
		sb.append(", depositable=");
		sb.append(getDepositable());
		sb.append(", itemCount=");
		sb.append(getItemCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.SubjectTree");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>subjectId</column-name><column-value><![CDATA[");
		sb.append(getSubjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectName</column-name><column-value><![CDATA[");
		sb.append(getSubjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lft</column-name><column-value><![CDATA[");
		sb.append(getLft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rgt</column-name><column-value><![CDATA[");
		sb.append(getRgt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depositable</column-name><column-value><![CDATA[");
		sb.append(getDepositable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCount</column-name><column-value><![CDATA[");
		sb.append(getItemCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _subjectId;
	private long _parentId;
	private String _subjectName;
	private int _lft;
	private int _rgt;
	private boolean _depositable;
	private int _itemCount;
	private BaseModel<?> _subjectTreeRemoteModel;
}