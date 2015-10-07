package com.dtaliance.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyViewPagerAdapter extends PagerAdapter{

	private List<View> mListViews;  
	private	String[] titles = {"title1", "title2", "title3"};
    
    public MyViewPagerAdapter(List<View> mListViews) {  
        this.mListViews = mListViews;//���췽�������������ǵ�ҳ���������ȽϷ��㡣  
    }  

    @Override  
    public void destroyItem(ViewGroup container, int position, Object object)   {     
        container.removeView(mListViews.get(position));//ɾ��ҳ��  
    }  


    @Override  
    public Object instantiateItem(ViewGroup container, int position) {  //�����������ʵ����ҳ��         
         container.addView(mListViews.get(position), 0);//���ҳ��  
         
//         mListViews.get(position).findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				Log.d("word","word");
//			}
//		}); 
         return mListViews.get(position);  
    }  

    @Override  
    public int getCount() {           
        return  mListViews.size();//����ҳ��������  
    }  
      
    @Override  
    public boolean isViewFromObject(View arg0, Object arg1) {             
        return arg0==arg1;//�ٷ���ʾ����д  
    }  
    
    public String getTitle(int position) {
        return titles[position % mListViews.size()].toUpperCase();
    }
}
