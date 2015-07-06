package com.idetronic.subur.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class AuthorSearchTerms extends AuthorDisplayTerms{

	public AuthorSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		firstName = DAOParamUtil.getString(portletRequest, FIRSTNAME);
		lastName = DAOParamUtil.getString(portletRequest, LASTNAME);
	}
	
}
