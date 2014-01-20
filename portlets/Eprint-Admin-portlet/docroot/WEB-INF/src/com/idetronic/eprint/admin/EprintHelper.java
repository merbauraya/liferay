package com.idetronic.eprint.admin;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.idetronic.eprint.admin.data.EprintDataAccess;
import com.idetronic.eprint.admin.data.SqlUtil;
import com.idetronic.eprint.model.*;
import com.idetronic.eprint.model.impl.EprintImpl;
import com.idetronic.eprint.model.impl.EprintStaticContentImpl;
import com.idetronic.eprint.service.*;
import com.idetronic.eprint.transform.*;
import com.idetronic.eprint.EprintConstant;
import com.idetronic.eprint.service.EprintSubjectLocalServiceUtil;
import com.idetronic.eprint.service.EprintStaticContentLocalServiceUtil;
import com.idetronic.eprint.model.EprintStaticContent;

public class EprintHelper {
	static Log log = LogFactoryUtil.getLog(EprintHelper.class);
	static Connection conn=null;
	static String _porletPath;
	public static void importRepository(ServiceContext serviceContext)
	{
		
		Statement stmt=null;
		ResultSet rs=null;
		Eprint eprint=null;
		
		try {
			conn = DataAccess.getConnection("jdbc/eprints");
			String sql = "select * from eprint where eprint_status = 'archive' "+
						 "and eprint.metadata_visibility = 'show'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				eprint = EprintLocalServiceUtil.fetchEprint(rs.getLong("eprintid"));
				Date createdDate = dateFromEprintDate(rs.getInt("datestamp_year"),rs.getInt("datestamp_month"),rs.getInt("datestamp_day"));
				Date modifiedDate = dateFromEprintDate(rs.getInt("lastmod_year"),rs.getInt("lastmod_month"),rs.getInt("lastmod_day"));
				
				if (Validator.isNull(eprint))
				{
					
					eprint = EprintLocalServiceUtil.insertEprint(rs.getLong("eprintid"), 
							rs.getString("title"),rs.getString("abstract"), 
							rs.getString("eprint_status"),rs.getString("type"),
							rs.getString("metadata_visibility"),rs.getString("keywords"), 
							rs.getString("ispublished"),rs.getString("date_year"),
							rs.getString("full_text_status"),
							createdDate,modifiedDate,serviceContext);
					
					//updateAssetEntry(eprint);
					
				}else
				{
					eprint = EprintLocalServiceUtil.modifyEprint(eprint.getEprintId(), rs.getString("title"),rs.getString("abstract"), 
							rs.getString("eprint_status"),rs.getString("type"),
							rs.getString("metadata_visibility"),rs.getString("keywords"), 
							rs.getString("ispublished"),rs.getString("date_year"),
							rs.getString("full_text_status"),
							createdDate,modifiedDate,serviceContext);
				}
				
			}
			importEprintSubject();
			generateEprintPage();
			
		} catch (Exception e) {
			log.error("Error importing eprint repository");
			log.error(e);
		} finally {
			// TODO Auto-generated catch block
			DataAccess.cleanUp(conn);
			DataAccess.cleanUp(stmt);
			DataAccess.cleanUp(rs);
		}
		
	}
	public static void importEprintSubject() throws Exception
	{
		String query = SqlUtil.getSQL("/com/idetronic/eprint/admin/data/eprintsubject.sql");
		Statement statement = conn.createStatement();
		ResultSet rst = statement.executeQuery(query);
		while (rst.next())
		{
			EprintSubjectLocalServiceUtil.validateEprintSubject(rst.getLong("eprintid"), rst.getString("subjectid"), rst.getString("name_name"));
		}
		rst.close();
		statement.close();
	}
	public static void generateEprintPage()
	{
		String bySubjectXML = EprintDataAccess.getBySubjectXML();
		if (Validator.isNull(bySubjectXML))
		{
			log.error("Error generating eprint pages");
			return;
		}
		
		XslContentTransformer transform = new XslContentTransformer(
				EprintConstant.XSL_BY_SUBJECT);
		Map<String,String> props = new HashMap<String,String>();
		String response = transform.transform(bySubjectXML, props);
		EprintStaticContentLocalServiceUtil.addContent(EprintConstant.KEY_BY_SUBJECT_TREE, response);
		
		/*
	
		
		Writer writer = null;

		try {
			
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(_porletPath +EprintConstant.FILE_BY_SUBJECT_TREE), "utf-8"));
		    writer.write(response);
		} catch (Exception ex) {
			log.error(ex);
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}*/
	}
	public static Date dateFromEprintDate(int year,int month,int day)
	{
		SimpleDateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(year +"-"+month+"-"+day);
		} catch (ParseException e) {
			
			return null;
		}
		
	}
	public static List<Eprint> browseBySubjectId(String subjectId,int begin,int end)
	{
		return EprintLocalServiceUtil.findBySubjectId(subjectId, begin, end);
		
		
	}
	public static JSONArray browseBySubjectIdJSON(String subjectId,int begin,int end)
	{
		List<Eprint> eprints = EprintLocalServiceUtil.findBySubjectId(subjectId, begin, end);
		JSONArray eprintJSON = JSONFactoryUtil.createJSONArray();
		String dateFormat = "dd-MMM-yyyy";
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		for (Eprint eprint :eprints)
		{
			
			JSONObject curEprintJSON = JSONFactoryUtil.createJSONObject();
			curEprintJSON.put("title", eprint.getTitle());
			curEprintJSON.put("type", eprint.getEprintType());
			
			String strDate = df.format(eprint.getCreatedDate());
			
			curEprintJSON.put("createdDate", strDate);
			curEprintJSON.put("id", eprint.getEprintId());
			eprintJSON.put(curEprintJSON);
			
		}
	
		return eprintJSON;
	}

public static PortletURL getViewDetailUrl(ThemeDisplay themeDisplay,HttpServletRequest request,long eprintId)
	throws Exception
	{
		String portletName = "eprintview_WAR_EprintAdminportlet";
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName);
		PortletURL portletURL = PortletURLFactoryUtil.create(request, portletName, plid,PortletRequest.RENDER_PHASE);
		portletURL.setParameter("jspPage", EprintConstant.VIEW_EPRINT_DETAIL);
		portletURL.setParameter("eprintId", String.valueOf(eprintId));
		return portletURL;
	
	}

}
