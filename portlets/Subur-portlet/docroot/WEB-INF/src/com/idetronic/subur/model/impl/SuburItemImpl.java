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

package com.idetronic.subur.model.impl;

import java.util.List;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.search.SuburSearchUtil;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.util.SuburUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The extended model implementation for the SuburItem service. Represents a row in the &quot;item&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.model.SuburItem} interface.
 * </p>
 *
 * @author Mazlan Mat
 */
public class SuburItemImpl extends SuburItemBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a subur item model instance should use the {@link com.idetronic.subur.model.SuburItem} interface instead.
	 */
	
	private static Log logger = LogFactoryUtil.getLog(SuburItemImpl.class);
	
	public SuburItemImpl() {
	}
	/*
	public String getEntryImageURL(ThemeDisplay themeDisplay) {
		
		if (!isSmallImage()) {
			return null;
		}
		if (Validator.isNotNull(getSmallImageURL())) {
			return getSmallImageURL();
		}

		return themeDisplay.getPathImage() + "/subur/item?img_id=" +
			getSmallImageId() + "&t=" +
				WebServerServletTokenUtil.getToken(getSmallImageId());

	}
	}*/
	public String getSearchDescription()
	{
		String authorDescription = "Author :".concat(StringPool.SPACE);
		long[] authorIds;
		try {
			authorIds = ItemAuthorLocalServiceUtil.getAuthorId(getItemId());
			List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
			for (Author author: authors)
			{
				
				authorDescription = authorDescription.concat(SuburUtil.getName(author.getFirstName(), author.getLastName()));
				authorDescription = authorDescription.concat(StringPool.SPACE);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return StringPool.BLANK;
		}
		
		
;		return (authorDescription);
	}
}