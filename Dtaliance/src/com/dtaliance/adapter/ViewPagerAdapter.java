package com.dtaliance.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter{

	private List<DTab> tabList;
	
	public ViewPagerAdapter(FragmentManager vp, List<DTab> tabList) {
		super(vp);
		this.tabList = tabList;
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
