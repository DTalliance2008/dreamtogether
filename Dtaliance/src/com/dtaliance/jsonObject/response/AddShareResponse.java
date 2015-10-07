package com.dtaliance.jsonObject.response;


import com.dtaliance.jsonObject.detail.AddShareDreamDetail;
import com.dtaliance.jsonObject.global.Response;

public class AddShareResponse extends Response{
	private AddShareDreamDetail details;

	public AddShareDreamDetail getDetails() {
		return details;
	}

	public void setDetails(AddShareDreamDetail details) {
		this.details = details;
	}
	
}
