package com.dtaliance.util;

import java.net.URLEncoder;
import java.util.Map;

public class PostStr {
	public static String mapToStr(Map<String, String> params, String encode){
		StringBuffer postStr = new StringBuffer();
		if( params!=null && !params.isEmpty()){
			try {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					postStr.append(entry.getKey()).append("=")
						.append(URLEncoder.encode(entry.getValue(), encode)).append("&");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return postStr.toString();
	}
	
	public static String mapObjToStr(Map<String, Object> params, String encode){
		StringBuffer postStr = new StringBuffer();
		if( params!=null && !params.isEmpty()){
			try {
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					postStr.append(entry.getKey()).append("=")
						.append(URLEncoder.encode(entry.getValue().toString(), encode)).append("&");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return postStr.toString();
	}
}
