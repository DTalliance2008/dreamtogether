package com.dtaliance.adapter;

public class DTab {
	private int title;
	private Class fragment;
	
	public DTab(int title, Class fragment) {
		this.title = title;
		this.fragment = fragment;
	}
	
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public Class getFragment() {
		return fragment;
	}
	public void setFragment(Class fragment) {
		this.fragment = fragment;
	}
	
}
