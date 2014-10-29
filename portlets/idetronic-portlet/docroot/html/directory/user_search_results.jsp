
<%--
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
--%>

<%
userParams.put("expandoAttributes", q);
out.print(q);		 

Sort sort = SortFactoryUtil.getSort(User.class, userSearchContainer.getOrderByCol(), userSearchContainer.getOrderByType());

boolean corruptIndex = false;

Hits hits = null;
Tuple tuple = null;
/*
do 
{
	
	

	tuple = UserServiceUtil.getUsers(hits);

	corruptIndex = (Boolean)tuple.getObject(1);
}
while (corruptIndex);
*/
long companyId = PortalUtil.getCompanyId(request);
hits = UserLocalServiceUtil.search(companyId, q, WorkflowConstants.STATUS_ANY, userParams, userSearchContainer.getStart(), userSearchContainer.getEnd(), sort);

results = UserServiceUtil.getUsers(hits);// (List<User>)tuple.getObject(0);

userSearchContainer.setResults(results);
userSearchContainer.setTotal(hits.getLength());

%>