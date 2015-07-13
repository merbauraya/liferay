package com.idetronic.subur;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.idetronic.subur.service.DownloadSummaryLocalServiceUtil;
import com.idetronic.subur.service.ViewSummaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SuburStatisticPortlet
 */
public class SuburStatisticPortlet extends MVCPortlet {
	
	public void updateStats(ActionRequest request,ActionResponse response)throws PortalException, SystemException
	{
		ViewSummaryLocalServiceUtil.updateStats();
		DownloadSummaryLocalServiceUtil.updateStats();
	}

	
 

}
