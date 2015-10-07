package com.dtaliance.db;

import android.content.Context;

public class FriendOpt {
	
	private SQLiteHelper helper;
	
	public FriendOpt(Context context) {
		helper = new SQLiteHelper(context);
	}
	
	public FriendOpt(Context context, int version){
		helper = new SQLiteHelper(context, version);
	}
	
	
	
	
}
