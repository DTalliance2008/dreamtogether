package com.dtaliance.util;

import java.util.List;

import android.app.Application;

import com.dtaliance.jsonObject.entry.ShareDream;

public class UserApplication extends Application{
	private String userName;
	private String passwd;
	private String email;
	private String icon;
	private String introduce;
	private String sessionID;
	private List<ShareDream> dreamList;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public List<ShareDream> getDreamList() {
		return dreamList;
	}
	public void setDreamList(List<ShareDream> dreamList) {
		this.dreamList = dreamList;
	}
}
