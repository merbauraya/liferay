package com.idetronic.importer;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import com.idetronic.importer.ImportCal;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class CalImporter extends MVCPortlet{
	public void importCalendar(ActionRequest actionRequest,
		    ActionResponse actionResponse)
		            throws IOException, PortletException {
		
		ImportCal m = new ImportCal();
		try
		{
			m.importCalEvents();
		}
		catch (Exception ex)
		{
			System.out.print(ex.getMessage());
		}
		
		
		
	}
}