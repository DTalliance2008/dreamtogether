package com.dtaliance.jsonObject.detail;

import com.dtaliance.jsonObject.entry.ShareDream;

public class AddShareDreamDetail {
	private ShareDream shareDream;
	private String sessionID;
	public ShareDream getShareDream() {
		return shareDream;
	}
	public void setShareDream(ShareDream shareDream) {
		this.shareDream = shareDream;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
}
