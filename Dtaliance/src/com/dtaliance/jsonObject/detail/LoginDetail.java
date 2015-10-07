package com.dtaliance.jsonObject.detail;

import com.dtaliance.jsonObject.entry.Regist;

public class LoginDetail {
	private Regist loginDetail;
	private String sessionID;
	
	public Regist getLoginDetail() {
		return loginDetail;
	}
	public void setLoginDetail(Regist loginDetail) {
		this.loginDetail = loginDetail;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
}
