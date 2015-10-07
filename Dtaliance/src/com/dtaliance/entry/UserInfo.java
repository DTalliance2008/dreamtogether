package com.dtaliance.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userName;
	private String LoginName;
	private String password;
	private String introduce;
	private String icon;
	private Date createTime;
	private Date updateTime;
	
	private List<Ugroup> ugroups;
	private List<Dream> dreams;
	private List<Friend> applyUser;
	private List<Friend> agreeUser;
	
	private String sesssionID;//验证登陆
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getSesssionID() {
		return sesssionID;
	}
	public void setSesssionID(String sesssionID) {
		this.sesssionID = sesssionID;
	}
	public List<Ugroup> getUgroups() {
		return ugroups;
	}
	public void setUgroups(List<Ugroup> ugroups) {
		this.ugroups = ugroups;
	}
	public List<Dream> getDreams() {
		return dreams;
	}
	public void setDreams(List<Dream> dreams) {
		this.dreams = dreams;
	}
	public List<Friend> getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(List<Friend> applyUser) {
		this.applyUser = applyUser;
	}
	public List<Friend> getAgreeUser() {
		return agreeUser;
	}
	public void setAgreeUser(List<Friend> agreeUser) {
		this.agreeUser = agreeUser;
	}
	

}
