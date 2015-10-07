package com.dtaliance.Model;

public class MessageShow {
	public MessageShow(){}
	
	public MessageShow(String title,String info){
		this.title = title;
		this.info = info;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getExceptionStack() {
		return exceptionStack;
	}

	public void setExceptionStack(String exceptionStack) {
		this.exceptionStack = exceptionStack;
	}
	private String title;
	private String info;
	private String exceptionStack;

}
