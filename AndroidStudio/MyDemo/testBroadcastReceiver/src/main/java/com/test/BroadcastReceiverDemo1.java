package com.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by YR on 2015/7/2.
 */
public class BroadcastReceiverDemo1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收广播
        Toast.makeText(context,"这是第一个BroadcastReceiver,接收到的Intent的Action为："+intent.getAction()+
        "消息内容为："+intent.getStringExtra("msg"),Toast.LENGTH_SHORT
        ).show();
        Log.i("BroadcastReceiver","这是第一个广播");
    }
}
