package org.jcssc.meetdirector.bean;

public class BaseBean
{
	private String lastMaintOpid;
	private String lastMaintDateTime;

	public String getLastMaintOpid() {
		return lastMaintOpid;
	}
	
	public void setLastMaintOpid(String lastMaintOpid) {
		this.lastMaintOpid = lastMaintOpid;
	}
	
	public String getLastMaintDateTime() {
		return lastMaintDateTime;
	}
	
	public void setLastMaintDateTime(String lastMaintDateTime) {
		this.lastMaintDateTime = lastMaintDateTime;
	}

	@Override
	public String toString() {
		return "BaseBean [lastMaintOpid=" + lastMaintOpid
				+ ", lastMaintDateTime=" + lastMaintDateTime + "]";
	}
}
