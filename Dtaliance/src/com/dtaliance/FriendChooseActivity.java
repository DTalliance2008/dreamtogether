package com.dtaliance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.SimpleAdapter;

import com.dtaliance.util.ConstantUtil;

@SuppressLint("ClickableViewAccessibility")
public class FriendChooseActivity extends Activity {
	private SearchView searchView;
	private ListView listView;
	private SimpleAdapter adapter;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.complete, menu);
		// MenuItem searchItem = menu.findItem(R.id.it_co_search);
		// SearchView searchView1 = (SearchView)
		// MenuItemCompat.getActionView(searchItem);
		// searchView1.setIconified(true); //to be opened collapsed
		// MenuItem itemSearch = menu.findItem(R.id.it_co_search);
		// searchView = (SearchView) MenuItemCompat.getActionView(itemSearch);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_friendchoose);
		
		listView = (ListView) findViewById(R.id.lv_friendchoose_list);

		searchView = (SearchView) findViewById(R.id.sv_friendchoose_search);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				String[] arrayName = new String[]{"jack", "pit", "ted"};
				Log.i("click", arrayName[arg2]);
				save(arrayName[arg2]);
				finish();
			}
		});
		
		searchView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				return false;
			}
		});

		searchView.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String arg0) {
				Log.i("query", arg0);
				List<String> a = new ArrayList<String>();
				a.add("jack");
				a.add("pit");
				a.add("ted");
				List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
				for (String str : a) {
					HashMap<String, Object> a1 = new HashMap<String, Object>();
					a1.put("userName", str);
					list.add(a1);
				}

				adapter = new SimpleAdapter(getApplicationContext(),
						(List<HashMap<String, Object>>) list,
						R.drawable.friendlist, new String[] { "userName" },
						new int[] { R.id.tv_friendlist_name });
				listView.setAdapter(adapter);
				return false;
			}

			@Override
			public boolean onQueryTextChange(String arg0) {
				// TODO Auto-generated method stub
				Log.i("queryText", arg0);
				return false;
			}
		});

	}

	public String getAcitivty() {
		Intent intent = getIntent();
		return intent.getStringExtra(ConstantUtil.ACTIVITY);
	}

	private class FriendSearchBackground extends AsyncTaskWithProgressDialog {

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
			List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
			for (String str : a) {
				HashMap<String, Object> a1 = new HashMap<String, Object>();
				a1.put("userName", str);
				list.add(a1);
			}

			adapter = new SimpleAdapter(getApplicationContext(),
					(List<HashMap<String, Object>>) list,
					R.drawable.friendlist, new String[] { "userName" },
					new int[] { R.id.tv_friendlist_name });
			return ConstantUtil.SUCCESS;
		}
	}
	
	public void save(String leaguer){
		if(ConstantUtil.LAUCHVSACTIVITY.equals(getAcitivty())){
			saveLeaguer(ConstantUtil.USER_INFO, ConstantUtil.USER_LEAGUER, leaguer);
		}else{
			saveLeaguer(ConstantUtil.TEAM_INFO, ConstantUtil.TEAM_LEAGUER, leaguer);
		}
	}
	
	public void saveLeaguer(String spName, String key, String leaguer){
		SharedPreferences sp = getApplicationContext().getSharedPreferences(spName, MODE_PRIVATE);
		
		Set<String> teamLeaguer = sp.getStringSet(key, new LinkedHashSet<String>());
		Editor edit = sp.edit();
		teamLeaguer.add(leaguer);
		edit.putStringSet(key, teamLeaguer); 
		edit.commit();
	}

}
