package com.dtaliance;

import java.util.HashMap;

import com.dtaliance.util.ConstantUtil;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

public class TeamTaskAddActivity extends CompleteActivity{
	private EditText titleNameEt;
	private EditText taskWeightEt;
	private ListView roleLv;
	private String dreamLevel;
	private int taskLevel;
	private HashMap<Integer, String> task = new HashMap<Integer, String>();
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teamtaskadd);
		
		init();
	}
	
	public void init(){
		titleNameEt = (EditText) findViewById(R.id.et_teamtaskadd_tittlecontent);
		taskWeightEt = (EditText) findViewById(R.id.et_teamtaskadd_priorityone);
		roleLv = (ListView) findViewById(R.id.lv_teamtaskadd_roleadd);
		
		Bundle extras = getIntent().getExtras();
		dreamLevel = extras.getString(ConstantUtil.DREAM_LEVEL);
		taskLevel = extras.getInt(ConstantUtil.TASK_LEVEL);
		
		task.put(0, "one");
		task.put(1, "two");
		task.put(2, "three");
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
		SharedPreferences sp = getApplicationContext().getSharedPreferences(dreamLevel, MODE_PRIVATE);
		Editor edit = sp.edit();
		edit.putInt(ConstantUtil.TASK_COUNT, taskLevel);
		edit.putString(task.get(taskLevel), titleNameEt.getText().toString().trim());
		edit.putString(task.get(taskLevel) + "Prority", taskWeightEt.getText().toString().trim()); 
		edit.commit();
		finish();
	}

}
