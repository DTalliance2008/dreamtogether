package com.dtaliance.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Dream implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String shareContent;
	private Date createTime;
	
	private UserInfo userInfo;//关联用户
	private List<Comment> comments; 
	
	
	public String getShareContent() {
		return shareContent;
	}
	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
