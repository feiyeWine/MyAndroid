package com.example.testfragment;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testfragment.MyFragment3.MyListener;


public class Activity3 extends Activity implements MyListener{
	private EditText editText;
	private Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity3);
		editText = (EditText) findViewById(R.id.editText);
		send = (Button) findViewById(R.id.send);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			String text = editText.getText().toString();
			MyFragment3 fragment3 = new MyFragment3();
			Bundle bundle = new Bundle();
			bundle.putString("name", text);
			fragment3.setArguments(bundle);
			FragmentManager fm = getFragmentManager();
			FragmentTransaction bt = fm.beginTransaction();
			bt.add(R.id.activity3, fragment3,"activity3" );
			bt.commit();
			Toast.makeText(Activity3.this, "向Fragment发送数据", Toast.LENGTH_SHORT).show();
			}
		});
		//静态加载
		FragmentManager fm = getFragmentManager();
		Fragment fragmentId = fm.findFragmentById(R.id.frag);
		MyFragment frag = (MyFragment) fragmentId;
		frag.setAaa("frag静态传值");
	}
	@Override
	public void thank(String code) {
		Toast.makeText(Activity3.this, "已成功接收到"+code, Toast.LENGTH_SHORT).show();
	}
}
