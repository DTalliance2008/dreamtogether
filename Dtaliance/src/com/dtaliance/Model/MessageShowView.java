package com.dtaliance.Model;

import java.util.ArrayList;
import java.util.List;

public class MessageShowView {
	
	public String getMsgstatus() {
		return msgstatus;
	}
	public void setMsgstatus(String msgstatus) {
		this.msgstatus = msgstatus;
	}
	public List<MessageShow> getMsgdatas() {
		if(msgdatas == null || msgdatas.isEmpty()){
			msgdatas = new ArrayList<MessageShow>() ;
		}
		return msgdatas;
	}
	public void setMsgdatas(List<MessageShow> msgdatas) {
		this.msgdatas = msgdatas;
	}
	
	private String msgstatus;
	private List<MessageShow> msgdatas;
}
