package com.dtaliance.jsonObject.request;


import com.dtaliance.jsonObject.entry.ShareDream;
import com.dtaliance.jsonObject.global.GlobalRequset;

public class AddShareRequest extends GlobalRequset{
	private ShareDream addShareDreamInfo;

	public ShareDream getAddShareDreamInfo() {
		return addShareDreamInfo;
	}

	public void setAddShareDreamInfo(ShareDream addShareDreamInfo) {
		this.addShareDreamInfo = addShareDreamInfo;
	}

	
}
