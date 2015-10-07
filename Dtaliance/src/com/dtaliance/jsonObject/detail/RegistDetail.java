package com.dtaliance.jsonObject.detail;


import com.dtaliance.jsonObject.entry.Regist;

public class RegistDetail {
	private String sessionID;
	private Regist regist;
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public Regist getRegist() {
		return regist;
	}
	public void setRegist(Regist regist) {
		this.regist = regist;
	}
}
