package com.idetronic.portlet.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

public class UserServiceUtil {
	static String usxPortletId ="usx_WAR_idetronicportlet";
	static String expPortletId ="exp_WAR_idetronicportlet";
	static String orgPortletId ="org_WAR_idetronicportlet";
	
	public static String getAddServiceExperienceURL(HttpServletRequest request,String nameSpace,long userId) throws PortalException, SystemException
	{
		String url = getEditServiceExperienceURL(request,nameSpace,userId);
		url = urlAddParam(url,usxPortletId,"eventName",nameSpace+"addExperience");
		return url;
		
	}
	
	public static String getEditExpertiseURL(HttpServletRequest request,String nameSpace,long userId) 
		throws PortalException, SystemException
		{
			String url = getPortletURL(request,userId,nameSpace,expPortletId);
			url = HttpUtil.addParameter(url, "p_p_state", "pop_up");
			url = HttpUtil.addParameter(url, "_"+ expPortletId +"_"+ "jspPage","/html/expertise/edit_exp.jsp");
			url = HttpUtil.addParameter(url, "_"+ expPortletId +"_"+ "p_u_i_d",String.valueOf(userId));

			return url;
		}
	public static String getEditOrgChartURL(HttpServletRequest request,String nameSpace,long userId) 
			throws PortalException, SystemException
	{
		String url = getPortletURL(request,userId,nameSpace,orgPortletId);
		url = HttpUtil.addParameter(url, "p_p_state", "pop_up");
		url = HttpUtil.addParameter(url, "_"+ orgPortletId +"_"+ "jspPage","/html/orgchart/edit_orgchart.jsp");
		url = HttpUtil.addParameter(url, "_"+ orgPortletId +"_"+ "p_u_i_d",String.valueOf(userId));

		return url;
		
		
	}
	public static String getEditServiceExperienceURL(javax.servlet.http.HttpServletRequest request,String nameSpace,long userId) throws PortalException, SystemException
	{
		boolean secure = request.isSecure();
		Company  company = PortalUtil.getCompany(request) ; 
		String url = PortalUtil.getPortalURL(company.getVirtualHostname(), PortalUtil.getPortalPort(secure),secure);
		url += "/group/control_panel/manage?";//p_p_id="+portletId +"&";
		
		url = HttpUtil.addParameter(url, "p_p_id", usxPortletId);
		url = HttpUtil.addParameter(url, "_"+ usxPortletId +"_"+ "jspPage","/html/service_experience/edit_exp.jsp");
		url = HttpUtil.addParameter(url, "p_p_state", "pop_up");
		url = HttpUtil.addParameter(url, "_"+ usxPortletId +"_"+ "p_u_i_d",String.valueOf(userId));
		
		url = HttpUtil.addParameter(url, "_"+usxPortletId+"_nameSpace", nameSpace);
		

		
		return url;
	}
	public static String getDeleteServiceExperienceURL(HttpServletRequest request,String nameSpace,
				long userId) throws PortalException, SystemException
	{
		String url = getPortletURL(request,userId,nameSpace,usxPortletId);
		url = HttpUtil.addParameter(url, "_"+usxPortletId + "_" +ActionRequest.ACTION_NAME, "deleteServiceExperience");
		url = HttpUtil.addParameter(url,"p_p_mode","view");
		url = HttpUtil.addParameter(url,"p_p_state","pop_up");
		url = HttpUtil.addParameter(url,"p_p_lifecycle","1");
		url = HttpUtil.addParameter(url, "p_p_cacheability", "cacheLevelPage");
		
		return url;
	}
	private static String getPortletURL(HttpServletRequest request,long userId,String nameSpace,String portletId) 
			throws PortalException, SystemException
	{
		boolean secure = request.isSecure();
		Company  company = PortalUtil.getCompany(request) ; 
		String url = PortalUtil.getPortalURL(company.getVirtualHostname(), PortalUtil.getPortalPort(secure),secure);
		url += "/group/control_panel/manage?";//p_p_id="+portletId +"&";
		url = HttpUtil.addParameter(url, "p_p_id", portletId);
		
		url = HttpUtil.addParameter(url, "_"+portletId+"_nameSpace", nameSpace);
		return url;
	}
	public static String getOrgChartPortletId()
	{
		return orgPortletId;
	}
	public static String getServiceExperiencePortletId()
	{
		return usxPortletId;
	}
	public static String getExpertisePortletId()
	{
		return expPortletId;
	}
	private static String urlAddParam(String url,String portletId,String param,String value)
	{
		String paramName = "_"+portletId+"_"+param;
		return HttpUtil.addParameter(url, paramName, value);
	}
	public static List<User> getUsers(Hits hits) throws PortalException, SystemException {
		List<Document> documents = hits.toList();
		List<User> users = new ArrayList<User>(documents.size());
		for (Document document : documents) {
			long userId = GetterUtil.getLong(document.get(Field.USER_ID));
			User user = UserLocalServiceUtil.fetchUser(userId);
			if (user == null) {
				users = null;
				Indexer indexer = IndexerRegistryUtil.getIndexer(User.class);
				long companyId = GetterUtil.getLong(
						document.get(Field.COMPANY_ID));
				indexer.delete(companyId, document.getUID());
			}
			else if (users != null) {
				users.add(user);
			}
		}
		return users;
	}
}
