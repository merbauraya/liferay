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

package com.idetronic.subur.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the SuburItem service. Represents a row in the &quot;subur_item&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mazlan Mat
 * @see SuburItemModel
 * @see com.idetronic.subur.model.impl.SuburItemImpl
 * @see com.idetronic.subur.model.impl.SuburItemModelImpl
 * @generated
 */
public interface SuburItem extends SuburItemModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.idetronic.subur.model.impl.SuburItemImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void setSeriesReportNo(
		java.util.Map<java.lang.String, java.lang.String> entryMap);

	public void setIdentifier(
		java.util.Map<java.lang.String, java.lang.String> identifierMap);

	public void setOtherTitle(java.lang.String[] otherTitle);

	public java.util.Map<java.lang.String, java.lang.String> getIdentifiers()
		throws java.io.IOException,
			javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException;

	public java.util.Map getSeriesReportNo()
		throws java.io.IOException,
			javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException;

	public java.lang.String[] getOtherTitles()
		throws java.io.IOException,
			javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException;

	public java.lang.String getSearchDescription();

	public java.util.List<com.idetronic.subur.model.ItemType> getItemTypes()
		throws com.liferay.portal.kernel.exception.SystemException;
}