package com.dtaliance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dtaliance.util.ConstantUtil;

public class FriendChooseActivity extends Activity{
	
	private SearchView searchView;
	private ListView listView;
	private SimpleAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_friendchoose);
		listView = (ListView) findViewById(R.id.lv_friendchoose_list);
		
		searchView.setOnSearchClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new FriendSearchBackground(getApplication()).execute();
			}
		});
	}
	
	private class FriendSearchBackground extends AsyncTaskWithProgressDialog{

		public FriendSearchBackground(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@Override
		protected void onPostExecute2(String result) {
			listView.setAdapter(adapter);
		}

		@Override
		protected String doInBackground2(String... params) {
			
			List<String> a = new ArrayList<String>();
			a.add("jack");
			a.add("pit");
			a.add("ted");
			List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
			for(String str : a){
				HashMap<String, Object> a1 = new HashMap<String, Object>();
				a1.put("userName", str);
				list.add(a1);
			}
			
			adapter = new SimpleAdapter(getApplicationContext(), (List<HashMap<String, Object>>)list,
					R.drawable.friendlist, new String[]{"userName"}, new int[]{R.id.tv_friendlist_name});
			return ConstantUtil.SUCCESS;
		}
		
	}

}
