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

package com.idetronic.eprint.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.idetronic.eprint.admin.EprintHelper;
import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.model.impl.EprintImpl;
import com.idetronic.eprint.service.EprintLocalServiceUtil;
import com.idetronic.eprint.service.base.EprintLocalServiceBaseImpl;
import com.idetronic.eprint.service.persistence.EprintFinderUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalService; 
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.Validator;
/**
 * The implementation of the eprint local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eprint.service.EprintLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matle
 * @see com.idetronic.eprint.service.base.EprintLocalServiceBaseImpl
 * @see com.idetronic.eprint.service.EprintLocalServiceUtil
 */
public class EprintLocalServiceImpl extends EprintLocalServiceBaseImpl {
	private static final Log log = LogFactoryUtil.getLog(EprintLocalServiceImpl.class);

	public Eprint insertEprint(long eprintId,String title,String eprintAbstract,String eprintStatus,String eprintType,
			                String metadataVisibility,String eprintKeywords,String isPublished,
			                String dateYear,String fullTextStatus,
			                Date createdDate,Date modifiedDate,ServiceContext serviceContext)
	{
		Eprint eprint = new EprintImpl();
		eprint.setEprintId(eprintId);
		eprint.setTitle(title);
		eprint.setEprintAbstract(eprintAbstract);
		eprint.setEprintStatus(eprintStatus);
		eprint.setEprintType(eprintType);
		eprint.setMetadataVisibility(metadataVisibility);
		eprint.setEprintKeywords(eprintKeywords);
		eprint.setIsPublished(isPublished);
		eprint.setDateYear(dateYear);
		eprint.setFullTextStatus(fullTextStatus);
		eprint.setCreatedDate(createdDate);
		eprint.setModifiedDate(modifiedDate);
		eprint.setCompanyId(serviceContext.getCompanyId());
		eprint.setGroupId(serviceContext.getScopeGroupId());
		try {
			eprint = eprintPersistence.update(eprint, false);
		} catch (SystemException e) {
			
			log.error(e);
		}
		try {
			assetEntryLocalService.updateEntry(
			        serviceContext.getUserId(),                     // userId
			        serviceContext.getScopeGroupId(),               // groupId
			        Eprint.class.getName(),                                // className
			        eprint.getPrimaryKey(),                                // classPK
			        serviceContext.getAssetCategoryIds(),   // category Ids
			        serviceContext.getAssetTagNames());
		} catch (PortalException e) {
			
			log.error(e);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} 
		 // indexer
		eprint.setExpandoBridgeAttributes(serviceContext);

        Indexer indexer =
                IndexerRegistryUtil.getIndexer(Eprint.class);
        try {
                indexer.reindex(eprint);
        } catch (SearchException e) {
                log.error(e);
        }

		
		return eprint;
		
	}
	public Eprint modifyEprint(long eprintId,String title,String eprintAbstract,String eprintStatus,String eprintType,
            String metadataVisibility,String eprintKeywords,String isPublished,
            String dateYear,String fullTextStatus,
            Date createdDate,Date modifiedDate,ServiceContext serviceContext)
	{
		 Eprint eprint = null;
         try {
                 eprint = fetchEprint(eprintId);
         } catch (SystemException e) {
                 log.error(e);
         }
         if (Validator.isNotNull(eprint))
         {
        		
        	 eprint.setTitle(title);
        	 eprint.setEprintAbstract(eprintAbstract);
        	 eprint.setEprintStatus(eprintStatus);
        	 eprint.setEprintType(eprintType);
        	 eprint.setMetadataVisibility(metadataVisibility);
        	 eprint.setEprintKeywords(eprintKeywords);
        	 eprint.setIsPublished(isPublished);
        	 eprint.setCreatedDate(createdDate);
        	 eprint.setModifiedDate(modifiedDate);
        	 eprint.setFullTextStatus(fullTextStatus);
        	 eprint.setCompanyId(serviceContext.getCompanyId());
        	 eprint.setGroupId(serviceContext.getScopeGroupId());
        	 try {
				eprint = updateEprint(eprint);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
         }
         return eprint;

	
	}
	public Hits getHits(String keyword, long companyId, long groupId) {
		// 1. Preparing a Search Context
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		String[] CLASS_NAMES = { Eprint.class.getName() };
		searchContext.setEntryClassNames(CLASS_NAMES);
		long[] groupIds = {groupId};
		searchContext.setGroupIds(groupIds);
		// 2. Preparing a Query to search
		BooleanQuery searchQuery =
		BooleanQueryFactoryUtil.create(searchContext);
		String[] terms = {Field.DESCRIPTION,Field.TITLE};
		try {
			searchQuery.addTerms(terms, keyword);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 3. Firing the query to get hits
		Hits hits = null;
		try {
			hits = SearchEngineUtil.search(
					searchContext, searchQuery);
		} catch (SearchException e) {
			e.printStackTrace();
		}
		return hits;
	}
	public List<Eprint> findBySubjectId(String subjectId,int begin,int end) 
						
	{
		return EprintFinderUtil.findBySubjectId(subjectId, begin, end);
	}
	public List<Eprint> searchIndex(String keyword, long companyId, long groupId)
		throws SystemException {
		
		Hits hits = getHits(keyword, companyId, groupId);
		// 1. return null if no results
		if (Validator.isNull(hits) || hits.getLength() == 0)
		return null;
		
		List<Eprint> eprints = new ArrayList<Eprint>();
		for (Document document : hits.getDocs()) 
		{
			long eprintId = GetterUtil.getLong(
					document.get(Field.ENTRY_CLASS_PK));
			Eprint eprint = fetchEprint(eprintId);
			eprints.add(eprint);
		}
		return eprints;
	}
}