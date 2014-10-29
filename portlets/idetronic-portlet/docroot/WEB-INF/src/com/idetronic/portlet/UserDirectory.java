package com.idetronic.portlet;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;



public class UserDirectory extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(UserDirectory.class);
	
	
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException 
	{
		
		Tuple tuple = null;
		String q = ParamUtil.getString(request, "q");
		_log.info("server="+q);
		SearchContext searchContext = new SearchContext();
		searchContext.setSearchEngineId(SearchEngineUtil.SYSTEM_ENGINE_ID);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(
				searchContext);
		
		//booleanQuery.addTerm(arg0, arg1);
		//Hits hits = SearchEngineUtil.search(searchContext, booleanQuery);
		//Hits hits = UserLocalServiceUtil.search(company.getCompanyId(), q, WorkflowConstants.STATUS_ANY, userParams, userSearchContainer.getStart(), userSearchContainer.getEnd(), sort);

		//hits = UserLocalServiceUtil.search(company.getCompanyId(), q, searchTerms.getStatus(), userParams, userSearchContainer.getStart(), userSearchContainer.getEnd(), sort);
		
		
	
	
		
		
	}

	
}
