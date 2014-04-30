package com.idetronic.eprint.admin.search;


import javax.portlet.PortletURL;

import com.idetronic.eprint.model.Eprint;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class EprintOpenSearchImpl extends HitsOpenSearchImpl {
	private static final Log log = LogFactoryUtil.getLog(EprintOpenSearchImpl.class);
	protected String getURL(ThemeDisplay themeDisplay, long groupId,
			Document result, PortletURL portletURL) throws Exception {
		
		portletURL.setParameter("jspPage","/html/eprintview/detail.jsp");
		long eprintId = GetterUtil.getLong(	result.get(Field.ENTRY_CLASS_PK));
		portletURL.setParameter("eprintId", String.valueOf(eprintId));
		return super.getURL(themeDisplay, groupId, result, portletURL);
	}
	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(Eprint.class);
	}
	@Override
	public String getPortletId() {
		
		return "EprintAdmin_WAR_EprintAdmin";
	}

	@Override
	public String getSearchPath() {
		return "/c/eprint/open_search";
	}

	@Override
	public String getTitle(String keywords) {
		return "Open Search for " + keywords;
	}

}
