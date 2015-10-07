package com.dtaliance.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.dtaliance.util.ConstantUtil;

public class SQLiteHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "yiqimengDB"; //
	private static final int VERSION = 1;
	
	private static final String CREATE_TABLE_REMIND = "create table if not exists " + ConstantUtil.TABLE_REMIND + 
			"(" + 
			"_id integer primary key autoincrement, " +
			"title varchar(50) default null, " +
			"keyWord varchar(200) default null, " +
			"url varchar(200) default null," +
			"type varchar(20) default null" +
			")";
	
	private static final String CREATE_TABLE_SHARE = "create table if not exists " + ConstantUtil.TABLE_SHARE + 
			"(" +
			"_id integer primary key autoincrement, " + 
			"username varchar(50) default null, " +
			"sharecontent varchar(300) default null" + 
			")";
	
	private static final String CREATE_TABLE_FRIEND = "create table if not exists " + ConstantUtil.TABLE_FRIEND +
			"(" + 
			"_id varchar(32) primary key, " +
			"create_user varchar(100) default null, " +
			"apply_status varchar(10) default null, " + 
			"create_time varchar(50) default null, " +
			"apply_user varchar(32) default null, " +
			"agree_user varchar(32) default null" +
			")";
	
	private static final String CREATE_TABLE_USEINFO = "create table if not exists " + ConstantUtil.TABLE_USERINFO +
			"(" +
			"_id varchar(32) primary key, " +
			"user_name varchar(100) default null, " +
			"login_name varchar(100) default null, " +
			"password varchar(100) default null, " +
			"user_intro varchar(1000) default null, " +
			"user_icon varchar(200) default null, " +
			"create_time varchar(50) default null, " +
			"update_time varchar(50) default null" +
			")";
	
	private static final String CREATE_TABLE_GROUP = "create table if not exists " + ConstantUtil.TABLE_GROUP +
			"(" + 
			"_id varchar(32) primary key, " +
			"name varchar(100) default null, " +
			"create_user varchar(100) default null, " + 
			"create_time varchar(50) default null" +
			")";
			
	
	public SQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	
	
	//������ݿ�
	public SQLiteHelper(Context context){
		this(context, DATABASE_NAME, null, VERSION);
	}
	
	//����ݿ�
	public SQLiteHelper(Context context, int version){
		this(context, DATABASE_NAME, null, version);
	}
	
	//������
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_REMIND);
		db.execSQL(CREATE_TABLE_SHARE);
		db.execSQL(CREATE_TABLE_FRIEND);
		db.execSQL(CREATE_TABLE_USEINFO);
		db.execSQL(CREATE_TABLE_GROUP);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public void reCreateNewTable(SQLiteDatabase db){
		db.execSQL("drop table if exists " + CREATE_TABLE_REMIND);
		db.execSQL("drop table if exists " + CREATE_TABLE_SHARE);
	}

}
