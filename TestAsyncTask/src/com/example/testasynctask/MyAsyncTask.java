package com.example.testasynctask;

import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Void, Void>{

	@Override
	protected Void doInBackground(Void... params) {
		Log.d("asyncTask", "doInBackground");
		return null;
	}
	
	@Override
	protected void onPreExecute() {
		Log.d("asyncTask", "onPreExecute");
		super.onPreExecute();
	}
	@Override
	protected void onPostExecute(Void result) {
		Log.d("asyncTask", "onPostExecute");
		super.onPostExecute(result);
	}
	@Override
	protected void onProgressUpdate(Void... values) {
		Log.d("asyncTask", "onProgressUpdate");
		super.onProgressUpdate(values);
	}

}
