package com.example.testcontent02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity02 extends Activity{
	private Button bt1;
	private Button bt2;
	private String str = "你好，我是第二个页面";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity02);
		//第二个页面
		bt1 = (Button) findViewById(R.id.button2_first);
		bt2 = (Button) findViewById(R.id.button2_second);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activity02.this,Activity03.class);
				startActivity(intent);
				Intent intent2 = new Intent();
				intent2.putExtra("data", str);
				setResult(2,intent2);
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();				
			}
		});
	}
}
