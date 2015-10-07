package com.dtaliance.fragment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.dtaliance.OpenVideoActivity;
import com.dtaliance.R;
import com.dtaliance.db.RemindData;
import com.dtaliance.jsonObject.entry.Remind;
import com.dtaliance.util.DBUtil;


public class PersistFragment extends Fragment{
	
	private ListView listView;
	private static final int MSG_SUCCESS = 0;  
    private static final int MSG_FAILURE = 1;  
    private LoadData loadData;
    List<HashMap<String, Object>> listItem = new LinkedList<HashMap<String,Object>>();
    
    private SimpleAdapter adapter;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_persist, container, false);
		listView = (ListView) view.findViewById(R.id.lv_persist);
		if(listItem != null){
			listItem.clear();
		}
		loadData = new LoadData();
		loadData.start(); 
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.i("click", Integer.toString(arg2));
				Log.i("click", Long.toString(arg3));
				Log.i("click", (String) listItem.get(arg2).get("title"));
				String url = (String) listItem.get(arg2).get("url");
				if(url != null){
					goVideo(url);
				}else{
					Toast.makeText(getActivity(), "不能打开文字", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		return view;
	}
	
	public void goVideo(String url){
//		url = "http://www.xiami.com/play?ids=/song/playlist/id/1772084442/object_name/default/object_id/0#open";
		Intent intent = new Intent(getActivity(), OpenVideoActivity.class);
		intent.putExtra("openurl", url);
		startActivity(intent);
	}
	
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler(){
		
		@Override  
        public void handleMessage(Message msg) {  
            switch (msg.what) {  
            case MSG_SUCCESS:  	
    			
    			listView.setAdapter(adapter);
//                Toast.makeText(getActivity(), "word success", Toast.LENGTH_LONG).show();    
                break;   
  
            case MSG_FAILURE:    
                Toast.makeText(getActivity(), "word failed", Toast.LENGTH_LONG).show();    
                break;  
            }  
            super.handleMessage(msg);  
        }  
	};
	
	private class LoadData extends Thread{
		
		public void run(){
			
			DBUtil.getDataBasePath(getActivity());
			
			RemindData persistWord = new RemindData(getActivity());
			LinkedList<Remind> selectData = (LinkedList<Remind>) persistWord.selectPersistData("20", "30");
			for(int i=0; i<selectData.size(); i++){
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("title", selectData.get(i).getTitle());
				map.put("context", selectData.get(i).getType());
				map.put("type", selectData.get(i).getType());
				map.put("url", selectData.get(i).getUrl());
				listItem.add(map); 
			}
			
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
