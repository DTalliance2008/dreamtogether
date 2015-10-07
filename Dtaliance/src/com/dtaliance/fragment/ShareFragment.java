package com.dtaliance.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.dtaliance.R;

public class ShareFragment extends Fragment{
	
	private ListView listView;
	
	private static final int MSG_SUCCESS = 0;  
    private static final int MSG_FAILURE = 1;  
    private DownDream downDream;
    List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();
    private SimpleAdapter adapter;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_dream, container, false);
		listView = (ListView) view.findViewById(R.id.lv_dream_item);
		
		setListViewItem();
		
		return view;
	}
	
	private void setListViewItem() {
		if(!listItem.isEmpty()){
			listItem.clear();
		}
		downDream = new DownDream();
		downDream.start();
	}

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {  
            case MSG_SUCCESS:  	
    			listView.setAdapter(adapter);
                break;   
            case MSG_FAILURE:    
                Toast.makeText(getActivity(), "word failed", Toast.LENGTH_LONG).show();    
                break;  
            }  
            super.handleMessage(msg); 
		};
	};
	
	
	private class DownDream extends Thread{
		@Override
		public void run() {
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", "早上");
			map.put("context", "hello");
			listItem.add(map); 
//			adapter = new SimpleAdapter(getActivity(), (List<HashMap<String, Object>>) listItem,
//					R.drawable.listview_persist, new String[]{"title", "context"}, 
//					new int[] {R.id.plItemtitle, R.id.plItem});
			adapter = new SimpleAdapter(getActivity(), (List<HashMap<String, Object>>) listItem,
					R.drawable.notelist, new String[]{"title", "context"}, 
					new int[] {R.id.tv_notelist_title1, R.id.tv_notelist_note1});
			Message message = new Message();
			message.what = MSG_SUCCESS;
			handler.sendMessage(message);
		}
	} 
	
	

}
