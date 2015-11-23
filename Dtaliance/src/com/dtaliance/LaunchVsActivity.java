package com.dtaliance;

import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.SPUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LaunchVsActivity extends Activity{
	private Button enemyBt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launchvs);
		
		init();
		
		enemyBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				goSearchFriend();
			}
		});
	}
	
	public void init(){
		enemyBt = (Button) findViewById(R.id.bt_launchvs_enemy);		
	}
	
	public void goSearchFriend(){
		Intent intent = new Intent(this, FriendChooseActivity.class);
		intent.putExtra(ConstantUtil.ACTIVITY, ConstantUtil.LAUCHVSACTIVITY);
		startActivity(intent);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		String enemyName = SPUtil.getString(getApplicationContext(), ConstantUtil.USER_INFO, ConstantUtil.USER_LEAGUER);
		enemyBt.setText(enemyName);
	}
}
