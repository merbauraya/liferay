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
import com.idetronic.subur.service.ItemTypeTemplateLocalServiceUtil;
import com.idetronic.subur.service.persistence.ItemTypeTemplatePK;

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
public class ItemTypeTemplateClp extends BaseModelImpl<ItemTypeTemplate>
	implements ItemTypeTemplate {
	public ItemTypeTemplateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemTypeTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return ItemTypeTemplate.class.getName();
	}

	@Override
	public ItemTypeTemplatePK getPrimaryKey() {
		return new ItemTypeTemplatePK(_itemTypeId, _metadataPropertyId);
	}

	@Override
	public void setPrimaryKey(ItemTypeTemplatePK primaryKey) {
		setItemTypeId(primaryKey.itemTypeId);
		setMetadataPropertyId(primaryKey.metadataPropertyId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ItemTypeTemplatePK(_itemTypeId, _metadataPropertyId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ItemTypeTemplatePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("metadataPropertyId", getMetadataPropertyId());
		attributes.put("required", getRequired());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		Long metadataPropertyId = (Long)attributes.get("metadataPropertyId");

		if (metadataPropertyId != null) {
			setMetadataPropertyId(metadataPropertyId);
		}

		Boolean required = (Boolean)attributes.get("required");

		if (required != null) {
			setRequired(required);
		}
	}

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_itemTypeTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_itemTypeTemplateRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMetadataPropertyId() {
		return _metadataPropertyId;
	}

	@Override
	public void setMetadataPropertyId(long metadataPropertyId) {
		_metadataPropertyId = metadataPropertyId;

		if (_itemTypeTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataPropertyId",
						long.class);

				method.invoke(_itemTypeTemplateRemoteModel, metadataPropertyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequired() {
		return _required;
	}

	@Override
	public boolean isRequired() {
		return _required;
	}

	@Override
	public void setRequired(boolean required) {
		_required = required;

		if (_itemTypeTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setRequired", boolean.class);

				method.invoke(_itemTypeTemplateRemoteModel, required);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemTypeTemplateRemoteModel() {
		return _itemTypeTemplateRemoteModel;
	}

	public void setItemTypeTemplateRemoteModel(
		BaseModel<?> itemTypeTemplateRemoteModel) {
		_itemTypeTemplateRemoteModel = itemTypeTemplateRemoteModel;
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

		Class<?> remoteModelClass = _itemTypeTemplateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemTypeTemplateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemTypeTemplateLocalServiceUtil.addItemTypeTemplate(this);
		}
		else {
			ItemTypeTemplateLocalServiceUtil.updateItemTypeTemplate(this);
		}
	}

	@Override
	public ItemTypeTemplate toEscapedModel() {
		return (ItemTypeTemplate)ProxyUtil.newProxyInstance(ItemTypeTemplate.class.getClassLoader(),
			new Class[] { ItemTypeTemplate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemTypeTemplateClp clone = new ItemTypeTemplateClp();

		clone.setItemTypeId(getItemTypeId());
		clone.setMetadataPropertyId(getMetadataPropertyId());
		clone.setRequired(getRequired());

		return clone;
	}

	@Override
	public int compareTo(ItemTypeTemplate itemTypeTemplate) {
		ItemTypeTemplatePK primaryKey = itemTypeTemplate.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemTypeTemplateClp)) {
			return false;
		}

		ItemTypeTemplateClp itemTypeTemplate = (ItemTypeTemplateClp)obj;

		ItemTypeTemplatePK primaryKey = itemTypeTemplate.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", metadataPropertyId=");
		sb.append(getMetadataPropertyId());
		sb.append(", required=");
		sb.append(getRequired());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ItemTypeTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataPropertyId</column-name><column-value><![CDATA[");
		sb.append(getMetadataPropertyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>required</column-name><column-value><![CDATA[");
		sb.append(getRequired());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemTypeId;
	private long _metadataPropertyId;
	private boolean _required;
	private BaseModel<?> _itemTypeTemplateRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}