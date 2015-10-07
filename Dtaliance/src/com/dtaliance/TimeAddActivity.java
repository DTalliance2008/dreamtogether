package com.dtaliance;

import java.util.LinkedHashSet;
import java.util.Set;

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
import android.widget.TextView;

import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.SPUtil;
import com.dtaliance.util.SystemTool;

public class TimeAddActivity extends Activity implements OnClickListener{
	
	private final String TIME = "time";
	private final String DAY_COLOR = "dayColor";
	
	private TextView monDayTv;
	private TextView tuesDayTv;
	private TextView wednesDayTv;
	private TextView thursDayTv;
	private TextView fridayTv;
	private TextView saterDayTv;
	private TextView sunDayTv;
	
	private TextView timeTv;
	private EditText titleET;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeadd);
		
		
		titleET = (EditText) findViewById(R.id.et_timeadd_tittlecontent);
		
		//单词
		TextView singleTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatonce);
		//work day
		TextView workDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatworkday);
		//weekend day 
		TextView weekDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatweekday);
		//every day
		TextView everyDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeateveryday);
		
		timeTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatshow);
		
		//monday
		monDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatmonday);
		//Tuesday
		tuesDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeattuesday);
		//Wednesday
		wednesDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatwednesday);
		//ThursdayTv
		thursDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatthursday);
		//Friday
		fridayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatfriday);
		//
		saterDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatsaterday);
		//
		sunDayTv = (TextView) findViewById(R.id.tv_timeadd_timerepeatsunday);
		
		Intent intent = getIntent();
		final String loadTitle = intent.getStringExtra(ConstantUtil.REMIND_TITLE);
		
		if(loadTitle != null){
			getDayTvColor(getApplication(), loadTitle);
			titleET.setText(loadTitle);
		}
		
		monDayTv.setOnClickListener(this);  
		tuesDayTv.setOnClickListener(this);
		wednesDayTv.setOnClickListener(this);
		thursDayTv.setOnClickListener(this);
		fridayTv.setOnClickListener(this);
		saterDayTv.setOnClickListener(this);
		sunDayTv.setOnClickListener(this);
		
		singleTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String colorStr = "0,0,0,0,0,0,0";
				timeTv.setText("单次");
				setDayTvColor(colorStr);
			}
		});
		
		workDayTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String colorStr = "0,1,1,1,1,1,0";
				timeTv.setText("工作日");
				setDayTvColor(colorStr);
			}
		});
		
		everyDayTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String colorStr = "1,1,1,1,1,1,1";
				timeTv.setText("每天");
				setDayTvColor(colorStr);
			}
		});
		
		weekDayTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String colorStr = "1,0,0,0,0,0,1";
				timeTv.setText("周末");
				setDayTvColor(colorStr);
			}
		});
		
