package com.dtaliance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.SPUtil;

public class TeamTaskActivity extends Activity implements OnClickListener{
	
	private TextView foneCt;
	private TextView ftwoCt;
	private TextView fthreeCt;
	private TextView firstTitle;
	
	private TextView moneCt;
	private TextView mtwoCt;
	private TextView mthreeCt;
	private TextView middleTitle;
	
	private TextView toneCt;
	private TextView ttwoCt;
	private TextView tthreeCt;
	private TextView terminalTitle;
	
	private TextView titleName;
	private String taskTag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teamtask);
		
		findViewById(R.id.tv_teamtask_teamname);
		
		titleName = (TextView) findViewById(R.id.tv_teamtask_teamname);
		
		foneCt = (TextView) findViewById(R.id.tv_teamtask_firstonecontent);
		ftwoCt = (TextView) findViewById(R.id.tv_teamtask_firsttwocontent);
		fthreeCt = (TextView) findViewById(R.id.tv_teamtask_firstthreecontent);
		firstTitle = (TextView) findViewById(R.id.tv_teamtask_firstdreamcontent);
		
		moneCt = (TextView) findViewById(R.id.tv_teamtask_middleonecontent);
		 mtwoCt = (TextView) findViewById(R.id.tv_teamtask_middletwocontent);
		 mthreeCt = (TextView) findViewById(R.id.tv_teamtask_middlethreecontent);
		 middleTitle = (TextView) findViewById(R.id.tv_teamtask_middlecontent);
		
		 toneCt = (TextView) findViewById(R.id.tv_teamtask_terminalonecontent);
		 ttwoCt = (TextView) findViewById(R.id.tv_teamtask_terminaltwocontent);
		 tthreeCt = (TextView) findViewById(R.id.tv_teamtask_terminalthreecontent);
		 terminalTitle = (TextView) findViewById(R.id.tv_teamtask_terminalcontent);
		 
		Intent intent = getIntent();
		taskTag = intent.getStringExtra(ConstantUtil.DREAM_LEVEL);
		setPageDetail(taskTag);
		
		 foneCt.setOnClickListener(this); 
		 ftwoCt.setOnClickListener(this);
		 fthreeCt.setOnClickListener(this);
		 
		 moneCt.setOnClickListener(this);
		 mtwoCt.setOnClickListener(this);
		 mthreeCt.setOnClickListener(this);
		 
		 toneCt.setOnClickListener(this);
		 ttwoCt.setOnClickListener(this);
		 tthreeCt.setOnClickListener(this);
		
	}
	public void setPageDetail(String dreamLevel){
		
		String firstTitleStr = null;
		String midddleTitleStr = null;
		String terminalTitleStr = null;
		String title = null;
		Context context = getApplicationContext();
		
		if(dreamLevel != null && ConstantUtil.TEAM_DREAM.equals(dreamLevel)){
			title = SPUtil.getString(context, ConstantUtil.TEAM_FIRST_LEVEL, ConstantUtil.TEAM_NAME);
			firstTitleStr = SPUtil.getString(context, ConstantUtil.TEAM_FIRST_LEVEL, "title");
			midddleTitleStr = SPUtil.getString(context, ConstantUtil.TEAM_MIDDLE_LEVEL, "title");
			terminalTitleStr = SPUtil.getString(context, ConstantUtil.TEAM_TERMINAL_LEVEL, "title");
		} else {
//			title = SPUtil.getString(context, ConstantUtil.FRIST_LEVEL, "title");
			firstTitleStr = SPUtil.getString(context, ConstantUtil.FRIST_LEVEL, "title");
			getDreamLevel(context, ConstantUtil.FRIST_LEVEL, foneCt, ftwoCt, fthreeCt);
			
			midddleTitleStr = SPUtil.getString(context, ConstantUtil.MIDDLE_LEVEL, "title");
			getDreamLevel(context, ConstantUtil.MIDDLE_LEVEL, moneCt, mtwoCt, mthreeCt);
			
			terminalTitleStr = 	SPUtil.getString(context, ConstantUtil.TERMINAL_LEVEL, "title");
			getDreamLevel(context, ConstantUtil.TERMINAL_LEVEL, toneCt, ttwoCt, tthreeCt);
		}
		
		titleName.setText(title);
		firstTitle.setText(firstTitleStr);
		middleTitle.setText(midddleTitleStr);
		terminalTitle.setText(terminalTitleStr);
		
	}
	
	public void getDreamLevel(Context context, String spName, TextView firstTask, TextView middleTask, TextView terminalTask){
		SharedPreferences sp = context.getSharedPreferences(spName, MODE_PRIVATE);
		firstTask.setText(sp.getString(ConstantUtil.TASK_ONE, ""));
		middleTask.setText(sp.getString("two", ""));
		terminalTask.setText(sp.getString("three", "")); 
	}
	
	@Override
	public void onClick(View view) {
		
		
		String title = null; 
		String index = null;
		switch (view.getId()) {
		case R.id.tv_teamtask_firstonecontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_FIRST_LEVEL : ConstantUtil.FRIST_LEVEL;
			index = ConstantUtil.TASK_ONE;
			break;
		case R.id.tv_teamtask_firsttwocontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_FIRST_LEVEL : ConstantUtil.FRIST_LEVEL;
			index = ConstantUtil.TASK_TWO;
			break;
		case R.id.tv_teamtask_firstthreecontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_FIRST_LEVEL : ConstantUtil.FRIST_LEVEL;
			index = "two";
			break;
			
		case R.id.tv_teamtask_middleonecontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_MIDDLE_LEVEL : ConstantUtil.MIDDLE_LEVEL;
			index = ConstantUtil.TASK_ONE;
			break;
		case R.id.tv_teamtask_middletwocontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_MIDDLE_LEVEL : ConstantUtil.MIDDLE_LEVEL;
			index = "two";
			break;
		case R.id.tv_teamtask_middlethreecontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_MIDDLE_LEVEL : ConstantUtil.MIDDLE_LEVEL;
			index = "three";
			break;
			
		case R.id.tv_teamtask_terminalonecontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_TERMINAL_LEVEL : ConstantUtil.TERMINAL_LEVEL;
			index = ConstantUtil.TASK_ONE;
			break;
			
		case R.id.tv_teamtask_terminaltwocontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_TERMINAL_LEVEL : ConstantUtil.TERMINAL_LEVEL;
			index = "two";
			break;
		case R.id.tv_teamtask_terminalthreecontent:
			title = ConstantUtil.TEAM_DREAM.equals(taskTag) ? ConstantUtil.TEAM_TERMINAL_LEVEL : ConstantUtil.TERMINAL_LEVEL;
			index = "three";
			break;
		default:
			break;
		}
		
		goTaskDetail(title, index);
	}
	
	public void goTaskDetail(String title, String index){
		Intent intent = new Intent(this, TaskDetailActivity.class);
		//等级
		intent.putExtra(ConstantUtil.EXTRA_FIRST, title);
		intent.putExtra(ConstantUtil.EXTRA_SECOND, index);
		startActivity(intent);
		
	}

}
