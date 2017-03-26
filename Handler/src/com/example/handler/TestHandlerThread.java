package com.example.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class TestHandlerThread extends Activity{
	private TextView textView;
	HandlerThread thread;
	Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		textView = new TextView(this);
		textView.setText("handler thread");
		setContentView(textView);
		
		thread = new HandlerThread("Handler Thread");
		thread.start();
		handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				Log.i("Tag","----->"+thread.currentThread());
			}
		};
		handler.sendEmptyMessage(1);
	}
}
