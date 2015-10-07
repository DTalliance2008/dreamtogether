package com.dtaliance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.dtaliance.adapter.MyAdapter;

public class ViewActivity extends Activity implements OnGestureListener{

	private ViewFlipper flipper;
	private GestureDetector gestureDetector;
	private int[] drawableID = {R.drawable.red, R.drawable.progress_image1, R.drawable.progress_image2};
	private ListView lv;
	private List<HashMap<String, Object>> mListItem; 
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		flipper = (ViewFlipper) findViewById(R.id.vf_view);
		gestureDetector = new GestureDetector(this);
		
		mListItem = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tv11","1"+1);
		map.put("tv12","1"+2);
		map.put("tv13","1"+3);
		map.put("tv21","1"+4);
		map.put("tv22","1"+5);
		map.put("tv23","1"+6);
		map.put("tv31","1"+7);
		map.put("tv32","1"+8);
		map.put("tv33","1"+9);
		mListItem.add(map);
		
		for(int i=0; i<drawableID.length; i++){
//			ImageView imageView = new ImageView(this);
//			imageView.setImageResource(drawableID[i]);
//			imageView.setScaleType(ImageView.ScaleType.FIT_XY);  
//			flipper.addView(imageView, new LayoutParams(
//					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			ListView lv = new ListView(this);
			MyAdapter myAdapter = new MyAdapter(this, mListItem, R.layout.createdreamlist);
			lv.setAdapter(myAdapter);
			flipper.addView(lv, new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		}
	}
	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		if (arg0.getX() - arg1.getX() > 120)  
        {  
            // 添加动画  
            this.flipper.setInAnimation(AnimationUtils.loadAnimation(this,  
                    R.anim.push_left_in));  
            this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this,  
                    R.anim.push_left_out));  
            this.flipper.showNext();  
            return true;  
        }// 从右向左滑动  
        else if (arg0.getX() - arg1.getX() < -120)  
        {  
            this.flipper.setInAnimation(AnimationUtils.loadAnimation(this,  
                    anim.fade_in));  
            this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this,  
                    anim.fade_out));  
            this.flipper.showPrevious();  
            return true;  
        }  
        return true;  
	}
	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return this.gestureDetector.onTouchEvent(event);
	}


}
