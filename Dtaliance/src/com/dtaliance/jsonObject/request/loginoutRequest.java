package com.dtaliance.jsonObject.request;


import com.dtaliance.jsonObject.detail.LoginoutInfo;
import com.dtaliance.jsonObject.global.GlobalRequset;

public class loginoutRequest extends GlobalRequset{
	private LoginoutInfo loginoutInfo;
	
	public LoginoutInfo getLoginoutInfo() {
		return loginoutInfo;
	}

	public void setLoginoutInfo(LoginoutInfo loginoutInfo) {
		this.loginoutInfo = loginoutInfo;
	}
	
}
