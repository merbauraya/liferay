package com.idetronic.subur.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class AuthorDisplayTerms  extends DisplayTerms{
	
	public static final String DESCRIPTION = "description";

	public static final String FIRSTNAME = "firstName";

	public static final String LASTNAME = "lastName";
	
	protected String description;
	protected String firstName;
	protected String lastName;
	protected int type;
	
	public AuthorDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		description = ParamUtil.getString(portletRequest, DESCRIPTION);
		firstName = ParamUtil.getString(portletRequest, FIRSTNAME);
		lastName = ParamUtil.getString(portletRequest, LASTNAME);
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	

}
