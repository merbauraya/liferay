package com.idetronic.eprint.admin.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;


public class EprintDataAccess {
	public static String getByTypeXML()
	{
		// This will load the MySQL driver, each DB has its own driver
				String ret = null;
				Statement statement = null;
				ResultSet resultSet = null;
				Connection conn = null;
			    try {
			    	 conn = DataAccess.getConnection("jdbc/eprints");
					// Statements allow to issue SQL queries to the database
					statement = conn.createStatement();
					      // Result set get the result of the SQL query
					      
					String query = SqlUtil.getSQL("/com/idetronic/eprint/admin/data/gettype.sql");
					      
				      resultSet = statement.executeQuery(query);
				      ret =  EprintXmlBuilder.buildXMLBySubject(resultSet);  
				      
				      
					      
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally
				{
					DataAccess.cleanUp(conn);
					DataAccess.cleanUp(resultSet);
					DataAccess.cleanUp(statement);
				}
			    return ret;
		
	}
	public static String getBySubjectXML()
	{
		// This will load the MySQL driver, each DB has its own driver
		String ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Connection conn = null;
	    try {
	    	 conn = DataAccess.getConnection("jdbc/eprints");
			// Statements allow to issue SQL queries to the database
			statement = conn.createStatement();
			      // Result set get the result of the SQL query
			      
			String query = SqlUtil.getSQL("/com/idetronic/eprint/admin/data/bysubject.sql");
			      
		      resultSet = statement.executeQuery(query);
		      ret =  EprintXmlBuilder.buildXMLBySubject(resultSet);  
		      
		      
			      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DataAccess.cleanUp(conn);
			DataAccess.cleanUp(resultSet);
			DataAccess.cleanUp(statement);
		}
	    return ret;
	      
	}

}
