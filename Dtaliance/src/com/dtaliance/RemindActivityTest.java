//package com.dtaliance;
//
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.app.AlarmManager;
//import android.app.Dialog;
//import android.app.PendingIntent;
//import android.app.TimePickerDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.SystemClock;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.TimePicker;
//import android.widget.Toast;
//
//import com.dtaliance.receiver.EveningReceiver;
//import com.dtaliance.receiver.MidayReceiver;
//import com.dtaliance.receiver.MorningReceiver;
//
//public class RemindActivityTest extends Activity{
//
//	private long selMorningTime = 0;
//	private long selMidayTime = 0;
//	private long selEveningTime = 0;
//	private Calendar calendar;
//	private Date date;
//	private TextView textMorning;
//	private TextView textMiday;
//	private TextView textEvening;
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_remind);
//		date = new Date();
//		calendar = Calendar.getInstance();
//		textMorning = (TextView) findViewById(R.id.textMoring);
//		textMiday = (TextView) findViewById(R.id.textMiday);
//		textEvening = (TextView) findViewById(R.id.textEvening);
//		textMorning.setText("00:00");
//		textMiday.setText("00:00");
//		textEvening.setText("00:00");
//		Button morningbt = (Button) findViewById(R.id.morningTime);
//		Button midaybt = (Button) findViewById(R.id.midayTime);
//		Button eveningbt = (Button) findViewById(R.id.eveningTime);
//		Button startRemind = (Button) findViewById(R.id.startRemind);
//		Button exitRemind = (Button) findViewById(R.id.exitRemind);
//		
//		morningbt.setOnClickListener(new OnClickListener(){
//			@SuppressWarnings("deprecation")
//			@Override
//			public void onClick(View arg0) {
//				showDialog(0);
//			}
//		});
//		
//		midaybt.setOnClickListener(new OnClickListener(){
//			@SuppressWarnings("deprecation")
//			@Override
//			public void onClick(View arg0) {
//				showDialog(1);
//			}
//		});
//		
//		eveningbt.setOnClickListener(new OnClickListener(){
//			@SuppressWarnings("deprecation")
//			@Override
//			public void onClick(View arg0) {
//				showDialog(2);
//			}
//		});
//		
//		startRemind.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View arg0) {
//				
//				if(startRemind(selMorningTime, 0)){
//					Log.d("Morning right it", "right it");
//					Toast.makeText(RemindActivity.this, "����ʱ�����óɹ�", Toast.LENGTH_SHORT).show();
//				} else {
//					Log.d("Morning error","Morning error");
//				}
//				
//				if(startRemind(selMidayTime, 1)){
//					Log.d("Miday right it", "right it");
//					Toast.makeText(RemindActivity.this, "����ʱ�����óɹ�", Toast.LENGTH_SHORT).show();
//				} else {
//					Log.d("Miday error","Miday error");
//				}
//				
//				if(startRemind(selEveningTime, 2)){
//					Log.d("Evening right it", "right it");
//					Toast.makeText(RemindActivity.this, "����ʱ�����óɹ�", Toast.LENGTH_SHORT).show();
//				} else {
//					Log.d("Evening error","Morning error");
//				}
//			}
//			
//		});
//		
//		exitRemind.setOnClickListener(new OnClickListener(){
//			@Override
//			public void onClick(View v) {
//				
//				Intent intent = new Intent(RemindActivity.this, MorningReceiver.class);
//	            PendingIntent sender = PendingIntent.getBroadcast(RemindActivity.this,
//	                    0, intent, 0);
//	            
//	            AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
//	            am.cancel(sender);
//	            Toast.makeText(RemindActivity.this, "�ɹ�", Toast.LENGTH_SHORT).show();
//			}
//		});
//	}
//	
//	@SuppressLint("SimpleDateFormat")
//	@Override
//	public Dialog onCreateDialog(int id){
//		Dialog dialog = null;
//		calendar = Calendar.getInstance();
//		switch(id){
//		case 0:
//			dialog = new TimePickerDialog(this, 
//					new TimePickerDialog.OnTimeSetListener() {
//						
//						@SuppressLint("SimpleDateFormat")
//						@Override
//						public void onTimeSet(TimePicker arg0, int hour, int min) {
//							textMorning.setText(Integer.toString(hour)+":"+Integer.toString(min));
//							int year = calendar.get(Calendar.YEAR);
//							int month = calendar.get(Calendar.MONTH)+1;
//							int day = calendar.get(Calendar.DAY_OF_MONTH);
//							String timeStr = Integer.toString(year) + '-' +
//										Integer.toString(month) + '-' +
//										Integer.toString(day) + '-' +
//										Integer.toString(hour) + '-' +
//										Integer.toString(min) + '-' + "00";
//							SimpleDateFormat selMorning = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
//							try {
//								date = selMorning.parse(timeStr);
//								selMorningTime = date.getTime();
//								SimpleDateFormat dateMor = new SimpleDateFormat("hh:mm");
//								Date seldateMorning = new Date(selMorningTime);
//								Log.d("date", dateMor.format(seldateMorning));
//								textMorning.setText(dateMor.format(seldateMorning));
//							} catch (ParseException e) {
//								e.printStackTrace();
//								Log.d("error","error");
//							}
//							
//						}
//					},
//					calendar.get(Calendar.HOUR_OF_DAY),
//					calendar.get(Calendar.MINUTE),
//					true);
//			break;
//		case 1:
//			dialog = new TimePickerDialog(this, 
//					new TimePickerDialog.OnTimeSetListener() {
//						
//						@Override
//						public void onTimeSet(TimePicker arg0, int hour, int min) {
//							textMiday.setText(Integer.toString(hour)+":"+Integer.toString(min));
//							int year = calendar.get(Calendar.YEAR);
//							int month = calendar.get(Calendar.MONTH)+1;
//							int day = calendar.get(Calendar.DAY_OF_MONTH);
//							String timeStr = Integer.toString(year) + '-' + 
//									Integer.toString(month) + '-' + 
//									Integer.toString(day) + '-' + 
//									Integer.toString(hour) + '-' + 
//									Integer.toString(min) + '-' + "00";
//							Log.d("timestr",timeStr);
//							SimpleDateFormat selMiday = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
//							try {
//								date = selMiday.parse(timeStr);
//								selMidayTime = date.getTime();
//								SimpleDateFormat dateMid = new SimpleDateFormat("hh:mm");
//								Date seldateMiday = new Date(selMidayTime);
//								Log.d("date", dateMid.format(seldateMiday));
//								textMiday.setText(dateMid.format(seldateMiday));
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					},
//					calendar.get(Calendar.HOUR_OF_DAY),
//					calendar.get(Calendar.MINUTE),
//					true);
//			break;
//		case 2:
//			dialog = new TimePickerDialog(this, 
//					new TimePickerDialog.OnTimeSetListener() {
//						@Override
//						public void onTimeSet(TimePicker arg0, int hour, int min) {
//							textEvening.setText(Integer.toString(hour)+":"+Integer.toString(min));
//							int year = calendar.get(Calendar.YEAR);
//							int month = calendar.get(Calendar.MONTH)+1;
//							int day = calendar.get(Calendar.DAY_OF_MONTH);
//							String timeStr = Integer.toString(year) + '-' + 
//									Integer.toString(month) + '-' + 
//									Integer.toString(day) + '-' + 
//									Integer.toString(hour) + '-' + 
//									Integer.toString(min) + '-' + "00";
//							Log.d("timestr",timeStr);
//							SimpleDateFormat selEvening = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
//							try {
//								date = selEvening.parse(timeStr);
//								selEveningTime = date.getTime();
//								SimpleDateFormat dateEven = new SimpleDateFormat("hh:mm");
//								Date seldateEvening = new Date(selEveningTime);
//								Log.d("date", dateEven.format(seldateEvening));
//								textEvening.setText(dateEven.format(seldateEvening));
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//							
//						}
//					},
//					calendar.get(Calendar.HOUR_OF_DAY),
//					calendar.get(Calendar.MINUTE),
//					true);
//			break;
//		default :
//			break;
//		}
//		return dialog;
//	}
//	
//	public boolean startRemind(long selectedTime, int id){
//		long sysTime = System.currentTimeMillis();
//		if(selectedTime < sysTime) {
//			selectedTime +=24*3600*1000;
//			Log.d("right<","<");
//		}
//		Log.d("right","time:"+selectedTime);
//		
//		Log.d("right",Integer.toString(id)+":"+(selectedTime-sysTime)); 
//		long triTime = selectedTime-sysTime+SystemClock.elapsedRealtime();
//		Log.d("right","time:"+triTime);
//		
//		Intent intent = new Intent();
//		switch(id) {
//		case 0:
//			intent.setClass(RemindActivity.this, MorningReceiver.class);
//			Log.d("right 0","right 0");
//			break;
//		case 1: 
//			intent.setClass(RemindActivity.this, MidayReceiver.class);
//			Log.d("right 1","right 1");
//			break;
//		case 2:
//			intent.setClass(RemindActivity.this, EveningReceiver.class);
//			Log.d("right 2","right 2");
//			break;
//		default :
//			return false;
//		}
//		
//		PendingIntent sender = PendingIntent.getBroadcast(RemindActivity.this, 0, intent, 0);
//		AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
//		manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//				triTime, 24*100*10*3600, sender);
//		return true;
//	}
//	
//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event){
//		if(keyCode == KeyEvent.KEYCODE_BACK){
//			Log.d("code","code");
//			goMain();
//		}
//		return false;
//	}
//	
//	public void goMain(){
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
//		finish();
//	}
//}
