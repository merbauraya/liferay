package com.idetronic.portlet;
import java.io.IOException;

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
		 
		 FAQEntryLocalServiceUtil.addEntry(category,question,answer);

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
	public void editFaq(ActionRequest actionRequest,ActionResponse actionResponse)
		            throws IOException, PortletException {
				
		long faqId = ParamUtil.getLong(actionRequest, "faqid");
		String question = ParamUtil.getString(actionRequest, "question");
		String answer = ParamUtil.getString(actionRequest, "answer");
		String category = ParamUtil.getString(actionRequest, "category");
		FAQEntry faq = null;
		
		Log log = LogFactoryUtil.getLog(FAQPortlet.class);//  (LMSBookLocalServiceImpl.class);
		log.info("faqId="+faqId);
		
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
		/*
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute("javax.portlet.config");
		String portletName = portletConfig.getPortletName();
		PortletURL successPageURL = PortletURLFactoryUtil.create(
		actionRequest,
		portletName + "_WAR_" + portletName + "portlet",themeDisplay.getPlid(),PortletRequest.RENDER_PHASE);
		
		successPageURL.setParameter("jspPage", FAQConstant.PAGE_LIST);
		actionResponse.sendRedirect(successPageURL.toString());
		//FAQEntryLocalServiceUtil.updateEntry(faqId, category, question, answer);
		
		*/
		

	}
 

}