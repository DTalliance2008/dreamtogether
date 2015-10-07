package com.dtaliance;

import com.dtaliance.Model.Task;
import com.dtaliance.util.ConstantUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TaskActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
		final EditText titleET = (EditText) findViewById(R.id.et_task_tittlecontent);
		final EditText oneET = (EditText) findViewById(R.id.et_task_one);
		final EditText priorityOneET = (EditText) findViewById(R.id.et_task_priorityone);
		final EditText twoET = (EditText) findViewById(R.id.et_task_two);
		final EditText priorityTwoET = (EditText) findViewById(R.id.et_task_prioritytwo);
		final EditText threeET = (EditText) findViewById(R.id.et_task_three);
		final EditText priorityThreET = (EditText) findViewById(R.id.et_task_prioritythree);
		
		Intent intent = getIntent();
		final String dreamLevel = intent.getExtras().getString(ConstantUtil.DREAM_LEVEL);

		Button confirm = (Button) findViewById(R.id.bt_task_confirm);
		
		final Task task = new Task();
		task.setDreamLevel(dreamLevel);
		
		getTask(task);
		
		titleET.setText(task.getTitle());
		oneET.setText(task.getOne());
		priorityOneET.setText(task.getPriorityOne());
		twoET.setText(task.getTwo());
		priorityTwoET.setText(task.getPriorityTwo());
		threeET.setText(task.getThree());
		priorityThreET.setText(task.getPriorityThree());
		
		confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				task.setDreamLevel(dreamLevel);
				task.setTitle(titleET.getText().toString());
				task.setOne(oneET.getText().toString());
				task.setPriorityOne(priorityOneET.getText().toString());
				task.setTwo(twoET.getText().toString());
				task.setPriorityTwo(priorityTwoET.getText().toString());
				task.setThree(threeET.getText().toString());
				task.setPriorityThree(priorityThreET.getText().toString());
				saveTask(task);
				finish();
			}
		});
		
	}
	
	public void saveTask(Task task){
		Context ctx = TaskActivity.this;
		SharedPreferences sp = ctx.getSharedPreferences(task.getDreamLevel(), MODE_PRIVATE);
		Editor editor = sp.edit();
		
		editor.putString("title", task.getTitle());
		editor.putString(ConstantUtil.TASK_ONE, task.getOne());
		editor.putString(ConstantUtil.TASK_ONE_PRORITY, task.getPriorityOne());
		editor.putString(ConstantUtil.TASK_TWO, task.getTwo());
		editor.putString(ConstantUtil.TASK_TWO_PRORITY, task.getPriorityTwo());
		editor.putString(ConstantUtil.TASK_THREE, task.getThree());
		editor.putString(ConstantUtil.TASK_THREE_PRORITY, task.getPriorityThree());
		editor.commit();
	}
	
	public void getTask(Task task){
		Context ctx = TaskActivity.this;
		SharedPreferences sp = ctx.getSharedPreferences(task.getDreamLevel(), MODE_PRIVATE);
		
		task.setTitle(sp.getString("title", ""));
		task.setOne(sp.getString(ConstantUtil.TASK_ONE, ""));
		task.setPriorityOne(sp.getString(ConstantUtil.TASK_ONE_PRORITY, ""));
		task.setTwo(sp.getString(ConstantUtil.TASK_TWO, ""));
		task.setPriorityTwo(sp.getString(ConstantUtil.TASK_TWO_PRORITY, ""));
		task.setThree(sp.getString(ConstantUtil.TASK_THREE, ""));
		task.setPriorityThree(sp.getString(ConstantUtil.TASK_THREE_PRORITY, ""));
	}
	
}
