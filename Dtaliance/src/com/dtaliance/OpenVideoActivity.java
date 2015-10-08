package com.dtaliance;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OpenVideoActivity extends Activity{
	
	private WebView webview;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint({ "NewApi", "SetJavaScriptEnabled" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open_video);
		Intent intent = getIntent();
		String url = intent.getStringExtra("openurl");
		Log.d("openurl",url);
		webview = (WebView) findViewById(R.id.webview_video);
		webview.getSettings().setJavaScriptEnabled(true);
//		webview.getSettings().setPluginsEnabled(true);
		webview.getSettings().setUseWideViewPort(true);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.getSettings().setSupportZoom(true);
		webview.loadUrl(url);
		webview.setWebViewClient(new newWebViewClient());
//		ActionBar action = getActionBar();
//		action.hide();
			
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.video, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem menuItem){
		switch(menuItem.getItemId()){
		case R.id.backVideo:
			if(webview.canGoBack()){
				webview.goBack();
			} else {
				goMainActivity(); 
			}
			break;
		case R.id.exitVideo:
			goMainActivity();
			break;
		default:
			break;
		}
		return true;
	}
	
	public class newWebViewClient extends WebViewClient{
		 @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
	            view.loadUrl(url); 
	            return true; 
	        } 
	} 
	
	public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if ((keyCode == KeyEvent.KEYCODE_BACK) ) {
        	if(webview.canGoBack()){
        		WebBackForwardList mWebBackForwardList = webview.copyBackForwardList();
        		
        		if(mWebBackForwardList.getCurrentIndex() > 0){
        			@SuppressWarnings("unused")
					String historyUrl = mWebBackForwardList.getItemAtIndex(mWebBackForwardList.getCurrentIndex()-1).getUrl();
        		}
//        		 webview.goBack(); 
        		goMainActivity();
        		 return true; 
        	} else {
    			goMainActivity();
        	}      	
        } 
        return false;//super.onKeyDown(keyCode, event); 
    }
	
	public void goMainActivity(){
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
		finish();
	}
}