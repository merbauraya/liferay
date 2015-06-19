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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.idetronic.subur.Subur;
import com.idetronic.subur.model.Author;
import com.idetronic.subur.service.base.AuthorLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.AuthorFinder;
import com.idetronic.subur.service.persistence.AuthorFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * The implementation of the author local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.AuthorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.AuthorLocalServiceBaseImpl
 * @see com.idetronic.subur.service.AuthorLocalServiceUtil
 */
public class AuthorLocalServiceImpl extends AuthorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.AuthorLocalServiceUtil} to access the author local service.
	 */
	private static Log logger = LogFactoryUtil.getLog(AuthorLocalServiceImpl.class);
	public long addAuthor(String firstName,String lastName,String remoteId,int idType) throws SystemException
	{
		Date now = new Date();
		long authorId = counterLocalService.increment();
		Author author = authorPersistence.create(authorId);
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setRemoteId(remoteId);
		author.setIdType(idType);
		
		authorPersistence.update(author);
		return authorId;
		
	}
	/**
	 * Return all authors with the primary keys
	 * @param authorIds the primary key of the author
	 * @return authors with primary key
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<Author> getAuthors(long[] authorIds) throws PortalException, SystemException  {
		List<Author> authors = new ArrayList<>(authorIds.length);
		for (long authorId : authorIds)
		{
			Author author = getAuthor(authorId);
			authors.add(author);
		}
		return authors;
	}
	
	private String authorLookup(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
		//String<> x = resourceRequest.
		String keyword = ParamUtil.getString(resourceRequest, "keyword");
		
		
		
		
		long itemId = ParamUtil.getLong(resourceRequest, "itemId");
		logger.info("keywrd="+ keyword);
		JSONObject jsonCells = JSONFactoryUtil.createJSONObject();
		  jsonCells.put("key", "1");
          jsonCells.put("name", "New York, USA");
          jsonResults.put(jsonCells);
          jsonCells = JSONFactoryUtil.createJSONObject();
          jsonCells.put("key", "2");
          jsonCells.put("name", "Delhi, India");
          jsonResults.put(jsonCells);
          jsonCells = JSONFactoryUtil.createJSONObject();
          jsonCells.put("key", "3");
          jsonCells.put("name", "Hyderabad, India");
          jsonResults.put(jsonCells);
          
          return jsonResults.toString();
		
	}
	public List<Author> search(String keyword,int start, int end, OrderByComparator obc) throws SystemException
	{
		String[] keywords = null;
		if (Validator.isNotNull(keyword))
			keywords = CustomSQLUtil.keywords(keyword);
		else
		{
			return authorPersistence.findAll(start, end, obc);
		}
			
		try {
			return AuthorFinderUtil.findByFirstName(keywords,new LinkedHashMap<String, Object>(), start, end, obc);
		} catch (SystemException e) {
			
			logger.error(e);
			throw new SystemException(e);
		}
	}
}