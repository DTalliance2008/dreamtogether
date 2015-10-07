package com.dtaliance.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Group implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;//group name
	private String createUser;//创建用户的ID
	private Date createTime;
	
	private List<Ugroup> ugroups;
	private List<Message> messages;
	
	public List<Ugroup> getUgroups() {
		return ugroups;
	}
	public void setUgroups(List<Ugroup> ugroups) {
		this.ugroups = ugroups;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
