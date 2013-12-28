package com.idetronic.portlet;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.idetronic.portlet.model.FAQEntry;
import com.idetronic.portlet.service.FAQEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;



public class FAQIndexer extends BaseIndexer {

	@Override
	public String[] getClassNames() {
		String[] CLASS_NAME = {FAQEntry.class.getName()};
		return CLASS_NAME;
	}

	@Override
	public String getPortletId() {
		
		return "faq_WAR_faqbuilderportlet";
	}

	@Override
	protected void doDelete(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Document doGetDocument(Object arg0) throws Exception {
		FAQEntry faq = (FAQEntry) arg0;
		Document document = getBaseModelDocument(getPortletId(),faq);
		document.addText(Field.TITLE, faq.getQuestion());
		document.addText("answer", faq.getAnswer());
		return document;
		
	}

	@Override
	protected Summary doGetSummary(Document arg0, Locale arg1, String arg2,
			PortletURL arg3) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doReindex(Object arg0) throws Exception {
		
		FAQEntry faq = (FAQEntry) arg0;
		Document document = getDocument(faq);
		SearchEngineUtil.updateDocument(getSearchEngineId(),
				faq.getCompanyId(), document);
	
		
	}

	@Override
	protected void doReindex(String[] arg0) throws Exception {
		long companyId = Long.valueOf(arg0[0]);
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(FAQEntry.class);
		dynamicQuery.add(
		RestrictionsFactoryUtil.eq("companyId", companyId));
		List<FAQEntry> faqs = 	FAQEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
		for (FAQEntry faq : faqs)
		{
			if (faq.getGroupId()>01)
				reindex(faq);
		}
		
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		
		return "faq_WAR_faqbuilderportlet";
	}

}
