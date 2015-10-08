package com.dtaliance;

import java.util.LinkedHashSet;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.dtaliance.util.ConstantUtil;

public class RemindActivity extends Activity{
	
	private TextView taskTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remind);
		
		Button addBt = (Button) findViewById(R.id.bt_remind_add);
		Button clearBt = (Button) findViewById(R.id.bt_remind_clear);
		
		taskTv = (TextView) findViewById(R.id.tv_remind_clocktittleone);
		
		clearBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				clearTask();
			}
		});
		
		addBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTimeAdd(null);
			}
		});
		
		taskTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTimeAdd(taskTv.getText().toString().trim());
			}
		});
	}
	
	public void goTimeAdd(String title){
		Intent intent = new Intent(this, TimeAddActivity.class);
		intent.putExtra(ConstantUtil.REMIND_TITLE, title);
		startActivity(intent);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		SharedPreferences sp = getApplicationContext().getSharedPreferences(ConstantUtil.TIME_ADD, MODE_PRIVATE);
		Set<String> stringSet = sp.getStringSet(ConstantUtil.REMIND_TITLE, new LinkedHashSet<String>());
		
		String res = null;
		for(String str : stringSet){
			res = str;
		}
		taskTv.setText(res);
	}

	public void clearTask(){
		SharedPreferences sp = getApplicationContext().getSharedPreferences(ConstantUtil.TIME_ADD, MODE_PRIVATE);
		Editor edit = sp.edit();
		
	}
}
