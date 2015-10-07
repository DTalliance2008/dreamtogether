package com.dtaliance.jsonObject.detail;

import com.dtaliance.jsonObject.entry.CreateDream;

public class CreateDreamDetail {
	private CreateDream createDream;
	private String sessionID;
	public CreateDream getCreateDream() {
		return createDream;
	}
	public void setCreateDream(CreateDream createDream) {
		this.createDream = createDream;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
}
