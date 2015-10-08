package com.dtaliance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.SPUtil;

public class TeamCreateActivity extends CompleteActivity{
	
	private TextView teamNameTv;
	private TextView firstDream;
	private TextView middleDream;
	private TextView terminalDream;
	
	private Button chooseMate;
	private Button firstDreamTask;
	private Button middleDreamTask;
	private Button terminalDreamTask;
	
	private TextView firListOne;
	private TextView firListTwo;
	private TextView firListThree;
	
	private TextView milListOne;
	private TextView milListTwo;
	private TextView milListThree;
	
	private TextView terListOne;
	private TextView terListTwo;
	private TextView terListThree;
	
	private String TASK = "任务";
	private String DELETE = "delete";
	
	public void setListionEnable(TextView tv, boolean enable){
		if(enable){
			tv.setOnClickListener(clickListener);
			tv.setOnLongClickListener(longClickListener);
		}
		
	}
	
	public Map<String, Object> getDreamAndTaskLevel(View view){
		
		Map<String, Object> res = new HashMap<String, Object>();
		switch (view.getId()) {
		case R.id.tv_teamcreate_firlistone:
			res.put(ConstantUtil.DREAM_LEVEL, ConstantUtil.TEAM_FIRST_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 0);
			break;
		case R.id.tv_teamcreate_firlisttwo:
			res.put(ConstantUtil.DREAM_LEVEL, ConstantUtil.TEAM_FIRST_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 1);
			break;
		case R.id.tv_teamcreate_firlistthree:
			res.put(ConstantUtil.DREAM_LEVEL, ConstantUtil.TEAM_FIRST_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 2);
			break;
		case R.id.tv_teamcreate_midlistone: 
			res.put(ConstantUtil.DREAM_LEVEL, ConstantUtil.TEAM_MIDDLE_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 0);
			break;
		case R.id.tv_teamcreate_midlisttwo:
			res.put(ConstantUtil.TASK_LEVEL, ConstantUtil.TEAM_MIDDLE_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 1);
			break;
		case R.id.tv_teamcreate_midlistthree:
			res.put(ConstantUtil.DREAM_LEVEL, ConstantUtil.TEAM_MIDDLE_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 2);
			break;
		case R.id.tv_teamcreate_terlistone: 
			res.put(ConstantUtil.DREAM_LEVEL, ConstantUtil.TEAM_TERMINAL_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 0);
			break;
		case R.id.tv_teamcreate_terlisttwo:
			res.put(ConstantUtil.DREAM_LEVEL, ConstantUtil.TEAM_TERMINAL_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 1);
			break;
		case R.id.tv_teamcreate_terlistthree:
			res.put(ConstantUtil.DREAM_LEVEL, ConstantUtil.TERMINAL_LEVEL);
			res.put(ConstantUtil.TASK_LEVEL, 2);
			break;
		default:
			break;
		}
		
		return res;
	}
	
	private OnLongClickListener longClickListener = new OnLongClickListener() {
		@Override
		public boolean onLongClick(View view) {
			
			Map<String, Object> level = getDreamAndTaskLevel(view);
			String dreamLevel = (String) level.get(ConstantUtil.DREAM_LEVEL);
			int taskLevel = (Integer) level.get(ConstantUtil.TASK_LEVEL);
			if(dreamLevel != null && !dreamLevel.isEmpty()){  
				showDialogText(dreamLevel, taskLevel);   
			}
			
			return true;
		}
	};
	
