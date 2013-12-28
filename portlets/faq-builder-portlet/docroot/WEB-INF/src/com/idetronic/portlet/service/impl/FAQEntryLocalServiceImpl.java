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

package com.idetronic.portlet.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.idetronic.portlet.service.base.FAQEntryLocalServiceBaseImpl;
import com.idetronic.portlet.model.FAQEntry;
import com.idetronic.portlet.model.impl.*;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactory;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
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
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the f a q entry local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.idetronic.portlet.service.FAQEntryLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Mazlan Mat
 * @see com.idetronic.portlet.service.base.FAQEntryLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.FAQEntryLocalServiceUtil
 */
public class FAQEntryLocalServiceImpl extends FAQEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.idetronic.portlet.service.FAQEntryLocalServiceUtil} to access the f a
	 * q entry local service.
	 */
	public FAQEntry addEntry(String category, String question, String answer,
			ServiceContext serviceContext) {
		FAQEntry faq = new FAQEntryImpl();
		faq.setCategory(category);
		faq.setQuestion(question);
		faq.setAnswer(answer);
		faq.setIsactive(true);
		faq.setCreateDate(new Date());
		faq.setGroupId(serviceContext.getScopeGroupId());
		faq.setCompanyId(serviceContext.getCompanyId());
		faq.setUserId(serviceContext.getUserId());
		long categoryOrder = getCategoryOrder(category);
		faq.setCategoryOrder(categoryOrder);
		
		// lmsBook.setGroupId(serviceContext.getScopeGroupId());
		try {
			faq = faqEntryPersistence.update(faq, false);
			// faq = addFAQEntry(faq);
			Indexer indexer = IndexerRegistryUtil.getIndexer(FAQEntry.class);
			try {
				indexer.reindex(faq);
			} catch (SearchException e) {
				e.printStackTrace();
			}

		} catch (SystemException ex) {
			ex.printStackTrace();
		}

		return faq;
	}

	public Hits getHits(String keyword, long companyId, long groupId) {
		// 1. Preparing a Search Context
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		String[] CLASS_NAMES = { FAQEntry.class.getName() };
		searchContext.setEntryClassNames(CLASS_NAMES);
		long[] groupIds = { groupId };
		searchContext.setGroupIds(groupIds);
		// 2. Preparing a Query to search
		BooleanQuery searchQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		String[] terms = { Field.TITLE, "author" };
		try {
			searchQuery.addTerms(terms, keyword);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 3. Firing the query to get hits
		Hits hits = null;
		try {
			hits = SearchEngineUtil.search(searchContext, searchQuery);
		} catch (SearchException e) {
			e.printStackTrace();
		}
		return hits;
	}

	public List<FAQEntry> getFaqs(long companyId, long groupId)
			throws SystemException {
		return null;
	}

	public List<FAQEntry> searchIndex(String keyword, long companyId,
			long groupId) throws SystemException {
		Hits hits = getHits(keyword, companyId, groupId);
		// 1. return null if no results
		if (Validator.isNull(hits) || hits.getLength() == 0)
			return null;
		// 2. Convert results into a List of LMSBook objects
		List<FAQEntry> faqs = new ArrayList<FAQEntry>();
		for (Document document : hits.getDocs()) {
			long bookId = GetterUtil
					.getLong(document.get(Field.ENTRY_CLASS_PK));
			FAQEntry faq = fetchFAQEntry(bookId);
			faqs.add(faq);
		}
		return faqs;
	}

	public FAQEntry updateEntry(long faqId, String category, String question,
			String answer) {

		FAQEntry faq = null;

		try {
			faq = fetchFAQEntry(faqId);
			faq.setQuestion(question);
			faq.setCategory(category);

			faq.setAnswer(answer);
			faq.setModifiedDate(new Date());

			faq = updateFAQEntry(faq);

		} catch (SystemException ex) {
			ex.printStackTrace();
		}
		return faq;

	}

	@SuppressWarnings("unchecked")
	public List<Object> getCategory() {
		List<String> catList = new ArrayList<String>();

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(FAQEntry.class);
		query.setProjection(ProjectionFactoryUtil.projectionList()
				.add(ProjectionFactoryUtil.groupProperty("category"))
				.add(ProjectionFactoryUtil.groupProperty("categoryOrder"))
				.add(ProjectionFactoryUtil.count("category")));

		// DynamicQuery query =
		// DynamicQueryFactoryUtil.forClass(FAQEntry.class);

		// query.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("category")));
		// query.setProjection(ProjectionFactoryUtil.count("category"));
		query.addOrder(OrderFactoryUtil.asc("categoryOrder"));

		try {
			// catList = dynamicQuery(query);
			List<Object> result = dynamicQuery(query);
			return result;

		} catch (SystemException ex) {
			ex.printStackTrace();
			return null;
		}

		// return catList;
	}

	public List<FAQEntry> getAll() {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(FAQEntry.class);

		query.add(PropertyFactoryUtil.forName("isactive").eq(true));
		// query.add(RestrictionsFactoryUtil.eq("isactive", true));
		query.addOrder(OrderFactoryUtil.asc("categoryOrder"));
		query.addOrder(OrderFactoryUtil.asc("displayorder"));
		try {
			List<FAQEntry> faqs = dynamicQuery(query);

			return faqs;
		} catch (SystemException ex) {
			ex.printStackTrace();
			return null;

		}
	}

	public List<FAQEntry> getByCategory(String category) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(FAQEntry.class);
		String[] inCondition = category.split(",");
		query.add(RestrictionsFactoryUtil.in("category",inCondition));//

		// query.add(PropertyFactoryUtil.forName("category").eq(category));
		//query.addOrder(OrderFactoryUtil.asc("category"));
		query.addOrder(OrderFactoryUtil.asc("displayorder"));

		try {
			List<FAQEntry> faqs = dynamicQuery(query);

			return faqs;
		} catch (SystemException ex) {
			ex.printStackTrace();
			return null;

		}
	}
	public void updateCategoryOrder(String category,int displayOrder)
	{
		
		List<FAQEntry> faqs = getByCategory(category);
		for (FAQEntry faq: faqs)
		{
			faq.setCategoryOrder(displayOrder);
			try {
				updateFAQEntry(faq);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void updateQuestionOrder(long id,int displayOrder)
	{
		FAQEntry faq = null;
		try {
			faq = fetchFAQEntry(id);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Validator.isNotNull(faq))
		{
			faq.setDisplayorder(displayOrder);
			try {
				faq = updateFAQEntry(faq);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private long getCategoryOrder(String category)
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(FAQEntry.class);
		query.add(RestrictionsFactoryUtil.eq("category",category));
		query.add(RestrictionsFactoryUtil.isNotNull("categoryOrder"));
		query.setLimit(0, 1);
		long categoryOrder =0;
		try {
			List<FAQEntry> faqs = dynamicQuery(query);
			for (FAQEntry faq: faqs)
			{
				categoryOrder = faq.getCategoryOrder();
			}
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryOrder;
		
		
		
				
		
	}
}