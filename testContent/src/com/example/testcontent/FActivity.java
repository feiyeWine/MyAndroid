package com.example.testcontent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 实现页面跳转，第一个页面
 * @author YR
 *
 */
public class FActivity extends Activity{
	private Button bt1;
	private Button bt2;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.factivity);
		//使用startActivity的方式实现页面跳转
		bt1 = (Button) findViewById(R.id.button1_first);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(FActivity.this,SActivity.class);
				startActivity(intent);				
			}
		});
		//使用startActivityForResult的方式实现页面跳转
		bt2 = (Button) findViewById(R.id.button2_second);
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(FActivity.this,SActivity.class);
				startActivityForResult(intent, 1);
			}
		});		
	}
	//接收返回数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(1, resultCode, data);
		if(requestCode == 1&& resultCode==2){
			String content = data.getStringExtra("data");
			tv = (TextView) findViewById(R.id.textView1);
			tv.setText(content);
		}
	}
}
