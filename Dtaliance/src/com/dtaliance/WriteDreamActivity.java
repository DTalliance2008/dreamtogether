package com.dtaliance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.dtaliance.sevice.DreamService;

public class WriteDreamActivity extends Activity{

	private EditText contentET;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_writedream);
		contentET = (EditText) findViewById(R.id.et_writedream_content);
		Button upload = (Button) findViewById(R.id.bt_writedream_upload);
				
		upload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				uploadDream(contentET.getText().toString().trim());
			}
		});
	}
	
	public void uploadDream(String upload){
//		NetworkService networkService = new NetworkService(getApplication());
//		if(networkService.isConnected() || networkService.isWifiConnected()){
			new WriteDreamBackgroud(WriteDreamActivity.this).execute(upload);
//		} else {
//			Toast.makeText(this, "«Î¡¨Ω”", Toast.LENGTH_LONG).show();
//		}
	}
	
	
	private class WriteDreamBackgroud extends AsyncTaskWithProgressDialog{

		
		public WriteDreamBackgroud(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@Override
		protected String doInBackground2(String... params) {
			DreamService service = new DreamService(getApplication());
			return service.getShareDream("word1", params[0]);
		}
		
		@Override
		protected void onPostExecute2(String result) {
			if("success".equals(result)){
				Log.d("word", "nihao");
				goPager();
			}
		}
	}
	
	public void goPager(){
		Intent intent = new Intent(this, PagerActivity.class);
		startActivity(intent);
		finish();
	}
}
