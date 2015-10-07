package com.dtaliance.db;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.dtaliance.jsonObject.entry.Remind;
import com.dtaliance.util.ConstantUtil;

public class RemindData {
	private SQLiteHelper helper;

	public RemindData(Context context){
		helper = new SQLiteHelper(context);
	}
	
	//����ݿ�
	public RemindData(Context context, int version){
		helper = new SQLiteHelper(context, version);
	}
	
	public boolean addPersistData(String type, String title, String keyWord, String url){
		SQLiteDatabase db = helper.getWritableDatabase();
		String insertQuery = "insert into " + ConstantUtil.TABLE_REMIND + " (type, title, keyWord, url ) values(?, ?, ?, ?)";
		boolean flag = false;
		db.beginTransaction();
		try {
			db.execSQL(insertQuery, new Object[]{type, title, keyWord, url});
			db.setTransactionSuccessful();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.endTransaction();
			db.close();
		}
		return flag;
	}
	
	public List<Remind> selectPersistData(String start, String end){
		SQLiteDatabase db = helper.getWritableDatabase();
		List<Remind> remindList = new LinkedList<Remind>();
		Cursor cursor = null;
		try {
			cursor = db.query(ConstantUtil.TABLE_REMIND, new String[]{"title","type", "keyWord", "url"}, "_id between ? and ?",  new String[]{start, end}, null, null, null);
			while(cursor.moveToNext()){
				Remind remind = new Remind();
				remind.setTitle(cursor.getString(0));
				remind.setType(cursor.getString(1));
				remind.setKeyWord(cursor.getString(2));
				remind.setUrl(cursor.getString(3));
				remindList.add(remind);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return remindList;
	}
	
	public List<Remind> selectAllData(){
		SQLiteDatabase db = helper.getWritableDatabase();
		List<Remind> remindList = new ArrayList<Remind>();
		Cursor cursor = null;
		try {
			cursor = db.query(ConstantUtil.TABLE_REMIND, new String[]{"title","type", "keyWord", "url"}, null,  null, null, null, null);
			while(cursor.moveToNext()){
				Remind remind = new Remind();
				remind.setTitle(cursor.getString(0));
				remind.setType(cursor.getString(1));
				remind.setKeyWord(cursor.getString(2));
				remind.setUrl(cursor.getString(3));
				remindList.add(remind);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return remindList;
	}
	
	public int countData(){
		SQLiteDatabase db = helper.getWritableDatabase();
		int count = -1;
		try {
			Cursor cursor = db.rawQuery("select count(*) from " + ConstantUtil.TABLE_REMIND, null);
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
