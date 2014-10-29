package com.idetronic.portlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.idetronic.portlet.service.impl.OrgChartLocalServiceImpl;
import com.idetronic.portlet.util.Constant;
import com.idetronic.portlet.util.UserServiceUtil;
public class OrgChart extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(OrgChart.class);
	
	public void saveOrgTree(ActionRequest request,ActionResponse response) throws JSONException
	{
		 Enumeration<String> parameterNames = request.getParameterNames();
		 while (parameterNames.hasMoreElements()) {
			 String paramName = parameterNames.nextElement();
			 _log.info(paramName);
			 
			 
		 }
		 HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
		 String jsonTree = PortalUtil.getOriginalServletRequest(httpReq).getParameter("orgTree");
		 //_log.info(param);
		 
		//String jsonTree = ParamUtil.getString(request, "orgTree");
		_log.info(jsonTree);
		JSONArray orgJSON = JSONFactoryUtil.createJSONArray(jsonTree);
		_log.info(orgJSON);
		for (int i=0; i < orgJSON.length();i++)
		{
			JSONObject userJSON = orgJSON.getJSONObject(i);
			_log.info(userJSON.getLong("userId"));
		}
		
		
	}
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException 
	{
		String resource = ParamUtil.getString(request, "resource");
		String keyword;
		long companyId = PortalUtil.getCompanyId(request);
		long userId = ParamUtil.getLong(request, "userId");
		if (Validator.equals(resource, "usertree"))
		{
			JSONArray tree = buildOrgTree(userId);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(
					response);
				
				ServletResponseUtil.write(res, tree.toString());
		}
		if (Validator.equals(resource, Constant.RESOURCE_USER_SEARCH ))
		{
			keyword = ParamUtil.getString(request, Constant.PARAMETER_KEYWORDS);
			JSONArray tree;
			try {
				tree = searchUser(keyword,companyId);
				sendAjaxResponse(response,tree.toString());
			} catch (SystemException e) {
				_log.error(e);
				
			} catch (PortalException e) {
				_log.error(e);
			}
			
		}
		
	}
	private void sendAjaxResponse(ResourceResponse response,String output) throws IOException
	{
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		ServletResponseUtil.write(res, output);
	}
	private JSONArray searchUser(String keyword,long companyId) throws SystemException, PortalException
	{
		LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();
		userParams.put("expandoAttributes", keyword);
		Sort sort = SortFactoryUtil.getSort(User.class, "firstName", "asc");

		Hits hits = UserLocalServiceUtil.search(companyId, keyword, WorkflowConstants.STATUS_ANY, userParams, 0, 15, sort);
		List<User> users = UserServiceUtil.getUsers(hits);
		
		JSONArray orgJSON = JSONFactoryUtil.createJSONArray();
		for (User user: users)
		{
			JSONObject usrJSON = JSONFactoryUtil.createJSONObject();
			usrJSON.put("id", user.getUserId());
			usrJSON.put("name", user.getFullName());
			usrJSON.put("jobTitle", user.getJobTitle());
			
			orgJSON.put(usrJSON);
			
		}
		return orgJSON;
	}
	private JSONArray buildOrgTree(long userId)
	{
		JSONArray orgJSON = JSONFactoryUtil.createJSONArray();
		JSONObject usrJSON = JSONFactoryUtil.createJSONObject();
		usrJSON.put("id", 100);
		usrJSON.put("name", "Mazlan Mat");
		usrJSON.put("jobTitle", "System Consultant");
		usrJSON.put("parent", "");
		orgJSON.put(usrJSON);
		
		return orgJSON;
	}
	
	
}
