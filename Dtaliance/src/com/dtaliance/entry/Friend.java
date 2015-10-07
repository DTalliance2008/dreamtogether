package com.dtaliance.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Friend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String status;
	private String createUser;
	
	private UserInfo applyUser;//申请者
	private UserInfo agreeUser;//接受者
	private Date createTime;
	
	private List<Message> messages;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public UserInfo getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(UserInfo applyUser) {
		this.applyUser = applyUser;
	}

	public UserInfo getAgreeUser() {
		return agreeUser;
	}

	public void setAgreeUser(UserInfo agreeUser) {
		this.agreeUser = agreeUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
