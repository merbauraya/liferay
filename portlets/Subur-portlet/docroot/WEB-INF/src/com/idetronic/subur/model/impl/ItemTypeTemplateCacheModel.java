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

package com.idetronic.subur.model.impl;

import com.idetronic.subur.model.ItemTypeTemplate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ItemTypeTemplate in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemTypeTemplate
 * @generated
 */
public class ItemTypeTemplateCacheModel implements CacheModel<ItemTypeTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", metadataPropertyId=");
		sb.append(metadataPropertyId);
		sb.append(", required=");
		sb.append(required);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemTypeTemplate toEntityModel() {
		ItemTypeTemplateImpl itemTypeTemplateImpl = new ItemTypeTemplateImpl();

		itemTypeTemplateImpl.setItemTypeId(itemTypeId);
		itemTypeTemplateImpl.setMetadataPropertyId(metadataPropertyId);
		itemTypeTemplateImpl.setRequired(required);

		itemTypeTemplateImpl.resetOriginalValues();

		return itemTypeTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemTypeId = objectInput.readLong();
		metadataPropertyId = objectInput.readLong();
		required = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemTypeId);
		objectOutput.writeLong(metadataPropertyId);
		objectOutput.writeBoolean(required);
	}

	public long itemTypeId;
	public long metadataPropertyId;
	public boolean required;
}