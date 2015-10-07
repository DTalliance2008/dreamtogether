package com.dtaliance.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dtaliance.OpenVideoActivity;
import com.dtaliance.OutputNoteActivity;
import com.dtaliance.R;
import com.dtaliance.util.ConstantUtil;

public class MyAdapter extends BaseAdapter{
	private LayoutInflater mInflater;
	private List<HashMap<String, Object>> selectItem;
	private int id;
	private ViewHolder viewHolder = null;
	private Context context;

	public MyAdapter(Context context, List<HashMap<String, Object>> item, int Id){
		mInflater = LayoutInflater.from(context);
		selectItem = item;
		id = Id;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return selectItem.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup viewGroup) {
//		ViewHolder viewHolder = null;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(id, null);
			viewHolder.tv11 = (TextView) convertView.findViewById(R.id.tvleft1);
			viewHolder.tv12 = (TextView) convertView.findViewById(R.id.tvleft2);
			viewHolder.tv13 = (TextView) convertView.findViewById(R.id.tvleft3);
			    
			viewHolder.tv21 = (TextView) convertView.findViewById(R.id.tvmid1);
			viewHolder.tv22 = (TextView) convertView.findViewById(R.id.tvmid2);
			viewHolder.tv23 = (TextView) convertView.findViewById(R.id.tvmid3);
			    
			viewHolder.tv31 = (TextView) convertView.findViewById(R.id.tvright1);
			viewHolder.tv32 = (TextView) convertView.findViewById(R.id.tvright2);
			viewHolder.tv33 = (TextView) convertView.findViewById(R.id.tvright3);
			
			viewHolder.tv11.setText(selectItem.get(position).get("tv11").toString());
			viewHolder.tv12.setText(selectItem.get(position).get("tv12").toString());
			viewHolder.tv13.setText(selectItem.get(position).get("tv13").toString());
			
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.tv11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("cd", "cd11");
			}
		});
		
		viewHolder.tv12.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("cd", "cd12");
			}
		});
		
		viewHolder.tv13.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Log.d("cd", "cd13");
				goWebView(view, viewHolder.tv13.getText().toString());
			}
		});
		
		viewHolder.tv21.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("cd", "cd21");
				goSpeech(v, ConstantUtil.FILE_SPEECH+"fileName2.txt");
			}
		});
		
		viewHolder.tv22.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("cd", "cd22");
			}
		});
		
		viewHolder.tv23.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("cd", "cd23");
			}
		});
		
		viewHolder.tv31.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("cd", "cd31");
			}
		});
		
		viewHolder.tv32.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("cd", "cd32");
			}
		});
		
		viewHolder.tv33.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("cd", "cd33");
			}
		});
		
		return convertView;
	}

	final class ViewHolder {
		public TextView tv11;
		public TextView tv12;
	    public TextView tv13;
	    public TextView tv21;
	    public TextView tv22;
	    public TextView tv23;
	    public TextView tv31;
	    public TextView tv32;
	    public TextView tv33;
	}
	
	public void goWebView(View view, String url){
		Intent intent = new Intent();
		intent.setClass(view.getContext(), OpenVideoActivity.class);
		intent.putExtra("openurl", url);
		view.getContext().startActivity(intent);
		
	}
	
	public void goSpeech(View view, String url){
		Intent intent = new Intent();
		intent.setClass(view.getContext(), OutputNoteActivity.class);
		intent.putExtra("filename", url);
		view.getContext().startActivity(intent);
		
	}
	
	
}
