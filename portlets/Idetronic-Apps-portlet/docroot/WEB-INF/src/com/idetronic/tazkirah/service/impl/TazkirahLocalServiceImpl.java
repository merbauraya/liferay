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

package com.idetronic.tazkirah.service.impl;

import java.util.Date;
import java.util.List;

import com.idetronic.tazkirah.TazkirahConstant;
import com.idetronic.tazkirah.model.Tazkirah;
import com.idetronic.tazkirah.model.impl.TazkirahImpl;
import com.idetronic.tazkirah.service.base.TazkirahLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the tazkirah local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.tazkirah.service.TazkirahLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.tazkirah.service.base.TazkirahLocalServiceBaseImpl
 * @see com.idetronic.tazkirah.service.TazkirahLocalServiceUtil
 */
public class TazkirahLocalServiceImpl extends TazkirahLocalServiceBaseImpl {
	Log log = LogFactoryUtil.getLog(TazkirahLocalServiceImpl.class);
	
	public Tazkirah addEntry(String title,String content,String category,long userId,String userName,long companyId,long groupId)
	{
		Tazkirah tazkirah = new TazkirahImpl();
		tazkirah.setCompanyId(companyId);
		tazkirah.setTitle(title);
		tazkirah.setContent(content);
		tazkirah.setCategory(category);
		tazkirah.setUserId(userId);
		tazkirah.setGroupId(groupId);
		tazkirah.setUserName(userName);
		tazkirah.setCreateDate(new Date());
		tazkirah.setModifiedDate(new Date());
		try
		{
			long id = CounterLocalServiceUtil.increment(TazkirahConstant.TAZKIRAH_MODEL_NAME);//entity specific increment
			tazkirah.setTazkirahId(id);
			tazkirah = addTazkirah(tazkirah);
			
		} catch (SystemException ex)
		{
			log.error(ex,ex);
		}
		return tazkirah;
		
	}
	public Tazkirah updateEntry(long tazkirahId,String title,String content,String category,long userId,String userName,long companyId,long groupId)
	{
		Tazkirah tazkirah = null;
		try
		{
			tazkirah = fetchTazkirah(tazkirahId);
			tazkirah.setCompanyId(companyId);
			tazkirah.setContent(content);
			tazkirah.setTitle(title);
			tazkirah.setCategory(category);
			tazkirah.setUserId(userId);
			tazkirah.setUserName(userName);
			tazkirah.setModifiedDate(new Date());
			tazkirah = updateTazkirah(tazkirah);
		} catch (SystemException ex)
		{
			log.error(ex, ex);
		}
		return tazkirah;
		
	}
	public void deleteEntry(long tazkirahId)
	{
		try {
			Tazkirah tazkirah = deleteTazkirah(tazkirahId);
		} catch (PortalException e) {
			log.error(e,e);
		} catch (SystemException e) {
			log.error(e,e);
		}
	}
	public List<Tazkirah> listOrderByCategory(long companyId,long groupId)
	{
		List<Tazkirah> tazkirahs = null;
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Tazkirah.class);
		query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		query.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		query.addOrder(OrderFactoryUtil.desc("category"));
		try {
			tazkirahs = dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return tazkirahs;
	}
	public List<Tazkirah> getByCategory(String category,long companyId,long groupId)
	{
		List<Tazkirah> tazkirahs = null;
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Tazkirah.class);
		query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		//query.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		query.addOrder(OrderFactoryUtil.desc("modifiedDate"));
		query.setLimit(0, 50);
		
		if (Validator.isNotNull(category))
		{
			query.add(PropertyFactoryUtil.forName("category").eq(category));
		}
		try {
			tazkirahs = dynamicQuery(query);
			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return tazkirahs;
		
	}
}