	public void showDialogText(String dreamLevel, int taskLevel){
		final String dreamLevelClear = dreamLevel;
		final int taskLevelClear = taskLevel;
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setPositiveButton(DELETE + TASK + Integer.toString(taskLevel+1), new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				clearTask(dreamLevelClear, taskLevelClear);
			}
		});
		builder.show();
	}
	
	public void clearTask(String dreamLevel, int taskLevel){
		Log.i("dream", dreamLevel);
		Log.i("task", Integer.toString(taskLevel));
		Map<Integer, String> task = new HashMap<Integer, String>(); 
		task.put(0, "one");
		task.put(1, "two");
		task.put(2, "three");
		
		SharedPreferences sp = getApplicationContext().getSharedPreferences(dreamLevel, MODE_PRIVATE);
		int count = sp.getInt(ConstantUtil.TASK_COUNT, 0);
		Editor edit = sp.edit();
		
		edit.putString(task.get(taskLevel),(taskLevel + 1) > 2 ? "" : sp.getString(task.get(taskLevel+1), ""));       
		edit.putString(task.get(taskLevel) + "Prority", (taskLevel + 1) > 2 ? "" : sp.getString(task.get(taskLevel+1)+"Prority", ""));
		if(taskLevel == 0){
			edit.putString(task.get(taskLevel + 1), sp.getString(task.get(taskLevel+2), ""));
			edit.putString(task.get(taskLevel + 1) + "Prority", sp.getString(task.get(taskLevel+2)+"Prority", ""));
		}else{
			edit.putString(task.get(taskLevel + 1), "");
			edit.putString(task.get(taskLevel + 1) + "Prority", "");
		}
		
		edit.putString(task.get(2), "");
		edit.putString(task.get(2) + "Prority", "");
		
		Log.i("count", Integer.toString(count)); 
		edit.putInt(ConstantUtil.TASK_COUNT, count < 1 ? 0 : count - 1);  
		edit.commit();
		getTeamDream();
	}
	
	private OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			
			Map<String, Object> level = getDreamAndTaskLevel(view);
			String dreamLevel = (String) level.get(ConstantUtil.DREAM_LEVEL);  
			int taskLevel = (Integer) level.get(ConstantUtil.TASK_LEVEL); 
			if(dreamLevel != null && !dreamLevel.isEmpty()){
				goTaskAdd(dreamLevel, taskLevel);
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teamcreate);
		
		teamNameTv = (EditText) findViewById(R.id.et_teamcreate_teamname);
		firListOne = (TextView) findViewById(R.id.tv_teamcreate_firlistone); 
		firListTwo = (TextView) findViewById(R.id.tv_teamcreate_firlisttwo);
		firListThree = (TextView) findViewById(R.id.tv_teamcreate_firlistthree);

		milListOne = (TextView) findViewById(R.id.tv_teamcreate_midlistone);
		milListTwo = (TextView) findViewById(R.id.tv_teamcreate_midlisttwo);
		milListThree = (TextView) findViewById(R.id.tv_teamcreate_midlistthree);

		terListOne = (TextView) findViewById(R.id.tv_teamcreate_terlistone);
		terListTwo = (TextView) findViewById(R.id.tv_teamcreate_terlisttwo);
		terListThree = (TextView) findViewById(R.id.tv_teamcreate_terlistthree);
		
		firstDream = (EditText) findViewById(R.id.et_teamcreate_firstdream);
		middleDream = (EditText) findViewById(R.id.et_teamcreate_middledream);
		terminalDream = (EditText) findViewById(R.id.et_teamcreate_terminaldream);
		
		firstDreamTask = (Button) findViewById(R.id.bt_teamcreate_firtaskadd);
		middleDreamTask = (Button) findViewById(R.id.bt_teamcreate_midtaskadd);
		terminalDreamTask = (Button) findViewById(R.id.bt_teamcreate_tertaskadd);
		
		chooseMate = (Button) findViewById(R.id.bt_teamcreate_teammatechoose);
		Button chooseLogo = (Button) findViewById(R.id.bt_teamcreate_logochoose);
		
		Intent intent = getIntent();
		String teamDream = intent.getStringExtra(ConstantUtil.TEAM_DREAM);
		
		if(teamDream != null){
			teamNameTv.setText(teamDream);
			getTeamDream();
		}
		firstDreamTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTaskAdd(ConstantUtil.TEAM_FIRST_LEVEL);
			}
		});
		
		middleDreamTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTaskAdd(ConstantUtil.TEAM_MIDDLE_LEVEL);
			}
		});
		
		terminalDreamTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTaskAdd(ConstantUtil.TEAM_TERMINAL_LEVEL);
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
		setTaskText(ConstantUtil.TEAM_FIRST_LEVEL, firListOne, firListTwo, firListThree);
		setTaskText(ConstantUtil.TEAM_MIDDLE_LEVEL, milListOne, milListTwo, milListThree);
		setTaskText(ConstantUtil.TEAM_TERMINAL_LEVEL, terListOne, terListTwo, terListThree);
	}
	
	public void setTaskText(String spName, TextView listOne, TextView listTwo, TextView listThree){
		SharedPreferences sp = getApplicationContext().getSharedPreferences(spName, MODE_PRIVATE);
		
		if(!sp.getString(ConstantUtil.TASK_ONE, "").equals("")){
			listOne.setText(TASK + "1");
			setListionEnable(listOne, true);
		}else{
			listOne.setText("");
			setListionEnable(listOne, false);
		}
		
		if(!sp.getString(ConstantUtil.TASK_TWO, "").equals("")){
			listTwo.setText(TASK + "2"); 
			setListionEnable(listTwo, true);
		} else {
			listTwo.setText("");
			setListionEnable(listTwo, false); 
		}
		
		if(!sp.getString(ConstantUtil.TASK_THREE, "").equals("")){
			listThree.setText(TASK + "3");
			setListionEnable(listThree, true);
		} else {
			listThree.setText("");
			setListionEnable(listThree, false); 
		}
		    
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		getTeamDream();
	}
	
	public void goTaskAdd(String dreamLevel){
		goTaskAdd(dreamLevel, -1);
	}
	
	public void goTaskAdd(String dreamLevel, int taskLevel){
		Intent intent = new Intent(this, TeamTaskAddActivity.class);
		intent.putExtra(ConstantUtil.DREAM_LEVEL, dreamLevel);
		intent.putExtra(ConstantUtil.TASK_LEVEL, taskLevel);
		startActivity(intent);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.it_complete_achive:
			goReturn();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void goReturn(){
		saveTeamDream(teamNameTv.getText().toString().trim(), firstDream.getText().toString().trim(),
				middleDream.getText().toString().trim(), terminalDream.getText().toString().trim());
		finish();
	}
}
