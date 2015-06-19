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

package com.idetronic.subur.service.messaging;

import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ClpSerializer;
import com.idetronic.subur.service.DivisionLocalServiceUtil;
import com.idetronic.subur.service.FileEntryTypeLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemDivisionLocalServiceUtil;
import com.idetronic.subur.service.ItemFileEntryLocalServiceUtil;
import com.idetronic.subur.service.ItemFileEntryServiceUtil;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.ItemSubjectLocalServiceUtil;
import com.idetronic.subur.service.ItemTypeLocalServiceUtil;
import com.idetronic.subur.service.ItemTypeTemplateLocalServiceUtil;
import com.idetronic.subur.service.MetadataPropertyLocalServiceUtil;
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;
import com.idetronic.subur.service.MetadataSchemaLocalServiceUtil;
import com.idetronic.subur.service.SubjectLocalServiceUtil;
import com.idetronic.subur.service.SubjectServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Mazlan Mat
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AuthorLocalServiceUtil.clearService();

			DivisionLocalServiceUtil.clearService();

			FileEntryTypeLocalServiceUtil.clearService();

			ItemAuthorLocalServiceUtil.clearService();

			ItemDivisionLocalServiceUtil.clearService();

			ItemFileEntryLocalServiceUtil.clearService();

			ItemFileEntryServiceUtil.clearService();
			ItemItemTypeLocalServiceUtil.clearService();

			ItemSubjectLocalServiceUtil.clearService();

			ItemTypeLocalServiceUtil.clearService();

			ItemTypeTemplateLocalServiceUtil.clearService();

			MetadataPropertyLocalServiceUtil.clearService();

			MetadataPropertyValueLocalServiceUtil.clearService();

			MetadataSchemaLocalServiceUtil.clearService();

			SubjectLocalServiceUtil.clearService();

			SubjectServiceUtil.clearService();
			SuburItemLocalServiceUtil.clearService();
		}
	}
}