package com.dtaliance;

import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.SPUtil;

public class TeamTaskAddActivity extends CompleteActivity{
	private EditText titleNameEt;
	private EditText taskWeightEt;
	private ListView roleLv;
	private String dreamLevel;
	private int taskLevel;
	private String tag;
	private static final String EDIT = "edit";
	private static final String CREATE = "create";
	@SuppressLint("UseSparseArrays")
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
		
		if(dreamLevel != null && !dreamLevel.isEmpty()){
			if(taskLevel != -1){
				setDetail(dreamLevel, taskLevel);
				tag = EDIT;
			}else{
				SharedPreferences sp = getApplicationContext().getSharedPreferences(dreamLevel, MODE_PRIVATE);
				taskLevel = sp.getInt(ConstantUtil.TASK_COUNT, 0);
				tag = CREATE;
			}
		} else {
			Toast.makeText(getApplicationContext(), "系统错误", Toast.LENGTH_SHORT).show();
			finish();
		}
	}
	
	public void setDetail(String dreamLevel, int taskLevel){
		titleNameEt.setText((String)SPUtil.getString(getApplicationContext(), dreamLevel, task.get(taskLevel)));  
		taskWeightEt.setText((String)SPUtil.getString(getApplicationContext(), dreamLevel, task.get(taskLevel) + "Prority"));  
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
		if(CREATE.equals(tag)){
			edit.putInt(ConstantUtil.TASK_COUNT, taskLevel + 1);
		} 
		
		edit.putString(task.get(taskLevel), titleNameEt.getText().toString().trim());
		edit.putString(task.get(taskLevel) + "Prority", taskWeightEt.getText().toString().trim()); 
		edit.commit();
		finish();
	}

}
