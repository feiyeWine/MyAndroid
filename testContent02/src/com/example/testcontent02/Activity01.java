package com.example.testcontent02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 测试页面跳转，第一个页面
 * @author YR
 *
 */
public class Activity01 extends Activity{
	private Button bt;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		
		//第一个页面
		bt = (Button)findViewById(R.id.button1_first);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activity01.this,Activity02.class);
				startActivityForResult(intent, 1);
			}
		});		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 1 && resultCode == 2){
			String str = data.getStringExtra("data");
			tv = (TextView) findViewById(R.id.textView1);
			tv.setText(str);
			
		}
	}
	
}
