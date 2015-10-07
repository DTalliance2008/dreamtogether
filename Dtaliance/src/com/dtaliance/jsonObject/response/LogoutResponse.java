package com.dtaliance.jsonObject.response;


import com.dtaliance.jsonObject.detail.LogoutDetail;
import com.dtaliance.jsonObject.global.Response;

public class LogoutResponse extends Response{
	private LogoutDetail details;

	public LogoutDetail getDetails() {
		return details;
	}

	public void setDetails(LogoutDetail details) {
		this.details = details;
	}

	
}