//		findViewById(R.id.tv_timeadd_time);
		Button conBt = (Button) findViewById(R.id.bt_timeadd_confirm);
		
		conBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				saveText(titleET.getText().toString().trim(), "time", loadTitle);
				finish();
			}
		});
		
	}
	
	//设置时间颜色，选中为红色（”1“）,不选为蓝色
	public void setDayTvColor(String colorArray){
		String[] array = colorArray.split(",");
		if(array.length == 7){
			monDayTv.setTextColor(getResources().getColor(array[1].equals("1") ? R.color.red : R.color.blue)); 
			tuesDayTv.setTextColor(getResources().getColor(array[2].equals("1") ? R.color.red : R.color.blue));
			wednesDayTv.setTextColor(getResources().getColor(array[3].equals("1") ? R.color.red : R.color.blue));
			thursDayTv.setTextColor(getResources().getColor(array[4].equals("1") ? R.color.red : R.color.blue));
			fridayTv.setTextColor(getResources().getColor(array[5].equals("1") ? R.color.red : R.color.blue));
			saterDayTv.setTextColor(getResources().getColor(array[6].equals("1") ? R.color.red : R.color.blue));
			sunDayTv.setTextColor(getResources().getColor(array[0].equals("1") ? R.color.red : R.color.blue));
		}
	}
	
	//保存的sp提醒时间的数据，然后展示到界面
	public void getDayTvColor(Context context, String title){
		String colorArray =	SPUtil.getString(context, ConstantUtil.TIME_ADD, title + DAY_COLOR);
		setDayTvColor(colorArray);
	}

	//保存时间颜色数据
	public void saveText(String remindTitle, String remindTime, String title){
		Context context = getApplicationContext();
		SharedPreferences sp = context.getSharedPreferences(ConstantUtil.TIME_ADD, MODE_PRIVATE);
		Editor edit = sp.edit();
		
		Set<String> titleSet = sp.getStringSet(ConstantUtil.REMIND_TITLE, new LinkedHashSet<String>());

		if(title != null && !title.equals(remindTitle)){
			edit.remove(title + DAY_COLOR);
			edit.remove(title + TIME);
			titleSet.remove(title);
		}
		
		titleSet.add(remindTitle);
		edit.putStringSet(ConstantUtil.REMIND_TITLE, titleSet);
		
		String colorStr = SystemTool.arrayToString(getDayTvColor());
		edit.putString(remindTitle + DAY_COLOR, colorStr);
		edit.putString(remindTitle + TIME, remindTime);
		edit.commit();
	}
	
	//从界面得到时间颜色数据
	public String[] getDayTvColor(){
		String[] colorArray = new String[7];
		colorArray[1] = monDayTv.getCurrentTextColor() == getResources().getColor(R.color.red) ? "1" : "0";  
		colorArray[2] = tuesDayTv.getCurrentTextColor() == getResources().getColor(R.color.red) ? "1" : "0";
		colorArray[3] = wednesDayTv.getCurrentTextColor() == getResources().getColor(R.color.red) ? "1" : "0";
		colorArray[4] = thursDayTv.getCurrentTextColor() == getResources().getColor(R.color.red) ? "1" : "0";
		colorArray[5] = fridayTv.getCurrentTextColor() == getResources().getColor(R.color.red) ? "1" : "0";
		colorArray[6] = saterDayTv.getCurrentTextColor() == getResources().getColor(R.color.red) ? "1" : "0";
		colorArray[0] = sunDayTv.getCurrentTextColor() == getResources().getColor(R.color.red) ? "1" : "0";
		return colorArray;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) { 
		case R.id.tv_timeadd_timerepeatsunday:
			setDayTvColor(sunDayTv);
			break;
		case R.id.tv_timeadd_timerepeatmonday:
			setDayTvColor(monDayTv);
			break;
			
		case R.id.tv_timeadd_timerepeattuesday:
			setDayTvColor(tuesDayTv);
			break;
		case R.id.tv_timeadd_timerepeatwednesday:
			setDayTvColor(wednesDayTv);
			break;
		case R.id.tv_timeadd_timerepeatthursday:
			setDayTvColor(thursDayTv);
			break;
		case R.id.tv_timeadd_timerepeatfriday:
			setDayTvColor(fridayTv);
			break;
		case R.id.tv_timeadd_timerepeatsaterday:
			setDayTvColor(saterDayTv);
			break;
		default:
			break;
		}
	}
	
	
	//时间选择
	public void setDayTvColor(TextView dayTv){
		dayTv.setTextColor(dayTv.getCurrentTextColor() != getResources().getColor(R.color.blue) ? 
				getResources().getColor(R.color.blue) : getResources().getColor(R.color.red)) ;
		setRepeatText();
	}
	
	//设置repeat的时间选择
	public void setRepeatText(){
		StringBuffer timeStr = new StringBuffer();
		String[] dayTvColor = getDayTvColor();

		timeStr.append(dayTvColor[0].equals("1") ? "周天  " : "");
		timeStr.append(dayTvColor[1].equals("1") ? "周一  " : ""); 
		timeStr.append(dayTvColor[2].equals("1") ? "周二  " : ""); 
		timeStr.append(dayTvColor[3].equals("1") ? "周三  " : ""); 
		timeStr.append(dayTvColor[4].equals("1") ? "周四  " : ""); 
		timeStr.append(dayTvColor[5].equals("1") ? "周五  " : ""); 
		timeStr.append(dayTvColor[6].equals("1") ? "周六"  : ""); 
		
		timeTv.setText(timeStr.toString());
	}
	
}
