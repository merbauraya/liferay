package com.idetronic.subur.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

















import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.idetronic.subur.model.Author;
import com.idetronic.subur.util.comparator.AuthorComparatorUtil;
import com.idetronic.subur.util.comparator.AuthorFirstNameComparator;

public class AuthorSearch extends SearchContainer<Author> {
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-authors-were-found";
	

	public static List<String> headerNames = new ArrayList<String>();
	public static Map<String, String> orderableHeaders = new HashMap<String,String>();

	static {
		headerNames.add("firstName");
		headerNames.add("lastName");
		headerNames.add("lastPublishedDate");


		orderableHeaders.put("firstName", "firstName");
		orderableHeaders.put("lastName", "lastName");
		
	}

	public AuthorSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
			portletRequest, new AuthorDisplayTerms(portletRequest),
			new AuthorSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		AuthorDisplayTerms displayTerms = (AuthorDisplayTerms)getDisplayTerms();

		//iteratorURL.setParameter(
			//AuthorDisplayTerms.DESCRIPTION, displayTerms.getDescription());
		iteratorURL.setParameter(AuthorDisplayTerms.FIRSTNAME, displayTerms.getFirstName());
		iteratorURL.setParameter(AuthorDisplayTerms.LASTNAME, displayTerms.getLastName());
		//iteratorURL.setParameter(AuthorDisplayTerms.LAST_PUBLISHED_DATE, displayTerms.getLastPublishedDate());
		//iteratorURL.setParameter(
			//RoleDisplayTerms.TYPE, String.valueOf(displayTerms.getType()));

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					portletRequest);

			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
					PortletKeys.ROLES_ADMIN, "authors-order-by-col", orderByCol);
				preferences.setValue(
					PortletKeys.ROLES_ADMIN, "authors-order-by-type",
					orderByType); 
			}
			else {
				orderByCol = preferences.getValue(
					PortletKeys.ROLES_ADMIN, "authors-order-by-col", "firstName");
				orderByType = preferences.getValue(
					PortletKeys.ROLES_ADMIN, "authors-order-by-type", "asc");
			}
			
		
			
			
			OrderByComparator orderByComparator = AuthorComparatorUtil.getUserOrderByComparator(
					orderByCol, orderByType);
				

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(AuthorSearch.class);


}
