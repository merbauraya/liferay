package com.idetronic.subur.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.idetronic.subur.model.SuburItem;
import com.liferay.portal.kernel.dao.search.SearchContainer;



public class SuburSearch extends SearchContainer<SuburItem> {
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-item-were-found";
	

	public static List<String> headerNames = new ArrayList<String>();
	public static Map<String, String> orderableHeaders = new HashMap<String,String>();

	
	public SuburSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
			portletRequest, new SuburDisplayTerms(portletRequest),
			new AuthorSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		SuburDisplayTerms displayTerms = (SuburDisplayTerms)getDisplayTerms();
		
	}

}
