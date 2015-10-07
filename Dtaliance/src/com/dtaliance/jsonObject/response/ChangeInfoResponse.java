package com.dtaliance.jsonObject.response;


import com.dtaliance.jsonObject.detail.ChangeInfoDetail;
import com.dtaliance.jsonObject.global.Response;

public class ChangeInfoResponse extends Response{
	private ChangeInfoDetail details;

	public ChangeInfoDetail getDetails() {
		return details;
	}

	public void setDetails(ChangeInfoDetail details) {
		this.details = details;
	}
	

}
