package com.example.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BcReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String s = intent.getStringExtra("msg");
		System.out.println("BC1接收到的广播为："+s);
		Bundle bundle = getResultExtras(true);
		System.out.println("得到为："+bundle.getString("test"));
		Toast.makeText(context, "BC1接收到的广播为："+s, Toast.LENGTH_SHORT).show();
		Toast.makeText(context,"得到为："+bundle.getString("test"), Toast.LENGTH_SHORT).show();
	}

}
