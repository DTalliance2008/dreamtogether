package com.dtaliance.entry;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String senderName;
	private String content;
	private String receiverName;
	private Date createTime; 
	
	private Dream dream;//关联梦想
	
	public Dream getDream() {
		return dream;
	}
	public void setDream(Dream dream) {
		this.dream = dream;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
