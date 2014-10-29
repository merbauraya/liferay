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

package com.idetronic.portlet.model.impl;

import com.idetronic.portlet.model.ServiceExperience;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceExperience in entity cache.
 *
 * @author Mazlan Mat
 * @see ServiceExperience
 * @generated
 */
public class ServiceExperienceCacheModel implements CacheModel<ServiceExperience>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{serviceExperienceId=");
		sb.append(serviceExperienceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", serviceData=");
		sb.append(serviceData);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceExperience toEntityModel() {
		ServiceExperienceImpl serviceExperienceImpl = new ServiceExperienceImpl();

		serviceExperienceImpl.setServiceExperienceId(serviceExperienceId);
		serviceExperienceImpl.setCompanyId(companyId);
		serviceExperienceImpl.setUserId(userId);

		if (userName == null) {
			serviceExperienceImpl.setUserName(StringPool.BLANK);
		}
		else {
			serviceExperienceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			serviceExperienceImpl.setCreateDate(null);
		}
		else {
			serviceExperienceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceExperienceImpl.setModifiedDate(null);
		}
		else {
			serviceExperienceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (startDate == Long.MIN_VALUE) {
			serviceExperienceImpl.setStartDate(null);
		}
		else {
			serviceExperienceImpl.setStartDate(new Date(startDate));
		}

		if (title == null) {
			serviceExperienceImpl.setTitle(StringPool.BLANK);
		}
		else {
			serviceExperienceImpl.setTitle(title);
		}

		if (endDate == Long.MIN_VALUE) {
			serviceExperienceImpl.setEndDate(null);
		}
		else {
			serviceExperienceImpl.setEndDate(new Date(endDate));
		}

		if (serviceData == null) {
			serviceExperienceImpl.setServiceData(StringPool.BLANK);
		}
		else {
			serviceExperienceImpl.setServiceData(serviceData);
		}

		serviceExperienceImpl.setStatus(status);

		serviceExperienceImpl.resetOriginalValues();

		return serviceExperienceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceExperienceId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		startDate = objectInput.readLong();
		title = objectInput.readUTF();
		endDate = objectInput.readLong();
		serviceData = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(serviceExperienceId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(startDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(endDate);

		if (serviceData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceData);
		}

		objectOutput.writeInt(status);
	}

	public long serviceExperienceId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long startDate;
	public String title;
	public long endDate;
	public String serviceData;
	public int status;
}