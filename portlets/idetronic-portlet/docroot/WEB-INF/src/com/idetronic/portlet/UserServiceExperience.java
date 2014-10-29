package com.idetronic.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idetronic.portlet.model.ServiceExperience;
import com.idetronic.portlet.service.ServiceExperienceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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

public class UserServiceExperience extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(UserServiceExperience.class);
	public void render(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
   
				

	super.render(request, response);
}
	public void deleteServiceExperience(ActionRequest request,ActionResponse actionResponse) throws Exception
	{
		
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
		String serviceExperienceId = PortalUtil.getOriginalServletRequest(httpReq).getParameter("serviceExperienceId");
		if (Validator.isNull(serviceExperienceId))
			serviceExperienceId = ParamUtil.getString(request, "serviceExperienceId");
		
		ServiceExperienceLocalServiceUtil.deleteServiceExperience(Long.valueOf(serviceExperienceId));
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("success", Boolean.TRUE);

		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			actionResponse);

		ServletResponseUtil.write(response, jsonObject.toString());
		
		
	}
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException 
    {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
		String serviceExperienceId = PortalUtil.getOriginalServletRequest(httpReq).getParameter("serviceExperienceId");
		if (Validator.isNull(serviceExperienceId))
			serviceExperienceId = ParamUtil.getString(request, "serviceExperienceId");
		_log.info("serveresource");
		ParamUtil.print(request);
    
    }
	public void addServiceExperience(ActionRequest request,ActionResponse actionResponse) throws IOException,PortletException, SystemException, PortalException
	{
		
		long userId = ParamUtil.getLong(request, "userId");
		User user = UserLocalServiceUtil.getUser(userId);
		
		long serviceExperienceId = ParamUtil.getLong(request, "serviceExperienceId");
		String title =  ParamUtil.getString(request, "serviceTitle");
		String data = ParamUtil.getString(request, "data");
		boolean current = ParamUtil.getBoolean(request, "current");
		int startDateMonth = ParamUtil.getInteger(request, "startMonth");
		int startDateYear = ParamUtil.getInteger(request, "startYear");
		
		int endDateMonth = ParamUtil.getInteger(request, "endMonth");
		int endDateYear = ParamUtil.getInteger(request, "endYear");
		
		if (serviceExperienceId >0)
		{
			
			ServiceExperienceLocalServiceUtil.updateServiceExperience(serviceExperienceId, title, 
					startDateMonth, 1, startDateYear, endDateMonth, 1, endDateYear, current, data); 
		}else
		{
			
			ServiceExperience serviceExperience = ServiceExperienceLocalServiceUtil.addServiceExperience(
					user.getUserId(), title, startDateMonth, 
					1, startDateYear, endDateMonth, 1, endDateYear, current, data);
			serviceExperienceId = serviceExperience.getServiceExperienceId();
		}
		
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		
		jsonObject.put("id", serviceExperienceId);

		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			actionResponse);

		ServletResponseUtil.write(response, jsonObject.toString());
	}
	
}
