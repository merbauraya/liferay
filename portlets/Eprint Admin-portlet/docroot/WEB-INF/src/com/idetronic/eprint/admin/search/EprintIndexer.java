package com.idetronic.eprint.admin.search;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.idetronic.eprint.model.Eprint;
import com.idetronic.eprint.service.EprintLocalServiceUtil;
import com.idetronic.eprint.service.impl.EprintLocalServiceImpl;


public class EprintIndexer extends BaseIndexer{
	public static String[] CLASS_NAMES = new String[] {Eprint.class.getName()};
	private static final Log log = LogFactoryUtil.getLog(EprintIndexer.class);
    public String[] getClassNames() {
            return CLASS_NAMES;
    }

    public String getPortletId() {
            return "EprintAdmin_WAR_EprintAdmin";
    }

    protected void doDelete(Object arg0) throws Exception {
           
    }
   
    protected Document doGetDocument(Object obj) throws Exception {
   
            Eprint eprint = (Eprint) obj;
            Document document =
                    getBaseModelDocument(getPortletId(), eprint);
           
            //document.addKeyword(Field.TITLE, eprint.getTitle());
            document.addText(Field.TITLE, eprint.getTitle());
            document.addText(Field.DESCRIPTION, eprint.getEprintAbstract());
            document.addText("Resource Type", eprint.getEprintType());
            Date modifiedDate = eprint.getModifiedDate();
            if (modifiedDate == null)
            	modifiedDate = new Date();
            document.addDate(Field.MODIFIED_DATE, modifiedDate);
            document.addText(Field.COMPANY_ID , String.valueOf(eprint.getCompanyId()));
            
            
            return document;
    }
   
    protected Summary doGetSummary(
            Document document, Locale local, String snippet,
            PortletURL portletURL) throws Exception {
           
            return new Summary(
                    document.get(Field.TITLE), snippet, portletURL);
    }
   
    protected void doReindex(Object obj) throws Exception {
            Eprint eprint = (Eprint) obj;
           
            Document document = doGetDocument(eprint);
   
            SearchEngineUtil.updateDocument(getSearchEngineId(),
                    eprint.getCompanyId(), document);
    }

    protected void doReindex(String[] args) throws Exception {
            long companyId = Long.valueOf(args[0]);
           
            DynamicQuery dynamicQuery =
                    DynamicQueryFactoryUtil.forClass(Eprint.class);
            dynamicQuery.add(
                    RestrictionsFactoryUtil.eq("companyId", companyId));
           
            List<Eprint> eprints =
                    EprintLocalServiceUtil.dynamicQuery(dynamicQuery);
           
            for (Eprint eprint: eprints) {
            	
            	doReindex(eprint);
            }
            
    }

    protected void doReindex(String className, long classPK) throws Exception {
           
    }

    protected String getPortletId(SearchContext searchContext) {
       
    	return AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(Eprint.class.getName()).getPortletId();    
    	 //   return null;
    }

}
