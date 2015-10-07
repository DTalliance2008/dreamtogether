package com.dtaliance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.dtaliance.adapter.MyAdapter;
import com.dtaliance.db.PersistWord;
import com.dtaliance.jsonObject.entry.Remind;

public class CreateDreamActivity extends Activity{

	private ListView createDreamLV;
	private List<HashMap<String, Object>> mListItem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_dream);
		
		
		createDreamLV = (ListView) findViewById(R.id.lv_create_dream_saying);
		
		 mListItem = new ArrayList<HashMap<String, Object>>();
		 
		 //从数据库中读数据
		 PersistWord persistWord = new PersistWord(getApplicationContext());
		 List<Remind> reminds = new ArrayList<Remind>();
		 
		 SharedPreferences preferences = this.getSharedPreferences("dream", MODE_PRIVATE);
		 Editor editor = preferences.edit();
		 int count = preferences.getInt("count", 0);
		 int nowPosition = preferences.getInt("nowPosition", 0);
		 
		 if(count != 0){
			 if(nowPosition != 0 && nowPosition+1 < persistWord.countData()){
				 reminds.addAll(persistWord.selectPersistData("1", Integer.toString(nowPosition + 1)));
				 editor.putInt("nowPosition", nowPosition + 1);
			 } else {
				 reminds.addAll(persistWord.selectPersistData("1", Integer.toString(2)));
				 editor.putInt("nowPosition", 1);
			 } 
			 editor.commit();
		 } 
			 
//		 reminds.add(persistWord.selectWordData("5").get(0));
//		 reminds.addAll(persistWord.selectAllData());
		 
		 for (Remind remind : reminds) {
			Log.d("word", remind.getKeyWord());
			Log.d("word", remind.getTitle());
			Log.d("word", remind.getUrl());
		}
		
		for(int i=0; i<reminds.size(); i++){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("tv11",reminds.get(i).getKeyWord());
			map.put("tv12",reminds.get(i).getTitle());
			map.put("tv13",reminds.get(i).getUrl());
			map.put("tv21","1"+i);
			map.put("tv22","1"+i);
			map.put("tv23","1"+i);
			map.put("tv31","1"+i);
			map.put("tv32","1"+i);
			map.put("tv33","1"+i);
			mListItem.add(map);
		}
		
		
		
//		SimpleAdapter listAdapter = new SimpleAdapter(this, listItem, R.layout.createdreamlist, 
//				new String[]{"tv11", "tv12","tv13","tv21","tv22","tv23","tv31","tv32","tv33"},
//				new int[]{R.id.tvleft1, R.id.tvleft2, R.id.tvleft3, R.id.tvmid1, R.id.tvmid2,
//					R.id.tvmid3, R.id.tvright1, R.id.tvright2, R.id.tvright3});
//
//		createDreamLV.setAdapter(listAdapter); 
		MyAdapter myAdapter = new MyAdapter(this, mListItem, R.layout.createdreamlist);
		createDreamLV.setAdapter(myAdapter);
		
		
		createDreamLV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.d("cd", "---"+arg3);
			}
		});
	}
	
//	final class ViewHolder {
//		  public TextView tv11;
//		  public TextView tv12;
//		  public TextView tv13;
//		  public TextView tv21;
//		  public TextView tv22;
//		  public TextView tv23;
//		  public TextView tv31;
//		  public TextView tv32;
//		  public TextView tv33;
//		 }
//	
//	public class MyAdapter extends BaseAdapter {
//		  private LayoutInflater mInflater;
//		  public MyAdapter(Context context) {
//		   this.mInflater = LayoutInflater.from(context);
//		  }
//		  @Override
//		  public int getCount() {
//		   return mListItem.size();
//		  }
//		  @Override
//		  public Object getItem(int arg0) {
//		   return null;
//		  }
//		  @Override
//		  public long getItemId(int arg0) {
//		   return 0;
//		  }
//		  @Override
//		  public View getView(int position, View convertView, ViewGroup parent) {
//		   ViewHolder holder = null;
//		   if (convertView == null) {
//		    holder = new ViewHolder();
//		    convertView = mInflater.inflate(
//		      R.layout.createdreamlist, null);
//		    
//		    holder.tv11 = (TextView) convertView.findViewById(R.id.tvleft1);
//		    holder.tv12 = (TextView) convertView.findViewById(R.id.tvleft2);
//		    holder.tv13 = (TextView) convertView.findViewById(R.id.tvleft3);
//		    
//		    holder.tv21 = (TextView) convertView.findViewById(R.id.tvmid1);
//		    holder.tv22 = (TextView) convertView.findViewById(R.id.tvmid2);
//		    holder.tv23 = (TextView) convertView.findViewById(R.id.tvmid3);
//		    
//		    holder.tv31 = (TextView) convertView.findViewById(R.id.tvright1);
//		    holder.tv32 = (TextView) convertView.findViewById(R.id.tvright2);
//		    holder.tv33 = (TextView) convertView.findViewById(R.id.tvright3);
//		    
//		    convertView.setTag(holder);
//		   } else {
//		    holder = (ViewHolder) convertView.getTag();
//		   }
//		   
//		   
////		   holder.tv11.setText(mListItem.get(position).get("tv11").toString());
////		   holder.tv12.setText(mListItem.get(position).get("tv12").toString());
////		   holder.tv13.setText(mListItem.get(position).get("tv13").toString());
////
////		   holder.tv21.setText(mListItem.get(position).get("tv21").toString());
////		   holder.tv22.setText(mListItem.get(position).get("tv22").toString());
////		   holder.tv23.setText(mListItem.get(position).get("tv23").toString());
////
////		   holder.tv31.setText(mListItem.get(position).get("tv31").toString());
////		   holder.tv32.setText(mListItem.get(position).get("tv32").toString());
////		   holder.tv33.setText(mListItem.get(position).get("tv33").toString());
//		   
//		   holder.tv11.setOnClickListener(new OnClickListener() {
//			
//				@Override
//				public void onClick(View arg0) {
//					Log.d("cd", "cd11");
//				}
//		   });
//		   
//		   holder.tv12.setOnClickListener(new OnClickListener() {
//			   
//			   @Override
//			   public void onClick(View arg0) {
//				   Log.d("cd", "cd12");
//			   }
//		   });
//		   
//		   
//		   
//		   
//
//		   return convertView;
//		  }
//		 }
}
