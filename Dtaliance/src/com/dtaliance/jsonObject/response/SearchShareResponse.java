package com.dtaliance.jsonObject.response;


import com.dtaliance.jsonObject.detail.SearchShareDreamDetail;
import com.dtaliance.jsonObject.global.Response;

public class SearchShareResponse extends Response{
	private SearchShareDreamDetail details;

	public SearchShareDreamDetail getDetails() {
		return details;
	}

	public void setDetails(SearchShareDreamDetail details) {
		this.details = details;
	}
	
}
