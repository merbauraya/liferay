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

package com.idetronic.subur.service.base;

import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.service.ExpertiseService;
import com.idetronic.subur.service.persistence.AuthorExpertisePersistence;
import com.idetronic.subur.service.persistence.AuthorFinder;
import com.idetronic.subur.service.persistence.AuthorPersistence;
import com.idetronic.subur.service.persistence.ExpertiseFinder;
import com.idetronic.subur.service.persistence.ExpertisePersistence;
import com.idetronic.subur.service.persistence.ItemAuthorPersistence;
import com.idetronic.subur.service.persistence.ItemFileEntryPersistence;
import com.idetronic.subur.service.persistence.ItemItemTypeFinder;
import com.idetronic.subur.service.persistence.ItemItemTypePersistence;
import com.idetronic.subur.service.persistence.ItemTypePersistence;
import com.idetronic.subur.service.persistence.ItemTypeTemplatePersistence;
import com.idetronic.subur.service.persistence.MetadataPropertyPersistence;
import com.idetronic.subur.service.persistence.MetadataPropertyValueFinder;
import com.idetronic.subur.service.persistence.MetadataPropertyValuePersistence;
import com.idetronic.subur.service.persistence.MetadataSchemaPersistence;
import com.idetronic.subur.service.persistence.SuburItemFinder;
import com.idetronic.subur.service.persistence.SuburItemPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the expertise remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.idetronic.subur.service.impl.ExpertiseServiceImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.impl.ExpertiseServiceImpl
 * @see com.idetronic.subur.service.ExpertiseServiceUtil
 * @generated
 */
