package com.example.testtoast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button;
	private Button button2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button);
		button2 = (Button) findViewById(R.id.button2);
		getToast1();
		getToast2();
	}
	private void getToast1(){
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(MainActivity.this, "测试默认Toast", Toast.LENGTH_SHORT).show();
			}
		});
	}
	private void  getToast2(){
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
				View toast_view = inflater.inflate(R.layout.toast_layout, null);
				Toast toast = new Toast(MainActivity.this);
				toast.setView(toast_view);
				//改变Toast的位置
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
		});
	}
}
