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

package com.slayer.service.impl;

import java.util.Date;

import com.slayer.model.LMSBook;
import com.slayer.model.impl.LMSBookImpl;
import com.slayer.service.base.LMSBookLocalServiceBaseImpl;

/**
 * The implementation of the l m s book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.slayer.service.LMSBookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matle
 * @see com.slayer.service.base.LMSBookLocalServiceBaseImpl
 * @see com.slayer.service.LMSBookLocalServiceUtil
 */
public class LMSBookLocalServiceImpl extends LMSBookLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.slayer.service.LMSBookLocalServiceUtil} to access the l m s book local service.
	 */
public LMSBook insertBook(String bookTitle, String author) {
		
		LMSBook lmsBook = new LMSBookImpl();
		
		
		//lmsBook.setBookId(bookId);
		lmsBook.setAuthor(author);
		lmsBook.setBookTitle(bookTitle);
		lmsBook.setCreateDate(new Date());
		try{
			lmsBook = addLMSBook(lmsBook);
		
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lmsBook;
	}
}