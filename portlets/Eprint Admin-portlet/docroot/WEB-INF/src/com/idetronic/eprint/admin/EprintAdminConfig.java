package com.idetronic.eprint.admin;

public class EprintAdminConfig {
	private long userId;
	private boolean useDefaultUser;
	public void setUserId(long userId)
	{
		this.userId = userId;
	}
	public long getUserId()
	{
		return this.userId;
	}
	public void setUseDefaultUser(boolean useDefaultUser)
	{
		this.useDefaultUser = useDefaultUser;
	}
	public boolean getUseDefaultUser()
	{
		return this.useDefaultUser;
	}
	

}
