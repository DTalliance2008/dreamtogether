package com.dtaliance;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.dtaliance.file.StoreFileToSD;
import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.TimeUtil;

public class OutputNoteActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notedisplay);
		TextView titleNote = (TextView) findViewById(R.id.tv_notedisplay_tittle);
		TextView contentNote = (TextView) findViewById(R.id.tv_notedisplay_note);
		
		TextView timeNote = (TextView) findViewById(R.id.tv_notedisplay_time);
		
		Intent intent = getIntent();
		String fileName = intent.getExtras().getString("filename");
		
		StoreFileToSD storeFileToSD = new StoreFileToSD();
		String readSD = storeFileToSD.readSD(ConstantUtil.SD_PATH + fileName);
		Log.i("readSD", readSD);
		String[] array = TimeUtil.getFileName(fileName);
		titleNote.setText(array[0]);
		if(array.length > 1){
			timeNote.setText(array[1]);
		}
		contentNote.setText(readSD);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
			goYiqikao();
		}
		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.outputnote, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) { 
		case R.id.optnoteitem:
			goYiqikao();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public String ReadFile(String path){
		String content = null;
		try{
			FileInputStream inStream = this.openFileInput(path);
//			File file = new File(path);
//			FileInputStream inStream = new FileInputStream(file);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = inStream.read(buffer)) != -1){
				byteStream.write(buffer, 0, len);
			}
			content = byteStream.toString();
			byteStream.close();
			inStream.close();
		} catch(Exception e ){
			e.printStackTrace();
		} 
		return content;
		
	}
	
	public void goYiqikao(){
//		Intent intent = new Intent(this, DTActivity.class);
//		startActivity(intent);
		finish();
	}

}
