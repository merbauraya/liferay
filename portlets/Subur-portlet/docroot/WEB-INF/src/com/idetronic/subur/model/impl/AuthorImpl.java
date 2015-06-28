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

import com.idetronic.subur.util.SuburUtil;

/**
 * The extended model implementation for the Author service. Represents a row in the &quot;subur_Author&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.model.Author} interface.
 * </p>
 *
 * @author Mazlan Mat
 */
public class AuthorImpl extends AuthorBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a author model instance should use the {@link com.idetronic.subur.model.Author} interface instead.
	 */
	public AuthorImpl() {
	}
	public String getDisplayName()
	{
		return SuburUtil.getAuhorDisplayName(getFirstName(), getLastName());
	}
}