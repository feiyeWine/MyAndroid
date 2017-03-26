package com.example.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainThread extends Activity{
	private Button send,stop;
	private Handler threadHandler;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			Message  message = new Message();
			Log.i("Tag",""+Thread.currentThread());
			threadHandler.sendMessageDelayed(message, 1000);
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handlerthread);
		
		send = (Button) findViewById(R.id.send);
		stop = (Button) findViewById(R.id.stop);
		
		HandlerThread thread = new HandlerThread("handlerThread");
		thread.start();
		//创建子线程handler
		threadHandler = new Handler(thread.getLooper())
		{
			@Override
			public void handleMessage(Message msg) {
				Message message = new Message();
				Log.i("Tag",""+Thread.currentThread());
				//向子线程发送消息
				handler.sendMessageDelayed(message, 1000);
			}
		};
	}
	public void onClick(View view){
		switch (view.getId()) {
		case R.id.send:
			handler.sendEmptyMessage(1);
			break;
		case R.id.stop:
			handler.removeMessages(1);
			break;
		default:
			break;
		}
	}
}
