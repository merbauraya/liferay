package com.idetronic.subur.service.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.Locale;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.model.ViewSummary;
import com.idetronic.subur.service.impl.ViewSummaryLocalServiceImpl;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewSummaryFinderImpl extends BasePersistenceImpl<ViewSummary> implements ViewSummaryFinder{
	
	private static Log logger = LogFactoryUtil.getLog(ViewSummaryFinderImpl.class);
	
	public JSONArray getMonthlyCategorySummary(int year,long vocabularyId) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
		
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_CATEGORY_SUMMARY);
			
			sql = sql.replace("[$VOCAB_ID$]", String.valueOf(vocabularyId));
			sql = sql.replace("[$YEAR$]", String.valueOf(year));
			
			logger.info(sql);
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			
			
			//String[] columns = new String[]{"permonth,totalview"};
			//return resultSetToJSON(rs,true);
			return monthlyTabular(rs,"categoryname");
			
			
		}catch(Exception e)
		{
			logger.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
	}
	public JSONArray getMothlyItemTypeSummary(int year) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
		
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_ITEMTYPE_SUMMARY);
			
			sql = sql.replace("?", String.valueOf(year));
			logger.info(sql);
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			
			
			//String[] columns = new String[]{"permonth,totalview"};
			//return resultSetToJSON(rs,true);
			return monthlyTabular(rs,"itemtypename");
			
			
		}catch(Exception e)
		{
			logger.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
	}
	private JSONArray monthlyTabular(ResultSet rst,String keyColumn) throws SQLException
	{
		boolean addMonthName = false;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ResultSetMetaData rsMetaData = rst.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		
		String[] columns = new String[colCount];
		
		for (int i=1; i <= colCount; i++)
			columns[i-1] = rsMetaData.getColumnName(i);
		
		Locale locale = LocaleUtil.getDefault();
		DateFormatSymbols  dateFormatSymbols = new DateFormatSymbols(locale);
		String keyColumnValue = StringPool.BLANK;
		JSONObject jsonObj = null;
		String keyValue = null;
		while (rst.next())
		{
				
			keyValue = rst.getString(keyColumn);
			if (!keyValue.equalsIgnoreCase(keyColumnValue))
			{
				if (jsonObj != null)
					jsonArray.put(jsonObj);

				jsonObj = JSONFactoryUtil.createJSONObject();
				jsonObj.put(keyColumn, keyValue);
				keyColumnValue = keyValue;
			}
			
			String mth = "M" +rst.getString("permonth");
			if (addMonthName)
			{
				int month = rst.getInt("permonth")-1;
				mth = dateFormatSymbols.getMonths()[month];
				
			}
			
			String val = rst.getString("totalview");
			jsonObj.put(mth , val);
			
	
		}
		jsonArray.put(jsonObj);
		return jsonArray;
		
	}
	
	
	/**
	 * Get tag visit summary by month
	 */
	public JSONArray getMothlyTagSummary(int year) throws SQLException
	{
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_TAG_SUMMARY);
			
			sql = sql.replace("?", String.valueOf(year));
			
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			
			return monthlyTabular(rs,"tagname");
			//String[] columns = new String[]{"permonth,totalview"};
			//return resultSetToJSON(rs,true);
			
			
		}catch(Exception e)
		{
			logger.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
	}
	
	/**
	 * Get basic monthly view Summary by month
	 */
	public JSONArray getMonthlySummary(int year) throws SQLException
	{
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_SUMMARY);
			
			sql = sql.replace("?", String.valueOf(year));
			
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			
			
			//String[] columns = new String[]{"permonth,totalview"};
			return resultSetToJSON(rs,true);
			
			
		}catch(Exception e)
		{
			logger.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
		
	}
	
	private JSONArray resultSetToJSON(ResultSet rst,boolean addMonthName) throws SQLException
	{
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ResultSetMetaData rsMetaData = rst.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		Locale locale = LocaleUtil.getDefault();
		while (rst.next())
			{
				
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
				
				for (int i = 1; i <= colCount; i++)
				{
					
					String colName = rsMetaData.getColumnName(i);
					
					jsonObj.put(colName , rst.getString(i));
					if (addMonthName && colName.equalsIgnoreCase("permonth"))
					{
						DateFormatSymbols  xx = new DateFormatSymbols(locale);
						int month = rst.getInt(i)-1;
						String monthString = xx.getMonths()[month];
						jsonObj.put("monthName",monthString );
					}
				}
				
				
				
				jsonArray.put(jsonObj);
				
				
		}
		return jsonArray;
	
		
	}
	
	private static final String SQL_MONTHLY_SUMMARY = ViewSummaryFinder.class.getName()+ ".monthlySummary";
	private static final String SQL_MONTHLY_TAG_SUMMARY = ViewSummaryFinder.class.getName() + ".monthlyTagSummary";
	private static final String SQL_MONTHLY_ITEMTYPE_SUMMARY = ViewSummaryFinder.class.getName() +".monthlyItemTypeSummary";
	private static final String SQL_MONTHLY_CATEGORY_SUMMARY = ViewSummaryFinder.class.getName() +".monthlyCategorySummary";
}
