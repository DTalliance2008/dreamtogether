package com.dtaliance.util;

import android.annotation.SuppressLint;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class TimeUtil {
	
	public static String[] getFileName(String fileName){
		return fileName != null ? fileName.split("@20") : null;
	}
	
	public static String dateToString(Date date){
		String res = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			res = dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static Date stringToDate(String dateStr){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = dateFormat.parse(dateStr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
