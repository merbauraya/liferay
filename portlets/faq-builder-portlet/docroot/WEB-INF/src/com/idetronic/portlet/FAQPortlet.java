package com.idetronic.portlet;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.idetronic.portlet.model.FAQEntry;
import com.idetronic.portlet.service.FAQEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

/**
 * Portlet implementation class FAQPortlet
 */
public class FAQPortlet extends MVCPortlet {
	public void addEntry(ActionRequest actionRequest,
    ActionResponse actionResponse)
            throws IOException, PortletException {
		
		 String category = ParamUtil.getString(actionRequest, "category");
		 String question = ParamUtil.getString(actionRequest, "question");
		 String answer = ParamUtil.getString(actionRequest, "answer");
		 
		 ServiceContext serviceContext = null;
		 try {
		 serviceContext = ServiceContextFactory.getInstance(actionRequest);
		 } catch (PortalException e) {
		 e.printStackTrace();
		 } catch (SystemException e) {
		 e.printStackTrace();
		 }
		 
		 FAQEntryLocalServiceUtil.addEntry(category,question,answer,serviceContext);

		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,
		                        themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", FAQConstant.PAGE_LIST); // set required parameter that you need in doView or render Method
		actionResponse.sendRedirect(redirectURL.toString()); 
			

	}
	public void deleteFaq(ActionRequest actionRequest,
		    ActionResponse actionResponse)
		            throws IOException, PortletException {
				
				 long faqId = ParamUtil.getLong(actionRequest, "faqId");
				 
		try {
			FAQEntryLocalServiceUtil.deleteFAQEntry(faqId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,
		                        themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", FAQConstant.PAGE_LIST); // set required parameter that you need in doView or render Method
		actionResponse.sendRedirect(redirectURL.toString()); 
		
		

	}
	public void searchFaqs(ActionRequest actionRequest,ActionResponse actionResponse)
            throws IOException, PortletException {
		String searchTerm = ParamUtil.getString(actionRequest, "searchTerm");
		if (Validator.isNull(searchTerm)) 
			return;
		 ThemeDisplay themeDisplay = (ThemeDisplay)
                 actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		
		
		try {
			List<FAQEntry> faqs= FAQEntryLocalServiceUtil.searchIndex(searchTerm, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
			actionRequest.setAttribute("SEARCH_RESULT", faqs);
			actionResponse.setRenderParameter("jspPage",FAQConstant.PAGE_LIST);
		
		}catch (SystemException e){
			e.printStackTrace();
		}
	}
	public void editFaq(ActionRequest actionRequest,ActionResponse actionResponse)
		            throws IOException, PortletException {
				
		long faqId = ParamUtil.getLong(actionRequest, "faqid");
		String question = ParamUtil.getString(actionRequest, "question");
		String answer = ParamUtil.getString(actionRequest, "answer");
		String category = ParamUtil.getString(actionRequest, "category");
		FAQEntry faq = null;
		
		Log log = LogFactoryUtil.getLog(FAQPortlet.class);//  (LMSBookLocalServiceImpl.class);
		
		
		try
		{
			faq = FAQEntryLocalServiceUtil.fetchFAQEntry(faqId);
		} catch (SystemException ex)
		{
			ex.printStackTrace();
		}
		if (Validator.isNotNull(faq))
		{
			faq.setCategory(category);
			faq.setAnswer(answer);
			faq.setQuestion(question);
			
			try
			{
				FAQEntryLocalServiceUtil.updateFAQEntry(faq);
			} catch (SystemException ex)
			{
				ex.printStackTrace();
			}
		}
		
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,
		                        themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", FAQConstant.PAGE_LIST); // set required parameter that you need in doView or render Method
		actionResponse.sendRedirect(redirectURL.toString()); 

		

	}
	public void deleteByCategory(ActionRequest actionRequest,
		    ActionResponse actionResponse)
		            throws IOException, PortletException {
				
		String category = ParamUtil.getString(actionRequest, "category");
		Log log = LogFactoryUtil.getLog(FAQPortlet.class);//  (LMSBookLocalServiceImpl.class);
		log.info("FAQ Portlet deleting all under category ="+category);
		//since we cannot perform delete via Custom Query, we do it the hard way
		//retrieve all faq under this category, and delete one by one
		List<FAQEntry> faqs = FAQEntryLocalServiceUtil.getByCategory(category);
		
		for (FAQEntry faq : faqs)
		{
			try
			{
				
				FAQEntryLocalServiceUtil.deleteFAQEntry(faq.getEntryId());//  .deleteFAQEntry(faq);
			} catch (SystemException ex)
			{
				ex.printStackTrace();
			}catch (PortalException pex)
			{
				pex.printStackTrace();
			}
			
		}
			
	}
	public void saveQuestionOrder(ActionRequest actionRequest,
		    ActionResponse actionResponse)
		            throws IOException, PortletException {
		
		Log log = LogFactoryUtil.getLog(FAQPortlet.class);//  (LMSBookLocalServiceImpl.class);
		String questions = ParamUtil.getString(actionRequest, "qorder");
		String x = ParamUtil.getString(actionRequest,"formDate");
		log.info("qorder="+questions+x);
		
		//split by ";" to get to format id=order
		String[] qOrders  = questions.split(";");
		for (String q: qOrders)
		{
			String[] questionAndOrder = q.split("=");
			long qid = Long.parseLong(questionAndOrder[0]);
			int qOrder = Integer.parseInt(questionAndOrder[1]);
			FAQEntryLocalServiceUtil.updateQuestionOrder(qid, qOrder);
			log.info("qid="+qid + ";order="+qOrder);
					
		}
		
	}
	public void orderCategory(ActionRequest actionRequest,
		    ActionResponse actionResponse)
		            throws IOException, PortletException {

		Log log = LogFactoryUtil.getLog(FAQPortlet.class);//  (LMSBookLocalServiceImpl.class);
		//		get category list from our hidden field
		String catList = ParamUtil.getString(actionRequest, "catList");
		String[] categories = catList.split(",");
		int catOrder;
		for (String category: categories)
		{
			//get our order based on category name
			catOrder = ParamUtil.getInteger(actionRequest, category);
			log.info("cat="+category +" order="+ catOrder);
			FAQEntryLocalServiceUtil.updateCategoryOrder(category, catOrder);
			
		}
	
	}
}