package com.idetronic.service.persistence;


import java.util.List;

import com.idetronic.model.Foo;
import com.idetronic.portlet.ImportCalResource;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FooFinderImpl extends BasePersistenceImpl<Foo> implements FooFinder
{
	
	private static Log logger = LogFactoryUtil.getLog(FooFinderImpl.class);

	public List<CalendarResource> doFindByC_G_C_C_N_D_A(
			long companyId, long[] groupIds, long[] classNameIds,
			String[] codes, String[] names, String[] descriptions,
			boolean active, boolean andOperator, int start, int end,
			OrderByComparator orderByComparator, boolean inlineSQLHelper)
		throws SystemException {
		
		//SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");

		
		codes = CustomSQLUtil.keywords(codes);
		names = CustomSQLUtil.keywords(names);
		descriptions = CustomSQLUtil.keywords(descriptions, false);

		Session session = null;

		try {
			session = sessionFactory.openSession();

			String sql = CustomSQLUtil.get("xxx");

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, CalendarResource.class.getName(),
					"CalendarResource.calendarResourceId", groupIds);
			}

			sql = StringUtil.replace(
				sql, "[$GROUP_ID$]", getGroupIds(groupIds));
			sql = StringUtil.replace(
				sql, "[$CLASS_NAME_ID$]", getClassNameIds(classNameIds));
			sql = CustomSQLUtil.replaceKeywords(
				sql, "lower(code_)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(
				sql, "lower(name)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(
				sql, "description", StringPool.LIKE, true, descriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			StringBundler sb = new StringBundler();

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, "CalendarResource.", orderByComparator);
			}

			sql = StringUtil.replace(sql, "[$ORDER_BY$]", sb.toString());
			
			logger.info(sql);
			logger.info(companyId);
			logger.info("code="+codes);
			logger.info("desc="+descriptions);
			SQLQuery q = session.createSQLQuery(sql);

			q.setCacheable(false);
			//q.addEntity("CalendarResource",  CalendarResource.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);
			qPos.add(groupIds);

			if (ArrayUtil.isNotEmpty(classNameIds)) {
				qPos.add(classNameIds);
			}

			qPos.add(codes, 2);
			qPos.add(names, 2);
			qPos.add(descriptions, 2);
			qPos.add(active);
			
			
			return (List<CalendarResource>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	protected String getClassNameIds(long[] classNameIds) {
		if (ArrayUtil.isEmpty(classNameIds)) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(classNameIds.length * 2);

		sb.append("(");

		for (int i = 0; i < classNameIds.length; i++) {
			sb.append("classNameId = ?");

			if ((i + 1) < classNameIds.length) {
				sb.append(" OR ");
			}
		}

		sb.append(") AND");

		return sb.toString();
	}
	protected String getGroupIds(long[] groupIds) {
		if (groupIds.length == 0) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(groupIds.length * 2);

		sb.append("(");

		for (int i = 0; i < groupIds.length; i++) {
			sb.append("groupId = ?");

			if ((i + 1) < groupIds.length) {
				sb.append(" OR ");
			}
		}

		sb.append(") AND");

		return sb.toString();
	}
}