public abstract class ExpertiseServiceBaseImpl extends BaseServiceImpl
	implements ExpertiseService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.idetronic.subur.service.ExpertiseServiceUtil} to access the expertise remote service.
	 */

	/**
	 * Returns the author local service.
	 *
	 * @return the author local service
	 */
	public com.idetronic.subur.service.AuthorLocalService getAuthorLocalService() {
		return authorLocalService;
	}

	/**
	 * Sets the author local service.
	 *
	 * @param authorLocalService the author local service
	 */
	public void setAuthorLocalService(
		com.idetronic.subur.service.AuthorLocalService authorLocalService) {
		this.authorLocalService = authorLocalService;
	}

	/**
	 * Returns the author persistence.
	 *
	 * @return the author persistence
	 */
	public AuthorPersistence getAuthorPersistence() {
		return authorPersistence;
	}

	/**
	 * Sets the author persistence.
	 *
	 * @param authorPersistence the author persistence
	 */
	public void setAuthorPersistence(AuthorPersistence authorPersistence) {
		this.authorPersistence = authorPersistence;
	}

	/**
	 * Returns the author finder.
	 *
	 * @return the author finder
	 */
	public AuthorFinder getAuthorFinder() {
		return authorFinder;
	}

	/**
	 * Sets the author finder.
	 *
	 * @param authorFinder the author finder
	 */
	public void setAuthorFinder(AuthorFinder authorFinder) {
		this.authorFinder = authorFinder;
	}

	/**
	 * Returns the author expertise local service.
	 *
	 * @return the author expertise local service
	 */
	public com.idetronic.subur.service.AuthorExpertiseLocalService getAuthorExpertiseLocalService() {
		return authorExpertiseLocalService;
	}

	/**
	 * Sets the author expertise local service.
	 *
	 * @param authorExpertiseLocalService the author expertise local service
	 */
	public void setAuthorExpertiseLocalService(
		com.idetronic.subur.service.AuthorExpertiseLocalService authorExpertiseLocalService) {
		this.authorExpertiseLocalService = authorExpertiseLocalService;
	}

	/**
	 * Returns the author expertise persistence.
	 *
	 * @return the author expertise persistence
	 */
	public AuthorExpertisePersistence getAuthorExpertisePersistence() {
		return authorExpertisePersistence;
	}

	/**
	 * Sets the author expertise persistence.
	 *
	 * @param authorExpertisePersistence the author expertise persistence
	 */
	public void setAuthorExpertisePersistence(
		AuthorExpertisePersistence authorExpertisePersistence) {
		this.authorExpertisePersistence = authorExpertisePersistence;
	}

	/**
	 * Returns the expertise local service.
	 *
	 * @return the expertise local service
	 */
	public com.idetronic.subur.service.ExpertiseLocalService getExpertiseLocalService() {
		return expertiseLocalService;
	}

	/**
	 * Sets the expertise local service.
	 *
	 * @param expertiseLocalService the expertise local service
	 */
	public void setExpertiseLocalService(
		com.idetronic.subur.service.ExpertiseLocalService expertiseLocalService) {
		this.expertiseLocalService = expertiseLocalService;
	}

	/**
	 * Returns the expertise remote service.
	 *
	 * @return the expertise remote service
	 */
	public com.idetronic.subur.service.ExpertiseService getExpertiseService() {
		return expertiseService;
	}

	/**
	 * Sets the expertise remote service.
	 *
	 * @param expertiseService the expertise remote service
	 */
	public void setExpertiseService(
		com.idetronic.subur.service.ExpertiseService expertiseService) {
		this.expertiseService = expertiseService;
	}

	/**
	 * Returns the expertise persistence.
	 *
	 * @return the expertise persistence
	 */
	public ExpertisePersistence getExpertisePersistence() {
		return expertisePersistence;
	}

	/**
	 * Sets the expertise persistence.
	 *
	 * @param expertisePersistence the expertise persistence
	 */
	public void setExpertisePersistence(
		ExpertisePersistence expertisePersistence) {
		this.expertisePersistence = expertisePersistence;
	}

	/**
	 * Returns the expertise finder.
	 *
	 * @return the expertise finder
	 */
	public ExpertiseFinder getExpertiseFinder() {
		return expertiseFinder;
	}

	/**
	 * Sets the expertise finder.
	 *
	 * @param expertiseFinder the expertise finder
	 */
	public void setExpertiseFinder(ExpertiseFinder expertiseFinder) {
		this.expertiseFinder = expertiseFinder;
	}

	/**
	 * Returns the item author local service.
	 *
	 * @return the item author local service
	 */
	public com.idetronic.subur.service.ItemAuthorLocalService getItemAuthorLocalService() {
		return itemAuthorLocalService;
	}

	/**
	 * Sets the item author local service.
	 *
	 * @param itemAuthorLocalService the item author local service
	 */
	public void setItemAuthorLocalService(
		com.idetronic.subur.service.ItemAuthorLocalService itemAuthorLocalService) {
		this.itemAuthorLocalService = itemAuthorLocalService;
	}

	/**
	 * Returns the item author persistence.
	 *
	 * @return the item author persistence
	 */
	public ItemAuthorPersistence getItemAuthorPersistence() {
		return itemAuthorPersistence;
	}

	/**
	 * Sets the item author persistence.
	 *
	 * @param itemAuthorPersistence the item author persistence
	 */
	public void setItemAuthorPersistence(
		ItemAuthorPersistence itemAuthorPersistence) {
		this.itemAuthorPersistence = itemAuthorPersistence;
	}

	/**
	 * Returns the item file entry local service.
	 *
	 * @return the item file entry local service
	 */
	public com.idetronic.subur.service.ItemFileEntryLocalService getItemFileEntryLocalService() {
		return itemFileEntryLocalService;
	}

	/**
	 * Sets the item file entry local service.
	 *
	 * @param itemFileEntryLocalService the item file entry local service
	 */
	public void setItemFileEntryLocalService(
		com.idetronic.subur.service.ItemFileEntryLocalService itemFileEntryLocalService) {
		this.itemFileEntryLocalService = itemFileEntryLocalService;
	}

	/**
	 * Returns the item file entry remote service.
	 *
	 * @return the item file entry remote service
	 */
	public com.idetronic.subur.service.ItemFileEntryService getItemFileEntryService() {
		return itemFileEntryService;
	}

	/**
	 * Sets the item file entry remote service.
	 *
	 * @param itemFileEntryService the item file entry remote service
	 */
	public void setItemFileEntryService(
		com.idetronic.subur.service.ItemFileEntryService itemFileEntryService) {
		this.itemFileEntryService = itemFileEntryService;
	}

	/**
	 * Returns the item file entry persistence.
	 *
	 * @return the item file entry persistence
	 */
	public ItemFileEntryPersistence getItemFileEntryPersistence() {
		return itemFileEntryPersistence;
	}

	/**
	 * Sets the item file entry persistence.
	 *
	 * @param itemFileEntryPersistence the item file entry persistence
	 */
	public void setItemFileEntryPersistence(
		ItemFileEntryPersistence itemFileEntryPersistence) {
		this.itemFileEntryPersistence = itemFileEntryPersistence;
	}

	/**
	 * Returns the item item type local service.
	 *
	 * @return the item item type local service
	 */
	public com.idetronic.subur.service.ItemItemTypeLocalService getItemItemTypeLocalService() {
		return itemItemTypeLocalService;
	}

	/**
	 * Sets the item item type local service.
	 *
	 * @param itemItemTypeLocalService the item item type local service
	 */
	public void setItemItemTypeLocalService(
		com.idetronic.subur.service.ItemItemTypeLocalService itemItemTypeLocalService) {
		this.itemItemTypeLocalService = itemItemTypeLocalService;
	}

	/**
	 * Returns the item item type persistence.
	 *
	 * @return the item item type persistence
	 */
	public ItemItemTypePersistence getItemItemTypePersistence() {
		return itemItemTypePersistence;
	}

	/**
	 * Sets the item item type persistence.
	 *
	 * @param itemItemTypePersistence the item item type persistence
	 */
	public void setItemItemTypePersistence(
		ItemItemTypePersistence itemItemTypePersistence) {
		this.itemItemTypePersistence = itemItemTypePersistence;
	}

	/**
	 * Returns the item item type finder.
	 *
	 * @return the item item type finder
	 */
	public ItemItemTypeFinder getItemItemTypeFinder() {
		return itemItemTypeFinder;
	}

	/**
	 * Sets the item item type finder.
	 *
	 * @param itemItemTypeFinder the item item type finder
	 */
	public void setItemItemTypeFinder(ItemItemTypeFinder itemItemTypeFinder) {
		this.itemItemTypeFinder = itemItemTypeFinder;
	}

	/**
	 * Returns the item type local service.
	 *
	 * @return the item type local service
	 */
	public com.idetronic.subur.service.ItemTypeLocalService getItemTypeLocalService() {
		return itemTypeLocalService;
	}

	/**
	 * Sets the item type local service.
	 *
	 * @param itemTypeLocalService the item type local service
	 */
	public void setItemTypeLocalService(
		com.idetronic.subur.service.ItemTypeLocalService itemTypeLocalService) {
		this.itemTypeLocalService = itemTypeLocalService;
	}

	/**
	 * Returns the item type persistence.
	 *
	 * @return the item type persistence
	 */
	public ItemTypePersistence getItemTypePersistence() {
		return itemTypePersistence;
	}

	/**
	 * Sets the item type persistence.
	 *
	 * @param itemTypePersistence the item type persistence
	 */
	public void setItemTypePersistence(ItemTypePersistence itemTypePersistence) {
		this.itemTypePersistence = itemTypePersistence;
	}

	/**
	 * Returns the item type template local service.
	 *
	 * @return the item type template local service
	 */
	public com.idetronic.subur.service.ItemTypeTemplateLocalService getItemTypeTemplateLocalService() {
		return itemTypeTemplateLocalService;
	}

	/**
	 * Sets the item type template local service.
	 *
	 * @param itemTypeTemplateLocalService the item type template local service
	 */
	public void setItemTypeTemplateLocalService(
		com.idetronic.subur.service.ItemTypeTemplateLocalService itemTypeTemplateLocalService) {
		this.itemTypeTemplateLocalService = itemTypeTemplateLocalService;
	}

	/**
	 * Returns the item type template persistence.
	 *
	 * @return the item type template persistence
	 */
	public ItemTypeTemplatePersistence getItemTypeTemplatePersistence() {
		return itemTypeTemplatePersistence;
	}

	/**
	 * Sets the item type template persistence.
	 *
	 * @param itemTypeTemplatePersistence the item type template persistence
	 */
	public void setItemTypeTemplatePersistence(
		ItemTypeTemplatePersistence itemTypeTemplatePersistence) {
		this.itemTypeTemplatePersistence = itemTypeTemplatePersistence;
	}

	/**
	 * Returns the metadata property local service.
	 *
	 * @return the metadata property local service
	 */
	public com.idetronic.subur.service.MetadataPropertyLocalService getMetadataPropertyLocalService() {
		return metadataPropertyLocalService;
	}

	/**
	 * Sets the metadata property local service.
	 *
	 * @param metadataPropertyLocalService the metadata property local service
	 */
	public void setMetadataPropertyLocalService(
		com.idetronic.subur.service.MetadataPropertyLocalService metadataPropertyLocalService) {
		this.metadataPropertyLocalService = metadataPropertyLocalService;
	}

	/**
	 * Returns the metadata property persistence.
	 *
	 * @return the metadata property persistence
	 */
	public MetadataPropertyPersistence getMetadataPropertyPersistence() {
		return metadataPropertyPersistence;
	}

	/**
	 * Sets the metadata property persistence.
	 *
	 * @param metadataPropertyPersistence the metadata property persistence
	 */
	public void setMetadataPropertyPersistence(
		MetadataPropertyPersistence metadataPropertyPersistence) {
		this.metadataPropertyPersistence = metadataPropertyPersistence;
	}

	/**
	 * Returns the metadata property value local service.
	 *
	 * @return the metadata property value local service
	 */
	public com.idetronic.subur.service.MetadataPropertyValueLocalService getMetadataPropertyValueLocalService() {
		return metadataPropertyValueLocalService;
	}

	/**
	 * Sets the metadata property value local service.
	 *
	 * @param metadataPropertyValueLocalService the metadata property value local service
	 */
	public void setMetadataPropertyValueLocalService(
		com.idetronic.subur.service.MetadataPropertyValueLocalService metadataPropertyValueLocalService) {
		this.metadataPropertyValueLocalService = metadataPropertyValueLocalService;
	}

	/**
	 * Returns the metadata property value persistence.
	 *
	 * @return the metadata property value persistence
	 */
	public MetadataPropertyValuePersistence getMetadataPropertyValuePersistence() {
		return metadataPropertyValuePersistence;
	}

	/**
	 * Sets the metadata property value persistence.
	 *
	 * @param metadataPropertyValuePersistence the metadata property value persistence
	 */
	public void setMetadataPropertyValuePersistence(
		MetadataPropertyValuePersistence metadataPropertyValuePersistence) {
		this.metadataPropertyValuePersistence = metadataPropertyValuePersistence;
	}

	/**
	 * Returns the metadata property value finder.
	 *
	 * @return the metadata property value finder
	 */
	public MetadataPropertyValueFinder getMetadataPropertyValueFinder() {
		return metadataPropertyValueFinder;
	}

	/**
	 * Sets the metadata property value finder.
	 *
	 * @param metadataPropertyValueFinder the metadata property value finder
	 */
	public void setMetadataPropertyValueFinder(
		MetadataPropertyValueFinder metadataPropertyValueFinder) {
		this.metadataPropertyValueFinder = metadataPropertyValueFinder;
	}

	/**
	 * Returns the metadata schema local service.
	 *
	 * @return the metadata schema local service
	 */
	public com.idetronic.subur.service.MetadataSchemaLocalService getMetadataSchemaLocalService() {
		return metadataSchemaLocalService;
	}

	/**
	 * Sets the metadata schema local service.
	 *
	 * @param metadataSchemaLocalService the metadata schema local service
	 */
	public void setMetadataSchemaLocalService(
		com.idetronic.subur.service.MetadataSchemaLocalService metadataSchemaLocalService) {
		this.metadataSchemaLocalService = metadataSchemaLocalService;
	}

	/**
	 * Returns the metadata schema persistence.
	 *
	 * @return the metadata schema persistence
	 */
	public MetadataSchemaPersistence getMetadataSchemaPersistence() {
		return metadataSchemaPersistence;
	}

	/**
	 * Sets the metadata schema persistence.
	 *
	 * @param metadataSchemaPersistence the metadata schema persistence
	 */
	public void setMetadataSchemaPersistence(
		MetadataSchemaPersistence metadataSchemaPersistence) {
		this.metadataSchemaPersistence = metadataSchemaPersistence;
	}

	/**
	 * Returns the subur item local service.
	 *
	 * @return the subur item local service
	 */
	public com.idetronic.subur.service.SuburItemLocalService getSuburItemLocalService() {
		return suburItemLocalService;
	}

	/**
	 * Sets the subur item local service.
	 *
	 * @param suburItemLocalService the subur item local service
	 */
	public void setSuburItemLocalService(
		com.idetronic.subur.service.SuburItemLocalService suburItemLocalService) {
		this.suburItemLocalService = suburItemLocalService;
	}

	/**
	 * Returns the subur item persistence.
	 *
	 * @return the subur item persistence
	 */
	public SuburItemPersistence getSuburItemPersistence() {
		return suburItemPersistence;
	}

	/**
	 * Sets the subur item persistence.
	 *
	 * @param suburItemPersistence the subur item persistence
	 */
	public void setSuburItemPersistence(
		SuburItemPersistence suburItemPersistence) {
		this.suburItemPersistence = suburItemPersistence;
	}

	/**
	 * Returns the subur item finder.
	 *
	 * @return the subur item finder
	 */
	public SuburItemFinder getSuburItemFinder() {
		return suburItemFinder;
	}

	/**
	 * Sets the subur item finder.
	 *
	 * @param suburItemFinder the subur item finder
	 */
	public void setSuburItemFinder(SuburItemFinder suburItemFinder) {
		this.suburItemFinder = suburItemFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Expertise.class;
	}

	protected String getModelClassName() {
		return Expertise.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = expertisePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.idetronic.subur.service.AuthorLocalService.class)
	protected com.idetronic.subur.service.AuthorLocalService authorLocalService;
	@BeanReference(type = AuthorPersistence.class)
	protected AuthorPersistence authorPersistence;
	@BeanReference(type = AuthorFinder.class)
	protected AuthorFinder authorFinder;
	@BeanReference(type = com.idetronic.subur.service.AuthorExpertiseLocalService.class)
	protected com.idetronic.subur.service.AuthorExpertiseLocalService authorExpertiseLocalService;
	@BeanReference(type = AuthorExpertisePersistence.class)
	protected AuthorExpertisePersistence authorExpertisePersistence;
	@BeanReference(type = com.idetronic.subur.service.ExpertiseLocalService.class)
	protected com.idetronic.subur.service.ExpertiseLocalService expertiseLocalService;
	@BeanReference(type = com.idetronic.subur.service.ExpertiseService.class)
	protected com.idetronic.subur.service.ExpertiseService expertiseService;
	@BeanReference(type = ExpertisePersistence.class)
	protected ExpertisePersistence expertisePersistence;
	@BeanReference(type = ExpertiseFinder.class)
	protected ExpertiseFinder expertiseFinder;
	@BeanReference(type = com.idetronic.subur.service.ItemAuthorLocalService.class)
	protected com.idetronic.subur.service.ItemAuthorLocalService itemAuthorLocalService;
	@BeanReference(type = ItemAuthorPersistence.class)
	protected ItemAuthorPersistence itemAuthorPersistence;
	@BeanReference(type = com.idetronic.subur.service.ItemFileEntryLocalService.class)
	protected com.idetronic.subur.service.ItemFileEntryLocalService itemFileEntryLocalService;
	@BeanReference(type = com.idetronic.subur.service.ItemFileEntryService.class)
	protected com.idetronic.subur.service.ItemFileEntryService itemFileEntryService;
	@BeanReference(type = ItemFileEntryPersistence.class)
	protected ItemFileEntryPersistence itemFileEntryPersistence;
	@BeanReference(type = com.idetronic.subur.service.ItemItemTypeLocalService.class)
	protected com.idetronic.subur.service.ItemItemTypeLocalService itemItemTypeLocalService;
	@BeanReference(type = ItemItemTypePersistence.class)
	protected ItemItemTypePersistence itemItemTypePersistence;
	@BeanReference(type = ItemItemTypeFinder.class)
	protected ItemItemTypeFinder itemItemTypeFinder;
	@BeanReference(type = com.idetronic.subur.service.ItemTypeLocalService.class)
	protected com.idetronic.subur.service.ItemTypeLocalService itemTypeLocalService;
	@BeanReference(type = ItemTypePersistence.class)
	protected ItemTypePersistence itemTypePersistence;
	@BeanReference(type = com.idetronic.subur.service.ItemTypeTemplateLocalService.class)
	protected com.idetronic.subur.service.ItemTypeTemplateLocalService itemTypeTemplateLocalService;
	@BeanReference(type = ItemTypeTemplatePersistence.class)
	protected ItemTypeTemplatePersistence itemTypeTemplatePersistence;
	@BeanReference(type = com.idetronic.subur.service.MetadataPropertyLocalService.class)
	protected com.idetronic.subur.service.MetadataPropertyLocalService metadataPropertyLocalService;
	@BeanReference(type = MetadataPropertyPersistence.class)
	protected MetadataPropertyPersistence metadataPropertyPersistence;
	@BeanReference(type = com.idetronic.subur.service.MetadataPropertyValueLocalService.class)
	protected com.idetronic.subur.service.MetadataPropertyValueLocalService metadataPropertyValueLocalService;
	@BeanReference(type = MetadataPropertyValuePersistence.class)
	protected MetadataPropertyValuePersistence metadataPropertyValuePersistence;
	@BeanReference(type = MetadataPropertyValueFinder.class)
	protected MetadataPropertyValueFinder metadataPropertyValueFinder;
	@BeanReference(type = com.idetronic.subur.service.MetadataSchemaLocalService.class)
	protected com.idetronic.subur.service.MetadataSchemaLocalService metadataSchemaLocalService;
	@BeanReference(type = MetadataSchemaPersistence.class)
	protected MetadataSchemaPersistence metadataSchemaPersistence;
	@BeanReference(type = com.idetronic.subur.service.SuburItemLocalService.class)
	protected com.idetronic.subur.service.SuburItemLocalService suburItemLocalService;
	@BeanReference(type = SuburItemPersistence.class)
	protected SuburItemPersistence suburItemPersistence;
	@BeanReference(type = SuburItemFinder.class)
	protected SuburItemFinder suburItemFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ExpertiseServiceClpInvoker _clpInvoker = new ExpertiseServiceClpInvoker();
}