package com.idetronic.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.idetronic.portlet.model.ExpertiseTag;
import com.idetronic.portlet.service.ExpertiseTagLocalServiceUtil;
import com.idetronic.portlet.service.UserEntries_ExpertiseTagsLocalServiceUtil;
import com.liferay.compat.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.dao.orm.QueryUtil;


public class UserExpertise extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(UserExpertise.class);
	
	public void saveUserExpertise(ActionRequest request,ActionResponse response)
			throws PortalException, SystemException
	{
		long userId = ParamUtil.getLong(request, "userId");
		String expertises = ParamUtil.getString(request, "exp_Expertise");
		
		UserEntries_ExpertiseTagsLocalServiceUtil.addEntry(userId, expertises, ",");
		
		
	}
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
	{
		String resource = ParamUtil.getString(request, "resource");
		JSONArray result;
		
		
		if (Validator.equals(resource,"tagList"))
		{
			
			result = getTagList();
			
			if (Validator.isNotNull(result))
			{
				HttpServletResponse res = PortalUtil.getHttpServletResponse(
					response);
				
				ServletResponseUtil.write(res, result.toString());
			}
			
	
		}
	}
	private JSONArray getTagList()  
	{
		JSONArray tagListJson = JSONFactoryUtil.createJSONArray();
		List<ExpertiseTag> tagLists;
		try {
			tagLists = ExpertiseTagLocalServiceUtil.getExpertiseTags(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			
			
			for (ExpertiseTag tag : tagLists)
			{
				jsonObject.put("name",tag.getTagName());
				tagListJson.put(tag.getTagName());// (jsonObject);
				
				
			}
			return tagListJson;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		
	}
}
