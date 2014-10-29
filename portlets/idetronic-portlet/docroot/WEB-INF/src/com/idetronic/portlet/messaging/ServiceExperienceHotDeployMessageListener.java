package com.idetronic.portlet.messaging;

import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortletClassInvoker;
//import com.liferay.compat.portal.kernel.util.PortletClassInvoker;
import com.liferay.portal.kernel.messaging.HotDeployMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.ClassResolverUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.idetronic.portlet.service.ClpSerializer;



public class ServiceExperienceHotDeployMessageListener extends
		HotDeployMessageListener {
	
	public ServiceExperienceHotDeployMessageListener(String... servletContextNames) {
		super(servletContextNames);
	}

	@Override
	protected void onDeploy(Message message) throws Exception {
		long companyId = message.getLong("companyId");

		if (PortletLocalServiceUtil.hasPortlet(
				companyId, "1_WAR_contactsportlet")) {

			registerContactsExtension();
		}
	}

	protected void registerContactsExtension() throws Exception {
		if (_registerMethodKey == null) {
			try {
				_registerMethodKey = new MethodKey(
					ClassResolverUtil.resolveByPortletClassLoader(
						"com.liferay.contacts.util.ContactsExtensionsUtil",
						"contacts-portlet"),
					"register", String.class, String.class);
			}
			catch (RuntimeException re) {
				return;
			}
		}
		PortletClassInvoker.invoke(true,
				"1_WAR_contactsportlet", _registerMethodKey,
				ClpSerializer.getServletContextName(), "/html/contact/service_summary.jsp");
		
		/*
		PortletClassInvoker.invoke(true,
				"1_WAR_contactsportlet", _registerMethodKey,
				ClpSerializer.getServletContextName(), "/html/contact/user_expertise.jsp");
		
		PortletClassInvoker.invoke(true,
				"1_WAR_contactsportlet", _registerMethodKey,
				ClpSerializer.getServletContextName(), "/html/contact/org_chart.jsp");
		*/
		
		/*
		PortletClassInvoker.invoke(
			"1_WAR_contactsportlet", _registerMethodKey,
			ClpSerializer.getServletContextName(), "/contacts/projects.jsp");
		
		PortletClassInvoker.invoke(
				"1_WAR_chatportlet", _registerMethodKey,
				ClpSerializer.getServletContextName(), "/chat/view.jsp");
				
		*/
	}

	private MethodKey _registerMethodKey;

}
