package com.dtaliance.db;

import java.util.List;

import com.dtaliance.entry.UserInfo;
import com.dtaliance.util.ConstantUtil;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserInfoOption {
	private SQLiteHelper sqLiteHelper;
	
	public UserInfoOption(Context context) {
		sqLiteHelper = new SQLiteHelper(context);
	}
	
	public UserInfoOption(Context context, int version) {
		sqLiteHelper = new SQLiteHelper(context, version);
	}
	
	public UserInfo getUserInfo(UserInfo userInfo){
		
		return userInfo;
	}
	
	public UserInfo getUserById(String id){
		UserInfo userInfo = new UserInfo();
		SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from " + ConstantUtil.TABLE_USERINFO + " where 1=1 and _id = ? ", new String[]{id});
		
		try {
			if(cursor.getCount() == 1){
				while(cursor.moveToNext()){
					userInfo.setId(cursor.getString(0));
					userInfo.setUserName(cursor.getString(1));
					userInfo.setLoginName(cursor.getString(2));
					userInfo.setPassword(cursor.getString(3));
					userInfo.setIntroduce(cursor.getString(4));
					userInfo.setIcon(cursor.getString(5));
//				userInfo.setCreateTime(cursor.getString(0));
//				userInfo.setUpdateTime(cursor.getString(0));
				}
			}else{
				Log.i("UserInfoOpiton", "用户不唯一");
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.close();
		}
		return userInfo;
	}
	
	public void add(List<UserInfo> userInfoList){
		SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
//		db.execSQL(sql);
		
		StringBuffer sql = new StringBuffer("insert into " + ConstantUtil.TABLE_USERINFO + "(_id, user_name, login_name," +
				"user_intro, user_icon, create_user, update_user) values(?,?,?,?,?,?,?) ");
		
		try {
			db.beginTransaction();
			
			for(UserInfo userInfo : userInfoList){
				db.execSQL(sql.toString(), new Object[]{userInfo.getId(), userInfo.getUserName(), userInfo.getLoginName(),
					userInfo.getIntroduce(), userInfo.getIcon(), userInfo.getCreateTime().toString(), userInfo.getUpdateTime()});
			}
			db.endTransaction();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} 
		
	}

}
