package com.dtaliance;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.SPUtil;

public class TeamCreateActivity extends Activity{
	
	private TextView teamNameTv;
	private TextView firstDream;
	private TextView middleDream;
	private TextView terminalDream;
	
	private Button chooseMate;
	private Button firstDreamTask;
	private Button middleDreamTask;
	private Button terminalDreamTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teamcreate);
		
		teamNameTv = (EditText) findViewById(R.id.et_teamcreate_teamname);
		
		firstDream = (EditText) findViewById(R.id.et_teamcreate_firstdream);
		middleDream = (EditText) findViewById(R.id.et_teamcreate_middledream);
		terminalDream = (EditText) findViewById(R.id.et_teamcreate_terminaldream);
		
		firstDreamTask = (Button) findViewById(R.id.bt_teamcreate_firtaskadd);
		middleDreamTask = (Button) findViewById(R.id.bt_teamcreate_midtaskadd);
		terminalDreamTask = (Button) findViewById(R.id.bt_teamcreate_tertaskadd);
		
		chooseMate = (Button) findViewById(R.id.bt_teamcreate_teammatechoose);
		Button chooseLogo = (Button) findViewById(R.id.bt_teamcreate_logochoose);
		Button con = (Button) findViewById(R.id.bt_teamcreate_confirm);
		
		Intent intent = getIntent();
		String teamDream = intent.getStringExtra(ConstantUtil.TEAM_DREAM);
		
		if(teamDream != null){
			teamNameTv.setText(teamDream);
			getTeamDream();
		}
		firstDreamTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		middleDreamTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		terminalDreamTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		chooseMate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplication(), FriendChooseActivity.class);
				startActivity(intent);
			}
		});
		
		chooseLogo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		con.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				saveTeamDream(teamNameTv.getText().toString().trim(), 
						firstDream.getText().toString().trim(),
						middleDream.getText().toString().trim(), 
						terminalDream.getText().toString().trim());
				finish();
			}
		});
		
	}
	
	public void goTeamTask(){}
	
	private void setPageDetail(EditText teamNameET) {
//		SharedPreferences sp = getApplicationContext().getSharedPreferences(ConstantUtil.TEAM_DREAM, MODE_PRIVATE);
//		Editor edit = sp.edit();
	}

	public void saveTeamDream(String teamName, String first, String middle, String terminal){
//		SharedPreferences sp = getApplicationContext().getSharedPreferences(ConstantUtil.TEAM_DREAM, MODE_PRIVATE);
//		Editor edit = sp.edit();
//		
//		edit.putString(ConstantUtil.TEAM_NAME, teamName);
//		edit.putString(ConstantUtil.TEAM_FIRST_LEVEL, first);
//		edit.putString(ConstantUtil.TEAM_MIDDLE_LEVEL, middle);
//		edit.putString(ConstantUtil.TEAM_TERMINAL_LEVEL, terminal);
//		edit.commit();
		saveSP(teamName, ConstantUtil.TEAM_FIRST_LEVEL, first);
		saveSP(teamName, ConstantUtil.TEAM_MIDDLE_LEVEL, middle);
		saveSP(teamName, ConstantUtil.TEAM_TERMINAL_LEVEL, terminal);
		
	}
	
	public void saveSP(String teamName, String level, String levelName){
		SharedPreferences sp = getApplicationContext().getSharedPreferences(level, MODE_PRIVATE);
		
		Editor edit = sp.edit();
		edit.putString(ConstantUtil.TEAM_NAME, teamName);
		edit.putString("title", levelName);
		edit.commit();
	}
	
	public void getTeamDream(){
//		SharedPreferences sp = getApplicationContext().getSharedPreferences(ConstantUtil.TEAM_DREAM, MODE_PRIVATE);
//		String l1 = sp.getString(ConstantUtil.TEAM_MIDDLE_LEVEL, ""); 
//		String l2 = sp.getString(ConstantUtil.TEAM_TERMINAL_LEVEL, "");
//		firstDream.setText(sp.getString(ConstantUtil.TEAM_FIRST_LEVEL, ""));
//		middleDream.setText(l1);
//		terminalDream.setText(l2);
		firstDream.setText(SPUtil.getString(getApplicationContext(), ConstantUtil.TEAM_FIRST_LEVEL, "title")); 
		middleDream.setText(SPUtil.getString(getApplicationContext(), ConstantUtil.TEAM_MIDDLE_LEVEL, "title"));
		terminalDream.setText(SPUtil.getString(getApplicationContext(), ConstantUtil.TEAM_TERMINAL_LEVEL, "title")); 
		
		Set<String> name = SPUtil.getStringSet(getApplicationContext(), ConstantUtil.TEAM_INFO, ConstantUtil.TEAM_LEAGUER);
		
		StringBuffer sb = new StringBuffer();
		for(String str : name){
			sb.append(str);
			sb.append("	");
		}
		chooseMate.setText(sb.toString());  
		
	}
	@Override
	protected void onResume() {
		super.onResume();
		getTeamDream();
	}
	
	public void goTaskAdd(String dreamLevel){
//		Intent intent = new Intent(this, TeamTaskAddActivity.class);
//		intent.putExtra(ConstantUtil.DREAM_LEVEL, );
//		intent.putExtra(ConstantUtil.TASK_LEVEL, );
	}

}
