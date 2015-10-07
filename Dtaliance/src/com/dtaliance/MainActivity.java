package com.dtaliance;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_start);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
//		TextView tv = (TextView) findViewById(R.id.tv_test);
//		
//		User user = new User();
//		user.setUserName("test");
//		user.setRegistEmail("test@regist");
//		tv.setText(JSON.toJSONString(user));
		
		getWindow().setFormat(PixelFormat.RGBA_8888);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

        //Display the current version number
        PackageManager pm = getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo("org.wordpress.android", 0);
//            TextView versionNumber = (TextView) findViewById(R.id.versionNumber);
//            versionNumber.setText("Version " + pi.versionName);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            public void run() {
                /* Create an Intent that will start the Main WordPress Activity. */
               goLogin();
            }
        }, 2900); //2900 for release
		
	}
	
	public void goLogin(){
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		finish();
	}
}
