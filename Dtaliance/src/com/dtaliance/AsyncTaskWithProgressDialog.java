package com.dtaliance;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

public abstract class AsyncTaskWithProgressDialog  extends AsyncTask<String, Void, String>{
	public AsyncTaskWithProgressDialog(Context progressDialogContext){
		this.progressDialogContext=progressDialogContext;
	}
	
	abstract protected void onPostExecute2(String result);
	abstract protected String doInBackground2(String... params);		

	@Override
    final protected void onPreExecute() {    		
	    initAndDisplayProgressDialog();
    }
	
	@Override
    final protected String doInBackground(String... params) {
		if(!isCancelled()){
			return doInBackground2(params);
    	}else{
    		return null;
    	}
	}
	
    @Override
    final protected void onPostExecute(String result) {
        hideProgressDialog();
        onPostExecute2(result);
    }
	
    @Override
    final protected void onCancelled() {
        super.onCancelled();
        Log.i("TASK", "user cancel the request of question lib.");
    }

	private void hideProgressDialog() {
		if(myProgressDialog.isShowing()) {
			 myProgressDialog.closeDialog();
		}
	}

	private void initAndDisplayProgressDialog() {
		DialogInterface.OnDismissListener cancelTaskCallback = new DialogInterface.OnDismissListener(){
			@Override
			public void onDismiss(DialogInterface arg0) {
				cancel(true);
			}
		};
		myProgressDialog = new MyProgressDialog(progressDialogContext,cancelTaskCallback);
		myProgressDialog.initDialog();
	}
	
	private Context progressDialogContext;
	
	//maybe the progress dialog should be a singleton.
	private MyProgressDialog myProgressDialog = null;
}