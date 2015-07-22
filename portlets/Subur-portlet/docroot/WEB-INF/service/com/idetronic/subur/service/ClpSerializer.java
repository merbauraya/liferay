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

package com.idetronic.subur.service;

import com.idetronic.subur.model.AuthorClp;
import com.idetronic.subur.model.AuthorExpertiseClp;
import com.idetronic.subur.model.AuthorSiteClp;
import com.idetronic.subur.model.DownloadSummaryClp;
import com.idetronic.subur.model.ExpertiseClp;
import com.idetronic.subur.model.ItemAuthorClp;
import com.idetronic.subur.model.ItemFileEntryClp;
import com.idetronic.subur.model.ItemItemTypeClp;
import com.idetronic.subur.model.ItemTypeClp;
import com.idetronic.subur.model.ItemTypeTemplateClp;
import com.idetronic.subur.model.MetadataPropertyClp;
import com.idetronic.subur.model.MetadataPropertyValueClp;
import com.idetronic.subur.model.MetadataSchemaClp;
import com.idetronic.subur.model.StatDownloadCategoryClp;
import com.idetronic.subur.model.StatDownloadItemTypeClp;
import com.idetronic.subur.model.StatDownloadPeriodClp;
import com.idetronic.subur.model.StatDownloadTagClp;
import com.idetronic.subur.model.StatViewCategoryClp;
import com.idetronic.subur.model.StatViewItemTypeClp;
import com.idetronic.subur.model.StatViewTagClp;
import com.idetronic.subur.model.SuburItemClp;
import com.idetronic.subur.model.ViewSummaryClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mazlan Mat
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"Subur-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"Subur-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "Subur-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AuthorClp.class.getName())) {
			return translateInputAuthor(oldModel);
		}

		if (oldModelClassName.equals(AuthorExpertiseClp.class.getName())) {
			return translateInputAuthorExpertise(oldModel);
		}

		if (oldModelClassName.equals(AuthorSiteClp.class.getName())) {
			return translateInputAuthorSite(oldModel);
		}

		if (oldModelClassName.equals(DownloadSummaryClp.class.getName())) {
			return translateInputDownloadSummary(oldModel);
		}

		if (oldModelClassName.equals(ExpertiseClp.class.getName())) {
			return translateInputExpertise(oldModel);
		}

		if (oldModelClassName.equals(ItemAuthorClp.class.getName())) {
			return translateInputItemAuthor(oldModel);
		}

		if (oldModelClassName.equals(ItemFileEntryClp.class.getName())) {
			return translateInputItemFileEntry(oldModel);
		}

		if (oldModelClassName.equals(ItemItemTypeClp.class.getName())) {
			return translateInputItemItemType(oldModel);
		}

		if (oldModelClassName.equals(ItemTypeClp.class.getName())) {
			return translateInputItemType(oldModel);
		}

		if (oldModelClassName.equals(ItemTypeTemplateClp.class.getName())) {
			return translateInputItemTypeTemplate(oldModel);
		}

		if (oldModelClassName.equals(MetadataPropertyClp.class.getName())) {
			return translateInputMetadataProperty(oldModel);
		}

		if (oldModelClassName.equals(MetadataPropertyValueClp.class.getName())) {
			return translateInputMetadataPropertyValue(oldModel);
		}

		if (oldModelClassName.equals(MetadataSchemaClp.class.getName())) {
			return translateInputMetadataSchema(oldModel);
		}

		if (oldModelClassName.equals(StatDownloadCategoryClp.class.getName())) {
			return translateInputStatDownloadCategory(oldModel);
		}

		if (oldModelClassName.equals(StatDownloadItemTypeClp.class.getName())) {
			return translateInputStatDownloadItemType(oldModel);
		}

		if (oldModelClassName.equals(StatDownloadPeriodClp.class.getName())) {
			return translateInputStatDownloadPeriod(oldModel);
		}

		if (oldModelClassName.equals(StatDownloadTagClp.class.getName())) {
			return translateInputStatDownloadTag(oldModel);
		}

		if (oldModelClassName.equals(StatViewCategoryClp.class.getName())) {
			return translateInputStatViewCategory(oldModel);
		}

		if (oldModelClassName.equals(StatViewItemTypeClp.class.getName())) {
			return translateInputStatViewItemType(oldModel);
		}

		if (oldModelClassName.equals(StatViewTagClp.class.getName())) {
			return translateInputStatViewTag(oldModel);
		}

		if (oldModelClassName.equals(SuburItemClp.class.getName())) {
			return translateInputSuburItem(oldModel);
		}

		if (oldModelClassName.equals(ViewSummaryClp.class.getName())) {
			return translateInputViewSummary(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAuthor(BaseModel<?> oldModel) {
		AuthorClp oldClpModel = (AuthorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAuthorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAuthorExpertise(BaseModel<?> oldModel) {
		AuthorExpertiseClp oldClpModel = (AuthorExpertiseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAuthorExpertiseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAuthorSite(BaseModel<?> oldModel) {
		AuthorSiteClp oldClpModel = (AuthorSiteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAuthorSiteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDownloadSummary(BaseModel<?> oldModel) {
		DownloadSummaryClp oldClpModel = (DownloadSummaryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDownloadSummaryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputExpertise(BaseModel<?> oldModel) {
		ExpertiseClp oldClpModel = (ExpertiseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getExpertiseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemAuthor(BaseModel<?> oldModel) {
		ItemAuthorClp oldClpModel = (ItemAuthorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemAuthorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemFileEntry(BaseModel<?> oldModel) {
		ItemFileEntryClp oldClpModel = (ItemFileEntryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemFileEntryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemItemType(BaseModel<?> oldModel) {
		ItemItemTypeClp oldClpModel = (ItemItemTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemItemTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemType(BaseModel<?> oldModel) {
		ItemTypeClp oldClpModel = (ItemTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemTypeTemplate(BaseModel<?> oldModel) {
		ItemTypeTemplateClp oldClpModel = (ItemTypeTemplateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemTypeTemplateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMetadataProperty(BaseModel<?> oldModel) {
		MetadataPropertyClp oldClpModel = (MetadataPropertyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMetadataPropertyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMetadataPropertyValue(
		BaseModel<?> oldModel) {
		MetadataPropertyValueClp oldClpModel = (MetadataPropertyValueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMetadataPropertyValueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMetadataSchema(BaseModel<?> oldModel) {
		MetadataSchemaClp oldClpModel = (MetadataSchemaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMetadataSchemaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStatDownloadCategory(
		BaseModel<?> oldModel) {
		StatDownloadCategoryClp oldClpModel = (StatDownloadCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStatDownloadCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStatDownloadItemType(
		BaseModel<?> oldModel) {
		StatDownloadItemTypeClp oldClpModel = (StatDownloadItemTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStatDownloadItemTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStatDownloadPeriod(BaseModel<?> oldModel) {
		StatDownloadPeriodClp oldClpModel = (StatDownloadPeriodClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStatDownloadPeriodRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStatDownloadTag(BaseModel<?> oldModel) {
		StatDownloadTagClp oldClpModel = (StatDownloadTagClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStatDownloadTagRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStatViewCategory(BaseModel<?> oldModel) {
		StatViewCategoryClp oldClpModel = (StatViewCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStatViewCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStatViewItemType(BaseModel<?> oldModel) {
		StatViewItemTypeClp oldClpModel = (StatViewItemTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStatViewItemTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStatViewTag(BaseModel<?> oldModel) {
		StatViewTagClp oldClpModel = (StatViewTagClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStatViewTagRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSuburItem(BaseModel<?> oldModel) {
		SuburItemClp oldClpModel = (SuburItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSuburItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputViewSummary(BaseModel<?> oldModel) {
		ViewSummaryClp oldClpModel = (ViewSummaryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getViewSummaryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.AuthorImpl")) {
			return translateOutputAuthor(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.AuthorExpertiseImpl")) {
			return translateOutputAuthorExpertise(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.AuthorSiteImpl")) {
			return translateOutputAuthorSite(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.DownloadSummaryImpl")) {
			return translateOutputDownloadSummary(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.ExpertiseImpl")) {
			return translateOutputExpertise(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.ItemAuthorImpl")) {
			return translateOutputItemAuthor(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.ItemFileEntryImpl")) {
			return translateOutputItemFileEntry(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.ItemItemTypeImpl")) {
			return translateOutputItemItemType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.ItemTypeImpl")) {
			return translateOutputItemType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.ItemTypeTemplateImpl")) {
			return translateOutputItemTypeTemplate(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.MetadataPropertyImpl")) {
			return translateOutputMetadataProperty(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.MetadataPropertyValueImpl")) {
			return translateOutputMetadataPropertyValue(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.MetadataSchemaImpl")) {
			return translateOutputMetadataSchema(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.StatDownloadCategoryImpl")) {
			return translateOutputStatDownloadCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.StatDownloadItemTypeImpl")) {
			return translateOutputStatDownloadItemType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.StatDownloadPeriodImpl")) {
			return translateOutputStatDownloadPeriod(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.StatDownloadTagImpl")) {
			return translateOutputStatDownloadTag(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.StatViewCategoryImpl")) {
			return translateOutputStatViewCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.StatViewItemTypeImpl")) {
			return translateOutputStatViewItemType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.StatViewTagImpl")) {
			return translateOutputStatViewTag(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.SuburItemImpl")) {
			return translateOutputSuburItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.subur.model.impl.ViewSummaryImpl")) {
			return translateOutputViewSummary(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.idetronic.subur.NoSuchAuthorException")) {
			return new com.idetronic.subur.NoSuchAuthorException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchAuthorExpertiseException")) {
			return new com.idetronic.subur.NoSuchAuthorExpertiseException();
		}

		if (className.equals("com.idetronic.subur.NoSuchAuthorSiteException")) {
			return new com.idetronic.subur.NoSuchAuthorSiteException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchDownloadSummaryException")) {
			return new com.idetronic.subur.NoSuchDownloadSummaryException();
		}

		if (className.equals("com.idetronic.subur.NoSuchExpertiseException")) {
			return new com.idetronic.subur.NoSuchExpertiseException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemAuthorException")) {
			return new com.idetronic.subur.NoSuchItemAuthorException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemFileEntryException")) {
			return new com.idetronic.subur.NoSuchItemFileEntryException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemItemTypeException")) {
			return new com.idetronic.subur.NoSuchItemItemTypeException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemTypeException")) {
			return new com.idetronic.subur.NoSuchItemTypeException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchItemTypeTemplateException")) {
			return new com.idetronic.subur.NoSuchItemTypeTemplateException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchMetadataPropertyException")) {
			return new com.idetronic.subur.NoSuchMetadataPropertyException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchMetadataPropertyValueException")) {
			return new com.idetronic.subur.NoSuchMetadataPropertyValueException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchMetadataSchemaException")) {
			return new com.idetronic.subur.NoSuchMetadataSchemaException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchStatDownloadCategoryException")) {
			return new com.idetronic.subur.NoSuchStatDownloadCategoryException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchStatDownloadItemTypeException")) {
			return new com.idetronic.subur.NoSuchStatDownloadItemTypeException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchStatDownloadPeriodException")) {
			return new com.idetronic.subur.NoSuchStatDownloadPeriodException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchStatDownloadTagException")) {
			return new com.idetronic.subur.NoSuchStatDownloadTagException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchStatViewCategoryException")) {
			return new com.idetronic.subur.NoSuchStatViewCategoryException();
		}

		if (className.equals(
					"com.idetronic.subur.NoSuchStatViewItemTypeException")) {
			return new com.idetronic.subur.NoSuchStatViewItemTypeException();
		}

		if (className.equals("com.idetronic.subur.NoSuchStatViewTagException")) {
			return new com.idetronic.subur.NoSuchStatViewTagException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemException")) {
			return new com.idetronic.subur.NoSuchItemException();
		}

		if (className.equals("com.idetronic.subur.NoSuchViewSummaryException")) {
			return new com.idetronic.subur.NoSuchViewSummaryException();
		}

		return throwable;
	}

	public static Object translateOutputAuthor(BaseModel<?> oldModel) {
		AuthorClp newModel = new AuthorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAuthorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAuthorExpertise(BaseModel<?> oldModel) {
		AuthorExpertiseClp newModel = new AuthorExpertiseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAuthorExpertiseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAuthorSite(BaseModel<?> oldModel) {
		AuthorSiteClp newModel = new AuthorSiteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAuthorSiteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDownloadSummary(BaseModel<?> oldModel) {
		DownloadSummaryClp newModel = new DownloadSummaryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDownloadSummaryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputExpertise(BaseModel<?> oldModel) {
		ExpertiseClp newModel = new ExpertiseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setExpertiseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemAuthor(BaseModel<?> oldModel) {
		ItemAuthorClp newModel = new ItemAuthorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemAuthorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemFileEntry(BaseModel<?> oldModel) {
		ItemFileEntryClp newModel = new ItemFileEntryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemFileEntryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemItemType(BaseModel<?> oldModel) {
		ItemItemTypeClp newModel = new ItemItemTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemItemTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemType(BaseModel<?> oldModel) {
		ItemTypeClp newModel = new ItemTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemTypeTemplate(BaseModel<?> oldModel) {
		ItemTypeTemplateClp newModel = new ItemTypeTemplateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemTypeTemplateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMetadataProperty(BaseModel<?> oldModel) {
		MetadataPropertyClp newModel = new MetadataPropertyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMetadataPropertyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMetadataPropertyValue(
		BaseModel<?> oldModel) {
		MetadataPropertyValueClp newModel = new MetadataPropertyValueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMetadataPropertyValueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMetadataSchema(BaseModel<?> oldModel) {
		MetadataSchemaClp newModel = new MetadataSchemaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMetadataSchemaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStatDownloadCategory(
		BaseModel<?> oldModel) {
		StatDownloadCategoryClp newModel = new StatDownloadCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStatDownloadCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStatDownloadItemType(
		BaseModel<?> oldModel) {
		StatDownloadItemTypeClp newModel = new StatDownloadItemTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStatDownloadItemTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStatDownloadPeriod(
		BaseModel<?> oldModel) {
		StatDownloadPeriodClp newModel = new StatDownloadPeriodClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStatDownloadPeriodRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStatDownloadTag(BaseModel<?> oldModel) {
		StatDownloadTagClp newModel = new StatDownloadTagClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStatDownloadTagRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStatViewCategory(BaseModel<?> oldModel) {
		StatViewCategoryClp newModel = new StatViewCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStatViewCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStatViewItemType(BaseModel<?> oldModel) {
		StatViewItemTypeClp newModel = new StatViewItemTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStatViewItemTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStatViewTag(BaseModel<?> oldModel) {
		StatViewTagClp newModel = new StatViewTagClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStatViewTagRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSuburItem(BaseModel<?> oldModel) {
		SuburItemClp newModel = new SuburItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSuburItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputViewSummary(BaseModel<?> oldModel) {
		ViewSummaryClp newModel = new ViewSummaryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setViewSummaryRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}