package com.idetronic.eprint.admin;

import com.idetronic.eprint.admin.EprintAdmin;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;



public class EprintGenerator implements MessageListener {
	static Log log = LogFactoryUtil.getLog(EprintGenerator.class);
	public void receive(Message message)
			throws MessageListenerException 
	{
		
		EprintAdmin epAdmin = new EprintAdmin();
		try {
			
			
			
			epAdmin.jobImportRepository();
		} catch (Exception e) {
			log.error("Error importing eprint repository");
			log.error(e);
		}
		
	}

}
