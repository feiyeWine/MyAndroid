package com.example.updateui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView;
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			textView.setText("ok"); //handler2更新UI
		}
	};
	//第一种
	private void handler1(){
			handler.post(new Runnable() {
			@Override
			public void run() {
				textView.setText("ok");
			}
		});
	}
	//第二种
	private void handler2(){
		handler.sendEmptyMessage(1);
	}
	//第三种
	private void updateUI(){
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				textView.setText("ok");
			}
		});
	}
	//第四种
	private void viewUI(){
		textView.post(new Runnable() {
			
			@Override
			public void run() {
				textView.setText("ok");
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = (TextView) findViewById(R.id.textView);
		
		new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					//handler1();
					//handler2();
					//updateUI();
					viewUI();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
