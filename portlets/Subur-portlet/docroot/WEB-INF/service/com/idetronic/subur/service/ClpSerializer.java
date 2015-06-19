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
import com.idetronic.subur.model.DivisionClp;
import com.idetronic.subur.model.FileEntryTypeClp;
import com.idetronic.subur.model.ItemAuthorClp;
import com.idetronic.subur.model.ItemDivisionClp;
import com.idetronic.subur.model.ItemFileEntryClp;
import com.idetronic.subur.model.ItemItemTypeClp;
import com.idetronic.subur.model.ItemSubjectClp;
import com.idetronic.subur.model.ItemTypeClp;
import com.idetronic.subur.model.ItemTypeTemplateClp;
import com.idetronic.subur.model.MetadataPropertyClp;
import com.idetronic.subur.model.MetadataPropertyValueClp;
import com.idetronic.subur.model.MetadataSchemaClp;
import com.idetronic.subur.model.SubjectClp;
import com.idetronic.subur.model.SuburItemClp;

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

		if (oldModelClassName.equals(DivisionClp.class.getName())) {
			return translateInputDivision(oldModel);
		}

		if (oldModelClassName.equals(FileEntryTypeClp.class.getName())) {
			return translateInputFileEntryType(oldModel);
		}

		if (oldModelClassName.equals(ItemAuthorClp.class.getName())) {
			return translateInputItemAuthor(oldModel);
		}

		if (oldModelClassName.equals(ItemDivisionClp.class.getName())) {
			return translateInputItemDivision(oldModel);
		}

		if (oldModelClassName.equals(ItemFileEntryClp.class.getName())) {
			return translateInputItemFileEntry(oldModel);
		}

		if (oldModelClassName.equals(ItemItemTypeClp.class.getName())) {
			return translateInputItemItemType(oldModel);
		}

		if (oldModelClassName.equals(ItemSubjectClp.class.getName())) {
			return translateInputItemSubject(oldModel);
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

		if (oldModelClassName.equals(SubjectClp.class.getName())) {
			return translateInputSubject(oldModel);
		}

		if (oldModelClassName.equals(SuburItemClp.class.getName())) {
			return translateInputSuburItem(oldModel);
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

	public static Object translateInputDivision(BaseModel<?> oldModel) {
		DivisionClp oldClpModel = (DivisionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDivisionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFileEntryType(BaseModel<?> oldModel) {
		FileEntryTypeClp oldClpModel = (FileEntryTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFileEntryTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemAuthor(BaseModel<?> oldModel) {
		ItemAuthorClp oldClpModel = (ItemAuthorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemAuthorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemDivision(BaseModel<?> oldModel) {
		ItemDivisionClp oldClpModel = (ItemDivisionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemDivisionRemoteModel();

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

	public static Object translateInputItemSubject(BaseModel<?> oldModel) {
		ItemSubjectClp oldClpModel = (ItemSubjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemSubjectRemoteModel();

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

	public static Object translateInputSubject(BaseModel<?> oldModel) {
		SubjectClp oldClpModel = (SubjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSubjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSuburItem(BaseModel<?> oldModel) {
		SuburItemClp oldClpModel = (SuburItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSuburItemRemoteModel();

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
					"com.idetronic.subur.model.impl.DivisionImpl")) {
			return translateOutputDivision(oldModel);
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
					"com.idetronic.subur.model.impl.FileEntryTypeImpl")) {
			return translateOutputFileEntryType(oldModel);
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
					"com.idetronic.subur.model.impl.ItemDivisionImpl")) {
			return translateOutputItemDivision(oldModel);
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
					"com.idetronic.subur.model.impl.ItemSubjectImpl")) {
			return translateOutputItemSubject(oldModel);
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
					"com.idetronic.subur.model.impl.SubjectImpl")) {
			return translateOutputSubject(oldModel);
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

		if (className.equals("com.idetronic.subur.NoSuchDivisionException")) {
			return new com.idetronic.subur.NoSuchDivisionException();
		}

		if (className.equals("com.idetronic.subur.NoSuchFileEntryTypeException")) {
			return new com.idetronic.subur.NoSuchFileEntryTypeException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemAuthorException")) {
			return new com.idetronic.subur.NoSuchItemAuthorException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemDivisionException")) {
			return new com.idetronic.subur.NoSuchItemDivisionException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemFileEntryException")) {
			return new com.idetronic.subur.NoSuchItemFileEntryException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemItemTypeException")) {
			return new com.idetronic.subur.NoSuchItemItemTypeException();
		}

		if (className.equals("com.idetronic.subur.NoSuchItemSubjectException")) {
			return new com.idetronic.subur.NoSuchItemSubjectException();
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

		if (className.equals("com.idetronic.subur.NoSuchSubjectException")) {
			return new com.idetronic.subur.NoSuchSubjectException();
		}

		if (className.equals("com.idetronic.subur.NoSuchSuburItemException")) {
			return new com.idetronic.subur.NoSuchSuburItemException();
		}

		return throwable;
	}

	public static Object translateOutputAuthor(BaseModel<?> oldModel) {
		AuthorClp newModel = new AuthorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAuthorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDivision(BaseModel<?> oldModel) {
		DivisionClp newModel = new DivisionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDivisionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFileEntryType(BaseModel<?> oldModel) {
		FileEntryTypeClp newModel = new FileEntryTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFileEntryTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemAuthor(BaseModel<?> oldModel) {
		ItemAuthorClp newModel = new ItemAuthorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemAuthorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemDivision(BaseModel<?> oldModel) {
		ItemDivisionClp newModel = new ItemDivisionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemDivisionRemoteModel(oldModel);

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

	public static Object translateOutputItemSubject(BaseModel<?> oldModel) {
		ItemSubjectClp newModel = new ItemSubjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemSubjectRemoteModel(oldModel);

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

	public static Object translateOutputSubject(BaseModel<?> oldModel) {
		SubjectClp newModel = new SubjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSubjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSuburItem(BaseModel<?> oldModel) {
		SuburItemClp newModel = new SuburItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSuburItemRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}