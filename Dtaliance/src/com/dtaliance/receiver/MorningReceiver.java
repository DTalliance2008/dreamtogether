package com.dtaliance.receiver;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.dtaliance.R;
import com.dtaliance.ViewPagerActivity;
import com.dtaliance.db.PersistWord;
import com.dtaliance.util.ConstantUtil;

/**
 * time:2014/11/10-17:00
 * Broadcaset notification Morning 
 *by zhf
 */
public class MorningReceiver extends BroadcastReceiver {
	
	private PersistWord dataManager;
	private Context context;
	private final String morning =  "早上好";
	private final static int NOTIFICATION_ID = 1001; 
	@Override
    public void onReceive(Context context, Intent intent) {
		this.context = context;
		showNotification();
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void showNotification(){
		Notification noCation = new Notification(R.drawable.ic_launcher,
				ConstantUtil.APP_NAME, System.currentTimeMillis());
		String phrase = "一起萌";
		SharedPreferences sp = context.getSharedPreferences("dream", context.MODE_PRIVATE);
		dataManager = new PersistWord(context);
		int count = sp.getInt("count", 0);
		if(count != 0){
			phrase = dataManager.selectPersistData(Integer.toString(count), Integer.toString(count)).get(0).getKeyWord();
		}
		
		Intent yiqimengIntent = new Intent(context, ViewPagerActivity.class);
		PendingIntent penIntent = PendingIntent.getActivity(context, 0,
				yiqimengIntent, 0);
		noCation.setLatestEventInfo(context, morning, phrase, penIntent);
		NotificationManager noCationManager = (NotificationManager) context.getSystemService(
					android.content.Context.NOTIFICATION_SERVICE);
		noCationManager.notify(NOTIFICATION_ID, noCation);
	}
}
