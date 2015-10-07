package com.dtaliance;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.dtaliance.sevice.NetworkService;
import com.dtaliance.sevice.UserService;

public class LoginActivity extends Activity {

	private String userName;
	private String passwd;
	private EditText userNameET;
	private EditText passwdET;
	private CheckBox saveCode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Button loginBt = (Button) findViewById(R.id.bt_login_login);
		Button registBt = (Button) findViewById(R.id.bt_login_regist);
		userNameET = (EditText) findViewById(R.id.et_login_username);
		passwdET = (EditText) findViewById(R.id.et_login_passwd);
		saveCode = (CheckBox) findViewById(R.id.ck_login_save);

		userName = userNameET.getText().toString().trim();
		passwd = passwdET.getText().toString().trim();
		
		getActionBar().hide();
		
		loginBt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				userName = userNameET.getText().toString().trim();
				passwd = passwdET.getText().toString().trim();
//				if (ValidateStr.ValidateEmail(userName)) {
//					login("", userName, passwd);
//				} else {
//					login(userName, "", passwd);
//				}
//				 goPager();
				goDT();
			}
		});

		registBt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				goRegist();
		
//				goCreateDream();
				
			}
		});
	}
	public void goCreateDream() {
		Intent intent = new Intent(this, CreateDreamActivity.class);
		startActivity(intent);
		finish();
	}

	public void goRegist() {
		Intent intent = new Intent(this, RegistActivity.class);
		startActivity(intent);
		finish();
	}

	public void goNote() {
		Intent intent = new Intent(this, NoteActivity.class);
		startActivity(intent);
		finish();
	}

	public void goPager() {
		Intent intent = new Intent(this, PagerActivity.class);
		startActivity(intent);
		finish();
	}
	
	public void login(String username, String registEmail, String passwd) {
		NetworkService networkService = new NetworkService(getApplicationContext());
		if(networkService.isConnected() || networkService.isWifiConnected()){
			
			new LoginInBackground(LoginActivity.this).execute(username,
				registEmail, passwd);
		} else {
			Toast.makeText(getApplicationContext(), R.string.connection, Toast.LENGTH_LONG).show();
		}
		
	}

	private class LoginInBackground extends AsyncTaskWithProgressDialog {

		public LoginInBackground(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@SuppressLint("CommitPrefEdits")
		@Override
		protected String doInBackground2(String... params) {
			UserService userService = new UserService(getApplication());
			
			if("success".equals(userService.getLogin(params[0], params[1], params[2]))){
				
				Context ctx = LoginActivity.this;
				SharedPreferences preferences = ctx.getSharedPreferences("dream", MODE_PRIVATE);
				
				Editor editor = preferences.edit();
				if(preferences.getInt("count", 0) != 0){
					int count = preferences.getInt("count", 0);
					
					editor.putInt("count", count + 2);
					editor.commit();
					return userService.getPersist(count + 2);
				} else {
					editor.putInt("count", 1);
					editor.commit();
					return userService.getPersist(1);
				}
				
			} else {
				return "error";
			}
		}

		@Override
		protected void onPostExecute2(String result) {
			if (result.equals("success")) {
				Log.d("success", result);
				// goCreateDream();
				// goNote();
				goPager();
			} else {
				Log.d("success", result);
				Toast.makeText(getApplicationContext(), "登陆失败", Toast.LENGTH_LONG).show();
			}
		}
	}
	
	public void goDT(){
		Intent intent = new Intent(this, DTActivity.class);
		startActivity(intent);
	}

}
