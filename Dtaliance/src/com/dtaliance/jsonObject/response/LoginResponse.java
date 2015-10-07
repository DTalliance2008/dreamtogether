package com.dtaliance.jsonObject.response;


import com.dtaliance.jsonObject.detail.LoginDetail;
import com.dtaliance.jsonObject.global.Response;

public class LoginResponse extends Response{
	private LoginDetail details;

	public LoginDetail getDetails() {
		return details;
	}

	public void setDetails(LoginDetail details) {
		this.details = details;
	}
	
}
