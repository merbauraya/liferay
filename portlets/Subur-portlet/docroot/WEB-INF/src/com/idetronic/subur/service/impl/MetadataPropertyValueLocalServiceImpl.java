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

package com.idetronic.subur.service.impl;

import java.util.List;

import com.idetronic.subur.NoSuchMetadataPropertyValueException;
import com.idetronic.subur.model.MetadataPropertyValue;
import com.idetronic.subur.model.MetadataValueView;
import com.idetronic.subur.service.MetadataValueViewLocalServiceUtil;
import com.idetronic.subur.service.base.MetadataPropertyValueLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.MetadataPropertyValueFinderUtil;
import com.idetronic.subur.service.persistence.MetadataPropertyValuePK;
import com.idetronic.subur.service.persistence.MetadataValueViewPK;
import com.idetronic.subur.service.persistence.SuburItemFinderUtil;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.facet.AssetEntriesFacet;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the metadata property value local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.MetadataPropertyValueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.MetadataPropertyValueLocalServiceBaseImpl
 * @see com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil
 */
public class MetadataPropertyValueLocalServiceImpl
	extends MetadataPropertyValueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil} to access the metadata property value local service.
	 */
	private static Log logger = LogFactoryUtil.getLog(MetadataPropertyValueLocalServiceImpl.class);
	public MetadataPropertyValue addMetadataPropertyValue(long itemId,long metadataId,String textValue) throws SystemException
	{
		long metadataPropertyValueId = counterLocalService.increment();
		MetadataPropertyValue entry = metadataPropertyValuePersistence.create(metadataPropertyValueId);
				
		entry.setItemId(itemId);
		entry.setPropertyId(metadataId);
		entry.setTextValue(textValue);
		
		metadataPropertyValuePersistence.update(entry);
		return entry;

	}
	public MetadataPropertyValue updateMetadataPropertyValue(long metadataPropertyValueId,
			long itemId,long metadataId,String textValue) throws SystemException, NoSuchMetadataPropertyValueException
	{
		MetadataPropertyValue entry = metadataPropertyValuePersistence.findByPrimaryKey(metadataPropertyValueId);
		entry.setItemId(itemId);
		entry.setPropertyId(metadataId);
		entry.setTextValue(textValue);
		
		metadataPropertyValuePersistence.update(entry);
		return entry;
	}
	public List getAdditionalMetadata(long itemId)
	{
		List additionalMetadata = MetadataPropertyValueFinderUtil.getAdditionalMetadata(itemId);
		return (List)additionalMetadata.get(1) ;//MetadataPropertyValueFinderUtil.
	}
	
	public List getAuthor(long itemId)
	{
		List authors = MetadataPropertyValueFinderUtil.getAuthor(itemId);
		
		return (List)authors.get(1);
	}

	@Override
	public List getByItemId(long itemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List getItemCountAuthorBySubject(long subjectId)
	{
		return null;
		//Facet assetEntriesFacet = new AssetEntriesFacet(searchContext);
	
				
		
	}
}