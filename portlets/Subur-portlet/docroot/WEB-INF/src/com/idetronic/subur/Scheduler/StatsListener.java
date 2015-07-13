package com.idetronic.subur.Scheduler;

import java.util.List;
import java.util.Map;

import com.idetronic.subur.model.ViewSummary;
import com.idetronic.subur.service.DownloadSummaryLocalServiceUtil;
import com.idetronic.subur.service.ViewSummaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class StatsListener implements MessageListener{
	
	private static Log logger = LogFactoryUtil.getLog(StatsListener.class);
	
	@Override
	public void receive(Message messages) throws MessageListenerException {
		Map<String, Object> map = messages.getValues();
		for (Map.Entry<String, Object> entry : map.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		 
		}
		
		try
		{
			DownloadSummaryLocalServiceUtil.updateStats();
			ViewSummaryLocalServiceUtil.updateStats();
		} catch (Exception e)
		{
			logger.error(e);
		}
		
	}
	

}
