package com.dtaliance.sevice;

import java.util.List;

import android.app.Application;

import com.dtaliance.db.PersistWord;
import com.dtaliance.jsonHelper.UserProtocal;
import com.dtaliance.jsonObject.entry.Remind;
import com.dtaliance.jsonObject.response.LoginResponse;
import com.dtaliance.jsonObject.response.PersistResponse;
import com.dtaliance.jsonObject.response.RegistResponse;
import com.dtaliance.util.HttpDownloader;
import com.dtaliance.util.SystemTool;
import com.dtaliance.util.UserApplication;

public class UserService {
	private UserApplication user;
	private UserProtocal userProtocal;
	private HttpDownloader httpDownloader;
	   
	public UserService(Application application){
		user = (UserApplication) application;
		userProtocal = new UserProtocal();
		httpDownloader = new HttpDownloader();
	}
	
	public String getRegist(String userName, String email, String passwd,
			String introduce, String icon) {

		String uploadString = userProtocal.requestRegist(userName, passwd,
				email, introduce, icon);
		String httpUrl = "http://192.168.1.105:8080/cnpc/system/exeAddUser_regist.action?";
		String downloadString = httpDownloader.DownloadString(httpUrl, uploadString);
		downloadString = SystemTool.delSE(downloadString);

		if (downloadString != null) {
			RegistResponse registRespone = userProtocal.responseRegist(downloadString);
			String result = registRespone.getResult();
			if (result.equals("success")) {
				 user.setSessionID(registRespone.getDetails().getSessionID());
				 user.setUserName(registRespone.getDetails().getRegist().getUserName());
				 user.setIntroduce(registRespone.getDetails().getRegist().getIntroduce());
				return result;
			} else {
				return "no data";
			}
		}
		return "no data";
	}
	
	public String getLogin(String userName, String registEmail, String passwd){
		String uploadString = userProtocal.requestLogin(userName, passwd, registEmail);
		String httpUrl = "http://192.168.1.105:8080/cnpc/system/exeCheck_login.action?";
		String downloadString = httpDownloader.DownloadString(httpUrl, uploadString);
		downloadString = SystemTool.delSE(downloadString);
		
		if (downloadString != null) {
			LoginResponse loginRespone = userProtocal.responseLogin(downloadString);
			String result = loginRespone.getResult();
			if (result.equals("success")) {
				 user.setSessionID(loginRespone.getDetails().getSessionID());
				 user.setUserName(loginRespone.getDetails().getLoginDetail().getUserName());
				 user.setIntroduce(loginRespone.getDetails().getLoginDetail().getIntroduce());
				return result;
			} else {
				return "no data";
			}
		}
		return "no data";
	}
	
	public String getPersist(int count){
		String httpUrl = "http://192.168.1.105:8080/cnpc/system/exePersist_ImpData.action?count="+Integer.toString(count);
		String downloadString = httpDownloader.DownloadString(httpUrl, "");
		downloadString = SystemTool.deleteBrackets(downloadString.trim());
		
		if(downloadString != null){
			PersistResponse persistResponse = userProtocal.responsePersist(downloadString);
			if(persistResponse.getResult().equals("success")){
				
				PersistWord persistWord = new PersistWord(user.getApplicationContext());
				List<Remind> reminds = persistResponse.getDetail().getRemind();
				for (Remind remind : reminds) {
					persistWord.addPersistData(remind.getType(), remind.getTitle(), remind.getKeyWord(), remind.getUrl());
				}
				
				return "success";
			}
		}
		return "no data";
	}

}
 