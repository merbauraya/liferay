package com.idetronic.portlet;

/**
 * 
 * author : Samir Gami
 * Email : gami_samir@yahoo.com 
 * 
 */

import java.io.IOException;
import java.util.Locale;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.kernel.exception.*;

import java.sql.*;

import javax.sql.*;
public class ImportUser extends MVCPortlet {

	private static final Log logger = LogFactoryUtil.getLog(ImportUser.class);
	
	
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(final RenderRequest renderRequest,
			final RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		final ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		final String userCount = actionRequest.getParameter("userCount");
		final String userName = actionRequest.getParameter("userName");
		if(userCount != null && !"".equals(userCount) && userName != null && !"".equals(userName)) {
			try {
				logger.info("<<<==========Creating number of users, with below informations==========>>>");
				final int userCreationCount = Integer.valueOf(userCount);
				createPortalUser(userCreationCount, userName, themeDisplay.getCompanyId(), themeDisplay.getUserId(), themeDisplay.getLocale());
				addSuccessMessage(actionRequest,actionResponse);
			} catch(Exception e) {
				logger.error("error occured while creating  "+e);
			}
		}
	}
	public void createPortalUser(final int userCreationCount, final String userName,final long companyId, final long userId,final Locale locale) {
		
		if(userCreationCount > 0) {
			/**
			 * UserLocalServiceUtil.addUser(creatorUserId, companyId,
			 * autoPassword, password1, password2, autoScreenName, screenName,
			 * emailAddress, facebookId, openId, locale, firstName, middleName,
			 * lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
			 * birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
			 * userGroupIds, sendEmail, serviceContext)
			 **/
	
			String newUserName = "";
			for(int i=0;i<userCreationCount;i++) {
				newUserName = userName+i;
				try {
					UserLocalServiceUtil.addUser(userId, companyId, false, "test", "test", false, newUserName, newUserName+"@liferay.com", 0L, "", locale,
					newUserName, "", newUserName, 0, 0, false, 0, 1,1970, "Demo User", null, null, null,
					null, false, new ServiceContext());
					logger.info("User "+(i+1)+ " :: [Email="+newUserName+"@liferay.com,  password=test ]");
				} catch (Exception e) {
					logger.info("Portal user creation failed "+e.getMessage());					
				}
			}
			
		}
	}
	public static void importUser(Connection conn,ThemeDisplay themeDisplay)
	{
		String password="";
		String screenName="";
		String email="";
		String openId="";
		String firstName="";
		String lastName="";
		String middleName="";
		int prefixId=0;
		int suffixId=0;
		int birthDayMonth=0;
		int birthDayDay=0;
		int birthDayYear=0;
		String jobTitle="";
		long[] groupId = null,roleId=null,userGroup=null;
		
		long creatorId = themeDisplay.getUserId();
		try
		{
			logger.info("companyid="+ themeDisplay.getCompanyId());
			//orgId[0] = OrganizationLocalServiceUtil.getOrganizationId(themeDisplay.getCompanyId(), "");
			User currentUser = themeDisplay.getUser();
			long[] orgId = currentUser.getOrganizationIds();
			
			logger.info("org id="+orgId[0]);
		
		
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from z_tmp_user");
			while (rs.next())
			{
				email = rs.getString("email");
				password="test";
				screenName = rs.getString("ic");
				firstName = rs.getString("name1");
				lastName = rs.getString("name2");
				birthDayMonth = 1;
				birthDayDay = 1;
				birthDayYear = 1970;
				UserLocalServiceUtil.addUser(creatorId,themeDisplay.getCompanyId(),false,
						password,password,false,screenName,
						email,0L,openId,themeDisplay.getLocale(),
						firstName,middleName,lastName,
						prefixId,suffixId,false,
						birthDayMonth,birthDayDay,birthDayYear,
						jobTitle,groupId,orgId,roleId,userGroup,
						false, new ServiceContext());
				
			}
		}
		catch (SystemException sex)
		{
			logger.error("User Import-System Exception " + sex);
		}
		catch(SQLException ex)
		{
				logger.error("Cannot get connection: " + ex);
		}
		catch (Exception ex)
		{
			logger.error("Portal user creation failed "+ex.getMessage());		
		}
		
	}
}
