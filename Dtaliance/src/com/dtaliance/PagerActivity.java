package com.dtaliance;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

import com.dtaliance.adapter.MyViewPagerAdapter;

@SuppressWarnings("deprecation")
public class PagerActivity extends Activity{

	private ViewPager pager;
	private LocalActivityManager lam;
	private List<View> viewList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pager);
		pager = (ViewPager) findViewById(R.id.vp_pager);
		
//		TextView t1 = (TextView) findViewById(R.id.tv_pager_create);
//		TextView t2 = (TextView) findViewById(R.id.tv_pager_note);
		
		lam = new LocalActivityManager(this, true);
		lam.dispatchCreate(savedInstanceState);
		
		viewList = new ArrayList<View>();
		Intent intent1 = new Intent(this, CreateDreamActivity.class);
		viewList.add(lam.startActivity(Integer.toString(R.layout.activity_create_dream), intent1).getDecorView());
		
		Intent intent2 = new Intent(this, NoteActivity.class);
		viewList.add(lam.startActivity(Integer.toString(R.layout.activity_notelist), intent2).getDecorView());
		
		Intent intent3 = new Intent(this, ShareActivity.class);
		viewList.add(lam.startActivity(Integer.toString(R.layout.activity_share), intent3).getDecorView());
		
		MyViewPagerAdapter myAdapter = new MyViewPagerAdapter(viewList);
		pager.setAdapter(myAdapter);
		pager.setCurrentItem(0);
		
//		TitlePageIndicator titleIndicator = (TitlePageIndicator) findViewById(R.id.tpi_titles);
//		titleIndicator.setViewPager(pager);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.note, menu);
		return true;
	}
	
	public void goWriteNote(){
		Intent intent = new Intent(this, WriteNoteActivity.class);
		startActivity(intent);
		finish();
	}
	
}
