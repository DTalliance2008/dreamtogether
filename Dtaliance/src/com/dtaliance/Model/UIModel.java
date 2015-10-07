package com.dtaliance.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UIModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**权限数据*/
	private Set<String> privilege = new HashSet<String>();
	
	/**业务数据*/
	private Object data;
	
	/**操作成功失败信息以及原因*/
	private MessageShowView msgView;
	private String status;

	public Set<String> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Set<String> privilege) {
		this.privilege = privilege;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public MessageShowView getMsgView() {
		return msgView;
	}

	public void setMsgView(MessageShowView msgView) {
		this.msgView = msgView;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
