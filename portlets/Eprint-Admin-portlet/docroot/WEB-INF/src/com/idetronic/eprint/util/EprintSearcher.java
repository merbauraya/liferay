package com.idetronic.eprint.util;

import java.util.Locale;

import javax.portlet.PortletURL;

import com.idetronic.eprint.model.Eprint;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerPostProcessor;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;

public class EprintSearcher extends BaseSearcher {
	public static final String[] CLASS_NAMES = {
		Eprint.class.getName()
	};
	public EprintSearcher() {
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public static Indexer getInstance() {
		return new EprintSearcher();
	}
	
	@Override
	public IndexerPostProcessor[] getIndexerPostProcessors() {
		throw new UnsupportedOperationException();
	}
	@Override
	public String getPortletId() {
		return null;
	}
	@Override
	public void registerIndexerPostProcessor(
		IndexerPostProcessor indexerPostProcessor) {

		throw new UnsupportedOperationException();
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Document doGetDocument(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Summary doGetSummary(Document arg0, Locale arg1, String arg2,
			PortletURL arg3) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doReindex(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doReindex(String[] arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
