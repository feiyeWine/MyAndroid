package com.example.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BcReceiver3 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String s = intent.getStringExtra("msg");
		System.out.println("BC3接收到的广播为："+s);
		Toast.makeText(context, "BC3接收到的广播为："+s, Toast.LENGTH_SHORT).show();
	}

}