package com.dtaliance.jsonObject.request;


import com.dtaliance.jsonObject.entry.CreateDream;
import com.dtaliance.jsonObject.global.GlobalRequset;

public class CreateDreamRequest extends GlobalRequset{
	private CreateDream createDreamInfo;

	public CreateDream getCreateDreamInfo() {
		return createDreamInfo;
	}

	public void setCreateDreamInfo(CreateDream createDreamInfo) {
		this.createDreamInfo = createDreamInfo;
	}
}
