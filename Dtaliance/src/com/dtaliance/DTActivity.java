package com.dtaliance;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dtaliance.adapter.DTab;
import com.dtaliance.adapter.ViewPagerAdapter;
import com.dtaliance.fragment.MyFragment;
import com.dtaliance.fragment.NoteFragment;
import com.dtaliance.fragment.PersistFragment;
import com.dtaliance.fragment.ShareFragment;


public class DTActivity extends ActionBarActivity implements TabListener, OnPageChangeListener{
	
	private List<DTab> tabList = new ArrayList<DTab>();
	private ActionBar actionBar;
	private ViewPager viewPager;
	private int indexPager = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dt);
		
		initAction();
	}
	
	public void initAction(){
		
		viewPager = (ViewPager) findViewById(R.id.vp_dt);
		
		tabList.add(new DTab(R.string.persist, PersistFragment.class));
		tabList.add(new DTab(R.string.note, NoteFragment.class));
		tabList.add(new DTab(R.string.sharedream, ShareFragment.class));
		tabList.add(new DTab(R.string.my, MyFragment.class));
		
		actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		for(DTab tab : tabList){
			Tab t = actionBar.newTab();
			t.setText(tab.getTitle());
			t.setTabListener(this);
			
			actionBar.addTab(t);
		}
		
		viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), tabList));
		viewPager.setOnPageChangeListener(this);
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	}
	
	class PagerAdapter extends FragmentPagerAdapter{
		public PagerAdapter(FragmentManager vp) {
			super(vp);
		}

		@Override
		public Fragment getItem(int i) {
			
			try {
				return (Fragment) tabList.get(i).getFragment().newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public int getCount() {
			return tabList.size();
		}
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int i) {
		actionBar.selectTab(actionBar.getTabAt(i));
		indexPager = i;
	}
	
	@Override 
	public boolean onCreateOptionsMenu(Menu menu) {  
	    MenuInflater inflater = getMenuInflater();  
	    inflater.inflate(R.menu.main, menu);  
	return super.onCreateOptionsMenu(menu);  
	}  
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){
		switch(menuItem.getItemId()){
		case R.id.writeNote:
			goWriteNote();
			return true;
		case R.id.set_alert:
			goRemind();
			return true;
		default:
			return false;
		}
	}
	
	public void goWriteNote(){
		Intent intent = new Intent(this, WriteNoteActivity.class);
		startActivity(intent);
	}
	
	public void goRemind(){
		Intent intent = new Intent(this, RemindActivity.class);
		startActivity(intent);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		actionBar.selectTab(actionBar.getTabAt(indexPager));
	}
}
