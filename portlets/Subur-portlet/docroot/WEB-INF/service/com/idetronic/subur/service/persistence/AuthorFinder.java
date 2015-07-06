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

package com.idetronic.subur.service.persistence;

/**
 * @author Mazlan Mat
 */
public interface AuthorFinder {
	public int getTotalByName(java.lang.String keyword, long companyId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.idetronic.subur.model.Author> findByFistNameLastName(
		long companyId, long groupId, java.lang.String firstName,
		java.lang.String lastName, boolean matchAll, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.idetronic.subur.model.Author> findByName(
		java.lang.String keyword, long companyId, long groupId, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByFistNameLastName(long companyId, long groupId,
		java.lang.String firstName, java.lang.String lastName,
		boolean isAndOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.idetronic.subur.model.Author> findByFirstName(
		java.lang.String[] keyword,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List getItemCountByGroupCompanyScalar(long companyId,
		long groupId);

	public java.util.List<com.idetronic.subur.model.Author> findByCompanyGroup(
		long companyId, long groupId, int start, int end);
}