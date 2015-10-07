package com.dtaliance;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.dtaliance.adapter.MyViewPagerAdapter;

public class ViewPagerActivity extends Activity{

	private PagerAdapter pagerAdapter;
	private ViewPager viewPager;
	private List<View> listItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager);
		
//		View view1 = findViewById(R.layout.activity_word);
//		View view2 = findViewById(R.layout.activity_regist);
		viewPager = (ViewPager) findViewById(R.id.vp_list);
		
		LayoutInflater layoutInflater = getLayoutInflater();
		listItem = new ArrayList<View>();
		listItem.add(layoutInflater.inflate(R.layout.activity_word, null)); 
		listItem.add(layoutInflater.inflate(R.layout.activity_regist, null));
		listItem.add(layoutInflater.inflate(R.layout.activity_share, null));
		
		pagerAdapter = new MyViewPagerAdapter(listItem);
		viewPager.setAdapter(pagerAdapter);
		
	}

}
