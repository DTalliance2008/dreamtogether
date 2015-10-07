package com.dtaliance;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.dtaliance.file.StoreFileToSD;

@SuppressLint("WorldReadableFiles")
public class WriteNoteActivity extends Activity {
	
	private EditText titleNote;
	private EditText editNote;
	private String fileName;
	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_writenote);
		titleNote = (EditText) findViewById(R.id.bt_notewrite_title);
		editNote = (EditText) findViewById(R.id.et_notewrite_note);
		SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());
		fileName = dateTime.format(curDate);
//		Log.d("testStr",fileName);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.writeNoteComp:
			goNote();
			return true;
		case R.id.writeNoteQuit:
			goNoteGiveUp();
			return true;
		default :
			return super.onOptionsItemSelected(item);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.writenote, menu);
		return true;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override 
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode ==KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
			AlertDialog isExit = new AlertDialog.Builder(this).create();
			isExit.setTitle("操作");
			isExit.setButton("放弃退出", listener);
			isExit.setButton2("保存", listener);
			isExit.setButton3("取消", listener);
			isExit.show();
		}
		return false;
	}
	
	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			switch(arg1){
				case AlertDialog.BUTTON_POSITIVE:
					goNoteGiveUp();
					break;
				case AlertDialog.BUTTON_NEGATIVE:
					goNote();
					break;
				case AlertDialog.BUTTON3:
					Log.d("test","goNote");
					break;
				default:
					break;
			}
		}		
		
	};
	
	public void goNote(){
		
//			File file = new File(fileName);
//			FileOutputStream outStream = this.openFileOutput(fileName, MODE_WORLD_READABLE);
//			outStream.write(testStr.getBytes());
//			outStream.close();
		String title = titleNote.getText().toString().trim();
		
		if(title == null || title.isEmpty()){
			return;
		}
		
		
		String titleFile = titleNote.getText().toString().trim() + "@" + fileName;
		String contentStr = editNote.getText().toString().trim();
	
		StoreFileToSD storeFileToSD =  new StoreFileToSD();
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			storeFileToSD.writeFileToSD(titleFile, contentStr);
		}
			
		Intent intent = new Intent(this, DTActivity.class);
		startActivity(intent);
		finish();
	}
	
	public void goNoteGiveUp(){
		Intent intent = new Intent(this, DTActivity.class);
		startActivity(intent);
		finish();
	}
}

