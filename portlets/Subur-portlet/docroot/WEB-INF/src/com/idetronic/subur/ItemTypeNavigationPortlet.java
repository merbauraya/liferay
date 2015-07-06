package com.idetronic.subur;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ItemType
 */
public class ItemTypeNavigationPortlet extends MVCPortlet {
	
	@Override
	  public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
	      PortletException {

	    String itemTypeIds = ParamUtil.getString(actionRequest, "itemTypeIds");

	    if (Validator.isNotNull(itemTypeIds)) {
	    	actionResponse.setRenderParameter("itemTypeId", itemTypeIds);
	    } else {
	    	actionResponse.setRenderParameter("itemTypeId", StringPool.BLANK);
	    }

	    actionResponse.setRenderParameter("resetCur", Boolean.TRUE.toString());

	    super.processAction(actionRequest, actionResponse);
	  }
 

}
