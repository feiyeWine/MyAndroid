package com.example.testbroadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	BcReceiver3 bc3 = new BcReceiver3();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//动态注册
		IntentFilter filter= new IntentFilter("BC_ONE");
		BcReceiver2 bc2 = new BcReceiver2();
		registerReceiver(bc2, filter);
		
	}
	public void doClick(View v){
		switch (v.getId()) {
		case R.id.send1:
			//这是一条普通广播
			Intent intent = new Intent();
			intent.putExtra("msg", "这是一条普通广播");
			intent.setAction("BC_ONE");
			sendBroadcast(intent);
			break;
		case R.id.send2:
			//这是一条有序广播
			Intent intent2 = new Intent();
			intent2.putExtra("msg", "这是一条有序广播");
			intent2.setAction("BC_ONE");
			sendOrderedBroadcast(intent2,null);
			break;
		case R.id.send3:
			//这是一条异步广播
			Intent intent3 = new Intent();
			intent3.putExtra("msg", "这是一条异步广播");
			intent3.setAction("BC_Three");
			sendStickyBroadcast(intent3);
			//动态注册,  先发送，后注册
			IntentFilter filter3= new IntentFilter("BC_Three");
			
			registerReceiver(bc3, filter3);
			break;
		default:
			break;
		}
	}
	@Override
	protected void onDestroy() {
		unregisterReceiver(bc3);
	}
}
