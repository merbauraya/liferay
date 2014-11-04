package com.idetronic.portlet;

import java.io.IOException;
import java.util.ArrayList;
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
import com.idetronic.portlet.model.OrgChart;
import com.idetronic.portlet.service.OrgChartLocalServiceUtil;
import com.idetronic.portlet.service.impl.OrgChartLocalServiceImpl;
import com.idetronic.portlet.util.Constant;
import com.idetronic.portlet.util.UserServiceUtil;
public class UserOrgChart extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(UserOrgChart.class);
	
	public void saveOrgTree(ActionRequest request,ActionResponse response) throws JSONException, SystemException
	{
		 
		 HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
		 String jsonTree = PortalUtil.getOriginalServletRequest(httpReq).getParameter("orgTree");
		 //_log.info(param);

		JSONArray orgJSON = JSONFactoryUtil.createJSONArray(jsonTree);
		
		//delete by parent loop
		for (int i=0; i < orgJSON.length();i++)
		{
			JSONObject userJSON = orgJSON.getJSONObject(i);
			OrgChartLocalServiceUtil.deleteByParentId(userJSON.getLong("parentId"));
		}
		
		for (int i=0; i < orgJSON.length();i++)
		{
			JSONObject userJSON = orgJSON.getJSONObject(i);
			long userId = userJSON.getLong("userId");
			long parentId = userJSON.getLong("parentId");
			if (parentId != 0)
			{
				OrgChartLocalServiceUtil.addEntry(userId, parentId);
			}
			
		}
		
		
	}
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException 
	{
		String resource = ParamUtil.getString(request, "resource");
		String keyword;
		long companyId = PortalUtil.getCompanyId(request);
		long userId = ParamUtil.getLong(request, "userId");
		if (Validator.equals(resource, Constant.RESOURCE_USER_TREE))
		{
			JSONArray tree;
			HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
			try {
				tree = buildOrgTree(userId);
				ServletResponseUtil.write(res, tree.toString());
				
			} catch (SystemException e) {
		
				_log.error(e);
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("success", Boolean.FALSE);
				ServletResponseUtil.write(res, jsonObject.toString());
				
			}
			
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
	private JSONArray buildOrgTree(long userId) throws SystemException
	{
		List userTrees = OrgChartLocalServiceUtil.getUserTree(userId);
		
		OrgChart orgChart = null;
		User user = null;
		
		JSONArray orgJSON = JSONFactoryUtil.createJSONArray();
		
		if (userTrees.size()== 0)
		{
			user = UserLocalServiceUtil.fetchUser(userId);
			JSONObject usrJSON = JSONFactoryUtil.createJSONObject();
			usrJSON.put("id",user.getUserId());
			usrJSON.put("name", user.getFullName() );
			usrJSON.put("jobTitle", user.getJobTitle() );
			usrJSON.put("parent", 0);
			orgJSON.put(usrJSON);
			return orgJSON;
		}
		List userObjectList=(List)userTrees.get(0);
		List userOrgTree = (List)userTrees.get(1);
		for (int i=0;i<userObjectList.size();i++)
		{
			user = (User)userObjectList.get(i);
			orgChart = (OrgChart)userOrgTree.get(i);
			JSONObject usrJSON = JSONFactoryUtil.createJSONObject();
			usrJSON.put("id", user.getUserId());
			usrJSON.put("name", user.getFullName());
			usrJSON.put("jobTitle", user.getJobTitle());
			usrJSON.put("parent", orgChart.getParentId());
			orgJSON.put(usrJSON);
			//_log.info(orgChart.getUserId() +","+orgChart.getParentId());
			//_log.info(user.getFullName());
			
		}
		
		return orgJSON;
	}
	
	
}
