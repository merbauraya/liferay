package com.idetronic.portlet;

import com.liferay.portal.kernel.exception.PortalException;



public class UserServiceEndDateException extends PortalException {
	public UserServiceEndDateException()
	{
		super();
	}
	public UserServiceEndDateException(String msg)
	{
		super(msg);
	}
	public UserServiceEndDateException(String msg, Throwable cause)
	{
		super(msg,cause);
	}
	public UserServiceEndDateException(Throwable cause)
	{
		super(cause);
	}

}
