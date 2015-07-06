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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.idetronic.subur.NoSuchAuthorException;
import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.ItemAuthor;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.base.ItemAuthorLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.ItemAuthorPK;
import com.idetronic.subur.service.persistence.SuburItemFinderUtil;



/**
 * The implementation of the item author local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ItemAuthorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ItemAuthorLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ItemAuthorLocalServiceUtil
 */
public class ItemAuthorLocalServiceImpl extends ItemAuthorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ItemAuthorLocalServiceUtil} to access the item author local service.
	 */
	private static Log logger = LogFactoryUtil.getLog(ItemAuthorLocalServiceImpl.class);
	/***
	 * 
	 */
	public void add(long itemId,long authorId) throws SystemException
	{
		ItemAuthorPK itemAuthorPK = new ItemAuthorPK();
		itemAuthorPK.setAuthorId(authorId);
		itemAuthorPK.setItemId(itemId);
		ItemAuthor itemAuthor = ItemAuthorLocalServiceUtil.createItemAuthor(itemAuthorPK);
		
		itemAuthorPersistence.update(itemAuthor);
	}
	
	/**
	 * Return all author id for a given item id
	 * @param itemId Subur Item id
	 * @return long array of author id
	 * @throws SystemException if author could not be found for the given item id
	 */
	public long[] getAuthorId(long itemId) throws SystemException
	{
		List<ItemAuthor> itemAuthors = itemAuthorPersistence.findByitemId(itemId);
		long[] authors = new long[itemAuthors.size()];
		for (int i = 0; i < itemAuthors.size(); i++)
		{
			authors[i] = itemAuthors.get(i).getAuthorId();
		}
		return authors;
		
	}
	/**
	 * Get list of author for the given item Id
	 * @param itemId
	 * @return list of author
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	
	public List<Author> getAuthors(long itemId) throws PortalException, SystemException
	{
		long[] authorIds = getAuthorId(itemId);
		return AuthorLocalServiceUtil.getAuthors(authorIds);
		
	}
	/**
	 * Get an array of author for a given item id
	 * @param itemId
	 * @return array of Author
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Author[] getAuthorArray(long itemId) throws PortalException, SystemException
	{
		long[] authorIds = getAuthorId(itemId);
		List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
		Author[] authorArray = new Author[authors.size()];
		
		for (int i = 0; i < authors.size(); i++)
			authorArray[i] = authors.get(i);
		
		return authorArray;
				
		
	}
	
	/**
	 * Set Item author based on given itemid and array of author ids
	 * @param itemId to be updated
	 * @param authorIds array of Author Id
	 * @throws SystemException
	 */
	public void setItemAuthor(long itemId,long[] authorIds) throws SystemException 
	{

		Set<Long> newAuthorIds = new HashSet<Long>();
		//ensure no duplicate in authorIds		
		for (int i = 0; i < authorIds.length; i++)
		{
			newAuthorIds.add(authorIds[i]);
		}
		//ensure author item count is reflected
		List<ItemAuthor> itemAuthors = itemAuthorPersistence.findByitemId(itemId);
		for (ItemAuthor itemAuthor: itemAuthors)
			AuthorLocalServiceUtil.decrementItemCount(itemAuthor.getAuthorId());
		
		itemAuthorPersistence.removeByitemId(itemId);
		
		Iterator<Long> authorIterator = newAuthorIds.iterator();
		while (authorIterator.hasNext())
		{
			long authorId = authorIterator.next();
			ItemAuthorPK itemAuthorPK = new ItemAuthorPK();
			itemAuthorPK.setAuthorId(authorId);
			itemAuthorPK.setItemId(itemId);
			
			ItemAuthor itemAuthor = ItemAuthorLocalServiceUtil.createItemAuthor(itemAuthorPK);
			
			itemAuthorPersistence.update(itemAuthor);
		}
		
		
		
		
	}
}