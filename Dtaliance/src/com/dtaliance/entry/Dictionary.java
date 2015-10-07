package com.dtaliance.entry;

import java.io.Serializable;
import java.util.Date;

public class Dictionary implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;//鍞竴涓婚敭
	private String pid;
	private String name; //瀛楀吀鍚嶇О
	private String encode; //瀛楀吀缂栫爜
	private String status; //瀛楀吀鐘舵�
	private String desc; //瀛楀吀鎻忚堪
	private Integer sort; //瀛楀吀灞曠ず椤哄簭
	private Integer type;//绫诲瀷
	
	private Date insertTime;//鍒涘缓鏃堕棿
	private Date updateTime;//淇敼鏃堕棿
	private String createUser; //鍒涘缓浜�
	private String updateUser; //淇敼浜�
	
	private Long version;//涔愯閿佹帶鍒跺瓧娈�
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
