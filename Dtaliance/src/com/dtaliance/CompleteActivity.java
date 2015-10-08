package com.dtaliance;

import android.app.Activity;
import android.view.Menu;

public class CompleteActivity extends Activity{
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.complete, menu);
		return super.onCreateOptionsMenu(menu);
	}

}
