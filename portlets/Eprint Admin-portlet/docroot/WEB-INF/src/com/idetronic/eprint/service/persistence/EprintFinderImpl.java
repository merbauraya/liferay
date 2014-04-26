package com.idetronic.eprint.service.persistence;
import java.util.List;

import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.model.impl.EprintImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class EprintFinderImpl extends BasePersistenceImpl<Eprint>
				implements EprintFinder {
	public static final String SQL_FINDBY_SUBJECTID =
		                       EprintFinderImpl.class.getName() + ".findBySubjectId";
	
	
	
	public List<Eprint> findBySubjectId(String subjectId,int begin,int end)
	{
		Session session = null;
		try
		{
			session = openSession();
			String sql = CustomSQLUtil.get(SQL_FINDBY_SUBJECTID);
			SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("Eprint", EprintImpl.class);
	        QueryPos qPos = QueryPos.getInstance(q);
	        qPos.add(subjectId);

	        
	        return (List<Eprint>) QueryUtil.list(q, getDialect(), begin, end); 
		} catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }
		return null;
	}
	
	

}
