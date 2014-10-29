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


import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.idetronic.portlet.UserServiceExperience;
import com.idetronic.portlet.model.ExpertiseTag;
import com.idetronic.portlet.service.ExpertiseTagLocalServiceUtil;
import com.idetronic.portlet.service.base.ExpertiseTagLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import  com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;


/**
 * The implementation of the expertise tag local service.

 * @author Mazlan Mat
 * @see com.idetronic.portlet.service.base.ExpertiseTagLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.ExpertiseTagLocalServiceUtil
 */
public class ExpertiseTagLocalServiceImpl
	extends ExpertiseTagLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(ExpertiseTagLocalServiceImpl.class);
	public void addExpertiseTag(String[] tags,long userId) throws SystemException, PortalException
	{
		if (tags.length == 0)
		{
			
			return;
		}
		List<ExpertiseTag> eTags = expertiseTagPersistence.findByTagName(tags);
		Set<String> tagEntries = new HashSet<String>();
		
		
		User user = userLocalService.getUserById(userId);
		
		for(ExpertiseTag _tag: eTags)
		{
			tagEntries.add(_tag.getTagName());
			
		}
		for (String tag: tags)
		{
			if ((!tagEntries.contains(tag) || (tagEntries.size() == 0)) && (!Validator.isBlank(tag)))
			{
				long tagId = counterLocalService.increment();
				ExpertiseTag newTag = ExpertiseTagLocalServiceUtil.createExpertiseTag(tagId);
				newTag.setCompanyId(user.getCompanyId());
				newTag.setCreateDate(new Date());
				newTag.setModifiedDate(new Date());
				newTag.setTagName(tag);
				newTag.setUserCount(0);
				newTag.setUserId(userId);
				
				ExpertiseTagLocalServiceUtil.updateExpertiseTag(newTag);
			}
		}
		
		
		
		
		
	}
	public void addExpertiseTag(String tags,String delimeter,long userId) throws SystemException, PortalException
	{
		String[] _tags = tags.split(delimeter);
		addExpertiseTag(_tags,userId);
	}
	public List<ExpertiseTag> findByTagName(String[] tagNames) throws SystemException
	{
		return expertiseTagPersistence.findByTagName(tagNames);
	}
	
}