package com.dtaliance.jsonObject.request;


import com.dtaliance.jsonObject.detail.ChangeInfo;
import com.dtaliance.jsonObject.global.GlobalRequset;


public class ChangeInfoRequest extends GlobalRequset{
	private ChangeInfo changeInfo;
	
	public ChangeInfo getChangeInfo() {
		return changeInfo;
	}

	public void setChangeInfo(ChangeInfo changeInfo) {
		this.changeInfo = changeInfo;
	}
	
}
