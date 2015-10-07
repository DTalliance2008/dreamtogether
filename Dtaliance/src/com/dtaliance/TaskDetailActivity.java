package com.dtaliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.SPUtil;

public class TaskDetailActivity extends Activity{
	
	private final String PRORITY = "Prority";
	private TextView taskName;
	private TextView taskPrority;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taskdetails);
		
		taskName = (TextView) findViewById(R.id.tv_taskdetails_tittlecontent);
		taskPrority = (TextView) findViewById(R.id.et_taskdetails_priorityone);
		
		
		Intent intent = getIntent();
		String title = intent.getStringExtra(ConstantUtil.EXTRA_FIRST);
		String index = intent.getStringExtra(ConstantUtil.EXTRA_SECOND);
		
		setPageDetail(title, index);
		
	}

	private void setPageDetail(String title, String index) {
		taskName.setText(SPUtil.getString(getApplicationContext(), title, index));
		taskPrority.setText(SPUtil.getString(getApplicationContext(), title, index + PRORITY)); 
	}
	

}
