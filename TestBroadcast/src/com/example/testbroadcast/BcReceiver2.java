package com.example.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BcReceiver2 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String s = intent.getStringExtra("msg");
		System.out.println("BC2接收到的广播为："+s);
		Bundle bundle = new Bundle();
		bundle.putString("test", "处理后的结果");
		setResultExtras(bundle);
		Toast.makeText(context, "BC2接收到的广播为："+s, Toast.LENGTH_SHORT).show();
	}

}
