package com.idetronic.subur.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class SuburSearchTerms extends SuburDisplayTerms {
	public SuburSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		title = DAOParamUtil.getString(portletRequest, "title");
		year = DAOParamUtil.getString(portletRequest, "year");
		authorFirstName = DAOParamUtil.getString(portletRequest, "authorFirstName");
		authorLastName = DAOParamUtil.getString(portletRequest, "authorLastName");
		itemType = DAOParamUtil.getLong(portletRequest, ITEM_TYPE);
	}

}
