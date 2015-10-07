package com.dtaliance.jsonObject.detail;


import java.util.List;

import com.dtaliance.jsonObject.entry.ShareDream;

public class SearchShareDreamDetail {
	private List<ShareDream> shareDreamList;
	private String sessionID;
	public List<ShareDream> getShareDreamList() {
		return shareDreamList;
	}
	public void setShareDreamList(List<ShareDream> shareDreamList) {
		this.shareDreamList = shareDreamList;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
}
