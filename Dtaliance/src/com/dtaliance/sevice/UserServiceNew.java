package com.dtaliance.sevice;

import android.app.Application;

import com.alibaba.fastjson.JSON;
import com.dtaliance.Model.UIModel;
import com.dtaliance.entry.UserInfo;
import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.HttpDownloader;
import com.dtaliance.util.UserApplication;

public class UserServiceNew {
	private UserApplication user;
	private HttpDownloader httpDownloader;
	   
	public UserServiceNew(Application application){
		user = (UserApplication) application;
		httpDownloader = new HttpDownloader();
	}
	
	public String getRegist(String userName, String email, String passwd,
			String introduce, String icon) {

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setLoginName(email);
		userInfo.setPassword(passwd);
		userInfo.setIntroduce(introduce);

		StringBuffer upString = new StringBuffer("param=");
		upString.append(JSON.toJSON(userInfo));
		
		String httpUrl = ConstantUtil.URLPATH + "exeAdd_user.action?";
		
		String downloadString = httpDownloader.DownloadString(httpUrl, upString.toString());

		if (downloadString != null) {

			UIModel model = JSON.parseObject(downloadString, UIModel.class);
			
			if (ConstantUtil.SUCCESS.equals(model.getStatus())) { 
				 user.setSessionID((String)model.getData());
				 user.setUserName(userName);
				 user.setEmail(email);
				 user.setIntroduce(introduce);
				return ConstantUtil.SUCCESS;
			} 
		}
		return ConstantUtil.FAILED;
	}
	
	public String getLogin(String loginName, String password){
		UserInfo userInfo = new UserInfo();
		userInfo.setLoginName(loginName);
		userInfo.setPassword(password);
		
		String downloadString = httpDownloader.DownloadString(
				ConstantUtil.URLPATH + "exeLogin_user.action?param=", JSON.toJSONString("a")) ;
		
		if(downloadString != null){
			UIModel model = JSON.parseObject(downloadString, UIModel.class);
			if(ConstantUtil.SUCCESS.equals(model.getStatus())){
				user.setSessionID((String) model.getData());
				return ConstantUtil.SUCCESS;
			}
		}
		return ConstantUtil.FAILED;
	}
	
//	public String getLogout(){
//		
//	}
}
