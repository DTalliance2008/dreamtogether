package com.dtaliance.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.dtaliance.jsonObject.entry.ShareDream;
import com.dtaliance.util.ConstantUtil;

public class ShareData {
	private SQLiteHelper helper;
	
	public ShareData(Context context){
		helper = new SQLiteHelper(context);
	}
	
	//Éý¼¶Êý¾Ý¿â
	public ShareData(Context context, int version){
		helper = new SQLiteHelper(context, version);
	}
	
	public boolean addShare(String userName, String shareDream){
		boolean flag = false;
		SQLiteDatabase db = helper.getWritableDatabase();
		String sql = "insert into " + ConstantUtil.TABLE_SHARE + "(username, sharecontent) values(?, ?)";
		db.beginTransaction();
		try {
			db.execSQL(sql, new Object[]{userName, shareDream});
			db.setTransactionSuccessful();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			db.endTransaction();
			db.close();
		}
		return flag;
	}
	
	public boolean addListShare(List<ShareDream> dreams){
		boolean flag = false;
		SQLiteDatabase db = helper.getWritableDatabase();
		String sql = "insert into " + ConstantUtil.TABLE_SHARE + "(username, sharecontent) values(?, ?)";
		db.beginTransaction();
		try {
			
			SQLiteStatement stat = db.compileStatement(sql);  
			for (ShareDream shareDream : dreams) {
				stat.bindString(1, shareDream.getUserName());
				stat.bindString(2, shareDream.getShareContent());
				long result = stat.executeInsert();
				if(result < 0){
					return false;
				}
//				db.execSQL(sql, new String[]{shareDream.getUserName(), shareDream.getShareContent()});
			}
			
			
			db.setTransactionSuccessful();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.endTransaction();
			db.close();
		}
		return flag;
	}
	
	public List<ShareDream> selectAll(){
		List<ShareDream> dreams = new ArrayList<ShareDream>();
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = null;
		try {
			cursor = db.query(ConstantUtil.TABLE_SHARE, new String[]{"username", "sharecontent"}, 
					null, null, null, null, null);
			while(cursor.moveToNext()){
				ShareDream shareDream = new ShareDream();
				shareDream.setUserName(cursor.getString(0));
				shareDream.setShareContent(cursor.getString(1));
				dreams.add(shareDream);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return dreams;
	}
	
	public List<ShareDream> selectShareData(int start, int end){
		List<ShareDream> dreams = new ArrayList<ShareDream>();
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = null;
		
		try {
			cursor = db.query(ConstantUtil.TABLE_SHARE, new String[]{"username", "sharecontent"}, 
					"_id between ? and ? ", new String[]{Integer.toString(start), Integer.toString(end)}, null, null, null, null);
			while (cursor.moveToNext()) {
				ShareDream shareDream = new ShareDream();
				shareDream.setUserName(cursor.getString(0));
				shareDream.setShareContent(cursor.getString(1));
				dreams.add(shareDream);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return dreams;
	}
	
	public int countData(){
		SQLiteDatabase db = helper.getWritableDatabase();
		int count = -1;
		try {
			Cursor cursor = db.rawQuery("select count(*) from " + ConstantUtil.TABLE_SHARE, null);
			while(cursor.moveToNext()){
				count = cursor.getInt(0);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return count;
	}
}
