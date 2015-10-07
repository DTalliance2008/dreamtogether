package com.dtaliance.jsonObject.response;


import com.dtaliance.jsonObject.detail.RegistDetail;
import com.dtaliance.jsonObject.global.Response;

public class RegistResponse extends Response{
	private RegistDetail details;

	public RegistDetail getDetails() {
		return details;
	}

	public void setDetails(RegistDetail details) {
		this.details = details;
	}


}
