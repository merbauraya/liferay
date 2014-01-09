package com.idetronic.eprint.admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import com.idetronic.eprint.model.*;
import com.idetronic.eprint.model.impl.EprintImpl;
import com.idetronic.eprint.service.*;
public class EprintHelper {
	static Log log = LogFactoryUtil.getLog(EprintHelper.class);
	public static void importRepository()
	{
		Connection conn=null;
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
				if (Validator.isNull(eprint))
				{
					eprint = EprintLocalServiceUtil.insertEprint(rs.getLong("eprintid"), 
							rs.getString("title"),rs.getString("abstract"), 
							rs.getString("eprint_status"),rs.getString("type"),
							rs.getString("metadata_visibility"),rs.getString("keywords"), 
							rs.getString("ispublished"),rs.getString("date_year"),
							rs.getString("full_text_status"));
					
					
				}
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
		} finally {
			// TODO Auto-generated catch block
			DataAccess.cleanUp(conn);
			DataAccess.cleanUp(stmt);
			DataAccess.cleanUp(rs);
		}
		
	}

}
