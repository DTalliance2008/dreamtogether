package com.dtaliance.jsonObject.detail;

import java.util.List;

import com.dtaliance.jsonObject.entry.Remind;

public class PersistDetail {
	private String sessionID;
	private List<Remind> remind;
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public List<Remind> getRemind() {
		return remind;
	}
	public void setRemind(List<Remind> remind) {
		this.remind = remind;
	}
}
