package com.dtaliance;

import com.dtaliance.util.ConstantUtil;
import com.dtaliance.util.SPUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DreamTreeActivity extends Activity{
	
	private Button firstDream;
	private Button middleDream;
	private Button terminalDream;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dreamtree);
		firstDream = (Button) findViewById(R.id.bt_dreamtree_first);
		
		middleDream = (Button) findViewById(R.id.bt_dreamtree_middle);
		terminalDream = (Button) findViewById(R.id.bt_dreamtree_terminal);
		
		firstDream.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTask(ConstantUtil.FRIST_LEVEL);
			}
		});
		
		middleDream.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTask(ConstantUtil.MIDDLE_LEVEL);
			}
		});
		
		terminalDream.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTask(ConstantUtil.TERMINAL_LEVEL);
			}
		});
	}
	
	public void goTask(String level){
		Intent intent = new Intent(this, TaskActivity.class);
		intent.putExtra(ConstantUtil.DREAM_LEVEL, level);
		startActivity(intent);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		firstDream.setText(ConstantUtil.FRIST_TITLE + ": " +  SPUtil.getDreamTitle(this, ConstantUtil.FRIST_LEVEL));
		middleDream.setText(ConstantUtil.MIDDLE_TITLE +":" + SPUtil.getDreamTitle(this, ConstantUtil.MIDDLE_LEVEL));
		terminalDream.setText(ConstantUtil.TERMINAL_TITLE + ":"+
					SPUtil.getDreamTitle(this, ConstantUtil.TERMINAL_LEVEL));
		
	}

}
