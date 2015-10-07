package com.dtaliance;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.dtaliance.util.UserApplication;

public class WordActivity extends Activity{

	private ListView wordLV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word);
		UserApplication user = (UserApplication) getApplication();
		Log.d("icon", user.getUserName());
		
		wordLV = (ListView) findViewById(R.id.lv_word);
	}
	
}
