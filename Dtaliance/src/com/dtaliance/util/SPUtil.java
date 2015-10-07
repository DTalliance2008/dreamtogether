package com.dtaliance.util;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class SPUtil {
	
	/**
	 * 
	 * @param sp
	 * @return
	 */
	
	public static String getString(Context context, String spName, String key, String value){
		SharedPreferences sp = context.getSharedPreferences(spName, Activity.MODE_PRIVATE);
		return sp.getString(key, value);
	}
	
	public static Set<String> getStringSet(Context context, String spName, String key){
		SharedPreferences sp = context.getSharedPreferences(spName, Activity.MODE_PRIVATE);
		return sp.getStringSet(key, new HashSet<String>()); 
	}
	
	public static String getString(Context context, String spName, String key){
		return getString(context, spName, key, "");
	}
	
	public static String getDreamTitle(Context context, String dreamLevel){
		return getString(context, dreamLevel, "title");
	}
	
	public static void setString(Context context, String spName, String key, String value){
		SharedPreferences sp = context.getSharedPreferences(spName, Activity.MODE_PRIVATE);
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.commit();
	}
	
	@SuppressWarnings("unchecked")
	public static void setString(Context context, String spName, Map<String, Object> map){
		SharedPreferences sp = context.getSharedPreferences(spName, Activity.MODE_PRIVATE);
		Editor edit = sp.edit();
		for(Entry<String, Object> entry : map.entrySet()){
			if(entry.getValue() instanceof String){
				edit.putString(entry.getKey(), (String) entry.getValue());
			}
			if(entry.getValue() instanceof Integer){  
				edit.putInt(entry.getKey(), (Integer) entry.getValue());
			}
			if(entry.getValue() instanceof Set<?>){
				edit.putStringSet(entry.getKey(), (Set<String>) entry.getValue());
			}
		}
		edit.commit();
	} 
	
	public static void removeString(Context context, String spName, String key){
		SharedPreferences sp = context.getSharedPreferences(spName, Activity.MODE_PRIVATE);
		Editor edit = sp.edit();
		edit.remove(key);
		edit.commit();
	}
	
}
