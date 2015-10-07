package com.dtaliance.jsonHelper;

import java.util.HashMap;
import java.util.Map;

import com.dtaliance.jsonObject.detail.ChangeInfo;
import com.dtaliance.jsonObject.entry.Regist;
import com.dtaliance.jsonObject.request.ChangeInfoRequest;
import com.dtaliance.jsonObject.request.LoginResquest;
import com.dtaliance.jsonObject.request.RegistResquest;
import com.dtaliance.jsonObject.response.ChangeInfoResponse;
import com.dtaliance.jsonObject.response.LoginResponse;
import com.dtaliance.jsonObject.response.PersistResponse;
import com.dtaliance.jsonObject.response.RegistResponse;
import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.ObjectToMap;
import com.dtaliance.util.PostStr;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserProtocal {
	
	public String requestLogin(String userName, String passwd, String email) {
		LoginResquest loginResquest = new LoginResquest();
		loginResquest.setRequest(ConstantUtil.LOGIN_REQUEST);
		
		Regist loginInfo = new Regist();
		loginInfo.setUserName(userName);
		loginInfo.setPasswd(passwd);
		loginInfo.setRegistEmail(email);
		Map<String, Object> map = new HashMap<String, Object>();
		map = ObjectToMap.ConvertObjToMap(loginInfo);
		return PostStr.mapObjToStr(map, "UTF-8");
	}
	
	public LoginResponse responseLogin(String jsonStr){
		LoginResponse loginResponse = new LoginResponse();
		Gson gson = new GsonBuilder().setDateFormat("yy-MM-dd HH:mm:ss").create();
		loginResponse = gson.fromJson(jsonStr, LoginResponse.class);
		return loginResponse;
	}
	
	public String requestRegist(String userName, String passwd, String email,
			String introduce, String icon) {
		return requestRegist(userName, passwd, email, introduce, icon, "UTF-8");
	}
	
	public String requestRegist(String userName, String passwd, String email,
			String introduce, String icon, String encode) {
		RegistResquest registResquest = new RegistResquest();
		registResquest.setRequest(ConstantUtil.REGIST_REQUEST);
		
		Regist registInfo = new Regist();
		registInfo.setIcon(icon);
		registInfo.setUserName(userName);
		registInfo.setPasswd(passwd);
		registInfo.setRegistEmail(email);
		registInfo.setIntroduce(introduce);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = ObjectToMap.ConvertObjToMap(registInfo);
		return PostStr.mapObjToStr(map, "UTF-8");
	}
	
	public RegistResponse responseRegist(String jsonStr) {
		RegistResponse registRespone = new RegistResponse();
		Gson gson = new GsonBuilder().setDateFormat("yy-MM-dd HH:mm:ss")
				.create();
		registRespone = gson.fromJson(jsonStr, RegistResponse.class);
		return registRespone;
	}
	
	public String requestChangeInfo(String sessionID, String oldUserName, String newUserName,
			String passwd, String introduce, String icon){
		ChangeInfoRequest changeInfoRequest = new ChangeInfoRequest();
		changeInfoRequest.setRequest(ConstantUtil.CHANGEINFO_REQUEST);
		changeInfoRequest.setSession(sessionID);
		
		ChangeInfo changeInfo = new ChangeInfo();
		changeInfo.setIcon(icon);
		changeInfo.setIntroduce(introduce);
		changeInfo.setNewUserName(newUserName);
		changeInfo.setOldUserName(oldUserName);
		changeInfo.setPasswd(passwd);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = ObjectToMap.ConvertObjToMap(changeInfo);
		map.put("sessionID", sessionID);
		return PostStr.mapObjToStr(map, "UTF-8");	
	}
	
	public ChangeInfoResponse responseChangeInfo(String jsonStr){
		ChangeInfoResponse changeInfoResponse = new ChangeInfoResponse();
		Gson gson = new GsonBuilder().setDateFormat("yy-MM-dd HH:mm:ss").create();
		changeInfoResponse = gson.fromJson(jsonStr, ChangeInfoResponse.class);
		return changeInfoResponse;
	}
	
	public PersistResponse responsePersist(String jsonStr){
		PersistResponse responsePersist = new PersistResponse();
		Gson gson = new Gson();
		responsePersist = gson.fromJson(jsonStr, PersistResponse.class);
		return responsePersist;
	}
	
}
