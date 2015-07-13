package com.idetronic.subur;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CategoriesNavigationPortlet
 */
public class CategoriesNavigationPortlet extends MVCPortlet {
	 @Override
	  public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
	      PortletException {

	    String categoryIds = ParamUtil.getString(actionRequest, "categoryIds");

	    if (Validator.isNotNull(categoryIds)) {
	    	actionResponse.setRenderParameter("categoryId", categoryIds);
	    	QName qName =
	    		  new QName("http://liferay.com", "categoryNav", "x");
	    	
	    	actionResponse.setEvent(qName, categoryIds);
	    	
	    } else {
	    	actionResponse.setRenderParameter("categoryId", StringPool.BLANK);
	    }

	    actionResponse.setRenderParameter("resetCur", Boolean.TRUE.toString());

	    super.processAction(actionRequest, actionResponse);
	  }
 

}
