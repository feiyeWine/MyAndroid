package com.example.testcontent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 第二个页面
 * @author YR
 *
 */
public class SActivity extends Activity{
	private Button bt ;
	private String data="你好，我是第二个页面";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sactivity);
		bt = (Button) findViewById(R.id.button1_third);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra("data", data);
				setResult(2, intent);
				//结束当前页面
				finish();
			}
		});
	}
}
