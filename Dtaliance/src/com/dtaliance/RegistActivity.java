package com.dtaliance;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dtaliance.sevice.UserServiceNew;
import com.dtaliance.util.ValidateStr;

public class RegistActivity extends Activity{

	private Button confirm;
	private EditText registEmailET;
//	private EditText userNameET;
	private EditText passwdET;
	private EditText repasswdET;
//	private EditText introduceET;
	
	private String registEmail;
//	private String userName;
	private String passwd;
	private String repasswd;
//	private String introduce;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		
		confirm = (Button) findViewById(R.id.bt_regist_confirm);
		registEmailET = (EditText) findViewById(R.id.et_regist_email);
//		userNameET = (EditText) findViewById(R.id.et_regist_username);
		passwdET = (EditText) findViewById(R.id.et_regist_passwd);
		repasswdET = (EditText) findViewById(R.id.et_regist_repasswd);
//		introduceET = (EditText) findViewById(R.id.et_regist_introduce);
		
		confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(validateInfo()){
//					regist(userName, registEmail, passwd, introduce, repasswd);
					regist("", registEmail, passwd, "", repasswd);
				} 
			}
		});
	}
	
	public void regist(String userName, String registEmail, String passwd,
			String introduce, String icon) {
		new RegistBackground(RegistActivity.this).execute(userName,
				registEmail, passwd, introduce, icon);
	}
	
	public class RegistBackground extends AsyncTaskWithProgressDialog{

		public RegistBackground(Context progressDialogContext){
			super(progressDialogContext);
		}
		
		@Override
		protected void onPostExecute2(String result) {
			if(result.equals("success")){
				goCreateDream();
			} else {
				Toast.makeText(getApplicationContext(), "registʧ��",
						Toast.LENGTH_SHORT).show();
			}
		}

		@Override
		protected String doInBackground2(String... params) {
			UserServiceNew service = new UserServiceNew(getApplication());
			return service.getRegist(params[0], params[1], params[2], params[3], params[4]);
		}
	}
	
	@SuppressLint("NewApi")
	public boolean validateInfo(){
		boolean flag = false;
		
		registEmail = registEmailET.getText().toString().trim();
//		userName = userNameET.getText().toString().trim();
		passwd = passwdET.getText().toString().trim();
		repasswd = repasswdET.getText().toString().trim();
//		introduce = introduceET.getText().toString().trim();
		
		if(passwd.isEmpty() || !(repasswd.equals(passwd))){
			Toast.makeText(getApplicationContext(), "���벻��ȷ", Toast.LENGTH_SHORT).show();
			return flag;
		}
		
//		if(userName.isEmpty()){
//			Toast.makeText(getApplicationContext(), "�û�����Ϊ��", Toast.LENGTH_SHORT).show();
//			return flag;
//		}
		
		if(registEmail.isEmpty() || !ValidateStr.ValidateEmail(registEmail)){
			Toast.makeText(getApplicationContext(), "�������", Toast.LENGTH_SHORT).show();
			return flag;
		}
		
		flag = true;
		return flag;
	}
	
	public void goCreateDream(){
		Intent intent = new Intent(this, CreateDreamActivity.class);
		startActivity(intent);
	}

}
