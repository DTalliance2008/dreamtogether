package com.dtaliance.util;

import android.annotation.SuppressLint;

public class SystemTool {
	public static String arrayToString(String[] array){
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<array.length; i++){
			sb.append(array[i]);
			if(i != array.length - 1){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	public static boolean isEmpty(String str){
		if(str == null || str.isEmpty()){
			return true;
		}
		return false;
	}
	
	@SuppressLint("NewApi")
	public static String delSE(String string){
		if(string ==null || string.isEmpty()){
			return null;
		} else {
			string = string.trim();
			String[] res1 = string.split("\\[");
			if(res1.length != 2){
				return null;
			} else {
				if((res1[1].split("\\]")).length < 3){
					return res1[1].split("\\]")[0];
				}
			}
		}
		return null;
	}
	
	@SuppressLint("NewApi")
	public static String delplace(String string){
		if(string == null || string.isEmpty()){
			return null;
		} else {
			return string.replace("[", "").replace("]", "");
		}
	}
	
	@SuppressLint("NewApi")
	public static String deleteBrackets(String str){
		if(str == null || str.isEmpty()){
			return null;
		} else {
			if(str.length() > 1){
				String newStr = str.substring(1, str.length()-1);
				return newStr;
			}
			return null;
		}
	}
}
