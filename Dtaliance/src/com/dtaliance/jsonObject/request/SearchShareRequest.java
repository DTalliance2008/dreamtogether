package com.dtaliance.jsonObject.request;

import com.dtaliance.jsonObject.detail.SearchInfo;
import com.dtaliance.jsonObject.global.GlobalRequset;



public class SearchShareRequest extends GlobalRequset{
	private SearchInfo searchInfo;

	public SearchInfo getSearchInfo() {
		return searchInfo;
	}

	public void setSearchInfo(SearchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}
	
}
