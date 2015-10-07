package com.dtaliance;

import android.app.Activity;
import android.view.Menu;

public class BaseActivity extends Activity{
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.writenote, menu);
		return true;
	}
	
}
