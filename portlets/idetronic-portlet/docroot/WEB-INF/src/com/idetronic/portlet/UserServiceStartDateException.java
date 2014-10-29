package com.idetronic.portlet;

import com.liferay.portal.kernel.exception.PortalException;

public class UserServiceStartDateException extends PortalException{
	public UserServiceStartDateException()
	{
		super();
	}
	public UserServiceStartDateException(String msg)
	{
		super(msg);
	}
	public UserServiceStartDateException(String msg, Throwable cause)
	{
		super(msg,cause);
	}
	public UserServiceStartDateException(Throwable cause)
	{
		super(cause);
	}

}
