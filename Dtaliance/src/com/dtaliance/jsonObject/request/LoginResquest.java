package com.dtaliance.jsonObject.request;

import com.dtaliance.jsonObject.detail.LoginInfo;


public class LoginResquest {
	private String request;
	private LoginInfo loginInfo;
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	
}
