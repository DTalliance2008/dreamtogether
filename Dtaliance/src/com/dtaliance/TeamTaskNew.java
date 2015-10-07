package com.dtaliance;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class TeamTaskNew extends Activity{
	
	private EditText title;
	private EditText taskWight;
	private ListView roleLv;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teamtaskadd);
		
		init();
		
		roleLv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			}
		});
	}

	private void init() {
		title = (EditText) findViewById(R.id.et_teamtaskadd_tittlecontent);
		taskWight = (EditText) findViewById(R.id.et_teamtaskadd_priorityone);
		roleLv = (ListView) findViewById(R.id.lv_teamtaskadd_roleadd);
	}
	
	 @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.complete, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.it_complete_achive:
			
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void save(){
		
	}
}
