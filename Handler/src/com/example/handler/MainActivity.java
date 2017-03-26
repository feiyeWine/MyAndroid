package com.example.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView;
	private ImageView imageView ;
	private int images[] = {R.drawable.a,R.drawable.b,R.drawable.c};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = (TextView)findViewById(R.id.textView);
		imageView = (ImageView) findViewById(R.id.imageView);
		handler.postDelayed(myRunnable, 1000);
		
		new Thread(){
			public void run() {
				Message msg = new Message();
				msg.what = 0x12;
				Bundle bundle = new Bundle();
				bundle.putString("msg", "hello");
				msg.setData(bundle);
				handler2.sendMessage(msg);
			};
		}.start();
	}
	private int index;
	private Handler handler = new Handler();
	private MyRunnable myRunnable = new MyRunnable();
	class MyRunnable implements Runnable{

		@Override
		public void run() {
			index++;
			index %= 3;
			imageView.setImageResource(images[index]);
			handler.postDelayed(myRunnable, 1000);
		}
	}
	
	Handler handler2 = new Handler(){
		public void handleMessage(android.os.Message msg) {
			textView.setText(""+msg.getData().getString("msg"));
		};
	};
}

