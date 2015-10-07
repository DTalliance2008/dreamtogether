package com.dtaliance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dtaliance.db.ShareData;
import com.dtaliance.jsonObject.entry.ShareDream;
import com.dtaliance.sevice.DreamService;
import com.dtaliance.util.UserApplication;

public class ShareActivity extends Activity{
	private static final int COMPLETE = 0;
	
	private DreamService dreamService;
	private ShareData shareData;
	private ListView share;
	private Button write;
	private List<Map<String, Object>> arry;
	private UserApplication user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share);
		
		share = (ListView) findViewById(R.id.lv_share_show);
		write = (Button) findViewById(R.id.bt_share_write);
		user = (UserApplication) getApplication();
		
		dreamService = new DreamService(getApplication());
		shareData = new ShareData(getApplication());
		
		arry = new ArrayList<Map<String,Object>>();
		
//		new downloadThread().start();
//		for(int i=0; i<3; i++){
//			Map<String, Object> eachItem = new HashMap<String, Object>();
//			eachItem.put("username", "word" + i);
//			eachItem.put("content", "content" + i);
//			arry.add(eachItem);
//		}
//		
//		SimpleAdapter adapter = new SimpleAdapter(ShareActivity.this, (List<Map<String, Object>>)arry, R.drawable.sharelist,
//				new String[] {"username", "content"},
//				new int[] {R.id.tv_sharelist_username, R.id.tv_sharelist_content});
//		share.setAdapter(adapter);
		
		write.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goWrite();
			}
		});
	}
	
	private class downloadThread extends Thread{

		@Override
		public void run() {
			if("success".equals(dreamService.getAllShare("nihao"))){
				Message message = new Message();
				message.what = COMPLETE;
				handler.sendMessage(message);
			};
			
		}
		
	}
	
	private Handler handler = new Handler(){
		
		@Override
		public void handleMessage(Message msg) {
			if(msg.what == COMPLETE){
//				List<ShareDream> listContent= user.getDreamList();
				List<ShareDream> listContent= shareData.selectAll();
				for(int i=0; i<listContent.size(); i++){
					Map<String, Object> eachItem = new HashMap<String, Object>();
					eachItem.put("username", listContent.get(i).getUserName());
					eachItem.put("content", listContent.get(i).getShareContent());
					arry.add(eachItem);
				}
				SimpleAdapter adapter = new SimpleAdapter(ShareActivity.this, (List<Map<String, Object>>)arry, R.drawable.sharelist,
						new String[] {"username", "content"},
						new int[] {R.id.tv_sharelist_username, R.id.tv_sharelist_content});
				share.setAdapter(adapter);
			}
			
		};
	};
	
	public void goWrite(){
		Intent intent = new Intent(this, WriteDreamActivity.class);
		startActivity(intent);
		finish();
	}

}
