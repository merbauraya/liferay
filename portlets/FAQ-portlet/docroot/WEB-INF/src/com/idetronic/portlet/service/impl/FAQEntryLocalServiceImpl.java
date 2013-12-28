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
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactory;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the f a q entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.portlet.service.FAQEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
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
	 * Never reference this interface directly. Always use {@link com.idetronic.portlet.service.FAQEntryLocalServiceUtil} to access the f a q entry local service.
	 */
	public FAQEntry addEntry(String category,String question,String answer)
	{
		FAQEntry faq = new FAQEntryImpl();
		faq.setCategory(category);
		faq.setQuestion(question);
		faq.setAnswer(answer);
		faq.setIsactive(true);
		faq.setCreateDate(new Date());
		try
		{
			faq = addFAQEntry(faq);
			
		}catch (SystemException ex)
		{
			ex.printStackTrace();
		}
		
		return faq;
	}
	public FAQEntry updateEntry(long faqId,String category,String question,String answer)
	{
		
		
		
		FAQEntry faq=null;
		
		
		try
		{
			faq = fetchFAQEntry(faqId);
			faq.setQuestion(question);
			faq.setCategory(category);
			
			faq.setAnswer(answer);
			faq.setModifiedDate(new Date());
			
			faq = updateFAQEntry(faq);
			
		}catch (SystemException ex)
		{
			ex.printStackTrace();
		}
		return faq;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getCategory()
	{
		List<String> catList = new ArrayList<String>();

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(FAQEntry.class);
		
		query.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("category")));
		//query.addOrder(OrderFactoryUtil.asc("displayOrder"));
		
		try {
			catList = dynamicQuery(query);
						
		}catch (SystemException ex)
		{
			ex.printStackTrace();
		}
		
		
		return catList;
	}
	public List<FAQEntry> getAll()
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(FAQEntry.class);
		
		query.add(PropertyFactoryUtil.forName("isactive").eq(true));
		query.addOrder(OrderFactoryUtil.asc("displayOrder"));
		try
		{
			List<FAQEntry> faqs = dynamicQuery(query);
		
			return faqs;
		}catch (SystemException ex)
		{
			ex.printStackTrace();
			return null;
			
		}
	}
	public List<FAQEntry> getByCategory(String category)
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(FAQEntry.class);
		query.add(PropertyFactoryUtil.forName("category").eq(category));
		query.addOrder(OrderFactoryUtil.asc("displayorder"));
		
		try
		{
			List<FAQEntry> faqs = dynamicQuery(query);
		
			return faqs;
		}catch (SystemException ex)
		{
			ex.printStackTrace();
			return null;
			
		}
	}
}